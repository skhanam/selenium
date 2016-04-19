package uk.co.ratedpeople.test.functional.selenium.test.profiles;

import static org.testng.Assert.assertEquals;

//import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//import com.gargoylesoftware.htmlunit.javascript.host.Element;


import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class ViewTMProfileRatingsAndPhotos  extends TestScriptUtilities{
private WebDriver driver;
private String testUrl;
WebDriverWait wait = new WebDriverWait(context.driver, 30);
	
	public ViewTMProfileRatingsAndPhotos(SeleniumTestContext context) {
		super(context);
		driver = context.driver;
		testUrl = context.getTestUrl ();
		
	}
		public void viewTMProfileAndGetQuote()throws Exception{
			WebDriverWait wait = new WebDriverWait(context.driver, 50);
			goTo(testUrl + "/profile/integrationtest/index");   
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/header/nav[2]/div/div/ul/li[5]/a"))).click();
			//driver.findElement(By.xpath("//*[@id='siteNavigation']/div/div/ul/li[4]/a")).click();
			sleep(5000);
			driver.switchTo().frame(0);
			sleep(5000);
			new Select(driver.findElement(By.id("Job_tradeId"))).selectByVisibleText("Bathroom Specialist"); 
			Thread.sleep(2000);
			new Select(driver.findElement(By.id("Job_jobTypeId"))).selectByVisibleText("Bathroom Design");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Job_description"))).sendKeys("I need some work done in my house. Please can you carry one out.");
			new Select(driver.findElement(By.id("Job_jobStartDate"))).selectByVisibleText("Urgently");
			new Select(driver.findElement(By.id("Job_jobBudgetId"))).selectByVisibleText("Under £100");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Job_postcode"))).sendKeys("sw46ba");
			//driver.findElement(By.id("Job_postcode")).sendKeys("sw46ba");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next"))).click();
			//driver.findElement(By.xpath("//*[@id='next']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Job_user_firstName"))).sendKeys("Mark");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Job_user_lastName"))).sendKeys("Coleman");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Job_user_phoneNumber"))).sendKeys("07777777777");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Job_user_email"))).sendKeys("sarah.pain@ratedtrades.com");
			assertEquals(driver.findElement(By.linkText("Privacy Policy")).getText(),"Privacy Policy");
			assertEquals(driver.findElement(By.linkText("User Agreement")).getText(),"User Agreement");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitBtn"))).click();
			sleep(3000);
			assertEquals(driver.findElement(By.xpath("//*[@id='stage-1']/section[1]/h3")).getText(),"Thank you"); 
				 
			 
	}
 
 public  void viewTMRatingsPhotosScroll (){
	WebDriverWait wait = new WebDriverWait(context.driver, 50);
	goTo(testUrl + "/profile/integrationtest/index");   
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showCommentDiv-0"))).click();
	sleep(3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hideCommentDiv-0"))).click();
	((JavascriptExecutor)driver).executeScript("scrollTo(0,4000)");
    }
	
 public void clickOnAllTabsInProfilePageAndAssert(){
	 
	 WebDriverWait wait = new WebDriverWait(context.driver, 50);
		goTo(testUrl + "/profile/integrationtest/index"); 
		
		assertEquals(driver.findElement(By.xpath(".//html/body/div/div[4]/h1")).getText(),"Integration Test");
		//services
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Services"))).click();
		sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div/div[2]/section[3]/div/div/div"))).isDisplayed();
		//rating
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Ratings"))).click();
		//sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div/div[2]/section[1]/div/div/span/span/span[1]"))).isDisplayed();
		//expertanswers
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div/div/header/nav[2]/div/div/ul/li[4]/a"))).click();
		sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//html/body/div[1]/div[2]/div/section[2]/div[1]/h1/a"))).isDisplayed();

	 }

 
 
}



	