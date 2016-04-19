package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class SignupVar_E_ScreeningDetailsPage_DL_NegativeTest extends TestScript {
	
	
	private SignupVar_E_ScreeningDetailsPage_DL_Negative SignupVar_E_ScreeningDetailsPage_DL_Negative;
	private UniqueEmailAddressGenerator uniqueEmailAddressGenerator;

	@BeforeClass
	public void beforeClass() throws Exception {

		SignupVar_E_ScreeningDetailsPage_DL_Negative = new SignupVar_E_ScreeningDetailsPage_DL_Negative(this.context, scriptUtilities);
		uniqueEmailAddressGenerator = new UniqueEmailAddressGenerator();
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
	public void signupVarEDL1(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_DL_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "DL_NUM1", "");
		assertEquals(result, "Please enter a valid Driving Licence number");
	}
	
	@Test(dataProvider = "data")
	public void signupVarEDL2(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_DL_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "DL_NUM2", "");
		assertEquals(result, "Please enter a valid Driving Licence number");
	}
	
	@Test(dataProvider = "data")
	public void signupVarEDL3(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_DL_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "DL_NUM3", "");
		assertEquals(result, "Please enter a valid Driving Licence number");
	}
	
	@Test(dataProvider = "data")
	public void signupVarEDL4(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_DL_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "DL_NUM4", "");
		assertEquals(result, "Please enter a valid Driving Licence number");
	}
	
	@Test(dataProvider = "data")
	public void signupVarEDate(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_DL_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "DL_DOB", null);
		assertEquals(result, "This field is required.");
	}

	@Test(dataProvider = "data")
	public void signupVarEMonth(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_DL_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "DL_DOM", null);
		assertEquals(result, "This field is required.");
	}
	
	@Test(dataProvider = "data")
	public void signupVarEYear(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_DL_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "DL_DOY", null);
		assertEquals(result, "This field is required.");
	}
	
	@Test(dataProvider = "data")
	public void signupVarEFirstName(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_DL_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "DL_FIRSTNAME", null);
		assertEquals(result, "Please enter a valid first name");
	}
	
	@Test(dataProvider = "data")
	public void signupVarEFiLastName(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_DL_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "DL_LASTNAME", null);
		assertEquals(result, "Please enter a valid last name");
	}
		
	@Test(dataProvider = "data")
	public void signupVarETitle(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_DL_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "DL_SALUTATION_TYPE", null);
		assertEquals(result, "Please select a title");
	}

}
