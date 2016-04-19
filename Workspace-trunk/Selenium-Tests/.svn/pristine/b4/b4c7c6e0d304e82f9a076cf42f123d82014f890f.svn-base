package uk.co.ratedpeople.test.functional.selenium.newjobforms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class DetailsToUse extends TestScriptUtilities {
	private String testUrl;
	public DetailsToUse(SeleniumTestContext context) {
		super(context);
		driver = context.driver;
		testUrl = context.getTestUrl();
	}
	private WebDriver driver;
	
	public void gasBDetails(){
	 goTo(testUrl + "/get-quotes-b/");
	    //select trade
	    new Select(driver.findElement(By.xpath("//*[@id='trade']"))).selectByVisibleText("Plumber");
	    //select job type
	    new Select(driver.findElement(By.xpath("//*[@id='jobtype']"))).selectByVisibleText("Gas Boiler");
	    driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("SW46BA");
	    driver.findElement(By.xpath("//*[@id='btn-next-step']")).click();
	    sleep(3000);
	    driver.switchTo().frame(0);
}
	public void enterDetails(){
		WebDriverWait wait = new WebDriverWait(context.driver, 40);
		goTo(testUrl + "/get-quotes-b/painters-decorators/london");
		new Select(driver.findElement(By.xpath("//*[@id='jobtype']"))).selectByVisibleText("Internal Painting & Decorating");
		driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("sw46ba");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='btn-next-step']"))).click();
		sleep(6000);
		driver.switchTo().frame(0);
		sleep(2000);
	}
}