/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.internalwoodendoor;

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

public class PostingJobViaInternalWoodenDoorJobForms {
	public static Logger logger = Logger
			.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.slatetiledroofs.PostingJobViaInternalWoodenDoorJobForms");
	private WebDriver driver;
	private String testUrl;
	private SeleniumTestContext context;
	private TestScriptUtilities scriptUtils;
	private static final String PROPERTY_STYLE_SELECT_ELEMENT = "propertyStyle";
	private static final String TIMING_SELECT_ELEMENT = "timing";
	private static final String POSTCODE_FIELD = "postcode";
	private static final String ADDITIONAL_INFO_TEXT_AREA_XPATH = ".//*[@id='additionalDetailsContainer']/textarea";
	private static final String BUDGET_SELECT_ELEMENT = "jobBudgetCode";

	public PostingJobViaInternalWoodenDoorJobForms(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.scriptUtils = scriptUtils;
		this.context = context;
	}

	public void postingJobViaInternalWoodenDoorFirstCriticalScenario() throws Exception {

		jobDetailsPage("radioRepair");
		jobDetailsPageForRepairOption();

		additionalInfoForRepair(5, InternalWoodenDoorsXpathlocators.dataLookup.get("postcode"));
		budgetByValue("Under £500");
		location();
	}

	public void postingJobViaInternalWoodenDoorSecondCriticalScenario() throws Exception {

		jobDetailsPage("radioReplace");
		jobDetailsPageForReplaceOption();
		additionalInfoForReplace(5, InternalWoodenDoorsXpathlocators.dataLookup.get("postcode"));
		budgetByValue("Under £500");
		location();
	}

	public void postingJobViaInternalWoodenDoorThirdCriticalScenario() throws Exception {

		jobDetailsPage("radioFittings");
		jobDetailsPageForReplaceFittingsOption();
		additionalInfoForRepair(31, InternalWoodenDoorsXpathlocators.dataLookup.get("postcode"));
		budgetByValue("Under £500");
		location();
	}

	public void postingJobViaInternalWoodenDoorFourthCriticalScenario() throws Exception {

		jobDetailsPage("radioElse");

		additionalInfoForRepair(31, InternalWoodenDoorsXpathlocators.dataLookup.get("postcode"));
		budgetByValue("Under £500");
		location();
	}

	public void jobDetailsPage(String pathone) throws Exception {
		scriptUtils.click(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get(pathone)));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("continuestage1")));
	}

	public void jobDetailsPageForReplaceOption() throws Exception {

		scriptUtils.clickPlusIcon(InternalWoodenDoorsXpathlocators.xpathLookup.get("whatdoorreplace_answer1"), "Plain flat doors", 3);

		scriptUtils.checkAndSelectRadioByOption(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacesupplyingdoor"), "Yes, I will supply the doors");

		scriptUtils
				.checkAndSelectRadioByOption(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacesupplyingfiitings"), "Yes, I will supply the fittings");

		scriptUtils.checkAndSelectRadioByOption(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacewhatelse"), "Door Frame");

		scriptUtils.click(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext")));
	}

	public void jobDetailsPageForReplaceFittingsOption() throws Exception {

		scriptUtils.clickPlusIcon(InternalWoodenDoorsXpathlocators.xpathLookup.get("whatdoorreplacefit_answer1"), "Hinges", 3);

		scriptUtils.checkAndSelectRadioByOption(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefittsupplyingfiitings"),
				"Yes, I will supply the fittings");

		scriptUtils.click(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext")));
	}

	public void jobDetailsPageForRepairOption() throws Exception {

		scriptUtils.clickPlusIcon(InternalWoodenDoorsXpathlocators.xpathLookup.get("whatdoorrepair_answer1"), "Plain flat doors", 3);
		scriptUtils.checkAndSelectRadioByOption(InternalWoodenDoorsXpathlocators.xpathLookup.get("whereroofrepair"), "Hinges");

		scriptUtils.click(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext")));
	}

	public void getQuotes() throws InterruptedException {

		scriptUtils.getQuotes(testUrl, driver, "22", "carpenter");
	}

	public void additionalInfoForRepair(int lengthstring, String postcode) throws Exception {
		scriptUtils.checkAndSelectDropDownByOption(InternalWoodenDoorsXpathlocators.xpathLookup.get("propertystyle"), "Period property (1700s - 1920s)");

		scriptUtils.checkAndSelectRadioByOption(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairownership"), "I am the landlord");
		scriptUtils.checkAndSelectRadioByOption(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairintent"), "I'm ready to hire");

		scriptUtils.checkAndSelectDropDownByOption(InternalWoodenDoorsXpathlocators.xpathLookup.get("timing"), "Urgently");

		scriptUtils.fillInXpathField(InternalWoodenDoorsXpathlocators.xpathLookup.get("textareaadditionalinfo"),
				TestScriptUtilities.getRandomString(lengthstring));

		scriptUtils.fillInTextField("postcode", postcode);

		scriptUtils.click(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagethreenext")));

	}

	public void additionalInfoForReplace(int lengthstring, String postcode) throws Exception {
		scriptUtils.checkAndSelectDropDownByOption(InternalWoodenDoorsXpathlocators.xpathLookup.get("propertystyle"), "Period property (1700s - 1920s)");

		scriptUtils.checkAndSelectRadioByOption(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairownership"), "I am the landlord");
		scriptUtils.checkAndSelectRadioByOption(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairintent"), "I'm ready to hire");

		scriptUtils.checkAndSelectDropDownByOption(InternalWoodenDoorsXpathlocators.xpathLookup.get("timing"), "Urgently");

		scriptUtils.fillInXpathField(InternalWoodenDoorsXpathlocators.xpathLookup.get("textareaadditionalinfo"),
				TestScriptUtilities.getRandomString(lengthstring));

		scriptUtils.fillInTextField("postcode", postcode);

		scriptUtils.click(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacetagethreenext")));

	}

	public void budgetByValue(String budget) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("budget"))));
		scriptUtils.checkAndSelectDropDownByOption(InternalWoodenDoorsXpathlocators.xpathLookup.get("budget"), budget);
		scriptUtils.click(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("stagethreenext")));
	}

	public void budget(int budget) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("budget"))));
		scriptUtils.selectDropdown(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("budget")), TestScriptUtilities.getRandomNumber(budget));
		scriptUtils.click(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("stagethreenext")));

	}

	public void budgetOther() {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("budget"))));
		scriptUtils.selectDropdown(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("budget")), 10);
		String convrtrandNumber = Integer.toString(TestScriptUtilities.getRandomNumberGreaterThanfifty(100000));
		logger.info("Here is the converted integer  : " + convrtrandNumber);
		scriptUtils.fillInXpathField(InternalWoodenDoorsXpathlocators.xpathLookup.get("otherbudget"), convrtrandNumber);
		scriptUtils.click(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("stagethreenext")));

	}

	public void location() throws Exception {
		String email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtils, context, TestScriptUtilities.getRandomAlphabeticString(3),
				TestScriptUtilities.getRandomAlphabeticString(3),
				InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"), InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"),
 email, email);

		String getheaderText = driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("headerthanku"))).getText();
		logger.info("Header Text is : " + getheaderText);
		assertEquals(getheaderText, InternalWoodenDoorsXpathlocators.dataLookup.get("headertxt"));
	}

	public void fillInPage2ForAdditionalInfo(String propertyStyle, String jobStatus, String ownershipStatus, String timing, String postcode,
			int descriptionLength, String additionalDetails) {

		if (StringUtils.isNotBlank(propertyStyle)) {
			Select propertyStyleSelect = new Select(driver.findElement(By.id(PROPERTY_STYLE_SELECT_ELEMENT)));
			propertyStyleSelect.selectByValue(propertyStyle);
		}

		if (jobStatus != null) {
			if (StringUtils.isNotBlank(jobStatus)) {
				scriptUtils.click(By.id(jobStatus));
			}
		}

		if (ownershipStatus != null) {

			if (StringUtils.isNotBlank(ownershipStatus)) {
				scriptUtils.click(By.id(ownershipStatus));
			}
		}

		if (timing != null) {
			if (StringUtils.isNotBlank(timing)) {
				Select timingSelect = new Select(driver.findElement(By.id(TIMING_SELECT_ELEMENT)));
				timingSelect.selectByValue(timing);
			}
		}

		if (postcode != null) {

			if (StringUtils.isNotBlank(postcode)) {
				scriptUtils.clear(By.id(POSTCODE_FIELD));
				scriptUtils.fillInTextField(POSTCODE_FIELD, postcode);
			}
		}

		if (additionalDetails != null) {

			if (StringUtils.isNotBlank(additionalDetails)) {
				scriptUtils.fillInXpathField(ADDITIONAL_INFO_TEXT_AREA_XPATH, additionalDetails);
			}
		}

		scriptUtils.click(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagethreenext")));
	}

	public void fillInPage3ForBudget(final String selectedBudget) throws Exception {
		if (StringUtils.isNotBlank(selectedBudget)) {
			Select budgetSelect = new Select(driver.findElement(By.id(BUDGET_SELECT_ELEMENT)));
			budgetSelect.selectByValue(selectedBudget);
		}

		scriptUtils.click(By.xpath(".//*[@id='next']"));
	}



}
