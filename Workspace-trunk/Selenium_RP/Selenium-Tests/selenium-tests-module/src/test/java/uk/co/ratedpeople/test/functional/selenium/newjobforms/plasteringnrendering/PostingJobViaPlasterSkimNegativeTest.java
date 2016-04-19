/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.plasteringnrendering;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.garden.GardenXpathLocators;

/**
 * @author shabana.khanam
 * 
 */
public class PostingJobViaPlasterSkimNegativeTest extends TestScript {

	private PostingJobViaPlasteringnRenderingJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaPlasteringnRenderingJobForms(context, scriptUtilities);
	}

	@Test(groups={"sanity"},enabled = true)
	public void postingJobviaSkimPlasterJobDetailsTest() throws Exception {
		underTest.getQuotesplasterer();
		underTest.fillInStage1(PlasteringXpathlocators.xpathLookup.get("skimmingradio"));
		underTest.fillInStage2Repair(PlasteringXpathlocators.xpathLookup.get("PARTSKIMXPATH"), null, PlasteringXpathlocators.xpathLookup.get("PLASTERNEXT"));
		assertEquals(context.driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("PARTSKIMMEDXPATH"))).getText(),
				PlasteringXpathlocators.assertLookup.get("NEWPLASTERMSG"));
	}

	@Test(groups={"regression"},enabled = true)
	public void postingJobviaSkimPlasterJobDetailsPlasterSkimTest() throws Exception {
		underTest.getQuotesplasterer();
		underTest.fillInStage1(PlasteringXpathlocators.xpathLookup.get("skimmingradio"));
		underTest.fillInStage2Repair(null, null, PlasteringXpathlocators.xpathLookup.get("PLASTERNEXT"));
		assertEquals(context.driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("PLASTERSKIMMEDXPATH"))).getText(),
				PlasteringXpathlocators.assertLookup.get("PLASTERSKIMMSG"));
	}

	@Test(groups={"regression"},enabled = true)
	public void postingJobviaSkimPlasterAdditionalDetailsTest() throws Exception {
		underTest.getQuotesplasterer();
		underTest.fillInStage1(PlasteringXpathlocators.xpathLookup.get("skimmingradio"));
		underTest.fillInStage2Repair(PlasteringXpathlocators.xpathLookup.get("PARTSKIMXPATH"), PlasteringXpathlocators.xpathLookup.get("PARTSKIMCEILINGXAPTH"),
				PlasteringXpathlocators.xpathLookup.get("PLASTERNEXT"));
		underTest.fillInStage3(null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("PROPERTYSTYLEXPATH"))).getText(),
				PlasteringXpathlocators.assertLookup.get("PROPERTYSTYLEMSG"));
		assertEquals(context.driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("STATUSXPATH"))).getText(),
				PlasteringXpathlocators.assertLookup.get("STATUSMSG"));
		assertEquals(context.driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("OWNERSHIPXPATH"))).getText(),
				PlasteringXpathlocators.assertLookup.get("OWNERSHIPMSG"));
		assertEquals(context.driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("TIMINGXPATH"))).getText(),
				PlasteringXpathlocators.assertLookup.get("TIMINGMSG"));
		assertEquals(context.driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("POSTCODEXPATH"))).getText(),
				PlasteringXpathlocators.assertLookup.get("POSTCODEMSG"));
		assertEquals(context.driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("ADDITIONALXPATH"))).getText(),
				PlasteringXpathlocators.assertLookup.get("DETAILSMSG"));

	}

	@Test(groups={"regression"},enabled = true)
	public void postingJobViaSkimPlasterBudgetNegativeTest() throws Exception {
		underTest.getQuotesplasterer();
		underTest.jobDetailsSomethingElse(PlasteringXpathlocators.xpathLookup.get("skimmingradio"));
		underTest.fillInStage2Repair(PlasteringXpathlocators.xpathLookup.get("PARTSKIMXPATH"), PlasteringXpathlocators.xpathLookup.get("PARTSKIMCEILINGXAPTH"),
				PlasteringXpathlocators.xpathLookup.get("PLASTERNEXT"));
		underTest.additionalInfo(30, PlasteringXpathlocators.dataLookup.get("postcode"));
		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("BUDGETXPATHNEW"))).getText(),
				GardenXpathLocators.assertLookup.get("BUDGETMSG"));

	}

	@Test(groups={"sanity"},enabled = true)
	public void postingJobViaSkimPlasterContactNegativeTest() throws Exception {
		underTest.getQuotesplasterer();
		underTest.jobDetailsSomethingElse(PlasteringXpathlocators.xpathLookup.get("skimmingradio"));
		underTest.fillInStage2Repair(PlasteringXpathlocators.xpathLookup.get("PARTSKIMXPATH"), PlasteringXpathlocators.xpathLookup.get("PARTSKIMCEILINGXAPTH"),
				PlasteringXpathlocators.xpathLookup.get("PLASTERNEXT"));
		underTest.additionalInfo(30, PlasteringXpathlocators.dataLookup.get("postcode"));
		underTest.budget(9);
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}
}
