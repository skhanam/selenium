/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.internalwoodendoor;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.internalwoodendoor.InternalWoodenDoorsXpathlocators;

public class PostingJobViaInternalWoodenDoorJobFormsTest extends TestScript {
	private PostingJobViaInternalWoodenDoorJobForms underTest;
	
	private static final String ErewardIMAGE_XPATH  = ".//*[@id='skill-specifc-portable-jobform']/a/img";	
	private static final String SRC_CONTAINS  ="2/post-your-job/bundles/rpglobalassets/img/research-now-banner.jpg";
	private static final String WELCOMETOEREWARDS_XPATH  =".//*[@id='Standard']/table/tbody/tr/td/span/strong";
	private static final String WELCOMETOEREWARDS_TEXT  ="Welcome to e-Rewards®!";

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaInternalWoodenDoorJobForms(context, scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups={"sanity"},enabled = true)
	public void postingJobViaInternalWoodenDoorFirstCriticalScenario()
			throws Exception {
		underTest.postingJobViaInternalWoodenDoorFirstCriticalScenario();
		
		ThankYouPage();
		

	}

	@Test(groups={"regression"},enabled = true)
	public void postingJobViaInternalWoodenDoorSecondCriticalScenario()
			throws Exception {
		underTest.postingJobViaInternalWoodenDoorSecondCriticalScenario();
		ThankYouPage();
		
	}

	@Test(groups={"regression"},enabled = true)
	public void postingJobViaInternalWoodenDoorThirdCriticalScenario()
			throws Exception {
		underTest.postingJobViaInternalWoodenDoorThirdCriticalScenario();
		ThankYouPage();
		
	}

	@Test(groups={"sanity"},enabled = true)
	public void postingJobViaInternalWoodenDoorFourthCriticalScenario()
			throws Exception {
		underTest.postingJobViaInternalWoodenDoorFourthCriticalScenario();
		
		ThankYouPage();

		
	}
	
     public void ThankYouPage() {
		
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(), InternalWoodenDoorsXpathlocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("WHATHAPPENSNEXTONE_XPATH"))).getText(), InternalWoodenDoorsXpathlocators.dataLookup.get("WHATHAPPENSNEXTONE_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("WHATHAPPENSNEXTTWO_XPATH"))).getText(), InternalWoodenDoorsXpathlocators.dataLookup.get("WHATHAPPENSNEXTTWO_TEXT"));
		assertEquals(context.driver.findElement(By.xpath(InternalWoodenDoorsXpathlocators.xpathLookup.get("WHATHAPPENSNEXTTHREE_XPATH"))).getText(), InternalWoodenDoorsXpathlocators.dataLookup.get("WHATHAPPENSNEXTTHREE_TEXT"));
	
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
