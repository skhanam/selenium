package uk.co.ratedpeople.test.functional.selenium.newjobforms.generic;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.JobformTestBudgetUtils;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.JobformTestContactDetailsUtils;

/**
 * @author shabana.khanam
 */
public class PostingJobviaGenericJobformTest extends TestScript {
	private PostingJobviaGenericJobForm underTest;
	private JobformTestBudgetUtils jobformTestBudgetUtils;
	private JobformTestContactDetailsUtils jobformTestContactDetailsUtils;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobviaGenericJobForm(context, scriptUtilities);
		jobformTestBudgetUtils = new JobformTestBudgetUtils();
		jobformTestContactDetailsUtils = new JobformTestContactDetailsUtils();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaNewGenericJobformTest() throws Exception {
		underTest.postingJobviaNewGenericJobform();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaNewGenericJobformLocalTest() throws Exception {
		underTest.postingJobviaNewGenericJobformLocal();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaNewGenericJobformDotComTest() throws Exception {
		underTest.postingJobviaNewGenericJobformDotCom();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaNewGenericJobform_BudgetPage_NoBudgetSelectedTest() throws Exception {
		underTest.postingJobviaGenericJobBudgetValidation();
		jobformTestBudgetUtils.noBudgetSelected(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaNewGenericJobform_ContactPage_NoFnameEnteredTest() throws Exception {
		underTest.postingJobviaGenericJobContactPageFnameValidation();
		jobformTestContactDetailsUtils.noFirstNameEntered(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaNewGenericJobform_ContactPage_NoLnameEnteredTest() throws Exception {
		underTest.postingJobviaGenericJobContactPageFnameValidation();
		jobformTestContactDetailsUtils.noLastNameEntered(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaNewGenericJobform_ContactPage_NoEmailEnteredTest() throws Exception {
		underTest.postingJobviaGenericJobContactPageFnameValidation();
		jobformTestContactDetailsUtils.noEmailEntered(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaNewGenericJobform_ContactPage_InvalidEmailEnteredTest() throws Exception {
		underTest.postingJobviaGenericJobContactPageFnameValidation();
		jobformTestContactDetailsUtils.invalidEmailEntered(this);
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaNewGenericJobform_ContactPage_NoPhoneNumberEnteredTest() throws Exception {
		underTest.postingJobviaGenericJobContactPageFnameValidation();
		jobformTestContactDetailsUtils.noPhoneNumberEntered(this);
	}
}
