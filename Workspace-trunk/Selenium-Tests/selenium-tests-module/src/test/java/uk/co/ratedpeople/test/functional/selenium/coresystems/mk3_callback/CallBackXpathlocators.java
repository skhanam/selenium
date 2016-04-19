package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_callback;

import java.util.HashMap;
import java.util.Map;

public class CallBackXpathlocators {	
	
	@SuppressWarnings("serial")
	public static Map<String, String> xpathLookup = new HashMap<String, String>() {
		
		{	//Tm login page xpath and id values	
			put("VIEW_FULL_DETAILS","View full details");
			put("BUY_BUTTON","buy-btn");
			put("CONFIRM_BUTTON","//html/body/div/div/div[4]/aside/div[3]/form/p/a");
			put("MAIL_CONTACT_INFO","//*[text()='Contact Info']");
			
			//mk3 login xpath and id values
			put("SEARCH_TEXT_AREA","search_search");
			put("GO_BUTTON","standardSearch");
			put("H0_EMAIL_SENT_BUTTON",".//*[@id='subnav']/ul/li[4]/a");
			
			//on callback page
			put("CALLBACKJOB_DESCRIPTION",".//*[@id='bodyContent']/div/div[1]/table/tbody/tr[1]/td[3]");
		//	put("TM_CALLBACKS_BUTTON",".//*[@id='subnav']/ul/li[18]/a");
			put("TM_CALLBACKS_BUTTON","Call Backs");
			put("CREDITED_JOB_STATUS",".//*[@id='bodyContent']/div/div[1]/table/tbody/tr[1]/td[1]");
			
			//mk3 id and values on purchase screen
			put("TM_PURCHASED_JOBS",".//*[@id='subnav']/ul/li[3]/a");
			put("MORE_BUTTON",".//*[@id='quote_0']");
			put("PHONE_CHECKBOX",".//*[@id='invalidPhone']");
			put("EMAIL_CHECKBOX",".//*[@id='invalidEmail']");
			put("CREDITJOB_BUTTON",".//*[@id='quote__goodwillCredit']");
			put("SPECIAL_CREDIT","userInfo-creditBalance");
			put("PAYMENT_DEATILS",".//*[@id='subnav']/ul/li[10]/a");
			
			//ho login  xpath and id values
			put("FIRST_NAME",".//*[@id='firstName']");
			put("LAST_NAME",".//*[@id='lastName']");
			put("MOBILE",".//*[@id='mobilePhone']");
			put("CONFIRM_MOBILE",".//*[@id='confirmPhone']");
			put("EMAIL",".//*[@id='email']");
			put("CONFIRM_EMAIL",".//*[@id='confirmEmail']");
			put("PASSWORD","tpPassword");
			put("POSTCODE",".//*[@id='btnPostJob']");
			put("CONFIRM_POSTJOB",".//*[@id='btnConfirmJob']");
			put("JOB_DESCRIPTION",".//*[@id='additionalDetailsContainer']/textarea");
			put("HEADER_THANKYOU",".//*[@id='header-h1']");			

			//Tm Ral
			put("PURCHASED_JOBS",".//*[@id='header-wrapper']/div[2]/nav/ul/li[2]/a");
			put("VIEW_DETAILS","//html/body/div[2]/div/div[3]/section/table/tbody/tr[2]/td[5]/a");
			put("UNABLE_TO_QUOTE","//html/body/div[2]/div/div[4]/aside/span[3]/p/a");
			put("STEP1_OF_3","//html/body/div[2]/div/div[4]/aside/span[3]/div/p");
			put("NEXT_STEP1","//html/body/div[2]/div/div[4]/aside/span[3]/div[2]/a");
			put("STEP2_OF_3","//html/body/div[2]/div/div[4]/aside/span[3]/form/div/p");
			put("CHECK_ATLEAST_ONE","//html/body/div[2]/div/div[4]/aside/span[3]/form/div/p/strong");
			
			put("CHECK_BOX1","//*[@id='UNABLE_TO_CONTACT']");
			put("NEXT_STEP2","//html/body/div[2]/div/div[4]/aside/span[3]/form/div[2]/button");
			put("STEP3_OF_3","//html/body/div[2]/div/div[4]/aside/span[3]/form/div/p/strong");
			put("SHOULD_ACCEPT_ALL_CONDITIONS","//html/body/div[2]/div/div[4]/aside/span[3]/form/div/p/strong");
			
			put("CONDITION_1","//*[@id='0']");
			put("CONDITION_2","//*[@id='1']");
			put("CONDITION_3","//*[@id='2']");
			put("CREDIT_REQUESTED_DATE_CHECK","//html/body/div[2]/div/div[3]/section/table/tbody/tr[2]/td[4]");
			
			put("RAL_SEPT_1","//html/body/div[2]/div/div[4]/aside/span[3]/div[1]/h3");
			put("RAL_SEPT_2","//html/body/div[2]/div/div[4]/aside/span[3]/form/div/h3");
			put("CANCEL","//html/body/div[2]/div/div[4]/aside/span[3]/form/div[2]/button[2]");
			put("CALL_BACK_REQUESTED","//html/body/div[2]/div/div[4]/aside/span[3]/div/p");
			
		}		
	};
	
	@SuppressWarnings("serial")
	public static Map<String, String> dataLookup = new HashMap<String, String>() {
		{
			put("FIRST_NAME", "fname");
			put("LAST_NAME", "lname");
			put("MOBILE", "07512000123");
			put("CONFIRM_MOBILE", "07512000123");
			put("EMAIL", "ruhulla2014@ratedtrades.com");
			put("CONFIRM_EMAIL", "ruhulla2014@ratedtrades.com");
			put("HEADER_TEXT", "Thank you");
			put("POSTCODE", "ha02lh");
			put("TMEMAIL","selenium.ralmk3user-CSU@ratedtrades.com");
			put("ADMIN_EMAIL","sangeetha.kumar@ratedpeople.com");
			put("PASSWORD","password");
			put("DESCRIPTION","selenium test : tree surgeon specialist.");
			put("JOB_STATUS","Credited");
					
		}
	};
		
}