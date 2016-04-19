package uk.co.ratedpeople.test.functional.selenium.ho.job.updating;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * Helper Actions used for the selenium test {@link JobUpdateViaLoginTest}
 * 
 * @author abhiuday.tomar
 * 
 */
public class HomeownerJobUpdateActions extends TestScriptUtilities {

	protected TestScriptUtilities scriptUtilities;
	private static final String DOUBLECHEKYOURBUDGETJOBCATEGORYANDCONTACTDETAILS_XPATH = ".//*[@id='jobUpdatePage']/section[2]/div/h3";
	private static final String DOUBLECHEKYOURBUDGETJOBCATEGORYANDCONTACTDETAILS_TEXT = "Double-check your budget, job category and contact details";
	private static final String RANDOMTEXT_XPATH = ".//*[@id='jobUpdatePage']/section[2]/div/p[1]";
	private static final String RANDOM_TEXT = "It can be hard to tell what makes a job look most appealing to a tradesman, but generally, the more detail the better.";
	private WebDriver driver;
	
	public HomeownerJobUpdateActions(SeleniumTestContext context) {
		super(context);
	}

	public void login(String userName, String password, String url) {
		goTo(context.getTestHttpsUrl() + url);
		fillInTextField("hoUserName", userName);
		sleep(3000);
		fillInTextField("hoPassword", password);
		sleep(3000);
		click(By.id("login-as-ho-button"));
		sleep(3000);
		driver = context.driver;
	}

	public void updateJob(String jobRef) {
		clickOnJobWithRef(jobRef);
		addMoreDescription();
		changeBudget();
		changeCategory();
		changeContatDetails();
		assertTextWhileUpadting();
		submitChangedDetails();
	}

	public void verifyUpdateJob() {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[2]/div/div[1]/section/h1")));
		//String submissionMsg = findElement(By.xpath("//html/body/div[2]/div/div[1]/section/h1")).getText();
		//Assert.assertTrue(submissionMsg.contains("Thank you for updating your job"));
		assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/section/h1")).getText(), "Thank you for updating your job");
	}

	private void clickOnJobWithRef(String jobRef) {
		WebDriverWait wait = new WebDriverWait(context.driver, 10);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Security Fencing")));
		click(By.partialLinkText("Security Fencing"));
		// click(By.partialLinkText("(Ref #"+jobRef+") Summary for test job"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[2]/div/div/section[2]/div/div/a")));
		click(By.xpath("//html/body/div[2]/div/div/section[2]/div/div/a"));

	}

	private void changeBudget() {
		selectDropdown(By.id("JobUpdate_budgetCode"), 3);
	}

	private void addMoreDescription() {
		WebDriverWait wait = new WebDriverWait(context.driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("JobUpdate_description")));
		fillInTextField("JobUpdate_description", "This is selenium test description.So adding more description ");
	}

	private void changeCategory() {
		click(By.id("change-category"));
		selectDropdown(By.id("JobUpdate_specialisationCode"), 1);
		sleep(2000);
		selectDropdown(By.id("JobUpdate_skillTypeID"), 1);
	}

	private void changeContatDetails() {
		WebDriverWait wait = new WebDriverWait(context.driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("change-details")));
		sleep(2000);
		click(By.id("change-details"));
		sleep(3000);
		fillInTextField("JobUpdate_firstName", "changed");
	}

	private void submitChangedDetails() {
		click(By.xpath(".//*[@id='updateLead']"));
		sleep(3000);
	}

	private void assertTextWhileUpadting() {
		assertEquals(context.driver.findElement(By.xpath(DOUBLECHEKYOURBUDGETJOBCATEGORYANDCONTACTDETAILS_XPATH)).getText(),
				DOUBLECHEKYOURBUDGETJOBCATEGORYANDCONTACTDETAILS_TEXT);
		assertEquals(context.driver.findElement(By.xpath(RANDOMTEXT_XPATH)).getText(), RANDOM_TEXT);
	}

}
