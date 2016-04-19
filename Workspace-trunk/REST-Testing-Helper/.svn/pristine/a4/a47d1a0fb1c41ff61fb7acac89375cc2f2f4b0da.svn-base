package uk.co.ratedpeople;


public class TradesmanSignupBuilder {

	public static TradesmanSignup build(String formType,  Integer campaignId,String tariffRef,
			 String landingPageUrl, String lastVisitedUrl, Integer stageCompleted, String email, String postcode, 
			 SpecialisationTypeWrapper primaryTradeList,TradesmanPersonalDetails tradesmanPersonalDetails,
			 TradesmanBusinessDetails tradesmanBusinessDetails, TradesmanScreeningDetails tradesmanScreeningDetails, TradesmanBillingDetails tradesmanBillingDetails) {
		TradesmanSignup obj = new TradesmanSignup();
		obj.setCampaignId(campaignId);
		obj.setEmail(email);
		obj.setFormType(formType);
		obj.setLandingPageUrl(landingPageUrl);
		obj.setLastVisitedUrl(lastVisitedUrl);
		obj.setPostcode(postcode);
		obj.setPrimaryTradeList(primaryTradeList);
		obj.setStageCompleted(stageCompleted);
		obj.setTariffRef(tariffRef);
		obj.setTradesmanBillingDetails(tradesmanBillingDetails);
		obj.setTradesmanBusinessDetails(tradesmanBusinessDetails);
		obj.setTradesmanPersonalDetails(tradesmanPersonalDetails);
		obj.setTradesmanScreeningDetails(tradesmanScreeningDetails);
		return obj;
	}
}

