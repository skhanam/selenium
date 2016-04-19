package uk.co.ratedpeople;

import static uk.co.ratedpeople.APIAccessConstants.AUTHENTICATION_HEADER_NAME;
import static uk.co.ratedpeople.APIAccessConstants.AUTHORIZATION_HEADER_NAME;
import static uk.co.ratedpeople.APIAccessConstants.RP_DATE_HEADER_NAME;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

public class JobImageSubmitter {
	
	private static final Logger LOGGER = Logger.getLogger(JobImageSubmitter.class.getName());

	private static final String CONTENT_TYPE = "Content-Type";
	private static final String FORM_PART_XML = "xml";
	private static final String FORM_PART_IMAGE = "image";

	private HttpRequestCreator requestCreator;
	private HttpRequestExecutor executor;
	private HeaderHelper headerHelper;
	
	public JobImageSubmitter() {
		requestCreator = new HttpRequestCreator();
		executor = new HttpRequestExecutor();
		headerHelper = new HeaderHelper();
	}
	
	public HttpResponse postJobImage(String uri, String xmlData, String imagePath, String username, String password) throws Exception {
		
		HttpPost request = requestCreator.createMultipartPostRequestForUri(uri);

		MultipartEntity multipartEntity = createMultipartEntity(xmlData, imagePath);

		applyHeaders(uri, request, multipartEntity);
		applyAuthenticationHeader(username, password, request);
		
		request.setEntity(multipartEntity);
		
		HttpResponse resp = executor.execute(request);
		
		int statusCode = resp.getStatusLine().getStatusCode();
		LOGGER.log(Level.INFO, "Job image posted (with image path as param). Response Status Code = {0}", statusCode);
		
		return resp;
	}
	
	public HttpResponse postJobImageWithIncorrectMultipartPartNames(String uri, String xmlData, String imagePath, String username, String password) throws Exception {
		
		HttpPost request = requestCreator.createMultipartPostRequestForUri(uri);

		MultipartEntity multipartEntity = createMultipartEntityWithIncorrectMultipartNames(xmlData, imagePath);

		applyHeaders(uri, request, multipartEntity);
		applyAuthenticationHeader(username, password, request);
		request.setEntity(multipartEntity);
		HttpResponse resp = executor.execute(request);
		return resp;
	}
	
	public HttpResponse postJobImage(String uri, MultipartEntity multipartEntity , String username, String password) throws Exception {
		
		HttpPost request = requestCreator.createMultipartPostRequestForUri(uri);
		
		applyHeaders(uri, request, multipartEntity);
		applyAuthenticationHeader(username, password, request);
		
		request.setEntity(multipartEntity);
		
		HttpResponse resp = executor.execute(request);
		
		int statusCode = resp.getStatusLine().getStatusCode();
		LOGGER.log(Level.INFO, "Job image posted (with multipart entity as param). Response Status Code = {0}", statusCode);
		

		return resp;
	}

	private MultipartEntity createMultipartEntityWithIncorrectMultipartNames(String xmlData, String imagePath) throws IOException {
		MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);

		FormBodyPart xmlPart = new FormBodyPart("XML", StringBody.create(xmlData, HeaderHelper.APPLICATION_XML_CONTENT_TYPE,
				Charset.forName("UTF-8")));
		multipartEntity.addPart(xmlPart);

		FileBody fileBody = new FileBody(new File(imagePath));
		FormBodyPart imagePart = new FormBodyPart("IMAGE", fileBody);
		multipartEntity.addPart(imagePart);

		return multipartEntity;
	}

	public MultipartEntity createMultipartEntity(String xmlData, String imagePath) throws IOException {
		MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);

		FormBodyPart xmlPart = new FormBodyPart(FORM_PART_XML, StringBody.create(xmlData, HeaderHelper.APPLICATION_XML_CONTENT_TYPE,
				Charset.forName("UTF-8")));
		multipartEntity.addPart(xmlPart);

		FileBody fileBody = new FileBody(new File(imagePath));
		FormBodyPart imagePart = new FormBodyPart(FORM_PART_IMAGE, fileBody);
		multipartEntity.addPart(imagePart);

		return multipartEntity;
	}
	
	public HttpResponse getImage(String imageUrl) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException,
			NoSuchAlgorithmException, ParseException, ClientProtocolException, IOException {
		HttpGet getImageRequest = new HttpGet(imageUrl);
		final DefaultHttpClient httpClient = new DefaultHttpClient();
		return httpClient.execute(getImageRequest);		
	}

	private void applyAuthenticationHeader(String username, String password, HttpPost request) throws InvalidKeyException, SignatureException {
		AuthenticationHeaderGenerator authnGenerator = new AuthenticationHeaderGenerator();
		String authnHeader = authnGenerator.getAuthenticationHeaderWithPlainPassword(username, password, headerHelper.provideAccessKeyId(), headerHelper.provideAccessKey());
		request.setHeader(AUTHENTICATION_HEADER_NAME, authnHeader);
	}

	private void applyHeaders(final String uri, HttpPost request, MultipartEntity multipartEntity) throws SignatureException, UnsupportedEncodingException,
			NoSuchAlgorithmException, InvalidKeyException {

		AuthorizationHeaderGenerator generator = new AuthorizationHeaderGenerator();
		Date date = new Date();
		String contentType = multipartEntity.getContentType().getValue();
		String authzHeader = generator.generate("POST", contentType, uri, headerHelper.provideAccessKeyId(), headerHelper.provideAccessKey(), date);
		request.setHeader(CONTENT_TYPE, contentType);
		request.setHeader(AUTHORIZATION_HEADER_NAME, authzHeader);
		request.setHeader(RP_DATE_HEADER_NAME, date.toString());
	}

	public HttpResponse postJobImageWithHashedPassword(String uri, String xmlData, String imagePath, String username, String hashedPassword)
			throws Exception {

		HttpPost request = requestCreator.createMultipartPostRequestForUri(uri);

		MultipartEntity multipartEntity = createMultipartEntity(xmlData, imagePath);

		applyHeaders(uri, request, multipartEntity);
		applyAuthenticationHeaderUsingHashPassword(username, hashedPassword, request);

		request.setEntity(multipartEntity);

		HttpResponse resp = executor.execute(request);

		int statusCode = resp.getStatusLine().getStatusCode();
		LOGGER.log(Level.INFO, "Job image posted (with image path as param). Response Status Code = {0}", statusCode);

		return resp;
	}

	private void applyAuthenticationHeaderUsingHashPassword(String username, String hashedPassword, HttpPost request)
			throws InvalidKeyException, SignatureException {
		AuthenticationHeaderGenerator authnGenerator = new AuthenticationHeaderGenerator();
		String authnHeader = authnGenerator.getAuthenticationHeader(username, hashedPassword, headerHelper.provideAccessKeyId(), headerHelper.provideAccessKey());
		request.setHeader(APIAccessConstants.AUTHENTICATION_HEADER_NAME, authnHeader);
	}
}
