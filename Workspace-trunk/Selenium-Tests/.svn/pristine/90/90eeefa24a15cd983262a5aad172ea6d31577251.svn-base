package uk.co.ratedpeople.test.functional.selenium.newjobforms.generic;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.internalrenovation.InternalRenovationXpathLocators;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.plasteringnrendering.PlasteringXpathlocators;

public class PostingJobviaGenericJobForm {

	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.generic");
	private WebDriver driver;
	private String testUrl;
	private SeleniumTestContext context;
	private TestScriptUtilities scriptUtils;

	public PostingJobviaGenericJobForm(final SeleniumTestContext context, final TestScriptUtilities scriptUtils) {
		this.context = context;
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.scriptUtils = scriptUtils;
	}

	public void postingJobviaNewGenericJobform() throws Exception {
		getlandingPage("/get-quotes/", "25", "network");
		jobDetailsGeneric();
		additionalInfo(30, InternalRenovationXpathLocators.dataLookup.get("postcode"));
		budget(8);
		location();
	}

	public void postingJobviaNewGenericJobformLocal() throws Exception {
		getlandingPageForLocal("/local/aerial-network-specialists", "25", "network");
		jobDetailsGeneric();
		additionalInfo(30, InternalRenovationXpathLocators.dataLookup.get("postcode"));
		budget(8);
		location();
	}

	public void postingJobviaNewGenericJobformDotCom() throws Exception {
		getlandingPage("", "31", "flooring");
		jobDetailsGeneric();
		additionalInfo(30, InternalRenovationXpathLocators.dataLookup.get("postcode"));
		budget(8);
		location();
	}

	public void postingJobviaNewGenericJobformDotCom(final String userName, final String postcode, final String skillTypeId, final String trade, final String description) throws Exception {
		getlandingPage("", skillTypeId, trade);
		jobDetailsGeneric();
		additionalInfo(description, postcode);
		budget(8);
		location(userName);
	}

	public void postingJobviaGenericJobBudgetValidation() throws Exception {
		getlandingPage("/get-quotes/", "25", "network");
		jobDetailsGeneric();
		additionalInfo(30, InternalRenovationXpathLocators.dataLookup.get("postcode"));
	}

	public void postingJobviaGenericJobContactPageFnameValidation() throws Exception {
		getlandingPage("/get-quotes/", "25", "network");
		jobDetailsGeneric();
		additionalInfo(30, InternalRenovationXpathLocators.dataLookup.get("postcode"));
		budget(10);
	}

	public void getlandingPage(String passUrl, String jobTypeValue, String tradeTypeValue) throws Exception {
		scriptUtils.getQuotes(testUrl + passUrl, driver, jobTypeValue, tradeTypeValue);
	}

	// landing page for local page job form
	public void getlandingPageForLocal(String passUrl, String jobTypeValue, String tradeTypeValue) throws Exception {
		scriptUtils.getQuotesForLocal(testUrl + passUrl, driver, jobTypeValue, tradeTypeValue);
	}

	public void jobDetailsGeneric() throws InterruptedException {

		List<WebElement> getoptionsIntent = driver.findElements(By.xpath(GenericJobFormXpathLocators.xpathLookup.get("intent")));
		int getcountofli = getoptionsIntent.size();
		logger.info("Count of links are : " + getcountofli);
		for (int i = 1; i < getcountofli; i++) {
			String formxpath = GenericJobFormXpathLocators.xpathLookup.get("intent") + "[" + i + "]/input";
			logger.info("Xpath formed is  : " + formxpath);
			scriptUtils.click(By.xpath(formxpath));
		}
		List<WebElement> getoptionsOwner = driver.findElements(By.xpath(GenericJobFormXpathLocators.xpathLookup.get("ownership")));
		int getcountofliOwner = getoptionsOwner.size();
		logger.info("Count of links are : " + getcountofliOwner);
		for (int j = 1; j < getcountofli; j++) {
			String formxpathOwner = GenericJobFormXpathLocators.xpathLookup.get("ownership") + "[" + j + "]/input";
			logger.info("Xpath formed is  : " + formxpathOwner);
			scriptUtils.click(By.xpath(formxpathOwner));
		}
		// scriptUtils.click(By.xpath(GenericJobFormXpathLocators.xpathLookup
		// .get("skimsjobdetailsnext")));
	}

	public void budget(int budget) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(GenericJobFormXpathLocators.xpathLookup.get("budget"))));
		scriptUtils.selectDropdown(By.xpath(GenericJobFormXpathLocators.xpathLookup.get("budget")), TestScriptUtilities.getRandomNumber(budget));
		scriptUtils.click(By.xpath(GenericJobFormXpathLocators.xpathLookup.get("stagethreenext")));
		// Thread.sleep(3000);
	}

	public void additionalInfo(int lengthstring, String postcode) throws Exception {
		scriptUtils.selectDropdown(By.xpath(GenericJobFormXpathLocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtils.fillInXpathField(GenericJobFormXpathLocators.xpathLookup.get("textareaadditionalinfo"), TestScriptUtilities.getRandomString(lengthstring));
		scriptUtils.fillInTextField("postcode", postcode);
		scriptUtils.click(By.xpath(GenericJobFormXpathLocators.xpathLookup.get("stagetwonext")));
	}

	public void additionalInfo(final String description, final String postcode) throws Exception {
		scriptUtils.selectDropdown(By.xpath(GenericJobFormXpathLocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtils.fillInXpathField(GenericJobFormXpathLocators.xpathLookup.get("textareaadditionalinfo"), description);
		scriptUtils.fillInTextField("postcode", postcode);
		scriptUtils.click(By.xpath(GenericJobFormXpathLocators.xpathLookup.get("stagetwonext")));
	}

	public void location() throws Exception {

		String phone = PlasteringXpathlocators.dataLookup.get("mobile");
		String email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtils, context, TestScriptUtilities.getRandomAlphabeticString(3),
				TestScriptUtilities.getRandomAlphabeticString(3), phone, phone, email, email);

		String getheaderText = driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("headerthanku"))).getText();
		logger.info("Header Text is : " + getheaderText);
		assertEquals(getheaderText, PlasteringXpathlocators.dataLookup.get("headertxt"));
	}

	public void location(final String userName) throws Exception {
		String phone = PlasteringXpathlocators.dataLookup.get("mobile");

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtils, context, TestScriptUtilities.getRandomAlphabeticString(3),
				TestScriptUtilities.getRandomAlphabeticString(3), phone, phone, userName, userName);

		String getheaderText = driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("headerthanku"))).getText();
		logger.info("Header Text is : " + getheaderText);
		assertEquals(getheaderText, PlasteringXpathlocators.dataLookup.get("headertxt"));
	}
}
