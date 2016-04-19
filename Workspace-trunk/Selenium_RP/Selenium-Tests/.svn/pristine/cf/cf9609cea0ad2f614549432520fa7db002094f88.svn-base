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
 * @author shobha.rani
 *
 */
public class NewtmSignUphappyscenario {
	
	private WebDriver driver;
	private String testUrl;
	private Login login;
	private WebDriverWait wait;
	private TestScriptUtilities scriptUtils;
	
	public NewtmSignUphappyscenario(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		driver = context.driver;
		testUrl = context.getTestUrl();

		wait = new WebDriverWait(driver, 60);
		login = new Login(scriptUtils, context);
	}
	
	public void newTmSignUp(String uniqueEmailAccountName) {
		testbusinessdetails(uniqueEmailAccountName);
		testScreeningdetails(uniqueEmailAccountName,"SO30 0PY");
		
	}
	
		
	public void testbusinessdetails(String uniqueEmailAccountName){
		System.out.println(uniqueEmailAccountName);
		scriptUtils.goTo(testUrl + "/tradesman-signup/enter-postcode");
		//Enter Post code
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("SO30 0PY");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		scriptUtils.sleep(3000);
		//Select trades and radius
		scriptUtils.click(By.xpath("//*[@id='neutral-main-column']/section[1]/form/ul/li[10]/a"));
		scriptUtils.sleep(3000);
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
	    // Enter Business Details
		//assert postcode is displayed
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='SO300PY']")).isDisplayed());
		//scriptUtils.click find postcode
		scriptUtils.click(By.xpath("//*[@id='find-postcode-button']"));
		//scriptUtils.click can't find address
		scriptUtils.sleep(3000);
		scriptUtils.click(By.xpath("//*[@id='address-not-available']"));
		scriptUtils.fillInXpathField(".//*[@id='form_businessDetails_address_property']", "69");
		scriptUtils.fillInXpathField(".//*[@id='form_businessDetails_address_street']", "whitebeam road");
		scriptUtils.fillInXpathField(".//*[@id='form_businessDetails_address_town']", "southampton");
		scriptUtils.clear(By.xpath(".//*[@id='form_businessDetails_companyName']"));
		scriptUtils.fillInXpathField(".//*[@id='form_businessDetails_companyName']", "BSR Limited");
		//enter a land line instead of mobile
		String landnum1=Integer.toString(TestScriptUtilities.getRandom6digitNumber());			
		String landnum="0208"+landnum1;
		scriptUtils.fillInXpathField(".//*[@id='form_businessDetails_mobileNumber']",landnum);
		scriptUtils.clear(By.xpath(".//*[@id='form_businessDetails_mobileNumber']"));
		String mobnum1=Integer.toString(TestScriptUtilities.getRandom6digitNumber());		
		String mobnum="07939"+mobnum1;
//		String randomNumbers = RandomStringUtils.randomNumeric(5);
//		String mobnum = "079393"+randomNumbers;
		scriptUtils.fillInXpathField(".//*[@id='form_businessDetails_mobileNumber']",mobnum);
		scriptUtils.clear(By.xpath(".//*[@id='form_businessDetails_contactName']"));
		scriptUtils.fillInXpathField(".//*[@id='form_businessDetails_contactName']", "kwame Nkrumah");
		scriptUtils.clear(By.xpath(".//*[@id='form_email']"));
		scriptUtils.fillInXpathField(".//*[@id='form_email']", uniqueEmailAccountName);	
		System.out.println("Email: "+uniqueEmailAccountName);
		//enter password
		scriptUtils.fillInXpathField(".//*[@id='form_personalDetails_password1']", "password");
		scriptUtils.fillInXpathField(".//*[@id='form_personalDetails_password2']", "password");
		scriptUtils.selectDropdown(By.xpath(".//*[@id='form_businessDetails_businessTypeId']"), 2);
		scriptUtils.selectDropdown(By.xpath(".//*[@id='form_businessDetails_noOfEmployees']"), 2);
		scriptUtils.selectDropdown(By.xpath(".//*[@id='form_businessDetails_leadSource']"), 8);
		//scriptUtils.click(RefreshJBillingingXPathLocators.xpathLookup.get("ACCEPT_TERMS_UI"));
		//scriptUtils.click join
		scriptUtils.click(By.xpath("//*[@id='contactDetailsSection']/button"));
		System.out.println("Potential Tradesman created");
		//TM Register page starts
		scriptUtils.sleep(4000);
		}
	
	public void testbusinessdetailsScotland(String uniqueEmailAccountName){
		System.out.println(uniqueEmailAccountName);
		scriptUtils.goTo(testUrl + "/tradesman-signup/enter-postcode");
		//Enter Post code
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("G1 3BS");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		scriptUtils.sleep(3000);
		//Select trades and radius
		scriptUtils.click(By.xpath("//*[@id='neutral-main-column']/section[1]/form/ul/li[10]/a"));
		scriptUtils.sleep(3000);
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
	    // Enter Business Details
		//assert postcode is displayed
//		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='G1 3BS']")).isDisplayed());
		//scriptUtils.click find postcode
		scriptUtils.click(By.xpath("//*[@id='find-postcode-button']"));
		//scriptUtils.click can't find address
		scriptUtils.sleep(3000);
		scriptUtils.checkAndSelectDropDownById("tradesman-address", "Pret A Manger, 144-146 Queen Street, Glasgow");
		scriptUtils.sleep(3000);
//		scriptUtils.click(By.xpath("//*[@id='address-not-available']"));
//		scriptUtils.fillInXpathField("//*[@id='tradesman-address-property']", "69");
//		scriptUtils.fillInXpathField("//*[@id='tradesman-address-street']", "whitebeam road");
//		scriptUtils.fillInXpathField("//*[@id='tradesman-address-town']", "southampton");
		scriptUtils.clear(By.xpath("//*[@id='form_businessDetails_companyName']"));
    	scriptUtils.fillInXpathField("//*[@id='form_businessDetails_companyName']", "Scotland Limited");
		
		//enter a land line instead of mobile
		String landnum1=Integer.toString(TestScriptUtilities.getRandom6digitNumber());			
		String landnum="0208"+landnum1;
		scriptUtils.fillInXpathField("//*[@id='form_businessDetails_landlineNumber']",landnum);
		scriptUtils.clear(By.xpath("//*[@id='form_businessDetails_mobileNumber']"));
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
		//scriptUtils.click(RefreshJBillingingXPathLocators.xpathLookup.get("ACCEPT_TERMS_UI"));
		//scriptUtils.click join
		scriptUtils.click(By.xpath("//*[@id='contactDetailsSection']/button"));
		System.out.println("Potential Tradesman created");
		//TM Register page starts
		scriptUtils.sleep(4000);
		}
		
  public String testScreeningdetails(String uniqueEmailAccountName,String postcode){
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='idchoice']/div[1]/button"))).click();
	    scriptUtils.sleep(2000);
	    driver.findElement(By.xpath("//*[@id='form_licenceNumber_part1']")).sendKeys("JENKI");
      driver.findElement(By.xpath("//*[@id='form_licenceNumber_part2']")).sendKeys("604063");
      driver.findElement(By.xpath("//*[@id='form_licenceNumber_part3']")).sendKeys("B99");
      driver.findElement(By.xpath("//*[@id='form_licenceNumber_part4']")).sendKeys("MN");	
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
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='annualPlan']"))).click();
      scriptUtils.sleep(2000);  
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
  
  public String editJobLeadSettings(String uniqueEmailAccountName) {
	    scriptUtils.goTo(testUrl);
		login.loginTP(uniqueEmailAccountName, "password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='alertRange']"))).click();
		driver.findElement(By.xpath("//*[@id='alertRange']")).sendKeys("4");
		scriptUtils.sleep(3000);
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("SW1E 6AU");
		scriptUtils.click(By.xpath(".//*[@id='settingsTab_area']/div/fieldset/p/button")).click();
		scriptUtils.sleep(3000);
		scriptUtils.click(By.xpath(".//*[@id='alertSettings']/div[1]/input"));
		scriptUtils.sleep(5000);
		driver.findElement(By.linkText("Job Leads")).click();
		scriptUtils.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View full details")));
		return "";
		}
}
