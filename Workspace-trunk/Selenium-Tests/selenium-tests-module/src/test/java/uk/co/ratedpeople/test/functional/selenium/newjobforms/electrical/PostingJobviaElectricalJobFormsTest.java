/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.electrical;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.flooring.FlooringXpathLocators;

/**
 * @author olivier.renard
 * 
 */
public class PostingJobviaElectricalJobFormsTest extends TestScript {

	private static final String REPAIR_RADIO_BTN = "radioRepair";
	private static final String REPLACE_RADIO_BTN = "radioReplace";
	private static final String REWIRE_RADIO_BTN = "radioRewire";
	private static final String TESTING_RADIO_BTN = "radioTesting";
	private static final String CONSUMER_RADIO_BTN = "radioConsumer";
	private static final String FAULT_RADIO_BTN = "radioFault";
	private static final String SOMETHING_ELSE_RADIO_BTN = "radioElse";

	private static final String REPAIR_PROPERTY_STYLE = "883"; // Modern property (1960s - present day)
	private static final String REPEAIR_IN_KITCHEN_RADIO_BTN = "repairInKitchenYes";
	private static final String REPAIR_HOB = "repairHob";
	private static final String REPAIR_SHOWER = "repairShower";

	private static final String REPLACE_PROVIDE_ITEMS = "replaceSupplyFittingsYes";
	private static final String REPLACE_PROPERTY_STYLE = "904";
	private static final String REPLACE_IN_KITCHEN_RADIO_BTN = "replaceInKitchenYes";
	private static final String REPLACE_HOB = "installHob";
	private static final String REPLACE_TOWEL = "installTowel";

	private static final String REWIRING_LOUNGE = "rewireLounge";
	private static final String REWIRING_DINING = "rewireDiningRoom";
	private static final String REWIRING_PROPERTY_STYLE = "918";

	private static final String TESTING_PROPERTY_STYLE = "928";
	private static final String TESTING_REPORT = "testReport";
	private static final String TESTING_APPLIANCE = "testAppliance";

	private static final String CONSUMER_PROPERTY_STYLE = "937";
	private static final String CONSUMER_REPLACE = "consumerReplace";

	private static final String FAULT_PROPERTY_STYLE = "942"; // Modern property (1960s - present day)

	private static final String SOMETHING_ELSE_PROPERTY_STYLE = "948"; // Modern property (1960s - present day)

	private static final String THANK_YOU = "Thank you";
	private static final String THANK_YOU_HEADER_TEXT_ID = "header-h1";

	private static final String IM_READY_TO_HIRE_RADIO_BTN = "statusREADY_TO_HIRE";
	private static final String OWNER_OWN_AND_LIVE_RADIO_BTN = "ownerOWN_AND_LIVE";
	private static final String URGENTLY = "URGENTLY";
	private static final String POSTCODE = "AL48TD";
	private static final String BUDGET_LT_500 = "27_LT_500";
	private static final String BUDGET_LT_1000 = "27_LT_1000";
	private static final String PHONE_NUMBER = "07512000000";
	private static final String EMAIL_ADDRESS = TestScriptUtilities.getRandomAlphabeticString(3) + "@ratedtrades.com";
	private static final String FIRST_NAME = TestScriptUtilities.getRandomAlphabeticString(3);
	private static final String LAST_NAME = TestScriptUtilities.getRandomAlphabeticString(3);
	private static final String ADDITIONAL_DETAILS = "additional info additional info additional info additional info additional info additional info additional info additional info";
	private static final int DESCRIPTION_LENGTH_30 = 30;

	private static final String ErewardIMAGE_XPATH  = ".//*[@id='skill-specifc-portable-jobform']/a/img";	
	private static final String SRC_CONTAINS  ="2/post-your-job/bundles/rpglobalassets/img/research-now-banner.jpg";
	private static final String WELCOMETOEREWARDS_XPATH  =".//*[@id='Standard']/table/tbody/tr/td/span/strong";
	private static final String WELCOMETOEREWARDS_TEXT  ="Welcome to e-Rewards®!";

	
	private PostingJobviaElectricalJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobviaElectricalJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaElectricalJobFormsRepairsAndMaintenanceTest() throws Exception {

		String[] whereRepairsNeeded = { REPEAIR_IN_KITCHEN_RADIO_BTN };

		String[] whatNeedsToBeRepaired = { REPAIR_SHOWER, REPAIR_HOB };

		underTest.fillInPage1ForJobDetailsForRepairElectrical(REPAIR_RADIO_BTN, whatNeedsToBeRepaired, whereRepairsNeeded);

		underTest.fillInPage2ForAdditionalInfo(REPAIR_PROPERTY_STYLE, IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE,
				DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_500);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaElectricalJobFormsReplaceElectricalTest() throws Exception {

		String[] roofSectionsToReplace = { REPLACE_HOB, REPLACE_TOWEL };

		String[] whereRepairsNeeded = { REPLACE_IN_KITCHEN_RADIO_BTN };

		underTest.fillInPage1ForJobDetailsForReplaceElectrical(REPLACE_RADIO_BTN, roofSectionsToReplace, whereRepairsNeeded, REPLACE_PROVIDE_ITEMS);

		underTest.fillInPage2ForAdditionalInfo(REPLACE_PROPERTY_STYLE, IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE,
				DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaElectricalJobFormsRewiringTest() throws Exception {

		String[] sectionsToRewire = { REWIRING_DINING, REWIRING_LOUNGE };

		underTest.fillInPage1ForJobDetailsForRewireElectrical(REWIRE_RADIO_BTN, sectionsToRewire);

		underTest.fillInPage2ForAdditionalInfo(REWIRING_PROPERTY_STYLE, IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE,
				DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaElectricalJobFormsCertificationTest() throws Exception {

		String[] whatNeedsToBeTested = { TESTING_REPORT, TESTING_APPLIANCE };

		underTest.fillInPage1ForJobDetailsForTestingElectrical(TESTING_RADIO_BTN, whatNeedsToBeTested);

		underTest.fillInPage2ForAdditionalInfo(TESTING_PROPERTY_STYLE, IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE,
				DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaElectricalJobFormsConsumerTest() throws Exception {

		String whatNeedsToBeCarried = CONSUMER_REPLACE;

		underTest.fillInPage1ForJobDetailsForConsumerElectrical(CONSUMER_RADIO_BTN, whatNeedsToBeCarried);

		underTest.fillInPage2ForAdditionalInfo(CONSUMER_PROPERTY_STYLE, IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE,
				DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaElectricalJobFormsFaultingTest() throws Exception {

		underTest.fillInPage1ForJobDetailsForFaultElectrical(FAULT_RADIO_BTN);

		underTest.fillInPage2ForAdditionalInfo(FAULT_PROPERTY_STYLE, IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE,
				DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaElectricalJobFormsSomethingElseTest() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(SOMETHING_ELSE_RADIO_BTN);

		underTest.fillInPage2ForAdditionalInfo(SOMETHING_ELSE_PROPERTY_STYLE, IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE,
				DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}
	
public void ThankYouPage() throws InterruptedException {
		
		assertEquals(context.driver.findElement(By.xpath(FlooringXpathLocators.xpathLookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(), FlooringXpathLocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
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
