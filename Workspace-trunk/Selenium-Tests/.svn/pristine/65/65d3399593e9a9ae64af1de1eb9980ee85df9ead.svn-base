package uk.co.ratedpeople.test.functional.selenium.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class ConfirmEmailSentForNewHoExistingTm {
	private Login login;
	private TestScriptUtilities scriptUtils;
	private WebDriver driver;

	public ConfirmEmailSentForNewHoExistingTm(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		this.driver = context.driver;
		
		login = new Login(scriptUtils, context);
	}
	
	public void confirmTmEmailNewHoExistingTm() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		login.loginSupport("sangeetha.kumar@ratedpeople.com", "password");
		Thread.sleep(5000);
		scriptUtils.fillInTextField("search_search", "sangitmtestuser@ratedtrades.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='standardSearch']")));
		scriptUtils.click(By.xpath(".//*[@id='standardSearch']"));
		Thread.sleep(5000);
		scriptUtils.click(By.xpath(".//*[@id='subnav']/ul/li[5]/a"));
	    Thread.sleep(5000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='contentInner']/div/table/tbody/tr[2]/td[2]/a")));
	    scriptUtils.click(By.xpath(".//*[@id='contentInner']/div/table/tbody/tr[2]/td[2]/a"));
	    Thread.sleep(5000);
	    String getTmMailContent = scriptUtils.findElement(By.xpath(".//*[@id='contentInner']/div[1]/div/p/code")).getText();
	    Thread.sleep(5000);
	    Assert.assertEquals(getTmMailContent.contains("selenium test"), true);
	    Thread.sleep(9000);
	}
}
