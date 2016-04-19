package uk.co.ratedpeople.test.functional.selenium.newjobforms;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class JobformTestContactDetailsUtils {

	private static final String ENTER_EMAIL = "enterEmail";
	private static final String ENTER_VALID_EMAIL = "enterValidEmail";
	private static final String ENTER_UK_PHONE_NUMBER = "enterUKPhoneNumber";
	private static final String ENTER_PHONE_NUMBER = "enterPhoneNumber";
	private static final String ENTER_LAST_NAME = "enterLastName";
	private static final String ENTER_FIRST_NAME = "enterFirstName";
	private static final String POSTJOB = "postjob";
	private static final String AT_RATEDTRADES_COM = "@ratedtrades.com";
	private static final String EMAIL = "email";
	private static final String LNAME = "lname";
	private static final String MOBILE = "mobile";
	private static final String FNAME = "fname";

	@SuppressWarnings("serial")
	public static final Map<String, String> xpathLookup = new HashMap<String, String>() {
		{
			put(FNAME, ".//*[@id='firstName']");
			put(LNAME, ".//*[@id='lastName']");
			put(MOBILE, ".//*[@id='mobilePhone']");
			put(EMAIL, ".//*[@id='email']");
			put(POSTJOB, ".//*[@id='btnPostJob']");
		}
	};
	
	@SuppressWarnings("serial")
	public static Map<String, String> dataLookup = new HashMap<String, String>() {
		{
			put(FNAME, FNAME);
			put(LNAME, LNAME);
			put(MOBILE, "07512000000");
			put("headertxt", "Thank you");
			put("postcode", "rp99rp");
		}
	};

	@SuppressWarnings("serial")
	public static final Map<String, String> errorMessages = new HashMap<String, String>() {
		{
			put(ENTER_FIRST_NAME, "Please enter your first name");
			put(ENTER_LAST_NAME, "Please enter your last name");
			put(ENTER_PHONE_NUMBER, "Please enter your phone number");
			put(ENTER_UK_PHONE_NUMBER, "Please enter a valid, 11-digit UK phone number (example: 07..., 020..., 0161..., etc.)");
			put(ENTER_EMAIL, "Please enter your email address");
			put(ENTER_VALID_EMAIL, "The address entered has an invalid email address format. Please correct and try again.");
			put("CONFIRM_EMAIL", "Please confirm your email address");
			put("CONFIRM_PHONENUMBER", "Please confirm your phone number");
			put("PHONENUMBER_DOESNOTMATCH", "The phone numbers entered do not match");
			put("EMAIL_DOESNOTMATCH", "The email addresses entered do not match");


		}
	};

	public void noFirstNameEntered(final TestScript testScript) {
		
		TestScriptUtilities utils = testScript.getTestScriptUtilities();

		// no first name
		utils.clearAndFillInXpathField(
				xpathLookup.get(LNAME),
				dataLookup.get(LNAME));
		utils.clearAndFillInXpathField(
				xpathLookup.get(MOBILE),
				dataLookup.get(MOBILE));
		utils.clearAndFillInXpathField(
				xpathLookup.get(EMAIL),
				TestScriptUtilities.getRandomString(3)
						+ AT_RATEDTRADES_COM);
		utils.click(By.xpath(xpathLookup.get(POSTJOB)));

		assertEquals(
				testScript.getTestContext().driver
						.findElement(
								By.xpath(".//*[@id='contact']/div[1]/label[2]"))
						.getText(),
				errorMessages.get(ENTER_FIRST_NAME));
		assertEquals(
				testScript.getTestContext().driver
						.findElement(
								By.xpath(".//*[@id='contact']/div[4]/label[2]"))
						.getText(),
				errorMessages.get("CONFIRM_PHONENUMBER"));
		assertEquals(
				testScript.getTestContext().driver
						.findElement(
								By.xpath(".//*[@id='contact']/div[6]/label[2]"))
						.getText(),
				errorMessages.get("CONFIRM_EMAIL"));
		
		
	}

	public void noLastNameEntered(final TestScript testScript) {
		
		TestScriptUtilities utils = testScript.getTestScriptUtilities();
		
		String Email = TestScriptUtilities.getRandomString(3)+ AT_RATEDTRADES_COM ;

		// no last name
		utils.clearAndFillInXpathField(
				xpathLookup.get(FNAME),
				dataLookup.get(FNAME));
		utils.clearAndFillInXpathField(
				xpathLookup.get(MOBILE),
				dataLookup.get(MOBILE));
		
		utils.findElement(By.xpath(".//*[@id='confirmPhone']")).sendKeys("07512000008");
		utils.findElement(By.xpath(".//*[@id='confirmEmail']")).sendKeys("emaildoesnot@ratedtrades.com");
		
		utils.clearAndFillInXpathField(
				xpathLookup.get(EMAIL),
				Email);
		utils.click(By.xpath(xpathLookup.get(POSTJOB)));

		assertEquals(
				testScript.getTestContext().driver
						.findElement(
								By.xpath(".//*[@id='contact']/div[2]/label[2]"))
						.getText(),
				errorMessages.get(ENTER_LAST_NAME));
		assertEquals(
				testScript.getTestContext().driver
						.findElement(
								By.xpath(".//*[@id='contact']/div[4]/label[2]"))
						.getText(),
				errorMessages.get("PHONENUMBER_DOESNOTMATCH"));
		assertEquals(
				testScript.getTestContext().driver
						.findElement(
								By.xpath(".//*[@id='contact']/div[6]/label[2]"))
						.getText(),
				errorMessages.get("EMAIL_DOESNOTMATCH"));
	}

	public void noPhoneNumberEntered(final TestScript testScript) {
		
		TestScriptUtilities utils = testScript.getTestScriptUtilities();
		
		// no phone number
		utils.clearAndFillInXpathField(
				xpathLookup.get(FNAME),
				dataLookup.get(FNAME));
		utils.clearAndFillInXpathField(
				xpathLookup.get(LNAME),
				dataLookup.get(LNAME));
		// utils.clearAndFillInXpathField(xpathLookup.get("mobile"),
		// dataLookup.get("mobile"));
		utils.clearAndFillInXpathField(
				xpathLookup.get(EMAIL),
				TestScriptUtilities.getRandomString(3)
						+ AT_RATEDTRADES_COM);
		utils.click(By.xpath(xpathLookup.get(POSTJOB)));

		assertEquals(
				testScript.getTestContext().driver
						.findElement(
								By.xpath(".//*[@id='contact']/div[3]/div/label"))
						.getText(),
				errorMessages.get(ENTER_PHONE_NUMBER));
	}

	public void tooShortPhoneNumberEntered(final TestScript testScript) {
		
		TestScriptUtilities utils = testScript.getTestScriptUtilities();

		// too short phone number
		utils.clearAndFillInXpathField(
				xpathLookup.get(FNAME),
				dataLookup.get(FNAME));
		utils.clearAndFillInXpathField(
				xpathLookup.get(LNAME),
				dataLookup.get(LNAME));
		utils.clearAndFillInXpathField(
				xpathLookup.get(MOBILE), "078654");
		utils.clearAndFillInXpathField(
				xpathLookup.get(EMAIL),
				TestScriptUtilities.getRandomString(3)
						+ AT_RATEDTRADES_COM);
		utils.click(By.xpath(xpathLookup.get(POSTJOB)));

		assertEquals(
				testScript.getTestContext().driver
						.findElement(
								By.xpath(".//*[@id='contact']/div[3]/div/label"))
						.getText(),
				errorMessages.get(ENTER_UK_PHONE_NUMBER));
	}
	
	public void noEmailEntered(final TestScript testScript) {
		
		TestScriptUtilities utils = testScript.getTestScriptUtilities();

		// no email
		utils.clearAndFillInXpathField(
				xpathLookup.get(FNAME),
				dataLookup.get(FNAME));
		utils.clearAndFillInXpathField(
				xpathLookup.get(LNAME),
				dataLookup.get(LNAME));
		utils.clearAndFillInXpathField(
				xpathLookup.get(MOBILE),
				dataLookup.get(MOBILE));
		utils.click(By.xpath(xpathLookup.get(POSTJOB)));

		assertEquals(
				testScript.getTestContext().driver.findElement(
						By.xpath(".//*[@id='contact']/div[5]/div/label"))
						.getText(),
				errorMessages.get(ENTER_EMAIL));
	}

	public void invalidEmailEntered(final TestScript testScript) {
		
		TestScriptUtilities utils = testScript.getTestScriptUtilities();

		// invalid email
		utils.clearAndFillInXpathField(
				xpathLookup.get(FNAME),
				dataLookup.get(FNAME));
		utils.clearAndFillInXpathField(
				xpathLookup.get(LNAME),
				dataLookup.get(LNAME));
		utils.clearAndFillInXpathField(
				xpathLookup.get(MOBILE),
				dataLookup.get(MOBILE));
		utils.clearAndFillInXpathField(
				xpathLookup.get(EMAIL),
				TestScriptUtilities.getRandomString(3));
		utils.click(By.xpath(xpathLookup.get(POSTJOB)));

		assertEquals(
				testScript.getTestContext().driver.findElement(
						By.xpath(".//*[@id='contact']/div[5]/div/label"))
						.getText(),
				errorMessages.get(ENTER_VALID_EMAIL));
	}

}
