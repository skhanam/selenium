package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author Ruhulla Mohammad
 */
public class MemberBenefitTMMobileTest extends TestScript {

	private Login tmLogin;
	private WebDriver driver;
		
	@BeforeClass
	public void setUp() throws Exception {
		driver = context.driver;
		tmLogin = new Login(context);
		
	}
	
	public void switchToWindow()
	{
		WebDriverWait wait = new WebDriverWait(context.driver, 30);
		String parentWindow = driver.getWindowHandle();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Member Benefits"))).click();
		for(String winMemberBenefit : driver.getWindowHandles())
		{
			  if (!parentWindow.equals(winMemberBenefit))
			  {
			    driver.switchTo().window(winMemberBenefit);
			    break;
			  }
		}
		//driver.switchTo().window(parentWindow);
		
	}
	
	@Test(enabled = true)
	public void MemberBenefits() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		tmLogin.login();
		// open the nav bar
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("nav-member-benefits")).click();
		switchToWindow();
		//Getting Offer from Memeber Benefit landing page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div/div/div/div/h1")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article.one-insurance a.image-container")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article.everline a.image-container")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article.anchor-vans a.image-container")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article.goodprint a.image-container")));
		WebElement oneInsuranceSeeTerms = driver.findElement(By.cssSelector("article.one-insurance a.btn-terms"));
		oneInsuranceSeeTerms.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tmBulletinOverlayDismissBtn"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article.one-insurance a.btnGreen"))).click();
		Thread.sleep(3000);
		String currentWindow = driver.getWindowHandle();
		driver.switchTo().window(currentWindow); 
		Thread.sleep(3000);
		//Getting Offer from Terms and Condition popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article.everline a.image-container")));
		WebElement everlineSeeTerms = driver.findElement(By.cssSelector("article.everline a.btn-terms"));
		everlineSeeTerms.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tmBulletinOverlayDismissBtn")));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Go to offer"))).click();
		Thread.sleep(3000);
		}

	
}
