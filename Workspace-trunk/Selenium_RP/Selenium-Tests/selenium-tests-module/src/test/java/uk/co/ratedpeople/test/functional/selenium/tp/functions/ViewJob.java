package uk.co.ratedpeople.test.functional.selenium.tp.functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.SubmitJobAsNewCustomer;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class ViewJob {
	private Login login;
	private String testUrl;
	private TestScriptUtilities scriptUtils;
	private SeleniumTestContext context;
	private WebDriver driver;

	public ViewJob(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		this.context = context;
		login = new Login(scriptUtils,context);
		testUrl = context.getTestUrl();
		this.driver = context.driver;
	}

	public void viewJob() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 30);
		//SubmitJob as Existing customer
		submitJobAsExistingCustomer();
		//View job
		login.loginTP("aleksandr01jbilling@ratedtrades.com", "password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View full details")));		
		WebElement element = driver.findElement(By.linkText("View full details"));
		element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Buy")));
		driver.findElement(By.linkText("Buy"));
		}

	private void submitJobAsExistingCustomer() throws Exception {
		SubmitJobAsNewCustomer submitJob = new SubmitJobAsNewCustomer(context, scriptUtils);
		submitJob.submitJobAsNewCustomer(testUrl);		
	}
}