package uk.co.ratedpeople;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

import uk.co.ratedpeople.RestDomainXMLBeanUser;

/**
 * Is a clone of RP app's uk.co.ratedpeople.test.functional.support.APIJobs
 *
 * @author zsolt
 */
@XmlRootElement(name = "job")
@XmlAccessorType(XmlAccessType.NONE)
public class APIJob {

	@XmlID()
	private String id = null;

	@XmlElement(required = false)
	private String tradeId = null;

	@XmlElement(required = true)
	private String jobTypeId = null;

	@XmlElement(required = true)
	private String summary = null;

	@XmlElement(required = true)
	private String description = null;

	@XmlElement(required = false)
	private String jobStartDateId = null;

	@XmlElement(required = true)
	private String postcode = null;

	@XmlElement(required = true)
	private String jobBudgetId = null;

	@XmlElement(required = false)
	private String timing = null;
	
	@XmlElement(required = false)
	private String intent;

	@XmlElement(name = "user", required = true)
	private RestDomainXMLBeanUser user = null;
	
	@XmlElement(required = false)
	private boolean thirdPartyMarketingOptIn;

	@XmlElement()
	private boolean agreedToTandC = false;
	
	@XmlElement(required = false)
	private Integer reservedTradesmanUserId;
	

	
	public RestDomainXMLBeanUser getUser() {
		return user;
	}

	public void setUser(RestDomainXMLBeanUser user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobBudgetId() {
		return jobBudgetId;
	}

	public void setJobBudgetId(String jobBudgetId) {
		this.jobBudgetId = jobBudgetId;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}
	
	public void setIntent(String intent) {
		this.intent = intent;
	}
	
	public String getIntent() {
		return intent;
	}

	/**
	 * The time until the job is expected to start
	 * @return The period of time the homeowner is expecting to wait for the work to be done. 
	 */
	public String getJobStartDateId() {
		return jobStartDateId;
	}

	public void setJobStartDateId(String jobStartDateId) {
		this.jobStartDateId = jobStartDateId;
	}

	public String getJobTypeId() {
		return jobTypeId;
	}

	public void setJobTypeId(String jobTypeId) {
		this.jobTypeId = jobTypeId;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public boolean isAgreedToTandC() {
		return agreedToTandC;
	}

	public void setAgreedToTandC(boolean agreedToTandC) {
		this.agreedToTandC = agreedToTandC;
	}

	public boolean isThirdPartyMarketingOptIn() {
		return thirdPartyMarketingOptIn;
	}

	public void setThirdPartyMarketingOptIn(boolean thirdPartyMarketingOptIn) {
		this.thirdPartyMarketingOptIn = thirdPartyMarketingOptIn;
	}

	public Integer getReservedTradesmanUserId() {
		return reservedTradesmanUserId;
	}

	public void setReservedTradesmanUserId(Integer reservedTradesmanUserId) {
		this.reservedTradesmanUserId = reservedTradesmanUserId;
	}
	
}
