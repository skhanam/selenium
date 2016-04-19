package uk.co.ratedpeople.test.functional.selenium.lumberjack;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tp.firstsecondthirdbuyandtimeintent.FirstSecondThirdBuyAndTimeIntent;

/**
 * 
 * @author ruhulla.mohammad
 */
public class FirstSecondThirdJobBuyTest extends TestScript {

	private LumberJack ThreeTMBuyJob;
	private FirstSecondThirdBuyAndTimeIntent submitJob;

	@BeforeClass
	public void beforeClass() {
		ThreeTMBuyJob = new LumberJack(context, scriptUtilities);
		submitJob =new FirstSecondThirdBuyAndTimeIntent(this.context, scriptUtilities);
	}

	@Test(enabled = true) 
	public void FirstBuy() throws Exception {
		submitJob.submitJobForFirstSecondThirdBuy();
		Thread.sleep(5000);
		ThreeTMBuyJob.firstBuy("TMFirstBuy@ratedtrades.com");
	}
	
	@Test(enabled = true) 
	public void SeconBuy() throws Exception {
		ThreeTMBuyJob.SecondBuy("TMSecondBuy@ratedtrades.com");
	}
	
	@Test(enabled = true) 
	public void ThirdBuy() throws Exception {
		ThreeTMBuyJob.ThirdBuy("TMThirdBuy@ratedtrades.com");
	}
	
}