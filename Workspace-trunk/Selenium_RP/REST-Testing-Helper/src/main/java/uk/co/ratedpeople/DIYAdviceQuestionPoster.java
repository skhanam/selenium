package uk.co.ratedpeople;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.ParseException;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

public class DIYAdviceQuestionPoster {
	
	private HttpRequestCreator httpRequestCreator = new HttpRequestCreator();
	private HttpRequestExecutor httpRequestExecutor = new HttpRequestExecutor();
	
	/**
	 * 
	 * @param email
	 * @return URI of question
	 * 
	 */
	public String postDefaultQuestion() throws ClientProtocolException, IOException, InvalidKeyException, SignatureException, NoSuchAlgorithmException, ParseException {
		HttpPost post = httpRequestCreator.createPostRequestForUri("/api/v1/diy/questions");
		String diyEmail = new UniqueEmailAddressGenerator().generateUniqueEmailAddress("diy");
		post.setEntity(new StringEntity("<diyQuestion>"
				+ "<title>Swimming Pool Paint?</title>"
				+ "<description>What kind of paint should I use for the walls of the area round my swimming pool?</description>"
				+ "<categoryCode>flooring</categoryCode>"
				+ "<user>"
					+ "<name><firstName>Pam</firstName><lastName>Butchovi</lastName></name>"
					+ "<emailAddress>" + diyEmail + "</emailAddress>"
					+ "<marketingOptIn>false</marketingOptIn>"
				+ "</user>"
			+ "</diyQuestion>"));
		HttpResponse questionResponse = httpRequestExecutor.execute(post);
		if (questionResponse.getStatusLine().getStatusCode() != HttpStatus.SC_CREATED) {
			throw new IllegalStateException("Response " + questionResponse.getStatusLine().getStatusCode() + " received from diy question submission");
		}
		Header locationHeader =  questionResponse.getHeaders("Location")[0];
		String uriWithoutProtocol = locationHeader.getValue().split("//")[1];
		return uriWithoutProtocol.replace(TestContext.getDefault().getTestHostName(), "");		
	}

}
