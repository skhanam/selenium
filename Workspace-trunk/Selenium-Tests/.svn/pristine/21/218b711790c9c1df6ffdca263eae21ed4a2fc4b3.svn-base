package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_requestcallback;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class MK3RequestCreditBackNegativeTest extends TestScript {
	private MK3RequestCreditBack underTest;

	@Override
	protected boolean shouldCloseSeleniumAfterTestsCompleteOrFail() {
		return true;		
	}
	
	@BeforeClass
	public void beforeClass() throws Exception {
			underTest = new MK3RequestCreditBack(this.context, scriptUtilities);
	}

	@Test(enabled=true)
	public void goodwill_RCB_TMcomplaintMinValueTest() throws Exception {
		underTest.goodwill_RCB_TMcomplaintMinValues();
	}
	
	@Test(enabled=true)
	public void goodwill_RCB_TMcomplaintMaxValueTest() throws Exception {
		underTest.goodwill_RCB_TMcomplaintMaxValues();
	}
	
	@Test(enabled=true)
	public void goodwill_RCB_TMcomplaintNegativeTest() throws Exception {
		underTest.goodwill_RCB_TMcomplaintNegativeValues();
	}
	
	@Test(enabled=true)
	public void goodwill_RCB_InvalidHoDetailsMinValueTest() throws Exception {
			underTest.goodwill_RCB_InvalidHoDetailsMinValues();
			}
	
	@Test(enabled=true)
	public void goodwill_RCB_InvalidHoDetailsMaxValueTest() throws Exception {
			underTest.goodwill_RCB_InvalidHoDetailsMaxValues();
			}
	
	@Test(enabled=true)
	public void goodwill_RCB_InvalidHoDetailsNegativeTest() throws Exception {
			underTest.goodwill_RCB_InvalidHoDetailsNegativeValues();
			}
	}
