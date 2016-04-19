package uk.co.ratedpeople.test.functional.selenium.newjobforms.flatroofs;

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

public class PostingJobViaFlatRoofsJobFormNegativeTest extends TestScript {

	private static final int DESCRIPTION_LENGTH_30 = 30;

	private PostingJobviaFlatRoofsJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobviaFlatRoofsJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest1() throws Exception {

		underTest.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), null, null, null);

		context.driver.findElement(By.xpath(".//*[@id='relate']/div[1]/ul/li[1]/a")).click();

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='relate']/div[2]/aside[1]/h4")).getText(), "Replace");

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[1]/div[3]/label")).getText(), "At least one item needs to be selected");

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='replaceSection']/div/label")).getText(),
				"Select the highest section of roof that needs to be replaced");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest2() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_DORMER") };

		underTest.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='replaceSection']/div/label")).getText(),
				"Select the highest section of roof that needs to be replaced");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest3() throws Exception {

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), null,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[1]/div[3]/label")).getText(), "At least one item needs to be selected");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest4() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"), FlatRoofsXpathLocators.xpathLookup.get("REPLACE_OTHER") };

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[1]/div[2]/ul/li[7]/div/label")).getText(),
				"List the roof(s) that needs to be replaced");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest5() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_DORMER") };

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		underTest.fillInPage2ForAdditionalInfo(null, null, null, 3, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='typeOfProperty']/div/label")).getText(), "Select the property type");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div[1]/div/div/label")).getText(), "Select the number of bedrooms");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[4]/div/label")).getText(), "Select the appropriate status of the job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Select your ownership status");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[7]/div/label")).getText(), "Enter a UK postcode");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest6() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_DORMER") };

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"), FlatRoofsXpathLocators.xpathLookup.get("REPLACE_BEDROOMS"), 3,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest7() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_DORMER") };

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"), FlatRoofsXpathLocators.xpathLookup.get("REPLACE_BEDROOMS"), 3,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), null, DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[7]/div/label")).getText(), "Enter a UK postcode");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest8() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_DORMER") };

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"), FlatRoofsXpathLocators.xpathLookup.get("REPLACE_BEDROOMS"), 3,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				null, FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest9() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_DORMER") };

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"), FlatRoofsXpathLocators.xpathLookup.get("REPLACE_BEDROOMS"), 3,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), null, FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"),
				FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Select your ownership status");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest10() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_DORMER") };

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"), FlatRoofsXpathLocators.xpathLookup.get("REPLACE_BEDROOMS"), 3, null,
				FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"),
				FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[4]/div/label")).getText(), "Select the appropriate status of the job");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest11() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_DORMER") };

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"), null, 3,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div[1]/div/div/label")).getText(), "Select the number of bedrooms");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest12() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_DORMER") };

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_TYPE"), null,
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_BEDROOMS"), 3, FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"),
				FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest13() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_DORMER") };

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		underTest.fillInPage2ForAdditionalInfo(null, FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_BEDROOMS"), 3, FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"),
				FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div[1]/p/a")).click();
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div[2]/aside/h4")).getText(), "Number of bedrooms");

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='typeOfProperty']/div/label")).getText(), "Select the property type");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest14() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_DORMER") };

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"), FlatRoofsXpathLocators.xpathLookup.get("REPLACE_BEDROOMS"), 3,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest15() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_DORMER") };

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"), FlatRoofsXpathLocators.xpathLookup.get("REPLACE_BEDROOMS"), 3,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest16() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_DORMER") };

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"), FlatRoofsXpathLocators.xpathLookup.get("REPLACE_BEDROOMS"), 3,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));
		String lastName = FlatRoofsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = FlatRoofsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = FlatRoofsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, lastName, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest17() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_DORMER") };

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"), FlatRoofsXpathLocators.xpathLookup.get("REPLACE_BEDROOMS"), 3,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));
		String firstName = FlatRoofsXpathLocators.xpathLookup.get("FIRST_NAME");
		String phoneNumber = FlatRoofsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = FlatRoofsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest18() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_DORMER") };

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"), FlatRoofsXpathLocators.xpathLookup.get("REPLACE_BEDROOMS"), 3,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));

		String firstName = FlatRoofsXpathLocators.xpathLookup.get("FIRST_NAME");
		String lastName = FlatRoofsXpathLocators.xpathLookup.get("LAST_NAME");
		String emailAddress = FlatRoofsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsReplaceFlatRoofsTest19() throws Exception {

		String[] roofSectionsToReplace = { FlatRoofsXpathLocators.xpathLookup.get("REPLACE_EXTENSION"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_DORMER") };

		underTest
				.fillInPage1ForJobDetailsForReplaceFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_SECTION_ROOF"),
						FlatRoofsXpathLocators.xpathLookup.get("REPLACE_HIGHEST_ROOF_SECTION_3_STOREY"));
		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPLACE_PROPERTY_STYLE"), FlatRoofsXpathLocators.xpathLookup.get("REPLACE_BEDROOMS"), 3,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));
		String firstName = FlatRoofsXpathLocators.xpathLookup.get("FIRST_NAME");
		String lastName = FlatRoofsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = FlatRoofsXpathLocators.xpathLookup.get("PHONE_NUMBER");

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, phoneNumber, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest1() throws Exception {

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[1]/div[1]/div/label")).getText(),
				"At least one option needs to be selected");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[2]/div[3]/label")).getText(), "At least one item needs to be selected");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='repairSection']/div/label")).getText(),
				"Select the highest section of roof that needs to be repaired");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest2() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WATER") };

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_BAY") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='repairSection']/div/label")).getText(),
				"Select the highest section of roof that needs to be repaired");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest3() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WATER") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired, null,
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[2]/div[3]/label")).getText(), "At least one item needs to be selected");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest4() throws Exception {

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_BAY") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), null, whereRepairsNeeded,
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));
		context.driver.findElement(By.xpath(".//*[@id='relate']/div[1]/ul/li[2]/a")).click();
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='relate']/div[2]/aside[2]/h4")).getText(), "Repair");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[1]/div[1]/div/label")).getText(),
				"At least one option needs to be selected");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest5() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIRROOF_OTHER") };

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_OTHER") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded, FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));
		context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[1]/div[1]/ul/li[3]/a")).click();
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[1]/div[2]/aside/h4")).getText(), "Flashing");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[1]/div[1]/ul/li[5]/div/label")).getText(),
				"List what needs to be repaired");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[2]/div[2]/ul/li[7]/div/label")).getText(),
				"List the roof(s) that needs to be repaired");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest6() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WATER") };

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_BAY") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded, FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));
		underTest.fillInPage2ForAdditionalInfo(null, null, null, 3, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='typeOfProperty']/div/label")).getText(), "Select the property type");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div/label")).getText(), "Select the appropriate status of the job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[4]/div/label")).getText(), "Select your ownership status");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[6]/div/label")).getText(), "Enter a UK postcode");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest7() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WATER") };

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_BAY") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded, FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"), null, 0, FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"),
				FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest8() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WATER") };

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_BAY") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded, FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"), null, 0, FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), null,
				DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[6]/div/label")).getText(), "Enter a UK postcode");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest9() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WATER") };

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_BAY") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded, FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"), null, 0, FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), null, FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"),
				DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest10() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WATER") };

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_BAY") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded, FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"), null, 0, FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				null, FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[4]/div/label")).getText(), "Select your ownership status");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest11() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WATER") };

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_BAY") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded, FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"), null, 0, null,
				FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"),
				FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div/label")).getText(), "Select the appropriate status of the job");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest12() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WATER") };

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_BAY") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded, FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_TYPE"), null, null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest13() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WATER") };

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_BAY") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded, FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));

		underTest.fillInPage2ForAdditionalInfo(null, FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='typeOfProperty']/div/label")).getText(), "Select the property type");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest14() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WATER") };

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_BAY") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded, FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"), null, 0, FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"),
				FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest15() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WATER") };

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_BAY") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded, FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"), null, 0, FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"),
				FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest16() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WATER") };

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_BAY") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded, FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"), null, 0, FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"),
				FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));
		String lastName = FlatRoofsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = FlatRoofsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = FlatRoofsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, lastName, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest17() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WATER") };

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_BAY") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded, FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"), null, 0, FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"),
				FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));

		String firstName = FlatRoofsXpathLocators.xpathLookup.get("FIRST_NAME");
		String phoneNumber = FlatRoofsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = FlatRoofsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest18() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WATER") };

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_BAY") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded, FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"), null, 0, FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"),
				FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));
		String firstName = FlatRoofsXpathLocators.xpathLookup.get("FIRST_NAME");
		String lastName = FlatRoofsXpathLocators.xpathLookup.get("LAST_NAME");
		String emailAddress = FlatRoofsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsRepairFlatRoofsTest19() throws Exception {

		String[] whatNeedsToBeRepaired = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WORN"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_ROOF_WATER") };

		String[] whereRepairsNeeded = { FlatRoofsXpathLocators.xpathLookup.get("REPAIR_MAIN"), FlatRoofsXpathLocators.xpathLookup.get("REPAIR_BAY") };

		underTest.fillInPage1ForJobDetailsForRepairFlatRoofs(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded, FlatRoofsXpathLocators.xpathLookup.get("REPAIR_SECTION_ROOF"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_HIGHEST_ROOF_SECTION_3_STOREY"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("REPAIR_PROPERTY_STYLE"), null, 0, FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"),
				FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));
		String firstName = FlatRoofsXpathLocators.xpathLookup.get("FIRST_NAME");
		String lastName = FlatRoofsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = FlatRoofsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, phoneNumber, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsFindAndRepairLeakNegativeTest() throws Exception {

		underTest.fillInPage1ForJobDetailsForFindAndRepairLeak(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(null, null, null, 3, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='typeOfProperty']/div/label")).getText(), "Select the property type");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div/label")).getText(), "Select the appropriate status of the job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[4]/div/label")).getText(), "Select your ownership status");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[6]/div/label")).getText(), "Enter a UK postcode");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsFindAndRepairLeakNegativeTest1() throws Exception {

		underTest.fillInPage1ForJobDetailsForFindAndRepairLeak(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsFindAndRepairLeakNegativeTest2() throws Exception {

		underTest.fillInPage1ForJobDetailsForFindAndRepairLeak(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), null, DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[6]/div/label")).getText(), "Enter a UK postcode");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsFindAndRepairLeakNegativeTest3() throws Exception {

		underTest.fillInPage1ForJobDetailsForFindAndRepairLeak(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				null, FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsFindAndRepairLeakNegativeTest4() throws Exception {

		underTest.fillInPage1ForJobDetailsForFindAndRepairLeak(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_RADIO_BTN"));
		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), null, FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"),
				FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[4]/div/label")).getText(), "Select your ownership status");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsFindAndRepairLeakNegativeTest5() throws Exception {

		underTest.fillInPage1ForJobDetailsForFindAndRepairLeak(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_TYPE"), null, null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsFindAndRepairLeakNegativeTest6() throws Exception {

		underTest.fillInPage1ForJobDetailsForFindAndRepairLeak(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(null, FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='typeOfProperty']/div/label")).getText(), "Select the property type");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsFindAndRepairLeakNegativeTest7() throws Exception {

		underTest.fillInPage1ForJobDetailsForFindAndRepairLeak(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[2]/label")).getText(), "Select an approximate budget");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsFindAndRepairLeakNegativeTest8() throws Exception {

		underTest.fillInPage1ForJobDetailsForFindAndRepairLeak(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsFindAndRepairLeakNegativeTest9() throws Exception {

		underTest.fillInPage1ForJobDetailsForFindAndRepairLeak(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));
		String lastName = FlatRoofsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = FlatRoofsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = FlatRoofsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, lastName, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsFindAndRepairLeakNegativeTest10() throws Exception {

		underTest.fillInPage1ForJobDetailsForFindAndRepairLeak(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));
		String firstName = FlatRoofsXpathLocators.xpathLookup.get("FIRST_NAME");
		String phoneNumber = FlatRoofsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = FlatRoofsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsFindAndRepairLeakNegativeTest11() throws Exception {

		underTest.fillInPage1ForJobDetailsForFindAndRepairLeak(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));
		String firstName = FlatRoofsXpathLocators.xpathLookup.get("FIRST_NAME");
		String lastName = FlatRoofsXpathLocators.xpathLookup.get("LAST_NAME");
		String emailAddress = FlatRoofsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsFindAndRepairLeakNegativeTest12() throws Exception {

		underTest.fillInPage1ForJobDetailsForFindAndRepairLeak(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("FIND_REPAIR_LEAK_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));

		String firstName = FlatRoofsXpathLocators.xpathLookup.get("FIRST_NAME");
		String lastName = FlatRoofsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = FlatRoofsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, phoneNumber, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsSomethingElseNegativeTest() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(null, null, null, 3, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='typeOfProperty']/div/label")).getText(), "Select the property type");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[3]/div/label")).getText(), "Select the appropriate status of the job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[4]/div/label")).getText(), "Select your ownership status");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[6]/div/label")).getText(), "Enter a UK postcode");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsSomethingElseNegativeTest1() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsSomethingElseNegativeTest2() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), null, DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[6]/div/label")).getText(), "Enter a UK postcode");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsSomethingElseNegativeTest3() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				null, FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsSomethingElseNegativeTest4() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), null, FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"),
				FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30, FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[4]/div/label")).getText(), "Select your ownership status");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsSomethingElseNegativeTest5() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));
		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_TYPE"), null, null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsSomethingElseNegativeTest6() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(null, FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='typeOfProperty']/div/label")).getText(), "Select the property type");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsSomethingElseNegativeTest7() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[2]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsSomethingElseNegativeTest8() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsSomethingElseNegativeTest9() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));

		String lastName = FlatRoofsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = FlatRoofsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = FlatRoofsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, lastName, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsSomethingElseNegativeTest10() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));

		String firstName = FlatRoofsXpathLocators.xpathLookup.get("FIRST_NAME");
		String phoneNumber = FlatRoofsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		String emailAddress = FlatRoofsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, phoneNumber, phoneNumber, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsSomethingElseNegativeTest11() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));

		String firstName = FlatRoofsXpathLocators.xpathLookup.get("FIRST_NAME");
		String lastName = FlatRoofsXpathLocators.xpathLookup.get("LAST_NAME");
		String emailAddress = FlatRoofsXpathLocators.xpathLookup.get("EMAIL_ADDRESS");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, emailAddress, emailAddress);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaFlatRoofsJobFormsSomethingElseNegativeTest12() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));

		underTest.fillInPage2ForAdditionalInfo(FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_TYPE"),
				FlatRoofsXpathLocators.xpathLookup.get("SOMETHING_ELSE_PROPERTY_STYLE"), null, 0,
				FlatRoofsXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"), FlatRoofsXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"),
				FlatRoofsXpathLocators.xpathLookup.get("URGENTLY"), FlatRoofsXpathLocators.xpathLookup.get("POSTCODE"), DESCRIPTION_LENGTH_30,
				FlatRoofsXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"));

		underTest.fillInPage3ForBudget(FlatRoofsXpathLocators.xpathLookup.get("BUDGET_LT_500"));

		String firstName = FlatRoofsXpathLocators.xpathLookup.get("FIRST_NAME");
		String lastName = FlatRoofsXpathLocators.xpathLookup.get("LAST_NAME");
		String phoneNumber = FlatRoofsXpathLocators.xpathLookup.get("PHONE_NUMBER");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, phoneNumber, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

}
