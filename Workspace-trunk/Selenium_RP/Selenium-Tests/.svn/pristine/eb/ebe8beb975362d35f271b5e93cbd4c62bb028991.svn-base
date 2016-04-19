package uk.co.ratedpeople.test.functional.selenium.newjobforms.gasboilers;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

public class PostingJobviaGasBoilerJobFormsNegativeTestForInstall extends TestScript {

	private static final String RADIO_INSTALL = ".//*[@id='radioInstall']";
	private static final String CONTINUE_BUTTON = ".//*[@id='stage1SelectButton']";

	private static final String BOILER_TYPE_INSTALLED = "47";
	private static final String BOILER_TYPE_REQUIRED = "53";
	private static final String BOILER_MAKE = "58";
	private static final String BOILER_NUMBER_OF_RADIATOR = "78";
	private static final String POSTCODE = "AL48TD";
	private static final String INCORRECT_POSTCODE = "ALTD";
	private static final String TIMING = "URGENTLY";
	private static final String OWNER_LANDLORD_RADIO_ID = "ownerLANDLORD";
	private static final String IM_READY_TO_HIRE_RADIO_BTN = "statusREADY_TO_HIRE";
	private static final String BUDGET = "140_LT_3000";
	private static final String FIRSTNAME = "Alan";
	private static final String LASTNAME = "Andrews";
	private static final String PHONE_NUMBER = "01234567890";
	private static final String INVALID_PHONE_NUMBER = "sa";
	private static final String INVALID_UK_PHONE_NUMBER = "0123456789";
	private static final String EMAIL = "a@mail.com";
	private static final String INVALID_EMAIL = "a@mail.";

	private static final String BOILER_CURRENTLY_INSTALLED_ERROR_XPATH = ".//*[@id='descInstall']/div[1]/div[2]/label";
	private static final String BOILER_REQUIRED_ERROR_XPATH = ".//*[@id='descInstall']/div[2]/div[2]/label";
	private static final String BOILER_MAKE_ERROR_XPATH = ".//*[@id='descInstall']/div[3]/div[2]/label";
	private static final String BOILER_NUMBER_OF_RADIATOR_ERROR_XPATH = ".//*[@id='descInstall']/div[4]/div/label";
	private static final String JOB_STATUS_ERROR_XPATH = ".//*[@id='stage2']/div[1]/div/label";
	private static final String OWNERSHIP_STATUS_ERROR_XPATH = ".//*[@id='stage2']/div[2]/div/label";
	private static final String TIMING_ERROR_XPATH = ".//*[@id='stage2']/div[3]/div/label";
	private static final String POSTCODE_ERROR_XPATH = ".//*[@id='stage2']/div[4]/div/label";
	private static final String ADDITIONAL_JOB_DETAIL_ERROR_XPATH = ".//*[@id='additionalDetailsContainer']/div/label";
	private static final String BUDGET_ERROR_XPATH = ".//*[@id='stage3']/div[1]/div[3]/label";

	private static final String SELECT_A_BOILER = "Select a boiler from the list";
	private static final String SELECT_NUMBER_RADIATOR = "Select number of radiators";
	private static final String SELECT_JOB_STATUS = "Select the appropriate status of the job";
	private static final String SELECT_OWNERSHIP_STATUS = "Select your ownership status";
	private static final String SELECT_TIMING = "Select when you want the job to start";
	private static final String ENTER_POSTCODE = "Enter your postcode";
	private static final String ENTER_UK_POSTCODE = "Enter a UK postcode";
	private static final String ENTER_ADDITIONAL_DETAILS = "Enter additional details about your job";

	private PostingJobviaGasBoilersJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobviaGasBoilersJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaGasBoilersJobFormsNoFieldsSelectedTest() throws Exception {
		selectInstall();
		underTest.fillInInstallGasBoilerStage2(null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(BOILER_CURRENTLY_INSTALLED_ERROR_XPATH)).getText(), SELECT_A_BOILER);
		assertEquals(context.driver.findElement(By.xpath(BOILER_REQUIRED_ERROR_XPATH)).getText(), SELECT_A_BOILER);
		assertEquals(context.driver.findElement(By.xpath(BOILER_MAKE_ERROR_XPATH)).getText(), SELECT_A_BOILER);
		assertEquals(context.driver.findElement(By.xpath(BOILER_NUMBER_OF_RADIATOR_ERROR_XPATH)).getText(), SELECT_NUMBER_RADIATOR);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_TypeOfBoilerInstalledNotSelected() throws Exception {

		selectInstall();
		underTest.fillInInstallGasBoilerStage2(null, BOILER_TYPE_REQUIRED, BOILER_MAKE, BOILER_NUMBER_OF_RADIATOR);

		assertEquals(context.driver.findElement(By.xpath(BOILER_CURRENTLY_INSTALLED_ERROR_XPATH)).getText(), SELECT_A_BOILER);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_TypeOfBoilerRequiredNotSelected() throws Exception {

		selectInstall();
		underTest.fillInInstallGasBoilerStage2(BOILER_TYPE_INSTALLED, null, BOILER_MAKE, BOILER_NUMBER_OF_RADIATOR);

		assertEquals(context.driver.findElement(By.xpath(BOILER_REQUIRED_ERROR_XPATH)).getText(), SELECT_A_BOILER);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_BoilerMakeNotSelected() throws Exception {

		selectInstall();
		underTest.fillInInstallGasBoilerStage2(BOILER_TYPE_INSTALLED, BOILER_TYPE_REQUIRED, null, BOILER_NUMBER_OF_RADIATOR);

		assertEquals(context.driver.findElement(By.xpath(BOILER_MAKE_ERROR_XPATH)).getText(), SELECT_A_BOILER);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_NoRadiatorRequiredNotSelected() throws Exception {

		selectInstall();
		underTest.fillInInstallGasBoilerStage2(BOILER_TYPE_INSTALLED, BOILER_TYPE_REQUIRED, BOILER_MAKE, null);

		assertEquals(context.driver.findElement(By.xpath(BOILER_NUMBER_OF_RADIATOR_ERROR_XPATH)).getText(), SELECT_NUMBER_RADIATOR);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_Page2_NothingSelectedOrEntered() throws Exception {
		selectInstall();
		selectJobDetailInfo();

		underTest.fillInStage3(null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(JOB_STATUS_ERROR_XPATH)).getText(), SELECT_JOB_STATUS);
		assertEquals(context.driver.findElement(By.xpath(OWNERSHIP_STATUS_ERROR_XPATH)).getText(), SELECT_OWNERSHIP_STATUS);
		assertEquals(context.driver.findElement(By.xpath(TIMING_ERROR_XPATH)).getText(), SELECT_TIMING);
		assertEquals(context.driver.findElement(By.xpath(POSTCODE_ERROR_XPATH)).getText(), ENTER_POSTCODE);
		assertEquals(context.driver.findElement(By.xpath(ADDITIONAL_JOB_DETAIL_ERROR_XPATH)).getText(), ENTER_ADDITIONAL_DETAILS);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_Page2_JobStatusNotSelectedOrEntered() throws Exception {
		selectInstall();
		selectJobDetailInfo();

		underTest.fillInStage3(null, OWNER_LANDLORD_RADIO_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(30));

		assertEquals(context.driver.findElement(By.xpath(JOB_STATUS_ERROR_XPATH)).getText(), SELECT_JOB_STATUS);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_Page2_OwnershipStatusNotSelectedOrEntered() throws Exception {
		selectInstall();
		selectJobDetailInfo();

		underTest.fillInStage3(IM_READY_TO_HIRE_RADIO_BTN, null, TIMING, POSTCODE, TestScriptUtilities.getRandomString(30));

		assertEquals(context.driver.findElement(By.xpath(OWNERSHIP_STATUS_ERROR_XPATH)).getText(), SELECT_OWNERSHIP_STATUS);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_Page2_TimingNotSelectedOrEntered() throws Exception {
		selectInstall();
		selectJobDetailInfo();

		underTest.fillInStage3(IM_READY_TO_HIRE_RADIO_BTN, OWNER_LANDLORD_RADIO_ID, null, POSTCODE, TestScriptUtilities.getRandomString(30));

		assertEquals(context.driver.findElement(By.xpath(TIMING_ERROR_XPATH)).getText(), SELECT_TIMING);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_Page2_PostcodeNotSelectedOrEntered() throws Exception {
		selectInstall();
		selectJobDetailInfo();

		underTest.fillInStage3(IM_READY_TO_HIRE_RADIO_BTN, OWNER_LANDLORD_RADIO_ID, TIMING, null, TestScriptUtilities.getRandomString(30));

		assertEquals(context.driver.findElement(By.xpath(POSTCODE_ERROR_XPATH)).getText(), ENTER_POSTCODE);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_Page2_IncorrectPostcodeEntered() throws Exception {
		selectInstall();
		selectJobDetailInfo();

		underTest.fillInStage3(IM_READY_TO_HIRE_RADIO_BTN, OWNER_LANDLORD_RADIO_ID, TIMING, INCORRECT_POSTCODE, TestScriptUtilities.getRandomString(30));

		assertEquals(context.driver.findElement(By.xpath(POSTCODE_ERROR_XPATH)).getText(), ENTER_UK_POSTCODE);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_Page2_AdditionalJonInfoNotSelectedOrEntered() throws Exception {
		selectInstall();
		selectJobDetailInfo();

		underTest.fillInStage3(IM_READY_TO_HIRE_RADIO_BTN, OWNER_LANDLORD_RADIO_ID, TIMING, POSTCODE, null);

		assertEquals(context.driver.findElement(By.xpath(ADDITIONAL_JOB_DETAIL_ERROR_XPATH)).getText(), ENTER_ADDITIONAL_DETAILS);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_Page3_BudgetNotSelectedOrEntered() throws Exception {
		selectInstall();
		selectJobDetailInfo();
		selectAdditionalInfo();

		underTest.fillInStage4(null);

		assertEquals(context.driver.findElement(By.xpath(BUDGET_ERROR_XPATH)).getText(), PostingJobviaGasBoilersJobForms.SELECT_BUDGET);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_Page4_NothingSelectedOrEntered() throws Exception {
		selectInstall();
		selectJobDetailInfo();
		selectAdditionalInfo();
		selectBudgetInfo();

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(PostingJobviaGasBoilersJobForms.FIRSTNAME_ERROR_XPATH)).getText(),
				PostingJobviaGasBoilersJobForms.ENTER_FIRSTNAME);
		assertEquals(context.driver.findElement(By.xpath(PostingJobviaGasBoilersJobForms.LASTNAME_ERROR_XPATH)).getText(),
				PostingJobviaGasBoilersJobForms.ENTER_LASTNAME);
		assertEquals(context.driver.findElement(By.xpath(PostingJobviaGasBoilersJobForms.PHONE_NUMBER_ERROR_XPATH)).getText(),
				PostingJobviaGasBoilersJobForms.ENTER_PHONE_NUMBER);
		assertEquals(context.driver.findElement(By.xpath(PostingJobviaGasBoilersJobForms.CONFIRM_PHONE_NUMBER_ERROR_XPATH)).getText(),
				PostingJobviaGasBoilersJobForms.CONFIRM_PHONE_NUMBER);
		assertEquals(context.driver.findElement(By.xpath(PostingJobviaGasBoilersJobForms.EMAIL_ERROR_XPATH)).getText(),
				PostingJobviaGasBoilersJobForms.ENTER_EMAIL);
		assertEquals(context.driver.findElement(By.xpath(PostingJobviaGasBoilersJobForms.CONFIRM_EMAIL_ERROR_XPATH)).getText(),
				PostingJobviaGasBoilersJobForms.CONFIRM_EMAIL);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_Page4_FirstNameNotSelectedOrEntered() throws Exception {
		selectInstall();
		selectJobDetailInfo();
		selectAdditionalInfo();
		selectBudgetInfo();

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, LASTNAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL, EMAIL);

		assertEquals(context.driver.findElement(By.xpath(PostingJobviaGasBoilersJobForms.FIRSTNAME_ERROR_XPATH)).getText(),
				PostingJobviaGasBoilersJobForms.ENTER_FIRSTNAME);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_Page4_LastNameNotSelectedOrEntered() throws Exception {
		selectInstall();
		selectJobDetailInfo();
		selectAdditionalInfo();
		selectBudgetInfo();

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, null, PHONE_NUMBER, PHONE_NUMBER, EMAIL, EMAIL);

		assertEquals(context.driver.findElement(By.xpath(PostingJobviaGasBoilersJobForms.LASTNAME_ERROR_XPATH)).getText(),
				PostingJobviaGasBoilersJobForms.ENTER_LASTNAME);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_Page4_PhoneNumberNotSelectedOrEntered() throws Exception {
		selectInstall();
		selectJobDetailInfo();
		selectAdditionalInfo();
		selectBudgetInfo();

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, null, null, EMAIL, EMAIL);

		assertEquals(context.driver.findElement(By.xpath(PostingJobviaGasBoilersJobForms.PHONE_NUMBER_ERROR_XPATH)).getText(),
				PostingJobviaGasBoilersJobForms.ENTER_PHONE_NUMBER);
		assertEquals(context.driver.findElement(By.xpath(PostingJobviaGasBoilersJobForms.CONFIRM_PHONE_NUMBER_ERROR_XPATH)).getText(),
				PostingJobviaGasBoilersJobForms.CONFIRM_PHONE_NUMBER);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_Page4_InvalidPhoneNumberEntered() throws Exception {
		selectInstall();
		selectJobDetailInfo();
		selectAdditionalInfo();
		selectBudgetInfo();

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, null, FIRSTNAME, LASTNAME, INVALID_PHONE_NUMBER, INVALID_PHONE_NUMBER,
				EMAIL, EMAIL);

		assertEquals(context.driver.findElement(By.xpath(PostingJobviaGasBoilersJobForms.PHONE_NUMBER_ERROR_XPATH)).getText(),
				PostingJobviaGasBoilersJobForms.ENTER_VALID_PHONE_NUMBER);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_Page4_InvalidUKPhoneNumberEntered() throws Exception {
		selectInstall();
		selectJobDetailInfo();
		selectAdditionalInfo();
		selectBudgetInfo();

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, null, FIRSTNAME, LASTNAME, INVALID_UK_PHONE_NUMBER,
				INVALID_UK_PHONE_NUMBER, EMAIL, EMAIL);

		assertEquals(context.driver.findElement(By.xpath(PostingJobviaGasBoilersJobForms.PHONE_NUMBER_ERROR_XPATH)).getText(),
				PostingJobviaGasBoilersJobForms.ENTER_UK_PHONE_NUMBER);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_Page4_EmailNotEntered() throws Exception {
		selectInstall();
		selectJobDetailInfo();
		selectAdditionalInfo();
		selectBudgetInfo();

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, INVALID_UK_PHONE_NUMBER,
				INVALID_UK_PHONE_NUMBER, null, null);

		assertEquals(context.driver.findElement(By.xpath(PostingJobviaGasBoilersJobForms.EMAIL_ERROR_XPATH)).getText(),
				PostingJobviaGasBoilersJobForms.ENTER_EMAIL);
		assertEquals(context.driver.findElement(By.xpath(PostingJobviaGasBoilersJobForms.CONFIRM_EMAIL_ERROR_XPATH)).getText(),
				PostingJobviaGasBoilersJobForms.CONFIRM_EMAIL);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaGasBoilersJobForms_Page4_InvalidEmailEntered() throws Exception {
		selectInstall();
		selectJobDetailInfo();
		selectAdditionalInfo();
		selectBudgetInfo();

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, null, FIRSTNAME, LASTNAME, PHONE_NUMBER, PHONE_NUMBER, INVALID_EMAIL,
				INVALID_EMAIL);

		assertEquals(context.driver.findElement(By.xpath(PostingJobviaGasBoilersJobForms.EMAIL_ERROR_XPATH)).getText(),
				PostingJobviaGasBoilersJobForms.ENTER_VALID_EMAIL);
	}

	public void selectInstall() {
		scriptUtilities.click(By.xpath(RADIO_INSTALL));
		WebDriverWait waitforcontinue = new WebDriverWait(context.driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(CONTINUE_BUTTON)));
		scriptUtilities.click(By.xpath(CONTINUE_BUTTON));
		WebDriverWait waitfornext = new WebDriverWait(context.driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(CONTINUE_BUTTON)));
	}

	public void selectJobDetailInfo() {
		underTest.fillInInstallGasBoilerStage2(BOILER_TYPE_INSTALLED, BOILER_TYPE_REQUIRED, BOILER_MAKE, BOILER_NUMBER_OF_RADIATOR);
	}

	public void selectAdditionalInfo() {
		underTest.fillInStage3(IM_READY_TO_HIRE_RADIO_BTN, OWNER_LANDLORD_RADIO_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(30));
	}

	public void selectBudgetInfo() {
		underTest.fillInStage4(BUDGET);
	}

}
