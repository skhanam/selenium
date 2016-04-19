package uk.co.ratedpeople;

public class TradesmanSignup {
	
	private String formType;
	private Integer campaignId;
	private String tariffRef;
	private String landingPageUrl;
	private String lastVisitedUrl;
	private Integer stageCompleted;
	private String email;
	private String postcode;
	private SpecialisationTypeWrapper primaryTradeList;
	private TradesmanPersonalDetails tradesmanPersonalDetails;
	private TradesmanBusinessDetails tradesmanBusinessDetails;
	private TradesmanScreeningDetails tradesmanScreeningDetails;
	private TradesmanBillingDetails tradesmanBillingDetails;
	
	public String getFormType() {
		return formType;
	}
	
	public void setFormType(String formType) {
		this.formType = formType;
	}
	
	public Integer getCampaignId() {
		return campaignId;
	}
	
	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}
	
	public String getTariffRef() {
		return tariffRef;
	}
	
	public void setTariffRef(String tariffRef) {
		this.tariffRef = tariffRef;
	}
	
	public String getLandingPageUrl() {
		return landingPageUrl;
	}
	public void setLandingPageUrl(String landingPageUrl) {
		this.landingPageUrl = landingPageUrl;
	}
	
	public String getLastVisitedUrl() {
		return lastVisitedUrl;
	}
	
	public void setLastVisitedUrl(String lastVisitedUrl) {
		this.lastVisitedUrl = lastVisitedUrl;
	}
	public Integer getStageCompleted() {
		return stageCompleted;
	}
	
	public void setStageCompleted(Integer stageCompleted) {
		this.stageCompleted = stageCompleted;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public SpecialisationTypeWrapper getPrimaryTradeList() {
		return primaryTradeList;
	}

	public void setPrimaryTradeList(SpecialisationTypeWrapper primaryTradeList) {
		this.primaryTradeList = primaryTradeList;
	}

	public TradesmanPersonalDetails getTradesmanPersonalDetails() {
		return tradesmanPersonalDetails;
	}
	
	public void setTradesmanPersonalDetails(
			TradesmanPersonalDetails tradesmanPersonalDetails) {
		this.tradesmanPersonalDetails = tradesmanPersonalDetails;
	}
	
	public TradesmanBusinessDetails getTradesmanBusinessDetails() {
		return tradesmanBusinessDetails;
	}
	
	public void setTradesmanBusinessDetails(
			TradesmanBusinessDetails tradesmanBusinessDetails) {
		this.tradesmanBusinessDetails = tradesmanBusinessDetails;
	}
	
	public TradesmanScreeningDetails getTradesmanScreeningDetails() {
		return tradesmanScreeningDetails;
	}
	
	public void setTradesmanScreeningDetails(
			TradesmanScreeningDetails tradesmanScreeningDetails) {
		this.tradesmanScreeningDetails = tradesmanScreeningDetails;
	}
	
	public TradesmanBillingDetails getTradesmanBillingDetails() {
		return tradesmanBillingDetails;
	}
	
	public void setTradesmanBillingDetails(
			TradesmanBillingDetails tradesmanBillingDetails) {
		this.tradesmanBillingDetails = tradesmanBillingDetails;
	}
}
