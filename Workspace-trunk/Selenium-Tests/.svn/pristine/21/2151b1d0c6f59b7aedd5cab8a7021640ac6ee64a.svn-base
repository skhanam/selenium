package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author craig.marcus
 */
public class UpdatePasswordTest extends TestScript {

	private Login tmLogin;
	private WebDriver driver;

	@BeforeClass
	public void setUp() throws Exception {
		driver = context.driver;
		tmLogin = new Login(context);
	}
	
	@Test(enabled = true)
	public void updatePassword() throws InterruptedException {
		tmLogin.login();
		// open the nav bar
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);
		// commence account details checks
		driver.findElement(By.id("nav-account-details")).click();
		Thread.sleep(1000);
		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Account Details");

		driver.findElement(By.id("link-change-password")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Edit Password");

		driver.findElement(By.id("Password_currentPassword")).clear();
		driver.findElement(By.id("Password_currentPassword")).sendKeys("password");

		// ids currently con
		driver.findElement(By.id("Password_password_first")).clear();
		driver.findElement(By.id("Password_password_first")).sendKeys("password");

		driver.findElement(By.id("Password_password_second")).clear();
		driver.findElement(By.id("Password_password_second")).sendKeys("password");

		// click save button
		driver.findElement(By.id("btn-save-pwd")).click();
		Thread.sleep(10000);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Password Changed");
	}

	@Test(enabled = true)
	public void cancelUpdatePassword() throws InterruptedException {
		tmLogin.login();
		// open the nav bar
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);
		// commence account details checks
		driver.findElement(By.id("nav-account-details")).click();
		Thread.sleep(1000);
		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Account Details");

		driver.findElement(By.id("link-change-password")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Edit Password");

		// click cancel link
		driver.findElement(By.id("link-cancel")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Account Details");
	}

	@Test
	public void updatePasswordFailsPasswordTooShort() throws InterruptedException {
		tmLogin.login();
		// open the nav bar
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);
		// commence account details checks
		driver.findElement(By.id("nav-account-details")).click();
		Thread.sleep(1000);
		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Account Details");

		driver.findElement(By.id("link-change-password")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Edit Password");

		driver.findElement(By.id("Password_currentPassword")).clear();
		driver.findElement(By.id("Password_currentPassword")).sendKeys("password");

		// ids currently con
		driver.findElement(By.id("Password_password_first")).clear();
		driver.findElement(By.id("Password_password_first")).sendKeys("pwd");

		driver.findElement(By.id("btn-save-pwd")).click();
		Thread.sleep(1000);

		WebElement errorElement = driver.findElement(By.cssSelector("label[for^='Password_password_first']"));
		assertNotNull(errorElement, "The error element should be present");
		assertEquals(errorElement.getText(), "Enter new password");

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Edit Password");
	}

	@Test
	public void updatePasswordFailsPasswordsDoNotMatch() throws InterruptedException {
		tmLogin.login();
		// open the nav bar
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);
		// commence account details checks
		driver.findElement(By.id("nav-account-details")).click();
		Thread.sleep(1000);
		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Account Details");

		driver.findElement(By.id("link-change-password")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Edit Password");

		driver.findElement(By.id("Password_currentPassword")).clear();
		driver.findElement(By.id("Password_currentPassword")).sendKeys("password");

		// ids currently con
		driver.findElement(By.id("Password_password_first")).clear();
		driver.findElement(By.id("Password_password_first")).sendKeys("passwordd");

		driver.findElement(By.id("Password_password_second")).clear();
		driver.findElement(By.id("Password_password_second")).sendKeys("passw0rd");

		driver.findElement(By.id("btn-save-pwd")).click();

		WebElement errorElement = driver.findElement(By.cssSelector("label[for^='Password_password_second']"));
		assertNotNull(errorElement, "The error element should be present");
		assertEquals(errorElement.getText(), "Confirm new password");

		// click save button
		driver.findElement(By.id("btn-save-pwd")).click();

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Edit Password");
	}
}
