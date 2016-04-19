/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.gasboilers;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author shabana.khanam
 * 
 */
public class PostingJobviaGasBoilersJobForms extends TestScript {
	
	public static final String SELECT_BUDGET = "Select an approximate budget";
	public static final String ENTER_FIRSTNAME = "Please enter your first name";
	public static final String ENTER_LASTNAME = "Please enter your last name";
	public static final String ENTER_PHONE_NUMBER = "Please enter your phone number";
	public static final String CONFIRM_PHONE_NUMBER = "Please confirm your phone number";
	public static final String ENTER_UK_PHONE_NUMBER = "Please enter a valid, 11-digit UK phone number (example: 07..., 020..., 0161..., etc.)";
	public static final String ENTER_VALID_PHONE_NUMBER = "Please enter a valid, 11-digit UK phone number (example: 07..., 020..., 0161..., etc.)";
	public static final String ENTER_EMAIL = "Please enter your email address";
	public static final String CONFIRM_EMAIL = "Please confirm your email address";
	public static final String ENTER_VALID_EMAIL = "The address entered has an invalid email address format. Please correct and try again.";
	
	public static final String FIRSTNAME_ERROR_XPATH = ".//*[@id='contact']/div[1]/label[2]";
	public static final String LASTNAME_ERROR_XPATH = ".//*[@id='contact']/div[2]/label[2]";
	public static final String PHONE_NUMBER_ERROR_XPATH = ".//*[@id='contact']/div[3]/div/label";
	public static final String CONFIRM_PHONE_NUMBER_ERROR_XPATH = ".//*[@id='contact']/div[4]/label[2]";
	public static final String EMAIL_ERROR_XPATH = ".//*[@id='contact']/div[5]/div/label";
	public static final String CONFIRM_EMAIL_ERROR_XPATH = ".//*[@id='contact']/div[6]/label[2]";

	private static final String STAGE2_GAS_SERVICE_ADDITIONAL_INFO_TEXT_AREA = ".//*[@id='descService']/div[1]/div[2]/ul/li[2]/div/textarea";
	private static final String SERVICE_BOILER_MAKE_SELECT_ID = "serviceBoilerMake";
	private static final String STAGE2_GAS_CERT_ADDITIONAL_INFO_TEXT_AREA = ".//*[@id='descCertificate']/div[1]/div[2]/ul/li[2]/div/textarea";
	private static final String HOT_WATER_STAGE2_NEXT_BUTTON_XPATH = ".//*[@id='descNotWorking']/div[4]/button[2]";
	private static final String RADIATOR_SELECT_ID = "radiator";
	private static final String BOILER_MAKE_INTSALLED_SELECT_ID = "boilerMakeInstalled";
	private static final String CERTIFICATE_BOILER_MAKE_SELECT_ID = "certificateBoilerMake";
	private static final String BOILER_MAKE_SELECT_ID = "boilerMake";
	private static final String BOILER_TYPE_SELECT_ID = "boilerType";
	private static final String BOILER_CURRENT_SELECT_ID = "boilerCurrent";
	private static final String STAGE1_SELECT_BUTTON_ID = "stage1SelectButton";
	private static final String ADDITIONAL_INFO_TEXT_AREA_XPATH = ".//*[@id='additionalDetailsContainer']/textarea";
	private static final String POSTCODE_FIELD = "postcode";
	private static final String SCREEN2_NEXT_BUTTON = ".//*[@id='descInstall']/div[5]/button[2]";
	private static final String SCREEN2_GAS_CERT_NEXT_BUTTON = ".//*[@id='descCertificate']/div[3]/button[2]";
	private static final String SCREEN2_GAS_APP_NEXT_BUTTON = ".//*[@id='descService']/div[4]/button[2]";

	private static final String SCREEN3_NEXT_BUTTON = ".//*[@id='stage2']/div[6]/div/button[1]";
	private static final String SCREEN4_NEXT_BUTTON = ".//*[@id='stage3']/div[2]/div/button[1]";

	private static final String BUDGET_SELECT_ELEMENT = "jobBudgetCode";
	private static final String TIMING_SELECT_ELEMENT = "timing";
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;
	private static final String HEATING_BOILERS_TRADE_CODE = "heating";
	private static final String GAS_BOILERS_SKILL_TYPE_ID = "140";

	public PostingJobviaGasBoilersJobForms(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
		this.driver = driver;
		this.testUrl = testUrl;
		this.scriptUtils = scriptUtils;
	}

	public void fillInStage1(String radioButtonId) {
		if (StringUtils.isNotBlank(radioButtonId)) {
			scriptUtils.click(By.id(radioButtonId));
		}

		scriptUtils.click(By.id(STAGE1_SELECT_BUTTON_ID));
	}

	public void fillInInstallGasBoilerStage2(String boilerTypeInstalled, String boilerTypeRequired, String boilerMakeRequired, String numberOfRadiators) {
		if (StringUtils.isNotBlank(boilerTypeInstalled)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(BOILER_CURRENT_SELECT_ID)));
			jobTypeSelect.selectByValue(boilerTypeInstalled);
		}

		if (StringUtils.isNotBlank(boilerTypeRequired)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(BOILER_TYPE_SELECT_ID)));
			jobTypeSelect.selectByValue(boilerTypeRequired);
		}

		if (StringUtils.isNotBlank(boilerMakeRequired)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(BOILER_MAKE_INTSALLED_SELECT_ID)));
			jobTypeSelect.selectByValue(boilerMakeRequired);
		}

		if (StringUtils.isNotBlank(numberOfRadiators)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(RADIATOR_SELECT_ID)));
			jobTypeSelect.selectByValue(numberOfRadiators);
		}

		scriptUtils.click(By.xpath(SCREEN2_NEXT_BUTTON));
	}

	public void fillInBoilerNotWorkingStage2(String tapsHotWaterRadioId, String radiatorHeatUpRadio, String boilerMakeCode) {
		if (StringUtils.isNotBlank(tapsHotWaterRadioId)) {
			scriptUtils.click(By.id(tapsHotWaterRadioId));
		}

		if (StringUtils.isNotBlank(radiatorHeatUpRadio)) {
			scriptUtils.click(By.id(radiatorHeatUpRadio));
		}

		if (StringUtils.isNotBlank(boilerMakeCode)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(BOILER_MAKE_SELECT_ID)));
			jobTypeSelect.selectByValue(boilerMakeCode);
		}

		scriptUtils.click(By.xpath(HOT_WATER_STAGE2_NEXT_BUTTON_XPATH));
	}

	public void fillInObtainSafetyCertStage2(String numberOfBoilersXpath, String boilerMakeCode, String otherXpath, String additionalInfo) {
		if (StringUtils.isNotBlank(numberOfBoilersXpath)) {
			scriptUtils.click(By.xpath(numberOfBoilersXpath));

			if (StringUtils.isNotBlank(boilerMakeCode)) {
				if (StringUtils.isNotBlank(boilerMakeCode)) {
					Select jobTypeSelect = new Select(driver.findElement(By.id(CERTIFICATE_BOILER_MAKE_SELECT_ID)));
					jobTypeSelect.selectByValue(boilerMakeCode);
				}
			}
		}

		if (StringUtils.isNotBlank(otherXpath)) {
			scriptUtils.click(By.xpath(otherXpath));

			if (StringUtils.isNotBlank(additionalInfo)) {
				scriptUtils.fillInXpathField(STAGE2_GAS_CERT_ADDITIONAL_INFO_TEXT_AREA, additionalInfo);
			}
		}

		scriptUtils.click(By.xpath(SCREEN2_GAS_CERT_NEXT_BUTTON));
	}

	public void fillInServiceGasApplianceStage2(String numberOfBoilersXpath, String boilerMakeCode, String otherXpath, String additionalInfo,
			String requireGasCertRadioId) throws InterruptedException {
		if (StringUtils.isNotBlank(numberOfBoilersXpath)) {
			scriptUtils.click(By.xpath(numberOfBoilersXpath));

			if (StringUtils.isNotBlank(boilerMakeCode)) {
				if (StringUtils.isNotBlank(boilerMakeCode)) {
					Select jobTypeSelect = new Select(driver.findElement(By.id(SERVICE_BOILER_MAKE_SELECT_ID)));
					jobTypeSelect.selectByValue(boilerMakeCode);
				}
			}
		}

		if (StringUtils.isNotBlank(otherXpath)) {
			scriptUtils.click(By.xpath(otherXpath));

			if (StringUtils.isNotBlank(additionalInfo)) {
				scriptUtils.fillInXpathField(STAGE2_GAS_SERVICE_ADDITIONAL_INFO_TEXT_AREA, additionalInfo);
			}
		}

		if (StringUtils.isNotBlank(requireGasCertRadioId)) {
			scriptUtils.click(By.id(requireGasCertRadioId));
		}

		scriptUtils.click(By.xpath(SCREEN2_GAS_APP_NEXT_BUTTON));
	}

	public void fillInStage3(String jobStatusId, String ownershipStatusId, String jobTimingValue, String postcode, String additionalInfo) {
		if (StringUtils.isNotBlank(jobStatusId)) {
			scriptUtils.click(By.id(jobStatusId));
		}

		if (StringUtils.isNotBlank(ownershipStatusId)) {
			scriptUtils.click(By.id(ownershipStatusId));
		}

		if (StringUtils.isNotBlank(jobTimingValue)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(TIMING_SELECT_ELEMENT)));
			jobTypeSelect.selectByValue(jobTimingValue);
		}

		if (StringUtils.isNotBlank(postcode)) {
			scriptUtils.fillInTextField(POSTCODE_FIELD, postcode);
		}

		if (StringUtils.isNotBlank(additionalInfo)) {
			scriptUtils.fillInXpathField(ADDITIONAL_INFO_TEXT_AREA_XPATH, additionalInfo);
		}

		scriptUtils.click(By.xpath(SCREEN3_NEXT_BUTTON));
	}

	public void fillInStage4(String budget) {
		if (StringUtils.isNotBlank(budget)) {
			Select budgetSelect = new Select(driver.findElement(By.id(BUDGET_SELECT_ELEMENT)));
			budgetSelect.selectByValue(budget);
		}

		scriptUtils.click(By.xpath(SCREEN4_NEXT_BUTTON));
	}

	public void getQuotes() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, GAS_BOILERS_SKILL_TYPE_ID, HEATING_BOILERS_TRADE_CODE);
	}
}
