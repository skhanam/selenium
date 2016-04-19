package uk.co.ratedpeople.test.functional.selenium.newjobforms.flatroofs;

/**
 * @author danthalapalli.aravind
 * 
 */
import java.util.HashMap;
import java.util.Map;


public class FlatRoofsXpathLocators {
	
	
	@SuppressWarnings("serial")
	public static Map<String, String> xpathLookup = new HashMap<String, String>() {
		
		{
			//REPLACE
			put("REPLACE_EXTENSION","replaceExtension");
			put("REPLACE_DORMER","replaceDormer");
			put("REPLACE_RADIO_BTN","radioReplace");
			put("REPLACE_SECTION_ROOF","replaceSectionRoof");
			put("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY","465");
			put("REPLACE_OTHER","replaceOther");
			put("REPLACE_PROPERTY_TYPE","468");
			put("REPLACE_PROPERTY_STYLE","476");
			put("REPLACE_BEDROOMS","repalceBedrooms");
			put("IM_READY_TO_HIRE_RADIO_BTN","statusREADY_TO_HIRE");
			put("OWNER_OWN_AND_LIVE_RADIO_BTN","ownerOWN_AND_LIVE");
			put("URGENTLY","URGENTLY");
			put("POSTCODE","AL48TD");
			put("ADDITIONAL_DETAILS","additional info additional info additional info additional info additional info additional info additional info additional info");
			put("BUDGET_LT_500","98_LT_500");
			put("FIRST_NAME","chinodu");
			put("LAST_NAME","pedodu");
			put("PHONE_NUMBER","07427555666");
			put("EMAIL_ADDRESS","rupa@gmail.com");
			//REPAIR
			put("REPAIR_ROOF_WORN","repairRoofWorn");
			put("REPAIR_ROOF_WATER","repairRoofWater");
			put("REPAIR_MAIN","repairMain");
			put("REPAIR_BAY","repairBay");
			put("REPAIR_RADIO_BTN","radioRepair");
			put("REPAIR_SECTION_ROOF","repairSectionRoof");
			put("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY","493");
			put("REPAIRROOF_OTHER","repairRoofOther");
			put("REPAIR_OTHER","repairOther");
			put("REPAIR_PROPERTY_TYPE","497");
			put("REPAIR_PROPERTY_STYLE","503");
			//REPAIRLEAK
			put("FIND_REPAIR_LEAK_RADIO_BTN","radioRepairLeak");
			put("FIND_REPAIR_LEAK_PROPERTY_TYPE","508");
			put("FIND_REPAIR_LEAK_PROPERTY_STYLE","516");
			
		//somethingelse
			
			put("SOMETHING_ELSE_RADIO_BTN","radioElse");
			put("SOMETHING_ELSE_PROPERTY_TYPE","520"); 
			put("SOMETHING_ELSE_PROPERTY_STYLE","528");
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
				   put("TEXTUNDERTHANKYOU_TEXT" , "Your job has been successfully submitted for review and will be shared with tradesmen shortly. We have sent you an email with your password for Rated People. Keep it safe and use it to log in to your account. If this is not your first job posted with us, you should already have your password.");   
				   //put("TEXTUNDERTHANKYOU_TEXT" , "Your job has been successfully submitted for review and will be shared with tradesmen shortly.");
				   put("WHATHAPPENSNEXTONE_TEXT" , "Tradesmen will review your job details");
				   put("WHATHAPPENSNEXTTWO_TEXT" , "Up to three interested tradesmen will pay to contact you");
				   put("WHATHAPPENSNEXTTHREE_TEXT" , "We'll send you an email and SMS with their profile(s) and ratings");

			}
		};

}
