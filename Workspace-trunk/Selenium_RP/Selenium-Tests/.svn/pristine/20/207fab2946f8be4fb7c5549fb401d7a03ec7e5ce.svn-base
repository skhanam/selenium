package uk.co.ratedpeople.test.functional.selenium.newjobforms.chimney;

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
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.chimney.ChimneyLocators;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.chimney.PostingJobViaChimneyJobForms;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

public class PostJobChimneyrepairStackNegativetest extends TestScript {

	private PostingJobViaChimneyJobForms underTest;
	private static final String[] CHIMNEY_STACK = { ".//*[@id='repairStackCowl']", ".//*[@id='repairStackPot']", ".//*[@id='repairStackStack']",
			".//*[@id='repairStackFlashing']", ".//*[@id='repairStackFlaunching']", ".//*[@id='repairStackStack']" };
	private static final String HEIGHT = "1401";
	private static final String JOB_STATUS_ID = "statusREADY_TO_HIRE']";
	private static final String OWNERSHIP_STATUS_ID = "ownerLANDLORD";
	private static final String TIMING = "URGENTLY";
	private static final String POSTCODE = "SW1E6AU";
	private static final String BUDGET = "97_LT_100";
	private static final String FIRSTNAME = "Andy";
	private static final String PHONE_NUMBER = "01234567890";
	private static final String EMAIL = "a@mail.com";

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaChimneyJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotesChimney();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void testrepairchimnystack() throws Exception {

		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_REPAIR_CHIMNEY"));

		context.driver.findElement(By.xpath("//*[@id='nextDescRepairStack']")).click();

		underTest.fillInStage2RepairChimneyStack(ChimneyLocators.xpathLookup.get("PLUS_ICON"), null, null, "");
		assertEquals(context.driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("ChimneyStkpart"))).getText(),
				ChimneyLocators.xpathLookup.get("ChimneyStkpartvalidation"));
		assertEquals(context.driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("Chimneyhighest"))).getText(),
				ChimneyLocators.xpathLookup.get("Chimneyhighestvalidation"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void testrepairchimnystackforother() throws Exception {

		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_REPAIR_CHIMNEY"));
		context.driver.findElement(By.xpath("//*[@id='repairStackOther']")).click();
		context.driver.findElement(By.xpath("//*[@id='nextDescRepairStack']")).click();
		assertEquals(context.driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("Chimneystkpartother"))).getText(),
				ChimneyLocators.xpathLookup.get("Chimneystkpartothervalidation"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void TestRepairChimneystackStage2additionaldetails() throws Exception {
		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_REPAIR_CHIMNEY"));
		underTest.fillInStage2RepairChimneyStack(ChimneyLocators.xpathLookup.get("PLUS_ICON"), CHIMNEY_STACK, null, HEIGHT);
		context.driver.findElement(By.xpath("//*[@id='next']")).click();
		assertEquals(context.driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("statusofthejob"))).getText(),
				ChimneyLocators.xpathLookup.get("statusofthejobvalidation"));
		assertEquals(context.driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("ownershipstatus"))).getText(),
				ChimneyLocators.xpathLookup.get("ownershipstatusvalidation"));
		assertEquals(context.driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("styleoftheproperty"))).getText(),
				ChimneyLocators.xpathLookup.get("styleofthepropertyjobvalidation"));
		assertEquals(context.driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("jobtostart"))).getText(),
				ChimneyLocators.xpathLookup.get("jobstartvalidation"));
		assertEquals(context.driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("enterpostcode"))).getText(),
				ChimneyLocators.xpathLookup.get("enterpostcodevalidation"));
		assertEquals(context.driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("enteradditionaldetails"))).getText(),
				ChimneyLocators.xpathLookup.get("enteraditionaldetalsvalidation"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void TestRepairChimneystackStage3budget() throws Exception {
		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_REPAIR_CHIMNEY"));
		underTest.fillInStage2RepairChimneyStack(ChimneyLocators.xpathLookup.get("PLUS_ICON"), CHIMNEY_STACK, null, HEIGHT);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1405", POSTCODE, TestScriptUtilities.getRandomString(10));
		context.driver.findElement(By.xpath("//*[@id='next']")).click();
		assertEquals(context.driver.findElement(By.xpath("//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void testRepairChimneystackStage4contact() throws Exception {

		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_REPAIR_CHIMNEY"));

		underTest.fillInStage2RepairChimneyStack(ChimneyLocators.xpathLookup.get("PLUS_ICON"), CHIMNEY_STACK, null, HEIGHT);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1405", POSTCODE, TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(BUDGET);
		context.driver.findElement(By.xpath("//*[@id='btnPostJob']")).click();
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testrebuildchimnystack() throws Exception {

		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_REBUILD_CHIMNEY"));

		context.driver.findElement(By.xpath("//*[@id='descRebuildStack']/div[4]/button[2]")).click();

		assertEquals(context.driver.findElement(By.xpath("//*[@id='descRebuildStack']/div[1]/div/label")).getText(), "Select the job you need to have done");

		assertEquals(context.driver.findElement(By.xpath("//*[@id='descRebuildStack']/div[2]/div/div/div/label")).getText(),
				"Select the number of chimney stacks");
		assertEquals(context.driver.findElement(By.xpath("//*[@id='replaceSection']/div/label")).getText(), "Select how high up the work needs to be done");

		context.driver.findElement(By.xpath("//*[@id='rebuildStackRequirementRebuild']")).click();
		context.driver.findElement(By.xpath("//*[@id='descRebuildStack']/div[2]/div/ul/li/a[2]")).click();
		context.driver.findElement(By.xpath("//*[@id='descRebuildStack']/div[3]/select[@id='repairStackHeight']")).sendKeys("3 storey");

		context.driver.findElement(By.xpath("//*[@id='descRebuildStack']/div[4]/button[2]")).click();

		assertEquals(context.driver.findElement(By.xpath("//*[@id='stage2']/div[1]/p")).getText(), "What is the appropriate status for this job?");

		underTest.fillInStage3(JOB_STATUS_ID, null, TIMING, "1420", POSTCODE, TestScriptUtilities.getRandomString(10));
		context.driver.findElement(By.xpath("//*[@id='next']")).click();
		assertEquals(context.driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("ownershipstatus"))).getText(),
				ChimneyLocators.xpathLookup.get("ownershipstatusvalidation"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testrebuildchimnystack3() throws Exception {

		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_REBUILD_CHIMNEY"));

		// stage1
		context.driver.findElement(By.xpath("//*[@id='rebuildStackRequirementRebuild']")).click();
		context.driver.findElement(By.xpath("//*[@id='descRebuildStack']/div[2]/div/ul/li/a[2]")).click();
		context.driver.findElement(By.xpath("//*[@id='descRebuildStack']/div[3]/select[@id='repairStackHeight']")).sendKeys("3 storey");
		context.driver.findElement(By.xpath("//*[@id='descRebuildStack']/div[4]/button[2]")).click();
		// stage2
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1420", POSTCODE, TestScriptUtilities.getRandomString(10));

		// stage3
		underTest.fillInStage4(BUDGET);
		// stage4
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(underTest.getScriptUtils(), context, FIRSTNAME, null, PHONE_NUMBER, PHONE_NUMBER, EMAIL, EMAIL);

		assertEquals(context.driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("Last_Name"))).getText(),
				ChimneyLocators.xpathLookup.get("Last_namevalidation"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaRepairChimneyBreastTest1() throws Exception {

		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_CHIMNEY_BREAST"));

		underTest.fillInStage3("statusINSURANCE_CLAIM", "ownerLOOKING_TO_BUY", "LT_2_DAYS", null, "RP99RP", TestScriptUtilities.getRandomString(30));

		assertEquals(context.driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("styleoftheproperty"))).getText(),
				ChimneyLocators.xpathLookup.get("styleofthepropertyjobvalidation"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaRepairChimneyBreastTest2() throws Exception {

		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_CHIMNEY_BREAST"));
		underTest.fillInStage3("statusINSURANCE_CLAIM", "ownerLOOKING_TO_BUY", "LT_2_DAYS", "1425", "RP99RP", TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[2]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaRepairChimneyBreastTest3() throws Exception {

		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_CHIMNEY_BREAST"));
		underTest.fillInStage3("statusINSURANCE_CLAIM", "ownerLOOKING_TO_BUY", "LT_2_DAYS", "1425", "RP99RP", TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(BUDGET);
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(underTest.getScriptUtils(), context, "ara", null, "07427538666", "07427538666", "aravind87in@gmail.com", "aravind87in@gmail.com");

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaRemoveChimneyBreastTest1() throws Exception {
		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_REMOVE_CHIMNEY"));
		underTest.fillInStage2RemoveChimneyBreast("removeBreastBasement", null, "1443");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='replaceSection']/div/label")).getText(), "Select how high up the work needs to be done");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaRemoveChimneyBreastTest2() throws Exception {
		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_REMOVE_CHIMNEY"));
		underTest.fillInStage2RemoveChimneyBreast("removeBreastBasement", "1440", "1443");
		underTest.fillInStage3("statusPLANNING_BUDGETING", "ownerLANDLORD", null, "1449", "RP99RP", TestScriptUtilities.getRandomString(30));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaRemoveChimneyBreastTest3() throws Exception {
		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_REMOVE_CHIMNEY"));
		underTest.fillInStage2RemoveChimneyBreast("removeBreastBasement", "1440", "1443");
		underTest.fillInStage3("statusPLANNING_BUDGETING", "ownerLANDLORD", "LT_2_MONTHS", "1449", "RP99RP", TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaRemoveChimneyBreastTest4() throws Exception {
		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_REMOVE_CHIMNEY"));
		underTest.fillInStage2RemoveChimneyBreast("removeBreastBasement", "1440", "1443");
		underTest.fillInStage3("statusPLANNING_BUDGETING", "ownerLANDLORD", "LT_2_MONTHS", "1449", "RP99RP", TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4("97_LT_3000");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(underTest.getScriptUtils(), context, "ara", null, "07427538666", "07427538666", "aravind87in@gmail.com", "aravind87in@gmail.com");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaSomethingElseTest() throws Exception {
		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_SOMETHING"));
		underTest.fillInStage3("statusPLANNING_BUDGETING", "ownerLANDLORD", "LT_2_MONTHS", "1454", null, TestScriptUtilities.getRandomString(30));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaSomethingElseTest1() throws Exception {
		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_SOMETHING"));
		underTest.fillInStage3("statusPLANNING_BUDGETING", "ownerLANDLORD", "LT_2_MONTHS", "1454", "RP99RP", TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[2]/label")).getText(), "Select an approximate budget");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaSomethingElseTest2() throws Exception {
		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_SOMETHING"));
		underTest.fillInStage3("statusPLANNING_BUDGETING", "ownerLANDLORD", "LT_2_MONTHS", "1454", "RP99RP", TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4("97_LT_15000");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(underTest.getScriptUtils(), context, null, "arav", "07427538666", "07427538666", "aravind87in@gmail.com", "aravind87in@gmail.com");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaSomethingElseTestWithConfirmNumberDifferent() throws Exception {
		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_SOMETHING"));
		underTest.fillInStage3("statusPLANNING_BUDGETING", "ownerLANDLORD", "LT_2_MONTHS", "1454", "RP99RP", TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4("97_LT_15000");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(underTest.getScriptUtils(), context, "ara", "arav", "07427538666", "07427538667", "aravind87in@gmail.com", "aravind87in@gmail.com");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "The phone numbers entered do not match");
	}
	
	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaSomethingElseTestWithConfirmEmailDifferent() throws Exception {
		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_SOMETHING"));
		underTest.fillInStage3("statusPLANNING_BUDGETING", "ownerLANDLORD", "LT_2_MONTHS", "1454", "RP99RP", TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4("97_LT_15000");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(underTest.getScriptUtils(), context, "ara", "arav", "07427538666", "07427538666", "aravind87in@gmail.com", "aravind87out@gmail.com");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "The email addresses entered do not match");
	}
}
