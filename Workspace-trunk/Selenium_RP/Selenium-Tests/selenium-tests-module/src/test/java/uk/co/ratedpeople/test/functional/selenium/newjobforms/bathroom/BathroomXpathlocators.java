/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.bathroom;

import java.util.Hashtable;

/**
 * 
 *
 */
public class BathroomXpathlocators {
	
	
	
	@SuppressWarnings("serial")
	public static Hashtable<String, String> xpathLookup = new Hashtable<String, String>(){
		{
			put("pcode","postcode");
			put("nextquotes","btn-next-step");
			//jobdetails
			put("radioInstall",".//*[@id='radioInstall']");
			put("radioRepair",".//*[@id='radioRepair']");
			put("radioElse",".//*[@id='radioElse']");
			put("continuestage1",".//*[@id='stage1SelectButton']");
			put("backstage1",".//*[@id='stage1']/div[2]/div/button[2]");
			
			//installation
			put("installed",".//*[@id='descInstall']/div[1]/div[1]/ul/li");
			put("installation", ".//*[@id='descInstall']/div[2]/div[2]/ul/li");
			put("installationOther", ".//*[@id='descInstall']/div[2]/div[2]/ul/li");
			put("supplying",".//*[@id='descInstall']/div[3]/div[2]/ul/li");
			put("supplyingOther",".//*[@id='descInstall']/div[3]/div[1]/ul/li");
			put("stageonereplaceback",".//*[@id='descInstall']/div[4]/button[1]");
			put("stageonereplacenext",".//*[@id='descInstall']/div[4]/button[2]");
			//stage 2 next & back
			put("stagetwoback",".//*[@id='stage2']/div[6]/div/button[2]");
			put("stagetwonext",".//*[@id='stage2']/div[6]/div/button[1]");	
			put("INSTALLATION", ".//*[@id='installExtraFlooringTiled']");
							
		
				
			//repair
			put("descRepair",".//*[@id='descRepair']/div[1]/div[2]/ul/li[5]/input");
			put("repairstagetwoback",".//*[@id='descRepair']/div[2]/button[1]");
			put("repairstagetwonext",".//*[@id='descRepair']/div[2]/button[2]");			
							
					
		
			//Additional Info somethingelse
			put("intent",".//*[@id='stage2']/div[1]/ul/li");
			put("ownership",".//*[@id='stage2']/div[2]/ul/li");
			put("timing",".//*[@id='timing']");
			put("postcode",".//*[@id='postcode']");
			put("textareaadditionalinfo",".//*[@id='additionalDetailsContainer']/textarea");
			put("status","statusREADY_TO_HIRE");
			put("owner","ownerOWN_AND_LIVE");
		
			
			
			
			
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
			put("confirmPhone",".//*[@id='confirmPhone']");
			put("email",".//*[@id='email']");
			put("confirmEmail",".//*[@id='confirmEmail']");
			put("postjob",".//*[@id='btnPostJob']");
			put("headerthanku",".//*[@id='header-h1']");
			put("RECOMMEND_SERVICES",".//*[@id='skill-specifc-portable-jobform']/div/section[2]/h2");
			put("CLICKON_FACEBOOKICON",".//*[@id='RL_ACCOUNT']/div[1]");
			
			// js validation labels
			
			put("installjs",".//*[@id='descInstall']/div[1]/div[3]/div/label");
			put("installWhatElseOtherjs", ".//*[@id='descInstall']/div[2]/div[2]/ul/li[5]/div/label");
			put("installSupplyingOtherjs", ".//*[@id='descInstall']/div[3]/div[1]/ul/li[6]/div/label");
			put("repairjs",".//*[@id='descRepair']/div[1]/div[3]/label");
			put("statusjs",".//*[@id='stage2']/div[1]/div/label");
			put("ownershipjs",".//*[@id='stage2']/div[2]/div/label");
			put("timingjs",".//*[@id='stage2']/div[3]/div/label");
			put("postcodejs",".//*[@id='stage2']/div[4]/div/label");
			put("additionaldetailsjs",".//*[@id='stage2']/div[5]/div/label");
			put("additionalinfolessjs",".//*[@id='stage2']/div[5]/div/label");
			put("budgetjs",".//*[@id='stage3']/div[1]/div[3]/label");
			put("otherbudgetjs",".//*[@id='stage3']/div[1]/div[3]/label[2]");
			put("firstnamejs",".//*[@id='contact']/div[1]/label[2]");
			put("lastnamejs",".//*[@id='contact']/div[2]/label[2]");
			put("phonenumberjs",".//*[@id='contact']/div[3]/div/label");
			put("confirmphonenumberjs",".//*[@id='contact']/div[4]/label[2]");
			put("emailjs",".//*[@id='contact']/div[5]/div/label");
			put("confirmemailjs",".//*[@id='contact']/div[6]/label[2]");
			
			put("TEXTUNDERTHANKYOU_XPATH" , ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/p[1]"); 
			put("WHATHAPPENSNEXTONE_XPATH",".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[1]"); 
			put("WHATHAPPENSNEXTTWO_XPATH" , ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[2]");
			put("WHATHAPPENSNEXTTHREE_XPATH", ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[3]");
			
		}
	};
	
	
	
	@SuppressWarnings("serial")
	public static Hashtable<String, String> dataLookup = new Hashtable<String, String>(){
		{
			put("postcode","sw46rz");
			put("mobile","07512000000");
			put("mobileDifferent","07512000001");
			put("headertxt","Thank you");
			put("fname","fname");
			put("lname","lname");
			put("RECOMMEND_SERVICESTEXT","Recommend Rated People to your friends");
			
			//put("TEXTUNDERTHANKYOU_TEXT" , "Your job has been successfully submitted for review and will be shared with tradesmen shortly.");
			put("TEXTUNDERTHANKYOU_TEXT" , "Your job has been successfully submitted for review and will be shared with tradesmen shortly. We have sent you an email with your password for Rated People. Keep it safe and use it to log in to your account. If this is not your first job posted with us, you should already have your password.");
			put("WHATHAPPENSNEXTONE_TEXT" , "Tradesmen will review your job details");
			put("WHATHAPPENSNEXTTWO_TEXT" , "Up to three interested tradesmen will pay to contact you");
			put("WHATHAPPENSNEXTTHREE_TEXT" , "We'll send you an email and SMS with their profile(s) and ratings");

		}
	};
	

	
	@SuppressWarnings("serial")
	public static Hashtable<String, String> jsLookup = new Hashtable<String, String>(){
		{
			put("whatElseNeededValidation", "List what else you need");
			put("whichAreYouSupplyingValidation", "List what you are supplying");
			put("installvalidation","At least one option needs to be selected");
			put("appropriatestatus","Select the appropriate status of the job");
			put("ownership","Select your ownership status");
			put("timing","Select when you want the job to start");
			put("postcode","Enter a UK postcode");
			put("additionaldetails","Enter additional details about your job");
			put("additionaldetailsless","Enter at least 5 characters");
			put("budget","Select an approximate budget");
			put("otherbudget","Enter an approximate budget");
			put("firstname","Please enter your first name");
			put("lastname","Please enter your last name");
			put("phonenumber","Please enter your phone number");
			put("confirmphonenumber","Please confirm your phone number");
			put("phonenumbermismatch","The phone numbers entered do not match");
			put("email","Please enter your email address");
			put("confirmemail", "Please confirm your email address");
			put("emailmismatch","The email addresses entered do not match");

		}
	};
	
	
}
