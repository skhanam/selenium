package uk.co.ratedpeople.test.functional.selenium.newjobforms.carpentry;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author olivier.renard
 * 
 */
public class PostingJobViaCarpentryJobForms {

	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.newbuilds.PostingJobViaCarpentryJobForms");

	private static final String NEXT = "next";

	private static final String TIMING_SELECT_ELEMENT = "timing";
	private static final String POSTCODE_FIELD = "postcode";
	private static final String ADDITIONAL_INFO_TEXT_AREA_XPATH = ".//*[@id='additionalDetailsContainer']/textarea";
	private static final String BUDGET_SELECT_ELEMENT = "jobBudgetCode";
	private static final String OTHER_BUDGET_VALUE_ELEMENT = "otherBudgetValue";
	
	private WebDriver driver;
	private TestScriptUtilities scriptUtils;

	public PostingJobViaCarpentryJobForms(WebDriver driver, TestScriptUtilities scriptUtils) {
		this.driver = driver;
		this.scriptUtils = scriptUtils;
	}

	public void fillInStage1(String jobStatusId, String ownershipStatusId, String jobTimingValue, String postcode, String description) {

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

		if (StringUtils.isNotBlank(description)) {
			scriptUtils.fillInXpathField(ADDITIONAL_INFO_TEXT_AREA_XPATH, description);
		}

		scriptUtils.click(By.id(NEXT));
	}

	public void fillInStage2(final String budget) {
		if (StringUtils.isNotBlank(budget)) {
			Select budgetSelect = new Select(driver.findElement(By.id(BUDGET_SELECT_ELEMENT)));
			budgetSelect.selectByValue(budget);
		}

		scriptUtils.click(By.id(NEXT));
	}

	public void fillInStage2OtherBudget(final String budget, final String value) {
		if (StringUtils.isNotBlank(budget)) {
			Select budgetSelect = new Select(driver.findElement(By.id(BUDGET_SELECT_ELEMENT)));
			budgetSelect.selectByValue(budget);
			if (StringUtils.isNotBlank(value)) {
				scriptUtils.fillInTextField(OTHER_BUDGET_VALUE_ELEMENT, value);
			}
		}

		scriptUtils.click(By.id(NEXT));
	}
}
