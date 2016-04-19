package uk.co.ratedpeople.test.functional.selenium.newjobforms.newbuilds;

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

public class PostingJobViaNewBuildJobFormsTest extends TestScript {

	private static final String EXTENSION = "radioExtension";
	private static final String LOFT_CONVERSION = "radioLoftConversion";
	private static final String GARAGE_CONVERSION = "radioGarageConversion";
	private static final String GARAGE_CONSTRUCTION = "radioGarageConstruction";
	private static final String OUTBUILDING_CONSTRUCTION = "radioOutbuildingConstruction";
	private static final String SOMETHING_ELSE = "radioElse";

	private static final String JOB_STATUS_ID = "statusREADY_TO_HIRE";
	private static final String OWNERSHIP_STATUS_ID = "ownerLANDLORD";
	private static final String TIMING = "URGENTLY";
	private static final String POSTCODE = "SW1E6AU";
	private static final String BUDGET_SOMETHINGELSE = "9_LT_250";

	private static final String FIRSTNAME = "Andy";
	private static final String LASTNAME = "Green";
	private static final String PHONE_NUMBER = "01234567890";
	private static final String CONFIRM_PHONENUMBER = "01234567890";
	private static final String EMAIL = "a@mail.com";
	private static final String CONFIRM_EMAIL = "a@mail.com";

	private static final String THANK_YOU_HEADER_TEXT_ID = "header-h1";
	private static final String THANK_YOU = "Thank you";

	private PostingJobViaNewBuildJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaNewBuildJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		scriptUtilities.getQuotes(underTest.getTestUrl(), context.driver, "9", "builder");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaNewBuildJobFormsExtensionTest() throws Exception {

		underTest.fillInStage1(EXTENSION);

		String[] useOfExtenstionXPathList = { ".//*[@id='extensionRoomsBedrooms']", ".//*[@id='extensionRoomsDiningroom']" };

		underTest.fillInExtensionStage2("1076", useOfExtenstionXPathList, null, "973", "975", "978", "983", ".//*[@id='extensionListedUnknown']");
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "990", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaNewBuildJobFormsExtensionOtherRoomTest() throws Exception {

		underTest.fillInStage1(EXTENSION);

		String[] useOfExtenstionXPathList = { ".//*[@id='extensionRoomsBedrooms']", ".//*[@id='extensionRoomsDiningroom']", ".//*[@id='extensionRoomsOther']" };

		underTest.fillInExtensionStage2("1076", useOfExtenstionXPathList, "this is other text", "973", "975", "978", "983",
				".//*[@id='extensionListedUnknown']");
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "990", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaNewBuildJobFormsLoftConversionTest() throws Exception {
		underTest.fillInStage1(LOFT_CONVERSION);

		String[] roomInLoftConversionXPathList = { ".//*[@id='descLoftConversion']/div[2]/div[1]/ul/li[1]/a[2]",
				".//*[@id='descLoftConversion']/div[2]/div[2]/ul/li[2]/a[2]" };

		underTest.fillInLoftConversionStage2("radioLoftConversionRooflight", null, roomInLoftConversionXPathList, null, "1008", "1011", "1018",
				".//*[@id='loftConversionListedNo']");
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1023", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();

		

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingjJobViaNewBuildJobFormsLoftConversionOtherTest() throws Exception {
		underTest.fillInStage1(LOFT_CONVERSION);

		String[] roomInLoftConversionXPathList = { ".//*[@id='descLoftConversion']/div[2]/div[1]/ul/li[1]/a[2]",
				".//*[@id='descLoftConversion']/div[2]/div[2]/ul/li[2]/a[2]", ".//*[@id='descLoftConversion']/div[2]/div[2]/ul/li[3]/a[2]" };

		underTest.fillInLoftConversionStage2("radioLoftConversionOther", "This is other text", roomInLoftConversionXPathList, "This is other text", "1008",
				"1011", "1018", ".//*[@id='loftConversionListedNo']");
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1023", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();

		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaNewBuildJobFormsGarageConversionTest() throws Exception {
		underTest.fillInStage1(GARAGE_CONVERSION);

		String[] roomsToBeConvertedXPathList = { ".//*[@id='descGarageConversion']/div[1]/div[1]/ul/li[1]/a[2]",
				".//*[@id='descGarageConversion']/div[1]/div[1]/ul/li[4]/a[2]" };

		underTest.fillInGarageConversionStage2(roomsToBeConvertedXPathList, null, "1035", "1038", "1043");
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, null, POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();

		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaNewBuildJobFormsGarageConversionOtherTest() throws Exception {
		underTest.fillInStage1(GARAGE_CONVERSION);

		String[] roomsToBeConvertedXPathList = { ".//*[@id='descGarageConversion']/div[1]/div[1]/ul/li[1]/a[2]",
				".//*[@id='descGarageConversion']/div[1]/div[2]/ul/li[3]/a[2]" };

		underTest.fillInGarageConversionStage2(roomsToBeConvertedXPathList, "This is other text", "1035", "1038", "1043");
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, null, POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();

		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaNewBuildJobFormsGarageConstructionTest() throws Exception {
		underTest.fillInStage1(GARAGE_CONSTRUCTION);
		underTest.fillInPlanningAndBuilding("extensionArchitectural", "1047", "extensionPlanningPermission", "1051", "extensionBuildingRegulations", "1056");
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, null, POSTCODE, TestScriptUtilities.getRandomString(30));

		fillInStage4();
		fillInStage5();

		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();

		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaNewBuildJobFormsOutbuilding_ConstructionTest() throws Exception {
		underTest.fillInStage1(OUTBUILDING_CONSTRUCTION);
		underTest.fillInPlanningAndBuilding("extensionArchitectural", "1059", "extensionPlanningPermission", "1063", "extensionBuildingRegulations", "1068");
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, null, POSTCODE, TestScriptUtilities.getRandomString(30));

		fillInStage4();
		fillInStage5();
		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();

		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaNewBuildJobFormsSomethingElseTest() throws Exception {
		underTest.fillInStage1(SOMETHING_ELSE);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, null, POSTCODE, TestScriptUtilities.getRandomString(30));

		fillInStage4();
		fillInStage5();

		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);		
		ThankYouPage();
		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaNewBuildJobFormsSomethingElseEditJobTest() throws Exception {
		underTest.fillInStage1(SOMETHING_ELSE);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, null, POSTCODE, TestScriptUtilities.getRandomString(30));

		fillInStage4();
		fillInStage5AndCancelAndEditJob();
		
		}
	

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaNewBuildJobFormsSomethingElseCancelAndReturnTest() throws Exception {
		underTest.fillInStage1(SOMETHING_ELSE);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, null, POSTCODE, TestScriptUtilities.getRandomString(30));

		fillInStage4();
		fillInStage5AndCancelAndReturnHome();
	}

	public void fillInStage4() {
		underTest.fillInStage4(BUDGET_SOMETHINGELSE);
	}

	public void fillInStage5() {
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, CONFIRM_PHONENUMBER, EMAIL, CONFIRM_EMAIL);
	}
	
	public void ThankYouPage() {
		
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(), BuildXpathLocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("WHATHAPPENSNEXTONE_XPATH"))).getText(), BuildXpathLocators.dataLookup.get("WHATHAPPENSNEXTONE_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("WHATHAPPENSNEXTTWO_XPATH"))).getText(), BuildXpathLocators.dataLookup.get("WHATHAPPENSNEXTTWO_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("WHATHAPPENSNEXTTHREE_XPATH"))).getText(), BuildXpathLocators.dataLookup.get("WHATHAPPENSNEXTTHREE_TEXT"));
	
	
	}
	
	private void fillInStage5AndCancelAndEditJob() {
		JobFormSeleniumHelper.fillInContactPageDetailsAndEditJob(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, CONFIRM_PHONENUMBER, EMAIL,
				CONFIRM_EMAIL);
	}
	
	private void fillInStage5AndCancelAndReturnHome() {
		JobFormSeleniumHelper.fillInContactPageDetailsAndCancelAndReturn(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, CONFIRM_PHONENUMBER, EMAIL,
				CONFIRM_EMAIL);
	}
}
