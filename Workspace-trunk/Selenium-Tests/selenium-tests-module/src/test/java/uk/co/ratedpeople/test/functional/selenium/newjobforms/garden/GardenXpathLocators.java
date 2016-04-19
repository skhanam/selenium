/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.garden;

import java.util.HashMap;

import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author shabana.khanam
 *
 */
public class GardenXpathLocators {
	

	@SuppressWarnings("serial")
	public static HashMap<String, String> xpathLookup = new HashMap<String, String>(){
		{
			
				put("CLEARENCE_MAINTANANCE_YES","clearanceMaintainanceYes");
				put("CLEARANCE_LENGTH","833");
				put("LANDSCAPE_LENGTH","853");
				put("SOMETHING_ELSE_LENGTH","857");
				put("IM_READY_TO_HIRE_RADIO_BTN","statusREADY_TO_HIRE");
				put("OWNER_OWN_AND_LIVE_RADIO_BTN","ownerOWN_AND_LIVE");
				put("URGENTLY","URGENTLY");
				put("SOMETHING_ELSE_RADIO_BTN","radioElse");
				put("LANDSCAPE_RADIO_BTN","radioLandscaping");
				put("CLARANCE_RADIO_BTN","radioClearance");
				put("LANDSCAPE_WASTE_YES","landscapeMaintainanceYes");
				put("LANDSCAPE_LENGTH","853");
				put("CLEARENCE_MOWING","clearanceMowing");
				put("CLEARENCE_SHED","clearanceShed");
				put("LANDSCAPE_SEEDING","landscapeSeeding");
				put("LANDSCAPE_PLAY_AREA","landscapePlayArea");
				
				put("LENGTHGARDEN",".//*[@id='stage2']/div[1]/div/label");
				put("STATUSXPATH",".//*[@id='stage2']/div[2]/div/label");
				put("OWNERXPATH",".//*[@id='stage2']/div[3]/div/label");
				put("TIMINGXPATH",".//*[@id='timeframe']/div/label");
				put("POSTCODEXPATH",".//*[@id='stage2']/div[5]/div/label");
				put("DESCRIPTIONXPATH",".//*[@id='additionalDetailsContainer']/div/label");
				put("BUDGETXPATH",".//*[@id='stage3']/div[1]/div[2]/label");
				put("LANDSCAPINGBUDGETXPATH",".//*[@id='stage3']/div[1]/div[3]/label");
				put("LANDSCAPINGWORKXPATH",".//*[@id='descLandscaping']/div[1]/div[3]/label");
				put("MAINTENANCEXPATH",".//*[@id='descLandscaping']/div[2]/div/div/label");
				put("APPROXLENXPATH",".//*[@id='descLandscaping']/div[3]/div/label");
				put("LANDSCAPEOTHER","landscapeOther");
				put("LANSCAPEOTHERXPATH",".//*[@id='descLandscaping']/div[1]/div[2]/ul/li[8]/div/label");
				put("CLEARANCEXPATH",".//*[@id='descClearance']/div[1]/div[3]/label");
				put("WASTEDXPATH",".//*[@id='descClearance']/div[2]/div/div/label");
				put("WORKDONEXPATH",".//*[@id='descClearance']/div[3]/div/div/label");
				put("LENGTHCLEARANCEXPATH",".//*[@id='descClearance']/div[4]/div/label");
				put("CLEARENCE_WASTE_YES","clearanceWasteYes");
				put("BUDGETXPATHNEW",".//*[@id='stage3']/div[1]/div[3]/label");
				put("RECOMMEND_SERVICES",".//*[@id='skill-specifc-portable-jobform']/div/section[2]/h2");
				put("CLICKON_FACEBOOKICON",".//*[@id='RL_ACCOUNT']/div[1]");
				
				put("TEXTUNDERTHANKYOU_XPATH" , ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/p[1]"); 
				put("WHATHAPPENSNEXTONE_XPATH",".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[1]"); 
				put("WHATHAPPENSNEXTTWO_XPATH" , ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[2]");
				put("WHATHAPPENSNEXTTHREE_XPATH", ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[3]");
		
		}
	};
	
	
	
	@SuppressWarnings("serial")
	public static HashMap<String, String> dataLookup = new HashMap<String, String>(){
		{
			
				put("POSTCODE","AL48TD");
				put("BUDGET_LT_500","82_LT_500");
				put("BUDGET_LT_1000","82_LT_1000");
				put("PHONE_NUMBER","07512000000");
				put("EMAIL_ADDRESS",TestScriptUtilities.getRandomString(3) + "@ratedtrades.com");
				put("FIRST_NAME",TestScriptUtilities.getRandomString(3));
				put("LAST_NAME",TestScriptUtilities.getRandomString(3));
				

              // put("TEXTUNDERTHANKYOU_TEXT" , "Your job has been successfully submitted for review and will be shared with tradesmen shortly.");
			   put("TEXTUNDERTHANKYOU_TEXT" , "Your job has been successfully submitted for review and will be shared with tradesmen shortly. We have sent you an email with your password for Rated People. Keep it safe and use it to log in to your account. If this is not your first job posted with us, you should already have your password.");
			   put("WHATHAPPENSNEXTONE_TEXT" , "Tradesmen will review your job details");
			   put("WHATHAPPENSNEXTTWO_TEXT" , "Up to three interested tradesmen will pay to contact you");
			   put("WHATHAPPENSNEXTTHREE_TEXT" , "We'll send you an email and SMS with their profile(s) and ratings");

		}
	};
	
	
	@SuppressWarnings("serial")
	public static HashMap<String, String> assertLookup = new HashMap<String, String>(){
		{
			
				put("LENGTHGARDENMSG","Select the length of your garden");
				put("STATUSMSG","Select the appropriate status of the job");
				put("OWNERMSG","Select your ownership status");
				put("TIMINGMSG","Select when you want the job to start");
				put("POSTCODEMSG","Enter a postcode");
				put("DESCRIPTIONMSG","Enter additional details about your job");
				put("BUDGETMSG","Select an approximate budget");
				put("LANDSCAPINGMSG","At least one option needs to be selected");
				put("MAINTENANCEMSG","Select whether you require ongoing garden maintenance");
				put("APPROXLENGTHMSG","Select the length of your garden");
				put("OTHERMSG","List what landscaping work needs to be done");
				put("WASTEMSG","Select whether you need the tradesman to take care of waste disposal");
				put("RECOMMEND_SERVICESTEXT","Recommend Rated People to your friends");
		}
	};

}
