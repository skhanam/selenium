package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varD;

/*     
 @Author ARAVIND 
                
 */
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class SignUpVariant_D_LandingPage_NegativeTest extends TestScript {
	
	
	private SignUpVariant_D_LandingPage_Negative SignUpVariant_D_Negative;

	@BeforeClass
	public void beforeClass() throws Exception {

		SignUpVariant_D_Negative = new SignUpVariant_D_LandingPage_Negative(this.context, scriptUtilities);
	}

	@DataProvider(name = "data")
	public static Object[][] postCode() {
		return new Object[][] {
		// 15/30 -> 7f5940396c13
		// 15/50 -> 0f05541d86b4
		// 0/50 -> 418486a9e548

		{ "MONTHLY", "7f5940396c13", "DL" },
		{ "MONTHLY", "0f05541d86b4", "PASSPORT" },
		{ "MONTHLY", "418486a9e548", "PASSPORTOTHER" },
		
 };
	}
	
	@Test(dataProvider = "data")
	public void signupVarDBusinessPage(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		SignUpVariant_D_Negative.testBusinessDetailsPage(uniqueEmailAccountName, rollOnType, tariff, screeningType);	
	
	}
}
