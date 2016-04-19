package uk.co.ratedpeople;

import java.util.Map;

import uk.co.ratedpeople.SpecialisationTypeWrapper.SpecialisationType;

public class TradesmanSignupBuilderHelper {

	public static String getXMLForTradesmanSignup(TradesmanSignup tradesmanSignup) {
		StringBuilder xml = new StringBuilder();
		xml.append("<tradesman>");
		
		if (tradesmanSignup.getFormType() != null) {
			xml.append("<formType>" + tradesmanSignup.getFormType() + "</formType>");
		}
		
		if (tradesmanSignup.getCampaignId() != null) {
			xml.append("<campaignId>" + tradesmanSignup.getCampaignId() + "</campaignId>");
		}
		
		if(tradesmanSignup.getTariffRef() != null){
			xml.append("<tariffRef>" + tradesmanSignup.getTariffRef() + "</tariffRef>");
		}
		
		if(tradesmanSignup.getLandingPageUrl() != null){
			xml.append("<landingPageUrl>" + tradesmanSignup.getLandingPageUrl() + "</landingPageUrl>");
		}
		
		if(tradesmanSignup.getLastVisitedUrl() != null){
			xml.append("<lastVisitedUrl>" + tradesmanSignup.getLastVisitedUrl() + "</lastVisitedUrl>");
		}
		
		if(tradesmanSignup.getStageCompleted() != null){
			xml.append("<stageCompleted>" + tradesmanSignup.getStageCompleted() + "</stageCompleted>");
		}
		
		if(tradesmanSignup.getEmail() != null){
			xml.append("<email>" + tradesmanSignup.getEmail() + "</email>");
		}
		
		if(tradesmanSignup.getPostcode() != null){
			xml.append("<postcode>" + tradesmanSignup.getPostcode() + "</postcode>");
		}

		if(tradesmanSignup.getPrimaryTradeList() != null){
			getXMLForPrimaryTradeList(xml, tradesmanSignup.getPrimaryTradeList());
		}
		
		if(tradesmanSignup.getTradesmanPersonalDetails() != null){
			getXMLForTradesmanPersonalDetails(xml, tradesmanSignup.getTradesmanPersonalDetails());
		}
		
		if(tradesmanSignup.getTradesmanBusinessDetails() != null){
			getXMLForTradesmanBusinessDetails(xml, tradesmanSignup.getTradesmanBusinessDetails());
		}
		
		if(tradesmanSignup.getTradesmanScreeningDetails() != null){
			getXMLForTradesmanScreeningDetails(xml, tradesmanSignup.getTradesmanScreeningDetails());
		}
		
		if(tradesmanSignup.getTradesmanBillingDetails() != null){
			getXMLForTradesmanBillingDetails(xml, tradesmanSignup.getTradesmanBillingDetails());
		}
		
		xml.append("</tradesman>");
		return xml.toString();
	}
	
	private static void getXMLForPrimaryTradeList(StringBuilder xml, SpecialisationTypeWrapper specialisationTypeWrapper) {
		xml.append("<primaryTradeList>");
		for(SpecialisationType specType : specialisationTypeWrapper.getSpecialisationTypeList()){
			xml.append("<specialisationtype>");
			xml.append("<id>" + specType.getId() + "</id>");
			xml.append("</specialisationtype>");
		}
		xml.append("</primaryTradeList>");
	}

	private static void getXMLForTradesmanPersonalDetails(StringBuilder xml, TradesmanPersonalDetails tradesmanPersonalDetails) {
		xml.append("<tradesmanPersonalDetails>");
		
		if(tradesmanPersonalDetails.getSalutationTypeId() != null){
			xml.append("<salutationTypeId>" + tradesmanPersonalDetails.getSalutationTypeId() + "</salutationTypeId>");
		}
		
		if(tradesmanPersonalDetails.getFirstName() != null){
			xml.append("<firstname>" + tradesmanPersonalDetails.getFirstName() + "</firstname>");
		}
		
		if(tradesmanPersonalDetails.getLastName() != null){
			xml.append("<lastname>" + tradesmanPersonalDetails.getLastName() + "</lastname>");
		}
		
		if(tradesmanPersonalDetails.getPassword() != null){
			xml.append("<password>" + tradesmanPersonalDetails.getPassword() + "</password>");
		}
		
		if(tradesmanPersonalDetails.getConfirmPassword() != null){
			xml.append("<confirmPassword>" + tradesmanPersonalDetails.getConfirmPassword() + "</confirmPassword>");
		}
		
		if(tradesmanPersonalDetails.getBusinessRoleTypeId() != null){
			xml.append("<businessRoleTypeId>" + tradesmanPersonalDetails.getBusinessRoleTypeId() + "</businessRoleTypeId>");
		}
		
		xml.append("</tradesmanPersonalDetails>");
	}
	
	private static void getXMLForTradesmanBusinessDetails(StringBuilder xml, TradesmanBusinessDetails tradesmanBusinessDetails) {
		xml.append("<tradesmanBusinessDetails>");
		
		if(tradesmanBusinessDetails.getBusinessTypeId() != null){
			xml.append("<businessTypeId>" + tradesmanBusinessDetails.getBusinessTypeId() + "</businessTypeId>");
		}
		
		if(tradesmanBusinessDetails.getContactName() != null){
			xml.append("<contactName>" + tradesmanBusinessDetails.getContactName() + "</contactName>");
		}
		
		if(tradesmanBusinessDetails.getCompanyName() != null){
			xml.append("<companyName>" + tradesmanBusinessDetails.getCompanyName() + "</companyName>");
		}
		
		if(tradesmanBusinessDetails.getEmployeeCountTypeId() != null){
			xml.append("<employeeCountTypeId>" + tradesmanBusinessDetails.getEmployeeCountTypeId() + "</employeeCountTypeId>");
		}		
		
		if(tradesmanBusinessDetails.getCompanyNumber() != null){
			xml.append("<companyNumber>" + tradesmanBusinessDetails.getCompanyNumber() + "</companyNumber>");
		}
		
		if(tradesmanBusinessDetails.getVatNumber() != null){
			xml.append("<vatNumber>" + tradesmanBusinessDetails.getVatNumber() + "</vatNumber>");
		}

		if(tradesmanBusinessDetails.getLandlineNumber() != null){
			xml.append("<landlineNumber>" + tradesmanBusinessDetails.getLandlineNumber() + "</landlineNumber>");
		}
		
		if(tradesmanBusinessDetails.getLeadSourceId() != null){
			xml.append("<leadSourceId>" + tradesmanBusinessDetails.getLeadSourceId() + "</leadSourceId>");
		}
		
		if(tradesmanBusinessDetails.getMobileNumber() != null){
			xml.append("<mobileNumber>" + tradesmanBusinessDetails.getMobileNumber() + "</mobileNumber>");
		}
		
		if(tradesmanBusinessDetails.getMaxDistance() != null){
			xml.append("<maxDistance>" + tradesmanBusinessDetails.getMaxDistance() + "</maxDistance>");
		}
		
		if(tradesmanBusinessDetails.getMarketingOptIn() != null){
			xml.append("<marketing_opt_in>" + tradesmanBusinessDetails.getMarketingOptIn() + "</marketing_opt_in>");
		}
		
		if(tradesmanBusinessDetails.getBusinessAddress() != null){
			xml.append("<businessAddress>");
			getXMLForDetailedAddress(xml, tradesmanBusinessDetails.getBusinessAddress());
			xml.append("</businessAddress>");
		}
		
		xml.append("</tradesmanBusinessDetails>");
	}
	
	private static void getXMLForTradesmanScreeningDetails(StringBuilder xml, TradesmanScreeningDetails tradesmanScreeningDetails) {
		xml.append("<tradesmanScreeningDetails>");
		
		if(tradesmanScreeningDetails.getDocumentType() != null){
			xml.append("<documentType>" + tradesmanScreeningDetails.getDocumentType() + "</documentType>");
		}
		
		if(tradesmanScreeningDetails.getIpAddress() != null){
			xml.append("<ipAddress>" + tradesmanScreeningDetails.getIpAddress() + "</ipAddress>");
		}
		
		if(tradesmanScreeningDetails.getSalutationTypeId() != null){
			xml.append("<salutationTypeId>" + tradesmanScreeningDetails.getSalutationTypeId() + "</salutationTypeId>");
		}	

		if(tradesmanScreeningDetails.getScreeningRetryCount() != null){
			xml.append("<screeningRetryCount>" + tradesmanScreeningDetails.getScreeningRetryCount() + "</screeningRetryCount>");
		}
		
		if(tradesmanScreeningDetails.getFirstName() != null){
			xml.append("<firstName>" + tradesmanScreeningDetails.getFirstName() + "</firstName>");
		}
		
		if(tradesmanScreeningDetails.getLastName() != null){
			xml.append("<lastName>" + tradesmanScreeningDetails.getLastName() + "</lastName>");
		}
		
		if(tradesmanScreeningDetails.getMiddleName() != null){
			xml.append("<middleName>" + tradesmanScreeningDetails.getMiddleName() + "</middleName>");
		}

		if(tradesmanScreeningDetails.getDateOfBirth() != null){
			xml.append("<dateOfBirth>" + tradesmanScreeningDetails.getDateOfBirth() + "</dateOfBirth>");
		}
		
		if(tradesmanScreeningDetails.getPassport() != null){
			getXMLForPassport(xml, tradesmanScreeningDetails.getPassport());
		}
		
		if(tradesmanScreeningDetails.getUkDrivingLicence() != null){
			getXMLForUKDrivingLicence(xml, tradesmanScreeningDetails.getUkDrivingLicence());
		}
		
		if(tradesmanScreeningDetails.getPersonalAddress() != null){
			xml.append("<personalAddress>");
			getXMLForDetailedAddress(xml, tradesmanScreeningDetails.getPersonalAddress());
			xml.append("</personalAddress>");
		}

		xml.append("</tradesmanScreeningDetails>");
	}
	
	private static void getXMLForTradesmanBillingDetails(StringBuilder xml, TradesmanBillingDetails tradesmanBillingDetails) {
		xml.append("<tradesmanBillingDetails>");
		
		if(tradesmanBillingDetails.getName() != null){
			xml.append("<name>" + tradesmanBillingDetails.getName() + "</name>");
		}
		
		if(tradesmanBillingDetails.getCardNumber() != null){
			xml.append("<cardNumber>" + tradesmanBillingDetails.getCardNumber() + "</cardNumber>");
		}
		
		if(tradesmanBillingDetails.getExpiryDate() != null){
			xml.append("<expiryDate>");
			xml.append("<month>" + tradesmanBillingDetails.getExpiryDate().getMonth() + "</month>");
			xml.append("<year>" + tradesmanBillingDetails.getExpiryDate().getYear() + "</year>");
			xml.append("</expiryDate>");
		}

		if(tradesmanBillingDetails.getCv2Number() != null){
			xml.append("<cv2Number>" + tradesmanBillingDetails.getCv2Number() + "</cv2Number>");
		}
		
		if(tradesmanBillingDetails.getBillingAddress() != null){
			xml.append("<billingAddress>");
			getXMLForDetailedAddress(xml, tradesmanBillingDetails.getBillingAddress());
			xml.append("</billingAddress>");
		}

		if(tradesmanBillingDetails.getPlanType() != null){
			xml.append("<planType>" + tradesmanBillingDetails.getPlanType() + "</planType>");
		}
		
		if(tradesmanBillingDetails.getPurchaseOrderId() != null){
			xml.append("<purchaseOrderId>" + tradesmanBillingDetails.getPurchaseOrderId() + "</purchaseOrderId>");
		}
		
		if(tradesmanBillingDetails.getThreeDResponse() != null){
			getXMLForThreeDResponse(xml, tradesmanBillingDetails.getThreeDResponse());
		}
		
		xml.append("</tradesmanBillingDetails>");
	}
		
	private static void getXMLForDetailedAddress(StringBuilder xml, DetailedAddress detailedAddress) {
		if(detailedAddress.getProperty() != null){
			xml.append("<property>" + detailedAddress.getProperty() + "</property>");
		}
		
		if(detailedAddress.getStreet() != null){
			xml.append("<street>" + detailedAddress.getStreet() + "</street>");
		}
		
		if(detailedAddress.getTown() != null){
			xml.append("<town>" + detailedAddress.getTown() + "</town>");
		}
		
		if(detailedAddress.getCounty() != null){
			xml.append("<county>" + detailedAddress.getCounty() + "</county>");
		}
		
		if(detailedAddress.getPostcode() != null){
			xml.append("<postcode>" + detailedAddress.getPostcode() + "</postcode>");
		}	
	}
	
	private static void getXMLForPassport(StringBuilder xml, Passport passport) {
		xml.append("<passport>");
		xml.append("<countryOfOrigin>" + passport.getCountryOfOrigin() + "</countryOfOrigin>");	
		xml.append("<expiryDate>" + passport.getExpiryDate()+ "</expiryDate>");
		xml.append("<number1>" + passport.getNumber1() + "</number1>");
		xml.append("<number2>" + passport.getNumber2() + "</number2>");
		xml.append("<number3>" + passport.getNumber3() + "</number3>");
		xml.append("<number4>" + passport.getNumber4() + "</number4>");
		xml.append("<number5>" + passport.getNumber5() + "</number5>");
		xml.append("<number6>" + passport.getNumber6() + "</number6>");
		xml.append("<number7>" + passport.getNumber7() + "</number7>");
		xml.append("<number8>" + passport.getNumber8() + "</number8>");
		xml.append("<number9>" + passport.getNumber9() + "</number9>");
		xml.append("</passport>");
	}
	
	private static void getXMLForUKDrivingLicence(StringBuilder xml, UKDrivingLicence ukDrivingLicence) {
		xml.append("<ukDrivingLicence>");
		
		if(ukDrivingLicence.getNumber1() != null){
			xml.append("<number1>" + ukDrivingLicence.getNumber1() + "</number1>");
		}
		
		if(ukDrivingLicence.getNumber2() != null){
			xml.append("<number2>" + ukDrivingLicence.getNumber2() + "</number2>");
		}
		
		if(ukDrivingLicence.getNumber3() != null){
			xml.append("<number3>" + ukDrivingLicence.getNumber3() + "</number3>");
		}
		
		if(ukDrivingLicence.getNumber4() != null){
			xml.append("<number4>" + ukDrivingLicence.getNumber4() + "</number4>");
		}
		
		xml.append("</ukDrivingLicence>");
	}
	
	private static void getXMLForThreeDResponse(StringBuilder xml, ThreeDResponse threeDResponse) {
		xml.append("<threedResponse>");
		xml.append("<md>" + threeDResponse.getMd() + "</md>");
		xml.append("<mdx>" + threeDResponse.getMdx() + "</mdx>");
		xml.append("<pares>" + threeDResponse.getPaRes() + "</pares>");
		xml.append("</threedResponse>");
	}
	
	public static ThreeDResponse setXMLForThreeDResponse(Map<String, String> threeDResponseMap){
		String threeResponseMD = threeDResponseMap.get("MD");
		String threeResponseMDX = threeDResponseMap.get("MDX");
		String threeResponsePaRes = threeDResponseMap.get("PaRes");
		
		ThreeDResponse threeDResponse = new ThreeDResponse();
		threeDResponse.setMd(threeResponseMD);
		threeDResponse.setMdx(threeResponseMDX);
		threeDResponse.setPaRes(threeResponsePaRes);
		
		return threeDResponse;
	}
}

