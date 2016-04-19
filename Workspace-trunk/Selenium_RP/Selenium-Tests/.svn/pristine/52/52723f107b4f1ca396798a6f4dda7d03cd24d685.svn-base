package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest extends TestScript {
	
	
	private SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_Negative SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest;
	private UniqueEmailAddressGenerator uniqueEmailAddressGenerator;

	@BeforeClass
	public void beforeClass() throws Exception {

	SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest = new SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_Negative(this.context, scriptUtilities);
	uniqueEmailAddressGenerator = new UniqueEmailAddressGenerator();
	}

	@DataProvider(name = "data")
	public static Object[][] postCode() {
		return new Object[][] {
				// 15/30 -> 7f5940396c13
				// 15/50 -> 0f05541d86b4
				// 0/50 -> 418486a9e548

				{ "MONTHLY", "7f5940396c13", "PASSPORTGBR" },
				{ "MONTHLY", "0f05541d86b4", "PASSPORTGBR" },
				{ "MONTHLY", "418486a9e548", "PASSPORTGBR" },

				{ "ANNUAL", "7f5940396c13", "PASSPORTGBR" },
				{ "ANNUAL", "0f05541d86b4", "PASSPORTGBR" },
				{ "ANNUAL", "418486a9e548", "PASSPORTGBR" },
			};
	}

	
	@Test(dataProvider = "data")
	public void signupVarEPASSPORTGBR1(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "PASSPORTGBR_NUM1", "");
		assertEquals(result, "Please enter a valid passport number");
	}
	@Test(dataProvider = "data")
	public void signupVarEPASSPORTGBR2(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "PASSPORTGBR_NUM2", "");
		assertEquals(result, "Please enter a valid passport number");
	}
	@Test(dataProvider = "data")
	public void signupVarEPASSPORTGBR3(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "PASSPORTGBR_NUM3", "");
		assertEquals(result, "Please enter a valid passport number");
	}
	@Test(dataProvider = "data")
	public void signupVarEPASSPORTGBR4(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "PASSPORTGBR_NUM4", "");
		assertEquals(result, "Please enter a valid passport number");
	}
	@Test(dataProvider = "data")
	public void signupVarEPASSPORTGBR5(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "PASSPORTGBR_NUM5", "");
		assertEquals(result, "Please enter a valid passport number");
	}
	@Test(dataProvider = "data")
	public void signupVarEPASSPORTGBR6(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "PASSPORTGBR_NUM6", "");
		assertEquals(result, "Please enter a valid passport number");
	}
	@Test(dataProvider = "data")
	public void signupVarEPASSPORTGBR7(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "PASSPORTGBR_EXPDAY", "");
		assertEquals(result, "This field is required.");		
	}
	@Test(dataProvider = "data")
	public void signupVarEPASSPORTGBR8(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "PASSPORTGBR_EXPMON", "");
		assertEquals(result, "This field is required.");		
	}
	@Test(dataProvider = "data")
	public void signupVarEPASSPORTGBR9(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "PASSPORTGBR_EXPYEAR", "");
		assertEquals(result, "This field is required.");		
	}
	@Test(dataProvider = "data")
	public void signupVarEPASSPORTGBR10(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "PASSPORTGBR_DOB_DAY", "");
		assertEquals(result, "This field is required.");		
	}
	@Test(dataProvider = "data")
	public void signupVarEPASSPORTGBR11(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "PASSPORTGBR_DOB_MONTH", "");
		assertEquals(result, "This field is required.");		
	}
	@Test(dataProvider = "data")
	public void signupVarEPASSPORTGBR12(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "PASSPORTGBR_DOB_YEAR", "");
		assertEquals(result, "This field is required.");		
	}
	
	@Test(dataProvider = "data")
	public void signupVarEPASSPORTGBR13(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "PASSPORTGBR_FIRST_NAME", "");
		assertEquals(result, "Please enter a valid first name");		
	}
	@Test(dataProvider = "data")
	public void signupVarEPASSPORTGBR14(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_NegativeTest.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName, "PASSPORTGBR_LAST_NAME", "");
		assertEquals(result, "Please enter a valid last name");		
	}
	
	
}
