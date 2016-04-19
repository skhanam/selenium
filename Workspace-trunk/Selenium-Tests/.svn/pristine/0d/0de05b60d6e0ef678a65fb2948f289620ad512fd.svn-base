package uk.co.ratedpeople.test.functional.selenium.tp;

import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;

public class TPMemberBenefits extends TestScriptUtilities{
	private WebDriver driver;
	private String testUrl;
	WebDriverWait wait = new WebDriverWait(context.driver, 30);
	 
	
	public TPMemberBenefits(SeleniumTestContext context) {
		super(context);
		driver = context.driver;
		testUrl = context.getTestUrl ();
		
	}
	
	public void switchToWindow()
	{
			for (String winHandle : driver.getWindowHandles()) {
		     driver.switchTo().window(winHandle); 
		    }
	
	}
	public void scrollToMiddleOfThePage(WebDriver scrollDriver) throws InterruptedException{
		Thread.sleep(3000);
		((JavascriptExecutor)scrollDriver).executeScript("scrollTo(0,800)");
	}
	
	public void scrollToTopOfThePage(WebDriver scrollDriver) throws InterruptedException{
		Thread.sleep(3000);
		((JavascriptExecutor)scrollDriver).executeScript("scrollTo(800,0)");
	}
	
	public void baseUrl(){
		//String testUrl=context.getTestUrl();
		String testUrlLowercase = testUrl.toLowerCase();
		String tmpreprodURL = "https://tradesmen.preprod";
		String tmparisURL = "https://tradesmen-paris.uk.ratedpeople/";
		if (testUrlLowercase.indexOf("preprod") != -1) {
			goTo(tmpreprodURL);
			} else {
			    // go to paris url
				goTo(tmparisURL);
			  }
		}
	
	public void gettingMemberBenefitFromLandingPage() throws Exception{
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		//goTo(testUrl + "/log-in");
		baseUrl();
		WebDriver scrollDriver = context.driver;
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tpUserName"))).sendKeys("memberbenefit@ratedtrades.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_username"))).sendKeys("integration.test@ratedtrades.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_password"))).sendKeys("password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login__login"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Member Benefits"))).click();
		//Getting One Insurance Offer from landing page
		String parentHandle = driver.getWindowHandle(); 
		driver.switchTo().frame(driver.findElement(By.cssSelector(".iframeWrapper iframe")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article.one-insurance a.image-container")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='one-insurance']/div/div[2]/div[1]/a[2]"))).click();
		Thread.sleep(3000);
		switchToWindow();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logo")));
	    driver.close(); 
	    driver.switchTo().window(parentHandle);
		//To test if the image link is working 
	    driver.switchTo().frame(driver.findElement(By.cssSelector(".iframeWrapper iframe")));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article.everline a.image-container"))).click();
		switchToWindow();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Get a quote")));
		driver.close(); 
		driver.switchTo().window(parentHandle);
		driver.switchTo().frame(driver.findElement(By.cssSelector(".iframeWrapper iframe")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article.everreach a.image-container"))).click();
		Thread.sleep(3000);
		switchToWindow();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signup-big-button")));
		driver.close(); 
		driver.switchTo().window(parentHandle);
		scrollToMiddleOfThePage(scrollDriver);
		driver.switchTo().frame(driver.findElement(By.cssSelector(".iframeWrapper iframe")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article.goodprint a.image-container"))).click();
	    Thread.sleep(3000);
		switchToWindow();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("maincontent")));
		driver.close(); 
		driver.switchTo().window(parentHandle);
		driver.switchTo().frame(driver.findElement(By.cssSelector(".iframeWrapper iframe")));
		//To test if the FuelCard offer is working 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article.the-fuelcard-people a.image-container"))).click();
		Thread.sleep(3000);
		switchToWindow();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apply Today"))).click();
		driver.close(); 
		driver.switchTo().window(parentHandle);
		driver.switchTo().frame(driver.findElement(By.cssSelector(".iframeWrapper iframe")));
		//To test if the AnchoreVans offer is working 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article.anchor-vans a.image-container"))).click();
		Thread.sleep(3000);
		switchToWindow();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links-desktop']/ul/li[2]/a"))).click();
		driver.switchTo().window(parentHandle);       
				
	}
	
	public String gettingMemberBenefitFromSeeTermsPopup() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		WebDriver scrollDriver = context.driver;
		String parentHandle = driver.getWindowHandle();
		/*baseUrl();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_username"))).sendKeys("integration.test@ratedtrades.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_password"))).sendKeys("password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login__login"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Member Benefits"))).click();*/
		//Getting Offer from Memeber Benefit from see terms
		scrollToTopOfThePage(scrollDriver);
		driver.switchTo().frame(driver.findElement(By.cssSelector(".iframeWrapper iframe")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div/div/div/div/h1")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article.everline a.image-container")));
		WebElement everlineSeeTerms = driver.findElement(By.cssSelector("article.everline a.btn-terms"));
		everlineSeeTerms.click();
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Go to offer"))).click();
		switchToWindow();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Get a quote"))).click();
	    driver.close();
	    driver.switchTo().window(parentHandle);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[4]/div/a[1]"))).click();
	    driver.switchTo().frame(driver.findElement(By.cssSelector(".iframeWrapper iframe")));
		WebElement oneInsuranceSeeTerms = driver.findElement(By.cssSelector("article.one-insurance a.btn-terms"));
		oneInsuranceSeeTerms.click();
		driver.switchTo().window(parentHandle);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Go to Van offer"))).click();
		switchToWindow();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logo")));
	    driver.close(); 
	    driver.switchTo().window(parentHandle);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Go to PL offer"))).click();
		switchToWindow();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logo")));
	    driver.close(); 
	    driver.switchTo().window(parentHandle);
	    return"";		
		}
}
