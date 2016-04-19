/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.chimney;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author shabana.khanam
 * 
 */
public class PostingJobViaChimneyJobForms {

	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.chimney.PostingJobViaChimneyJobForms");

	private static final String STAGE1_CONTINUE = "stage1SelectButton";
	private static final String STAGE2_CONTINUE_REPAIR = "nextDescRepairStack";
	private static final String STAGE2_NEXT_REBUILD = ".//*[@id='descRebuildStack']/div[4]/button[2]";
	private static final String STAGE2_CONTINUE_REMOVE = ".//*[@id='descRemoveBreast']/div[4]/button[2]";
	private static final String STAGE3_CONTINUE = "next";
	private static final String STAGE4_CONTINUE = ".//*[@id='stage3']/div[2]/div/button[1]";
	// private static final String STAGE2_NEXT_RMEBREAST = ".//*[@id='nextDescRepairStack']";

	private static final String JOB_STATUS = "statusREADY_TO_HIRE";

	private static final String TIMING_SELECT_ELEMENT = "timing";
	private static final String POSTCODE_FIELD = "postcode";
	private static final String ADDITIONAL_INFO_TEXT_AREA_XPATH = ".//*[@id='additionalDetailsContainer']/textarea";
	private static final String BUDGET_SELECT_ELEMENT = "jobBudgetCode";

	private static final String PROPERTY_STYLE_SELECT_ELEMENT = "propertyStyle";

	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;

	public PostingJobViaChimneyJobForms(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
		this.driver = driver;
		this.testUrl = testUrl;
		this.scriptUtils = scriptUtils;
	}

	public void getQuotesChimney() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, "97", "builder");
	}

	public void fillInStage1(String radioButtonId) {
		if (StringUtils.isNotBlank(radioButtonId)) {
			scriptUtils.click(By.id(radioButtonId));
		}
		scriptUtils.click(By.id(STAGE1_CONTINUE));
	}

	public void fillInStage2RepairChimneyStack(String plusIcon, String[] chimneyStack, String partOther, String chimneyHigh) {
		scriptUtils.clickPlusIcon(plusIcon, 2);
		if (chimneyStack != null) {
			for (int i = 0; i < chimneyStack.length; i++) {
				scriptUtils.click(By.xpath(chimneyStack[i]));
			}

			if (StringUtils.isNotBlank(partOther)) {
				scriptUtils.fillInXpathField(ChimneyLocators.xpathLookup.get("OTHER_TEXT"), partOther);
			}
		}

		if (StringUtils.isNotBlank(chimneyHigh)) {
			Select jobTypeSelect = new Select(driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("CHIMNEY_HEIGHT"))));
			jobTypeSelect.selectByValue(chimneyHigh);
		}

		scriptUtils.click(By.id(STAGE2_CONTINUE_REPAIR));

	}

	public void fillInStage2RebuildChimneyStack(String plusIcon, String jobRequirement, String chimneyHigh) throws InterruptedException {
		scriptUtils.clickPlusIcon(plusIcon, 3);

		if (StringUtils.isNotBlank(jobRequirement)) {
			scriptUtils.click(jobRequirement);
		}

		if (StringUtils.isNotBlank(chimneyHigh)) {
			Select jobTypeSelect = new Select(driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("REBUILD_CHIMNEY_HEIGHT"))));
			jobTypeSelect.selectByValue(chimneyHigh);
		}
		scriptUtils.click(By.xpath(STAGE2_NEXT_REBUILD));

	}

	public void fillInStage2RemoveChimneyStack(String[] chimneyBreast, String partOther, String chimneyHigh, String buildingRegulation)
			throws InterruptedException {

		if (chimneyBreast != null) {
			for (int i = 0; i < chimneyBreast.length; i++) {
				scriptUtils.click(By.xpath(chimneyBreast[i]));
			}

			if (StringUtils.isNotBlank(partOther)) {
				scriptUtils.fillInXpathField(ChimneyLocators.xpathLookup.get("OTHER_TEXT"), partOther);
			}
		}

		if (StringUtils.isNotBlank(chimneyHigh)) {
			Select jobTypeSelect = new Select(driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("REMOVE_STOREY_HEIGHT"))));
			jobTypeSelect.selectByValue(chimneyHigh);
		}

		if (StringUtils.isNotBlank(buildingRegulation)) {
			Select jobTypeSelect = new Select(driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("BUILDING_CONVERSION"))));
			jobTypeSelect.selectByValue(buildingRegulation);
		}
		Thread.sleep(2000);
		scriptUtils.click(By.xpath(STAGE2_CONTINUE_REMOVE));

	}

	public void fillInStage2RemoveChimneyBreast(String chimneybreast, String storeysproperty, String buildingregulations) throws InterruptedException {

		if (StringUtils.isNotBlank(chimneybreast)) {
			scriptUtils.click(By.id(chimneybreast));
		}

		if (StringUtils.isNotBlank(storeysproperty)) {
			Select jobTypeSelect = new Select(driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("STOREY_PROPERTY"))));
			jobTypeSelect.selectByValue(storeysproperty);
		}

		if (StringUtils.isNotBlank(buildingregulations)) {
			Select jobTypeSelect = new Select(driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("BUILDING_REGULATION"))));
			jobTypeSelect.selectByValue(buildingregulations);
		}

		scriptUtils.click(By.xpath(STAGE2_CONTINUE_REMOVE));

	}

	public void fillInStage3(String jobStatusId, String ownershipStatusId, String jobTimingValue, String propertyStyle, String postcode, String additionalInfo) {
		if (StringUtils.isNotBlank(jobStatusId)) {
			scriptUtils.click(By.id(JOB_STATUS));
		}

		if (StringUtils.isNotBlank(ownershipStatusId)) {
			scriptUtils.click(By.id(ownershipStatusId));
		}

		if (StringUtils.isNotBlank(jobTimingValue)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(TIMING_SELECT_ELEMENT)));
			jobTypeSelect.selectByValue(jobTimingValue);
		}

		if (StringUtils.isNotBlank(propertyStyle)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(PROPERTY_STYLE_SELECT_ELEMENT)));
			jobTypeSelect.selectByValue(propertyStyle);
		}

		if (StringUtils.isNotBlank(postcode)) {
			scriptUtils.fillInTextField(POSTCODE_FIELD, postcode);
		}

		if (StringUtils.isNotBlank(additionalInfo)) {
			scriptUtils.fillInXpathField(ADDITIONAL_INFO_TEXT_AREA_XPATH, additionalInfo);
		}

		scriptUtils.click(By.id(STAGE3_CONTINUE));
	}

	public void fillInStage4(String budget) {
		if (StringUtils.isNotBlank(budget)) {
			Select budgetSelect = new Select(driver.findElement(By.id(BUDGET_SELECT_ELEMENT)));
			budgetSelect.selectByValue(budget);
		}

		scriptUtils.click(By.xpath(STAGE4_CONTINUE));
	}

	public TestScriptUtilities getScriptUtils() {
		return scriptUtils;
	}
}
