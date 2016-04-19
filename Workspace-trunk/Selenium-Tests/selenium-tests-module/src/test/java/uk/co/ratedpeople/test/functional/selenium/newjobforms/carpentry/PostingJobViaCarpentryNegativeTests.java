/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.carpentry;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

/**
 * @author shabana.khanam
 * 
 */
public class PostingJobViaCarpentryNegativeTests extends TestScript {

	private PostingJobViaCarpentryJobForms underTest;

	private static final String FIRSTNAME = "Andy";
	private static final String LASTNAME = "Green";
	private static final String PHONE_NUMBER = "01234567890";
	private static final String EMAIL = "a@mail.com";

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaCarpentryJobForms(context.driver, scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		scriptUtilities.getQuotes(context.getTestUrl(), context.driver, "38", "carpenter");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testAdditionalInfoValidation() throws Exception {
		underTest.fillInStage1(null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.dataLookup.get("STATUSXPATH"))).getText(),
				CarpentryXpathLocators.assertLookup.get("STATUSMSG"));
		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.dataLookup.get("OWNERSHIPPATH"))).getText(),
				CarpentryXpathLocators.assertLookup.get("OWNERMSG"));
		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.dataLookup.get("TIMINGXPATH"))).getText(),
				CarpentryXpathLocators.assertLookup.get("TIMINGMSG"));
		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.dataLookup.get("POSTCODEXPATH"))).getText(),
				CarpentryXpathLocators.assertLookup.get("POSTCODEMSG"));
		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.dataLookup.get("DETAILSXPATH"))).getText(),
				CarpentryXpathLocators.assertLookup.get("DETAILSMSG"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testBudgetValidation() throws Exception {

		underTest.fillInStage1(CarpentryXpathLocators.dataLookup.get("JOB_STATUS_ID"), CarpentryXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				CarpentryXpathLocators.dataLookup.get("TIMING"), CarpentryXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));

		underTest.fillInStage2(null);

		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.dataLookup.get("BUDGETXPATH"))).getText(),
				CarpentryXpathLocators.assertLookup.get("BUDGETMSG"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void testContactValidation() throws Exception {

		underTest.fillInStage1(CarpentryXpathLocators.dataLookup.get("JOB_STATUS_ID"), CarpentryXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				CarpentryXpathLocators.dataLookup.get("TIMING"), CarpentryXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));

		underTest.fillInStage2(CarpentryXpathLocators.dataLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.dataLookup.get("FNAMEXPATH"))).getText(),
				CarpentryXpathLocators.assertLookup.get("FNAMEMSG"));
		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.dataLookup.get("LNAMEXPATH"))).getText(),
				CarpentryXpathLocators.assertLookup.get("LNAMEMSG"));
		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.dataLookup.get("PNUMBERXPATH"))).getText(),
				CarpentryXpathLocators.assertLookup.get("PNUMBERMSG"));
		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.dataLookup.get("CONFIRMPNUMBERXPATH"))).getText(),
				CarpentryXpathLocators.assertLookup.get("CONFIRMPNUMBERMSG"));
		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.dataLookup.get("MAILXPATH"))).getText(),
				CarpentryXpathLocators.assertLookup.get("EMAILMSG"));
		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.dataLookup.get("CONFIRMMAILXPATH"))).getText(),
				CarpentryXpathLocators.assertLookup.get("CONFIRMEMAILMSG"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testContactValidationConfirmPhoneNumberNotPresent() throws Exception {

		underTest.fillInStage1(CarpentryXpathLocators.dataLookup.get("JOB_STATUS_ID"), CarpentryXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				CarpentryXpathLocators.dataLookup.get("TIMING"), CarpentryXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));

		underTest.fillInStage2(CarpentryXpathLocators.dataLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, "", EMAIL, EMAIL);

		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.dataLookup.get("CONFIRMPNUMBERXPATH"))).getText(),
				CarpentryXpathLocators.assertLookup.get("CONFIRMPNUMBERMSG"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testContactValidationConfirmPhoneNumberDifferent() throws Exception {

		underTest.fillInStage1(CarpentryXpathLocators.dataLookup.get("JOB_STATUS_ID"), CarpentryXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				CarpentryXpathLocators.dataLookup.get("TIMING"), CarpentryXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));

		underTest.fillInStage2(CarpentryXpathLocators.dataLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, "01234567899", EMAIL, EMAIL);

		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.dataLookup.get("CONFIRMPNUMBERXPATH"))).getText(),
				CarpentryXpathLocators.assertLookup.get("MISMATCHPNUMBERMSG"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testContactValidationConfirmEmailNotPresent() throws Exception {

		underTest.fillInStage1(CarpentryXpathLocators.dataLookup.get("JOB_STATUS_ID"), CarpentryXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				CarpentryXpathLocators.dataLookup.get("TIMING"), CarpentryXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));

		underTest.fillInStage2(CarpentryXpathLocators.dataLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL, "");

		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.dataLookup.get("CONFIRMMAILXPATH"))).getText(),
				CarpentryXpathLocators.assertLookup.get("CONFIRMEMAILMSG"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testContactValidationConfirmEmailDifferent() throws Exception {

		underTest.fillInStage1(CarpentryXpathLocators.dataLookup.get("JOB_STATUS_ID"), CarpentryXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				CarpentryXpathLocators.dataLookup.get("TIMING"), CarpentryXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));

		underTest.fillInStage2(CarpentryXpathLocators.dataLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRSTNAME, LASTNAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL, EMAIL + ".co.uk");

		assertEquals(context.driver.findElement(By.xpath(CarpentryXpathLocators.dataLookup.get("CONFIRMMAILXPATH"))).getText(),
				CarpentryXpathLocators.assertLookup.get("MISMATCHEMAILMSG"));
	}

}
