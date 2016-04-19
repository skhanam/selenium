package uk.co.ratedpeople.test.functional.selenium.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class ConfirmEmailSentWithExistingHoExistingTm {
	private Login login;
	private TestScriptUtilities scriptUtils;
	private WebDriver driver;
	
	public ConfirmEmailSentWithExistingHoExistingTm(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		this.driver = context.driver;
		
		login = new Login(scriptUtils, context);
	}

	 public void confirmTMEmailSentWithExistingHo() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
	
		login.loginSupport("sangeetha.kumar@ratedpeople.com", "password");
		Thread.sleep(5000);
		scriptUtils.fillInTextField("search_search", "seleniumho@ratedpeople.com");
		scriptUtils.click(By.xpath(".//*[@id='search_0']"));
		Thread.sleep(5000);
		scriptUtils.click(By.xpath(".//*[@id='subnav']/ul/li[4]/a"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='contentInner']/div/table/tbody/tr[3]/td[2]/a")));
		Thread.sleep(5000);
		scriptUtils.click(By.xpath(".//*[@id='contentInner']/div/table/tbody/tr[2]/td[2]/a"));
	    Thread.sleep(5000);
	    String getHoMailContent = scriptUtils.findElement(By.xpath(".//*[@id='contentInner']/div[1]/div/p/code")).getText();
	    Thread.sleep(5000);
	    Assert.assertTrue(getHoMailContent.contains("Submit a job via selenium tests : Full regression testing"));
	    scriptUtils.findElement(By.xpath(".//*[@id='search_search']")).clear();
	    scriptUtils.fillInTextField("search_search", "sangitmtestuser@ratedtrades.com");
	    Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='search_0']")));
		scriptUtils.click(By.xpath(".//*[@id='search_0']"));
		Thread.sleep(3000);
		scriptUtils. click(By.xpath(".//*[@id='subnav']/ul/li[5]/a"));
	    Thread.sleep(5000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='contentInner']/div/table/tbody/tr[2]/td[2]/a")));
	    scriptUtils.click(By.xpath(".//*[@id='contentInner']/div/table/tbody/tr[2]/td[2]/a"));
	    Thread.sleep(5000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='search_search']")));
	    Thread.sleep(5000);
	    String getTmMailContent = scriptUtils.findElement(By.xpath(".//*[@id='contentInner']/div[1]/div/p/code")).getText();
	    Thread.sleep(5000);
	    Assert.assertTrue(getTmMailContent.contains("selenium test"));
	    Thread.sleep(9000);
    }
}
