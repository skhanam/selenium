package uk.co.ratedpeople.test.functional.selenium.newjobforms.kitchen;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
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

public class PostingJobViaKitchenJobFormsTest extends TestScript {

	private static final String INSTALL = "radioInstall";
	private static final String REFURBISH = "radioRefurbish";
	private static final String WORKTOPS = "radioWorktops";
	private static final String SOMETHING_ELSE = "radioElse";

	private static final String[] PART_TO_INSTALL = { ".//*[@id='installGasHob']", ".//*[@id='installElectricOven']" };
	private static final String[] PART_TO_INSTALL_OTHER = { ".//*[@id='installGasHob']", ".//*[@id='installOther']" };
	private static final String TYPE_OF_WORKTOP = "installWorktopsLaminate";
	private static final String TYPE_OF_WORKTOP_OTHER = "installWorktopsOther";
	private static final String[] ADDITIONAL_INSTALL = { ".//*[@id='installFloorLino']", ".//*[@id='installWorktopWooden']" };
	private static final String[] ADDITIONAL_INSTALL_OTHER = { ".//*[@id='installFloorLino']", ".//*[@id='installPartsOther']" };
	private static final String INSTALL_KITCHEN_SIZE = "1364";
	private static final String SUPPLY_MATERIAL_INSTALL = "installSupplyKitchenYes";
	private static final String REMOVED_EXISTING_KITCHEN = "installKitchenRemoveNo";

	private static final String[] PART_TO_REFURBISH = { ".//*[@id='refurbishFloorLaminate']", ".//*[@id='refurbishWallTiling']" };
	private static final String[] PART_TO_REFURBISH_OTHER = { ".//*[@id='refurbishFloorLaminate']", ".//*[@id='refurbishOther']" };
	private static final String REFURBISH_KITCHEN_SIZE = "1382";

	private static final String JOB_STATUS_ID = "statusREADY_TO_HIRE";
	private static final String OWNERSHIP_STATUS_ID = "ownerLANDLORD";
	private static final String TIMING = "URGENTLY";
	private static final String POSTCODE = "SW1E6AU";
	private static final String BUDGET = "43_LT_100";

	private static final String FIRSTNAME = "Andy";
	private static final String LASTNAME = "Green";
	private static final String PHONE_NUMBER = "01234567890";
	private static final String EMAIL = "a@mail.com";

	private static final String THANK_YOU_HEADER_TEXT_ID = "header-h1";
	private static final String THANK_YOU = "Thank you";

	private static final String OTHER_TEXT = "This is other text";
	private static final String ErewardIMAGE_XPATH  = ".//*[@id='skill-specifc-portable-jobform']/a/img";	
	private static final String SRC_CONTAINS  ="2/post-your-job/bundles/rpglobalassets/img/research-now-banner.jpg";
	private static final String WELCOMETOEREWARDS_XPATH  =".//*[@id='Standard']/table/tbody/tr/td/span/strong";
	private static final String WELCOMETOEREWARDS_TEXT  ="Welcome to e-Rewards®!";

	private PostingJobViaKitchenJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaKitchenJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotesKitchen();
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallWithOptionalTest() throws Exception {

		underTest.fillInStage1(INSTALL);

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, TYPE_OF_WORKTOP, null, ADDITIONAL_INSTALL, null, INSTALL_KITCHEN_SIZE,
				SUPPLY_MATERIAL_INSTALL, REMOVED_EXISTING_KITCHEN);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallWithoutOptionalTest() throws Exception {

		underTest.fillInStage1(INSTALL);

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, TYPE_OF_WORKTOP, null, null, null, INSTALL_KITCHEN_SIZE, SUPPLY_MATERIAL_INSTALL,
				REMOVED_EXISTING_KITCHEN);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallOtherTest() throws Exception {

		underTest.fillInStage1(INSTALL);

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL_OTHER, OTHER_TEXT, TYPE_OF_WORKTOP_OTHER, OTHER_TEXT, ADDITIONAL_INSTALL_OTHER, OTHER_TEXT,
				INSTALL_KITCHEN_SIZE, SUPPLY_MATERIAL_INSTALL, REMOVED_EXISTING_KITCHEN);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();

		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsRefurbishTest() throws Exception {

		underTest.fillInStage1(REFURBISH);

		underTest.fillInRefurbishKitchenStage2(PART_TO_REFURBISH, null, REFURBISH_KITCHEN_SIZE);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaKitchenJobFormsRefurbishOtherTest() throws Exception {

		underTest.fillInStage1(REFURBISH);

		underTest.fillInRefurbishKitchenStage2(PART_TO_REFURBISH_OTHER, OTHER_TEXT, REFURBISH_KITCHEN_SIZE);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsWorktopTest() throws Exception {

		underTest.fillInStage1(WORKTOPS);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, TestScriptUtilities.getRandomString(30));

		fillInStage4();
		fillInStage5();
		
		

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();

		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaKitchenJobFormsSomethingElseTest() throws Exception {
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
	
public void ThankYouPage() {
		
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(), KitchenXpathLocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("WHATHAPPENSNEXTONE_XPATH"))).getText(), KitchenXpathLocators.dataLookup.get("WHATHAPPENSNEXTONE_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("WHATHAPPENSNEXTTWO_XPATH"))).getText(), KitchenXpathLocators.dataLookup.get("WHATHAPPENSNEXTTWO_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("WHATHAPPENSNEXTTHREE_XPATH"))).getText(), KitchenXpathLocators.dataLookup.get("WHATHAPPENSNEXTTHREE_TEXT"));
	
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
