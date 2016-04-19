package uk.co.ratedpeople.test.functional.selenium.newjobforms.fences;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author ankitkumar.rana
 * 
 */
public class PostingJobViaFencesJobForms {

	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.newbuilds.PostingJobViaNewBuildJobForms");

	private static final String STAGE1_CONTINUE = "stage1SelectButton";
	private static final String STAGE2_CONTINUE_FENCES = "nextDescFence";
	private static final String STAGE2_CONTINUE_GARDEN_WALLS = "nextDescWall";
	private static final String STAGE2_CONTINUE_GATES = "nextDescGate";
	private static final String STAGE3_CONTINUE = "next";
	private static final String STAGE4_CONTINUE = ".//*[@id='stage3']/div[2]/div/button[1]";

	private static final String TIMING_SELECT_ELEMENT = "timing";
	private static final String POSTCODE_FIELD = "postcode";
	private static final String ADDITIONAL_INFO_TEXT_AREA_XPATH = ".//*[@id='additionalDetailsContainer']/textarea";
	private static final String BUDGET_SELECT_ELEMENT = "jobBudgetCode";
	private static final String TRADE_ID = "gardener";
	private static final String JOB_ID = "79";

	private WebDriver driver;
	private TestScriptUtilities scriptUtils;
	private String testUrl;

	public PostingJobViaFencesJobForms(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
		this.driver = driver;
		this.testUrl = testUrl;
		this.scriptUtils = scriptUtils;
	}

	public void getQuotes() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, JOB_ID, TRADE_ID);
	}

	public void fillInStage1(String radioButtonId) {
		if (StringUtils.isNotBlank(radioButtonId)) {
			scriptUtils.click(By.id(radioButtonId));
		}

		scriptUtils.click(By.id(STAGE1_CONTINUE));
	}

	public void fillInWoodenFenceStage2(String jobRequirment, String fenceLengthXPath, String fenceLength, String[] typeOfFencesRequiredXPath,
			String typeOfFencesRequiredOtherXPath, String typeOfFencesRequiredOtherText, String fencesHeight, String supplyingMaterial) {
		if (StringUtils.isNotBlank(jobRequirment)) {
			scriptUtils.click(By.id(jobRequirment));
		}

		if (StringUtils.isNotBlank(fenceLength) && StringUtils.isNotBlank(fenceLengthXPath)) {
			Select fencesLengthSelect = new Select(driver.findElement(By.xpath(fenceLengthXPath)));
			fencesLengthSelect.selectByValue(fenceLength);
		}

		if (typeOfFencesRequiredXPath != null) {
			for (int i = 0; i < typeOfFencesRequiredXPath.length; i++) {
				scriptUtils.click(By.xpath(typeOfFencesRequiredXPath[i]));
			}

			if (StringUtils.isNotBlank(typeOfFencesRequiredOtherText) && StringUtils.isNotBlank(typeOfFencesRequiredOtherXPath)) {
				scriptUtils.fillInTextField(typeOfFencesRequiredOtherXPath, typeOfFencesRequiredOtherText);
			}
		}

		if (StringUtils.isNotBlank(fencesHeight)) {
			scriptUtils.click(By.id(fencesHeight));
		}

		if (StringUtils.isNotBlank(supplyingMaterial)) {
			scriptUtils.click(By.id(supplyingMaterial));
		}

		scriptUtils.click(By.id(STAGE2_CONTINUE_FENCES));
	}

	public void fillInGardenWallsStage2(String jobRequirment, String fenceLengthXPath, String fenceLength, String fencesHeight, String supplyingMaterial) {
		if (StringUtils.isNotBlank(jobRequirment)) {
			scriptUtils.click(By.id(jobRequirment));
		}

		if (StringUtils.isNotBlank(fenceLength) && StringUtils.isNotBlank(fenceLengthXPath)) {
			Select fencesLengthSelect = new Select(driver.findElement(By.xpath(fenceLengthXPath)));
			fencesLengthSelect.selectByValue(fenceLength);
		}

		if (StringUtils.isNotBlank(fencesHeight)) {
			scriptUtils.click(By.id(fencesHeight));
		}

		if (StringUtils.isNotBlank(supplyingMaterial)) {
			scriptUtils.click(By.id(supplyingMaterial));
		}

		scriptUtils.click(By.id(STAGE2_CONTINUE_GARDEN_WALLS));
	}

	public void fillInGatesStage2(String jobRequirment, String[] typeOfGateSelectionXPath, String typeOfGateOtherXPath, String typeOfGateOtherText,
			String supplyingMaterial) {
		if (StringUtils.isNotBlank(jobRequirment)) {
			scriptUtils.click(By.id(jobRequirment));
		}

		if (typeOfGateSelectionXPath != null) {
			for (int i = 0; i < typeOfGateSelectionXPath.length; i++) {
				scriptUtils.click(By.xpath(typeOfGateSelectionXPath[i]));
			}

			if (StringUtils.isNotBlank(typeOfGateOtherText)) {
				scriptUtils.fillInXpathField(typeOfGateOtherXPath, typeOfGateOtherText);
			}
		}

		if (StringUtils.isNotBlank(supplyingMaterial)) {
			scriptUtils.click(By.id(supplyingMaterial));
		}

		scriptUtils.click(By.id(STAGE2_CONTINUE_GATES));
	}

	public void fillInStage3(String jobStatusId, String ownershipStatusId, String jobTimingValue, String postcode, String additionalInfo) {
		if (StringUtils.isNotBlank(jobStatusId)) {
			scriptUtils.click(By.id(jobStatusId));
		}

		if (StringUtils.isNotBlank(ownershipStatusId)) {
			scriptUtils.click(By.id(ownershipStatusId));
		}

		if (StringUtils.isNotBlank(jobTimingValue)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(TIMING_SELECT_ELEMENT)));
			jobTypeSelect.selectByValue(jobTimingValue);
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
}
