package uk.co.ratedpeople.test.functional.selenium.tp.functions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class PurchaseJobWithExistingCard {
	private ViewJob viewJob;
	private TestScriptUtilities scriptUtils;
	private SeleniumTestContext context;

	public PurchaseJobWithExistingCard(SeleniumTestContext context, TestScriptUtilities scriptUtils) throws IOException {
		this.context = context;
		this.scriptUtils = scriptUtils;
		viewJob = new ViewJob(context, scriptUtils);
	}

	public void purchaseJobWithExistingCard() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 10);
		//Viewed job
		viewJob.viewJob();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Buy")));
		//Now need to click buy
		WebElement element = scriptUtils.findElement(By.linkText("Buy"));
		element.click();
		Thread.sleep(5000);
		//Now buy
		scriptUtils.click(By.linkText("Confirm"));
	}
}