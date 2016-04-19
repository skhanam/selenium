package uk.co.ratedpeople.test.functional.selenium.tp;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tp.functions.Login;

public class GoogleClickIDTest extends TestScript {
	
	private Login gclid;
	
	
	@BeforeClass
	public void beforeClass() throws IOException {
		gclid=new Login(this.context);
		
	}
	
	@Test
	public void gclidTest() {
		gclid.googleclickID();
	}
	
}