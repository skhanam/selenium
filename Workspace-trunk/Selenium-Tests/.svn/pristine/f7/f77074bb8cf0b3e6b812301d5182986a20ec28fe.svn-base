/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.slatetiledroofs;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import uk.co.ratedpeople.test.functional.selenium.TestScript;


/**
 * @author shabana.khanam
 *
 */
public class PostingJobViaSlateTiledRoofJobFormsTest extends TestScript {
	
	private static final String ErewardIMAGE_XPATH  = ".//*[@id='skill-specifc-portable-jobform']/a/img";	
	private static final String SRC_CONTAINS  ="2/post-your-job/bundles/rpglobalassets/img/research-now-banner.jpg";
	private static final String WELCOMETOEREWARDS_XPATH  =".//*[@id='Standard']/table/tbody/tr/td/span/strong";
	private static final String WELCOMETOEREWARDS_TEXT  ="Welcome to e-Rewards®!";
	private PostingJobViaSlateTiledRoofJobForms underTest;
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaSlateTiledRoofJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}
	

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}
	
	@Test(groups={"regression"},enabled = true)	
	 public void postingJobViaSlateTiledRoofFirstCriticalScenario() throws Exception{
		underTest.postingJobViaSlateTiledRoofFirstCriticalScenario();
		ThankYouPage();	
       
	}
	
	@Test(groups={"sanity"},enabled = true)	
	 public void postingJobViaSlateTiledRoofSecondCriticalScenario() throws Exception{
		underTest.postingJobViaSlateTiledRoofSecondCriticalScenario();
		ThankYouPage();	
		 
		
	}
	
	@Test(groups={"regression"},enabled = true)	
	 public void postingJobViaSlateTiledRoofThirdCriticalScenario() throws Exception{
		underTest.postingJobViaSlateTiledRoofThirdCriticalScenario();
		ThankYouPage();	

	}
	
	@Test(groups={"sanity"},enabled = true)	
	 public void postingJobViaSlateTiledRoofFourthCriticalScenario() throws Exception{
		underTest.postingJobViaSlateTiledRoofFourthCriticalScenario();
		
		ThankYouPage();			
		
	}
	
	@Test(groups={"sanity"},enabled = true)	
	 public void postingJobViaSlateTiledRoofFourthCriticalScenarioForEditjob() throws Exception{
		underTest.postingJobViaSlateTiledRoofFourthCriticalScenarioEditJob();
	
	}
	
	@Test(groups={"sanity"},enabled = true)	
	 public void postingJobViaSlateTiledRoofFourthCriticalScenarioToCancelAndReturnHome() throws Exception{
		underTest.postingJobViaSlateTiledRoofFourthCriticalScenarioCancelAndReturnHome();
		
		
	}
	
public void ThankYouPage() {
		
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("WHATHAPPENSNEXTONE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("WHATHAPPENSNEXTONE_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("WHATHAPPENSNEXTTWO_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("WHATHAPPENSNEXTTWO_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("WHATHAPPENSNEXTTHREE_XPATH"))).getText(), SlateTiledRoofsXpathlocators.dataLookup.get("WHATHAPPENSNEXTTHREE_TEXT"));
	
		// this is to test E-rewards link
				context.driver.findElement(By.xpath(ErewardIMAGE_XPATH)).isDisplayed();
				context.driver.findElement(By.xpath(ErewardIMAGE_XPATH)).getAttribute("src").contains(SRC_CONTAINS);
				
					
				String Mainwindow = context.driver.getWindowHandle(); 
				context.driver.findElement(By.xpath(ErewardIMAGE_XPATH)).click();

				for (String Erewardwindow : context.driver.getWindowHandles()) {
					context.driver.switchTo().window(Erewardwindow); 
				}

				context.driver.close(); 
				context.driver.switchTo().window(Mainwindow);
	
	}
	
}
