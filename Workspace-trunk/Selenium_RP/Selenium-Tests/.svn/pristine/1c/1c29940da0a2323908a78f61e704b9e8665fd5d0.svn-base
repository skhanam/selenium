package uk.co.ratedpeople.test.functional.selenium.tests;
/**
 * 
 * @author ruhulla.mohammed
 * 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tp.functions.Login;

public class PaginationTest extends TestScript {
	private Login tpLogin;
	
	
	@BeforeClass
	public void beforeClass() {
		tpLogin = new Login(this.context);
		
	}
	
	public void scrollToBottomofThePage(WebDriver scrollDriver) throws InterruptedException{
		Thread.sleep(3000);
		((JavascriptExecutor)scrollDriver).executeScript("scrollTo(0,6000)");
	}
	
	@Test (enabled=true)
	public void paginationTest()throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(context.driver, 30);
		WebDriver scrollDriver = context.driver;
		tpLogin.login("aleksandr01jbilling@ratedtrades.com", "password");
		scrollToBottomofThePage(scrollDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//*[@id='jobAlertsTable']/div/div[2]/div[5]"))).click(); //checking for Last page
		scrollToBottomofThePage(scrollDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//*[@id='jobAlertsTable']/div/div[2]/div[1]"))).click(); //checking for First page
		scrollToBottomofThePage(scrollDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//*[@id='jobAlertsTable']/div/div[2]/div[3]/div[3]"))).click(); //checking for 3rd page
		scrollToBottomofThePage(scrollDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//*[@id='jobAlertsTable']/div/div[2]/div[2]"))).click(); //checking for Previous page takes you to second page
		scrollToBottomofThePage(scrollDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//*[@id='jobAlertsTable']/div/div[2]/div[4]"))).click(); //checking for Next page takes you to third page
		scrollToBottomofThePage(scrollDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//*[@id='jobAlertsTable']/div/div[2]/div[3]/div[7]"))).click(); //checking for 7th page of current window
		scrollToBottomofThePage(scrollDriver);
		}
}