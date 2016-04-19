/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.newbuilds;

import java.util.HashMap;

/**
 * @author shabana.khanam
 *
 */
public class BuildXpathLocators {
		
	@SuppressWarnings("serial")
	public static HashMap<String, String> xpathLookup = new HashMap<String, String>(){
		{
			put("ROOMS_EXTENSION",".//*[@id='descExtension']/div[1]/div/label");
			put("ROOMS_EXTENSION_OPTIONS",".//*[@id='descExtension']/div[2]/div[3]/label");
			put("FLOOR_EXTENSION",".//*[@id='descExtension']/div[3]/div/label");
			put("ARCHITECTURAL_PLANS",".//*[@id='descExtension']/div[4]/div/label");
			put("PERMISSION",".//*[@id='descExtension']/div[5]/div/label");
			put("REGULATIONS",".//*[@id='descExtension']/div[6]/div/label");
			put("LISTED_BUILDING",".//*[@id='descExtension']/div[7]/div/label");
			//LOFT CONVERSION
			put("TYPE_CONVERSION",".//*[@id='descLoftConversion']/div[1]/div/div/label");
			put("ROOM_CONVERSION",".//*[@id='descLoftConversion']/div[2]/div[3]/div/label");
			put("ARCHITECTURAL_CONVERSION",".//*[@id='descLoftConversion']/div[3]/div/label");
			put("PLAN_PERM_CONVERSION",".//*[@id='descLoftConversion']/div[4]/div/label");
			put("REGULATION_CONVERSION",".//*[@id='descLoftConversion']/div[5]/div/label");
			put("LIST_BUILD_CONVERSION",".//*[@id='descLoftConversion']/div[6]/div/label");
			//GARAGE CONVERSION
			put("ROOM_GARAGE",".//*[@id='descGarageConversion']/div[1]/div[3]/div/label");
			put("ARCHITECTURAL_GARAGE",".//*[@id='descGarageConversion']/div[2]/div/label");
			put("PLAN_PERM_GARAGE",".//*[@id='descGarageConversion']/div[3]/div/label");
			put("REGULATION_GARAGE",".//*[@id='descGarageConversion']/div[4]/div/label");
			//GARAGE CONSTRUCTION
			put("STATUS",".//*[@id='stage2']/div[1]/div/label");
			put("OWNERSHIP",".//*[@id='stage2']/div[2]/div/label");
			put("TIMING",".//*[@id='timeframe']/div/label");
			put("ARCHICHECTURAL_CONSTRUCTION",".//*[@id='stage2']/div[4]/div/label");
			put("PLAN_PERM_CONSTRUCTION",".//*[@id='stage2']/div[5]/div/label");
			put("REGULATION_CONSTRUCTION",".//*[@id='stage2']/div[6]/div/label");
			put("POSTCODE",".//*[@id='stage2']/div[7]/div/label");
			put("POSTCODE_SE",".//*[@id='stage2']/div[4]/div/label");
			put("POSTCODE_EXT",".//*[@id='stage2']/div[5]/div/label");
			put("ADDITIONAL_DETAILS",".//*[@id='additionalDetailsContainer']/div/label");
			// BUDGET
			put("BUDGET_XPATH",".//*[@id='stage3']/div[1]/div[2]/label");
			//Contact
			put("FNAME",".//*[@id='contact']/div[1]/label[2]");
			put("LNAME",".//*[@id='contact']/div[2]/label[2]");
			put("PHONENUMBER",".//*[@id='contact']/div[3]/div/label");
			put("EMAIL",".//*[@id='contact']/div[4]/div/label");
			put("FIRSTNAME_ERRORMSG",".//*[@id='contact']/div[1]/label[2]");
			put("LASTNAME_ERRORMSG",".//*[@id='contact']/div[2]/label[2]");	
			put("PHONENUMBER_ERRORMSG",".//*[@id='contact']/div[3]/div/label");
		    put("CONFIRMPHONENUMBER_ERRORMSG",".//*[@id='contact']/div[4]/label[2]");
			put("EMAIL_ERRORMSG",".//*[@id='contact']/div[5]/div/label");
			put("CONFIRMEMAIL_ERRORMSG",".//*[@id='contact']/div[6]/label[2]");


			//SERVICE OPTIONS
			put("EXTENSION","radioExtension");
			put("LOFT_CONVERSION","radioLoftConversion");
			put("GARAGE_CONVERSION","radioGarageConversion");
			put("GARAGE_CONSTRUCTION","radioGarageConstruction");
			put("OUTBUILDING_CONSTRUCTION","radioOutbuildingConstruction");
			put("SOMETHING_ELSE","radioElse");
			
			put("RECOMMEND_SERVICES",".//*[@id='skill-specifc-portable-jobform']/div/section[2]/h2");
			put("CLICKON_FACEBOOKICON",".//*[@id='RL_ACCOUNT']/div[1]");
			
			put("PROPERTY_STYLE",".//*[@id='styleOfProperty']/div/label");
			
			

            put("TEXTUNDERTHANKYOU_XPATH" , ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/p[1]"); 
			put("WHATHAPPENSNEXTONE_XPATH",".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[1]"); 
			put("WHATHAPPENSNEXTTWO_XPATH" , ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[2]");
			put("WHATHAPPENSNEXTTHREE_XPATH", ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[3]");

			
			
		
		}
	};
	
	@SuppressWarnings("serial")
		public static  HashMap<String, String> assertLookup = new HashMap<String, String>(){
			{
				put("ROOMS_EXTENSION_MSG","Select the number of rooms");
				put("ROOMS_EXTENSION_OPTIONS_MSG","Select what the rooms are to be used for");
				put("FLOOR_EXTENSION_MSG","Select how many floors the extension is to have");
				put("ARCHITECTURAL_PLANS_MSG","Select whether architectural plans have been drawn up");
				put("PERMISSION_MSG","Select the planning permission status of this job");
				put("REGULATIONS_MSG","Select the building regulations status of this job");
				put("LISTED_BUILDING_MSG","Select whether the property is listed or not");
				//LOFT CONVERSION
				put("TYPE_CONVERSION_MSG","Select a conversion");
				put("ROOM_CONVERSION_MSG","At least one option needs to be selected");
				//GARAGE CONVERSION
				put("ROOM_GARAGE_MSG","At least one option needs to be selected");
				//GARAGE CONSTRUCTION
				put("STATUS_MSG","Select the appropriate status of the job");
				put("OWNERSHIP_MSG","Select your ownership status");
				put("TIMING_MSG","Select when you want the job to start");
				put("POSTCODE_MSG","Enter a postcode");
				put("ADDITIONAL_DETAILS_MSG","Enter additional details about your job");
				put("BUDGET_MSG","Select an approximate budget");
				put("FIRSTNAME_ERRORMSGTEXT","Please enter your first name");
				put("LASTNAME_ERRORMSGTEXT","Please enter your last name");		
				put("PHONENUMBER_ERRORMSGTEXT","Please enter your phone number"); 
				put("CONFIRMPHONENUMBER_ERRORMSGTEXT","Please confirm your phone number");
				put("EMAIL_ERRORMSGTEXT","Please enter your email address");
				put("CONFIRMEMAIL_ERRORMSGTEXT","Please confirm your email address");
				put("PROPERTY_STYLE_MSG","Select the property style");
				put("RECOMMEND_SERVICESTEXT","Recommend Rated People to your friends");
				
			}
		};
		
		
		@SuppressWarnings("serial")
		public static HashMap<String, String> dataLookup = new HashMap<String, String>(){
			{
				put("JOB_STATUS_ID","statusREADY_TO_HIRE");
				put("OWNERSHIP_STATUS_ID","ownerLANDLORD");
				put("TIMING","URGENTLY");
				put("POSTCODE","SW1E6AU");
				put("BUDGET","10_LT_250");
				put("BUDGET_SOMETHINGELSE","9_LT_250");
				put("FIRSTNAME","Andy");
				put("LASTNAME","Green");
				put("PHONE_NUMBER","01234567890");
				put("EMAIL","a@mail.com");	
                put("TEXTUNDERTHANKYOU_TEXT" , "Your job has been successfully submitted for review and will be shared with tradesmen shortly. We have sent you an email with your password for Rated People. Keep it safe and use it to log in to your account. If this is not your first job posted with us, you should already have your password.");
			    put("WHATHAPPENSNEXTONE_TEXT" , "Tradesmen will review your job details");
			    put("WHATHAPPENSNEXTTWO_TEXT" , "Up to three interested tradesmen will pay to contact you");
			    put("WHATHAPPENSNEXTTHREE_TEXT" , "We'll send you an email and SMS with their profile(s) and ratings");
				put("","");
				put("","");
				put("","");
				put("","");
				put("","");
				put("","");
				put("","");
				put("","");
				put("","");
				put("","");
				put("","");
				put("","");
				put("","");
			}
		};

}
