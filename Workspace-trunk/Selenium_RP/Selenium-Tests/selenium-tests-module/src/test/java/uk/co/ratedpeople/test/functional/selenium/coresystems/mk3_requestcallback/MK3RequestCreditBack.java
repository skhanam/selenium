package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_requestcallback;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class MK3RequestCreditBack {
	private Login login;
	private TestScriptUtilities scriptUtils;
	private WebDriver driver;
	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_requestcallback");
	public MK3RequestCreditBack(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		this.driver = context.driver;
		login = new Login(scriptUtils, context);
	}
	
	public void viewPaymentDetails() throws Exception {
		login.loginSupport(RCBXpathlocators.dataLookup.get("ADMIN_EMAIL"),RCBXpathlocators.dataLookup.get("PASSWORD"));
		if(scriptUtils.getTitle().contains("Login - Customer/Trade")){
    	login.loginSupport(RCBXpathlocators.dataLookup.get("ADMIN_EMAIL"),RCBXpathlocators.dataLookup.get("PASSWORD"));
    		searchText();
    	}else{
    		searchText();
		}
		
	}
	
	
	public void searchText(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))));
	    scriptUtils.findElement(By.id(RCBXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))).clear();
	    
	    scriptUtils.fillInTextField(RCBXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"),RCBXpathlocators.dataLookup.get("TMEMAIL"));
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("GO_BUTTON"))));
		scriptUtils.click(By.xpath(RCBXpathlocators.xpathLookup.get("GO_BUTTON")));
		if(moreRecords()== false){
			logger.info("There is no Search Results !!!");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("PAYMENT_DEATILS"))));				
		scriptUtils.click(By.xpath(RCBXpathlocators.xpathLookup.get("PAYMENT_DEATILS")));}else{
			logger.info("There are  Search Results !!!");
			//whenMoreRecords();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("USER"))));
			scriptUtils.click(By.xpath(RCBXpathlocators.xpathLookup.get("USER")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("PAYMENT_DEATILS"))));	
			scriptUtils.click(By.xpath(RCBXpathlocators.xpathLookup.get("PAYMENT_DEATILS")));
		}
	}
	
	public <WebElement> void whenMoreRecords(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("SEARCHRESULTS"))));
//		String getText = scriptUtils.getValue(RCBXpathlocators.xpathLookup.get("SEARCHRESULTS"));
//		logger.info("Search Results : " + getText);
//		if(getText.contains("Search Results"))
//		{
			List<org.openqa.selenium.WebElement> moreUsers =  driver.findElements(By.xpath(RCBXpathlocators.xpathLookup.get("GETUSR")));
			 int getTotalCount = moreUsers.size();
			 logger.info("Count of Users : " + getTotalCount);
			 if(getTotalCount > 3){
				 logger.info("In the count : " + getTotalCount);
				 for(int i=3;i<=getTotalCount;i++){
					 logger.info("About to click : " + getTotalCount);
					 String searchActiveUser = scriptUtils.getValue(RCBXpathlocators.xpathLookup.get("GETUSR")+"["+i+"]/td[4]");
					 logger.info("User status : " + searchActiveUser);
					 if(searchActiveUser.contains("(Active)")){
						scriptUtils.click(By.xpath(RCBXpathlocators.xpathLookup.get("GETUSR")+"["+i+"]/td[1]/a"));
						
					}
					 if(scriptUtils.getTitle().contains("Administer Details")){
						 break;
					 }
					 
				 }
				 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("PAYMENT_DEATILS"))));				
					scriptUtils.click(By.xpath(RCBXpathlocators.xpathLookup.get("PAYMENT_DEATILS")));
			} 
//		}
	}
	
	public boolean moreRecords(){
		boolean foundText;
		String getText = scriptUtils.getValue(RCBXpathlocators.xpathLookup.get("SEARCHRESULTS"));
		logger.info("Search Results : " + getText);
		if(getText.contains("Search Results")){
			logger.info("You have more records !!!! ");
			 foundText = true;
		}else foundText = false;
		logger.info("Found Text Status : "+foundText);
	 return  foundText;
	}
	public void creditValidation() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("ADD_SELECT_CREDIT_BTN"))));
		scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("ADD_SELECT_CREDIT_BTN")));	
		
		String error_message = scriptUtils.getValue(RCBXpathlocators.xpathLookup.get("VALIDATION_MESSAGE"));
	    Assert.assertEquals(error_message.contains(RCBXpathlocators.dataLookup.get("NOTE_ERROR_MESSAGE")),true);

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE"))));
	    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE")), 3);
	    
	    scriptUtils.fillInTextField(RCBXpathlocators.xpathLookup.get("ADDITIONAL_DETAILS"),RCBXpathlocators.dataLookup.get("DETAILS_VALUE"));				
	}
	
	
	
	public void goodwill_RCB_TMcomplaint() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,50);		
				
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE"))));
//	    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE")), 3);
//	   
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON"))));
	    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON")), 2);

	    scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("ADD_SELECT_CREDIT_BTN")));	
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT_MESSAGE"))));	    

	    String credit_award_message = scriptUtils.getValue(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT_MESSAGE"));
	    Assert.assertEquals(credit_award_message.contains(RCBXpathlocators.dataLookup.get("CREDIT_AWARDED_MESSAGE")),true);
	    
	}
		
	
	
	public String specialCredit(BigDecimal previousCreditAmount) throws Exception {
			viewPaymentDetails();
			WebDriverWait wait = new WebDriverWait(driver,50);	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("SPECIAL_CREDIT"))));
		    scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("SPECIAL_CREDIT")));
		    
		    String userSpecialCredit = null;
			boolean waitingForInfo = true;
			while (waitingForInfo) {
				userSpecialCredit = scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("SPECIAL_CREDIT"))).getText();
				if (userSpecialCredit != null && !userSpecialCredit.equals("")) {
					waitingForInfo = false;
				}
			}
			System.out.println(userSpecialCredit);
			
			BigDecimal newCreditAmount = new BigDecimal(userSpecialCredit.replaceAll("[,£]", ""));
			
			BigDecimal expectedNewCreditAmount = previousCreditAmount.add(BigDecimal.valueOf(10));
			
			Assert.assertEquals(newCreditAmount, expectedNewCreditAmount);
			
			return "";
		}
		
	
	public String specialCreditMinValue(BigDecimal previousCreditAmount) {
//			viewPaymentDetails();
			WebDriverWait wait = new WebDriverWait(driver,50);	
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("SPECIAL_CREDIT"))));
		    scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("SPECIAL_CREDIT")));
		    
		    String userSpecialCredit = null;
			boolean waitingForInfo = true;
			while (waitingForInfo) {
				userSpecialCredit = scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("SPECIAL_CREDIT"))).getText();
				if (userSpecialCredit != null && !userSpecialCredit.equals("")) {
					waitingForInfo = false;
				}
			}
			logger.info(userSpecialCredit);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("REFRESH_JBILLING"))));
			scriptUtils.click(By.xpath(RCBXpathlocators.xpathLookup.get("REFRESH_JBILLING")));
			BigDecimal newCreditAmount = new BigDecimal(userSpecialCredit.replaceAll("[£,]", ""));
			
			BigDecimal expectedNewCreditAmount = previousCreditAmount.add(BigDecimal.valueOf(0.01));
			
			Assert.assertEquals(newCreditAmount.add(BigDecimal.valueOf(0.01)), expectedNewCreditAmount);
			
			return "";
		}

	
	public String specialCreditMaxValue(BigDecimal previousCreditAmount) {
//			viewPaymentDetails();
			WebDriverWait wait = new WebDriverWait(driver,50);	
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("SPECIAL_CREDIT"))));
		    scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("SPECIAL_CREDIT")));
		    
		    String userSpecialCredit = null;
			boolean waitingForInfo = true;
			while (waitingForInfo) {
				userSpecialCredit = scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("SPECIAL_CREDIT"))).getText();
				if (userSpecialCredit != null && !userSpecialCredit.equals("")) {
					waitingForInfo = false;
				}
			}
			System.out.println(userSpecialCredit);
			
			BigDecimal newCreditAmount = new BigDecimal(userSpecialCredit.replaceAll("[£,]", ""));
			
			BigDecimal expectedNewCreditAmount = previousCreditAmount.add(BigDecimal.valueOf(100));
			
			Assert.assertEquals(newCreditAmount.add(BigDecimal.valueOf(100)), expectedNewCreditAmount);
			
			return "";
		}
	
	
	public String specialCreditNegValue(BigDecimal previousCreditAmount) {
//			viewPaymentDetails();
			WebDriverWait wait = new WebDriverWait(driver,30);	
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("SPECIAL_CREDIT"))));
		    scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("SPECIAL_CREDIT")));
		    
		    String userSpecialCredit = null;
			boolean waitingForInfo = true;
			while (waitingForInfo) {
				userSpecialCredit = scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("SPECIAL_CREDIT"))).getText();
				if (userSpecialCredit != null && !userSpecialCredit.equals("")) {
					waitingForInfo = false;
				}
			}
			System.out.println(userSpecialCredit);
			
			BigDecimal newCreditAmount = new BigDecimal(userSpecialCredit.replaceAll("[£,]", ""));
					
			
			BigDecimal expectedNewCreditAmount = previousCreditAmount;
			
			Assert.assertEquals(newCreditAmount, expectedNewCreditAmount);
			
			return "";
		}
		
	
	
	public BigDecimal currentCreditValue() {
			
			WebDriverWait wait = new WebDriverWait(driver,50);		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("SPECIAL_CREDIT"))));
		    scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("SPECIAL_CREDIT")));
		    
		    String userCurrentSpecialCredit = null;
			boolean waitingForInfo = true;
			while (waitingForInfo) {
				userCurrentSpecialCredit = scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("SPECIAL_CREDIT"))).getText();
				if (userCurrentSpecialCredit != null && !userCurrentSpecialCredit.equals("")) {
					waitingForInfo = false;
				}
			}
			System.out.println(userCurrentSpecialCredit);
			
			BigDecimal currentCreditAmount = new BigDecimal(userCurrentSpecialCredit.replaceAll("[£,]", ""));
					
			
			return currentCreditAmount;
		}
	
	
	public void goodwill_RCB_InvalidHoDetails() {
			WebDriverWait wait = new WebDriverWait(driver,50);		
			
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE"))));
		    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE")), 3);
		   
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON"))));
		    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON")), 1);

		    scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("ADD_SELECT_CREDIT_BTN")));	
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT_MESSAGE"))));	    

		    String credit_award_message = scriptUtils.getValue(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT_MESSAGE"));
		    Assert.assertEquals(credit_award_message.contains(RCBXpathlocators.dataLookup.get("CREDIT_AWARDED_MESSAGE")),true);
		}
		
	
	
	public void goodwill_RCB_TMcomplaintMinValues() throws Exception {
		viewPaymentDetails();
//		creditValidation();	
		BigDecimal currentAmount = currentCreditValue();

		WebDriverWait wait = new WebDriverWait(driver,50);		
				
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE"))));
	    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE")), 3);
	   
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON"))));
	    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON")), 2);
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT"))));
	    scriptUtils.clear(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT")));
	    scriptUtils.fillInXpathField(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT"),RCBXpathlocators.dataLookup.get("MIN_VALUE"));

	    scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("ADD_SELECT_CREDIT_BTN")));	
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT_MESSAGE"))));	    

	    String credit_award_message = scriptUtils.getValue(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT_MESSAGE"));
	    Assert.assertEquals(credit_award_message.contains(RCBXpathlocators.dataLookup.get("CREDIT_AWARDED_MESSAGE")),true);
	    
	    specialCreditMinValue(currentAmount);
	}
		
	
	public void goodwill_RCB_TMcomplaintMaxValues() throws Exception {
			viewPaymentDetails();
			creditValidation();	
			BigDecimal currentAmount = currentCreditValue();

			WebDriverWait wait = new WebDriverWait(driver,50);		
					
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE"))));
		    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE")), 3);
		   
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON"))));
		    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON")), 2);
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT"))));
		    scriptUtils.clear(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT")));
		    scriptUtils.fillInXpathField(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT"),RCBXpathlocators.dataLookup.get("MAX_VALUE"));

		    scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("ADD_SELECT_CREDIT_BTN")));	
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT_MESSAGE"))));	    

		    String credit_award_message = scriptUtils.getValue(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT_MESSAGE"));
		    Assert.assertEquals(credit_award_message.contains(RCBXpathlocators.dataLookup.get("CREDIT_AWARDED_MESSAGE")),true);
		    
		    specialCreditMaxValue(currentAmount);
		}
		
	public void goodwill_RCB_TMcomplaintNegativeValues() throws Exception {
			viewPaymentDetails();
			creditValidation();	
			BigDecimal currentAmount = currentCreditValue();

			WebDriverWait wait = new WebDriverWait(driver,70);		
					
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE"))));
		    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE")), 3);
		   
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON"))));
		    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON")), 2);
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT"))));
		    scriptUtils.clear(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT")));
		    scriptUtils.fillInXpathField(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT"),RCBXpathlocators.dataLookup.get("NEGATIVE_VALUE"));

		    scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("ADD_SELECT_CREDIT_BTN")));	
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("CRITICAL_AMOUNT_ERROR"))));	    

		    String credit_award_message = scriptUtils.getValue(RCBXpathlocators.xpathLookup.get("CRITICAL_AMOUNT_ERROR"));
		    Assert.assertEquals(credit_award_message.contains(RCBXpathlocators.dataLookup.get("INVALID_AMOUNT_MESSAGE")),true);
		    
		    specialCreditNegValue(currentAmount);
		}
	
	
	public void goodwill_RCB_InvalidHoDetailsMinValues() throws Exception {
			viewPaymentDetails();
			creditValidation();	
			BigDecimal currentAmount = currentCreditValue();
			
			logger.info("Special Credit before GoodWill Credit : "+currentAmount);

			WebDriverWait wait = new WebDriverWait(driver,50);		
			
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE"))));
		    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE")), 3);
		   
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON"))));
		    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON")), 1);

		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT"))));
		    scriptUtils.clear(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT")));
		    scriptUtils.fillInXpathField(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT"),RCBXpathlocators.dataLookup.get("MIN_VALUE"));

		    scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("ADD_SELECT_CREDIT_BTN")));	
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT_MESSAGE"))));	    

		    String credit_award_message = scriptUtils.getValue(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT_MESSAGE"));
		    Assert.assertEquals(credit_award_message.contains(RCBXpathlocators.dataLookup.get("CREDIT_AWARDED_MESSAGE")),true);

		    specialCreditMinValue(currentAmount);

		}
	
	
	public void goodwill_RCB_InvalidHoDetailsMaxValues() throws Exception {
			viewPaymentDetails();
			creditValidation();	
			BigDecimal currentAmount = currentCreditValue();

			WebDriverWait wait = new WebDriverWait(driver,50);		
			
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE"))));
		    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE")), 3);
		   
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON"))));
		    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON")), 1);

		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT"))));
		    scriptUtils.clear(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT")));
		    scriptUtils.fillInXpathField(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT"),RCBXpathlocators.dataLookup.get("MAX_VALUE"));

		    scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("ADD_SELECT_CREDIT_BTN")));	
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT_MESSAGE"))));	    

		    String credit_award_message = scriptUtils.getValue(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT_MESSAGE"));
		    Assert.assertEquals(credit_award_message.contains(RCBXpathlocators.dataLookup.get("CREDIT_AWARDED_MESSAGE")),true);

		    specialCreditMaxValue(currentAmount);

		}
	
	
	public void goodwill_RCB_InvalidHoDetailsNegativeValues() throws InterruptedException,Exception {
			viewPaymentDetails();
			creditValidation();	
			BigDecimal currentAmount = currentCreditValue();

			WebDriverWait wait = new WebDriverWait(driver,70);		
					
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE"))));
		    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE")), 3);
		   
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON"))));
		    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON")), 1);
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT"))));
		    scriptUtils.clear(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT")));
		    scriptUtils.fillInXpathField(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT"),RCBXpathlocators.dataLookup.get("NEGATIVE_VALUE"));

		    scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("ADD_SELECT_CREDIT_BTN")));	
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("CRITICAL_AMOUNT_ERROR"))));	    

		    String credit_award_message = scriptUtils.getValue(RCBXpathlocators.xpathLookup.get("CRITICAL_AMOUNT_ERROR"));
		    Assert.assertEquals(credit_award_message.contains(RCBXpathlocators.dataLookup.get("INVALID_AMOUNT_MESSAGE")),true);
		    
		    specialCreditNegValue(currentAmount);
		}
		
	
	public void retention() {
			WebDriverWait wait = new WebDriverWait(driver,50);		
			
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE"))));
		    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE")), 3);
		   
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON"))));
		    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON")), 3);

		    scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("ADD_SELECT_CREDIT_BTN")));	
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT_MESSAGE"))));	    

		    String credit_award_message = scriptUtils.getValue(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT_MESSAGE"));
		    Assert.assertEquals(credit_award_message.contains(RCBXpathlocators.dataLookup.get("CREDIT_AWARDED_MESSAGE")),true);
		}
		
   public void other() {
			WebDriverWait wait = new WebDriverWait(driver,50);		
			
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE"))));
		    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_TYPE")), 3);
		   
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON"))));
		    scriptUtils.selectDropdown(By.id(RCBXpathlocators.xpathLookup.get("CREDIT_REASON")), 4);

		    scriptUtils.click(By.id(RCBXpathlocators.xpathLookup.get("ADD_SELECT_CREDIT_BTN")));	
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT_MESSAGE"))));	    

		    String credit_award_message = scriptUtils.getValue(RCBXpathlocators.xpathLookup.get("CREDIT_AMOUNT_MESSAGE"));
		    Assert.assertEquals(credit_award_message.contains(RCBXpathlocators.dataLookup.get("CREDIT_AWARDED_MESSAGE")),true);
		}
}
