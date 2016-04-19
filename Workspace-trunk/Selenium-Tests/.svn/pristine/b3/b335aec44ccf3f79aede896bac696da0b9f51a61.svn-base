package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author craig.marcus
 */
public class UpdateAddressTest extends TestScript{
	
	private Login tmLogin;
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		driver = context.driver;
		tmLogin = new Login(context);
		//perform login and arrive at job details page
		tmLogin.login();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-toggle"))).click();
		//commence account details checks
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-account-details"))).click();
        Thread.sleep(3000);
		assertEquals(driver.findElement(By.id("header-h1")).getText(),"Account Details");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link-address"))).click();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-edit-address"))).click();
		Thread.sleep(3000);
	}
	
	@Test(enabled = true)
	public void selectAddressFromPostcodeSuggestions() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddressDetails_postcode"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddressDetails_postcode"))).sendKeys("SW1E6AU");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-find-address"))).click();
		Thread.sleep(3000);
		
		//take the 1st option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddressDetails_address")));
		Select addressSelect = new Select(driver.findElement(By.id("AddressDetails_address")));
		addressSelect.selectByIndex(1);
		
		//click save button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-address-find-save"))).click();
		//confirm edit complete
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-edit-address")));
	}
	
	@Test(enabled = true)
	public void enterNewAddressManually() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddressDetails_postcode"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddressDetails_postcode"))).sendKeys("SW1E6AU");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-find-address"))).click();
		//Allow ajax load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link-addr-not-listed"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddressDetails_houseName"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddressDetails_houseName"))).sendKeys("3rd Floor");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddressDetails_houseName"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddressDetails_houseName"))).sendKeys("3rd Floor");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddressDetails_street"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddressDetails_street"))).sendKeys("66 Buckingham Gate");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddressDetails_town"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddressDetails_town"))).sendKeys("London");
		
		//leaving optional county field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddressDetails_county"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddressDetails_county"))).sendKeys("Greater London");
		Thread.sleep(5000);	
		//click save button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-save-address"))).click();
		//confirm edit complete
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-edit-address")));
			
	}

}
