package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varC;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class SignUpVariant_C_AndLogin {

	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtilities;
	private Login login;
	private WebDriverWait wait;
	public static Logger logger = Logger.getLogger(SignUpVariant_C_AndLogin.class.getName());

	public SignUpVariant_C_AndLogin(SeleniumTestContext context, TestScriptUtilities scriptUtilities) {
		this.scriptUtilities = scriptUtilities;
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.testUrl = testUrl.replaceAll("http://", "https://");
		new WebDriverWait(driver, 30);
		wait = new WebDriverWait(driver, 30);
		login = new Login(scriptUtilities, context);
	}

	public void login(final String uniqueEmailAccountName, String password) throws Exception {
		System.out.println("Target environment: " + this.testUrl);
		System.out.println("username: " + uniqueEmailAccountName);
		if (testUrl.indexOf("tokyo") != -1) {
			scriptUtilities.goTo("https://tradesmen-tokyo/login");
			scriptUtilities.sleep(1000);
			scriptUtilities.fillInTextField("login_username", uniqueEmailAccountName);
			scriptUtilities.fillInTextField("login_password", password);
			scriptUtilities.click("login__login");
		} else {
			login.loginTP(uniqueEmailAccountName, password);
			scriptUtilities.sleep(2000);
		}
	}

	public void checkPostcode(String postcode) throws Exception {

		Actions builder = new Actions(driver);
		scriptUtilities.sleep(1000);
		builder.moveToElement(driver.findElement(By.linkText("Account"))).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Account Details")));
		(driver.findElement(By.linkText("Account Details"))).click();
		assertEquals(driver.findElement(By.id("postcode")).getText(), postcode.toUpperCase());
		scriptUtilities.sleep(1000);

	}

	public void checkBilling(String tariffText, String credit) throws Exception {

		Actions builder = new Actions(driver);
		scriptUtilities.sleep(1000);
		builder.moveToElement(driver.findElement(By.linkText("Account"))).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Billing")));
		(driver.findElement(By.linkText("Billing"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='membership-summary']/ul/li[1]/span")));
		if (testUrl.indexOf("tokyo") != -1) {
			tariffText = tariffText.replace("£", "Â£");
		}

		assertEquals(driver.findElement(By.xpath(".//*[@id='membership-summary']/ul/li[1]/span")).getText(), tariffText);
		assertEquals(driver.findElement(By.xpath(".//*[@id='membership-summary']/ul/li[3]/span")).getText(), credit);

		scriptUtilities.sleep(1000);

	}

	public void checkTrade(List<String> skillList) throws Exception {

		scriptUtilities.sleep(1000);

		(driver.findElement(By.linkText("Job Leads"))).click();
		scriptUtilities.sleep(1000);
		(driver.findElement(By.linkText("Edit job lead settings"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Skills & Trades"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("html/body/div[2]/div/div[3]/form/div[4]/section/fieldset/ol/li[1]/div/ul/li[1]/label")));

		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 20; j++) {
				try {
					String xpath = "html/body/div[2]/div/div[3]/form/div[4]/section/fieldset/ol/li[" + i + "]/div/ul/li[" + j + "]";

					String text = driver.findElement(By.xpath(xpath + "/label")).getText();
					if (StringUtils.isNotEmpty(text)) {
						System.out.println("text: " + text);
					}
					if (skillList.contains(text)) {
						boolean isChecked = driver.findElement(By.id(xpath + "/input")).isSelected();
						assertEquals(isChecked, true);
					} else {
						boolean isChecked = driver.findElement(By.id(xpath + "/input")).isSelected();
						assertEquals(isChecked, false);
					}

				} catch (NoSuchElementException e) {

				}
			}
		}
	}
}
