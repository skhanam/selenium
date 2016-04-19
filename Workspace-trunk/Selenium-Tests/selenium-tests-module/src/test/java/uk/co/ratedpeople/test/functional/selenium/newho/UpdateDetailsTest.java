package uk.co.ratedpeople.test.functional.selenium.newho;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.newho.pages.HomePage;
import uk.co.ratedpeople.test.functional.selenium.newho.pages.LoginPage;
import uk.co.ratedpeople.test.functional.selenium.newho.pages.MyDetailsPage;

public class UpdateDetailsTest extends LoginContext {

	private HomePage homePage = null;
	private MyDetailsPage myDetailsPage = null;

	@BeforeClass
	public void beforeClass() throws Exception {
		scriptUtilities.goTo(context.getTestHttpsNewHOURL());
	}

	@Test
	public void updatePassword() throws Exception {
		String usrname = "preprod@ratedtrades.com";
		String password = "password";

		LoginPage lp = PageFactory
				.initElements(context.driver, LoginPage.class);
		homePage = lp.doLogin(usrname, password);
		Assert.assertTrue(homePage != null, "Could not login");
		myDetailsPage = getTopMenu().clickMyDetails();
		myDetailsPage.updatePassword(password, password, password);
	}

}
