package uk.co.ratedpeople.test.functional.selenium.newjobforms.flooring;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

/**
 * @author ankitkumar.rana
 * 
 */

public class PostingJobViaFlooringJobFormsTest extends TestScript {

	private static final String CARPETS = "radioCarpets";
	private static final String LAMINATE_FLOORING = "radioLaminate";
	private static final String WOOD_FLOORING = "radioEngineeredWood";
	private static final String SOLID_TIMBER = "radioSolidWood";
	private static final String LINO_VINYL = "radioLinoVinyl";
	private static final String SOMETHING_ELSE = "radioElse";

	private static final String STAGE2_CONTINUE_LAMINATED_FLOORING = "nextDescLaminate";
	private static final String STAGE2_CONTINUE_WOOD_FLOORING = "nextDescEngineeredWood";
	private static final String STAGE2_CONTINUE_TIMBER = "nextDescSolidTimber";
	private static final String STAGE2_CONTINUE_VINYL = "nextDescLinoVinyl";

	private static final String CARPET_FIT = "carpetFitNew";
	private static final String LAMINATE_INSTALL = "laminateInstall";
	private static final String WOOD_INSTALL = "engineeredWoodInstall";
	private static final String SOLID_TIMBER_INSTALL = "solidWoodInstall";
	private static final String LINO_VINYL_INSTALL = "linoVinylInstall";

	private static final String JOB_STATUS_ID = "statusREADY_TO_HIRE";
	private static final String OWNERSHIP_STATUS_ID = "ownerLANDLORD";
	private static final String TIMING = "URGENTLY";
	private static final String POSTCODE = "SW1E6AU";
	private static final String BUDGET = "30_LT_100";

	private static final String EMAIL_ADDRESS = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
	private static final String FIRST_NAME = TestScriptUtilities.getRandomAlphabeticString(3);
	private static final String LAST_NAME = TestScriptUtilities.getRandomAlphabeticString(3);
	private static final String PHONE_NUMBER = "01234567890";

	private static final String THANK_YOU_HEADER_TEXT_ID = "header-h1";
	private static final String THANK_YOU = "Thank you";
	private static final String OTHER_TEXT = "This is other text";
	
	private static final String ErewardIMAGE_XPATH  = ".//*[@id='skill-specifc-portable-jobform']/a/img";	
	private static final String SRC_CONTAINS  ="2/post-your-job/bundles/rpglobalassets/img/research-now-banner.jpg";
	private static final String WELCOMETOEREWARDS_XPATH  =".//*[@id='Standard']/table/tbody/tr/td/span/strong";
	private static final String WELCOMETOEREWARDS_TEXT  ="Welcome to e-Rewards®!";

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
	public void postingJobViaFlooringJobFormsCarpetFitTest() throws Exception {

		underTest.fillInStage1(CARPETS);

		String[] roomsCarpetXPathList = { ".//*[@id='descCarpets']/div[2]/div[1]/div[1]/ul/li[3]/a[2]" };
		String[] typesOfCarpetXpath = { ".//*[@id='carpetTypeGeneral']" };
		String isSupplyingMaterial = "carpetSupplyYes";

		underTest.fillInCarpetsStage2(CARPET_FIT, roomsCarpetXPathList, null, null, typesOfCarpetXpath, null, null, isSupplyingMaterial);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1185", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		

	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsCarpetOtherTest() throws Exception {

		underTest.fillInStage1(CARPETS);

		String[] roomsCarpetXPathList = { ".//*[@id='descCarpets']/div[2]/div[1]/div[1]/ul/li[3]/a[2]",
				".//*[@id='descCarpets']/div[2]/div[1]/div[2]/ul/li[5]/a[2]" };
		String roomsCarpetOtherXpath = ".//*[@id='descCarpets']/div[2]/div[1]/div[2]/ul/li[5]/div/textarea";
		String[] typesOfCarpetXpath = { ".//*[@id='carpetTypeGeneral']", ".//*[@id='carpetTypeOther']" };
		String typesOfCarpetOtherXpath = ".//*[@id='carpetTypeOtherText']";
		String isSupplyingMaterial = "carpetSupplyYes";

		underTest.fillInCarpetsStage2(CARPET_FIT, roomsCarpetXPathList, roomsCarpetOtherXpath, OTHER_TEXT, typesOfCarpetXpath, typesOfCarpetOtherXpath,
				OTHER_TEXT, isSupplyingMaterial);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1185", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringTest() throws Exception {
		underTest.fillInStage1(LAMINATE_FLOORING);

		String[] roomsCarpetXPathList = { ".//*[@id='descLaminate']/div[2]/div[1]/div[1]/ul/li[1]/a[2]" };
		String isSupplyingMaterial = "laminateSupplyYes";

		underTest.fillInGenericStage2(LAMINATE_INSTALL, roomsCarpetXPathList, null, null, isSupplyingMaterial, STAGE2_CONTINUE_LAMINATED_FLOORING);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1204", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
	
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLaminateFlooringOtherTest() throws Exception {
		underTest.fillInStage1(LAMINATE_FLOORING);

		String[] roomsLaminateFlooringXPathList = { ".//*[@id='descLaminate']/div[2]/div[1]/div[1]/ul/li[1]/a[2]",
				".//*[@id='descLaminate']/div[2]/div[1]/div[2]/ul/li[5]/a[2]" };
		String roomLaminateFlooringOtherXPath = ".//*[@id='descLaminate']/div[2]/div[1]/div[2]/ul/li[5]/div/textarea";
		String isSupplyingMaterial = "laminateSupplyYes";

		underTest.fillInGenericStage2(LAMINATE_INSTALL, roomsLaminateFlooringXPathList, roomLaminateFlooringOtherXPath, OTHER_TEXT, isSupplyingMaterial,
				STAGE2_CONTINUE_LAMINATED_FLOORING);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1204", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
	
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringTest() throws Exception {
		underTest.fillInStage1(WOOD_FLOORING);

		String[] roomsWoodFlooringXPathList = { ".//*[@id='descEngineeredWood']/div[2]/div[1]/div[1]/ul/li[4]/a[2]" };
		String isSupplyingMaterial = "engineeredWoodSupplyNo";

		underTest.fillInGenericStage2(WOOD_INSTALL, roomsWoodFlooringXPathList, null, null, isSupplyingMaterial, STAGE2_CONTINUE_WOOD_FLOORING);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1224", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
	
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsWoodFlooringOtherTest() throws Exception {
		underTest.fillInStage1(WOOD_FLOORING);

		String[] roomsWoodFlooringXPathList = { ".//*[@id='descEngineeredWood']/div[2]/div[1]/div[1]/ul/li[4]/a[2]",
				".//*[@id='descEngineeredWood']/div[2]/div[1]/div[2]/ul/li[5]/a[2]" };
		String roomWoodFlooringOtherXPath = ".//*[@id='descEngineeredWood']/div[2]/div[1]/div[2]/ul/li[5]/div/textarea";
		String isSupplyingMaterial = "engineeredWoodSupplyNo";

		underTest.fillInGenericStage2(WOOD_INSTALL, roomsWoodFlooringXPathList, roomWoodFlooringOtherXPath, OTHER_TEXT, isSupplyingMaterial,
				STAGE2_CONTINUE_WOOD_FLOORING);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1224", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberTest() throws Exception {
		underTest.fillInStage1(SOLID_TIMBER);

		String[] roomsSolidTimberXPathList = { ".//*[@id='descSolidWood']/div[2]/div[1]/div[1]/ul/li[4]/a[2]" };
		String isSupplyingMaterial = "solidWoodSupplyYes";

		underTest.fillInGenericStage2(SOLID_TIMBER_INSTALL, roomsSolidTimberXPathList, null, null, isSupplyingMaterial, STAGE2_CONTINUE_TIMBER);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1245", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
	
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsSolidTimberOtherTest() throws Exception {
		underTest.fillInStage1(SOLID_TIMBER);

		String[] roomsSolidTimberXPathList = { ".//*[@id='descSolidWood']/div[2]/div[1]/div[1]/ul/li[4]/a[2]",
				".//*[@id='descSolidWood']/div[2]/div[1]/div[2]/ul/li[5]/a[2]" };
		String roomSolidTimberOtherXPath = ".//*[@id='descSolidWood']/div[2]/div[1]/div[2]/ul/li[5]/div/textarea";
		String isSupplyingMaterial = "solidWoodSupplyYes";

		underTest.fillInGenericStage2(SOLID_TIMBER_INSTALL, roomsSolidTimberXPathList, roomSolidTimberOtherXPath, OTHER_TEXT, isSupplyingMaterial,
				STAGE2_CONTINUE_TIMBER);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1245", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylTest() throws Exception {
		underTest.fillInStage1(LINO_VINYL);

		String[] roomsLinoVinylXPathList = { ".//*[@id='descLinoVinyl']/div[2]/div[1]/div[1]/ul/li[3]/a[2]" };
		String isSupplyingMaterial = "linoVinylSupplyNo";

		underTest.fillInGenericStage2(LINO_VINYL_INSTALL, roomsLinoVinylXPathList, null, null, isSupplyingMaterial, STAGE2_CONTINUE_VINYL);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1265", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "regression" }, enabled = true)
	public void postingJobViaFlooringJobFormsLinoVinylOtherTest() throws Exception {
		underTest.fillInStage1(LINO_VINYL);

		String[] roomsSLinoVinylXPathList = { ".//*[@id='descLinoVinyl']/div[2]/div[1]/div[1]/ul/li[3]/a[2]",
				".//*[@id='descLinoVinyl']/div[2]/div[1]/div[2]/ul/li[5]/a[2]" };
		String roomLinoVinylOtherXPath = ".//*[@id='descLinoVinyl']/div[2]/div[1]/div[2]/ul/li[5]/div/textarea";
		String isSupplyingMaterial = "linoVinylSupplyNo";

		underTest.fillInGenericStage2(LINO_VINYL_INSTALL, roomsSLinoVinylXPathList, roomLinoVinylOtherXPath, OTHER_TEXT, isSupplyingMaterial,
				STAGE2_CONTINUE_VINYL);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1265", POSTCODE, TestScriptUtilities.getRandomString(10));

		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();
		
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postingJobViaFlooringJobFormsSomethingElseTest() throws Exception {
		underTest.fillInStage1(SOMETHING_ELSE);
		underTest.fillInStage3(JOB_STATUS_ID, OWNERSHIP_STATUS_ID, TIMING, "1271", POSTCODE, TestScriptUtilities.getRandomString(30));

		fillInStage4();
		fillInStage5();

		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
		ThankYouPage();		
	}

	public void fillInStage4() {
		underTest.fillInStage4(BUDGET);
	}

	public void fillInStage5() {
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PHONE_NUMBER, EMAIL_ADDRESS,
				EMAIL_ADDRESS);

	}
	
    public void ThankYouPage() throws InterruptedException {
		
		assertEquals(context.driver.findElement(By.xpath(FlooringXpathLocators.xpathLookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(), FlooringXpathLocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(FlooringXpathLocators.xpathLookup.get("WHATHAPPENSNEXTONE_XPATH"))).getText(), FlooringXpathLocators.dataLookup.get("WHATHAPPENSNEXTONE_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(FlooringXpathLocators.xpathLookup.get("WHATHAPPENSNEXTTWO_XPATH"))).getText(), FlooringXpathLocators.dataLookup.get("WHATHAPPENSNEXTTWO_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(FlooringXpathLocators.xpathLookup.get("WHATHAPPENSNEXTTHREE_XPATH"))).getText(), FlooringXpathLocators.dataLookup.get("WHATHAPPENSNEXTTHREE_TEXT"));
	
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
