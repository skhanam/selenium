/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_refreshjbilling;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

/**
 * @author shobha.rani
 * Create a User , Suspend All Active Plans, Refresh JBilling,
 *  User should go to SUSPENDED , RE-ACTIVATE, Refresh JBilling, User should return to ACTIVE
 *
 */
  public class RefreshJBillinginMK3   {
	
	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.coresystems.mk3");	
	private WebDriver driver;
	private Login login;
	public String uniqueEmailAccountName;
	private TestScriptUtilities scriptUtils;
	private SeleniumTestContext context;
	private static final String USER_STATUS_SUSP = "Suspended";
	private static final String SUPPORT_LOGIN_USER_ID = "shobha.rani@ratedpeople.com";
	private static final String SUPPORT_LOGIN_USER__PWD = "password";
	private static final String USER_STATUS_ACTIVE = "Active";
	private static final String TAKE_PAYMENT_HEADER = "Take Payment";
	private static final String CREDITCARD_NUMBER = "5404000000000001";
	private static final String CREDITCARD_CV2_NUMBER="123";
	private static final String NAME_ON_THE_CARD = "B S R Maramreddy";
	private static final String EXISTING_USER_NAME = "233745-20-Mar-2014-@ratedtrades.com";	
	
	 //This method is going to create a new Tradesman on MK3
		
	public RefreshJBillinginMK3(SeleniumTestContext context, TestScriptUtilities scriptUtils){
		
		driver = context.driver;
		this.context = context;
		this.scriptUtils = scriptUtils;
		login = new Login(scriptUtils, context);
	}		
	
		
		public String testCreateNewTradesmanMK3support(String uniqueEmailAccountName) throws Exception {
			createNewTradesmanMK3form(uniqueEmailAccountName);
			return "";
		}
		
		public String createNewTradesmanMK3form(String uniqueEmailAccountName) throws Exception 
		{
			WebDriverWait wait = new WebDriverWait(context.driver, 20);
			login.loginSupport(SUPPORT_LOGIN_USER_ID, SUPPORT_LOGIN_USER__PWD);
			Thread.sleep(1000);
			scriptUtils.click(By.xpath(".//*[@id='nav']/li[4]/a"));
			System.out.println(uniqueEmailAccountName);
			Thread.sleep(1000);
			scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("POST_CODE_UI")));
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("POST_CODE_UI"), RefreshJBillingingXPathLocators.dataLookUp.get("POST_CODE"));
			scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("POSTCODE_SEARCH_UI")));
			scriptUtils.sleep(1000);
			scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[1]/a"));
			scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[2]/a"));
			scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[15]/a"));
			scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[19]/a"));
			scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[29]/a"));
			scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/div/button"));
			scriptUtils.sleep(1000);
			scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/div/button"));
			scriptUtils.sleep(1000);
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("BUSINESS_NAME_UI"), RefreshJBillingingXPathLocators.dataLookUp.get("BUSINESS_NAME_UI"));
			String mobileNewNumber= Integer.toString(TestScriptUtilities.getRandom6digitNumber());
			String mobileNewNumber2 = "07644"+mobileNewNumber;
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("BUSINESS_MOBILE_NO"),mobileNewNumber2 );
			scriptUtils.sleep(1000);			
			scriptUtils.click(RefreshJBillingingXPathLocators.xpathLookup.get("FIND_POSTCODE_BUTTON"));
			scriptUtils.sleep(1000);
			scriptUtils.click(RefreshJBillingingXPathLocators.xpathLookup.get("ADD_NOT_FOUND"));
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("TM_HOUSE_NO"), "1A");
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("TM_STREET_NAME"), "Balfour Road");
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("TM_TOWN_NAME"), "Hounslow");
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("CONTACT_NAME_UI"), RefreshJBillingingXPathLocators.dataLookUp.get("CONTACT_NAME"));
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("TM_EMAIL_NAME"), uniqueEmailAccountName);
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("PASSWORD_ONE_UI"),RefreshJBillingingXPathLocators.dataLookUp.get("PASSWORD"));
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("PASSWORD_TWO_UI"),RefreshJBillingingXPathLocators.dataLookUp.get("PASSWORD"));
			scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("TM_BUS_TYPE_ID")), 2);
			scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("TM_EMP_COUNT")), 2);
			scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("TM_ORIGIN_TYPE_ID")), 2);
			scriptUtils.click(RefreshJBillingingXPathLocators.xpathLookup.get("ACCEPT_TERMS_UI"));
			scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("JOIN_30DAYS_UI")));
			scriptUtils.sleep(1000);
			// Check GB timeout
			scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("BUS_DET_CONFIRM_BUTTON")));
	        scriptUtils.sleep(1000);

	        //enter D.O.B
	        new Select(scriptUtils.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("DOB_DAY")))).selectByVisibleText("6");
	        new Select(scriptUtils.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("DOB_MONTH")))).selectByVisibleText("Apr");
	        new Select(scriptUtils.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("DOB_YEAR")))).selectByVisibleText("1963");
	        new Select(scriptUtils.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("TM_GENDER")))).selectByVisibleText("Male");
	        
	          //personal details page
	        new Select(scriptUtils.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("TM_SAL_TYPE")))).selectByVisibleText("Mr");
	        scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("TM_FIRST_NAME"), RefreshJBillingingXPathLocators.dataLookUp.get("TM_FIRST_NAME"));
	        scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("TM_LAST_NAME"), RefreshJBillingingXPathLocators.dataLookUp.get("TM_LAST_NAME"));
	        // enter postcode will change it later			
			scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("TM_BUS_ROLL_ID")), 2);			
	        scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("POST_CODE_UI"), RefreshJBillingingXPathLocators.dataLookUp.get("POST_CODE"));
	        scriptUtils.click(RefreshJBillingingXPathLocators.xpathLookup.get("FIND_POSTCODE_BUTTON"));
			scriptUtils.sleep(1000);
			scriptUtils.click(RefreshJBillingingXPathLocators.xpathLookup.get("ADD_NOT_FOUND"));
			//enter address details
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("TM_HOUSE_NO"), RefreshJBillingingXPathLocators.dataLookUp.get("DRI_ADDR_HOUSE_NO"));
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("TM_STREET_NAME"), RefreshJBillingingXPathLocators.dataLookUp.get("DRI_ADDR_STREET_NAME"));
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("TM_TOWN_NAME"), RefreshJBillingingXPathLocators.dataLookUp.get("DRI_ADDR_TOWN_NAME"));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("SCREENING_CONFIRM_BUTTON")))).click();
	        scriptUtils.sleep(5000);
	        //PLI Details       
	        /*scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("PLI_INSU_PROVIDER"), RefreshJBillingingXPathLocators.dataLookUp.get("PLI_INSU_PROVIDER_NAME"));
            new Select(scriptUtils.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("PLI_AMOUNT")))).selectByVisibleText("5,000,000");
            scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("PLI_POLICY_NO"), scriptUtils.getRandomString(10));
            scriptUtils.sleep(2000);
            scriptUtils.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("START_DATE"))).click(); 
            scriptUtils.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[4]/a")).click();
            scriptUtils.sleep(2000);
            scriptUtils.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("EXPIRY_DATE"))).click();
            scriptUtils.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[5]/a")).click();
            scriptUtils.sleep(3000);                     
            scriptUtils.findElement(By .xpath(".//*[@id='screening_public-liability-insurance-details']/div[8]/button")).click();*/
             //select the plan
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='selectPlan']/div[1]/button"))).click();
            scriptUtils.sleep(1000);
	        //enter the credit card details  
	        createTMbillingDetails();
	        System.out.println("Successfully created new tm : " +uniqueEmailAccountName); 
	        scriptUtils.sleep(3000);
	        return"" ;
		 }
		
		public String createTMbillingDetails()
		{
			//Enter billing details
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("BILLING_CARDNAME"), NAME_ON_THE_CARD);
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("BILLING_CARD_NUMBER"), CREDITCARD_NUMBER);
			scriptUtils.selectDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("BILLING_EXPIRY_MONTH")), 2);
			scriptUtils.selectDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("BILLING_EXPIRY_YR")), 7);
			scriptUtils.fillInXpathField(RefreshJBillingingXPathLocators.xpathLookup.get("BILLING_CV2"), CREDITCARD_CV2_NUMBER);
		    scriptUtils.click(By.name("method:doSubmit"));
		    scriptUtils.sleep(5000);  	
		    return"";
		}
		
		// Update LUCENE INFO
	
		public void testUpdateLuceneSearch() throws Exception {
	 		WebDriverWait wait = new WebDriverWait(context.driver, 50);
	 		login.loginSupport(SUPPORT_LOGIN_USER_ID, SUPPORT_LOGIN_USER__PWD);
	 		scriptUtils.sleep(3000);	 		
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_ADMIN")))).click();
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(RefreshJBillingingXPathLocators.xpathLookup.get("LUCENE_INFO")))).click();
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_UPDATE_INDEX")))).click();
	 		scriptUtils.sleep(2000);
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(RefreshJBillingingXPathLocators.xpathLookup.get("LOGOUT_FROM_ADMIN")))).click();
	 		}
		
		public void testUpdateLuceneSearch(String uniqueEmailAccountName) throws Exception {
	 		WebDriverWait wait = new WebDriverWait(context.driver, 50);
	 		login.loginSupport(SUPPORT_LOGIN_USER_ID, SUPPORT_LOGIN_USER__PWD);
	 		scriptUtils.sleep(3000);	 		
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_ADMIN")))).click();
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(RefreshJBillingingXPathLocators.xpathLookup.get("LUCENE_INFO")))).click();
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_UPDATE_INDEX")))).click();
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_UPDATE_INDEX")))).click();
	 		System.out.println("Lucene Index updated");
	 		}
		// Test to Suspend user and Refresh Jbiling button on MK3
		 public void testSuspendAllActivePlans(String uniqueEmailAccountName) throws Exception 
		 {
	 		WebDriverWait wait = new WebDriverWait(context.driver, 50);
	 		login.loginSupport(SUPPORT_LOGIN_USER_ID, SUPPORT_LOGIN_USER__PWD);
	 		Thread.sleep(3000);
	 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"))));
	 		scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"), uniqueEmailAccountName);
	 	    scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_MK3_SEARCH")));
	 	    scriptUtils.sleep(3000);
	 	    driver.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"))).clear();
	 	    scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"), uniqueEmailAccountName);
		    scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_MK3_SEARCH")));
		    scriptUtils.sleep(3000);
	 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("SUSPEND_IMMEDIATELY"))));
	 	    scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("SUSPEND_IMMEDIATELY")));
	 	    scriptUtils.sleep(3000);
	 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("REFRESH_JBILLING_BUTTON"))));
	 	    scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("REFRESH_JBILLING_BUTTON")));
	 	    scriptUtils.sleep(5000);
	 	    assertEquals(context.driver.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("USER_STATUS"))).getText(),USER_STATUS_SUSP);
	 	   
		}

       //Re-Activate,Refresh JBilling & Returning USER to ACTIVE
		
		public void testReActivateSuspendUser(String uniqueEmailAccountName) throws Exception 
		{
	 	  WebDriverWait wait = new WebDriverWait(context.driver, 50);
	 	  login.loginSupport(SUPPORT_LOGIN_USER_ID, SUPPORT_LOGIN_USER__PWD);
	 	  Thread.sleep(3000);
	 	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"))));
	 	  scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"), uniqueEmailAccountName );
	 	  scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_MK3_SEARCH")));
	 	  scriptUtils.sleep(5000);
	 	  driver.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"))).clear();
	 	  scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"), uniqueEmailAccountName);
		  scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_MK3_SEARCH")));
		  scriptUtils.sleep(3000);
	 	  scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("PROMO_PLAN")), 2);
	 	  scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("RENEWAL")), 2);
	 	  scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("FOLLOW_ON_PLAN")), 10);
	 	  scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("BUTTON_NEXT")));
	 	  scriptUtils.sleep(5000);
	 	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("BUTTON_CONFIRM_SIGN_UP"))));
	 	  scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("BUTTON_CONFIRM_SIGN_UP")));
	 	  scriptUtils.sleep(5000);
	 	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ccForm']/h1")));
	 	  assertEquals(context.driver.findElement(By.xpath(".//*[@id='ccForm']/h1")).getText(),TAKE_PAYMENT_HEADER);
	 	  // Enter card details
	 	  testMK3TakePaymentDetails();
	 	  scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("REFRESH_JBILLING_BUTTON")));
 	     
		}
		
		// Existing User
		
		public void testExistingUserRefreshJBilling() throws Exception 
		{
		 	WebDriverWait wait = new WebDriverWait(context.driver, 50);
		 	login.loginSupport(SUPPORT_LOGIN_USER_ID, SUPPORT_LOGIN_USER__PWD);
		 	Thread.sleep(3000);
		 	// USER SUSPENDED
		 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"))));
		 	scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"), EXISTING_USER_NAME );
		 	scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_MK3_SEARCH")));
		 	scriptUtils.sleep(3000);
		 	driver.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"))).clear();
	 	    scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"), EXISTING_USER_NAME);
		    scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_MK3_SEARCH")));
		    scriptUtils.sleep(3000);
		 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("SUSPEND_IMMEDIATELY"))));
		 	assertEquals(context.driver.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("USER_STATUS"))).getText(),USER_STATUS_ACTIVE);
		 	scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("SUSPEND_IMMEDIATELY")));
	 	    scriptUtils.sleep(3000);
	 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("REFRESH_JBILLING_BUTTON"))));
	 	    scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("REFRESH_JBILLING_BUTTON")));
	 	    scriptUtils.sleep(5000);
	 	    assertEquals(context.driver.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("USER_STATUS"))).getText(),USER_STATUS_SUSP);
	 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("LOGOUT_MK3"))));
	 	    scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("LOGOUT_MK3")));
	 	    scriptUtils.sleep(3000);	
		}
		
		  //Re-Activate,Refresh JBilling & Returning Existing USER to ACTIVE
		
		public void testReActivateExistingsuspendUser() throws Exception
		{
			 	WebDriverWait wait = new WebDriverWait(context.driver, 50);
			 	login.loginSupport(SUPPORT_LOGIN_USER_ID, SUPPORT_LOGIN_USER__PWD);
			 	Thread.sleep(3000);
			 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"))));
			 	scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"), EXISTING_USER_NAME  );
			 	scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_MK3_SEARCH")));
			 	scriptUtils.sleep(5000);
			 	driver.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"))).clear();
		 	    scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"), EXISTING_USER_NAME);
			    scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_MK3_SEARCH")));
			    scriptUtils.sleep(3000);
			 	scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("PROMO_PLAN")), 2);
			 	scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("RENEWAL")), 2);
			 	scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("FOLLOW_ON_PLAN")), 10);
			 	scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("BUTTON_NEXT")));
			 	scriptUtils.sleep(5000);
			 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("BUTTON_CONFIRM_SIGN_UP"))));
			 	scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("BUTTON_CONFIRM_SIGN_UP")));
			 	scriptUtils.sleep(5000);
			 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ccForm']/h1")));
			 	assertEquals(context.driver.findElement(By.xpath(".//*[@id='ccForm']/h1")).getText(),TAKE_PAYMENT_HEADER);
			 	// Enter card details
			 	testMK3TakePaymentDetails();
			 	scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("REFRESH_JBILLING_BUTTON")));
		 	    scriptUtils.sleep(5000);
		 	    assertEquals(context.driver.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("USER_STATUS"))).getText(),USER_STATUS_ACTIVE);
		 	   
				}
		
		public String testMK3TakePaymentDetails()
		{
			//Enter billing details
			System.out.println("Enter Card details");
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("PAYMENT_CARD_TYPE"),"VISA");
			scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("PAYMENT_CARD_NUMBER"),CREDITCARD_NUMBER);
			scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("PAYMENT_CARD_EXPIRY_MONTH")),4);
			scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("PAYMENT_CARD_EXPIRY_YR")),4);
			scriptUtils.fillInXpathField(RefreshJBillingingXPathLocators.xpathLookup.get("PAYMENT_ISSUE_NUMBER"),CREDITCARD_CV2_NUMBER);
			scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("BUTTON_PAY_ACTIVATE")));
		    scriptUtils.sleep(5000);  	
		    return"";
		}
		
}
