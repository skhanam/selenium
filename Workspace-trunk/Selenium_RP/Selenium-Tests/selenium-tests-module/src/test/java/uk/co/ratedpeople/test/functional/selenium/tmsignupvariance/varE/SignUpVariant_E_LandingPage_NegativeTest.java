package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author olivier.renard
 * 
 *         This test is for signing up the new TM with variant E using all possible tariff combinations. This test only goes as far as testing negative
 *         scenarios on the landing page.
 */

public class SignUpVariant_E_LandingPage_NegativeTest extends TestScript {

	private SignUpVariant_E_LandingPage_Negative signupVariant_E_Negative;

	@BeforeClass
	public void beforeClass() throws Exception {

		signupVariant_E_Negative = new SignUpVariant_E_LandingPage_Negative(this.context, scriptUtilities);
	}

	@DataProvider(name = "data")
	public static Object[][] postCode() {
		return new Object[][] {
				// 15/30 -> 7f5940396c13
				// 15/50 -> 0f05541d86b4
				// 0/50 -> 418486a9e548

				{ "MONTHLY", "7f5940396c13", "DL" },
				{ "MONTHLY", "0f05541d86b4", "DL" },
				{ "MONTHLY", "418486a9e548", "DL" },

				{ "ANNUAL", "7f5940396c13", "DL" },
				{ "ANNUAL", "0f05541d86b4", "DL" },
				{ "ANNUAL", "418486a9e548", "DL" },

				{ "MONTHLY", "7f5940396c13", "PASSPORT" },
				{ "MONTHLY", "0f05541d86b4", "PASSPORT" },
				{ "MONTHLY", "418486a9e548", "PASSPORT" },

				{ "ANNUAL", "7f5940396c13", "PASSPORT" },
				{ "ANNUAL", "0f05541d86b4", "PASSPORT" },
				{ "ANNUAL", "418486a9e548", "PASSPORT" },
			};
	}

	@Test(dataProvider = "data")
	public void signupNoPostcode(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String result = signupVariant_E_Negative.signUpLandingPage(rollOnType, tariff, screeningType, "");
		assertEquals("Enter a valid UK postcode", result);
	}
	
	@Test(dataProvider = "data")
	public void signupEmptyPostcode(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		signupVariant_E_Negative.signUpLandingPage(rollOnType, tariff, screeningType, "   ");
	}

	@Test(dataProvider = "data")
	public void signupPostcodeTooLong(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		signupVariant_E_Negative.signUpLandingPage(rollOnType, tariff, screeningType, "HELLOTHERE");
	}

	@Test(dataProvider = "data")
	public void signupOutcode(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		signupVariant_E_Negative.signUpLandingPage(rollOnType, tariff, screeningType, "SW1E");
	}

}
