/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.garden;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

/**
 * 
 * 
 */
public class PostingJobviaGardenJobFormsTest extends TestScript {

	private static final String CLARANCE_RADIO_BTN = "radioClearance";
	private static final String LANDSCAPE_RADIO_BTN = "radioLandscaping";
	private static final String SOMETHING_ELSE_RADIO_BTN = "radioElse";

	private static final String CLEARENCE_MOWING = "clearanceMowing";
	private static final String CLEARENCE_SHED = "clearanceShed";
	private static final String CLEARENCE_WASTE_YES = "clearanceWasteYes";
	private static final String CLEARENCE_MAINTANANCE_YES = "clearanceMaintainanceYes";
	private static final String CLEARANCE_LENGTH = "833";

	private static final String LANDSCAPE_SEEDING = "landscapeSeeding";
	private static final String LANDSCAPE_PLAY_AREA = "landscapePlayArea";
	private static final String LANDSCAPE_WASTE_YES = "landscapeMaintainanceYes";
	private static final String LANDSCAPE_LENGTH = "853";

	private static final String SOMETHING_ELSE_LENGTH = "857";

	private static final String THANK_YOU = "Thank you";
	private static final String THANK_YOU_HEADER_TEXT_ID = "header-h1";

	private static final String IM_READY_TO_HIRE_RADIO_BTN = "statusREADY_TO_HIRE";
	private static final String OWNER_OWN_AND_LIVE_RADIO_BTN = "ownerOWN_AND_LIVE";
	private static final String URGENTLY = "URGENTLY";
	private static final String POSTCODE = "AL48TD";
	private static final String BUDGET_LT_500 = "82_LT_500";
	private static final String BUDGET_LT_1000 = "82_LT_1000";
	private static final String PHONE_NUMBER = "07512000000";
	private static final String EMAIL_ADDRESS = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
	private static final String FIRST_NAME = TestScriptUtilities.getRandomAlphabeticString(3);
	private static final String LAST_NAME = TestScriptUtilities.getRandomAlphabeticString(3);
	private static final String ADDITIONAL_DETAILS = "additional info additional info additional info additional info additional info additional info additional info additional info";
	private static final int DESCRIPTION_LENGTH_30 = 30;
	
	private static final String ErewardIMAGE_XPATH  = ".//*[@id='skill-specifc-portable-jobform']/a/img";	
	private static final String SRC_CONTAINS  ="2/post-your-job/bundles/rpglobalassets/img/research-now-banner.jpg";
	private static final String WELCOMETOEREWARDS_XPATH  =".//*[@id='Standard']/table/tbody/tr/td/span/strong";
	private static final String WELCOMETOEREWARDS_TEXT  ="Welcome to e-Rewards®!";

	private PostingJobviaGardenJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobviaGardenJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGardenJobFormsMaintenanceGardenTest() throws Exception {

		String[] workRequired = { CLEARENCE_MOWING, CLEARENCE_SHED };

		underTest.fillInPage1ForJobDetailsForGardenMaintenance(CLARANCE_RADIO_BTN, workRequired, CLEARENCE_WASTE_YES, CLEARENCE_MAINTANANCE_YES,
				CLEARANCE_LENGTH);

		underTest.fillInPage2ForAdditionalInfo(IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE, DESCRIPTION_LENGTH_30,
				ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaGardenJobFormsLandscapingTest() throws Exception {

		String[] workRequired = { LANDSCAPE_SEEDING, LANDSCAPE_PLAY_AREA };

		underTest.fillInPage1ForJobDetailsForLandscaping(LANDSCAPE_RADIO_BTN, workRequired, LANDSCAPE_WASTE_YES, LANDSCAPE_LENGTH);

		underTest.fillInPage2ForAdditionalInfo(IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE, DESCRIPTION_LENGTH_30,
				ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_500);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGardenJobFormsSomethingElseTest() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(SOMETHING_ELSE_RADIO_BTN, SOMETHING_ELSE_LENGTH);
		underTest.fillInPage2ForAdditionalInfo(IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE, DESCRIPTION_LENGTH_30,
				ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}
	
      public void ThankYouPage() {
		
		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(), GardenXpathLocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("WHATHAPPENSNEXTONE_XPATH"))).getText(), GardenXpathLocators.dataLookup.get("WHATHAPPENSNEXTONE_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("WHATHAPPENSNEXTTWO_XPATH"))).getText(), GardenXpathLocators.dataLookup.get("WHATHAPPENSNEXTTWO_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("WHATHAPPENSNEXTTHREE_XPATH"))).getText(), GardenXpathLocators.dataLookup.get("WHATHAPPENSNEXTTHREE_TEXT"));
	
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
