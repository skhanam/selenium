/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.externalwoodendoor;

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
public class PostingJobviaExternalWoodenDoorsJobForms {

	private static final String POSTCODE_FIELD = "postcode";
	private static final String EXTERNAL_WOODEN_DOORS_SKILL_TYPE_ID = "127";
	private static final String EXTERNAL_WOODEN_DOORS_TRADE_CODE = "carpenter";
	private static final String BUDGET_SELECT_ELEMENT = "jobBudgetCode";
	private static final String PROPERTY_STYLE_SELECT_ELEMENT = "propertyStyle";
	private static final String TIMING_SELECT_ELEMENT = "timing";
	private static final String REPAIR_PAGE1_NEXT_BUTTON = ".//*[@id='nextDescRepair']";
	private static final String REPLACE_PAGE1_NEXT_BUTTON = ".//*[@id='nextDescReplace']";
	private static final String STAGE1_CONTINUE_XPATH = ".//*[@id='stage1SelectButton']";
	private static final String STAGE2_CONTINUE_XPATH = ".//*[@id='stage2']/div[7]/div/button[1]";
	private static final String STAGE3_CONTINUE_XPATH = ".//*[@id='stage3']/div[2]/div/button[1]";
	private static final String ADDITIONAL_INFO_TEXT_AREA_XPATH = ".//*[@id='additionalDetailsContainer']/textarea";

	public static Logger logger = Logger.getLogger(PostingJobviaExternalWoodenDoorsJobForms.class.getName());
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;

	public PostingJobviaExternalWoodenDoorsJobForms(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
		this.driver = driver;
		this.testUrl = testUrl;
		this.scriptUtils = scriptUtils;
	}

	public void getQuotes() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, EXTERNAL_WOODEN_DOORS_SKILL_TYPE_ID, EXTERNAL_WOODEN_DOORS_TRADE_CODE);
	}

	public void fillInPage1ForJobDetailsForRepairOrAdjustExternalWoodenDoors(String serviceRequired, String whatDoorToRepair, int howManyDoorsToRepair,
			String[] partsOfDoorToRepair) throws Exception {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));

		if (whatDoorToRepair != null) {

			if (StringUtils.isNotBlank(whatDoorToRepair)) {
				for (int i = 0; i < howManyDoorsToRepair; i++) {
					scriptUtils.click(By.xpath(".//*[@id='" + whatDoorToRepair + "']/following-sibling::a"));
				}
			}
		}

		if (partsOfDoorToRepair != null) {

			for (int i = 0; i < partsOfDoorToRepair.length; i++) {
				scriptUtils.click(By.id(partsOfDoorToRepair[i]));
			}
		}
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(REPAIR_PAGE1_NEXT_BUTTON)));
		scriptUtils.click(By.xpath(REPAIR_PAGE1_NEXT_BUTTON));
	}

	public void fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(String serviceRequired, String whatDoorToReplace, int howManyDoorsToReplace,
			String areTheySupplyingDoors, String areTheySupplyingFittings, String[] whatElseToInclude) {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));

		if (whatDoorToReplace != null) {

			if (StringUtils.isNotBlank(whatDoorToReplace)) {
				for (int i = 0; i < howManyDoorsToReplace; i++) {
					scriptUtils.click(By.xpath(".//*[@id='" + whatDoorToReplace + "']/following-sibling::a"));
				}
			}
		}

		if (areTheySupplyingDoors != null) {
			if (StringUtils.isNotBlank(areTheySupplyingDoors)) {
				scriptUtils.select(By.id(areTheySupplyingDoors));
			}
		}

		if (StringUtils.isNotBlank(areTheySupplyingFittings)) {
			scriptUtils.select(By.id(areTheySupplyingFittings));
		}

		if (whatElseToInclude != null) {
			for (int i = 0; i < whatElseToInclude.length; i++) {
				scriptUtils.click(By.id(whatElseToInclude[i]));
			}
		}
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(REPLACE_PAGE1_NEXT_BUTTON)));
		scriptUtils.click(By.xpath(REPLACE_PAGE1_NEXT_BUTTON));
	}

	public void fillInPage1ForJobDetailsForFittings(String serviceRequired, String whatFittingsToInstall, int howManyFittingsToInstall,
			String areTheySupplyingFittings, String nextStage) throws Exception {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 20);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));

		if (whatFittingsToInstall != null) {
			if (StringUtils.isNotBlank(whatFittingsToInstall)) {
				for (int i = 0; i < howManyFittingsToInstall; i++) {
					scriptUtils.click(By.xpath(".//*[@id='" + whatFittingsToInstall + "']/following-sibling::a"));
				}
			}
		}

		if (areTheySupplyingFittings != null) {
			if (StringUtils.isNotBlank(areTheySupplyingFittings)) {
				scriptUtils.select(By.id(areTheySupplyingFittings));
			}
		}
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(nextStage)));
		scriptUtils.click(By.xpath(nextStage));
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

		scriptUtils.click(By.xpath(STAGE2_CONTINUE_XPATH));
	}

	public void fillInPage3ForBudget(final String selectedBudget) throws Exception {
		if (StringUtils.isNotBlank(selectedBudget)) {
			Select budgetSelect = new Select(driver.findElement(By.id(BUDGET_SELECT_ELEMENT)));
			budgetSelect.selectByValue(selectedBudget);
		}

		scriptUtils.click(By.xpath(STAGE3_CONTINUE_XPATH));
	}
}
