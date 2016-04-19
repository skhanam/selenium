package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author olivier.renard
 * 
 *         This test is for signing up the new TM with variant E using all possible tariff combinations. This test only goes as far as testing negative
 *         scenarios on the landing page.
 */

public class SignUpVariant_E_BillingPage_NegativeTest extends TestScript {

	private SignUpVariant_E_BillingPage_Negative signUpVariant_E_BillingPage_Negative;
	private UniqueEmailAddressGenerator uniqueEmailAddressGenerator;

	@BeforeClass
	public void beforeClass() throws Exception {

		signUpVariant_E_BillingPage_Negative = new SignUpVariant_E_BillingPage_Negative(this.context, scriptUtilities);
		uniqueEmailAddressGenerator = new UniqueEmailAddressGenerator();
	}

	@DataProvider(name = "data")
	public static Object[][] postCode() {
		return new Object[][] {
		// 15/30 -> 7f5940396c13
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
	public void signupNoCreditCardName(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signUpVariant_E_BillingPage_Negative.signUp(rollOnType, tariff, screeningType, uniqueEmailAccountName, "CREDITCARD_NAME", "");
		assertEquals(result, "Please enter your name as it appears on the card.");
	}

	@Test(dataProvider = "data")
	public void signupNoCreditNumber(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signUpVariant_E_BillingPage_Negative.signUp(rollOnType, tariff, screeningType, uniqueEmailAccountName, "CREDITCARD_NUM", "");
		assertEquals(result, "Please enter your credit card number.");
	}

	@Test(dataProvider = "data")
	public void signupNoMonthInExpirationDate(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signUpVariant_E_BillingPage_Negative.signUp(rollOnType, tariff, screeningType, uniqueEmailAccountName, "CREDITCARD_MONTH", null);
		assertEquals(result, "Card Expiry Month is required.");
	}

	@Test(dataProvider = "data")
	public void signupNoYearInExpirationDate(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signUpVariant_E_BillingPage_Negative.signUp(rollOnType, tariff, screeningType, uniqueEmailAccountName, "CREDITCARD_YEAR", null);
		assertEquals(result, "Card Expiry Year is required.");
	}

	@Test(dataProvider = "data")
	public void signupPastMonthInExpirationDate(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signUpVariant_E_BillingPage_Negative.signUp(rollOnType, tariff, screeningType, uniqueEmailAccountName, "CREDITCARD_YEAR", "1");
		assertEquals(result, "Credit Card Expiry Date validation failed");
	}

	@Test(dataProvider = "data")
	public void signupNoSecurityCode(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signUpVariant_E_BillingPage_Negative.signUp(rollOnType, tariff, screeningType, uniqueEmailAccountName, "CREDITCARD_SECURITY_CODE", "");
		assertEquals(result, "Please enter a valid Card Security Code.");
	}
}
