package uk.co.ratedpeople;

import uk.co.ratedpeople.TradesmanBillingDetails.MonthYear;

public interface TradesmanSignupConstants {

	public static final String TRADESMAN_SIGNUP_POST_URI = "/api/v1/tradesman/signup";
	public static final String TRADESMAN_SIGNUP_PLAN_URI = "/api/v1/tradesman/signup/plan";
	public static final String TRADESMAN_SIGNUP_GET_URI = "/api/v1/tradesman/signup?email=";

	public static final String FAIL_EMAIL = "tm.signup.test.fail.businessdetails@ratedpeople.com";
	public static final String EMAIL_OF_EXISTING_TRADESMAN = "integration.test@ratedtrades.com";
	public static final String POSTCODE_OF_EXISTING_TRADESMAN = "SO300PY";

	/**
	 * Form Types
	 */
	public static final String FORM_TYPE_A = "FORM_A";
	public static final String FORM_TYPE_B = "FORM_B";
	public static final String FORM_TYPE_C = "FORM_C";
	public static final String FORM_TYPE_D = "FORM_D";
	public static final String FORM_TYPE_E = "FORM_E";

	/**
	 * Tradesman Signup bean
	 */
	public static final Integer CAMPAIGN_ID = 1;
	public static final String TARIFF_REF = "7f5940396c13";
	public static final String EMAIL = "do-not-touch-this-user@ratedpeople.com";
	public static final String DIFFERENT_POSTCODE = "SW1E6AU";
	public static final String LANDING_PAGE_URL = "/new-signup/A/7f5940396c13";
	public static final String LAST_VISITED_URL = "/new-signup/personal-details";

	public static final Integer STAGE_COMPLETED_1 = 1;
	public static final Integer STAGE_COMPLETED_2 = 2;
	public static final Integer STAGE_COMPLETED_3 = 3;
	public static final Integer STAGE_COMPLETED_4 = 4;

	public static final Integer SPECIALISATION_TYPE_ID_1 = 1;
	public static final Integer SPECIALISATION_TYPE_ID_2 = 2;

	/**
	 * Personal Details bean
	 */
	public static final Integer SALUTATION_TYPE_ID_1 = 1;
	public static final String SALUTATION_TYPE = "Mr";
	public static final String FIRST_NAME = "Albert";
	public static final String LAST_NAME = "McLaren";
	public static final Integer BUSINESS_ROLE_TYPE_ID = 2;
	public static final String PASSWORD = "password";
	public static final Integer MAX_DISTANCE = 20;
	public static final String CONTACT_NAME = "Rated";

	/**
	 * Business Details Bean
	 */
	public static final Integer BUSINESS_TYPE_ID = 2;
	public static final String COMPANY_NAME = "Homeowner Team";
	public static final String COMPANY_NAME_PROFILE = "homeowner-team";
	public static final Integer EMPLOYEE_COUNT_TYPE_ID = 2;
	public static final String COMPANY_NUMBER = "123COMP789";
	public static final String VAT_NUMBER = "789VAT123";
	public static final String MOBILE_NUMBER = "07562011144";
	public static final String LANDLINE_NUMBER = "02081234567";
	public static final Boolean MARKETING_OPT_IN = true;
	public static final Integer ORIGIN_TYPE_ID = 1;
	public static final Integer LEAD_SOURCE_ID = 1;

	/**
	 * Screening Details bean
	 */
	public static final String DOCUMENT_TYPE_PASSPORT = "PASSPORT";
	public static final String DOCUMENT_TYPE_LICENCE = "DRIVING_LICENCE";
	public static final String IP_ADDRESS = "192.168.0.1";
	public static final Integer SCREENING_RETRY_COUNT = 0;
	public static final String DOB = "1975-02-02+00:00";

	/**
	 * Driving Licence Details
	 */
	public static final String LICENCE_NUMBER_1 = "MCLAR";
	public static final String LICENCE_NUMBER_2 = "702025";
	public static final String LICENCE_NUMBER_3 = "A99";
	public static final String LICENCE_NUMBER_4 = "AB";

	/**
	 * Passport Contact Details
	 */
	public static final Integer SALUTATION_TYPE_ID_2 = 2;
	public static final String PASSPORT_FIRST_NAME = "Sharon";
	public static final String PASSPORT_LAST_NAME = "Warwick";
	public static final String PASSPORT_DOB = "1987-08-07+00:00";

	public static final String COUNTRY_OF_ORIGIN_UK = "GBR";
	public static final String COUNTRY_OF_ORIGIN_OTHER = "OTHER";
	public static final String PASSPORT_NUMBER_1 = "0445567687";
	public static final String PASSPORT_NUMBER_2 = "GBR";
	public static final String PASSPORT_NUMBER_3 = "8708070";
	public static final String PASSPORT_NUMBER_4 = "F";
	public static final String PASSPORT_NUMBER_5 = "1011186";
	public static final String PASSPORT_NUMBER_6 = "02";

	public static final String INTERNATIONAL_PASSPORT_NUMBER_1 = "044556768";
	public static final String INTERNATIONAL_PASSPORT_NUMBER_2 = "7";
	public static final String INTERNATIONAL_PASSPORT_NUMBER_3 = "GBR";
	public static final String INTERNATIONAL_PASSPORT_NUMBER_4 = "8708070";
	public static final String INTERNATIONAL_PASSPORT_NUMBER_5 = "F";
	public static final String INTERNATIONAL_PASSPORT_NUMBER_6 = "1011186";
	public static final String INTERNATIONAL_PASSPORT_NUMBER_7 = "&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;";
	public static final String INTERNATIONAL_PASSPORT_NUMBER_8 = "0";
	public static final String INTERNATIONAL_PASSPORT_NUMBER_9 = "2";

	public static final String PASSPORT_EXPIRY = "2030-11-18+00:00";

	public static final String PASSPORT_PROPERTY = "50 Pine Mews";
	public static final String PASSPORT_STREET_NAME = "St. James Road";
	public static final String PASSPORT_TOWN = "Liverpool";
	public static final String PASSPORT_POSTCODE = "L17BX";

	/**
	 * Credit Card Details
	 */
	public static final String CREDIT_CARD_NUMBER = "4929000000006";
	public static final MonthYear CREDIT_CARD_EXPIRY_DATE = new MonthYear(01, 2016);
	public static final String CREDIT_CARD_EXPIRY_MONTH = "01";
	public static final String CREDIT_CARD_EXPIRY_YEAR = "2016";
	public static final Integer CREDIT_CARD_CV2 = 123;
	public static final String PLAN_TYPE = "MONTHLY";

	/**
	 * Default Address
	 */
	public static final String PROPERTY = "66";
	public static final String STREET_NAME = "Buckingham Gate";
	public static final String TOWN = "Westminster";
	public static final String COUNTY = "London";
	public static final String POSTCODE = "SW1E6AU";

	public class RandomNumberGenerator {
		private static long current = System.currentTimeMillis();

		public static long generate() {
			return current++;
		}
	}

	public static final String RANDOM_NUMBER = Long.toString(RandomNumberGenerator.generate());
	public static final String RANDOM_EMAIL = RANDOM_NUMBER + "@ratedpeople.com";
	public static final String RANDOM_MOBILE_NUMBER = "07" + RANDOM_NUMBER.substring(4);
	public static final String RANDOM_LANDLINE_NUMBER = "02" + RANDOM_NUMBER.substring(4);

	public class DataRemover {
		public static boolean clear() {
			final boolean potentialContact = DataBaseHelper
					.executeQuery("delete from potential_tm_contact_details where potential_tm_id IN (SELECT id FROM potential_tm WHERE user_name IN ('"
							+ TradesmanSignupConstants.EMAIL + "','" + TradesmanSignupConstants.RANDOM_EMAIL + "','" + TradesmanSignupConstants.FAIL_EMAIL
							+ "'))");
			final boolean potentialSpecialisation = DataBaseHelper
					.executeQuery("delete from potential_tm_specialisation where potential_tm_id IN (SELECT id FROM potential_tm WHERE user_name IN ('"
							+ TradesmanSignupConstants.EMAIL + "','" + TradesmanSignupConstants.RANDOM_EMAIL + "','" + TradesmanSignupConstants.FAIL_EMAIL
							+ "'))");
			
			final boolean potentialIdentityCheckAttempt = DataBaseHelper
					.executeQuery("delete from potential_tm_identity_check_attempt where potential_tm_id IN (SELECT id FROM potential_tm WHERE user_name IN ('"
							+ TradesmanSignupConstants.EMAIL + "','" + TradesmanSignupConstants.RANDOM_EMAIL + "','" + TradesmanSignupConstants.FAIL_EMAIL
							+ "'))");
			
			final boolean potentialUser = DataBaseHelper.executeQuery("delete from potential_tm where user_name IN ('" + TradesmanSignupConstants.EMAIL + "','"
					+ TradesmanSignupConstants.RANDOM_EMAIL + "','" + TradesmanSignupConstants.FAIL_EMAIL + "')");

			final boolean blackListedUser = deleteBlacklistedUser(TradesmanSignupConstants.EMAIL);
			
			return potentialContact && potentialSpecialisation && potentialUser && blackListedUser && potentialIdentityCheckAttempt;
		}

		public static boolean addToBlacklistedUser(final String userName, final String mobileNumber) {
			String insertBlacklistedUser = "INSERT INTO blacklisted_user(user_id, user_name, address, phone_number_mobile)"
					+ "SELECT (SELECT max(id) FROM user), '" + userName + "', '1-2 Castle Lane, London, SW1E6DR', '" + mobileNumber + "'";

			final boolean success = DataBaseHelper.executeQuery(insertBlacklistedUser);

			return success;
		}

		public static boolean deleteBlacklistedUser(final String userName) {
			final boolean success = DataBaseHelper.executeQuery("DELETE FROM blacklisted_user where user_name='" + userName + "';");
			return success;
		}
	}
}