package uk.co.ratedpeople.test.functional.selenium.tmmobile.functions;

/**
 * @author danthalapalli.aravind
 */
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class TimeIntentAndFirstSecondThirdBuyTestAndSignupWithScotlandPostcode extends TestScript {

	private TestForTimeIntentAndFirstSecondThirdBuy TimeIntentAndFirstSecondThirdBuyTestAndSignupWithScotlandPostcode;
	private String rootURL = null;
	private String FOR_1st_2nd_3rd_BUY = "html/body/div[1]/div[3]/div[2]/div/a/div[1]/ul/li[2]";
	private String CLICK_ONTHEJOB = "html/body/div[1]/div[3]/div[2]/div[1]/a[1]/div[1]";
	private String CHECK_WHICHBUYISIT = ".//*[@id='job-purchase-count']";
	private String CLICK_ONBUYBUTTON = "link-buy-job";
	private String CLICK_ONACCOUNTBALANCE = "html/body/div[2]/div/a[1]";
	private String CLICK_ONMENU = ".//*[@id='nav-toggle']";
	private String CLICK_ONLOGOUT = ".//*[@id='nav-logout']";
	private String POPUP_HEADING = "html/body/div[2]/div/div[1]/div/h2/strong";
	private String POPUP_XPATH = "html/body/div[2]/div";
	private String POPUP_TEXTONE_XPATH = "html/body/div[2]/div/div[1]/div/h2/p[1]";
	private String POPUP_TEXTONE_TEXT = "For a limited time only we’re reducing the prices of all leads whether you are 2nd or 3rd to buy.";
	private String POPUP_TEXTTHREE_XPATH = "html/body/div[2]/div/div[1]/div/h2/p[3]";
	private String POPUP_TEXTTHREE_TEXT = "Take advantage of these price reductions and see if you can improve your return on lead purchases.";
	private String CLOSE_POPUP_XPATH = ".//*[@id='tmBulletinOverlayDismissBtn']";
	private UniqueEmailAddressGenerator uniqueEmailAddressGenerator;

	@BeforeClass
	public void beforeClass() throws Exception {
		TimeIntentAndFirstSecondThirdBuyTestAndSignupWithScotlandPostcode = new TestForTimeIntentAndFirstSecondThirdBuy(this.context, scriptUtilities);
		uniqueEmailAddressGenerator = new UniqueEmailAddressGenerator();
	}

	@DataProvider(name = "data")
	public static Object[][] postCode() {
		return new Object[][] {
		// 15/30 -> 7f5940396c13

		{ "MONTHLY", "7f5940396c13", "DL" },

		};
	}

	@Test(alwaysRun = true)
	public void postingJobViaBathroomFirstCriticalScenario() throws Exception {
		TimeIntentAndFirstSecondThirdBuyTestAndSignupWithScotlandPostcode.postingJobViaBathroomFirstCriticalScenario();
	}

	@Test(dataProvider = "data")
	public void signup(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = TestScriptUtilities.getRandomString(3) + uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		System.out.printf("This is First TM", uniqueEmailAccountName);
		TimeIntentAndFirstSecondThirdBuyTestAndSignupWithScotlandPostcode.signUp(uniqueEmailAccountName, rollOnType, tariff, screeningType);
		LoginAsTMAndBuyJob(uniqueEmailAccountName, "password");

	}

	@Test(dataProvider = "data")
	public void signup2(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = TestScriptUtilities.getRandomString(3) + uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		System.out.printf("This is Second TM", uniqueEmailAccountName);
		TimeIntentAndFirstSecondThirdBuyTestAndSignupWithScotlandPostcode.signUp(uniqueEmailAccountName, rollOnType, tariff, screeningType);
		LoginAsTMAndBuyJob(uniqueEmailAccountName, "password");
	}

	@Test(dataProvider = "data")
	public void signup3(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		String uniqueEmailAccountName = TestScriptUtilities.getRandomString(3) + uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		System.out.printf("this is Third TM", uniqueEmailAccountName);
		TimeIntentAndFirstSecondThirdBuyTestAndSignupWithScotlandPostcode.signUp(uniqueEmailAccountName, rollOnType, tariff, screeningType);
		LoginAsTMAndBuyJob(uniqueEmailAccountName, "password");

	}

	public void LoginAsTMAndBuyJob(String uniqueEmailAccountName, String password) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);

		rootURL = context.getTestHttpsTMMobileURL();

		// site root will redirect to /login using https
		scriptUtilities.goTo(rootURL);

		// fill in login form and submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		scriptUtilities.findElement(By.id("username")).clear();
		scriptUtilities.findElement(By.id("username")).sendKeys(uniqueEmailAccountName);

		scriptUtilities.findElement(By.id("password")).clear();
		scriptUtilities.findElement(By.id("password")).sendKeys(password);

		scriptUtilities.findElement(By.id("btn_login")).click();

		Thread.sleep(10000);
		// Pop up in Scotland for price variation
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(POPUP_XPATH)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(POPUP_HEADING))).click();
		assertEquals(scriptUtilities.findElement(By.xpath(POPUP_TEXTONE_XPATH)).getText(), POPUP_TEXTONE_TEXT);
		// assertEquals(scriptUtilities.findElement(By.xpath("html/body/div[2]/div/div[1]/div/h2/p[2]")).getText(), Did you know you can see:
		// "Be the 1st, 2nd, 3rd to buy" a lead on the lead list and the full lead detail page.);
		assertEquals(scriptUtilities.findElement(By.xpath(POPUP_TEXTTHREE_XPATH)).getText(), POPUP_TEXTTHREE_TEXT);
		scriptUtilities.findElement(By.xpath(CLOSE_POPUP_XPATH)).click();

		// ensure job alerts page load
		WebElement element = scriptUtilities.getElementIfExists(By.id("header-h1"));
		assertNotNull(element);
		assertEquals(element.getText(), "Job Alerts");

		String first = "Be 1st to buy!";
		String second = "Be 2nd to buy.";
		String third = "Be 3rd to buy.";

		String firstbuy = scriptUtilities.findElement(By.xpath(FOR_1st_2nd_3rd_BUY)).getText();
		String secondbuy = scriptUtilities.findElement(By.xpath(FOR_1st_2nd_3rd_BUY)).getText();
		String thirdbuy = scriptUtilities.findElement(By.xpath(FOR_1st_2nd_3rd_BUY)).getText();

		if (first.equals(firstbuy)) {

			scriptUtilities.findElement(By.xpath(CLICK_ONTHEJOB)).click();
			assertEquals(scriptUtilities.findElement(By.xpath(CHECK_WHICHBUYISIT)).getText(), "Be 1st to buy!");
			scriptUtilities.findElement(By.id(CLICK_ONBUYBUTTON)).click();
			scriptUtilities.findElement(By.xpath(CLICK_ONACCOUNTBALANCE)).click();
			// click the navigation tab
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CLICK_ONMENU))).click();
			scriptUtilities.findElement(By.xpath(CLICK_ONMENU)).click();
			// click on logout
			scriptUtilities.findElement(By.xpath(CLICK_ONLOGOUT)).click();

		} else if (second.equals(secondbuy)) {
			scriptUtilities.findElement(By.xpath(CLICK_ONTHEJOB)).click();
			assertEquals(scriptUtilities.findElement(By.xpath(CHECK_WHICHBUYISIT)).getText(), "Be 2nd to buy.");
			scriptUtilities.findElement(By.id(CLICK_ONBUYBUTTON)).click();
			scriptUtilities.findElement(By.xpath(CLICK_ONACCOUNTBALANCE)).click();
			// click the navigation tab
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CLICK_ONMENU))).click();
			scriptUtilities.findElement(By.xpath(CLICK_ONMENU)).click();
			// click on logout
			scriptUtilities.findElement(By.xpath(CLICK_ONLOGOUT)).click();

		} else if (third.equals(thirdbuy)) {
			scriptUtilities.findElement(By.xpath(CLICK_ONTHEJOB)).click();
			assertEquals(scriptUtilities.findElement(By.xpath(CHECK_WHICHBUYISIT)).getText(), "Be 3rd to buy.");
			scriptUtilities.findElement(By.id(CLICK_ONBUYBUTTON)).click();
			scriptUtilities.findElement(By.xpath(CLICK_ONACCOUNTBALANCE)).click();
			// click the navigation tab
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CLICK_ONMENU))).click();
			scriptUtilities.findElement(By.xpath(CLICK_ONMENU)).click();
			// click on logout
			scriptUtilities.findElement(By.xpath(CLICK_ONLOGOUT)).click();

		}

	}

}
