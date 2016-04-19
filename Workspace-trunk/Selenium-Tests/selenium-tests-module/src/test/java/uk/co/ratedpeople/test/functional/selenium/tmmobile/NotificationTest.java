/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;


/**
 * @author shobha.rani
 *
 */
public class NotificationTest extends TestScript{
	private Login tmLogin;
	private WebDriver driver;
	private static String tmWithAlertsUsername = "NotificationTest@ratedtrades.com";
	private static String tmWithAlertsPassword = "password";

	@BeforeClass
	public void setUp() throws Exception {
		driver = context.driver;
		tmLogin = new Login(context);
	}
	
	@Test(enabled = true)
	public void NotificationCampaignTM() throws InterruptedException {
		tmLogin.login(tmWithAlertsUsername, tmWithAlertsPassword);
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);
		assertEquals(driver.findElement(By.xpath("html/body/div[1]/div[2]/ul/li[13]/h2")).getText(), "NOTIFICATIONS");
	    driver.findElement(By.linkText("Plan offers")).click();  
	    
}
}
