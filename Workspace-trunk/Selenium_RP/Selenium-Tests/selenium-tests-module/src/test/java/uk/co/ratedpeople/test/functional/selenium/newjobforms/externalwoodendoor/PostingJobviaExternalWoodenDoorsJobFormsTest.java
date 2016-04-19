/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.externalwoodendoor;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.externalwoodendoor.ExternalWoodenDoorsXpathLocators;

/**
 * @author olivier.renard
 * 
 */
public class PostingJobviaExternalWoodenDoorsJobFormsTest extends TestScript {

	private static final String REPLACE_DOOR_GLASS = "replaceDoorGlass";
	private static final String REPLACE_DOOR_BRICKWORK = "replaceDoorBrickwork";
	private static final String REPLACE_SUPPLY_FITTINGS_NO = "replaceSupplyFittingsNo";
	private static final String REPLACE_SUPPLY_DOORS_YES = "replaceSupplyDoorsYes";
	private static final String FITTINGS_SUPPLY_FITTINGS_YES = "fittingsSupplyFittingsYes";
	private static final String FITTINGS_LETTERBOXES = "fittingsLetterboxes";
	private static final String SECURITY_SUPPLY_FITTINGS_YES = "securitySupplyFittingsYes";
	private static final String SECURITY_BOLTS = "securityBolts";
	private static final String THANK_YOU = "Thank you";
	private static final String THANK_YOU_HEADER_TEXT_ID = "header-h1";
	private static final String REPAIR_DOOR_PAINT = "repairDoorPaint";
	private static final String REPAIR_DOOR_HANDLES = "repairDoorHandles";
	private static final String REPAIR_DOOR_HINGES = "repairDoorHinges";
	private static final String REPAIR_GLAZED = "repairGlazed";
	private static final String REPLACE_BIFOLD = "replaceBiFold";
	private static final String REPAIR_RADIO_BTN = "radioRepair";
	private static final String REPLACE_RADIO_BTN = "radioReplace";
	private static final String FITTINGS_RADIO_BTN = "radioFittings";
	private static final String SECURITY_RADIO_BTN = "radioSecurity";
	private static final String SOMETHING_ELSE_RADIO_BTN = "radioElse";
	private static final String IM_READY_TO_HIRE_RADIO_BTN = "statusREADY_TO_HIRE";
	private static final String OWNER_OWN_AND_LIVE_RADIO_BTN = "ownerOWN_AND_LIVE";
	private static final String URGENTLY = "URGENTLY";
	private static final String POSTCODE = "AL48TD";
	private static final String REPAIR_PROPERTY_STYLE = "704"; // Modern property (1960s - present day)
	private static final String REPLACE_PROPERTY_STYLE = "724"; // Modern property (1960s - present day)
	private static final String FITTINGS_PROPERTY_STYLE = "743"; // Modern property (1960s - present day)
	private static final String SECURITY_PROPERTY_STYLE = "758"; // Modern property (1960s - present day)
	private static final String SOMETHING_ELSE_PROPERTY_STYLE = "764"; // Modern property (1960s - present day)
	private static final String BUDGET_LT_500 = "127_LT_500";
	private static final String BUDGET_LT_1000 = "127_LT_1000";
	private static final String PHONE_NUMBER = "07512000000";
	private static final String EMAIL_ADDRESS = TestScriptUtilities.getRandomAlphabeticString(3) + "@ratedtrades.com";
	private static final String FIRST_NAME = TestScriptUtilities.getRandomAlphabeticString(3);
	private static final String LAST_NAME = TestScriptUtilities.getRandomAlphabeticString(3);
	private static final String ADDITIONAL_DETAILS = "additional info additional info additional info additional info additional info additional info additional info additional info";
	private static final String FITTINGS_PAGE1_NEXT_BUTTON_XPATH = ".//*[@id='descFittings']/div[3]/button[2]";
	private static final String SECURITY_PAGE1_NEXT_BUTTON_XPATH = ".//*[@id='descSecurity']/div[3]/button[2]";
	private static final int DESCRIPTION_LENGTH_30 = 30;

	private static final String ErewardIMAGE_XPATH  = ".//*[@id='skill-specifc-portable-jobform']/a/img";	
	private static final String SRC_CONTAINS  ="2/post-your-job/bundles/rpglobalassets/img/research-now-banner.jpg";
	private static final String WELCOMETOEREWARDS_XPATH  =".//*[@id='Standard']/table/tbody/tr/td/span/strong";
	private static final String WELCOMETOEREWARDS_TEXT  ="Welcome to e-Rewards®!";

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
	public void postingJobviaExternalWoodenDoorsJobFormsRepairOrAdjustExternalWoodenDoorsTest() throws Exception {

		String[] doorPartsToRepair = { REPAIR_DOOR_HINGES, REPAIR_DOOR_HANDLES, REPAIR_DOOR_PAINT };

		underTest.fillInPage1ForJobDetailsForRepairOrAdjustExternalWoodenDoors(REPAIR_RADIO_BTN, REPAIR_GLAZED, 3, doorPartsToRepair);

		underTest.fillInPage2ForAdditionalInfo(REPAIR_PROPERTY_STYLE, IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE,
				DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_500);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTest() throws Exception {

		String[] whatElseToInclude = { REPLACE_DOOR_BRICKWORK, REPLACE_DOOR_GLASS };

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(REPLACE_RADIO_BTN, REPLACE_BIFOLD, 3, REPLACE_SUPPLY_DOORS_YES,
				REPLACE_SUPPLY_FITTINGS_NO, whatElseToInclude);

		underTest.fillInPage2ForAdditionalInfo(REPLACE_PROPERTY_STYLE, IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE,
				DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallExternalWoodenDoorsTestWhatElseToIncludeNotAnswered() throws Exception {

		String[] whatElseToInclude = null;

		underTest.fillInPage1ForJobDetailsForReplaceOrInstallExternalWoodenDoors(REPLACE_RADIO_BTN, REPLACE_BIFOLD, 3, REPLACE_SUPPLY_DOORS_YES,
				REPLACE_SUPPLY_FITTINGS_NO, whatElseToInclude);

		underTest.fillInPage2ForAdditionalInfo(REPLACE_PROPERTY_STYLE, IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE,
				DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReplaceOrInstallFittingsTest() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(FITTINGS_RADIO_BTN, FITTINGS_LETTERBOXES, 3, FITTINGS_SUPPLY_FITTINGS_YES,
				FITTINGS_PAGE1_NEXT_BUTTON_XPATH);

		underTest.fillInPage2ForAdditionalInfo(FITTINGS_PROPERTY_STYLE, IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE,
				DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsInstallSecurityFittingsTest() throws Exception {

		underTest.fillInPage1ForJobDetailsForFittings(SECURITY_RADIO_BTN, SECURITY_BOLTS, 3, SECURITY_SUPPLY_FITTINGS_YES, SECURITY_PAGE1_NEXT_BUTTON_XPATH);

		underTest.fillInPage2ForAdditionalInfo(SECURITY_PROPERTY_STYLE, IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE,
				DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaExternalWoodenDoorsJobFormsReconfigurationSomethingElseTest() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(SOMETHING_ELSE_RADIO_BTN);

		underTest.fillInPage2ForAdditionalInfo(SOMETHING_ELSE_PROPERTY_STYLE, IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE,
				DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}
	
    public void ThankYouPage() {
		
		assertEquals(context.driver.findElement(By.xpath(ExternalWoodenDoorsXpathLocators.xpathLookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(), ExternalWoodenDoorsXpathLocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(ExternalWoodenDoorsXpathLocators.xpathLookup.get("WHATHAPPENSNEXTONE_XPATH"))).getText(), ExternalWoodenDoorsXpathLocators.dataLookup.get("WHATHAPPENSNEXTONE_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(ExternalWoodenDoorsXpathLocators.xpathLookup.get("WHATHAPPENSNEXTTWO_XPATH"))).getText(), ExternalWoodenDoorsXpathLocators.dataLookup.get("WHATHAPPENSNEXTTWO_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(ExternalWoodenDoorsXpathLocators.xpathLookup.get("WHATHAPPENSNEXTTHREE_XPATH"))).getText(), ExternalWoodenDoorsXpathLocators.dataLookup.get("WHATHAPPENSNEXTTHREE_TEXT"));
	
		
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
