/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.garden;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 *
 */
public class PostingJobviaGardenJobForms {

	private static final String POSTCODE_FIELD = "postcode";
	private static final String GARDEN_SKILL_TYPE_ID = "82";
	private static final String GARDEN_TRADE_CODE = "gardener";
	private static final String BUDGET_SELECT_ELEMENT = "jobBudgetCode";

	private static final String LANDSCAPING_SELECT_ELEMENT = "landscapeGardenLength";
	private static final String MAINTENANCE_SELECT_ELEMENT = "maintenanceGardenLength";
	private static final String ELSE_SELECT_ELEMENT = "elseGardenLength";

	private static final String TIMING_SELECT_ELEMENT = "timing";
	private static final String NEXT_DESC_CLEARENCE = "nextClearance";
	private static final String NEXT_DESC_LANDSCAPING = "nextLandscaping";

	private static final String NEXT = "next";
	private static final String STAGE1_CONTINUE_XPATH = ".//*[@id='stage1SelectButton']";

	private static final String ADDITIONAL_INFO_TEXT_AREA_XPATH = ".//*[@id='additionalDetailsContainer']/textarea";

	public static Logger logger = Logger.getLogger(PostingJobviaGardenJobForms.class.getName());
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;

	public PostingJobviaGardenJobForms(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
		this.driver = driver;
		this.testUrl = testUrl;
		this.scriptUtils = scriptUtils;
	}

	public void getQuotes() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, GARDEN_SKILL_TYPE_ID, GARDEN_TRADE_CODE);
	}

	public void fillInPage1ForJobDetailsForGardenMaintenance(String serviceRequired, String[] workrequired, String careOfWaste,
			String ongoingGardenMaintenance, String lengthGarden) throws Exception {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));

		if (workrequired != null) {

			for (int i = 0; i < workrequired.length; i++) {
				scriptUtils.click(By.id(workrequired[i]));
			}
		}
		if (StringUtils.isNotBlank(careOfWaste)) {
			scriptUtils.click(By.id(careOfWaste));
		}
		if (StringUtils.isNotBlank(ongoingGardenMaintenance)) {
			scriptUtils.click(By.id(ongoingGardenMaintenance));
		}

		if (StringUtils.isNotBlank(lengthGarden)) {
			Select propertyStyleSelect = new Select(driver.findElement(By.id(MAINTENANCE_SELECT_ELEMENT)));
			propertyStyleSelect.selectByValue(lengthGarden);
		}

		scriptUtils.click(By.id(NEXT_DESC_CLEARENCE));
	}

	public void fillInPage1ForJobDetailsForLandscaping(String serviceRequired, String[] workrequired, String careOfWaste, String lengthGarden) throws Exception {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));

		if (workrequired != null) {

			for (int i = 0; i < workrequired.length; i++) {
				scriptUtils.click(By.id(workrequired[i]));
			}
		}
		if (StringUtils.isNotBlank(careOfWaste)) {
			scriptUtils.click(By.id(careOfWaste));

		}

		if (StringUtils.isNotBlank(lengthGarden)) {
			Select propertyStyleSelect = new Select(driver.findElement(By.id(LANDSCAPING_SELECT_ELEMENT)));
			propertyStyleSelect.selectByValue(lengthGarden);
		}

		scriptUtils.click(By.id(NEXT_DESC_LANDSCAPING));
	}

	public void fillInPage1ForJobDetailsForSomethingElse(String serviceRequired, String lengthGarden) throws Exception {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));

		if (StringUtils.isNotBlank(lengthGarden)) {
			Select propertyStyleSelect = new Select(driver.findElement(By.id(ELSE_SELECT_ELEMENT)));
			propertyStyleSelect.selectByValue(lengthGarden);
		}

	}

	public void fillInPage2ForAdditionalInfo(String jobStatus, String ownershipStatus, String timing, String postcode, int descriptionLength,
			String additionalDetails) {

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
