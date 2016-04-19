package uk.co.ratedpeople.test.functional.selenium.fake.postcode;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class ViewJobPageObect {
	private Login tpLogin;
	private TestScriptUtilities scriptUtils;
	private SeleniumTestContext context;

	public ViewJobPageObect(SeleniumTestContext context, TestScriptUtilities scriptUtils) throws IOException {
		this.scriptUtils = scriptUtils;
		this.context = context;
		tpLogin = new Login(context);
	}

	public void viewJob() throws IOException {
		// SubmitJob as Existing customer
		SubmitAJobFakePostCode();
		scriptUtils.goTo(context.getTestUrl());
		tpLogin.login("sarah.pain@ratedtrades.com", "123456");
/*		 tpLogin.findElement(By.xpath("//*[@id='tpUserName']")).sendKeys("sarah.pain@ratedtrades.com");
		 tpLogin.findElement(By.xpath("//*[@id='tpPassword']")).sendKeys("123456");
		 tpLogin.findElement(By.xpath("//*[@id='login-as-tp-button']")).click();*/
		// View job
		assertEquals(tpLogin.findElement(By.linkText("View full details")).getText(), "View full details");
		WebElement element = tpLogin.findElement(By.linkText("View full details"));
		element.click();

	}

	private void SubmitAJobFakePostCode() throws IOException {
		SubmitAJobFakePostCode submitJob = new SubmitAJobFakePostCode(context, scriptUtils);
		submitJob.submitAJobFakePostCode();
	}

}