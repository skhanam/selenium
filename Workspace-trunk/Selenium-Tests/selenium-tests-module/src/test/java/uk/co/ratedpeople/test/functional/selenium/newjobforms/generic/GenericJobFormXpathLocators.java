package uk.co.ratedpeople.test.functional.selenium.newjobforms.generic;

import java.util.HashMap;
import java.util.Map;

public class GenericJobFormXpathLocators {
	
	
	@SuppressWarnings("serial")
	public static Map<String, String> xpathLookup = new HashMap<String, String>() {
		{
			//Job details 
			put("pcode", "postcode");
			put("nextquotes","btn-next-step");
			put("timing",".//*[@id='stage2']/div[3]/select[@id='timing']");
			put("textareaadditionalinfo",".//*[@id='stage2']/div[5]/textarea");
			put("intent",".//*[@id='stage2']/div[1]/ul/li");
			put("ownership",".//*[@id='stage2']/div[2]/ul/li");
			put("stagetwonext",".//*[@id='stage2']/div[6]/div/button[1]");
			//budget 
			put("budget",".//*[@id='stage3']/div[1]/select[@id='jobBudgetCode']");
			//stage3 next & back
			put("stagethreenext",".//*[@id='stage3']/div[2]/div/button[1]");
			put("stagethreeback",".//*[@id='stage3']/div[2]/div/button[2]");
			//location and contact
			put("fname",".//*[@id='firstName']");
			put("lname",".//*[@id='lastName']");
			put("mobile",".//*[@id='mobilePhone']");
			put("email",".//*[@id='email']");
			put("postjob",".//*[@id='btnPostJob']");
			put("headerthanku",".//*[@id='header-h1']");
			}
		};
			

		
		@SuppressWarnings("serial")
		public static Map<String,String> mesglocators = new HashMap<String, String>(){{
			put("trade","Select a trade");
			put("jobtype","Select a job type");
				
		}};
}
