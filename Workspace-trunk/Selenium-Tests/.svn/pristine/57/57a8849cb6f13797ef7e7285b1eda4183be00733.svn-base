package uk.co.ratedpeople.test.functional.selenium.newjobforms.electrical;

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
import uk.co.ratedpeople.test.functional.selenium.newjobforms.electrical.PostingJobviaElectricalJobForms;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.electrical.ElectricalXpathlocators;

public class PostingJobViaElectricalJobFormsNegativeTest extends TestScript {

	private static final int DESCRIPTION_LENGTH_30 = 30;
	private PostingJobviaElectricalJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobviaElectricalJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaElectricalJobFormsRepairsAndMaintenanceNegativeTest() throws Exception {

		String[] whereRepairsNeeded = { ElectricalXpathlocators.xpathLookup.get("REPEAIR_IN_KITCHEN_RADIO_BTN") };

		underTest.fillInPage1ForJobDetailsForRepairElectrical(ElectricalXpathlocators.xpathLookup.get("REPAIR_RADIO_BTN"), null, whereRepairsNeeded);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobviaElectricalJobFormsRepairsAndMaintenanceNegativeTest1() throws Exception {

		underTest.fillInPage1ForJobDetailsForRepairElectrical(ElectricalXpathlocators.xpathLookup.get("REPAIR_RADIO_BTN"), null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[2]/div/div/label")).getText(),
				"Select whether any of the items exist in a kitchen, bathroom, or outside");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaElectricalJobFormsRepairsAndMaintenanceNegativeTest2() throws Exception {

		String[] whereRepairsNeeded = { ElectricalXpathlocators.xpathLookup.get("REPEAIR_IN_KITCHEN_RADIO_BTN") };

		String[] whatNeedsToBeRepaired = { ElectricalXpathlocators.xpathLookup.get("REPAIR_SHOWER"), ElectricalXpathlocators.xpathLookup.get("REPAIR_HOB") };

		underTest.fillInPage1ForJobDetailsForRepairElectrical(ElectricalXpathlocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded);
		underTest.fillInPage2ForAdditionalInfo("884", null, "ownerLANDLORD", "LT_2_WEEKS", "RP99RP", DESCRIPTION_LENGTH_30, "kumbipakam");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), "Select the appropriate status of the job");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaElectricalJobFormsRepairsAndMaintenanceNegativeTest3() throws Exception {

		String[] whereRepairsNeeded = { ElectricalXpathlocators.xpathLookup.get("REPEAIR_IN_KITCHEN_RADIO_BTN") };

		String[] whatNeedsToBeRepaired = { ElectricalXpathlocators.xpathLookup.get("REPAIR_SHOWER"), ElectricalXpathlocators.xpathLookup.get("REPAIR_HOB") };

		underTest.fillInPage1ForJobDetailsForRepairElectrical(ElectricalXpathlocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded);
		underTest.fillInPage2ForAdditionalInfo("884", "statusREADY_TO_HIRE", "ownerLANDLORD", "LT_2_WEEKS", "RP99RP", DESCRIPTION_LENGTH_30, "kumbipakam");
		underTest.fillInPage3ForBudget(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaElectricalJobFormsRepairsAndMaintenanceNegativeTest4() throws Exception {

		String[] whereRepairsNeeded = { ElectricalXpathlocators.xpathLookup.get("REPEAIR_IN_KITCHEN_RADIO_BTN") };

		String[] whatNeedsToBeRepaired = { ElectricalXpathlocators.xpathLookup.get("REPAIR_SHOWER"), ElectricalXpathlocators.xpathLookup.get("REPAIR_HOB") };

		underTest.fillInPage1ForJobDetailsForRepairElectrical(ElectricalXpathlocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded);
		underTest.fillInPage2ForAdditionalInfo("884", "statusREADY_TO_HIRE", "ownerLANDLORD", "LT_2_WEEKS", "RP99RP", DESCRIPTION_LENGTH_30, "kumbipakam");
		underTest.fillInPage3ForBudget("27_LT_4000");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, "chiru", null, "07427272778", "07427272778", "gmail@gmail.com", "gmail@gmail.com");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaElectricalJobFormsRepairsAndMaintenanceNegativeTest5() throws Exception {

		String[] whatNeedsToBeRepaired = { ElectricalXpathlocators.xpathLookup.get("REPAIR_SHOWER"), ElectricalXpathlocators.xpathLookup.get("REPAIR_HOB") };
		underTest.fillInPage1ForJobDetailsForRepairElectrical(ElectricalXpathlocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[2]/div/div/label")).getText(),
				"Select whether any of the items exist in a kitchen, bathroom, or outside");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaElectricalJobFormsRepairsAndMaintenanceNegativeTest6() throws Exception {

		String[] whereRepairsNeeded = { ElectricalXpathlocators.xpathLookup.get("REPEAIR_IN_KITCHEN_RADIO_BTN") };

		String[] whatNeedsToBeRepaired = { ElectricalXpathlocators.xpathLookup.get("REPAIR_SHOWER"), ElectricalXpathlocators.xpathLookup.get("REPAIR_HOB") };

		underTest.fillInPage1ForJobDetailsForRepairElectrical(ElectricalXpathlocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded);
		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), "Select the appropriate status of the job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), "Select your ownership status");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaElectricalJobFormsRepairsAndMaintenanceNegativeTest7() throws Exception {

		String[] whereRepairsNeeded = { ElectricalXpathlocators.xpathLookup.get("REPEAIR_IN_KITCHEN_RADIO_BTN") };

		String[] whatNeedsToBeRepaired = { ElectricalXpathlocators.xpathLookup.get("REPAIR_SHOWER"), ElectricalXpathlocators.xpathLookup.get("REPAIR_HOB") };

		underTest.fillInPage1ForJobDetailsForRepairElectrical(ElectricalXpathlocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded);
		underTest.fillInPage2ForAdditionalInfo("884", "statusREADY_TO_HIRE", "ownerLANDLORD", "LT_2_WEEKS", "RP99RP", DESCRIPTION_LENGTH_30, "kumbipakam");
		underTest.fillInPage3ForBudget("27_LT_4000");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobviaElectricalJobFormsRepairsAndMaintenanceNegativeTest8() throws Exception {

		String[] whereRepairsNeeded = { ElectricalXpathlocators.xpathLookup.get("REPEAIR_IN_KITCHEN_RADIO_BTN") };

		String[] whatNeedsToBeRepaired = { ElectricalXpathlocators.xpathLookup.get("REPAIR_OTHER") };

		underTest.fillInPage1ForJobDetailsForRepairElectrical(ElectricalXpathlocators.xpathLookup.get("REPAIR_RADIO_BTN"), whatNeedsToBeRepaired,
				whereRepairsNeeded);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRepair']/div[1]/div[2]/ul/li[5]/div/div/label")).getText(),
				"List what needs to be repaired");

	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsReplaceElectricalTest() throws Exception {

		// String[] roofSectionsToReplace = { ElectricalXpathlocators.xpathLookup.get("REPLACE_HOB"), ElectricalXpathlocators.xpathLookup.get("REPLACE_TOWEL")
		// };

		// String[] whereRepairsNeeded = { ElectricalXpathlocators.xpathLookup.get("REPLACE_IN_KITCHEN_RADIO_BTN")};

		underTest.fillInPage1ForJobDetailsForReplaceElectrical(ElectricalXpathlocators.xpathLookup.get("REPLACE_RADIO_BTN"), null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[2]/div/div/label")).getText(),
				"Select whether any of the items exist in a kitchen, bathroom, or outside");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[3]/div/div/label")).getText(), "Select who will supply the fittings");

	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsReplaceElectricalTest1() throws Exception {

		String[] roofSectionsToReplace = { ElectricalXpathlocators.xpathLookup.get("REPLACE_HOB"), ElectricalXpathlocators.xpathLookup.get("REPLACE_TOWEL") };

		// String[] whereRepairsNeeded = { ElectricalXpathlocators.xpathLookup.get("REPLACE_IN_KITCHEN_RADIO_BTN")};

		underTest.fillInPage1ForJobDetailsForReplaceElectrical(ElectricalXpathlocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace, null,
				ElectricalXpathlocators.xpathLookup.get("REPLACE_PROVIDE_ITEMS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[2]/div/div/label")).getText(),
				"Select whether any of the items exist in a kitchen, bathroom, or outside");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsReplaceElectricalTest2() throws Exception {

		String[] roofSectionsToReplace = { ElectricalXpathlocators.xpathLookup.get("REPLACE_HOB"), ElectricalXpathlocators.xpathLookup.get("REPLACE_TOWEL") };

		String[] whereRepairsNeeded = { ElectricalXpathlocators.xpathLookup.get("REPLACE_IN_KITCHEN_RADIO_BTN") };

		underTest.fillInPage1ForJobDetailsForReplaceElectrical(ElectricalXpathlocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
				whereRepairsNeeded, ElectricalXpathlocators.xpathLookup.get("REPLACE_PROVIDE_ITEMS"));
		underTest.fillInPage2ForAdditionalInfo(null, "statusINSURANCE_CLAIM", "ownerLOOKING_TO_BUY", "FLEXIBLE_S_D", "rp99rp", DESCRIPTION_LENGTH_30, "davide");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsReplaceElectricalTest3() throws Exception {

		String[] roofSectionsToReplace = { ElectricalXpathlocators.xpathLookup.get("REPLACE_HOB"), ElectricalXpathlocators.xpathLookup.get("REPLACE_TOWEL") };

		String[] whereRepairsNeeded = { ElectricalXpathlocators.xpathLookup.get("REPLACE_IN_KITCHEN_RADIO_BTN") };

		underTest.fillInPage1ForJobDetailsForReplaceElectrical(ElectricalXpathlocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
				whereRepairsNeeded, ElectricalXpathlocators.xpathLookup.get("REPLACE_PROVIDE_ITEMS"));
		underTest
				.fillInPage2ForAdditionalInfo("904", "statusINSURANCE_CLAIM", "ownerLOOKING_TO_BUY", "FLEXIBLE_S_D", "rp99rp", DESCRIPTION_LENGTH_30, "davide");
		underTest.fillInPage3ForBudget(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");

	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsReplaceElectricalTest4() throws Exception {

		String[] roofSectionsToReplace = { ElectricalXpathlocators.xpathLookup.get("REPLACE_HOB"), ElectricalXpathlocators.xpathLookup.get("REPLACE_TOWEL") };

		String[] whereRepairsNeeded = { ElectricalXpathlocators.xpathLookup.get("REPLACE_IN_KITCHEN_RADIO_BTN") };

		underTest.fillInPage1ForJobDetailsForReplaceElectrical(ElectricalXpathlocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
				whereRepairsNeeded, ElectricalXpathlocators.xpathLookup.get("REPLACE_PROVIDE_ITEMS"));
		underTest
				.fillInPage2ForAdditionalInfo("904", "statusINSURANCE_CLAIM", "ownerLOOKING_TO_BUY", "FLEXIBLE_S_D", "rp99rp", DESCRIPTION_LENGTH_30, "davide");
		underTest.fillInPage3ForBudget("27_LT_4000");
		
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, "chiru", "07427272778", "07427272778", "gmail@gmail.com", "gmail@gmail.com");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");

	}

	public void postingJobviaElectricalJobFormsReplaceElectricalTest5() throws Exception {

		String[] roofSectionsToReplace = { ElectricalXpathlocators.xpathLookup.get("INSTALL_OTHER") };

		String[] whereRepairsNeeded = { ElectricalXpathlocators.xpathLookup.get("REPLACE_IN_KITCHEN_RADIO_BTN") };

		underTest.fillInPage1ForJobDetailsForReplaceElectrical(ElectricalXpathlocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
				whereRepairsNeeded, ElectricalXpathlocators.xpathLookup.get("REPLACE_PROVIDE_ITEMS"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descReplace']/div[1]/div[2]/ul/li[5]/div/div/label")).getText(),
				"List what needs to be installed");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsReplaceElectricalTest6() throws Exception {

		String[] roofSectionsToReplace = { ElectricalXpathlocators.xpathLookup.get("REPLACE_HOB"), ElectricalXpathlocators.xpathLookup.get("REPLACE_TOWEL") };

		String[] whereRepairsNeeded = { ElectricalXpathlocators.xpathLookup.get("REPLACE_IN_KITCHEN_RADIO_BTN") };

		underTest.fillInPage1ForJobDetailsForReplaceElectrical(ElectricalXpathlocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
				whereRepairsNeeded, ElectricalXpathlocators.xpathLookup.get("REPLACE_PROVIDE_ITEMS"));
		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), "Select the appropriate status of the job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), "Select your ownership status");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");

	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsReplaceElectricalTest7() throws Exception {

		String[] roofSectionsToReplace = { ElectricalXpathlocators.xpathLookup.get("REPLACE_HOB"), ElectricalXpathlocators.xpathLookup.get("REPLACE_TOWEL") };

		String[] whereRepairsNeeded = { ElectricalXpathlocators.xpathLookup.get("REPLACE_IN_KITCHEN_RADIO_BTN") };

		underTest.fillInPage1ForJobDetailsForReplaceElectrical(ElectricalXpathlocators.xpathLookup.get("REPLACE_RADIO_BTN"), roofSectionsToReplace,
				whereRepairsNeeded, ElectricalXpathlocators.xpathLookup.get("REPLACE_PROVIDE_ITEMS"));
		underTest
				.fillInPage2ForAdditionalInfo("904", "statusINSURANCE_CLAIM", "ownerLOOKING_TO_BUY", "FLEXIBLE_S_D", "rp99rp", DESCRIPTION_LENGTH_30, "davide");
		underTest.fillInPage3ForBudget("27_LT_4000");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsRewiringTest() throws Exception {

		String[] sectionsToRewire = { ElectricalXpathlocators.xpathLookup.get("REWIRE_OTHER") };

		underTest.fillInPage1ForJobDetailsForRewireElectrical(ElectricalXpathlocators.xpathLookup.get("REWIRE_RADIO_BTN"), sectionsToRewire);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRewire']/div[1]/div[2]/ul/li[4]/div/div/label")).getText(),
				"List what areas need wiring");

	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsRewiringTest1() throws Exception {

		underTest.fillInPage1ForJobDetailsForRewireElectrical(ElectricalXpathlocators.xpathLookup.get("REWIRE_RADIO_BTN"), null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRewire']/div[1]/div[3]/div/label")).getText(),
				"At least one option needs to be selected");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsRewiringTest2() throws Exception {

		String[] sectionsToRewire = { ElectricalXpathlocators.xpathLookup.get("REWIRING_DINING"), ElectricalXpathlocators.xpathLookup.get("REWIRING_LOUNGE") };

		underTest.fillInPage1ForJobDetailsForRewireElectrical(ElectricalXpathlocators.xpathLookup.get("REWIRE_RADIO_BTN"), sectionsToRewire);
		underTest.fillInPage2ForAdditionalInfo("919", "statusINSURANCE_CLAIM", "ownerLANDLORD", null, "rp99rp", DESCRIPTION_LENGTH_30, "jonathan");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsRewiringTest3() throws Exception {

		String[] sectionsToRewire = { ElectricalXpathlocators.xpathLookup.get("REWIRING_DINING"), ElectricalXpathlocators.xpathLookup.get("REWIRING_LOUNGE") };

		underTest.fillInPage1ForJobDetailsForRewireElectrical(ElectricalXpathlocators.xpathLookup.get("REWIRE_RADIO_BTN"), sectionsToRewire);
		underTest.fillInPage2ForAdditionalInfo("919", "statusINSURANCE_CLAIM", "ownerLANDLORD", "LT_2_WEEKS", "rp99rp", DESCRIPTION_LENGTH_30, "jonathan");
		underTest.fillInPage3ForBudget(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsRewiringTest4() throws Exception {

		String[] sectionsToRewire = { ElectricalXpathlocators.xpathLookup.get("REWIRING_DINING"), ElectricalXpathlocators.xpathLookup.get("REWIRING_LOUNGE") };

		underTest.fillInPage1ForJobDetailsForRewireElectrical(ElectricalXpathlocators.xpathLookup.get("REWIRE_RADIO_BTN"), sectionsToRewire);
		underTest.fillInPage2ForAdditionalInfo("919", "statusINSURANCE_CLAIM", "ownerLANDLORD", "LT_2_WEEKS", "rp99rp", DESCRIPTION_LENGTH_30, "jonathan");
		underTest.fillInPage3ForBudget("27_LT_1000");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, "jhon", "peter", "07427897897", "07427897897", null, null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsRewiringTest5() throws Exception {

		String[] sectionsToRewire = { ElectricalXpathlocators.xpathLookup.get("REWIRING_DINING"), ElectricalXpathlocators.xpathLookup.get("REWIRING_LOUNGE") };

		underTest.fillInPage1ForJobDetailsForRewireElectrical(ElectricalXpathlocators.xpathLookup.get("REWIRE_RADIO_BTN"), sectionsToRewire);
		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), "Select the appropriate status of the job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), "Select your ownership status");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsRewiringTest6() throws Exception {

		String[] sectionsToRewire = { ElectricalXpathlocators.xpathLookup.get("REWIRING_DINING"), ElectricalXpathlocators.xpathLookup.get("REWIRING_LOUNGE") };

		underTest.fillInPage1ForJobDetailsForRewireElectrical(ElectricalXpathlocators.xpathLookup.get("REWIRE_RADIO_BTN"), sectionsToRewire);
		underTest.fillInPage2ForAdditionalInfo("919", "statusINSURANCE_CLAIM", "ownerLANDLORD", "LT_2_WEEKS", "rp99rp", DESCRIPTION_LENGTH_30, "jonathan");
		underTest.fillInPage3ForBudget("27_LT_1000");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsCertificationTest() throws Exception {

		String[] whatNeedsToBeTested = { ElectricalXpathlocators.xpathLookup.get("TEST_OTHER") };

		underTest.fillInPage1ForJobDetailsForTestingElectrical(ElectricalXpathlocators.xpathLookup.get("TESTING_RADIO_BTN"), whatNeedsToBeTested);

		context.driver.findElement(By.xpath(".//*[@id='descTesting']/div[1]/div[1]/ul/li[1]/label/a")).click();
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descTesting']/div[1]/div[1]/ul/li[4]/div/label")).getText(),
				"List what needs to be inspected");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsCertificationTest1() throws Exception {

		underTest.fillInPage1ForJobDetailsForTestingElectrical(ElectricalXpathlocators.xpathLookup.get("TESTING_RADIO_BTN"), null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descTesting']/div[1]/div[2]/label")).getText(), "At least one option needs to be selected");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsCertificationTest2() throws Exception {

		String[] whatNeedsToBeTested = { ElectricalXpathlocators.xpathLookup.get("TESTING_REPORT"),
				ElectricalXpathlocators.xpathLookup.get("TESTING_APPLIANCE") };

		underTest.fillInPage1ForJobDetailsForTestingElectrical(ElectricalXpathlocators.xpathLookup.get("TESTING_RADIO_BTN"), whatNeedsToBeTested);

		underTest.fillInPage2ForAdditionalInfo("927", "statusPLANNING_BUDGETING", "ownerRENT", "LT_2_WEEKS", null, DESCRIPTION_LENGTH_30, "jhonny");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsCertificationTest3() throws Exception {

		String[] whatNeedsToBeTested = { ElectricalXpathlocators.xpathLookup.get("TESTING_REPORT"),
				ElectricalXpathlocators.xpathLookup.get("TESTING_APPLIANCE") };

		underTest.fillInPage1ForJobDetailsForTestingElectrical(ElectricalXpathlocators.xpathLookup.get("TESTING_RADIO_BTN"), whatNeedsToBeTested);

		underTest.fillInPage2ForAdditionalInfo("927", "statusPLANNING_BUDGETING", "ownerRENT", "LT_2_WEEKS", "rp99rp", DESCRIPTION_LENGTH_30, "jhonny");
		underTest.fillInPage3ForBudget(null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsCertificationTest4() throws Exception {

		String[] whatNeedsToBeTested = { ElectricalXpathlocators.xpathLookup.get("TESTING_REPORT"),
				ElectricalXpathlocators.xpathLookup.get("TESTING_APPLIANCE") };

		underTest.fillInPage1ForJobDetailsForTestingElectrical(ElectricalXpathlocators.xpathLookup.get("TESTING_RADIO_BTN"), whatNeedsToBeTested);

		underTest.fillInPage2ForAdditionalInfo("927", "statusPLANNING_BUDGETING", "ownerRENT", "LT_2_WEEKS", "rp99rp", DESCRIPTION_LENGTH_30, "jhonny");
		underTest.fillInPage3ForBudget("27_LT_8000");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, "jhina", null, "07427897897", "07427897897", "gmail@gmail.com", "gmail@gmail.com");

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsCertificationTest5() throws Exception {

		String[] whatNeedsToBeTested = { ElectricalXpathlocators.xpathLookup.get("TESTING_REPORT"),
				ElectricalXpathlocators.xpathLookup.get("TESTING_APPLIANCE") };

		underTest.fillInPage1ForJobDetailsForTestingElectrical(ElectricalXpathlocators.xpathLookup.get("TESTING_RADIO_BTN"), whatNeedsToBeTested);

		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), "Select the appropriate status of the job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), "Select your ownership status");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsCertificationTest6() throws Exception {

		String[] whatNeedsToBeTested = { ElectricalXpathlocators.xpathLookup.get("TESTING_REPORT"),
				ElectricalXpathlocators.xpathLookup.get("TESTING_APPLIANCE") };

		underTest.fillInPage1ForJobDetailsForTestingElectrical(ElectricalXpathlocators.xpathLookup.get("TESTING_RADIO_BTN"), whatNeedsToBeTested);

		underTest.fillInPage2ForAdditionalInfo("927", "statusPLANNING_BUDGETING", "ownerRENT", "LT_2_WEEKS", "rp99rp", DESCRIPTION_LENGTH_30, "jhonny");
		underTest.fillInPage3ForBudget("27_LT_8000");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsConsumerTest() throws Exception {

		underTest.fillInPage1ForJobDetailsForConsumerElectrical(ElectricalXpathlocators.xpathLookup.get("CONSUMER_RADIO_BTN"), null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descConsumer']/div[1]/div/div/label")).getText(),
				"Select what work needs to be carried out");

	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsConsumerTest1() throws Exception {

		underTest.fillInPage1ForJobDetailsForConsumerElectrical(ElectricalXpathlocators.xpathLookup.get("CONSUMER_RADIO_BTN"), null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descConsumer']/div[1]/div/div/label")).getText(),
				"Select what work needs to be carried out");

	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsConsumerTest2() throws Exception {

		underTest.fillInPage1ForJobDetailsForConsumerElectrical(ElectricalXpathlocators.xpathLookup.get("CONSUMER_RADIO_BTN"),
				ElectricalXpathlocators.xpathLookup.get("CONSUMER_REPLACE"));
		underTest.fillInPage2ForAdditionalInfo(null, "statusINSURANCE_CLAIM", "ownerOWN_AND_LIVE", "GT_2_MONTHS", "rp99rp", DESCRIPTION_LENGTH_30, "penny");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");

	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsConsumerTest3() throws Exception {

		underTest.fillInPage1ForJobDetailsForConsumerElectrical(ElectricalXpathlocators.xpathLookup.get("CONSUMER_RADIO_BTN"),
				ElectricalXpathlocators.xpathLookup.get("CONSUMER_REPLACE"));
		underTest.fillInPage2ForAdditionalInfo("937", "statusINSURANCE_CLAIM", "ownerOWN_AND_LIVE", "GT_2_MONTHS", "rp99rp", DESCRIPTION_LENGTH_30, "penny");
		underTest.fillInPage3ForBudget(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");

	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsConsumerTest4() throws Exception {

		underTest.fillInPage1ForJobDetailsForConsumerElectrical(ElectricalXpathlocators.xpathLookup.get("CONSUMER_RADIO_BTN"),
				ElectricalXpathlocators.xpathLookup.get("CONSUMER_REPLACE"));
		underTest.fillInPage2ForAdditionalInfo("937", "statusINSURANCE_CLAIM", "ownerOWN_AND_LIVE", "GT_2_MONTHS", "rp99rp", DESCRIPTION_LENGTH_30, "penny");
		underTest.fillInPage3ForBudget("27_LT_500");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, "jhina", null, "07427897897", "07427897897", "gmail@gmail.com", "gmail@gmail.com");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");

	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsConsumerTest5() throws Exception {

		underTest.fillInPage1ForJobDetailsForConsumerElectrical(ElectricalXpathlocators.xpathLookup.get("CONSUMER_RADIO_BTN"),
				ElectricalXpathlocators.xpathLookup.get("CONSUMER_REPLACE"));
		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), "Select the appropriate status of the job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), "Select your ownership status");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");

	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsConsumerTest6() throws Exception {

		underTest.fillInPage1ForJobDetailsForConsumerElectrical(ElectricalXpathlocators.xpathLookup.get("CONSUMER_RADIO_BTN"),
				ElectricalXpathlocators.xpathLookup.get("CONSUMER_REPLACE"));
		underTest.fillInPage2ForAdditionalInfo("937", "statusINSURANCE_CLAIM", "ownerOWN_AND_LIVE", "GT_2_MONTHS", "rp99rp", DESCRIPTION_LENGTH_30, "penny");
		underTest.fillInPage3ForBudget("27_LT_500");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsSomethingElseTest2() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ElectricalXpathlocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));
		underTest.fillInPage2ForAdditionalInfo(null, "statusINSURANCE_CLAIM", "ownerOWN_AND_LIVE", "GT_2_MONTHS", "rp99rp", DESCRIPTION_LENGTH_30,
				ElectricalXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsSomethingElseTest3() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ElectricalXpathlocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));
		underTest.fillInPage2ForAdditionalInfo("949", "statusINSURANCE_CLAIM", "ownerOWN_AND_LIVE", "GT_2_MONTHS", "rp99rp", DESCRIPTION_LENGTH_30,
				ElectricalXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget(null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[2]/label")).getText(), "Select an approximate budget");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsSomethingElseTest4() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ElectricalXpathlocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));
		underTest.fillInPage2ForAdditionalInfo("949", "statusINSURANCE_CLAIM", "ownerOWN_AND_LIVE", "GT_2_MONTHS", "rp99rp", DESCRIPTION_LENGTH_30,
				ElectricalXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget("27_LT_8000");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, "jhina", null, "07427897897", "07427897897", "gmail@gmail.com", "gmail@gmail.com");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsSomethingElseTest5() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ElectricalXpathlocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));
		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, null, DESCRIPTION_LENGTH_30, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='styleOfProperty']/div/label")).getText(), "Select the property style");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[1]/div/label")).getText(), "Select the appropriate status of the job");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[2]/div/label")).getText(), "Select your ownership status");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='timeframe']/div/label")).getText(), "Select when you want the job to start");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage2']/div[5]/div/label")).getText(), "Enter a UK postcode");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/div/label")).getText(),
				"Enter additional details about your job");

	}

	@Test(enabled = true)
	public void postingJobviaElectricalJobFormsSomethingElseTest6() throws Exception {

		underTest.fillInPage1ForJobDetailsForSomethingElse(ElectricalXpathlocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"));
		underTest.fillInPage2ForAdditionalInfo("949", "statusINSURANCE_CLAIM", "ownerOWN_AND_LIVE", "GT_2_MONTHS", "rp99rp", DESCRIPTION_LENGTH_30,
				ElectricalXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"));
		underTest.fillInPage3ForBudget("27_LT_8000");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");
	}

}
