package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_creditjob;

import java.math.BigDecimal;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author sangeetha.kumar
 * 
 * This test is used to check the positive scenarios of credit job function on MK3 - purchased jobs
 */

public class CreditJobTest extends TestScript{
	private CreditJob test;


//this method is set to false during debug mode
	@Override
	protected boolean shouldCloseSeleniumAfterTestsCompleteOrFail() {
	return true;
	}
		
	@BeforeClass
	public void beforeClass() throws Exception {
		test=new CreditJob(this.context, scriptUtilities);
		}
	
	@Test(enabled=true)
	public void  creaditJobTest() throws Exception {
	for (int i=0;i<1;i++) {
		test.submitJobAsExistingCustomer();
	}
	test.buyLeadExistingCardNoBalance();
	test.confirmTmEmailNewHoExistingTm();
	BigDecimal currentAmount = test.currentCreditValue();
	test.creditJob();
	test.specialCredit(currentAmount);
		
	}

}
