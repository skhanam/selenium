package uk.co.ratedpeople.test.functional.selenium.coresystems.pricing;

import java.util.HashMap;
import java.util.Map;

public class PricingXpathlocators {	
	
	@SuppressWarnings("serial")
	public static Map<String, String> xpathLookup = new HashMap<String, String>() {
		
		{		
			put("JOB1_VIEW_FULL_DETAILS_XPATH",".//*[@id='jobAlertsTable']/ol/li[4]/div/p[2]/a");
			put("JOB2_VIEW_FULL_DETAILS_XPATH",".//*[@id='jobAlertsTable']/ol/li[3]/div/p[2]/a");
			put("JOB3_VIEW_FULL_DETAILS_XPATH",".//*[@id='jobAlertsTable']/ol/li[2]/div/p[2]/a");
			//put("JOB1_VIEW_FULL_DETAILS_XPATH","html/body/div[2]/div/div[3]/div[3]/div[1]/div[2]/ol/li[4]/div/p[2]/a"); 
			put("JOB_PRICE",".//*[@id='buy-panel']/h3[2]");
			//put("JOB_LEADS",".//*[@id='header-wrapper']/div[2]/nav/ul/li[1]/a");	
			put("JOB_LEADS","html/body/div[2]/header/div/div[2]/nav/ul/li[1]/a");
			put("FIRST_NAME",".//*[@id='firstName']");
			put("LAST_NAME",".//*[@id='lastName']");
			put("MOBILE",".//*[@id='mobilePhone']");
			put("CONFIRM_MOBILE",".//*[@id='confirmPhone']");
			put("EMAIL",".//*[@id='email']");
			put("CONFIRM_EMAIL",".//*[@id='confirmEmail']");
			put("PASSWORD","tpPassword");
			put("POSTJOB",".//*[@id='btnPostJob']");
			put("HEADER_ALMOST",".//*[@id='contentLightBox']/div[2]/h1");
			put("CONFIRM_POSTJOB",".//*[@id='btnConfirmJob']");
			put("JOB_DESCRIPTION",".//*[@id='additionalDetailsContainer']/textarea");
			put("HEADER_THANKYOU","header-h1");			
		}		
	};
	
	@SuppressWarnings("serial")
	public static Map<String, String> dataLookup = new HashMap<String, String>() {
		{
			put("FIRST_NAME", "fname");
			put("LAST_NAME", "lname");
			put("MOBILE", "07512000000");
			put("CONFIRM_MOBILE", "07512000000");
			put("EMAIL", "shobha99@gmail.com");
			put("CONFIRM_EMAIL", "shobha99@gmail.com");
			put("HEADER_TEXT", "Thank you");
			put("ALMOST_DONE","Almost done ...");
			put("POSTCODE", "ha02lh");
			put("EMAIL1","sangitm2@ratedtrades.com");
			put("EMAIL2","sangitm4@ratedtrades.com");
			put("EMAIL3","111928-11-Jul-2013-jbilling@ratedtrades.com");
			put("EMAIL4","sangitmtimingpayg@ratedtrades.com");
			put("EMAIL5","seleniumpaygpsti@ratedtrades.com");
			put("EMAIL6","seleniumstdpsti@ratedtrades.com");
			put("PASSWORD","password");
		}
	};
		
}