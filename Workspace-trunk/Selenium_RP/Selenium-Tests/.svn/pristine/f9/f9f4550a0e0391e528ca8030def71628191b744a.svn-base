package uk.co.ratedpeople.test.functional.selenium.functions;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctionsGasSafePartP;

public class BuyGasJobByAddingCertificate{
	private Login login;
	private TestScriptUtilities scriptUtils;
	private WebDriver driver;
	public static Logger logger = Logger
			.getLogger("uk.co.ratedpeople.test.functional.selenium.coresystems");
	private TestFunctionsGasSafePartP testFunctions;
	private static final String CERTIFICATE_REG_NUM_ONE = "215772";
	private static final String USER_MEMBERBENEFIT_PASSWORD = "password";
	private static final String USER_MEMBERBENEFIT_USERNAME = "memberbenefit@ratedtrades.com";

	public BuyGasJobByAddingCertificate(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		this.driver = context.driver;
		login = new Login(scriptUtils, context);
		testFunctions = new TestFunctionsGasSafePartP(driver);
	}

	public void submitGasJob() throws Exception {
		driver.get("http://preprod.preprod/");
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		new Select(driver.findElement(By.xpath("//*[@id='trade']")))
				.selectByVisibleText("Heating Engineer");
		new Select(driver.findElement(By.xpath("//*[@id='jobtype']")))
				.selectByVisibleText("Gas Fire");
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.name("method:submitSkillSpecificJob"))).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.id("statusREADY_TO_HIRE"))).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.id("ownerOWN_AND_LIVE"))).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.id("ownerOWN_AND_LIVE"))).click();
		new Select(driver.findElement(By.xpath("//*[@id='timing']")))
				.selectByVisibleText("Urgently");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(
				"CT11 8LS");
		driver.findElement(
				By.xpath("//html/body/div/div[2]/div/div/div/div/div/div/form/section/div[5]/textarea"))
				.sendKeys(
						"Submit a job via selenium tests : For GasSafe certification regression testing .");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//html/body/div/div[2]/div/div/div/div/div/div/form/section/div/p/label")));
		new Select(driver.findElement(By.xpath("//*[@id='jobBudgetCode']")))
				.selectByVisibleText("Under £100");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next")))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(
				"GasJobPost");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("HO");
		driver.findElement(By.xpath("//input[@id='mobilePhone']")).sendKeys(
				"07412463662");
		driver.findElement(By.xpath("//input[@id='confirmPhone']")).sendKeys("07412463662");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("GasJobPost_HO@ratedtrades.com");
		driver.findElement(By.xpath("//input[@id='confirmEmail']")).sendKeys("GasJobPost_HO@ratedtrades.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPostJob"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnConfirmJob"))).click();
		Thread.sleep(8000);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-h1")));
		}catch(TimeoutException e){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("breadcrumbs-container")));
		    driver.navigate().refresh();
		    scriptUtils.sleep(2000);
			driver.switchTo().alert().accept();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-h1")));
		}
		 assertEquals(driver.findElement(By.id("header-h1")).getText(), "Thank you");	

	}

	public void switchToWindow() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String parentWindow = driver.getWindowHandle();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.linkText("http://preprod.preprod/profile/member-benefits")))
				.click();
		for (String winTMWebsite : driver.getWindowHandles()) {
			if (!parentWindow.equals(winTMWebsite)) {
				driver.switchTo().window(winTMWebsite);
				wait.until(
						ExpectedConditions.visibilityOfElementLocated(By
								.linkText("Services"))).click();
				scriptUtils.sleep(3000);
				assertEquals(
						driver.findElement(
								By.xpath("//html/body/div/div[2]/section[3]/div/div/span/strong"))
								.getText(), "Gas safe");
				break;
			}
		}
		driver.switchTo().window(parentWindow);
	}

	public void buyGasJobLeadByAddingGasCertificateAndDeletingCertificate()
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		System.out.println("Tradesman Email : memberbenefit@ratedtrades.com");
		//login.loginTP("memberbenefit@ratedtrades.com", "password");
		login.loginTP(USER_MEMBERBENEFIT_USERNAME, USER_MEMBERBENEFIT_PASSWORD);
		Thread.sleep(3000);
		// Deleting Gas Certificate if already available
		List<Integer> listOfCert = testFunctions.getListOfGasSafeCertificateIds(USER_MEMBERBENEFIT_USERNAME, USER_MEMBERBENEFIT_PASSWORD);
		if(listOfCert!=null && !listOfCert.isEmpty()){
			HttpResponse deleteResponse1 = testFunctions.deleteGasSafeCertification(CERTIFICATE_REG_NUM_ONE, USER_MEMBERBENEFIT_USERNAME, USER_MEMBERBENEFIT_PASSWORD);
				assertEquals(deleteResponse1.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
		}
		
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.linkText("View full details"))).click();
		Thread.sleep(3000);
		assertEquals(
				driver.findElement(
						By.xpath("//html/body/div[2]/div/div[4]/aside/div[2]/h3"))
						.getText(), "Gas Certification Required");
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.linkText("Job Leads"))).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.linkText("Edit job lead settings"))).click();
		Thread.sleep(5000);

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.linkText("Certifications"))).click();
		Thread.sleep(3000);

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.id("addGasCert"))).click();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("[name=name]")).sendKeys("Watertight");
		driver.findElement(By.cssSelector("[name=registrationNumber]")).sendKeys("215772");
		//driver.findElement(By.name("expiryDateFormat")).sendKeys("13/03/2016");
		driver.findElement(By.cssSelector("[name=expiryDateFormat]")).sendKeys("13/03/2016");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//html/body/div[2]/div/div[3]/form/div[5]/section/div/ul/li/table/tbody/tr[2]/td[5]/strong")));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.linkText("Job Leads"))).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.linkText("View full details"))).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("buy-btn")))
				.click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.linkText("Confirm"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[text()='Contact Info']")));

		// Deleting Gas Certificate
		/*wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.linkText("Job Leads"))).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.linkText("Edit job lead settings"))).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.linkText("Certifications"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("addGasCert")));
		
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//*[@id='certificationTable']/tbody/tr[2]/td[6]/a"))).click();
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(8000);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By
						.id("addGasCert")));*/

	}

}
