package uk.co.ratedpeople.test.functional.selenium.ho.diy;

import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author shabana.khanam
 * 
 */

public class AskAnExpertQuestionQnA {

	public static Logger logger = Logger.getLogger(AskAnExpertQuestionQnA.class.getName());
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;

	private static final String TRADESMEN_USERNAME = "tpUserName";
	private static final String TRADESMEN_PASSWORD = "tpPassword";
	private static final String CLICK_ON_LOGIN = "login-as-tp-button";
	private static final String TADESMENLOGIN_ASKANEXPERTTAB = ".//*[@id='header-wrapper']/nav/ul/li[3]/a";
	private static final String TRADESMENLOGIN_FIRSTRESPOND = ".//*[@id='jobAlertsTable']/ol/li[2]/p[2]/a";
	private static final String RESPONSETOQUESTION_XPATH = ".//*[@id='tag_line']";
	private static final String TRADESMENMYRESPONSE_FIRSTRESPOND = ".//*[@id='jobAlertsTable']/ol/li[2]/p[2]/a";
	private static final String CLICKON_MYRESPONSE = ".//*[@id='answered-tab']";

	public AskAnExpertQuestionQnA(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
		this.driver = driver;
		this.testUrl = testUrl;
		this.scriptUtils = scriptUtils;
	}

	@SuppressWarnings("static-access")
	public void fillinQuestionnaire(String categoryId) throws Exception, NoSuchElementException {
		Thread.sleep(2000);
		scriptUtils.fillInXpathField(AskanexpertXpathLocators.xpathlocators.get("asknexpertsearch"), AskanexpertXpathLocators.datalocators.get("searchText"));
		WebElement askanExpertbtn = driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("askquestionbutn")));
		askanExpertbtn.click();
		scriptUtils.fillInXpathField(AskanexpertXpathLocators.xpathlocators.get("question"), AskanexpertXpathLocators.datalocators.get("searchText")
				+ scriptUtils.getRandomString(25));
		Select bycategory = new Select(driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("category"))));
		bycategory.selectByValue(categoryId);
		scriptUtils.fillInTextField(AskanexpertXpathLocators.xpathlocators.get("fname"), "fname" + AskanexpertXpathLocators.datalocators.get("name"));
		scriptUtils.fillInTextField(AskanexpertXpathLocators.xpathlocators.get("lname"), "lname" + AskanexpertXpathLocators.datalocators.get("name"));
		scriptUtils.fillInTextField(AskanexpertXpathLocators.xpathlocators.get("email"), "email" + scriptUtils.getRandomNumber(100) + "@ratedtrades.com");
		scriptUtils.click(AskanexpertXpathLocators.xpathlocators.get("askbtn"));
		Thread.sleep(2000);
	}

	public void getdiypage() throws Exception, NoSuchElementException {
		scriptUtils.goTo(testUrl);
		WebDriverWait waitforpagetoLoad = new WebDriverWait(driver, 10);
		waitforpagetoLoad.until(ExpectedConditions.elementToBeClickable(By.linkText("Ask an expert")));
		driver.findElement(By.linkText("Ask an expert")).click();
	}

	public void testNoOfQuestionsInThePage1() throws Exception {

		// Select all the questions from webpage page 1
		getdiypage();

		System.out.println("Select number of questions from webpage ");

		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(AskanexpertXpathLocators.xpathlocators.get("LISTOFELEMENTSXPATH"))));

		List<WebElement> numberofquestions = driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("LISTOFELEMENTSXPATH"))).findElements(
				By.tagName("article"));

		System.out.println("total no. questions available on webpage");
		System.out.println(numberofquestions.size());

		System.out.println("Text of the questions available on the webpage :");

		for (int i = 1; i <= 10; i++) {
			waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/div/div[1]/section/article[" + i + "]/h2/a")));
			String headerText = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/section/article[" + i + "]/h2/a")).getText();
			System.out.println(headerText);
		}

	}

	public void testNoOfQuestionsInThePage2() throws Exception {

		// Select all the questions from webpage page 2
		getdiypage();

		driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKONSECONDPAGE"))).click();

		System.out.println("Select number of questions from second webpage : ");

		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(AskanexpertXpathLocators.xpathlocators.get("LISTOFELEMENTSXPATH"))));
		
		List<WebElement> numberofquestions = driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("LISTOFELEMENTSXPATH"))).findElements(
				By.tagName("article"));

		System.out.println("total no. questions available on second webpage :");
		System.out.println(numberofquestions.size());

		System.out.println("Text of the questions available on the second webpage :");

		for (int i = 1; i <= 10; i++) {
			waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/div/div[1]/section/article[" + i + "]/h2/a")));
			String headerText = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/section/article[" + i + "]/h2/a")).getText();
			System.out.println(headerText);
		}

	}

	public void testNoOfQuestionsInThePage3() throws Exception {

		// Select all the questions from webpage page 3
		getdiypage();

		driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKONTHIRDPAGE"))).click();

		System.out.println("Select number of questions from THIRD webpage : ");

		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(AskanexpertXpathLocators.xpathlocators.get("LISTOFELEMENTSXPATH"))));
		
		List<WebElement> numberofquestions = driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("LISTOFELEMENTSXPATH"))).findElements(
				By.tagName("article"));

		System.out.println("total no. questions available on THIRD webpage :");
		System.out.println(numberofquestions.size());

		System.out.println("Text of the questions available on the THIRD webpage :");

		for (int i = 1; i <= 10; i++) {
			waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/div/div[1]/section/article[" + i + "]/h2/a")));
			String headerText = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/section/article[" + i + "]/h2/a")).getText();
			System.out.println(headerText);
		}

	}

	public void testNoOfQuestionsInThePage4() throws Exception {

		// Select all the questions from webpage page 4
		getdiypage();

		driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKONFOURTHPAGE"))).click();

		System.out.println("Select number of questions from FOURTH webpage : ");

		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(AskanexpertXpathLocators.xpathlocators.get("LISTOFELEMENTSXPATH"))));

		List<WebElement> numberofquestions = driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("LISTOFELEMENTSXPATH"))).findElements(
				By.tagName("article"));

		System.out.println("total no. questions available on FOURTH webpage :");
		System.out.println(numberofquestions.size());

		System.out.println("Text of the questions available on the FOURTH webpage :");

		for (int i = 1; i <= 10; i++) {
			waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/div/div[1]/section/article[" + i + "]/h2/a")));
			String headerText = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/section/article[" + i + "]/h2/a")).getText();
			System.out.println(headerText);
		}

	}

	public void testNoOfQuestionsInThePage5() throws Exception {

		// Select all the questions from webpage page 5
		getdiypage();

		driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKONFIFTHPAGE"))).click();

		System.out.println("Select number of questions from FIFTH webpage : ");

		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(AskanexpertXpathLocators.xpathlocators.get("LISTOFELEMENTSXPATH"))));

		List<WebElement> numberofquestions = driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("LISTOFELEMENTSXPATH"))).findElements(
				By.tagName("article"));

		System.out.println("total no. questions available on FIFTH webpage :");
		System.out.println(numberofquestions.size());

		System.out.println("Text of the questions available on the FIFTH webpage :");

		for (int i = 1; i <= 10; i++) {
			waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/div/div[1]/section/article[" + i + "]/h2/a")));
			String headerText = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/section/article[" + i + "]/h2/a")).getText();
			System.out.println(headerText);
		}

	}

	public void fillInTheTradesmenUsernameAndPassword(String username, String password, String response_text) {

		if (StringUtils.isNotBlank(username)) {
			scriptUtils.fillInTextField(TRADESMEN_USERNAME, username);
		}

		if (StringUtils.isNotBlank(password)) {
			scriptUtils.fillInTextField(TRADESMEN_PASSWORD, password);
		}

		scriptUtils.click(By.id(CLICK_ON_LOGIN));

		scriptUtils.sleep(2000);
		
	
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(TADESMENLOGIN_ASKANEXPERTTAB)));
		scriptUtils.click(By.xpath(TADESMENLOGIN_ASKANEXPERTTAB));

		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(TRADESMENLOGIN_FIRSTRESPOND)));
		scriptUtils.click(By.xpath(TRADESMENLOGIN_FIRSTRESPOND));

		if (StringUtils.isNotBlank(response_text)) {
			scriptUtils.fillInXpathField(RESPONSETOQUESTION_XPATH, response_text);
		}

		driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKON_RESPONDBUTTON"))).click();
		driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKON_LOGOUT"))).click();

	}

	public void MostRecentlyPostedAnswer(String username, String password, String response_text) {

		if (StringUtils.isNotBlank(username)) {
			scriptUtils.fillInTextField(TRADESMEN_USERNAME, username);
		}

		if (StringUtils.isNotBlank(password)) {
			scriptUtils.fillInTextField(TRADESMEN_PASSWORD, password);
		}

		scriptUtils.click(By.id(CLICK_ON_LOGIN));

		scriptUtils.sleep(2000);

		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(TADESMENLOGIN_ASKANEXPERTTAB)));
		scriptUtils.click(By.xpath(TADESMENLOGIN_ASKANEXPERTTAB));

		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(TRADESMENLOGIN_FIRSTRESPOND)));
		scriptUtils.click(By.xpath(TRADESMENLOGIN_FIRSTRESPOND));

		if (StringUtils.isNotBlank(response_text)) {
			scriptUtils.fillInXpathField(RESPONSETOQUESTION_XPATH, response_text);
		}

		driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKON_RESPONDBUTTON"))).click();
		scriptUtils.sleep(2000);

		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(CLICKON_MYRESPONSE)));
		scriptUtils.click(By.xpath(CLICKON_MYRESPONSE));
		
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(TRADESMENMYRESPONSE_FIRSTRESPOND)));
		scriptUtils.click(By.xpath(TRADESMENMYRESPONSE_FIRSTRESPOND));

		if (StringUtils.isNotBlank(response_text)) {
			scriptUtils.fillInXpathField(RESPONSETOQUESTION_XPATH, AskanexpertXpathLocators.datalocators.get("response_text1"));
			
		}

		driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKON_RESPONDBUTTON"))).click();
		scriptUtils.sleep(2000);

		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(CLICKON_MYRESPONSE)));
		scriptUtils.click(By.xpath(CLICKON_MYRESPONSE));
		
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(TRADESMENMYRESPONSE_FIRSTRESPOND)));
		scriptUtils.click(By.xpath(TRADESMENMYRESPONSE_FIRSTRESPOND));

		if (StringUtils.isNotBlank(response_text)) {
			scriptUtils.fillInXpathField(RESPONSETOQUESTION_XPATH, AskanexpertXpathLocators.datalocators.get("response_text2"));
		}

		driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKON_RESPONDBUTTON"))).click();
		scriptUtils.sleep(2000);

		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(CLICKON_MYRESPONSE)));
		scriptUtils.click(By.xpath(CLICKON_MYRESPONSE));
		
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(TRADESMENMYRESPONSE_FIRSTRESPOND)));
		scriptUtils.click(By.xpath(TRADESMENMYRESPONSE_FIRSTRESPOND));

		if (StringUtils.isNotBlank(response_text)) {
			scriptUtils.fillInXpathField(RESPONSETOQUESTION_XPATH, AskanexpertXpathLocators.datalocators.get("response_text3"));
		}

		driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKON_RESPONDBUTTON"))).click();
		scriptUtils.sleep(2000);

		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(CLICKON_MYRESPONSE)));
		scriptUtils.click(By.xpath(CLICKON_MYRESPONSE));
		
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(TRADESMENMYRESPONSE_FIRSTRESPOND)));
		scriptUtils.click(By.xpath(TRADESMENMYRESPONSE_FIRSTRESPOND));

		if (StringUtils.isNotBlank(response_text)) {
			scriptUtils.fillInXpathField(RESPONSETOQUESTION_XPATH, AskanexpertXpathLocators.datalocators.get("response_text4"));
		}

		driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKON_RESPONDBUTTON"))).click();
		scriptUtils.sleep(2000);

		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(CLICKON_MYRESPONSE)));
		scriptUtils.click(By.xpath(CLICKON_MYRESPONSE));
		
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(TRADESMENMYRESPONSE_FIRSTRESPOND)));
		scriptUtils.click(By.xpath(TRADESMENMYRESPONSE_FIRSTRESPOND));

		if (StringUtils.isNotBlank(response_text)) {
			scriptUtils.fillInXpathField(RESPONSETOQUESTION_XPATH, AskanexpertXpathLocators.datalocators.get("response_text5"));
		}

		driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKON_RESPONDBUTTON"))).click();

	}

	public void VotedAnswersList() throws Exception {

		WebElement firstAnswerLink = driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("FIRST_ANSWERSLINK")));
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(AskanexpertXpathLocators.xpathlocators.get("FIRST_ANSWERSLINK"))));
		firstAnswerLink.click();

		System.out.println("Select number of answers from webpage : ");

		List<WebElement> numberofanswers = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/section[2]")).findElements(By.tagName("article"));

		System.out.println("total no. answers available on  webpage :");
		System.out.println(numberofanswers.size());

		for (int i = 1; i <= numberofanswers.size(); i++) {
			String headerText = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/section[2]/article[" + i + "]/blockquote/p")).getText();
			System.out.println(headerText);

			for (int j = 1; j <= numberofanswers.size(); j++) {

				WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
				waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/div/div[1]/div/section[2]/article[" + j
						+ "]/div/span")));
				scriptUtils.click(By.xpath("html/body/div[2]/div/div/div[1]/div/section[2]/article[" + j + "]/div/span"));

			}
		}

	}

	public void DisplayMostRecentlyVoted() throws Exception {

		driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("FIRST_ANSWERSLINK"))).click();

		System.out.println("Select number of answers from webpage : ");

		
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/div/div[1]/div/section[2]")));
		
		List<WebElement> numberofanswers = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/section[2]")).findElements(By.tagName("article"));

		System.out.println("total no. answers available on  webpage :");
		System.out.println(numberofanswers.size());

		WebElement webElement = driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("VOTEBY_SECONDTRADESMEN")));
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(AskanexpertXpathLocators.xpathlocators.get("VOTEBY_SECONDTRADESMEN"))));
		webElement.click();

	}

}
