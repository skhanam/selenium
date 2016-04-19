package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varA;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author sangeetha.kumar
 * 
 *         This test is for signing up the new TM with variant A on monthly plan [15/30]using driving license as his screening details
 */

public class SignUpVariantATest extends TestScript {

	private SignUpVariantA signupDrivingLicense;

	@BeforeClass
	public void beforeClass() throws Exception {

		signupDrivingLicense = new SignUpVariantA(this.context, scriptUtilities);
	}

	@DataProvider(name = "data")
	public static Object[][] postCode() {
		return new Object[][] {
				// 15/30 -> 7f5940396c13
				// 15/50 -> 0f05541d86b4
				// 0/50 -> 418486a9e548

				{ "MONTHLY", "7f5940396c13", "DL" },

				{ "MONTHLY", "7f5940396c13", "PASSPORT" }, { "MONTHLY", "7f5940396c13", "PASSPORTOTHER" },

				{ "MONTHLY", "0f05541d86b4", "DL" }, { "MONTHLY", "0f05541d86b4", "PASSPORT" }, { "MONTHLY", "0f05541d86b4", "PASSPORTOTHER" },

				{ "MONTHLY", "418486a9e548", "DL" }, { "MONTHLY", "418486a9e548", "PASSPORT" }, { "MONTHLY", "418486a9e548", "PASSPORTOTHER" },

				{ "ANNUAL", "7f5940396c13", "DL" }, { "ANNUAL", "7f5940396c13", "PASSPORT" }, { "ANNUAL", "7f5940396c13", "PASSPORTOTHER" },

				{ "ANNUAL", "0f05541d86b4", "DL" }, { "ANNUAL", "0f05541d86b4", "PASSPORT" }, { "ANNUAL", "0f05541d86b4", "PASSPORTOTHER" },

				{ "ANNUAL", "418486a9e548", "DL" }, { "ANNUAL", "418486a9e548", "PASSPORT" }, { "ANNUAL", "418486a9e548", "PASSPORTOTHER" },

		};
	}

	@Test(dataProvider = "data")
	public void signupVarATest(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		signupDrivingLicense.signUpVarA(uniqueEmailAccountName, rollOnType, tariff, screeningType);

	}

}
