/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.chimney;

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

/**
 * @author shabana.khanam
 * 
 */
public class PostingJobViachimneyJobFormsTest extends TestScript {

	private PostingJobViaChimneyJobForms underTest;
	private static final String[] CHIMNEY_STACK = { ".//*[@id='repairStackCowl']", ".//*[@id='repairStackPot']", ".//*[@id='repairStackStack']",
			".//*[@id='repairStackFlashing']", ".//*[@id='repairStackFlaunching']", ".//*[@id='repairStackStack']" };
	public static final String[] CHIMNEY_BREAST = { ".//*[@id='removeBreastBasement']", ".//*[@id='removeBreastBathroom']", ".//*[@id='removeBreastBedrooms']",
			".//*[@id='removeBreastDining']", ".//*[@id='removeBreastHallway']", ".//*[@id='removeBreastKitchen']", ".//*[@id='removeBreastLanding']",
			".//*[@id='removeBreastLounge']" };
	private static final String HEIGHT = "1401";
	private static final String HEIGHT_REBUILT = "1416";
	public static final String HEIGHT_REMOVE = "1441";
	public static final String BUILD_CONVERSION = "1444";
	private static final String JOB_STATUS_ID = "statusREADY_TO_HIRE";
	private static final String OWNERSHIP_STATUS_ID = "ownerLANDLORD";
	private static final String TIMING = "URGENTLY";
	private static final String POSTCODE = "SW1E6AU";
	private static final String BUDGET = "97_LT_100";
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

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaChimneyJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotesChimney();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaRepairChimneystackTest() throws Exception {
		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_REPAIR_CHIMNEY"));
		// underTest.fillInStage2RepairChimneyStack(ChimneyLocators.xpathLookup.get("PLUS_ICON"),CHIMNEY_STACK,"stupid",HEIGHT);
		underTest.fillInStage2RepairChimneyStack(ChimneyLocators.xpathLookup.get("PLUS_ICON"), CHIMNEY_STACK, null, HEIGHT);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1405", POSTCODE, TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(BUDGET);
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL, EMAIL);
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaRebuildChimneystackTest() throws Exception {
		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_REBUILD_CHIMNEY"));
		underTest.fillInStage2RebuildChimneyStack(ChimneyLocators.xpathLookup.get("REBUILD_PLUS_ICON"),
				ChimneyLocators.xpathLookup.get("JOB_REQUIREMENT_REBUILD"), HEIGHT_REBUILT);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1420", POSTCODE, TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(BUDGET);
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL, EMAIL);
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaRepairChimneyBreastTest() throws Exception {
		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_CHIMNEY_BREAST"));
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1427", POSTCODE, TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(BUDGET);
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL, EMAIL);
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaSomethingElseTest() throws Exception {
		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_SOMETHING"));
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1457", POSTCODE, TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(BUDGET);
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL, EMAIL);
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaRemoveChimneyBreastTest() throws Exception {
		underTest.fillInStage1(ChimneyLocators.xpathLookup.get("RADIO_REMOVE_CHIMNEY"));
		underTest.fillInStage2RemoveChimneyStack(CHIMNEY_BREAST, null, HEIGHT_REMOVE, BUILD_CONVERSION);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1449", POSTCODE, TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(BUDGET);
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL, EMAIL);
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}
	
public void ThankYouPage() {
		
		assertEquals(context.driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(), ChimneyLocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("WHATHAPPENSNEXTONE_XPATH"))).getText(), ChimneyLocators.dataLookup.get("WHATHAPPENSNEXTONE_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("WHATHAPPENSNEXTTWO_XPATH"))).getText(), ChimneyLocators.dataLookup.get("WHATHAPPENSNEXTTWO_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(ChimneyLocators.xpathLookup.get("WHATHAPPENSNEXTTHREE_XPATH"))).getText(), ChimneyLocators.dataLookup.get("WHATHAPPENSNEXTTHREE_TEXT"));
	
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
