/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.bathroom;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

/**
 *  
 * 
 */
public class PostingJobViaBathroomJobForms {
	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.bathrooms.PostingJobViaBathroomJobForms");
	private WebDriver driver;
	private String testUrl;
	private SeleniumTestContext context;
	private TestScriptUtilities scriptUtils;
	private static final String IPD_TRADE_CODE = "bathroom";
	private static final String IPD_SKILL_TYPE_ID = "18";
	private static final String ADDITIONAL_INFO_TEXT_AREA_XPATH = ".//*[@id='additionalDetailsContainer']/textarea";
	private static final String POSTCODE_FIELD = "postcode";
	private static final String SCREEN2_NEXT_BUTTON = ".//*[@id='stage2']/div[6]/div/button[1]";
	private static final String SCREEN3_NEXT_BUTTON = ".//*[@id='stage3']/div[2]/div/button[1]";
	private static final String BUDGET_SELECT_ELEMENT = "jobBudgetCode";

    private static final String ErewardIMAGE_XPATH  = ".//*[@id='skill-specifc-portable-jobform']/a/img";	
	private static final String SRC_CONTAINS  ="2/post-your-job/bundles/rpglobalassets/img/research-now-banner.jpg";

	public PostingJobViaBathroomJobForms(final SeleniumTestContext context, final TestScriptUtilities scriptUtils) {
		this.context = context;
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.scriptUtils = scriptUtils;
	}

	public void getQuotes() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, IPD_SKILL_TYPE_ID, IPD_TRADE_CODE);
	}

	public void postingJobViaBathroomFirstCriticalScenario() throws Exception {
		getQuotes();
		jobDetailsPage("radioInstall");
		replacePathFirstPage();
		additionalInfoPage(5, BathroomXpathlocators.dataLookup.get("postcode"));
		thirdPage("Under £8,000");
		fourthPage();
	}

	public void postingJobViaBathroomSecondCriticalScenario() throws Exception {
		getQuotes();
		jobDetailsPage("radioRepair");
		repairPathFirstPage();
		additionalInfoPage(5, BathroomXpathlocators.dataLookup.get("postcode"));
		thirdPage("Under £1,000");
		fourthPage();
	}

	public void postingJobViaBathroomThirdCriticalScenario() throws Exception {
		getQuotes();
		jobDetailsPage("radioElse");

		additionalInfoPage(31, BathroomXpathlocators.dataLookup.get("postcode"));
		thirdPage("Under £500");
		fourthPage();
	}

	public void jobDetailsPage(String pathone) throws Exception {
		scriptUtils.click(By.xpath(BathroomXpathlocators.xpathLookup.get(pathone)));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(BathroomXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(BathroomXpathlocators.xpathLookup.get("continuestage1")));
	}

	public void replacePathFirstPage() throws Exception {
		scriptUtils.clickPlusIcon(BathroomXpathlocators.xpathLookup.get("installed"), "Basin", 2);
//		scriptUtils.clickXpath(BathroomXpathlocators.xpathLookup.get("INSTALLATION"));
		scriptUtils.checkAndSelectRadioByOption(BathroomXpathlocators.xpathLookup.get("installation"), "Flooring - tiled");

		scriptUtils.checkAndSelectRadioByOption(BathroomXpathlocators.xpathLookup.get("supplying"), "Bathroom suite");

		scriptUtils.click(By.xpath(BathroomXpathlocators.xpathLookup.get("stageonereplacenext")));
	}

	public void installFirstPageWhatElseNeededQuestionOtherNotAnswered() {
		scriptUtils.clickPlusIcon(BathroomXpathlocators.xpathLookup.get("installed"), "Basin", 2);
		scriptUtils.checkAndSelectRadioForOptionOfTypeOther(BathroomXpathlocators.xpathLookup.get("installationOther"), false);
		scriptUtils.click(By.xpath(BathroomXpathlocators.xpathLookup.get("stageonereplacenext")));
	}

	public void installFirstPageWhichOfTheFollowingAreYouSupplyingQuestionOtherNotAnswered() {
		scriptUtils.clickPlusIcon(BathroomXpathlocators.xpathLookup.get("installed"), "Basin", 2);
		scriptUtils.checkAndSelectRadioByOption(BathroomXpathlocators.xpathLookup.get("installation"), "Flooring - tiled");
		scriptUtils.checkAndSelectRadioForOptionOfTypeOther(BathroomXpathlocators.xpathLookup.get("supplyingOther"), false);
		scriptUtils.click(By.xpath(BathroomXpathlocators.xpathLookup.get("stageonereplacenext")));
	}

	public void repairPathFirstPage() throws Exception {

		// scriptUtils.checkAndSelectRadioByOption(BathroomXpathlocators.xpathLookup
		// .get("descRepair"),"Flooring");
		scriptUtils.click(By.id("repairFlooring"));

		scriptUtils.click(By.xpath(BathroomXpathlocators.xpathLookup.get("repairstagetwonext")));
	}

	public void landingPage() throws InterruptedException {
		scriptUtils.goTo(testUrl + "/get-quotes/");
		Select tradetype = new Select(driver.findElement(By.id("trade")));
		tradetype.selectByValue("plumber");
		Select select = new Select(driver.findElement(By.id("jobtype")));
		select.selectByValue("18");
		scriptUtils.click(BathroomXpathlocators.xpathLookup.get("nextquotes"));
	}

	public void additionalInfoPage(int lengthstring, String postcode) throws Exception {

		scriptUtils.checkAndSelectRadioByOption(BathroomXpathlocators.xpathLookup.get("ownership"), "I am the landlord");
		scriptUtils.checkAndSelectRadioByOption(BathroomXpathlocators.xpathLookup.get("intent"), "I'm ready to hire");

		scriptUtils.checkAndSelectDropDownByOption(BathroomXpathlocators.xpathLookup.get("timing"), "Within 2 weeks");

		scriptUtils.fillInXpathField(BathroomXpathlocators.xpathLookup.get("textareaadditionalinfo"), TestScriptUtilities.getRandomString(lengthstring));

		scriptUtils.fillInTextField("postcode", postcode);

		scriptUtils.click(By.xpath(BathroomXpathlocators.xpathLookup.get("stagetwonext")));

	}

	public void thirdPage(String budget) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BathroomXpathlocators.xpathLookup.get("budget"))));
		scriptUtils.checkAndSelectDropDownByOption(BathroomXpathlocators.xpathLookup.get("budget"), budget);
		scriptUtils.click(By.xpath(BathroomXpathlocators.xpathLookup.get("stagethreenext")));
	}

	public void budget(int budget) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BathroomXpathlocators.xpathLookup.get("budget"))));
		scriptUtils.selectDropdown(By.xpath(BathroomXpathlocators.xpathLookup.get("budget")), TestScriptUtilities.getRandomNumber(budget));
		scriptUtils.click(By.xpath(BathroomXpathlocators.xpathLookup.get("stagethreenext")));

	}

	public void budgetOther() {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BathroomXpathlocators.xpathLookup.get("budget"))));
		scriptUtils.selectDropdown(By.xpath(BathroomXpathlocators.xpathLookup.get("budget")), 10);
		String convrtrandNumber = Integer.toString(TestScriptUtilities.getRandomNumberGreaterThanfifty(100000));
		logger.info("Here is the converted integer  : " + convrtrandNumber);
		scriptUtils.fillInXpathField(BathroomXpathlocators.xpathLookup.get("otherbudget"), convrtrandNumber);
		scriptUtils.click(By.xpath(BathroomXpathlocators.xpathLookup.get("stagethreenext")));

	}

	public void fourthPage() throws Exception {
		String firstName = BathroomXpathlocators.dataLookup.get("fname");
		String lastName = BathroomXpathlocators.dataLookup.get("lname");
		String email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
		String mobile = BathroomXpathlocators.dataLookup.get("mobile");
		
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtils, context, firstName, lastName, mobile, mobile, email, email);
		
		String getheaderText = driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("headerthanku"))).getText();
		logger.info("Header Text is : " + getheaderText);
		assertEquals(getheaderText, BathroomXpathlocators.dataLookup.get("headertxt"));
		assertEquals(driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(), BathroomXpathlocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
		assertEquals(driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("WHATHAPPENSNEXTONE_XPATH"))).getText(), BathroomXpathlocators.dataLookup.get("WHATHAPPENSNEXTONE_TEXT"));
		assertEquals(driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("WHATHAPPENSNEXTTWO_XPATH"))).getText(), BathroomXpathlocators.dataLookup.get("WHATHAPPENSNEXTTWO_TEXT"));
		assertEquals(driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("WHATHAPPENSNEXTTHREE_XPATH"))).getText(), BathroomXpathlocators.dataLookup.get("WHATHAPPENSNEXTTHREE_TEXT"));
		
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

	public void fillInStage1(String option, String next) throws Exception {
		jobDetailsPage(option);
		scriptUtils.click(By.xpath(BathroomXpathlocators.xpathLookup.get(next)));
	}

	public void fillInStage2(String jobStatus, String ownershipStatus, String timing, String postcode, String additionalDetails) {
		if (StringUtils.isNotBlank(jobStatus)) {
			scriptUtils.click(By.id(jobStatus));
		}

		if (StringUtils.isNotBlank(ownershipStatus)) {
			scriptUtils.click(By.id(ownershipStatus));
		}

		if (StringUtils.isNotBlank(timing)) {
			Select timingSelect = new Select(driver.findElement(By.id("timing")));
			// WebDriverWait wait = new WebDriverWait(driver,1000);
			// wait.until(ExpectedConditions.elementToBeSelected((WebElement) timingSelect));
			timingSelect.selectByValue(timing);
		}

		/*
		 * if(StringUtils.isNotBlank(material)) { scriptUtils.click(By.id(material)); }
		 */

		if (StringUtils.isNotBlank(postcode)) {
			scriptUtils.fillInTextField(POSTCODE_FIELD, postcode);
		}

		if (StringUtils.isNotBlank(additionalDetails)) {
			scriptUtils.fillInXpathField(ADDITIONAL_INFO_TEXT_AREA_XPATH, additionalDetails);
		}

		scriptUtils.click(By.xpath(SCREEN2_NEXT_BUTTON));
	}

	/*
	 * Budget page validation
	 */
	public void fillInStage3(String budget) {
		if (StringUtils.isNotBlank(budget)) {
			Select budgetSelect = new Select(driver.findElement(By.id(BUDGET_SELECT_ELEMENT)));
			budgetSelect.selectByValue(budget);
		}

		scriptUtils.click(By.xpath(SCREEN3_NEXT_BUTTON));
	}
}
