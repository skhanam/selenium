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

public class PostJobViaPlumbingJobFormNegativeTestForInstall extends TestScript {

	private static final String SELECT_TIMING = "selectTiming";
	private static final String NEXT = PostingJobViaPlumbingJobForms.NEXT;
	private static final String NEXT_DESC_INSTALL = "nextDescInstall";
	private static final String ENTER_DETAILS_ABOUT_JOB = "enterDetailsAboutJob";
	private static final String SELECT_AN_OPTION = "selectAnOption";
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

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormInstall_Page1_WhatToInstallNotAnswered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectInstall();
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_INSTALL)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='multipleAnswer[23][]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get("selectAtLeastOne"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormInstall_Page1_WhatToInstallOtherSelectedButNoAdditionalInfo() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectInstall();
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("insother")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_INSTALL)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='installOtherText' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get("installOther"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormInstall_Page2_IsAlreadyInPlaceNotAnswered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectInstall();
		selectWhereInstallIsNeeded();

		// is in place is not selected
		// scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("insplaceyes")));
		scriptUtilities.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "selenium" + TestScriptUtilities.getRandomString(3));
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtilities.fillInTextField("postcode", RP99RP);
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='singleAnswer[24]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(SELECT_AN_OPTION));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormInstall_Page2_TimingNotSelected() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectInstall();
		selectWhereInstallIsNeeded();

		// timing is not selected
		// scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("insplaceyes")));
		scriptUtilities.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "selenium" + TestScriptUtilities.getRandomString(3));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='timing' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(SELECT_TIMING));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormInstall_Page2_NoDescriptionEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectInstall();
		selectWhereInstallIsNeeded();

		// no description entered
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("insplaceyes")));
		underTest.intentownership(Xpathlocators.xpathLookup.get("insintent"), Xpathlocators.xpathLookup.get("insownership"));
		// underTest.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"),"selenium" + PostingJobViaPlumbingJobForms.getRandomString(3));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='freeTextAnswer[27][215]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(ENTER_DETAILS_ABOUT_JOB));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormInstall_Page2_DescriptionTooShort() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectInstall();
		selectWhereInstallIsNeeded();
		underTest.intentownership(Xpathlocators.xpathLookup.get("insintent"), Xpathlocators.xpathLookup.get("insownership"));
		// description too short
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("insplaceyes")));
		scriptUtilities.fillInTextField("postcode", Xpathlocators.dataLookup.get("postcode"));
		scriptUtilities.clearAndFillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "a");
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='freeTextAnswer[27][215]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get("enterAtLeast5Chars"));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormInstall_Page2_NothingSelectedOrEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectInstall();
		selectWhereInstallIsNeeded();

		// nothing selected or entered
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='singleAnswer[24]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(SELECT_AN_OPTION));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='timing' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(SELECT_TIMING));
		assertEquals(context.driver.findElement(By.xpath(".//label[@for='freeTextAnswer[27][215]' and @class='error']")).getText(),
				Xpathlocators.errorMessages.get(ENTER_DETAILS_ABOUT_JOB));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormInstall_Page3_NoBudgetSelected() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectInstall();
		selectWhereInstallIsNeeded();
		underTest.additionalInfoInstall(Xpathlocators.xpathLookup.get("insplacenotsure"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("insintent"), Xpathlocators.xpathLookup.get("insownership"));
		// enterAdditionalInfoForInstall();

		jobformTestBudgetUtils.noBudgetSelected(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormInstall_Page3_NoBudgetEnteredWhenOtherSelected() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectInstall();
		selectWhereInstallIsNeeded();
		underTest.additionalInfoInstall(Xpathlocators.xpathLookup.get("insplacenotsure"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("insintent"), Xpathlocators.xpathLookup.get("insownership"));

		jobformTestBudgetUtils.noBudgetEnteredWhenOtherSelected(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormInstall_Page3_NegativeBudgetEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectInstall();
		selectWhereInstallIsNeeded();
		// enterAdditionalInfoForInstall();
		underTest.additionalInfoInstall(Xpathlocators.xpathLookup.get("insplacenotsure"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("insintent"), Xpathlocators.xpathLookup.get("insownership"));

		jobformTestBudgetUtils.negativeBudgetEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormInstall_Page4_NoFirstNameEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectInstall();
		selectWhereInstallIsNeeded();
		// enterAdditionalInfoForInstall();
		underTest.additionalInfoInstall(Xpathlocators.xpathLookup.get("insplacenotsure"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("insintent"), Xpathlocators.xpathLookup.get("insownership"));
		selectBudget();

		// no first name
		jobformTestContactDetailsUtils.noFirstNameEntered(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormInstall_Page4_NoLastNameEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectInstall();
		selectWhereInstallIsNeeded();
		// enterAdditionalInfoForInstall();
		underTest.additionalInfoInstall(Xpathlocators.xpathLookup.get("insplacenotsure"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("insintent"), Xpathlocators.xpathLookup.get("insownership"));
		selectBudget();

		// no last name
		jobformTestContactDetailsUtils.noLastNameEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormInstall_Page4_NoPhoneNumberEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectInstall();
		selectWhereInstallIsNeeded();
		// enterAdditionalInfoForInstall();
		underTest.additionalInfoInstall(Xpathlocators.xpathLookup.get("insplacenotsure"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("insintent"), Xpathlocators.xpathLookup.get("insownership"));
		selectBudget();

		// no phone number
		jobformTestContactDetailsUtils.noPhoneNumberEntered(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormInstall_Page4_TooShortPhoneNumberEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectInstall();
		selectWhereInstallIsNeeded();
		// enterAdditionalInfoForInstall();
		underTest.additionalInfoInstall(Xpathlocators.xpathLookup.get("insplacenotsure"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("insintent"), Xpathlocators.xpathLookup.get("insownership"));
		selectBudget();

		// too short phone number
		jobformTestContactDetailsUtils.tooShortPhoneNumberEntered(this);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaPlumbingJobFormInstall_Page4_NoEmailEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectInstall();
		selectWhereInstallIsNeeded();
		// enterAdditionalInfoForInstall();
		underTest.additionalInfoInstall(Xpathlocators.xpathLookup.get("insplacenotsure"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("insintent"), Xpathlocators.xpathLookup.get("insownership"));
		selectBudget();

		// no email
		jobformTestContactDetailsUtils.noEmailEntered(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaPlumbingJobFormInstall_Page4_InvalidEmailEntered() throws Exception {
		underTest.getQuotesPlumbingRepairMaintenance();
		selectInstall();
		selectWhereInstallIsNeeded();
		// enterAdditionalInfoForInstall();
		underTest.additionalInfoInstall(Xpathlocators.xpathLookup.get("insplacenotsure"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("insintent"), Xpathlocators.xpathLookup.get("insownership"));
		selectBudget();

		// invalid email
		jobformTestContactDetailsUtils.invalidEmailEntered(this);
	}

	private void selectInstall() {
		// select repair first and then install so as to force the continue button to appear
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("repair")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("install")));
		WebDriverWait waitforcontinue = new WebDriverWait(context.driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(context.driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
	}

	private void selectWhereInstallIsNeeded() {
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("inswbasin")));
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_INSTALL)));
		// wait until we go to the second page - additional details
		WebDriverWait waitforAddInfo = new WebDriverWait(context.driver, 10);
		waitforAddInfo.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("additionalInfo"))));
	}

	private void selectBudget() {
		scriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("budget")), 9);
		scriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("nextstage3")));
	}
}
