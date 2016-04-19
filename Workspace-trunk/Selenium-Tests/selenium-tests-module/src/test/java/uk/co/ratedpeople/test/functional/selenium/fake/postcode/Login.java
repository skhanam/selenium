package uk.co.ratedpeople.test.functional.selenium.fake.postcode;

import org.openqa.selenium.By;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;


public class Login extends TestScriptUtilities {
	
	public Login(SeleniumTestContext context) {
		super(context);
	}
	
	public void login(String hoUserName, String hoPassword) {
		clickIfExists(By.linkText("Log out"));
		goTo(context.getTestUrl()+"/login");
		fillInTextField("login_username", hoUserName);
		fillInTextField("login_password", hoPassword);
		click("login__login"); 
	}
	public void login2(String hoUserName, String hoPassword) {
		//clickIfExists(By.linkText("Logout"));
		goTo("https://dev2/log-in");
		fillInTextField("login_username", hoUserName);
		fillInTextField("login_password", hoPassword);
		click("login__login"); 
	}
	
}

