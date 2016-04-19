package uk.co.ratedpeople.test.functional.selenium.newjobforms.plumbing;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.JobformTestBudgetUtils;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.JobformTestContactDetailsUtils;

@SuppressWarnings("unused")
public class PostJobViaPlumbingJobFormNegativeTestForSomethingElse extends TestScript {

	private static final String SELECT_TIMING = "selectTiming";
	private static final String NEXT = PostingJobViaPlumbingJobForms.NEXT;
	private static final String ENTER_DETAILS_ABOUT_JOB = "enterDetailsAboutJob";

	private static final String RP99RP = "rp99rp";
	private WebDriver driver;
	private TestScriptUtilities testScriptUtilities;
	public static Logger logger = Logger
			.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.PostJobViaPlumbingJobFormNegativeTestForSomethingElse");
	private PostingJobViaPlumbingJobForms underTest;
	private JobformTestBudgetUtils jobformTestBudgetUtils;
	private JobformTestContactDetailsUtils jobformTestContactDetailsUtils;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaPlumbingJobForms(scriptUtilities, context, context.getTestUrl());
		jobformTestBudgetUtils = new JobformTestBudgetUtils();
		jobformTestContactDetailsUtils = new JobformTestContactDetailsUtils();
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormSomethingElse_Page2_TimingNotSelected() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectSomethingElse();
		// timing is not selected
		// underTest.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), PostingJobViaPlumbingJobForms.getRandomNumber(6));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='timing' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(SELECT_TIMING));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormSomethingElse_Page2_NoDescriptionEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectSomethingElse();

		// no description entered
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		// underTest.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"),"selenium" + PostingJobViaPlumbingJobForms.getRandomString(3));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='freeTextAnswer[27][240]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(ENTER_DETAILS_ABOUT_JOB));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormSomethingElse_Page2_DescriptionTooShort() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectSomethingElse();

		// description too short
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtilities.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "a");
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='freeTextAnswer[27][240]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get("enterAtLeast30Chars"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormSomethingElse_Page2_NothingSelectedOrEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectSomethingElse();

		// nothing selected or entered
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='timing' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(SELECT_TIMING));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='freeTextAnswer[27][240]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(ENTER_DETAILS_ABOUT_JOB));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormSomethingElse_Page3_NoBudgetSelected() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectSomethingElse();
		underTest.additionalInfoSomethingElse(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("somethingelsintent"),
				Xpathlocators.xpathLookup.get("somethingelsownership"));

		jobformTestBudgetUtils.noBudgetSelected(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormSomethingElse_Page3_NoBudgetEnteredWhenOtherSelected() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectSomethingElse();

		underTest.additionalInfoSomethingElse(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("somethingelsintent"),
				Xpathlocators.xpathLookup.get("somethingelsownership"));

		jobformTestBudgetUtils.noBudgetEnteredWhenOtherSelected(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormSomethingElse_Page3_NegativeBudgetEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectSomethingElse();

		underTest.additionalInfoSomethingElse(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("somethingelsintent"),
				Xpathlocators.xpathLookup.get("somethingelsownership"));

		jobformTestBudgetUtils.negativeBudgetEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormSomethingElse_Page4_NoFirstNameEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectSomethingElse();

		underTest.additionalInfoSomethingElse(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("somethingelsintent"),
				Xpathlocators.xpathLookup.get("somethingelsownership"));
		selectBudget();

		// no first name
		jobformTestContactDetailsUtils.noFirstNameEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormSomethingElse_Page4_NoLastNameEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectSomethingElse();

		underTest.additionalInfoSomethingElse(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("somethingelsintent"),
				Xpathlocators.xpathLookup.get("somethingelsownership"));
		selectBudget();

		// no last name
		jobformTestContactDetailsUtils.noLastNameEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormSomethingElse_Page4_NoPhoneNumberEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectSomethingElse();

		underTest.additionalInfoSomethingElse(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("somethingelsintent"),
				Xpathlocators.xpathLookup.get("somethingelsownership"));
		selectBudget();

		// no phone number
		jobformTestContactDetailsUtils.noPhoneNumberEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormSomethingElse_Page4_TooShortPhoneNumberEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectSomethingElse();

		underTest.additionalInfoSomethingElse(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("somethingelsintent"),
				Xpathlocators.xpathLookup.get("somethingelsownership"));
		selectBudget();

		// too short phone number
		jobformTestContactDetailsUtils.tooShortPhoneNumberEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormSomethingElse_Page4_NoEmailEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectSomethingElse();

		underTest.additionalInfoSomethingElse(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("somethingelsintent"),
				Xpathlocators.xpathLookup.get("somethingelsownership"));
		selectBudget();

		// no email
		jobformTestContactDetailsUtils.noEmailEntered(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormSomethingElse_Page4_InvalidEmailEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectSomethingElse();

		underTest.additionalInfoSomethingElse(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("somethingelsintent"),
				Xpathlocators.xpathLookup.get("somethingelsownership"));
		selectBudget();

		// invalid email
		jobformTestContactDetailsUtils.invalidEmailEntered(this);
	}

	private void selectSomethingElse() {
		// select repair first and then install so as to force the continue button to appear
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("repair")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("somethingelse")));
		WebDriverWait waitforcontinue = new WebDriverWait(context.driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
	}

	private void selectBudget() {
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("budget")), 9);
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("nextstage3")));
	}
}
