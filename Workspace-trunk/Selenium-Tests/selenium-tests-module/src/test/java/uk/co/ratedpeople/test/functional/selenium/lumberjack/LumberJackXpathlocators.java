package uk.co.ratedpeople.test.functional.selenium.lumberjack;

import java.util.HashMap;
import java.util.Map;

public class LumberJackXpathlocators {
	
	@SuppressWarnings("serial")
	public static  Map<String,String> xpathLookup =new HashMap<String, String>()
	{
		{
			put("USERNAME","username");
			put("PASSWORD","password");
			put("LOGIN","login__login");
			put("WELCOME_POPUP_LJ_WALKTHROUGH",".//*[@id='modal-controls']/div/div");
			put("LISTOFJOBSINPAGE1", "(//*[@data-leadcard])[1]");
			put("LEADS_AVAILABLE_NUMBER","//*[@class='lead-menu_counter heading1 green']");
			put("DELETE_JOB","//*[@data-action='delete']");
			put("VIEW_FULL_DETAILS_THIRD_LEAD", "//*[@data-action='lead'])[3]");
			put("VIEW_FULL_DETAILS_FIRST_LEAD", ".//*[@id='main']/div/div[1]/div/div[2]/a");
			put("CONFIRM_PURCHASE_BOX","//*[@class='box_title']");
			put("THANKYOU_MESSAGE","//*[@class='titleBox']");
			put("VIEW_LEAD","//*[@data-action='view-lead']");
			put("PURCHASED_JOB_HEADER","//*[@class='main_header']/h2");
			put("LEADS_PURCHASED_TEXT","//*[@class='gillSans']");
			put("PAGINATION_NEXT_PAGE","(//*[@class='pagination_direction '])[3]"); 
			put("PAGINATION_LAST_PAGE","(//*[@class='pagination_direction '])[4]");
			put("PAGINATION_PREVIOUS_PAGE","(//*[@class='pagination_direction '])[2]");
			put("PAGINATION_FIRST_PAGE","(//*[@class='pagination_direction '])[1]");
			put("1st_2nd_3rd_TO_BUY","(//*[@class='ftb_text'])[1]");
			put("JOB_LEAD_DETAILS", "(//*[@class='main_header'])/div/h2");
		    put("CANCEL_NEWCARD", "Cancel");
			put("CREDITCARD_NUMBER", "cardnumber");
			put("SECURITY_CODE", "cv2");		
			put("ERROR_ADDING_NEW_CARD", "(//*[@class='error error--solo'])");
			put("LJ_SORT_COMBO_BOX", "(//*[@class='sortation_select'])");
			put("LJ_LEAD_URL_PREFIX", "id('main')/div[1]/div[2]/div[1]/div[");
			put("LJ_LEAD_URL_SUFFIX", "]/div/div[2]/a");
			put("LJ_LEADS_LIST", "(//*[@class='leads grid'])");
			put("LJ_LEADS_LIST_NEXT_BUTTON", "id('pagination')/div[1]/div[1]/div[3]/span[1]");
			put("DELETE_LEAD_CONFIRM_BUTTON", "id('modal')/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/button");
			put("CLICK_ANYWHERE_ON_JOB", ".//*[@id='main']/div/div[1]/div/div[2]");
			put("MINIMUM_NUMBER_LEADS_PER_PAGE", ".//*[@id='pagination-limit']/div/div/a[1]");
			put("TIMING_FILTER_TAB", ".//*[@id='timingAndStatus']/div/div/a[1]");
			put("STATUS_FILTER_TAB", ".//*[@id='timingAndStatus']/div/div/a[2]");
			put("URGENTLY", "id('timing[URGENTLY]')");
			put("LT_2_DAYS", "id('timing[LT_2_DAYS]')");
			put("FLEXIBLE_S_D", "id('timing[FLEXIBLE_S_D]')");
			put("READY_TO_HIRE", "id('intent[READY_TO_HIRE]')");
			put("PLANNING_BUDGETING", "id('intent[PLANNING_BUDGETING]')");
			put("INSURANCE_CLAIM", "id('intent[INSURANCE_CLAIM]')");
			put("SHOW_ALL_SKILLS_LINK", "id('skills')/div[1]/a[1]");
			put("CHIMNEY_SKILL", "id('skills[97]')");
			put("BATHROOM_INSTALLATION_SKILL", "id('skills[18]')");
			put("BATHROOM_INSTALLATION_SKILL", "id('skills[18]')");
			put("CCTV_SKILL", "id('skills[68]')");
			put("SUBMIT_FILTER", ".//*[@id='filters']/div/div[5]/a[1]");
		}
	};
	
	@SuppressWarnings("serial")
	public static Map<String,String> dataLookup=new HashMap<String,String>() {
		{
			put("USERNAME","integration.test@ratedtrades.com");	
			put("ADMIN_EMAIL","aaron.barwell@ratedpeople.com");
			put("PASSWORD","password");
			put("TMEMAIL","integration.test@ratedtrades.com");
		}
	}; 
	
}
