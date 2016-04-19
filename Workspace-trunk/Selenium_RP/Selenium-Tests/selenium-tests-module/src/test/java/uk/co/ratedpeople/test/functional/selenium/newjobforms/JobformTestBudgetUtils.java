package uk.co.ratedpeople.test.functional.selenium.newjobforms;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class JobformTestBudgetUtils {

	private static final String SELECT_BUDGET = "selectBudget";
	private static final String ENTER_PROPER_BUDGET = "enterProperBudget";
	private static final String OTHER_BUDGET = "otherbudget";
	private static final String ENTER_BUDGET = "enterBudget";
	private static final String JOB_BUDGET_CODE_XPATH = "jobBudgetCodeXPath";
	private static final String NEXT_STAGE_3_XPATH = "nextStage3XPath";
	private static final String LABEL_OTHER_BUDGET_VALUE_ERROR_XPATH = "labelOtherBudgetValueErrorXPath";
	private static final String LABEL_JOB_BUDGET_CODE_ERROR_XPATH = "labelJobBudgetCodeErrorXPath";

	@SuppressWarnings("serial")
	public static final Map<String, String> xpathLookup = new HashMap<String, String>() {
		{
			put(JOB_BUDGET_CODE_XPATH, ".//*[@id='jobBudgetCode']");
			put(NEXT_STAGE_3_XPATH, ".//*[@id='stage3']/div[2]/div/button");
			put(LABEL_OTHER_BUDGET_VALUE_ERROR_XPATH,
					".//label[@for='otherBudgetValue' and @class='error']");
			put(LABEL_JOB_BUDGET_CODE_ERROR_XPATH,
					".//label[@for='jobBudgetCode' and @class='error']");
			put(OTHER_BUDGET, ".//*[@id='otherBudgetValue']");
		}
	};

	@SuppressWarnings("serial")
	public static final Map<String, String> errorMessages = new HashMap<String, String>() {
		{
			put(SELECT_BUDGET, "Select an approximate budget");
			put(ENTER_BUDGET, "Enter an approximate budget");
			put(ENTER_PROPER_BUDGET,
					"Enter a value greater than or equal to 50");
		}
	};

	public void noBudgetSelected(final TestScript testScript) {
		TestScriptUtilities utils = testScript.getTestScriptUtilities();

		utils.click(By.xpath(xpathLookup.get(NEXT_STAGE_3_XPATH)));
		assertEquals(
				testScript.getTestContext().driver.findElement(
						By.xpath(xpathLookup
								.get(LABEL_JOB_BUDGET_CODE_ERROR_XPATH)))
						.getText(), errorMessages.get(SELECT_BUDGET));
	}

	public void noBudgetEnteredWhenOtherSelected(final TestScript testScript) {
		TestScriptUtilities utils = testScript.getTestScriptUtilities();
		utils.selectDropdown(By.xpath(xpathLookup.get(JOB_BUDGET_CODE_XPATH)),
				10);
		utils.click(By.xpath(xpathLookup.get(NEXT_STAGE_3_XPATH)));
		assertEquals(
				testScript.getTestContext().driver.findElement(
						By.xpath(xpathLookup
								.get(LABEL_OTHER_BUDGET_VALUE_ERROR_XPATH)))
						.getText(), errorMessages.get(ENTER_BUDGET));
	}

	public void negativeBudgetEntered(final TestScript testScript) {
		TestScriptUtilities utils = testScript.getTestScriptUtilities();

		utils.selectDropdown(By.xpath(xpathLookup.get(JOB_BUDGET_CODE_XPATH)),
				10);
		utils.clearAndFillInXpathField(xpathLookup.get(OTHER_BUDGET), "-100");
		utils.click(By.xpath(xpathLookup.get(NEXT_STAGE_3_XPATH)));
		assertEquals(
				testScript.getTestContext().driver.findElement(
						By.xpath(xpathLookup
								.get(LABEL_OTHER_BUDGET_VALUE_ERROR_XPATH)))
						.getText(), errorMessages.get(ENTER_PROPER_BUDGET));
	}
}
