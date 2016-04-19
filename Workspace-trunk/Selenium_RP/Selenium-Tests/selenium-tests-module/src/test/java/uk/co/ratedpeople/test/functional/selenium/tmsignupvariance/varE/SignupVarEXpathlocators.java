package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import java.util.HashMap;
import java.util.Map;

public class SignupVarEXpathlocators {

	@SuppressWarnings("serial")
	public static Map<String, String> xpathLookup = new HashMap<String, String>() {
		{
			// xpath and id for the tm sign up pages Var E
			// postcode landing page
			put("POSTCODE", "postcode");
			put("VIEW_JOB_LEADS_BTN", ".//*[@id='landingAreaForm']/button");
			put("POSTCODE_ERROR", ".//*[@id='landingAreaForm']/em");
			
			put("SELECT_SKILLS_ERROR", "//*[@id='skillsForm']/div/em");
			
			put("ROSETTE_TEXT", ".//*[@id='neutral-main-column']/section[1]/div[1]");

			// select trades Page
			put("VIEW_JOB_LEADS_FOR_YOUR_TRADE_BTN", ".//*[@id='skillsForm']/div/button");
			put("AERIAL_TRADE", ".//*[@id='skillsForm']/ul/li[1]/a");
			put("CLEANER_TRADE", ".//*[@id='skillsForm']/ul/li[6]/a");
			put("HANDYMAN_TRADE", ".//*[@id='skillsForm']/ul/li[12]/a");
			put("ROOFER_TRADE", ".//*[@id='skillsForm']/ul/li[22]/a");
			put("WINDOW_TRADE", ".//*[@id='skillsForm']/ul/li[1]/a");

			// select workarea page
			put("MILES", ".//*[@id='radius']");
			put("CONFIRM_WORK_AREA_BTN", ".//*[@id='neutral-main-column']/section[1]/form/div/button");

			// business details page
			put("FINDADDRESS_BTN", ".//*[@id='find-postcode-button']");
			put("ADDRESS_OPTION", ".//*[@id='tradesman-address']/option[2]");
			put("NEXT_PAGE", ".//*[@id='contactDetailsSection']/button");
			put("BUSINESS_NAME", "form_businessDetails_companyName");
			put("BUSINESS_NAME_ERROR", ".//*[@id='businessDetailsForm']/div[1]/em");
			
			
			put("MOBILE_NUMBER", "form_businessDetails_mobileNumber");
			put("MOBILE_NUMBER_ERROR", ".//*[@id='businessDetailsForm']/div[2]/em");
			put("EXISTING_MOBILE_NUMBER_ERROR", ".//*[@id='businessDetailsForm']/div[2]/em");
			
			
			put("LANLINE_NUMBER", "form_businessDetails_landlineNumber");
			put("CONTACT_NAME", "form_businessDetails_contactName");
			put("CONTACT_NAME_ERROR", ".//*[@id='contactDetailsSection']/div[1]/em");
			
			
			put("EMAIL_ADDRESS", "form_email");
			put("EMAIL_ADDRESS_ERROR", ".//*[@id='contactDetailsSection']/div[2]/em");
			put("EXISTING_EMAIL_ADDRESS_ERROR", ".//*[@id='contactDetailsSection']/div[2]/em");
				
			put("PASSWORD", "form_personalDetails_password1");
			put("PASSWORD_ERROR", ".//*[@id='contactDetailsSection']/div[3]/em");
			
			put("CONFIRM_PASSWORD", "form_personalDetails_password2");
			put("CONFIRM_PASSWORD_ERROR", ".//*[@id='contactDetailsSection']/div[4]/em");
			
			put("TYPES_OF_BUSINESS", "form_businessDetails_businessTypeId");
			put("TYPES_OF_BUSINESS_ERROR", ".//*[@id='contactDetailsSection']/div[5]/em");
			
			put("PEOPLE_IN_BUSINESS", "form_businessDetails_noOfEmployees");
			put("PEOPLE_IN_BUSINESS_ERROR", ".//*[@id='contactDetailsSection']/div[6]/em");
			
			put("HEAR_US", "form_businessDetails_leadSource");
			put("HEAR_US_ERROR", ".//*[@id='contactDetailsSection']/div[7]/em");

			
			// screening selection page
			put("DL_UK", ".//*[@id='idchoice']/div[1]/button");
			put("PASSPORT_UK", ".//*[@id='idchoice']/div[2]/button");
			put("PASSPORTGBR_UK", ".//*[@id='idchoice']/div[2]/button");


			// driving license page
			put("DL_FIND_ADDRESS", "find-postcode-button");
			put("DL_OPTION_FIND_ADDRESS", ".//*[@id='tradesman-address']/option[1]");
			put("DL_CONFIRM_BTN", "confirmButton");
			put("DL_POSTCODE", "form_postcode");
			
			put("DL_ADDRESS_NOT_AVAILABLE", ".//*[@id='address-not-available']");
			put("DL_ADDRESS_HOME_NUM", "form_address_property");
			put("DL_ADDRESS_STREET", "form_address_street");
			put("DL_ADDRESS_TOWN", "form_address_town");

			put("DL_NUM1", "form_licenceNumber_part1");
			put("DL_NUM2", "form_licenceNumber_part2");
			put("DL_NUM3", "form_licenceNumber_part3");
			put("DL_NUM4", "form_licenceNumber_part4");
			put("DL_DOB", "form_dateOfBirth_day");
			put("DL_DOM", "form_dateOfBirth_month");
			put("DL_DOY", "form_dateOfBirth_year");
			put("DL_GENDER", "form_gender");
			put("DL_SALUTATION_TYPE", "form_salutationTypeId");
			put("DL_FIRSTNAME", "form_firstName");
			put("DL_LASTNAME", "form_lastName");
			put("DL_BUSINESS_ROLE", "form_describesYou");
			
			put("DL_NUM1_ERROR", ".//*[@id='drivingLicenceDetailsScreeningForm']/div[1]/em[1]");
			put("DL_NUM2_ERROR", ".//*[@id='drivingLicenceDetailsScreeningForm']/div[1]/em[2]");
			put("DL_NUM3_ERROR", ".//*[@id='drivingLicenceDetailsScreeningForm']/div[1]/em[3]");
			put("DL_NUM4_ERROR", ".//*[@id='drivingLicenceDetailsScreeningForm']/div[1]/em[4]");
			put("DL_DOB_ERROR", ".//*[@id='drivingLicenceDetailsScreeningForm']/div[2]/em");
			put("DL_DOM_ERROR",".//*[@id='drivingLicenceDetailsScreeningForm']/div[2]/em");
			put("DL_DOY_ERROR",".//*[@id='drivingLicenceDetailsScreeningForm']/div[2]/em");
			put("DL_FIRSTNAME_ERROR",".//*[@id='drivingLicenceDetailsScreeningForm']/div[6]/em");
			put("DL_LASTNAME_ERROR",".//*[@id='drivingLicenceDetailsScreeningForm']/div[7]/em");
			put("DL_SALUTATION_TYPE_ERROR",".//*[@id='drivingLicenceDetailsScreeningForm']/div[5]/em");

			
			

			// rollon plans page
			put("DL_MONTHLY_PLAN", "monthlyPlan");
			put("DL_ANNUAL_PLAN", "annualPlan");

			put("PASSPORT_MONTHLY_PLAN", "monthlyPlan");
			put("PASSPORT_ANNUAL_PLAN", "annualPlan");
			
			put("PASSPORTGBR_MONTHLY_PLAN", "monthlyPlan");
			put("PASSPORTGBR_ANNUAL_PLAN", "annualPlan");
			
			put("MONTHLY_PLAN_TEXT", ".//*[@id='selectPlan']/div[1]/div/div/p");
			put("ANNUAL_PLAN_TEXT", ".//*[@id='selectPlan']/div[2]/div[2]/div/p");
			put("FREE_LEADS_TEXT", ".//*[@id='neutral-main-column']/section/section/ul[1]/li[2]");
			
			
			// billing credit card page
			put("CREDITCARD_NAME", "form_nameOnCard");
			put("CREDITCARD_NUM", "form_cardNumber");
			put("CREDITCARD_MONTH", "form_expirationDate_month");
			put("CREDITCARD_YEAR", "form_expirationDate_year");
			put("CREDITCARD_SECURITY_CODE", "form_cvv");
			put("CREDITCARD_CONFIRM_BTN", "confirmButton");
			
			put("SELECT_BILLING_CARD_NAME_ERROR", ".//*[@id='billingForm']/div/em");
			put("SELECT_BILLING_CARD_NUMBER_ERROR", ".//*[@id='billingForm']/div[2]/em");
			put("SELECT_BILLING_CARD_MONTH_ERROR", ".//*[@id='billingForm']/div[3]/em[1]");
			put("SELECT_BILLING_CARD_YEAR2_ERROR", ".//*[@id='billingForm']/div[3]/em[1]");
			put("SELECT_BILLING_CARD_YEAR1_ERROR", ".//*[@id='billingForm']/div[3]/em[2]");
			put("SELECT_BILLING_CARD_CVV_ERROR", ".//*[@id='billingForm']/div[4]/em");

			
			//sage page 3D secure page
     		put("CREDITCARD_3D_PASSWORD",".//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[5]/td[2]/input");
			put("CREDITCARD_SUBMIT_BTN",".//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[6]/td[2]/input");
			
			// Passport screening Page for tokyo
			put("SELECT_PASSPORT", "form_passportDetails_countryOfIssue");
			put("PASSPORT_NUM1", "form_passportDetails_passport1");
			put("PASSPORT_NUM2", "form_passportDetails_passport2");
			put("PASSPORT_NUM3", "form_passportDetails_passport3");
			put("PASSPORT_NUM4", "form_passportDetails_passport4");
			put("PASSPORT_NUM5", "form_passportDetails_passport5");
			put("PASSPORT_NUM6", "form_passportDetails_passport6");
			put("PASSPORT_NUM7", "form_passportDetails_passport7");
			put("PASSPORT_NUM8", "form_passportDetails_passport8");
			put("PASSPORT_NUM9", "form_passportDetails_passport9");
			put("PASSPORT_EXPDAY", "form_passportDetails_expiryDate_day");
			put("PASSPORT_EXPMON", "form_passportDetails_expiryDate_month");
			put("PASSPORT_EXPYEAR", "form_passportDetails_expiryDate_year");
			put("PASSPORT_DOB_DAY", "form_dateOfBirth_day");
			put("PASSPORT_DOB_MONTH", "form_dateOfBirth_month");
			put("PASSPORT_DOB_YEAR", "form_dateOfBirth_year");
			put("PASSPORT_GENDER", "form_gender");
			put("PASSPORT_SALUTATION_TYPE", "form_salutationTypeId");
			put("PASSPORT_FIRST_NAME", "form_firstName");
			put("PASSPORT_LAST_NAME", "form_lastName");
			put("PASSPORT_DESCRIBES_YOU", "form_describesYou");
			put("PASSPORT_POSTCODE", "form_postcode");
			put("PASSPORT_FIND_ADDRESS_BTN", "find-postcode-button");
			put("PASSPORT_OPTION_FIND_ADDRESS", ".//*[@id='tradesman-address']/option[1]");
			put("PASSPORT_ADDRESS_NOT_AVAILABLE", "address-not-available");
			put("PASSPORT_ADDRESS_HOME_NUM", "form_address_property");
			put("PASSPORT_ADDRESS_STREET", "form_address_street");
			put("PASSPORT_ADDRESS_TOWN", "form_address_town");
			put("PASSPORT_CONFIRM_BTN", "confirmButton");	
			
			// Passport GBR screening Page for tokyo
			put("SELECT_PASSPORT", "form_passportDetails_countryOfIssue");
			put("PASSPORTGBR_NUM1", "form_passportDetails_passport1");
			put("PASSPORTGBR_NUM2", "form_passportDetails_passport2");
			put("PASSPORTGBR_NUM3", "form_passportDetails_passport3");
			put("PASSPORTGBR_NUM4", "form_passportDetails_passport4");
			put("PASSPORTGBR_NUM5", "form_passportDetails_passport5");
			put("PASSPORTGBR_NUM6", "form_passportDetails_passport6");
			put("PASSPORTGBR_EXPDAY", "form_passportDetails_expiryDate_day");
			put("PASSPORTGBR_EXPMON", "form_passportDetails_expiryDate_month");
			put("PASSPORTGBR_EXPYEAR", "form_passportDetails_expiryDate_year");
			put("PASSPORTGBR_DOB_DAY", "form_dateOfBirth_day");
			put("PASSPORTGBR_DOB_MONTH", "form_dateOfBirth_month");
			put("PASSPORTGBR_DOB_YEAR", "form_dateOfBirth_year");
			put("PASSPORTGBR_GENDER", "form_gender");
			put("PASSPORTGBR_SALUTATION_TYPE", "form_salutationTypeId");
			put("PASSPORTGBR_FIRST_NAME", "form_firstName");
			put("PASSPORTGBR_LAST_NAME", "form_lastName");
			put("PASSPORTGBR_DESCRIBES_YOU", "form_describesYou");
			put("PASSPORTGBR_POSTCODE", "form_postcode");
			put("PASSPORTGBR_FIND_ADDRESS_BTN", "find-postcode-button");
			put("PASSPORTGBR_OPTION_FIND_ADDRESS", ".//*[@id='tradesman-address']/option[1]");
			put("PASSPORTGBR_ADDRESS_NOT_AVAILABLE", "address-not-available");
			put("PASSPORTGBR_ADDRESS_HOME_NUM", "form_address_property");
			put("PASSPORTGBR_ADDRESS_STREET", "form_address_street");
			put("PASSPORTGBR_ADDRESS_TOWN", "form_address_town");
			put("PASSPORTGBR_CONFIRM_BTN", "confirmButton");	
			
			
			//PASSPORTGBR ERROR MSG XPATH
			put("PASSPORTGBR_NUM1_ERROR",".//*[@id='passportDetailsScreeningForm']/div[2]/em[1]");
			put("PASSPORTGBR_NUM2_ERROR",".//*[@id='passportDetailsScreeningForm']/div[2]/em[2]");
			put("PASSPORTGBR_NUM3_ERROR",".//*[@id='passportDetailsScreeningForm']/div[2]/em[3]");
			put("PASSPORTGBR_NUM4_ERROR",".//*[@id='passportDetailsScreeningForm']/div[2]/em[4]");
			put("PASSPORTGBR_NUM5_ERROR",".//*[@id='passportDetailsScreeningForm']/div[2]/em[5]");
			put("PASSPORTGBR_NUM6_ERROR",".//*[@id='passportDetailsScreeningForm']/div[2]/em[6]");
			put("PASSPORTGBR_EXPDAY_ERROR",".//*[@id='passportDetailsScreeningForm']/div[3]/em[1]");
			put("PASSPORTGBR_EXPMON_ERROR",".//*[@id='passportDetailsScreeningForm']/div[3]/em[2]");
			put("PASSPORTGBR_EXPYEAR_ERROR",".//*[@id='passportDetailsScreeningForm']/div[3]/em[3]");
			put("PASSPORTGBR_DOB_DAY_ERROR",".//*[@id='passportDetailsScreeningForm']/div[4]/em");
			put("PASSPORTGBR_DOB_MONTH_ERROR",".//*[@id='passportDetailsScreeningForm']/div[4]/em");
			put("PASSPORTGBR_DOB_YEAR_ERROR",".//*[@id='passportDetailsScreeningForm']/div[4]/em");
			put("PASSPORTGBR_FIRST_NAME_ERROR",".//*[@id='passportDetailsScreeningForm']/div[8]/em");
			put("PASSPORTGBR_LAST_NAME_ERROR",".//*[@id='passportDetailsScreeningForm']/div[9]/em");

			// PASSPORTGBR ERROR MSG XPATH
			put("PASSPORT_NUM1_ERROR", ".//*[@id='passportDetailsScreeningForm']/div[2]/em[1]");
			put("PASSPORT_NUM2_ERROR", ".//*[@id='passportDetailsScreeningForm']/div[2]/em[2]");
			put("PASSPORT_NUM3_ERROR", ".//*[@id='passportDetailsScreeningForm']/div[2]/em[3]");
			put("PASSPORT_NUM4_ERROR", ".//*[@id='passportDetailsScreeningForm']/div[2]/em[4]");
			put("PASSPORT_NUM5_ERROR", ".//*[@id='passportDetailsScreeningForm']/div[2]/em[5]");
			put("PASSPORT_NUM6_ERROR", ".//*[@id='passportDetailsScreeningForm']/div[2]/em[6]");
			put("PASSPORT_EXPDAY_ERROR", ".//*[@id='passportDetailsScreeningForm']/div[3]/em[1]");
			put("PASSPORT_EXPMON_ERROR", ".//*[@id='passportDetailsScreeningForm']/div[3]/em[2]");
			put("PASSPORT_EXPYEAR_ERROR", ".//*[@id='passportDetailsScreeningForm']/div[3]/em[3]");
			put("PASSPORT_DOB_DAY_ERROR", ".//*[@id='passportDetailsScreeningForm']/div[4]/em");
			put("PASSPORT_DOB_MONTH_ERROR", ".//*[@id='passportDetailsScreeningForm']/div[4]/em");
			put("PASSPORT_DOB_YEAR_ERROR", ".//*[@id='passportDetailsScreeningForm']/div[4]/em");
			put("PASSPORT_FIRST_NAME_ERROR", ".//*[@id='passportDetailsScreeningForm']/div[8]/em");
			put("PASSPORT_LAST_NAME_ERROR", ".//*[@id='passportDetailsScreeningForm']/div[9]/em");


			//Induction page header
			put("WELCOME_HEADER", ".//*[@id='neutral-main-column']/section/h1");
			
			//ERROR MSGS XPATHS
			put("DL_POSTCODE_ERRORMSGXPATH","/html/body/div/div/div[2]/div/div/div/section/form/div[9]/em");
			
			
		}
	};

	@SuppressWarnings("serial")
	public static Map<String, String> dataLookup = new HashMap<String, String>() {
		{
			// datd for all the pages
			// postcode landing page
			put("postcode", "ha04rq");

			// business details
			put("business_name", "self");
			put("mobile_number", "07");
			put("lanline_number", "");
			put("contact_name", "seleniumuser");

			put("password", "password");
			put("confirm_password", "password");
			put("type_businees", "1");
			put("people_in_business", "1");
			put("hear_us", "1");

			put("dl_num1", "MCLAR");
			put("dl_num2", "702025");
			put("dl_num3", "A99");
			put("dl_num4", "AB");

			put("dl_dob", "2");
			put("dl_dom", "Feb");
			put("dl_doy", "1975");

			put("dl_gender", "1");
			put("dl_saluatation_type", "1");
			put("dl_firstname", "Albert");
			put("dl_lastname", "McLaren");

			put("dl_business_role", "1");
			
			put("dl_property","22 A");
			put("dl_street","Central Road");
			put("dl_town","Wembley");			

			// billing credit card details
			put("creditcard_name", "seleniumusername");
			put("creditcard_num", "4929000000006");
//			put("creditcard_num", "5 641 8200 0000 0005");
			put("creditcard_month", "Jan");
			put("creditcard_year", "2020");
			put("creditcard_security", "123");

			//sage page 3D secure password details
			put("creditcard_3d_password","password");
			
			
			// passport details for tokyo
			
			put("select_passport", "1");
			put("_passport_num1", "044556768");
			put("_passport_num2", "7");
			put("_passport_num3", "GBR");
			put("_passport_num4", "8708070");
			put("_passport_num5", "F");
			put("_passport_num6", "1011186");			
			put("_passport_num7", "<<<<<<<<<<<<<<");
			put("_passport_num8", "0");
			put("_passport_num9", "2");
			put("_passport_exp_day", "18");
			put("_passport_exp_mon", "November");
			put("_passport_exp_year", "2030");
			put("_passport_dob_day", "07");
			put("_passport_dob_mon", "August");
			put("_passport_dob_year", "1987");
			put("_passport_gender", "Female");
			put("_passport_sal_name", "Mrs");
			put("_passport_firstname", "Sharon");
			put("_passport_lastname", "Warwick");
			put("_passport_describes_u", "1");
			put("_passport_postcode", "L1 7BX");
			put("_passport_home_num", "50");
			put("_passport_property", "Rose Cottage");
			put("_passport_street", "St.James Road ");
			put("_passport_town", "Liverpool");
					
			
			
			
			
			

			// passport GBR details for tokyo
			
			put("select_passport", "1");
			put("_passportGbr_num1", "0445567687");
			put("_passportGbr_num2", "GBR");
			put("_passportGbr_num3", "8708070");
			put("_passportGbr_num4", "F");
			put("_passportGbr_num5", "1011186");
			put("_passportGbr_num6", "02");			
			put("_passportGbr_exp_day", "18");
			put("_passportGbr_exp_mon", "November");
			put("_passportGbr_exp_year", "2030");
			put("_passportGbr_dob_day", "07");
			put("_passportGbr_dob_mon", "August");
			put("_passportGbr_dob_year", "1987");
			put("_passportGbr_gender", "Female");
			put("_passportGbr_sal_name", "Mrs");
			put("_passportGbr_firstname", "Sharon");
			put("_passportGbr_lastname", "Warwick");
			put("_passportGbr_describes_u", "1");
			put("_passportGbr_postcode", "L1 7BX");
			put("_passportGbr_home_num", "50");
			put("_passportGbr_property", "Rose Cottage");
			put("_passportGbr_street", "St.James Road ");
			put("_passportGbr_town", "Liverpool");
			
			// passport  other details for preprod
			
			put("select_passport", "1");
			put("preprod_passport_num1", "708649312");
			put("preprod_passport_num2", "6");
			put("preprod_passport_num3", "GBR");
			put("preprod_passport_num4", "6510204");
			put("preprod_passport_num5", "M");
			put("preprod_passport_num6", "1502246");			
			put("preprod_passport_num7", "<<<<<<<<<<<<<<");
			put("preprod_passport_num8", "0");
			put("preprod_passport_num9", "2");
			put("preprod_passport_exp_day", "24");
			put("preprod_passport_exp_mon", "February");
			put("preprod_passport_exp_year", "2015");
			put("preprod_passport_dob_day", "20");
			put("preprod_passport_dob_mon", "October");
			put("preprod_passport_dob_year", "1965");
			put("preprod_passport_gender", "Male");
			put("preprod_passport_sal_name", "Mr");
			put("preprod_passport_firstname", "Martyn");
			put("preprod_passport_lastname", "Hunter");
			put("preprod_passport_describes_u", "1");
			put("preprod_passport_postcode", "OL2 8SJ");
			put("preprod_passport_property", "Rose Cottage");
			put("preprod_passport_street", "Hesketh Avenue");
			put("preprod_passport_town", "Shaw");
			
			// passport  GBR details for preprod
			
			put("preprod_passportGbr_num1", "2986543702");
			put("preprod_passportGbr_num2", "GBR");
			put("preprod_passportGbr_num3", "6304065");
			put("preprod_passportGbr_num4", "M");
			put("preprod_passportGbr_num5", "1606063");
		    put("preprod_passportGbr_num6", "06");			
			put("preprod_passportGbr_exp_day", "06");
			put("preprod_passportGbr_exp_mon", "June");
			put("preprod_passportGbr_exp_year", "2016");
			put("preprod_passportGbr_dob_day", "06");
			put("preprod_passportGbr_dob_mon", "April");
			put("preprod_passportGbr_dob_year", "1963");
			put("preprod_passportGbr_gender", "Male");
			put("preprod_passportGbr_sal_name", "Mr");
			put("preprod_passportGbr_firstname", "Barry");
			put("preprod_passportGbr_lastname", "Jenkins");
		    put("preprod_passportGbr_describes_u", "1");
			put("preprod_passportGbr_postcode", "SO300PY");
			put("preprod_passportGbr_property", "Rose Cottage");
			put("preprod_passportGbr_street", "Whitebeam Road");
			put("preprod_passportGbr_town", "Southampton");
									
			
			
			//ERROR MSGS 			
			put("_POSTCODE_ERRORMSG","Please enter your full postcode.");

					
		}
	};
	
	@SuppressWarnings("serial")
	public static HashMap<String, String> assertLookup = new HashMap<String, String>(){
		{
			
				put("BUSINESS_NAME_ERROR","Please enter your company name or \"self-employed\"");
				put("MOBILE_NUMBER_ERROR","Please enter a valid mobile phone number.");
				put("CONTACT_NAME_ERROR","Please enter a valid contact name.");
				put("EMAIL_ADDRESS_ERROR","Please enter a valid email address.");
				put("PASSWORD_ERROR","Please enter a password of 6 or more characters.");
				put("CONFIRM_PASSWORD_ERROR","Please enter a password of 6 or more characters.");
				put("TYPES_OF_BUSINESS_ERROR","Please tell us what type of business you have.");
				put("PEOPLE_IN_BUSINESS_ERROR","Please tell us how many people work in your business.");
				put("HEAR_US_ERROR","Please tell us how you heard about us.");
		}
	};
}