/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.internalrenovation;

import java.util.Hashtable;

/**
 * @author shabana.khanam
 * 
 */
public class InternalRenovationXpathLocators {

	@SuppressWarnings("serial")
	public static Hashtable<String, String> xpathlookup = new Hashtable<String, String>() {
		{
			// landing page
			put("pcode", "postcode");
			put("nextquotes", "btn-next-step");
			// job details
			put("reconfigradio", ".//*[@id='radioConfigure']");
			put("repairradio", ".//*[@id='radioRepair']");
			put("somethingelseradio", ".//*[@id='radioElse']");
			// stage1 back & continue
			put("continuestage1", ".//*[@id='stage1SelectButton']");
			put("backstage1", ".//*[@id='stage1']/div[2]/button[1]");
			// Work needs done not sure
			put("configurenotsure", ".//*[@id='descConfigure']/div[1]/div[1]/ul/li[1]/input[@id='configureTypeNotsure']");
			put("workneedsdoneone", ".//*[@id='descConfigure']/div[1]/div[1]/ul/li");
			put("workneedsdonetwo", ".//*[@id='descConfigure']/div[1]/div[2]/ul/li");
			put("workneedsdonerepairone", ".//*[@id='descRepair']/div[1]/div[1]/ul/li");
			put("workneedsdonerepairtwo", ".//*[@id='descRepair']/div[1]/div[2]/ul/li");
			put("workneedsdother", ".//*[@id='descConfigure']/div[1]/div[2]/ul/li[9]");
			put("workneedsothertext", ".//*[@id='descConfigure']/div[1]/div[2]/ul/li[10]/textarea");
			// Where work needs done
			put("workdoneone", ".//*[@id='descConfigure']/div[2]/div[1]/ul/li");
			put("workdonetwo", ".//*[@id='descConfigure']/div[2]/div[2]/ul/li");
			put("workdonerepairone", ".//*[@id='descRepair']/div[2]/div[1]/ul/li");
			put("workdonerepairtwo", ".//*[@id='descRepair']/div[2]/div[2]/ul/li");
			put("workdother", ".//*[@id='descConfigure']/div[2]/div[2]/ul/li[5]");
			put("workothertext", ".//*[@id='descConfigure']/div[2]/div[2]/ul/li[6]/textarea");
			// Configure stage1 next & back
			put("configurestageoneback", ".//*[@id='descConfigure']/div[3]/button[1]");
			put("configurestageonenext", ".//*[@id='descConfigure']/div[3]/button[2]");
			// Repair stage1 next & back
			put("repairstageoneback", ".//*[@id='descRepair']/div[3]/button[1]");
			put("repairstageonenext", ".//*[@id='descRepair']/div[3]/button[2]");
			// Additional Page
			put("materialradio", ".//*[@id='stage2']/div[1]/div[1]/ul/li");
			put("propertyownyes", ".//*[@id='ownPropertyYes']");
			put("propertyownno", ".//*[@id='ownPropertyYes']");
			put("propertytype", ".//*[@id='stage2']/div[2]/select[@id='propertyType']");
			put("propertyListed", ".//*[@id='stage2']/div[3]/div[1]/ul/li");
			put("timing", ".//*[@id='stage2']/div[6]/select[@id='timing']");
			put("textareaadditionalinfo", ".//*[@id='stage2']/div[8]/textarea");
			put("intent", ".//*[@id='stage2']/div[4]/ul/li");
			put("ownership", ".//*[@id='stage2']/div[5]/ul/li");
			// stage 2 next & back
			put("stagetwoback", ".//*[@id='stage2']/div[9]/div/button[2]");
			put("stagetwonext", ".//*[@id='stage2']/div[9]/div/button[1]");
			// budget
			put("budget", ".//*[@id='stage3']/div[1]/select[@id='jobBudgetCode']");
			put("otherbudget", ".//*[@id='otherBudgetValue']");
			// stage3 next & back
			put("stagethreenext", ".//*[@id='stage3']/div[2]/div/button[1]");
			put("stagethreeback", ".//*[@id='stage3']/div[2]/div/button[2]");
			// location and contact
			put("fname", ".//*[@id='firstName']");
			put("lname", ".//*[@id='lastName']");
			put("mobile", ".//*[@id='mobilePhone']");
			put("email", ".//*[@id='email']");
			put("postjob", ".//*[@id='btnPostJob']");
			put("headerthanku", ".//*[@id='header-h1']");

			// labels

			put("whatwork_label", ".//*[@id='descConfigure']/div[1]/div[3]/label");
			put("wherework_label", ".//*[@id='descConfigure']/div[2]/div[3]/label");
			put("repairwhatwork_label", ".//*[@id='descRepair']/div[1]/div[3]/label");
			put("repairwherework_label", ".//*[@id='descRepair']/div[2]/div[3]/label");
			put("material_label", ".//*[@id='stage2']/div[1]/div[1]/div/label");
			put("propertystyle_label", ".//*[@id='stage2']/div[2]/div/label");
			put("propertylist_label", ".//*[@id='stage2']/div[3]/div[1]/div/label");
			put("status_label", ".//*[@id='stage2']/div[4]/div/label");
			put("ownership_label", ".//*[@id='stage2']/div[5]/div/label");
			put("timing_label", ".//*[@id='timeframe']/div/label");
			put("postcode_label", ".//*[@id='stage2']/div[7]/div/label");
			put("description_label", ".//*[@id='additionalDetailsContainer']/div/label");
			put("budget_label", ".//*[@id='stage3']/div[1]/div[2]/label");
			put("fname_label", ".//*[@id='contact']/div[1]/label[2]");
			put("lname_label", ".//*[@id='contact']/div[2]/label[2]");
			put("number_label", ".//*[@id='contact']/div[3]/div/label");
			put("email_label", ".//*[@id='contact']/div[4]/div/label");
			put("BUDGET_SELECT_ELEMENT", "jobBudgetCode");
			put("SCREEN3_NEXT_BUTTON", ".//*[@id='stage3']/div[2]/div/button[1]");
			put("wrkType", ".//*[@id='configureTypeConstruction']");
			put("wrkDone", ".//*[@id='configureBedroom']");
			put("repairItem", ".//*[@id='repairItemElectrics']");
			put("repairNeeded", ".//*[@id='repairBedroom']");
			put("renovateNext", ".//*[@id='nextDescConfigure']");
			put("repairNext", ".//*[@id='nextDescRepair']");
			put("MATERIAL", "fittingMaterialTradesman");
			put("LISTED", "noListed");
			put("RECOMMEND_SERVICES",".//*[@id='skill-specifc-portable-jobform']/div/section[2]/h2");
			put("CLICKON_FACEBOOKICON",".//*[@id='RL_ACCOUNT']/div[1]");
			
		}
	};

	@SuppressWarnings("serial")
	public static Hashtable<String, String> dataLookup = new Hashtable<String, String>() {
		{
			put("postcode", "sw197ns");
			put("mobile", "07512000000");
			put("headertxt", "Thank you");
			put("fname", "fname");
			put("lname", "lname");
		}
	};

	@SuppressWarnings("serial")
	public static Hashtable<String, String> assertLookup = new Hashtable<String, String>() {
		{
			put("whatwork_msg", "Select what work needs to be carried out");
			put("wherework_msg", "Select which rooms the work relates to");
			put("repairwhatwork_msg", "Select what needs to be repaired");
			put("repairwherework_msg", "Select which rooms the work relates to");
			put("budget_msg", "Select an approximate budget");
			put("fname_msg", "Enter your first name");
			put("lname_msg", "Enter your last name");
			put("number_msg", "Enter your phone number");
			put("email_msg", "Enter your email address");

			put("material_msg", "Select who will supply the fittings/materials");
			put("property_msg", "Select the property style");
			put("property_list_msg", "Select whether the property is listed or not");
			put("status_msg", "Select the appropriate status of the job");
			put("ownership_msg", "Select your ownership status");
			put("timing_msg", "Select when you want the job to start");
			put("postcode_msg", "Enter your postcode");
			put("addinfo_msg", "Enter additional details about your job");

            put("RECOMMEND_SERVICESTEXT","Recommend Rated People to your friends");
		}
	};
}
