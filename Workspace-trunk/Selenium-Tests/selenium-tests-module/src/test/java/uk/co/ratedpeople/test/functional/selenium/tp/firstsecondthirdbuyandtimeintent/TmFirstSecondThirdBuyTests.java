package uk.co.ratedpeople.test.functional.selenium.tp.firstsecondthirdbuyandtimeintent;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;


public class TmFirstSecondThirdBuyTests extends TestScript {
	private FirstSecondThirdBuyAndTimeIntent multiBuy;

	@BeforeClass
	public void beforeClass() {
		multiBuy=new FirstSecondThirdBuyAndTimeIntent(this.context, scriptUtilities);
	}
	
	@Test(enabled = true)
	public void firstsecondthridBuy() throws Exception {
		multiBuy.submitJobForFirstSecondThirdBuy();
		multiBuy.firstBuy();
		multiBuy.SecondBuy();
		multiBuy.ThirdBuy();
		
	}
	
	
}



