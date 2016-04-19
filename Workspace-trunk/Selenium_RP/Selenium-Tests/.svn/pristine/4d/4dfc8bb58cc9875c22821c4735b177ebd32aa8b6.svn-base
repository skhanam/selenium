package uk.co.ratedpeople.test.functional.selenium.updatejob;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.coresystems.mail.MailXpathlocators;
import uk.co.ratedpeople.test.functional.selenium.coresystems.pricing.PriceJobBySkill;
import uk.co.ratedpeople.test.functional.selenium.coresystems.pricing.PricingXpathlocators;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;
import uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE.SignUpVariant_E_AndCheckTariffAndSkill;

public class UpdateExistingJob extends TestScriptUtilities {

	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtilities;
	public static Logger logger = Logger.getLogger(SignUpVariant_E_AndCheckTariffAndSkill.class.getName());
	private PriceJobBySkill underTest;
	private String userName = "sangiho@ratedtrades.com";
	private String password = "password";
	private String postcode = "RP99RP";

	public UpdateExistingJob(SeleniumTestContext context, TestScriptUtilities scriptUtilities) {

		super(context);
		this.scriptUtilities = scriptUtilities;
		new Login(scriptUtilities, context);
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.testUrl = testUrl.replaceAll("http://", "https://");
		new WebDriverWait(driver, 30);
		new Login(scriptUtilities, context);
		underTest = new PriceJobBySkill(context, scriptUtilities);
	}

	public void submitJobAsExistingCustomer() throws Exception {
		underTest.chooseTradePage1("locksmiths", "150");
		underTest.fillInPage2ForAdditionalInfo("statusREADY_TO_HIRE", "ownerOWN_AND_LIVE", "URGENTLY", "CF101BP",
				"Submit a job via selenium tests : Full regression testing .");
		location();
	}

	public void location() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("FIRST_NAME"))));
		scriptUtilities.fillInXpathField(PricingXpathlocators.xpathLookup.get("FIRST_NAME"), PricingXpathlocators.dataLookup.get("FIRST_NAME")
				+ TestScriptUtilities.getRandomString(3));
		scriptUtilities.fillInXpathField(PricingXpathlocators.xpathLookup.get("LAST_NAME"), PricingXpathlocators.dataLookup.get("LAST_NAME")
				+ TestScriptUtilities.getRandomString(3));
		scriptUtilities.fillInXpathField(PricingXpathlocators.xpathLookup.get("MOBILE"), PricingXpathlocators.dataLookup.get("MOBILE"));
		scriptUtilities.fillInXpathField(PricingXpathlocators.xpathLookup.get("EMAIL"), MailXpathlocators.dataLookup.get("HOEMAIL"));
		scriptUtilities.click(By.xpath(PricingXpathlocators.xpathLookup.get("POSTCODE")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("HEADER_THANKYOU"))));
		String getheaderText = scriptUtilities.getValue(PricingXpathlocators.xpathLookup.get("HEADER_THANKYOU"));
		assertEquals(getheaderText, "Thank you");
	}

	public void login(String userName, String password) {
		sleep(2000);
		goTo(context.getTestHttpsUrl() + "/log-in");
		sleep(3000);
		fillInTextField("hoUserName", userName);
		// sleep(3000);
		fillInTextField("hoPassword", password);
		// sleep(3000);
		click(By.id("login-as-ho-button"));
		sleep(3000);
		// fillInXpathField(".//*[@id='username']", userName);
		// sleep(3000);
		// fillInXpathField(".//*[@id='password']", password);
		// click(By.id("btn_login"));
	}

	public void loginToHomeownersApp(final String userName, final String password) {
		String httpsUrl = context.getTestHttpsUrl();
		String hoUrl = "";
		if (httpsUrl.indexOf("preprod") != -1) {
			hoUrl = "http://homeowners.preprod";
		} else if (httpsUrl.indexOf("tokyo") != -1) {
			hoUrl = "http://homeowners-tokyo.uk.ratedpeople";
		} else {
			fail("Invalid environment");
		}

		goTo(hoUrl + "/login");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		clear(By.id("username"));
		fillInTextField("username", userName);
		clear(By.id("password"));
		fillInTextField("password", password);

		click(By.id("btn_login"));
	}

	public String goToJobPage() {
		sleep(5000);
		click(By.xpath(".//*[@id='job-list']/li[1]/a/span[3]"));
		sleep(3000);
		String jobPageUrl = driver.getCurrentUrl();
		return jobPageUrl;
	}

	public void clickUpdateJob() {
		click(By.xpath("html/body/div[2]/div/div[1]/section[2]/div/div/a"));
		sleep(3000);
	}

	public String updateJobDescription(final String jobPageUrl, final String addToDescription) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("JobUpdate_description")));
		fillInTextField("JobUpdate_description", addToDescription);
		click(By.xpath(".//*[@id='form-update-job']/div[5]/button"));

		wait = new WebDriverWait(driver, 90);
		String pathToThankYouHeader = "html/body/div[2]/div/h1";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathToThankYouHeader)));
		String thankYouText = scriptUtilities.getValue(pathToThankYouHeader);
		assertEquals(thankYouText, "Thank you for updating your job");

		// go to my new job's page
		goToNewJobPage(jobPageUrl);
		wait = new WebDriverWait(driver, 90);
		String pathToDescription = "html/body/div[2]/div/div[1]/section[2]/div/div/p[3]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathToDescription)));
		String descriptionText = scriptUtilities.getValue(pathToDescription);
		return descriptionText;
	}

	public UpdatedJobDetails updatePostcode(final String jobPageUrl, final String postcode) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("change-details")));
		click(By.id("change-details"));
		clear(By.id("JobUpdate_postCode"));
		fillInTextField("JobUpdate_postCode", postcode);
		click(By.xpath(".//*[@id='form-update-job']/div[5]/button"));

		wait = new WebDriverWait(driver, 90);
		String pathToThankYouHeader = "html/body/div[2]/div/h1";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathToThankYouHeader)));
		String thankYouText = scriptUtilities.getValue(pathToThankYouHeader);
		assertEquals(thankYouText, "Thank you for updating your job");

		// go to my new job's page
		goToNewJobPage(jobPageUrl);
		wait = new WebDriverWait(driver, 90);
		String pathToDescription = "html/body/div[2]/div/div[1]/section[2]/div/div/p[3]";
		String pathToBudgetAndPostcode = "html/body/div[2]/div/div[1]/section[2]/div/div/p[2]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathToBudgetAndPostcode)));
		String budgetAndPostcodeText = scriptUtilities.getValue(pathToBudgetAndPostcode);
		String[] elements = budgetAndPostcodeText.split(",");
		String postcodeText = elements[1].trim();
		// the budgetAndPostcodeText line could contain an amount with or without a comma, e.g.
		// £100, SW1E 6AU
		// or
		// £1,000, SW1E 6AU
		if (elements.length == 3) {
			postcodeText = elements[2].trim();
		}
		String descriptionText = scriptUtilities.getValue(pathToDescription);
		UpdatedJobDetails ujd = new UpdatedJobDetails();
		ujd.setNewDescription(descriptionText);
		ujd.setNewPostcode(postcodeText);
		return ujd;
	}

	public UpdatedJobDetails updateSkillTypeId(final String jobPageUrl, final String skillTypeId, final String skillTypeName) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("change-category")));
		click(By.id("change-category"));
		driver.findElement(By.xpath(".//*[@id='JobUpdate_skillTypeID']/option[@value='" + skillTypeId + "']")).click();
		click(By.xpath(".//*[@id='form-update-job']/div[5]/button"));

		wait = new WebDriverWait(driver, 90);
		String pathToThankYouHeader = "html/body/div[2]/div/h1";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathToThankYouHeader)));
		String thankYouText = scriptUtilities.getValue(pathToThankYouHeader);
		assertEquals(thankYouText, "Thank you for updating your job");

		goToNewJobPage(jobPageUrl);
		wait = new WebDriverWait(driver, 90);
		String pathToDescription = "html/body/div[2]/div/div[1]/section[2]/div/div/p[3]";
		String pathToCategory = "html/body/div[2]/div/div[1]/section[2]/div/div/h3";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathToCategory)));
		String categoryText = scriptUtilities.getValue(pathToCategory);
		String descriptionText = scriptUtilities.getValue(pathToDescription);
		UpdatedJobDetails ujd = new UpdatedJobDetails();
		ujd.setNewDescription(descriptionText);
		ujd.setNewCategory(categoryText);
		return ujd;
	}

	public UpdatedJobDetails updateBudget(final String jobPageUrl, final String newBudget) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		String xpathSubmitButton = ".//*[@id='form-update-job']/div[5]/button";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathSubmitButton)));
		WebElement budgetEntry = driver.findElement(By.xpath(".//*[@id='JobUpdate_budgetCode']/option[@value='" + newBudget + "']"));
		budgetEntry.click();
		click(By.xpath(xpathSubmitButton));

		wait = new WebDriverWait(driver, 90);
		String pathToThankYouHeader = "html/body/div[2]/div/h1";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathToThankYouHeader)));
		String thankYouText = scriptUtilities.getValue(pathToThankYouHeader);
		assertEquals(thankYouText, "Thank you for updating your job");

		goToNewJobPage(jobPageUrl);
		wait = new WebDriverWait(driver, 90);
		String pathToDescription = "html/body/div[2]/div/div[1]/section[2]/div/div/p[3]";
		String pathToBudgetAndPostcode = "html/body/div[2]/div/div[1]/section[2]/div/div/p[2]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathToBudgetAndPostcode)));
		String budgetAndPostcodeText = scriptUtilities.getValue(pathToBudgetAndPostcode);
		String[] elements = budgetAndPostcodeText.split(",");
		String budgetText = elements[0].trim();
		String descriptionText = scriptUtilities.getValue(pathToDescription);
		// the budgetAndPostcodeText line could contain an amount with or without a comma, e.g.
		// £100, SW1E 6AU
		// or
		// £1,000, SW1E 6AU
		if (elements.length > 2) {
			budgetText += "," + elements[1].trim();
		}
		UpdatedJobDetails ujd = new UpdatedJobDetails();
		ujd.setNewDescription(descriptionText);
		ujd.setNewBudget(budgetText);
		return ujd;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getPostcode() {
		return postcode;
	}

	private void goToNewJobPage(final String jobPageUrl) {
		Integer oldJobId = Integer.parseInt(jobPageUrl.substring(jobPageUrl.lastIndexOf('/') + 1));
		Integer newJobId = oldJobId + 1;
		String jobPageUrlPrefix = jobPageUrl.substring(0, jobPageUrl.lastIndexOf('/'));
		goTo(jobPageUrlPrefix + "/" + newJobId);
	}
}
