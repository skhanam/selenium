package uk.co.ratedpeople.test.functional.selenium.coresystems.pricing;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;


import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class PriceJobBySkillAndTime {
	
	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.coresystems");
	
	private Login login;
	private SeleniumTestContext context;
	private TestScriptUtilities scriptUtils;
	private PriceJobBySkill underTest;
	

     public PriceJobBySkillAndTime(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
    	this.context = context;
    	this.scriptUtils = scriptUtils;
    	underTest = new PriceJobBySkill(context, scriptUtils);
		login = new Login(scriptUtils, context);
	}

     
    
	public void submitJobWithUrgentTimingFlooring() 
			throws Exception {
		
		underTest.chooseTradePage1("flooring", "31");		
		underTest.fillInPage2ForAdditionalInfo("statusINSURANCE_CLAIM","ownerOWN_AND_LIVE","URGENTLY","SW1E6AU","selenium test : Flooring Specialist- Floor sanding and Finishing  skill with Urgent timing." );
		underTest.location();
		}
	
	
	
	public void submitJobWithRestofUKUrgentTimingFlooring() 
			throws Exception {
		
		underTest.chooseTradePage1("flooring", "31");		
		underTest.fillInPage2ForOtherThanLondonAdditionalInfo("statusINSURANCE_CLAIM","ownerOWN_AND_LIVE","URGENTLY","G1 3BS",
				"selenium test : Flooring Specialist- Floor sanding and Finishing  skill with Urgent timing." );
		underTest.location();
		}
	
	
	@DataProvider(name = "dataProvider")
	public Object[][] provideData(Method method) {
 
		Object[][] result = null;
 
		if (method.getName().equals("fillInPage2ForAdditionalInfo")) {
			result = new Object[][] {
				{"statusINSURANCE_CLAIM","ownerOWN_AND_LIVE","URGENTLY","SW1E6AU","selenium test : Flooring Specialist- Floor sanding and Finishing  skill with Urgent timing."} 
			};
		} else if (method.getName().equals("fillInPage2ForAdditionalInfo")) {
			result = new Object[][] { 
				{"statusINSURANCE_CLAIM","ownerOWN_AND_LIVE","URGENTLY","G1 3BS",
				"selenium test : Flooring Specialist- Floor sanding and Finishing  skill with Urgent timing."}
			};
		}
 
		return result;
 
	}
	
	
	public void submitJobWithUrgentTimingCarpenter()
			throws Exception {
		
		underTest.chooseTradePage1("carpenter","31");
		underTest.fillInPage2ForAdditionalInfo("statusINSURANCE_CLAIM","ownerOWN_AND_LIVE","URGENTLY","SW1E6AU","selenium test : Carpenter Specialist - Floor sanding and Finishing skill with Urgent timing. " );
		underTest.location();		
		}
	
		// In future when the pricing sheet is updated with different values,all these scenarios should be checked.
/*		public void submitJob2Within2Days() {}
		public void submitJob3Within2weeks() {}
		public void submitJob4Within2Months() {}
		public void submitJob5Within2MonthsPlus() {}	
		public void submitJob6FlexiDates() {}
*/	
	
	public void compareBuyLeadPriceStdTM() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		login.loginTP(PricingXpathlocators.dataLookup.get("EMAIL3"), PricingXpathlocators.dataLookup.get("PASSWORD"));
		
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB2_VIEW_FULL_DETAILS_XPATH"))));
	    scriptUtils.clickXpath(PricingXpathlocators.xpathLookup.get("JOB2_VIEW_FULL_DETAILS_XPATH"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB_PRICE"))));
	    String price1 = scriptUtils.getValue(PricingXpathlocators.xpathLookup.get("JOB_PRICE"));
        logger.info("Tradesman Email : "+ PricingXpathlocators.dataLookup.get("EMAIL3"));
        logger.info("Job 1 " +price1);
	    scriptUtils.clickXpath(PricingXpathlocators.xpathLookup.get("JOB_LEADS"));
    	
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB3_VIEW_FULL_DETAILS_XPATH"))));
	    scriptUtils.clickXpath(PricingXpathlocators.xpathLookup.get("JOB3_VIEW_FULL_DETAILS_XPATH"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB_PRICE"))));
	    String price2 = scriptUtils.getValue(PricingXpathlocators.xpathLookup.get("JOB_PRICE"));
	    logger.info("Job 2" +price2);	
	        	        	    	
	    assertEquals(price1, price2);	    
	    System.out.println("Both jobs have the highest price based on timing " +price1);
	}
	public void compareBuyLeadPricePaygTM() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(context.driver, 20);
		login.loginTP(PricingXpathlocators.dataLookup.get("EMAIL4"), PricingXpathlocators.dataLookup.get("PASSWORD"));
		
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB2_VIEW_FULL_DETAILS_XPATH"))));
	    scriptUtils.clickXpath(PricingXpathlocators.xpathLookup.get("JOB2_VIEW_FULL_DETAILS_XPATH"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB_PRICE"))));
	    String price1 = scriptUtils.getValue(PricingXpathlocators.xpathLookup.get("JOB_PRICE"));
	    
        logger.info("Tradesman Email : "+ PricingXpathlocators.dataLookup.get("EMAIL4"));
        logger.info("Job 1 " +price1);
	    scriptUtils.clickXpath(PricingXpathlocators.xpathLookup.get("JOB_LEADS"));
    	
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB3_VIEW_FULL_DETAILS_XPATH"))));
	    scriptUtils.clickXpath(PricingXpathlocators.xpathLookup.get("JOB3_VIEW_FULL_DETAILS_XPATH"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB_PRICE"))));
	    String price2 = scriptUtils.getValue(PricingXpathlocators.xpathLookup.get("JOB_PRICE"));
	    logger.info("Job 2" +price2);	
	        	        	    	
	    assertEquals(price1, price2);	    
	    System.out.println("Both jobs have the highest price based on timing " +price1);
	}
}
