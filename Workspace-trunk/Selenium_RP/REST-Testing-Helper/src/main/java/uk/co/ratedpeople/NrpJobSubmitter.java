package uk.co.ratedpeople;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import uk.co.ratedpeople.HttpRequestCreator;
import uk.co.ratedpeople.HttpRequestExecutor;

/**
 * Class for submitting NrpJobs
 * @author swetha.morthala
 */
public class NrpJobSubmitter {
	
	private HttpRequestCreator requestCreator = new HttpRequestCreator();
	private HttpRequestExecutor requestExecutor = new HttpRequestExecutor();
	
	public HttpResponse postNrpJobDataWithFields(Integer tradesmanId, String tradesmanUserName, String tradesmanPassword,
			String firstName, String lastName, String email, String telephone, String mobile, String jobTypeId, String postcode) throws Exception {
		
		String xml = getXmlForPostingNrpJob(firstName, lastName, email, telephone, mobile, jobTypeId, postcode);
		
		return  postNrpJobData(tradesmanId, tradesmanUserName, tradesmanPassword, xml);
	}
	
	public HttpResponse postNrpJobData(Integer tradesmanId, String tradesmanUserName, String tradesmanPassword, String xml) throws Exception {
		
		HttpPost post = requestCreator.createPostRequestForUri(getUri(tradesmanId));
		requestCreator.assignDefaultAuthenticationHeader(post, tradesmanUserName, tradesmanPassword);
		HttpEntity entity = new StringEntity(xml);
	    post.setEntity(entity);
		
		return requestExecutor.execute(post);
	}
	
	public String getXmlForPostingNrpJob(String firstName, String lastName, String email, String telephone, String mobile, String jobTypeId, String postcode) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("<nrpjob>");
		builder.append("<email>").append(email).append("</email>");
		builder.append("<firstname>").append(firstName).append("</firstname>");
		builder.append("<lastname>").append(lastName).append("</lastname>");
		
		if(mobile != null) {
			builder.append("<mobile>").append(mobile).append("</mobile>");
		}
		
		if(telephone != null) {
			builder.append("<telephone>").append(telephone).append("</telephone>");
		}
		
		builder.append("<jobtypeid>").append(jobTypeId).append("</jobtypeid>");
		builder.append("<postcode>").append(postcode).append("</postcode>");
		
		builder.append("</nrpjob>");
		
		return builder.toString();
	}
	
	private String getUri(Integer tradesmanId) {
		String uri = "/api/v1/tradesmen/" + tradesmanId + "/jobs";
		return uri;
	}
	
}
