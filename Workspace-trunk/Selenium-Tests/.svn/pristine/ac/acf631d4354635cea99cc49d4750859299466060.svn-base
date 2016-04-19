/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.flatroofs;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

/**
 * @author olivier.renard
 * 
 */
public class PostingJobviaFlatRoofsJobFormsTest extends TestScript {

	private static final String SOMETHING_ELSE_PROPERTY_TYPE = "520"; // Terraced
	private static final String SOMETHING_ELSE_PROPERTY_STYLE = "528"; // Modern
																		// property
																		// (1960s
																		// -
																		// present
																		// day)
	private static final String FIND_REPAIR_LEAK_PROPERTY_TYPE = "508"; // Terraced
	private static final String FIND_REPAIR_LEAK_PROPERTY_STYLE = "516"; // Terraced
	private static final String FIND_REPAIR_LEAK_RADIO_BTN = "radioRepairLeak";
	private static final String REPAIR_PROPERTY_TYPE = "496"; // Terraced
	private static final String REPAIR_PROPERTY_STYLE = "504"; // Modern
																// property
																// (1960s -
																// present day)
	private static final String REPAIR_SECTION_ROOF = "repairSectionRoof";
	private static final String REPAIR_HIGHEST_ROOF_SECTION_3_STOREY = "493";
	private static final String REPAIR_BAY = "repairBay";
	private static final String REPAIR_MAIN = "repairMain";
	private static final String REPAIR_ROOF_WATER = "repairRoofWater";
	private static final String REPAIR_ROOF_WORN = "repairRoofWorn";
	private static final String REPLACE_BEDROOMS = "repalceBedrooms";
	private static final String REPLACE_PROPERTY_STYLE = "476"; // Modern
																// property
																// (1960s -
																// present day)
	private static final String REPLACE_PROPERTY_TYPE = "468"; // Terraced
	private static final String REPLACE_HIGHEST_ROOF_SECTION_3_STOREY = "465";
	private static final String REPLACE_SECTION_ROOF = "replaceSectionRoof";
	private static final String REPLACE_DORMER = "replaceDormer";
	private static final String REPLACE_EXTENSION = "replaceExtension";
	private static final String THANK_YOU = "Thank you";
	private static final String THANK_YOU_HEADER_TEXT_ID = "header-h1";
	private static final String REPAIR_RADIO_BTN = "radioRepair";
	private static final String REPLACE_RADIO_BTN = "radioReplace";
	private static final String SOMETHING_ELSE_RADIO_BTN = "radioElse";
	private static final String IM_READY_TO_HIRE_RADIO_BTN = "statusREADY_TO_HIRE";
	private static final String OWNER_OWN_AND_LIVE_RADIO_BTN = "ownerOWN_AND_LIVE";
	private static final String URGENTLY = "URGENTLY";
	private static final String POSTCODE = "AL48TD";
	private static final String BUDGET_LT_500 = "98_LT_500";
	private static final String BUDGET_LT_1000 = "98_LT_1000";
	private static final String PHONE_NUMBER = "07512000000";
	private static final String EMAIL_ADDRESS = TestScriptUtilities
			.getRandomString(3) + "@ratedtrades.com";
	private static final String FIRST_NAME = TestScriptUtilities
			.getRandomAlphabeticString(3);
	private static final String LAST_NAME = TestScriptUtilities
			.getRandomAlphabeticString(3);
	private static final String ADDITIONAL_DETAILS = "additional info additional info additional info additional info additional info additional info additional info additional info";
	private static final int DESCRIPTION_LENGTH_30 = 30;

	private static final String ErewardIMAGE_XPATH  = ".//*[@id='skill-specifc-portable-jobform']/a/img";	
	private static final String SRC_CONTAINS  ="2/post-your-job/bundles/rpglobalassets/img/research-now-banner.jpg";
	private static final String WELCOMETOEREWARDS_XPATH  =".//*[@id='Standard']/table/tbody/tr/td/span/strong";
	private static final String WELCOMETOEREWARDS_TEXT  ="Welcome to e-Rewards®!";
	
	private PostingJobviaFlatRoofsJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobviaFlatRoofsJobForms(context.driver,
				context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups={"regression"},enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest()
			throws Exception {

		String[] roofSectionsToReplace = { REPLACE_EXTENSION, REPLACE_DORMER };

		underTest.fillInPage1ForJobDetailsForReplaceFlatRoofs(
				REPLACE_RADIO_BTN, roofSectionsToReplace, REPLACE_SECTION_ROOF,
				REPLACE_HIGHEST_ROOF_SECTION_3_STOREY);

		underTest.fillInPage2ForAdditionalInfo(REPLACE_PROPERTY_TYPE,
				REPLACE_PROPERTY_STYLE, REPLACE_BEDROOMS, 3,
				IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN,
				URGENTLY, POSTCODE, DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_500);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver
				.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(),
				THANK_YOU);
		ThankYouPage();
		

	}

	@Test(groups={"sanity"},enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest()
			throws Exception {

		String[] whatNeedsToBeRepaired = { REPAIR_ROOF_WORN, REPAIR_ROOF_WATER };

		String[] whereRepairsNeeded = { REPAIR_MAIN, REPAIR_BAY };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(REPAIR_RADIO_BTN,
				whatNeedsToBeRepaired, whereRepairsNeeded, REPAIR_SECTION_ROOF,
				REPAIR_HIGHEST_ROOF_SECTION_3_STOREY);

		underTest.fillInPage2ForAdditionalInfo(REPAIR_PROPERTY_TYPE,
				REPAIR_PROPERTY_STYLE, null, 0, IM_READY_TO_HIRE_RADIO_BTN,
				OWNER_OWN_AND_LIVE_RADIO_BTN, URGENTLY, POSTCODE,
				DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver
				.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(),
				THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups={"regression"},enabled = true)
	public void postingJobviaFlatRoofsJobFormsFindAndRepairLeakTest()
			throws Exception {

		underTest
				.fillInPage1ForJobDetailsForFindAndRepairLeak(FIND_REPAIR_LEAK_RADIO_BTN);

		underTest.fillInPage2ForAdditionalInfo(FIND_REPAIR_LEAK_PROPERTY_TYPE,
				FIND_REPAIR_LEAK_PROPERTY_STYLE, null, 0,
				IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN,
				URGENTLY, POSTCODE, DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver
				.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(),
				THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups={"sanity"},enabled = true)
	public void postingJobviaFlatRoofsJobFormsSomethingElseTest()
			throws Exception {

		underTest
				.fillInPage1ForJobDetailsForSomethingElse(SOMETHING_ELSE_RADIO_BTN);

		underTest.fillInPage2ForAdditionalInfo(SOMETHING_ELSE_PROPERTY_TYPE,
				SOMETHING_ELSE_PROPERTY_STYLE, null, 0,
				IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO_BTN,
				URGENTLY, POSTCODE, DESCRIPTION_LENGTH_30, ADDITIONAL_DETAILS);

		underTest.fillInPage3ForBudget(BUDGET_LT_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver
				.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(),
				THANK_YOU);
		ThankYouPage();
		
	}
	
   public void ThankYouPage() {
		
		assertEquals(context.driver.findElement(By.xpath(FlatRoofsXpathLocators.xpathLookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(), FlatRoofsXpathLocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(FlatRoofsXpathLocators.xpathLookup.get("WHATHAPPENSNEXTONE_XPATH"))).getText(), FlatRoofsXpathLocators.dataLookup.get("WHATHAPPENSNEXTONE_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(FlatRoofsXpathLocators.xpathLookup.get("WHATHAPPENSNEXTTWO_XPATH"))).getText(), FlatRoofsXpathLocators.dataLookup.get("WHATHAPPENSNEXTTWO_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(FlatRoofsXpathLocators.xpathLookup.get("WHATHAPPENSNEXTTHREE_XPATH"))).getText(), FlatRoofsXpathLocators.dataLookup.get("WHATHAPPENSNEXTTHREE_TEXT"));
	
		
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
