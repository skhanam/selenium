package uk.co.ratedpeople.test.functional.selenium.newjobforms.common;

import static org.testng.Assert.assertEquals;

import java.awt.Toolkit;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.DataBaseHelper;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public final class JobFormSeleniumHelper {

	private static final String JOB_USER_LAST_NAME_FIELD = "lastName";
	private static final String JOB_USER_FIRST_NAME_FIELD = "firstName";
	private static final String JOB_USER_PHONE_NUMBER_FIELD = "mobilePhone";
	private static final String JOB_USER_CONFIRM_PHONE_NUMBER_FIELD = "confirmPhone";
	private static final String JOB_USER_EMAIL_FIELD = "email";
	private static final String JOB_USER_CONFIRM_EMAIL_FIELD = "confirmEmail";
	private static final String POST_JOB_BUTTON = "btnPostJob";
	private static final String CONFIRM_POST_JOB_BUTTON = "btnConfirmJob";

	private static final String ALMOSTDONE_XPATH = ".//*[@id='contentLightBox']/div[2]/h1";
	private static final String TEXTONE_XPATH = ".//*[@id='contentLightBox']/div[2]/ul/li[1]";
	private static final String TEXTTWO_XPATH = ".//*[@id='contentLightBox']/div[2]/ul/li[2]";
	private static final String TEXTTHREE_XPATH = ".//*[@id='contentLightBox']/div[2]/ul/li[3]";
	private static final String TEXTFOUR_XPATH = ".//*[@id='contentLightBox']/div[2]/ul/li[4]";
	private static final String TEXTFIVE_XPATH = ".//*[@id='contentLightBox']/div[2]/ul/li[5]";
	private static final String HOMEOWNERUSERAGREEMENT_XPATH = ".//*[@id='contentLightBox']/div[2]/small[1]/a[1]";
	private static final String USERSERVICES_XPATH = ".//*[@id='contentLightBox']/div[2]/small[1]/a[2]";
	private static final String INDEMNITY_XPATH = ".//*[@id='contentLightBox']/div[2]/small[1]/a[3]";
	private static final String LIMITATIONOFLIABILITY_XPATH = ".//*[@id='contentLightBox']/div[2]/small[1]/a[4]";
	private static final String PRIVACY_XPATH = ".//*[@id='contentLightBox']/div[2]/small[1]/a[5]";  
	
	private static final String EDIT_JOB_XPATH = ".//*[@id='editJob']";
	private static final String CANCEL_AND_RETURN_HOME = ".//*[@id='contentLightBox']/div[2]/small[2]/a";

	private static final String ALMOSTDONE_TEXT = "Almost done ...";
	private static final String TEXTONE_TEXT = "the job details that you have provided are as informative as possible";
	private static final String TEXTTWO_TEXT = "your contact details are correct and you are ready to take their call";
	private static final String TEXTTHREE_TEXT = "you are responsible for deciding whether to use any tradesman";
	private static final String TEXTFOUR_TEXT = "you will carefully review tradesmen qualification and ratings";
	private static final String TEXTFIVE_TEXT = "if for any reason you no longer require a quote, you will withdraw your job";
	private static final String HOMEOWNERUSERAGREEMENT_TEXT = "Homeowner User Agreement";
	private static final String USERSERVICES_TEXT = "'Use of Service'";
	private static final String INDEMNITY_TEXT = "'Indemnity'";
	private static final String LIMITATIONOFLIABILITY_TEXT = "'Limitation of Liability'";
	private static final String PRIVACY_TEXT = "Privacy Policy";
	
	private static final Logger LOGGER = Logger.getLogger(JobFormSeleniumHelper.class.getName());

	public static void fillInContactPageDetailsAndPostJob(final TestScriptUtilities scriptUtils, final SeleniumTestContext context, final String firstName,
			final String lastName, final String phoneNumber, final String confirmPhoneNumber, final String emailAddress, final String confirmEmailAddress) {
		
		enterContactPageDetailsAndPostJob(scriptUtils, context, firstName, lastName, phoneNumber, confirmPhoneNumber, emailAddress, confirmEmailAddress, CONFIRM_POST_JOB_BUTTON);
	}

	public static void fillInContactPageDetailsAndEditJob(final TestScriptUtilities scriptUtils, final SeleniumTestContext context, final String firstName,
			final String lastName, final String phoneNumber, final String confirmPhoneNumber, final String emailAddress, final String confirmEmailAddress) {
		
		enterContactPageDetailsAndPostJob(scriptUtils, context, firstName, lastName, phoneNumber, confirmPhoneNumber, emailAddress, confirmEmailAddress, EDIT_JOB_XPATH);
	}
	
	public static void fillInContactPageDetailsAndCancelAndReturn(final TestScriptUtilities scriptUtils, final SeleniumTestContext context, final String firstName,
			final String lastName, final String phoneNumber, final String confirmPhoneNumber, final String emailAddress, final String confirmEmailAddress) {
		
		enterContactPageDetailsAndPostJob(scriptUtils, context, firstName, lastName, phoneNumber, confirmPhoneNumber, emailAddress, confirmEmailAddress, CANCEL_AND_RETURN_HOME);
	}

	private static void enterContactPageDetailsAndPostJob(final TestScriptUtilities scriptUtils, final SeleniumTestContext context, final String firstName, final String lastName,
			final String phoneNumber, final String confirmPhoneNumber, final String emailAddress, final String confirmEmailAddress, final String idOfButtonToPress) {
		if (StringUtils.isNotBlank(firstName)) {
			scriptUtils.fillInTextField(JOB_USER_FIRST_NAME_FIELD, firstName);
		}

		if (StringUtils.isNotBlank(lastName)) {
			scriptUtils.fillInTextField(JOB_USER_LAST_NAME_FIELD, lastName);
		}

		if (StringUtils.isNotBlank(phoneNumber)) {
			scriptUtils.fillInTextField(JOB_USER_PHONE_NUMBER_FIELD, phoneNumber);
			scriptUtils.fillInTextField(JOB_USER_CONFIRM_PHONE_NUMBER_FIELD, confirmPhoneNumber);
		}

		if (StringUtils.isNotBlank(emailAddress)) {
			scriptUtils.fillInTextField(JOB_USER_EMAIL_FIELD, emailAddress);
			scriptUtils.fillInTextField(JOB_USER_CONFIRM_EMAIL_FIELD, confirmEmailAddress);
		}

		scriptUtils.click(By.id(POST_JOB_BUTTON));
		
		if (isLightboxEnabled()) {
			if (isDataOK(firstName, lastName, phoneNumber, confirmPhoneNumber, emailAddress, confirmEmailAddress)) {
				try {
					WebDriverWait wait = new WebDriverWait(context.driver, 20);
					if (context != null) {
						
						Toolkit tool_kit = Toolkit.getDefaultToolkit();
						
						int width=(int) tool_kit.getScreenSize().getWidth();
						String msgForWidth = "Screen width: " + width;
						System.out.println(msgForWidth);
						LOGGER.info(msgForWidth);
						
						int height=(int) tool_kit.getScreenSize().getHeight();
						String msgForHeight = "Screen height: " + width;
						System.out.println(msgForHeight);
						LOGGER.info(msgForHeight);
						Dimension screen_Dimension = new Dimension(width, height);
						context.driver.manage().window().setSize(screen_Dimension);
						
						assertEquals(context.driver.findElement(By.xpath(ALMOSTDONE_XPATH)).getText(), ALMOSTDONE_TEXT);
						assertEquals(context.driver.findElement(By.xpath(TEXTONE_XPATH)).getText(), TEXTONE_TEXT);
						assertEquals(context.driver.findElement(By.xpath(TEXTTWO_XPATH)).getText(), TEXTTWO_TEXT);
						assertEquals(context.driver.findElement(By.xpath(TEXTTHREE_XPATH)).getText(), TEXTTHREE_TEXT);
						assertEquals(context.driver.findElement(By.xpath(TEXTFOUR_XPATH)).getText(), TEXTFOUR_TEXT);
						assertEquals(context.driver.findElement(By.xpath(TEXTFIVE_XPATH)).getText(), TEXTFIVE_TEXT);
						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(HOMEOWNERUSERAGREEMENT_XPATH)));
						assertEquals(context.driver.findElement(By.xpath(HOMEOWNERUSERAGREEMENT_XPATH)).getText(), HOMEOWNERUSERAGREEMENT_TEXT);
						assertEquals(context.driver.findElement(By.xpath(USERSERVICES_XPATH)).getText(), USERSERVICES_TEXT);
						assertEquals(context.driver.findElement(By.xpath(INDEMNITY_XPATH)).getText(), INDEMNITY_TEXT);
						assertEquals(context.driver.findElement(By.xpath(LIMITATIONOFLIABILITY_XPATH)).getText(), LIMITATIONOFLIABILITY_TEXT);
						assertEquals(context.driver.findElement(By.xpath(PRIVACY_XPATH)).getText(), PRIVACY_TEXT);
					}
					wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnConfirmJob")));
					scriptUtils.click(By.id("btnConfirmJob"));					
				} catch (Exception e) {
					// this is because in the negative test we do not show any lightbox
				}
			}
		}
		
		scriptUtils.sleep(2000);
	}

	private static boolean isDataOK(final String firstName, final String lastName, final String phoneNumber, final String confirmPhoneNumber,
			final String emailAddress, final String confirmEmailAddress) {
		boolean result = false;

		if (StringUtils.isNotEmpty(firstName) && StringUtils.isNotEmpty(lastName)
				&& ((StringUtils.isNotEmpty(phoneNumber)) && (phoneNumber.equals(confirmPhoneNumber)))
				&& ((StringUtils.isNotEmpty(emailAddress)) && (emailAddress.equals(confirmEmailAddress)))) {
			result = true;
		}

		return result;
	}

	public static boolean isLightboxEnabled() {
		String resultAsString = DataBaseHelper
				.executeSelectQuery("select v.value from prop_name_tbl n, prop_values_tbl v where n.name = \"jobform.confirmation.lightbox.enabled\" and n.id = v.prop_id");
		boolean result = true;
		try {
			Boolean value = Boolean.valueOf(resultAsString);
			result = value.booleanValue();
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

}
