package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.IntegrationTestUsers;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class Login extends TestScriptUtilities {

	private WebDriver driver;

	public static final String TRADESMAN = IntegrationTestUsers.TP_INTEGRATION_TEST;
	public static final String INVOICE_TRADESMAN = IntegrationTestUsers.TP_INVOICE_TEST;
	public static final String TRADESMAN_PASSWORD = IntegrationTestUsers.TP_PASSWORD;


	private String rootURL = null;

	public Login(SeleniumTestContext context) {
		super(context);
		driver = context.driver;
	}

	public void login(String username, String password) {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		
		driver.manage().deleteAllCookies();

		rootURL = context.getTestHttpsTMMobileURL();

		// site root will redirect to /login using https
		goTo(rootURL);

		// fill in login form and submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.id("btn_login")).click();

		// ensure job alerts page load
		WebElement element = getElementIfExists(By.id("header-h1"));
		assertNotNull(element);
		assertEquals(element.getText(), "Job Alerts");
	}

	public void login() {
		login(TRADESMAN, TRADESMAN_PASSWORD);
	}

	public void loginWithIntroductorySlides() {

		driver.manage().deleteAllCookies();

		rootURL = context.getTestHttpsTMMobileURL();

		// site root will redirect to /login using https
		goTo(rootURL);

		// fill in login form and submit
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(TRADESMAN);

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(TRADESMAN_PASSWORD);

		driver.findElement(By.id("btn-login")).click();

		// move through 5 page slideshow, and click on 'Done' driver.findElement(By.id("link-slide2")).click();
		driver.findElement(By.id("link-slide3")).click();
		driver.findElement(By.id("link-slide4")).click();
		driver.findElement(By.id("link-slide5")).click();
		driver.findElement(By.id("link-done")).click();

		// ensure job alerts page load
		WebElement element = getElementIfExists(By.id("header-h1"));
		assertNotNull(element);
		assertEquals(element.getText(), "Job Alerts");

	}

	public String getRootURL() {
		return rootURL;
	}
}