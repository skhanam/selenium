package uk.co.ratedpeople.test.functional.selenium.requestCallBackAndRating;

import java.util.HashMap;
import java.util.Map;


public class RalXpathlocators {
	
	@SuppressWarnings("serial")
	public static  Map<String,String> xpathLookup =new HashMap<String, String>()
	{
		{
			
			
			put("VIEW_FULL_DETAILS","//html/body/div[2]/div/div[3]/div[3]/div/div[2]/ol/li[2]/div/p[2]/a");
			put("BUY_BUTTON","buy-btn");
			put("CONFIRM_BUTTON","//html/body/div[2]/div/div[4]/aside/div[3]/form/p/a");
			put("MAIL_CONTACT_INFO","//*[text()='Contact Info']");
			put("JOB_DESCRIPTION","//html/body/div[2]/div/div[4]/section/div/h1");
			put("TERMS_AND_CONDITIONS","//html/body/div[3]/p/h2");
			put("TANDC_CHECKBOX","//*[@id='terms-and-condition-check-box']");
			put("TANDC_ACCEPT_OK","//*[@id='accept-terms-and-condition']");
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
			put("CALL_BACK_REQUESTED_Date","//html/body/div[2]/div/div[4]/aside/span[3]/div/p/strong");
			
			put("SEARCH_TEXT_AREA","search_search");
			put("GO_BUTTON","//*[@id='standardSearch']");
			//put("SELECT_FROM_SEARCH",".//html/body/div/div/div[2]/div/table/tbody/tr[4]/td/a");
			put("H0_EMAIL_SENT_BUTTON",".//*[@id='subnav']/ul/li[4]/a");
			put("LAST_JOB_LINK","//html/body/div/div/div[3]/div/div/table/tbody/tr[2]/td[2]/a");
			//put("TM_EMAIL_SENT_BUTTON",".//*[@id='subnav']/ul/li[5]/a");
			put("CHECK_SMS","//html/body/div/nav/ul/li[5]/a");
			put("HO_CALL_BACK_SMS","//html/body/div/div/div[3]/div/div/table/tbody/tr[2]/td[4]");
			
			put("EMAIL","email");
			put("CONFIRMEMAIL","confirmEmail");
									
		}
	};
	
	@SuppressWarnings("serial")
	public static Map<String,String> dataLookup=new HashMap<String,String>() {
		{
			put("TMEMAIL","raluser_02@ratedtrades.com");	
			put("PASSWORD","password");
			put("TM_NAME","Tradesman Email :");
			put("ADMIN_EMAIL","aaron.barwell@ratedpeople.com");
			put("HOEMAIL","ruhhomeowner@ratedtrades.com");
			put("CONFIRMHOEMAIL","ruhhomeowner@ratedtrades.com");
		}
	}; 
	
}
