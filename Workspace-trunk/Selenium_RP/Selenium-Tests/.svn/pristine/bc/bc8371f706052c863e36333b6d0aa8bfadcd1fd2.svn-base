/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.internalrenovation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

/**
 * @author shabana.khanam
 * 
 */
public class PostingJobViaInternalRenovationNegativeTests extends TestScript {

	private PostingJobviaInternalRenovationJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobviaInternalRenovationJobForms(context, scriptUtilities);
	}

	@Test(groups = { "regression" }, enabled = true)
	public void reconfigureJobDetailsTest() throws Exception {
		underTest.getQuotes();
		underTest.service(InternalRenovationXpathLocators.xpathlookup.get("reconfigradio"));
		underTest.fillRepairRenovate(InternalRenovationXpathLocators.xpathlookup.get("wrkType"), null,
				InternalRenovationXpathLocators.xpathlookup.get("wrkDone"), null, InternalRenovationXpathLocators.xpathlookup.get("renovateNext"));
		assertEquals(context.driver.findElement(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("whatwork_label"))).getText(),
				InternalRenovationXpathLocators.assertLookup.get("whatwork_msg"));
		assertEquals(context.driver.findElement(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("wherework_label"))).getText(),
				InternalRenovationXpathLocators.assertLookup.get("wherework_msg"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void reRepairJobDetailsTest() throws Exception {
		underTest.getQuotes();
		underTest.service(InternalRenovationXpathLocators.xpathlookup.get("repairradio"));
		underTest.fillRepairRenovate(InternalRenovationXpathLocators.xpathlookup.get("repairItem"), null,
				InternalRenovationXpathLocators.xpathlookup.get("repairNeeded"), null, InternalRenovationXpathLocators.xpathlookup.get("repairNext"));
		assertEquals(context.driver.findElement(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("repairwhatwork_label"))).getText(),
				InternalRenovationXpathLocators.assertLookup.get("repairwhatwork_msg"));
		assertEquals(context.driver.findElement(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("repairwherework_label"))).getText(),
				InternalRenovationXpathLocators.assertLookup.get("repairwherework_msg"));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void additionalInfoNegativeTests() throws Exception {
		underTest.getQuotes();
		underTest.jobDetailsRepair(InternalRenovationXpathLocators.xpathlookup.get("repairradio"));
		underTest.fillInStage2(null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("material_label"))).getText(),
				InternalRenovationXpathLocators.assertLookup.get("material_msg"));
		assertEquals(context.driver.findElement(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("propertystyle_label"))).getText(),
				InternalRenovationXpathLocators.assertLookup.get("property_msg"));
		assertEquals(context.driver.findElement(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("propertylist_label"))).getText(),
				InternalRenovationXpathLocators.assertLookup.get("property_list_msg"));
		assertEquals(context.driver.findElement(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("status_label"))).getText(),
				InternalRenovationXpathLocators.assertLookup.get("status_msg"));
		assertEquals(context.driver.findElement(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("ownership_label"))).getText(),
				InternalRenovationXpathLocators.assertLookup.get("ownership_msg"));
		assertEquals(context.driver.findElement(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("timing_label"))).getText(),
				InternalRenovationXpathLocators.assertLookup.get("timing_msg"));
		assertEquals(context.driver.findElement(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("postcode_label"))).getText(),
				InternalRenovationXpathLocators.assertLookup.get("postcode_msg"));
		assertEquals(context.driver.findElement(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("description_label"))).getText(),
				InternalRenovationXpathLocators.assertLookup.get("addinfo_msg"));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void budgetNegativeTests() throws Exception {
		underTest.getQuotes();
		underTest.jobDetailsSomethingElse(InternalRenovationXpathLocators.xpathlookup.get("somethingelseradio"));
		underTest.additionalInfo(30, InternalRenovationXpathLocators.dataLookup.get("postcode"), InternalRenovationXpathLocators.xpathlookup.get("intent"),
				InternalRenovationXpathLocators.xpathlookup.get("ownership"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage3(null);
		assertEquals(context.driver.findElement(By.xpath(InternalRenovationXpathLocators.xpathlookup.get("budget_label"))).getText(),
				InternalRenovationXpathLocators.assertLookup.get("budget_msg"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void contactNegativeTests() throws Exception {
		underTest.getQuotes();
		underTest.jobDetailsSomethingElse(InternalRenovationXpathLocators.xpathlookup.get("somethingelseradio"));
		underTest.additionalInfo(30, InternalRenovationXpathLocators.dataLookup.get("postcode"), InternalRenovationXpathLocators.xpathlookup.get("intent"),
				InternalRenovationXpathLocators.xpathlookup.get("ownership"), TestScriptUtilities.getRandomString(30));
		underTest.budgetOther();
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

}
