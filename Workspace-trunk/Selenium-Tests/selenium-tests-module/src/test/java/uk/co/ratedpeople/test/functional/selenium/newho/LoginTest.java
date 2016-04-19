package uk.co.ratedpeople.test.functional.selenium.newho;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.newho.pages.HomePage;
import uk.co.ratedpeople.test.functional.selenium.newho.pages.LoginPage;

public class LoginTest extends LoginContext {

	private HomePage homePage = null;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		scriptUtilities.goTo(context.getTestHttpsNewHOURL());
	}

	@Test
	public void loginTest() throws Exception {
		String usrname = "satish.sabapathi@ratedpeople.com";
		String password = "password";
		
	

		LoginPage lp = PageFactory
				.initElements(context.driver, LoginPage.class);
		
		System.out.println(context.driver.getTitle());;
		
		
		homePage = lp.doLogin(usrname, password);
		Assert.assertTrue(homePage != null, "Could not login");
		Assert.assertTrue(homePage.jobList.isDisplayed(),
				"Job list not present");

		getTopMenu().clickMyDetails();

	}

	
}
