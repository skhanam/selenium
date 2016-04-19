package uk.co.ratedpeople.test.functional.selenium.newjobforms.externalwoodendoor;

/**
 * @author danthalapalli.aravind
 * 
 */
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

public class PostingJobViaExternalWoodenDoorsJobFormsNegativeTest extends TestScript {

	private static final String POSTCODE = "POSTCODE";

	private static final int DESCRIPTION_LENGTH_30 = 30;

	private PostingJobviaExternalWoodenDoorsJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobviaExternalWoodenDoorsJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsRepairOrAdjustExternalWoodenDoorsNegativeTest2() throws Exception {

		String[] doorPartsToRepair = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_HINGES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_HANDLES"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_PAINT") };

		underTest.fillInPage1ForJobDetailsForRepairOrAdjustExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_GLAZED"), 3, doorPartsToRepair);

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				null, DESCRIPTION_LENGTH_30, ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsRepairOrAdjustExternalWoodenDoorsNegativeTest3() throws Exception {

		String[] doorPartsToRepair = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_HINGES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_HANDLES"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_PAINT") };

		underTest.fillInPage1ForJobDetailsForRepairOrAdjustExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_GLAZED"), 3, doorPartsToRepair);

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsRepairOrAdjustExternalWoodenDoorsNegativeTest4() throws Exception {

		String[] doorPartsToRepair = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_HINGES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_HANDLES"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_PAINT") };

		underTest.fillInPage1ForJobDetailsForRepairOrAdjustExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_GLAZED"), 3, doorPartsToRepair);

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_500"));

		String lastName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = ExternalWoodenDoorsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = ExternalWoodenDoorsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, lastName, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsRepairOrAdjustExternalWoodenDoorsNegativeTest5() throws Exception {

		underTest.fillInPage1ForJobDetailsForRepairOrAdjustExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_GLAZED"), 3, null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[2]/div[4]/label")).getText(),
				"Select what needs to be repaired or adjusted");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsRepairOrAdjustExternalWoodenDoorsNegativeTest6() throws Exception {

		underTest.fillInPage1ForJobDetailsForRepairOrAdjustExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), null, 3,
				null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[2]/div[4]/label")).getText(),
				"Select what needs to be repaired or adjusted");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsRepairOrAdjustExternalWoodenDoorsNegativeTest7() throws Exception {

		String[] doorPartsToRepair = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_HINGES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_HANDLES"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_PAINT") };

		underTest.fillInPage1ForJobDetailsForRepairOrAdjustExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_GLAZED"), 3, doorPartsToRepair);

		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), "Select the appropriate status of the job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div/label")).getText(), "Select your ownership status");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsRepairOrAdjustExternalWoodenDoorsNegativeTest8() throws Exception {

		String[] doorPartsToRepair = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_HINGES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_HANDLES"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_PAINT") };

		underTest.fillInPage1ForJobDetailsForRepairOrAdjustExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_GLAZED"), 3, doorPartsToRepair);

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsRepairOrAdjustExternalWoodenDoorsNegativeTest9() throws Exception {

		String[] doorPartsToRepair = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_HINGES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_HANDLES"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOR_PAINT") };

		underTest.fillInPage1ForJobDetailsForRepairOrAdjustExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), null, 3,
				doorPartsToRepair);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsRepairOrAdjustExternalWoodenDoorsNegativeTest10() throws Exception {

		String[] doorPartsToRepair = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_DOOROTHER") };

		underTest.fillInPage1ForJobDetailsForRepairOrAdjustExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPAIR_OTHER"), 3, doorPartsToRepair);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[1]/div[2]/ul/li[3]/div/label[2]")).getText(),
				"List what needs to be repaired or adjusted");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[2]/div[3]/ul/li[8]/div/label")).getText(),
				"List what needs to be repaired or adjusted");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest() throws Exception {

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), null,
				3, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[2]/div/div/label")).getText(), "Select who will supply the door(s)");

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[3]/div/div/label")).getText(), "Select who will supply the fittings");

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest1() throws Exception {

		String[] whatElseToInclude = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOROTHER") };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_OTHER"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_DOORS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_FITTINGS_NO"), whatElseToInclude);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[1]/div[2]/ul/li[3]/div/label[2]")).getText(),
				"List the doors you need replaced/installed");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[4]/div[2]/ul/li[6]/div/label")).getText(), "List what else you need");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest2() throws Exception {

		String[] whatElseToInclude = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_BRICKWORK"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_GLASS") };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), null,
				3, ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_DOORS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_FITTINGS_NO"), whatElseToInclude);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest3() throws Exception {

		String[] whatElseToInclude = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_BRICKWORK"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_GLASS") };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_BIFOLD"), 3, null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_FITTINGS_NO"), whatElseToInclude);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[2]/div/div/label")).getText(), "Select who will supply the door(s)");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest4() throws Exception {

		String[] whatElseToInclude = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_BRICKWORK"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_GLASS") };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_BIFOLD"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_DOORS_YES"), null, whatElseToInclude);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[3]/div/div/label")).getText(), "Select who will supply the fittings");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest5() throws Exception {

		String[] whatElseToInclude = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_BRICKWORK"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_GLASS") };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_BIFOLD"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_DOORS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_FITTINGS_NO"), whatElseToInclude);

		underTest.fillInPage2ForAdditionalInfo(null, ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest6() throws Exception {

		String[] whatElseToInclude = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_BRICKWORK"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_GLASS") };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_BIFOLD"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_DOORS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_FITTINGS_NO"), whatElseToInclude);

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"), null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), "Select the appropriate status of the job");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest7() throws Exception {

		String[] whatElseToInclude = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_BRICKWORK"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_GLASS") };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_BIFOLD"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_DOORS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_FITTINGS_NO"), whatElseToInclude);

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"), ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE),
				DESCRIPTION_LENGTH_30, ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div/label")).getText(), "Select your ownership status");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest8() throws Exception {

		String[] whatElseToInclude = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_BRICKWORK"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_GLASS") };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_BIFOLD"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_DOORS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_FITTINGS_NO"), whatElseToInclude);

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest9() throws Exception {

		String[] whatElseToInclude = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_BRICKWORK"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_GLASS") };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_BIFOLD"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_DOORS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_FITTINGS_NO"), whatElseToInclude);

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				null, DESCRIPTION_LENGTH_30, ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest10() throws Exception {

		String[] whatElseToInclude = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_BRICKWORK"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_GLASS") };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_BIFOLD"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_DOORS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_FITTINGS_NO"), whatElseToInclude);

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest11() throws Exception {

		String[] whatElseToInclude = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_BRICKWORK"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_GLASS") };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_BIFOLD"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_DOORS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_FITTINGS_NO"), whatElseToInclude);

		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), "Select the appropriate status of the job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div/label")).getText(), "Select your ownership status");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest12() throws Exception {

		String[] whatElseToInclude = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_BRICKWORK"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_GLASS") };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_BIFOLD"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_DOORS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_FITTINGS_NO"), whatElseToInclude);

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest13() throws Exception {

		String[] whatElseToInclude = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_BRICKWORK"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_GLASS") };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_BIFOLD"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_DOORS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_FITTINGS_NO"), whatElseToInclude);

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest14() throws Exception {

		String[] whatElseToInclude = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_BRICKWORK"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_GLASS") };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_BIFOLD"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_DOORS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_FITTINGS_NO"), whatElseToInclude);

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		String lastName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = ExternalWoodenDoorsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = ExternalWoodenDoorsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, lastName, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest15() throws Exception {

		String[] whatElseToInclude = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_BRICKWORK"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_GLASS") };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_BIFOLD"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_DOORS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_FITTINGS_NO"), whatElseToInclude);

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		String firstName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("FIRST_NAME");
		String phoneNumber = ExternalWoodenDoorsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = ExternalWoodenDoorsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest16() throws Exception {

		String[] whatElseToInclude = { ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_BRICKWORK"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_DOOR_GLASS") };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_BIFOLD"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_DOORS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_FITTINGS_NO"), whatElseToInclude);

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		String firstName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("FIRST_NAME");
		String lastName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("LAST_NAME");
		String emailAddress = ExternalWoodenDoorsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest17() throws Exception {

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_BIFOLD"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_DOORS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_SUPPLY_FITTINGS_NO"), null);

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		String firstName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("FIRST_NAME");
		String lastName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = ExternalWoodenDoorsXpathLocators.xpathLookup.get("PHONE_NUMBER");

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, phoneNumber, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_LETTERBOXES"), 3, null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descFittings']/div[2]/div/div/label")).getText(), "Select who will supply the fittings");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest2() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"), null, 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descFittings']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest3() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"), null, 3, null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descFittings']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descFittings']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest4() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_OTHER"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descFittings']/div[1]/div[2]/ul/li[5]/div/label[2]")).getText(),
				"List what needs to replaced/installed");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest5() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_LETTERBOXES"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), "Select the appropriate status of the job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div/label")).getText(), "Select your ownership status");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest6() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_LETTERBOXES"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(null, ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest7() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_LETTERBOXES"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PROPERTY_STYLE"), null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), "Select the appropriate status of the job");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest8() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_LETTERBOXES"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"), ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE),
				DESCRIPTION_LENGTH_30, ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div/label")).getText(), "Select your ownership status");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest9() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_LETTERBOXES"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest10() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_LETTERBOXES"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				null, DESCRIPTION_LENGTH_30, ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest11() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_LETTERBOXES"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest12() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_LETTERBOXES"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), "Select the appropriate status of the job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div/label")).getText(), "Select your ownership status");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest13() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_LETTERBOXES"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest14() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_LETTERBOXES"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest15() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_LETTERBOXES"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		String lastName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = ExternalWoodenDoorsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = ExternalWoodenDoorsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, lastName, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest16() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_LETTERBOXES"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		String firstName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("FIRST_NAME");
		String phoneNumber = ExternalWoodenDoorsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = ExternalWoodenDoorsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest17() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_LETTERBOXES"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		String firstName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("FIRST_NAME");
		String lastName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("LAST_NAME");
		String emailAddress = ExternalWoodenDoorsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest18() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_LETTERBOXES"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("FITTINGS_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		String firstName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("FIRST_NAME");
		String lastName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = ExternalWoodenDoorsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, phoneNumber, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"), null, 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descSecurity']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest2() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_BOLTS"), 3, null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descSecurity']/div[2]/div/div/label")).getText(), "Select who will supply the fittings");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest3() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"), null, 3, null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descSecurity']/div[2]/div/div/label")).getText(), "Select who will supply the fittings");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descSecurity']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest4() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_OTHER"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descSecurity']/div[1]/div[2]/ul/li[3]/div/label[2]")).getText(),
				"List what needs to replaced/installed");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest5() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_BOLTS"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), "Select the appropriate status of the job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div/label")).getText(), "Select your ownership status");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest6() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_BOLTS"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(null, ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest7() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_BOLTS"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PROPERTY_STYLE"), null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), "Select the appropriate status of the job");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest8() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_BOLTS"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"), ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE),
				DESCRIPTION_LENGTH_30, ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div/label")).getText(), "Select your ownership status");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest9() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_BOLTS"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest10() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_BOLTS"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				null, DESCRIPTION_LENGTH_30, ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest11() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_BOLTS"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest12() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_BOLTS"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest13() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_BOLTS"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		String lastName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = ExternalWoodenDoorsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = ExternalWoodenDoorsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, lastName, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest14() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_BOLTS"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		String firstName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("FIRST_NAME");
		String phoneNumber = ExternalWoodenDoorsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = ExternalWoodenDoorsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest15() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_BOLTS"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		String firstName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("FIRST_NAME");
		String lastName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("LAST_NAME");
		String emailAddress = ExternalWoodenDoorsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest16() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_BOLTS"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		String firstName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("FIRST_NAME");
		String lastName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = ExternalWoodenDoorsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, phoneNumber, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest17() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_BOLTS"), 3,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_SUPPLY_FITTINGS_YES"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PAGE1_NEXT_BUTTON_XPATH"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SECURITY_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReconfigurationSomethingElseTest() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(null, ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReconfigurationSomethingElseTest2() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"), null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), "Select the appropriate status of the job");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReconfigurationSomethingElseTest3() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"), ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE),
				DESCRIPTION_LENGTH_30, ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div/label")).getText(), "Select your ownership status");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReconfigurationSomethingElseTest4() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), null,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReconfigurationSomethingElseTest5() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				null, DESCRIPTION_LENGTH_30, ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReconfigurationSomethingElseTest6() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReconfigurationSomethingElseTest7() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), "Select the appropriate status of the job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div/label")).getText(), "Select your ownership status");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReconfigurationSomethingElseTest8() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[2]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReconfigurationSomethingElseTest9() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		String lastName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = ExternalWoodenDoorsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = ExternalWoodenDoorsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, lastName, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReconfigurationSomethingElseTest10() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		String firstName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("FIRST_NAME");
		String phoneNumber = ExternalWoodenDoorsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = ExternalWoodenDoorsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReconfigurationSomethingElseTest11() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		String firstName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("FIRST_NAME");
		String lastName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("LAST_NAME");
		String emailAddress = ExternalWoodenDoorsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReconfigurationSomethingElseTest12() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		String firstName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("FIRST_NAME");
		String lastName = ExternalWoodenDoorsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = ExternalWoodenDoorsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, phoneNumber, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReconfigurationSomethingElseTest13() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(ExternalWoodenDoorsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), ExternalWoodenDoorsXpathLocators.xpathLookup.get("URGENTLY"),
				ExternalWoodenDoorsXpathLocators.xpathLookup.get(POSTCODE), DESCRIPTION_LENGTH_30,
				ExternalWoodenDoorsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(ExternalWoodenDoorsXpathLocators.xpathLookup.get("BUDGET_LT_1000"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}
}
