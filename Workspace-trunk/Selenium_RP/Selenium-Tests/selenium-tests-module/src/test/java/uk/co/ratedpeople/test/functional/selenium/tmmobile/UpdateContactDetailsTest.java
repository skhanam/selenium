package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author craig.marcus
 */
public class UpdateContactDetailsTest extends TestScript{
	
	private Login tmLogin;
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = context.driver;
		tmLogin = new Login(context);
		//perform login and arrive at job details page
		tmLogin.login();
		//open the nav bar
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);
		//commence account details checks
		driver.findElement(By.id("nav-account-details")).click(); 
		Thread.sleep(1000);
		assertEquals(driver.findElement(By.id("header-h1")).getText(),"Account Details");
		driver.findElement(By.id("link-contact-details")).click();
		Thread.sleep(1000);
		assertEquals(driver.findElement(By.id("header-h1")).getText(),"Contact Details");
		driver.findElement(By.id("link-edit-contact-dets")).click();
		Thread.sleep(1000);
	}
	
	@Test(enabled=true)
	public void editContactDetails() throws InterruptedException {
				
		driver.findElement(By.id("ContactDetails_firstName")).clear();
		driver.findElement(By.id("ContactDetails_firstName")).sendKeys("First Name");
		
		driver.findElement(By.id("ContactDetails_lastName")).clear();
		driver.findElement(By.id("ContactDetails_lastName")).sendKeys("Last Name");
		
		driver.findElement(By.id("ContactDetails_mobile")).clear();
		driver.findElement(By.id("ContactDetails_mobile")).sendKeys("07700900056");	
		
		driver.findElement(By.id("ContactDetails_landLine")).clear();
		driver.findElement(By.id("ContactDetails_landLine")).sendKeys("07812345699");	
		
		driver.findElement(By.id("ContactDetails_email")).clear();
		driver.findElement(By.id("ContactDetails_email")).sendKeys("integration.test@ratedtrades.com");	
		
		Thread.sleep(1000);
		driver.findElement(By.id("btn-save")).click();
		Thread.sleep(5000);
		//temporary fix for CSRF token issue Trade-561  
		if(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div[2]/form/em")) != null)
		{
			driver.findElement(By.id("btn-save")).click();
			Thread.sleep(5000);
		}
		//end of test, back to contact details and 'Edit Contact Details' button visible		
		assertNotNull(driver.findElement(By.id("link-edit-contact-dets")));
		
	}
	
	@Test(enabled = true)
	public void editContactDetailsCancelSuccess() throws Exception {

		driver.findElement(By.id("link-cancel")).click();

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Contact Details");
	}
}
