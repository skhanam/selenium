/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.slatetiledroofs;

import java.util.Hashtable;

import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author shabana.khanam
 *
 */
public class SlateTiledRoofsXpathlocators {
	
	
	
	@SuppressWarnings("serial")
	public static Hashtable<String, String> xpathLookup = new Hashtable<String, String>(){
		{
			put("pcode","postcode");
			put("nextquotes","btn-next-step");
			//jobdetails
			put("radioReplace",".//*[@id='radioReplace']");
			put("radioRepair",".//*[@id='radioRepair']");
			put("radioRepairLeak",".//*[@id='radioRepairLeak']");
			put("radioElse",".//*[@id='radioElse']");
			put("continuestage1",".//*[@id='stage1SelectButton']");
			put("backstage1",".//*[@id='relate']/div[3]/div/button[2]");
			
			//replace
			put("roofreplaced", ".//*[@id='descReplace']/div[1]/div[2]/ul/li");
			put("replaceSectionRoof",".//*[@id='replaceSectionRoof']");
			put("stageonereplaceback",".//*[@id='descReplace']/div[3]/button[1]");
			put("stageonereplacenext",".//*[@id='descReplace']/div[3]/button[2]");
			put("visibilityoptions",".//*[@id='descReplace']/div[1]/div[2]/ul/li");
			put("replaceintent",".//*[@id='stage2']/div[4]/ul/li");
			put("replaceownership",".//*[@id='stage2']/div[5]/ul/li");
			put("numberbedroompositive",".//*[@id='stage2']/div[3]/div[1]/ul/li/a[2]");
			put("numberbedroomnegative",".//*[@id='stage2']/div[3]/div[1]/ul/li/a[1]");
			//stage 2 next & back
			put("replacestagetwoback",".//*[@id='stage2']/div[9]/div/button[2]");
			put("replacestagetwonext",".//*[@id='stage2']/div[9]/div/button[1]");	
			
			//repair
			put("whichroofrepair",".//*[@id='descRepair']/div[1]/div[1]/ul/li");
			put("whereroofrepair",".//*[@id='descRepair']/div[2]/div[2]/ul/li");
			put("repairSectionRoof",".//*[@id='repairSectionRoof']");
			put("stageonerepairback",".//*[@id='descRepair']/div[4]/button[1]");
			put("stageonerepairnext",".//*[@id='descRepair']/div[4]/button[2]");
			put("repairintent",".//*[@id='stage2']/div[3]/ul/li");
			put("repairownership",".//*[@id='stage2']/div[4]/ul/li");
			//stage 2 next & back
			put("repairstagetwoback",".//*[@id='stage2']/div[8]/div/button[2]");
			put("repairstagetwonext",".//*[@id='stage2']/div[8]/div/button[1]");			
							
		
			//Additional Info somethingelse
			put("propertytype",".//*[@id='propertyType']");
			put("propertystyle",".//*[@id='propertyStyle']");
			put("timing",".//*[@id='timing']");
			put("postcode",".//*[@id='postcode']");
			put("textareaadditionalinfo",".//*[@id='additionalDetailsContainer']/textarea");
			
			
			//budget 
			put("budget",".//*[@id='jobBudgetCode']");
			put("otherbudget",".//*[@id='otherBudgetValue']");
			//stage3 next & back
			put("stagethreenext",".//*[@id='stage3']/div[2]/div/button[1]");
			put("stagethreeback",".//*[@id='stage3']/div[2]/div/button[2]");
			//location and contact
		
		
			
			put("fname",".//*[@id='firstName']");
			put("lname",".//*[@id='lastName']");
			put("mobile",".//*[@id='mobilePhone']");
			put("confirmphonenumber",".//*[@id='confirmPhone']");
			put("email",".//*[@id='email']");
			put("confirmemail",".//*[@id='confirmEmail']");
			put("postjob",".//*[@id='btnPostJob']");
			put("headerthanku",".//*[@id='header-h1']");
			
			put("roofsection_label",".//*[@id='descReplace']/div[1]/div[3]/label");
			put("highestsection_label",".//*[@id='replaceSection']/div/label");
			put("repairsection_label",".//*[@id='descRepair']/div[1]/div[1]/div/label");
			put("repair_roofsection_label",".//*[@id='descRepair']/div[2]/div[3]/label");
			put("repair_highestsection_label",".//*[@id='repairSection']/div/label");
			put("propertyTypelabel",".//*[@id='typeOfProperty']/div/label");
			put("propertstylelabel",".//*[@id='styleOfProperty']/div/label");
			put("numberbedrooms_label",".//*[@id='stage2']/div[3]/div[1]/div/div/label");
			put("status_label",".//*[@id='stage2']/div[4]/div/label");
			put("ownership_label",".//*[@id='stage2']/div[5]/div/label");
			put("jobtostart_label",".//*[@id='timeframe']/div/label");
			put("postcode_label",".//*[@id='stage2']/div[7]/div/label");
			put("additional_label",".//*[@id='additionalDetailsContainer']/div/label");
			put("repairstatus_label",".//*[@id='stage2']/div[3]/div/label");
			put("repairownership_label",".//*[@id='stage2']/div[4]/div/label");
			put("repairpostcode_label",".//*[@id='stage2']/div[6]/div/label");
			put("budget_label",".//*[@id='stage3']/div[1]/div[2]/label");
			put("fname_label",".//*[@id='contact']/div[1]/label[2]");
			put("lname_label",".//*[@id='contact']/div[2]/label[2]");
			put("number_label",".//*[@id='contact']/div[3]/div/label");
			put("CONFIRMPHONENUMBER_ERRORMSG",".//*[@id='contact']/div[4]/label[2]");
			put("CONFIRMEMAIL_ERRORMSG",".//*[@id='contact']/div[6]/label[2]");
			put("email_label",".//*[@id='contact']/div[5]/div/label");
			put("CLICK_NEXT",".//*[@id='btnPostJob']");
			
            put("ALMOSTDONE_XPATH",".//*[@id='contentLightBox']/div[2]/h1");
            put("TEXTONE_XPATH",".//*[@id='contentLightBox']/div[2]/ul/li[1]");
            put("TEXTTWO_XPATH",".//*[@id='contentLightBox']/div[2]/ul/li[2]");
            put("TEXTTHREE_XPATH",".//*[@id='contentLightBox']/div[2]/ul/li[3]");
            put("TEXTFOUR_XPATH",".//*[@id='contentLightBox']/div[2]/ul/li[4]");
            put("TEXTFIVE_XPATH",".//*[@id='contentLightBox']/div[2]/ul/li[5]");
            put("HOMEOWNERUSERAGREEMENT_XPATH",".//*[@id='contentLightBox']/div[2]/small[1]/a[1]");
            put("USERSERVICES_XPATH",".//*[@id='contentLightBox']/div[2]/small[1]/a[2]");
            put("INDEMNITY_XPATH",".//*[@id='contentLightBox']/div[2]/small[1]/a[3]");
            put("LIMITATIONOFLIABILITY_XPATH",".//*[@id='contentLightBox']/div[2]/small[1]/a[4]");
            put("PRIVACY_XPATH",".//*[@id='contentLightBox']/div[2]/small[1]/a[5]");
            put("CANCELANDRETURNHOME",".//*[@id='contentLightBox']/div[2]/small[2]/a");
            
			put("RECOMMEND_SERVICES",".//*[@id='skill-specifc-portable-jobform']/div/section[2]/h2");
			put("CLICKON_FACEBOOKICON",".//*[@id='RL_ACCOUNT']/div[1]");
			put("RECOMMEND_SERVICESTEXT","Discover friends who would like Rated People");	
			put("HOMEPAGEHEADER_XPATH",".//*[@id='header-h1']/span");
			
			put("TEXTUNDERTHANKYOU_XPATH" , ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/p[1]"); 
			put("WHATHAPPENSNEXTONE_XPATH",".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[1]"); 
			put("WHATHAPPENSNEXTTWO_XPATH" , ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[2]");
			put("WHATHAPPENSNEXTTHREE_XPATH", ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[3]");
			
			
		
		}
	};
	
	
	
	@SuppressWarnings("serial")
	public static Hashtable<String, String> assertLookup = new Hashtable<String, String>()
		{
			{
				put("roofsection_msg","At least one item needs to be selected");
				put("highestsection_msg","Select the highest section of roof that needs to be replaced");
				put("repairsection_msg","At least one option needs to be selected");
				put("highestsectionrepair_msg","Select the highest section of roof that needs to be repaired");
				put("propertytype_msg","Select the property type");
				put("propertystyle_msg","Select the property style");
				put("numberbedrooms_msg","Select the number of bedrooms");
				put("status_msg","Select the appropriate status of the job");
				put("ownership_msg","Select your ownership status");
				put("jobtostart_msg","Select when you want the job to start");
				put("postcode_msg","Enter a UK postcode");
				put("additional_msg","Enter additional details about your job");
				put("budget_msg","Select an approximate budget");
				put("fname_msg","Please enter your first name");
				put("lname_msg","Please enter your last name");
				put("num_msg","Please enter your phone number");
				put("email_msg","Please enter your email address");
			}
		};
	
	@SuppressWarnings("serial")
	public static Hashtable<String, String> dataLookup = new Hashtable<String, String>(){
		{
			put("postcode","sw46rz");
			put("mobile","07512000000");
			put("confirmphonenumber","07512000000");
			put("CONFIRMEMAIL_ERRORMSGTEXT","Please confirm your email address");
			put("CONFIRMPHONENUMBER_ERRORMSGTEXT","Please confirm your phone number");
			put("headertxt","Thank you");
			put("fname","fname");
			put("lname","lname");
			put("roofSection","Main roof");
			put("highestRoof","2 storey");
			put("whichroofrepair","Other");
			put("whereroofrepair","Bay window");
			put("BUDGET","Under £500");
			put("propertytype","Detached");
			put("propertystyle","Period property (1700s - 1920s)");
			put("repairownership","I am the landlord");
			put("repairintent","I'm ready to hire");
			put("timing","Urgently");
			put("ALMOSTDONE_TEXT","Almost done ...");
			put("TEXTONE_TEXT","the job details that you have provided are as informative as possible");
		    put("TEXTTWO_TEXT","your contact details are correct and you are ready to take their call");
			put("TEXTTHREE_TEXT","you are responsible for deciding whether to use any tradesman");
			put("TEXTFOUR_TEXT","you will carefully review tradesmen qualification and ratings");
			put("TEXTFIVE_TEXT","if for any reason you no longer require a quote, you will withdraw your job");
			put("HOMEOWNERUSERAGREEMENT_TEXT","Homeowner User Agreement");
			put("USERSERVICES_TEXT","'Use of Service'");
			put("INDEMNITY_TEXT","'Indemnity'");
			put("LIMITATIONOFLIABILITY_TEXT","'Limitation of Liability'");
			put("PRIVACY_TEXT","Privacy Policy");
			put("description",TestScriptUtilities.getRandomString(30));

			put("HOMEPAGEHEADER_TEXT","We have thousands of recommended tradesmen across the UK");
			
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
