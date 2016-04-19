package uk.co.ratedpeople.test.functional.selenium.newjobforms.tiling;

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

/**
 * @author ankitkumar.rana
 * 
 */

public class PostingJobViaTilingJobFormsTest extends TestScript {

	private static final String INSTALL = "radioInstall";
	private static final String REPAIR = "radioRepair";
	private static final String GROUT = "radioGrout";
	private static final String SOMETHING_ELSE = "radioElse";

	private static final String[] AREA_TO_INSTALL = { ".//*[@id='installAreaSmall']", ".//*[@id='installAreaLarge']" };
	private static final String[] INSTALL_XPATH_LIST = { ".//*[@id='descInstall']/div[1]/ul/li[1]/div[2]/div[1]/ul/li[1]/a[2]",
			".//*[@id='descInstall']/div[1]/ul/li[2]/div/div[1]/ul/li[2]/a[2]" };
	private static final String[] INSTALL_XPATH_LIST_OTHER = { ".//*[@id='descInstall']/div[1]/ul/li[1]/div[2]/div[1]/ul/li[1]/a[2]",
			".//*[@id='descInstall']/div[1]/ul/li[2]/div/div[1]/ul/li[2]/a[2]", ".//*[@id='descInstall']/div[1]/ul/li[1]/div[2]/div[1]/ul/li[4]/a[2]" };
	private static final String INSTALL_OTHER_XPATH = ".//*[@id='descInstall']/div[1]/ul/li[1]/div[2]/div[1]/ul/li[4]/div/textarea";
	private static final String REMOVE_EXISTING_TILE_INSTALL = "installTilesRemoveYes";
	private static final String[] TYPES_OF_TILES_XPATH_LIST_INSTALL = { ".//*[@id='installTileCeramic']" };
	private static final String[] TYPES_OF_TILES_XPATH_LIST_OTHER_INSTALL = { ".//*[@id='installTileCeramic']", ".//*[@id='installTileOther']" };
	private static final String TYPES_OF_TILES_OTHER_INSTALL = ".//*[@id='installTileOtherText']";
	private static final String SUPPLY_MATERIAL_INSTALL = "installSupplyTilesYes";

	private static final String[] WHAT_NEEDS_REPAIR_XPATH_LIST = { ".//*[@id='repairCeramic']", ".//*[@id='repairPorcelain']" };
	private static final String[] WHAT_NEEDS_REPAIR_OTHER_XPATH_LIST = { ".//*[@id='repairCeramic']", ".//*[@id='repairOther']" };
	private static final String WHAT_NEEDS_REPAIR_OTHER_XPATH = ".//*[@id='installSupplyOtherText']";
	private static final String SUPPLY_MATERIAL_REPAIR = "repairSupplyTilesYes";

	private static final String[] AREA_TO_GROUT = { ".//*[@id='groutAreaSmall']", ".//*[@id='groutAreaLarge']" };
	private static final String[] AREA_TO_GROUT_XPATH_LIST = { ".//*[@id='descGrout']/div[1]/ul/li[1]/div[2]/div[1]/ul/li[1]/a[2]",
			".//*[@id='descGrout']/div[1]/ul/li[2]/div/div[1]/ul/li[2]/a[2]" };
	private static final String[] AREA_TO_GROUT_OTHER_XPATH_LIST = { ".//*[@id='descGrout']/div[1]/ul/li[1]/div[2]/div[1]/ul/li[1]/a[2]",
			".//*[@id='descGrout']/div[1]/ul/li[1]/div[2]/div[1]/ul/li[4]/a[2]" };
	private static final String AREA_TO_GROUT_OTHER_XPATH = ".//*[@id='descGrout']/div[1]/ul/li[1]/div[2]/div[1]/ul/li[4]/div/textarea";
	private static final String SUPPLY_MATERIAL_GROUT = "groutRemoveYes";

	private static final String JOB_STATUS_ID = "statusREADY_TO_HIRE";
	private static final String OWNERSHIP_STATUS_ID = "ownerLANDLORD";
	private static final String TIMING = "URGENTLY";
	private static final String POSTCODE = "SW1E6AU";
	private static final String BUDGET = "71_LT_100";

	private static final String FIRSTNAME = "Andy";
	private static final String LASTNAME = "Green";
	private static final String PHONE_NUMBER = "01234567890";
	private static final String CONFIRM_PHONENUMBER = "01234567890";
	private static final String EMAIL = "a@mail.com";
	private static final String CONFIRM_EMAIL = "a@mail.com";

	private static final String THANK_YOU_HEADER_TEXT_ID = "header-h1";
	private static final String THANK_YOU = "Thank you";

	private static final String OTHER_TEXT = "This is other text";

	private PostingJobViaTilingJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaTilingJobForms(context.driver, context.getTestUrl(), scriptUtilities);

	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotesTiling();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallTest() throws Exception {

		underTest.fillInStage1(INSTALL);

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null, REMOVE_EXISTING_TILE_INSTALL, TYPES_OF_TILES_XPATH_LIST_INSTALL,
				null, null, SUPPLY_MATERIAL_INSTALL);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1295", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();
		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallOtherTest() throws Exception {

		underTest.fillInStage1(INSTALL);

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST_OTHER, INSTALL_OTHER_XPATH, OTHER_TEXT, REMOVE_EXISTING_TILE_INSTALL,
				TYPES_OF_TILES_XPATH_LIST_OTHER_INSTALL, TYPES_OF_TILES_OTHER_INSTALL, OTHER_TEXT, SUPPLY_MATERIAL_INSTALL);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1295", POSTCODE, TestScriptUtilities.getRandomString(10));
		fillInStage4();
		fillInStage5();
		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTest() throws Exception {

		underTest.fillInStage1(REPAIR);

		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_XPATH_LIST, null, null, SUPPLY_MATERIAL_REPAIR);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1307", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();
		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairOtherTest() throws Exception {

		underTest.fillInStage1(REPAIR);

		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_OTHER_XPATH_LIST, WHAT_NEEDS_REPAIR_OTHER_XPATH, OTHER_TEXT, SUPPLY_MATERIAL_REPAIR);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1307", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();
		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutTest() throws Exception {

		underTest.fillInStage1(GROUT);

		underTest.fillInGroutNewTileStage2(AREA_TO_GROUT, AREA_TO_GROUT_XPATH_LIST, null, null, SUPPLY_MATERIAL_GROUT);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1320", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();
		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutOtherTest() throws Exception {

		underTest.fillInStage1(GROUT);

		underTest.fillInGroutNewTileStage2(AREA_TO_GROUT, AREA_TO_GROUT_OTHER_XPATH_LIST, AREA_TO_GROUT_OTHER_XPATH, OTHER_TEXT, SUPPLY_MATERIAL_GROUT);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1320", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();
		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaTilingJobFormsSomethingElseTest() throws Exception {
		underTest.fillInStage1(SOMETHING_ELSE);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1326", POSTCODE, TestScriptUtilities.getRandomString(30));

		fillInStage4();
		fillInStage5();
		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaTilingJobFormsSomethingElseTestEditJob() throws Exception {
		underTest.fillInStage1(SOMETHING_ELSE);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1326", POSTCODE, TestScriptUtilities.getRandomString(30));

		fillInStage4();
		fillInStage5();
		}


	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaTilingJobFormsSomethingElseTestToCancelAndReturnHome() throws Exception {
		underTest.fillInStage1(SOMETHING_ELSE);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1326", POSTCODE, TestScriptUtilities.getRandomString(30));

		fillInStage4();
		JobFormSeleniumHelper.fillInContactPageDetailsAndCancelAndReturn(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, CONFIRM_PHONENUMBER,
				EMAIL, CONFIRM_EMAIL);
	}

	public void fillInStage4() {
		underTest.fillInStage4(BUDGET);
	}

	public void fillInStage5() {
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, CONFIRM_PHONENUMBER, EMAIL,
				CONFIRM_EMAIL);
	}
}
