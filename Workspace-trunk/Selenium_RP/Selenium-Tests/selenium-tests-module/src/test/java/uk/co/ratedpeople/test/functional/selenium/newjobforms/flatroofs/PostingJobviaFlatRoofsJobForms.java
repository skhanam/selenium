/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.flatroofs;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author olivier.renard
 * 
 */
public class PostingJobviaFlatRoofsJobForms {

	private static final String POSTCODE_FIELD = "postcode";
	private static final String FLAT_ROOFS_SKILL_TYPE_ID = "98";
	private static final String FLAT_ROOFS_TRADE_CODE = "roofer";
	private static final String BUDGET_SELECT_ELEMENT = "jobBudgetCode";
	private static final String PROPERTY_TYPE_SELECT_ELEMENT = "propertyType";
	private static final String PROPERTY_STYLE_SELECT_ELEMENT = "propertyStyle";
	private static final String TIMING_SELECT_ELEMENT = "timing";
	private static final String NEXT_DESC_REPLACE = "nextDescReplace";
	private static final String NEXT_DESC_REPAIR = "nextDescRepair";
	private static final String NEXT = "next";
	private static final String STAGE1_CONTINUE_XPATH = ".//*[@id='stage1SelectButton']";
	private static final String ADDITIONAL_INFO_TEXT_AREA_XPATH = ".//*[@id='additionalDetailsContainer']/textarea";

	public static Logger logger = Logger.getLogger(PostingJobviaFlatRoofsJobForms.class.getName());
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;

	public PostingJobviaFlatRoofsJobForms(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
		this.driver = driver;
		this.testUrl = testUrl ;
		this.scriptUtils = scriptUtils;
	}

	public void getQuotes() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, FLAT_ROOFS_SKILL_TYPE_ID, FLAT_ROOFS_TRADE_CODE);
	}

	public void fillInPage1ForJobDetailsForReplaceFlatRoofs(String serviceRequired, String[] roofSectionsToReplace, String highestRoofSection,
			String selectedRoofSection) throws Exception {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));

		if(roofSectionsToReplace != null){
		
		for (int i = 0; i < roofSectionsToReplace.length; i++) {
			scriptUtils.click(By.id(roofSectionsToReplace[i]));
		}
		}
		
		
		if(highestRoofSection != null){

		if (StringUtils.isNotBlank(highestRoofSection)) {
			
			if(selectedRoofSection != null){			
			if (StringUtils.isNotBlank(selectedRoofSection)) {
				Select timingSelect = new Select(driver.findElement(By.id(highestRoofSection)));
				timingSelect.selectByValue(selectedRoofSection);
			}
			}
		}
		}

		scriptUtils.click(By.id(NEXT_DESC_REPLACE));
	}

	public void fillInPage1ForJobDetailsForRepairFlatRoofs(String serviceRequired, String[] whatNeedsToBeRepaired, String [] whereRepairsNeeded, String highestRoofSection,
			String selectedRoofSection) {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));

		if(whatNeedsToBeRepaired != null){
		for (int i = 0; i < whatNeedsToBeRepaired.length; i++) {
			scriptUtils.click(By.id(whatNeedsToBeRepaired[i]));
		}
		}

		if(whereRepairsNeeded != null){
		
		for (int i = 0; i < whereRepairsNeeded.length; i++) {
			scriptUtils.click(By.id(whereRepairsNeeded[i]));
		}
		}

		if(highestRoofSection != null){
		
		if (StringUtils.isNotBlank(highestRoofSection)) {
			if (StringUtils.isNotBlank(selectedRoofSection)) {
				Select timingSelect = new Select(driver.findElement(By.id(highestRoofSection)));
				timingSelect.selectByValue(selectedRoofSection);
			}
		}
		}

		scriptUtils.click(By.id(NEXT_DESC_REPAIR));
	}

	public void fillInPage1ForJobDetailsForFindAndRepairLeak(String serviceRequired) throws Exception {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));
	}

	public void fillInPage1ForJobDetailsForSomethingElse(String serviceRequired) throws Exception {

		if (StringUtils.isNotBlank(serviceRequired)) {
			scriptUtils.select(By.id(serviceRequired));
		}

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(STAGE1_CONTINUE_XPATH)));
		scriptUtils.click(By.xpath(STAGE1_CONTINUE_XPATH));
	}

	public void fillInPage2ForAdditionalInfo(String propertyType, String propertyStyle, String propertyBedrooms, int numberOfBedrooms, String jobStatus,
			String ownershipStatus, String timing, String postcode, int descriptionLength, String additionalDetails) {

		if (StringUtils.isNotBlank(propertyType)) {
			Select propertyTypeSelect = new Select(driver.findElement(By.id(PROPERTY_TYPE_SELECT_ELEMENT)));
			propertyTypeSelect.selectByValue(propertyType);
		}
		if (StringUtils.isNotBlank(propertyStyle)) {
			Select propertyStyleSelect = new Select(driver.findElement(By.id(PROPERTY_STYLE_SELECT_ELEMENT)));
			propertyStyleSelect.selectByValue(propertyStyle);
		}
		if (StringUtils.isNotBlank(propertyBedrooms)) {
			for (int i = 0; i < numberOfBedrooms; i++) {
				scriptUtils.click(By.xpath(".//*[@id='" + propertyBedrooms + "']/following-sibling::a"));
			}
			}
	
		if (StringUtils.isNotBlank(jobStatus)) {
			scriptUtils.click(By.id(jobStatus));
			}
		if (StringUtils.isNotBlank(ownershipStatus)) {
			scriptUtils.click(By.id(ownershipStatus));
		}
		if (StringUtils.isNotBlank(timing)) {
			Select timingSelect = new Select(driver.findElement(By.id(TIMING_SELECT_ELEMENT)));
			timingSelect.selectByValue(timing);
		}
		if (StringUtils.isNotBlank(postcode)) {
			scriptUtils.clear(By.id(POSTCODE_FIELD));
			scriptUtils.fillInTextField(POSTCODE_FIELD, postcode);
		}		
		if (StringUtils.isNotBlank(additionalDetails)) {
			scriptUtils.fillInXpathField(ADDITIONAL_INFO_TEXT_AREA_XPATH, additionalDetails);
		}
	
		scriptUtils.click(By.id(NEXT));
	}

	public void fillInPage3ForBudget(final String selectedBudget) throws Exception {
		if (StringUtils.isNotBlank(selectedBudget)) {
			Select budgetSelect = new Select(driver.findElement(By.id(BUDGET_SELECT_ELEMENT)));
			budgetSelect.selectByValue(selectedBudget);
		}

		scriptUtils.click(By.id(NEXT));
	}


}
