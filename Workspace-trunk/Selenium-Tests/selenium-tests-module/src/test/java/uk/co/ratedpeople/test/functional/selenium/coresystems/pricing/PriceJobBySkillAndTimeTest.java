package uk.co.ratedpeople.test.functional.selenium.coresystems.pricing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.BuyJob;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;
import uk.co.ratedpeople.test.functional.selenium.newtmsignup.NewTradesmanSignUp;
import uk.co.ratedpeople.test.functional.selenium.newtmsignup.NewtmSignUphappyscenario;


/**
 * @author sangeetha.kumar
 * 
 * This test is used to check pricing for same job posted under different trades and time
 * Posting  Floor sanding and Finishing jobs from different trades like Flooring specialist and Carpenter /Joiner  
 * so that pricing can be checked to be the same
 */

public class PriceJobBySkillAndTimeTest extends TestScript {
	private PriceJobBySkillAndTime underTest;
	private NewtmSignUphappyscenario underTMSignpTest;
	private BuyJob<?> buyJob;
	// this method is set to false during debug mode
	@Override
	protected boolean shouldCloseSeleniumAfterTestsCompleteOrFail() {
	return true;
	}
		
	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new PriceJobBySkillAndTime(this.context, scriptUtilities);		
		underTMSignpTest = new NewtmSignUphappyscenario (this.context, scriptUtilities);
		new NewTradesmanSignUp (this.context, scriptUtilities);
		buyJob = new BuyJob<Object>(this.context, scriptUtilities);		
		new Login(scriptUtilities, context);
	
		}
	
	@Test(enabled=true)
	public void  testPostFloorsJobsinFlooring() throws Exception {
		underTest.submitJobWithUrgentTimingFlooring();
	}

	@Test(enabled=true,dependsOnMethods="testPostFloorsJobsinFlooring")
	 public void testPostFloorJobsinCarpenter() throws Exception {
		underTest.submitJobWithUrgentTimingCarpenter();
	}
	

	@Test(enabled=true,dependsOnMethods="testPostFloorJobsinCarpenter")
    public void testComparePriceStandardTMBySkillAndTimeTest() throws Exception {
		underTest.compareBuyLeadPriceStdTM(); 
		} 
	
	@Test(enabled=false,dependsOnMethods="testPostFloorJobsinCarpenter")
    public void testCompareJobPricePAYGTMBySkillAndTimeSkillTest() throws Exception {
		underTest.compareBuyLeadPricePaygTM();
		} 
	
	/*
	 * post a job in Scotland 
	 */
	@Test(enabled=true)
	public void  testPostScotLandFloorsJobsinFlooring() throws Exception {
		underTest.submitJobWithRestofUKUrgentTimingFlooring();
	}
	
	/*
	 * New Tm signup in Scotland
	 */
	@Test(enabled=false)
	public void testNewTmSignupScotland() throws Exception{
		String uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		underTMSignpTest.testbusinessdetailsScotland(uniqueEmailAccountName);
		underTMSignpTest.testScreeningdetails(uniqueEmailAccountName,"DD10 0AB");
		underTMSignpTest.createTMbillingDetails(); 
		buyJob.buyLead(uniqueEmailAccountName);
	   }
	}