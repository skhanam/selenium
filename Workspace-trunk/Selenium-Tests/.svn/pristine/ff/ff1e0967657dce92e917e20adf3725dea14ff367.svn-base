/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_refreshjbilling;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_refreshjbilling.RefreshJBillinginMK3;

/**
 * @author shobha.rani
 *
 */
public class RefreshingJBillingExistingUserTest extends TestScript {
	private RefreshJBillinginMK3 underTest;
	
	@BeforeClass
	public void beforeClass() {
		underTest = new RefreshJBillinginMK3(this.context, scriptUtilities);	
	}
	
	@Test (enabled=true)
	public void existingRefreshJBillingTradesmanTest() throws Exception {
			
		underTest.testExistingUserRefreshJBilling();
		underTest.testReActivateExistingsuspendUser();
	}

}
