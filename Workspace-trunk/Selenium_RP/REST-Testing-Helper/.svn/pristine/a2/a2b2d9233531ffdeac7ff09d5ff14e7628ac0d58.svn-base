package uk.co.ratedpeople;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

public class JobPutter{
	
	private final HttpRequestCreator requestCreator;
	private final HttpRequestExecutor requestExecutor;

	public JobPutter() {
		requestCreator = new HttpRequestCreator();
		requestExecutor = new HttpRequestExecutor();
	}
	
	public HttpResponse updateJob(String homeOwnerId, String jobRef, String firstName, String lastName, String postCode, String mobile, String budgetCode, String description, String specialisationCode, String skillTypeId, String timing, String homeownerIntent) throws Exception {
		
		String uri = "/api/v1/homeowner/"+homeOwnerId+"/job/"+jobRef+"/update";
		
		HttpPut put = requestCreator.createPutRequestForUri(uri);
		requestCreator.assignDefaultAuthenticationHeader(put, APIAccessConstants.AGENT_USERNAME, APIAccessConstants.AGENT_PASSWORD);
		HttpEntity entity = new StringEntity(getXmlForJobUpdate(firstName, lastName, postCode, mobile, budgetCode, description, specialisationCode, skillTypeId, timing, homeownerIntent));
		
		put.setEntity(entity);
		
		HttpResponse response = requestExecutor.execute(put);

		return response;
	}
	
	private String getXmlForJobUpdate(String firstName, String lastName, String postCode, String mobile, String budgetCode, String description, String specialisationCode, String skillTypeId, String timing, String homeownerIntent) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<jobUpdateDetails>");
		sb.append("<jobContactDetails>");
			sb.append("<firstName>"+firstName+"</firstName>");
			sb.append("<lastName>"+lastName+"</lastName>");
			sb.append("<postCode>"+postCode+"</postCode>");
			sb.append("<mobile>"+mobile+"</mobile>");
		sb.append("</jobContactDetails>");
		sb.append("<budgetCode>"+budgetCode+"</budgetCode>");
		sb.append("<description>"+description+"</description>");
		sb.append("<specialisationCode>"+specialisationCode+"</specialisationCode>");
		sb.append("<skillTypeId>"+skillTypeId+"</skillTypeId>");
		sb.append("<timing>"+timing+"</timing>");
		sb.append("<homeownerIntent>"+homeownerIntent+"</homeownerIntent>");
		sb.append("</jobUpdateDetails>");		
		return sb.toString();
	}
	
}