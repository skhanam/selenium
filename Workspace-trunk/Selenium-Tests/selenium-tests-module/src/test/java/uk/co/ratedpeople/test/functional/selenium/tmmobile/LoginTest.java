package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * 
 * @author swetha.morthala
 */
public class LoginTest extends TestScript {

	private Login tmLogin;
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		tmLogin = new Login(this.context);
		driver = context.driver;
	}

	@Test(enabled = false)
	public void testWithIntroductorySlides() {
		tmLogin.loginWithIntroductorySlides();
	}

	@Test(enabled = true) 
	public void testWithoutIntroductorySlides() {
		tmLogin.login();
	}

	@Test(enabled = true)
	public void testCantAccessAppOverHTTP() {
		tmLogin.login();
		// ensure we are requesting http://
		String jobAlertsOverHttp = context.getTestHttpsTMMobileURL() + "/job-alerts";
		jobAlertsOverHttp = jobAlertsOverHttp.replaceFirst("https", "http");
		assertEquals(jobAlertsOverHttp.substring(0, 7), "http://");

		driver.get(jobAlertsOverHttp);
		// ensure we are redirected to https://
		String currentUrl = driver.getCurrentUrl().replaceFirst("/app.php/", "/");
		assertEquals(currentUrl, "https://" + jobAlertsOverHttp.substring(7));
	}

	@Test(enabled = false)
	public void testRememberUsernameCookie() {
		tmLogin.login();
	}

	@Test(enabled = true)
	public void testCantAccessAppWithoutLogin() {

		driver.manage().deleteAllCookies();

		// attempt to go to job alerts. we expect to be redirected to login page
		driver.get(context.getTestHttpsTMMobileURL() + "/job-alerts");

		assertEquals(driver.findElement(By.id("welcome-h2")).getText(), "Tradesman Login");
		assertNotNull(driver.findElement(By.id("btn_login")));

		// do not match the protocol as we will be redirected to https page
		String defaultLoginPage = context.getTestHttpsTMMobileURL() + "/login";
		String currentUrlWithoutProtocol = driver.getCurrentUrl().substring(driver.getCurrentUrl().indexOf("://"));
		String defaultLoginPageUrl = defaultLoginPage.substring(defaultLoginPage.indexOf("://"));
		assertEquals(currentUrlWithoutProtocol, defaultLoginPageUrl);
	}
}