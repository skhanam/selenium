package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varB;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.logging.Logger;

import org.openqa.selenium.By;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;


public class SignUpVariant_B_DynamicTextCheck {


	private String testUrl;
	private TestScriptUtilities scriptUtilities;
	private SignUpVariantB signUpVariantB;
	public static Logger logger = Logger.getLogger(SignUpVariant_B_DynamicTextCheck.class.getName());

	public SignUpVariant_B_DynamicTextCheck(final SeleniumTestContext context, final TestScriptUtilities scriptUtilities) {
		this.scriptUtilities = scriptUtilities;

		this.testUrl = context.getTestUrl();
		this.testUrl = testUrl.replaceAll("http://", "https://");

		signUpVariantB = new SignUpVariantB(context, scriptUtilities);
	}

	public void signUpVarB(final String uniqueEmailAccountName, final String rollOnType, final String tariff, final String screeningType,
			final String upfrontAmount, final String freeLeadsAmount, final String monthlyRollOnAmount, final String annualRollOnAmount) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		scriptUtilities.goTo(testUrl + "/new-signup/b/" + tariff);
		checkIfRosetteIsPresentForFreeTariff(tariff);
		signUpVariantB.testLandingPage(uniqueEmailAccountName, tariff);
		signUpVariantB.testBusinessDetailsPage(uniqueEmailAccountName);

		signUpVariantB.testSelectScreeningPage(uniqueEmailAccountName, screeningType);
		signUpVariantB.testScreeningDetailsPage(uniqueEmailAccountName, screeningType);
		checkBillingTariffMessageAreCorrect(tariff);
	}

	private void checkIfRosetteIsPresentForFreeTariff(final String tariff) {
		String text = scriptUtilities.findElement(By.xpath(SignupVarBXpathlocators.xpathLookup.get("TARIFF_TEXT"))).getText();
		if (SignUpVariant_B_DynamicTextCheckTest._0_50_418486A9E548.equals(tariff)) {

			if (text != null) {
				text = text.replaceAll("\n", " ");
				assertEquals(text, "ONE MONTH FREE TRIAL JOIN NOW AND GET £50 TO SPEND ON LEADS");
			}
		} else if (SignUpVariant_B_DynamicTextCheckTest._15_30_7F5940396C13.equals(tariff)) {
			assertTrue(text.indexOf("JUST £15 A MONTH") != -1);
			assertTrue(text.indexOf("£30") != -1);
		} else if (SignUpVariant_B_DynamicTextCheckTest._15_50_0F05541D86B4.equals(tariff)) {
			assertTrue(text.indexOf("JUST £15 A MONTH") != -1);
			assertTrue(text.indexOf("£50") != -1);
		}
	}

	private void checkBillingTariffMessageAreCorrect(final String tariff) {
		String text = scriptUtilities.findElement(By.xpath(SignupVarBXpathlocators.xpathLookup.get("BILLING_TARIFF_TEXT"))).getText();
		if (SignUpVariant_B_DynamicTextCheckTest._0_50_418486A9E548.equals(tariff)) {
			assertTrue(text.indexOf("is just £15 a month") != -1);
			assertTrue(text.indexOf("£50") != -1);
		} else if (SignUpVariant_B_DynamicTextCheckTest._15_30_7F5940396C13.equals(tariff)) {
			assertTrue(text.indexOf("is just £15 a month") != -1);
			assertTrue(text.indexOf("£30") != -1);
		} else if (SignUpVariant_B_DynamicTextCheckTest._15_50_0F05541D86B4.equals(tariff)) {
			assertTrue(text.indexOf("£50") != -1);
			assertTrue(text.indexOf("is just £15 a month") != -1);
		}
	}


}
