package uk.co.ratedpeople.test.functional.selenium.tp;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tp.functions.SplitLogin;

public class SplitLoginTest extends TestScript {
	
	private SplitLogin splitLogin;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		splitLogin = new SplitLogin(this.context);		
	}
	
	@Test(enabled=false)
	public void testLogin() {
		splitLogin.login("aleksandr01@ratedtrades.com", "password");
		//Make sure user lands on the job alerts page
		WebElement element = splitLogin.findElement(By.partialLinkText("Job Alerts"));
		assertNotNull(element);
	}

}