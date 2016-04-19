package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varC;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;



public class SignUpVariant_C_DynamicTextCheck {


	private String testUrl;
	private TestScriptUtilities scriptUtilities;
	private SignUpVariantC signUpVariantC;
	private SeleniumTestContext context;
	public static Logger logger = Logger.getLogger(SignUpVariant_C_DynamicTextCheck.class.getName());

	public SignUpVariant_C_DynamicTextCheck(final SeleniumTestContext context, final TestScriptUtilities scriptUtilities) {
		this.scriptUtilities = scriptUtilities;
		this.context = context;
		this.testUrl = context.getTestUrl();
		this.testUrl = testUrl.replaceAll("http://", "https://");

		signUpVariantC = new SignUpVariantC(context, scriptUtilities);
	}

	public void signUpVarC(final String uniqueEmailAccountName, final String rollOnType, final String tariff, final String screeningType,
			final String upfrontAmount, final String freeLeadsAmount, final String monthlyRollOnAmount, final String annualRollOnAmount) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		scriptUtilities.goTo(testUrl + "/new-signup/c/landing/" + tariff);
		checkLandingPageTariffMessageAreCorrect(tariff, upfrontAmount, freeLeadsAmount, monthlyRollOnAmount, annualRollOnAmount);
		signUpVariantC.testLandingPage(uniqueEmailAccountName, tariff);
		checkBusinessTariffMessageAreCorrect(tariff, upfrontAmount, freeLeadsAmount, monthlyRollOnAmount, annualRollOnAmount);
		signUpVariantC.testBusinessDetailsPage(uniqueEmailAccountName);

		signUpVariantC.testSelectScreeningPage(uniqueEmailAccountName, screeningType);
		signUpVariantC.testScreeningDetailsPage(uniqueEmailAccountName, screeningType);
		
		checkBillingTariffMessageAreCorrect(tariff, upfrontAmount, freeLeadsAmount, monthlyRollOnAmount, annualRollOnAmount);
		signUpVariantC.testcreateTMbillingDetailsPPage(rollOnType);
		if (!"418486a9e548".equals(tariff)) {
			signUpVariantC.testSagepayPage();
			// if the 3D-secure page timed out, return and show success as it is a false positive
			if (signUpVariantC.isThreeDSecurePageTimedOut()) {
				return;
			}
		}

		signUpVariantC.testInductionwelcomePage();

	}

	private void checkLandingPageTariffMessageAreCorrect(final String tariff, final String upfrontAmount, final String freeLeadsAmount,
			final String monthlyRollOnAmount, final String annualRollOnAmount) {
		String text = scriptUtilities.findElement(By.xpath(SignupVarCXpathlocators.xpathLookup.get("TARIFF_TEXT"))).getText();

		System.out.println("tariff " + tariff);
		System.out.println("upfrontAmount " + upfrontAmount);
		System.out.println("freeLeadsAmount " + freeLeadsAmount);
		System.out.println("monthlyRollOnAmount " + monthlyRollOnAmount);
		System.out.println("annualRollOnAmount " + annualRollOnAmount);
		if (SignUpVariant_C_DynamicTextCheckTest._0_50_418486A9E548.equals(tariff)) {

			if (text != null) {
				text = text.replaceAll("\n", " ");
				assertEquals(text, "ONE MONTH FREE TRIAL JOIN NOW AND GET £50 TO SPEND ON LEADS");
			}
		} else if (SignUpVariant_C_DynamicTextCheckTest._15_30_7F5940396C13.equals(tariff)) {
			assertTrue(text.indexOf("JUST £" + monthlyRollOnAmount + " A MONTH") != -1);
			assertTrue(text.indexOf("£" + upfrontAmount) != -1);
		} else if (SignUpVariant_C_DynamicTextCheckTest._15_50_0F05541D86B4.equals(tariff)) {
			assertTrue(text.indexOf("JUST £" + monthlyRollOnAmount + " A MONTH") != -1);
			assertTrue(text.indexOf("£" + upfrontAmount) != -1);
		}
	}

	private void checkBusinessTariffMessageAreCorrect(final String tariff, final String upfrontAmount, final String freeLeadsAmount,
			final String monthlyRollOnAmount, final String annualRollOnAmount) {
		String text = scriptUtilities.findElement(By.xpath(SignupVarCXpathlocators.xpathLookup.get("BUSINESS_TARIFF_TEXT"))).getText();
		System.out.println("tariff " + tariff);
		System.out.println("upfrontAmount " + upfrontAmount);
		System.out.println("freeLeadsAmount " + freeLeadsAmount);
		System.out.println("monthlyRollOnAmount " + monthlyRollOnAmount);
		System.out.println("annualRollOnAmount " + annualRollOnAmount);

		if (SignUpVariant_C_DynamicTextCheckTest._0_50_418486A9E548.equals(tariff)) {

			assertTrue(text.indexOf("is just £" + monthlyRollOnAmount + " a month") != -1);
			assertTrue(text.indexOf("£" + monthlyRollOnAmount) != -1);
		} else if (SignUpVariant_C_DynamicTextCheckTest._15_30_7F5940396C13.equals(tariff)) {
			assertTrue(text.indexOf("is just £" + monthlyRollOnAmount + " a month") != -1);
			assertTrue(text.indexOf("£" + upfrontAmount) != -1);
		} else if (SignUpVariant_C_DynamicTextCheckTest._15_50_0F05541D86B4.equals(tariff)) {
			assertTrue(text.indexOf("is just £" + monthlyRollOnAmount + " a month") != -1);
			assertTrue(text.indexOf("£" + upfrontAmount) != -1);
		}
	}

	private void checkBillingTariffMessageAreCorrect(final String tariff, final String upfrontAmount, final String freeLeadsAmount,
			final String monthlyRollOnAmount, final String annualRollOnAmount) {

		System.out.println("tariff " + tariff);
		System.out.println("upfrontAmount " + upfrontAmount);
		System.out.println("freeLeadsAmount " + freeLeadsAmount);
		System.out.println("monthlyRollOnAmount " + monthlyRollOnAmount);
		System.out.println("annualRollOnAmount " + annualRollOnAmount);
		WebDriverWait wait = new WebDriverWait(context.driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarCXpathlocators.xpathLookup.get("BILLING_TARIFF_TEXT"))));
		String text = scriptUtilities.findElement(By.xpath(SignupVarCXpathlocators.xpathLookup.get("BILLING_TARIFF_TEXT"))).getText();
		if (SignUpVariant_C_DynamicTextCheckTest._0_50_418486A9E548.equals(tariff)) {
			assertTrue(text.indexOf("is just £" + monthlyRollOnAmount + " a month") != -1);
			assertTrue(text.indexOf("£" + freeLeadsAmount) != -1);
		} else if (SignUpVariant_C_DynamicTextCheckTest._15_30_7F5940396C13.equals(tariff)) {
			assertTrue(text.indexOf("is just £" + monthlyRollOnAmount + " a month") != -1);
			assertTrue(text.indexOf("£" + upfrontAmount) != -1);
		} else if (SignUpVariant_C_DynamicTextCheckTest._15_50_0F05541D86B4.equals(tariff)) {
			assertTrue(text.indexOf("is just £" + monthlyRollOnAmount + " a month") != -1);
			assertTrue(text.indexOf("£" + upfrontAmount) != -1);
		}
	}

}
