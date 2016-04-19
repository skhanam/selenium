/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newtmsignup;


import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

/**
 * @author ruhulla.mohammad
 *
 */
public class NewtmSignUpFreeTrailFromPartnersSite {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private TestScriptUtilities scriptUtils;
	private Login login;
	
	public NewtmSignUpFreeTrailFromPartnersSite(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		driver = context.driver;
		wait = new WebDriverWait(driver, 60);
		login = new Login(scriptUtils, context);
	}
	
	public void newTmSignUp(String uniqueEmailAccountName) {
		testbusinessdetails(uniqueEmailAccountName);
		testScreeningdetails(uniqueEmailAccountName);
	}
	
	public void testbusinessdetails(String uniqueEmailAccountName){
		System.out.println(uniqueEmailAccountName);
		scriptUtils.goTo("https://preprod.preprod/tradesman-signup/enter-postcode?campaignId=81&utm_source=thomson&utm_medium=email&utm_campaign=march&mb=418486a9e548");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='neutral-main-column']/section[1]/div[1]")));
		//Enter Post code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postcode"))).sendKeys("SO30 0PY");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='neutral-main-column']/section[1]/div[1]")));
		//Select trades and radius
		scriptUtils.click(By.xpath("//*[@id='neutral-main-column']/section[1]/form/ul/li[27]/a"));
		scriptUtils.sleep(3000);
		scriptUtils.click(By.xpath("//*[@id='neutral-main-column']/section[1]/form/ul/li[27]/a"));
		//Select skills
		driver.findElement(By.xpath("//*[@id='neutral-main-column']/section[1]/form/ul/li[14]/a")).click();
		scriptUtils.sleep(3000);
		driver.findElement(By.xpath("//*[@id='neutral-main-column']/section[1]/form/ul/li[21]/a")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='neutral-main-column']/section[1]/div[1]")));
		//set work area to 50 miles
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='radius']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='radiusList']/li[6]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
		// Enter Business Details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='neutral-main-column']/section[1]/div[1]")));
		Assert.assertTrue(driver.findElement(By.xpath("//html/body/div/div[2]/div/div/div/section/h2")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='SO300PY']")).isDisplayed());
		scriptUtils.click(By.xpath("//*[@id='find-postcode-button']"));
		//scriptUtils.click can't find address
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address-not-available"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tradesman-address-property"))).sendKeys("69");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tradesman-address-street"))).sendKeys("whitebeam road");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tradesman-address-town"))).sendKeys("southampton");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("businessName"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("businessName"))).sendKeys("BSR Limited");
		//enter a land line instead of mobile
		String landnum1=Integer.toString(TestScriptUtilities.getRandom6digitNumber());			
		String landnum="0208"+landnum1;
		scriptUtils.fillInXpathField("//*[@id='businessMobileNumber']",landnum);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("businessMobileNumber"))).clear();
		String mobnum1=Integer.toString(TestScriptUtilities.getRandom6digitNumber());			
		String mobnum="07949"+mobnum1;
		scriptUtils.fillInXpathField("//*[@id='businessMobileNumber']",mobnum);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contactName"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contactName"))).sendKeys("kwame Nkrumah");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailAddress"))).clear();
		scriptUtils.fillInXpathField("//*[@id='emailAddress']", uniqueEmailAccountName);	
		System.out.println("Email: "+uniqueEmailAccountName);
		//enter password
		scriptUtils.fillInXpathField("//*[@id='passwordOne']", "password");
		scriptUtils.fillInXpathField("//*[@id='passwordTwo']", "password");
		scriptUtils.selectDropdown(By.xpath("//*[@id='businessTypeId']"), 2);
		scriptUtils.selectDropdown(By.xpath("//*[@id='employeeCountTypeId']"), 2);
		scriptUtils.selectDropdown(By.xpath("//*[@id='originTypeId']"), 8);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("method:doSubmit"))).click();
		System.out.println("Potential Tradesman created");
		//TM Register page starts
		scriptUtils.sleep(4000);
		}
		
  public String testScreeningdetails(String uniqueEmailAccountName){
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='neutral-main-column']/section[1]/div[1]")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("method:chooseDrivingLicence"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='neutral-main-column']/section[1]/div[1]")));
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
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='neutral-main-column']/section[1]/div[1]")));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div/div[2]/div/div/div/section/section/ul/li[2]/strong"))).getText();
    driver.findElement(By.id("monthlyPlan")).click();
    scriptUtils.sleep(2000);  
    createTMbillingDetails();       		
	/*scriptUtils.click(By.name("method:next"));
    scriptUtils.sleep(3000);
    scriptUtils.click(By.name("method:next"));
    scriptUtils.sleep(3000);
    scriptUtils.click(By.name("method:next"));
    scriptUtils.sleep(3000);
    scriptUtils.click(By.name("method:next"));
    scriptUtils.sleep(3000);
    scriptUtils.click(By.name("method:next"));
    scriptUtils.sleep(3000);
    scriptUtils.click(By.name("method:next"));
    scriptUtils.sleep(3000);
    scriptUtils.click(By.className("edit-btn"));*/
    
    return"";
}
  
  public String createTMbillingDetails(){
	//assert CCA number is availabe on Billing Screen
	assertEquals(driver.findElement(By.xpath(".//*[@id='page-header']/p/strong")).getText(),"0207 192 1240");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='neutral-main-column']/section[1]/div[1]")));
	assertEquals(driver.findElement(By.xpath("//html/body/div/div[2]/div/div/div/section/div[2]/div/ul/li[2]")).getText(), "£50 free to spend on job leads to get you started - credit expires at the end of your 1 month free trial");
	scriptUtils.fillInXpathField("//*[@id='nameOnCard']", "Barry Jenkins");
	scriptUtils.fillInXpathField("//*[@id='cardNumber']", "5404000000000001");
	scriptUtils.selectDropdown(By.xpath("//*[@id='expireMonth']"), 2);
	scriptUtils.selectDropdown(By.xpath("//*[@id='expireYear']"), 7);
	scriptUtils.fillInXpathField("//*[@id='cv2']", "123");
	scriptUtils.click(By.name("method:doSubmit"));
	scriptUtils.sleep(8000);
	/*scriptUtils.fillInXpathField("//html/body/table/tbody/tr[2]/td/form/table/tbody/tr[5]/td[2]/input","password");
	scriptUtils.click(By.xpath("//html/body/table/tbody/tr[2]/td/form/table/tbody/tr[6]/td[2]/input"));
	assertEquals(driver.findElement(By.xpath("//*[@id=\"neutral-main-column\"]/section/h1")).getText(), "Welcome to Rated People");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div/div[2]/div/div/div/section/h1"))).getText();
	System.out.println("Thank you"); */
	return"";
	}
  
  public void confirmWelcomeEmailSentToTM(String uniqueEmailAccountName) throws Exception{
	  System.out.println(uniqueEmailAccountName);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		login.loginSupport("aaron.barwell@ratedpeople.com","password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='search_search']")));
		scriptUtils.fillInXpathField("//*[@id='search_search']", uniqueEmailAccountName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='standardSearch']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='subnav']/ul/li[5]/a"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='subnav']/ul/li[5]/a"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Welcome to your Rated People account"))).click();
		assertEquals(driver.findElement(By.xpath(".//*[@id='bodyContent']/div[1]/table/tbody/tr[2]/td/h2")).getText(), "Welcome to your Rated People account");
		scriptUtils.sleep(3000);	
	}
  
}
