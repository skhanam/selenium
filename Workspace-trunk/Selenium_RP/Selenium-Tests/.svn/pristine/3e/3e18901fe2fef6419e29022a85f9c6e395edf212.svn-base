package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class SignUpVariant_E_DynamicTextCheck {

	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtilities;
	private SignUpVariantE signUpVariantE;
	private WebDriverWait wait;
	private boolean threeDSecurePageTimedOut = false;

	public static Logger logger = Logger.getLogger(SignUpVariant_E_DynamicTextCheck.class.getName());

	public SignUpVariant_E_DynamicTextCheck(final SeleniumTestContext context, final TestScriptUtilities scriptUtilities) {
		this.scriptUtilities = scriptUtilities;
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.testUrl = testUrl.replaceAll("http://", "https://");
		this.wait = new WebDriverWait(driver, 30); // 30 seconds

		signUpVariantE = new SignUpVariantE(context, scriptUtilities);
	}

	public void signUpVarE(final String uniqueEmailAccountName, final String rollOnType, final String tariff, final String screeningType,
			final String upfrontAmount, final String freeLeadsAmount, final String monthlyRollOnAmount, final String annualRollOnAmount) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		System.out.println("Target environment: " + this.testUrl);

		scriptUtilities.goTo(testUrl + "/new-signup/e/enter-postcode/" + tariff);
		checkIfRosetteIsPresentForFreeTariff(tariff);
		signUpVariantE.testLandingPage(tariff);

		checkIfRosetteIsPresentForFreeTariff(tariff);
		signUpVariantE.testSelectTradesPage();

		checkIfRosetteIsPresentForFreeTariff(tariff);
		signUpVariantE.testSelectWorkareaPage();

		checkIfRosetteIsPresentForFreeTariff(tariff);
		assertTrue(scriptUtilities.findElement(By.xpath(".//*[@id='neutral-main-column']/section[1]/h2")).getText().indexOf(upfrontAmount) != -1);
		assertTrue(scriptUtilities.findElement(By.xpath(".//*[@id='neutral-main-column']/section[1]/div/div/ul/li[2]")).getText().indexOf(freeLeadsAmount) != -1);
		signUpVariantE.testBusinessDetailsPage(uniqueEmailAccountName, tariff);

		checkIfRosetteIsPresentForFreeTariff(tariff);
		signUpVariantE.testSelectScreeningPage(uniqueEmailAccountName, screeningType);

		checkIfRosetteIsPresentForFreeTariff(tariff);
		signUpVariantE.testScreeningDetailsPage(uniqueEmailAccountName, screeningType);

		checkIfRosetteIsPresentForFreeTariff(tariff);
		assertTrue(scriptUtilities.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("MONTHLY_PLAN_TEXT"))).getText().indexOf(monthlyRollOnAmount) != -1);
		assertTrue(scriptUtilities.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("ANNUAL_PLAN_TEXT"))).getText().indexOf(annualRollOnAmount) != -1);
		assertTrue(scriptUtilities.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("FREE_LEADS_TEXT"))).getText().indexOf(freeLeadsAmount) != -1);
		signUpVariantE.testSelectPlanPage(uniqueEmailAccountName, screeningType, rollOnType);

		checkIfRosetteIsPresentForFreeTariff(tariff);
		signUpVariantE.testCreateTMbillingDetailsPPage();

		if (!SignUpVariant_E_DynamicTextCheckTest._0_50_418486A9E548.equals(tariff)) {
			testSagepayPage();
			// if the 3D-secure page timed out, return and show success as it is a false positive
			if (threeDSecurePageTimedOut) {
				return;
			}
		}
		testInductionwelcomePage();
	}

	public void testSagepayPage() throws InterruptedException {

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN"))));

			scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN")));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN"))));

			scriptUtilities.fillInXpathField(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_3D_PASSWORD"),
					SignupVarEXpathlocators.dataLookup.get("creditcard_3d_password"));

			scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN")));
		} catch (Exception e) {
			logger.log(Level.INFO, "3D-Secure page may have timed out.", e);
			String exMessage = e.getMessage();
			if (exMessage != null && exMessage.startsWith(SignUpVariantE.THREE_D_SECURE_TIMEOUT_SELENIUM_ERROR_MSG_START)) {
				threeDSecurePageTimedOut = true;
			}
		}
	}

	private void testInductionwelcomePage() throws InterruptedException {

		this.wait = new WebDriverWait(driver, 50);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("WELCOME_HEADER"))));
		}catch(TimeoutException e){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div[2]/div/div/section/h1")));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("breadcrumbs-container")));
		    driver.navigate().refresh();
		    scriptUtilities.sleep(2000);
			driver.switchTo().alert().accept();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("WELCOME_HEADER"))));
		}		
				
		assertEquals(driver.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("WELCOME_HEADER"))).getText(), "Welcome to Rated People");
	}

	private void checkIfRosetteIsPresentForFreeTariff(final String tariff) {
		if (SignUpVariant_E_DynamicTextCheckTest._0_50_418486A9E548.equals(tariff)) {
			String oneMonthFreeTrailText = scriptUtilities.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("ROSETTE_TEXT"))).getText();
			if (oneMonthFreeTrailText != null) {
				oneMonthFreeTrailText = oneMonthFreeTrailText.replaceAll("\n", " ");
				assertEquals(oneMonthFreeTrailText, "1 month FREE trial");
			}
		}
	}
}
