package uk.co.ratedpeople.test.functional.selenium.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.httpclient.support.WebSiteCredentials;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class LoginToSupportTest extends TestScript {
	private String testUrl;
	private WebDriver driver;
	private Login login;

	@BeforeMethod
	public void setUp() {
		this.driver = this.context.driver;
		this.testUrl = this.context.getSupportUrl();
		this.login = new Login(scriptUtilities, this.context);
	}

	/**
	 * Test access to /support as an admin user. Should be fine and go straight through to MK3.
	 * @throws Exception 
	 */
	@Test
	public void testLoginToSupportAsAdmin() throws Exception {
		WebSiteCredentials webSiteCredentials = this.context.getAdminCredentials();
		this.login.loginSupport(webSiteCredentials);

		String currentUrl = this.driver.getCurrentUrl();
		assertEquals(this.testUrl + "/supportN/member/search", currentUrl, "The urls should be the same and end in /supportN/member/search");
		Thread.sleep(3000);
		WebElement webElement = driver.findElement(By.xpath("//html/body/div/div/div[2]/div/div/h1"));
		assertNotNull(webElement, "The h1 element should not be null");
		assertEquals(webElement.getText().trim(), "Welcome to MK3 Support");
	}

	/**
	 * Test access to /support as a homeowner. Should not be allowed and should get error page 403 (forbidden).
	 * @throws Exception 
	 */
	@Test
	public void testLoginToSupportAsHomeowner() throws Exception {
		this.login.loginSupport("elisecross@ratedtrades.com", "password");

		String currentUrl = this.driver.getCurrentUrl();
		assertEquals(this.testUrl + "/supportN/member/search", currentUrl, "The urls should be the same and end in /supportN/member/search");

		WebElement webElement = driver.findElement(By.cssSelector("#main-content > h1"));
		assertNotNull(webElement, "The h1 element should not be null");
		assertEquals(webElement.getText().trim(), "Error Page (403)");
	}

}
