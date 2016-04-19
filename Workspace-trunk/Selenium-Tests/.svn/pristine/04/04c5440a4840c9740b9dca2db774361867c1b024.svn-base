package uk.co.ratedpeople.test.functional.selenium.newjobforms.flooring;

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
public class PostingJobViaFlooringJobForms {

	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.flooring.PostingJobViaFlooringJobForms");

	private static final String STAGE1_CONTINUE = "stage1SelectButton";
	private static final String STAGE2_CONTINUE_CARPETS = "nextDescCarpets";
	private static final String STAGE3_CONTINUE = "next";
	private static final String STAGE4_CONTINUE = ".//*[@id='stage3']/div[2]/div/button[1]";
	private static final String TIMING_SELECT_ELEMENT = "timing";
	private static final String POSTCODE_FIELD = "postcode";
	private static final String ADDITIONAL_INFO_TEXT_AREA_XPATH = ".//*[@id='additionalDetailsContainer']/textarea";
	private static final String BUDGET_SELECT_ELEMENT = "jobBudgetCode";
	private static final String PROPERTY_STYLE_SELECT_ELEMENT = "propertyStyle";

	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;

	public PostingJobViaFlooringJobForms(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
		this.driver = driver;
		this.testUrl = testUrl;
		this.scriptUtils = scriptUtils;
	}

	public void fillInStage1(String radioButtonId) {
		if (StringUtils.isNotBlank(radioButtonId)) {
			scriptUtils.click(By.id(radioButtonId));
		}
		scriptUtils.click(By.id(STAGE1_CONTINUE));
	}

	public void fillInCarpetsStage2(String jobRequirementId, String[] roomsCarpetXPathList, String roomsCarpetOtherXPath, String roomsCarpetOther,
			String[] typesOfCarpetXpath, String typesOfCarpetOtherXPath, String typesOfCarpetOther, String isSupplyingMaterial) {

		if (jobRequirementId != null) {

			if (StringUtils.isNotBlank(jobRequirementId)) {
				scriptUtils.click(By.id(jobRequirementId));
			}

			if (roomsCarpetXPathList != null) {
				for (int i = 0; i < roomsCarpetXPathList.length; i++)

				{
					scriptUtils.click(By.xpath(roomsCarpetXPathList[i]));
				}

				if (StringUtils.isNotBlank(roomsCarpetOther) && StringUtils.isNotBlank(roomsCarpetOtherXPath)) {
					scriptUtils.fillInXpathField(roomsCarpetOtherXPath, roomsCarpetOther);
				}
			}

			if (typesOfCarpetXpath != null) {
				for (int i = 0; i < roomsCarpetXPathList.length; i++)

				{

					scriptUtils.click(By.xpath(typesOfCarpetXpath[i]));
				}

				if (StringUtils.isNotBlank(typesOfCarpetOtherXPath) && StringUtils.isNotBlank(typesOfCarpetOther)) {
					scriptUtils.fillInXpathField(typesOfCarpetOtherXPath, typesOfCarpetOther);
				}
			}

			if (StringUtils.isNotBlank(isSupplyingMaterial)) {
				scriptUtils.click(By.id(isSupplyingMaterial));
			}
		}
		scriptUtils.click(By.id(STAGE2_CONTINUE_CARPETS));
	}

	public void fillInGenericStage2(String jobRequirementId, String[] roomsXPathList, String roomsOtherXPath, String roomsOther, String isSupplyingMaterial,
			String nextButton) {
		if (StringUtils.isNotBlank(jobRequirementId)) {
			scriptUtils.click(By.id(jobRequirementId));
		}

		if (roomsXPathList != null) {
			for (int i = 0; i < roomsXPathList.length; i++) {
				scriptUtils.click(By.xpath(roomsXPathList[i]));
			}

			if (StringUtils.isNotBlank(roomsOtherXPath) && StringUtils.isNotBlank(roomsOther)) {
				scriptUtils.fillInXpathField(roomsOtherXPath, roomsOther);
			}
		}

		if (StringUtils.isNotBlank(isSupplyingMaterial)) {
			scriptUtils.click(By.id(isSupplyingMaterial));
		}

		scriptUtils.click(By.id(nextButton));
	}

	public void fillInStage3(String jobStatusId, String ownershipStatusId, String jobTimingValue, String propertyStyle, String postcode, String additionalInfo) {
		if (StringUtils.isNotBlank(jobStatusId)) {
			scriptUtils.click(By.id(jobStatusId));
		}

		if (StringUtils.isNotBlank(ownershipStatusId)) {
			scriptUtils.click(By.id(ownershipStatusId));
		}

		if (StringUtils.isNotBlank(propertyStyle)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(PROPERTY_STYLE_SELECT_ELEMENT)));
			jobTypeSelect.selectByValue(propertyStyle);
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



	public void getQuotes() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, "30", "flooring");
	}
}
