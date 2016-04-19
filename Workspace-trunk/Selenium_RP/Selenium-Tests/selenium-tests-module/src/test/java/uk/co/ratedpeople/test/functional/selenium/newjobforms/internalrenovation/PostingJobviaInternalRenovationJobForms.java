/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.internalrenovation;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.plasteringnrendering.PlasteringXpathlocators;

/**
 * @author shabana.khanam
 * 
 */
public class PostingJobviaInternalRenovationJobForms {

	private static final String JOB_TYPE_ID = "11";
	private static final String TRADE = "builder";
	

    private static final String ErewardIMAGE_XPATH  = ".//*[@id='skill-specifc-portable-jobform']/a/img";	
	private static final String SRC_CONTAINS  ="2/post-your-job/bundles/rpglobalassets/img/research-now-banner.jpg";
	
	public static Logger logger = Logger
			.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.internalrenovation.PostingJobviaInternalRenovationJobForms");
	private WebDriver driver;
	private String testUrl;
	private SeleniumTestContext context;
	private TestScriptUtilities scriptUtils;

	public PostingJobviaInternalRenovationJobForms(final SeleniumTestContext context, final TestScriptUtilities scriptUtils) {
		this.context = context;
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.scriptUtils = scriptUtils;
	}

	public void getQuotes() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, JOB_TYPE_ID, TRADE);
	}

	public void PostingJobviaInternalRenovationJobFormsReconfigurationSomethingElse() throws Exception {
		jobDetailsSomethingElse(InternalRenovationXpathLocators.xpathlookup.get("somethingelseradio"));

		additionalInfo(30, InternalRenovationXpathLocators.dataLookup.get("postcode"), InternalRenovationXpathLocators.xpathlookup.get("intent"),
				InternalRenovationXpathLocators.xpathlookup.get("ownership"), TestScriptUtilities.getRandomAlphabeticString(30));
		budgetOther();
		location(PlasteringXpathlocators.dataLookup.get("fname") + TestScriptUtilities.getRandomAlphabeticString(3),
				PlasteringXpathlocators.dataLookup.get("lname") + TestScriptUtilities.getRandomAlphabeticString(3),
				PlasteringXpathlocators.dataLookup.get("mobile"), InternalRenovationXpathLocators.dataLookup.get("mobile") + "@ratedtrades.com");
	}

	public void PostingJobviaInternalRenovationJobFormsReconfigurationReconfigurationNotSure() throws Exception {

		getQuotes();
		jobDetailsNotsure(InternalRenovationXpathLocators.xpathlookup.get("reconfigradio"), InternalRenovationXpathLocators.xpathlookup.get("configurenotsure"));
		additionalInfo(5, InternalRenovationXpathLocators.dataLookup.get("postcode"), InternalRenovationXpathLocators.xpathlookup.get("intent"),
				InternalRenovationXpathLocators.xpathlookup.get("ownership"), TestScriptUtilities.getRandomAlphabeticString(30));
		budgetOther();
		location(PlasteringXpathlocators.dataLookup.get("fname") + TestScriptUtilities.getRandomAlphabeticString(3),
				PlasteringXpathlocators.dataLookup.get("lname") + TestScriptUtilities.getRandomAlphabeticString(3),
				PlasteringXpathlocators.dataLookup.get("mobile"), InternalRenovationXpathLocators.dataLookup.get("mobile") + "@ratedtrades.com");

	}

	public void PostingJobviaInternalRenovationJobFormsReconfigurationReconfiguration() throws Exception {

		jobDetails(InternalRenovationXpathLocators.xpathlookup.get("reconfigradio"));
		additionalInfo(5, InternalRenovationXpathLocators.dataLookup.get("postcode"), InternalRenovationXpathLocators.xpathlookup.get("intent"),
				InternalRenovationXpathLocators.xpathlookup.get("ownership"), TestScriptUtilities.getRandomAlphabeticString(30));

		budget(10);
		location(PlasteringXpathlocators.dataLookup.get("fname") + TestScriptUtilities.getRandomAlphabeticString(3),
				PlasteringXpathlocators.dataLookup.get("lname") + TestScriptUtilities.getRandomAlphabeticString(3),
				PlasteringXpathlocators.dataLookup.get("mobile"), InternalRenovationXpathLocators.dataLookup.get("mobile") + "@ratedtrades.com");
	}

	public void PostingJobviaInternalRenovationJobFormsReconfigurationRepair() throws Exception {
		jobDetailsRepair(InternalRenovationXpathLocators.xpathlookup.get("repairradio"));

		additionalInfo(5, InternalRenovationXpathLocators.dataLookup.get("postcode"), InternalRenovationXpathLocators.xpathlookup.get("intent"),
				InternalRenovationXpathLocators.xpathlookup.get("ownership"), TestScriptUtilities.getRandomAlphabeticString(30));

		budget(10);
		location(PlasteringXpathlocators.dataLookup.get("fname") + TestScriptUtilities.getRandomAlphabeticString(3),
				PlasteringXpathlocators.dataLookup.get("lname") + TestScriptUtilities.getRandomAlphabeticString(3),
				PlasteringXpathlocators.dataLookup.get("mobile"), InternalRenovationXpathLocators.dataLookup.get("mobile") + "@ratedtrades.com");
	}

	// These are customised methods
	// public void getQuotes() throws InterruptedException {
	// scriptUtils.goTo(testUrl);
	// Select tradetype = new Select(driver.findElement(By.id("trade")));
	// tradetype.selectByValue("builder");
	//
	// // sleep for 2 seconds to give a change for the AJAX call to populate the second drop-down
	// scriptUtils.sleep(2000);
	//
	// Select select = new Select(driver.findElement(By.id("jobtype")));
	// select.selectByValue("11");
	//
	// scriptUtils.click(InternalRenovationXpathLocators.xpathlookup.get("nextquotes"));
	// }

	// These are customised methods
	public void jobDetails(String pathone) {

		scriptUtils.click(By.xpath(pathone));
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("continuestage1")));
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("configurestageonenext"))));

		List<WebElement> getcheckboxCountpathone = driver.findElements(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("workneedsdoneone")));
		int getcountofchkboxpathone = getcheckboxCountpathone.size();
		logger.info("Count of work needs to be carried out : " + getcountofchkboxpathone);
		int generateRandomofCountlipartsubone = TestScriptUtilities.getRandomNumber(getcountofchkboxpathone);
		logger.info("Random of Count : " + generateRandomofCountlipartsubone);
		String formxpathone = InternalRenovationXpathLocators.xpathlookup.get("workneedsdoneone") + "[" + generateRandomofCountlipartsubone + "]/input";
		logger.info("Xpath formed for property listed  : " + formxpathone);
		scriptUtils.click(By.xpath(formxpathone));
		// scriptUtils.fillInTextField("postcode", postcode);

		List<WebElement> getcheckboxCount = driver.findElements(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("workdoneone")));
		int getcountofchkbox = getcheckboxCount.size();
		logger.info("Count of work needs to be done : " + getcountofchkbox);
		int generateRandomofCountlipartsubtwo = TestScriptUtilities.getRandomNumber(getcountofchkbox);
		logger.info("Random of Count : " + generateRandomofCountlipartsubtwo);
		String formxpathtwo = InternalRenovationXpathLocators.xpathlookup.get("workdoneone") + "[" + generateRandomofCountlipartsubtwo + "]/input";
		logger.info("Xpath formed for property listed  : " + formxpathtwo);
		scriptUtils.click(By.xpath(formxpathtwo));
		scriptUtils.click(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("configurestageonenext")));
	}

	public void jobDetailsRepair(String pathone) {
		scriptUtils.click(By.xpath(pathone));
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("continuestage1")));
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("repairstageonenext"))));

		List<WebElement> getcheckboxCountpathone = driver.findElements(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("workneedsdonerepairone")));
		int getcountofchkboxpathone = getcheckboxCountpathone.size();
		logger.info("Count of work needs to be carried out : " + getcountofchkboxpathone);
		int generateRandomofCountlipartsubone = TestScriptUtilities.getRandomNumber(getcountofchkboxpathone);
		logger.info("Random of Count : " + generateRandomofCountlipartsubone);
		String formxpathone = InternalRenovationXpathLocators.xpathlookup.get("workneedsdonerepairone") + "[" + generateRandomofCountlipartsubone + "]/input";
		logger.info("Xpath formed for property listed  : " + formxpathone);
		scriptUtils.click(By.xpath(formxpathone));

		List<WebElement> getcheckboxCount = driver.findElements(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("workdonerepairone")));
		int getcountofchkbox = getcheckboxCount.size();
		logger.info("Count of work needs to be done : " + getcountofchkbox);
		int generateRandomofCountlipartsubtwo = TestScriptUtilities.getRandomNumber(getcountofchkbox);
		logger.info("Random of Count : " + generateRandomofCountlipartsubtwo);
		String formxpathtwo = InternalRenovationXpathLocators.xpathlookup.get("workdonerepairone") + "[" + generateRandomofCountlipartsubtwo + "]/input";
		logger.info("Xpath formed for property listed  : " + formxpathtwo);
		scriptUtils.click(By.xpath(formxpathtwo));
		scriptUtils.click(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("repairstageonenext")));
	}

	public void jobDetailsNotsure(String pathone, String pathtwo) {
		scriptUtils.click(By.xpath(pathone));
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("continuestage1")));
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("configurestageonenext"))));
		scriptUtils.click(By.xpath(pathtwo));
		List<WebElement> getcheckboxCount = driver.findElements(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("workdoneone")));
		int getcountofchkbox = getcheckboxCount.size();
		logger.info("Count of property style : " + getcountofchkbox);
		int generateRandomofCountlipartsubtwo = TestScriptUtilities.getRandomNumber(getcountofchkbox);
		logger.info("Random of Count : " + generateRandomofCountlipartsubtwo);
		String formxpath = InternalRenovationXpathLocators.xpathlookup.get("workdoneone") + "[" + generateRandomofCountlipartsubtwo + "]/input";
		logger.info("Xpath formed for property listed  : " + formxpath);
		scriptUtils.click(By.xpath(formxpath));
		scriptUtils.click(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("configurestageonenext")));
	}

	public void jobDetailsSomethingElse(String pathone) {
		scriptUtils.click(By.xpath(pathone));
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("continuestage1")));
	}

	public void additionalInfo(int lengthstring, String postcode, String intent, String ownership, String description) throws Exception {

		getrandomfittings(InternalRenovationXpathLocators.xpathlookup.get("propertyownyes"));

		// List<WebElement> getradioCount = driver.findElements(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("")));
		// int getcountofdropdown = getradioCount.size();
		// logger.info("Count of property style : ");

		scriptUtils.selectDropdown(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("propertytype")), TestScriptUtilities.getRandomNumber(5));
		scriptUtils.selectDropdown(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("timing")), TestScriptUtilities.getRandomNumber(6));

		// List<WebElement> getradioCount = driver.findElements(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("")));
		// int getcountofdropdown = getradioCount.size();
		// logger.info("Count of property style : ");
		scriptUtils.selectDropdown(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("propertytype")), TestScriptUtilities.getRandomNumber(5));
		scriptUtils.selectDropdown(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("timing")), TestScriptUtilities.getRandomNumber(6));

		// intent & ownership added
		List<WebElement> getoptionsIntent = driver.findElements(By.xpath(intent));
		int getcountofli = getoptionsIntent.size();
		int getRandomintent = TestScriptUtilities.getRandomNumber(getcountofli);
		logger.info("Random of Intent links are : " + getRandomintent);
		if (getRandomintent == 1) {
			getRandomintent += 1;
		}
		logger.info("Count of links are : " + getcountofli);

		String formxpath = intent + "[" + getRandomintent + "]/input";
		logger.info("Xpath formed is  : " + formxpath);
		scriptUtils.click(By.xpath(formxpath));

		List<WebElement> getoptionsOwner = driver.findElements(By.xpath(ownership));
		int getcountofliOwner = getoptionsOwner.size();
		logger.info("Count of links are : " + getcountofliOwner);
		int getRandomofliOwner = TestScriptUtilities.getRandomNumber(getcountofliOwner);
		logger.info("Random of Ownership links are : " + getRandomofliOwner);

		String formxpathOwner = ownership + "[" + getRandomofliOwner + "]/input";
		logger.info("Xpath formed is  : " + formxpathOwner);
		scriptUtils.click(By.xpath(formxpathOwner));

		getrandomlistedbuilding();
		if (StringUtils.isNotBlank(postcode)) {
			scriptUtils.fillInTextField("postcode", postcode);
		}

		if (StringUtils.isNotBlank(description)) {

			scriptUtils.fillInXpathField(InternalRenovationXpathLocators.xpathlookup.get("textareaadditionalinfo"), description);
		}

		scriptUtils.fillInXpathField(InternalRenovationXpathLocators.xpathlookup.get("textareaadditionalinfo"),
				TestScriptUtilities.getRandomString(lengthstring));

		scriptUtils.click(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("stagetwonext")));

	}

	public void service(String service) {
		scriptUtils.click(By.xpath(service));
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("continuestage1")));
	}

	public void fillRepairRenovate(String whatrepairxpath, String whatrepair, String whererepairxpath, String whererepair, String next) {
		if (StringUtils.isNotBlank(whatrepair)) {
			scriptUtils.click(By.xpath(whatrepairxpath));
		}
		if (StringUtils.isNotBlank(whererepair)) {
			scriptUtils.click(By.xpath(whererepairxpath));
		}
		scriptUtils.click(By.xpath(next));
	}

	public void fillInStage3(String budget) {
		if (StringUtils.isNotBlank(budget)) {
			Select budgetSelect = new Select(driver.findElement(By.id(InternalRenovationXpathLocators.xpathlookup.get("BUDGET_SELECT_ELEMENT"))));
			budgetSelect.selectByValue(budget);
		}
		scriptUtils.click(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("SCREEN3_NEXT_BUTTON")));
	}

	public void fillInStage2(String jobStatus, String ownershipStatus, String timing, String material, String postcode, String additionalDetails) {
		if (StringUtils.isNotBlank(jobStatus)) {
			scriptUtils.click(By.xpath(jobStatus));
		}

		if (StringUtils.isNotBlank(ownershipStatus)) {
			scriptUtils.click(By.xpath(ownershipStatus));
		}

		if (StringUtils.isNotBlank(timing)) {
			Select timingSelect = new Select(driver.findElement(By.id(InternalRenovationXpathLocators.xpathlookup.get("timing"))));
			timingSelect.selectByValue(timing);
		}

		if (StringUtils.isNotBlank(material)) {
			scriptUtils.click(By.xpath(material));
		}

		if (StringUtils.isNotBlank(postcode)) {
			scriptUtils.fillInXpathField(InternalRenovationXpathLocators.xpathlookup.get("timing"), postcode);
		}

		if (StringUtils.isNotBlank(additionalDetails)) {
			scriptUtils.fillInXpathField(InternalRenovationXpathLocators.xpathlookup.get("ADDITIONAL_INFO_TEXT_AREA_XPATH"), additionalDetails);
		}

		scriptUtils.click(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("stagetwonext")));
	}

	public void getrandomfittings(String ownproperty) {
		List<WebElement> getoptionsparttwo = driver.findElements(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("materialradio")));
		int getcountofliparttwo = getoptionsparttwo.size();
		logger.info("Random of Count : " + getcountofliparttwo);
		int generateRandomofCountliparttwo = TestScriptUtilities.getRandomNumber(getcountofliparttwo);
		logger.info("Random of Count : " + generateRandomofCountliparttwo);
		String formxpath = InternalRenovationXpathLocators.xpathlookup.get("materialradio") + "[" + generateRandomofCountliparttwo + "]/input";
		logger.info("Xpath formed is  : " + formxpath);
		scriptUtils.click(By.xpath(formxpath));
		// scriptUtils.click(By.xpath(ownproperty));
	}

	public void getrandomlistedbuilding() {
		List<WebElement> getoptionsparttwo = driver.findElements(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("propertyListed")));
		int getcountofliparttwo = getoptionsparttwo.size();
		logger.info("Count of Listed building  :" + getcountofliparttwo);
		int generateRandomofCountliparttwo = TestScriptUtilities.getRandomNumber(getcountofliparttwo);
		logger.info("Random of Count : " + generateRandomofCountliparttwo);
		String formxpath = InternalRenovationXpathLocators.xpathlookup.get("propertyListed") + "[" + generateRandomofCountliparttwo + "]/input";
		logger.info("Xpath formed for property listed  : " + formxpath);
		scriptUtils.click(By.xpath(formxpath));
	}

	public void budget(int budget) throws Exception {

		scriptUtils.selectDropdown(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("budget")), TestScriptUtilities.getRandomNumber(budget));
		scriptUtils.click(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("stagethreenext")));

		Thread.sleep(3000);
	}

	public void budgetOther() {
		scriptUtils.selectDropdown(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("budget")), 15);
		String convrtrandNumber = Integer.toString(TestScriptUtilities.getRandomNumberGreaterThanfifty(100000));
		logger.info("Here is the converted integer  : " + convrtrandNumber);
		scriptUtils.fillInXpathField(InternalRenovationXpathLocators.xpathlookup.get("otherbudget"), convrtrandNumber);
		scriptUtils.click(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("stagethreenext")));

	}

	public void location(String fname, String lname, String mobile, String email) throws Exception {
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtils, context, fname, lname, mobile, mobile, email, email);
		String getheaderText = driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("headerthanku"))).getText();
		logger.info("Header Text is : " + getheaderText);
		assertEquals(getheaderText, PlasteringXpathlocators.dataLookup.get("headertxt"));

		assertEquals(driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(),
				PlasteringXpathlocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
		assertEquals(driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("WHATHAPPENSNEXTONE_XPATH"))).getText(),
				PlasteringXpathlocators.dataLookup.get("WHATHAPPENSNEXTONE_TEXT"));
		assertEquals(driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("WHATHAPPENSNEXTTWO_XPATH"))).getText(),
				PlasteringXpathlocators.dataLookup.get("WHATHAPPENSNEXTTWO_TEXT"));
		assertEquals(driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("WHATHAPPENSNEXTTHREE_XPATH"))).getText(),
				PlasteringXpathlocators.dataLookup.get("WHATHAPPENSNEXTTHREE_TEXT"));
		// this is to test E-rewards link
				context.driver.findElement(By.xpath(ErewardIMAGE_XPATH)).isDisplayed();
				context.driver.findElement(By.xpath(ErewardIMAGE_XPATH)).getAttribute("src").contains(SRC_CONTAINS);
				
					
				String Mainwindow = context.driver.getWindowHandle(); 
				context.driver.findElement(By.xpath(ErewardIMAGE_XPATH)).click();

				for (String Erewardwindow : context.driver.getWindowHandles()) {
					context.driver.switchTo().window(Erewardwindow); 
				}

				context.driver.close(); 
				context.driver.switchTo().window(Mainwindow);
		
	}

	public String getTestUrl() {
		return testUrl;
	}

	public void setTestUrl(String testUrl) {
		this.testUrl = testUrl;
	}

}
