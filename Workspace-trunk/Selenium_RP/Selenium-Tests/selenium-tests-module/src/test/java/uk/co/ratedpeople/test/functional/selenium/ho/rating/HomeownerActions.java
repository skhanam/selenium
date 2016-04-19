package uk.co.ratedpeople.test.functional.selenium.ho.rating;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
/**
 * Mimics actions that a homeowner can perform once he has logged into his rated people account via browser.
 * @author abhiuday.tomar
 *
 */
public class HomeownerActions extends TestScriptUtilities {
	private static String poorCommentSubmitted = "This is testing comment with very poor rating for feed back ";
	private static String exceptionalCommentSubmitted = " This is testing comment with exceptional rating for feedback ";
	
	public HomeownerActions(SeleniumTestContext context) {
		super(context);
	}
	public void postFirstCommentWithPoorRating(String jobId){
		clickOnJobWithRef(jobId);
		clickNoMoreTradespeople();
		clickRateMyTradesperson();
		verifyFirstCommentSubmissionPage();
		submitVeryPoorRating();
		verifyPoorRatingSubmissionPage();
	}
	
	public void goToArchivedJobs(){
		goTo(context.getTestHttpsUrl()+"/customer/archived-jobs");
		
	}
	
	public void postSecondCommentWithExceptionalRating(String jobId){
		clickOnJobWithRef(jobId);
		clickOnCompanyNameLink();
		clickRateMyTradesperson();
		verifyAlreadyCommentedJobSubmissionPage();
		submitExceptionalRating();
		verifyExceptionalRatingSubmissionPage();
	}
	
	public void login(String userName,String password,String url){
		goTo(context.getTestHttpsUrl()+url);
		fillInTextField("hoUserName", "test.homeowner@ratedtrades.com");
		fillInTextField("hoPassword", "password");
		clickIfExists(By.id("login-as-ho-button"));
	}
	
	private void clickOnJobWithRef(String jobRef){
		clickIfExists(By.partialLinkText("(Ref #"+jobRef+") Summary for test job"));
		sleep(300);
	}
	
	private void clickNoMoreTradespeople(){
		clickIfExists(By.id("view-job__noMoreQuotes"));
	}
	
	private void clickRateMyTradesperson(){
		clickIfExists(By.id("view-job__hoRateTradesman"));
	}
	
	private void verifyFirstCommentSubmissionPage(){
		sleep(3000);
		String articleMsg = findElement(By.xpath("//html/body/div[2]/div/div/div/aside/section/article")).getText();
		Assert.assertTrue(articleMsg.contains("Your rating helps other homeowners decide which tradesman to hire."));
	}
	
	private void submitVeryPoorRating(){
		clickIfExists(By.id("tradesman-1"));
		click(By.linkText("2"));
		click(By.xpath("(//a[contains(text(),'2')])[2]"));
		click(By.xpath("(//a[contains(text(),'2')])[3]"));
		fillInTextField("rating-feedback",poorCommentSubmitted);
		clickIfExists(By.id("error-false"));
	}

	
	
	private void verifyPoorRatingSubmissionPage(){
		WebElement twoStars = findElement(By.xpath("//*[@id=\"star-ratings\"]"));
		assertNotNull(twoStars);
		assertEquals(twoStars.getAttribute("class"), "star-position-4");
	}
	
	public void clickOnArchivedJobs(){
		clickIfExists(By.linkText("Archived jobs"));
	}
	private void clickOnCompanyNameLink(){
		clickIfExists(By.linkText("Integration Test"));
	}
	
	private void submitExceptionalRating(){
		clickIfExists(By.id("tradesman-1"));
		click(By.linkText("5"));
		click(By.xpath("(//a[contains(text(),'5')])[2]"));
		click(By.xpath("(//a[contains(text(),'5')])[3]"));
		fillInTextField("rating-feedback",exceptionalCommentSubmitted);
		clickIfExists(By.id("error-false"));
	}
	
	private void verifyAlreadyCommentedJobSubmissionPage(){
		String textInAlreadyCommentedJobPage = findElement(By.xpath("//html/body/div[2]/div/div/div/aside/section/article/em")).getText();
		Assert.assertTrue(textInAlreadyCommentedJobPage.contains("Overall rating"));
	}
	
	private void verifyExceptionalRatingSubmissionPage(){
		WebElement fiveStars = findElement(By.xpath("//*[@id=\"star-ratings\"]"));
		assertNotNull(fiveStars);
		assertEquals(fiveStars.getAttribute("class"), "star-position-10");
	}
}
