package uk.co.ratedpeople.test.functional.selenium.functions;

import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class CreateTradesman {
	private UniqueEmailAddressGenerator uniqueEmailAddressGenerator;
	public static class TPDetails {
		private String username;
		private String id;
		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}
		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
		}
		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}
		
		
	}

	private String testUrl;
	private Login login;
	public String uniqueEmailAccountName;
	private TestScriptUtilities scriptUtils;
	private SeleniumTestContext context;
	
	@SuppressWarnings("serial")
	public final static Hashtable<String, String> xpathLookUp = new Hashtable<String, String>(){
		{
				put("postcodeUi",".//*[@id='postcode']");
				put("postcodeSearchUi",".//*[@id='postcodeSearchForm']/form/button");
				put("nxtpageUi","next-page");
				put("cardnoUi","card-number");
				put("ccexpiremonthUi","paymentForm_Payment_CCExpireMonth");
				put("ccexpireyrUi","paymentForm_Payment_CCExpireYear");
				put("ccvUi","paymentForm_Payment_CCcv2");
				put("drvNoOne","uk-drivers-form-num1");
				put("drvNoTwo","uk-drivers-form-num2");
				put("drvNoThree","uk-drivers-form-num3");
				put("drvNoFour","uk-drivers-form-num4");
				put("businessNameUi","businessName");
				put("businessLanLineUi","businessLandline");
				put("businessMobLineUi","businessMobileNumber");
				put("contactNameUi","contactName");
				put("passwordOneUi","passwordOne");
				put("passwordTwoUi","passwordTwo");
				put("acceptTermsUi","acceptTerms");
				put("join30DaysUi",".//*[@id='contactDetailsSection']/button");
									
		}
	};
	
	
	@SuppressWarnings("serial")
	private final static Hashtable<String, String> dataLookUp = new Hashtable<String, String>(){
		{
			put("postcode","SO300PY");
			put("password","password");
			put("mobilenumber","07534444842");
			put("cardNo","4929 0000 0000 6");
			put("ccmonth","01");
			put("ccyear","2015");
			put("ccv","123");
			put("drivNoOne","MCLAR");
			put("drivNotwo","702025");
			put("drivNothree","A99");
			put("drivNofour","AB");
			put("businessLanLine","03069990123");
			put("contactName","Albert Mclaren");			
		}};
	
	
	public CreateTradesman(SeleniumTestContext context, TestScriptUtilities scriptUtils){
		testUrl = context.getTestUrl();
		this.context = context;
		this.scriptUtils = scriptUtils;
		login = new Login(scriptUtils, context);
		uniqueEmailAddressGenerator = new UniqueEmailAddressGenerator();
	}

	public String createNewTradesman(String uniqueEmailAccountName) throws Exception {
		createNewTradesmanform(uniqueEmailAccountName);
		return "";
	}
	
	
	public String createNewTradesmanform(String uniqueEmailAccountName) throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 20);

		System.out.println(uniqueEmailAccountName);
		scriptUtils.goTo(testUrl);

		scriptUtils.click(By.xpath(".//*[@id='tmHeaderLink']"));
	    scriptUtils.sleep(1000);
		scriptUtils.click(By.xpath(xpathLookUp.get("postcodeUi")));
		scriptUtils.fillInTextField("postcode", dataLookUp.get("postcode"));
		scriptUtils.click(By.xpath(xpathLookUp.get("postcodeSearchUi")));
		scriptUtils.sleep(1000);
		scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[1]/a"));
		//scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[2]/a"));
		//scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[15]/a"));
		//scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[19]/a"));
		//scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[29]/a"));
		scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/div/button"));
		scriptUtils.sleep(1000);
		scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/div/button"));
		scriptUtils.sleep(1000);
		
		scriptUtils.fillInTextField(xpathLookUp.get("businessNameUi"), uniqueEmailAccountName);
		//scriptUtils.fillInTextField(xpathLookUp.get("businessLanLineUi"), dataLookUp.get("businessLanLine"));
		//scriptUtils.fillInTextField(xpathLookUp.get("businessMobLineUi"), dataLookUp.get("mobilenumber"));
	
		String mobileNewNumber= Integer.toString(TestScriptUtilities.getRandom6digitNumber());
		String mobileNewNumber2 = "07544"+mobileNewNumber;
		scriptUtils.fillInTextField(xpathLookUp.get("businessMobLineUi"),mobileNewNumber2 );
		
		scriptUtils.sleep(1000);
		scriptUtils.click("find-postcode-button");
		scriptUtils.sleep(1000);
		scriptUtils.click("address-not-available");		
		scriptUtils.fillInTextField("tradesman-address-property", "Rose Cottage");
		scriptUtils.fillInTextField("tradesman-address-street", "Hesketh Avenue");
		scriptUtils.fillInTextField("tradesman-address-town", "Oldham");
		//scriptUtils.fillInTextField("tradesman-address-county", "Oldham");
		
		scriptUtils.fillInTextField(xpathLookUp.get("contactNameUi"), dataLookUp.get("contactName"));
		scriptUtils.fillInTextField("emailAddress", uniqueEmailAccountName);
		scriptUtils.fillInTextField(xpathLookUp.get("passwordOneUi"),dataLookUp.get("password") );
		scriptUtils.fillInTextField(xpathLookUp.get("passwordTwoUi"),dataLookUp.get("password"));
		
		
		scriptUtils.clickDropdown(By.id("businessTypeId"), 2);
		scriptUtils.clickDropdown(By.id("employeeCountTypeId"), 2);
		
		scriptUtils.clickDropdown(By.id("originTypeId"), 2);
		
		scriptUtils.click(xpathLookUp.get("acceptTermsUi"));
		scriptUtils.click(By.xpath(".//*[@id='contactDetailsSection']/button"));
		scriptUtils.sleep(1000);
		// Check GB timeout
        scriptUtils.click(By.xpath(".//*[@id='idchoice']/div[1]/button"));
        scriptUtils.sleep(1000);
		scriptUtils.fillInTextField(xpathLookUp.get("drvNoOne"),dataLookUp.get("drivNoOne") );
		scriptUtils.fillInTextField(xpathLookUp.get("drvNoTwo"),dataLookUp.get("drivNotwo") );
		scriptUtils.fillInTextField(xpathLookUp.get("drvNoThree"),dataLookUp.get("drivNothree") );
		scriptUtils.fillInTextField(xpathLookUp.get("drvNoFour"),dataLookUp.get("drivNofour") );
				
		scriptUtils.sleep(1000);

        //enter D.O.B
        new Select(scriptUtils.findElement(By.xpath("//*[@id='dobDay']"))).selectByVisibleText("2");
        new Select(scriptUtils.findElement(By.xpath("//*[@id='dobMonth']"))).selectByVisibleText("Feb");
        new Select(scriptUtils.findElement(By.xpath("//*[@id='dobYear']"))).selectByVisibleText("1975");
        new Select(scriptUtils.findElement(By.xpath("//*[@id='gender']"))).selectByVisibleText("Male");
        
      //  new Select(findElement(By.xpath("//*[@id='businessRoleId']"))).selectByVisibleText("Company Director");
        //personal details page
        new Select(scriptUtils.findElement(By.id("salutationTypeName"))).selectByVisibleText("Mr");
        scriptUtils.findElement(By.id("firstName")).sendKeys("Albert");
        scriptUtils.findElement(By.id("lastName")).sendKeys("McLaren");
        // enter postcode will change it later
        new Select(scriptUtils.findElement(By.id("businessRoleId"))).selectByVisibleText("I'm the sole tradesman");
              
        scriptUtils.fillInXpathField("//*[@id='postcode']", "SO300PY");
        //scriptUtils.click find postcode
        scriptUtils.findElement(By.xpath("//*[@id='find-postcode-button']")).click();
        //scriptUtils.click on address not found
        scriptUtils.findElement(By.xpath("//a[@id='address-not-available']")).click(); 
        //enter address details
        scriptUtils.findElement(By.xpath("//input[@id='tradesman-address-property']")).sendKeys("69");
        scriptUtils.findElement(By.xpath("//input[@id='tradesman-address-street']")).sendKeys("Whitebeam Road");
        scriptUtils.findElement(By.xpath("//*[@id='tradesman-address-town']")).sendKeys("Southampton");             
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='confirmButton']"))).click();
        scriptUtils.sleep(1000);

        //select the plan
        scriptUtils.findElement(By.xpath("//*[@id='selectPlan']/div[1]/button")).click();
        scriptUtils.sleep(1000);
        //enter the credit card details
        createTMbillingDetails();
        
        scriptUtils.clearAndFillInXpathField(".//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[5]/td[2]/input", "password");
	    scriptUtils.sleep(1000);
	    scriptUtils.click(By.xpath(".//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[6]/td[2]/input"));
	    scriptUtils.sleep(10000);
	    assertEquals(scriptUtils.findElement(By.xpath("//*[@id=\"neutral-main-column\"]/section/h1")).getText(), "Welcome to Rated People");
	    scriptUtils.sleep(5000);
        return "";
	}
	
	public String createNewMk3Tradesman(String uniqueEmailAccountName) throws Exception {
		createNewMK3Tradesmanform(uniqueEmailAccountName);
		return "";
	}
	
	
	public String createNewMK3Tradesmanform(String uniqueEmailAccountName) throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 20);

		System.out.println(uniqueEmailAccountName);
		scriptUtils.goTo(testUrl);

		scriptUtils.click(By.xpath(".//*[@id='tmHeaderLink']"));
	    scriptUtils.sleep(3000);
		scriptUtils.click(By.xpath(xpathLookUp.get("postcodeUi")));
		scriptUtils.fillInTextField("postcode", dataLookUp.get("postcode"));
		scriptUtils.click(By.xpath(xpathLookUp.get("postcodeSearchUi")));
		scriptUtils.sleep(5000);
		scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[1]/a"));
		//scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[2]/a"));
		//scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[15]/a"));
		//scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[19]/a"));
		//scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[29]/a"));
		scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/div/button"));
		scriptUtils.sleep(2000);
		scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/div/button"));
		scriptUtils.sleep(3000);
		
		scriptUtils.fillInTextField(xpathLookUp.get("businessNameUi"), uniqueEmailAccountName);
		//scriptUtils.fillInTextField(xpathLookUp.get("businessLanLineUi"), dataLookUp.get("businessLanLine"));
		//scriptUtils.fillInTextField(xpathLookUp.get("businessMobLineUi"), dataLookUp.get("mobilenumber"));
	
		String mobileNewNumber= Integer.toString(TestScriptUtilities.getRandom6digitNumber());
		String mobileNewNumber2 = "07544"+mobileNewNumber;
		scriptUtils.fillInTextField(xpathLookUp.get("businessMobLineUi"),mobileNewNumber2 );
		
		scriptUtils.sleep(3000);
		scriptUtils.click("find-postcode-button");
		scriptUtils.sleep(3000);
		scriptUtils.click("address-not-available");		
		scriptUtils.fillInTextField("tradesman-address-property", "Rose Cottage");
		scriptUtils.fillInTextField("tradesman-address-street", "Hesketh Avenue");
		scriptUtils.fillInTextField("tradesman-address-town", "Oldham");
		//scriptUtils.fillInTextField("tradesman-address-county", "Oldham");
		
		scriptUtils.fillInTextField(xpathLookUp.get("contactNameUi"), dataLookUp.get("contactName"));
		scriptUtils.fillInTextField("emailAddress", uniqueEmailAccountName);
		scriptUtils.fillInTextField(xpathLookUp.get("passwordOneUi"),dataLookUp.get("password") );
		scriptUtils.fillInTextField(xpathLookUp.get("passwordTwoUi"),dataLookUp.get("password"));
		
		
		scriptUtils.clickDropdown(By.id("businessTypeId"), 2);
		scriptUtils.clickDropdown(By.id("employeeCountTypeId"), 2);
		
		scriptUtils.clickDropdown(By.id("originTypeId"), 2);
		
		scriptUtils.click(xpathLookUp.get("acceptTermsUi"));
		scriptUtils.click(By.xpath(".//*[@id='contactDetailsSection']/button"));
		scriptUtils.sleep(4000);
		// Check GB timeout
        scriptUtils.click(By.xpath(".//*[@id='idchoice']/div[1]/button"));
        scriptUtils.sleep(2000);
		scriptUtils.fillInTextField(xpathLookUp.get("drvNoOne"),dataLookUp.get("drivNoOne") );
		scriptUtils.fillInTextField(xpathLookUp.get("drvNoTwo"),dataLookUp.get("drivNotwo") );
		scriptUtils.fillInTextField(xpathLookUp.get("drvNoThree"),dataLookUp.get("drivNothree") );
		scriptUtils.fillInTextField(xpathLookUp.get("drvNoFour"),dataLookUp.get("drivNofour") );
				
		scriptUtils.sleep(10000);

        //enter D.O.B
        new Select(scriptUtils.findElement(By.xpath("//*[@id='dobDay']"))).selectByVisibleText("6");
        new Select(scriptUtils.findElement(By.xpath("//*[@id='dobMonth']"))).selectByVisibleText("Apr");
        new Select(scriptUtils.findElement(By.xpath("//*[@id='dobYear']"))).selectByVisibleText("1963");
        new Select(scriptUtils.findElement(By.xpath("//*[@id='gender']"))).selectByVisibleText("Male");
        
      //  new Select(findElement(By.xpath("//*[@id='businessRoleId']"))).selectByVisibleText("Company Director");
        //personal details page
        new Select(scriptUtils.findElement(By.id("salutationTypeName"))).selectByVisibleText("Mr");
        scriptUtils.findElement(By.id("firstName")).sendKeys("Barry");
        scriptUtils.findElement(By.id("lastName")).sendKeys("Jenkins");
        // enter postcode will change it later
        new Select(scriptUtils.findElement(By.id("businessRoleId"))).selectByVisibleText("I'm the sole tradesman");
              
        scriptUtils.fillInXpathField("//*[@id='postcode']", "SO300PY");
        //scriptUtils.click find postcode
        scriptUtils.findElement(By.xpath("//*[@id='find-postcode-button']")).click();
        //scriptUtils.click on address not found
        scriptUtils.findElement(By.xpath("//a[@id='address-not-available']")).click(); 
        //enter address details
        scriptUtils.findElement(By.xpath("//input[@id='tradesman-address-property']")).sendKeys("69");
        scriptUtils.findElement(By.xpath("//input[@id='tradesman-address-street']")).sendKeys("Whitebeam Road");
        scriptUtils.findElement(By.xpath("//*[@id='tradesman-address-town']")).sendKeys("Southampton");
       
      
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='confirmButton']"))).click();
        scriptUtils.sleep(10000);

        createTMbillingDetails();
        
        scriptUtils.clearAndFillInXpathField(".//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[5]/td[2]/input", "password");
	    scriptUtils.sleep(2000);
	    scriptUtils.click(By.xpath(".//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[6]/td[2]/input"));
	    scriptUtils.sleep(8000);
	    assertEquals(scriptUtils.findElement(By.xpath("//*[@id=\"neutral-main-column\"]/section/h1")).getText(), "Welcome to Rated People");
	    scriptUtils.sleep(2000);
        return "";
	}
	
	public String createTMbillingDetails(){
		//enter billing details
		scriptUtils.fillInXpathField("//*[@id='nameOnCard']", "Barry Jenkins");
		scriptUtils.fillInXpathField("//*[@id='cardNumber']", "5404000000000001");
		scriptUtils.selectDropdown(By.xpath("//*[@id='expireMonth']"), 2);
		scriptUtils.selectDropdown(By.xpath("//*[@id='expireYear']"), 7);
		scriptUtils.fillInXpathField("//*[@id='cv2']", "123");
	    scriptUtils.click(By.name("method:doSubmit"));
	    scriptUtils.sleep(8000);  	
	    return"";
	}

	public String createNewTradesmanFailedVerification() {

		fillFormFailedVerification();
		
		scriptUtils.sleep(3000);
		scriptUtils.click(By.linkText("ADMIN"));
		scriptUtils.click(By.linkText("LUCENE INFO"));
		scriptUtils.click("info_update index");
		
		// Go to support area, find new TP
		scriptUtils.click(By.xpath("//html/body/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[4]/table/tbody/tr/td[2]/div/a"));	
		scriptUtils.fillInTextField("search_search", uniqueEmailAccountName);
		scriptUtils.click("search_0");
		
		context.driver.findElement(By.id("statusDescription"));
		scriptUtils.sleep(3000);
		
		return"";
	}
	
	public String createNewTradesmanProofOfDrvLic() {
		
		fillFormFailedVerification();
		
		scriptUtils.sleep(3000);
		scriptUtils.fillInTextField("personal-details_passwordOne", "password");
		scriptUtils.fillInTextField("personal-details_passwordTwo", "password");
		
		scriptUtils.click("next-page");
		scriptUtils.sleep(3000);
		scriptUtils.fillInTextField("personal-details_passwordOne", "password");
		scriptUtils.fillInTextField("personal-details_passwordTwo", "password");
		
		scriptUtils.click("next-page");
		scriptUtils.sleep(16000);
		
		context.driver.findElement(By.id("personal-details_firstName")).clear();
		scriptUtils.fillInTextField("personal-details_firstName", "Martyn");
		context.driver.findElement(By.id("personal-details_lastName")).clear();	
		scriptUtils.fillInTextField("personal-details_lastName", "Hunter");
	
		context.driver.findElement(By.id("postcode")).clear();
		scriptUtils.fillInTextField("postcode", "OL2 8SJ");
		scriptUtils.click("find-postcode-button");
		
		scriptUtils.click("address-not-available");
		
		scriptUtils.fillInTextField("tradesman-address-property", "Rose Cottage");
		scriptUtils.fillInTextField("tradesman-address-street", "Hesketh Avenue");
		scriptUtils.fillInTextField("tradesman-address-town", "Oldham");
		//scriptUtils.fillInTextField("tradesman-address-county", "Oldham");
		
		scriptUtils.clickDropdown(By.id("dobDay"), 21);
		scriptUtils.clickDropdown(By.id("dobMonth"), 11);
		scriptUtils.clickDropdown(By.id("dobYear"), 34);
		scriptUtils.clickDropdown(By.id("gender"), 2);
		
		scriptUtils.click("proof-UK_DL");
		
		scriptUtils.fillInTextField("uk-drivers-form-num1", "HUNTE");
		scriptUtils.fillInTextField("uk-drivers-form-num2", "610205");
		scriptUtils.fillInTextField("uk-drivers-form-num3", "MK9");
		scriptUtils.fillInTextField("uk-drivers-form-num4", "MN");
		
		
		
		
		scriptUtils.fillInTextField("personal-details_passwordOne", "password");
		scriptUtils.fillInTextField("personal-details_passwordTwo", "password");
		
		scriptUtils.click("next-page");
		scriptUtils.sleep(16000);
		
		return"";
	}

	public String createNewTradesmanProofOfPass() {
		
		fillFormFailedVerification();
		
		scriptUtils.sleep(3000);
		scriptUtils.fillInTextField("personal-details_passwordOne", "password");
		scriptUtils.fillInTextField("personal-details_passwordTwo", "password");
		
		scriptUtils.click("next-page");
		scriptUtils.sleep(3000);
		scriptUtils.fillInTextField("personal-details_passwordOne", "password");
		scriptUtils.fillInTextField("personal-details_passwordTwo", "password");
		
		scriptUtils.click("next-page");
		scriptUtils.sleep(16000);
		
		context.driver.findElement(By.id("personal-details_firstName")).clear();
		scriptUtils.fillInTextField("personal-details_firstName", "Martyn");
		context.driver.findElement(By.id("personal-details_lastName")).clear();	
		scriptUtils.fillInTextField("personal-details_lastName", "Hunter");
	
		context.driver.findElement(By.id("postcode")).clear();
		scriptUtils.fillInTextField("postcode", "OL2 8SJ");
		scriptUtils.click("find-postcode-button");
		
		scriptUtils.click("address-not-available");
		
		scriptUtils.fillInTextField("tradesman-address-property", "Rose Cottage");
		scriptUtils.fillInTextField("tradesman-address-street", "Hesketh Avenue");
		scriptUtils.fillInTextField("tradesman-address-town", "Shaw");
		scriptUtils.fillInTextField("tradesman-address-county", "Oldham");
		
		scriptUtils.clickDropdown(By.id("dobDay"), 21);
		scriptUtils.clickDropdown(By.id("dobMonth"), 11);
		scriptUtils.clickDropdown(By.id("dobYear"), 34);
		scriptUtils.clickDropdown(By.id("gender"), 2);
		
		scriptUtils.click("proof-UK_PP");
		
		scriptUtils.fillInTextField("uk-passport-form-num1", "7086493126");
		scriptUtils.fillInTextField("uk-passport-form-num2", "GBR");
		scriptUtils.fillInTextField("uk-passport-form-num3", "6510204");
		scriptUtils.fillInTextField("uk-passport-form-num4", "M");
		scriptUtils.fillInTextField("uk-passport-form-num5", "1502246");
		scriptUtils.fillInTextField("uk-passport-form-num6", "02");		
		
		scriptUtils.clickDropdown(By.id("ukppExpDay"), 25);
		scriptUtils.clickDropdown(By.id("ukppExpMonth"), 3);
		scriptUtils.clickDropdown(By.id("ukppExpYear"), 14);
		
		
		scriptUtils.fillInTextField("personal-details_passwordOne", "password");
		scriptUtils.fillInTextField("personal-details_passwordTwo", "password");
		
		scriptUtils.click("next-page");
		scriptUtils.sleep(16000);
		
		return"";
	}
	
	public String createNewTradesmanProofOfIntPass() {
		
		fillFormFailedVerification();
		
		scriptUtils.sleep(3000);
		scriptUtils.fillInTextField("personal-details_passwordOne", "password");
		scriptUtils.fillInTextField("personal-details_passwordTwo", "password");
		
		scriptUtils.click("next-page");
		scriptUtils.sleep(3000);
		scriptUtils.fillInTextField("personal-details_passwordOne", "password");
		scriptUtils.fillInTextField("personal-details_passwordTwo", "password");
		
		scriptUtils.click("next-page");
		scriptUtils.sleep(16000);
		
		context.driver.findElement(By.id("personal-details_firstName")).clear();
		scriptUtils.fillInTextField("personal-details_firstName", "Martyn");
		context.driver.findElement(By.id("personal-details_lastName")).clear();	
		scriptUtils.fillInTextField("personal-details_lastName", "Hunter");
	
		context.driver.findElement(By.id("postcode")).clear();
		scriptUtils.fillInTextField("postcode", "OL2 8SJ");
		scriptUtils.click("find-postcode-button");
		
		scriptUtils.click("address-not-available");
		
		scriptUtils.fillInTextField("tradesman-address-property", "Rose Cottage");
		scriptUtils.fillInTextField("tradesman-address-street", "Hesketh Avenue");
		scriptUtils.fillInTextField("tradesman-address-town", "Shaw");
		scriptUtils.fillInTextField("tradesman-address-county", "Oldham");
		
		scriptUtils.clickDropdown(By.id("dobDay"), 21);
		scriptUtils.clickDropdown(By.id("dobMonth"), 11);
		scriptUtils.clickDropdown(By.id("dobYear"), 34);
		scriptUtils.clickDropdown(By.id("gender"), 2);
		
		scriptUtils.click("proof-INTL_PP");
		
		scriptUtils.fillInTextField("int-passport-form-num1", "708649312");
		scriptUtils.fillInTextField("int-passport-form-num2", "6");
		scriptUtils.fillInTextField("int-passport-form-num3", "GBR");
		scriptUtils.fillInTextField("int-passport-form-num4", "6510204");
		scriptUtils.fillInTextField("int-passport-form-num5", "M");
		scriptUtils.fillInTextField("int-passport-form-num6", "1502246");	
		scriptUtils.fillInTextField("int-passport-form-num7", "<<<<<<<<<<<<<<");
		scriptUtils.fillInTextField("int-passport-form-num8", "0");
		scriptUtils.fillInTextField("int-passport-form-num9", "2");
		
		scriptUtils.clickDropdown(By.id("intlppExpDay"), 25);
		scriptUtils.clickDropdown(By.id("intlppExpMonth"), 3);
		scriptUtils.clickDropdown(By.id("intlppExpYear"), 14);
		
		scriptUtils.clickDropdown(By.xpath("//html/body/div/div/div/div/section/form/fieldset/section[9]/section[3]/span/select"), 254);
		
		
		scriptUtils.fillInTextField("personal-details_passwordOne", "password");
		scriptUtils.fillInTextField("personal-details_passwordTwo", "password");
		
		scriptUtils.click("next-page");
		scriptUtils.sleep(16000);
		
		return"";
	}
	
	
	public String createAgent() {
		// 11.03.2011 Covered, works fine, creates agent (Aleksandr)
		scriptUtils.goTo(testUrl); // You need to open BASE_URL to set cookies.
		scriptUtils.goTo(testUrl + "/log-in");
		// Login as admin
		scriptUtils.fillInTextField("userName", context.getAdminCredentials().getUserName());
		scriptUtils.fillInTextField("j_security_check_j_password", context.getAdminCredentials().getPassword());
		scriptUtils.click("j_security_check_0");
		// Open "ADD AGENT" page to fill form
		scriptUtils.click(By.linkText("MK3-SUPPORT"));
		scriptUtils.click(By.linkText("ADD AGENT"));
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		System.out.println("E-mail:" + uniqueEmailAccountName);
		scriptUtils.fillInTextField("addNewSupportUser_firstname", "Test");
		scriptUtils.fillInTextField("addNewSupportUser_lastname", "Agent");
		context.driver.findElement(By.id("addNewSupportUser_emailAddress")).clear();
		scriptUtils.fillInTextField("addNewSupportUser_emailAddress", uniqueEmailAccountName);
		scriptUtils.click("addNewSupportUser__addAgent");

		// XPath of div with password
		String result = context.driver.findElement(By.xpath("//html/body/table/tbody/tr[2]/td[2]/div[2]/div/div/ul/li/span")).getText();
		// Extracting password from text
		String agentPassword = result.substring(result.lastIndexOf(" ") + 1);
		System.out.println("Password: " + agentPassword);

		scriptUtils.click(By.linkText("LOG OUT"));
		scriptUtils.click(By.linkText("Login"));
		// Login as new agent
		scriptUtils.fillInTextField("userName", uniqueEmailAccountName);
		scriptUtils.fillInTextField("j_security_check_j_password", agentPassword);
		scriptUtils.click("j_security_check_0");
		return "";
	}

	public String buyJobFreeLead(String uniqueEmailAccountName) {
		
		scriptUtils.goTo("https://tradesmen.preprod/login");
		// Login as new agent
		scriptUtils.fillInTextField("login_username", uniqueEmailAccountName);
		scriptUtils.fillInTextField("login_password", "123456");
		scriptUtils.click("login__login");

		scriptUtils.click(By.xpath("//html/body/div/div/div[2]/div[2]/div/div[2]/ol/li[2]/p[2]/a"));
		scriptUtils.click("buy-btn");
		scriptUtils.sleep(5000);
		//scriptUtils.click("btn-save");
		scriptUtils.click(By.xpath("//html/body/div/div/div[3]/aside/div[3]/form/p/a"));

		scriptUtils.sleep(5000);
		
		//scriptUtils.click(By.xpath("//html/body/div/div/div[2]/aside/span[3]/p/a"));
		scriptUtils.sleep(5000);
		context.driver.findElement(By.xpath("//*[text()='Contact Info']"));
		scriptUtils.sleep(5000);
		return "";
	}
	
	public String buyJobNewCard() {
		scriptUtils.sleep(5000);
		scriptUtils.clickIfExists(By.className("close")); // Lightbox
		scriptUtils.sleep(5000);
		scriptUtils.click(By.xpath("//html/body/div/div/div/div/div/div[2]/ol/li[2]/p[2]/a"));
		scriptUtils.click("buy-btn");
		
		context.driver.findElement(By.name("name")).sendKeys("Test Tradesman");
		context.driver.findElement(By.name("cardNumber")).sendKeys("4929 0000 0000 6");
		scriptUtils.selectDropdown("purchase-enddate-month", 1);	
		scriptUtils.selectDropdown("purchase-enddate-year", 3);
		context.driver.findElement(By.name("cv2")).sendKeys("123");
		
		//scriptUtils.click(By.xpath("//html/body/div/div/div[2]/aside/div[3]/form/p/a"));
		scriptUtils.click(By.xpath("//html/body/div/div/div[3]/aside/div[3]/form/p/a"));

		context.driver.findElement(By.name("password")).sendKeys("password");
		scriptUtils.click(By.xpath("//input[@type='submit']"));
		
		context.driver.findElement(By.xpath("//*[text()='Contact Info']"));
		scriptUtils.sleep(5000);
		return "";
	}
	
	public String buyJobExistingCard() {
		scriptUtils.click(By.xpath("//html/body/div/div/div/div/div/div[2]/ol/li[2]/p[2]/a"));
		scriptUtils.click("buy-btn");
		scriptUtils.sleep(5000);
		//scriptUtils.click("btn-save");
		//scriptUtils.click(By.xpath("//html/body/div/div/div[2]/aside/div[3]/form/p/a"));
		scriptUtils.click(By.xpath("//html/body/div/div/div[3]/aside/div[3]/form/p/a"));
		scriptUtils.sleep(5000);
		
		//scriptUtils.click(By.xpath("//html/body/div/div/div[2]/aside/span[3]/p/a"));
		scriptUtils.sleep(5000);
		
		context.driver.findElement(By.xpath("//*[text()='Contact Info']"));
		scriptUtils.sleep(5000);
		return "";
	}

	public String buyJobFreeBalance() {
		WebDriverWait wait = new WebDriverWait(context.driver, 20);
		scriptUtils.sleep(5000);
		scriptUtils.click(By.linkText("Job Leads"));
		scriptUtils.sleep(5000);
		scriptUtils.click(By.xpath("//html/body/div/div/div/div/div/div[2]/ol/li[2]/p[2]/a"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buy-btn")));
		scriptUtils.click("buy-btn");
		scriptUtils.sleep(5000);
		//scriptUtils.click(By.className("btn-save"));
		scriptUtils.click(By.xpath("//html/body/div/div/div[4]/aside/div[3]/form/p/a"));
		scriptUtils.sleep(12000);
		
		context.driver.findElement(By.xpath("//*[text()='Contact Info']"));
		scriptUtils.sleep(1000);
		return "";
	}
	
	
	public String createNewTradesmanMK2() throws Exception{
		uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		fillFormOverriden(uniqueEmailAccountName);
		scriptUtils.sleep(5000);
		scriptUtils.click("input-button-NEXT");
		scriptUtils.fillInTextField("card-number", "4929 0000 0000 6");
		scriptUtils.selectDropdown("Payment_CCStartMonth", 2);
		scriptUtils.selectDropdown("Payment_CCStartYear", 1);		
		scriptUtils.selectDropdown("Payment_CCExpireMonth", 2);
		scriptUtils.selectDropdown("Payment_CCExpireYear", 5);
		context.driver.findElement(By.name("Payment_CCcv2")).sendKeys("123");
		scriptUtils.fillInTextField("cardholder-name", "Firstname Surname");	
		scriptUtils.click("input-button-PAY_ACTIVATE"); //changed id Aaron 20/5/2011 (added input-)
		
		scriptUtils.click(By.linkText("LOG OUT"));
		login.loginTP(uniqueEmailAccountName, "123456");
		
		buyJobExistingCard();
		
	return "";	
	}
	
	
	public String createNewTradesmanMK3Verified(String uniqueEmailAccountName) throws Exception{
		WebDriverWait wait = new WebDriverWait(context.driver, 20);
		fillFormVerified(uniqueEmailAccountName);
		scriptUtils.click("input-button-NEXT");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-button-CONFIRM")));
		scriptUtils.click("input-button-CONFIRM");
		scriptUtils.fillInTextField("card-number", "4929 0000 0000 6");
		scriptUtils.selectDropdown("Payment_CCStartMonth", 2);
		scriptUtils.selectDropdown("Payment_CCStartYear", 1);		
		scriptUtils.selectDropdown("Payment_CCExpireMonth", 2);
		scriptUtils.selectDropdown("Payment_CCExpireYear", 5);
		context.driver.findElement(By.name("Payment_CCcv2")).sendKeys("123");
		scriptUtils.fillInTextField("cardholder-name", "Firstname Surname");	
		scriptUtils.click("input-button-PAY_ACTIVATE"); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("LOG OUT")));
		scriptUtils.click(By.linkText("LOG OUT"));
		login.loginTP(uniqueEmailAccountName, "123456");
		scriptUtils.sleep(3000);
		context.driver.findElement(By.id("accountDetails"));
		scriptUtils.click(By.xpath("//html/body/div/header/div/p/a"));
		
	return "";
	}

/*	public String createNewTradesmanMK3VerifiedJBilling(String uniqueEmailAccountName){
		fillFormVerified(uniqueEmailAccountName);
		scriptUtils.click("input-button-NEXT");
		scriptUtils.fillInTextField("card-number", "4929 0000 0000 6");
		selectDropdown("Payment_CCStartMonth", 2);
		selectDropdown("Payment_CCStartYear", 1);		
		selectDropdown("Payment_CCExpireMonth", 2);
		selectDropdown("Payment_CCExpireYear", 5);
		context.driver.findElement(By.name("Payment_CCcv2")).sendKeys("123");
		scriptUtils.fillInTextField("cardholder-name", "Firstname Surname");	
		scriptUtils.click("input-button-PAY_ACTIVATE"); //changed id Aaron 20/5/2011 (added input-)
	return "";
	}*/
	
	/*public TPDetails createNewTradesmanMK3JBilling(){
		WebDriverWait wait = new WebDriverWait(context.driver, 20);
		uniqueEmailAccountName = Utilities.getUniqueEmailAccountNameJBilling();
		fillFormOverriden(uniqueEmailAccountName);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-button-NEXT")));
		//waitForAccountPageToLoad();
		//scriptUtils.click(By.id("400"));
		scriptUtils.click("input-button-NEXT");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-button-CONFIRM")));
		scriptUtils.click("input-button-CONFIRM");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card-number")));
		scriptUtils.fillInTextField("card-number", "4929 0000 0000 6");
		scriptUtils.selectDropdown("Payment_CCStartMonth", 2);
		scriptUtils.selectDropdown("Payment_CCStartYear", 1);		
		scriptUtils.selectDropdown("Payment_CCExpireMonth", 2);
		scriptUtils.selectDropdown("Payment_CCExpireYear", 5);
		context.driver.findElement(By.name("Payment_CCcv2")).sendKeys("123");
		scriptUtils.fillInTextField("cardholder-name", "Firstname Surname");	
		scriptUtils.click("input-button-PAY_ACTIVATE");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userInfo-jbillingId")));
				
		String id = null;
		boolean waitingForInfo = true;
		while (waitingForInfo) {
			id = context.driver.findElement(By.id("userInfo-jbillingId")).getText();
			if (id != null && !id.equals("")) {
				waitingForInfo = false;
			}
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("LOG OUT")));
		scriptUtils.click(By.linkText("LOG OUT"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));
		scriptUtils.click(By.linkText("Login"));
		scriptUtils.sleep(3000);
		scriptUtils.fillInTextField("tpUserName", uniqueEmailAccountName);
		scriptUtils.fillInTextField("tpPassword", "123456");
		scriptUtils.click("login-as-tp-button");
		

		
		
		TPDetails tpDetails = new TPDetails();
		tpDetails.setId(id);
		tpDetails.setUsername(uniqueEmailAccountName);
		//buyJobFreeLead();
		
		login.loginTP(uniqueEmailAccountName, "123456");
		scriptUtils.sleep(4000);
		scriptUtils.click("asideButton");
		scriptUtils.sleep(15000);
		scriptUtils.click(By.xpath("//html/body/div/div/div/form/nav/ul/li[4]/a"));
		//scriptUtils.sleep(7000);
		scriptUtils.click(By.xpath("//html/body/div/div/div/form/div[6]/section/div[3]/fieldset/footer/button"));
		scriptUtils.click(By.xpath("//html/body/div/div/div/form/div[6]/section/div[3]/fieldset/footer/input"));

		scriptUtils.sleep(7000);
		context.driver.findElement(By.xpath("//*[text()='200 texts']"));
		
		
		scriptUtils.click(By.linkText("Job Alerts"));
		
		//buyJobExistingCard();
		
	return tpDetails;	
	}

*/
	
	public String forgotPassword() throws Exception{
		String result;
		String url;
		String password;
		scriptUtils.goTo(testUrl);
		scriptUtils.click(By.linkText("Login"));
		scriptUtils.click(By.linkText("Forgotten your password?"));
		scriptUtils.fillInTextField("mail-new-password_email", "aleksandr01@ratedtrades.com");
		scriptUtils.click(By.name("action"));
		scriptUtils.click(By.className("button"));
		login.login(context.getAdminCredentials());
		
		scriptUtils.click(By.linkText("MK3-SUPPORT"));
		// scriptUtils.fillInTextField("search_search", uniqueEmailAccountName);
		scriptUtils.fillInTextField("search_search", "aleksandr01@ratedtrades.com");
		scriptUtils.click("search_0");
		scriptUtils.click(By.linkText("Emails Sent"));
		
		scriptUtils.click(By.xpath("//html/body/div/div/div[3]/div/table/tbody/tr[2]/td[2]/a"));
		result = context.driver.findElement(By.xpath("//html/body/div/div/div[3]/div/div/p/code")).getText(); 
		//System.out.println(result);
		
		// Extracting validation URL
		url = result.substring(result.indexOf("\n") + 1);
		//url = url.substring(url.indexOf("\n") + 1);
		url = url.substring(url.indexOf("\n") + 1);		
		url = url.substring(47, url.indexOf(","));
		System.out.println("Validation URL: " + url);
		scriptUtils.click(By.linkText("LOG OUT"));
		scriptUtils.goTo(url);
		scriptUtils.sleep(3000);

		login.login(context.getAdminCredentials());
		
		scriptUtils.click(By.linkText("MK3-SUPPORT"));
		// scriptUtils.fillInTextField("search_search", uniqueEmailAccountName);
		scriptUtils.fillInTextField("search_search", "aleksandr01@ratedtrades.com");
		scriptUtils.click("search_0");
		scriptUtils.click(By.linkText("Emails Sent"));
		
		scriptUtils.click(By.xpath("//html/body/div/div/div[3]/div/table/tbody/tr[2]/td[2]/a"));
		
		result = context.driver.findElement(By.xpath("//html/body/div/div/div[3]/div/div/p/code")).getText(); 
		//System.out.println(result);
		
		// Extracting password
		password = result.substring(result.indexOf("\n") + 1);
		password = password.substring(password.indexOf("\n") + 1);		
		password = password.substring(18, password.indexOf("\n"));
		System.out.println("Password: " + password);
		
		scriptUtils.click(By.linkText("LOG OUT"));
		login.login("aleksandr01@ratedtrades.com", password);
		scriptUtils.click(By.linkText("My account"));
		
		scriptUtils.fillInTextField("index_oldPassword", password);
		scriptUtils.fillInTextField("index_newPassword", "password");
		scriptUtils.fillInTextField("index_rePassword", "password");
	 
	//    scriptUtils.click(By.linkText("LOG OUT"));
		  
		login.login("aleksandr01@ratedtrades.com", "password");
		scriptUtils.sleep(5000);
		
		return"";
	}
	
	public void fillFormOverriden(String uniqueEmailAccountName) throws Exception {
		scriptUtils.goTo(testUrl);
		login.login(context.getAdminCredentials());
		scriptUtils.goTo(testUrl+"/supportN/member/addTrader/addNewTradesman");
		scriptUtils.sleep(2000);
		scriptUtils.selectDropdown("addNewTradesman_salutation", 1);
		scriptUtils.fillInTextField("addNewTradesman_firstName", "Test");
		scriptUtils.fillInTextField("addNewTradesman_surName", "Account");
		scriptUtils.fillInTextField("newTraderForm_companyName", uniqueEmailAccountName);
		scriptUtils.fillInTextField("newTraderForm_contactName","John Smith");
		scriptUtils.fillInTextField("newTraderForm_email", uniqueEmailAccountName);
		System.out.println("Email: "+uniqueEmailAccountName);
		System.out.println("Password: 123456");
		scriptUtils.fillInTextField("newTraderForm_mobileNumber", "07777777775");
		
		scriptUtils.selectDropdown("dobDay", 2);
		scriptUtils.selectDropdown("dobMonth", 2);
		scriptUtils.selectDropdown("dobYear", 2);
		scriptUtils.selectDropdown("gender", 2);
		
		scriptUtils.fillInTextField("postcode", "sw1e6dr");
		scriptUtils.click("findPostcodeButton");
		scriptUtils.sleep(2000);
		// scriptUtils.click on an entry in the address select control:
		//scriptUtils.clickDropdown(By.id("tradesman-address"), 1);
		//scriptUtils.sleep(2000);
		scriptUtils.click(By.xpath("//html/body/table/tbody/tr[2]/td[2]/div[2]/div/form/div/div/div/ul[2]/li/select/option[3]"));

		
		scriptUtils.click("skipIdChk");
		
		//context.driver.findElement(By.xpath("//html/body/table/tbody/tr[2]/td[2]/div[2]/div/form/div/div[2]/div/ul/li/input")).scriptUtils.click();
		
		scriptUtils.click(By.xpath("//html/body/table/tbody/tr[2]/td[2]/div[2]/div/form/div/div[2]/div/ul/li/input"));
		scriptUtils.sleep(4000);
		scriptUtils.click(By.xpath("//html/body/table/tbody/tr[2]/td[2]/div[2]/div/form/div/div[2]/div[2]/div/ul/li/input"));
		
		scriptUtils.click("trial-btn");
		scriptUtils.fillInTextField("elecSafeNumber", "001122");
		scriptUtils.fillInTextField("elecEengineerName", "Test Name");	
		
		scriptUtils.selectDropdown(By.xpath("//html/body/table/tbody/tr[2]/td[2]/div[2]/div/form/div/div[2]/div[6]/ul[2]/li[3]/span[2]/div/select"), 2);
		scriptUtils.selectDropdown(By.xpath("//html/body/table/tbody/tr[2]/td[2]/div[2]/div/form/div/div[2]/div[6]/ul[2]/li[3]/span[2]/div/select[2]"), 2);
		scriptUtils.selectDropdown(By.xpath("//html/body/table/tbody/tr[2]/td[2]/div[2]/div/form/div/div[2]/div[6]/ul[2]/li[3]/span[2]/div/select[3]"), 2);
		scriptUtils.selectDropdown("partpSel", 2);

		scriptUtils.click("trial-btn");		
		scriptUtils.sleep(7000);
		
	}
	
	public void fillFormVerified(String uniqueEmailAccountName) throws Exception {
		scriptUtils.goTo(testUrl);
		login.login(context.getAdminCredentials());
		scriptUtils.goTo(testUrl+"/supportN/member/addTrader/addNewTradesman");
		scriptUtils.selectDropdown("addNewTradesman_salutation", 1);
		scriptUtils.fillInTextField("addNewTradesman_firstName", "Martin");
		scriptUtils.fillInTextField("addNewTradesman_surName", "Fisher");
		scriptUtils.fillInTextField("newTraderForm_companyName", "Plumber Company");
		scriptUtils.fillInTextField("newTraderForm_contactName", "Mr. Plumber");
		scriptUtils.fillInTextField("newTraderForm_email", uniqueEmailAccountName);
		System.out.println("Email: "+uniqueEmailAccountName);
		System.out.println("Password: 123456");
		scriptUtils.fillInTextField("newTraderForm_mobileNumber", "07777777165");
		
		scriptUtils.selectDropdown("dobDay", 12);
		scriptUtils.selectDropdown("dobMonth", 8);
		scriptUtils.selectDropdown("dobYear", 45);
		scriptUtils.selectDropdown("gender", 2);
		
		scriptUtils.fillInTextField("postcode", "PL15 7PW");
		scriptUtils.click("findPostcodeButton");
		scriptUtils.sleep(2000);
		// scriptUtils.click on an entry in the address select control:
		//scriptUtils.clickDropdown(By.id("tradesman-address"), 1);
		//scriptUtils.sleep(2000);
		scriptUtils.click(By.xpath("//html/body/table/tbody/tr[2]/td[2]/div[2]/div/form/div/div/div/ul[2]/li/select/option[82]"));

		
		scriptUtils.click("verify-btn");
		scriptUtils.sleep(10000);
		
		// Check GB timeout
		if(context.driver.findElements(By.xpath("//html/body/table/tbody/tr[2]/td[2]/div[2]/div/form/div/div/div/ul[3]/li")).size()!= 0){
			
			scriptUtils.click("verify-btn");
			scriptUtils.sleep(5000);
		}
		
		//context.driver.findElement(By.xpath("//html/body/table/tbody/tr[2]/td[2]/div[2]/div/form/div/div[2]/div/ul/li/input")).scriptUtils.click();
		
		scriptUtils.click(By.xpath("//html/body/table/tbody/tr[2]/td[2]/div[2]/div/form/div/div[2]/div/ul/li/input"));
		
		scriptUtils.sleep(2000);
		scriptUtils.click(By.xpath("//html/body/table/tbody/tr[2]/td[2]/div[2]/div/form/div/div[2]/div[2]/div/ul/li/input"));

		
		
		scriptUtils.click("trial-btn");
		scriptUtils.fillInTextField("elecSafeNumber", "001122");
		scriptUtils.fillInTextField("elecEengineerName", "Test Name");	
		
		scriptUtils.selectDropdown(By.xpath("//html/body/table/tbody/tr[2]/td[2]/div[2]/div/form/div/div[2]/div[6]/ul[2]/li[3]/span[2]/div/select"), 2);
		scriptUtils.selectDropdown(By.xpath("//html/body/table/tbody/tr[2]/td[2]/div[2]/div/form/div/div[2]/div[6]/ul[2]/li[3]/span[2]/div/select[2]"), 2);
		scriptUtils.selectDropdown(By.xpath("//html/body/table/tbody/tr[2]/td[2]/div[2]/div/form/div/div[2]/div[6]/ul[2]/li[3]/span[2]/div/select[3]"), 2);
		scriptUtils.selectDropdown("partpSel", 2);

		scriptUtils.click("trial-btn");		
		scriptUtils.sleep(50000);
		
	}
	
	public void fillFormFailedVerification() {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		System.out.println(uniqueEmailAccountName);
		scriptUtils.goTo(testUrl);

		scriptUtils.click(By.xpath("//html/body/div/div/header/nav/ul/li[3]/a"));
		scriptUtils.click(By.xpath("//html/body/div/div/div/div/div/section/a"));
		scriptUtils.sleep(2000);
		scriptUtils.fillInTextField("personal-details_userName", uniqueEmailAccountName);
		scriptUtils.fillInTextField("personal-details_businessOrHomeContactDetails_phoneMobile", "07534444842");
	
		scriptUtils.fillInTextField("personal-details_firstName", "John");
		scriptUtils.fillInTextField("personal-details_lastName", "Smith");
		scriptUtils.fillInTextField("personal-details_businessOrHomeContactDetails_name", uniqueEmailAccountName);
	
		scriptUtils.fillInTextField("postcode", "SW1E 6DR");
		scriptUtils.click("find-postcode-button");
		//scriptUtils.clickDropdown(By.id("tradesman-address"), 2);
		scriptUtils.click(By.xpath("//html/body/div/div/div/div/section/form/fieldset/section[4]/section[6]/section/select/option[4]"));
		
		
		scriptUtils.clickDropdown(By.id("dobDay"), 13);
		scriptUtils.clickDropdown(By.id("dobMonth"), 9);
		scriptUtils.clickDropdown(By.id("dobYear"), 45);
		scriptUtils.clickDropdown(By.id("gender"), 2);
		
		scriptUtils.fillInTextField("uk-drivers-form-num1", "HUNTE");
		scriptUtils.fillInTextField("uk-drivers-form-num2", "610205");
		scriptUtils.fillInTextField("uk-drivers-form-num3", "MK9");
		scriptUtils.fillInTextField("uk-drivers-form-num4", "MN");
		
		scriptUtils.fillInTextField("personal-details_passwordOne", "password");
		scriptUtils.fillInTextField("personal-details_passwordTwo", "password");
		
		
		scriptUtils.click("personal-details_acceptTerms");
		scriptUtils.click("next-page");
	}
	public String changePhoneAndPostcode(String uniqueEmailAccountName) throws Exception {
		scriptUtils.goTo(testUrl);
		login.login(context.getAdminCredentials());
		scriptUtils.click(By.partialLinkText("MK3-SUPPORT"));
		scriptUtils.fillInTextField("search_search", uniqueEmailAccountName);
		scriptUtils.click("search_0");
		scriptUtils.click(By.linkText("Personal Details"));
		
		scriptUtils.fillInTextField("postcode-Business", "SW1E6DR");
		scriptUtils.click("findPostcodeButton-Business");
		scriptUtils.sleep(1000);
		//scriptUtils.click("tradesmanAddress-Business");
		//scriptUtils.clickDropdown(By.id("tradesmanAddress-Business"), 2);
		
		scriptUtils.click("updateCompanyDetails__updateCompanyContactDetails");
		scriptUtils.fillInTextField("business-address-street", "The Street");
		scriptUtils.fillInTextField("business-address-town", "London");
		scriptUtils.click("updateCompanyDetails__updateCompanyContactDetails");
		context.driver.findElement(By.id("userDetailsForm_businessOrHomeContactDetails_phoneMobile")).clear();
		scriptUtils.fillInTextField("userDetailsForm_businessOrHomeContactDetails_phoneMobile", "0711223344");
		scriptUtils.click(By.cssSelector("html body div#container div#content div#contentInner sj:head form#userDetailsForm div.displayBox ul.default li.last input.submitButton"));
		scriptUtils.sleep(5000);
		return "";
	}
	
	public String changePhoneAndPostcodeTPAPP(String uniqueEmailAccountName) {
		scriptUtils.goTo(testUrl);
		
		login.loginTP(uniqueEmailAccountName, "password");
		scriptUtils.sleep(5000);
		
		//scriptUtils.clickIfExists(By.className("close"));
		scriptUtils.clickIfExists(By.xpath("//html/body/div[2]/a"));// Lightbox
		scriptUtils.sleep(5000);
		scriptUtils.click(By.xpath("//html/body/div/header/div/nav/ul/li[3]/a"));
		scriptUtils.sleep(2000);
		scriptUtils.click(By.xpath("//html/body/div/div/div[4]/section/div/span/a"));
		scriptUtils.sleep(2000);
		context.driver.findElement(By.xpath("//html/body/div/div/div[4]/section/div/span[2]/ul/li[4]/span/input")).clear();
		context.driver.findElement(By.xpath("//html/body/div/div/div[4]/section/div/span[2]/ul/li[4]/span/input")).sendKeys("Contact Name");
		
		context.driver.findElement(By.xpath("//html/body/div/div/div[4]/section/div/span[2]/ul/li[5]/span/input")).clear();
		context.driver.findElement(By.xpath("//html/body/div/div/div[4]/section/div/span[2]/ul/li[5]/span/input")).sendKeys("07777770000");
		scriptUtils.click(By.xpath("//html/body/div/div/div[4]/section/div/span[2]/div/a"));
		scriptUtils.sleep(2000);
		scriptUtils.click(By.xpath("//html/body/div/div/div[4]/section/div[2]/span/a"));
		scriptUtils.sleep(2000);
		context.driver.findElement(By.xpath("//html/body/div/div/div[4]/section/div[2]/span/span/form/ul/li/input")).sendKeys("SW1E 6DR");
		scriptUtils.click("findPostcode");
		scriptUtils.sleep(3000);
		scriptUtils.selectDropdown("newAddress", 4);
		scriptUtils.sleep(1000);
		scriptUtils.click(By.xpath("//html/body/div/div/div[4]/section/div[2]/span/span/form/div/a"));
		scriptUtils.sleep(2000);
		
		return "";
	}
   //This method is going to create a new Tradesman on MK3
	
	public String createNewTradesmanMK3(String uniqueEmailAccountName) throws Exception {
		createNewTradesmanMK3form(uniqueEmailAccountName);
		return "";
	}
	
	public String createNewTradesmanMK3form(String uniqueEmailAccountName) throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 20);
		login.loginSupport("sangeetha.kumar@ratedpeople.com", "password");
		Thread.sleep(1000);
		scriptUtils.click(By.xpath(".//*[@id='nav']/li[4]/a"));
		System.out.println(uniqueEmailAccountName);
		Thread.sleep(1000);
		scriptUtils.click(By.xpath(xpathLookUp.get("postcodeUi")));
		scriptUtils.fillInTextField("postcode", dataLookUp.get("postcode"));
		scriptUtils.click(By.xpath(xpathLookUp.get("postcodeSearchUi")));
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
		
		scriptUtils.fillInTextField(xpathLookUp.get("businessNameUi"), uniqueEmailAccountName);
		//scriptUtils.fillInTextField(xpathLookUp.get("businessLanLineUi"), dataLookUp.get("businessLanLine"));
		//scriptUtils.fillInTextField(xpathLookUp.get("businessMobLineUi"), dataLookUp.get("mobilenumber"));
		String mobileNewNumber= Integer.toString(TestScriptUtilities.getRandom6digitNumber());
		String mobileNewNumber2 = "07544"+mobileNewNumber;
		scriptUtils.fillInTextField(xpathLookUp.get("businessMobLineUi"),mobileNewNumber2 );
		scriptUtils.sleep(1000);
		scriptUtils.click("find-postcode-button");
		scriptUtils.sleep(1000);
		scriptUtils.click("address-not-available");		
		scriptUtils.fillInTextField("tradesman-address-property", "Rose Cottage");
		scriptUtils.fillInTextField("tradesman-address-street", "Hesketh Avenue");
		scriptUtils.fillInTextField("tradesman-address-town", "Oldham");
		//scriptUtils.fillInTextField("tradesman-address-county", "Oldham");
		
		scriptUtils.fillInTextField(xpathLookUp.get("contactNameUi"), dataLookUp.get("contactName"));
		scriptUtils.fillInTextField("emailAddress", uniqueEmailAccountName);
		scriptUtils.fillInTextField(xpathLookUp.get("passwordOneUi"),dataLookUp.get("password") );
		scriptUtils.fillInTextField(xpathLookUp.get("passwordTwoUi"),dataLookUp.get("password"));
		
		scriptUtils.clickDropdown(By.id("businessTypeId"), 2);
		scriptUtils.clickDropdown(By.id("employeeCountTypeId"), 2);
		
		scriptUtils.clickDropdown(By.id("originTypeId"), 2);
		scriptUtils.click(xpathLookUp.get("acceptTermsUi"));
		
		scriptUtils.click(By.xpath(".//*[@id='contactDetailsSection']/button"));
		scriptUtils.sleep(1000);
		// Check GB timeout
		
        scriptUtils.click(By.xpath(".//*[@id='idchoice']/button"));
        scriptUtils.sleep(1000);

        //enter D.O.B
        new Select(scriptUtils.findElement(By.xpath("//*[@id='dobDay']"))).selectByVisibleText("6");
        new Select(scriptUtils.findElement(By.xpath("//*[@id='dobMonth']"))).selectByVisibleText("Apr");
        new Select(scriptUtils.findElement(By.xpath("//*[@id='dobYear']"))).selectByVisibleText("1963");
        new Select(scriptUtils.findElement(By.xpath("//*[@id='gender']"))).selectByVisibleText("Male");
        
      //  new Select(findElement(By.xpath("//*[@id='businessRoleId']"))).selectByVisibleText("Company Director");
        //personal details page
        new Select(scriptUtils.findElement(By.id("salutationTypeName"))).selectByVisibleText("Mr");
        scriptUtils.findElement(By.id("firstName")).sendKeys("Barry");
        scriptUtils.findElement(By.id("lastName")).sendKeys("Jenkins");
        // enter postcode will change it later
		
		scriptUtils.clickDropdown(By.id("businessRoleId"), 2);
		
        scriptUtils.fillInXpathField("//*[@id='postcode']", "SO300PY");
        //scriptUtils.click find postcode
        scriptUtils.findElement(By.xpath("//*[@id='find-postcode-button']")).click();
        //scriptUtils.click on address not found
        scriptUtils.findElement(By.xpath("//a[@id='address-not-available']")).click(); 
        //enter address details
        scriptUtils.findElement(By.xpath("//input[@id='tradesman-address-property']")).sendKeys("69");
        scriptUtils.findElement(By.xpath("//input[@id='tradesman-address-street']")).sendKeys("Whitebeam Road");
        scriptUtils.findElement(By.xpath("//*[@id='tradesman-address-town']")).sendKeys("Southampton");            
               
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='confirmButton']"))).click();
        scriptUtils.sleep(5000);
        
        //select the plan
        scriptUtils.findElement(By.xpath("//*[@id='selectPlan']/div[1]/button")).click();
        scriptUtils.sleep(1000);
        //enter the credit card details  
        createTMbillingDetails();
        System.out.println("Successfully created new tm : " +uniqueEmailAccountName); 
        scriptUtils.sleep(5000);
         return"" ;
	 }

	public CreateTradesman.TPDetails createNewTradesmanMK3JBilling() throws Exception {
		
		uniqueEmailAccountName = uniqueEmailAddressGenerator.getUniqueEmailAccountNameJBilling();
		createNewTradesmanMK3Billingform(uniqueEmailAccountName);
        
		scriptUtils.sleep(1000);
		login.loginSupport("sangeetha.kumar@ratedpeople.com", "password");
		scriptUtils.sleep(2000);
		scriptUtils.click(By.xpath(".//*[@id='nav']/li[1]/a"));
		scriptUtils.sleep(2000);
		scriptUtils.click(By.xpath("html/body/table/tbody/tr[2]/td[1]/center/table/tbody/tr/td/table/tbody/tr[19]/td[2]/div/a"));
		scriptUtils.sleep(2000);
		scriptUtils.click(By.xpath(".//*[@id='info_update index']"));
		scriptUtils.sleep(2000);
		scriptUtils.click(By.xpath("html/body/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[4]/table/tbody/tr/td[2]/div/a"));
		scriptUtils.sleep(6000);
		scriptUtils.fillInXpathField(".//*[@id='search_search']",uniqueEmailAccountName);
		scriptUtils.sleep(3000);
		scriptUtils.click(By.xpath(".//*[@id='search_0']"));
		scriptUtils.sleep(5000);
		String id = null;
		boolean waitingForInfo = true;
		while (waitingForInfo) {
			id = context.driver.findElement(By.id("userInfo-jbillingId")).getText();
			if (id != null && !id.equals("")) {
				waitingForInfo = false;
			}
		}
		scriptUtils.sleep(5000);
		CreateTradesman.TPDetails tpDetails = new CreateTradesman.TPDetails();
		tpDetails.setUsername(uniqueEmailAccountName);
		
		tpDetails.setId(id);
		return tpDetails;
	}
	
	public String createNewTradesmanMK3Billingform(String uniqueEmailAccountName) throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 20);
		//Login in as support user
		login.loginSupport("sangeetha.kumar@ratedpeople.com", "password");
		scriptUtils.sleep(3000);
		
		//click the TP signup link
		scriptUtils.click(By.xpath(".//*[@id='nav']/li[3]/a"));
		Thread.sleep(3000);
		
		//Enter postcode
		scriptUtils.click(By.xpath(xpathLookUp.get("postcodeUi")));
		scriptUtils.fillInTextField("postcode", dataLookUp.get("postcode"));
		scriptUtils.click(By.xpath(xpathLookUp.get("postcodeSearchUi")));
		scriptUtils.sleep(3000);
		
		//Select the trades
		scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[1]/a"));
		scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[17]/a"));
		scriptUtils.sleep(2000);
		scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/div/button"));
		scriptUtils.sleep(3000);
		
		//Select the work region
		scriptUtils.click(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/div/button"));
		scriptUtils.sleep(1000);
		
		//Enter the business details
		//final String noDomain = uniqueEmailAccountName.substring(0, uniqueEmailAccountName.indexOf("@"));
		scriptUtils.fillInTextField(xpathLookUp.get("businessNameUi"), "Mah Business Ltd");
		String mobileNewNumber= Integer.toString(TestScriptUtilities.getRandom6digitNumber());
		String mobileNewNumber2 = "0752441"+mobileNewNumber;
		scriptUtils.fillInTextField(xpathLookUp.get("businessMobLineUi"),mobileNewNumber2 );
		
		scriptUtils.sleep(1000);
		scriptUtils.click("find-postcode-button");
				
		//click the cant find address 
		scriptUtils.click("address-not-available");
		scriptUtils.fillInTextField("tradesman-address-property", "Rose Cottage");
		scriptUtils.fillInTextField("tradesman-address-street", "Hesketh Avenue");
		scriptUtils.fillInTextField("tradesman-address-town", "Oldham");
		
		
		scriptUtils.fillInTextField(xpathLookUp.get("contactNameUi"), dataLookUp.get("contactName"));
		scriptUtils.fillInTextField("emailAddress", uniqueEmailAccountName);
		scriptUtils.fillInTextField("passwordOne","password");
		scriptUtils.fillInTextField("passwordTwo","password");
		
		scriptUtils.clickDropdown(By.id("businessTypeId"), 2);
		scriptUtils.clickDropdown(By.id("employeeCountTypeId"), 2);
		
		scriptUtils.clickDropdown(By.id("originTypeId"), 2);
		
		scriptUtils.click(xpathLookUp.get("acceptTermsUi"));
		scriptUtils.click(By.xpath(".//*[@id='contactDetailsSection']/button"));
		scriptUtils.sleep(4000);
		
		// Check GB timeout ..it works fine
		
		scriptUtils.click(By.xpath(".//*[@id='idchoice']/button"));
        scriptUtils.sleep(2000);
        
        //enter D.O.B
        new Select(scriptUtils.findElement(By.xpath("//*[@id='dobDay']"))).selectByVisibleText("6");
        new Select(scriptUtils.findElement(By.xpath("//*[@id='dobMonth']"))).selectByVisibleText("Apr");
        new Select(scriptUtils.findElement(By.xpath("//*[@id='dobYear']"))).selectByVisibleText("1963");
        new Select(scriptUtils.findElement(By.xpath("//*[@id='gender']"))).selectByVisibleText("Male");
        
      //  new Select(findElement(By.xpath("//*[@id='businessRoleId']"))).selectByVisibleText("Company Director");
        //personal details page
        new Select(scriptUtils.findElement(By.id("salutationTypeName"))).selectByVisibleText("Mr");
        scriptUtils.findElement(By.id("firstName")).sendKeys("Barry");
        scriptUtils.findElement(By.id("lastName")).sendKeys("Jenkins");
        new Select(scriptUtils.findElement(By.id("businessRoleId"))).selectByVisibleText("I'm the sole tradesman");
        
        // enter postcode will change it later
        scriptUtils.fillInXpathField("//*[@id='postcode']", "SO300PY");
        //scriptUtils.click find postcode
        scriptUtils.findElement(By.xpath("//*[@id='find-postcode-button']")).click();
        //scriptUtils.click on address not found
        scriptUtils.findElement(By.xpath("//a[@id='address-not-available']")).click(); 
        //enter address details
        scriptUtils.findElement(By.xpath("//input[@id='tradesman-address-property']")).sendKeys("69");
        scriptUtils.findElement(By.xpath("//input[@id='tradesman-address-street']")).sendKeys("Whitebeam Road");
        scriptUtils.findElement(By.xpath("//*[@id='tradesman-address-town']")).sendKeys("Southampton");
       
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='confirmButton']"))).click();
        scriptUtils.sleep(5000);
        
//        scriptUtils.findElement(By.xpath("//*[@id='selectPlan']/div[1]/button")).click();
//        scriptUtils.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monthlyPlan"))).click();
        scriptUtils.sleep(5000);
        
        scriptUtils.fillInXpathField("//*[@id='nameOnCard']", "Peter Giles");
		scriptUtils.fillInXpathField("//*[@id='cardNumber']", "5404000000000001");
		scriptUtils.selectDropdown(By.xpath("//*[@id='expireMonth']"), 2);
		scriptUtils.selectDropdown(By.xpath("//*[@id='expireYear']"), 7);
		scriptUtils.fillInXpathField("//*[@id='cv2']", "123");
	    scriptUtils.click(By.name("method:doSubmit"));
	    scriptUtils.sleep(8000);  	
	       
        System.out.println("Successfully created new tm : " +uniqueEmailAccountName); 
        scriptUtils.sleep(2000);
        return "" ;	
	 }
	
	}
	
	

