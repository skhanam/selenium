/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_tmuserstatus;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;


/**
 * @author shobha.rani
 *
 */
public class CheckMK3NotVerifiedTest extends TestScript {
    public String uniqueEmailAccountName;
	private CheckStatus checkOverriddenBtn;
	
		
	@BeforeClass
	public void beforeClass() throws Exception {		
		checkOverriddenBtn = new CheckStatus(this.context);		
	}
	@Test(enabled=true)
    public void testNotVerifiedTMOnMk3Test() throws Exception {
		String tradesman =CheckUserXpathlocators.dataLookup.get("EMAIL3");	
		checkOverriddenBtn.checkIsNotVerified(CheckUserXpathlocators.dataLookup.get("EMAIL"),CheckUserXpathlocators.dataLookup.get("PASSWORD"),tradesman);
		}

}
