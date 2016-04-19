package uk.co.ratedpeople.test.functional.selenium.newjobforms.internalpaintingdecorating;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

public class PostingJobviaInternalPaintingDecoratingJobFormsNegativeTest extends TestScript {

	private static final String XPATH_HOW_MANY_ROOMS_NOT_SELECTED_ERROR = ".//*[@id='form-multipage-job-detail']/form/section/div[1]/div[3]/div/label";
	private static final String XPATH_HOW_MANY_ROOMS_OTHER_TEXT_ERROR = ".//*[@id='form-multipage-job-detail']/form/section/div[1]/div[2]/ul/li[4]/div/div/label";
	private static final String XPATH_WHAT_SERVICE_DO_YOU_REQUIRE_Q2_ERROR = ".//*[@id='form-multipage-job-detail']/form/section/div[2]/div[2]/label";
	private static final String XPATH_WHAT_SERVICE_DO_YOU_REQUIRE_OTHER_TEXT_ERROR = ".//*[@id='form-multipage-job-detail']/form/section/div[2]/div[1]/ul/li[6]/div/label";
	private static final String XPATH_WALL_CONDITION_ERROR = ".//*[@id='form-multipage-job-detail']/form/section/div[3]/div/div/label";
	private static final String XPATH_STAGE2_JOB_STATUS_ERROR = ".//*[@id='stage2']/div[2]/div/label";
	private static final String XPATH_STAGE2_OWNERSHIP_STATUS_ERROR = ".//*[@id='stage2']/div[3]/div/label";
	private static final String XPATH_STAGE2_TIMING_ERROR = ".//*[@id='timeframe']/div/label";
	private static final String XPATH_STAGE2_MATERIAL_ERROR = ".//*[@id='stage2']/div[1]/div/label";
	private static final String XPATH_STAGE2_POSTCODE_ERROR = ".//*[@id='stage2']/div[5]/div/label";
	private static final String XPATH_STAGE2_ADDITIONAL_DETAILS_ERROR = ".//*[@id='additionalDetailsContainer']/div/label";
	private static final String XPATH_STAGE3_BUDGET_ERROR = ".//*[@id='stage3']/div[1]/div[3]/label";

	private static final String IN_REPAIR_RADIO = "inRepair";
	private static final String PAINTING_CHECKBOX_ID = "painting";
	private static final String IM_READY_TO_HIRE_RADIO_BTN = "statusREADY_TO_HIRE";
	private static final String OWNER_OWN_AND_LIVE_RADIO = "ownerOWN_AND_LIVE";
	private static final String URGENTLY = "URGENTLY";
	private static final String HAVE_MATERIAL_RADIO = "haveMaterial";
	private static final String POSTCODE = "AL48TD";
	private static final String INCORRECT_POSTCODE = "ALTD";
	private static final String ADDITIONAL_DETAILS = "additional info additional info additional info additional info additional info additional info additional info additional info";
	private static final String BUDGET_500 = "LT_500";
	private static final String FIRSTNAME = "Alan";
	private static final String LASTNAME = "Andrews";
	private static final String PHONE_NUMBER = "01234567890";
	private static final String INVALID_PHONE_NUMBER = "sa";
	private static final String INVALID_UK_PHONE_NUMBER = "0123456789";
	private static final String EMAIL = "a@mail.com";
	private static final String INVALID_EMAIL = "a@mail.";

	private static final String HOW_MANY_ROOM_ERROR_MESSAGE = "At least one option needs to be selected";
	private static final String HOW_MANY_ROOM_OTHER_TEXT_ERROR_MESSAGE = "List the rooms you need decorated";
	private static final String SERVICE_REQUIRED_ERROR_MESSAGE = "Select at least one";
	private static final String SERVICE_OTHER_ERROR_MESSAGE = "List the type of decoration you need";
	private static final String WALL_CONDITION_ERROR_MESSAGE = "Select if any rooms need repair, or I'm not sure if you're unsure";
	private static final String JOB_STATUS_ERROR_MESSAGE = "Select the appropriate status of the job";
	private static final String OWNERSHIP_STATUS_ERROR_MESSAGE = "Select your ownership status";
	private static final String JOB_TIMING_ERROR_MESSAGE = "Select when you want the job to start";
	private static final String MATERIAL_ERROR_MESSAGE = "Select who will supply the paint/wallpaper or if unsure select 'I would like some advice'";
	private static final String EMPTY_POSTCODE_ERROR_MESSAGE = "Enter your postcode";
	private static final String INVALID_UK_POSTCODE_ERROR_MESSAGE = "Enter a UK postcode";
	private static final String ADDITIONAL_INFO_ERROR_MESSAGE = "Enter additional details about your job";
	private static final String BUDGET_ERROR_MESSAGE = "Select an approximate budget";

	private static final String UK_PHONE_NUMBER_ERROR_MESSAGE = "Please enter a valid, 11-digit UK phone number (example: 07..., 020..., 0161..., etc.)";
	private static final String INVALID_PHONE_NUMBER_ERROR_MESSAGE = "Please enter a valid, 11-digit UK phone number (example: 07..., 020..., 0161..., etc.)";

	private static final String INVALID_EMAIL_ERROR_MESSAGE = "The address entered has an invalid email address format. Please correct and try again.";

	private PostingJobviaInternalPaintingDecorationJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobviaInternalPaintingDecorationJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void whenStage1_How_Many_Rooms_NotSelectedThenErrorMessageShouldBeDisplayed() throws Exception {
		underTest.fillInStage1(PAINTING_CHECKBOX_ID, IN_REPAIR_RADIO, false, "", false, "", false);

		assertEquals(context.driver.findElement(By.xpath(XPATH_HOW_MANY_ROOMS_NOT_SELECTED_ERROR)).getText(), HOW_MANY_ROOM_ERROR_MESSAGE);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void whenOtherTextMissingFromStage1_How_Many_Rooms_ThenErrorMessageShouldBeDisplayed() throws Exception {
		underTest.fillInStage1(PAINTING_CHECKBOX_ID, IN_REPAIR_RADIO, true, null, false, "", false);

		assertEquals(context.driver.findElement(By.xpath(XPATH_HOW_MANY_ROOMS_OTHER_TEXT_ERROR)).getText(), HOW_MANY_ROOM_OTHER_TEXT_ERROR_MESSAGE);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void whenStage1_Which_Services_Do_You_Require_NotSelectedThenErrorMessageShouldBeDisplayed() throws Exception {
		underTest.fillInStage1(null, IN_REPAIR_RADIO, false, "", false, "", true);

		assertEquals(context.driver.findElement(By.xpath(XPATH_WHAT_SERVICE_DO_YOU_REQUIRE_Q2_ERROR)).getText(), SERVICE_REQUIRED_ERROR_MESSAGE);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void whenOtherTextMissingFromStage1_Which_services_Do_You_Require_ThenErrorMessageShouldBeDisplayed() throws Exception {
		underTest.fillInStage1(null, IN_REPAIR_RADIO, false, "", true, null, false);

		assertEquals(context.driver.findElement(By.xpath(XPATH_WHAT_SERVICE_DO_YOU_REQUIRE_OTHER_TEXT_ERROR)).getText(), SERVICE_OTHER_ERROR_MESSAGE);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void whenStage1_Which_Services_Do_You_Require_2NotSelectedThenErrorMessageShouldBeDisplayed() throws Exception {
		underTest.fillInStage1(PAINTING_CHECKBOX_ID, null, false, "", false, "", false);

		assertEquals(context.driver.findElement(By.xpath(XPATH_WALL_CONDITION_ERROR)).getText(), WALL_CONDITION_ERROR_MESSAGE);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void whenStage2JobStatusNotSelectedThenErrorMessageShouldBeDisplayed() throws Exception {
		fillJobDetails();

		underTest.fillInStage2(null, OWNER_OWN_AND_LIVE_RADIO, URGENTLY, HAVE_MATERIAL_RADIO, POSTCODE, ADDITIONAL_DETAILS);

		assertEquals(context.driver.findElement(By.xpath(XPATH_STAGE2_JOB_STATUS_ERROR)).getText(), JOB_STATUS_ERROR_MESSAGE);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void whenStage2OwnershipStatusNotSelectedThenErrorMessageShouldBeDisplayed() throws Exception {
		fillJobDetails();

		underTest.fillInStage2(IM_READY_TO_HIRE_RADIO_BTN, null, URGENTLY, HAVE_MATERIAL_RADIO, POSTCODE, ADDITIONAL_DETAILS);

		assertEquals(context.driver.findElement(By.xpath(XPATH_STAGE2_OWNERSHIP_STATUS_ERROR)).getText(), OWNERSHIP_STATUS_ERROR_MESSAGE);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void whenStage2TimingNotSelectedThenErrorMessageShouldBeDisplayed() throws Exception {
		fillJobDetails();

		underTest.fillInStage2(IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO, null, HAVE_MATERIAL_RADIO, POSTCODE, ADDITIONAL_DETAILS);

		assertEquals(context.driver.findElement(By.xpath(XPATH_STAGE2_TIMING_ERROR)).getText(), JOB_TIMING_ERROR_MESSAGE);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void whenStage2MaterialsNotSelectedThenErrorMessageShouldBeDisplayed() throws Exception {
		fillJobDetails();

		underTest.fillInStage2(IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO, URGENTLY, null, POSTCODE, ADDITIONAL_DETAILS);

		assertEquals(context.driver.findElement(By.xpath(XPATH_STAGE2_MATERIAL_ERROR)).getText(), MATERIAL_ERROR_MESSAGE);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void whenStage2PostCodeNotEnteredThenErrorMessageShouldBeDisplayed() throws Exception {
		fillJobDetails();

		underTest.fillInStage2(IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO, URGENTLY, HAVE_MATERIAL_RADIO, null, ADDITIONAL_DETAILS);

		assertEquals(context.driver.findElement(By.xpath(XPATH_STAGE2_POSTCODE_ERROR)).getText(), EMPTY_POSTCODE_ERROR_MESSAGE);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void whenStage2InvalidPostCodeEnteredThenErrorMessageShouldBeDisplayed() throws Exception {
		fillJobDetails();

		underTest.fillInStage2(IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO, URGENTLY, HAVE_MATERIAL_RADIO, INCORRECT_POSTCODE, ADDITIONAL_DETAILS);

		assertEquals(context.driver.findElement(By.xpath(XPATH_STAGE2_POSTCODE_ERROR)).getText(), INVALID_UK_POSTCODE_ERROR_MESSAGE);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void whenStage2AdditionalDetailsNotEnteredThenErrorMessageShouldBeDisplayed() throws Exception {
		fillJobDetails();

		underTest.fillInStage2(IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO, URGENTLY, HAVE_MATERIAL_RADIO, POSTCODE, null);

		assertEquals(context.driver.findElement(By.xpath(XPATH_STAGE2_ADDITIONAL_DETAILS_ERROR)).getText(), ADDITIONAL_INFO_ERROR_MESSAGE);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void whenStage3BudgetNotSelectedThenErrorMessageShouldBeDisplayed() throws Exception {
		fillJobDetails();
		fillAdditionalInfo();

		underTest.fillInStage3(null);

		assertEquals(context.driver.findElement(By.xpath(XPATH_STAGE3_BUDGET_ERROR)).getText(), BUDGET_ERROR_MESSAGE);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void whenStage4FirstPersonalDetailsNotEnteredThenErrorMessageShouldBeDisplayed() throws Exception {
		fillJobDetails();
		fillAdditionalInfo();
		selectBudgetInfo();

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void whenStage4FirstNameNotEnteredThenErrorMessageShouldBeDisplayed() throws Exception {
		fillJobDetails();
		fillAdditionalInfo();
		selectBudgetInfo();

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, LASTNAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL, EMAIL);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void whenStage4LastNameNotEnteredThenErrorMessageShouldBeDisplayed() throws Exception {
		fillJobDetails();
		fillAdditionalInfo();
		selectBudgetInfo();

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, null, PHONE_NUMBER, PHONE_NUMBER, EMAIL, EMAIL);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void whenStage4PhoneNumberNotEnteredThenErrorMessageShouldBeDisplayed() throws Exception {
		fillJobDetails();
		fillAdditionalInfo();
		selectBudgetInfo();

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, null, null, EMAIL, EMAIL);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void whenStage4InvalidPhoneNumberEnteredThenErrorMessageShouldBeDisplayed() throws Exception {
		fillJobDetails();
		fillAdditionalInfo();
		selectBudgetInfo();

		JobFormSeleniumHelper
				.fillInContactPageDetailsAndPostJob(scriptUtilities, null, FIRSTNAME, LASTNAME, INVALID_PHONE_NUMBER, INVALID_PHONE_NUMBER, EMAIL, EMAIL);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), INVALID_PHONE_NUMBER_ERROR_MESSAGE);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void whenStage4InvalidUKPhoneNumberEnteredThenErrorMessageShouldBeDisplayed() throws Exception {
		fillJobDetails();
		fillAdditionalInfo();
		selectBudgetInfo();

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, null, FIRSTNAME, LASTNAME, INVALID_UK_PHONE_NUMBER, INVALID_UK_PHONE_NUMBER, EMAIL,
				EMAIL);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), UK_PHONE_NUMBER_ERROR_MESSAGE);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void whenStage4IEmailNotEnteredThenErrorMessageShouldBeDisplayed() throws Exception {
		fillJobDetails();
		fillAdditionalInfo();
		selectBudgetInfo();

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, PHONE_NUMBER, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(enabled = true)
	public void whenStage4InvalidEmailEnteredThenErrorMessageShouldBeDisplayed() throws Exception {
		fillJobDetails();
		fillAdditionalInfo();
		selectBudgetInfo();

		JobFormSeleniumHelper
				.fillInContactPageDetailsAndPostJob(scriptUtilities, null, FIRSTNAME, LASTNAME, PHONE_NUMBER, PHONE_NUMBER, INVALID_EMAIL, INVALID_EMAIL);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), INVALID_EMAIL_ERROR_MESSAGE);

	}

	public void fillJobDetails() {
		underTest.fillInStage1(PAINTING_CHECKBOX_ID, IN_REPAIR_RADIO, false, "", false, "", true);
	}

	public void fillAdditionalInfo() {
		underTest.fillInStage2(IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO, URGENTLY, HAVE_MATERIAL_RADIO, POSTCODE,
				TestScriptUtilities.getRandomString(30));
	}

	public void selectBudgetInfo() {
		underTest.fillInStage3(BUDGET_500);
	}
}
