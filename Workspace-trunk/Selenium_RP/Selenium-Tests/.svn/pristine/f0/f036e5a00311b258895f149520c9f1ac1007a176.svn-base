package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varD;

/*     
@Author ARAVIND                 
*/
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class SignupVar_D_ScreeningDetailsPage_DL_NegativeTest extends TestScript{
	
	private SignupVar_D_ScreeningDetailsPage_DL_Negative signupVar_D_ScreeningDetailsPage_DrivingLicence_Negative;

	@BeforeClass
	public void beforeClass() throws Exception {

		signupVar_D_ScreeningDetailsPage_DrivingLicence_Negative = new SignupVar_D_ScreeningDetailsPage_DL_Negative(this.context, scriptUtilities);
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
		};
	}
	
	
	
	@Test(dataProvider = "data")
	public void signupVarDScreeningPage(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		signupVar_D_ScreeningDetailsPage_DrivingLicence_Negative.testScreeningDetailsPage(uniqueEmailAccountName, rollOnType, tariff, screeningType);
	}
	

}
