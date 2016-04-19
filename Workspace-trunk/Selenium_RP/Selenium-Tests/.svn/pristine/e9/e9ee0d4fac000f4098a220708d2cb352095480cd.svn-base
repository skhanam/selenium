package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author sangeetha.kumar
 * 
 *         This test is for signing up the new TM with variant E on monthly plan [15/30]using driving license as his screening details
 */

public class SignUpVariantETest extends TestScript {

	private SignUpVariantE signUpVariantE;

	@BeforeClass
	public void beforeClass() throws Exception {
		signUpVariantE = new SignUpVariantE(this.context, scriptUtilities);
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
				
				{ "MONTHLY", "7f5940396c13", "PASSPORTGBR" },
				{ "MONTHLY", "0f05541d86b4", "PASSPORTGBR" },
				{ "MONTHLY", "418486a9e548", "PASSPORTGBR" },

				{ "ANNUAL", "7f5940396c13", "PASSPORTGBR" },
				{ "ANNUAL", "0f05541d86b4", "PASSPORTGBR" },
				{ "ANNUAL", "418486a9e548", "PASSPORTGBR" }, 
				};
	}

	@Test(dataProvider = "data")
	public void signupVarETest(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = TestScriptUtilities.getRandomString(3) + new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		signUpVariantE.signUpVarE(uniqueEmailAccountName, rollOnType, tariff, screeningType);
	}
}
