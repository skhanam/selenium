/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_tmbalance;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_refreshjbilling.RefreshJBillinginMK3;

/**
 * @author shobha.rani
 * Check values on MK3 Free Balance and Special Credit
 *
 */
    public class VerifyFreeBalanceandSpecialCreditMK3Test extends TestScript {
	  private VerifyFreeBalanceandSpecialCreditMK3 underTest;
	  private RefreshJBillinginMK3 refreshJbilling;
	  
	
	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new VerifyFreeBalanceandSpecialCreditMK3(this.context, scriptUtilities);
		refreshJbilling = new RefreshJBillinginMK3(this.context, scriptUtilities);	
   }
	
	@Test (enabled=true)
	public void testCheckFreeandSpecialBalanceinMK3() throws Exception 
	{
		
		refreshJbilling.testUpdateLuceneSearch();
		underTest.testCheckNewTMBalanceinMK3();
		//testCheckNewAnnualTMBalanceinMK3
		underTest.testCheckNewAnnualTMBalanceinMK3();
	    //  Current Plan: Trail Plan 1 Year Free 
		underTest.testChecksuspendedfreetrailplanTMBalanceinMK3();
	}
	
}
