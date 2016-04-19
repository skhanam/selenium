package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author craig.marcus
 */
public class LogoutTest extends TestScript {

	private Login tmLogin;
	private WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = context.driver;
		tmLogin = new Login(context);
		tmLogin.login();
	}

	@Test(enabled = true)
	public void logoutDirectlyFromNav() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		// open the nav bar
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-toggle"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-logout"))).click();
		assertEquals(driver.findElement(By.id("welcome-h2")).getText(), "Tradesman Login");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_login")));
	}

	@Test(enabled = true)
	public void logoutFromAccountDetailsLinkInNav() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		// open the nav bar
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-toggle"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-account-details"))).click();
		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Account Details");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link-logout"))).click();
		assertEquals(driver.findElement(By.id("welcome-h2")).getText(), "Tradesman Login");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_login")));
	}

	@Test(enabled = true)
	public void cantAccessAppWithoutLoggingInFollowingLogout() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-toggle"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-logout"))).click();
		// attempt to go to job alerts. we expect to be redirected to login page
		driver.get(context.getTestHttpsTMMobileURL() + "/job-alerts");
		assertEquals(driver.findElement(By.id("welcome-h2")).getText(), "Tradesman Login");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_login")));
	}
}
