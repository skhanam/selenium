package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class SignUpVariant_E_SelectSkillsPage_Negative {

	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtilities;
	private WebDriverWait wait;

	public static Logger logger = Logger.getLogger(SignUpVariant_E_SelectSkillsPage_Negative.class.getName());

	public SignUpVariant_E_SelectSkillsPage_Negative(SeleniumTestContext context, TestScriptUtilities scriptUtilities) {
		this.scriptUtilities = scriptUtilities;
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.testUrl = testUrl.replaceAll("http://", "https://");
		this.wait = new WebDriverWait(driver, 30); // 30 seconds
	}

	public String signUp(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		System.out.println("Target environment: " + this.testUrl);
		return testLandingPage(tariff);
	}

	public String testLandingPage(final String tariff) {
		// landing page
		scriptUtilities.goTo(testUrl + "/new-signup/e/enter-postcode/" + tariff);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarEXpathlocators.xpathLookup.get("POSTCODE"))));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("VIEW_JOB_LEADS_BTN")));
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("POSTCODE"), SignupVarEXpathlocators.dataLookup.get("postcode"));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("VIEW_JOB_LEADS_BTN")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("VIEW_JOB_LEADS_FOR_YOUR_TRADE_BTN"))));
		
		// select skills page
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("VIEW_JOB_LEADS_FOR_YOUR_TRADE_BTN")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("SELECT_SKILLS_ERROR"))));
		return scriptUtilities.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("SELECT_SKILLS_ERROR"))).getText();
	}
}
