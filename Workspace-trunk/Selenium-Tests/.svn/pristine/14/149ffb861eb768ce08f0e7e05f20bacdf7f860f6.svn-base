package uk.co.ratedpeople.test.functional.selenium.newjobforms.internalwoodendoor;

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

public class PostingJobViaInternalWoodenDoorsJobFormsNegativeTest extends TestScript {

	private static final int DESCRIPTION_LENGTH_30 = 30;

	private PostingJobViaInternalWoodenDoorJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaInternalWoodenDoorJobForms(context, scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest() throws Exception {

		underTest.jobDetailsPage("radioRepair");
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[2]/div[4]/label")).getText(),
				"Select what needs to be repaired or adjusted");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest1() throws Exception {

		underTest.jobDetailsPage("radioRepair");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PANEL_DOORS"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[2]/div[4]/label")).getText(),
				"Select what needs to be repaired or adjusted");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest2() throws Exception {

		underTest.jobDetailsPage("radioRepair");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRDOOR_ARCHITRAVE"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest3() throws Exception {

		underTest.jobDetailsPage("radioRepair");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("NEEDS_OTHER"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIR_DOORS_OTHER"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[1]/div[2]/ul/li[3]/div/label[2]")).getText(),
				"List what needs to be repaired or adjusted");

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[2]/div[3]/ul/li[5]/div/label")).getText(),
				"List what needs to be repaired or adjusted");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest4() throws Exception {

		underTest.jobDetailsPage("radioRepair");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PANEL_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRDOOR_ARCHITRAVE"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PROPERTY_ERRORMSGXPATH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("PROPERTY_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("APPROPRIATE_STATUS_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("APPROPRIATE_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("TIMIMG_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest5() throws Exception {

		underTest.jobDetailsPage("radioRepair");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PANEL_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRDOOR_ARCHITRAVE"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(null, InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PROPERTY_ERRORMSGXPATH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("PROPERTY_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest6() throws Exception {

		underTest.jobDetailsPage("radioRepair");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PANEL_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRDOOR_ARCHITRAVE"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"), null,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("APPROPRIATE_STATUS_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("APPROPRIATE_STATUS_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest7() throws Exception {

		underTest.jobDetailsPage("radioRepair");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PANEL_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRDOOR_ARCHITRAVE"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), null,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"), InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"),
				DESCRIPTION_LENGTH_30, InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest8() throws Exception {

		underTest.jobDetailsPage("radioRepair");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PANEL_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRDOOR_ARCHITRAVE"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), null,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("TIMIMG_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest9() throws Exception {

		underTest.jobDetailsPage("radioRepair");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PANEL_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRDOOR_ARCHITRAVE"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				null, DESCRIPTION_LENGTH_30, InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest10() throws Exception {

		underTest.jobDetailsPage("radioRepair");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PANEL_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRDOOR_ARCHITRAVE"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest11() throws Exception {

		underTest.jobDetailsPage("radioRepair");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PANEL_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRDOOR_ARCHITRAVE"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest12() throws Exception {

		underTest.jobDetailsPage("radioRepair");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PANEL_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRDOOR_ARCHITRAVE"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest13() throws Exception {

		underTest.jobDetailsPage("radioRepair");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PANEL_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRDOOR_ARCHITRAVE"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, InternalWoodenDoorsXpathlocators.dataLookup.get("lname"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"), InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("email"), InternalWoodenDoorsXpathlocators.dataLookup.get("email"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest14() throws Exception {

		underTest.jobDetailsPage("radioRepair");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PANEL_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRDOOR_ARCHITRAVE"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, InternalWoodenDoorsXpathlocators.dataLookup.get("fname"), null,
				InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"), InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("email"), InternalWoodenDoorsXpathlocators.dataLookup.get("email"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest15() throws Exception {

		underTest.jobDetailsPage("radioRepair");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PANEL_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRDOOR_ARCHITRAVE"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, InternalWoodenDoorsXpathlocators.dataLookup.get("fname"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("lname"), null, null, InternalWoodenDoorsXpathlocators.dataLookup.get("email"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("email"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorRepairNegativeTest16() throws Exception {

		underTest.jobDetailsPage("radioRepair");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PANEL_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRDOOR_ARCHITRAVE"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("repairstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, InternalWoodenDoorsXpathlocators.dataLookup.get("fname"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("lname"), InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"), null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[2]/div/div/label")).getText(), "Select who will supply the door(s)");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[3]/div/div/label")).getText(), "Select who will supply the fittings");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest1() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SLIDING_DOORS"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[2]/div/div/label")).getText(), "Select who will supply the door(s)");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[3]/div/div/label")).getText(), "Select who will supply the fittings");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest2() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SLIDING_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGDOORS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[3]/div/div/label")).getText(), "Select who will supply the fittings");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest3() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SLIDING_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGDOORS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGFITTINGS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("WHATELSENEEDED_OTHER"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[4]/div[2]/ul/li[5]/div/label")).getText(), "List what else you need");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest4() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("WHATDOORSNEED_OTHER"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGDOORS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGFITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[1]/div[2]/ul/li[3]/div/label[2]")).getText(),
				"List the doors you need replaced/installed");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest5() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SLIDING_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGDOORS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGFITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PROPERTY_ERRORMSGXPATH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("PROPERTY_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("APPROPRIATE_STATUS_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("APPROPRIATE_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("TIMIMG_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest6() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SLIDING_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGDOORS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGFITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(null, InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PROPERTY_ERRORMSGXPATH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("PROPERTY_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest7() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SLIDING_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGDOORS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGFITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPALCE_PROPERTY_STYLE"), null,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("APPROPRIATE_STATUS_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("APPROPRIATE_STATUS_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest8() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SLIDING_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGDOORS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGFITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPALCE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), null,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"), InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"),
				DESCRIPTION_LENGTH_30, InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest9() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SLIDING_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGDOORS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGFITTINGS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPALCE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), null,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("TIMIMG_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest10() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SLIDING_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGDOORS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGFITTINGS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPALCE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				null, DESCRIPTION_LENGTH_30, InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest11() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SLIDING_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGDOORS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGFITTINGS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPALCE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest12() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SLIDING_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGDOORS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGFITTINGS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPALCE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest13() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SLIDING_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGDOORS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGFITTINGS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPALCE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest14() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SLIDING_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGDOORS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGFITTINGS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPALCE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, InternalWoodenDoorsXpathlocators.dataLookup.get("lname"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"), InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("email"), InternalWoodenDoorsXpathlocators.dataLookup.get("email"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest15() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SLIDING_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGDOORS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGFITTINGS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPALCE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, InternalWoodenDoorsXpathlocators.dataLookup.get("fname"), null,
				InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"), InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("email"), InternalWoodenDoorsXpathlocators.dataLookup.get("email"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest16() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SLIDING_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGDOORS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGFITTINGS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPALCE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, InternalWoodenDoorsXpathlocators.dataLookup.get("fname"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("lname"), null, null, InternalWoodenDoorsXpathlocators.dataLookup.get("email"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("email"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallWoodenDoorsNegativeTest17() throws Exception {

		underTest.jobDetailsPage("radioReplace");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SLIDING_DOORS"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGDOORS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("SUPPLYINGFITTINGS_YES"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacestagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPALCE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, InternalWoodenDoorsXpathlocators.dataLookup.get("fname"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("lname"), InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"), null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallFittingsNegativeTest() throws Exception {

		underTest.jobDetailsPage("radioFittings");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext"))).click();

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descFittings']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descFittings']/div[2]/div/div/label")).getText(), "Select who will supply the fittings");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallFittingsNegativeTest1() throws Exception {

		underTest.jobDetailsPage("radioFittings");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ARCHITRAVE_SKIRTING"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext"))).click();

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descFittings']/div[2]/div/div/label")).getText(), "Select who will supply the fittings");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallFittingsNegativeTest2() throws Exception {

		underTest.jobDetailsPage("radioFittings");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("FITTINGS_NEEDEDOTHER"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("FITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext"))).click();

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descFittings']/div[1]/div[2]/ul/li[3]/div/label[2]")).getText(),
				"List the doors you need replaced/installed");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallFittingsNegativeTest3() throws Exception {

		underTest.jobDetailsPage("radioFittings");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ARCHITRAVE_SKIRTING"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("FITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PROPERTY_ERRORMSGXPATH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("PROPERTY_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("APPROPRIATE_STATUS_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("APPROPRIATE_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("TIMIMG_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallFittingsNegativeTest4() throws Exception {

		underTest.jobDetailsPage("radioFittings");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ARCHITRAVE_SKIRTING"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("FITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(null, InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PROPERTY_ERRORMSGXPATH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("PROPERTY_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallFittingsNegativeTest5() throws Exception {

		underTest.jobDetailsPage("radioFittings");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ARCHITRAVE_SKIRTING"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("FITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRFITTING_PROPERTY_STYLE"), null,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("APPROPRIATE_STATUS_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("APPROPRIATE_STATUS_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallFittingsNegativeTest6() throws Exception {

		underTest.jobDetailsPage("radioFittings");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ARCHITRAVE_SKIRTING"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("FITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRFITTING_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), null,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"), InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"),
				DESCRIPTION_LENGTH_30, InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallFittingsNegativeTest7() throws Exception {

		underTest.jobDetailsPage("radioFittings");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ARCHITRAVE_SKIRTING"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("FITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRFITTING_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), null,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("TIMIMG_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallFittingsNegativeTest8() throws Exception {

		underTest.jobDetailsPage("radioFittings");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ARCHITRAVE_SKIRTING"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("FITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRFITTING_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				null, DESCRIPTION_LENGTH_30, InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallFittingsNegativeTest9() throws Exception {

		underTest.jobDetailsPage("radioFittings");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ARCHITRAVE_SKIRTING"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("FITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext"))).click();

		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRFITTING_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallFittingsNegativeTest10() throws Exception {

		underTest.jobDetailsPage("radioFittings");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ARCHITRAVE_SKIRTING"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("FITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRFITTING_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallFittingsNegativeTest11() throws Exception {

		underTest.jobDetailsPage("radioFittings");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ARCHITRAVE_SKIRTING"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("FITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRFITTING_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallFittingsNegativeTest12() throws Exception {

		underTest.jobDetailsPage("radioFittings");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ARCHITRAVE_SKIRTING"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("FITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRFITTING_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, InternalWoodenDoorsXpathlocators.dataLookup.get("lname"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"), InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("email"), InternalWoodenDoorsXpathlocators.dataLookup.get("email"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallFittingsNegativeTest13() throws Exception {

		underTest.jobDetailsPage("radioFittings");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ARCHITRAVE_SKIRTING"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("FITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRFITTING_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, InternalWoodenDoorsXpathlocators.dataLookup.get("fname"), null,
				InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"), InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("email"), InternalWoodenDoorsXpathlocators.dataLookup.get("email"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallFittingsNegativeTest14() throws Exception {

		underTest.jobDetailsPage("radioFittings");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ARCHITRAVE_SKIRTING"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("FITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRFITTING_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, InternalWoodenDoorsXpathlocators.dataLookup.get("fname"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("lname"), null, null, InternalWoodenDoorsXpathlocators.dataLookup.get("email"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("email"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorReplaceAndInstallFittingsNegativeTest15() throws Exception {

		underTest.jobDetailsPage("radioFittings");

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ARCHITRAVE_SKIRTING"))).click();
		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("FITTINGS_YES"))).click();

		context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("replacefitstagetwonext"))).click();
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("REPAIRFITTING_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, InternalWoodenDoorsXpathlocators.dataLookup.get("fname"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("lname"), InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"), null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorSomethingElseNegativeTest() throws Exception {

		underTest.jobDetailsPage("radioElse");

		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PROPERTY_ERRORMSGXPATH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("PROPERTY_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("APPROPRIATE_STATUS_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("APPROPRIATE_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("TIMIMG_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorSomethingElseNegativeTest1() throws Exception {

		underTest.jobDetailsPage("radioElse");
		underTest.fillInPage2ForAdditionalInfo(null, InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("PROPERTY_ERRORMSGXPATH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("PROPERTY_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorSomethingElseNegativeTest2() throws Exception {

		underTest.jobDetailsPage("radioElse");

		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("SOMETHINGELSE_PROPERTY_STYLE"), null,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("APPROPRIATE_STATUS_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("APPROPRIATE_STATUS_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorSomethingElseNegativeTest3() throws Exception {

		underTest.jobDetailsPage("radioElse");

		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("SOMETHINGELSE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), null,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"), InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"),
				DESCRIPTION_LENGTH_30, InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorSomethingElseNegativeTest4() throws Exception {

		underTest.jobDetailsPage("radioElse");
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("SOMETHINGELSE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), null,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("TIMIMG_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorSomethingElseNegativeTest5() throws Exception {

		underTest.jobDetailsPage("radioElse");

		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("SOMETHINGELSE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				null, DESCRIPTION_LENGTH_30, InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE_ERRORMSGTEXT"));

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaInternalWoodenDoorSomethingElseNegativeTest6() throws Exception {

		underTest.jobDetailsPage("radioElse");
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("SOMETHINGELSE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_ERRORMSGXAPTH"))).getText(),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorSomethingElseNegativeTest7() throws Exception {

		underTest.jobDetailsPage("radioElse");
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("SOMETHINGELSE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[2]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorSomethingElseNegativeTest8() throws Exception {

		underTest.jobDetailsPage("radioElse");
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("SOMETHINGELSE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorSomethingElseNegativeTest9() throws Exception {

		underTest.jobDetailsPage("radioElse");
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("SOMETHINGELSE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, InternalWoodenDoorsXpathlocators.dataLookup.get("lname"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"), InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("email"), InternalWoodenDoorsXpathlocators.dataLookup.get("email"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaInternalWoodenDoorSomethingElseNegativeTest10() throws Exception {

		underTest.jobDetailsPage("radioElse");
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("SOMETHINGELSE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, InternalWoodenDoorsXpathlocators.dataLookup.get("fname"), null,
				InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"), InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("email"), InternalWoodenDoorsXpathlocators.dataLookup.get("email"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaInternalWoodenDoorSomethingElseNegativeTest11() throws Exception {

		underTest.jobDetailsPage("radioElse");
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("SOMETHINGELSE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, InternalWoodenDoorsXpathlocators.dataLookup.get("fname"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("lname"), null, null, InternalWoodenDoorsXpathlocators.dataLookup.get("email"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("email"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaInternalWoodenDoorSomethingElseNegativeTest12() throws Exception {

		underTest.jobDetailsPage("radioElse");
		underTest.fillInPage2ForAdditionalInfo(InternalWoodenDoorsXpathlocators.xpathLookup.get("SOMETHINGELSE_PROPERTY_STYLE"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), InternalWoodenDoorsXpathlocators.xpathLookup.get("URGENTLY"),
				InternalWoodenDoorsXpathlocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				InternalWoodenDoorsXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(InternalWoodenDoorsXpathlocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, InternalWoodenDoorsXpathlocators.dataLookup.get("fname"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("lname"), InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"),
				InternalWoodenDoorsXpathlocators.dataLookup.get("mobile"), null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}
}
