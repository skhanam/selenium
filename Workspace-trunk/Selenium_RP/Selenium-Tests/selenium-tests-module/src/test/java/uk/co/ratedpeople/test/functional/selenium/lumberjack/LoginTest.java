package uk.co.ratedpeople.test.functional.selenium.lumberjack;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * 
 * @author ruhulla.mohammad
 */
public class LoginTest extends TestScript {

	private Login tmLogin;

	@BeforeClass
	public void beforeClass() {
		tmLogin = new Login(this.context);
	
	}

	@Test(enabled = true) 
	public void testHappyLogin() throws InterruptedException {
		tmLogin.login();
	}
	
	@Test(enabled = true) 
	public void testUnHappyLogin() throws InterruptedException {
		tmLogin.unhappylogin();
	}

}