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

public class PostJobViaPlumbingJobFormNegativeTestForBlockage extends TestScript {
	private static final String SELECT_TIMING = "selectTiming";
	private static final String NEXT = PostingJobViaPlumbingJobForms.NEXT;
	private static final String NEXT_DESC_BLOCKED = "nextDescBlocked";
	private static final String ENTER_DETAILS_ABOUT_JOB = "enterDetailsAboutJob";
	private PostingJobViaPlumbingJobForms underTest;
	private JobformTestBudgetUtils jobformTestBudgetUtils;
	private JobformTestContactDetailsUtils jobformTestContactDetailsUtils;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaPlumbingJobForms(scriptUtilities, context, context.getTestUrl());
		jobformTestBudgetUtils = new JobformTestBudgetUtils();
		jobformTestContactDetailsUtils = new JobformTestContactDetailsUtils();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormBlockage_Page1_WhatIsBlockedNotAnswered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectBlockage();
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_BLOCKED)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='multipleAnswer[26][]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get("selectAtLeastOne"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormBlockage_Page1_WhatIsBlockedOtherSelectedButNoAdditionalInfo() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectBlockage();
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("bother")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_BLOCKED)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='blockedOtherText' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get("blockageOther"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormBlockage_Page2_TimingNotSelected() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectBlockage();
		selectWhatIsBlocked();

		// timing is not selected
		// underTest.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), PostingJobViaPlumbingJobForms.getRandomNumber(6));
		scriptUtilities.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "selenium" + TestScriptUtilities.getRandomString(3));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='timing' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(SELECT_TIMING));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormBlockage_Page2_NoDescriptionEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectBlockage();
		selectWhatIsBlocked();

		// no description entered
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		// underTest.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"),"selenium" + PostingJobViaPlumbingJobForms.getRandomString(3));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='freeTextAnswer[27][239]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(ENTER_DETAILS_ABOUT_JOB));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormBlockage_Page2_DescriptionTooShort() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectBlockage();
		selectWhatIsBlocked();

		// description too short
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtilities.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "a");
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='freeTextAnswer[27][239]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get("enterAtLeast20Chars"));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormBlockage_Page2_NothingSelectedOrEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectBlockage();
		selectWhatIsBlocked();

		// nothing selected or entered
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='timing' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(SELECT_TIMING));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='freeTextAnswer[27][239]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(ENTER_DETAILS_ABOUT_JOB));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormBlockage_Page3_NoBudgetSelected() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectBlockage();
		selectWhatIsBlocked();
		// enterAdditionalInfoForBlockage();
		underTest.additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("somethingelsintent"),
				Xpathlocators.xpathLookup.get("somethingelsownership"));

		jobformTestBudgetUtils.noBudgetSelected(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormBlockage_Page3_NoBudgetEnteredWhenOtherSelected() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectBlockage();
		selectWhatIsBlocked();
		// enterAdditionalInfoForBlockage();
		underTest.additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("somethingelsintent"),
				Xpathlocators.xpathLookup.get("somethingelsownership"));

		jobformTestBudgetUtils.noBudgetEnteredWhenOtherSelected(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormBlockage_Page3_NegativeBudgetEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectBlockage();
		selectWhatIsBlocked();

		// enterAdditionalInfoForBlockage();
		underTest.additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("somethingelsintent"),
				Xpathlocators.xpathLookup.get("somethingelsownership"));
		jobformTestBudgetUtils.negativeBudgetEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormBlockage_Page4_NoFirstNameEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectBlockage();
		selectWhatIsBlocked();
		// enterAdditionalInfoForBlockage();
		underTest.additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("bintent"),
				Xpathlocators.xpathLookup.get("bownership"));
		selectBudget();

		// no first name
		jobformTestContactDetailsUtils.noFirstNameEntered(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormBlockage_Page4_NoLastNameEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectBlockage();
		selectWhatIsBlocked();
		// enterAdditionalInfoForBlockage();
		underTest.additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("bintent"),
				Xpathlocators.xpathLookup.get("bownership"));
		selectBudget();

		// no last name
		jobformTestContactDetailsUtils.noLastNameEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormBlockage_Page4_NoPhoneNumberEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectBlockage();
		selectWhatIsBlocked();
		// enterAdditionalInfoForBlockage();
		underTest.additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("bintent"),
				Xpathlocators.xpathLookup.get("bownership"));
		selectBudget();

		// no phone number
		jobformTestContactDetailsUtils.noPhoneNumberEntered(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormBlockage_Page4_TooShortPhoneNumberEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectBlockage();
		selectWhatIsBlocked();
		// enterAdditionalInfoForBlockage();
		underTest.additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("bintent"),
				Xpathlocators.xpathLookup.get("bownership"));
		selectBudget();

		// too short phone number
		jobformTestContactDetailsUtils.tooShortPhoneNumberEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormBlockage_Page4_NoEmailEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectBlockage();
		selectWhatIsBlocked();
		// enterAdditionalInfoForBlockage();
		underTest.additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("bintent"),
				Xpathlocators.xpathLookup.get("bownership"));
		selectBudget();

		// no email
		jobformTestContactDetailsUtils.noEmailEntered(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormBlockage_Page4_InvalidEmailEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectBlockage();
		selectWhatIsBlocked();
		// enterAdditionalInfoForBlockage();
		underTest.additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("bintent"),
				Xpathlocators.xpathLookup.get("bownership"));
		selectBudget();

		// invalid email
		jobformTestContactDetailsUtils.invalidEmailEntered(this);
	}

	private void selectBlockage() {
		// select repair first and then install so as to force the continue button to appear
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("repair")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("blockage")));
		WebDriverWait waitforcontinue = new WebDriverWait(context.driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(context.driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
	}

	private void selectWhatIsBlocked() {
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("bbasin")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_BLOCKED)));
		// wait until we go to the second page - additional details
		WebDriverWait waitforAddInfo = new WebDriverWait(context.driver, 10);
		waitforAddInfo.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("additionalInfo"))));
	}

	private void selectBudget() {
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("budget")), 9);
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("nextstage3")));
	}
}
