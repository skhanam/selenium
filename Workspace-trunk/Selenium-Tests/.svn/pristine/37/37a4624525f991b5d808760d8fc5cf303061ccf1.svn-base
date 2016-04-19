package uk.co.ratedpeople.test.functional.selenium.newjobforms.flooring;

/**
 * @author danthalapalli.aravind
 * 
 */

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

public class PostingJobViaFlooringJobFormsNegativeTest extends TestScript {

	private static final String SOLID_TIMBER = "SOLID_TIMBER";
	private static final String LOUNGE = "LOUNGE";
	private static final String WOOD_FLOORING = "WOOD_FLOORING";
	private static final String BUDGET = "BUDGET";
	private static final String LIST_OTHER_ROOMS = "List other rooms";
	private static final String SELECT_AN_APPROXIMATE_BUDGET = "Select an approximate budget";
	private static final String ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB = "Enter additional details about your job";
	private static final String SELECT_THE_APPROPRIATE_STATUS_OF_THE_JOB = "Select the appropriate status of the job";
	private static final String SELECT_YOUR_OWNERSHIP_STATUS = "Select your ownership status";
	private static final String ENTER_A_UK_POSTCODE = "Enter a UK postcode";
	private static final String SELECT_WHEN_YOU_WANT_THE_JOB_TO_START = "Select when you want the job to start";
	private static final String SELECT_THE_PROPERTY_STYLE = "Select the property style";
	private static final String CARPET_GENERAL = "CARPET_GENERAL";
	private static final String CARPET_TILES = "CARPET_TILES";
	private static final String CARPET_FIT = "CARPET_FIT";
	private static final String OWNERSHIP_STATUS_ID = "OWNERSHIP_STATUS_ID";
	private static final String SUBURBAN = "SUBURBAN";
	private static final String POSTCODE = "POSTCODE";
	private static final String ADDITIONAL_DETAILS = "ADDITIONAL_DETAILS";
	private static final String TIMING = "TIMING";
	private static final String JOB_STATUS_ID = "JOB_STATUS_ID";
	private static final String CARPETS = "CARPETS";
	private static final String BEDROOM = "BEDROOM";

	private PostingJobViaFlooringJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaFlooringJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetfitNegativeTest() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(CARPETS));

		underTest.fillInCarpetsStage2(FlooringXpathLocators.xpathLookup.get(CARPET_FIT), null, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descCarpets']/div[2]/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descCarpets']/div[2]/div[2]/div[2]/label")).getText(), "At least one needs to be selected");

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descCarpets']/div[2]/div[3]/div/div/label")).getText(),
				"Select who will supply the materials");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetfitNegativeTest1() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(CARPETS));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get(BEDROOM), FlooringXpathLocators.xpathLookup.get("BATHROOM") };
		String[] typesOfCarpetXpath = { FlooringXpathLocators.xpathLookup.get(CARPET_TILES), FlooringXpathLocators.xpathLookup.get(CARPET_GENERAL) };

		underTest.fillInCarpetsStage2(null, roomsCarpetXPathList, null, null, typesOfCarpetXpath, null, null,
				FlooringXpathLocators.xpathLookup.get("CARPET_SUPPLYYES"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descCarpets']/div[1]/div/div/label")).getText(), "Select the job you need to have done");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetfitNegativeTest2() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(CARPETS));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get(BEDROOM) };

		underTest.fillInCarpetsStage2(FlooringXpathLocators.xpathLookup.get(CARPET_FIT), roomsCarpetXPathList, null, null, null, null, null,
				FlooringXpathLocators.xpathLookup.get("CARPET_SUPPLYYES"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descCarpets']/div[2]/div[2]/div[2]/label")).getText(), "At least one needs to be selected");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetfitNegativeTest3() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(CARPETS));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get(BEDROOM) };
		String[] typesOfCarpetXpath = { FlooringXpathLocators.xpathLookup.get(CARPET_TILES), FlooringXpathLocators.xpathLookup.get(CARPET_GENERAL) };

		underTest
				.fillInCarpetsStage2(FlooringXpathLocators.xpathLookup.get(CARPET_FIT), roomsCarpetXPathList, null, null, typesOfCarpetXpath, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descCarpets']/div[2]/div[3]/div/div/label")).getText(),
				"Select who will supply the materials");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetfitNegativeTest5() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(CARPETS));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get(BEDROOM) };
		String[] typesOfCarpetXpath = { FlooringXpathLocators.xpathLookup.get(CARPET_TILES), FlooringXpathLocators.xpathLookup.get(CARPET_GENERAL) };

		underTest.fillInCarpetsStage2(FlooringXpathLocators.xpathLookup.get(CARPET_FIT), roomsCarpetXPathList, null, null, typesOfCarpetXpath, null, null,
				FlooringXpathLocators.xpathLookup.get("CARPET_SUPPLYYES"));

		underTest.fillInStage3(null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), SELECT_THE_APPROPRIATE_STATUS_OF_THE_JOB);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), SELECT_YOUR_OWNERSHIP_STATUS);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), SELECT_THE_PROPERTY_STYLE);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), SELECT_WHEN_YOU_WANT_THE_JOB_TO_START);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), ENTER_A_UK_POSTCODE);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetfitNegativeTest6() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(CARPETS));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get(BEDROOM) };
		String[] typesOfCarpetXpath = { FlooringXpathLocators.xpathLookup.get(CARPET_TILES), FlooringXpathLocators.xpathLookup.get(CARPET_GENERAL) };

		underTest.fillInCarpetsStage2(FlooringXpathLocators.xpathLookup.get(CARPET_FIT), roomsCarpetXPathList, null, null, typesOfCarpetXpath, null, null,
				FlooringXpathLocators.xpathLookup.get("CARPET_SUPPLYYES"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), SELECT_YOUR_OWNERSHIP_STATUS);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), SELECT_THE_PROPERTY_STYLE);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), SELECT_WHEN_YOU_WANT_THE_JOB_TO_START);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), ENTER_A_UK_POSTCODE);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetfitNegativeTest7() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(CARPETS));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get(BEDROOM) };
		String[] typesOfCarpetXpath = { FlooringXpathLocators.xpathLookup.get(CARPET_TILES), FlooringXpathLocators.xpathLookup.get(CARPET_GENERAL) };

		underTest.fillInCarpetsStage2(FlooringXpathLocators.xpathLookup.get(CARPET_FIT), roomsCarpetXPathList, null, null, typesOfCarpetXpath, null, null,
				FlooringXpathLocators.xpathLookup.get("CARPET_SUPPLYYES"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID), null, null,
				null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), SELECT_THE_PROPERTY_STYLE);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), SELECT_WHEN_YOU_WANT_THE_JOB_TO_START);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), ENTER_A_UK_POSTCODE);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetfitNegativeTest8() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(CARPETS));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get(BEDROOM) };
		String[] typesOfCarpetXpath = { FlooringXpathLocators.xpathLookup.get(CARPET_TILES), FlooringXpathLocators.xpathLookup.get(CARPET_GENERAL) };

		underTest.fillInCarpetsStage2(FlooringXpathLocators.xpathLookup.get(CARPET_FIT), roomsCarpetXPathList, null, null, typesOfCarpetXpath, null, null,
				FlooringXpathLocators.xpathLookup.get("CARPET_SUPPLYYES"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), SELECT_THE_PROPERTY_STYLE);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), ENTER_A_UK_POSTCODE);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetfitNegativeTest9() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(CARPETS));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get(BEDROOM) };
		String[] typesOfCarpetXpath = { FlooringXpathLocators.xpathLookup.get(CARPET_TILES), FlooringXpathLocators.xpathLookup.get(CARPET_GENERAL) };

		underTest.fillInCarpetsStage2(FlooringXpathLocators.xpathLookup.get(CARPET_FIT), roomsCarpetXPathList, null, null, typesOfCarpetXpath, null, null,
				FlooringXpathLocators.xpathLookup.get("CARPET_SUPPLYYES"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get(SUBURBAN), null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), ENTER_A_UK_POSTCODE);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetfitNegativeTest10() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(CARPETS));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get(BEDROOM) };
		String[] typesOfCarpetXpath = { FlooringXpathLocators.xpathLookup.get(CARPET_TILES), FlooringXpathLocators.xpathLookup.get(CARPET_GENERAL) };

		underTest.fillInCarpetsStage2(FlooringXpathLocators.xpathLookup.get(CARPET_FIT), roomsCarpetXPathList, null, null, typesOfCarpetXpath, null, null,
				FlooringXpathLocators.xpathLookup.get("CARPET_SUPPLYYES"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get(SUBURBAN),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetfitNegativeTest11() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(CARPETS));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get(BEDROOM) };
		String[] typesOfCarpetXpath = { FlooringXpathLocators.xpathLookup.get(CARPET_TILES), FlooringXpathLocators.xpathLookup.get(CARPET_GENERAL) };

		underTest.fillInCarpetsStage2(FlooringXpathLocators.xpathLookup.get(CARPET_FIT), roomsCarpetXPathList, null, null, typesOfCarpetXpath, null, null,
				FlooringXpathLocators.xpathLookup.get("CARPET_SUPPLYYES"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get(SUBURBAN),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), SELECT_AN_APPROXIMATE_BUDGET);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetfitNegativeTest4() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(CARPETS));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get(BEDROOM) };
		String[] typesOfCarpetXpath = { FlooringXpathLocators.xpathLookup.get(CARPET_TILES), FlooringXpathLocators.xpathLookup.get(CARPET_GENERAL) };

		underTest.fillInCarpetsStage2(FlooringXpathLocators.xpathLookup.get(CARPET_FIT), roomsCarpetXPathList, null, null, typesOfCarpetXpath, null, null,
				FlooringXpathLocators.xpathLookup.get("CARPET_SUPPLYYES"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get(SUBURBAN),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetfitNegativeTest12() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(CARPETS));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get(BEDROOM) };
		String[] typesOfCarpetXpath = { FlooringXpathLocators.xpathLookup.get(CARPET_TILES), FlooringXpathLocators.xpathLookup.get(CARPET_GENERAL) };

		underTest.fillInCarpetsStage2(FlooringXpathLocators.xpathLookup.get(CARPET_FIT), roomsCarpetXPathList, null, null, typesOfCarpetXpath, null, null,
				FlooringXpathLocators.xpathLookup.get("CARPET_SUPPLYYES"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get(SUBURBAN),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetfitNegativeTest13() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(CARPETS));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get(BEDROOM) };
		String[] typesOfCarpetXpath = { FlooringXpathLocators.xpathLookup.get(CARPET_TILES), FlooringXpathLocators.xpathLookup.get(CARPET_GENERAL) };

		underTest.fillInCarpetsStage2(FlooringXpathLocators.xpathLookup.get(CARPET_FIT), roomsCarpetXPathList, null, null, typesOfCarpetXpath, null, null,
				FlooringXpathLocators.xpathLookup.get("CARPET_SUPPLYYES"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get(SUBURBAN),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		String lastName = FlooringXpathLocators.xpathLookup.get("LASTNAME");

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetfitNegativeTest14() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(CARPETS));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get(BEDROOM) };
		String[] typesOfCarpetXpath = { FlooringXpathLocators.xpathLookup.get(CARPET_TILES), FlooringXpathLocators.xpathLookup.get(CARPET_GENERAL) };

		underTest.fillInCarpetsStage2(FlooringXpathLocators.xpathLookup.get(CARPET_FIT), roomsCarpetXPathList, null, null, typesOfCarpetXpath, null, null,
				FlooringXpathLocators.xpathLookup.get("CARPET_SUPPLYYES"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get(SUBURBAN),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		String lastName = FlooringXpathLocators.xpathLookup.get("LASTNAME");
		String phoneNumber = FlooringXpathLocators.xpathLookup.get("PHONE_NUMBER");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, phoneNumber, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetfitNegativeTest15() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(CARPETS));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get("ROOM_OTHER") };
		String[] typesOfCarpetXpath = { FlooringXpathLocators.xpathLookup.get("CARPET_OTHER") };

		underTest.fillInCarpetsStage2(FlooringXpathLocators.xpathLookup.get(CARPET_FIT), roomsCarpetXPathList, null, null, typesOfCarpetXpath, null, null,
				FlooringXpathLocators.xpathLookup.get("CARPET_SUPPLYYES"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descCarpets']/div[2]/div[1]/div[2]/ul/li[5]/div/div/label")).getText(), LIST_OTHER_ROOMS);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descCarpets']/div[2]/div[2]/div[1]/ul/li[6]/div/label")).getText(),
				"List other carpet types");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringNegativeTest() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LAMINATE_FLOORING"));

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LAMINATE_INSTALL"), null, null, null, null,
				FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_LAMINATED_FLOORING"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descLaminate']/div[2]/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descLaminate']/div[2]/div[2]/div/div/label")).getText(),
				"Select who will supply the materials");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringNegativeTest1() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LAMINATE_FLOORING"));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get("BASEMENT") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LAMINATE_INSTALL"), roomsCarpetXPathList, null, null, null,
				FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_LAMINATED_FLOORING"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descLaminate']/div[2]/div[2]/div/div/label")).getText(),
				"Select who will supply the materials");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringNegativeTest2() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LAMINATE_FLOORING"));

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LAMINATE_INSTALL"), null, null, null,
				FlooringXpathLocators.xpathLookup.get("LAMINATE_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_LAMINATED_FLOORING"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descLaminate']/div[2]/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringNegativeTest3() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LAMINATE_FLOORING"));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get("LAMINATEROOM_OTHER") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LAMINATE_INSTALL"), roomsCarpetXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LAMINATE_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_LAMINATED_FLOORING"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descLaminate']/div[2]/div[1]/div[2]/ul/li[5]/div/div/label")).getText(), LIST_OTHER_ROOMS);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringNegativeTest4() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LAMINATE_FLOORING"));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get("BASEMENT") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LAMINATE_INSTALL"), roomsCarpetXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LAMINATE_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_LAMINATED_FLOORING"));

		underTest.fillInStage3(null, FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID), FlooringXpathLocators.xpathLookup.get(TIMING),
				FlooringXpathLocators.xpathLookup.get("MODREN"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), SELECT_THE_APPROPRIATE_STATUS_OF_THE_JOB);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringNegativeTest5() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LAMINATE_FLOORING"));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get("BASEMENT") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LAMINATE_INSTALL"), roomsCarpetXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LAMINATE_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_LAMINATED_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), null, FlooringXpathLocators.xpathLookup.get(TIMING),
				FlooringXpathLocators.xpathLookup.get("MODREN"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), SELECT_YOUR_OWNERSHIP_STATUS);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringNegativeTest6() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LAMINATE_FLOORING"));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get("BASEMENT") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LAMINATE_INSTALL"), roomsCarpetXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LAMINATE_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_LAMINATED_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID), null,
				FlooringXpathLocators.xpathLookup.get("MODREN"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), SELECT_WHEN_YOU_WANT_THE_JOB_TO_START);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringNegativeTest7() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LAMINATE_FLOORING"));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get("BASEMENT") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LAMINATE_INSTALL"), roomsCarpetXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LAMINATE_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_LAMINATED_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), null, FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), SELECT_THE_PROPERTY_STYLE);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringNegativeTest8() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LAMINATE_FLOORING"));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get("BASEMENT") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LAMINATE_INSTALL"), roomsCarpetXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LAMINATE_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_LAMINATED_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("MODREN"), null,
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), ENTER_A_UK_POSTCODE);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringNegativeTest9() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LAMINATE_FLOORING"));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get("BASEMENT") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LAMINATE_INSTALL"), roomsCarpetXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LAMINATE_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_LAMINATED_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("MODREN"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringNegativeTest10() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LAMINATE_FLOORING"));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get("BASEMENT") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LAMINATE_INSTALL"), roomsCarpetXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LAMINATE_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_LAMINATED_FLOORING"));

		underTest.fillInStage3(null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), SELECT_THE_PROPERTY_STYLE);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), SELECT_WHEN_YOU_WANT_THE_JOB_TO_START);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), SELECT_YOUR_OWNERSHIP_STATUS);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), SELECT_THE_APPROPRIATE_STATUS_OF_THE_JOB);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), ENTER_A_UK_POSTCODE);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringNegativeTest11() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LAMINATE_FLOORING"));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get("BASEMENT") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LAMINATE_INSTALL"), roomsCarpetXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LAMINATE_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_LAMINATED_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("MODREN"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), SELECT_AN_APPROXIMATE_BUDGET);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringNegativeTest12() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LAMINATE_FLOORING"));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get("BASEMENT") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LAMINATE_INSTALL"), roomsCarpetXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LAMINATE_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_LAMINATED_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("MODREN"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringNegativeTest13() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LAMINATE_FLOORING"));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get("BASEMENT") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LAMINATE_INSTALL"), roomsCarpetXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LAMINATE_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_LAMINATED_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("MODREN"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));
		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringNegativeTest14() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LAMINATE_FLOORING"));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get("BASEMENT") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LAMINATE_INSTALL"), roomsCarpetXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LAMINATE_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_LAMINATED_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("MODREN"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		String lastName = FlooringXpathLocators.xpathLookup.get("LASTNAME");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringNegativeTest15() throws Exception {

		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LAMINATE_FLOORING"));

		String[] roomsCarpetXPathList = { FlooringXpathLocators.xpathLookup.get("BASEMENT") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LAMINATE_INSTALL"), roomsCarpetXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LAMINATE_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_LAMINATED_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("MODREN"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));
		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		String lastName = FlooringXpathLocators.xpathLookup.get("LASTNAME");
		String phoneNumber = FlooringXpathLocators.xpathLookup.get("PHONE_NUMBER");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, phoneNumber, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringNegativeTest() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(WOOD_FLOORING));

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("WOOD_INSTALL"), null, null, null,
				FlooringXpathLocators.xpathLookup.get("ENGINEER_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_WOOD_FLOORING"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descEngineeredWood']/div[2]/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringNegativeTest1() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(WOOD_FLOORING));

		String[] roomsWoodFlooringXPathList = { FlooringXpathLocators.xpathLookup.get(LOUNGE) };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("WOOD_INSTALL"), roomsWoodFlooringXPathList, null, null, null,
				FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_WOOD_FLOORING"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descEngineeredWood']/div[2]/div[2]/div/div/label")).getText(),
				"Select who will supply the materials");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringNegativeTest2() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(WOOD_FLOORING));

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("WOOD_INSTALL"), null, null, null, null,
				FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_WOOD_FLOORING"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descEngineeredWood']/div[2]/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descEngineeredWood']/div[2]/div[2]/div/div/label")).getText(),
				"Select who will supply the materials");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringNegativeTest3() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(WOOD_FLOORING));

		String[] roomsWoodFlooringXPathList = { FlooringXpathLocators.xpathLookup.get("ENGINEER_OTHER") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("WOOD_INSTALL"), roomsWoodFlooringXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("ENGINEER_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_WOOD_FLOORING"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descEngineeredWood']/div[2]/div[1]/div[2]/ul/li[5]/div/div/label")).getText(),
				LIST_OTHER_ROOMS);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringNegativeTest4() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(WOOD_FLOORING));

		String[] roomsWoodFlooringXPathList = { FlooringXpathLocators.xpathLookup.get(LOUNGE) };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("WOOD_INSTALL"), roomsWoodFlooringXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("ENGINEER_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_WOOD_FLOORING"));

		underTest.fillInStage3(null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), SELECT_THE_PROPERTY_STYLE);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), SELECT_WHEN_YOU_WANT_THE_JOB_TO_START);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), SELECT_YOUR_OWNERSHIP_STATUS);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), SELECT_THE_APPROPRIATE_STATUS_OF_THE_JOB);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), ENTER_A_UK_POSTCODE);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringNegativeTest5() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(WOOD_FLOORING));

		String[] roomsWoodFlooringXPathList = { FlooringXpathLocators.xpathLookup.get(LOUNGE) };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("WOOD_INSTALL"), roomsWoodFlooringXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("ENGINEER_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_WOOD_FLOORING"));
		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("OTHER"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringNegativeTest6() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(WOOD_FLOORING));

		String[] roomsWoodFlooringXPathList = { FlooringXpathLocators.xpathLookup.get(LOUNGE) };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("WOOD_INSTALL"), roomsWoodFlooringXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("ENGINEER_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_WOOD_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("OTHER"), null,
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), ENTER_A_UK_POSTCODE);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringNegativeTest7() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(WOOD_FLOORING));

		String[] roomsWoodFlooringXPathList = { FlooringXpathLocators.xpathLookup.get(LOUNGE) };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("WOOD_INSTALL"), roomsWoodFlooringXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("ENGINEER_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_WOOD_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), null, FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), SELECT_THE_PROPERTY_STYLE);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringNegativeTest8() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(WOOD_FLOORING));

		String[] roomsWoodFlooringXPathList = { FlooringXpathLocators.xpathLookup.get(LOUNGE) };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("WOOD_INSTALL"), roomsWoodFlooringXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("ENGINEER_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_WOOD_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID), null,
				FlooringXpathLocators.xpathLookup.get("OTHER"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), SELECT_WHEN_YOU_WANT_THE_JOB_TO_START);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringNegativeTest9() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(WOOD_FLOORING));

		String[] roomsWoodFlooringXPathList = { FlooringXpathLocators.xpathLookup.get(LOUNGE) };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("WOOD_INSTALL"), roomsWoodFlooringXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("ENGINEER_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_WOOD_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), null, FlooringXpathLocators.xpathLookup.get(TIMING),
				FlooringXpathLocators.xpathLookup.get("OTHER"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), SELECT_YOUR_OWNERSHIP_STATUS);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringNegativeTest10() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(WOOD_FLOORING));

		String[] roomsWoodFlooringXPathList = { FlooringXpathLocators.xpathLookup.get(LOUNGE) };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("WOOD_INSTALL"), roomsWoodFlooringXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("ENGINEER_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_WOOD_FLOORING"));

		underTest.fillInStage3(null, FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID), FlooringXpathLocators.xpathLookup.get(TIMING),
				FlooringXpathLocators.xpathLookup.get("OTHER"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), SELECT_THE_APPROPRIATE_STATUS_OF_THE_JOB);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringNegativeTest11() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(WOOD_FLOORING));

		String[] roomsWoodFlooringXPathList = { FlooringXpathLocators.xpathLookup.get(LOUNGE) };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("WOOD_INSTALL"), roomsWoodFlooringXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("ENGINEER_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_WOOD_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("OTHER"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));
		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), SELECT_AN_APPROXIMATE_BUDGET);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringNegativeTest12() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(WOOD_FLOORING));

		String[] roomsWoodFlooringXPathList = { FlooringXpathLocators.xpathLookup.get(LOUNGE) };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("WOOD_INSTALL"), roomsWoodFlooringXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("ENGINEER_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_WOOD_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("OTHER"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringNegativeTest13() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(WOOD_FLOORING));

		String[] roomsWoodFlooringXPathList = { FlooringXpathLocators.xpathLookup.get(LOUNGE) };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("WOOD_INSTALL"), roomsWoodFlooringXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("ENGINEER_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_WOOD_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("OTHER"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));
		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringNegativeTest14() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(WOOD_FLOORING));

		String[] roomsWoodFlooringXPathList = { FlooringXpathLocators.xpathLookup.get(LOUNGE) };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("WOOD_INSTALL"), roomsWoodFlooringXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("ENGINEER_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_WOOD_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("OTHER"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		String lastName = FlooringXpathLocators.xpathLookup.get("LASTNAME");

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringNegativeTest15() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(WOOD_FLOORING));

		String[] roomsWoodFlooringXPathList = { FlooringXpathLocators.xpathLookup.get(LOUNGE) };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("WOOD_INSTALL"), roomsWoodFlooringXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("ENGINEER_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_WOOD_FLOORING"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("OTHER"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));
		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		String lastName = FlooringXpathLocators.xpathLookup.get("LASTNAME");
		String phoneNumber = FlooringXpathLocators.xpathLookup.get("PHONE_NUMBER");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, phoneNumber, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(SOLID_TIMBER));

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("SOLID_TIMBER_INSTALL"), null, null, null, null,
				FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_TIMBER"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descSolidWood']/div[2]/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descSolidWood']/div[2]/div[2]/div/div/label")).getText(),
				"Select who will supply the materials");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest1() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(SOLID_TIMBER));

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("SOLID_TIMBER_INSTALL"), null, null, null,
				FlooringXpathLocators.xpathLookup.get("SOLIDWOOD_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_TIMBER"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descSolidWood']/div[2]/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest2() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(SOLID_TIMBER));
		String[] roomsSolidTimberXPathList = { FlooringXpathLocators.xpathLookup.get("STAIWAY") };
		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("SOLID_TIMBER_INSTALL"), roomsSolidTimberXPathList, null, null, null,
				FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_TIMBER"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descSolidWood']/div[2]/div[2]/div/div/label")).getText(),
				"Select who will supply the materials");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest3() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(SOLID_TIMBER));

		String[] roomsSolidTimberXPathList = { FlooringXpathLocators.xpathLookup.get("SOLID_OTHER") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("SOLID_TIMBER_INSTALL"), roomsSolidTimberXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("SOLIDWOOD_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_TIMBER"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descSolidWood']/div[2]/div[1]/div[2]/ul/li[5]/div/div/label")).getText(), LIST_OTHER_ROOMS);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest4() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(SOLID_TIMBER));

		String[] roomsSolidTimberXPathList = { FlooringXpathLocators.xpathLookup.get("STAIWAY") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("SOLID_TIMBER_INSTALL"), roomsSolidTimberXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("SOLIDWOOD_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_TIMBER"));

		underTest.fillInStage3(null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), SELECT_THE_PROPERTY_STYLE);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), SELECT_WHEN_YOU_WANT_THE_JOB_TO_START);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), SELECT_YOUR_OWNERSHIP_STATUS);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), SELECT_THE_APPROPRIATE_STATUS_OF_THE_JOB);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), ENTER_A_UK_POSTCODE);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest5() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(SOLID_TIMBER));

		String[] roomsSolidTimberXPathList = { FlooringXpathLocators.xpathLookup.get("STAIWAY") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("SOLID_TIMBER_INSTALL"), roomsSolidTimberXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("SOLIDWOOD_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_TIMBER"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("DONT_KNOW"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest6() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(SOLID_TIMBER));

		String[] roomsSolidTimberXPathList = { FlooringXpathLocators.xpathLookup.get("STAIWAY") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("SOLID_TIMBER_INSTALL"), roomsSolidTimberXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("SOLIDWOOD_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_TIMBER"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("DONT_KNOW"), null,
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), ENTER_A_UK_POSTCODE);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest7() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(SOLID_TIMBER));

		String[] roomsSolidTimberXPathList = { FlooringXpathLocators.xpathLookup.get("STAIWAY") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("SOLID_TIMBER_INSTALL"), roomsSolidTimberXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("SOLIDWOOD_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_TIMBER"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), null, FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), SELECT_THE_PROPERTY_STYLE);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest8() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(SOLID_TIMBER));

		String[] roomsSolidTimberXPathList = { FlooringXpathLocators.xpathLookup.get("STAIWAY") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("SOLID_TIMBER_INSTALL"), roomsSolidTimberXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("SOLIDWOOD_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_TIMBER"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID), null,
				FlooringXpathLocators.xpathLookup.get("DONT_KNOW"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), SELECT_WHEN_YOU_WANT_THE_JOB_TO_START);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest9() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(SOLID_TIMBER));

		String[] roomsSolidTimberXPathList = { FlooringXpathLocators.xpathLookup.get("STAIWAY") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("SOLID_TIMBER_INSTALL"), roomsSolidTimberXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("SOLIDWOOD_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_TIMBER"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), null, FlooringXpathLocators.xpathLookup.get(TIMING),
				FlooringXpathLocators.xpathLookup.get("DONT_KNOW"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), SELECT_YOUR_OWNERSHIP_STATUS);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest10() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(SOLID_TIMBER));

		String[] roomsSolidTimberXPathList = { FlooringXpathLocators.xpathLookup.get("STAIWAY") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("SOLID_TIMBER_INSTALL"), roomsSolidTimberXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("SOLIDWOOD_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_TIMBER"));

		underTest.fillInStage3(null, FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID), FlooringXpathLocators.xpathLookup.get(TIMING),
				FlooringXpathLocators.xpathLookup.get("DONT_KNOW"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), SELECT_THE_APPROPRIATE_STATUS_OF_THE_JOB);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest11() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(SOLID_TIMBER));

		String[] roomsSolidTimberXPathList = { FlooringXpathLocators.xpathLookup.get("STAIWAY") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("SOLID_TIMBER_INSTALL"), roomsSolidTimberXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("SOLIDWOOD_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_TIMBER"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("DONT_KNOW"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), SELECT_AN_APPROXIMATE_BUDGET);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest12() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(SOLID_TIMBER));

		String[] roomsSolidTimberXPathList = { FlooringXpathLocators.xpathLookup.get("STAIWAY") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("SOLID_TIMBER_INSTALL"), roomsSolidTimberXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("SOLIDWOOD_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_TIMBER"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("DONT_KNOW"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest13() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(SOLID_TIMBER));

		String[] roomsSolidTimberXPathList = { FlooringXpathLocators.xpathLookup.get("STAIWAY") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("SOLID_TIMBER_INSTALL"), roomsSolidTimberXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("SOLIDWOOD_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_TIMBER"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("DONT_KNOW"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest14() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(SOLID_TIMBER));

		String[] roomsSolidTimberXPathList = { FlooringXpathLocators.xpathLookup.get("STAIWAY") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("SOLID_TIMBER_INSTALL"), roomsSolidTimberXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("SOLIDWOOD_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_TIMBER"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("DONT_KNOW"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		String lastName = FlooringXpathLocators.xpathLookup.get("LASTNAME");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest15() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get(SOLID_TIMBER));

		String[] roomsSolidTimberXPathList = { FlooringXpathLocators.xpathLookup.get("STAIWAY") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("SOLID_TIMBER_INSTALL"), roomsSolidTimberXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("SOLIDWOOD_YES"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_TIMBER"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("DONT_KNOW"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		String lastName = FlooringXpathLocators.xpathLookup.get("LASTNAME");
		String phoneNumber = FlooringXpathLocators.xpathLookup.get("PHONE_NUMBER");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, phoneNumber, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));

		// String[] roomsLinoVinylXPathList = {FlooringXpathLocators.xpathLookup.get("TOILET")};

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), null, null, null,
				FlooringXpathLocators.xpathLookup.get("LINO_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descLinoVinyl']/div[2]/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest1() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));

		String[] roomsLinoVinylXPathList = { FlooringXpathLocators.xpathLookup.get("TOILET") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), roomsLinoVinylXPathList, null, null, null,
				FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descLinoVinyl']/div[2]/div[2]/div/div/label")).getText(),
				"Select who will supply the materials");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest2() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), null, null, null, null,
				FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descLinoVinyl']/div[2]/div[2]/div/div/label")).getText(),
				"Select who will supply the materials");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descLinoVinyl']/div[2]/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest3() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));
		String[] roomsLinoVinylXPathList = { FlooringXpathLocators.xpathLookup.get("LINO_OTHER") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), roomsLinoVinylXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LINO_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descLinoVinyl']/div[2]/div[1]/div[2]/ul/li[5]/div/div/label")).getText(), LIST_OTHER_ROOMS);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest4() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));
		String[] roomsLinoVinylXPathList = { FlooringXpathLocators.xpathLookup.get("TOILET") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), roomsLinoVinylXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LINO_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));

		underTest.fillInStage3(null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), SELECT_THE_PROPERTY_STYLE);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), SELECT_WHEN_YOU_WANT_THE_JOB_TO_START);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), SELECT_YOUR_OWNERSHIP_STATUS);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), SELECT_THE_APPROPRIATE_STATUS_OF_THE_JOB);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), ENTER_A_UK_POSTCODE);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest5() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));
		String[] roomsLinoVinylXPathList = { FlooringXpathLocators.xpathLookup.get("TOILET") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), roomsLinoVinylXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LINO_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));
		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("PERIOD"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest6() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));
		String[] roomsLinoVinylXPathList = { FlooringXpathLocators.xpathLookup.get("TOILET") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), roomsLinoVinylXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LINO_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("PERIOD"), null,
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), ENTER_A_UK_POSTCODE);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest7() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));
		String[] roomsLinoVinylXPathList = { FlooringXpathLocators.xpathLookup.get("TOILET") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), roomsLinoVinylXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LINO_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), null, FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), SELECT_THE_PROPERTY_STYLE);

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest8() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));
		String[] roomsLinoVinylXPathList = { FlooringXpathLocators.xpathLookup.get("TOILET") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), roomsLinoVinylXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LINO_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID), null,
				FlooringXpathLocators.xpathLookup.get("PERIOD"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), SELECT_WHEN_YOU_WANT_THE_JOB_TO_START);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest9() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));
		String[] roomsLinoVinylXPathList = { FlooringXpathLocators.xpathLookup.get("TOILET") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), roomsLinoVinylXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LINO_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));
		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), null, FlooringXpathLocators.xpathLookup.get(TIMING),
				FlooringXpathLocators.xpathLookup.get("PERIOD"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), SELECT_YOUR_OWNERSHIP_STATUS);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest10() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));
		String[] roomsLinoVinylXPathList = { FlooringXpathLocators.xpathLookup.get("TOILET") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), roomsLinoVinylXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LINO_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));

		underTest.fillInStage3(null, FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID), FlooringXpathLocators.xpathLookup.get(TIMING),
				FlooringXpathLocators.xpathLookup.get("PERIOD"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), SELECT_THE_APPROPRIATE_STATUS_OF_THE_JOB);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest11() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));
		String[] roomsLinoVinylXPathList = { FlooringXpathLocators.xpathLookup.get("TOILET") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), roomsLinoVinylXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LINO_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("PERIOD"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), SELECT_AN_APPROXIMATE_BUDGET);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest12() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));
		String[] roomsLinoVinylXPathList = { FlooringXpathLocators.xpathLookup.get("TOILET") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), roomsLinoVinylXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LINO_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("PERIOD"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest13() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));
		String[] roomsLinoVinylXPathList = { FlooringXpathLocators.xpathLookup.get("TOILET") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), roomsLinoVinylXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LINO_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("PERIOD"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));
		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest14() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));
		String[] roomsLinoVinylXPathList = { FlooringXpathLocators.xpathLookup.get("TOILET") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), roomsLinoVinylXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LINO_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("PERIOD"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));
		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		String lastName = FlooringXpathLocators.xpathLookup.get("LASTNAME");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest15() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));
		String[] roomsLinoVinylXPathList = { FlooringXpathLocators.xpathLookup.get("TOILET") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), roomsLinoVinylXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LINO_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("PERIOD"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));
		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		String lastName = FlooringXpathLocators.xpathLookup.get("LASTNAME");
		String phoneNumber = FlooringXpathLocators.xpathLookup.get("PHONE_NUMBER");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest16() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("LINO_VINYL"));
		String[] roomsLinoVinylXPathList = { FlooringXpathLocators.xpathLookup.get("TOILET") };

		underTest.fillInGenericStage2(FlooringXpathLocators.xpathLookup.get("LINO_VINYL_INSTALL"), roomsLinoVinylXPathList, null, null,
				FlooringXpathLocators.xpathLookup.get("LINO_NO"), FlooringXpathLocators.xpathLookup.get("STAGE2_CONTINUE_VINYL"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("PERIOD"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSomethingElseTest() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), SELECT_THE_PROPERTY_STYLE);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), SELECT_WHEN_YOU_WANT_THE_JOB_TO_START);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), SELECT_YOUR_OWNERSHIP_STATUS);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), SELECT_THE_APPROPRIATE_STATUS_OF_THE_JOB);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), ENTER_A_UK_POSTCODE);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSomethingElseTest1() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("OTHEROFSOMETHING"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				ENTER_ADDITIONAL_DETAILS_ABOUT_YOUR_JOB);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSomethingElseTest2() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("OTHEROFSOMETHING"), null,
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), ENTER_A_UK_POSTCODE);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSomethingElseTest3() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), null, FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), SELECT_THE_PROPERTY_STYLE);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSomethingElseTest4() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID), null,
				FlooringXpathLocators.xpathLookup.get("OTHEROFSOMETHING"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), SELECT_WHEN_YOU_WANT_THE_JOB_TO_START);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSomethingElseTest5() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), null, FlooringXpathLocators.xpathLookup.get(TIMING),
				FlooringXpathLocators.xpathLookup.get("OTHEROFSOMETHING"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), SELECT_YOUR_OWNERSHIP_STATUS);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSomethingElseTest6() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(null, FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID), FlooringXpathLocators.xpathLookup.get(TIMING),
				FlooringXpathLocators.xpathLookup.get("OTHEROFSOMETHING"), FlooringXpathLocators.xpathLookup.get(POSTCODE),
				FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), SELECT_THE_APPROPRIATE_STATUS_OF_THE_JOB);

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSomethingElseTest7() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("OTHEROFSOMETHING"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[2]/label")).getText(), SELECT_AN_APPROXIMATE_BUDGET);

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaFlooringJobFormsSomethingElseTest8() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("OTHEROFSOMETHING"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));
		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSomethingElseTest9() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("OTHEROFSOMETHING"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));
		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSomethingElseTest10() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("OTHEROFSOMETHING"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		String lastName = FlooringXpathLocators.xpathLookup.get("LASTNAME");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaFlooringJobFormsSomethingElseTest11() throws Exception {
		underTest.fillInStage1(FlooringXpathLocators.xpathLookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(FlooringXpathLocators.xpathLookup.get(JOB_STATUS_ID), FlooringXpathLocators.xpathLookup.get(OWNERSHIP_STATUS_ID),
				FlooringXpathLocators.xpathLookup.get(TIMING), FlooringXpathLocators.xpathLookup.get("OTHEROFSOMETHING"),
				FlooringXpathLocators.xpathLookup.get(POSTCODE), FlooringXpathLocators.xpathLookup.get(ADDITIONAL_DETAILS));

		underTest.fillInStage4(FlooringXpathLocators.xpathLookup.get(BUDGET));

		String firstName = FlooringXpathLocators.xpathLookup.get("FIRSTNAME");
		String lastName = FlooringXpathLocators.xpathLookup.get("LASTNAME");
		String phoneNumber = FlooringXpathLocators.xpathLookup.get("PHONE_NUMBER");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}
}
