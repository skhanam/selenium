package uk.co.ratedpeople.test.functional.selenium.newjobforms.kitchen;

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
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

public class PostingJobViaKitchenJobFormsNegativeTest extends TestScript {

	private PostingJobViaKitchenJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaKitchenJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotesKitchen();
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));

		underTest.fillInInstallNewKitchenStage2(null, null, null, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("INSTALLED_KITCHEN_ERRORMSGXPATH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("INSTALLED_KITCHEN_ERRORMESSAGE"));
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descInstall']/div[2]/div[3]/label")).getText(), "Select the type of worktop");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descInstall']/div[4]/div/label")).getText(), "Select the size of the kitchen");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descInstall']/div[5]/div/label")).getText(), "Select who will supply the kitchen");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descInstall']/div[6]/div/label")).getText(),
				"Select whether existing kitchen needs to be removed");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest1() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));

		String[] ADDITIONAL_INSTALL = { KitchenXpathLocators.xpathlookup.get("INSTALL_FLOORLINO"),
				KitchenXpathLocators.xpathlookup.get("INSTALL_WORKTOPWOODEN") };

		underTest.fillInInstallNewKitchenStage2(null, null, KitchenXpathLocators.xpathlookup.get("TYPE_OF_WORKTOP"), null, ADDITIONAL_INSTALL, null,
				KitchenXpathLocators.xpathlookup.get("INSTALL_KITCHEN_SIZE"), KitchenXpathLocators.xpathlookup.get("SUPPLY_MATERIAL_INSTALL"),
				KitchenXpathLocators.xpathlookup.get("REMOVED_EXISTING_KITCHEN"));
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descInstall']/div[1]/div[3]/label")).getText(), "At least one option needs to be selected");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest2() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));

		String[] PART_TO_INSTALL = { KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLGASHOB"),
				KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLELECTRICOVEN") };

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, KitchenXpathLocators.xpathlookup.get("TYPE_OF_WORKTOP"), null, null, null,
				KitchenXpathLocators.xpathlookup.get("INSTALL_KITCHEN_SIZE"), KitchenXpathLocators.xpathlookup.get("SUPPLY_MATERIAL_INSTALL"),
				KitchenXpathLocators.xpathlookup.get("REMOVED_EXISTING_KITCHEN"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest3() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));

		String[] PART_TO_INSTALL = { KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLGASHOB"),
				KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLELECTRICOVEN") };
		String[] ADDITIONAL_INSTALL = { KitchenXpathLocators.xpathlookup.get("INSTALL_FLOORLINO"),
				KitchenXpathLocators.xpathlookup.get("INSTALL_WORKTOPWOODEN") };

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, null, null, ADDITIONAL_INSTALL, null,
				KitchenXpathLocators.xpathlookup.get("INSTALL_KITCHEN_SIZE"), KitchenXpathLocators.xpathlookup.get("SUPPLY_MATERIAL_INSTALL"),
				KitchenXpathLocators.xpathlookup.get("REMOVED_EXISTING_KITCHEN"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descInstall']/div[2]/div[3]/label")).getText(), "Select the type of worktop");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest4() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));

		String[] PART_TO_INSTALL = { KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLGASHOB"),
				KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLELECTRICOVEN") };
		String[] ADDITIONAL_INSTALL = { KitchenXpathLocators.xpathlookup.get("INSTALL_FLOORLINO"),
				KitchenXpathLocators.xpathlookup.get("INSTALL_WORKTOPWOODEN") };

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, KitchenXpathLocators.xpathlookup.get("TYPE_OF_WORKTOP"), null, ADDITIONAL_INSTALL, null,
				null, KitchenXpathLocators.xpathlookup.get("SUPPLY_MATERIAL_INSTALL"), KitchenXpathLocators.xpathlookup.get("REMOVED_EXISTING_KITCHEN"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descInstall']/div[4]/div/label")).getText(), "Select the size of the kitchen");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest5() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));

		String[] PART_TO_INSTALL = { KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLGASHOB"),
				KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLELECTRICOVEN") };
		String[] ADDITIONAL_INSTALL = { KitchenXpathLocators.xpathlookup.get("INSTALL_FLOORLINO"),
				KitchenXpathLocators.xpathlookup.get("INSTALL_WORKTOPWOODEN") };

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, KitchenXpathLocators.xpathlookup.get("TYPE_OF_WORKTOP"), null, ADDITIONAL_INSTALL, null,
				KitchenXpathLocators.xpathlookup.get("INSTALL_KITCHEN_SIZE"), null, KitchenXpathLocators.xpathlookup.get("REMOVED_EXISTING_KITCHEN"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descInstall']/div[5]/div/label")).getText(), "Select who will supply the kitchen");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest6() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));

		String[] PART_TO_INSTALL = { KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLGASHOB"),
				KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLELECTRICOVEN") };
		String[] ADDITIONAL_INSTALL = { KitchenXpathLocators.xpathlookup.get("INSTALL_FLOORLINO"),
				KitchenXpathLocators.xpathlookup.get("INSTALL_WORKTOPWOODEN") };

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, KitchenXpathLocators.xpathlookup.get("TYPE_OF_WORKTOP"), null, ADDITIONAL_INSTALL, null,
				KitchenXpathLocators.xpathlookup.get("INSTALL_KITCHEN_SIZE"), KitchenXpathLocators.xpathlookup.get("SUPPLY_MATERIAL_INSTALL"), null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descInstall']/div[6]/div/label")).getText(),
				"Select whether existing kitchen needs to be removed");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest7() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));
		String[] PART_TO_INSTALL = { KitchenXpathLocators.xpathlookup.get("INSTALL_OTHER"), KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLELECTRICOVEN") };
		String[] ADDITIONAL_INSTALL = { KitchenXpathLocators.xpathlookup.get("OPTIONAL_OTHER"), KitchenXpathLocators.xpathlookup.get("WORKTOP_OTHER") };

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, KitchenXpathLocators.xpathlookup.get("TYPE_OF_WORKTOP"), null, ADDITIONAL_INSTALL, null,
				KitchenXpathLocators.xpathlookup.get("INSTALL_KITCHEN_SIZE"), KitchenXpathLocators.xpathlookup.get("SUPPLY_MATERIAL_INSTALL"),
				KitchenXpathLocators.xpathlookup.get("REMOVED_EXISTING_KITCHEN"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descInstall']/div[1]/div[2]/ul/li[8]/div/label")).getText(),
				"List what else is to be installed");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descInstall']/div[2]/div[2]/ul/li[4]/div/label")).getText(),
				"List the type of worktop you require");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descInstall']/div[3]/div[2]/ul/li[5]/div/label")).getText(), "List what else you need");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest8() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));

		String[] PART_TO_INSTALL = { KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLGASHOB"),
				KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLELECTRICOVEN") };
		String[] ADDITIONAL_INSTALL = { KitchenXpathLocators.xpathlookup.get("INSTALL_FLOORLINO"),
				KitchenXpathLocators.xpathlookup.get("INSTALL_WORKTOPWOODEN") };

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, KitchenXpathLocators.xpathlookup.get("TYPE_OF_WORKTOP"), null, ADDITIONAL_INSTALL, null,
				KitchenXpathLocators.xpathlookup.get("INSTALL_KITCHEN_SIZE"), KitchenXpathLocators.xpathlookup.get("SUPPLY_MATERIAL_INSTALL"),
				KitchenXpathLocators.xpathlookup.get("REMOVED_EXISTING_KITCHEN"));

		underTest.fillInStage3(null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("APPROPRIATE_STATUS_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("APPROPRIATE_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("ADDITIONAL_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest9() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));

		String[] PART_TO_INSTALL = { KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLGASHOB"),
				KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLELECTRICOVEN") };
		String[] ADDITIONAL_INSTALL = { KitchenXpathLocators.xpathlookup.get("INSTALL_FLOORLINO"),
				KitchenXpathLocators.xpathlookup.get("INSTALL_WORKTOPWOODEN") };

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, KitchenXpathLocators.xpathlookup.get("TYPE_OF_WORKTOP"), null, ADDITIONAL_INSTALL, null,
				KitchenXpathLocators.xpathlookup.get("INSTALL_KITCHEN_SIZE"), KitchenXpathLocators.xpathlookup.get("SUPPLY_MATERIAL_INSTALL"),
				KitchenXpathLocators.xpathlookup.get("REMOVED_EXISTING_KITCHEN"));

		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("ADDITIONAL_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest10() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));

		String[] PART_TO_INSTALL = { KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLGASHOB"),
				KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLELECTRICOVEN") };
		String[] ADDITIONAL_INSTALL = { KitchenXpathLocators.xpathlookup.get("INSTALL_FLOORLINO"),
				KitchenXpathLocators.xpathlookup.get("INSTALL_WORKTOPWOODEN") };

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, KitchenXpathLocators.xpathlookup.get("TYPE_OF_WORKTOP"), null, ADDITIONAL_INSTALL, null,
				KitchenXpathLocators.xpathlookup.get("INSTALL_KITCHEN_SIZE"), KitchenXpathLocators.xpathlookup.get("SUPPLY_MATERIAL_INSTALL"),
				KitchenXpathLocators.xpathlookup.get("REMOVED_EXISTING_KITCHEN"));

		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), null, KitchenXpathLocators.xpathlookup.get("TIMING"),
				KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));

		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest11() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));

		String[] PART_TO_INSTALL = { KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLGASHOB"),
				KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLELECTRICOVEN") };
		String[] ADDITIONAL_INSTALL = { KitchenXpathLocators.xpathlookup.get("INSTALL_FLOORLINO"),
				KitchenXpathLocators.xpathlookup.get("INSTALL_WORKTOPWOODEN") };

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, KitchenXpathLocators.xpathlookup.get("TYPE_OF_WORKTOP"), null, ADDITIONAL_INSTALL, null,
				KitchenXpathLocators.xpathlookup.get("INSTALL_KITCHEN_SIZE"), KitchenXpathLocators.xpathlookup.get("SUPPLY_MATERIAL_INSTALL"),
				KitchenXpathLocators.xpathlookup.get("REMOVED_EXISTING_KITCHEN"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"), null,
				KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest12() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));

		String[] PART_TO_INSTALL = { KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLGASHOB"),
				KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLELECTRICOVEN") };
		String[] ADDITIONAL_INSTALL = { KitchenXpathLocators.xpathlookup.get("INSTALL_FLOORLINO"),
				KitchenXpathLocators.xpathlookup.get("INSTALL_WORKTOPWOODEN") };

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, KitchenXpathLocators.xpathlookup.get("TYPE_OF_WORKTOP"), null, ADDITIONAL_INSTALL, null,
				KitchenXpathLocators.xpathlookup.get("INSTALL_KITCHEN_SIZE"), KitchenXpathLocators.xpathlookup.get("SUPPLY_MATERIAL_INSTALL"),
				KitchenXpathLocators.xpathlookup.get("REMOVED_EXISTING_KITCHEN"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), null, TestScriptUtilities.getRandomString(10));

		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest13() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));

		String[] PART_TO_INSTALL = { KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLGASHOB"),
				KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLELECTRICOVEN") };
		String[] ADDITIONAL_INSTALL = { KitchenXpathLocators.xpathlookup.get("INSTALL_FLOORLINO"),
				KitchenXpathLocators.xpathlookup.get("INSTALL_WORKTOPWOODEN") };

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, KitchenXpathLocators.xpathlookup.get("TYPE_OF_WORKTOP"), null, ADDITIONAL_INSTALL, null,
				KitchenXpathLocators.xpathlookup.get("INSTALL_KITCHEN_SIZE"), KitchenXpathLocators.xpathlookup.get("SUPPLY_MATERIAL_INSTALL"),
				KitchenXpathLocators.xpathlookup.get("REMOVED_EXISTING_KITCHEN"));

		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));

		underTest.fillInStage4(null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[3]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest14() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));

		String[] PART_TO_INSTALL = { KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLGASHOB"),
				KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLELECTRICOVEN") };
		String[] ADDITIONAL_INSTALL = { KitchenXpathLocators.xpathlookup.get("INSTALL_FLOORLINO"),
				KitchenXpathLocators.xpathlookup.get("INSTALL_WORKTOPWOODEN") };

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, KitchenXpathLocators.xpathlookup.get("TYPE_OF_WORKTOP"), null, ADDITIONAL_INSTALL, null,
				KitchenXpathLocators.xpathlookup.get("INSTALL_KITCHEN_SIZE"), KitchenXpathLocators.xpathlookup.get("SUPPLY_MATERIAL_INSTALL"),
				KitchenXpathLocators.xpathlookup.get("REMOVED_EXISTING_KITCHEN"));

		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));

		underTest.fillInStage4(KitchenXpathLocators.xpathlookup.get("BUDGET"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest15() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));

		String[] PART_TO_INSTALL = { KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLGASHOB"),
				KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLELECTRICOVEN") };
		String[] ADDITIONAL_INSTALL = { KitchenXpathLocators.xpathlookup.get("INSTALL_FLOORLINO"),
				KitchenXpathLocators.xpathlookup.get("INSTALL_WORKTOPWOODEN") };

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, KitchenXpathLocators.xpathlookup.get("TYPE_OF_WORKTOP"), null, ADDITIONAL_INSTALL, null,
				KitchenXpathLocators.xpathlookup.get("INSTALL_KITCHEN_SIZE"), KitchenXpathLocators.xpathlookup.get("SUPPLY_MATERIAL_INSTALL"),
				KitchenXpathLocators.xpathlookup.get("REMOVED_EXISTING_KITCHEN"));

		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));

		underTest.fillInStage4(KitchenXpathLocators.xpathlookup.get("BUDGET"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, KitchenXpathLocators.xpathlookup.get("LASTNAME"),
				KitchenXpathLocators.xpathlookup.get("PHONE_NUMBER"), null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsInstallNegativeTest16() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("INSTALL"));

		String[] PART_TO_INSTALL = { KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLGASHOB"),
				KitchenXpathLocators.xpathlookup.get("PART_TO_INSTALLELECTRICOVEN") };
		String[] ADDITIONAL_INSTALL = { KitchenXpathLocators.xpathlookup.get("INSTALL_FLOORLINO"),
				KitchenXpathLocators.xpathlookup.get("INSTALL_WORKTOPWOODEN") };

		underTest.fillInInstallNewKitchenStage2(PART_TO_INSTALL, null, KitchenXpathLocators.xpathlookup.get("TYPE_OF_WORKTOP"), null, ADDITIONAL_INSTALL, null,
				KitchenXpathLocators.xpathlookup.get("INSTALL_KITCHEN_SIZE"), KitchenXpathLocators.xpathlookup.get("SUPPLY_MATERIAL_INSTALL"),
				KitchenXpathLocators.xpathlookup.get("REMOVED_EXISTING_KITCHEN"));

		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));

		underTest.fillInStage4(KitchenXpathLocators.xpathlookup.get("BUDGET"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, KitchenXpathLocators.xpathlookup.get("FIRSTNAME"), null, null, null,
				KitchenXpathLocators.xpathlookup.get("EMAIL"), KitchenXpathLocators.xpathlookup.get("EMAIL"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsRefurbishNegativeTest() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("REFURBISH"));

		underTest.fillInRefurbishKitchenStage2(null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRefurbish']/div[1]/div[3]/label")).getText(),
				"At least one option needs to be selected");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRefurbish']/div[2]/div/label")).getText(), "Select the size of the kitchen");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsRefurbishNegativeTest1() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("REFURBISH"));
		underTest.fillInRefurbishKitchenStage2(null, null, KitchenXpathLocators.xpathlookup.get("REFURBISH_KITCHEN_SIZE"));
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRefurbish']/div[1]/div[3]/label")).getText(),
				"At least one option needs to be selected");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsRefurbishNegativeTest2() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("REFURBISH"));

		String[] PART_TO_REFURBISH = { KitchenXpathLocators.xpathlookup.get("REFURBISH_FLOORLAMINATE"),
				KitchenXpathLocators.xpathlookup.get("REFURBISH_WALLTILLING") };
		underTest.fillInRefurbishKitchenStage2(PART_TO_REFURBISH, null, null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRefurbish']/div[2]/div/label")).getText(), "Select the size of the kitchen");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsRefurbishNegativeTest3() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("REFURBISH"));
		String[] PART_TO_REFURBISH = { KitchenXpathLocators.xpathlookup.get("REFURBISH_FLOORLAMINATE"), KitchenXpathLocators.xpathlookup.get("REFURBISH_OTHER") };

		underTest.fillInRefurbishKitchenStage2(PART_TO_REFURBISH, null, KitchenXpathLocators.xpathlookup.get("REFURBISH_KITCHEN_SIZE"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='descRefurbish']/div[1]/div[2]/ul/li[7]/div/label")).getText(),
				"List what else is to be refurbished");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsRefurbishNegativeTest4() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("REFURBISH"));
		String[] PART_TO_REFURBISH = { KitchenXpathLocators.xpathlookup.get("REFURBISH_FLOORLAMINATE"),
				KitchenXpathLocators.xpathlookup.get("REFURBISH_WALLTILLING") };

		underTest.fillInRefurbishKitchenStage2(PART_TO_REFURBISH, null, KitchenXpathLocators.xpathlookup.get("REFURBISH_KITCHEN_SIZE"));
		underTest.fillInStage3(null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("APPROPRIATE_STATUS_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("APPROPRIATE_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("ADDITIONAL_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsRefurbishNegativeTest5() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("REFURBISH"));
		String[] PART_TO_REFURBISH = { KitchenXpathLocators.xpathlookup.get("REFURBISH_FLOORLAMINATE"),
				KitchenXpathLocators.xpathlookup.get("REFURBISH_WALLTILLING") };

		underTest.fillInRefurbishKitchenStage2(PART_TO_REFURBISH, null, KitchenXpathLocators.xpathlookup.get("REFURBISH_KITCHEN_SIZE"));

		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("ADDITIONAL_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("ADDITIONAL_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsRefurbishNegativeTest6() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("REFURBISH"));
		String[] PART_TO_REFURBISH = { KitchenXpathLocators.xpathlookup.get("REFURBISH_FLOORLAMINATE"),
				KitchenXpathLocators.xpathlookup.get("REFURBISH_WALLTILLING") };

		underTest.fillInRefurbishKitchenStage2(PART_TO_REFURBISH, null, KitchenXpathLocators.xpathlookup.get("REFURBISH_KITCHEN_SIZE"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), null, KitchenXpathLocators.xpathlookup.get("TIMING"),
				KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));

		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsRefurbishNegativeTest7() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("REFURBISH"));
		String[] PART_TO_REFURBISH = { KitchenXpathLocators.xpathlookup.get("REFURBISH_FLOORLAMINATE"),
				KitchenXpathLocators.xpathlookup.get("REFURBISH_WALLTILLING") };

		underTest.fillInRefurbishKitchenStage2(PART_TO_REFURBISH, null, KitchenXpathLocators.xpathlookup.get("REFURBISH_KITCHEN_SIZE"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"), null,
				KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsRefurbishNegativeTest8() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("REFURBISH"));
		String[] PART_TO_REFURBISH = { KitchenXpathLocators.xpathlookup.get("REFURBISH_FLOORLAMINATE"),
				KitchenXpathLocators.xpathlookup.get("REFURBISH_WALLTILLING") };

		underTest.fillInRefurbishKitchenStage2(PART_TO_REFURBISH, null, KitchenXpathLocators.xpathlookup.get("REFURBISH_KITCHEN_SIZE"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), null, TestScriptUtilities.getRandomString(10));

		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsRefurbishNegativeTest9() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("REFURBISH"));
		String[] PART_TO_REFURBISH = { KitchenXpathLocators.xpathlookup.get("REFURBISH_FLOORLAMINATE"),
				KitchenXpathLocators.xpathlookup.get("REFURBISH_WALLTILLING") };

		underTest.fillInRefurbishKitchenStage2(PART_TO_REFURBISH, null, KitchenXpathLocators.xpathlookup.get("REFURBISH_KITCHEN_SIZE"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));

		underTest.fillInStage4(null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[2]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsRefurbishNegativeTest10() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("REFURBISH"));
		String[] PART_TO_REFURBISH = { KitchenXpathLocators.xpathlookup.get("REFURBISH_FLOORLAMINATE"),
				KitchenXpathLocators.xpathlookup.get("REFURBISH_WALLTILLING") };

		underTest.fillInRefurbishKitchenStage2(PART_TO_REFURBISH, null, KitchenXpathLocators.xpathlookup.get("REFURBISH_KITCHEN_SIZE"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(KitchenXpathLocators.xpathlookup.get("BUDGET"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsRefurbishNegativeTest11() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("REFURBISH"));
		String[] PART_TO_REFURBISH = { KitchenXpathLocators.xpathlookup.get("REFURBISH_FLOORLAMINATE"),
				KitchenXpathLocators.xpathlookup.get("REFURBISH_WALLTILLING") };

		underTest.fillInRefurbishKitchenStage2(PART_TO_REFURBISH, null, KitchenXpathLocators.xpathlookup.get("REFURBISH_KITCHEN_SIZE"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(KitchenXpathLocators.xpathlookup.get("BUDGET"));
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, KitchenXpathLocators.xpathlookup.get("LASTNAME"),
				KitchenXpathLocators.xpathlookup.get("PHONE_NUMBER"), null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsRefurbishNegativeTest12() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("REFURBISH"));
		String[] PART_TO_REFURBISH = { KitchenXpathLocators.xpathlookup.get("REFURBISH_FLOORLAMINATE"),
				KitchenXpathLocators.xpathlookup.get("REFURBISH_WALLTILLING") };

		underTest.fillInRefurbishKitchenStage2(PART_TO_REFURBISH, null, KitchenXpathLocators.xpathlookup.get("REFURBISH_KITCHEN_SIZE"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(KitchenXpathLocators.xpathlookup.get("BUDGET"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, KitchenXpathLocators.xpathlookup.get("FIRSTNAME"), null, null, null,
				KitchenXpathLocators.xpathlookup.get("EMAIL"), KitchenXpathLocators.xpathlookup.get("EMAIL"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsWorktopTest() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("WORKTOPS"));
		underTest.fillInStage3(null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("APPROPRIATE_STATUS_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("APPROPRIATE_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("ADDITIONAL_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsWorktopTest1() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("WORKTOPS"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("ADDITIONAL_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("ADDITIONAL_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsWorktopTest2() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("WORKTOPS"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), null, KitchenXpathLocators.xpathlookup.get("TIMING"),
				KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));

		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsWorktopTest3() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("WORKTOPS"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"), null,
				KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsWorktopTest4() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("WORKTOPS"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), null, TestScriptUtilities.getRandomString(30));

		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsWorktopTest5() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("WORKTOPS"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[2]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsWorktopTest6() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("WORKTOPS"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(KitchenXpathLocators.xpathlookup.get("BUDGET"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsWorktopTest7() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("WORKTOPS"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(KitchenXpathLocators.xpathlookup.get("BUDGET"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, KitchenXpathLocators.xpathlookup.get("LASTNAME"),
				KitchenXpathLocators.xpathlookup.get("PHONE_NUMBER"), null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsWorktopTest8() throws Exception {

		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("WORKTOPS"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(KitchenXpathLocators.xpathlookup.get("BUDGET"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, KitchenXpathLocators.xpathlookup.get("FIRSTNAME"), null, null, null,
				KitchenXpathLocators.xpathlookup.get("EMAIL"), KitchenXpathLocators.xpathlookup.get("EMAIL"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsSomethingElseTest() throws Exception {
		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("ADDITIONAL_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("ADDITIONAL_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsSomethingElseTest1() throws Exception {
		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), null, KitchenXpathLocators.xpathlookup.get("TIMING"),
				KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));

		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsSomethingElseTest2() throws Exception {
		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("APPROPRIATE_STATUS_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("APPROPRIATE_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("ADDITIONAL_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaKitchenJobFormsSomethingElseTest3() throws Exception {
		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"), null,
				KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("TIMIMG_ERRORMSGTEXT"));

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaKitchenJobFormsSomethingElseTest4() throws Exception {
		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), null, TestScriptUtilities.getRandomString(30));

		assertEquals(context.driver.findElement(By.xpath(KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGXAPTH"))).getText(),
				KitchenXpathLocators.xpathlookup.get("POSTCODE_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsSomethingElseTest5() throws Exception {
		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='stage3']/div[1]/div[2]/label")).getText(), "Select an approximate budget");

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaKitchenJobFormsSomethingElseTest6() throws Exception {
		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(KitchenXpathLocators.xpathlookup.get("BUDGET"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaKitchenJobFormsSomethingElseTest7() throws Exception {
		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(KitchenXpathLocators.xpathlookup.get("BUDGET"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, KitchenXpathLocators.xpathlookup.get("LASTNAME"),
				KitchenXpathLocators.xpathlookup.get("PHONE_NUMBER"), null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaKitchenJobFormsSomethingElseTest8() throws Exception {
		underTest.fillInStage1(KitchenXpathLocators.xpathlookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(KitchenXpathLocators.xpathlookup.get("JOB_STATUS_ID"), KitchenXpathLocators.xpathlookup.get("OWNERSHIP_STATUS_ID"),
				KitchenXpathLocators.xpathlookup.get("TIMING"), KitchenXpathLocators.xpathlookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(KitchenXpathLocators.xpathlookup.get("BUDGET"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, KitchenXpathLocators.xpathlookup.get("FIRSTNAME"), null, null, null,
				KitchenXpathLocators.xpathlookup.get("EMAIL"), KitchenXpathLocators.xpathlookup.get("EMAIL"));

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");

	}
}
