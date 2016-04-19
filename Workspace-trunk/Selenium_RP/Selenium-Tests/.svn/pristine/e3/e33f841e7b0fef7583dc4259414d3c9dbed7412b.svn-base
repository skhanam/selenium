/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.gasboilers;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

/**
 * @author christopher.bridle
 * 
 */
public class PostingJobviaGasBoilersJobFormsTest extends TestScript {
	private static final String RADIO_SOMETHING_ELSE_ID = "radioElse";
	private static final String RADIO_SERVICE_ID = "radioService";
	private static final String CERTIFICATE_YES_RADIO_ID = "certificateYes";
	private static final String NUMBER_OF_BOILER_SERVICE_BOILER_OTHER_XPATH = ".//*[@id='descService']/div[1]/div[2]/ul/li[2]/a[2]";
	private static final String SERVICE_BOILER_BOILER_MAKE_SELECT_CODE = "164";
	private static final String NUMBER_OF_BOILER_SERVICE_BOILER_XPATH = ".//*[@id='descService']/div[1]/div[1]/ul/li[1]/a[2]";
	private static final String QUANTITY_GAS_CERT_APP_OTHER_XPATH = ".//*[@id='descCertificate']/div[1]/div[2]/ul/li[2]/a[2]";
	private static final String BOILER_MAKE_SELECT_VALUE = "163";
	private static final String BOILER_PLUS_BUTTON_XPATH = ".//*[@id='descCertificate']/div[1]/div[1]/ul/li[1]/a[2]";
	private static final String RADIO_CERTIFICATE_ID = "radioCertificate";
	private static final String BOILER_MAKE_ID = "162";
	private static final String HEAT_YES_RADIO_ID = "heatYes";
	private static final String TAP_YES_RADIO_ID = "tapYes";
	private static final String RADIO_BOILER_NOT_WORKING_ID = "radioNotWorking";
	private static final String NUMBER_OF_REQUIRED_RADIATORS_SELECT_CODE = "78";
	private static final String REQUIRED_BOILER_MAKE_SELECT_CODE = "57";
	private static final String REQUIRED_COMBI_BOILER_TYPE_CODE = "52";
	private static final String INSTALLED_COMBI_BOILER_SELECT_CODE = "47";
	private static final String RADIO_INSTALL_ID = "radioInstall";
	private static final String THANK_YOU = "Thank you";
	private static final String THANK_YOU_HEADER_TEXT_ID = "header-h1";
	private static final String IM_READY_TO_HIRE_RADIO_BTN = "statusREADY_TO_HIRE";
	private static final String URGENTLY = "URGENTLY";
	private static final String BUDGET_500 = "140_LT_500";
	private static final String OWNER_LANDLORD_RADIO_ID = "ownerLANDLORD";
	private static final String POSTCODE = "AL48TD";
	private static final String ADDITIONAL_DETAILS = "additional info additional info additional info additional info additional info additional info additional info additional info";
	private static final String PHONE_NUMBER = "07973837438";
	private static final String LAST_NAME = "Little-John";
	private static final String FIRST_NAME = "Rupert";
	private static final String EMAIL_ADDRESS = "email@ratedtrades.com";
	private static final String TEXTUNDERTHANKYOU_XPATH = ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/p[1]";
	private static final String WHATHAPPENSNEXTONE_XPATH = ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[1]";
	private static final String WHATHAPPENSNEXTTWO_XPATH = ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[2]";
	private static final String WHATHAPPENSNEXTTHREE_XPATH = ".//*[@id='skill-specifc-portable-jobform']/div/section[1]/ol/li[3]";
	private static final String TEXTUNDERTHANKYOU_TEXT = "Your job has been successfully submitted for review and will be shared with tradesmen shortly. We have sent you an email with your password for Rated People. Keep it safe and use it to log in to your account. If this is not your first job posted with us, you should already have your password.";
	private static final String WHATHAPPENSNEXTONE_TEXT = "Tradesmen will review your job details";
	private static final String WHATHAPPENSNEXTTWO_TEXT = "Up to three interested tradesmen will pay to contact you";
	private static final String WHATHAPPENSNEXTTHREE_TEXT = "We'll send you an email and SMS with their profile(s) and ratings";
	private static final String  CLICKANDRETURNTOHOME = ".//*[@id='contentLightBox']/div[2]/small[2]/a";
	private static final String ErewardIMAGE_XPATH  = ".//*[@id='skill-specifc-portable-jobform']/a/img";	
	private static final String SRC_CONTAINS  ="2/post-your-job/bundles/rpglobalassets/img/research-now-banner.jpg";
	private static final String WELCOMETOEREWARDS_XPATH  =".//*[@id='Standard']/table/tbody/tr/td/span/strong";
	private static final String WELCOMETOEREWARDS_TEXT  ="Welcome to e-Rewards®!";
	private PostingJobviaGasBoilersJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobviaGasBoilersJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaGasBoilersJobFormsInstallGasBoilerTest() throws Exception {
		underTest.fillInStage1(RADIO_INSTALL_ID);

		underTest.fillInInstallGasBoilerStage2(INSTALLED_COMBI_BOILER_SELECT_CODE, REQUIRED_COMBI_BOILER_TYPE_CODE, REQUIRED_BOILER_MAKE_SELECT_CODE,
				NUMBER_OF_REQUIRED_RADIATORS_SELECT_CODE);

		underTest.fillInStage3(IM_READY_TO_HIRE_RADIO_BTN, OWNER_LANDLORD_RADIO_ID, URGENTLY, POSTCODE, ADDITIONAL_DETAILS);

		underTest.fillInStage4(BUDGET_500);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);

		ThankYouPage();


	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobFormsInstallBoilerNotWorkingTest() throws Exception {
		underTest.fillInStage1(RADIO_BOILER_NOT_WORKING_ID);

		underTest.fillInBoilerNotWorkingStage2(TAP_YES_RADIO_ID, HEAT_YES_RADIO_ID, BOILER_MAKE_ID);

		underTest.fillInStage3(IM_READY_TO_HIRE_RADIO_BTN, OWNER_LANDLORD_RADIO_ID, URGENTLY, POSTCODE, ADDITIONAL_DETAILS);

		underTest.fillInStage4(BUDGET_500);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();

		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaGasBoilersJobFormsObtainGasCertForApplianceTest() throws Exception {
		underTest.fillInStage1(RADIO_CERTIFICATE_ID);

		underTest.fillInObtainSafetyCertStage2(BOILER_PLUS_BUTTON_XPATH, BOILER_MAKE_SELECT_VALUE, QUANTITY_GAS_CERT_APP_OTHER_XPATH, ADDITIONAL_DETAILS);

		underTest.fillInStage3(IM_READY_TO_HIRE_RADIO_BTN, OWNER_LANDLORD_RADIO_ID, URGENTLY, POSTCODE, ADDITIONAL_DETAILS);

		underTest.fillInStage4(BUDGET_500);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();

		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaGasBoilersJobFormsServiceApplianceTest() throws Exception {
		underTest.fillInStage1(RADIO_SERVICE_ID);

		underTest.fillInServiceGasApplianceStage2(NUMBER_OF_BOILER_SERVICE_BOILER_XPATH, SERVICE_BOILER_BOILER_MAKE_SELECT_CODE,
				NUMBER_OF_BOILER_SERVICE_BOILER_OTHER_XPATH, ADDITIONAL_DETAILS, CERTIFICATE_YES_RADIO_ID);

		underTest.fillInStage3(IM_READY_TO_HIRE_RADIO_BTN, OWNER_LANDLORD_RADIO_ID, URGENTLY, POSTCODE, ADDITIONAL_DETAILS);

		underTest.fillInStage4(BUDGET_500);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);

		ThankYouPage();

		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaGasBoilersJobFormsSomethingElseTest() throws Exception {
		underTest.fillInStage1(RADIO_SOMETHING_ELSE_ID);

		underTest.fillInStage3(IM_READY_TO_HIRE_RADIO_BTN, OWNER_LANDLORD_RADIO_ID, URGENTLY, POSTCODE, ADDITIONAL_DETAILS);

		underTest.fillInStage4(BUDGET_500);

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);

		ThankYouPage();

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaGasBoilersJobFormsSomethingElseEditJobTest() throws Exception {
		underTest.fillInStage1(RADIO_SOMETHING_ELSE_ID);

		underTest.fillInStage3(IM_READY_TO_HIRE_RADIO_BTN, OWNER_LANDLORD_RADIO_ID, URGENTLY, POSTCODE, ADDITIONAL_DETAILS);

		underTest.fillInStage4(BUDGET_500);
		
		context.driver.findElement(
				By.xpath(".//*[@id='firstName']")).sendKeys(FIRST_NAME);	
		context.driver.findElement(
				By.xpath(".//*[@id='lastName']")).sendKeys(LAST_NAME);
		context.driver.findElement(
				By.xpath(".//*[@id='mobilePhone']")).sendKeys(PHONE_NUMBER);
		context.driver.findElement(
				By.xpath(".//*[@id='confirmPhone']")).sendKeys(PHONE_NUMBER);;
		context.driver.findElement(
				By.xpath(".//*[@id='email']")).sendKeys(EMAIL_ADDRESS);
		context.driver.findElement(
				By.xpath(".//*[@id='confirmEmail']")).sendKeys(EMAIL_ADDRESS);
		
		context.driver.findElement(
				By.xpath(".//*[@id='btnPostJob']")).click();
		
		context.driver.findElement(
				By.xpath(".//*[@id='editJob']")).click();
		
		context.driver.findElement(
				By.xpath(".//*[@id='btnPostJob']")).click();
		
		WebDriverWait waitForPageToLoad = new WebDriverWait(context.driver, 10);
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='btnConfirmJob']"))).click();
		
		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaGasBoilersJobFormsSomethingElseCancelAndReturnTest() throws Exception {
		underTest.fillInStage1(RADIO_SOMETHING_ELSE_ID);

		underTest.fillInStage3(IM_READY_TO_HIRE_RADIO_BTN, OWNER_LANDLORD_RADIO_ID, URGENTLY, POSTCODE, ADDITIONAL_DETAILS);

		underTest.fillInStage4(BUDGET_500);
		
		context.driver.findElement(
				By.xpath(".//*[@id='firstName']")).sendKeys(FIRST_NAME);	
		context.driver.findElement(
				By.xpath(".//*[@id='lastName']")).sendKeys(LAST_NAME);
		context.driver.findElement(
				By.xpath(".//*[@id='mobilePhone']")).sendKeys(PHONE_NUMBER);
		context.driver.findElement(
				By.xpath(".//*[@id='confirmPhone']")).sendKeys(PHONE_NUMBER);;
		context.driver.findElement(
				By.xpath(".//*[@id='email']")).sendKeys(EMAIL_ADDRESS);
		context.driver.findElement(
				By.xpath(".//*[@id='confirmEmail']")).sendKeys(EMAIL_ADDRESS);
		
		context.driver.findElement(
				By.xpath(".//*[@id='btnPostJob']")).click();
		
		WebDriverWait waitForPageToLoad = new WebDriverWait(context.driver, 10);
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLICKANDRETURNTOHOME))).click();
		Thread.sleep(5000);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='header-h1']/span")).getText(), "We have thousands of recommended tradesmen across the UK");

		
		
	}

	public void ThankYouPage() {

		assertEquals(context.driver.findElement(By.xpath(TEXTUNDERTHANKYOU_XPATH)).getText(), TEXTUNDERTHANKYOU_TEXT);
		assertEquals(context.driver.findElement(By.xpath(WHATHAPPENSNEXTONE_XPATH)).getText(), WHATHAPPENSNEXTONE_TEXT);
		assertEquals(context.driver.findElement(By.xpath(WHATHAPPENSNEXTTWO_XPATH)).getText(), WHATHAPPENSNEXTTWO_TEXT);
		assertEquals(context.driver.findElement(By.xpath(WHATHAPPENSNEXTTHREE_XPATH)).getText(), WHATHAPPENSNEXTTHREE_TEXT);

		// this is to test E-rewards link
				context.driver.findElement(By.xpath(ErewardIMAGE_XPATH)).isDisplayed();
				context.driver.findElement(By.xpath(ErewardIMAGE_XPATH)).getAttribute("src").contains(SRC_CONTAINS);
				
					
				String Mainwindow = context.driver.getWindowHandle(); 
				context.driver.findElement(By.xpath(ErewardIMAGE_XPATH)).click();

				for (String Erewardwindow : context.driver.getWindowHandles()) {
					context.driver.switchTo().window(Erewardwindow); 
				}

				context.driver.close(); 
				context.driver.switchTo().window(Mainwindow);
		
	}

}
