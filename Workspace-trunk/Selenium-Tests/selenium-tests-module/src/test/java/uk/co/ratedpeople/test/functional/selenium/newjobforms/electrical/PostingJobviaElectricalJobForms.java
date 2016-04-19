/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.electrical;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author olivier.renard
 * 
 */
public class PostingJobviaElectricalJobForms {

	private static final String POSTCODE_FIELD = "postcode";
	private static final String ELECTRICAL_SKILL_TYPE_ID = "27";
	private static final String ELECTRICAL_TRADE_CODE = "electrician";
	private static final String BUDGET_SELECT_ELEMENT = "jobBudgetCode";

	private static final String PROPERTY_STYLE_SELECT_ELEMENT = "propertyStyle";
	private static final String TIMING_SELECT_ELEMENT = "timing";
	private static final String NEXT_DESC_REPLACE = "nextDescReplace";
	private static final String NEXT_DESC_REPAIR = "nextDescRepair";
	private static final String NEXT_DESC_REWIRE = "nextDescRewire";
	private static final String NEXT_DESC_TESTING = "nextDescTesting";
	private static final String NEXT_DESC_CONSUMER = "nextDescConsumer";

	private static final String NEXT = "next";
	private static final String STAGE1_CONTINUE_XPATH = ".//*[@id='stage1SelectButton']";
	private static final String ADDITIONAL_INFO_TEXT_AREA_XPATH = ".//*[@id='additionalDetailsContainer']/textarea";

	public static Logger logger = Logger.getLogger(PostingJobviaElectricalJobForms.class.getName());
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;

	public PostingJobviaElectricalJobForms(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
		this.driver = driver;
		this.testUrl = testUrl;
		// "/get-quotes/";
		this.scriptUtils = scriptUtils;
	}

	public void getQuotes() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, ELECTRICAL_SKILL_TYPE_ID, ELECTRICAL_TRADE_CODE);
	}

	public void fillInPage1ForJobDetailsForReplaceElectrical(String serviceRequired, String[] whatNeedsToBeReplaced, String[] whereRepairsNeeded,
			String provideItems) throws Exception {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));

		if (whatNeedsToBeReplaced != null) {
			for (int i = 0; i < whatNeedsToBeReplaced.length; i++) {
				scriptUtils.clickPlusIcon(".//*[@id='" + whatNeedsToBeReplaced[i] + "']/following-sibling::a", 3);
			}
		}

		if (whereRepairsNeeded != null) {

			for (int i = 0; i < whereRepairsNeeded.length; i++) {
				scriptUtils.click(By.id(whereRepairsNeeded[i]));
			}
		}
		if (provideItems != null) {
			scriptUtils.click(By.id(provideItems));

		}

		scriptUtils.click(By.id(NEXT_DESC_REPLACE));
	}

	public void fillInPage1ForJobDetailsForRewireElectrical(String serviceRequired, String[] whatNeedsToBeRewired) throws Exception {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));

		if (whatNeedsToBeRewired != null) {
			for (int i = 0; i < whatNeedsToBeRewired.length; i++) {
				scriptUtils.clickPlusIcon(".//*[@id='" + whatNeedsToBeRewired[i] + "']/following-sibling::a", 3);
			}

		}

		scriptUtils.click(By.id(NEXT_DESC_REWIRE));
	}

	public void fillInPage1ForJobDetailsForTestingElectrical(String serviceRequired, String[] whatNeedsToBeTested) throws Exception {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));

		if (whatNeedsToBeTested != null) {
			for (int i = 0; i < whatNeedsToBeTested.length; i++) {
				scriptUtils.click(By.id(whatNeedsToBeTested[i]));
			}

		}

		scriptUtils.click(By.id(NEXT_DESC_TESTING));
	}

	public void fillInPage1ForJobDetailsForConsumerElectrical(String serviceRequired, String whatNeedsToBeCarried) throws Exception {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));

		if (whatNeedsToBeCarried != null) {
			scriptUtils.click(By.id(whatNeedsToBeCarried));

		}
		scriptUtils.click(By.id(NEXT_DESC_CONSUMER));
	}

	public void fillInPage1ForJobDetailsForFaultElectrical(String serviceRequired) throws Exception {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));
	}

	public void fillInPage1ForJobDetailsForRepairElectrical(String serviceRequired, String[] whatNeedsToBeRepaired, String[] whereRepairsNeeded)
			throws InterruptedException {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));

		if (whatNeedsToBeRepaired != null) {
			for (int i = 0; i < whatNeedsToBeRepaired.length; i++) {
				scriptUtils.clickPlusIcon(".//*[@id='" + whatNeedsToBeRepaired[i] + "']/following-sibling::a", 3);
			}
		}

		if (whereRepairsNeeded != null) {
			for (int i = 0; i < whereRepairsNeeded.length; i++) {
				scriptUtils.click(By.id(whereRepairsNeeded[i]));

			}
		}

		scriptUtils.click(By.id(NEXT_DESC_REPAIR));
	}

	public void fillInPage1ForJobDetailsForFindAndRepairLeak(String serviceRequired) throws Exception {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));
	}

	public void fillInPage1ForJobDetailsForSomethingElse(String serviceRequired) throws Exception {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));
	}

	public void fillInPage2ForAdditionalInfo(String propertyStyle, String jobStatus, String ownershipStatus, String timing, String postcode,
			int descriptionLength, String additionalDetails) {

		if (StringUtils.isNotBlank(propertyStyle)) {
			Select propertyStyleSelect = new Select(driver.findElement(By.id(PROPERTY_STYLE_SELECT_ELEMENT)));
			propertyStyleSelect.selectByValue(propertyStyle);
		}

		if (StringUtils.isNotBlank(jobStatus)) {
			scriptUtils.click(By.id(jobStatus));
		}

		if (StringUtils.isNotBlank(ownershipStatus)) {
			scriptUtils.click(By.id(ownershipStatus));
		}

		if (StringUtils.isNotBlank(timing)) {
			Select timingSelect = new Select(driver.findElement(By.id(TIMING_SELECT_ELEMENT)));
			timingSelect.selectByValue(timing);
		}

		if (StringUtils.isNotBlank(postcode)) {
			scriptUtils.clear(By.id(POSTCODE_FIELD));
			scriptUtils.fillInTextField(POSTCODE_FIELD, postcode);
		}

		if (StringUtils.isNotBlank(additionalDetails)) {
			scriptUtils.fillInXpathField(ADDITIONAL_INFO_TEXT_AREA_XPATH, additionalDetails);
		}

		scriptUtils.click(By.id(NEXT));
	}

	public void fillInPage3ForBudget(final String selectedBudget) throws Exception {
		if (StringUtils.isNotBlank(selectedBudget)) {
			Select budgetSelect = new Select(driver.findElement(By.id(BUDGET_SELECT_ELEMENT)));
			budgetSelect.selectByValue(selectedBudget);
		}

		scriptUtils.click(By.id(NEXT));
	}
}
