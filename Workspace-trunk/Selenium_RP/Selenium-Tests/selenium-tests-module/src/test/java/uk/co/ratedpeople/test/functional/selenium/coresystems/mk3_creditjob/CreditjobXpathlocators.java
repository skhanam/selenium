package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_creditjob;

import java.util.HashMap;
import java.util.Map;

public class CreditjobXpathlocators {
	
	@SuppressWarnings("serial")
	public static  Map<String,String> xpathLookup =new HashMap<String, String>()
	{
		{
			put("VIEW_FULL_DETAILS","//html/body/div/div/div/div/div/div[2]/ol/li[2]/p[2]/a");
			put("BUY_BUTTON","buy-btn");
			put("CONFIRM_BUTTON","//html/body/div/div/div[4]/aside/div[3]/form/p/a");
			put("MAIL_CONTACT_INFO","//*[text()='Contact Info']");
			put("SEARCH_TEXT_AREA","search_search");
			put("GO_BUTTON",".//*[@id='standardSearch']");
			put("H0_EMAIL_SENT_BUTTON",".//*[@id='subnav']/ul/li[4]/a");
			put("LOAD",".//*[@id='bodyContent']/div/table/tbody/tr[3]/td[2]/a");
			put("LAST_JOB_LINK",".//*[@id='bodyContent']/div/table/tbody/tr[2]/td[2]/a");
			put("MAIL_CONTENT",".//*[@id='bodyContent']/div[1]/div/p/code");
			put("TM_EMAIL_SENT_BUTTON",".//*[@id='subnav']/ul/li[5]/a");
			
			put("TM_PURCHASED_JOBS",".//*[@id='subnav']/ul/li[3]/a");
			put("MORE_BUTTON",".//*[@id='quote_0']");
			put("PHONE_CHECKBOX",".//*[@id='invalidPhone']");
			put("EMAIL_CHECKBOX",".//*[@id='invalidEmail']");
			put("CREDITJOB_BUTTON",".//*[@id='quote__goodwillCredit']");
			put("SPECIAL_CREDIT","userInfo-creditBalance");
			put("PAYMENT_DEATILS",".//*[@id='subnav']/ul/li[10]/a");
			
		}
	};
	
	@SuppressWarnings("serial")
	public static Map<String,String> dataLookup=new HashMap<String,String>() {
		{
			put("HOEMAIL","seleniumho@ratedpeople.com");
			put("TMEMAIL","165014-28-Nov-2013-CSU@ratedtrades.com");
			put("TM_NAME","Tradesman Email :");
			put("ADMIN_EMAIL","sangeetha.kumar@ratedpeople.com");
			put("PASSWORD","password");
			put("DESCRIPTION","Submit a job via selenium tests : Full regression testing");
			put("OUTPUT_RESULT","selenium tests");
		}
	}; 
	
}

