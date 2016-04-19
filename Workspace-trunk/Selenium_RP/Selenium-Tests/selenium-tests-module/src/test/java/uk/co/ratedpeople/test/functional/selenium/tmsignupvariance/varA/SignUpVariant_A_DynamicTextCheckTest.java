package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varA;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

// 15/30 -> 7f5940396c13
// 15/50 -> 0f05541d86b4
// 0/50 -> 418486a9e548

public class SignUpVariant_A_DynamicTextCheckTest extends TestScript {

	private static final String MONTHLY = "MONTHLY";
	private static final String ANNUAL = "ANNUAL";
	public static final String _0_50_418486A9E548 = "418486a9e548";
	public static final String _15_50_0F05541D86B4 = "0f05541d86b4";
	public static final String _15_30_7F5940396C13 = "7f5940396c13";
	private SignUpVariant_A_DynamicTextCheck signUpVariant_A_DynamicTextCheck;
	private UniqueEmailAddressGenerator uniqueEmailAddressGenerator;

	@BeforeClass
	public void beforeClass() throws Exception {
		signUpVariant_A_DynamicTextCheck = new SignUpVariant_A_DynamicTextCheck(this.context, scriptUtilities);
		uniqueEmailAddressGenerator = new UniqueEmailAddressGenerator();
	}

	@DataProvider(name = "data_15_30")
	public static Object[][] data_15_30() {
		return new Object[][] { 
				{ MONTHLY, _15_30_7F5940396C13, "DL", "15", "30", "15", "120" },
				{ ANNUAL, _15_30_7F5940396C13, "DL", "15", "30", "15", "120" }, 
			//	{ MONTHLY, _15_30_7F5940396C13, "PASSPORT", "15", "30", "15", "120" },
			//	{ ANNUAL, _15_30_7F5940396C13, "PASSPORT", "15", "30", "15", "120" },
			//	{ MONTHLY, _15_30_7F5940396C13, "PASSPORTGBR", "15", "30", "15", "120" },
			//	{ ANNUAL, _15_30_7F5940396C13, "PASSPORTGBR", "15", "30", "15", "120" },

		};
	}

	@DataProvider(name = "data_15_50")
	public static Object[][] data_15_50() {
		return new Object[][] { 
				//{ MONTHLY, _15_50_0F05541D86B4, "DL", "15", "50", "15", "120" },
			//	{ ANNUAL, _15_50_0F05541D86B4, "DL", "15", "50", "15", "120" },
				{ MONTHLY, _15_50_0F05541D86B4, "PASSPORT", "15", "50", "15", "120" },
				{ ANNUAL, _15_50_0F05541D86B4, "PASSPORT", "15", "50", "15", "120" }, 
		// { MONTHLY, _15_50_0F05541D86B4, "PASSPORTGBR", "15", "50", "15", "120" },
		// { ANNUAL, _15_50_0F05541D86B4, "PASSPORTGBR", "15", "50", "15", "120" },
		};
	}

	@DataProvider(name = "data_0_50")
	public static Object[][] postCode() {
		return new Object[][] {
				// { MONTHLY, _0_50_418486A9E548, "DL", "1 month free trial", "50", "15", "120" },
				// { ANNUAL, _0_50_418486A9E548, "DL", "1 month free trial", "50", "15", "120" },
				// { MONTHLY, _0_50_418486A9E548, "PASSPORT", "1 month free trial", "50", "15", "120" },
				// { ANNUAL, _0_50_418486A9E548, "PASSPORT", "1 month free trial", "50", "15", "120" },
				{ MONTHLY, _0_50_418486A9E548, "PASSPORTOTHER", "1 month free trial", "50", "15", "120" },
				{ ANNUAL, _0_50_418486A9E548, "PASSPORTOTHER", "1 month free trial", "50", "15", "120" },
		};
	}

	@Test(dataProvider = "data_15_30", enabled = true)
	public void testSignUpVarE_15_30(final String rollOnType, final String tariff, final String screeningType, final String upfrontAmount,
			final String freeLeadsAmount, final String monthlyRollOnAmount, final String annualRollOnAmount) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		signUpVariant_A_DynamicTextCheck.signUpVarA(uniqueEmailAccountName, rollOnType, tariff, screeningType, upfrontAmount, freeLeadsAmount,
				monthlyRollOnAmount, annualRollOnAmount);
	}

	@Test(dataProvider = "data_15_50", enabled = true)
	public void testSignUpVarE_15_50(final String rollOnType, final String tariff, final String screeningType, final String upfrontAmount,
			final String freeLeadsAmount, final String monthlyRollOnAmount, final String annualRollOnAmount) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		signUpVariant_A_DynamicTextCheck.signUpVarA(uniqueEmailAccountName, rollOnType, tariff, screeningType, upfrontAmount, freeLeadsAmount,
				monthlyRollOnAmount, annualRollOnAmount);
	}

	@Test(dataProvider = "data_0_50", enabled = true)
	public void testSignUpVarE_0_50(final String rollOnType, final String tariff, final String screeningType, final String upfrontAmount,
			final String freeLeadsAmount, final String monthlyRollOnAmount, final String annualRollOnAmount) throws Exception {
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		signUpVariant_A_DynamicTextCheck.signUpVarA(uniqueEmailAccountName, rollOnType, tariff, screeningType, upfrontAmount, freeLeadsAmount,
				monthlyRollOnAmount, annualRollOnAmount);
	}

}
