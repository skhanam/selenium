/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.chimney;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shabana.khanam
 *
 */
public class ChimneyLocators {
	
		@SuppressWarnings("serial")
		public static Map<String, String> xpathLookup = new HashMap<String, String>() {
			
			{
				put("nextquotes", "btn-next-step");
				put("leak", ".//*[@id='radioLeak']");
				put("notsure", ".//*[@id='leakNotSure']");
				put("JOB_USER_EMAIL_FIELD","email");
				put("JOB_USER_FIRST_NAME_FIELD","firstName");
				put("JOB_USER_LAST_NAME_FIELD","lastName");
				put("JOB_USER_PHONE_NUMBER_FIELD","mobilePhone");
				put("BUDGET_SELECT_ELEMENT","jobBudgetCode");
				put("ADDITIONAL_INFO_TEXT_AREA_XPATH",".//*[@id='additionalDetailsContainer']/textarea");
				put("POSTCODE_FIELD","postcode");
				put("TIMING_SELECT_ELEMENT","timing");
				put("RADIO_REPAIR_CHIMNEY","radioRepairStack");
				put("RADIO_REBUILD_CHIMNEY","radioRebuildStack");
				put("RADIO_CHIMNEY_BREAST","radioRepairBreast");
				put("RADIO_REMOVE_CHIMNEY","radioRemoveBreast");
				put("RADIO_SOMETHING","radioElse");
				put("PLUS_ICON",".//*[@id='descRepairStack']/div[1]/div/ul/li/a[2]");
				put("REBUILD_PLUS_ICON",".//*[@id='descRebuildStack']/div[2]/div/ul/li/a[2]");
				put("JOB_REQUIREMENT_REBUILD","rebuildStackRequirementRebuild");
				put("CHIMNEY_STACK_OTHER",".//*[@id='descRepairStack']/div[2]/div[2]/ul/li[6]/input[@id='repairStackOther']");
				put("OTHER_TEXT",".//*[@id='descRepairStack']/div[2]/div[2]/ul/li[7]/textarea[@id='replaceOtherText']");
				put("CHIMNEY_HEIGHT",".//*[@id='repairStackHeight']");
				put("REMOVE_STOREY_HEIGHT",".//*[@id='removeBreastStoreyHeight']");
				put("BUILDING_CONVERSION",".//*[@id='loftConversionBuildingRegulations']");
				put("REBUILD_CHIMNEY_HEIGHT",".//*[@id='descRebuildStack']/div[3]/select[@id='repairStackHeight']");
				put("OTHER_CHECK",".//*[@id='descRemoveBreast']/div[1]/div[2]/ul/li[4]/input[@id='removeBreastOther']");
				put("continuebuttonstage1",".//*[@id='stage1SelectButton']");
				put("JOB_STATUS","statusREADY_TO_HIRE");
				//js validations
				
				put("ChimneyStack",".//*[@id='descRepairStack']/div[1]/div/div/div/label");
				put("ChimneyStkvalidation","Select the number of chimney stacks");
				put("ChimneyStkpart",".//*[@id='descRepairStack']/div[2]/div[3]/label");
				put("ChimneyStkpartvalidation","Select what repairs are needed");
				put("Chimneyhighest",".//*[@id='replaceSection']/div/label");
				put("Chimneyhighestvalidation","Select how high up the work needs to be done");
				put("Chimneystkpartother",".//*[@id='descRepairStack']/div[2]/div[2]/ul/li[7]/div/label");
				put("Chimneystkpartothervalidation","Describe what needs to be repaired");
				put("statusofthejob",".//*[@id='stage2']/div[1]/div/label");
				put("statusofthejobvalidation","Select the appropriate status of the job");
				put("ownershipstatus",".//*[@id='stage2']/div[2]/div/label");
				put("ownershipstatusvalidation","Select your ownership status");
				put("styleoftheproperty",".//*[@id='styleOfProperty']/div/label");
				put("styleofthepropertyjobvalidation","Select the property style");
			
				put("jobtostart",".//*[@id='timeframe']/div/label");
				put("jobstartvalidation","Select when you want the job to start");
				put("enterpostcode",".//*[@id='stage2']/div[5]/div/label");
				put("enterpostcodevalidation","Enter a UK postcode");
				put("enteradditionaldetails","//*[@id='additionalDetailsContainer']/div/label");
				put("enteraditionaldetalsvalidation","Enter additional details about your job");
				put("Last_Name",".//*[@id='contact']/div[2]/label[2]");
				put("Last_namevalidation","Please enter your last name");
				
				//removechimneybreast
				
				put("CHIMNEY_BREAST",".//*[@id='removeBreastBasement']");
				put("STOREY_PROPERTY",".//*[@id='removeBreastStoreyHeight']");
				put("BUILDING_REGULATION",".//*[@id='loftConversionBuildingRegulations']");
			
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
  			   put("WHATHAPPENSNEXTONE_TEXT" , "Tradesmen will review your job details");
  			   put("WHATHAPPENSNEXTTWO_TEXT" , "Up to three interested tradesmen will pay to contact you");
  			   put("WHATHAPPENSNEXTTHREE_TEXT" , "We'll send you an email and SMS with their profile(s) and ratings");

  		}
  	};

}
