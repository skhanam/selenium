package uk.co.ratedpeople.test.functional.selenium.newtmsignup;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class NewTradesmanSignUp {
	private WebDriver driver;
	private String testUrl;
	private Login login;
	private WebDriverWait wait;
	private TestScriptUtilities scriptUtils;
	private SeleniumTestContext context;
	
	//Ruh
	public static final String DATE_PICKER_MONTH = "//span[@class='ui-datepicker-month']";
	public static final String DATE_PICKER_YEAR = "//span[@class='ui-datepicker-year']";
	public static final String DATE_PICKER_PREV = "//span[@class='ui-icon ui-icon-circle-triangle-w";
	public static final String DATE_PICKER_NEXT = "//span[@class='ui-icon ui-icon-circle-triangle-e']";
	
	
	public NewTradesmanSignUp(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		driver = context.driver;
		testUrl = context.getTestUrl();
		this.context = context; 
		
		wait = new WebDriverWait(driver, 60);
		login = new Login(scriptUtils, context);
		
	}
	
	public void switchToWindow()
	{
		String parentWindow = driver.getWindowHandle();
		for(String winMemberBenefit : driver.getWindowHandles())
		{
			  if (!parentWindow.equals(winMemberBenefit))
			  {
			    driver.switchTo().window(winMemberBenefit);
			    break;
			  }
		}
				
	}

	public String newTmSignUpDrivingLicense(String uniqueEmailAccountName) {
		createTM1step(uniqueEmailAccountName);
		//enter driving licence details
     	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("method:chooseDrivingLicence"))).click();
		driver.findElement(By.xpath("//*[@id='uk-drivers-form-num1']")).sendKeys("JENKI");
        driver.findElement(By.xpath("//*[@id='uk-drivers-form-num2']")).sendKeys("604063");
        driver.findElement(By.xpath("//*[@id='uk-drivers-form-num3']")).sendKeys("B99");
        driver.findElement(By.xpath("//*[@id='uk-drivers-form-num4']")).sendKeys("MN");
		//enter D.O.B
        new Select(driver.findElement(By.xpath("//*[@id='dobDay']"))).selectByVisibleText("6");
        new Select(driver.findElement(By.xpath("//*[@id='dobMonth']"))).selectByVisibleText("Apr");
        new Select(driver.findElement(By.xpath("//*[@id='dobYear']"))).selectByVisibleText("1963");
        new Select(driver.findElement(By.xpath("//*[@id='gender']"))).selectByVisibleText("Male");
        //personal details page
        new Select(driver.findElement(By.id("salutationTypeName"))).selectByVisibleText("Mr");
        driver.findElement(By.id("firstName")).sendKeys("Barry");
        driver.findElement(By.id("lastName")).sendKeys("Jenkins");
        //#8973 user is prompted for Role with the business when they sign up             
         new Select(driver.findElement(By.xpath("//*[@id='businessRoleId']"))).selectByVisibleText("I'm not a trademan, but the manager of the Rated People account");    
        // enter postcode will change it later
        scriptUtils.fillInXpathField("//*[@id='postcode']", "SO30 0PY");
        //scriptUtils.click find postcode
        driver.findElement(By.xpath("//*[@id='find-postcode-button']")).click();
        //scriptUtils.click on address not found
        driver.findElement(By.xpath("//a[@id='address-not-available']")).click(); 
        //enter address details
        driver.findElement(By.xpath("//input[@id='tradesman-address-property']")).sendKeys("69");
        driver.findElement(By.xpath("//input[@id='tradesman-address-street']")).sendKeys("Whitebeam Road");
        driver.findElement(By.xpath("//*[@id='tradesman-address-town']")).sendKeys("Southampton");      
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='confirmButton']"))).click();
        scriptUtils.sleep(5000);
        //Adding PLI Test -- Ruhulla.mohammed
        //newTMPLIDetails();    
        driver.findElement(By.id("monthlyPlan")).click();
        scriptUtils.sleep(2000);     
        createTMbillingDetails();       		
		
        /*scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(3000);
        scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(3000);
        scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(3000);
        //https://dev3.uk.ratedpeople/tradesman-signup/induction-customer-details
        scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(3000);
        //https://dev3.uk.ratedpeople/tradesman-signup/induction-contact-customer
        scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(3000);
        scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(3000);
        //https://dev3.uk.ratedpeople/tradesman-signup/induction-closing-video
        scriptUtils.click(By.className("edit-btn"));*/
        
		return "";
	}
	public String newTmSignUpGBRPassport(String uniqueEmailAccountName) {
		createTM1step(uniqueEmailAccountName);
		//enter driving licence details
		scriptUtils.sleep(2000);
		//scriptUtils.click(By.name("method:choosePassport"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("method:choosePassport"))).click();
		new Select(driver.findElement(By.xpath("//*[@id='countryOfOrigin']"))).selectByVisibleText("GBR");
		scriptUtils.fillInXpathField("//*[@id='passport-form-num1']", "2986543702");
		scriptUtils.fillInXpathField("//*[@id='passport-form-num2']", "GBR");
		scriptUtils.fillInXpathField("//*[@id='passport-form-num3']", "6304065");
		scriptUtils.fillInXpathField("//*[@id='passport-form-num4']", "M");
		scriptUtils.fillInXpathField("//*[@id='passport-form-num5']", "1606063");
		scriptUtils.fillInXpathField("//*[@id='passport-form-num6']", "06");
		new Select(driver.findElement(By.xpath("//*[@id='expiryDay']"))).selectByVisibleText("6");
        new Select(driver.findElement(By.xpath("//*[@id='expiryMonth']"))).selectByVisibleText("Jun");
        new Select(driver.findElement(By.xpath("//*[@id='expiryYear']"))).selectByVisibleText("2016");
		new Select(driver.findElement(By.xpath("//*[@id='dobDay']"))).selectByVisibleText("6");
        new Select(driver.findElement(By.xpath("//*[@id='dobMonth']"))).selectByVisibleText("Apr");
        new Select(driver.findElement(By.xpath("//*[@id='dobYear']"))).selectByVisibleText("1963");
        new Select(driver.findElement(By.xpath("//*[@id='gender']"))).selectByVisibleText("Male");
        //personal details page
        new Select(driver.findElement(By.id("salutationTypeName"))).selectByVisibleText("Mr");
        driver.findElement(By.id("firstName")).sendKeys("Barry");
        driver.findElement(By.id("lastName")).sendKeys("Jenkins");
        //#8973 user is prompted for Role with the business when they sign up             
        new Select(driver.findElement(By.xpath("//*[@id='businessRoleId']"))).selectByVisibleText("I'm not a trademan, but the manager of the Rated People account");
        // enter post code will change it later
        scriptUtils.fillInXpathField("//*[@id='postcode']", "SO300PY");
        //scriptUtils.click find post code
        driver.findElement(By.xpath("//*[@id='find-postcode-button']")).click();
        //scriptUtils.click on address not found
        driver.findElement(By.xpath("//a[@id='address-not-available']")).click(); 
        //enter address details
        driver.findElement(By.xpath("//input[@id='tradesman-address-property']")).sendKeys("69");
        driver.findElement(By.xpath("//input[@id='tradesman-address-street']")).sendKeys("Whitebeam Road");
        driver.findElement(By.xpath("//*[@id='tradesman-address-town']")).sendKeys("Southampton");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='confirmButton']"))).click();
        scriptUtils.sleep(6000); 
        //Adding PLI Test -- Ruhulla.mohammed
        //newTMPLIDetails();
        driver.findElement(By.id("monthlyPlan")).click();
        scriptUtils.sleep(2000);
        createTMbillingDetails();
        
        /*scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(2000);
        scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(2000);
        scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(2000);
        scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(2000);
        scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(2000);
        scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(2000);
        scriptUtils.click(By.className("edit-btn"));*/
        return"";
	}

	
	public String newTmSignUpIntPassport(String uniqueEmailAccountName) {
		createTM1step(uniqueEmailAccountName);
	    //enter international passport details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("method:choosePassport"))).click();
		new Select(driver.findElement(By.xpath("//*[@id='countryOfOrigin']"))).selectByVisibleText("Other");
		scriptUtils.fillInXpathField("//*[@id='passport-form-num1']", "708649312");
		scriptUtils.fillInXpathField("//*[@id='passport-form-num2']", "6");
		scriptUtils.fillInXpathField("//*[@id='passport-form-num3']", "GBR");
		scriptUtils.fillInXpathField("//*[@id='passport-form-num4']", "6510204");
		scriptUtils.fillInXpathField("//*[@id='passport-form-num5']", "M");
		scriptUtils.fillInXpathField("//*[@id='passport-form-num6']", "1502246");
		scriptUtils.fillInXpathField("//*[@id='passport-form-num7']", "<<<<<<<<<<<<<<");
		scriptUtils.fillInXpathField("//*[@id='passport-form-num8']", "0");
		scriptUtils.fillInXpathField("//*[@id='passport-form-num9']", "2");	
		
        new Select(driver.findElement(By.xpath("//*[@id='expiryDay']"))).selectByVisibleText("24");
        new Select(driver.findElement(By.xpath("//*[@id='expiryMonth']"))).selectByVisibleText("Feb");
        new Select(driver.findElement(By.xpath("//*[@id='expiryYear']"))).selectByVisibleText("2015");
		
        new Select(driver.findElement(By.xpath("//*[@id='dobDay']"))).selectByVisibleText("20");
        new Select(driver.findElement(By.xpath("//*[@id='dobMonth']"))).selectByVisibleText("Oct");
        new Select(driver.findElement(By.xpath("//*[@id='dobYear']"))).selectByVisibleText("1965");
        new Select(driver.findElement(By.xpath("//*[@id='gender']"))).selectByVisibleText("Male");
        
        //personal details page
        new Select(driver.findElement(By.id("salutationTypeName"))).selectByVisibleText("Mr");
        driver.findElement(By.id("firstName")).sendKeys("Martyn");
        driver.findElement(By.id("lastName")).sendKeys("Hunter");
        //#8973 user is prompted for Role with the business when they sign up       
         new Select(driver.findElement(By.xpath("//*[@id='businessRoleId']"))).selectByVisibleText("I'm not a trademan, but the manager of the Rated People account");
        // enter post code will change it later
        scriptUtils.fillInXpathField("//*[@id='postcode']", "OL2 8SJ");
        //scriptUtils.click find post code
        driver.findElement(By.xpath("//*[@id='find-postcode-button']")).click();
        driver.findElement(By.xpath("//a[@id='address-not-available']")).click(); 
        //enter address details
        driver.findElement(By.xpath("//input[@id='tradesman-address-property']")).sendKeys("Rose Cottage");
        driver.findElement(By.xpath("//input[@id='tradesman-address-street']")).sendKeys("Hesketh Avenue");
        driver.findElement(By.xpath("//*[@id='tradesman-address-town']")).sendKeys("Shaw");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='confirmButton']"))).click();
        scriptUtils.sleep(6000); 
       // PLI 
        //newTMPLIDetails();  
        driver.findElement(By.id("annualPlan")).click();
        scriptUtils.sleep(2000);
        createTMbillingDetails();
        
        /*scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(2000);
        scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(2000);
        scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(2000);
        scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(2000);
        scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(2000);
        scriptUtils.click(By.name("method:next"));
        scriptUtils.sleep(2000);
        scriptUtils.click(By.className("edit-btn"));*/
        return"";
	}
	
	
	public String changePhoneAndPostcodeTPAPP(String uniqueEmailAccountName) {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		scriptUtils.goTo(testUrl);
		login.loginTP(uniqueEmailAccountName, "password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Account"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit personal Details"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[2]/div/div[4]/section/div[1]/span[2]/ul/li[5]/span/input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[2]/div/div[4]/section/div[1]/span[2]/ul/li[5]/span/input"))).sendKeys("07145678911");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save changes"))).click();
		scriptUtils.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Change address"))).click();
		scriptUtils.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[2]/div/div[4]/section/div[2]/span/span/form/ul/li/input"))).sendKeys("SW1E 6DR");
		scriptUtils.click("findPostcode");
		scriptUtils.sleep(3000);
		scriptUtils.selectDropdown("newAddress", 4);
		scriptUtils.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save"))).click();
		scriptUtils.sleep(2000);
		
		return "";
	}
	
	public String createTM1step(String uniqueEmailAccountName){
	System.out.println(uniqueEmailAccountName);
	scriptUtils.goTo(testUrl + "/tradesman-signup/enter-postcode");
	//no postcode entered and assert error
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
	assertEquals(driver.findElement(By.xpath("//em[@class='error hidden']")).getText(), "Enter a valid UK postcode");
	//enter wrong postcode and assert for error
	driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("SW1E66AU");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	assertEquals(driver.findElement(By.xpath("//em[@class='error hidden']")).getText(), "Enter a valid UK postcode");
	driver.findElement(By.xpath("//input[@id='postcode']")).clear();
	//enter correct postcode and scriptUtils.click next
	driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("SO30 0PY");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	scriptUtils.sleep(3000);
	//scriptUtils.click next without selecting a trade, assert for error message
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	assertEquals(driver.findElement(By.xpath("//em[@class='error hidden']")).getText(), "Select at least one trade");
	//select and deselect Tiler
	scriptUtils.click(By.xpath("//*[@id='neutral-main-column']/section[1]/form/ul/li[27]/a"));
	scriptUtils.sleep(3000);
	scriptUtils.click(By.xpath("//*[@id='neutral-main-column']/section[1]/form/ul/li[27]/a"));
	//kitchen
	driver.findElement(By.xpath("//*[@id='neutral-main-column']/section[1]/form/ul/li[14]/a")).click();
	scriptUtils.sleep(3000);
	//Plumbing
	driver.findElement(By.xpath("//*[@id='neutral-main-column']/section[1]/form/ul/li[21]/a")).click();
	//scriptUtils.click next
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	//set work area to 50 miles
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='radius']"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='radiusList']/li[6]"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
	scriptUtils.sleep(3000);
	//assert post code is displayed
	Assert.assertTrue(driver.findElement(By.xpath("//input[@value='SO300PY']")).isDisplayed());
	//scriptUtils.click find post code
	scriptUtils.click(By.xpath("//*[@id='find-postcode-button']"));
	//scriptUtils.click can't find address
	scriptUtils.sleep(3000);
	scriptUtils.click(By.xpath("//*[@id='address-not-available']"));
	scriptUtils.fillInXpathField("//*[@id='tradesman-address-property']", "69");
	scriptUtils.fillInXpathField("//*[@id='tradesman-address-street']", "whitebeam road");
	scriptUtils.fillInXpathField("//*[@id='tradesman-address-town']", "southampton");
	//enter an invalid bus name
	scriptUtils.fillInXpathField("//*[@id='businessName']", "kofi[]");
	//enter a land line instead of mobile
	String landnum1=Integer.toString(TestScriptUtilities.getRandom6digitNumber());			
	String landnum="0208"+landnum1;
	scriptUtils.fillInXpathField("//*[@id='businessMobileNumber']",landnum);
    // wrong contact name entered
	scriptUtils.fillInXpathField("//*[@id='contactName']", "kofi123");
	//enter a email address in use
	scriptUtils.fillInXpathField("//*[@id='emailAddress']", "kkgbonse@ratedtrades.com");
	//short password entered
	scriptUtils.sleep(3000);
	scriptUtils.fillInXpathField("//*[@id='passwordOne']", "13335");
	scriptUtils.fillInXpathField("//*[@id='passwordTwo']", "13335");
	//select how did u hear of us
	scriptUtils.sleep(3000);
	scriptUtils.selectDropdown(By.xpath("//*[@id='originTypeId']"), 8);
	//terms and condition
	scriptUtils.click(By.xpath("//*[@id='contactDetailsSection']/button"));
	scriptUtils.sleep(4000);
	//assert all errors
	assertEquals(driver.findElement(By.xpath("//*[@id='businessDetailsForm']/div[1]/em")).getText(),"Special characters are not allowed in the company name, ie - ':', '[', ']'.");
	assertEquals(driver.findElement(By.xpath(".//*[@id='businessDetailsForm']/div[2]/em")).getText(), "Please enter a valid mobile phone number.");
	assertEquals(driver.findElement(By.xpath("//*[@id='contactDetailsSection']/div[1]/em")).getText(), "Please enter a valid contact name.");
    //assertEquals(driver.findElement(By.xpath("//*[@id='contactDetailsSection']/div[2]/em")).getText(), "The email address is already in use, log in or call Customer Service");
	assertEquals(driver.findElement(By.xpath("//*[@id='contactDetailsSection']/div[3]/em")).getText(), "Please enter a password of 6 or more characters.");
	//enter business name
	scriptUtils.clear(By.xpath("//*[@id='businessName']"));
	scriptUtils.fillInXpathField("//*[@id='businessName']", "Yo-nana ltd");
	//business land line
	scriptUtils.clear(By.xpath("//*[@id='businessLandline']"));
	//fillInXpathField("//*[@id='businessLandline']", "02084424289");
	//fill in Bus mobile number
	scriptUtils.clear(By.xpath("//*[@id='businessMobileNumber']"));
	String mobnum1=Integer.toString(TestScriptUtilities.getRandom6digitNumber());			
	String mobnum="07959"+mobnum1;
	scriptUtils.fillInXpathField("//*[@id='businessMobileNumber']",mobnum);
	scriptUtils.clear(By.xpath("//*[@id='contactName']"));
	scriptUtils.fillInXpathField("//*[@id='contactName']", "kwame Nkrumah");
	scriptUtils.clear(By.xpath("//*[@id='emailAddress']"));
	scriptUtils.fillInXpathField("//*[@id='emailAddress']", uniqueEmailAccountName);	
    System.out.println("Email: "+uniqueEmailAccountName);
    //enter password
    scriptUtils.fillInXpathField("//*[@id='passwordOne']", "password");
    scriptUtils.fillInXpathField("//*[@id='passwordTwo']", "password");
    scriptUtils.selectDropdown(By.xpath("//*[@id='businessTypeId']"), 2);
    scriptUtils.selectDropdown(By.xpath("//*[@id='employeeCountTypeId']"), 2);
    scriptUtils.selectDropdown(By.xpath("//*[@id='originTypeId']"), 8);
    
   /* //UserAgreement
    String parentHandle = driver.getWindowHandle(); 
    driver.findElement(By.xpath(".//*[@id='contactDetailsSection']/div[8]/ul/li[1]/a[1]")).click(); 

   for (String winHandle : driver.getWindowHandles()) {
     driver.switchTo().window(winHandle); 
   }
   scriptUtils.sleep(6000);
   assertEquals(driver.findElement(By.xpath("html/body/div[2]/div/div[2]/section/h1")).getText(),"Trade Business User Agreement");
   driver.close(); 
   driver.switchTo().window(parentHandle);
   
   //PrivacyPolices
   String parentHandle1 = driver.getWindowHandle(); 
   driver.findElement(By.xpath(".//*[@id='contactDetailsSection']/div[8]/ul/li[1]/a[2]")).click(); 

   for (String winHandle : driver.getWindowHandles()) {
     driver.switchTo().window(winHandle); 
   }
   scriptUtils.sleep(6000);
   assertEquals(driver.findElement(By.xpath("html/body/div[2]/div/div[2]/section/h1")).getText(),"Privacy Policy");
   driver.close(); 
   driver.switchTo().window(parentHandle1);  
   
   //TradesmanCodeOfConduct
   String parentHandle2 = driver.getWindowHandle(); 
   driver.findElement(By.xpath(".//*[@id='contactDetailsSection']/div[8]/ul/li[2]/a")).click(); 

   for (String winHandle : driver.getWindowHandles()) {
     driver.switchTo().window(winHandle); 
   }
   scriptUtils.sleep(6000);
   assertEquals(driver.findElement(By.xpath("html/body/div[2]/div/div[2]/section/h1")).getText(),"Trade Business Code of Conduct");
   driver.close(); 
   driver.switchTo().window(parentHandle2);  */
    
    //scriptUtils.click join
	scriptUtils.click(By.xpath("//*[@id='contactDetailsSection']/button"));
	System.out.println("Potential Tradesman created");
    //TM Register page starts
	scriptUtils.sleep(6000);
	return"";
	}
	
	public String createTMbillingDetails(){
	    //assert CCA number is available on Billing Screen
		assertEquals(driver.findElement(By.xpath(".//*[@id='page-header']/p/strong")).getText(),"0207 192 1240");
		//enter billing details
		scriptUtils.fillInXpathField("//*[@id='nameOnCard']", "Barry Jenkins");
		scriptUtils.fillInXpathField("//*[@id='cardNumber']", "5404000000000001");
		scriptUtils.selectDropdown(By.xpath("//*[@id='expireMonth']"), 2);
		scriptUtils.selectDropdown(By.xpath("//*[@id='expireYear']"), 7);
		scriptUtils.fillInXpathField("//*[@id='cv2']", "123");
		scriptUtils.click(By.name("method:doSubmit"));
		scriptUtils.sleep(8000);
		scriptUtils.fillInXpathField("//html/body/table/tbody/tr[2]/td/form/table/tbody/tr[5]/td[2]/input","password");
		scriptUtils.click(By.xpath("//html/body/table/tbody/tr[2]/td/form/table/tbody/tr[6]/td[2]/input"));
		scriptUtils.sleep(15000); 
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("neutral-main-column"))).getText();
		//System.out.println("Welcome to Rated People"); 
		return"";
	}
	
	
	public String createTMbillingDetail(){
	    //assert CCA number is available on Billing Screen
		assertEquals(driver.findElement(By.xpath(".//*[@id='page-header']/p/strong")).getText(),"0207 192 1240");
		//enter billing details
		scriptUtils.fillInXpathField("//*[@id='nameOnCard']", "Barry Jenkins");
		scriptUtils.fillInXpathField("//*[@id='cardNumber']", "5404000000000001");
		scriptUtils.selectDropdown(By.xpath("//*[@id='expireMonth']"), 2);
		scriptUtils.selectDropdown(By.xpath("//*[@id='expireYear']"), 7);
		scriptUtils.fillInXpathField("//*[@id='cv2']", "123");
		scriptUtils.click(By.name("method:doSubmit"));
		scriptUtils.sleep(8000);
		scriptUtils.fillInXpathField("//html/body/table/tbody/tr[2]/td/form/table/tbody/tr[5]/td[2]/input","password");
		scriptUtils.click(By.xpath("//html/body/table/tbody/tr[2]/td/form/table/tbody/tr[6]/td[2]/input"));
		scriptUtils.sleep(10000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("neutral-main-column"))).getText();
		System.out.println("Welcome to Rated People"); 
		return"";
	}
 
	@SuppressWarnings("static-access")
	public void newTMPLIDetails()
	{
        assertEquals(driver.findElement(By.xpath("//html/body/div/div[2]/div/div/div/section/h1")).getText(), "Please enter your public liability insurance details");
        //-ve Testing
        driver.findElement(By .xpath(".//*[@id='screening_public-liability-insurance-details']/div[8]/button")).click();      
        scriptUtils.sleep(2000); 
        assertEquals(driver.findElement(By.xpath(".//*[@id='screening_public-liability-insurance-details']/div[1]/em")).getText(),"Enter your policy provider");
        assertEquals(driver.findElement(By.xpath(".//*[@id='screening_public-liability-insurance-details']/div[2]/em")).getText(), "Select liability amount");
        assertEquals(driver.findElement(By.xpath(".//*[@id='screening_public-liability-insurance-details']/div[3]/em")).getText(), "Your policy number is too short");
        assertEquals(driver.findElement(By.xpath(".//*[@id='screening_public-liability-insurance-details']/div[4]/em")).getText(), "Enter your policy start date");
        assertEquals(driver.findElement(By.xpath(".//*[@id='screening_public-liability-insurance-details']/div[5]/em")).getText(), "Enter your policy expiry date");
        scriptUtils.sleep(2000);
        //+ve Testing
        scriptUtils.fillInXpathField("//*[@id='selectableInsuranceProvider']", "PLITest");
        new Select(driver.findElement(By.xpath("//*[@id='selectableLiabilityInsuranceAmountId']"))).selectByVisibleText("5,000,000");
        scriptUtils.fillInXpathField("//*[@id='policyNumber']", scriptUtils.getRandomString(10));
        scriptUtils.sleep(2000);
        driver.findElement(By.id("startDate")).click(); 
        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr/td[6]/a")).click();
        scriptUtils.sleep(2000);
        driver.findElement(By.id("expiryDate")).click();
        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[7]/a")).click();
        scriptUtils.sleep(3000);
        driver.findElement(By .xpath(".//*[@id='screening_public-liability-insurance-details']/div[8]/button")).click();
        scriptUtils.sleep(5000);
		
	}
	
}
