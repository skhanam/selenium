package uk.co.ratedpeople;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * Utilities to support XPath operations.
 * 
 * Only as threadsafe as DocumentBuilderFactory and XPathFactory (research
 * needed if you care).
 */
public class XmlUtils {
	public static final class Constants {
		public static final String XML_UTF8_PROLOG = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
	}
	private DocumentBuilderFactory documentBuilderFactory;
	private XPathFactory xPathFactory;

	public XmlUtils() {
		documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setValidating(false);
		documentBuilderFactory.setNamespaceAware(false);
		documentBuilderFactory.setAttribute("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

		xPathFactory = XPathFactory.newInstance();
	}
	
	public String withoutXmlProlog(String xml) {
		if (!xml.startsWith(Constants.XML_UTF8_PROLOG)) {
			return xml;
		}
		
		return xml.substring(Constants.XML_UTF8_PROLOG.length());
	}

	public String asString(Document document, String expression) throws XPathExpressionException {
		XPathExpression xPathExpression = xPathFactory.newXPath().compile(expression);
		return (String) xPathExpression.evaluate(document, XPathConstants.STRING);
	}

	public NodeList asNodeList(Document document, String expression) throws XPathExpressionException {
		XPathExpression xPathExpression = xPathFactory.newXPath().compile(expression);
		return (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);
	}

	public Double asNumber(Document document, String expression) throws XPathExpressionException {
		XPathExpression xPathExpression = xPathFactory.newXPath().compile(expression);
		return (Double) xPathExpression.evaluate(document, XPathConstants.NUMBER);
	}

	public Document getDocument(String string) throws Exception {
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		return documentBuilder.parse(new InputSource(new StringReader(string)));
	}

	public DocumentBuilderFactory getDocumentBuilderFactory() {
		return documentBuilderFactory;
	}

	public XPathFactory getXPathFactory() {
		return xPathFactory;
	}

	public String getXml(Document document) throws Exception {
		// Use a Transformer for output
		TransformerFactory tFactory = TransformerFactory.newInstance();
		javax.xml.transform.Transformer transformer = tFactory.newTransformer();

		DOMSource source = new DOMSource(document);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		transformer.transform(source, result);
		writer.close();
		
		return  writer.getBuffer().toString();
	}
}
