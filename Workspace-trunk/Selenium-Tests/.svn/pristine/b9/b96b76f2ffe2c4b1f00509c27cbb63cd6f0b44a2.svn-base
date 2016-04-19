package uk.co.ratedpeople.test.functional.selenium.newjobforms.newbuilds;

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
public class PostingJobViaNewBuildJobForms {
	
	public static Logger logger = Logger
			.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.newbuilds.PostingJobViaNewBuildJobForms");
	
	private static final String STAGE1_CONTINUE = "stage1SelectButton";
	private static final String STAGE2_CONTINUE_EXTENSION = "nextDescExtension";
	private static final String STAGE2_CONTINUE_LOFT_CONVERSION = "nextDescLoftConversion";
	private static final String STAGE2_CONTINUE_GARAGE_CONVERSION = "nextDescGarageConversion";
	private static final String STAGE3_CONTINUE  = "next";
	private static final String STAGE4_CONTINUE  = ".//*[@id='stage3']/div[2]/div/button[1]";
	
	private static final String EXTENSION_NUMBER_OF_ROOM_SELECT = "extensionRooms";
	private static final String EXTENSION_USE_OF_EXTENSION_OTHER = "extensionRoomsOtherText";
	private static final String EXTENSION_NUMBER_OF_FLOOR_SELECT = "extensionFloors";
	private static final String EXTENSION_ARCHITECTURAL_PLAN_SELECT = "extensionArchitectural";
	private static final String EXTENSION_PLANNING_PERSMISSION_SELECT = "extensionPlanningPermission";
	private static final String EXTENSION_BUILDING_REGULATION_SELECT = "extensionBuildingRegulations";
	
	private static final String LOFT_CONVERSION_ROOM_TO_BE_IN_LOFT_CONVERSION = ".//*[@id='descLoftConversion']/div[2]/div[2]/ul/li[3]/div/textarea";
	private static final String LOFT_ARCHITECTURAL_PLAN_SELECT = "loftConversionArchitectural";
	private static final String LOFT_PLANNING_PERSMISSION_SELECT = "loftConversionPlanningPermission";
	private static final String LOFT_BUILDING_REGULATION_SELECT = "loftConversionBuildingRegulations";
	
	private static final String GARAGE_CONVERSION_GARAGE_TO_BE_CONVERTED = ".//*[@id='descGarageConversion']/div[1]/div[2]/ul/li[3]/div/textarea";
	private static final String GARAGE_CONVERSION_ARCHITECTURAL_PLAN_SELECT = "garageConversionArchitectural";
	private static final String GARAGE_CONVERSION_PLANNING_PERSMISSION_SELECT = "garageConversionPlanningPermission";
	private static final String GARAGE_CONVERSION_BUILDING_REGULATION_SELECT = "garageConversionBuildingRegulation";
		
	private static final String TYPE_OF_LOFT_CONVERSION_OTHER = "radioLoftConversionOtherText";
	
	private static final String TIMING_SELECT_ELEMENT = "timing";
	private static final String POSTCODE_FIELD = "postcode";
	private static final String ADDITIONAL_INFO_TEXT_AREA_XPATH = ".//*[@id='additionalDetailsContainer']/textarea";
	private static final String BUDGET_SELECT_ELEMENT = ".//*[@id='jobBudgetCode']";
	private static final String PROPERTY_STYLE_SELECT_ELEMENT = "propertyStyle";
	
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;
	
	public PostingJobViaNewBuildJobForms(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
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
	
	public void fillInExtensionStage2(String numberOfRoom, String[] useOfExtenstionXPathList, String useOfExtenstionOther, String numberOfFloor, String architectural, String permissionStatus, String buildingRegulationStatus, String isBuildingListedXPath) {
		if(StringUtils.isNotBlank(numberOfRoom)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(EXTENSION_NUMBER_OF_ROOM_SELECT)));
			jobTypeSelect.selectByValue(numberOfRoom);
		}
		
		if(useOfExtenstionXPathList != null){
			for(int i=0;i<useOfExtenstionXPathList.length;i++){
				scriptUtils.click(By.xpath(useOfExtenstionXPathList[i]));
			}
			
			if(StringUtils.isNotBlank(useOfExtenstionOther)) {
				scriptUtils.fillInTextField(EXTENSION_USE_OF_EXTENSION_OTHER, useOfExtenstionOther);
			}
		}
		
		if(StringUtils.isNotBlank(numberOfFloor)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(EXTENSION_NUMBER_OF_FLOOR_SELECT)));
			jobTypeSelect.selectByValue(numberOfFloor);
		}
		
		if(StringUtils.isNotBlank(numberOfFloor)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(EXTENSION_NUMBER_OF_FLOOR_SELECT)));
			jobTypeSelect.selectByValue(numberOfFloor);
		}
		
		if(StringUtils.isNotBlank(architectural)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(EXTENSION_ARCHITECTURAL_PLAN_SELECT)));
			jobTypeSelect.selectByValue(architectural);
		}
		
		if(StringUtils.isNotBlank(permissionStatus)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(EXTENSION_PLANNING_PERSMISSION_SELECT)));
			jobTypeSelect.selectByValue(permissionStatus);
		}
		
		if(StringUtils.isNotBlank(buildingRegulationStatus)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(EXTENSION_BUILDING_REGULATION_SELECT)));
			jobTypeSelect.selectByValue(buildingRegulationStatus);
		}
		
		if(StringUtils.isNotBlank(isBuildingListedXPath)) {
			scriptUtils.click(By.xpath(isBuildingListedXPath));
		}
		
		scriptUtils.click(By.id(STAGE2_CONTINUE_EXTENSION));
	}
	
	public void fillInLoftConversionStage2(String typeOfConversion, String typeOfConversionOther, String[] roomInLoftConversionXPathList, String roomInLoftConversionOther, String architectural, String permissionStatus, String buildingRegulationStatus, String isBuildingListedXPath) {
		if(StringUtils.isNotBlank(typeOfConversion)) {
			scriptUtils.click(By.id(typeOfConversion));

			if(StringUtils.isNotBlank(typeOfConversionOther)) {
				scriptUtils.fillInTextField(TYPE_OF_LOFT_CONVERSION_OTHER, typeOfConversionOther);
			}
		}
		
		if(roomInLoftConversionXPathList != null){
			for(int i=0;i<roomInLoftConversionXPathList.length;i++){
				scriptUtils.click(By.xpath(roomInLoftConversionXPathList[i]));
			}
			
			if(StringUtils.isNotBlank(roomInLoftConversionOther)) {
				scriptUtils.fillInXpathField(LOFT_CONVERSION_ROOM_TO_BE_IN_LOFT_CONVERSION, roomInLoftConversionOther);
			}
		}
		
		if(StringUtils.isNotBlank(architectural)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(LOFT_ARCHITECTURAL_PLAN_SELECT)));
			jobTypeSelect.selectByValue(architectural);
		}
		
		if(StringUtils.isNotBlank(permissionStatus)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(LOFT_PLANNING_PERSMISSION_SELECT)));
			jobTypeSelect.selectByValue(permissionStatus);
		}
		
		if(StringUtils.isNotBlank(buildingRegulationStatus)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(LOFT_BUILDING_REGULATION_SELECT)));
			jobTypeSelect.selectByValue(buildingRegulationStatus);
		}
		
		if(StringUtils.isNotBlank(isBuildingListedXPath)) {
			scriptUtils.click(By.xpath(isBuildingListedXPath));
		}

		scriptUtils.click(By.id(STAGE2_CONTINUE_LOFT_CONVERSION));
	}

	public void fillInGarageConversionStage2(String[] roomsToBeConvertedXPathList, String roomsToBeConvertedOther, String architectural, String permissionStatus, String buildingRegulationStatus) {
		
		if(roomsToBeConvertedXPathList != null){
			for(int i=0;i<roomsToBeConvertedXPathList.length;i++){
				scriptUtils.click(By.xpath(roomsToBeConvertedXPathList[i]));
			}
			
			if(StringUtils.isNotBlank(roomsToBeConvertedOther)) {
				scriptUtils.fillInXpathField(GARAGE_CONVERSION_GARAGE_TO_BE_CONVERTED, roomsToBeConvertedOther);
			}
		}
		
		if(StringUtils.isNotBlank(architectural)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(GARAGE_CONVERSION_ARCHITECTURAL_PLAN_SELECT)));
			jobTypeSelect.selectByValue(architectural);
		}
		
		if(StringUtils.isNotBlank(permissionStatus)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(GARAGE_CONVERSION_PLANNING_PERSMISSION_SELECT)));
			jobTypeSelect.selectByValue(permissionStatus);
		}
		
		if(StringUtils.isNotBlank(buildingRegulationStatus)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(GARAGE_CONVERSION_BUILDING_REGULATION_SELECT)));
			jobTypeSelect.selectByValue(buildingRegulationStatus);
		}
		scriptUtils.click(By.id(STAGE2_CONTINUE_GARAGE_CONVERSION));
	}

	public void fillInPlanningAndBuilding(String architecturalId, String architectural, String permissionStatusId, String permissionStatus, String buildingRegulationStatusId, String buildingRegulationStatus) {
		if(StringUtils.isNotBlank(architectural)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(architecturalId)));
			jobTypeSelect.selectByValue(architectural);
		}
		
		if(StringUtils.isNotBlank(permissionStatus)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(permissionStatusId)));
			jobTypeSelect.selectByValue(permissionStatus);
		}
		
		if(StringUtils.isNotBlank(buildingRegulationStatus)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(buildingRegulationStatusId)));
			jobTypeSelect.selectByValue(buildingRegulationStatus);
		}

	}
	
	public void fillInStage3(String jobStatusId, String ownershipStatusId, String jobTimingValue, String propertyStyle, String postcode, String additionalInfo) {
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
		
		if(StringUtils.isNotBlank(propertyStyle)) {
			Select jobTypeSelect = new Select(driver.findElement(By.id(PROPERTY_STYLE_SELECT_ELEMENT)));
			jobTypeSelect.selectByValue(propertyStyle);
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
//			WebDriverWait waitSelect = new WebDriverWait(driver, 10);
			Select budgetSelect = new Select(driver.findElement(By.xpath(BUDGET_SELECT_ELEMENT)));
			budgetSelect.selectByValue(budget);
//			waitSelect.until(ExpectedConditions.elementToBeSelected(By.xpath(BUDGET_SELECT_ELEMENT)));
		}
		
		scriptUtils.click(By.xpath(STAGE4_CONTINUE));
	}
	
	public String getTestUrl() {
		return testUrl;
	}

	public void setTestUrl(String testUrl) {
		this.testUrl = testUrl;
	}

	/*
	public void getQuotesNewBuild() throws InterruptedException {
		scriptUtils.goTo(testUrl);
		Select tradetype = new Select(driver.findElement(By.id("trade")));
		tradetype.selectByValue("builder");
		Select select = new Select(driver.findElement(By.id("jobtype")));
		select.selectByValue("9");
		scriptUtils.click(NEXT_QUOTES_BUTTON);
	}
	*/

}
