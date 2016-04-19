package uk.co.ratedpeople.test.functional.selenium.coresystems.pricing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;


/**
 * @author sangeetha.kumar
 * This test is used for testing the price of jobs for same skill and time with different intent
 * so that pricing can be checked to be the same
 */

public class PriceJobBySkillTimeAndIntentTest extends TestScript {
	private PriceJobBySkillTimeAndIntent underTest;
	
	// this method cab be set to false during debug mode
		@Override
		protected boolean shouldCloseSeleniumAfterTestsCompleteOrFail() {
		return true;
		}
				
	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new PriceJobBySkillTimeAndIntent(this.context, scriptUtilities);	
	}
	
	@Test(enabled=true)
    public void testPostReadyToHireJob() throws Exception {
		underTest.submitJob1ReadyToHire();
	}

	@Test(enabled=true,dependsOnMethods="testPostReadyToHireJob")
	public void testPlanBudgetJob() throws Exception {
		underTest.submitJob2WithPlanBudget();
	}
	
	@Test(enabled=true,dependsOnMethods="testPlanBudgetJob")
    public void testQuoteForInsuranceJob() throws Exception {
		underTest.submitJob3QuoteForInsurance();
	}
	
	@Test(enabled=true,dependsOnMethods="testQuoteForInsuranceJob")
    public void testpriceBySkillTimeAndIntentStandardTMTest() throws Exception {
		underTest.compareBuyLeadPriceSkillTimeIntentStdTM();
    } 
	
	@Test(enabled=false,dependsOnMethods="testQuoteForInsuranceJob")
    public void testpriceJobBySkillTimeAndIntentPAYGTMTest() throws Exception {
		underTest.compareBuyLeadPriceSkillTimeIntentPaygTM();
	}
}