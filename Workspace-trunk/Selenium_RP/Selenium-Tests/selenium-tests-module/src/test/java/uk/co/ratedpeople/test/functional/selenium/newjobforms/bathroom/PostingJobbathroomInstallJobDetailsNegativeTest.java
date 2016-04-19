/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.bathroom;

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
public class PostingJobbathroomInstallJobDetailsNegativeTest extends TestScript {
	private PostingJobViaBathroomJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaBathroomJobForms(context, scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups={"sanity"},enabled = true)
	public void testinstallFlowWhatneedstobeInstalledNotSelected() throws Exception {
		underTest.fillInStage1("radioInstall", "stageonereplacenext");
		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("installjs"))).getText(),
				BathroomXpathlocators.jsLookup.get("installvalidation"));
	}

	@Test(groups={"sanity"},enabled = true)
	public void testInstallFlowWhatElseDoYouNeedOtherNotAnswered() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.installFirstPageWhatElseNeededQuestionOtherNotAnswered();
		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("installWhatElseOtherjs"))).getText(),
				BathroomXpathlocators.jsLookup.get("whatElseNeededValidation"));
	}

	@Test(groups={"regression"},enabled = true)
	public void testInstallFlowWhichOfTheFollowingAreYourSupplyingOtherNotAnswered() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.installFirstPageWhichOfTheFollowingAreYouSupplyingQuestionOtherNotAnswered();
		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("installSupplyingOtherjs"))).getText(),
				BathroomXpathlocators.jsLookup.get("whichAreYouSupplyingValidation"));
	}

	@Test(groups={"regression"},enabled = true)
	public void testrepairFlowWhatneedstobeRepairedNotSelected() throws Exception {
		underTest.fillInStage1("radioRepair", "repairstagetwonext");
		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("repairjs"))).getText(),
				BathroomXpathlocators.jsLookup.get("installvalidation"));
	}

	@SuppressWarnings("static-access")
	@Test(groups={"regression"},enabled = true)
	public void testadditionalInfostatusNotSelected() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.replacePathFirstPage();
		underTest.fillInStage2("", BathroomXpathlocators.xpathLookup.get("owner"), "URGENTLY", BathroomXpathlocators.dataLookup.get("postcode"), "Selenium"
				+ scriptUtilities.getRandomString(5));
		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("statusjs"))).getText(),
				BathroomXpathlocators.jsLookup.get("appropriatestatus"));

	}

	@SuppressWarnings("static-access")
	@Test(groups={"regression"},enabled = true)
	public void testadditionalInfoOwnershipsNotSelected() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.replacePathFirstPage();
		underTest.fillInStage2(BathroomXpathlocators.xpathLookup.get("status"), "", "URGENTLY", BathroomXpathlocators.dataLookup.get("postcode"), "Selenium"
				+ scriptUtilities.getRandomString(5));
		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("ownershipjs"))).getText(),
				BathroomXpathlocators.jsLookup.get("ownership"));

	}

	@SuppressWarnings("static-access")
	@Test(groups={"regression"},enabled = true)
	public void testadditionalInfoTimingNotSelected() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.replacePathFirstPage();
		underTest.fillInStage2(BathroomXpathlocators.xpathLookup.get("status"), BathroomXpathlocators.xpathLookup.get("owner"), "",
				BathroomXpathlocators.dataLookup.get("postcode"), "Selenium" + scriptUtilities.getRandomString(5));
		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("timingjs"))).getText(),
				BathroomXpathlocators.jsLookup.get("timing"));

	}

	@SuppressWarnings("static-access")
	@Test(groups={"regression"},enabled = true)
	public void testadditionalInfoPostcodeNotSelected() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.replacePathFirstPage();
		underTest.fillInStage2(BathroomXpathlocators.xpathLookup.get("status"), BathroomXpathlocators.xpathLookup.get("owner"), "URGENTLY", "", "Selenium"
				+ scriptUtilities.getRandomString(5));
		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("postcodejs"))).getText(),
				BathroomXpathlocators.jsLookup.get("postcode"));

	}

	@Test(groups={"regression"},enabled = true)
	public void testadditionalInfoAdditionalInfoNotEntered() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.replacePathFirstPage();
		underTest.fillInStage2(BathroomXpathlocators.xpathLookup.get("status"), BathroomXpathlocators.xpathLookup.get("owner"), "URGENTLY",
				BathroomXpathlocators.dataLookup.get("postcode"), "");
		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("additionaldetailsjs"))).getText(),
				BathroomXpathlocators.jsLookup.get("additionaldetails"));

	}

	@SuppressWarnings("static-access")
	@Test(groups={"regression"},enabled = true)
	public void testadditionalInfoAdditionalInfoLessThanMinimumEntered() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.replacePathFirstPage();
		underTest.fillInStage2(BathroomXpathlocators.xpathLookup.get("status"), BathroomXpathlocators.xpathLookup.get("owner"), "URGENTLY",
				BathroomXpathlocators.dataLookup.get("postcode"), scriptUtilities.getRandomString(3));
		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("additionalinfolessjs"))).getText(),
				BathroomXpathlocators.jsLookup.get("additionaldetailsless"));

	}

	@Test(groups={"regression"},enabled = true)
	public void testBudgetNotSelected() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.replacePathFirstPage();
		underTest.additionalInfoPage(5, BathroomXpathlocators.dataLookup.get("postcode"));
		underTest.fillInStage3("");
		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("budgetjs"))).getText(),
				BathroomXpathlocators.jsLookup.get("budget"));

	}

	@Test(groups={"regression"},enabled = true)
	public void testContactPageFirstnameNotEntered() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.replacePathFirstPage();
		underTest.additionalInfoPage(5, BathroomXpathlocators.dataLookup.get("postcode"));
		underTest.thirdPage("Under £8,000");
		
		String lastName = BathroomXpathlocators.dataLookup.get("lname");
		String email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
		String mobile = BathroomXpathlocators.dataLookup.get("mobile");
		
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, "", lastName, mobile, mobile, email, email);

		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("firstnamejs"))).getText(),
				BathroomXpathlocators.jsLookup.get("firstname"));
	}

	@Test(groups={"regression"},enabled = true)
	public void testContactPageLastnameNotEntered() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.replacePathFirstPage();
		underTest.additionalInfoPage(5, BathroomXpathlocators.dataLookup.get("postcode"));
		underTest.thirdPage("Under £8,000");
		
		String firstName = BathroomXpathlocators.dataLookup.get("fname");
		String email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
		String mobile = BathroomXpathlocators.dataLookup.get("mobile");
		
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, "", mobile, mobile, email, email);

		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("lastnamejs"))).getText(),
				BathroomXpathlocators.jsLookup.get("lastname"));
	}

	@Test(groups={"regression"},enabled = true)
	public void testContactPagePhoneNumberNotEntered() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.replacePathFirstPage();
		underTest.additionalInfoPage(5, BathroomXpathlocators.dataLookup.get("postcode"));
		underTest.thirdPage("Under £8,000");
		
		String firstName = BathroomXpathlocators.dataLookup.get("fname");
		String lastName = BathroomXpathlocators.dataLookup.get("lname");
		String email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
		
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, "", "", email, email);

		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("phonenumberjs"))).getText(),
				BathroomXpathlocators.jsLookup.get("phonenumber"));
	}

	@Test(groups={"regression"},enabled = true)
	public void testContactPageEmailNotEntered() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.replacePathFirstPage();
		underTest.additionalInfoPage(5, BathroomXpathlocators.dataLookup.get("postcode"));
		underTest.thirdPage("Under £8,000");
		
		String firstName = BathroomXpathlocators.dataLookup.get("fname");
		String lastName = BathroomXpathlocators.dataLookup.get("lname");
		String mobile = BathroomXpathlocators.dataLookup.get("mobile");
		
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, mobile, mobile, "", "");

		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("emailjs"))).getText(),
				BathroomXpathlocators.jsLookup.get("email"));
	}
	
	@Test(groups={"regression"},enabled = true)
	public void testContactPageConfirmPhoneNumberNotEntered() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.replacePathFirstPage();
		underTest.additionalInfoPage(5, BathroomXpathlocators.dataLookup.get("postcode"));
		underTest.thirdPage("Under £8,000");
		
		String firstName = BathroomXpathlocators.dataLookup.get("fname");
		String lastName = BathroomXpathlocators.dataLookup.get("lname");
		String email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
		String mobile = BathroomXpathlocators.dataLookup.get("mobile");
		
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, mobile, "", email, email);
		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("confirmphonenumberjs"))).getText(),
				BathroomXpathlocators.jsLookup.get("confirmphonenumber"));
	}

	@Test(groups={"regression"},enabled = true)
	public void testContactPageConfirmPhoneNumberDifferent() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.replacePathFirstPage();
		underTest.additionalInfoPage(5, BathroomXpathlocators.dataLookup.get("postcode"));
		underTest.thirdPage("Under £8,000");
		
		String firstName = BathroomXpathlocators.dataLookup.get("fname");
		String lastName = BathroomXpathlocators.dataLookup.get("lname");
		String email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
		String mobile = BathroomXpathlocators.dataLookup.get("mobile");
		String mobileDifferent = BathroomXpathlocators.dataLookup.get("mobileDifferent");
		
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, mobile, mobileDifferent, email, email);
		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("confirmphonenumberjs"))).getText(),
				BathroomXpathlocators.jsLookup.get("phonenumbermismatch"));
	}

	@Test(groups={"regression"},enabled = true)
	public void testContactPageConfirmEmailDifferent() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.replacePathFirstPage();
		underTest.additionalInfoPage(5, BathroomXpathlocators.dataLookup.get("postcode"));
		underTest.thirdPage("Under £8,000");
		
		String firstName = BathroomXpathlocators.dataLookup.get("fname");
		String lastName = BathroomXpathlocators.dataLookup.get("lname");
		String email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
		String mobile = BathroomXpathlocators.dataLookup.get("mobile");
		
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, mobile, mobile, email, "hello@ratedpeople.com");
		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("confirmemailjs"))).getText(),
				BathroomXpathlocators.jsLookup.get("emailmismatch"));
	}

	@Test(groups={"regression"},enabled = true)
	public void testContactPageConfirmEmailNotEntered() throws Exception {
		underTest.jobDetailsPage("radioInstall");
		underTest.replacePathFirstPage();
		underTest.additionalInfoPage(5, BathroomXpathlocators.dataLookup.get("postcode"));
		underTest.thirdPage("Under £8,000");
		
		String firstName = BathroomXpathlocators.dataLookup.get("fname");
		String lastName = BathroomXpathlocators.dataLookup.get("lname");
		String email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
		String mobile = BathroomXpathlocators.dataLookup.get("mobile");
		
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, mobile, mobile, email, "");
		assertEquals(context.driver.findElement(By.xpath(BathroomXpathlocators.xpathLookup.get("confirmemailjs"))).getText(),
				BathroomXpathlocators.jsLookup.get("confirmemail"));
	}

}
