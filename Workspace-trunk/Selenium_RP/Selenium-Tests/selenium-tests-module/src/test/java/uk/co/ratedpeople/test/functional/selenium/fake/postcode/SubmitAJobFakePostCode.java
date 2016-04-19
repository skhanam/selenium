package uk.co.ratedpeople.test.functional.selenium.fake.postcode;

import static org.testng.Assert.assertEquals;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class SubmitAJobFakePostCode {
	private TestScriptUtilities scriptUtils;
	private SeleniumTestContext context;
	
	public SubmitAJobFakePostCode(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		this.context = context;
	}

	public String submitAJobFakePostCode() {
		scriptUtils.goTo(context.getTestUrl());
		scriptUtils.sleep(3000);
		// First page of job widget
		scriptUtils.selectDropdown("trade", 1);
		scriptUtils.selectDropdown("jobtype", 2);
		scriptUtils.fillInTextField("jobdescription",
				StringUtils.repeat("jobdescription", 5));
		scriptUtils.click("submit-1");
		// Second page of job widget
		scriptUtils.selectDropdown("timing", 1);
		scriptUtils.selectDropdown("range", 1);
		// enter a null postcode
		scriptUtils.fillInTextField("postcode", "");

		scriptUtils.fillInTextField("email", "sarah.pain@ratedpeople.com");
		System.out.println("Email: sarah.pain@ratedpeople.com");
		scriptUtils.click("new-user-btn");
		assertEquals(scriptUtils.findElement(By.cssSelector("Ul> li.required> label> em#postcodeError.error")).getText(),"Please enter a postcode");
		// assertEquals(driver.findElement(By.cssSelector("li.required > label >em#postcodeError.errordset")).getText(),"Please enter a valid postcode");
		assertEquals(scriptUtils.findElement(By.xpath("//*[@id='postcodeError']")).getText(), "Please enter a postcode");
		// enter a wrong postcode
		scriptUtils.fillInTextField("postcode", "RP991p");
		scriptUtils.click("new-user-btn");
		assertEquals(scriptUtils.findElement(By.xpath("//*[@id='postcodeError']")).getText(), "Please enter a valid postcode");
		scriptUtils.findElement(By.xpath("//*[@id='postcode']")).clear();
		scriptUtils.fillInTextField("postcode", "rp99rp");
		scriptUtils.click("new-user-btn");
		scriptUtils.fillInTextField("firstname", "mark");
		scriptUtils.fillInTextField("surname", "kofi");
		scriptUtils.fillInTextField("number", "07988673200");
		assertEquals(scriptUtils.findElement(By.linkText("Privacy Policy")).getText(), "Privacy Policy");
		//assertEquals(login.findElement(By.linkText("User Agreement")).getText(), "User Agreement");
		scriptUtils.click("submitUser");
		//sleep(3000);
		//login.findElement(By.xpath("//*[@id='site-navigation']/ul/li[5]/a")).click();
		return "";
	
	}

}
