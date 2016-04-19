package uk.co.ratedpeople.test.functional.selenium.newjobforms.tiling;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author ankitkumar.rana
 * 
 */
public class PostingJobViaTilingJobForms {
	
	public static Logger logger = Logger
			.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.tiling.PostingJobViaTilingJobForms");
	
	private static final String STAGE1_CONTINUE = "stage1SelectButton";
	private static final String STAGE2_CONTINUE_INSTALL = "nextDescInstall";
	private static final String STAGE2_CONTINUE_REPAIR = "nextDescRepair";
	private static final String STAGE2_CONTINUE_GROUT = "nextDescGrout";
	private static final String STAGE3_CONTINUE  = "next";
	private static final String STAGE4_CONTINUE  = ".//*[@id='stage3']/div[2]/div/button[1]";
			
	private static final String TIMING_SELECT_ELEMENT = "timing";
	private static final String POSTCODE_FIELD = "postcode";
	private static final String ADDITIONAL_INFO_TEXT_AREA_XPATH = ".//*[@id='additionalDetailsContainer']/textarea";
	private static final String BUDGET_SELECT_ELEMENT = "jobBudgetCode";
	private static final String PROPERTY_STYLE_SELECT_ELEMENT = "propertyType";
	
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;
	
	public PostingJobViaTilingJobForms(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
		this.driver = driver;
		this.testUrl = testUrl;
		this.scriptUtils = scriptUtils;
	}
	
	public void fillInStage1(String radioButtonId) {
		if(StringUtils.isNotBlank(radioButtonId)) {
			scriptUtils.click(By.id(radioButtonId));
		}	
		scriptUtils.click(By.id(STAGE1_CONTINUE));
	}
	
	public void fillInInstallNewTileStage2(String[] areaToInstall, String[] installXPathList, String installOtherXPath, String installOther, String removeExistingTile, String[] typesOfTilesXpath, 
			String typesOfTilesOtherXPath, String typesOfTilesOther, String isSupplyingMaterial) {
		
		if(areaToInstall != null){
			for(int i=0;i<areaToInstall.length;i++){
				scriptUtils.click(By.xpath(areaToInstall[i]));
			}
		}
		
		if(installXPathList != null){
			for(int i=0;i<installXPathList.length;i++){
				scriptUtils.click(By.xpath(installXPathList[i]));
			}
			
			if(StringUtils.isNotBlank(installOther) && StringUtils.isNotBlank(installOtherXPath)) {
				scriptUtils.fillInXpathField(installOtherXPath, installOther);
			}
		}
		
		if(StringUtils.isNotBlank(removeExistingTile)) {
			scriptUtils.click(By.id(removeExistingTile));
		}
		
		if(typesOfTilesXpath != null) {
			for(int i=0;i<typesOfTilesXpath.length;i++){
				scriptUtils.click(By.xpath(typesOfTilesXpath[i]));
			}
			
			if(StringUtils.isNotBlank(typesOfTilesOtherXPath) && StringUtils.isNotBlank(typesOfTilesOther)) {
				scriptUtils.fillInXpathField(typesOfTilesOtherXPath, typesOfTilesOther);
			}
		}
		
		if(StringUtils.isNotBlank(isSupplyingMaterial)) {
			scriptUtils.click(By.id(isSupplyingMaterial));
		}
		
		scriptUtils.click(By.id(STAGE2_CONTINUE_INSTALL));
	}
	
	public void fillInRepairStage2(String[] whatNeedsRepairXPathList, String whatNeedsRepairOtherXPath, String whatNeedsRepairOther, String isSupplyingMaterial) {
		
		if(whatNeedsRepairXPathList != null){
			for(int i=0;i<whatNeedsRepairXPathList.length;i++){
				scriptUtils.click(By.xpath(whatNeedsRepairXPathList[i]));
			}
			
			if(StringUtils.isNotBlank(whatNeedsRepairOtherXPath) && StringUtils.isNotBlank(whatNeedsRepairOther)) {
				scriptUtils.fillInXpathField(whatNeedsRepairOtherXPath, whatNeedsRepairOther);
			}
		}
		
		if(StringUtils.isNotBlank(isSupplyingMaterial)) {
			scriptUtils.click(By.id(isSupplyingMaterial));
		}

		scriptUtils.click(By.id(STAGE2_CONTINUE_REPAIR));
	}
	
	public void fillInGroutNewTileStage2(String[] areaToGrout, String[] groutXPathList, String groutOtherXPath, String groutOther, String removeExistingGrout) {
		
		if(areaToGrout != null){
			for(int i=0;i<areaToGrout.length;i++){
				scriptUtils.click(By.xpath(areaToGrout[i]));
			}
		}
		
		if(groutXPathList != null){
			for(int i=0;i<groutXPathList.length;i++){
				scriptUtils.click(By.xpath(groutXPathList[i]));
			}
			
			if(StringUtils.isNotBlank(groutOther) && StringUtils.isNotBlank(groutOtherXPath)) {
				scriptUtils.fillInXpathField(groutOtherXPath, groutOther);
			}
		}
		
		if(StringUtils.isNotBlank(removeExistingGrout)) {
			scriptUtils.click(By.id(removeExistingGrout));
		}
		
		scriptUtils.click(By.id(STAGE2_CONTINUE_GROUT));
	}
	
	public void fillInStage3(String jobStatusId, String ownershipStatusId, String jobTimingValue, String propertyStyle, String postcode, String additionalInfo) {
		if(StringUtils.isNotBlank(jobStatusId)) {
			scriptUtils.click(By.id(jobStatusId));
		}
		
		if(StringUtils.isNotBlank(ownershipStatusId)) {
			scriptUtils.click(By.id(ownershipStatusId));
		}
				
		if(StringUtils.isNotBlank(propertyStyle)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(PROPERTY_STYLE_SELECT_ELEMENT)));
			jobTypeSelect.selectByValue(propertyStyle);
		}
		
		if(StringUtils.isNotBlank(jobTimingValue)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(TIMING_SELECT_ELEMENT)));
			jobTypeSelect.selectByValue(jobTimingValue);
		}
		
		if(StringUtils.isNotBlank(postcode)) {
			scriptUtils.fillInTextField(POSTCODE_FIELD, postcode);
		}
		
		if(StringUtils.isNotBlank(additionalInfo)) {
			scriptUtils.fillInXpathField(ADDITIONAL_INFO_TEXT_AREA_XPATH, additionalInfo);
		}
		
		scriptUtils.click(By.id(STAGE3_CONTINUE));
	}
	
	public void fillInStage4(String budget) {
		if(StringUtils.isNotBlank(budget)) {
			Select budgetSelect = new Select(driver.findElement(By.id(BUDGET_SELECT_ELEMENT)));
			budgetSelect.selectByValue(budget);
		}
		
		scriptUtils.click(By.xpath(STAGE4_CONTINUE));
	}
	
	public void getQuotesTiling() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, "71", "tiler");
	}
}
