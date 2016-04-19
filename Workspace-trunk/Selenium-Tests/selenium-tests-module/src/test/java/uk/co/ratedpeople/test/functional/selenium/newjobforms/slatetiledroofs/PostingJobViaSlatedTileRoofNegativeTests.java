/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.slatetiledroofs;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author shabana.khanam
 * 
 */
public class PostingJobViaSlatedTileRoofNegativeTests extends TestScript {

	private PostingJobViaSlateTiledRoofJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaSlateTiledRoofJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups={"sanity"},enabled = true)
	public void replaceJobdetailsNegativeTests() throws Exception {
		underTest.jobDetailsPage("radioReplace");
		underTest.replacePathFirstPage(null, null);
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("roofsection_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("roofsection_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("highestsection_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("highestsection_msg"));

	}

	@Test(groups={"regression"},enabled = true)
	public void repairJobdetailsNegativeTests() throws Exception {
		underTest.jobDetailsPage("radioRepair");
		underTest.repairPathFirstPage(null, null, null);
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("repairsection_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("repairsection_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("repair_roofsection_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("roofsection_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("repair_highestsection_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("highestsectionrepair_msg"));

	}

	@Test(groups={"regression"},enabled = true)
	public void replaceAdditionalInfoNegativeTests() throws Exception {
		underTest.jobDetailsPage("radioReplace");
		underTest.replacePathFirstPage(SlateTiledRoofsXpathlocators.dataLookup.get("roofSection"), SlateTiledRoofsXpathlocators.dataLookup.get("highestRoof"));
		underTest.replacePathSecondPage(null, null, null, null, 0, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("propertyTypelabel"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("propertytype_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("propertstylelabel"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("propertystyle_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("numberbedrooms_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("numberbedrooms_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("status_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("status_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("ownership_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("ownership_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("jobtostart_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("jobtostart_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("postcode_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("postcode_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("additional_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("additional_msg"));
	}

	@Test(groups={"regression"},enabled = true)
	public void repairAdditionalInfoNegativeTests() throws Exception {
		underTest.jobDetailsPage("radioRepair");
		underTest.repairPathFirstPage(SlateTiledRoofsXpathlocators.dataLookup.get("whichroofrepair"),
				SlateTiledRoofsXpathlocators.dataLookup.get("whereroofrepair"), SlateTiledRoofsXpathlocators.dataLookup.get("highestRoof"));
		underTest.repairSecondPage(null, null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("propertyTypelabel"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("propertytype_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("propertstylelabel"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("propertystyle_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("repairstatus_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("status_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("repairownership_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("ownership_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("jobtostart_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("jobtostart_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("repairpostcode_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("postcode_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("additional_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("additional_msg"));
	}

	@Test(groups={"sanity"},enabled = true)
	public void findnRepairSomethingElseAdditionalInfoNegativeTests() throws Exception {
		underTest.jobDetailsPage("radioRepairLeak");
		underTest.repairSecondPage(null, null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("propertyTypelabel"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("propertytype_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("propertstylelabel"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("propertystyle_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("repairstatus_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("status_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("repairownership_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("ownership_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("jobtostart_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("jobtostart_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("repairpostcode_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("postcode_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("additional_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("additional_msg"));
	}

	@Test(groups={"regression"},enabled = true)
	public void budgetNegativeTest() throws Exception {
		underTest.jobDetailsPage("radioElse");
		underTest.repairSecondPage(SlateTiledRoofsXpathlocators.dataLookup.get("propertytype"), SlateTiledRoofsXpathlocators.dataLookup.get("propertystyle"),
				SlateTiledRoofsXpathlocators.dataLookup.get("repairownership"), SlateTiledRoofsXpathlocators.dataLookup.get("repairintent"),
				SlateTiledRoofsXpathlocators.dataLookup.get("timing"), SlateTiledRoofsXpathlocators.dataLookup.get("postcode"),
				SlateTiledRoofsXpathlocators.dataLookup.get("description"));
		underTest.thirdPage(null);
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("budget_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("budget_msg"));
	}

	@Test(groups={"sanity"},enabled = true)
	public void contactNegativeTest() throws Exception {
		underTest.jobDetailsPage("radioElse");
		underTest.repairSecondPage(SlateTiledRoofsXpathlocators.dataLookup.get("propertytype"), SlateTiledRoofsXpathlocators.dataLookup.get("propertystyle"),
				SlateTiledRoofsXpathlocators.dataLookup.get("repairownership"), SlateTiledRoofsXpathlocators.dataLookup.get("repairintent"),
				SlateTiledRoofsXpathlocators.dataLookup.get("timing"), SlateTiledRoofsXpathlocators.dataLookup.get("postcode"),
				SlateTiledRoofsXpathlocators.dataLookup.get("description"));
		underTest.thirdPage(SlateTiledRoofsXpathlocators.dataLookup.get("BUDGET"));
		underTest.fourthPage(null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("fname_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("fname_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("lname_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("lname_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("number_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("num_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				SlateTiledRoofsXpathlocators.dataLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("email_label"))).getText(),
				SlateTiledRoofsXpathlocators.assertLookup.get("email_msg"));
		assertEquals(context.driver.findElement(By.xpath(SlateTiledRoofsXpathlocators.xpathLookup.get("CONFIRMEMAIL_ERRORMSG"))).getText(),
				SlateTiledRoofsXpathlocators.dataLookup.get("CONFIRMEMAIL_ERRORMSGTEXT"));
	}
}
