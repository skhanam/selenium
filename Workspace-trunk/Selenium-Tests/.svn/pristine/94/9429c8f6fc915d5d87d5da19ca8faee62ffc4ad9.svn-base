package uk.co.ratedpeople.test.functional.selenium.lumberjack;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.IntegrationTestUsers;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class Login extends TestScriptUtilities {

	private WebDriver driver;

	public static final String TRADESMAN = IntegrationTestUsers.TP_INTEGRATION_TEST;
	public static final String INVOICE_TRADESMAN = IntegrationTestUsers.TP_INVOICE_TEST;
	public static final String TRADESMAN_PASSWORD = IntegrationTestUsers.TP_PASSWORD;
	public static final String WRONG_TRADESMAN = "wrongTradesmen@ratedtrades.com";
	public static final String WRONG_TRADESMAN_PASSWORD = "wrongTradesmenPassword";


	public Login(SeleniumTestContext context) {
		super(context);
		driver = context.driver;
	}
	
	public void baseUrl(){
		String testUrl=context.getTestUrl();
		String testUrlLowercase = testUrl.toLowerCase();
		String lumberJackURL1 = "https://preprod.preprod/account";
		String lumberJackURL2 = "https://tradesmen-paris.uk.ratedpeople/";
		if (testUrlLowercase.indexOf("preprod") != -1) {
			goTo(lumberJackURL1);
			} else {
			    // paris and others: use stub
				goTo(lumberJackURL2);
			  }
		}

	public void login(String username, String password) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		
		driver.manage().deleteAllCookies();

		//String lumberJackURL = "http://ljpp01.ratedpeople.com/login";
		baseUrl();

		// fill in login form and submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		// ensure job alerts page load
				
	}

	public void login() throws InterruptedException {
		login(TRADESMAN, TRADESMAN_PASSWORD);
	}
	
	public void unhappylogin() throws InterruptedException {
		unHappyLogin(WRONG_TRADESMAN, WRONG_TRADESMAN_PASSWORD);
	}
	
	public void unHappyLogin(String username, String password) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		
		driver.manage().deleteAllCookies();

		baseUrl();

		// fill in login form and submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
             
		Thread.sleep(5000);
		// ensure job alerts page load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/section/div")));
		WebElement loginError = getElementIfExists(By.xpath("//html/body/div[1]/div/section/div"));
		assertNotNull(loginError);
		assertEquals(loginError.getText(), "Login failed, please try again");
		
	}
	
	public void logoutTest(String username, String password) {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		
		driver.manage().deleteAllCookies();

		String lumberJackURL = "http://ljpp01.ratedpeople.com/login";
		//rootURL = context.getTestHttpsTMMobileURL();

		// site root will redirect to /login using https
		goTo(lumberJackURL);

		// fill in login form and submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		//assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("WELCOME_TO_OUR_NEW_LOGIN_EXPERIENCE"))).getText(),"Welcome to our new logged-in Experience!");
		/*WebElement element = getElementIfExists(By.xpath("//html/body/div[2]/div/section[3]/div/div[1]/div[1]/h3"));
		assertNotNull(element);
		assertEquals(element.getText(), "Welcome to our new logged-in Experience!");*/
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		
	}

}