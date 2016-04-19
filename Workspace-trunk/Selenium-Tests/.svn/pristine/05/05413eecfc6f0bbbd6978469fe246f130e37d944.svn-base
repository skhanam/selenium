package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_requestcallback;

import java.math.BigDecimal;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class MK3RequestCreditBackTest extends TestScript {
	private MK3RequestCreditBack underTest;

	@Override
	protected boolean shouldCloseSeleniumAfterTestsCompleteOrFail() {
		return false;		
	}
	
	@BeforeClass
	public void beforeClass() throws Exception {
			underTest = new MK3RequestCreditBack(this.context, scriptUtilities);
	}

	@Test(enabled=true)
	public void goodwill_RCB_TMcomplaintTest() throws Exception {
	
		underTest.viewPaymentDetails();
		BigDecimal currentAmount = underTest.currentCreditValue();
		underTest.creditValidation();
		underTest.goodwill_RCB_TMcomplaint();
		//underTest.specialCredit(currentAmount);
	}
	
	@Test(enabled=true)
	public void goodwill_RCB_InvalidHoDetailsTest() throws Exception {
	
		underTest.viewPaymentDetails();
		BigDecimal currentAmount = underTest.currentCreditValue();
		underTest.creditValidation();
		underTest.goodwill_RCB_InvalidHoDetails();
		//underTest.specialCredit(currentAmount);
	}
	@Test(enabled=true)
	public void retentionTest() throws Exception {
	
		underTest.viewPaymentDetails();
		BigDecimal currentAmount = underTest.currentCreditValue();
		underTest.creditValidation();
		underTest.retention();
		//underTest.specialCredit(currentAmount);
		}
	
	@Test(enabled=true)
	public void othersTest() throws Exception {
	
		underTest.viewPaymentDetails();
		BigDecimal currentAmount = underTest.currentCreditValue();
		underTest.creditValidation();
		underTest.other();
		//underTest.specialCredit(currentAmount);
		}
	}
