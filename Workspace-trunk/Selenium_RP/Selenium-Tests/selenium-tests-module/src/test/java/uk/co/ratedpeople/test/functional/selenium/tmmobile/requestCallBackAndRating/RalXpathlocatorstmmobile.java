package uk.co.ratedpeople.test.functional.selenium.tmmobile.requestCallBackAndRating;

import java.util.HashMap;
import java.util.Map;


public class RalXpathlocatorstmmobile {
	
	@SuppressWarnings("serial")
	public static  Map<String,String> xpathLookup =new HashMap<String, String>()
	{
		{
			put("TERMS_AND_CONDITIONS","//html/body/div[2]/div/div/div/h2");
			put("TANDC_CHECKBOX","//*[@id='tmBulletinOverlayAcceptChangesCb']");
			put("TANDC_ACCEPT_OK","//*[@id='tmBulletinOverlayAcceptChangesFormSubmitBtn']");
			put("MEMBERSHIP_OFFER_MESSAGE","//html/body/div[2]/div/div/div/h2[2]");
			put("CUSTOMER_DETAILS","header-h1");
			put("REQUEST_CALLBACK_LINK","link-request-credit");
			put("UNABLE_TO_QUOTE","//html/body/div/div[3]/div[2]/div/p");
			put("LINK_NEXT","link-next");
			put("CONFIRM_ALL_CHECKED","//html/body/div/div[3]/div[2]/form/ul/li/label");
			put("BTN_NEXT","btn-next");
			put("VALIDATION_CHECK","//html/body/div/div[3]/div[2]/form/ul/li/em/label");
			put("CANCEL_LINK","link-cancel");
			put("CHECKBOX_0","called");
			put("CHECKBOX_1","emailed");
			put("CHECKBOX_2","leftMessage");
			put("CALLBACK_REQUESTED","//html/body/div/div[3]/div[2]/div/p");
			put("LINK_TO_CHECK_CALLBACK_REQUESTED","link-view-job");
		    put("CALLBACK_REQUESTED_DATE_CHECK","credit-requested-p");
		    put("REQUEST_RATING_LINK","link-request-rating");
		    put("MORE_INFO","//html/body/div/div[3]/div[2]/div/form/fieldset/h2");
		    put("NO_OF_DAYS_TO_COMPLETE_JOB","AdditionalJobDetails_duration");
		    put("PRICE_OF_THE_JOB","AdditionalJobDetails_price");
		    put("RATING_REQUESTED_CHECK","rating-requested-p");
		    put("BTN_SEND","btn-send");
		    //old ral
		    put("UNABLE_TO_QUOTE_OLD","//html/body/div/div[3]/div[2]/div/p[2]");
		  	put("CREDITREQUEST_REASON_UNABLE_TO_CONTACT","CreditRequest_reason_UNABLE_TO_CONTACT");
		  	put("CONFIRM_ALL_CHECKED_OLD","//html/body/div/div[3]/div[2]/form/ul/li/ul/label");
		  	
		    put("CHECKBOX_0_OLD","CreditRequest_requirements_0");
			put("CHECKBOX_1_OLD","CreditRequest_requirements_1");
			put("CHECKBOX_2_OLD","CreditRequest_requirements_2");
			put("BTN_SUBMIT","btn-submit");
		    put("CALLBACK_REQUESTED","//html/body/div/div[3]/div[2]/div/p");
		    put("SEARCH","search_search");
			put("GO_BUTTON",".//*[@id='standardSearch']");
			put("SELECT_HO_FROM_SEARCH",".//*[@id='bodyContent']/div/table/tbody/tr[3]/td[1]/a");
			put("SELECT_TM_FROM_SEARCH","//html/body/div[1]/div/div[2]/div/table/tbody/tr[33]/td[1]/a");
			put("H0_EMAIL_SENT_BUTTON",".//*[@id='subnav']/ul/li[4]/a");
			
			put("LOAD",".//*[@id='contentInner']/div/table/tbody/tr[3]/td[2]/a");
			put("LAST_JOB_LINK","//html/body/div/div/div[3]/div/div/table/tbody/tr[2]/td[2]/a");
			put("MAIL_CONTENT","//html/body/div/div/div[3]/div/div/table/tbody/tr[2]/td/h2");
			put("CHECK_SMS","//html/body/div/nav/ul/li[5]/a");
			put("HO_CALL_BACK_SMS","//html/body/div/div/div[3]/div/div/table/tbody/tr[2]/td[4]");
			put("CHECK_TM_CALLBACK","//html/body/div[2]/nav/ul/li[18]/a");
		}
	};
	
	@SuppressWarnings("serial")
	public static Map<String,String> dataLookup=new HashMap<String,String>() {
		{
			put("ADMIN_EMAIL","aaron.barwell@ratedpeople.com");
			put("PASSWORD","password");
			put("CONFIRMATION_OF_EMAIL","//html/body/div/div/div[3]/div/div/table/tbody/tr[2]/td/h2");
			put("DESCRIPTION","Submit a job via selenium tests : Full regression testing");
			put("HOEMAIL","testuser1@ratedtrades.com");
			put("TM_EMAIL","raluser_02@ratedtrades.com");
		}
	}; 
	
}
