package uk.co.ratedpeople.test.functional.selenium.newtmmembershipcampaign;


import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.ParseException;
import java.util.logging.Level;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.DataBaseHelper;
import uk.co.ratedpeople.HttpRequestCreator;
import uk.co.ratedpeople.HttpRequestExecutor;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;


/**
 * @author ruhulla.mohammad
 * Proactive Membership Drive(PMD)
 */
public class PMDOfferForNewTMSignUpVarE extends TestScript {
	
	public static final String HO_EMAIL = "postjob569@ratedtrades.com";
	private static final String TRADESMAN_PASSWORD = "password";
	private static final String TRADESMAN_USERNAME = "integration.test@ratedtrades.com";
	
	private WebDriver driver;
	private String testUrl;
	private Login login;
	private WebDriverWait wait;
	private TestScriptUtilities scriptUtils;

	private HttpRequestCreator requestCreator;
	private HttpRequestExecutor requestExecutor;
	private SeleniumTestContext testContext;
			
	
	public PMDOfferForNewTMSignUpVarE(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		driver = context.driver;
		testUrl = context.getTestUrl();
		wait = new WebDriverWait(driver, 60);
		login = new Login(scriptUtils, context);

		this.requestExecutor = new HttpRequestExecutor();
		try {
			this.testContext = SeleniumTestContext.getDefault();
		} catch (IOException exception) {
			LOGGER.log(Level.SEVERE, "Exception assigning TestContext to member! (will wrap this in a RuntimeException and throw that)", exception);
			throw new RuntimeException(exception);
		}
		this.requestCreator = new HttpRequestCreator(testContext);
		
}
	
	public void newTmSignUp(String uniqueEmailAccountName) {
		testbusinessdetails(uniqueEmailAccountName);
		testDrivingLicenceScreeningdetails(uniqueEmailAccountName);
		testGBRPassportScreeningdetails(uniqueEmailAccountName);
		
	}
	
	public void testbusinessdetails(String uniqueEmailAccountName){
		System.out.println(uniqueEmailAccountName);
		scriptUtils.goTo(testUrl + "/tradesman-signup/enter-postcode");
		//Enter Post code
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("SO30 0PY");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		scriptUtils.sleep(3000);
		//Select trades 
		//Metal worker
		driver.findElement(By.xpath(".//*[@id='neutral-main-column']/section[1]/form/ul/li[17]/a")).click();
		scriptUtils.sleep(3000);
		//Pest control
		driver.findElement(By.xpath("//*[@id='neutral-main-column']/section[1]/form/ul/li[19]/a")).click();
		//scriptUtils.click next
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//set work area to 50 miles
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='radius']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='radiusList']/li[6]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
		scriptUtils.sleep(3000);		
	    // Enter Business Details
		//assert postcode is displayed
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='SO300PY']")).isDisplayed());
		//scriptUtils.click find postcode
		scriptUtils.click(By.xpath("//*[@id='find-postcode-button']"));
		//scriptUtils.click can't find address
		scriptUtils.sleep(3000);
		scriptUtils.click(By.xpath("//*[@id='address-not-available']"));
		scriptUtils.fillInXpathField("//*[@id='form_businessDetails_address_property']", "69");
		scriptUtils.fillInXpathField("//*[@id='form_businessDetails_address_street']", "whitebeam road");
		scriptUtils.fillInXpathField("//*[@id='form_businessDetails_address_town']", "southampton");
		scriptUtils.clear(By.xpath("//*[@id='form_businessDetails_companyName']"));
		scriptUtils.fillInXpathField("//*[@id='form_businessDetails_companyName']", "RUH Sample");
		//enter a land line instead of mobile
		String landnum1=Integer.toString(TestScriptUtilities.getRandom6digitNumber());			
		String landnum="0208"+landnum1;
		scriptUtils.fillInXpathField("//*[@id='form_businessDetails_landlineNumber']",landnum);
		scriptUtils.clear(By.xpath("//*[@id='form_businessDetails_landlineNumber']"));
		String mobnum1=Integer.toString(TestScriptUtilities.getRandom6digitNumber());			
		String mobnum="07939"+mobnum1;
		scriptUtils.fillInXpathField("//*[@id='form_businessDetails_mobileNumber']",mobnum);
		scriptUtils.clear(By.xpath("//*[@id='form_businessDetails_contactName']"));
		scriptUtils.fillInXpathField("//*[@id='form_businessDetails_contactName']", "kwame Nkrumah");
		scriptUtils.clear(By.xpath("//*[@id='form_email']"));
		scriptUtils.fillInXpathField("//*[@id='form_email']", uniqueEmailAccountName);	
		System.out.println("Email: "+uniqueEmailAccountName);
		//enter password
		scriptUtils.fillInXpathField("//*[@id='form_personalDetails_password1']", "password");
		scriptUtils.fillInXpathField("//*[@id='form_personalDetails_password2']", "password");
		scriptUtils.selectDropdown(By.xpath("//*[@id='form_businessDetails_businessTypeId']"), 2);
		scriptUtils.selectDropdown(By.xpath("//*[@id='form_businessDetails_noOfEmployees']"), 2);
		scriptUtils.selectDropdown(By.xpath("//*[@id='form_businessDetails_leadSource']"), 8);
		//scriptUtils.click join
		scriptUtils.click(By.xpath("//*[@id='contactDetailsSection']/button"));
		System.out.println("Potential Tradesman created");
		//TM Register page starts
		scriptUtils.sleep(4000);
		}
		
  public String testDrivingLicenceScreeningdetails(String uniqueEmailAccountName){
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='idchoice']/div[1]/button"))).click();
	    scriptUtils.sleep(2000);
	    driver.findElement(By.xpath("//*[@id='form_licenceNumber_part1']")).sendKeys("MCLAR");
        driver.findElement(By.xpath("//*[@id='form_licenceNumber_part2']")).sendKeys("702025");
        driver.findElement(By.xpath("//*[@id='form_licenceNumber_part3']")).sendKeys("A99");
        driver.findElement(By.xpath("//*[@id='form_licenceNumber_part4']")).sendKeys("AB");	
        //enter D.O.B
        new Select(driver.findElement(By.xpath("//*[@id='form_dateOfBirth_day']"))).selectByIndex(6);
        new Select(driver.findElement(By.xpath("//*[@id='form_dateOfBirth_month']"))).selectByIndex(4);
        new Select(driver.findElement(By.xpath("//*[@id='form_dateOfBirth_year']"))).selectByIndex(34);
      //  new Select(driver.findElement(By.xpath("//*[@id='form_gender']"))).selectByIndex(0);
        //personal details page
        new Select(driver.findElement(By.id("form_salutationTypeId"))).selectByIndex(1);
        driver.findElement(By.id("form_firstName")).sendKeys("Barry");
        driver.findElement(By.id("form_lastName")).sendKeys("Jenkins");
        //#8973 user is prompted for Role with the business when they sign up             
        new Select(driver.findElement(By.xpath("//*[@id='form_describesYou']"))).selectByIndex(4);    
        // enter postcode will change it later
        scriptUtils.fillInXpathField("//*[@id='form_postcode']", "SO30 0PY");
        //scriptUtils.click find postcode
        driver.findElement(By.xpath("//*[@id='find-postcode-button']")).click();
        scriptUtils.sleep(2000);
        //scriptUtils.click on address not found
        driver.findElement(By.xpath("//a[@id='address-not-available']")).click(); 
        //enter address details
        driver.findElement(By.xpath("//input[@id='form_address_property']")).sendKeys("69");
        driver.findElement(By.xpath("//input[@id='form_address_street']")).sendKeys("Whitebeam Road");
        driver.findElement(By.xpath("//*[@id='form_address_town']")).sendKeys("Southampton");  
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='confirmButton']"))).click();
        //scriptUtils.sleep(5000);
        //driver.findElement(By.id("monthlyPlan")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='monthlyPlan']"))).click();
        scriptUtils.sleep(2000);  
        return"";
}
  
  public String testGBRPassportScreeningdetails(String uniqueEmailAccountName) {
		//scriptUtils.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='idchoice']/div[2]/button"))).click();
		scriptUtils.sleep(2000);
		new Select(driver.findElement(By.xpath("//*[@id='form_passportDetails_countryOfIssue']"))).selectByIndex(2);
		scriptUtils.fillInXpathField("//*[@id='form_passportDetails_passport1']", "7086493126");
		scriptUtils.fillInXpathField("//*[@id='form_passportDetails_passport2']", "GBR");
		scriptUtils.fillInXpathField("//*[@id='form_passportDetails_passport3']", "6510204");
		scriptUtils.fillInXpathField("//*[@id='form_passportDetails_passport4']", "M");
		scriptUtils.fillInXpathField("//*[@id='form_passportDetails_passport5']", "1502246");
	    scriptUtils.fillInXpathField("//*[@id='form_passportDetails_passport6']", "02");
	    //enter Passport Expiry Date
	    new Select(driver.findElement(By.xpath("//*[@id='form_passportDetails_expiryDate_day']"))).selectByIndex(24);
        new Select(driver.findElement(By.xpath("//*[@id='form_passportDetails_expiryDate_month']"))).selectByIndex(2);
        new Select(driver.findElement(By.xpath("//*[@id='form_passportDetails_expiryDate_year']"))).selectByIndex(2);
        //enter D.O.B
        new Select(driver.findElement(By.xpath("//*[@id='form_dateOfBirth_day']"))).selectByIndex(20);
        new Select(driver.findElement(By.xpath("//*[@id='form_dateOfBirth_month']"))).selectByIndex(10);
        new Select(driver.findElement(By.xpath("//*[@id='form_dateOfBirth_year']"))).selectByIndex(32);
	    //personal details page
        new Select(driver.findElement(By.id("form_salutationTypeId"))).selectByIndex(1);
        driver.findElement(By.id("form_firstName")).sendKeys("Martyn");
        driver.findElement(By.id("form_lastName")).sendKeys("Hunter");
        //#8973 user is prompted for Role with the business when they sign up             
        new Select(driver.findElement(By.xpath("//*[@id='form_describesYou']"))).selectByIndex(4);  
        // enter post code will change it later
        scriptUtils.fillInXpathField("//*[@id='form_postcode']", "OL2 8SJ");
        //scriptUtils.click find postcode
        driver.findElement(By.xpath("//*[@id='find-postcode-button']")).click();
        scriptUtils.sleep(2000);
        //scriptUtils.click on address not found
        driver.findElement(By.xpath("//a[@id='address-not-available']")).click(); 
        //enter address details
        driver.findElement(By.xpath("//input[@id='form_address_property']")).sendKeys("Rose Cottage");
        driver.findElement(By.xpath("//input[@id='form_address_street']")).sendKeys("Hesketh Avenue");
        driver.findElement(By.xpath("//*[@id='form_address_town']")).sendKeys("Shaw");  
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='confirmButton']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='monthlyPlan']"))).click();
        scriptUtils.sleep(2000);  
        return"";
	   }
  
   
  public String editJobLeadSettings() {
		scriptUtils.goTo(testUrl);
		login.loginTP("prenovpli@ratedtrades.com", "password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit job lead settings"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='alertRange']"))).click();
		driver.findElement(By.xpath("//*[@id='alertRange']")).sendKeys("4");
		scriptUtils.sleep(3000);
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("SW1E 6AU");
		scriptUtils.click(By.xpath("//button[@type='submit']"));
		scriptUtils.sleep(5000);
		scriptUtils.click(By.xpath("//html/body/div[2]/div/div[3]/form/div/input"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View full details")));
		return "";
		}
  
  //posting jobs
  public void submitJobForPMDRating() throws Exception {
		driver.get("http://preprod.preprod/");
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		 new Select(driver.findElement(By.xpath("//*[@id='trade']"))).selectByVisibleText("Metalworker");
		 new Select(driver.findElement(By.xpath("//*[@id='jobtype']"))).selectByVisibleText("Security Grill");
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("method:submitSkillSpecificJob"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("statusREADY_TO_HIRE"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ownerOWN_AND_LIVE"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ownerOWN_AND_LIVE"))).click();
		 new Select(driver.findElement(By.xpath("//*[@id='timing']"))).selectByVisibleText("Urgently");
		 driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("SW1E6AU");
		 driver.findElement(By.xpath("//html/body/div/div[2]/div/div/div/div/div/div/form/section/div[5]/textarea")).sendKeys("Submit a job via selenium tests and give rating for PMD regression testing Services required: maintainance Approximate length : 250cm-500 cm Type of work: panels, screening Posting job for testing purpose. I will supply the materials ");
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div/div[2]/div/div/div/div/div/div/form/section/div/p/label")));
		 new Select(driver.findElement(By.xpath("//*[@id='jobBudgetCode']"))).selectByVisibleText("Under £100");
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next"))).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("ruhulla");
		 driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("ho");
		 driver.findElement(By.xpath("//input[@id='mobilePhone']")).sendKeys("07412463662");
		 driver.findElement(By.xpath("//input[@id='confirmPhone']")).sendKeys("07412463662");
		 driver.findElement(By.xpath("//input[@id='email']")).sendKeys(HO_EMAIL);
		 driver.findElement(By.xpath("//input[@id='confirmEmail']")).sendKeys(HO_EMAIL);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPostJob"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnConfirmJob"))).click();
		 Thread.sleep(8000);
		 assertEquals(context.driver.findElement(By.xpath(".//*[@id='header-h1']")).getText(),"Thank you");
				
		}
  
	
  public void buyLeadWithExistingBalanceAndRequestRating(String uniqueEmailAccountName) throws Exception {
	  WebDriverWait wait = new WebDriverWait(driver, 60);
			turnPMDPlanOfferMessageOff();
			login.loginTP(uniqueEmailAccountName, "password");
			//login.loginTP("142033-17-Nov-2014-@ratedtrades.com", "password");
			Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='message-light-box']/a"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='alertRange']"))).click();
			driver.findElement(By.xpath("//*[@id='alertRange']")).sendKeys("4");
			scriptUtils.sleep(3000);
			driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("SW1E 6AU");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			scriptUtils.sleep(5000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			scriptUtils.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Job Leads"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View full details"))).click();
			//Buying first job & Request Rating
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buy-btn")));
			driver.findElement(By.id("buy-btn")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Confirm"))).click();
			//Requesting Rating
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='sublinks rate']"))).click();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='container-rating'][1]"))).click();
			scriptUtils.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callToActionButtons']/a[1]"))).click();
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Purchased Jobs"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View details"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-rating']/div"))).isDisplayed();
			
			GiveRatingsForTradesman();
			scriptUtils.sleep(5000);
		
		
	}
  
  public void GiveRatingsForTradesman(){
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  scriptUtils.goTo("https://preprod.preprod/log-in");
	  driver.findElement(By.id("hoUserName")).sendKeys(HO_EMAIL);
	  driver.findElement(By.id("hoPassword")).sendKeys("password");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-as-ho-button"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='skill']"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Rate"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rate-job']/div[1]/p"))).isDisplayed();
	  //Giving 5 Star rating for Quality
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='quality']/div[1]/span[5]"))).click();
	  //Giving 4 Star rating for Value
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='value']/div[1]/span[4]"))).click();
	  //Giving 5 Star rating for Reliability
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='reliability']/div[1]/span[5]"))).click();
	  driver.findElement(By.id("Rating_comment")).sendKeys("Giving ratings to test a TM eligible for PMD offer with average 4 star ratings......");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='container group']/h1"))).isDisplayed();
	 }
  

	    //MembershipOffer using Existing Card
		public String getPMDOfferForNewTMWithExistingCard(String uniqueEmailAccountName) throws Exception{
			 WebDriverWait wait = new WebDriverWait(driver, 60);
           	turnPMDPlanOfferMessageOn();
			login.loginTP(uniqueEmailAccountName, "password");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='message-light-box']/a"))).click();
			scriptUtils.sleep(3000);
			WebElement account = driver.findElement(By.xpath("//*[@id='profile-link']"));
			Actions builder = new Actions(driver);
	        Action hoverAction = builder.moveToElement(account).build();
	        hoverAction.perform();
	    	String parentHandle = driver.getWindowHandle();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Plan Offers"))).click();
	    	scriptUtils.sleep(3000);
	    	switchToWindow();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pageWrap']/section[1]/div/h1")));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[1]/div/section[1]/div/div/article[2]/div/div/div[3]/a"))).click();
	        scriptUtils.sleep(2000); 
	        assertEquals(driver.findElement(By.xpath(".//*[@id='pageWrap']/section[1]/div/h1")).getText(), "Confirm plan change");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pageWrap']/section/div/h1"))).isDisplayed();
			scriptUtils.sleep(5000);
			assertEquals(driver.findElement(By.xpath(".//*[@id='pageWrap']/section/div/h1")).getText(), "Payment successful");
			turnPMDPlanOfferMessageOff();
			driver.close(); // close newly opened window when done with it
			driver.switchTo().window(parentHandle);
			return"";
			
		} 
          
          public void switchToWindow()
      	{
      			for (String winHandle : driver.getWindowHandles()) {
      		     driver.switchTo().window(winHandle); 
      		    }
      	
      	}
		
	    //Membership Campaign for New card 
	    public String getPMDOfferForNewTMWithNewCard(String uniqueEmailAccountName) throws Exception
	    {
	    	turnPMDPlanOfferMessageOn();
	    	login.loginTP(uniqueEmailAccountName, "password");
	    	//login.loginTP("Z13144202-01-Oct-2014-@ratedtrades.com", "password");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='message-light-box']/a"))).click();
			scriptUtils.sleep(3000);
			WebElement account = driver.findElement(By.xpath("//*[@id='profile-link']"));
			Actions builder = new Actions(driver);
	        Action hoverAction = builder.moveToElement(account).build();
	        hoverAction.perform();
	    	String parentHandle = driver.getWindowHandle();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Plan Offers"))).click();
	    	scriptUtils.sleep(3000);
	    	switchToWindow();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pageWrap']/section[1]/div/h1")));
	    	assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div/section[1]/div/h1")).getText(), "Save money with our annual pre-pay plans.");
	    	assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[1]/div/div/article[1]/div/div/div[2]/p/span")).getText().trim(), "SAVE £60");
	    	assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[1]/div/div/article[2]/div/div/div[2]/p/span")).getText().trim(), "GET £120");
	    	assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[1]/div/div/article[3]/div/div/div[2]/p/span")).getText().trim(), "GET £240");
	    	assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[1]/div/div/article[4]/div/div/div[2]/p/span")).getText().trim(), "GET £600");
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[1]/div/section[1]/div/div/article[1]/div/div/div[3]/a"))).click();
	    	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[1]/div/section[1]/div/div/article[2]/div/div/div[3]/a"))).click();
	        scriptUtils.sleep(2000); 
	        assertEquals(driver.findElement(By.xpath(".//*[@id='pageWrap']/section[1]/div/h1")).getText(), "Confirm plan change");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Change card details"))).click();
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newCardForm")));
			//Testing with empty Fields 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='newCardForm']/div/input"))).click();
			Thread.sleep(3000);
			assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[2]/div/div/div/div/div/article/form/ul/li[1]/div[3]")).getText().trim(), "Please select a valid card type");
			assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[2]/div/div/div/div/div/article/form/ul/li[2]/div[3]")).getText().trim(), "Please enter the name as shown on the card");
			assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[2]/div/div/div/div/div/article/form/ul/li[3]/div[3]")).getText().trim(), "Please enter a valid card number");
			assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[2]/div/div/div/div/div/article/form/ul/li[4]/div[3]/em[1]")).getText().trim(), "Please enter a valid expiry date");
			assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[2]/div/div/div/div/div/article/form/ul/li[5]/div[3]")).getText().trim(), "Please enter the 3 digit number from the back of the card");
			//Testing with minimum 5 characters in name field
			new Select(driver.findElement(By.name("CreditCard[type]"))).selectByVisibleText("Visa");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_name"))).sendKeys("Ad");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cardNumber"))).sendKeys("4929000000006");
			new Select(driver.findElement(By.name("CreditCard[expiryDateMonth]"))).selectByVisibleText("05");
			new Select(driver.findElement(By.name("CreditCard[expiryDateYear]"))).selectByVisibleText("2017");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cv2"))).sendKeys("123");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='newCardForm']/div/input"))).click();
			Thread.sleep(2000);
			assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[2]/div/div/div/div/div/article/form/ul/li[2]/div[3]")).getText().trim(), "Please enter the name as shown on the card");
			//Testing with wrong Card number
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_name"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_name"))).sendKeys("Ruhulla");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cardNumber"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cardNumber"))).sendKeys("492900000000000");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='newCardForm']/div/input"))).click();
			Thread.sleep(2000);
			assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[2]/div/div/div/div/div/article/form/ul/li[3]/div[3]")).getText().trim(), "Please enter a valid card number");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cardNumber"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cardNumber"))).sendKeys("1234567");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='newCardForm']/div/input"))).click();
			Thread.sleep(2000);
			assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[2]/div/div/div/div/div/article/form/ul/li[3]/div[3]")).getText().trim(), "Please enter a valid card number");
			//Testing with positive test data
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cardNumber"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cardNumber"))).sendKeys("4929000000006");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cv2"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cv2"))).sendKeys("545");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='newCardForm']/div/input"))).click();
			scriptUtils.sleep(10000);
	        assertEquals(driver.findElement(By.xpath(".//*[@id='AutoNumber1']/tbody/tr[2]/td/font[1]/b")).getText(), "Purchase Authentication");
	        scriptUtils.fillInXpathField(".//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[5]/td[2]/input", "password");
	        scriptUtils.click(By.xpath(".//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[6]/td[2]/input"));
	        scriptUtils.sleep(8000);
	        assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[1]/div/div/p")).getText().trim(), "There was an error with your 3D-Authentication details and payment has not been taken. Please try again or use an alternative card. If this problem continues, please contact your bank.");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Change card details"))).click();
	        scriptUtils.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("CreditCard[type]")));
	        new Select(driver.findElement(By.name("CreditCard[type]"))).selectByVisibleText("Visa");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_name"))).sendKeys("Ruhulla");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cardNumber"))).sendKeys("4929000000006");
			new Select(driver.findElement(By.name("CreditCard[expiryDateMonth]"))).selectByVisibleText("05");
			new Select(driver.findElement(By.name("CreditCard[expiryDateYear]"))).selectByVisibleText("2017");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cv2"))).sendKeys("545");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='newCardForm']/div/input"))).click();
			scriptUtils.sleep(10000);
	        assertEquals(driver.findElement(By.xpath(".//*[@id='AutoNumber1']/tbody/tr[2]/td/font[1]/b")).getText(), "Purchase Authentication");
	        scriptUtils.fillInXpathField(".//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[5]/td[2]/input", "WrongPWD");
	        scriptUtils.click(By.xpath(".//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[6]/td[2]/input"));
	        scriptUtils.sleep(8000);
	        assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[1]/div/div/p")).getText().trim(), "There was an error with your 3D-Authentication details and payment has not been taken. Please try again or use an alternative card. If this problem continues, please contact your bank.");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Change card details"))).click();
	        scriptUtils.sleep(2000);
	        new Select(driver.findElement(By.name("CreditCard[type]"))).selectByVisibleText("Visa");
	        
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_name"))).sendKeys("Ruhulla");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cardNumber"))).sendKeys("4929000000006");
			new Select(driver.findElement(By.name("CreditCard[expiryDateMonth]"))).selectByVisibleText("05");
			new Select(driver.findElement(By.name("CreditCard[expiryDateYear]"))).selectByVisibleText("2017");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cv2"))).sendKeys("123");;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='newCardForm']/div/input"))).click();
			scriptUtils.sleep(10000);
	        assertEquals(driver.findElement(By.xpath(".//*[@id='AutoNumber1']/tbody/tr[2]/td/font[1]/b")).getText(), "Purchase Authentication");
	        scriptUtils.fillInXpathField(".//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[5]/td[2]/input", "password");
	        scriptUtils.click(By.xpath(".//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[6]/td[2]/input"));
	        scriptUtils.sleep(8000);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pageWrap']/section/div/h2"))).isDisplayed();
	        assertEquals(driver.findElement(By.xpath(".//*[@id='pageWrap']/section/div/h1")).getText(), "Payment successful");
	        assertEquals(driver.findElement(By.xpath(".//*[@id='pageWrap']/section/div/p[1]")).getText().trim(), "£120 +VAT (£144) will be charged to the card ending in ************0006");
	        assertEquals(driver.findElement(By.xpath(".//*[@id='pageWrap']/section/div/p[2]")).getText().trim(), "£0 +VAT (£0) in lead credit will be added to your account");
	        assertEquals(driver.findElement(By.xpath(".//*[@id='pageWrap']/section/div/p[3]")).getText().trim(), "You will receive an email confirmation shortly.");
	        turnPMDPlanOfferMessageOff();
			driver.close(); // close newly opened window when done with it
			driver.switchTo().window(parentHandle);
	        return"";
	    }

		public String createTMbillingDetails() {
			assertEquals(driver.findElement(By.xpath(".//*[@id='page-header']/p/strong")).getText(),"0207 192 1240");
			//enter billing details
			scriptUtils.fillInXpathField("//*[@id='form_nameOnCard']", "Barry Jenkins");
			scriptUtils.fillInXpathField("//*[@id='form_cardNumber']", "5404000000000001");
			scriptUtils.selectDropdown(By.xpath("//*[@id='form_expirationDate_month']"), 2);
			scriptUtils.selectDropdown(By.xpath("//*[@id='form_expirationDate_year']"), 7);
			scriptUtils.fillInXpathField("//*[@id='form_cvv']", "123");
			scriptUtils.click(By.name("method:doSubmit"));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='AutoNumber1']/tbody/tr[1]/td/table/tbody/tr/td[1]/img"))).getText();
		    scriptUtils.fillInXpathField("//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[5]/td[2]/input","password");
			scriptUtils.click(By.xpath("//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[6]/td[2]/input"));
			scriptUtils.sleep(6000);
			/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("neutral-main-column"))).getText();
			System.out.println("Welcome to Rated People");*/
			return"";
		}
		
		/*** Change the tm.monthly.plan.show.new.offer.message.after.x.days property to 0 days in order to get PMD Offers POPUP to test ***/
		private boolean turnPMDPlanOfferMessageOn() throws Exception {
			final boolean status = DataBaseHelper
					.executeQuery("update prop_values_tbl set value = '0' where prop_id = (select id from prop_name_tbl where name =\"tm.monthly.plan.show.new.offer.message.after.x.days\")");
			flushTheRpPropertyCache();
			flushTheRpPropertyCacheForapp1();
			flushTheRpPropertyCacheForapp2();
			return status;
		}
		
		/*** Change the tm.monthly.plan.show.new.offer.message.after.x.days property back to 15 days so that this test can be repeatable ***/
		private boolean turnPMDPlanOfferMessageOff() throws Exception {
			final boolean status = DataBaseHelper
					.executeQuery("update prop_values_tbl set value = '15' where prop_id = (select id from prop_name_tbl where name =\"tm.monthly.plan.show.new.offer.message.after.x.days\")");
			flushTheRpPropertyCache();
			flushTheRpPropertyCacheForapp1();
			flushTheRpPropertyCacheForapp2();
			return status;
		}
		
		private void flushTheRpPropertyCache() throws Exception {
			String rpPropertyFlushResource = "/api/v1/rp_property/flush";
			final HttpUriRequest request = this.createPutRequestForSupportUri(rpPropertyFlushResource);
			this.assignDefaultAuthenticationHeader(request, TRADESMAN_USERNAME, TRADESMAN_PASSWORD);
			this.execute(request);
		}
		
		
		private void flushTheRpPropertyCacheForapp1() throws Exception {
			String rpPropertyFlushResource = "/api/v1/rp_property/flush";
			final HttpUriRequest request = this.createPutRequestForapp1Uri(rpPropertyFlushResource);
			this.assignDefaultAuthenticationHeader(request, TRADESMAN_USERNAME, TRADESMAN_PASSWORD);
			this.execute(request);
		}
		private void flushTheRpPropertyCacheForapp2() throws Exception {
			String rpPropertyFlushResource = "/api/v1/rp_property/flush";
			final HttpUriRequest request = this.createPutRequestForapp2Uri(rpPropertyFlushResource);
			this.assignDefaultAuthenticationHeader(request, TRADESMAN_USERNAME, TRADESMAN_PASSWORD);
			this.execute(request);
		}
		
		private void assignDefaultAuthenticationHeader(HttpUriRequest request, String username, String password) throws InvalidKeyException, SignatureException {
	    	requestCreator.assignDefaultAuthenticationHeader(request, username, password);	
		}
		 
		private HttpUriRequest createPutRequestForSupportUri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
			return requestCreator.createPutRequestForSupportUri(uri);
		}
		private HttpUriRequest createPutRequestForapp1Uri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
			return requestCreator.createPutRequestForapp1Uri(uri);
		}
		private HttpUriRequest createPutRequestForapp2Uri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
			return requestCreator.createPutRequestForapp2Uri(uri);
		}
		
		private HttpResponse execute(HttpUriRequest request) throws ClientProtocolException, IOException {
			return requestExecutor.execute(request);
		}
		protected HttpGet createGetRequestForUri(String uri, String accessKey, String accessKeyId) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
			return requestCreator.createGetRequestForUri(uri, accessKey, accessKeyId);		
		}
		
		
		
		
		
}
