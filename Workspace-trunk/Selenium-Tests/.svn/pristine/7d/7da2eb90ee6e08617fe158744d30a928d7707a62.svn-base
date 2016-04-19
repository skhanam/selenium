package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctionsGasSafePartP;

/**
 * @author ruhulla.mohammad
 */
public class AddGasCertificateBuyJobAndDeleteCertificateTest extends TestScript {

	private static final String CERTIFICATE_REG_NUM_ONE = "215772";
	private static final String USER_INTEGRATIONTEST_PASSWORD = "password";
	//private static final String USER_INTEGRATIONTEST_USERNAME = "integration.test@ratedtrades.com";
	private static final String USER_INTEGRATIONTEST_USERNAME = "AddDeleteCertificate_User@ratedtrades.com";
	private WebDriver driver;
	private TestFunctionsGasSafePartP testFunctions;
	private TestScriptUtilities scriptUtils;
	

	
	@BeforeMethod
	public void beforeMethod() {
		testFunctions = new TestFunctionsGasSafePartP(driver);
		submitGasJob();
	}
	
	
	public void submitGasJob() {
		try {
			this.driver = context.driver;
			driver.get("http://preprod.preprod/");
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 50);
			new Select(driver.findElement(By.xpath("//*[@id='trade']"))).selectByVisibleText("Heating Engineer");
			new Select(driver.findElement(By.xpath("//*[@id='jobtype']"))).selectByVisibleText("Gas Fire");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("method:submitSkillSpecificJob"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("statusREADY_TO_HIRE"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ownerOWN_AND_LIVE"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ownerOWN_AND_LIVE"))).click();
			new Select(driver.findElement(By.xpath("//*[@id='timing']"))).selectByVisibleText("Urgently");
			driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("SW1E6AU");
			driver.findElement(By.xpath("//html/body/div/div[2]/div/div/div/div/div/div/form/section/div[5]/textarea")).sendKeys(
					"Submit a job via selenium tests : For GasSafe certification regression testing .");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div/div[2]/div/div/div/div/div/div/form/section/div/p/label")));
			new Select(driver.findElement(By.xpath("//*[@id='jobBudgetCode']"))).selectByVisibleText("Under £100");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next"))).click();
			driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("ruhulla");
			driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("ho");
			driver.findElement(By.xpath("//input[@id='mobilePhone']")).sendKeys("07412463662");
			driver.findElement(By.xpath("//input[@id='confirmPhone']")).sendKeys("07412463662");
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pre.ho@ratedtrades.com");
			driver.findElement(By.xpath("//input[@id='confirmEmail']")).sendKeys("pre.ho@ratedtrades.com");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPostJob"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnConfirmJob"))).click();
			Thread.sleep(8000);
			assertEquals(context.driver.findElement(By.xpath(".//*[@id='header-h1']")).getText(),"Thank you");
			
		} catch (InterruptedException exception) {
			throw new RuntimeException("Thread sleeping was interrupted!", exception);
		}
	}

	@Test(enabled = true)
	public void addingGasCertificateBuyJobDeleteCertificate() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		driver = context.driver;
		context.driver.get(context.getTestHttpsTMMobileURL());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(USER_INTEGRATIONTEST_USERNAME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(USER_INTEGRATIONTEST_PASSWORD))).sendKeys(USER_INTEGRATIONTEST_PASSWORD);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_login"))).click();
		List<Integer> listOfCert = testFunctions.getListOfGasSafeCertificateIds(USER_INTEGRATIONTEST_USERNAME, USER_INTEGRATIONTEST_PASSWORD);
		if(listOfCert!=null && !listOfCert.isEmpty()){
			HttpResponse deleteResponse1 = testFunctions.deleteGasSafeCertification(CERTIFICATE_REG_NUM_ONE, USER_INTEGRATIONTEST_USERNAME, USER_INTEGRATIONTEST_PASSWORD);
				assertEquals(deleteResponse1.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-h1"))).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div[3]/div[2]/div[1]/a[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Buy"))).click();
//		Thread.sleep(5000);
//		assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/h2")).getText(), "Gas Certification Required");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/h2")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Certificate"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Certificate_name"))).sendKeys("Watertight");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Certificate_number"))).sendKeys(CERTIFICATE_REG_NUM_ONE);
		new Select(driver.findElement(By.id("Certificate_expiryDateDay"))).selectByVisibleText("06");
		new Select(driver.findElement(By.id("Certificate_expiryDateMonth"))).selectByVisibleText("06");
		new Select(driver.findElement(By.id("Certificate_expiryDateYear"))).selectByVisibleText("2016");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-save"))).click();
		Thread.sleep(5000);
		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Gas Safe Certificate");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Back to job alert"))).click();
		Thread.sleep(180000); // Have to wait till the Gas Certificate is validated and added, usually takes 3 mins
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Buy"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Use account balance"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link-create-invoice")));
		// delete it as we do not need to keep it.
		HttpResponse deleteResponse1 = testFunctions.deleteGasSafeCertification(CERTIFICATE_REG_NUM_ONE, USER_INTEGRATIONTEST_USERNAME, USER_INTEGRATIONTEST_PASSWORD);
		assertEquals(deleteResponse1.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

	}

}
