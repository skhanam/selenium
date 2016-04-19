/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.fences;

import java.util.HashMap;

/**
 * @author shabana.khanam
 * 
 */
public class FencesXpathLocators {

	@SuppressWarnings("serial")
	public static HashMap<String, String> xpathLookup = new HashMap<String, String>() {
		{
			put("pcode", "postcode");
			put("nextquotes", "btn-next-step");
			put("FENCES", "radioFence");
			put("GARDEN_WALLS", "radioWall");
			put("GATES", "radioGate");
			put("SOMETHING_ELSE", "radioElse");
			put("FENCES_JOB_REQUIRMENT_INSTALL", "fenceReplace");
			put("FENCES_JOB_REQUIRMENT_REPAIR", "fenceRepair");
			put("GARDEN_WALLS_JOB_REQUIRMENT_INSTALL", "wallReplace");
			put("GARDEN_WALLS_JOB_REQUIRMENT_REPAIR", "wallRepair");
			put("GATES_JOB_REQUIRMENT_INSTALL", "gateReplace");
			put("GATES_JOB_REQUIRMENT_REPAIR", "gateRepair");
			put("FENCES_JOB_REQUIRMENT_INSTALL", "fenceReplace");
			put("FENCES_JOB_REQUIRMENT_REPAIR", "fenceRepair");
			put("GARDEN_WALLS_JOB_REQUIRMENT_INSTALL", "wallReplace");
			put("GARDEN_WALLS_JOB_REQUIRMENT_REPAIR", "wallRepair");
			put("GATES_JOB_REQUIRMENT_INSTALL", "gateReplace");
			put("GATES_JOB_REQUIRMENT_REPAIR", "gateRepair");
			put("GARDEN_WALLS_LENGTH_INSTALL_XPATH", ".//*[@id='wallLengthReplace']");
			put("GARDEN_WALL_LENGTH_INSTALL", "1125");
			put("GARDEN_WALL_HEIGHT_INSTALL", "wallHeightUnderReplace");
			put("GARDEN_WALL_SUPPLY_MATERIAL", "wallMaterialYes");
			put("JOB_STATUS_ID", "statusREADY_TO_HIRE");
			put("OWNERSHIP_STATUS_ID", "ownerLANDLORD");
			put("TIMING", "URGENTLY");
			put("POSTCODE", "SW1E6AU");
			put("BUDGET", "79_LT_4000");
			put("BUDGETOTHER", "79_OTHER");
			put("FENCES_SUPPLY_MATERIAL", "fenceMaterialYes");
			put("FENCES_HEIGHT_INSTALL", "fenceHeightUnderReplace");
			// put("FENCES_USE_OF_FENCES_INSTALL_XPATH_LIST",".//*[@id='fenceScreeningReplace']");
			put("FENCES_LENGTH_INSTALL", "1089");
			put("FENCES_LENGTH_INSTALL_XPATH", ".//*[@id='fenceLengthReplace']");
			put("GATES_SUPPLY_MATERIAL", "gateMaterialYes");
			/*
			 * Xpaths for retrieving js messages
			 */
			put("REQUIREMENTXPATH",".//*[@Id='descWall']/div[1]/div/div/label");
			put("REQUIREMENTFENCEXPATH",".//*[@id='descFence']/div[1]/div/div/label");
			put("MATERIALSFENCEXPATH",".//*[@id='descFence']/div[4]/div/div/label");
			put("MATERIALSXPATH",".//*[@id='descWall']/div[4]/div/div/label");
			put("LENGTHWALLXPATH",".//*[@Id='descWall']/div[2]/div[1]/div/label");
			put("HEIGHTXPATH",".//*[@Id='descWall']/div[2]/div[2]/div/label");
			put("MATERIALSUXPATH",".//*[@Id='descWall']/div[4]/div[1]/div/label");
			put("STATUSXPATH",".//*[@id='stage2']/div[1]/div/label");
			put("OWNERSHIPPATH",".//*[@id='stage2']/div[2]/div/label");
			put("TIMINGXPATH",".//*[@id='timeframe']/div/label");
			put("POSTCODEXPATH",".//*[@id='stage2']/div[4]/div/label");
			put("DETAILSXPATH",".//*[@id='additionalDetailsContainer']/div/label");
			put("BUDGETXPATH", ".//*[@id='stage3']/div[1]/div[3]/label");
			put("BUDGETSTHELSEXPATH", ".//*[@id='stage3']/div[1]/div[2]/label");
			put("BUDGETOTHERXPATH", ".//*[@id='stage3']/div[1]/div[3]/label[2]");
			put("FNAMEXPATH", ".//*[@id='contact']/div[1]/label[2]");
			put("LNAMEXPATH", ".//*[@id='contact']/div[2]/label[2]");
			put("PNUMBERXPATH", ".//*[@id='contact']/div[3]/div/label");
			put("CONFIRMPNUMBERXPATH", ".//*[@id='contact']/div[4]/label[2]");
			put("MAILXPATH", ".//*[@id='contact']/div[5]/div/label");
			put("CONFIRMMAILXPATH", ".//*[@id='contact']/div[6]/label[2]");
			put("LENGTHFENCEXPATH", ".//*[@id='descFence']/div[2]/div[1]/div/label");
			put("FENCEREPLACEDXPATH", ".//*[@id='descFence']/div[2]/div[2]/div[3]/label");
			put("FENCEHEIGHTXPATH", ".//*[@id='descFence']/div[2]/div[3]/div/label");
			put("MATERIALSXPATH", ".//*[@id='descFence']/div[4]/div/div/label");
			put("FENCEOTHERXPATH", ".//*[@id='descFence']/div[2]/div[2]/div[1]/ul/li[8]/div/label");
			put("REQUIREMENTGATEXPATH", ".//*[@id='descGate']/div[1]/div/div/label");
			put("MATERIALGATEXPATH", ".//*[@id='descGate']/div[4]/div/div/label");
			put("GATEINSTALLXPATH", ".//*[@id='descGate']/div[2]/div[2]/div/label");
			put("SUPPLYMATERIALXPATH", ".//*[@id='descGate']/div[4]/div/div/label");
			put("GATETYPEXPATH", ".//*[@id='descGate']/div[2]/div[1]/ul/li[3]/div/div/label");
			put("RECOMMEND_SERVICES",".//*[@id='skill-specifc-portable-jobform']/div/section[2]/h2");
			put("CLICKON_FACEBOOKICON",".//*[@id='RL_ACCOUNT']/div[1]");
			
			
			put("TEXTUNDERTHANKYOU_XPATH" , ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/p[1]"); 
			put("WHATHAPPENSNEXTONE_XPATH",".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[1]"); 
			put("WHATHAPPENSNEXTTWO_XPATH" , ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[2]");
			put("WHATHAPPENSNEXTTHREE_XPATH", ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[3]");
		}
	};

	@SuppressWarnings("serial")
	public static HashMap<String, String> assertLookup = new HashMap<String, String>() {
		{
			put("REQUIREMENTMSG", "Select the job you need to have done");
			put("SUPPLYMSG", "Select who will supply the materials");
			put("LENGTHMSG", "Select the length of wall");
			put("HEIGHTMSG", "Select the height");
			put("MATERIALMSG", "Select who will supply the materials");
			put("STATUSMSG", "Select the appropriate status of the job");
			put("OWNERMSG", "Select your ownership status");
			put("TIMINGMSG", "Select when you want the job to start");
			put("POSTCODEMSG", "Enter a postcode");
			put("DETAILSMSG", "Enter additional details about your job");
			put("BUDGETMSG", "Select an approximate budget");
			put("BUDGETOTHERMSG", "Enter an approximate budget");
			put("FNAMEMSG", "Please enter your first name");
			put("LNAMEMSG", "Please enter your last name");
			put("PNUMBERMSG", "Please enter your phone number");
			put("CONFIRMPNUMBERMSG", "Please confirm your phone number");
			put("MAILMSG", "Please enter your email address");
			put("CONFIRMMAILMSG", "Please confirm your email address");
			put("LENGTHFENCEMSG", "Select the length of fence");
			put("FENCETYPEMSG", "At least one needs to be selected");
			put("FENCEOTHERMSG", "List the type of fence");
			put("GATEINSTALLMSG", "At least one option needs to be selected");
			put("GATETYPEMSG", "List the type of gate");
			put("RECOMMEND_SERVICESTEXT","Recommend Rated People to your friends");
		}
	};
	
	@SuppressWarnings("serial")
	public static HashMap<String, String> dataLookup = new HashMap<String, String>(){
		{
//			   put("TEXTUNDERTHANKYOU_TEXT" , "Your job has been successfully submitted for review and will be shared with tradesmen shortly.");
			  put("TEXTUNDERTHANKYOU_TEXT" , "Your job has been successfully submitted for review and will be shared with tradesmen shortly. We have sent you an email with your password for Rated People. Keep it safe and use it to log in to your account. If this is not your first job posted with us, you should already have your password.");
			   put("WHATHAPPENSNEXTONE_TEXT" , "Tradesmen will review your job details");
			   put("WHATHAPPENSNEXTTWO_TEXT" , "Up to three interested tradesmen will pay to contact you");
			   put("WHATHAPPENSNEXTTHREE_TEXT" , "We'll send you an email and SMS with their profile(s) and ratings");

		}
	};
	
}
