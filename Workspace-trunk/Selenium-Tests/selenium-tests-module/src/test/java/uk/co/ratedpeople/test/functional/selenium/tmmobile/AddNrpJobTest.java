package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * 
 * @author olivier.renard
 * 
 */
public class AddNrpJobTest extends TestScript {

	private Login tmLogin;
	private WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = context.driver;
		tmLogin = new Login(context);
	}

	@Test(enabled = false)
	public void addNrpJobSuccess() throws Exception {

		loginAndClickOnAddAJobNav();

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Add a Job");

		//we see introduction page 1st time in.
		driver.findElement(By.id("link-continue")).click();
        //cookie now set
		
		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Add a Job");

		assertNotNull(driver.findElement(By.id("Job_firstName")));

		driver.findElement(By.id("Job_firstName")).clear();
		driver.findElement(By.id("Job_firstName")).sendKeys("Joe");

		driver.findElement(By.id("Job_lastName")).clear();
		driver.findElement(By.id("Job_lastName")).sendKeys("Bloggs");

		driver.findElement(By.id("Job_email")).clear();
		driver.findElement(By.id("Job_email")).sendKeys("JoeBloggs@ratedpeople.com");

		driver.findElement(By.id("Job_telephone")).clear();
		driver.findElement(By.id("Job_telephone")).sendKeys("02084557854");

		driver.findElement(By.id("Job_postcode")).clear();
		driver.findElement(By.id("Job_postcode")).sendKeys("SW1E 6AU");

		WebElement dropDownList = driver.findElement(By.id("Job_jobTypeId"));
		Select jobType = new Select(dropDownList);
		jobType.selectByVisibleText("CCTV");

		driver.findElement(By.id("btn-add-job")).click();

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Job Added");
		
		//we now need to obtain the job ref from the url (https://devtm.uk.ratedpeople/jobs/N103)
		String[] urlSectionArray = driver.getCurrentUrl().split("/");
		String nonRPref =  urlSectionArray[urlSectionArray.length-1];
		
		//check back prevention - we should be redirected to the new job card
		driver.navigate().back();
		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "#" + nonRPref);
		assertNotNull(driver.findElement(By.id("link-create-invoice")));
		
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("nav-jobs")).click();
		
		WebElement jobLink = driver.findElement(By.cssSelector("a[data-job='"+nonRPref+"']"));
		assertNotNull(jobLink);
	
		//check that the RP image is not present	
		List<WebElement> imageList = jobLink.findElements(By.cssSelector("rp-job"));
	    assertEquals(imageList.size(),0);	    
	    jobLink.click();
			    
		//back into job card - and check that non RP quick actions show
		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "#" + nonRPref);
		assertNotNull(driver.findElement(By.id("link-create-invoice")));
		assertNotNull(driver.findElement(By.id("gmap")));
		List<WebElement> nonRPQuickActions = driver.findElements(By.cssSelector("#link-request-rating, #link-request-credit"));
	    assertEquals(nonRPQuickActions.size(),0);
		
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);
		
		//attempt to add another job by clicking add button on jobs page
		driver.findElement(By.id("nav-jobs")).click();
		driver.findElement(By.id("header-link-new")).click();
		
		//we should see the add job for and not introduction page second time around
		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Add a Job");
		assertNotNull(driver.findElement(By.id("btn-add-job")));
		
		//TODO check that this job cannot be found on the ratings list page
	}

	private void loginAndClickOnAddAJobNav() throws Exception {
		// perform login and arrive at job details page
		tmLogin.login();

		// open the nav bar
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);

		// commence add new job
		driver.findElement(By.id("nav-add-job")).click();
	}
}
