package uk.co.ratedpeople.test.functional.selenium.tp;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tp.functions.Login;

public class LoginTest extends TestScript {
	
	private Login tpLogin;
	
	
	@BeforeClass
	public void beforeClass() throws IOException {
		tpLogin = new Login(this.context);
		
	}
	
	@Test
	public void testLogin() {
		tpLogin.login("aleksandr01jbilling@ratedtrades.com", "password");
	}
	
}