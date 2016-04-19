package uk.co.ratedpeople.test.functional.selenium.newjobforms.fences;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.flooring.FlooringXpathLocators;

public class PostingJobViaFencesJobFormTest extends TestScript {

	private static final String FENCES = "radioFence";
	private static final String GARDEN_WALLS = "radioWall";
	private static final String GATES = "radioGate";
	private static final String SOMETHING_ELSE = "radioElse";

	private static final String FENCES_JOB_REQUIRMENT_INSTALL = "fenceReplace";
	private static final String FENCES_JOB_REQUIRMENT_REPAIR = "fenceRepair";
	private static final String GARDEN_WALLS_JOB_REQUIRMENT_INSTALL = "wallReplace";
	private static final String GARDEN_WALLS_JOB_REQUIRMENT_REPAIR = "wallRepair";
	private static final String GATES_JOB_REQUIRMENT_INSTALL = "gateReplace";
	private static final String GATES_JOB_REQUIRMENT_REPAIR = "gateRepair";

	private static final String FENCES_LENGTH_INSTALL_XPATH = ".//*[@id='fenceLengthReplace']";
	private static final String FENCES_LENGTH_REPAIR_XPATH = ".//*[@id='fenceLengthRepair']";
	private static final String GARDEN_WALLS_LENGTH_INSTALL_XPATH = ".//*[@id='wallLengthReplace']";
	private static final String GARDEN_WALLS_LENGTH_REPAIR_XPATH = ".//*[@id='wallLengthRepair']";

	private static final String[] FENCES_USE_OF_FENCES_INSTALL_XPATH_LIST = { ".//*[@id='fencePanelsReplace']", ".//*[@id='fenceScreeningReplace']" };
	private static final String[] FENCES_USE_OF_FENCES_INSTALL_XPATH_LIST_OTHER = { ".//*[@id='fencePanelsReplace']", ".//*[@id='fenceOtherReplace']" };
	private static final String[] FENCES_USE_OF_FENCES_REPAIR_XPATH_LIST = { ".//*[@id='fenceTrellisRepair']", ".//*[@id='fenceScreeningRepair']" };
	private static final String[] FENCES_USE_OF_FENCES_REPAIR_XPATH_LIST_OTHER = { ".//*[@id='fenceTrellisRepair']", ".//*[@id='fenceOtherRepair']" };
	private static final String[] GATES_TYPE_TO_INSTALL_XPATH_LIST = { ".//*[@id='descGate']/div[2]/div[1]/ul/li[1]/a[2]",
			".//*[@id='descGate']/div[2]/div[1]/ul/li[2]/a[2]" };
	private static final String[] GATES_TYPE_TO_INSTALL_XPATH_LIST_OTHER = { ".//*[@id='descGate']/div[2]/div[1]/ul/li[1]/a[2]",
			".//*[@id='descGate']/div[2]/div[1]/ul/li[3]/a[2]" };
	private static final String[] GATES_TYPE_TO_REPAIR_XPATH_LIST = { ".//*[@id='descGate']/div[3]/div[1]/ul/li[1]/a[2]",
			".//*[@id='descGate']/div[3]/div[1]/ul/li[2]/a[2]" };
	private static final String[] GATES_TYPE_TO_REPAIR_XPATH_LIST_OTHER = { ".//*[@id='descGate']/div[3]/div[1]/ul/li[1]/a[2]",
			".//*[@id='descGate']/div[3]/div[1]/ul/li[3]/a[2]" };

	private static final String FENCES_OTHER_INSTALL = "fenceOtherTextReplace";
	private static final String FENCES_OTHER_REPAIR = "fenceOtherTextRepair";
	private static final String GATES_OTHER_INSTALL = ".//*[@id='descGate']/div[2]/div[1]/ul/li[3]/div/textarea";
	private static final String GATES_OTHER_REPAIR = ".//*[@id='descGate']/div[3]/div[1]/ul/li[3]/div/textarea";

	private static final String FENCES_LENGTH_INSTALL = "1089";
	private static final String FENCES_LENGTH_REPAIR = "1110";
	private static final String GARDEN_WALL_LENGTH_INSTALL = "1125";
	private static final String GARDEN_WALL_LENGTH_REPAIR = "1135";

	private static final String FENCES_HEIGHT_INSTALL = "fenceHeightUnderReplace";
	private static final String FENCES_HEIGHT_REPAIR = "fenceHeightUnderRepair";
	private static final String GARDEN_WALL_HEIGHT_INSTALL = "wallHeightUnderReplace";
	private static final String GARDEN_WALL_HEIGHT_REPAIR = "wallHeightUnderRepair";

	private static final String FENCES_SUPPLY_MATERIAL = "fenceMaterialYes";
	private static final String GARDEN_WALL_SUPPLY_MATERIAL = "wallMaterialYes";
	private static final String GATES_SUPPLY_MATERIAL = "gateMaterialYes";

	private static final String FENCES_OTHER_TEXT = "This is other text";

	private static final String JOB_STATUS_ID = "statusREADY_TO_HIRE";
	private static final String OWNERSHIP_STATUS_ID = "ownerLANDLORD";
	private static final String TIMING = "URGENTLY";
	private static final String POSTCODE = "SW1E6AU";
	private static final String BUDGET = "83_LT_4000";

	private static final String FIRSTNAME = "Andy";
	private static final String LASTNAME = "Green";
	private static final String PHONE_NUMBER = "01234567890";
	private static final String EMAIL = "a@mail.com";

	private static final String THANK_YOU_HEADER_TEXT_ID = "header-h1";
	private static final String THANK_YOU = "Thank you";

	private static final String ErewardIMAGE_XPATH  = ".//*[@id='skill-specifc-portable-jobform']/a/img";	
	private static final String SRC_CONTAINS  ="2/post-your-job/bundles/rpglobalassets/img/research-now-banner.jpg";
	private static final String WELCOMETOEREWARDS_XPATH  =".//*[@id='Standard']/table/tbody/tr/td/span/strong";
	private static final String WELCOMETOEREWARDS_TEXT  ="Welcome to e-Rewards®!";

	private PostingJobViaFencesJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaFencesJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		scriptUtilities.getQuotes(context.getTestUrl(), context.driver, "83", "bricklayer");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFencesJobFormsWoodenFencesInstallTest() throws Exception {

		underTest.fillInStage1(FENCES);
		underTest.fillInWoodenFenceStage2(FENCES_JOB_REQUIRMENT_INSTALL, FENCES_LENGTH_INSTALL_XPATH, FENCES_LENGTH_INSTALL,
				FENCES_USE_OF_FENCES_INSTALL_XPATH_LIST, null, null, FENCES_HEIGHT_INSTALL, FENCES_SUPPLY_MATERIAL);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(30));
		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFencesJobFormsWoodenFencesInstallOtherTest() throws Exception {

		underTest.fillInStage1(FENCES);
		underTest.fillInWoodenFenceStage2(FENCES_JOB_REQUIRMENT_INSTALL, FENCES_LENGTH_INSTALL_XPATH, FENCES_LENGTH_INSTALL,
				FENCES_USE_OF_FENCES_INSTALL_XPATH_LIST_OTHER, FENCES_OTHER_INSTALL, FENCES_OTHER_TEXT, FENCES_HEIGHT_INSTALL, FENCES_SUPPLY_MATERIAL);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(30));
		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFencesJobFormsWoodenFencesRepairTest() throws Exception {

		underTest.fillInStage1(FENCES);
		underTest.fillInWoodenFenceStage2(FENCES_JOB_REQUIRMENT_REPAIR, FENCES_LENGTH_REPAIR_XPATH, FENCES_LENGTH_REPAIR,
				FENCES_USE_OF_FENCES_REPAIR_XPATH_LIST, null, null, FENCES_HEIGHT_REPAIR, FENCES_SUPPLY_MATERIAL);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(30));
		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFencesJobFormsWoodenFencesRepairOtherTest() throws Exception {

		underTest.fillInStage1(FENCES);
		underTest.fillInWoodenFenceStage2(FENCES_JOB_REQUIRMENT_REPAIR, FENCES_LENGTH_REPAIR_XPATH, FENCES_LENGTH_REPAIR,
				FENCES_USE_OF_FENCES_REPAIR_XPATH_LIST_OTHER, FENCES_OTHER_REPAIR, FENCES_OTHER_TEXT, FENCES_HEIGHT_REPAIR, FENCES_SUPPLY_MATERIAL);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(30));
		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFencesJobFormsGardenWallsInstallTest() throws Exception {

		underTest.fillInStage1(GARDEN_WALLS);
		underTest.fillInGardenWallsStage2(GARDEN_WALLS_JOB_REQUIRMENT_INSTALL, GARDEN_WALLS_LENGTH_INSTALL_XPATH, GARDEN_WALL_LENGTH_INSTALL,
				GARDEN_WALL_HEIGHT_INSTALL, GARDEN_WALL_SUPPLY_MATERIAL);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(30));
		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaFencesJobFormsGardenWallsRepairTest() throws Exception {

		underTest.fillInStage1(GARDEN_WALLS);
		underTest.fillInGardenWallsStage2(GARDEN_WALLS_JOB_REQUIRMENT_REPAIR, GARDEN_WALLS_LENGTH_REPAIR_XPATH, GARDEN_WALL_LENGTH_REPAIR,
				GARDEN_WALL_HEIGHT_REPAIR, GARDEN_WALL_SUPPLY_MATERIAL);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(30));
		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFencesJobFormsGatesInstallTest() throws Exception {

		underTest.fillInStage1(GATES);
		underTest.fillInGatesStage2(GATES_JOB_REQUIRMENT_INSTALL, GATES_TYPE_TO_INSTALL_XPATH_LIST, null, null, GATES_SUPPLY_MATERIAL);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(30));
		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFencesJobFormsGatesInstallOtherTest() throws Exception {

		underTest.fillInStage1(GATES);
		underTest.fillInGatesStage2(GATES_JOB_REQUIRMENT_INSTALL, GATES_TYPE_TO_INSTALL_XPATH_LIST_OTHER, GATES_OTHER_INSTALL, FENCES_OTHER_TEXT,
				GATES_SUPPLY_MATERIAL);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(30));
		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaFencesJobFormsGatesRepairTest() throws Exception {

		underTest.fillInStage1(GATES);
		underTest.fillInGatesStage2(GATES_JOB_REQUIRMENT_REPAIR, GATES_TYPE_TO_REPAIR_XPATH_LIST, null, null, GATES_SUPPLY_MATERIAL);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(30));
		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFencesJobFormsGatesRepairOtherTest() throws Exception {

		underTest.fillInStage1(GATES);
		underTest.fillInGatesStage2(GATES_JOB_REQUIRMENT_REPAIR, GATES_TYPE_TO_REPAIR_XPATH_LIST_OTHER, GATES_OTHER_REPAIR, FENCES_OTHER_TEXT,
				GATES_SUPPLY_MATERIAL);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(30));
		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaFencesJobFormsSomethingElseTest() throws Exception {

		underTest.fillInStage1(SOMETHING_ELSE);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(30));
		fillInStage4();
		fillInStage5();		

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	public void fillInStage4() {
		underTest.fillInStage4(BUDGET);
	}

	public void fillInStage5() {
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL, EMAIL);
	}
	

public void ThankYouPage() throws InterruptedException {
		
		assertEquals(context.driver.findElement(By.xpath(FlooringXpathLocators.xpathLookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(), FencesXpathLocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(FlooringXpathLocators.xpathLookup.get("WHATHAPPENSNEXTONE_XPATH"))).getText(), FlooringXpathLocators.dataLookup.get("WHATHAPPENSNEXTONE_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(FlooringXpathLocators.xpathLookup.get("WHATHAPPENSNEXTTWO_XPATH"))).getText(), FlooringXpathLocators.dataLookup.get("WHATHAPPENSNEXTTWO_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(FlooringXpathLocators.xpathLookup.get("WHATHAPPENSNEXTTHREE_XPATH"))).getText(), FlooringXpathLocators.dataLookup.get("WHATHAPPENSNEXTTHREE_TEXT"));
	
		// this is to test E-rewards link
		context.driver.findElement(By.xpath(ErewardIMAGE_XPATH)).isDisplayed();
		context.driver.findElement(By.xpath(ErewardIMAGE_XPATH)).getAttribute("src").contains(SRC_CONTAINS);
		
			
		String Mainwindow = context.driver.getWindowHandle(); 
		context.driver.findElement(By.xpath(ErewardIMAGE_XPATH)).click();

		for (String Erewardwindow : context.driver.getWindowHandles()) {
			context.driver.switchTo().window(Erewardwindow); 
		}

		context.driver.close(); 
		context.driver.switchTo().window(Mainwindow);
	
	}
}
