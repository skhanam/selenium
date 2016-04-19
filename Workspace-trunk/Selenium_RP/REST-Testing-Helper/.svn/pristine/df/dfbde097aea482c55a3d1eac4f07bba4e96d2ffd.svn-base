package uk.co.ratedpeople;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TradesmanCertificatesResourceHelper {

	private final HttpRequestCreator requestCreator = new HttpRequestCreator();
	private final HttpRequestExecutor requestExecutor = new HttpRequestExecutor();

	private final UserRetriever userRetriever = new UserRetriever();

	private static final String GAS_SAFE_CERTIFICATE_XML_ELEMENT_NAME = "gassafecertificate";
	private static final String PARTP_CERTIFICATE_XML_ELEMENT_NAME = "partpcertificate";

	private final HttpResponseUtils httpResponseUtils = new HttpResponseUtils();
	private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private final XmlUtils xmlUtils = new XmlUtils();

	public HttpResponse getAllCertifications(final String username, final String password) throws Exception {

		int tradesmanUserId = userRetriever.getUserId(username, password);

		String uri = "/api/v1/tradesmen/" + tradesmanUserId + "/certificates";

		HttpUriRequest request = requestCreator.createGetRequestForUri(uri);
		requestCreator.assignDefaultAuthenticationHeader(request, username, password);

		HttpResponse response = requestExecutor.execute(request);

		return response;
	}

	public List<Integer> getListOfGasCertificationIds(final String username, final String password) throws Exception {

		HttpResponse response = getAllCertifications(username, password);
		Document document = this.httpResponseUtils.documentFromResponseBody(response);
		return getListOfCertificationIds(document, GAS_SAFE_CERTIFICATE_XML_ELEMENT_NAME);
	}

	public List<Integer> getListOfPartPCertificateIds(final String username, final String password) throws Exception {

		HttpResponse response = getAllCertifications(username, password);
		Document document = this.httpResponseUtils.documentFromResponseBody(response);
		return getListOfCertificationIds(document, PARTP_CERTIFICATE_XML_ELEMENT_NAME);
	}

	public HttpResponse deleteCertification(final Integer certificateId, final String username, final String password) throws Exception {

		int tradesmanUserId = userRetriever.getUserId(username, password);

		String uri = "/api/v1/tradesmen/" + tradesmanUserId + "/certificates/" + certificateId;

		HttpDelete request = requestCreator.createDeleteRequestForUri(uri);
		requestCreator.assignDefaultAuthenticationHeader(request, username, password);

		HttpResponse response = requestExecutor.execute(request);

		return response;
	}

	public HttpResponse addGasSafeCertification(final String username, final String password, final String certificateDetailsXml) throws Exception {
		String uri = "/api/v1/tradesmen/%1d/certificates/gassafe";
		return addGasSafeCertification(username, password, certificateDetailsXml, uri);
	}

	public HttpResponse addGasSafeCertificationV2(final String username, final String password, final String certificateDetailsXml) throws Exception {
		String uri = "/api/v2/tradesmen/%1d/certificates/gassafe";
		return addGasSafeCertification(username, password, certificateDetailsXml, uri);
	}

	private HttpResponse addGasSafeCertification(final String username, final String password, final String certificateDetailsXml, final String uri) throws Exception {
		int tradesmanUserId = userRetriever.getUserId(username, password);
		String formatterUri = String.format(uri, tradesmanUserId);
		return addCertification(formatterUri, tradesmanUserId, username, password, certificateDetailsXml);
	}
	
	public HttpResponse addPartPCertification(final String username, final String password, final String certificateDetailsXml) throws Exception {

		int tradesmanUserId = userRetriever.getUserId(username, password);

		String uri = "/api/v1/tradesmen/" + tradesmanUserId + "/certificates/partp";
		return addCertification(uri, tradesmanUserId, username, password, certificateDetailsXml);
	}

	private HttpResponse addCertification(final String uri, final Integer tradesmanUserId, final String username, final String password,
			final String certificateDetailsXml) throws Exception {

		HttpPost request = requestCreator.createPostRequestForUri(uri);
		requestCreator.assignDefaultAuthenticationHeader(request, username, password);
		HttpEntity entity = new StringEntity(certificateDetailsXml);
		request.setEntity(entity);

		HttpResponse response = requestExecutor.execute(request);

		return response;
	}

	private List<Integer> getListOfCertificationIds(final Document document, final String certificationType) throws Exception {

		List<Integer> certificateIds = new ArrayList<Integer>();
		System.out.println(xmlUtils.getXml(document));
		NodeList nodeList = document.getElementsByTagName(certificationType);
		int numberNodes = nodeList.getLength();
		for (int i = 0; i < numberNodes; i++) {
			Node currentNode = nodeList.item(i);
			NodeList children = currentNode.getChildNodes();
			int numberChildren = children.getLength();
			for (int j = 0; j < numberChildren; j++) {
				Node currentChild = children.item(j);
				if ("id".equals(currentChild.getNodeName())) {
					Integer certificateId = Integer.parseInt(currentChild.getTextContent());
					certificateIds.add(certificateId);
					break;
				}
			}
			System.out.println(currentNode.getTextContent());
		}
		return certificateIds;
	}

	public Integer getIdOfGasSafeCertificationNumber(final String certificationNumber, final String username, final String password) throws Exception {
		return this.getIdOfCertificationNumber(certificationNumber, username, password, GAS_SAFE_CERTIFICATE_XML_ELEMENT_NAME);
	}

	public Integer getIdOfPartPCertificationNumber(final String certificationNumber, final String username, final String password) throws Exception {
		return this.getIdOfCertificationNumber(certificationNumber, username, password, PARTP_CERTIFICATE_XML_ELEMENT_NAME);
	}

	private Integer getIdOfCertificationNumber(final String certificationNumber, final String username, final String password, final String certificationType)
			throws Exception {
		Integer idFound = -1;
		HttpResponse response = this.getAllCertifications(username, password);
		Document document = this.httpResponseUtils.documentFromResponseBody(response);
		NodeList nodeList = document.getElementsByTagName(certificationType);
		int numberNodes = nodeList.getLength();
		outer: for (int i = 0; i < numberNodes; i++) {
			Node currentNode = nodeList.item(i);
			NodeList children = currentNode.getChildNodes();
			int numberChildren = children.getLength();
			boolean registrationNumberFound = false;
			idFound = -1;
			for (int j = 0; j < numberChildren; j++) {
				Node currentChild = children.item(j);
				if ("id".equals(currentChild.getNodeName())) {
					idFound = Integer.parseInt(currentChild.getTextContent());
					if (registrationNumberFound) {
						break outer;
					}
				}
				if ("registrationnumber".equals(currentChild.getNodeName())) {
					if (currentChild.getTextContent().equals(certificationNumber)) {
						if (idFound != -1) {
							break outer;
						}
						registrationNumberFound = true;
					}
				}
			}
			System.out.println(currentNode.getTextContent());
		}
		return idFound;
	}

	public String createGasCertificationDetailsXml(final String name, final String registrationNumber, final Date expirydate, final String username,
			final String password) throws Exception {

		StringBuilder sb = new StringBuilder();
		sb.append("<gassafecertificate>");
		sb.append("<name>").append(name).append("</name>");
		sb.append("<registrationnumber>").append(registrationNumber).append("</registrationnumber>");

		String formattedDate = df.format(expirydate);
		sb.append("<expirydate>").append(formattedDate).append("</expirydate>");

		int tradesmanUserId = userRetriever.getUserId(username, password);

		sb.append("<id>").append(tradesmanUserId).append("</id>");
		sb.append("</gassafecertificate>");
		return sb.toString();
	}

	public String createPartPCertificationDetailsXml(final String name, final String registrationNumber, final Date expirydate, final String certbodycode,
			final String username, final String password) throws Exception {

		StringBuilder sb = new StringBuilder();
		sb.append("<partpcertificate>");
		sb.append("<name>").append(name).append("</name>");
		sb.append("<registrationnumber>").append(registrationNumber).append("</registrationnumber>");

		String formattedDate = df.format(expirydate);
		sb.append("<expirydate>").append(formattedDate).append("</expirydate>");

		int tradesmanUserId = userRetriever.getUserId(username, password);

		sb.append("<certbodycode>").append(certbodycode).append("</certbodycode>");
		sb.append("<id>").append(tradesmanUserId).append("</id>");
		sb.append("</partpcertificate>");
		return sb.toString();
	}
}
