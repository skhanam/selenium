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
public class PostingJobViaPlasteringnRenderingSomethingElseNegativeTest extends TestScript {

	private PostingJobViaPlasteringnRenderingJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaPlasteringnRenderingJobForms(context, scriptUtilities);
	}

	@Test(groups={"sanity"},enabled = true)
	public void postingJobViaPlasteringnRenderingSomethingElseAdditionalInfoNegativeTest() throws Exception {
		underTest.getQuotestiler();
		underTest.jobDetailsSomethingElse(PlasteringXpathlocators.xpathLookup.get("somethingelseradio"));
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
	public void postingJobViaPlasteringnRenderingSomethingElseBudgetNegativeTest() throws Exception {
		underTest.getQuotestiler();
		underTest.jobDetailsSomethingElse(PlasteringXpathlocators.xpathLookup.get("somethingelseradio"));
		underTest.additionalInfo(30, PlasteringXpathlocators.dataLookup.get("postcode"));
		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("BUDGETXPATH"))).getText(),
				GardenXpathLocators.assertLookup.get("BUDGETMSG"));

	}

	@Test(groups={"sanity"},enabled = true)
	public void postingJobViaPlasteringnRenderingSomethingElseContactNegativeTest() throws Exception {
		underTest.getQuotestiler();
		underTest.jobDetailsSomethingElse(PlasteringXpathlocators.xpathLookup.get("somethingelseradio"));
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
