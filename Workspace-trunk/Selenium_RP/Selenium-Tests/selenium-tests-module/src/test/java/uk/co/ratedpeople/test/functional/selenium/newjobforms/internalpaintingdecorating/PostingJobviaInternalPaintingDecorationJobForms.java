/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.internalpaintingdecorating;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author shabana.khanam
 * 
 */
public class PostingJobviaInternalPaintingDecorationJobForms extends TestScript {

	private static final String NUMBER_OF_ROOMS_TO_DECORATE_OTHER_ADDITIONAL_XPATH = ".//*[@id='form-multipage-job-detail']/form/section/div[1]/div[2]/ul/li[4]/div/textarea";
	private static final String NUMBER_OF_ROOMS_TO_DECORATE_OTHER_XPATH = ".//*[@id='form-multipage-job-detail']/form/section/div[1]/div[2]/ul/li[4]/a[2]";
	private static final String NUMBER_OF_ROOMS_TO_DECORATE_XPATH = ".//*[@id='form-multipage-job-detail']/form/section/div[1]/div[1]/ul/li[1]/a[2]";
	private static final String SERVICE_REQUIRE_OTHER_TEXT_ID = "serviceRequireOtherText";
	private static final String SERVICE_REQUIRE_OTHER_CHECKBOX_ID = "serviceRequireOther";
	private static final String ADDITIONAL_INFO_TEXT_AREA_XPATH = ".//*[@id='additionalDetailsContainer']/textarea";
	private static final String POSTCODE_FIELD = "postcode";
	private static final String SCREEN2_NEXT_BUTTON = ".//*[@id='stage2']/div[7]/div/button[1]";
	private static final String SCREEN1_NEXT_BUTTON = ".//*[@id='form-multipage-job-detail']/form/section/div[4]/button[2]";
	private static final String SCREEN3_NEXT_BUTTON = ".//*[@id='stage3']/div[2]/div/button[1]";
	private static final String BUDGET_SELECT_ELEMENT = "jobBudgetCode";
	private static final String TIMING_SELECT_ELEMENT = "timing";
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;
	private static final String IPD_TRADE_CODE = "decorator";
	private static final String IPD_SKILL_TYPE_ID = "20";

	public PostingJobviaInternalPaintingDecorationJobForms(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
		this.driver = driver;
		this.testUrl = testUrl;
		this.scriptUtils = scriptUtils;
	}

	public void fillInStage1(String question2ServicesRequired, String question3ServicesRequired, boolean question1Other, String question1OtherText,
			boolean question2Other, String question2OtherText, boolean selectHowManyRooms) {
		if (selectHowManyRooms) {
			scriptUtils.click(By.xpath(NUMBER_OF_ROOMS_TO_DECORATE_XPATH));
		}

		if (question1Other) {
			scriptUtils.click(By.xpath(NUMBER_OF_ROOMS_TO_DECORATE_OTHER_XPATH));
			scriptUtils.fillInXpathField(NUMBER_OF_ROOMS_TO_DECORATE_OTHER_ADDITIONAL_XPATH, question1OtherText);
		}

		if (StringUtils.isNotBlank(question2ServicesRequired)) {
			scriptUtils.select(By.id(question2ServicesRequired));
		}

		if (StringUtils.isNotBlank(question3ServicesRequired)) {
			scriptUtils.select(By.id(question3ServicesRequired));
		}

		if (question2Other) {
			scriptUtils.select(By.id(SERVICE_REQUIRE_OTHER_CHECKBOX_ID));
			scriptUtils.fillInTextField(SERVICE_REQUIRE_OTHER_TEXT_ID, question2OtherText);
		}

		scriptUtils.click(By.xpath(SCREEN1_NEXT_BUTTON));
	}

	public void fillInStage2(String jobStatus, String ownershipStatus, String timing, String material, String postcode, String additionalDetails) {
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

		if (StringUtils.isNotBlank(material)) {
			scriptUtils.click(By.id(material));
		}

		if (StringUtils.isNotBlank(postcode)) {
			scriptUtils.fillInTextField(POSTCODE_FIELD, postcode);
		}

		if (StringUtils.isNotBlank(additionalDetails)) {
			scriptUtils.fillInXpathField(ADDITIONAL_INFO_TEXT_AREA_XPATH, additionalDetails);
		}

		scriptUtils.click(By.xpath(SCREEN2_NEXT_BUTTON));
	}

	public void fillInStage3(String budget) {
		if (StringUtils.isNotBlank(budget)) {
			Select budgetSelect = new Select(driver.findElement(By.id(BUDGET_SELECT_ELEMENT)));
			budgetSelect.selectByValue(budget);
		}

		scriptUtils.click(By.xpath(SCREEN3_NEXT_BUTTON));
	}

	public void getQuotes() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, IPD_SKILL_TYPE_ID, IPD_TRADE_CODE);
	}


}
