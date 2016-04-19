package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class SignupVar_E_ScreeningDetailsPage_PASSPORTOTHER_NegativeTest extends TestScript {

	private SignupVar_E_ScreeningDetailsPage_PASSPORTOTHER_Negative signupVar_E_ScreeningDetailsPage_PASSPORT_OTHER_Negative;
	private UniqueEmailAddressGenerator uniqueEmailAddressGenerator;

	@BeforeClass
	public void beforeClass() throws Exception {

		signupVar_E_ScreeningDetailsPage_PASSPORT_OTHER_Negative = new SignupVar_E_ScreeningDetailsPage_PASSPORTOTHER_Negative(this.context, scriptUtilities);
		uniqueEmailAddressGenerator = new UniqueEmailAddressGenerator();
	}

	@DataProvider(name = "data")
	public static Object[][] postCode() {
		return new Object[][] {
		// 15/30 -> 7f5940396c13
		// 15/50 -> 0f05541d86b4
		// 0/50 -> 418486a9e548

		{ "MONTHLY", "7f5940396c13", "PASSPORT" },
		{ "MONTHLY", "0f05541d86b4", "PASSPORT" },
		{ "MONTHLY", "418486a9e548", "PASSPORT" },

		{ "ANNUAL", "7f5940396c13", "PASSPORT" },
		{ "ANNUAL", "0f05541d86b4", "PASSPORT" },
		{ "ANNUAL", "418486a9e548", "PASSPORT" },
		};
	}

	@Test(dataProvider = "data")
	public void signupVarEPASSPORTOTHER1(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupVar_E_ScreeningDetailsPage_PASSPORT_OTHER_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName,
				"PASSPORT_NUM1", "");
		assertEquals(result, "Please enter a valid passport number");
	}

	@Test(dataProvider = "data")
	public void signupVarEPASSPORTOTHER2(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupVar_E_ScreeningDetailsPage_PASSPORT_OTHER_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName,
				"PASSPORT_NUM2", "");
		assertEquals(result, "Please enter a valid passport number");
	}

	@Test(dataProvider = "data")
	public void signupVarEPASSPORTOTHER3(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupVar_E_ScreeningDetailsPage_PASSPORT_OTHER_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName,
				"PASSPORT_NUM3", "");
		assertEquals(result, "Please enter a valid passport number");
	}

	@Test(dataProvider = "data")
	public void signupVarEPASSPORTOTHER4(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupVar_E_ScreeningDetailsPage_PASSPORT_OTHER_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName,
				"PASSPORT_NUM4", "");
		assertEquals(result, "Please enter a valid passport number");
	}

	@Test(dataProvider = "data")
	public void signupVarEPASSPORTOTHER5(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupVar_E_ScreeningDetailsPage_PASSPORT_OTHER_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName,
				"PASSPORT_NUM5", "");
		assertEquals(result, "Please enter a valid passport number");
	}

	@Test(dataProvider = "data")
	public void signupVarEPASSPORTOTHER6(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupVar_E_ScreeningDetailsPage_PASSPORT_OTHER_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName,
				"PASSPORT_NUM6", "");
		assertEquals(result, "Please enter a valid passport number");
	}

	@Test(dataProvider = "data")
	public void signupVarEPASSPORTOTHER7(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupVar_E_ScreeningDetailsPage_PASSPORT_OTHER_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName,
				"PASSPORT_EXPDAY", "");
		assertEquals(result, "This field is required.");
	}

	@Test(dataProvider = "data")
	public void signupVarEPASSPORTOTHER8(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupVar_E_ScreeningDetailsPage_PASSPORT_OTHER_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName,
				"PASSPORT_EXPMON", "");
		assertEquals(result, "This field is required.");
	}

	@Test(dataProvider = "data")
	public void signupVarEPASSPORTOTHER9(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupVar_E_ScreeningDetailsPage_PASSPORT_OTHER_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName,
				"PASSPORT_EXPYEAR", "");
		assertEquals(result, "This field is required.");
	}

	@Test(dataProvider = "data")
	public void signupVarEPASSPORTOTHER10(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupVar_E_ScreeningDetailsPage_PASSPORT_OTHER_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName,
				"PASSPORT_DOB_DAY", "");
		assertEquals(result, "This field is required.");
	}

	@Test(dataProvider = "data")
	public void signupVarEPASSPORTOTHER11(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupVar_E_ScreeningDetailsPage_PASSPORT_OTHER_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName,
				"PASSPORT_DOB_MONTH", "");
		assertEquals(result, "This field is required.");
	}

	@Test(dataProvider = "data")
	public void signupVarEPASSPORTOTHER12(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupVar_E_ScreeningDetailsPage_PASSPORT_OTHER_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName,
				"PASSPORT_DOB_YEAR", "");
		assertEquals(result, "This field is required.");
	}

	@Test(dataProvider = "data")
	public void signupVarEPASSPORTOTHER13(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupVar_E_ScreeningDetailsPage_PASSPORT_OTHER_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName,
				"PASSPORT_FIRST_NAME", "");
		assertEquals(result, "Please enter a valid first name");
	}

	@Test(dataProvider = "data")
	public void signupVarEPASSPORTOTHER14(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupVar_E_ScreeningDetailsPage_PASSPORT_OTHER_Negative.signUpVarE(rollOnType, tariff, screeningType, uniqueEmailAccountName,
				"PASSPORT_LAST_NAME", "");
		assertEquals(result, "Please enter a valid last name");
	}

}
