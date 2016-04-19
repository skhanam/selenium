package uk.co.ratedpeople.test.functional.selenium.ho.rating;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
/**
 * This class tests home owner submitting a rating, via email link. The user clicks on the link
 * he is taken to a page, where user should select the tradesman and submit rating
 * @author swetha.morthala
 */
public class SubmitRatingViaEmailLinkTest extends TestScript {
	
	private SubmitRatingPreReqCompleter preReqCompleter;
	
	@BeforeClass
	public void beforeClass() {
		preReqCompleter = new SubmitRatingPreReqCompleter();
	}
	
	@Test(enabled=true)
	public void testSubmit5And2Rating() throws Exception{
		WebDriverWait wait = new WebDriverWait(context.driver, 20);
		preReqCompleter.postPurchaseAndRequestRatingForJob();
		loginAsAgent();
		searchForUser();
		String url = extractRatingsLinkFromEmail();
		scriptUtilities.goTo(url);
		System.out.println("URL: "+url);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[2]/div/div[2]/section/form/div/ul/li/input")));
		scriptUtilities.click(By.xpath("//html/body/div[2]/div/div[2]/section/form/div/ul/li/input"));
		submitAndAssertFiveStarRating();
		scriptUtilities.goTo(url);
		submitAndAssertTwoStarRating();
	}
	
	@Test(enabled=false)
	public void testSubmit2And5Rating() throws Exception {
		preReqCompleter.postPurchaseAndRequestRatingForJob();
		loginAsAgent();
		searchForUser();
		String url = extractRatingsLinkFromEmail();
		scriptUtilities.goTo(url);
		scriptUtilities.click(By.id("tradesman-1"));
		submitAndAssertTwoStarRating();
		scriptUtilities.goTo(url);
		submitAndAssertFiveStarRating();
	}
	
	private void submitAndAssertTwoStarRating() {
		WebDriverWait wait = new WebDriverWait(context.driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='quality']/div/span[5]")));
		scriptUtilities.click(By.xpath("//div[@id='quality']/div/span[5]"));
		scriptUtilities.click(By.xpath("//div[@id='value']/div/span[5]"));
		scriptUtilities.click(By.xpath("//div[@id='reliability']/div/span[5]"));
		scriptUtilities.fillInTextField("Rating_comment", "Test two star rating");
		scriptUtilities.click(By.xpath("//html/body/div[2]/div/div[2]/section/form/div[5]/button"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[3]/div/h1")));
		assertEquals(scriptUtilities.findElement(By.xpath("//html/body/div[3]/div/h1")).getText(), "Thank you");
		
		
/*		WebElement stars = scriptUtilities.findElement(By.xpath("//*[@id=\"star-ratings\"]"));
		assertNotNull(stars);
		assertEquals(stars.getAttribute("class"), "star-position-4");*/
	}
	
	private void submitAndAssertFiveStarRating() {
		WebDriverWait wait = new WebDriverWait(context.driver, 10);
		scriptUtilities.click(By.xpath("//div[@id='quality']/div/span[5]"));
		scriptUtilities.click(By.xpath("//div[@id='value']/div/span[5]"));
		scriptUtilities.click(By.xpath("//div[@id='reliability']/div/span[5]"));
		scriptUtilities.fillInTextField("Rating_comment", "Test five star rating");
		scriptUtilities.click(By.xpath("//html/body/div[2]/div/div[2]/section/form/div[4]/button"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[3]/div/h1")));
		
		assertEquals(scriptUtilities.findElement(By.xpath("//html/body/div[3]/div/h1")).getText(), "Thank you");
		
/*		WebElement stars = scriptUtilities.findElement(By.xpath("//*[@id=\"star-ratings\"]"));
		assertNotNull(stars);
		assertEquals(stars.getAttribute("class"), "star-position-10");*/
	}
	
	private void loginAsAgent() {
		scriptUtilities.goTo(context.getSupportUrl() + "/support");
		scriptUtilities.fillInTextField("userName", "integration.agent@ratedtrades.com");
		scriptUtilities.fillInTextField("password", "password");
		scriptUtilities.click("btn-log-in");
	}
	
	private void searchForUser() {
		WebDriverWait wait = new WebDriverWait(context.driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_search")));
		scriptUtilities.fillInTextField("search_search", "test.homeowner@ratedtrades.com");
		scriptUtilities.click("standardSearch");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("test.homeowner@ratedtrades.com")));
		scriptUtilities.click(By.partialLinkText("test.homeowner@ratedtrades.com"));
		
	}
	
	private String extractRatingsLinkFromEmail() {
		WebDriverWait wait = new WebDriverWait(context.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Emails Sent")));
		
		scriptUtilities.click(By.linkText("Emails Sent"));
		WebElement link = scriptUtilities.findElement(By.linkText("Please rate Integration Test"));
		link.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div[3]/div/div[1]/div/p/code")));
		WebElement element = scriptUtilities.findElement(By.xpath("//html/body/div[1]/div/div[3]/div/div[1]/div/p/code"));
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[3]/div/div/p/code")));
		WebElement element = scriptUtilities.findElement(By.xpath("/html/body/div/div/div[3]/div/div/p/code"));*/
		String text = element.getText();
		int fi = text.indexOf("http");
		int ei = text.indexOf("Not finished");
		//int ei = text.indexOf("Job not finished yet");
		String url = text.substring(fi, ei);
		System.out.println(url);
		return url;
	}
}
