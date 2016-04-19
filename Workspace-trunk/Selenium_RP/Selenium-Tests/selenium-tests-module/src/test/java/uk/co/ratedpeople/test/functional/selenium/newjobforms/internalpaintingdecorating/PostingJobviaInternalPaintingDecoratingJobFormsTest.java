/**

 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.internalpaintingdecorating;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

/**
 * @author shabana.khanam
 * 
 */
public class PostingJobviaInternalPaintingDecoratingJobFormsTest extends TestScript {
	private static final String THANK_YOU = "Thank you";
	private static final String THANK_YOU_HEADER_TEXT_ID = "header-h1";
	private static final String IN_REPAIR_RADIO = "inRepair";
	private static final String IM_READY_TO_HIRE_RADIO_BTN = "statusREADY_TO_HIRE";
	private static final String OWNER_OWN_AND_LIVE_RADIO = "ownerOWN_AND_LIVE";
	private static final String URGENTLY = "URGENTLY";
	private static final String HAVE_MATERIAL_RADIO = "haveMaterial";
	private static final String BUDGET_500 = "LT_500";
	private static final String NEED_REPAIR_RADIO_ID = "needRepair";
	private static final String IM_PLANNING_AND_BUDGETING_RADIO = "statusPLANNING_BUDGETING";
	private static final String OWNER_LANDLORD_RADIO_ID = "ownerLANDLORD";
	private static final String TWO_DAYS_TIMING_ID = "LT_2_DAYS";
	private static final String NO_MATERIAL_RADIO_ID = "noMaterial";
	private static final String LOT_REPAIR_RADIO_ID = "lotRepair";
	private static final String OWNER_RENT_RADIO_ID = "ownerRENT";
	private static final String SOME_MATERIAL_RADIO_ID = "someMaterial";
	private static final String BUDGET_1000 = "LT_1000";
	private static final String NOT_SURE_RADIO_ID = "notSure";
	private static final String TWO_MONTHS_TIMING = "LT_2_MONTHS";
	private static final String VALID_OTHER_TEXT = "other text other text other text other text other text other text";
	private static final String PAINTING_CHECKBOX_ID = "painting";
	private static final String POSTCODE = "AL48TD";
	private static final String ADDITIONAL_DETAILS = "additional info additional info additional info additional info additional info additional info additional info additional info";
	private static final String PHONE_NUMBER = "07973837438";
	private static final String LAST_NAME = "Little-John";
	private static final String FIRST_NAME = "Rupert";
	private static final String EMAIL_ADDRESS = "email@ratedtrades.com";
	private static final String TEXTUNDERTHANKYOU_XPATH = ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/p[1]";
	private static final String WHATHAPPENSNEXTONE_XPATH = ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[1]";
	private static final String WHATHAPPENSNEXTTWO_XPATH = ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[2]";
	private static final String WHATHAPPENSNEXTTHREE_XPATH = ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[3]";
	private static final String TEXTUNDERTHANKYOU_TEXT =  "Your job has been successfully submitted for review and will be shared with tradesmen shortly. We have sent you an email with your password for Rated People. Keep it safe and use it to log in to your account. If this is not your first job posted with us, you should already have your password.";
	private static final String WHATHAPPENSNEXTONE_TEXT = "Tradesmen will review your job details";
	private static final String WHATHAPPENSNEXTTWO_TEXT = "Up to three interested tradesmen will pay to contact you";
	private static final String WHATHAPPENSNEXTTHREE_TEXT = "We'll send you an email and SMS with their profile(s) and ratings";
	private static final String ErewardIMAGE_XPATH  = ".//*[@id='skill-specifc-portable-jobform']/a/img";	
	private static final String SRC_CONTAINS  ="2/post-your-job/bundles/rpglobalassets/img/research-now-banner.jpg";
	private static final String WELCOMETOEREWARDS_XPATH  =".//*[@id='Standard']/table/tbody/tr/td/span/strong";
	private static final String WELCOMETOEREWARDS_TEXT  ="Welcome to e-Rewards®!";	
	private PostingJobviaInternalPaintingDecorationJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobviaInternalPaintingDecorationJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaInternalPaintingDecoratingJobFormsPaintingInGoodRepairTest() throws Exception {
		underTest.fillInStage1(PAINTING_CHECKBOX_ID, IN_REPAIR_RADIO, false, "", false, "", true);

		underTest.fillInStage2(IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO, URGENTLY, HAVE_MATERIAL_RADIO, POSTCODE, ADDITIONAL_DETAILS);

		underTest.fillInStage3(BUDGET_500);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaInternalPaintingDecoratingJobFormsPaintingWithOtherInGoodRepairTest() throws Exception {
		underTest.fillInStage1(PAINTING_CHECKBOX_ID, IN_REPAIR_RADIO, true, VALID_OTHER_TEXT, false, "", true);

		underTest.fillInStage2(IM_READY_TO_HIRE_RADIO_BTN, OWNER_OWN_AND_LIVE_RADIO, URGENTLY, HAVE_MATERIAL_RADIO, POSTCODE, ADDITIONAL_DETAILS);

		underTest.fillInStage3(BUDGET_500);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaInternalPaintingDecoratingJobFormsPaintingNeedsSomeRepairTest() throws Exception {
		underTest.fillInStage1(PAINTING_CHECKBOX_ID, NEED_REPAIR_RADIO_ID, false, "", false, "", true);

		underTest
				.fillInStage2(IM_PLANNING_AND_BUDGETING_RADIO, OWNER_LANDLORD_RADIO_ID, TWO_DAYS_TIMING_ID, NO_MATERIAL_RADIO_ID, POSTCODE, ADDITIONAL_DETAILS);

		underTest.fillInStage3(BUDGET_500);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaInternalPaintingDecoratingJobFormsPaintingNeedsLotRepairTest() throws Exception {
		underTest.fillInStage1(PAINTING_CHECKBOX_ID, LOT_REPAIR_RADIO_ID, false, "", false, "", true);

		underTest.fillInStage2(IM_PLANNING_AND_BUDGETING_RADIO, OWNER_RENT_RADIO_ID, TWO_DAYS_TIMING_ID, SOME_MATERIAL_RADIO_ID, POSTCODE, ADDITIONAL_DETAILS);

		underTest.fillInStage3(BUDGET_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaInternalPaintingDecoratingJobFormsPaintingNotSureTest() throws Exception {
		underTest.fillInStage1(PAINTING_CHECKBOX_ID, NOT_SURE_RADIO_ID, false, "", false, "", true);

		underTest.fillInStage2(IM_PLANNING_AND_BUDGETING_RADIO, OWNER_RENT_RADIO_ID, TWO_MONTHS_TIMING, SOME_MATERIAL_RADIO_ID, POSTCODE, ADDITIONAL_DETAILS);

		underTest.fillInStage3(BUDGET_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaInternalPaintingDecoratingJobFormsPaintingNotSureOtherTest() throws Exception {
		underTest.fillInStage1(PAINTING_CHECKBOX_ID, NOT_SURE_RADIO_ID, false, "", true, VALID_OTHER_TEXT, true);

		underTest.fillInStage2(IM_PLANNING_AND_BUDGETING_RADIO, OWNER_RENT_RADIO_ID, TWO_MONTHS_TIMING, SOME_MATERIAL_RADIO_ID, POSTCODE, ADDITIONAL_DETAILS);

		underTest.fillInStage3(BUDGET_1000);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

     public void ThankYouPage() {
		
		assertEquals(context.driver.findElement(By.xpath(TEXTUNDERTHANKYOU_XPATH)).getText(), TEXTUNDERTHANKYOU_TEXT);
		assertEquals(context.driver.findElement(By.xpath(WHATHAPPENSNEXTONE_XPATH)).getText(), WHATHAPPENSNEXTONE_TEXT);
		assertEquals(context.driver.findElement(By.xpath(WHATHAPPENSNEXTTWO_XPATH)).getText(), WHATHAPPENSNEXTTWO_TEXT);
		assertEquals(context.driver.findElement(By.xpath(WHATHAPPENSNEXTTHREE_XPATH)).getText(), WHATHAPPENSNEXTTHREE_TEXT);
	
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
