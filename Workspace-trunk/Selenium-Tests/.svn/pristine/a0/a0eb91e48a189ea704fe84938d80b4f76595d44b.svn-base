package uk.co.ratedpeople.test.functional.selenium.functions;

import static org.testng.Assert.assertEquals;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class SubmitJobAsNewCustomer {
	private Login login;
	public String password;
	private TestScriptUtilities scriptUtils;
	private SeleniumTestContext context;
	private UniqueEmailAddressGenerator uniqueEmailAddressGenerator;

	public SubmitJobAsNewCustomer(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		this.context = context;
		login = new Login(scriptUtils, context);
		uniqueEmailAddressGenerator = new UniqueEmailAddressGenerator();
	}

	public void submitJobAsNewCustomer(String testUrl) throws Exception {
		scriptUtils.goTo(testUrl);

		scriptUtils.sleep(4000);
		submitJobWidgetPageOne();
		scriptUtils.sleep(3000);
		submitJobWidgetPageTwo(null);
	}
	
	public void submitJobAsNewCustomerWithEmail(String testUrl, String email) throws Exception {
		scriptUtils.goTo(testUrl);

		scriptUtils.sleep(4000);
		submitJobWidgetPageOne();
		
		submitJobWidgetPageTwo(email);
	}
	

	public void submitJobNewCustomerMobile(String testUrl) throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 10);
		scriptUtils.goTo(testUrl);
		scriptUtils.sleep(4000);
		submitJobWidgetPageOne();
		String uniqueEmailAccountName = submitJobWidgetPageTwo(null);

		login.login(context.getAdminCredentials());

		// Update Lucene to find new customer from Support area.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.linkText("ADMIN")));
		scriptUtils.click(By.linkText("ADMIN"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.linkText("LUCENE INFO")));
		scriptUtils.click(By.linkText("LUCENE INFO"));
		scriptUtils.click("info_update index");

		// Open Support area to extract password and email validation URL
		scriptUtils.goTo(testUrl + "/supportN/member/search");
		scriptUtils.fillInXpathField(".//*[@id='search_search']", uniqueEmailAccountName);
		scriptUtils.click("search_0");
		scriptUtils.sleep(5000);
		scriptUtils.click(By.linkText("Jobs"));
		scriptUtils.sleep(2000);
		scriptUtils.click("detail_0");
		scriptUtils.sleep(3000);
		context.driver.findElement(By
				.xpath("//img[@src='/img/jobBar/customer/REQUESTING.gif']"));
	}

	public void submitJobNewCustomerWithdraw(String testUrl) throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 10);
		scriptUtils.goTo(testUrl);
		scriptUtils.sleep(4000);
		submitJobWidgetPageOne();
		String uniqueEmailAccountName = submitJobWidgetPageTwo(null);

		login.login(context.getAdminCredentials());

		// Update Lucene to find new customer from Support area.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.linkText("ADMIN")));
		scriptUtils.click(By.linkText("ADMIN"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("LUCENE INFO")));
		scriptUtils.click(By.linkText("LUCENE INFO"));
		scriptUtils.click("info_update index");
		scriptUtils.sleep(5000);
		scriptUtils.goTo(testUrl + "/supportN/member/search");
		scriptUtils.sleep(5000);
		scriptUtils.fillInXpathField(".//*[@id='search_search']", uniqueEmailAccountName);
		scriptUtils.click("search_0");
		scriptUtils.sleep(5000);
		scriptUtils.click(By.linkText("Jobs"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("detail_0")));
		scriptUtils.sleep(5000);
		scriptUtils.click("detail_0");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//img[@src='/img/jobBar/customer/REQUESTING.gif']")));
		context.driver.findElement(By
				.xpath("//img[@src='/img/jobBar/customer/REQUESTING.gif']"));

		scriptUtils.click("detail__withdrawJob");
		scriptUtils.sleep(3000);
		context.driver.switchTo().alert().accept();
		scriptUtils.sleep(3000);

	}

	private void submitJobWidgetPageOne() {
		scriptUtils.sleep(2000);
		scriptUtils.selectDropdown("trade", 1);
		scriptUtils.sleep(2000);
		scriptUtils.selectDropdown("jobtype", 1);
		scriptUtils.click("btn-next-step");
	}

	/**
	 * 
	 * @return unique email account name for new customer
	 */
	private String submitJobWidgetPageTwo(String email) {
		scriptUtils.click("statusREADY_TO_HIRE");
		scriptUtils.click("ownerOWN_AND_LIVE");
		scriptUtils.selectDropdown("timing", 1);
		scriptUtils.fillInTextField("postcode", "SW5 9QA");
		scriptUtils.fillInXpathField(".//*[@id='additionalDetailsContainer']/textarea", "TEST TEXT TEST TEXT TEST TEXT TEST TEXT TEST TEXT TEST TEXT TEST TEXT TEST TEXT");
		scriptUtils.findElement(By.xpath(".//*[@id='stage2']/div[6]/div/button[1]")).click();
		scriptUtils.selectDropdown("jobBudgetCode", 1);
		scriptUtils.findElement(By.xpath(".//*[@id='stage3']/div[2]/div/button[1]")).click();
		scriptUtils.fillInTextField("firstName", "sangeetha");
		scriptUtils.fillInTextField("lastName", "kumar");
		scriptUtils.fillInTextField("mobilePhone", "07700900003");
		scriptUtils.fillInTextField("confirmPhone", "07700900003");
		
		
		if(StringUtils.isBlank(email)) {
			email = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		}
		
		scriptUtils.fillInTextField("email", email);
		System.out.println("Email: " + email);
		scriptUtils.fillInTextField("confirmEmail", email);
		scriptUtils.click("btnPostJob");
		scriptUtils.sleep(2000);
		scriptUtils.click("btnConfirmJob");
		scriptUtils.sleep(10000);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='header-h1']")).getText(),"Thank you");

		return email;
	}

	public void submitJobMicroSite(String testUrl) {
		WebDriverWait wait = new WebDriverWait(context.driver, 10);
		scriptUtils.goTo(testUrl + "/profile/integrationtest/request-a-quote");
		context.driver.switchTo().frame(0);
		scriptUtils.sleep(2000);
		scriptUtils.selectDropdown("Job_tradeId", 1);
		scriptUtils.sleep(2000);
		scriptUtils.selectDropdown("Job_jobTypeId", 1);
		scriptUtils.fillInTextField(
				"Job_description",
				"This is a test job title. This is a test job description.This is a test job description.");
		scriptUtils.selectDropdown("Job_jobStartDate", 2);
		scriptUtils.selectDropdown("Job_jobBudgetId", 2);
		scriptUtils.fillInTextField("Job_postcode", "SW1E6DR");
		scriptUtils.sleep(2000);
		scriptUtils.click("next");
		scriptUtils.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("Job_user_firstName")));
		scriptUtils.fillInTextField("Job_user_firstName", "firstname");
		scriptUtils.fillInTextField("Job_user_lastName", "Customer");
		scriptUtils.fillInTextField("Job_user_phoneNumber", "07700900003");
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		System.out.println("Email: " + uniqueEmailAccountName);
		scriptUtils.fillInTextField("Job_user_email", uniqueEmailAccountName);
		scriptUtils.click("submitBtn");
//		wait.until(ExpectedConditions.textToBePresentInElement(
//				By.cssSelector("h3.formHeader"), "Thank you"));

	}

	public String submitJobAsNewCustomerCheckMail() {


		scriptUtils.goTo(context.getTestUrl());
		scriptUtils.sleep(3000);
		scriptUtils.selectDropdown("trade", 10);
		scriptUtils.selectDropdown("jobtype",3);
		scriptUtils.click("btn-next-step");
		
		scriptUtils.click("statusREADY_TO_HIRE");
		scriptUtils.click("ownerOWN_AND_LIVE");
		scriptUtils.selectDropdown("timing", 1);
		scriptUtils.fillInTextField("postcode", "HA02LH");
		scriptUtils.clearAndFillInXpathField(".//*[@id='additionalDetailsContainer']/textarea", "Submit a job via selenium tests : Full regression testing .");
		scriptUtils.clickIfExists(By.xpath(".//*[@id='stage2']/div[6]/div/button[1]"));
		
		scriptUtils.selectDropdown("jobBudgetCode", 1);
		scriptUtils.clickIfExists(By.xpath(".//*[@id='stage3']/div[2]/div/button[1]"));
		
		scriptUtils.fillInTextField("firstName", "sangeetha");
		scriptUtils.fillInTextField("lastName", "kumar");
		scriptUtils.fillInTextField("mobilePhone", "07788990099");
		scriptUtils.fillInTextField("email", "seleniumho@ratedpeople.com");
		scriptUtils.click("btnPostJob");
		scriptUtils.sleep(2000);
		
		assertEquals(context.driver.findElement(By.id("header-h1")).getText(),"Thank you");
		System.out.println("Home owner Email : seleniumho@ratedpeople.com");
		
		return "";		
	}
}
