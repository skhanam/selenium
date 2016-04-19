package uk.co.ratedpeople.test.functional.selenium.tp.functions;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class Login extends TestScriptUtilities {
	
	public Login(SeleniumTestContext context) {
		super(context);
	}
	
	public void login(String userName, String password) {
		clickIfExists(By.linkText("Logout"));
		goTo(context.getTestTPURL()+"/log-in");
		sleep(3000);
		fillInTextField("tpUserName", userName);
		fillInTextField("tpPassword", password);
		click("login-as-tp-button");
	}
	
	public void googleclickID(){
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		goTo(context.getTestTPURL()+"/local/roofers?NW=g&AdID=Testingparameters&MT=1&KW=rated people roofers&gclid=helpmeplease");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login"))).click();
    	//assertEquals(driver.findElement(By.id("header-h1")).getText(), "We have thousands of recommended Roofers across the UK");
		goTo(context.getTestTPURL()+"?gclid=CIe465PsqLwCFdShtAodzVgAsg");
		sleep(3000);
		//assertTrue(selenium.isElementPresent("http://preprod.preprod/?gclid=CIe465PsqLwCFdShtAodzVgAsg"));
	}
	
		
}