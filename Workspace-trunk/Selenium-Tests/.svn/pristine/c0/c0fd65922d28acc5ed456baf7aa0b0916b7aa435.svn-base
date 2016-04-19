package uk.co.ratedpeople.test.functional.selenium.pjf;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.chimney.PostingJobViaChimneyJobForms;

public class PostJobViaPortableJobFormTestConcertinaTwoPanel extends TestScript{
	private WebDriver driver;
	private String baseUrl;

	
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = context.driver;
		baseUrl = context.getTestPJFURL();
	}
	
	@Test(enabled=true)   
	public void testWebdriverjunit() throws Exception {

		driver.get(baseUrl + "/test-cases/test-case.php?jts=consertina&jdl=2&hwp=false&prese=false");
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("#jc0 > h4")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Plumbing - Kitchen")).click();
		driver.findElement(By.id("Job_description")).clear();
		driver.findElement(By.id("Job_description")).sendKeys("Less than min");
		driver.findElement(By.id("Job_postcode")).clear();
		driver.findElement(By.id("Job_postcode")).sendKeys("");
		driver.findElement(By.id("next")).click();
		Thread.sleep(1000);                                                                                                
		assertEquals("Enter your postcode.", driver.findElement(By.cssSelector("div.relative > em.error")).getText());
	
		driver.findElement(By.id("Job_postcode")).clear();
		driver.findElement(By.id("Job_postcode")).sendKeys("ig88nw");
		driver.findElement(By.id("Job_description")).clear();
		driver.findElement(By.id("Job_description")).sendKeys("I need a loft conversion. Please can you carry one out.");
		new Select(driver.findElement(By.id("Job_jobBudgetId"))).selectByVisibleText("Under £100");
		new Select(driver.findElement(By.id("Job_jobStartDate"))).selectByVisibleText("Within 2 weeks");
		Thread.sleep(3000);
		driver.findElement(By.id("next")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.id("next")).click(); // Added 13.11.2012. Doesn't work without this row.
		Thread.sleep(5000);
		driver.findElement(By.id("submitBtn")).click();
		Thread.sleep(2000);			
		assertEquals(driver.findElement(By.cssSelector("section > fieldset > div.formElement > em.error")).getText(),"Enter your first name.");
		assertEquals(driver.findElement(By.cssSelector("section > fieldset > div.formElement.inline-loader > div.relative > em.error")).getText(),"Enter your email address.");
		assertEquals(driver.findElement(By.id("Job_user_subscribedToNewsletter")).getAttribute("value"),"1");
		assertEquals("Privacy Policy", driver.findElement(By.linkText("Privacy Policy")).getText());
		assertEquals(driver.findElement(By.linkText("User Agreement")).getText(),"User Agreement");
		Thread.sleep(2000);	
		driver.findElement(By.id("Job_user_firstName")).clear();
		driver.findElement(By.id("Job_user_firstName")).sendKeys("Arpine");
		driver.findElement(By.id("Job_user_lastName")).clear();
		driver.findElement(By.id("Job_user_lastName")).sendKeys("Grigoryan");
		driver.findElement(By.id("Job_user_phoneNumber")).clear();
		driver.findElement(By.id("Job_user_phoneNumber")).sendKeys("07777777777");
		driver.findElement(By.id("Job_user_email")).clear();
		driver.findElement(By.id("Job_user_email")).sendKeys("arpine.grigoryan@ratedtrades.com");
		
		Thread.sleep(2000);
		driver.findElement(By.id("submitBtn")).click();
		Thread.sleep(2000);
		assertEquals(driver.findElement(By.cssSelector("h3.formHeader")).getText(),"Thank you");
	}
}
