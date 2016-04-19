package uk.co.ratedpeople.test.functional.selenium.newtmmembershipcampaign;


import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.jdbc.Statement;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

/**
 * @author ruhulla.mohammad
 * Proactive Membership Drive(PMD)
 */
public class NewtmSignUpForPMDOffer {
	
	public static final String JDBC_DRIVER_URL = "jdbc:mysql://db.preprod:3306/rated_people" ;
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_USER_NAME = "ratedpeople";  
	public static final String DB_PWD = "ratedpeople";
	public static final  String USER_QUERY = "select * from user where salutation_type_id='1' order by id desc";
	public static final  String CAMPAIGN_QUERY = "select * from membership_campaign_url where user_id= '";
	public static final String CAMPAIGN_EMAIL_ID = "select * from user where user_name='";
	public static final String HO_EMAIL = "postjob569@ratedtrades.com";
	
	private WebDriver driver;
	private String testUrl;
	private Login login;
	private WebDriverWait wait;
	private TestScriptUtilities scriptUtils;
	private Connection con;
	private Statement stmt;
	private ResultSet result;
	private String userID;
	private String userName;
	public String membershipCampaignURL;
	
	public NewtmSignUpForPMDOffer(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		driver = context.driver;
		testUrl = context.getTestUrl();

		wait = new WebDriverWait(driver, 60);
		login = new Login(scriptUtils, context);
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
		scriptUtils.fillInXpathField("//*[@id='tradesman-address-property']", "69");
		scriptUtils.fillInXpathField("//*[@id='tradesman-address-street']", "whitebeam road");
		scriptUtils.fillInXpathField("//*[@id='tradesman-address-town']", "southampton");
		scriptUtils.clear(By.xpath("//*[@id='businessName']"));
		scriptUtils.fillInXpathField("//*[@id='businessName']", "RUH Sample");
		//enter a land line instead of mobile
		String landnum1=Integer.toString(TestScriptUtilities.getRandom6digitNumber());			
		String landnum="0208"+landnum1;
		scriptUtils.fillInXpathField("//*[@id='businessMobileNumber']",landnum);
		scriptUtils.clear(By.xpath("//*[@id='businessMobileNumber']"));
		String mobnum1=Integer.toString(TestScriptUtilities.getRandom6digitNumber());			
		String mobnum="07939"+mobnum1;
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
		//scriptUtils.click join
		scriptUtils.click(By.xpath("//*[@id='contactDetailsSection']/button"));
		System.out.println("Potential Tradesman created");
		//TM Register page starts
		scriptUtils.sleep(4000);
		}
		
  public String testDrivingLicenceScreeningdetails(String uniqueEmailAccountName){
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
        //scriptUtils.sleep(5000);
        //driver.findElement(By.id("monthlyPlan")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='monthlyPlan']"))).click();
        scriptUtils.sleep(2000);  
        return"";
}
  
  public String testGBRPassportScreeningdetails(String uniqueEmailAccountName) {
		//scriptUtils.sleep(2000);
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
        driver.findElement(By.id("monthlyPlan")).click();
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
		WebDriverWait wait = new WebDriverWait(driver, 50);
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
		 Thread.sleep(10000);
		 driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("ruhulla");
		 driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("ho");
		 driver.findElement(By.xpath("//input[@id='mobilePhone']")).sendKeys("07412463662");
		 driver.findElement(By.xpath("//input[@id='email']")).sendKeys(HO_EMAIL);
		 //driver.findElement(By.id("email")).sendKeys(hoemail);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPostJob"))).click();
		 Thread.sleep(5000);
		 
		}
  
	
  public void buyLeadWithExistingBalanceAndRequestRating() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		setupDatabaseConnection();
		result = (ResultSet) stmt.executeQuery(USER_QUERY);
   		if(result.next()){
		   	System.out.println("result  being fetched   : " + result);
		   	userName = result.getString("user_name");
   		}
   		System.out.println("User user_name being fetched   : "+userName);
		login.loginTP(userName, "password");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='alertRange']"))).click();
		driver.findElement(By.xpath("//*[@id='alertRange']")).sendKeys("4");
		scriptUtils.sleep(3000);
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("SW1E 6AU");
		scriptUtils.click(By.xpath("//html/body/div[2]/div/div[3]/form/div[3]/div/fieldset/p/button"));
		scriptUtils.sleep(5000);
		scriptUtils.click(By.xpath("//html/body/div[2]/div/div[3]/form/div/input")); //Save Changes
		scriptUtils.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Job Leads"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View full details"))).click();
		//Buying first job & Request Rating
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buy-btn")));
		driver.findElement(By.id("buy-btn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Confirm"))).click();
		//Requesting Rating
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Ask the customer to rate you on this job"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-rating']/div[2]/a[1]"))).click();
		Thread.sleep(6000);
		assertEquals(driver.findElement(By.xpath(".//*[@id='container-rating-notify-msg']")).getText(), "We will email you when your customer rates this job");
		
	}
  
  public void GiveRatingsForTradesman(){
	  WebDriverWait wait = new WebDriverWait(driver, 50);
	  scriptUtils.goTo("https://preprod.preprod/log-in");
	  driver.findElement(By.id("hoUserName")).sendKeys(HO_EMAIL);
	  driver.findElement(By.id("hoPassword")).sendKeys("password");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-as-ho-button"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='job-list']/li[1]/a/span[3]"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Rate"))).click();
	  Assert.assertTrue(driver.findElement(By.xpath("//html/body/div[2]/div/h1")).isDisplayed());
	  //Giving 4 Star rating for Quality
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[2]/div/div[2]/section/form/div[2]/div/div/div/span"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[2]/div/div[2]/section/form/div[2]/div/div/div/span[2]"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[2]/div/div[2]/section/form/div[2]/div/div/div/span[3]"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[2]/div/div[2]/section/form/div[2]/div/div/div/span[4]"))).click();
	  //Giving 4 Star rating for Value
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[2]/div/div[2]/section/form/div[2]/div/div[2]/div/span"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[2]/div/div[2]/section/form/div[2]/div/div[2]/div/span[2]"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[2]/div/div[2]/section/form/div[2]/div/div[2]/div/span[3]"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[2]/div/div[2]/section/form/div[2]/div/div[2]/div/span[4]"))).click();
	  //Giving 5 Star rating for Reliability
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[2]/div/div[2]/section/form/div[2]/div/div[3]/div/span"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[2]/div/div[2]/section/form/div[2]/div/div[3]/div/span[2]"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[2]/div/div[2]/section/form/div[2]/div/div[3]/div/span[3]"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[2]/div/div[2]/section/form/div[2]/div/div[3]/div/span[4]"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[2]/div/div[2]/section/form/div[2]/div/div[3]/div/span[5]"))).click();
	  driver.findElement(By.id("Rating_comment")).sendKeys("Giving ratings to test a TM eligible for PMD offer with average 4 star ratings......");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  Assert.assertTrue(driver.findElement(By.xpath("//html/body/div[3]/div/h1")).isDisplayed());
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My jobs"))).click();
	}
  

	public String setupDatabaseConnection() throws SQLException {
		con = DriverManager.getConnection(JDBC_DRIVER_URL, DB_USER_NAME, DB_PWD);
		stmt = (Statement) con.createStatement();
		return "";
	}
	
    
   public String getMembershipCampaignFromDB() throws SQLException {
		try {
				System.out.println("You are in  getMembershipCampaignFromDB ");
				Class.forName(JDBC_DRIVER).newInstance();
			   	setupDatabaseConnection();	
								
		   		result = (ResultSet) stmt.executeQuery(USER_QUERY);
		   		if(result.next()){
				   	System.out.println("result  being fetched   : " + result);
				   	userID = result.getString("id");
				   	userName = result.getString("user_name");
				   	System.out.println("User ID being fetched   : "+userID);
				   	System.out.println("User user_name being fetched   : "+userName);
				   	String COMBINED_QUERY = CAMPAIGN_QUERY + userID + "'";
				   	ResultSet resultTwo = (ResultSet) stmt.executeQuery(COMBINED_QUERY);	
				    if(resultTwo.next()){
					   	System.out.println("resultSetTwo being fetched   : " + resultTwo);
					   	membershipCampaignURL = resultTwo.getString("url");
					   
					   	System.out.println("resultSetTwo being fetched   : " + membershipCampaignURL);
			   	    }
		   		}
			} catch (Exception e) {
				System.err.println("e.getMessage()" + e);
			} finally {
				con.close();
				
			}
			return membershipCampaignURL;
		 }
	
	    //MC for Existing Card
		public String getTMMembershipCampaignWithExistingCard(){
			try {
				getMembershipCampaignFromDB();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			assertEquals(driver.findElement(By.xpath("//*[@id='page-h1']")).getText(), "Great value 12 month deals");
			assertEquals(driver.findElement(By.xpath("//*[@id='plan1-calculated-savings']")).getText(), "60");
			assertEquals(driver.findElement(By.xpath("//*[@id='plan1-cost-net']")).getText(), "120");
			assertEquals(driver.findElement(By.xpath(".//*[@id='plan1-lead-credit']")).getText(), "0");
			scriptUtils.click(By.xpath(".//*[@id='plan1-select']"));
			scriptUtils.sleep(2000); 
			assertEquals(driver.findElement(By.xpath(".//*[@id='page-h1']")).getText(), "Log-in to confirm your payment details");
			// Enter wrong user login details
			scriptUtils.fillInXpathField("//*[@id='username']", "133331-08-Oct-2013-@ratedtrades.com"); // enter user email 
			scriptUtils.fillInXpathField("//*[@id='password']", "password");  
			scriptUtils.click(By.xpath(".//*[@id='responsiveLogin']/button"));
			assertEquals(driver.findElement(By.xpath(".//*[@id='login-error']")).getText(), "Sorry, you do not qualify for this membership plan");
			// Test for wrong password
			scriptUtils.sleep(2000);
			scriptUtils.clear(By.xpath("//*[@id='username']"));
			scriptUtils.fillInXpathField("//*[@id='username']", userName); // enter user email 
			scriptUtils.fillInXpathField("//*[@id='password']", "passwor");  
			scriptUtils.click(By.xpath(".//*[@id='responsiveLogin']/button"));
			scriptUtils.sleep(2000); 
			assertEquals(driver.findElement(By.xpath(".//*[@id='login-error']")).getText(), "Login failed, please try again");
			// Enter correct user login details
			scriptUtils.sleep(2000);
			scriptUtils.clear(By.xpath("//*[@id='username']"));
			scriptUtils.fillInXpathField("//*[@id='username']", userName); // enter user email 
			scriptUtils.fillInXpathField("//*[@id='password']", "password");  
			scriptUtils.click(By.xpath(".//*[@id='responsiveLogin']/button"));
			scriptUtils.sleep(2000); 
			assertEquals(driver.findElement(By.xpath(".//*[@id='page-h1']")).getText(), "Confirm plan change");
			scriptUtils.click(By.xpath("//*[@id='payWithExistingCard']")); // confirm and pay
			scriptUtils.sleep(2000); 
			assertEquals(driver.findElement(By.xpath("html/body/div[2]/div/div/h1")).getText(), "Payment successful");
			return"";
		} 
		
	    //Membership Campaign for New card 
	    public String getTMMembershipCampaignNewCard()
	    {
	    	
	    	try {
				getMembershipCampaignFromDB();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			
			assertEquals(driver.findElement(By.xpath("//*[@id='page-h1']")).getText(), "Great value 12 month deals");
			assertEquals(driver.findElement(By.xpath("//*[@id='plan1-calculated-savings']")).getText(), "60");
			assertEquals(driver.findElement(By.xpath("//*[@id='plan1-cost-net']")).getText(), "120");
			assertEquals(driver.findElement(By.xpath(".//*[@id='plan1-lead-credit']")).getText(), "0");
			scriptUtils.click(By.xpath(".//*[@id='plan1-select']"));
			scriptUtils.sleep(2000); 
			// Enter wrong user login details
			scriptUtils.fillInXpathField("//*[@id='username']", "133331-08-Oct-2013-@ratedtrades.com"); // enter user email 
			scriptUtils.fillInXpathField("//*[@id='password']", "password");  
			scriptUtils.click(By.xpath(".//*[@id='responsiveLogin']/button"));
			assertEquals(driver.findElement(By.xpath(".//*[@id='login-error']")).getText(), "Sorry, you do not qualify for this membership plan");
			// Test for wrong password
			scriptUtils.sleep(2000);
			scriptUtils.clear(By.xpath("//*[@id='username']"));
			scriptUtils.fillInXpathField("//*[@id='username']", userName); // enter user email 
			scriptUtils.fillInXpathField("//*[@id='password']", "passwor");  
			scriptUtils.click(By.xpath(".//*[@id='responsiveLogin']/button"));
			scriptUtils.sleep(2000); 
			assertEquals(driver.findElement(By.xpath(".//*[@id='login-error']")).getText(), "Login failed, please try again");
			// Enter correct user login details
			scriptUtils.sleep(2000);
			scriptUtils.clear(By.xpath("//*[@id='username']"));
			scriptUtils.fillInXpathField("//*[@id='username']", userName); // enter user email 
			scriptUtils.fillInXpathField("//*[@id='password']", "password");  
			scriptUtils.click(By.xpath(".//*[@id='responsiveLogin']/button"));
			scriptUtils.sleep(2000); 
			assertEquals(driver.findElement(By.xpath(".//*[@id='page-h1']")).getText(), "Confirm plan change");
			scriptUtils.click(By.xpath(".//*[@id='payWithNewCard']"));
	        scriptUtils.sleep(2000);
	        scriptUtils.selectDropdown(By.xpath(".//*[@id='CreditCard_type']"), 1);
	        scriptUtils.fillInXpathField(".//*[@id='CreditCard_name']", "Barry Jenkins");
	        scriptUtils.fillInXpathField(".//*[@id='CreditCard_cardNumber']", "4929000000006");
	        scriptUtils.selectDropdown(By.xpath(".//*[@id='CreditCard_expiryDateMonth']"), 2);
	        scriptUtils.selectDropdown(By.xpath(".//*[@id='CreditCard_expiryDateYear']"), 7);
	        scriptUtils.fillInXpathField(".//*[@id='CreditCard_cv2']", "123");
	        scriptUtils.click(By.xpath(".//*[@id='addNewCardCancel']"));// for cancel the payment
	        scriptUtils.sleep(3000);
	        assertEquals(driver.findElement(By.xpath(".//*[@id='page-h1']")).getText(), "Confirm plan change");
	        scriptUtils.sleep(1000);
	        scriptUtils.click(By.xpath(".//*[@id='payWithNewCard']"));
		    assertEquals(driver.findElement(By.xpath(".//*[@id='page-h2']")).getText(), "Card details");
		    scriptUtils.selectDropdown(By.xpath(".//*[@id='CreditCard_type']"), 1);
	        scriptUtils.fillInXpathField(".//*[@id='CreditCard_name']", "Barry Jenkins");
	        scriptUtils.fillInXpathField(".//*[@id='CreditCard_cardNumber']", "4929000000006");
	        scriptUtils.selectDropdown(By.xpath(".//*[@id='CreditCard_expiryDateMonth']"), 2);
	        scriptUtils.selectDropdown(By.xpath(".//*[@id='CreditCard_expiryDateYear']"), 7);
	        scriptUtils.fillInXpathField(".//*[@id='CreditCard_cv2']", "123");
	        scriptUtils.click(By.xpath(".//*[@id='addNewCardSubmit']"));
	        scriptUtils.sleep(6000);
	        assertEquals(driver.findElement(By.xpath(".//*[@id='AutoNumber1']/tbody/tr[2]/td/font[1]/b")).getText(), "Purchase Authentication");
	        scriptUtils.fillInXpathField(".//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[5]/td[2]/input", "password");
	        scriptUtils.click(By.xpath(".//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[6]/td[2]/input"));
	        assertEquals(driver.findElement(By.xpath(".//*[@id='page-h1']")).getText(), "Payment successful");
	        return"";
	    }

		public String createTMbillingDetails() {
			assertEquals(driver.findElement(By.xpath(".//*[@id='page-header']/p/strong")).getText(),"0207 192 1240");
			//enter billing details
			scriptUtils.fillInXpathField("//*[@id='nameOnCard']", "Barry Jenkins");
			scriptUtils.fillInXpathField("//*[@id='cardNumber']", "5404000000000001");
			scriptUtils.selectDropdown(By.xpath("//*[@id='expireMonth']"), 2);
			scriptUtils.selectDropdown(By.xpath("//*[@id='expireYear']"), 7);
			scriptUtils.fillInXpathField("//*[@id='cv2']", "123");
			scriptUtils.click(By.name("method:doSubmit"));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='AutoNumber1']/tbody/tr[1]/td/table/tbody/tr/td/img[1]"))).getText();
		    scriptUtils.fillInXpathField("//html/body/table/tbody/tr[2]/td/form/table/tbody/tr[5]/td[2]/input","password");
			scriptUtils.click(By.xpath("//html/body/table/tbody/tr[2]/td/form/table/tbody/tr[6]/td[2]/input"));
			scriptUtils.sleep(6000);
			/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("neutral-main-column"))).getText();
			System.out.println("Welcome to Rated People");*/
			return"";
		}
			

}
