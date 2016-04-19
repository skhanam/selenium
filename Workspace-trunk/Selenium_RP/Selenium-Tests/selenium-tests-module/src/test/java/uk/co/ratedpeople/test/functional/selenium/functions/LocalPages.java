package uk.co.ratedpeople.test.functional.selenium.functions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class LocalPages extends TestScriptUtilities{
	private String testUrl;
	public LocalPages(SeleniumTestContext context) {
		super(context);		
		testUrl = context.getTestUrl();
	}
	public void localpages() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 10);
		
		goTo(testUrl+"/local");
		click(By.linkText("Plumber"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerReviewsContainer")));
		context.driver.findElement(By.id("customerReviewsContainer"));
		context.driver.findElement(By.id("customerReviewsLink"));
		click("customerReviewsLink");
		
		context.driver.findElement(By.id("customerReviews"));
		context.driver.findElement(By.className("jobReview"));
		//context.driver.findElement(By.linkText("companyname"));
		context.driver.findElement(By.linkText("See other plumbers"));
		
		context.driver.findElement(By.id("seoJobsSection"));
		context.driver.findElement(By.id("seoJobsContainer"));	
		
		click(By.linkText("flooring"));
		Thread.sleep(3000);
		context.driver.findElement(By.linkText("See other flooring specialists"));
		context.driver.navigate().back();
		Thread.sleep(3000);
		
		click(By.linkText("Home"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Plumber")));
		click(By.linkText("Plumber"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("London")));		
		click(By.linkText("London"));
		Thread.sleep(3000);
		context.driver.findElement(By.id("customerReviewsContainer"));
		context.driver.findElement(By.id("customerReviewsLink"));
		click("customerReviewsLink");
		
		context.driver.findElement(By.id("customerReviews"));
		context.driver.findElement(By.className("jobReview"));
		context.driver.findElement(By.linkText("Integration Test"));
		context.driver.findElement(By.linkText("See other plumbers"));
		
		context.driver.findElement(By.id("seoJobsSection"));
		context.driver.findElement(By.id("seoJobsContainer"));	
		
		click(By.linkText("Plumbers"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("London")));
		click(By.linkText("London"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Westminster")));
		click(By.linkText("Westminster"));
		Thread.sleep(3000);
		context.driver.findElement(By.id("customerReviewsContainer"));
		context.driver.findElement(By.id("customerReviewsLink"));
		click("customerReviewsLink");
		
		context.driver.findElement(By.id("customerReviews"));
		context.driver.findElement(By.className("jobReview"));
		
		context.driver.findElement(By.linkText("See other plumbers"));

		context.driver.findElement(By.id("seoJobsSection"));
		context.driver.findElement(By.id("seoJobsContainer"));	
		
		click(By.linkText("London"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Westminster")));
		click(By.linkText("Westminster"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("St James's")));
		click(By.linkText("St James's"));
		Thread.sleep(3000);
		context.driver.findElement(By.id("customerReviewsContainer"));
		
		context.driver.findElement(By.id("customerReviewsLink"));
		click("customerReviewsLink");
		
		context.driver.findElement(By.id("customerReviews"));
		context.driver.findElement(By.className("jobReview"));
		
		context.driver.findElement(By.linkText("See other plumbers"));
		
		context.driver.findElement(By.id("seoJobsSection"));
		context.driver.findElement(By.id("seoJobsContainer"));	
		
		click(By.linkText("Westminster"));
		
		
		goTo(testUrl+"/local/tradesmen");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("London")));
		click(By.linkText("London"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerReviewsContainer")));
		context.driver.findElement(By.id("customerReviewsContainer"));
		context.driver.findElement(By.id("customerReviewsLink"));
		click("customerReviewsLink");
		
		context.driver.findElement(By.id("customerReviews"));
		context.driver.findElement(By.className("jobReview"));
		context.driver.findElement(By.linkText("Integration Test"));
		click(By.linkText("See more ratings"));
		
		
		
		context.driver.findElement(By.id("seoJobsSection"));
		context.driver.findElement(By.id("seoJobsContainer"));	
		
		click(By.linkText("Tradesmen"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("London")));
		click(By.linkText("London"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Westminster")));
		click(By.linkText("Westminster"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerReviewsContainer")));
		context.driver.findElement(By.id("customerReviewsContainer"));
		context.driver.findElement(By.id("customerReviewsLink"));
		click("customerReviewsLink");
		
		context.driver.findElement(By.id("customerReviews"));
		context.driver.findElement(By.className("jobReview"));
		sleep(3000);	
		click(By.linkText("heating"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("See other heating engineers")));
		context.driver.findElement(By.linkText("See other heating engineers"));
		context.driver.navigate().back();
		Thread.sleep(3000);
		context.driver.findElement(By.id("seoJobsSection"));
		context.driver.findElement(By.id("seoJobsContainer"));	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("London")));
		click(By.linkText("London"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Westminster")));
		click(By.linkText("Westminster"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("St James's")));
		click(By.linkText("St James's"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerReviewsContainer")));
		context.driver.findElement(By.id("customerReviewsContainer"));
		context.driver.findElement(By.id("customerReviewsLink"));
		click("customerReviewsLink");
		
		context.driver.findElement(By.id("customerReviews"));
		context.driver.findElement(By.className("jobReview"));
		
		context.driver.findElement(By.id("seoJobsSection"));
		context.driver.findElement(By.id("seoJobsContainer"));	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Westminster")));
		click(By.linkText("Westminster"));
				
		
	}
	
	
}
