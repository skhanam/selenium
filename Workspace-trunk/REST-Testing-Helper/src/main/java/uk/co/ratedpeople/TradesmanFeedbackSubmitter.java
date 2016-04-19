package uk.co.ratedpeople;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import uk.co.ratedpeople.HttpRequestCreator;
import uk.co.ratedpeople.HttpRequestExecutor;

public class TradesmanFeedbackSubmitter {
	private HttpRequestCreator requestCreator;
	private HttpRequestExecutor requestExecutor;
	
	public TradesmanFeedbackSubmitter() {
		this.requestCreator = new HttpRequestCreator();
		this.requestExecutor = new HttpRequestExecutor();
	}
	
	public HttpResponse postComment(String username, String password, int userid, String jobReference, String feedbackXml) throws Exception {
		HttpPost request = createPostComment(userid, jobReference);
		requestCreator.assignDefaultAuthenticationHeader(request, username, password);
		HttpEntity entity = new StringEntity(feedbackXml);
	    request.setEntity(entity);		
		HttpResponse response = requestExecutor.execute(request);
		return response;
	}
	
	private HttpPost createPostComment(int userid, String jobReference) throws Exception {
		final String postFeedbackUri = "/api/v1/tradesmen/" + userid + "/jobs/" + jobReference + "/feedback/comments";
		HttpPost request = requestCreator.createPostRequestForUri(postFeedbackUri);
		return request;
	}
}
