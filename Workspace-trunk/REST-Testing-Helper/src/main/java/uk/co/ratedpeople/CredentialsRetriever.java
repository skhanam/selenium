package uk.co.ratedpeople;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.w3c.dom.Document;

public class CredentialsRetriever {
	
	private HttpResponseUtils httpResponseUtils = new HttpResponseUtils();
	private HttpRequestCreator requestCreator = new HttpRequestCreator();
	private HttpRequestExecutor requestExecutor = new HttpRequestExecutor();
	private TestContext testContext; 
	private XmlUtils xmlUtls = new XmlUtils();
	
	public CredentialsRetriever() {
		try {
			testContext = TestContext.getDefault();
		} catch (IOException io) {
			throw new IllegalStateException(io);
		}
	}
	
	public String retrieveHashedPassword(HttpResponse jobSubmissionResponse) throws Exception  {
		Header tokenHeader = jobSubmissionResponse.getFirstHeader("token");
		String encryptionKey = testContext.getAccessKey().substring(0, 16);
		
		Document tokenDoc = null;
		
		if (tokenHeader == null) {
			throw new IllegalStateException("Cannot retrieve hashed password as no token headerr is present");
		} else {
			String token = tokenHeader.getValue();
			
			if (token == null) {
				throw new IllegalStateException("Cannot retrieve hashed password as no token is present");
			} else {
				String tokenUri = "/api/v2/homeowner/credentials/" + token;
				System.out.println("HEADER=" + tokenHeader);

				HttpUriRequest request = requestCreator.createGetRequestForUri(tokenUri, testContext.getAccessKey(), testContext.getAccessKeyId());

				HttpResponse tokenResponse = requestExecutor.execute(request);
				tokenDoc = this.httpResponseUtils.documentFromResponseBody(tokenResponse);
				return AESEncryption.decrypt(xmlUtls.asString(tokenDoc, "userCredentials/encryptedHashedPassword"), encryptionKey);
			} 			
		}
	}
}
