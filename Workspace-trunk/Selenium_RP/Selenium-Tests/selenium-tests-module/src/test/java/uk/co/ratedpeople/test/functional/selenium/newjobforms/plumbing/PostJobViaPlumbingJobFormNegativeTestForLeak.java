package uk.co.ratedpeople.test.functional.selenium.newjobforms.plumbing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.JobformTestBudgetUtils;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.JobformTestContactDetailsUtils;

public class PostJobViaPlumbingJobFormNegativeTestForLeak extends TestScript {

	private static final String SELECT_TIMING = "selectTiming";
	private static final String NEXT = PostingJobViaPlumbingJobForms.NEXT;
	private static final String NEXT_DESC_LEAK = "nextDescLeak";
	private static final String ENTER_DETAILS_ABOUT_JOB = "enterDetailsAboutJob";
	private static final String SELECT_AN_OPTION = "selectAnOption";
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
	public void postingJobViaPlumbingJobFormLeak_Page1_WhereIsLeakOccurringNotAnswered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_LEAK)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='multipleAnswer[18][]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get("selectAtLeastOne"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormLeak_Page1_WhereIsLeakOccurringOtherSelectedButNoAdditionalInfo() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("lother")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_LEAK)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='leakOtherText' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get("leakOther"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormLeak_Page2_IsVisibleNotAnswered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		selectWhereLeakIsOccurring();

		// visibility is not selected
		// scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("visibletrue")));
		scriptUtilities.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "selenium" + TestScriptUtilities.getRandomString(3));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("accessibletrue")));
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='singleAnswer[19]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(SELECT_AN_OPTION));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormLeak_Page2_IsAccessibleNotAnswered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		selectWhereLeakIsOccurring();

		// accessibility is not selected
		// scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("accessibletrue")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("visibletrue")));
		scriptUtilities.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "selenium" + TestScriptUtilities.getRandomString(3));
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='singleAnswer[20]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(SELECT_AN_OPTION));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormLeak_Page2_TimingNotSelected() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		selectWhereLeakIsOccurring();

		// timing is not selected
		// underTest.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), PostingJobViaPlumbingJobForms.getRandomNumber(6));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("accessibletrue")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("visibletrue")));
		scriptUtilities.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "selenium" + TestScriptUtilities.getRandomString(3));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='timing' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(SELECT_TIMING));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormLeak_Page2_NoDescriptionEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		selectWhereLeakIsOccurring();

		// no description entered
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("accessibletrue")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("visibletrue")));
		// underTest.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"),"selenium" + PostingJobViaPlumbingJobForms.getRandomString(3));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='freeTextAnswer[27][184]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(ENTER_DETAILS_ABOUT_JOB));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormLeak_Page2_DescriptionTooShort() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		selectWhereLeakIsOccurring();

		// description too short
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("accessibletrue")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("visibletrue")));
		scriptUtilities.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "a");
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='freeTextAnswer[27][184]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get("enterAtLeast5Chars"));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormLeak_Page2_NothingSelectedOrEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		selectWhereLeakIsOccurring();

		// nothing selected or entered
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='singleAnswer[19]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(SELECT_AN_OPTION));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='singleAnswer[20]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(SELECT_AN_OPTION));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='timing' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(SELECT_TIMING));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='freeTextAnswer[27][184]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(ENTER_DETAILS_ABOUT_JOB));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormLeak_Page3_NoBudgetSelected() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		selectWhereLeakIsOccurring();

		underTest.additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		jobformTestBudgetUtils.noBudgetSelected(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormLeak_Page3_NoBudgetEnteredWhenOtherSelected() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		selectWhereLeakIsOccurring();
		underTest.additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));

		jobformTestBudgetUtils.noBudgetEnteredWhenOtherSelected(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormLeak_Page3_NegativeBudgetEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		selectWhereLeakIsOccurring();
		underTest.additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));

		jobformTestBudgetUtils.negativeBudgetEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormLeak_Page4_NoFirstNameEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		selectWhereLeakIsOccurring();
		underTest.additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		selectBudget();

		// no first name
		jobformTestContactDetailsUtils.noFirstNameEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormLeak_Page4_NoLastNameEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		selectWhereLeakIsOccurring();
		underTest.additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		selectBudget();

		// no last name
		jobformTestContactDetailsUtils.noLastNameEntered(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormLeak_Page4_NoPhoneNumberEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		selectWhereLeakIsOccurring();
		underTest.additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		selectBudget();

		// no phone number
		jobformTestContactDetailsUtils.noPhoneNumberEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormLeak_Page4_TooShortPhoneNumberEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		selectWhereLeakIsOccurring();
		underTest.additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		selectBudget();

		// too short phone number
		jobformTestContactDetailsUtils.tooShortPhoneNumberEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormLeak_Page4_NoEmailEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		selectWhereLeakIsOccurring();
		underTest.additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		selectBudget();

		// no email
		jobformTestContactDetailsUtils.noEmailEntered(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormLeak_Page4_InvalidEmailEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectLeak();
		selectWhereLeakIsOccurring();
		underTest.additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		selectBudget();

		// invalid email
		jobformTestContactDetailsUtils.invalidEmailEntered(this);
	}

	private void selectLeak() {
		// select repair first and then install so as to force the continue button to appear
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("repair")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("leak")));
		WebDriverWait waitforcontinue = new WebDriverWait(context.driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(context.driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
	}

	private void selectWhereLeakIsOccurring() {
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("ltank")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_LEAK)));
		// wait until we go to the second page - additional details
		WebDriverWait waitforAddInfo = new WebDriverWait(context.driver, 10);
		waitforAddInfo.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("additionalInfo"))));
	}

	private void selectBudget() {
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("budget")), 9);
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("nextstage3")));
	}
}
