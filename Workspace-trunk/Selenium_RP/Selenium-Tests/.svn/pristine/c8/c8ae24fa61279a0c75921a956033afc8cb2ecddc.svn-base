package uk.co.ratedpeople.test.functional.selenium.newjobforms.kitchen;

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
public class PostingJobViaKitchenJobForms {
	
	public static Logger logger = Logger
			.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.tiling.PostingJobViaTilingJobForms");
	
	private static final String STAGE1_CONTINUE = "stage1SelectButton";
	private static final String STAGE2_CONTINUE_INSTALL = "nextDescInstall";
	private static final String STAGE2_CONTINUE_REFURBISH = "nextDescRefurbish";
	private static final String STAGE3_CONTINUE  = "next";
	private static final String STAGE4_CONTINUE  = ".//*[@id='stage3']/div[2]/div/button[1]";
	
	private static final String INSTALL_KITCHEN_SIZE = ".//*[@id='installKitchenSize']";
	private static final String REFURBISH_KITCHEN_SIZE = ".//*[@id='refurbishKitchenSize']";
	
	private static final String TYPE_TO_INSTALL_OTHER_FIELD = ".//*[@id='installOtherText']";
	private static final String WORKTOP_TYPE_OTHER_FIELD = ".//*[@id='installWorktopsOtherText']";
	private static final String ADDITIONAL_INSTALL_OTHER_FIELD = ".//*[@id='installPartsOtherText']";
	private static final String PART_TO_REFURSH_OTHER_FIELD = ".//*[@id='refurbishOtherText']";
	
	private static final String TIMING_SELECT_ELEMENT = "timing";
	private static final String POSTCODE_FIELD = "postcode";
	private static final String ADDITIONAL_INFO_TEXT_AREA_XPATH = ".//*[@id='additionalDetailsContainer']/textarea";
	private static final String BUDGET_SELECT_ELEMENT = "jobBudgetCode";
		
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;
	
	public PostingJobViaKitchenJobForms(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
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
	
	public void fillInInstallNewKitchenStage2(String[] partToInstall, String partOther, String worktopType, String worktopTypeOther, String[] additionalInstall, String additionalInstallOther, 
			String kitchenSize, String isSupplyingMaterial, String removeOldKitchen) {
		
		if(partToInstall != null){
			for(int i=0;i<partToInstall.length;i++){
				scriptUtils.click(By.xpath(partToInstall[i]));
			}
			
			if(StringUtils.isNotBlank(partOther)) {
				scriptUtils.fillInXpathField(TYPE_TO_INSTALL_OTHER_FIELD, partOther);
			}
		}
		
		if(StringUtils.isNotBlank(worktopType)) {
			scriptUtils.click(By.id(worktopType));
			
			if(StringUtils.isNotBlank(worktopTypeOther)) {
				scriptUtils.fillInXpathField(WORKTOP_TYPE_OTHER_FIELD, worktopTypeOther);
			}
		}
		
		if(additionalInstall != null){
			for(int i=0;i<additionalInstall.length;i++){
				scriptUtils.click(By.xpath(additionalInstall[i]));
			}
			
			if(StringUtils.isNotBlank(additionalInstallOther)) {
				scriptUtils.fillInXpathField(ADDITIONAL_INSTALL_OTHER_FIELD, additionalInstallOther);
			}
		}
		
		if(StringUtils.isNotBlank(kitchenSize)) {
			Select jobTypeSelect = new Select(driver.findElement(By.xpath(INSTALL_KITCHEN_SIZE)));
			jobTypeSelect.selectByValue(kitchenSize);
		}
		
		if(StringUtils.isNotBlank(isSupplyingMaterial)) {
			scriptUtils.click(By.id(isSupplyingMaterial));
		}
		
		if(StringUtils.isNotBlank(removeOldKitchen)) {
			scriptUtils.click(By.id(removeOldKitchen));
		}
		
		scriptUtils.click(By.id(STAGE2_CONTINUE_INSTALL));
	}
	
	public void fillInRefurbishKitchenStage2(String[] partToRefurbish, String refurbishOther, String kitchenSize) {
		
		if(partToRefurbish != null){
			for(int i=0;i<partToRefurbish.length;i++){
				scriptUtils.click(By.xpath(partToRefurbish[i]));
			}
			
			if(StringUtils.isNotBlank(refurbishOther)) {
				scriptUtils.fillInXpathField(PART_TO_REFURSH_OTHER_FIELD, refurbishOther);
			}
		}

		if(StringUtils.isNotBlank(kitchenSize)) {
			Select jobTypeSelect = new Select(driver.findElement(By.xpath(REFURBISH_KITCHEN_SIZE)));
			jobTypeSelect.selectByValue(kitchenSize);
		}
		
		scriptUtils.click(By.id(STAGE2_CONTINUE_REFURBISH));
	}
	
	public void fillInStage3(String jobStatusId, String ownershipStatusId, String jobTimingValue, String postcode, String additionalInfo) {
		if(StringUtils.isNotBlank(jobStatusId)) {
			scriptUtils.click(By.id(jobStatusId));
		}
		
		if(StringUtils.isNotBlank(ownershipStatusId)) {
			scriptUtils.click(By.id(ownershipStatusId));
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
	
	
	
	public void getQuotesKitchen() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, "43", "kitchen");
	}

}
