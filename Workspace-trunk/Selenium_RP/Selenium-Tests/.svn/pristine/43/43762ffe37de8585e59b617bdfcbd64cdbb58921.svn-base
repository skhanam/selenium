package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_flushcache;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class FlushCache extends TestScriptUtilities {
		 
	public FlushCache(SeleniumTestContext context) {
		super(context);
	}
	public void loginSupport(String userName, String password) {
		clickIfExists(By.linkText("Logout"));
		goTo(context.getSupportUrl()+"/support");
		sleep(3000);
		clear(By.xpath(".//*[@id='userName']"));
		fillInTextField("userName", userName);
		fillInTextField("password", password);
		click("btn-log-in");
	}

	public void rpPropertyUtilsFlushCache() {		   
		WebDriverWait wait = new WebDriverWait(context.driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='nav']/li[1]/a")));
	    element.click();
	    WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("CACHE")));
	    element1.click();
	    WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[4]/td/table/tbody/tr[2]/td[8]")));
	    element2.click(); 
	    System.out.println("This test has flushed the cache for the RPPropertyUtils");
	 }

}