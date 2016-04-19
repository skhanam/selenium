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

public class PostJobViaPlumbingJobFormNegativeTestForReplace extends TestScript {

	private static final String READY_TO_HIRE = "readyToHire";
	private static final String SELECT_TIMING = "selectTiming";
	private static final String NEXT = PostingJobViaPlumbingJobForms.NEXT;
	private static final String NEXT_DESC_REPLACE = "nextDescReplace";
	private static final String ENTER_DETAILS_ABOUT_JOB = "enterDetailsAboutJob";
	private static final String RP99RP = "rp99rp";

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
	public void postingJobViaPlumbingJobFormReplace_Page1_WhatToReplaceNotAnswered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectReplace();
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_REPLACE)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='multipleAnswer[25][]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get("selectAtLeastOne"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormReplace_Page1_WhatToReplaceOtherSelectedButNoAdditionalInfo() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectReplace();
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("replother")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_REPLACE)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='replaceOtherText' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get("replaceOther"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormReplace_Page2_TimingNotSelected() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectReplace();
		selectWhatToReplace();

		// timing is not selected
		// underTest.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), PostingJobViaPlumbingJobForms.getRandomNumber(6));
		scriptUtilities.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "selenium" + TestScriptUtilities.getRandomString(3));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='timing' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(SELECT_TIMING));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormReplace_Page2_NoDescriptionEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectReplace();
		selectWhatToReplace();

		// no description entered
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		// underTest.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"),"selenium" + PostingJobViaPlumbingJobForms.getRandomString(3));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='freeTextAnswer[27][230]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(ENTER_DETAILS_ABOUT_JOB));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormReplace_Page2_DescriptionTooShort() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectReplace();
		selectWhatToReplace();

		// description too short
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtilities.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "a");
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='freeTextAnswer[27][230]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get("enterAtLeast20Chars"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormReplace_Page2_NothingSelectedOrEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectReplace();
		selectWhatToReplace();

		// nothing selected or entered
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='timing' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(SELECT_TIMING));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='freeTextAnswer[27][230]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(ENTER_DETAILS_ABOUT_JOB));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormReplace_Page3_NoBudgetSelected() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectReplace();
		selectWhatToReplace();
		enterAdditionalInfoForReplace();

		jobformTestBudgetUtils.noBudgetSelected(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormReplace_Page3_NoBudgetEnteredWhenOtherSelected() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectReplace();
		selectWhatToReplace();
		enterAdditionalInfoForReplace();

		jobformTestBudgetUtils.noBudgetEnteredWhenOtherSelected(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormReplace_Page3_NegativeBudgetEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectReplace();
		selectWhatToReplace();
		underTest.additionalInfoSomethingElse(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("somethingelsintent"),
				Xpathlocators.xpathLookup.get("somethingelsownership"));
		jobformTestBudgetUtils.negativeBudgetEntered(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormReplace_Page4_NoFirstNameEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectReplace();
		selectWhatToReplace();
		enterAdditionalInfoForReplace();
		selectBudget();

		// no first name
		jobformTestContactDetailsUtils.noFirstNameEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormReplace_Page4_NoLastNameEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectReplace();
		selectWhatToReplace();
		enterAdditionalInfoForReplace();
		selectBudget();

		// no last name
		jobformTestContactDetailsUtils.noLastNameEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormReplace_Page4_NoPhoneNumberEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectReplace();
		selectWhatToReplace();
		enterAdditionalInfoForReplace();
		selectBudget();

		// no phone number
		jobformTestContactDetailsUtils.noPhoneNumberEntered(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormReplace_Page4_TooShortPhoneNumberEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectReplace();
		selectWhatToReplace();
		enterAdditionalInfoForReplace();
		selectBudget();

		// too short phone number
		jobformTestContactDetailsUtils.tooShortPhoneNumberEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormReplace_Page4_NoEmailEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectReplace();
		selectWhatToReplace();
		enterAdditionalInfoForReplace();
		selectBudget();

		// no email
		jobformTestContactDetailsUtils.noEmailEntered(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormReplace_Page4_InvalidEmailEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectReplace();
		selectWhatToReplace();
		enterAdditionalInfoForReplace();
		selectBudget();

		// invalid email
		jobformTestContactDetailsUtils.invalidEmailEntered(this);
	}

	private void selectReplace() {
		// select repair first and then install so as to force the continue button to appear
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("repair")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("replace")));
		WebDriverWait waitforcontinue = new WebDriverWait(context.driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(context.driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
	}

	private void selectWhatToReplace() {
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("replboiler")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_REPLACE)));
		// wait until we go to the second page - additional details
		WebDriverWait waitforAddInfo = new WebDriverWait(context.driver, 10);
		waitforAddInfo.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("additionalInfo"))));
	}

	private void enterAdditionalInfoForReplace() throws Exception {
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtilities.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "selenium" + TestScriptUtilities.getRandomString(15));
		scriptUtilities.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("postcode"), RP99RP);
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(READY_TO_HIRE)));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("ownerLandlord")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
	}

	private void selectBudget() {
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("budget")), 9);
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("nextstage3")));
	}
}
