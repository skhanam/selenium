package uk.co.ratedpeople;


/**
 * Class to provide functionality for configuring and executing a tradesman signup.
 * 
 * @author nigel.rawlins
 */
public class TradesmanSignupFactory {
	
	/**
	 * This is the method to call by default if just a general tradesman signup is required with no other features.
	 * It is anticipated that other methods will be added in this classes if more specific customisation is required when generating tradesmen.
	 * 
	 * @return A {@link RestDomainXMLBeanUser} representing the tradesman just signed up.
	 * @throws Exception
	 */
	public RestDomainXMLBeanUser doDefaultTradesmanSignup() throws Exception {
		return doTradesmanSignupSpecificSpecialisationsAndPostcode(TradesmanSignupConstants.POSTCODE, new Integer[]{});
	}

	public RestDomainXMLBeanUser doTradesmanSignupSpecificSpecialisationsAndPostcode(String postcode, Integer[] specialisations) throws Exception {
		
		final SpecialisationTypeWrapper specialisationTypeWrapper = TradesmanSignupSetterHelper.buildPrimaryTradeList(specialisations);
		
		final TradesmanPersonalDetails tradesmanPersonalDetails = TradesmanSignupSetterHelper.buildTradesmanPersonalDetails();
		
		final DetailedAddress detailedAddress =	TradesmanSignupSetterHelper.buildDetailedAddress(TradesmanSignupConstants.PROPERTY,
				TradesmanSignupConstants.STREET_NAME, TradesmanSignupConstants.TOWN, TradesmanSignupConstants.COUNTY, postcode);
		
		final TelephoneNumberCurrentTimeStampBasedGenerator telephoneNumberCurrentTimeStampBasedGenerator = new TelephoneNumberCurrentTimeStampBasedGenerator();
		String phoneNumber = telephoneNumberCurrentTimeStampBasedGenerator.generateMobileTelephoneNumber();
		
		final TradesmanBusinessDetails tradesmanBusinessDetails = TradesmanSignupSetterHelper.buildTradesmanBusinessDetails(detailedAddress,
				phoneNumber, telephoneNumberCurrentTimeStampBasedGenerator.generateLandLineTelephoneNumber());
		
		final Passport passport = TradesmanSignupSetterHelper.buildPassport();
		
		final TradesmanScreeningDetails tradesmanScreeningDetails = TradesmanSignupSetterHelper.buildTradesmanScreeningDetailsForPassport(passport, detailedAddress);
		
		final TradesmanBillingDetails tradesmanBillingDetails = TradesmanSignupSetterHelper.buildTradesmanBillingDetails(detailedAddress);
		
		final TradesmanSignup tradesmanSignup = new TradesmanSignup();
		tradesmanSignup.setPrimaryTradeList(specialisationTypeWrapper);
		tradesmanSignup.setTradesmanPersonalDetails(tradesmanPersonalDetails);
		tradesmanSignup.setTradesmanBusinessDetails(tradesmanBusinessDetails);
		tradesmanSignup.setTradesmanScreeningDetails(tradesmanScreeningDetails);
		tradesmanSignup.setTradesmanBillingDetails(tradesmanBillingDetails);
		
		final String tradesmanUserName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		
		new TradesmanSignupExecutor().signUpANewTradesman(tradesmanSignup, tradesmanUserName, postcode);
		
		RestDomainXMLBeanUser tradesman = new UserRetriever().getUser(tradesmanUserName, TradesmanSignupConstants.PASSWORD);
		tradesman.setMobilePhone(phoneNumber);
		return tradesman;
	}
	
}