package uk.co.ratedpeople;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * Common functionality for working with {@link Document} objects.
 */
public class XmlDocumentUtils {
	private final XmlUtils xmlUtils = new XmlUtils();

	public void assertErrorPresent(final Document doc, final String errorCodeName) {
		try {
			final List<String> actualErrorCodes = new ArrayList<String>();
			final NodeList errorNodes = this.xmlUtils.asNodeList(doc, "//error");
			final int numberOfErrors = errorNodes.getLength();
			for (int indexOfError = 1; indexOfError < (numberOfErrors + 1); indexOfError++) {
				final String errorCode = this.xmlUtils.asString(doc, "errors/error[" + indexOfError + "]/code");
				actualErrorCodes.add(errorCode);
				if (errorCodeName.equals(errorCode)) {
					return; // All good - we found the matching error
				}
			}
		} catch (final Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	public String formatDocument(final Document document) {
		try {
			final OutputFormat format = new OutputFormat(document);
			format.setLineWidth(65);
			format.setIndenting(true);
			format.setIndent(2);
			final Writer out = new StringWriter();
			final XMLSerializer serializer = new XMLSerializer(out, format);
			serializer.serialize(document);

			return out.toString();
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String getStringValueInDocumentOfXPath(final Document document, final String xpath) {
		try {
			return this.xmlUtils.asString(document, xpath);
		} catch (final XPathExpressionException xpathException) {
			throw new RuntimeException(xpathException);
		}
	}
}
