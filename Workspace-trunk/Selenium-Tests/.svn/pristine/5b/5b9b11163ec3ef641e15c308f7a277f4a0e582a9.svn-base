package uk.co.ratedpeople.test.functional.selenium.newjobforms.carpentry;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.carpentry.CarpentryXpathLocators;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

/**
 * @author olivier.renard
 */

public class PostingJobViaCarpentryJobFormsTest extends TestScript {

	private static final String JOB_STATUS_ID = "statusREADY_TO_HIRE";
	private static final String OWNERSHIP_STATUS_ID = "ownerLANDLORD";
	private static final String TIMING = "URGENTLY";
	private static final String POSTCODE = "SW1E6AU";
	private static final String BUDGET = "38_LT_6000";
	private static final String BUDGET_OTHER = "38_OTHER";

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

	private PostingJobViaCarpentryJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaCarpentryJobForms(context.driver, scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		scriptUtilities.getQuotes(context.getTestUrl(), context.driver, "38", "carpenter");
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaCarpentryJobFormsTest() throws Exception {

		underTest.fillInStage1(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, "Some job description that must be greater than 30 chars");
		underTest.fillInStage2(BUDGET);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL, EMAIL);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaCarpentryJobFormsOtherBudgetTest() throws Exception {

		underTest.fillInStage1(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, POSTCODE, "Some job description that must be greater than 30 chars");
		underTest.fillInStage2OtherBudget(BUDGET_OTHER, "1234");

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL, EMAIL);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	public void ThankYouPage() {

		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.xpathLookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(),
				CarpentryXpathLocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.xpathLookup.get("WHATHAPPENSNEXTONE_XPATH"))).getText(),
				CarpentryXpathLocators.dataLookup.get("WHATHAPPENSNEXTONE_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.xpathLookup.get("WHATHAPPENSNEXTTWO_XPATH"))).getText(),
				CarpentryXpathLocators.dataLookup.get("WHATHAPPENSNEXTTWO_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.xpathLookup.get("WHATHAPPENSNEXTTHREE_XPATH"))).getText(),
				CarpentryXpathLocators.dataLookup.get("WHATHAPPENSNEXTTHREE_TEXT"));
		
		
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
