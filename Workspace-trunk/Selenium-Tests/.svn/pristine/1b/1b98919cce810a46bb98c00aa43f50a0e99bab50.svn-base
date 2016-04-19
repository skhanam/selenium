package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varD;

/*     
@Author ARAVIND                 
*/
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varD.SignUpVariant_D_3DSecure_Negative;


public class SignUpVariant_D_3DSecure_NegativeTest extends TestScript{
	
	private SignUpVariant_D_3DSecure_Negative SignUpVariant_D_3D_Secure_Negative;

	@BeforeClass
	public void beforeClass() throws Exception {

		SignUpVariant_D_3D_Secure_Negative = new SignUpVariant_D_3DSecure_Negative(this.context, scriptUtilities);
	}

	@DataProvider(name = "data")
	public static Object[][] postCode() {
		return new Object[][] {
				// 15/30 -> 7f5940396c13
				// 15/50 -> 0f05541d86b4

				{ "MONTHLY", "7f5940396c13", "PASSPORT" },
				{ "MONTHLY", "0f05541d86b4", "PASSPORT" },

				{ "ANNUAL", "7f5940396c13", "PASSPORT" },
				{ "ANNUAL", "0f05541d86b4", "PASSPORT" },
		};
	}
	
	
	
	@Test(dataProvider = "data")
	public void signupVaXPATH3DSecurePage(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		SignUpVariant_D_3D_Secure_Negative.testPassport3DSecurePage(uniqueEmailAccountName, rollOnType, tariff, screeningType);
	}
	

}
