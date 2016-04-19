/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.featureposting;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.plasteringnrendering.PlasteringXpathlocators;

/**
 * @author shobha.rani
 *
 */
public class Updatejob extends TestScriptUtilities {

	private WebDriver driver;
	private String testUrl;
	private String userName = "sangiho@ratedtrades.com";
	private String password = "password";
	private String postcode = "RP99RP";
	private TestScriptUtilities scriptUtils;
	
	public Updatejob(SeleniumTestContext context, TestScriptUtilities scriptUtilities) {

		super(context);
		
		new Login(scriptUtilities, context);
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.testUrl = testUrl.replaceAll("http://", "https://");
		new WebDriverWait(driver, 30);
		new Login(scriptUtilities, context);		
		
	}
	
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getPostcode() {
		return postcode;
	}
	public void loginToHomeownersApp(final String userName, final String password) {
		String httpsUrl = context.getTestHttpsUrl();
		String hoUrl = "";
		if (httpsUrl.indexOf("preprod") != -1) {
			hoUrl = "http://homeowners.preprod";
		} else if (httpsUrl.indexOf("tokyo") != -1) {
			hoUrl = "http://homeowners-tokyo.uk.ratedpeople";
		} else {
			fail("Invalid environment");
		}

		goTo(hoUrl + "/login");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		clear(By.id("username"));
		fillInTextField("username", userName);
		clear(By.id("password"));
		fillInTextField("password", password);

		click(By.id("btn_login"));
	}

	public String goToJobPage() {
		sleep(5000);
		click(By.xpath(".//*[@id='job-list']/li[1]/a/span[3]"));
		sleep(3000);
		String jobPageUrl = driver.getCurrentUrl();
		return jobPageUrl;
	}

	public void clickUpdateJob() {
		click(By.xpath("html/body/div[2]/div/div[1]/section[2]/div/div/a"));
		sleep(3000);
	}

	public void postingJobviaNewGenericJobformDotCom(final String userName, final String postcode, final String skillTypeId, final String trade, final String description) throws Exception {
		getlandingPage("", skillTypeId, trade);
	//	jobDetailsGeneric();
		additionalInfo(description, postcode);
		budget(8);
		location(userName);
	}
	
	public void getlandingPage(String passUrl, String jobTypeValue, String tradeTypeValue) throws Exception {
		scriptUtils.getQuotes(testUrl + passUrl, driver, jobTypeValue, tradeTypeValue);
	}



public void additionalInfo(final String description, final String postcode) throws Exception {
		scriptUtils.selectDropdown(By.xpath(GenericJobformXpathLocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtils.fillInXpathField(GenericJobformXpathLocators.xpathLookup.get("textareaadditionalinfo"), description);
		scriptUtils.fillInTextField("postcode", postcode);
		scriptUtils.click(By.xpath(GenericJobformXpathLocators.xpathLookup.get("stagetwonext")));
	}
public void budget(int budget) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(GenericJobformXpathLocators.xpathLookup.get("budget"))));
		scriptUtils.selectDropdown(By.xpath(GenericJobformXpathLocators.xpathLookup.get("budget")), TestScriptUtilities.getRandomNumber(budget));
		scriptUtils.click(By.xpath(GenericJobformXpathLocators.xpathLookup.get("stagethreenext")));
		// Thread.sleep(3000);
	}

public void location(final String userName) throws Exception {
		String phone = PlasteringXpathlocators.dataLookup.get("mobile");

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtils, context, TestScriptUtilities.getRandomAlphabeticString(3),
				TestScriptUtilities.getRandomAlphabeticString(3), phone, phone, userName, userName);

		String getheaderText = driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("headerthanku"))).getText();
		logger.info("Header Text is : " + getheaderText);
		assertEquals(getheaderText, PlasteringXpathlocators.dataLookup.get("headertxt"));
	}
}


