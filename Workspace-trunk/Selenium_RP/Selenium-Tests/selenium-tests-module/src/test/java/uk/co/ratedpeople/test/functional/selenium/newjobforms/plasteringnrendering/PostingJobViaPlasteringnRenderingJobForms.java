/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.plasteringnrendering;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

/**
 * @author shabana.khanam
 * 
 */
public class PostingJobViaPlasteringnRenderingJobForms {
	
	
	private static final String ErewardIMAGE_XPATH  = ".//*[@id='skill-specifc-portable-jobform']/a/img";	
	private static final String SRC_CONTAINS  ="2/post-your-job/bundles/rpglobalassets/img/research-now-banner.jpg";
	
	public static Logger logger = Logger
			.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.plasteringnrendering.PostingJobViaPlasteringnRenderingJobForms");
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;
	private SeleniumTestContext context;

	public PostingJobViaPlasteringnRenderingJobForms(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.scriptUtils = scriptUtils;
		this.context = context;
	}

	public void PostingJobViaPlasteringnRenderingJobFormsPlasterSkimming() throws Exception {
		getQuotesplasterer();
		jobDetailsplasterer(PlasteringXpathlocators.xpathLookup.get("skimmingradio"), PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxpart"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsPlasterSkimmingpathoneOther() throws Exception {
		getQuotesplasterer();
		jobDetailsplastererOther(PlasteringXpathlocators.xpathLookup.get("skimmingradio"), PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxpart"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	// Other budget
	public void PostingJobViaPlasteringnRenderingJobFormsPlasterSkimmingOtherBudget() throws Exception {
		getQuotesplasterer();
		jobDetailsplasterer(PlasteringXpathlocators.xpathLookup.get("skimmingradio"), PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxpart"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budgetOther();
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsInternalrenderingPlasterSkimming() throws Exception {
		getQuotestiler();
		jobDetailsplastererTiler(PlasteringXpathlocators.xpathLookup.get("skimmingradio"), PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxpart"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsPlasterSkimmingpathoneOtherNOtherBudget() throws Exception {
		getQuotesplasterer();
		jobDetailsplastererOther(PlasteringXpathlocators.xpathLookup.get("skimmingradio"), PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxpart"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budgetOther();
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsPlasterSkimmingMaxCount() throws Exception {
		getQuotesplasterer();
		jobDetailsplasterer(PlasteringXpathlocators.xpathLookup.get("skimmingradio"), PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxpart"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budgetOther();
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsPlasterSkimmingPathtwoAll() throws Exception {
		getQuotesplasterer();
		jobDetailsplastererAll(PlasteringXpathlocators.xpathLookup.get("skimmingradio"), PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxpart"),
				PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxcomplete"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsPlasterSkimmingpathtwoOtherBudget() throws Exception {
		getQuotesplasterer();
		jobDetailsplastererCompleterooms(PlasteringXpathlocators.xpathLookup.get("skimmingradio"),
				PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxcomplete"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budgetOther();
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsPlasterSkimmingpathtwo() throws Exception {
		getQuotesplasterer();
		jobDetailsplastererCompleterooms(PlasteringXpathlocators.xpathLookup.get("skimmingradio"),
				PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxcomplete"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsPlasterSkimmingpathtwoOther() throws Exception {
		getQuotesplasterer();
		jobDetailsplastererCompleteroomsOther(PlasteringXpathlocators.xpathLookup.get("skimmingradio"),
				PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxcomplete"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	// Only Ceiling
	public void PostingJobViaPlasteringnRenderingJobFormsPlasterSkimmingpathtwoCeiling() throws Exception {
		getQuotesplasterer();
		jobDetailsplastererCompleteroomsCeiling(PlasteringXpathlocators.xpathLookup.get("skimmingradio"),
				PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxcomplete"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	// Only Walls
	public void PostingJobViaPlasteringnRenderingJobFormsPlasterSkimmingpathtwoWalls() throws Exception {
		getQuotesplasterer();
		jobDetailsplastererCompleteroomsWalls(PlasteringXpathlocators.xpathLookup.get("skimmingradio"),
				PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxcomplete"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	// Internal Rendering tests

	public void PostingJobViaInternalnRenderingJobFormsPlasterSkimming() throws Exception {
		getQuotestiler();
		jobDetailsplasterer(PlasteringXpathlocators.xpathLookup.get("skimmingradio"), PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxpart"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	public void PostingJobViaInternalnRenderingJobFormsPlasterSkimmingpathoneOther() throws Exception {
		getQuotestiler();
		jobDetailsplastererOther(PlasteringXpathlocators.xpathLookup.get("skimmingradio"), PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxpart"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	// Other budget
	public void PostingJobViaInternalnRenderingJobFormsPlasterSkimmingOtherBudget() throws Exception {
		getQuotestiler();
		jobDetailsplasterer(PlasteringXpathlocators.xpathLookup.get("skimmingradio"), PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxpart"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budgetOther();
		location();
	}

	public void PostingJobViaInternalnRenderingJobFormsInternalrenderingPlasterSkimming() throws Exception {
		getQuotestiler();
		jobDetailsplastererTiler(PlasteringXpathlocators.xpathLookup.get("skimmingradio"), PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxpart"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	public void PostingJobViaInternalnRenderingJobFormsPlasterSkimmingpathoneOtherNOtherBudget() throws Exception {
		getQuotestiler();
		jobDetailsplastererOther(PlasteringXpathlocators.xpathLookup.get("skimmingradio"), PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxpart"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budgetOther();
		location();
	}

	public void PostingJobViaInternalnRenderingJobFormsPlasterSkimmingMaxCount() throws Exception {
		getQuotestiler();
		jobDetailsplasterer(PlasteringXpathlocators.xpathLookup.get("skimmingradio"), PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxpart"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budgetOther();
		location();
	}

	public void PostingJobViaInternalnRenderingJobFormsPlasterSkimmingPathtwoAll() throws Exception {
		getQuotestiler();
		jobDetailsplastererAll(PlasteringXpathlocators.xpathLookup.get("skimmingradio"), PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxpart"),
				PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxcomplete"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	public void PostingJobViaInternalnRenderingJobFormsPlasterSkimmingpathtwoOtherBudget() throws Exception {
		getQuotestiler();
		jobDetailsplastererCompleterooms(PlasteringXpathlocators.xpathLookup.get("skimmingradio"),
				PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxcomplete"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budgetOther();
		location();
	}

	public void PostingJobViaInternalnRenderingJobFormsPlasterSkimmingpathtwo() throws Exception {
		getQuotestiler();
		jobDetailsplastererCompleterooms(PlasteringXpathlocators.xpathLookup.get("skimmingradio"),
				PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxcomplete"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	public void PostingJobViaInternalnRenderingJobFormsPlasterSkimmingpathtwoOther() throws Exception {
		getQuotestiler();
		jobDetailsplastererCompleteroomsOther(PlasteringXpathlocators.xpathLookup.get("skimmingradio"),
				PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxcomplete"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	// Only Ceiling
	public void PostingJobViaInternalnRenderingJobFormsPlasterSkimmingpathtwoCeiling() throws Exception {
		getQuotestiler();
		jobDetailsplastererCompleteroomsCeiling(PlasteringXpathlocators.xpathLookup.get("skimmingradio"),
				PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxcomplete"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	// Only Walls
	public void PostingJobViaInternalnRenderingJobFormsPlasterSkimmingpathtwoWalls() throws Exception {
		getQuotestiler();
		jobDetailsplastererCompleteroomsWalls(PlasteringXpathlocators.xpathLookup.get("skimmingradio"),
				PlasteringXpathlocators.xpathLookup.get("skimparttwochkboxcomplete"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	// Install Path

	public void PostingJobViaPlasteringnRenderingJobFormsInstall() throws Exception {
		getQuotesplasterer();
		jobDetailsInstallplasterer(PlasteringXpathlocators.xpathLookup.get("installradio"), PlasteringXpathlocators.xpathLookup.get("installradioyes"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsInstallNo() throws Exception {
		getQuotesplasterer();
		jobDetailsInstallplasterer(PlasteringXpathlocators.xpathLookup.get("installradio"), PlasteringXpathlocators.xpathLookup.get("installradiono"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsInstallDontKnow() throws Exception {
		getQuotesplasterer();
		jobDetailsInstallplasterer(PlasteringXpathlocators.xpathLookup.get("installradio"), PlasteringXpathlocators.xpathLookup.get("installradiodnow"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsInstallOther() throws Exception {
		getQuotesplasterer();
		jobDetailsInstallplastererOther(PlasteringXpathlocators.xpathLookup.get("installradio"), PlasteringXpathlocators.xpathLookup.get("installradiodnow"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsRepairJobdetailsPartone() throws Exception {
		getQuotesplasterer();
		jobDetailsRepair(PlasteringXpathlocators.xpathLookup.get("repairradio"));
		repairjobrelatepartone(PlasteringXpathlocators.xpathLookup.get("repairjobrelatepartone"));
		repairworkneedingpartone(PlasteringXpathlocators.xpathLookup.get("repairwrkneedpartone"));
		// Thread.sleep(4000);
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsRepairJobdetailsPartoneOtherBudget() throws Exception {
		getQuotesplasterer();
		jobDetailsRepair(PlasteringXpathlocators.xpathLookup.get("repairradio"));
		repairjobrelatepartone(PlasteringXpathlocators.xpathLookup.get("repairjobrelatepartone"));
		repairworkneedingpartone(PlasteringXpathlocators.xpathLookup.get("repairwrkneedpartone"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budgetOther();
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsRepairJobdetailsParttwoOther() throws Exception {
		getQuotesplasterer();
		jobDetailsRepairOther(PlasteringXpathlocators.xpathLookup.get("repairradio"), PlasteringXpathlocators.xpathLookup.get("repairjobrelateparttwoOther"),
				PlasteringXpathlocators.xpathLookup.get("repairwrkneedparttwoOther"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsRepairJobdetailsParttwo() throws Exception {
		getQuotesplasterer();
		jobDetailsRepair(PlasteringXpathlocators.xpathLookup.get("repairradio"));
		repairjobrelatepartonesub(PlasteringXpathlocators.xpathLookup.get("repairjobrelateparttwo"));
		repairworkneedingparttwosub(PlasteringXpathlocators.xpathLookup.get("repairwrkneedparttwo"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsRepairJobdetailsParttwoOtherbudget() throws Exception {
		getQuotesplasterer();
		jobDetailsRepair(PlasteringXpathlocators.xpathLookup.get("repairradio"));
		repairjobrelatepartonesub(PlasteringXpathlocators.xpathLookup.get("repairjobrelateparttwo"));
		repairworkneedingparttwosub(PlasteringXpathlocators.xpathLookup.get("repairwrkneedparttwo"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budgetOther();
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsRepairJobdetailsPartoneOther() throws Exception {
		getQuotesplasterer();
		jobDetailsRepairOther(PlasteringXpathlocators.xpathLookup.get("repairradio"), PlasteringXpathlocators.xpathLookup.get("repairjobrelateparttwoOther"),
				PlasteringXpathlocators.xpathLookup.get("repairwrkneedparttwoOther"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	public void PostingJobViaPlasteringnRenderingJobFormsRepairJobdetailsParttwoOtherBudget() throws Exception {
		getQuotesplasterer();
		jobDetailsRepairOther(PlasteringXpathlocators.xpathLookup.get("repairradio"), PlasteringXpathlocators.xpathLookup.get("repairjobrelateparttwoOther"),
				PlasteringXpathlocators.xpathLookup.get("repairwrkneedparttwoOther"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budgetOther();
		location();
	}

	// Something Else

	public void PostingJobViaPlasteringnRenderingJobFormsRepairJobdetailsSomethingElse() throws Exception {
		getQuotesplasterer();
		jobDetailsSomethingElse(PlasteringXpathlocators.xpathLookup.get("somethingelseradio"));
		additionalInfo(30, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();
	}

	// Internal Rendering
	public void PostingJobViaInternalnRenderingJobFormsRepairJobdetailsSomethingElse() throws Exception {
		getQuotestiler();
		jobDetailsSomethingElse(PlasteringXpathlocators.xpathLookup.get("somethingelseradio"));
		additionalInfo(30, PlasteringXpathlocators.dataLookup.get("postcode"));
		budget(9);
		location();

	}

	public void PostingJobViaInternalnRenderingJobFormsRepairJobdetailsPartoneOtherBudget() throws Exception {
		getQuotestiler();
		jobDetailsRepair(PlasteringXpathlocators.xpathLookup.get("repairradio"));
		repairjobrelatepartone(PlasteringXpathlocators.xpathLookup.get("repairjobrelatepartone"));
		repairworkneedingpartone(PlasteringXpathlocators.xpathLookup.get("repairwrkneedpartone"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budgetOther();
		location();
	}

	public void PostingJobViaInternalnRenderingJobFormsRepairJobdetailsParttwoOtherBudget() throws Exception {
		getQuotestiler();
		jobDetailsRepair(PlasteringXpathlocators.xpathLookup.get("repairradio"));
		repairjobrelatepartonesub(PlasteringXpathlocators.xpathLookup.get("repairjobrelateparttwo"));
		repairworkneedingparttwosub(PlasteringXpathlocators.xpathLookup.get("repairwrkneedparttwo"));
		additionalInfo(5, PlasteringXpathlocators.dataLookup.get("postcode"));
		budgetOther();
		location();
	}

	public void jobDetailsSomethingElse(String pathone) {
		scriptUtils.click(By.xpath(pathone));
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1")));
	}

	public void jobDetailsplastererCompleterooms(String pathone, String pathtwo) throws InterruptedException {
		scriptUtils.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1")));
		scriptUtils.click(By.xpath(pathtwo));
		List<WebElement> getoptions = driver.findElements(By.xpath(PlasteringXpathlocators.xpathLookup.get("visibilityofoptionspathtwo")));
		int getcountofli = getoptions.size();
		logger.info("Count of links are : " + getcountofli);
		for (int i = 1; i < getcountofli; i++) {
			String formxpath = PlasteringXpathlocators.xpathLookup.get("visibilityofoptionspathtwo") + "[" + i + "]/a[2]";
			logger.info("Xpath formed is  : " + formxpath);
			scriptUtils.click(By.xpath(formxpath));
		}
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("skimsjobdetailsnext")));
	}

	public void jobDetailsplastererCompleteroomsCeiling(String pathone, String pathtwo) throws InterruptedException {
		scriptUtils.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1")));
		Thread.sleep(5000);
		scriptUtils.click(By.xpath(pathtwo));
		List<WebElement> getoptions = driver.findElements(By.xpath(PlasteringXpathlocators.xpathLookup.get("visibilityofoptionspathtwo")));
		int getcountofli = getoptions.size();
		logger.info("Count of links are : " + getcountofli);
		for (int i = 1; i < getcountofli; i++) {
			String formxpath = PlasteringXpathlocators.xpathLookup.get("visibilityofoptionspathtwo") + "[" + i + "]/a[2]";
			logger.info("Xpath formed is  : " + formxpath);
			scriptUtils.click(By.xpath(formxpath));
			String ceilingpath = PlasteringXpathlocators.xpathLookup.get("visibilityofoptionspathtwo") + "[" + i + "]/div/ul/li[1]/input";
			scriptUtils.click(By.xpath(ceilingpath));

		}
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("skimsjobdetailsnext")));
	}

	public void jobDetailsplastererCompleteroomsWalls(String pathone, String pathtwo) throws InterruptedException {
		scriptUtils.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1")));
		Thread.sleep(5000);
		scriptUtils.click(By.xpath(pathtwo));
		List<WebElement> getoptions = driver.findElements(By.xpath(PlasteringXpathlocators.xpathLookup.get("visibilityofoptionspathtwo")));
		int getcountofli = getoptions.size();
		logger.info("Count of links are : " + getcountofli);
		for (int i = 1; i < getcountofli; i++) {
			String formxpath = PlasteringXpathlocators.xpathLookup.get("visibilityofoptionspathtwo") + "[" + i + "]/a[2]";
			logger.info("Xpath formed is  : " + formxpath);
			scriptUtils.click(By.xpath(formxpath));
			String ceilingpath = PlasteringXpathlocators.xpathLookup.get("visibilityofoptionspathtwo") + "[" + i + "]/div/ul/li[2]/input";
			scriptUtils.click(By.xpath(ceilingpath));

		}
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("skimsjobdetailsnext")));
	}

	public void jobDetailsplastererCompleteroomsOther(String pathone, String pathtwo) throws Exception {
		scriptUtils.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1")));
		Thread.sleep(5000);
		scriptUtils.click(By.xpath(pathtwo));
		String formxpath = PlasteringXpathlocators.xpathLookup.get("visibilityofoptionspaththree") + "[" + 4 + "]/a[2]";
		logger.info("Xpath formed is  : " + formxpath);
		scriptUtils.click(By.xpath(formxpath));
		Thread.sleep(3000);
		scriptUtils.fillInXpathField(PlasteringXpathlocators.xpathLookup.get("skimCompleteothertext"), TestScriptUtilities.getRandomString(3));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("skimsjobdetailsnext")));
		Thread.sleep(3000);

	}

	public void jobDetailsplasterer(String pathone, String pathtwo) throws Exception {
		scriptUtils.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1")));
		scriptUtils.click(By.xpath(pathtwo));
		List<WebElement> getoptions = driver.findElements(By.xpath(PlasteringXpathlocators.xpathLookup.get("visibilityofoptions")));
		int getcountofli = getoptions.size();
		logger.info("Count of links are : " + getcountofli);
		for (int i = 1; i < getcountofli; i++) {
			String formxpath = PlasteringXpathlocators.xpathLookup.get("visibilityofoptions") + "[" + i + "]/a[2]";
			logger.info("Xpath formed is  : " + formxpath);

			scriptUtils.click(By.xpath(formxpath));
		}
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("skimsjobdetailsnext")));
		// Thread.sleep(3000);
	}

	public void jobDetailsplastererTiler(String pathone, String pathtwo) throws Exception {

		scriptUtils.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1")));
		scriptUtils.click(By.xpath(pathtwo));
		List<WebElement> getoptions = driver.findElements(By.xpath(PlasteringXpathlocators.xpathLookup.get("visibilityofoptions")));
		int getcountofli = getoptions.size();
		logger.info("Count of links are : " + getcountofli);
		for (int i = 1; i < getcountofli; i++) {
			String formxpath = PlasteringXpathlocators.xpathLookup.get("visibilityofoptions") + "[" + i + "]/a[2]";
			logger.info("Xpath formed is  : " + formxpath);

			scriptUtils.click(By.xpath(formxpath));
		}
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("skimsjobdetailsnext")));
		Thread.sleep(3000);
	}

	public void jobDetailsplastererAll(String pathone, String pathtwo, String paththree) throws Exception {

		scriptUtils.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1")));
		scriptUtils.click(By.xpath(pathtwo));
		List<WebElement> getoptions = driver.findElements(By.xpath(PlasteringXpathlocators.xpathLookup.get("visibilityofoptions")));
		int getcountofli = getoptions.size();
		logger.info("Count of links are : " + getcountofli);
		for (int i = 1; i < getcountofli; i++) {
			String formxpath = PlasteringXpathlocators.xpathLookup.get("visibilityofoptions") + "[" + i + "]/a[2]";
			logger.info("Xpath formed is  : " + formxpath);

			scriptUtils.click(By.xpath(formxpath));
		}
		// Complete rooms
		scriptUtils.click(By.xpath(paththree));
		List<WebElement> getoptionscomplete = driver.findElements(By.xpath(PlasteringXpathlocators.xpathLookup.get("visibilityofoptionspathtwo")));
		int getcountoflicomplete = getoptionscomplete.size();
		logger.info("Count of links are : " + getcountoflicomplete);
		for (int i = 1; i < getcountoflicomplete; i++) {
			String formxpaththree = PlasteringXpathlocators.xpathLookup.get("visibilityofoptionspathtwo") + "[" + i + "]/a[2]";
			logger.info("Xpath formed is  : " + formxpaththree);
			scriptUtils.click(By.xpath(formxpaththree));
		}

		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("skimsjobdetailsnext")));
		Thread.sleep(3000);
	}

	public void jobDetailsplastererMax(String postcode, String pathone, String pathtwo) throws Exception {

		scriptUtils.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1")));
		Thread.sleep(5000);
		scriptUtils.click(By.xpath(pathtwo));
		List<WebElement> getoptions = driver.findElements(By.xpath(PlasteringXpathlocators.xpathLookup.get("visibilityofoptions")));
		int getcountofli = getoptions.size();
		logger.info("Count of links are : " + getcountofli);
		for (int i = 1; i < getcountofli; i++) {
			String formxpath = PlasteringXpathlocators.xpathLookup.get("visibilityofoptions") + "[" + i + "]/a[2]";
			logger.info("Xpath formed is  : " + formxpath);
			String makexpathforcount = PlasteringXpathlocators.xpathLookup.get("visibilityofoptions") + "[" + i + "]/input[starts-with(@id,'part')]";
			logger.info("Here is Xpath : " + makexpathforcount);
			String getmakexpathforcountText = driver.findElement(By.xpath(makexpathforcount)).getAttribute("value");
			logger.info("Here is the text : " + getmakexpathforcountText);
			if (getmakexpathforcountText.equalsIgnoreCase("0")) {
				scriptUtils.click(By.xpath(formxpath));
			}

			//
		}
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("skimsjobdetailsnext")));
		Thread.sleep(3000);
	}

	public void jobDetailsplastererOther(String pathone, String pathtwo) throws Exception {

		scriptUtils.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1")));
		Thread.sleep(5000);
		scriptUtils.click(By.xpath(pathtwo));
		String formxpath = PlasteringXpathlocators.xpathLookup.get("visibilityofoptions") + "[" + 5 + "]/a[2]";
		logger.info("Xpath formed is  : " + formxpath);
		scriptUtils.click(By.xpath(formxpath));
		scriptUtils.fillInXpathField(PlasteringXpathlocators.xpathLookup.get("skimothertext"), TestScriptUtilities.getRandomString(3));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("skimsjobdetailsnext")));
		Thread.sleep(3000);

	}

	/*
	 * This is the Install Job flow
	 */

	public void jobDetailsInstallplasterer(String pathone, String pathtwo) throws Exception {
		scriptUtils.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1")));
		List<WebElement> getoptions = driver.findElements(By.xpath(PlasteringXpathlocators.xpathLookup.get("visibilityinstalloptionsone")));
		int getcountofli = getoptions.size();
		logger.info("Count of links are : " + getcountofli);
		for (int i = 1; i < getcountofli; i++) {
			String formxpath = PlasteringXpathlocators.xpathLookup.get("visibilityinstalloptionsone") + "[" + i + "]/a[2]";
			logger.info("Xpath formed is  : " + formxpath);
			scriptUtils.click(By.xpath(formxpath));
		}

		getoptions = driver.findElements(By.xpath(PlasteringXpathlocators.xpathLookup.get("visibilityinstalloptionsone")));

		getcountofli = getoptions.size();
		logger.info("Count of links are : " + getcountofli);
		for (int i = 1; i < getcountofli; i++) {
			String formxpath = PlasteringXpathlocators.xpathLookup.get("visibilityinstalloptionsone") + "[" + i + "]/a[2]";
			logger.info("Xpath formed is  : " + formxpath);
			scriptUtils.click(By.xpath(formxpath));
		}

		scriptUtils.click(By.xpath(pathtwo));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("installnext")));
	}

	public void jobDetailsInstallplastererOther(String pathone, String pathtwo) throws Exception {

		scriptUtils.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1")));
		String formxpath = PlasteringXpathlocators.xpathLookup.get("visibilityinstalloptionstwo") + "[" + 4 + "]/a[2]";
		logger.info("Xpath formed is  : " + formxpath);
		scriptUtils.click(By.xpath(formxpath));
		scriptUtils.fillInXpathField(PlasteringXpathlocators.xpathLookup.get("installothertext"), TestScriptUtilities.getRandomString(3));
		scriptUtils.click(By.xpath(pathtwo));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("installnext")));
		Thread.sleep(3000);
	}

	/*
	 * This is for Repair flow
	 */

	public void jobDetailsRepair(String pathone) throws Exception {
		scriptUtils.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1")));
		/*
		 * List<WebElement> getoptions = driver.findElements(By.xpath(pathjobrelate)); int getcountofli = getoptions.size(); logger.info("Count of links are : "
		 * + getcountofli); for(int i=1;i<getcountofli;i++){ String formxpath = pathjobrelate+"["+i+"]/input"; logger.info("Xpath formed is  : "+formxpath);
		 * scriptUtils.click(By.xpath(formxpath)); }
		 * 
		 * List<WebElement> getoptionsparttwo = driver.findElements(By.xpath(pathworkneed)); int getcountofliparttwo = getoptionsparttwo.size();
		 * logger.info("Count of links are : " + getcountofliparttwo); for(int i=1;i<getcountofliparttwo;i++){ String formxpathtwo =
		 * pathworkneed+"["+i+"]/input"; logger.info("Xpath formed is  : "+formxpathtwo); scriptUtils.click(By.xpath(formxpathtwo)); }
		 */

	}

	public void jobDetailsRepairOther(String pathone, String pathtwo, String pathtwosub) throws Exception {
		scriptUtils.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1")));
		scriptUtils.click(By.xpath(pathtwo));
		scriptUtils.fillInXpathField(PlasteringXpathlocators.xpathLookup.get("repairjobrelateparttwoOthertext"), TestScriptUtilities.getRandomString(5));
		scriptUtils.click(By.xpath(pathtwosub));
		scriptUtils.fillInXpathField(PlasteringXpathlocators.xpathLookup.get("repairwrkneedparttwoOthertext"), TestScriptUtilities.getRandomString(5));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("repairnext")));
	}

	public void jobDetailstiler(String pathone, String pathtwo) throws Exception {
		scriptUtils.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PlasteringXpathlocators.xpathLookup.get("skimsjobdetailsnext"))));
		scriptUtils.click(By.xpath(pathtwo));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("skimsjobdetailsnext")));

	}

	public void getQuotesplasterer() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, "50", "plasterer");
	}

	public void getQuotestiler() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, "49", "tiler");
	}

	// Repair Job relate part one
	public void repairjobrelatepartone(String xpathjobrelate) {
		List<WebElement> getoptions = driver.findElements(By.xpath(xpathjobrelate));
		int getcountofli = getoptions.size();
		logger.info("Count of links are : " + getcountofli);
		int generateRandomofCountli = TestScriptUtilities.getRandomNumber(getcountofli);
		logger.info("Random of Count : " + generateRandomofCountli);

		for (int i = 1; i <= generateRandomofCountli; i++) {
			String formxpath = xpathjobrelate + "[" + i + "]/input";
			logger.info("Xpath formed is  : " + formxpath);
			scriptUtils.click(By.xpath(formxpath));
		}
	}

	public void repairjobrelatepartonesub(String xpathjobrelate) {
		List<WebElement> getoptions = driver.findElements(By.xpath(xpathjobrelate));
		int getcountofli = getoptions.size();
		// int generateRandomofCountli = getRandomNumber(getcountofli);
		// logger.info("Random of Count : " + generateRandomofCountli);
		logger.info("Count of links are : " + getcountofli);
		for (int i = 1; i < getcountofli - 1; i++) {
			String formxpath = xpathjobrelate + "[" + i + "]/input";
			logger.info("Xpath formed is  : " + formxpath);
			scriptUtils.click(By.xpath(formxpath));
		}
	}

	// Repair job work need doing partone
	public void repairworkneedingpartone(String xpathneedwork) {
		List<WebElement> getoptionsparttwo = driver.findElements(By.xpath(xpathneedwork));
		int getcountofliparttwo = getoptionsparttwo.size();
		int generateRandomofCountliparttwo = TestScriptUtilities.getRandomNumber(getcountofliparttwo);
		logger.info("Random of Count : " + generateRandomofCountliparttwo);
		logger.info("Count of links are : " + getcountofliparttwo);
		for (int i = 1; i <= generateRandomofCountliparttwo; i++) {
			String formxpath = xpathneedwork + "[" + i + "]/input";
			logger.info("Xpath formed is  : " + formxpath);
			scriptUtils.click(By.xpath(formxpath));
		}
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("repairnext")));
	}

	// Repair job work need doing parttwo
	public void repairworkneedingparttwosub(String xpathneedwork) {
		List<WebElement> getoptionsparttwo = driver.findElements(By.xpath(xpathneedwork));
		int getcountofliparttwo = getoptionsparttwo.size();
		logger.info("Count of links are : " + getcountofliparttwo);
		for (int i = 1; i <= getcountofliparttwo - 2; i++) {
			String formxpath = xpathneedwork + "[" + i + "]/input";
			logger.info("Xpath formed is  : " + formxpath);
			scriptUtils.click(By.xpath(formxpath));
		}
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("repairnext")));
	}

	// Repair job work need doing parttwo
	public void repairworkneedingparttwo(String xpathneedwork) {
		List<WebElement> getoptionsparttwo = driver.findElements(By.xpath(PlasteringXpathlocators.xpathLookup.get("repairradioparttwo")));
		int getcountofliparttwo = getoptionsparttwo.size();
		int generateRandomofCountliparttwo = TestScriptUtilities.getRandomNumber(getcountofliparttwo);
		logger.info("Random of Count : " + generateRandomofCountliparttwo);
		logger.info("Count of links are : " + generateRandomofCountliparttwo);
		for (int i = 1; i < generateRandomofCountliparttwo; i++) {
			String formxpath = PlasteringXpathlocators.xpathLookup.get("repairradioparttwo") + "[" + i + "]/input";
			logger.info("Xpath formed is  : " + formxpath);
			scriptUtils.click(By.xpath(formxpath));
		}
	}

	public void additionalInfo(int lengthstring, String postcode) throws Exception {
		scriptUtils.selectDropdown(By.xpath(PlasteringXpathlocators.xpathLookup.get("propertytype")), TestScriptUtilities.getRandomNumber(5));
		// intent & ownership added
		List<WebElement> getoptionsIntent = driver.findElements(By.xpath(PlasteringXpathlocators.xpathLookup.get("intent")));
		int getcountofli = getoptionsIntent.size();
		logger.info("Count of links are : " + getcountofli);
		for (int i = 1; i < getcountofli; i++) {
			String formxpath = PlasteringXpathlocators.xpathLookup.get("intent") + "[" + i + "]/input";
			logger.info("Xpath formed is  : " + formxpath);
			scriptUtils.click(By.xpath(formxpath));
		}
		List<WebElement> getoptionsOwner = driver.findElements(By.xpath(PlasteringXpathlocators.xpathLookup.get("ownership")));
		int getcountofliOwner = getoptionsOwner.size();
		logger.info("Count of links are : " + getcountofliOwner);
		for (int j = 1; j < getcountofli; j++) {
			String formxpathOwner = PlasteringXpathlocators.xpathLookup.get("ownership") + "[" + j + "]/input";
			logger.info("Xpath formed is  : " + formxpathOwner);
			scriptUtils.click(By.xpath(formxpathOwner));
		}
		scriptUtils.selectDropdown(By.xpath(PlasteringXpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtils.fillInXpathField(PlasteringXpathlocators.xpathLookup.get("textareaadditionalinfo"), TestScriptUtilities.getRandomString(lengthstring));
		scriptUtils.fillInTextField("postcode", postcode);
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("stagetwonext")));

	}

	public void fillInStage1(String radioButtonId) {
		if (StringUtils.isNotBlank(radioButtonId)) {
			scriptUtils.click(By.xpath(radioButtonId));
		}
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("continuestage1")));
	}

	public void fillInStage2Install(String plastererId, String plasterSkimId, String next) {
		if (StringUtils.isNotBlank(plastererId)) {
			scriptUtils.clickPlusIcon(plastererId, 3);
		}
		if (StringUtils.isNotBlank(plasterSkimId)) {
			scriptUtils.click(By.xpath(plasterSkimId));
		}
		scriptUtils.click(By.xpath(next));

	}

	public void fillInStage2Repair(String jobId, String plasterSkimId, String next) {
		if (StringUtils.isNotBlank(jobId)) {
			scriptUtils.click(By.xpath(jobId));
		}
		if (StringUtils.isNotBlank(plasterSkimId)) {
			scriptUtils.click(By.xpath(plasterSkimId));
		}
		scriptUtils.click(By.xpath(next));

	}

	public void fillInStage2PlasterSkim(String jobId, String plasterSkimId, String next) {
		if (StringUtils.isNotBlank(jobId)) {
			scriptUtils.click(By.xpath(jobId));
		}
		if (StringUtils.isNotBlank(plasterSkimId)) {
			scriptUtils.click(By.xpath(plasterSkimId));
		}
		scriptUtils.click(By.xpath(next));

	}

	public void fillInStage3(String jobStatusId, String ownershipStatusId, String jobTimingValue, String postcode, String additionalInfo) {
		if (StringUtils.isNotBlank(jobStatusId)) {
			scriptUtils.click(By.id(jobStatusId));
		}

		if (StringUtils.isNotBlank(ownershipStatusId)) {
			scriptUtils.click(By.id(ownershipStatusId));
		}

		if (StringUtils.isNotBlank(jobTimingValue)) {
			Select jobTypeSelect = new Select(driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("timing"))));
			jobTypeSelect.selectByValue(jobTimingValue);
		}

		if (StringUtils.isNotBlank(postcode)) {
			scriptUtils.fillInTextField("postcode", postcode);
		}

		if (StringUtils.isNotBlank(additionalInfo)) {
			scriptUtils.fillInXpathField(PlasteringXpathlocators.xpathLookup.get("textareaadditionalinfo"), additionalInfo);
		}

		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("stagetwonext")));
	}

	public void fillInStage4(String budget) {
		if (StringUtils.isNotBlank(budget)) {
			Select budgetSelect = new Select(driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("budget"))));
			budgetSelect.selectByValue(budget);
		}

		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("stagethreenext")));
	}

	public void budget(int budget) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PlasteringXpathlocators.xpathLookup.get("budget"))));
		scriptUtils.selectDropdown(By.xpath(PlasteringXpathlocators.xpathLookup.get("budget")), TestScriptUtilities.getRandomNumber(budget));
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("stagethreenext")));
		// Thread.sleep(3000);
	}

	public void budgetOther() {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PlasteringXpathlocators.xpathLookup.get("budget"))));
		scriptUtils.selectDropdown(By.xpath(PlasteringXpathlocators.xpathLookup.get("budget")), 10);
		String convrtrandNumber = Integer.toString(TestScriptUtilities.getRandomNumberGreaterThanfifty(100000));
		logger.info("Here is the converted integer  : " + convrtrandNumber);
		scriptUtils.fillInXpathField(PlasteringXpathlocators.xpathLookup.get("otherbudget"), convrtrandNumber);
		scriptUtils.click(By.xpath(PlasteringXpathlocators.xpathLookup.get("stagethreenext")));

	}

	public void location() throws Exception {
		String email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtils, context, TestScriptUtilities.getRandomAlphabeticString(3),
				TestScriptUtilities.getRandomAlphabeticString(3), PlasteringXpathlocators.dataLookup.get("mobile"),
				PlasteringXpathlocators.dataLookup.get("mobile"), email, email);

		// WebDriverWait waitfortext = new WebDriverWait(driver,60);
		// waitfortext.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(Xpathlocators.xpathLookup.get("headerthanku")),Xpathlocators.dataLookup.get("headertxt")));
		String getheaderText = driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("headerthanku"))).getText();
		logger.info("Header Text is : " + getheaderText);
		assertEquals(getheaderText, PlasteringXpathlocators.dataLookup.get("headertxt"));
		assertEquals(driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(),
				PlasteringXpathlocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
		assertEquals(driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("WHATHAPPENSNEXTONE_XPATH"))).getText(),
				PlasteringXpathlocators.dataLookup.get("WHATHAPPENSNEXTONE_TEXT"));
		assertEquals(driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("WHATHAPPENSNEXTTWO_XPATH"))).getText(),
				PlasteringXpathlocators.dataLookup.get("WHATHAPPENSNEXTTWO_TEXT"));
		assertEquals(driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("WHATHAPPENSNEXTTHREE_XPATH"))).getText(),
				PlasteringXpathlocators.dataLookup.get("WHATHAPPENSNEXTTHREE_TEXT"));
		
		
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
