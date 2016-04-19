package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author olivier.renard
 * 
 *         This test is for signing up the new TM with variant E, with the test failing at the 3D Secure stage
 *         
 *         Note that the 0/50 tariff does not require the use of 3D secure since we are not taking a payment from the user
 */

public class SignUpVariant_E_3DSecure_NegativeTest extends TestScript {

	private static final String PASSPORT = "PASSPORT";
	private static final String ANNUAL = "ANNUAL";
	private static final String TARIFF_0_50 = "418486a9e548";
	private static final String TARIFF_15_30 = "7f5940396c13";
	private static final String TARIFF_15_50 = "0f05541d86b4";
	private static final String DRIVING_LICENSE = "DL";
	private static final String MONTHLY = "MONTHLY";
	private SignUpVariant_E_3DSecure_Negative signupDrivingLicense;
	private UniqueEmailAddressGenerator uniqueEmailAddressGenerator;

	@BeforeClass
	public void beforeClass() throws Exception {

		signupDrivingLicense = new SignUpVariant_E_3DSecure_Negative(this.context, scriptUtilities);
		uniqueEmailAddressGenerator = new UniqueEmailAddressGenerator();
	}
	
	@BeforeMethod
	public void setup() {
		context.driver.manage().deleteAllCookies();
	}

	@DataProvider(name = "data")
	public static Object[][] postCode() {
		return new Object[][] {
				{ MONTHLY, TARIFF_15_50, DRIVING_LICENSE },
				{ MONTHLY, TARIFF_15_30, DRIVING_LICENSE },
				{ MONTHLY, TARIFF_0_50, DRIVING_LICENSE },

				{ ANNUAL, TARIFF_15_30, DRIVING_LICENSE },
				{ ANNUAL, TARIFF_15_50, DRIVING_LICENSE },
				{ ANNUAL, TARIFF_0_50, DRIVING_LICENSE },

				{ MONTHLY, TARIFF_15_30, PASSPORT },
				{ MONTHLY, TARIFF_15_50, PASSPORT },
				{ MONTHLY, TARIFF_0_50, PASSPORT },

				{ ANNUAL, TARIFF_15_30, PASSPORT },
				{ ANNUAL, TARIFF_15_50, PASSPORT },
				{ ANNUAL, TARIFF_0_50, PASSPORT },
			};
	}

	@Test(dataProvider = "data")
	public void signupFailWhenPasswordIsBlank(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupDrivingLicense.signupFailWhenPasswordIsBlank(uniqueEmailAccountName, rollOnType, tariff, screeningType, "   ");
		if (TARIFF_0_50.equals(tariff)) {
			assertEquals(result, "3D Secure not required for this tariff");
		} else {
			assertEquals(result, "3D-Authentication failed. Your card vendor's rules require a successful 3D-authentication.");
		}
	}
	
	// OR-20140530 - when using a dataprovider, all tests run in the same browser session. Even though cookies were cleared before each
	// test, there were issues with PHP thinking that the user would need to be updated on the business details page (i.e. PHP would call
	// PUT instead of POST) and this would cause issues. As a result, each variant has its own test now.  
	
	@Test
	public void signupFailWhenPasswordIsEmpty_Annual_Tariff_15_50_DL() throws Exception {
		context.driver.manage().deleteAllCookies();
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupDrivingLicense.signUpFailWhenPasswordEmpty(uniqueEmailAccountName, ANNUAL, TARIFF_15_50, DRIVING_LICENSE, "");
		assertEquals(result, "password is required");		
	}
	
	@Test
	public void signupFailWhenPasswordIsEmpty_Annual_Tariff_15_30_DL() throws Exception {
		context.driver.manage().deleteAllCookies();
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupDrivingLicense.signUpFailWhenPasswordEmpty(uniqueEmailAccountName, ANNUAL, TARIFF_15_30, DRIVING_LICENSE, "");
		assertEquals(result, "password is required");
	}
	
	@Test
	public void signupFailWhenPasswordIsEmpty_Annual_Tariff_0_50_DL() throws Exception {
		context.driver.manage().deleteAllCookies();
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupDrivingLicense.signUpFailWhenPasswordEmpty(uniqueEmailAccountName, ANNUAL, TARIFF_0_50, DRIVING_LICENSE, "");
		assertEquals(result, "3D Secure not required for this tariff");
	}
	
	@Test
	public void signupFailWhenPasswordIsEmpty_Annual_Tariff_15_50_PS() throws Exception {
		context.driver.manage().deleteAllCookies();
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupDrivingLicense.signUpFailWhenPasswordEmpty(uniqueEmailAccountName, ANNUAL, TARIFF_15_50, PASSPORT, "");
		assertEquals(result, "password is required");
	}	
	
	@Test
	public void signupFailWhenPasswordIsEmpty_Annual_Tariff_15_30_PS() throws Exception {
		context.driver.manage().deleteAllCookies();
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupDrivingLicense.signUpFailWhenPasswordEmpty(uniqueEmailAccountName, ANNUAL, TARIFF_15_30, PASSPORT, "");
		assertEquals(result, "password is required");
	}
	
	@Test
	public void signupFailWhenPasswordIsEmpty_Annual_Tariff_0_50_PS() throws Exception {
		context.driver.manage().deleteAllCookies();
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupDrivingLicense.signUpFailWhenPasswordEmpty(uniqueEmailAccountName, ANNUAL, TARIFF_0_50, PASSPORT, "");
		assertEquals(result, "3D Secure not required for this tariff");
	}
	
	@Test
	public void signupFailWhenPasswordIsEmpty_Monthly_Tariff_15_50_DL() throws Exception {
		context.driver.manage().deleteAllCookies();
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupDrivingLicense.signUpFailWhenPasswordEmpty(uniqueEmailAccountName, MONTHLY, TARIFF_15_50, DRIVING_LICENSE, "");
		assertEquals(result, "password is required");
	}
	
	@Test
	public void signupFailWhenPasswordIsEmpty_Monthly_Tariff_15_30_DL() throws Exception {
		context.driver.manage().deleteAllCookies();
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupDrivingLicense.signUpFailWhenPasswordEmpty(uniqueEmailAccountName, MONTHLY, TARIFF_15_30, DRIVING_LICENSE, "");
		assertEquals(result, "password is required");
	}

	@Test
	public void signupFailWhenPasswordIsEmpty_Monthly_Tariff_0_50_DL() throws Exception {
		context.driver.manage().deleteAllCookies();
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupDrivingLicense.signUpFailWhenPasswordEmpty(uniqueEmailAccountName, MONTHLY, TARIFF_0_50, DRIVING_LICENSE, "");
		assertEquals(result, "3D Secure not required for this tariff");
	}

	@Test
	public void signupFailWhenPasswordIsEmpty_Monthly_Tariff_15_50_PS() throws Exception {
		context.driver.manage().deleteAllCookies();
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupDrivingLicense.signUpFailWhenPasswordEmpty(uniqueEmailAccountName, MONTHLY, TARIFF_15_50, PASSPORT, "");
		assertEquals(result, "password is required");
	}
	
	@Test
	public void signupFailWhenPasswordIsEmpty_Monthly_Tariff_15_30_PS() throws Exception {
		context.driver.manage().deleteAllCookies();
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupDrivingLicense.signUpFailWhenPasswordEmpty(uniqueEmailAccountName, MONTHLY, TARIFF_15_30, PASSPORT, "");
		assertEquals(result, "password is required");
	}

	@Test
	public void signupFailWhenPasswordIsEmpty_Monthly_Tariff_0_50_PS() throws Exception {
		context.driver.manage().deleteAllCookies();
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		String result = signupDrivingLicense.signUpFailWhenPasswordEmpty(uniqueEmailAccountName, MONTHLY, TARIFF_0_50, PASSPORT, "");
		assertEquals(result, "3D Secure not required for this tariff");
	}
}
