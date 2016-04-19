package uk.co.ratedpeople.test.functional.selenium.pjf;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class PostJobViaPortableJobFormTestTwoSelectOnePanel extends TestScript{
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = context.driver;
		baseUrl = context.getTestPJFURL();
	}

	@Test(enabled=true) 
	public void testWebdriverjunit() throws Exception {
		driver.get(baseUrl + "/test-cases/test-case.php?jts=two-select-inputs&jdl=1&hwp=false&prese=false");
		driver.switchTo().frame(0);
		driver.findElement(By.id("Job_description")).clear();
		driver.findElement(By.id("Job_description")).sendKeys("Less than min");
		driver.findElement(By.id("submitBtn")).click();
		driver.findElement(By.id("submitBtn")).click();                                                                                                 
      //  assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div/div/fieldset/div/label[2]")).getText(),"Please select a type of tradesman.");
      //  assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div/div/fieldset/div[2]/label[2]")).getText(),"Please select a type of job.");
		assertEquals(driver.findElement(By.cssSelector("div.relative > em.error")).getText(),"Enter your postcode.");
		assertEquals(driver.findElement(By.cssSelector("section > fieldset > div.formElement > em.error")).getText(),"Enter your first name.");
		assertEquals(driver.findElement(By.cssSelector("section > fieldset > div.formElement.inline-loader > div.relative > em.error")).getText(),"Enter your email address.");
		assertEquals(driver.findElement(By.id("Job_user_subscribedToNewsletter")).getAttribute("value"),"1");
		assertEquals(driver.findElement(By.linkText("Privacy Policy")).getText(),"Privacy Policy");
		assertEquals(driver.findElement(By.linkText("User Agreement")).getText(),"User Agreement");

		
		new Select(driver.findElement(By.id("Job_tradeId"))).selectByVisibleText("Cleaner");
		Thread.sleep(5000);
		new Select(driver.findElement(By.id("Job_jobTypeId"))).selectByVisibleText("Carpet Cleaning");
		new Select(driver.findElement(By.id("Job_jobStartDate"))).selectByVisibleText("Within 2 weeks");
		new Select(driver.findElement(By.id("Job_jobBudgetId"))).selectByVisibleText("Under £100");
		
		driver.findElement(By.id("Job_description")).clear();
		driver.findElement(By.id("Job_description")).sendKeys("Need Carpet Cleaned. Available on weekends only. 12 toomsgoo");
		driver.findElement(By.id("Job_postcode")).clear();
		driver.findElement(By.id("Job_postcode")).sendKeys("ig88nw");
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
