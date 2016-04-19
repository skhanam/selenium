package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_tmuserstatus;

import java.util.HashMap;
import java.util.Map;

public class CheckUserXpathlocators {
	
	@SuppressWarnings("serial")
	public static Map<String, String> xpathLookup = new HashMap<String, String>() {
		{
			
			put("MK3_SEARCH","search_search");
			put("CLICK_MK3_SEARCH",".//*[@id='standardSearch']");
			put("USER_DETAILS",".//*[@id='userDetailsForm']/div[2]/ul[1]/li[15]/a");
			put("AGENT_MASQARADE_LOGIN","login_username");
			put("AGENT_MASQARADE_PWD","login_password");
			put("CLICK_MASQAERADE_LOGIN_BUTTON",".//*[@id='login__login']");
			put("SUPPORT_USER_NAME","userName");
			put("SUPPORT_PASSWORD","password");
			put("SUPPORT_LOGININ_BUTTON","btn-log-in");
			put("ADMIN_TAB",".//*[@id='nav']/li[1]/a");
			//put("LUCENE_INFO","html/body/table/tbody/tr[2]/td[1]/center/table/tbody/tr/td/table/tbody/tr[19]/td[2]/div/a");
			put("LUCENE_INFO","LUCENE INFO");
			put("UPDATE_INDEX_BUTTON","info_update index");
			put("MK3SUPPORT_TAB","html/body/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[4]/table/tbody/tr/td[2]/div/a");
			put("SEARCH_TEXT",".//*[@id='search_search']");
			put("GO_BUTTON","standardSearch");
			put("CHECK_STATUS",".//*[@id='userInfo-verified-text']");
		}		
	};

	@SuppressWarnings("serial")
	public static Map<String,String> dataLookup =new HashMap<String,String>(){
		
		{
			put("SUPPORT_LOGOUT","Logout");
			put("SUPPORT_URL","/support");
			put("EMAIL","sangeetha.kumar@ratedpeople.com");
			put("EMAIL1","free.balance@ratedtrades.com");
			put("EMAIL2","newtestsangi2@ratedtrades.com");
			put("EMAIL3","status.notverified@ratedtrades.com");
			put("PASSWORD","password");
		}

		{
			put("SUPPORT_LOGOUT","Logout");
			put("SUPPORT_URL","/support");
			put("EMAIL","sangeetha.kumar@ratedpeople.com");
			put("EMAIL1","free.balance@ratedtrades.com");
			put("EMAIL2","newtestsangi2@ratedtrades.com");
			put("PASSWORD","password");
		}

	};
}
