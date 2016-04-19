package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author sangeetha.kumar
 * 
 *         This test is for signing up the new TM with variant E using all possible tariff combinations. This test only goes as far as testing negative
 *         scenarios on the business details page.
 */

public class SignUpVariant_E_BusinessDetailsPage_NegativeTest extends TestScript {

	private SignUpVariant_E_BusinessDetailsPage_Negative signupVariant_E_Negative;

	@BeforeClass
	public void beforeClass() throws Exception {

		signupVariant_E_Negative = new SignUpVariant_E_BusinessDetailsPage_Negative(this.context, scriptUtilities);
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
	public void signupNoBusinessDetailsEntered(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		signupVariant_E_Negative.testBusinessDetailsPage(rollOnType, tariff, screeningType);		
	}

	@Test(dataProvider = "data")
	public void signupEmptyCompanyNameEntered(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String result = signupVariant_E_Negative.testCompanyName(rollOnType, tariff, screeningType,"    ");
		assertEquals("Please enter your company name or \"self-employed\"", result);		
	}	
	
	@Test(dataProvider = "data")
	public void signupEmptyMobile(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String result = signupVariant_E_Negative.signUpBusinessDetailsPage(rollOnType, tariff, screeningType,"   ");
		assertEquals("Please enter a valid mobile phone number.", result);
	}
	
	@Test(dataProvider = "data")
	public void signupShortMobileNum(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String result = signupVariant_E_Negative.signUpBusinessDetailsPage(rollOnType, tariff, screeningType,"07647474");
		assertEquals("Please enter a valid mobile phone number.", result);
	}
	
	@Test(dataProvider = "data")
	public void signupMobileNumWithSpace(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String result = signupVariant_E_Negative.signUpBusinessDetailsPage(rollOnType, tariff, screeningType,"07647474 ");
		assertEquals("Please enter a valid mobile phone number.", result);
	}
	
	@Test(dataProvider = "data")
	public void signupInvalidMobileNum(final String rollOnType, final String tariff, final String screeningType) throws Exception {
	String result = signupVariant_E_Negative.signUpBusinessDetailsPage(rollOnType, tariff, screeningType,"0 7647474ee");
	assertEquals("Please enter a valid mobile phone number.", result);
	}
	
	@Test(dataProvider = "data")
	public void signupNullContactName(final String rollOnType, final String tariff, final String screeningType) throws Exception {
	String result = signupVariant_E_Negative.signUpContactNameValidation(rollOnType, tariff, screeningType, "  ");
	assertEquals("Please enter a valid contact name.", result);
	}
	
	@Test(dataProvider = "data")
	public void signupWithBlankEmailId(final String rollOnType, final String tariff, final String screeningType) throws Exception {
	String result = signupVariant_E_Negative.signUpEmailIdValidation(rollOnType, tariff, screeningType,"");
	assertEquals("Please enter a valid email address.", result);
	}
	
	@Test(dataProvider = "data")
	public void signupWithInvalidEmailId(final String rollOnType, final String tariff, final String screeningType) throws Exception {
	String result = signupVariant_E_Negative.signUpEmailIdValidation(rollOnType, tariff, screeningType,"dsfsdf.com");
	assertEquals("Please enter a valid email address.", result);
	}
	
	@Test(dataProvider = "data")
	public void signupWithSpacesEmailId(final String rollOnType, final String tariff, final String screeningType) throws Exception {
	String result = signupVariant_E_Negative.signUpEmailIdValidation(rollOnType, tariff, screeningType,"dsfsdf@ df.com");
	assertEquals("Please enter a valid email address.", result);
	}
	
	
	@Test(dataProvider = "data")
	public void signupWithSpacesInFrontEmailId(final String rollOnType, final String tariff, final String screeningType) throws Exception {
	String result = signupVariant_E_Negative.signUpEmailIdValidation(rollOnType, tariff, screeningType,"  imnotvalid@address .com");
	assertEquals("Please enter a valid email address.", result);
	}
	
	@Test(dataProvider = "data")
	public void signupWithlongEmailId(final String rollOnType, final String tariff, final String screeningType) throws Exception {
	String result = signupVariant_E_Negative.signUpEmailIdValidation(rollOnType, tariff, screeningType," this_is_a_long_address_which_is_a_not_valid_this_is_a_long_address_which_is_a_not_valid_this_is_a_long_address_which_is_a_not_valid@sdsdssdsdsdsdsdsdsdsdf.com ");
	assertEquals("Please enter a valid email address.", result);
	}
	@Test(dataProvider = "data")
	public void signupWithShortEmailId(final String rollOnType, final String tariff, final String screeningType) throws Exception {
	String result = signupVariant_E_Negative.signUpEmailIdValidation(rollOnType, tariff, screeningType," a.b@gmail.com@ ");
	assertEquals("Please enter a valid email address.", result);
	}
	@Test(dataProvider = "data")
	public void signupNullPassword(final String rollOnType, final String tariff, final String screeningType) throws Exception {
	String result = signupVariant_E_Negative.signUpPasswordFieldValidation(rollOnType, tariff, screeningType, "", "");
	assertEquals("Please enter a password of 6 or more characters.", result);
	}
	
	@Test(dataProvider = "data")
	public void signupDifferntPassword(final String rollOnType, final String tariff, final String screeningType) throws Exception {
	String result = signupVariant_E_Negative.signUpPasswordFieldValidation(rollOnType, tariff, screeningType, "pass", "");
	assertEquals("Please enter at least 6 characters.", result);
	}
	
	@Test(dataProvider = "data")
	public void signupOnePasswordMissing(final String rollOnType, final String tariff, final String screeningType) throws Exception {
	String result = signupVariant_E_Negative.signUpPasswordFieldValidation(rollOnType, tariff, screeningType, "", "password");
	assertEquals("Please enter a password of 6 or more characters.", result);
	}
	@Test(dataProvider = "data")
	public void signupwithSpacesinPassword(final String rollOnType, final String tariff, final String screeningType) throws Exception {
	String result = signupVariant_E_Negative.signUpPasswordFieldValidation(rollOnType, tariff, screeningType, "", "password");
	assertEquals("Please enter a password of 6 or more characters.", result);
	}
	
	@Test(dataProvider = "data")
	public void signupNotSelectingTypesofBusiness(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		signupVariant_E_Negative.signUpNoBusinesstype(rollOnType, tariff, screeningType);		
	
	}
	
	@Test(dataProvider = "data")
	public void signupwithNotSelectingNumberOfPeople(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		signupVariant_E_Negative.signUpNoNumberOfPeople(rollOnType, tariff, screeningType);		

	}
	
	@Test(dataProvider = "data")
	public void signupwithNotSelectingHearAboutUs(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		signupVariant_E_Negative.signUpNotSelectingHearaboutUs(rollOnType, tariff, screeningType);	
	}
	
	@Test(dataProvider = "data")
	public void signupExistingMobileNum(final String rollOnType, final String tariff, final String screeningType) throws Exception {
	String result = signupVariant_E_Negative.signUpExistingMobile(rollOnType, tariff, screeningType,"07534444842");
	assertEquals("The mobile number is already in use, log in or call Customer Service.", result);		
	}
	
	@Test(dataProvider = "data")
	public void signupExistingEmailId(final String rollOnType, final String tariff, final String screeningType) throws Exception {
	String result = signupVariant_E_Negative.signUpExistingEmail(rollOnType, tariff, screeningType,"sangitm@ratedtrades.com");
	assertEquals("The email address is already in use, log in or call Customer Service.", result);
	}
		
}
