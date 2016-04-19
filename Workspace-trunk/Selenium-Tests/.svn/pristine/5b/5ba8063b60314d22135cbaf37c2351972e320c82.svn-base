package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.ParseException;
import java.util.logging.Level;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.APIAccessConstants;
import uk.co.ratedpeople.DataBaseHelper;
import uk.co.ratedpeople.HeaderHelper;
import uk.co.ratedpeople.HttpRequestCreator;
import uk.co.ratedpeople.HttpRequestExecutor;
import uk.co.ratedpeople.UserRetriever;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScript;



/**
 * @author ruhulla.mohammad
 */
public class PMDAnnualRenewalTest extends TestScript {

	private static final String TRADESMAN_PASSWORD = "password";
	private static final String TRADESMAN_USERNAME = "PMDRenewalTest@ratedtrades.com";
	private WebDriver driver;
	private HttpRequestCreator requestCreator;
	private HttpRequestExecutor requestExecutor;
	private UserRetriever userRetriever;
	private HeaderHelper headerHelper;
	private SeleniumTestContext testContext;
	private HttpRequestExecutor executor;
		
	public PMDAnnualRenewalTest() {
		this.requestExecutor = new HttpRequestExecutor();
		try {
			this.testContext = SeleniumTestContext.getDefault();
		} catch (IOException exception) {
			LOGGER.log(Level.SEVERE, "Exception assigning TestContext to member! (will wrap this in a RuntimeException and throw that)", exception);
			throw new RuntimeException(exception);
		}
	}
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		this.requestCreator = new HttpRequestCreator(testContext);
		headerHelper = new HeaderHelper();
		executor = new HttpRequestExecutor();
		userRetriever = new UserRetriever();
		int userId = userRetriever.getUserId(TRADESMAN_USERNAME, TRADESMAN_PASSWORD);
		HttpPut request = createPutUri("PM-120", userId, TRADESMAN_USERNAME);
		HttpResponse response = executor.execute(request);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpServletResponse.SC_OK);
	}
	
	@Test(enabled = true)
	public void acceptingPMDRenewalOfferWithExistingCard() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		driver = context.driver;
		turnPMDAnnualShowNewRenewalMessageOn();
		context.driver.get(context.getTestHttpsTMMobileURL());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(TRADESMAN_USERNAME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(TRADESMAN_PASSWORD);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_login"))).click();
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);
		// Check for Plan Offers on menu and click   
		driver.findElement(By.linkText("Plan offers")).click();
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
		     driver.switchTo().window(winHandle); 
		    }
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pageWrap']/section[1]/div/h1")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pageWrap']/section[1]/div/div/article[2]/div/div/div[3]/a"))).click();
		Thread.sleep(5000);
		assertEquals(driver.findElement(By.xpath(".//*[@id='pageWrap']/section[1]/div/h1")).getText().trim(), "Confirm plan change");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pageWrap']/section/div/h1"))).isDisplayed();
        Thread.sleep(10000);
		assertEquals(driver.findElement(By.xpath(".//*[@id='pageWrap']/section/div/h1")).getText(), "Plan change successful");        
		turnPMDAnnualRenewalMessagePropertyOff();
	}
	
	@Test(enabled = true)
	public void acceptingPMDRenewalOfferWithNewCard() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		driver = context.driver;
		turnPMDAnnualShowNewRenewalMessageOn();
		context.driver.get(context.getTestHttpsTMMobileURL());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(TRADESMAN_USERNAME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(TRADESMAN_PASSWORD);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_login"))).click();
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);
		// Check for Plan Offers on menu and click   
		driver.findElement(By.linkText("Plan offers")).click();
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
		     driver.switchTo().window(winHandle); 
		    }
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pageWrap']/section[1]/div/h1")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pageWrap']/section[1]/div/div/article[2]/div/div/div[3]/a"))).click();
		Thread.sleep(5000);
		assertEquals(driver.findElement(By.xpath(".//*[@id='pageWrap']/section[1]/div/h1")).getText().trim(), "Confirm plan change");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Change card details"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newCardForm")));
		//Testing with empty Fields 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='newCardForm']/div/input"))).click();
		Thread.sleep(3000);
		assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[2]/div/div/div/div/div/article/form/ul/li[1]/div[3]")).getText().trim(), "Please select a valid card type");
		assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[2]/div/div/div/div/div/article/form/ul/li[2]/div[3]")).getText().trim(), "Please enter the name as shown on the card");
		assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[2]/div/div/div/div/div/article/form/ul/li[3]/div[3]")).getText().trim(), "Please enter a valid card number");
		assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[2]/div/div/div/div/div/article/form/ul/li[4]/div[3]/em[1]")).getText().trim(), "Please enter a valid expiry date");
		assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[2]/div/div/div/div/div/article/form/ul/li[5]/div[3]")).getText().trim(), "Please enter the 3 digit number from the back of the card");
		//Testing with minium 5 characters in name field
		new Select(driver.findElement(By.name("CreditCard[type]"))).selectByVisibleText("Visa");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_name"))).sendKeys("Ad");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cardNumber"))).sendKeys("4929000000006");
		new Select(driver.findElement(By.name("CreditCard[expiryDateMonth]"))).selectByVisibleText("05");
		new Select(driver.findElement(By.name("CreditCard[expiryDateYear]"))).selectByVisibleText("2017");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cv2"))).sendKeys("123");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='newCardForm']/div/input"))).click();
		Thread.sleep(2000);
		assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[2]/div/div/div/div/div/article/form/ul/li[2]/div[3]")).getText().trim(), "Please enter the name as shown on the card");
		//Testing with wrong Card number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_name"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_name"))).sendKeys("Admin");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cardNumber"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cardNumber"))).sendKeys("492900000000000");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='newCardForm']/div/input"))).click();
		Thread.sleep(2000);
		assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[2]/div/div/div/div/div/article/form/ul/li[3]/div[3]")).getText().trim(), "Please enter a valid card number");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cardNumber"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cardNumber"))).sendKeys("1234567");
		assertEquals(driver.findElement(By.xpath(".//html/body/div[1]/div/section[2]/div/div/div/div/div/article/form/ul/li[3]/div[3]")).getText().trim(), "Please enter a valid card number");
		Thread.sleep(2000);
		//Testing with positive test data
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cardNumber"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cardNumber"))).sendKeys("4929000000006");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCard_cv2"))).sendKeys("123");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='newCardForm']/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pageWrap']/section/div/h1"))).isDisplayed();
        Thread.sleep(10000);
       	assertEquals(driver.findElement(By.xpath(".//*[@id='pageWrap']/section/div/h1")).getText(), "Plan change successful");        
		turnPMDAnnualRenewalMessagePropertyOff();
	}
	
	private HttpPut createPutUri(String planCode, int userId, String username) throws Exception {
		String uri = "/api/v1/tradesmen/" + userId + "/membership/subscriptions/" + planCode + "/renewal?referer=mobile";
		HttpPut request = requestCreator.createPutRequestForUri(uri);
		String authnHeader = headerHelper.createAuthnHeader(username, TRADESMAN_PASSWORD);
		request.setHeader(APIAccessConstants.AUTHENTICATION_HEADER_NAME, authnHeader);
		request.setEntity(null);
		return request;
	}

	private void turnPMDAnnualShowNewRenewalMessageOn() throws Exception {
		DataBaseHelper.executeQuery("update prop_values_tbl set value = '365' where prop_id = (select id from prop_name_tbl where name = \"tm.annual.plan.days.left.for.renewal\")");
		flushTheRpPropertyCache();
		flushTheRpPropertyCacheForapp1();
		flushTheRpPropertyCacheForapp2();
		}
		
	/*** Change the tm.annual.plan.days.left.for.renewal property back to 30days so that this test can be repeatable ***/
	private void turnPMDAnnualRenewalMessagePropertyOff() throws Exception {
		DataBaseHelper.executeQuery("update prop_values_tbl set value = '30' where prop_id = (select id from prop_name_tbl where name = \"tm.annual.plan.days.left.for.renewal\")");
		flushTheRpPropertyCache();
		flushTheRpPropertyCacheForapp1();
		flushTheRpPropertyCacheForapp2();
		} 
	
	private void flushTheRpPropertyCache() throws Exception {
		String rpPropertyFlushResource = "/api/v1/rp_property/flush";
		final HttpUriRequest request = this.createPutRequestForSupportUri(rpPropertyFlushResource);
		this.assignDefaultAuthenticationHeader(request, TRADESMAN_USERNAME, TRADESMAN_PASSWORD);
		this.execute(request);
	}
	private void flushTheRpPropertyCacheForapp1() throws Exception {
		String rpPropertyFlushResource = "/api/v1/rp_property/flush";
		final HttpUriRequest request = this.createPutRequestForapp1Uri(rpPropertyFlushResource);
		this.assignDefaultAuthenticationHeader(request, TRADESMAN_USERNAME, TRADESMAN_PASSWORD);
		this.execute(request);
	}
	private void flushTheRpPropertyCacheForapp2() throws Exception {
		String rpPropertyFlushResource = "/api/v1/rp_property/flush";
		final HttpUriRequest request = this.createPutRequestForapp2Uri(rpPropertyFlushResource);
		this.assignDefaultAuthenticationHeader(request, TRADESMAN_USERNAME, TRADESMAN_PASSWORD);
		this.execute(request);
	}
	
	private void assignDefaultAuthenticationHeader(HttpUriRequest request, String username, String password) throws InvalidKeyException, SignatureException {
    	requestCreator.assignDefaultAuthenticationHeader(request, username, password);	
	}
	 
	private HttpUriRequest createPutRequestForSupportUri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		return requestCreator.createPutRequestForSupportUri(uri);
	}
	private HttpUriRequest createPutRequestForapp1Uri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		return requestCreator.createPutRequestForapp1Uri(uri);
	}
	private HttpUriRequest createPutRequestForapp2Uri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		return requestCreator.createPutRequestForapp2Uri(uri);
	}
	
	private HttpResponse execute(HttpUriRequest request) throws ClientProtocolException, IOException {
		return requestExecutor.execute(request);
	}
	protected HttpGet createGetRequestForUri(String uri, String accessKey, String accessKeyId) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		return requestCreator.createGetRequestForUri(uri, accessKey, accessKeyId);		
	}
	
}
