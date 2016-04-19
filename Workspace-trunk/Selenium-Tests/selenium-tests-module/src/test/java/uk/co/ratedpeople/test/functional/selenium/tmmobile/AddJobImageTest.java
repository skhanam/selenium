package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.IntegrationTestUsers;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctions;

public class AddJobImageTest extends TestScript {

	private TestFunctions testFunctions;
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = context.driver;
		testFunctions = new TestFunctions(driver);
	}

	@Test(enabled = false)
	public void testAddHOImage() throws Exception {
		final String homeOwnerUsername = IntegrationTestUsers.HOME_OWNER_1;
		final String homeOwnerUserPassword = IntegrationTestUsers.HOME_OWNER_1_PASSWORD;
		String jobReference = testFunctions.addGardeningRPAlert("firstname", "lastName", homeOwnerUsername);
		Integer imageId = testFunctions.addHOImage(jobReference, homeOwnerUsername, homeOwnerUserPassword);
		assertNotNull(imageId);
	}

	@Test(enabled = false)
	public void testTMImage() throws Exception {
		final String tradesmanUsername = IntegrationTestUsers.TP_INTEGRATION_TEST;
		final String tradesmanUserPassword = IntegrationTestUsers.TP_PASSWORD;
		final String homeOwnerUsername = IntegrationTestUsers.HOME_OWNER_1;
		String jobReference = testFunctions.addGardeningRPAlert("firstname", "lastName", homeOwnerUsername);
		Integer imageId = testFunctions.addTMImage(jobReference, homeOwnerUsername, tradesmanUsername, tradesmanUserPassword);
		assertNotNull(imageId);
	}
}
