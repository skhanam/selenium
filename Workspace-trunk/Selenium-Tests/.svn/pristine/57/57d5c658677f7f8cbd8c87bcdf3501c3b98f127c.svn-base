package uk.co.ratedpeople.test.functional.selenium.newjobforms.tiling;

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
import uk.co.ratedpeople.test.functional.selenium.newjobforms.tiling.PostingJobViaTilingJobForms;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.tiling.TilingXpathLocators;

public class PostingJobViaTilingJobFormsNegativeTest extends TestScript {

	private PostingJobViaTilingJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaTilingJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotesTiling();
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest1() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		underTest.fillInInstallNewTileStage2(null, null, null, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("TILESTOBEINNSTALLED_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("TILESTOBEINNSTALLED_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("EXISTINGTILES_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("EXISTINGTILES_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("TYPEOFTILES_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("TYPEOFTILES_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("SUPPLYINGTILES_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("SUPPLYINGTILES_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest2() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, null, null, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("EXISTINGTILES_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("EXISTINGTILES_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("TYPEOFTILES_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("TYPEOFTILES_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("SUPPLYINGTILES_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("SUPPLYINGTILES_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest3() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };
		String[] INSTALL_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("BATH_SPLASH_XPATH"), TilingXpathLocators.xpathLookup.get("FLOOR_XPATH") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null,
				TilingXpathLocators.dataLookup.get("REMOVE_EXISTING_TILE_INSTALL"), null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("TYPEOFTILES_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("TYPEOFTILES_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("SUPPLYINGTILES_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("SUPPLYINGTILES_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest4() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };
		String[] INSTALL_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("BATH_SPLASH_XPATH"), TilingXpathLocators.xpathLookup.get("FLOOR_XPATH") };
		String[] TYPES_OF_TILES_XPATH_LIST_INSTALL = { TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_STONE") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null,
				TilingXpathLocators.dataLookup.get("REMOVE_EXISTING_TILE_INSTALL"), TYPES_OF_TILES_XPATH_LIST_INSTALL, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("SUPPLYINGTILES_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("SUPPLYINGTILES_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallOtherTest() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };
		String[] INSTALL_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("BATH_SPLASH_XPATH"), TilingXpathLocators.xpathLookup.get("INSTALL_OTHER_XPATH") };
		String[] TYPES_OF_TILES_XPATH_LIST_INSTALL = { TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_OTHER_INSTALL") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null,
				TilingXpathLocators.dataLookup.get("REMOVE_EXISTING_TILE_INSTALL"), TYPES_OF_TILES_XPATH_LIST_INSTALL, null, null,
				TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_INSTALL"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("TILESTOBEINNSTALLEDOTHER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("TILESTOBEINNSTALLEDOTHER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("TYPEOFTILESOTHER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("TYPEOFTILESOTHER_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest5() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };
		String[] INSTALL_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("BATH_SPLASH_XPATH"), TilingXpathLocators.xpathLookup.get("FLOOR_XPATH") };
		String[] TYPES_OF_TILES_XPATH_LIST_INSTALL = { TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_STONE") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null,
				TilingXpathLocators.dataLookup.get("REMOVE_EXISTING_TILE_INSTALL"), TYPES_OF_TILES_XPATH_LIST_INSTALL, null, null,
				TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_INSTALL"));
		underTest.fillInStage3(null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("APPROPRITESTATUS_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("APPROPRITESTATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("OWNERORAUTHORSIED_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("OWNERORAUTHORSIED_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("PROPERTYSTYLE_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("PROPERTYSTYLE_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("JOBTOSTART_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("JOBTOSTART_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("POSTCARD_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("POSTCARD_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("ADDITIONAL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest6() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };
		String[] INSTALL_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("BATH_SPLASH_XPATH"), TilingXpathLocators.xpathLookup.get("FLOOR_XPATH") };
		String[] TYPES_OF_TILES_XPATH_LIST_INSTALL = { TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_STONE") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null,
				TilingXpathLocators.dataLookup.get("REMOVE_EXISTING_TILE_INSTALL"), TYPES_OF_TILES_XPATH_LIST_INSTALL, null, null,
				TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_INSTALL"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("PROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("ADDITIONAL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("ADDITIONAL_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest7() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };
		String[] INSTALL_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("BATH_SPLASH_XPATH"), TilingXpathLocators.xpathLookup.get("FLOOR_XPATH") };
		String[] TYPES_OF_TILES_XPATH_LIST_INSTALL = { TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_STONE") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null,
				TilingXpathLocators.dataLookup.get("REMOVE_EXISTING_TILE_INSTALL"), TYPES_OF_TILES_XPATH_LIST_INSTALL, null, null,
				TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_INSTALL"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("PROPERTY_STYLE"), null,
				TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("POSTCARD_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("POSTCARD_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest8() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };
		String[] INSTALL_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("BATH_SPLASH_XPATH"), TilingXpathLocators.xpathLookup.get("FLOOR_XPATH") };
		String[] TYPES_OF_TILES_XPATH_LIST_INSTALL = { TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_STONE") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null,
				TilingXpathLocators.dataLookup.get("REMOVE_EXISTING_TILE_INSTALL"), TYPES_OF_TILES_XPATH_LIST_INSTALL, null, null,
				TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_INSTALL"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), null, TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("PROPERTYSTYLE_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("PROPERTYSTYLE_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest9() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };
		String[] INSTALL_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("BATH_SPLASH_XPATH"), TilingXpathLocators.xpathLookup.get("FLOOR_XPATH") };
		String[] TYPES_OF_TILES_XPATH_LIST_INSTALL = { TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_STONE") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null,
				TilingXpathLocators.dataLookup.get("REMOVE_EXISTING_TILE_INSTALL"), TYPES_OF_TILES_XPATH_LIST_INSTALL, null, null,
				TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_INSTALL"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"), null,
				TilingXpathLocators.dataLookup.get("PROPERTY_STYLE"), TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("JOBTOSTART_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("JOBTOSTART_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest10() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };
		String[] INSTALL_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("BATH_SPLASH_XPATH"), TilingXpathLocators.xpathLookup.get("FLOOR_XPATH") };
		String[] TYPES_OF_TILES_XPATH_LIST_INSTALL = { TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_STONE") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null,
				TilingXpathLocators.dataLookup.get("REMOVE_EXISTING_TILE_INSTALL"), TYPES_OF_TILES_XPATH_LIST_INSTALL, null, null,
				TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_INSTALL"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), null, TilingXpathLocators.dataLookup.get("TIMING"),
				TilingXpathLocators.dataLookup.get("PROPERTY_STYLE"), TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("OWNERORAUTHORSIED_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("OWNERORAUTHORSIED_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest11() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };
		String[] INSTALL_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("BATH_SPLASH_XPATH"), TilingXpathLocators.xpathLookup.get("FLOOR_XPATH") };
		String[] TYPES_OF_TILES_XPATH_LIST_INSTALL = { TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_STONE") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null,
				TilingXpathLocators.dataLookup.get("REMOVE_EXISTING_TILE_INSTALL"), TYPES_OF_TILES_XPATH_LIST_INSTALL, null, null,
				TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_INSTALL"));
		underTest.fillInStage3(null, TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"), TilingXpathLocators.dataLookup.get("TIMING"),
				TilingXpathLocators.dataLookup.get("PROPERTY_STYLE"), TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("APPROPRITESTATUS_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("APPROPRITESTATUS_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest12() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };
		String[] INSTALL_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("BATH_SPLASH_XPATH"), TilingXpathLocators.xpathLookup.get("FLOOR_XPATH") };
		String[] TYPES_OF_TILES_XPATH_LIST_INSTALL = { TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_STONE") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null,
				TilingXpathLocators.dataLookup.get("REMOVE_EXISTING_TILE_INSTALL"), TYPES_OF_TILES_XPATH_LIST_INSTALL, null, null,
				TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_INSTALL"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("PROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("BUDGET_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("BUDGET_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest13() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };
		String[] INSTALL_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("BATH_SPLASH_XPATH"), TilingXpathLocators.xpathLookup.get("FLOOR_XPATH") };
		String[] TYPES_OF_TILES_XPATH_LIST_INSTALL = { TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_STONE") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null,
				TilingXpathLocators.dataLookup.get("REMOVE_EXISTING_TILE_INSTALL"), TYPES_OF_TILES_XPATH_LIST_INSTALL, null, null,
				TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_INSTALL"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("PROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("FIRSTNAME_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("FIRSTNAME_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("LASTNAME_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("LASTNAME_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("PHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("PHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("EMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("EMAIL_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest14() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };
		String[] INSTALL_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("BATH_SPLASH_XPATH"), TilingXpathLocators.xpathLookup.get("FLOOR_XPATH") };
		String[] TYPES_OF_TILES_XPATH_LIST_INSTALL = { TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_STONE") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null,
				TilingXpathLocators.dataLookup.get("REMOVE_EXISTING_TILE_INSTALL"), TYPES_OF_TILES_XPATH_LIST_INSTALL, null, null,
				TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_INSTALL"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("PROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));
		String firstName = TilingXpathLocators.dataLookup.get("FIRSTNAME");
		String lastName = TilingXpathLocators.dataLookup.get("LASTNAME");
		String phoneNumber = TilingXpathLocators.dataLookup.get("PHONE_NUMBER");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("EMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("EMAIL_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest15() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };
		String[] INSTALL_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("BATH_SPLASH_XPATH"), TilingXpathLocators.xpathLookup.get("FLOOR_XPATH") };
		String[] TYPES_OF_TILES_XPATH_LIST_INSTALL = { TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_STONE") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null,
				TilingXpathLocators.dataLookup.get("REMOVE_EXISTING_TILE_INSTALL"), TYPES_OF_TILES_XPATH_LIST_INSTALL, null, null,
				TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_INSTALL"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("PROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		String firstName = TilingXpathLocators.dataLookup.get("FIRSTNAME");
		String lastName = TilingXpathLocators.dataLookup.get("LASTNAME");
		String email = TilingXpathLocators.dataLookup.get("EMAIL");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, email, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("PHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("PHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest16() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };
		String[] INSTALL_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("BATH_SPLASH_XPATH"), TilingXpathLocators.xpathLookup.get("FLOOR_XPATH") };
		String[] TYPES_OF_TILES_XPATH_LIST_INSTALL = { TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_STONE") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null,
				TilingXpathLocators.dataLookup.get("REMOVE_EXISTING_TILE_INSTALL"), TYPES_OF_TILES_XPATH_LIST_INSTALL, null, null,
				TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_INSTALL"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("PROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		String firstName = TilingXpathLocators.dataLookup.get("FIRSTNAME");
		String phoneNumber = TilingXpathLocators.dataLookup.get("PHONE_NUMBER");
		String email = TilingXpathLocators.dataLookup.get("EMAIL");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, phoneNumber, null, email, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("LASTNAME_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("LASTNAME_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsInstallNegativeTest() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("INSTALL"));

		String[] AREA_TO_INSTALL = { TilingXpathLocators.xpathLookup.get("INSTALL_AREA_SMALL"), TilingXpathLocators.xpathLookup.get("INSTALL_AREA_LARGE") };
		String[] INSTALL_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("BATH_SPLASH_XPATH"), TilingXpathLocators.xpathLookup.get("FLOOR_XPATH") };
		String[] TYPES_OF_TILES_XPATH_LIST_INSTALL = { TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("TYPES_OF_TILES_XPATH_STONE") };

		underTest.fillInInstallNewTileStage2(AREA_TO_INSTALL, INSTALL_XPATH_LIST, null, null,
				TilingXpathLocators.dataLookup.get("REMOVE_EXISTING_TILE_INSTALL"), TYPES_OF_TILES_XPATH_LIST_INSTALL, null, null,
				TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_INSTALL"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("PROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		String lastName = TilingXpathLocators.dataLookup.get("LASTNAME");
		String phoneNumber = TilingXpathLocators.dataLookup.get("PHONE_NUMBER");
		String email = TilingXpathLocators.dataLookup.get("EMAIL");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, lastName, phoneNumber, null, email, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("FIRSTNAME_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("FIRSTNAME_ERRORMSGTEXT"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTest1() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("REPAIR"));
		underTest.fillInRepairStage2(null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("NEEDSTOBEREPAIRED_ERRORMSGXPATH"))).getText(),
				TilingXpathLocators.dataLookup.get("NEEDSTOBEREPAIRED_ERRORMSGXPATHTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("SUPPLYINGTILES_ERRORMSGXAPTH"))).getText(),
				TilingXpathLocators.dataLookup.get("SUPPLYINGTILES_ERRORMSGXAPTHTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTes2t() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("REPAIR"));
		String[] WHAT_NEEDS_REPAIR_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("REPAIR_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("REPAIR_PORCELAIN") };

		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_XPATH_LIST, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("SUPPLYINGTILES_ERRORMSGXAPTH"))).getText(),
				TilingXpathLocators.dataLookup.get("SUPPLYINGTILES_ERRORMSGXAPTHTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTest3() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("REPAIR"));
		String[] WHAT_NEEDS_REPAIR_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("REPAIR_CERAMIC"), TilingXpathLocators.xpathLookup.get("REPAIR_OTHER") };

		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_REPAIR"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("REPAIROTHER_ERRORMSGXPATH"))).getText(),
				TilingXpathLocators.dataLookup.get("REPAIROTHER_ERRORMSGXPATHTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTest4() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("REPAIR"));
		String[] WHAT_NEEDS_REPAIR_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("REPAIR_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("REPAIR_PORCELAIN") };

		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_REPAIR"));
		underTest.fillInStage3(null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("APPROPRITESTATUS_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("APPROPRITESTATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("OWNERORAUTHORSIED_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("OWNERORAUTHORSIED_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("PROPERTYSTYLE_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("PROPERTYSTYLE_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("JOBTOSTART_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("JOBTOSTART_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("POSTCARD_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("POSTCARD_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("ADDITIONAL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTest5() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("REPAIR"));
		String[] WHAT_NEEDS_REPAIR_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("REPAIR_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("REPAIR_PORCELAIN") };

		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_REPAIR"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("REPAIRPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("ADDITIONAL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTest6() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("REPAIR"));
		String[] WHAT_NEEDS_REPAIR_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("REPAIR_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("REPAIR_PORCELAIN") };

		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_REPAIR"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("REPAIRPROPERTY_STYLE"), null,
				TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("POSTCARD_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("POSTCARD_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTest7() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("REPAIR"));
		String[] WHAT_NEEDS_REPAIR_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("REPAIR_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("REPAIR_PORCELAIN") };

		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_REPAIR"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), null, TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("PROPERTYSTYLE_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("PROPERTYSTYLE_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTest8() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("REPAIR"));
		String[] WHAT_NEEDS_REPAIR_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("REPAIR_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("REPAIR_PORCELAIN") };

		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_REPAIR"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"), null,
				TilingXpathLocators.dataLookup.get("REPAIRPROPERTY_STYLE"), TilingXpathLocators.dataLookup.get("POSTCODE"),
				TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("JOBTOSTART_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("JOBTOSTART_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTest9() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("REPAIR"));
		String[] WHAT_NEEDS_REPAIR_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("REPAIR_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("REPAIR_PORCELAIN") };

		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_REPAIR"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), null, TilingXpathLocators.dataLookup.get("TIMING"),
				TilingXpathLocators.dataLookup.get("REPAIRPROPERTY_STYLE"), TilingXpathLocators.dataLookup.get("POSTCODE"),
				TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("OWNERORAUTHORSIED_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("OWNERORAUTHORSIED_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTest10() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("REPAIR"));
		String[] WHAT_NEEDS_REPAIR_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("REPAIR_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("REPAIR_PORCELAIN") };

		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_REPAIR"));
		underTest.fillInStage3(null, TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"), TilingXpathLocators.dataLookup.get("TIMING"),
				TilingXpathLocators.dataLookup.get("REPAIRPROPERTY_STYLE"), TilingXpathLocators.dataLookup.get("POSTCODE"),
				TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("APPROPRITESTATUS_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("APPROPRITESTATUS_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTest12() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("REPAIR"));
		String[] WHAT_NEEDS_REPAIR_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("REPAIR_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("REPAIR_PORCELAIN") };

		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_REPAIR"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("REPAIRPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("BUDGET_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("BUDGET_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTest13() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("REPAIR"));
		String[] WHAT_NEEDS_REPAIR_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("REPAIR_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("REPAIR_PORCELAIN") };

		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_REPAIR"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("REPAIRPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("FIRSTNAME_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("FIRSTNAME_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("LASTNAME_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("LASTNAME_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("PHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("PHONENUMBER_ERRORMSGTEXT"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("EMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("EMAIL_ERRORMSGTEXT"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTest14() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("REPAIR"));
		String[] WHAT_NEEDS_REPAIR_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("REPAIR_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("REPAIR_PORCELAIN") };

		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_REPAIR"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("REPAIRPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		String firstName = TilingXpathLocators.dataLookup.get("FIRSTNAME");
		String lastName = TilingXpathLocators.dataLookup.get("LASTNAME");
		String phoneNumber = TilingXpathLocators.dataLookup.get("PHONE_NUMBER");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("EMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("EMAIL_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTest15() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("REPAIR"));
		String[] WHAT_NEEDS_REPAIR_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("REPAIR_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("REPAIR_PORCELAIN") };

		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_REPAIR"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("REPAIRPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		String firstName = TilingXpathLocators.dataLookup.get("FIRSTNAME");
		String lastName = TilingXpathLocators.dataLookup.get("LASTNAME");
		String email = TilingXpathLocators.dataLookup.get("EMAIL");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, email, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("PHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("PHONENUMBER_ERRORMSGTEXT"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTest16() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("REPAIR"));
		String[] WHAT_NEEDS_REPAIR_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("REPAIR_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("REPAIR_PORCELAIN") };

		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_REPAIR"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("REPAIRPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		String firstName = TilingXpathLocators.dataLookup.get("FIRSTNAME");
		String phoneNumber = TilingXpathLocators.dataLookup.get("PHONE_NUMBER");
		String email = TilingXpathLocators.dataLookup.get("EMAIL");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, phoneNumber, null, email, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("LASTNAME_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("LASTNAME_ERRORMSGTEXT"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsRepairTest() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("REPAIR"));
		String[] WHAT_NEEDS_REPAIR_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("REPAIR_CERAMIC"),
				TilingXpathLocators.xpathLookup.get("REPAIR_PORCELAIN") };
		underTest.fillInRepairStage2(WHAT_NEEDS_REPAIR_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_REPAIR"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("REPAIRPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		String lastName = TilingXpathLocators.dataLookup.get("LASTNAME");
		String phoneNumber = TilingXpathLocators.dataLookup.get("PHONE_NUMBER");
		String email = TilingXpathLocators.dataLookup.get("EMAIL");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, lastName, phoneNumber, null, email, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("FIRSTNAME_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("FIRSTNAME_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutTest1() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("GROUT"));

		underTest.fillInGroutNewTileStage2(null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("AREASNEEDTOBEGROUTED_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("AREASNEEDTOBEGROUTED_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("EXISTING_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("EXISTING_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutTest2() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("GROUT"));

		String[] AREA_TO_GROUT = { TilingXpathLocators.xpathLookup.get("GROUT_SMALLAREA"), TilingXpathLocators.xpathLookup.get("GROUT_WALLS") };
		String[] AREA_TO_GROUT_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("SMALLAREA_OTHER"), TilingXpathLocators.xpathLookup.get("GROUT_WALL") };

		underTest.fillInGroutNewTileStage2(AREA_TO_GROUT, AREA_TO_GROUT_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_GROUT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("SMALLAREA_OTHERERRORMSGXPATH"))).getText(),
				TilingXpathLocators.dataLookup.get("SMALLAREA_OTHERERRORMSGXPATHTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutTest3() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("GROUT"));

		String[] AREA_TO_GROUT = { TilingXpathLocators.xpathLookup.get("GROUT_SMALLAREA"), TilingXpathLocators.xpathLookup.get("GROUT_WALLS") };
		String[] AREA_TO_GROUT_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("GROUT_WASHBASIN"), TilingXpathLocators.xpathLookup.get("GROUT_WALL") };

		underTest.fillInGroutNewTileStage2(AREA_TO_GROUT, AREA_TO_GROUT_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_GROUT"));
		underTest.fillInStage3(null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("APPROPRITESTATUS_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("APPROPRITESTATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("OWNERORAUTHORSIED_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("OWNERORAUTHORSIED_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("PROPERTYSTYLE_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("PROPERTYSTYLE_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("JOBTOSTART_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("JOBTOSTART_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("POSTCARD_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("POSTCARD_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("ADDITIONAL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutTest4() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("GROUT"));

		String[] AREA_TO_GROUT = { TilingXpathLocators.xpathLookup.get("GROUT_SMALLAREA"), TilingXpathLocators.xpathLookup.get("GROUT_WALLS") };
		String[] AREA_TO_GROUT_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("GROUT_WASHBASIN"), TilingXpathLocators.xpathLookup.get("GROUT_WALL") };

		underTest.fillInGroutNewTileStage2(AREA_TO_GROUT, AREA_TO_GROUT_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_GROUT"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("GROUTPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("ADDITIONAL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("ADDITIONAL_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutTest5() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("GROUT"));

		String[] AREA_TO_GROUT = { TilingXpathLocators.xpathLookup.get("GROUT_SMALLAREA"), TilingXpathLocators.xpathLookup.get("GROUT_WALLS") };
		String[] AREA_TO_GROUT_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("GROUT_WASHBASIN"), TilingXpathLocators.xpathLookup.get("GROUT_WALL") };

		underTest.fillInGroutNewTileStage2(AREA_TO_GROUT, AREA_TO_GROUT_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_GROUT"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("GROUTPROPERTY_STYLE"), null,
				TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("POSTCARD_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("POSTCARD_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutTest6() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("GROUT"));

		String[] AREA_TO_GROUT = { TilingXpathLocators.xpathLookup.get("GROUT_SMALLAREA"), TilingXpathLocators.xpathLookup.get("GROUT_WALLS") };
		String[] AREA_TO_GROUT_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("GROUT_WASHBASIN"), TilingXpathLocators.xpathLookup.get("GROUT_WALL") };

		underTest.fillInGroutNewTileStage2(AREA_TO_GROUT, AREA_TO_GROUT_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_GROUT"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), null, TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("PROPERTYSTYLE_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("PROPERTYSTYLE_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutTest7() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("GROUT"));

		String[] AREA_TO_GROUT = { TilingXpathLocators.xpathLookup.get("GROUT_SMALLAREA"), TilingXpathLocators.xpathLookup.get("GROUT_WALLS") };
		String[] AREA_TO_GROUT_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("GROUT_WASHBASIN"), TilingXpathLocators.xpathLookup.get("GROUT_WALL") };

		underTest.fillInGroutNewTileStage2(AREA_TO_GROUT, AREA_TO_GROUT_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_GROUT"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"), null,
				TilingXpathLocators.dataLookup.get("GROUTPROPERTY_STYLE"), TilingXpathLocators.dataLookup.get("POSTCODE"),
				TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("JOBTOSTART_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("JOBTOSTART_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutTest8() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("GROUT"));

		String[] AREA_TO_GROUT = { TilingXpathLocators.xpathLookup.get("GROUT_SMALLAREA"), TilingXpathLocators.xpathLookup.get("GROUT_WALLS") };
		String[] AREA_TO_GROUT_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("GROUT_WASHBASIN"), TilingXpathLocators.xpathLookup.get("GROUT_WALL") };

		underTest.fillInGroutNewTileStage2(AREA_TO_GROUT, AREA_TO_GROUT_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_GROUT"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), null, TilingXpathLocators.dataLookup.get("TIMING"),
				TilingXpathLocators.dataLookup.get("GROUTPROPERTY_STYLE"), TilingXpathLocators.dataLookup.get("POSTCODE"),
				TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("OWNERORAUTHORSIED_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("OWNERORAUTHORSIED_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutTest9() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("GROUT"));

		String[] AREA_TO_GROUT = { TilingXpathLocators.xpathLookup.get("GROUT_SMALLAREA"), TilingXpathLocators.xpathLookup.get("GROUT_WALLS") };
		String[] AREA_TO_GROUT_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("GROUT_WASHBASIN"), TilingXpathLocators.xpathLookup.get("GROUT_WALL") };

		underTest.fillInGroutNewTileStage2(AREA_TO_GROUT, AREA_TO_GROUT_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_GROUT"));
		underTest.fillInStage3(null, TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"), TilingXpathLocators.dataLookup.get("TIMING"),
				TilingXpathLocators.dataLookup.get("GROUTPROPERTY_STYLE"), TilingXpathLocators.dataLookup.get("POSTCODE"),
				TestScriptUtilities.getRandomString(10));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("APPROPRITESTATUS_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("APPROPRITESTATUS_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutTest10() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("GROUT"));

		String[] AREA_TO_GROUT = { TilingXpathLocators.xpathLookup.get("GROUT_SMALLAREA"), TilingXpathLocators.xpathLookup.get("GROUT_WALLS") };
		String[] AREA_TO_GROUT_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("GROUT_WASHBASIN"), TilingXpathLocators.xpathLookup.get("GROUT_WALL") };

		underTest.fillInGroutNewTileStage2(AREA_TO_GROUT, AREA_TO_GROUT_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_GROUT"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("GROUTPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("BUDGET_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("BUDGET_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutTest11() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("GROUT"));

		String[] AREA_TO_GROUT = { TilingXpathLocators.xpathLookup.get("GROUT_SMALLAREA"), TilingXpathLocators.xpathLookup.get("GROUT_WALLS") };
		String[] AREA_TO_GROUT_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("GROUT_WASHBASIN"), TilingXpathLocators.xpathLookup.get("GROUT_WALL") };

		underTest.fillInGroutNewTileStage2(AREA_TO_GROUT, AREA_TO_GROUT_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_GROUT"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("GROUTPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("FIRSTNAME_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("FIRSTNAME_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("LASTNAME_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("LASTNAME_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("PHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("PHONENUMBER_ERRORMSGTEXT"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("EMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("EMAIL_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutTest12() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("GROUT"));

		String[] AREA_TO_GROUT = { TilingXpathLocators.xpathLookup.get("GROUT_SMALLAREA"), TilingXpathLocators.xpathLookup.get("GROUT_WALLS") };
		String[] AREA_TO_GROUT_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("GROUT_WASHBASIN"), TilingXpathLocators.xpathLookup.get("GROUT_WALL") };

		underTest.fillInGroutNewTileStage2(AREA_TO_GROUT, AREA_TO_GROUT_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_GROUT"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("GROUTPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		String firstName = TilingXpathLocators.dataLookup.get("FIRSTNAME");
		String lastName = TilingXpathLocators.dataLookup.get("LASTNAME");
		String phoneNumber = TilingXpathLocators.dataLookup.get("PHONE_NUMBER");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("EMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("EMAIL_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutTest13() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("GROUT"));

		String[] AREA_TO_GROUT = { TilingXpathLocators.xpathLookup.get("GROUT_SMALLAREA"), TilingXpathLocators.xpathLookup.get("GROUT_WALLS") };
		String[] AREA_TO_GROUT_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("GROUT_WASHBASIN"), TilingXpathLocators.xpathLookup.get("GROUT_WALL") };

		underTest.fillInGroutNewTileStage2(AREA_TO_GROUT, AREA_TO_GROUT_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_GROUT"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("GROUTPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		String firstName = TilingXpathLocators.dataLookup.get("FIRSTNAME");
		String lastName = TilingXpathLocators.dataLookup.get("LASTNAME");
		String email = TilingXpathLocators.dataLookup.get("EMAIL");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, email, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("PHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("PHONENUMBER_ERRORMSGTEXT"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutTest14() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("GROUT"));

		String[] AREA_TO_GROUT = { TilingXpathLocators.xpathLookup.get("GROUT_SMALLAREA"), TilingXpathLocators.xpathLookup.get("GROUT_WALLS") };
		String[] AREA_TO_GROUT_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("GROUT_WASHBASIN"), TilingXpathLocators.xpathLookup.get("GROUT_WALL") };

		underTest.fillInGroutNewTileStage2(AREA_TO_GROUT, AREA_TO_GROUT_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_GROUT"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("GROUTPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		String firstName = TilingXpathLocators.dataLookup.get("FIRSTNAME");
		String phoneNumber = TilingXpathLocators.dataLookup.get("PHONE_NUMBER");
		String email = TilingXpathLocators.dataLookup.get("EMAIL");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, phoneNumber, null, email, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("LASTNAME_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("LASTNAME_ERRORMSGTEXT"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsGroutTest() throws Exception {

		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("GROUT"));

		String[] AREA_TO_GROUT = { TilingXpathLocators.xpathLookup.get("GROUT_SMALLAREA"), TilingXpathLocators.xpathLookup.get("GROUT_WALLS") };
		String[] AREA_TO_GROUT_XPATH_LIST = { TilingXpathLocators.xpathLookup.get("GROUT_WASHBASIN"), TilingXpathLocators.xpathLookup.get("GROUT_WALL") };

		underTest.fillInGroutNewTileStage2(AREA_TO_GROUT, AREA_TO_GROUT_XPATH_LIST, null, null, TilingXpathLocators.dataLookup.get("SUPPLY_MATERIAL_GROUT"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("GROUTPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		String lastName = TilingXpathLocators.dataLookup.get("LASTNAME");
		String phoneNumber = TilingXpathLocators.dataLookup.get("PHONE_NUMBER");
		String email = TilingXpathLocators.dataLookup.get("EMAIL");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, lastName, phoneNumber, null, email, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("FIRSTNAME_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("FIRSTNAME_ERRORMSGTEXT"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsSomethingElseTest() throws Exception {
		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("APPROPRITESTATUS_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("APPROPRITESTATUS_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("OWNERORAUTHORSIED_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("OWNERORAUTHORSIED_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("PROPERTYSTYLE_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("PROPERTYSTYLE_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("JOBTOSTART_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("JOBTOSTART_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("POSTCARD_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("POSTCARD_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("ADDITIONAL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("ADDITIONAL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsSomethingElseTest1() throws Exception {
		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("SOMETHING_ELSE"));

		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("SOMETHINGPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("ADDITIONAL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("ADDITIONAL_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsSomethingElseTest2() throws Exception {
		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("SOMETHINGPROPERTY_STYLE"), null,
				TestScriptUtilities.getRandomString(30));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("POSTCARD_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("POSTCARD_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsSomethingElseTest3() throws Exception {
		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), null, TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("PROPERTYSTYLE_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("PROPERTYSTYLE_ERRORMSGTEXT"));

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaTilingJobFormsSomethingElseTest4() throws Exception {
		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"), null,
				TilingXpathLocators.dataLookup.get("SOMETHINGPROPERTY_STYLE"), TilingXpathLocators.dataLookup.get("POSTCODE"),
				TestScriptUtilities.getRandomString(30));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("JOBTOSTART_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("JOBTOSTART_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsSomethingElseTest5() throws Exception {
		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), null, TilingXpathLocators.dataLookup.get("TIMING"),
				TilingXpathLocators.dataLookup.get("SOMETHINGPROPERTY_STYLE"), TilingXpathLocators.dataLookup.get("POSTCODE"),
				TestScriptUtilities.getRandomString(30));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("OWNERORAUTHORSIED_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("OWNERORAUTHORSIED_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsSomethingElseTest6() throws Exception {
		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(null, TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"), TilingXpathLocators.dataLookup.get("TIMING"),
				TilingXpathLocators.dataLookup.get("SOMETHINGPROPERTY_STYLE"), TilingXpathLocators.dataLookup.get("POSTCODE"),
				TestScriptUtilities.getRandomString(30));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("APPROPRITESTATUS_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("APPROPRITESTATUS_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsSomethingElseTest7() throws Exception {
		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("SOMETHINGPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("BUDGET_ERRORMSG1"))).getText(),
				TilingXpathLocators.dataLookup.get("BUDGET_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsSomethingElseTest8() throws Exception {
		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("SOMETHINGPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("FIRSTNAME_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("FIRSTNAME_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("LASTNAME_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("LASTNAME_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("PHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("PHONENUMBER_ERRORMSGTEXT"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("EMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("EMAIL_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaTilingJobFormsSomethingElseTest9() throws Exception {
		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("SOMETHINGPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		String firstName = TilingXpathLocators.dataLookup.get("FIRSTNAME");
		String lastName = TilingXpathLocators.dataLookup.get("LASTNAME");
		String phoneNumber = TilingXpathLocators.dataLookup.get("PHONE_NUMBER");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, phoneNumber, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("EMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("EMAIL_ERRORMSGTEXT"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsSomethingElseTest10() throws Exception {
		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("SOMETHINGPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		String firstName = TilingXpathLocators.dataLookup.get("FIRSTNAME");
		String lastName = TilingXpathLocators.dataLookup.get("LASTNAME");
		String email = TilingXpathLocators.dataLookup.get("EMAIL");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, lastName, null, null, email, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("PHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("PHONENUMBER_ERRORMSGTEXT"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaTilingJobFormsSomethingElseTest11() throws Exception {
		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("SOMETHINGPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		String firstName = TilingXpathLocators.dataLookup.get("FIRSTNAME");
		String phoneNumber = TilingXpathLocators.dataLookup.get("PHONE_NUMBER");
		String email = TilingXpathLocators.dataLookup.get("EMAIL");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, firstName, null, phoneNumber, null, email, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("LASTNAME_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("LASTNAME_ERRORMSGTEXT"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaTilingJobFormsSomethingElseTest12() throws Exception {
		underTest.fillInStage1(TilingXpathLocators.dataLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(TilingXpathLocators.dataLookup.get("JOB_STATUS_ID"), TilingXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				TilingXpathLocators.dataLookup.get("TIMING"), TilingXpathLocators.dataLookup.get("SOMETHINGPROPERTY_STYLE"),
				TilingXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(TilingXpathLocators.dataLookup.get("BUDGET"));

		String lastName = TilingXpathLocators.dataLookup.get("LASTNAME");
		String phoneNumber = TilingXpathLocators.dataLookup.get("PHONE_NUMBER");
		String email = TilingXpathLocators.dataLookup.get("EMAIL");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, lastName, phoneNumber, null, email, null);

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("FIRSTNAME_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("FIRSTNAME_ERRORMSGTEXT"));

		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(TilingXpathLocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				TilingXpathLocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));
	}
}
