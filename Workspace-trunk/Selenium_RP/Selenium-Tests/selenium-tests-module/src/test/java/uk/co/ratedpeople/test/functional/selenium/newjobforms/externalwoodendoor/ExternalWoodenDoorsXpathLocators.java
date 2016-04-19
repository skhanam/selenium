package uk.co.ratedpeople.test.functional.selenium.newjobforms.externalwoodendoor;


/**
 * @author danthalapalli.aravind
 * 
 */
import java.util.HashMap;
import java.util.Map;

public class ExternalWoodenDoorsXpathLocators {

	
	
	
	@SuppressWarnings("serial")
	public static Map<String, String> xpathLookup = new HashMap<String, String>() {
		
		{
	
			put("REPAIR_DOOR_PAINT","repairDoorPaint");
			put("REPAIR_DOOR_HANDLES","repairDoorHandles");
			put("REPAIR_DOOR_HINGES","repairDoorHinges");
			put("REPAIR_RADIO_BTN","radioRepair");
			put("REPAIR_GLAZED","repairGlazed");
			put("REPAIR_OTHER","repairOther");
			put("REPAIR_DOOROTHER","repairDoorOther");		//additional info
			put("REPAIR_PROPERTY_STYLE","704");
			put("REPLACE_PROPERTY_STYLE","724");
			put("IM_READY_TO_HIRE_RADIO_BTN","statusREADY_TO_HIRE");
			put("OWNER_OWN_AND_LIVE_RADIO_BTN","ownerOWN_AND_LIVE");
		    put("URGENTLY","URGENTLY");
		    put("POSTCODE","AL48TD");
		    put("ADDITIONAL_DETAILS","additional info additional info additional info additional info additional info additional info additional info additional info");
		    put("BUDGET_LT_500","127_LT_500");
		    put("FIRST_NAME","rapchik");
		    put("LAST_NAME","dude");
			
		    put("PHONE_NUMBER","07512000000");
		    put("EMAIL_ADDRESS","jhonjhon@gmail.com");
		    
		    //replace
		    put("REPLACE_RADIO_BTN","radioReplace");
		    put("REPLACE_DOOR_BRICKWORK","replaceDoorBrickwork");
		    put("REPLACE_DOOR_GLASS","replaceDoorGlass");
		    put("REPLACE_BIFOLD","replaceBiFold");
		    put("REPLACE_SUPPLY_DOORS_YES","replaceSupplyDoorsYes");
		    put("REPLACE_SUPPLY_FITTINGS_NO","replaceSupplyFittingsNo");
		    put("REPLACE_OTHER","replaceOther");
		    put("REPLACE_DOOROTHER","replaceDoorOther");
		    put("REPLACE_PROPERTY_STYLE", "724");
		    put("IM_READY_TO_HIRE_RADIO_BTN","statusREADY_TO_HIRE");
		    put("OWNER_OWN_AND_LIVE_RADIO_BTN","ownerOWN_AND_LIVE");
		    put("URGENTLY", "URGENTLY");
		    put("POSTCODE","AL48TD");
		    put("ADDITIONAL_DETAILS","THIS PHASE IS CALLED TESTING is what about ");
		    put("BUDGET_LT_1000","127_LT_1000");
		    put("FIRST_NAME","sam");
		    put("LAST_NAME","juliet");
		    put("PHONE_NUMBER","07512000000");
		    put("EMAIL_ADDRESS","php@gmail.com");
		    
		    //replace or install fittings
		    put("FITTINGS_RADIO_BTN","radioFittings");
		    put("FITTINGS_LETTERBOXES","fittingsLetterboxes");
		    put("FITTINGS_PAGE1_NEXT_BUTTON_XPATH",".//*[@id='nextDescFittings']");	
		    put("FITTINGS_SUPPLY_FITTINGS_YES","fittingsSupplyFittingsYes");
		    put("FITTINGS_OTHER","fittingsOther");		   
		    put("FITTINGS_PROPERTY_STYLE","743");
		    
		    //install security fittings
		    put("SECURITY_RADIO_BTN","radioSecurity");
		    put("SECURITY_BOLTS","securityBolts");
		    put("SECURITY_SUPPLY_FITTINGS_YES","securitySupplyFittingsYes");
		    put("SECURITY_PAGE1_NEXT_BUTTON_XPATH",".//*[@id='nextDescSecurity']");
		    put("SECURITY_PROPERTY_STYLE","758");
		    put("SECURITY_OTHER","securityOther");
		    
		    //somethingelse
		    put("SOMETHING_ELSE_RADIO_BTN","radioElse");
		    put("SOMETHING_ELSE_PROPERTY_STYLE","764");
		 
            put("RECOMMEND_SERVICES",".//*[@id='skill-specifc-portable-jobform']/div/section[2]/h2");
            put("CLICKON_FACEBOOKICON",".//*[@id='RL_ACCOUNT']/div[1]");


            put("RECOMMEND_SERVICESTEXT","Recommend Rated People to your friends");
            
            put("TEXTUNDERTHANKYOU_XPATH" , ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/p[1]"); 
			put("WHATHAPPENSNEXTONE_XPATH",".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[1]"); 
			put("WHATHAPPENSNEXTTWO_XPATH" , ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[2]");
			put("WHATHAPPENSNEXTTHREE_XPATH", ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[3]");
		    		    
		}
		
		
	};
	
	@SuppressWarnings("serial")
	public static HashMap<String, String> dataLookup = new HashMap<String, String>(){
		{
			  // put("TEXTUNDERTHANKYOU_TEXT" , "Your job has been successfully submitted for review and will be shared with tradesmen shortly.");
			   put("TEXTUNDERTHANKYOU_TEXT" , "Your job has been successfully submitted for review and will be shared with tradesmen shortly. We have sent you an email with your password for Rated People. Keep it safe and use it to log in to your account. If this is not your first job posted with us, you should already have your password.");
			   put("WHATHAPPENSNEXTONE_TEXT" , "Tradesmen will review your job details");
			   put("WHATHAPPENSNEXTTWO_TEXT" , "Up to three interested tradesmen will pay to contact you");
			   put("WHATHAPPENSNEXTTHREE_TEXT" , "We'll send you an email and SMS with their profile(s) and ratings");

		}
	};
}
