/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.slatetiledroofs;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

/**
 * @author shabana.khanam
 * 
 */
public class PostingJobViaSlateTiledRoofJobForms {
	public static Logger logger = Logger
			.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.slatetiledroofs.PostingJobViaSlateTiledRoofJobForms");
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;

	public void getQuotes() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, "101", "roofer");
	}

	public PostingJobViaSlateTiledRoofJobForms(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
		this.driver = driver;
		this.testUrl = testUrl;
		this.scriptUtils = scriptUtils;
	}

	public void postingJobViaSlateTiledRoofFirstCriticalScenario() throws Exception {
		jobDetailsPage("radioReplace");
		replacePathFirstPage(SlateTiledRoofsXpathlocators.dataLookup.get("roofSection"), SlateTiledRoofsXpathlocators.dataLookup.get("highestRoof"));
		replacePathSecondPage(SlateTiledRoofsXpathlocators.dataLookup.get("propertytype"), SlateTiledRoofsXpathlocators.dataLookup.get("propertystyle"),
				SlateTiledRoofsXpathlocators.dataLookup.get("repairownership"), SlateTiledRoofsXpathlocators.dataLookup.get("repairintent"), 3,
				SlateTiledRoofsXpathlocators.dataLookup.get("timing"), SlateTiledRoofsXpathlocators.dataLookup.get("description"),
				SlateTiledRoofsXpathlocators.dataLookup.get("postcode"));
		thirdPage(SlateTiledRoofsXpathlocators.dataLookup.get("BUDGET"));
		
		String Email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";		
		fourthPage(SlateTiledRoofsXpathlocators.dataLookup.get("fname"),
				SlateTiledRoofsXpathlocators.dataLookup.get("lname"),
				SlateTiledRoofsXpathlocators.dataLookup.get("mobile"), SlateTiledRoofsXpathlocators.dataLookup.get("confirmphonenumber"), Email, Email);
		driver.findElement(
				By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("CLICK_NEXT"))).click();
		if (JobFormSeleniumHelper.isLightboxEnabled()) {
			WebDriverWait wait = new WebDriverWait(driver, 90);	
			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("ALMOSTDONE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("ALMOSTDONE_TEXT"));
			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTONE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTONE_TEXT"));
			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTTWO_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTTWO_TEXT"));
			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTTHREE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTTHREE_TEXT"));
			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTFOUR_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTFOUR_TEXT"));
			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTFIVE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTFIVE_TEXT"));
			
//			assertEquals(driver.findElement(By.linkText("Homeowner User Agreement")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("HOMEOWNERUSERAGREEMENT_TEXT"));
//			assertEquals(driver.findElement(By.linkText("'Use of Service'")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("USERSERVICES_TEXT"));
//			assertEquals(driver.findElement(By.linkText("'Limitation of Liability'")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("LIMITATIONOFLIABILITY_TEXT"));
//			assertEquals(driver.findElement(By.linkText("Privacy Policy")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("PRIVACY_TEXT"));	
			
//			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("HOMEOWNERUSERAGREEMENT_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("HOMEOWNERUSERAGREEMENT_TEXT"));
//			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("USERSERVICES_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("USERSERVICES_TEXT"));
//			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("INDEMNITY_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("INDEMNITY_TEXT"));
//			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("LIMITATIONOFLIABILITY_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("LIMITATIONOFLIABILITY_TEXT"));
//			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("PRIVACY_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("PRIVACY_TEXT"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnConfirmJob")));
			scriptUtils.click(By.id("btnConfirmJob"));	
		}
	}

	public void postingJobViaSlateTiledRoofSecondCriticalScenario() throws Exception {

		jobDetailsPage("radioRepair");
		repairPathFirstPage(SlateTiledRoofsXpathlocators.dataLookup.get("whichroofrepair"), SlateTiledRoofsXpathlocators.dataLookup.get("whereroofrepair"),
				SlateTiledRoofsXpathlocators.dataLookup.get("highestRoof"));
		repairSecondPage(SlateTiledRoofsXpathlocators.dataLookup.get("propertytype"), SlateTiledRoofsXpathlocators.dataLookup.get("propertystyle"),
				SlateTiledRoofsXpathlocators.dataLookup.get("repairownership"), SlateTiledRoofsXpathlocators.dataLookup.get("repairintent"),
				SlateTiledRoofsXpathlocators.dataLookup.get("timing"), SlateTiledRoofsXpathlocators.dataLookup.get("postcode"),
				SlateTiledRoofsXpathlocators.dataLookup.get("description"));
		thirdPage(SlateTiledRoofsXpathlocators.dataLookup.get("BUDGET"));
        String Email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";		
		fourthPage(SlateTiledRoofsXpathlocators.dataLookup.get("fname"),
				SlateTiledRoofsXpathlocators.dataLookup.get("lname"),
				SlateTiledRoofsXpathlocators.dataLookup.get("mobile"), SlateTiledRoofsXpathlocators.dataLookup.get("confirmphonenumber"), Email, Email);
		driver.findElement(
				By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("CLICK_NEXT"))).click();
		
		if (JobFormSeleniumHelper.isLightboxEnabled()) {
		WebDriverWait wait = new WebDriverWait(driver, 90);	
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("ALMOSTDONE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("ALMOSTDONE_TEXT"));
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTONE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTONE_TEXT"));
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTTWO_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTTWO_TEXT"));
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTTHREE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTTHREE_TEXT"));
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTFOUR_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTFOUR_TEXT"));
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTFIVE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTFIVE_TEXT"));
		
//		assertEquals(driver.findElement(By.linkText("Homeowner User Agreement")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("HOMEOWNERUSERAGREEMENT_TEXT"));
//		assertEquals(driver.findElement(By.linkText("'Use of Service'")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("USERSERVICES_TEXT"));
//		assertEquals(driver.findElement(By.linkText("'Limitation of Liability'")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("LIMITATIONOFLIABILITY_TEXT"));
//		assertEquals(driver.findElement(By.linkText("Privacy Policy")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("PRIVACY_TEXT"));	
		
//		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("HOMEOWNERUSERAGREEMENT_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("HOMEOWNERUSERAGREEMENT_TEXT"));
//		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("USERSERVICES_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("USERSERVICES_TEXT"));
//		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("INDEMNITY_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("INDEMNITY_TEXT"));
//		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("LIMITATIONOFLIABILITY_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("LIMITATIONOFLIABILITY_TEXT"));
//		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("PRIVACY_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("PRIVACY_TEXT"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnConfirmJob")));
		scriptUtils.click(By.id("btnConfirmJob"));	

		}
		
	}

	public void postingJobViaSlateTiledRoofThirdCriticalScenario() throws Exception {

		jobDetailsPage("radioRepairLeak");

		repairSecondPage(SlateTiledRoofsXpathlocators.dataLookup.get("propertytype"), SlateTiledRoofsXpathlocators.dataLookup.get("propertystyle"),
				SlateTiledRoofsXpathlocators.dataLookup.get("repairownership"), SlateTiledRoofsXpathlocators.dataLookup.get("repairintent"),
				SlateTiledRoofsXpathlocators.dataLookup.get("timing"), SlateTiledRoofsXpathlocators.dataLookup.get("postcode"),
				SlateTiledRoofsXpathlocators.dataLookup.get("description"));

		thirdPage(SlateTiledRoofsXpathlocators.dataLookup.get("BUDGET"));

		String Email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";		
		fourthPage(SlateTiledRoofsXpathlocators.dataLookup.get("fname"),
				SlateTiledRoofsXpathlocators.dataLookup.get("lname"),
				SlateTiledRoofsXpathlocators.dataLookup.get("mobile"), SlateTiledRoofsXpathlocators.dataLookup.get("confirmphonenumber"), Email, Email);
		driver.findElement(
				By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("CLICK_NEXT"))).click();
		if (JobFormSeleniumHelper.isLightboxEnabled()) {
			WebDriverWait wait = new WebDriverWait(driver, 90);	
			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("ALMOSTDONE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("ALMOSTDONE_TEXT"));
			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTONE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTONE_TEXT"));
			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTTWO_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTTWO_TEXT"));
			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTTHREE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTTHREE_TEXT"));
			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTFOUR_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTFOUR_TEXT"));
			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTFIVE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTFIVE_TEXT"));
			
//			assertEquals(driver.findElement(By.linkText("Homeowner User Agreement")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("HOMEOWNERUSERAGREEMENT_TEXT"));
//			assertEquals(driver.findElement(By.linkText("'Use of Service'")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("USERSERVICES_TEXT"));
//			assertEquals(driver.findElement(By.linkText("'Limitation of Liability'")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("LIMITATIONOFLIABILITY_TEXT"));
//			assertEquals(driver.findElement(By.linkText("Privacy Policy")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("PRIVACY_TEXT"));	
			
//			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("HOMEOWNERUSERAGREEMENT_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("HOMEOWNERUSERAGREEMENT_TEXT"));
//			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("USERSERVICES_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("USERSERVICES_TEXT"));
//			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("INDEMNITY_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("INDEMNITY_TEXT"));
//			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("LIMITATIONOFLIABILITY_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("LIMITATIONOFLIABILITY_TEXT"));
//			assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("PRIVACY_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("PRIVACY_TEXT"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnConfirmJob")));
			scriptUtils.click(By.id("btnConfirmJob"));	

	}
	}

	public void postingJobViaSlateTiledRoofFourthCriticalScenario() throws Exception {

		jobDetailsPage("radioElse");

		repairSecondPage(SlateTiledRoofsXpathlocators.dataLookup.get("propertytype"), SlateTiledRoofsXpathlocators.dataLookup.get("propertystyle"),
				SlateTiledRoofsXpathlocators.dataLookup.get("repairownership"), SlateTiledRoofsXpathlocators.dataLookup.get("repairintent"),
				SlateTiledRoofsXpathlocators.dataLookup.get("timing"), SlateTiledRoofsXpathlocators.dataLookup.get("postcode"),
				SlateTiledRoofsXpathlocators.dataLookup.get("description"));

		thirdPage(SlateTiledRoofsXpathlocators.dataLookup.get("BUDGET"));
		String Email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";		
		fourthPage(SlateTiledRoofsXpathlocators.dataLookup.get("fname"),
				SlateTiledRoofsXpathlocators.dataLookup.get("lname"),
				SlateTiledRoofsXpathlocators.dataLookup.get("mobile"), SlateTiledRoofsXpathlocators.dataLookup.get("confirmphonenumber"), Email, Email);
		driver.findElement(
				By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("CLICK_NEXT"))).click();
		if (JobFormSeleniumHelper.isLightboxEnabled()) {
		WebDriverWait wait = new WebDriverWait(driver, 90);	
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("ALMOSTDONE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("ALMOSTDONE_TEXT"));
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTONE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTONE_TEXT"));
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTTWO_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTTWO_TEXT"));
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTTHREE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTTHREE_TEXT"));
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTFOUR_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTFOUR_TEXT"));
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTFIVE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTFIVE_TEXT"));
		
//		assertEquals(driver.findElement(By.linkText("Homeowner User Agreement")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("HOMEOWNERUSERAGREEMENT_TEXT"));
//		assertEquals(driver.findElement(By.linkText("'Use of Service'")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("USERSERVICES_TEXT"));
//		assertEquals(driver.findElement(By.linkText("'Limitation of Liability'")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("LIMITATIONOFLIABILITY_TEXT"));
//		assertEquals(driver.findElement(By.linkText("Privacy Policy")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("PRIVACY_TEXT"));		
		
//		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("HOMEOWNERUSERAGREEMENT_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("HOMEOWNERUSERAGREEMENT_TEXT"));
//		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("USERSERVICES_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("USERSERVICES_TEXT"));
//		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("LIMITATIONOFLIABILITY_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("LIMITATIONOFLIABILITY_TEXT"));
//		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("PRIVACY_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("PRIVACY_TEXT"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnConfirmJob")));
		scriptUtils.click(By.id("btnConfirmJob"));	

		}
	}
	
	public void postingJobViaSlateTiledRoofFourthCriticalScenarioEditJob() throws Exception {

		jobDetailsPage("radioElse");

		repairSecondPage(SlateTiledRoofsXpathlocators.dataLookup.get("propertytype"), SlateTiledRoofsXpathlocators.dataLookup.get("propertystyle"),
				SlateTiledRoofsXpathlocators.dataLookup.get("repairownership"), SlateTiledRoofsXpathlocators.dataLookup.get("repairintent"),
				SlateTiledRoofsXpathlocators.dataLookup.get("timing"), SlateTiledRoofsXpathlocators.dataLookup.get("postcode"),
				SlateTiledRoofsXpathlocators.dataLookup.get("description"));

		thirdPage(SlateTiledRoofsXpathlocators.dataLookup.get("BUDGET"));
		String Email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";		
		fourthPage(SlateTiledRoofsXpathlocators.dataLookup.get("fname"),
				SlateTiledRoofsXpathlocators.dataLookup.get("lname"),
				SlateTiledRoofsXpathlocators.dataLookup.get("mobile"), SlateTiledRoofsXpathlocators.dataLookup.get("confirmphonenumber"), Email, Email);
		driver.findElement(
				By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("CLICK_NEXT"))).click();
		if (JobFormSeleniumHelper.isLightboxEnabled()) {
		WebDriverWait wait = new WebDriverWait(driver, 90);	
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("ALMOSTDONE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("ALMOSTDONE_TEXT"));
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTONE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTONE_TEXT"));
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTTWO_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTTWO_TEXT"));
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTTHREE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTTHREE_TEXT"));
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTFOUR_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTFOUR_TEXT"));
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTFIVE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTFIVE_TEXT"));
		
//		assertEquals(driver.findElement(By.linkText("Homeowner User Agreement")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("HOMEOWNERUSERAGREEMENT_TEXT"));
//		assertEquals(driver.findElement(By.linkText("'Use of Service'")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("USERSERVICES_TEXT"));
//		assertEquals(driver.findElement(By.linkText("'Limitation of Liability'")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("LIMITATIONOFLIABILITY_TEXT"));
//		assertEquals(driver.findElement(By.linkText("Privacy Policy")).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("PRIVACY_TEXT"));	
		
//		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("HOMEOWNERUSERAGREEMENT_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("HOMEOWNERUSERAGREEMENT_TEXT"));
//		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("USERSERVICES_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("USERSERVICES_TEXT"));
//		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("INDEMNITY_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("INDEMNITY_TEXT"));
//		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("LIMITATIONOFLIABILITY_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("LIMITATIONOFLIABILITY_TEXT"));
//		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("PRIVACY_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("PRIVACY_TEXT"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("editJob"))).click();
				
		fourthPage(SlateTiledRoofsXpathlocators.dataLookup.get("fname"),
				SlateTiledRoofsXpathlocators.dataLookup.get("lname"),
				SlateTiledRoofsXpathlocators.dataLookup.get("mobile"), SlateTiledRoofsXpathlocators.dataLookup.get("confirmphonenumber"), Email, Email);
		driver.findElement(
				By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("CLICK_NEXT"))).click();
		
			

		}
	}
	
	public void postingJobViaSlateTiledRoofFourthCriticalScenarioCancelAndReturnHome() throws Exception {

		jobDetailsPage("radioElse");

		repairSecondPage(SlateTiledRoofsXpathlocators.dataLookup.get("propertytype"), SlateTiledRoofsXpathlocators.dataLookup.get("propertystyle"),
				SlateTiledRoofsXpathlocators.dataLookup.get("repairownership"), SlateTiledRoofsXpathlocators.dataLookup.get("repairintent"),
				SlateTiledRoofsXpathlocators.dataLookup.get("timing"), SlateTiledRoofsXpathlocators.dataLookup.get("postcode"),
				SlateTiledRoofsXpathlocators.dataLookup.get("description"));

		thirdPage(SlateTiledRoofsXpathlocators.dataLookup.get("BUDGET"));
		String Email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";		
		fourthPage(SlateTiledRoofsXpathlocators.dataLookup.get("fname"),
				SlateTiledRoofsXpathlocators.dataLookup.get("lname"),
				SlateTiledRoofsXpathlocators.dataLookup.get("mobile"), SlateTiledRoofsXpathlocators.dataLookup.get("confirmphonenumber"), Email, Email);
		driver.findElement(
				By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("CLICK_NEXT"))).click();
		if (JobFormSeleniumHelper.isLightboxEnabled()) {

		WebDriverWait wait = new WebDriverWait(driver, 90);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("CANCELANDRETURNHOME")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("HOMEPAGEHEADER_XPATH"))));
		assertEquals(driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("HOMEPAGEHEADER_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("HOMEPAGEHEADER_TEXT"));

		}
	}


	public void jobDetailsPage(String pathone) throws Exception {
		scriptUtils.click(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get(pathone)));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("continuestage1")));
	}

	public void replacePathFirstPage(String roofSection, String highestRoof) throws Exception {
		if (StringUtils.isNotBlank(roofSection)) {
			scriptUtils.checkAndSelectRadioByOption(SlateTiledRoofsXpathlocators.xpathLookup.get("roofreplaced"), roofSection);
		}
		if (StringUtils.isNotBlank(highestRoof)) {
			scriptUtils.checkAndSelectDropDownByOption(SlateTiledRoofsXpathlocators.xpathLookup.get("replaceSectionRoof"), highestRoof);
		}

		scriptUtils.click(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("stageonereplacenext")));
	}

	public void repairPathFirstPage(String whichroofrepair, String whereroofRepair, String repairSection) throws Exception {
		if (StringUtils.isNotBlank(whichroofrepair)) {
			scriptUtils.checkAndSelectRadioByOption(SlateTiledRoofsXpathlocators.xpathLookup.get("whichroofrepair"), whichroofrepair);
		}
		if (StringUtils.isNotBlank(whereroofRepair)) {
			scriptUtils.checkAndSelectRadioByOption(SlateTiledRoofsXpathlocators.xpathLookup.get("whereroofrepair"), whereroofRepair);
		}
		if (StringUtils.isNotBlank(repairSection)) {
			scriptUtils.checkAndSelectDropDownByOption(SlateTiledRoofsXpathlocators.xpathLookup.get("repairSectionRoof"), repairSection);
		}
		scriptUtils.click(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("stageonerepairnext")));
	}

	public void repairSecondPage(String propertytype, String propertystyle, String repairownership, String repairintent, String timing, String postcode,
			String description) throws Exception {
		if (StringUtils.isNotBlank(propertytype)) {
			scriptUtils.checkAndSelectDropDownByOption(SlateTiledRoofsXpathlocators.xpathLookup.get("propertytype"), propertytype);
		}
		if (StringUtils.isNotBlank(propertystyle)) {
			scriptUtils.checkAndSelectDropDownByOption(SlateTiledRoofsXpathlocators.xpathLookup.get("propertystyle"), propertystyle);
		}
		if (StringUtils.isNotBlank(repairownership)) {
			scriptUtils.checkAndSelectRadioByOption(SlateTiledRoofsXpathlocators.xpathLookup.get("repairownership"), repairownership);
		}
		if (StringUtils.isNotBlank(repairintent)) {
			scriptUtils.checkAndSelectRadioByOption(SlateTiledRoofsXpathlocators.xpathLookup.get("repairintent"), repairintent);
		}
		if (StringUtils.isNotBlank(timing)) {
			scriptUtils.checkAndSelectDropDownByOption(SlateTiledRoofsXpathlocators.xpathLookup.get("timing"), timing);
		}
		if (StringUtils.isNotBlank(postcode)) {
			scriptUtils.fillInTextField("postcode", postcode);
		}
		if (StringUtils.isNotBlank(description)) {
			scriptUtils.fillInXpathField(SlateTiledRoofsXpathlocators.xpathLookup.get("textareaadditionalinfo"), description);
		}

		scriptUtils.click(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("repairstagetwonext")));

	}

	public void replacePathSecondPage(String propertyType, String propertyStyle, String ownership, String status, int rooms, String timing, String description,
			String postcode) throws Exception {
		if (StringUtils.isNotBlank(propertyType)) {
			scriptUtils.checkAndSelectDropDownByOption(SlateTiledRoofsXpathlocators.xpathLookup.get("propertytype"), propertyType);
		}
		if (StringUtils.isNotBlank(propertyStyle)) {
			scriptUtils.checkAndSelectDropDownByOption(SlateTiledRoofsXpathlocators.xpathLookup.get("propertystyle"), propertyStyle);
		}
		if (StringUtils.isNotBlank(ownership)) {
			scriptUtils.checkAndSelectRadioByOption(SlateTiledRoofsXpathlocators.xpathLookup.get("replaceownership"), ownership);
		}
		if (StringUtils.isNotBlank(status)) {
			scriptUtils.checkAndSelectRadioByOption(SlateTiledRoofsXpathlocators.xpathLookup.get("replaceintent"), status);
		}
		// if(StringUtils.isNotBlank(rooms)) {
		scriptUtils.clickPlusIcon(SlateTiledRoofsXpathlocators.xpathLookup.get("numberbedroompositive"), rooms);
		// }
		if (StringUtils.isNotBlank(timing)) {
			scriptUtils.checkAndSelectDropDownByOption(SlateTiledRoofsXpathlocators.xpathLookup.get("timing"), timing);
		}
		if (StringUtils.isNotBlank(description)) {
			scriptUtils.fillInXpathField(SlateTiledRoofsXpathlocators.xpathLookup.get("textareaadditionalinfo"), description);
		}
		if (StringUtils.isNotBlank(postcode)) {
			scriptUtils.fillInTextField("postcode", postcode);
		}

		scriptUtils.click(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("replacestagetwonext")));

	}

	public void thirdPage(String budget) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("budget"))));
		if (StringUtils.isNotBlank(budget)) {
			scriptUtils.checkAndSelectDropDownByOption(SlateTiledRoofsXpathlocators.xpathLookup.get("budget"), budget);
		}
		scriptUtils.click(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("stagethreenext")));
	}

	public void budget(int budget) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("budget"))));

		scriptUtils.selectDropdown(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("budget")), TestScriptUtilities.getRandomNumber(budget));
		scriptUtils.click(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("stagethreenext")));

	}

	public void budgetOther() {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("budget"))));
		scriptUtils.selectDropdown(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("budget")), 10);
		String convrtrandNumber = Integer.toString(TestScriptUtilities.getRandomNumberGreaterThanfifty(100000));
		logger.info("Here is the converted integer  : " + convrtrandNumber);
		scriptUtils.fillInXpathField(SlateTiledRoofsXpathlocators.xpathLookup.get("otherbudget"), convrtrandNumber);
		scriptUtils.click(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("stagethreenext")));

	}

	public void fourthPage(String fname, String lname, String mobile, String confirmphonenumber, String email, String confirmemail) throws Exception {
		
		driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("fname"))).clear();
		driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("lname"))).clear();
		driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("mobile"))).clear();
		driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("confirmphonenumber"))).clear();
		driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("email"))).clear();
		driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("confirmemail"))).clear();

		scriptUtils.fillInXpathField(SlateTiledRoofsXpathlocators.xpathLookup.get("fname"), fname);
		scriptUtils.fillInXpathField(SlateTiledRoofsXpathlocators.xpathLookup.get("lname"), lname);
		scriptUtils.fillInXpathField(SlateTiledRoofsXpathlocators.xpathLookup.get("mobile"), mobile);
		scriptUtils.fillInXpathField(SlateTiledRoofsXpathlocators.xpathLookup.get("confirmphonenumber"), confirmphonenumber);
		scriptUtils.fillInXpathField(SlateTiledRoofsXpathlocators.xpathLookup.get("email"), email);
		scriptUtils.fillInXpathField(SlateTiledRoofsXpathlocators.xpathLookup.get("confirmemail"), confirmemail);

	}
	


}
