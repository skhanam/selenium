package uk.co.ratedpeople.test.functional.selenium.pjf;

 
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class PostJobViaPortableJobFormTestConcertinaOnePanelShowPanel extends TestScript{
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = context.driver;
		baseUrl = context.getTestPJFURL();
	}

	@Test(enabled=true) 
	public void testWebdriverjunit() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 20);
		driver.get(baseUrl + "/test-cases/test-case.php?jts=consertina&jdl=1&hwp=true&prese=false");
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("#jc10 > h4")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Loft Conversions")));
		driver.findElement(By.linkText("Loft Conversions")).click();
		driver.findElement(By.id("Job_description")).clear();
		driver.findElement(By.id("Job_description")).sendKeys("Less than min");
		driver.findElement(By.id("Job_postcode")).clear();
		driver.findElement(By.id("Job_postcode")).sendKeys("");
		driver.findElement(By.id("submitBtn")).click();

		assertEquals(driver.findElement(By.cssSelector("div.relative > em.error")).getText(),"Enter your postcode.");
		driver.findElement(By.id("Job_description")).clear();
		driver.findElement(By.id("Job_description")).sendKeys("I need a loft conversion. Please can you carry one out.");
		//new Select(driver.findElement(By.id("Job_jobBudgetId"))).selectByVisibleText("Under £100");
		
		driver.findElement(By.xpath("//html/body/div/div/div/div[2]/form/div[2]/div/fieldset/div[2]/select/option[3]")).click();
		
		
		
		driver.findElement(By.id("submitBtn")).click();
		
		assertEquals(driver.findElement(By.cssSelector("div.relative > em.error")).getText(),"Enter your postcode.");
		assertEquals(driver.findElement(By.cssSelector("section > fieldset > div.formElement > em.error")).getText(),"Enter your first name.");
		assertEquals(driver.findElement(By.cssSelector("section > fieldset > div.formElement.inline-loader > div.relative > em.error")).getText(),"Enter your email address.");
		assertEquals(driver.findElement(By.id("Job_user_subscribedToNewsletter")).getAttribute("value"),"1");
		assertEquals(driver.findElement(By.linkText("Privacy Policy")).getText(),"Privacy Policy");
		assertEquals(driver.findElement(By.linkText("User Agreement")).getText(),"User Agreement");
		//checkpanel exists	
		assertEquals(driver.findElement(By.xpath("//html/body/div/div/div/div[3]/aside/h3")).getText(),"Find quality, local tradesmen quickly and easily.");		

		driver.findElement(By.xpath("//html/body/div/div/div/div[2]/form/div[2]/div/fieldset/div[3]/select/option[3]")).click();
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
		assertEquals(driver.findElement(By.cssSelector("h3.formHeader")).getText(), "Thank you");

	}
}
