package uk.co.ratedpeople;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TradesmanSignupSetterHelper {
	
	public enum ScreeningType{
		PASSPORT,
		LICENCE;
	}
	
	public static TradesmanSignup buildTradesmanSignup(ScreeningType screeningType){
		SpecialisationTypeWrapper specialisationTypeWrapper = TradesmanSignupSetterHelper.buildPrimaryTradeList();
		DetailedAddress detailedAddress = TradesmanSignupSetterHelper.buildDetailedAddress(TradesmanSignupConstants.PROPERTY, TradesmanSignupConstants.STREET_NAME, TradesmanSignupConstants.TOWN, TradesmanSignupConstants.COUNTY, TradesmanSignupConstants.POSTCODE);
		
		TradesmanScreeningDetails screeningDetails;
		if(screeningType == ScreeningType.PASSPORT){
			DetailedAddress passportAddress = TradesmanSignupSetterHelper.buildDetailedAddress(TradesmanSignupConstants.PASSPORT_PROPERTY, TradesmanSignupConstants.PASSPORT_STREET_NAME, TradesmanSignupConstants.PASSPORT_TOWN, null, TradesmanSignupConstants.PASSPORT_POSTCODE);
			Passport passport = TradesmanSignupSetterHelper.buildPassport();
			screeningDetails = TradesmanSignupSetterHelper.buildTradesmanScreeningDetailsForPassport(passport, passportAddress);
		}else{
			UKDrivingLicence ukDrivingLicence = buildDrivingLicence();
			screeningDetails = buildTradesmanScreeningDetailsForLicence(ukDrivingLicence, detailedAddress);
		}
		
		TradesmanPersonalDetails personalDetails = TradesmanSignupSetterHelper.buildTradesmanPersonalDetails();
		TradesmanBusinessDetails businessDetails = TradesmanSignupSetterHelper.buildTradesmanBusinessDetails(detailedAddress);
		
		TradesmanBillingDetails billingDetails = TradesmanSignupSetterHelper.buildTradesmanBillingDetails(detailedAddress);
		
		TradesmanSignup tradesmanSignup = TradesmanSignupSetterHelper.buildTradesmanSignup(TradesmanSignupConstants.FORM_TYPE_A, TradesmanSignupConstants.STAGE_COMPLETED_1, specialisationTypeWrapper, 
				personalDetails, businessDetails, screeningDetails, billingDetails);
		
		return tradesmanSignup;
	}
	
	public static Passport buildInternationalPassport(){
		return PassportDetailsBuilder.build(
				TradesmanSignupConstants.COUNTRY_OF_ORIGIN_OTHER,
				TradesmanSignupConstants.PASSPORT_EXPIRY,
				TradesmanSignupConstants.INTERNATIONAL_PASSPORT_NUMBER_1,
				TradesmanSignupConstants.INTERNATIONAL_PASSPORT_NUMBER_2,
				TradesmanSignupConstants.INTERNATIONAL_PASSPORT_NUMBER_3,
				TradesmanSignupConstants.INTERNATIONAL_PASSPORT_NUMBER_4,
				TradesmanSignupConstants.INTERNATIONAL_PASSPORT_NUMBER_5,
				TradesmanSignupConstants.INTERNATIONAL_PASSPORT_NUMBER_6,
				TradesmanSignupConstants.INTERNATIONAL_PASSPORT_NUMBER_7,
				TradesmanSignupConstants.INTERNATIONAL_PASSPORT_NUMBER_8,
				TradesmanSignupConstants.INTERNATIONAL_PASSPORT_NUMBER_9
			);
	}
	
	private static TradesmanSignup buildTradesmanSignup(
			String formType,
			Integer stageCompleted,
			SpecialisationTypeWrapper primaryTradeList, 
			TradesmanPersonalDetails tradesmanPersonalDetails,
			TradesmanBusinessDetails tradesmanBusinessDetails,
			TradesmanScreeningDetails tradesmanScreeningDetails,
			TradesmanBillingDetails tradesmanBillingDetails){
		return TradesmanSignupBuilder.build(
						formType, 
						TradesmanSignupConstants.CAMPAIGN_ID,
						TradesmanSignupConstants.TARIFF_REF,
						TradesmanSignupConstants.LANDING_PAGE_URL,
						TradesmanSignupConstants.LAST_VISITED_URL,
						stageCompleted,
						TradesmanSignupConstants.EMAIL,
						TradesmanSignupConstants.POSTCODE,
						primaryTradeList,
						tradesmanPersonalDetails, 
						tradesmanBusinessDetails, 
						tradesmanScreeningDetails, 
						tradesmanBillingDetails
				);
	}
	
	public static SpecialisationTypeWrapper buildPrimaryTradeList(Integer... skills){
		List<Integer> specList = new ArrayList<Integer>();
		if(skills.length==0){
			specList.add(TradesmanSignupConstants.SPECIALISATION_TYPE_ID_1);
			specList.add(TradesmanSignupConstants.SPECIALISATION_TYPE_ID_2);
		}else {
			specList.addAll(Arrays.asList(skills));
		}
		return PrimaryTradeListBuilder.build(specList);
	}
	
	public static TradesmanPersonalDetails buildTradesmanPersonalDetails(){
		return TradesmanPersonalDetailsBuilder.build(
						TradesmanSignupConstants.SALUTATION_TYPE_ID_1,
						TradesmanSignupConstants.FIRST_NAME,
						TradesmanSignupConstants.LAST_NAME,
						TradesmanSignupConstants.PASSWORD,
						TradesmanSignupConstants.PASSWORD,
						TradesmanSignupConstants.BUSINESS_ROLE_TYPE_ID
				);
	}
	
	public static TradesmanBusinessDetails buildTradesmanBusinessDetails(DetailedAddress detailedAddress){
		return TradesmanSignupSetterHelper.buildTradesmanBusinessDetails(detailedAddress, 
																		  TradesmanSignupConstants.MOBILE_NUMBER,
																		  TradesmanSignupConstants.LANDLINE_NUMBER);
	}
	
	public static TradesmanBusinessDetails buildTradesmanBusinessDetails(DetailedAddress detailedAddress,
																		   String mobileNumber,
																		   String landlineNumber){
		return TradesmanBusinessDetailsBuilder.build(
					TradesmanSignupConstants.BUSINESS_TYPE_ID,
					TradesmanSignupConstants.CONTACT_NAME,
					TradesmanSignupConstants.COMPANY_NAME,
					TradesmanSignupConstants.EMPLOYEE_COUNT_TYPE_ID,
					TradesmanSignupConstants.COMPANY_NUMBER,
					TradesmanSignupConstants.VAT_NUMBER,
					mobileNumber,
					landlineNumber,
					TradesmanSignupConstants.MAX_DISTANCE,
					detailedAddress,
					TradesmanSignupConstants.MARKETING_OPT_IN,
					TradesmanSignupConstants.LEAD_SOURCE_ID
				);
	}
	
	public static TradesmanScreeningDetails buildTradesmanScreeningDetailsForPassport(Passport passport, DetailedAddress detailedAddress){
		return TradesmanScreeningDetailsBuilder.build(
					TradesmanSignupConstants.DOCUMENT_TYPE_PASSPORT,
					TradesmanSignupConstants.IP_ADDRESS,
					TradesmanSignupConstants.SCREENING_RETRY_COUNT,
					TradesmanSignupConstants.SALUTATION_TYPE_ID_2,
					TradesmanSignupConstants.PASSPORT_FIRST_NAME,
					null,
					TradesmanSignupConstants.PASSPORT_LAST_NAME,
					TradesmanSignupConstants.PASSPORT_DOB,
					passport,
					null,
					detailedAddress
				);
	}
	
	public static TradesmanScreeningDetails buildTradesmanScreeningDetailsForLicence(UKDrivingLicence ukDrivingLicence, DetailedAddress detailedAddress){
		return TradesmanScreeningDetailsBuilder.build(
					TradesmanSignupConstants.DOCUMENT_TYPE_LICENCE,
					TradesmanSignupConstants.IP_ADDRESS,
					TradesmanSignupConstants.SCREENING_RETRY_COUNT,
					TradesmanSignupConstants.SALUTATION_TYPE_ID_1,
					TradesmanSignupConstants.FIRST_NAME,
					null,
					TradesmanSignupConstants.LAST_NAME,
					TradesmanSignupConstants.DOB,
					null,
					ukDrivingLicence,
					detailedAddress
				);
	}
	
	public static TradesmanBillingDetails buildTradesmanBillingDetails(DetailedAddress detailedAddress){
		return TradesmanBillingDetailsBuilder.build(
					TradesmanSignupConstants.LAST_NAME,
					TradesmanSignupConstants.CREDIT_CARD_NUMBER,
					TradesmanSignupConstants.CREDIT_CARD_EXPIRY_DATE,
					TradesmanSignupConstants.CREDIT_CARD_CV2,
					detailedAddress,
					TradesmanSignupConstants.PLAN_TYPE,
					null,
					null
				);
	}
	
	public static DetailedAddress buildDetailedAddress(String property, String streetName, String town, String county, String postcode){
		return DetailedAddressBuilder.build(property, streetName, town, county, postcode);
	}
	
	public static Passport buildPassport(){
		return PassportDetailsBuilder.build(
					TradesmanSignupConstants.COUNTRY_OF_ORIGIN_UK,
					TradesmanSignupConstants.PASSPORT_EXPIRY,
					TradesmanSignupConstants.PASSPORT_NUMBER_1,
					TradesmanSignupConstants.PASSPORT_NUMBER_2,
					TradesmanSignupConstants.PASSPORT_NUMBER_3,
					TradesmanSignupConstants.PASSPORT_NUMBER_4,
					TradesmanSignupConstants.PASSPORT_NUMBER_5,
					TradesmanSignupConstants.PASSPORT_NUMBER_6,
					null,
					null,
					null
				);
	}
	
	public static UKDrivingLicence buildDrivingLicence(){
		return UKDrivingLicenceDetailsBuilder.build(
				TradesmanSignupConstants.LICENCE_NUMBER_1,
				TradesmanSignupConstants.LICENCE_NUMBER_2,
				TradesmanSignupConstants.LICENCE_NUMBER_3,
				TradesmanSignupConstants.LICENCE_NUMBER_4
			);
	}
}