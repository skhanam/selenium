package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author craig.marcus
 */
public class ViewHelpTest extends TestScript {

	private Login tmLogin;
	private WebDriver driver;

	@BeforeClass
	public void setUp() throws Exception {
		driver = context.driver;
		tmLogin = new Login(context);
	}
	
	private void checkLoggedInMenuPresent(Boolean clickBack)
	{
	    //assertEquals(driver.findElement(By.id("header-h1")).getText(), "Help");
		assertNotNull(driver.findElement(By.id("nav-toggle")));
		assertNotNull(driver.findElement(By.id("nav-header")));
		
		if(clickBack == true)
		{
			driver.findElement(By.id("link-back")).click();
		}
	}
	
	private void checkLoggedOutRenderingPresent(Boolean clickBack)
	{
		//TODO selector taking over 10 seconds to run
		//List<WebElement> headerList = driver.findElements(By.cssSelector("#header-h1, #nav-toggle, #nav-header"));
		//assertEquals(headerList.size(),0);
		
		if(clickBack == true)
		{
			driver.findElement(By.id("link-back")).click();
		}
	}
	
	@Test(enabled = true)
	public void testViewTradesmanHelpLoggedIn() throws InterruptedException {
        
		tmLogin.login();
		
		// open the nav bar
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);
		// commence account details checks
		driver.findElement(By.xpath("//html/body/div/div[2]/ul/li[11]/a")).click();
		Thread.sleep(1000);
		assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/section/div/div/ul/li/a")).getText(), "What are job leads?");
		//logged in display must show menu and nav toggle
/*		checkLoggedInMenuPresent(false);
		
		//39 links on index page - enter page click back
		for(int i=1; i<=39; i++)
		{
	        driver.findElement(By.id("link-help-" + i)).click();
	        checkLoggedInMenuPresent(true);
        }*/
	}
	
	//this functionality is available without login, and over http

}
