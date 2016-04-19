/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.ho.diy;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author shabana.khanam
 * 
 */
public class AskAnExpertQuestionQnATest extends TestScript {

	private static final String THANK_YOU_TEXT = "Thank you for your submission. You will receive an email when one of our experts has answered your question.";
	private static final String THANK_YOU_TEXT_ELEMENT = "html/body/div[2]/div/div/div[1]/div/div/h2";
	private static final String PLUMBER = "plumber";
	private static final String FIRSTTRADESMEN = "integration.test@ratedtrades.com";
	private static final String password = "password";
	private static final String FIRSTTRADESMENTEXT = "first posted text by integration test";
	private static final String SECONDTRADESMEN = "askanexpert@ratedtrades.com";
	private static final String SECONDTRADESMENTEXT = "second posted text by askanexpert test";
	private static final String ROOFER = "roofer";
	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.ho.diy.AskAnExpertQuestionQnATest");
	private AskAnExpertQuestionQnA underTest;

	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new AskAnExpertQuestionQnA(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@Test(enabled = true)
	public void testfillinQuestionnaireforDIY() throws Exception {
		underTest.getdiypage();
		underTest.fillinQuestionnaire("plumber");
		String getheader = context.driver.findElement(By.xpath(THANK_YOU_TEXT_ELEMENT)).getText();
		logger.info("Here is the header text : " + getheader);
		assertEquals(context.driver.findElement(By.xpath(THANK_YOU_TEXT_ELEMENT)).getText(), THANK_YOU_TEXT);
		WebDriverWait waitForPageToLoad = new WebDriverWait(context.driver, 10);
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("GENERALDIY_XAPTH"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("GENERALDIY_XAPTH"))).click();

	}

	@Test(enabled = true)
	public void GetHyperLinksUnderCategories() throws Exception {

		underTest.getdiypage();
		WebDriverWait waitForPageToLoad = new WebDriverWait(context.driver, 10);
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CATEGORIES_XPATH"))));
		String getheader = context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CATEGORIES_XPATH"))).getText();
		logger.info("Here is the header text : " + getheader);
		WebElement webElement = context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CATEGORIES_XPATH")));
		assertEquals(webElement.getText(),AskanexpertXpathLocators.datalocators.get("CATEGORIES_TEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("GENERALDIY_XAPTH"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("GENERALDIY_XAPTH"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_GENERALDIY"))));
		webElement = context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_GENERALDIY")));
		assertEquals(webElement.getText(), AskanexpertXpathLocators.datalocators.get("HEADER_GENERALDIYTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("BUILDER_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("BUILDER_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_BUILDER"))));
		webElement = context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_BUILDER")));
		assertEquals(webElement.getText(), AskanexpertXpathLocators.datalocators.get("HEADER_BUILDERTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("DRINAGE_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("DRINAGE_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_DRINAGE"))));
		webElement = context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_DRINAGE")));
		assertEquals(webElement.getText(), AskanexpertXpathLocators.datalocators.get("HEADER_DRINAGETEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEATINGENGINEERS_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEATINGENGINEERS_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_HEATINGENGINEER"))));
		webElement = context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_HEATINGENGINEER")));
		assertEquals(webElement.getText(), AskanexpertXpathLocators.datalocators.get("HEADER_HEATINGENGINEERTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("PAINTERS_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("PAINTERS_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_PAINTER"))));
		webElement = context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_PAINTER")));
		assertEquals(webElement.getText(), AskanexpertXpathLocators.datalocators.get("HEADER_PAINTERTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("SECURITY_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("SECURITY_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_SECURITY"))));
		webElement = context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_SECURITY")));
		assertEquals(webElement.getText(), AskanexpertXpathLocators.datalocators.get("HEADER_SECURITYTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("TILERS_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("TILERS_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_TILER"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_TILER"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_TILERTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("AERIALNETWORK_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("AERIALNETWORK_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_AERIALNETWORK"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_AERIALNETWORK"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_AERIALNETWORKTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CARPENTERS_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CARPENTERS_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_CARPENTERS"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_CARPENTERS"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_CARPENTERSTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("ELECTRICIAN_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("ELECTRICIAN_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_ELECTRICIAN"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_ELECTRICIAN"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_ELECTRICIANTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("KITCHEN_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("KITCHEN_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_KITCHEN"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_KITCHEN"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_KITCHENTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("PLASTERERS_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("PLASTERERS_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_PLASTERERS"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_PLASTERERS"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_PLASTERERSTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("SPECIALISTSERVICES_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("SPECIALISTSERVICES_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_SPECIALISTSERVICES"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_SPECIALISTSERVICES"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_SPECIALISTSERVICESTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CRAFTSMEN_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CRAFTSMEN_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_CRAFTSMEN"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_CRAFTSMEN"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_CRAFTSMENTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("BATHROOM_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("BATHROOM_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_BATHROOM"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_BATHROOM"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_BATHROOMTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLEANERS_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLEANERS_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_CLEANERS"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_CLEANERS"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_CLEANERSTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("FLOORINGSPECIALISTS_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("FLOORINGSPECIALISTS_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_FLOORINGSPECIALISTS"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_FLOORINGSPECIALISTS"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_FLOORINGSPECIALISTSTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("LOFTCONVERSION_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("LOFTCONVERSION_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_LOFTCONVERSION"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_LOFTCONVERSION"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_LOFTCONVERSIONTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("PLUMBERS_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("PLUMBERS_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_PLUMBERS"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_PLUMBERS"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_PLUMBERSTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("STONEWORKERS_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("STONEWORKERS_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_STONEWORKERS"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_STONEWORKERS"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_STONEWORKERSTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("WINDOW_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("WINDOW_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_WINDOW"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_WINDOW"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_WINDOWTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("BRICKLAYERS_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("BRICKLAYERS_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_BRICKLAYERS"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_BRICKLAYERS"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_BRICKLAYERSTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("DAMPANDWATERPROOFING_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("DAMPANDWATERPROOFING_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_DAMPANDWATERPROOFING"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_DAMPANDWATERPROOFING"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_DAMPANDWATERPROOFINGTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("GARDENERS_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("GARDENERS_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_GARDENERS"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_GARDENERS"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_GARDENERSTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("GMETALWORKERS_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("GMETALWORKERS_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_METALWORKERS"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_METALWORKERS"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_METALWORKERSTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("ROOFERS_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("ROOFERS_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_ROFFERS"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_ROFFERS"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_ROFFERSTEXT"));
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("ROOFERS_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("SWIMMINGPOOL_LINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_SWIMMINGPOOL"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADER_SWIMMINGPOOL"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADER_SWIMMINGPOOLTEXT"));
	}

	@Test(enabled = true)
	public void AssertAskAnExpertpage() throws Exception {

		underTest.getdiypage();
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HOWITWORKSXPATH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HOWITWORKSXPATHTEXT"));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("TEXTUNDERHOWITWORKS_XPATH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("TEXTUNDERHOWITWORKS_XPATHTEXT"));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("EXPERTS_XPATH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("EXPERTS_XPATHTEXT"));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("POSTYOURJOB_XPATH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("POSTYOURJOB_XPATHTEXT"));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CONTACTUS_XPATH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("CONTACTUS_XPATHTEXT"));
		WebDriverWait waitForPageToLoad = new WebDriverWait(context.driver, 10);
		waitForPageToLoad
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div/div/div[1]/section/article[1]/blockquote/footer/a")));
		context.driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/section/article[1]/blockquote/footer/a")).getText().contains("answer");
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKONCONTACTUS_LINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKONCONTACTUS_LINK"))).click();
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CUSTOMERSERVICE_XPATH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("CUSTOMERSERVICE_XPATHTEXT"));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HOWITWORKSINNEXTPAGE_XPATH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HOWITWORKSINNEXTPAGE_XPATHTEXT"));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("COMPLAINTS_XPATH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("COMPLAINTS_XPATHTEXT"));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("FREQUENTLYASKEDQUESTION_XAPTH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("FREQUENTLYASKEDQUESTION_XAPTHTEXT"));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADOFFICE_XPATH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("HEADOFFICE_XPATHTEXT"));

	}

	@Test(enabled = true)
	public void testNoOfQuestionsInTheEachPage() throws Exception {

		underTest.testNoOfQuestionsInThePage1();
		underTest.testNoOfQuestionsInThePage2();
		underTest.testNoOfQuestionsInThePage3();
		underTest.testNoOfQuestionsInThePage4();
		underTest.testNoOfQuestionsInThePage5();
	}

	@Test(enabled = true)
	public void TwoTradesmenAnsweringTheQuestion() throws Exception {

		underTest.getdiypage();
		underTest.fillinQuestionnaire(PLUMBER);
		WebDriverWait waitForPageToLoad = new WebDriverWait(context.driver, 10);
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("LOGIN_TAB"))));		
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("LOGIN_TAB"))).click();
		
		underTest.fillInTheTradesmenUsernameAndPassword(FIRSTTRADESMEN, password, FIRSTTRADESMENTEXT);
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKON_SITELOGO"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKON_SITELOGO"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICK_ON_LOGINLINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICK_ON_LOGINLINK"))).click();
		
		underTest.fillInTheTradesmenUsernameAndPassword(SECONDTRADESMEN, password, SECONDTRADESMENTEXT);
		underTest.getdiypage();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("FIRST_ANSWERSLINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("FIRST_ANSWERSLINK"))).click();

		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("MOSTRECENTLY_ANSWEREDXPATH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("MOSTRECENTLY_ANSWEREDXPATHTEXT"));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("SECONDMOSTRECENTLY_ANSWEREDXPATH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("SECONDMOSTRECENTLY_ANSWEREDXPATHTEXT"));

	}

	@Test(enabled = true)
	public void MostRecentlyPostedAnswer() throws Exception {

		underTest.getdiypage();
		underTest.fillinQuestionnaire(ROOFER);
		WebDriverWait waitForPageToLoad = new WebDriverWait(context.driver, 10);
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("LOGIN_TAB"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("LOGIN_TAB"))).click();
		underTest.MostRecentlyPostedAnswer(FIRSTTRADESMEN, password, FIRSTTRADESMENTEXT);

		underTest.getdiypage();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("FIRST_ANSWERSLINK"))));
		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("FIRST_ANSWERSLINK"))).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADERQUESTION_XPATH"))));
		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("HEADERQUESTION_XPATH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("searchText"));

		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("MOSTRECENTLY_ANSWEREDXPATH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("response_text5"));

		String headerText = context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("MOSTRECENTLY_ANSWEREDXPATH"))).getText();
		System.out.println(headerText);

	}

	@Test(enabled = true)
	public void VoteTheAnswer() throws Exception {

		underTest.getdiypage();
		underTest.VotedAnswersList();

		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("POSTEDBY_NEXTRADESMEN"))).getText(),
				AskanexpertXpathLocators.datalocators.get("POSTEDBY_NEXTRADESMENTEXT"));

		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("POSTEDBY_RECENTTRADESMEN"))).getText(),
				AskanexpertXpathLocators.datalocators.get("POSTEDBY_RECENTTRADESMENTEXT"));

		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("FSHARE_XPATH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("FSHARE_XPATHTEXT"));

		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("TWEETSHARE_XPATH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("TWEETSHARE_XPATHTEXT"));

		assertEquals(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("GOOGLESHARE_XPATH"))).getText(),
				AskanexpertXpathLocators.datalocators.get("GOOGLESHARE_XPATHTEXT"));

	}

	@Test(enabled = true)
	public void MostRecentlyVotedAnswerOnTheTop() throws Exception {

		underTest.getdiypage();
		underTest.DisplayMostRecentlyVoted();
		WebDriverWait waitForPageToLoad = new WebDriverWait(context.driver, 10);
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ask an expert")));
		context.driver.findElement(By.linkText("Ask an expert")).click();
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("FIRST_ANSWERSLINK"))));

		context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("FIRST_ANSWERSLINK"))).click();
		
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AskanexpertXpathLocators.xpathlocators.get("MOSTRECENTLY_ANSWEREDXPATH"))));
		WebElement mostRecentlyAnswered = context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("MOSTRECENTLY_ANSWEREDXPATH")));
		assertEquals(mostRecentlyAnswered.getText(), AskanexpertXpathLocators.datalocators.get("response_text4"));
	}

}
