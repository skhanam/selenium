package uk.co.ratedpeople.test.functional.selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.Clock;
import uk.co.ratedpeople.test.functional.SystemClock;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;

/**
 * Provides script-like lower-level methods for Selenium functional tests.
 * 
 * May be instructed to use a bespoke retry strategy, in which failing element-finding operations are retried at intervals. Otherwise, uses the native WebDriver
 * strategy for element-finding operations.
 * 
 * Intentionally not a test class in itself (e.g. no Before/AfterClass methods) so that it can be used as superclass or by composition.
 */
public class TestScriptUtilities {
	private static final String TRADE_SELECT_ELEMENT_ID = "trade";
	private static final String JOBTYPE_ELEMENT_ID = "jobtype";
	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities");
	private static final long NATIVE_WEB_DRIVER_TIMEOUT = 10000;

	/**
	 * Each sleep() call will wait this time on top of whatever is asked.
	 * 
	 * Useful when the Fibre connection goes down...
	 */
	private static final long MASTER_SLEEP_BASE = 0;

	/**
	 * Default interval in milliseconds between retries of timing-sensitive operations, when bespoke retry strategy is used
	 */
	private static long DEFAULT_RETRY_INTERVAL = 500;

	/**
	 * Default period in milliseconds during which retries of timing-sensitive operations may be made and after which we give up, when bespoke retry strategy is
	 * used
	 */
	public static long DEFAULT_TIMEOUT = 20 * 1000;

	protected final SeleniumTestContext context;

	private boolean retryModeOn;
	private final Clock clock;
	private final RetryingRunner retryingRunner;

	/**
	 * Constructs a TestScript with bespoke retry strategy turned off.
	 */
	public TestScriptUtilities(SeleniumTestContext context) {
		this(context, false);
	}

	/**
	 * Constructs a TestScript.
	 * 
	 * @param retryModeOn
	 *            true if this script should start up with retry mode on
	 */
	public TestScriptUtilities(SeleniumTestContext context, boolean retryModeOn) {
		this.context = context;
		this.retryModeOn = retryModeOn;

		clock = new SystemClock();
		retryingRunner = new RetryingRunner(DEFAULT_RETRY_INTERVAL);
	}

	private void setNativeWebDriverTimeout(long timeout) {
		context.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.MILLISECONDS);
	}

	public void goTo(String url) {
		context.driver.get(url);
	}

	/**
	 * Returns matching element or null if there's no match
	 */
	public WebElement getElementIfExists(By matching) {
		setNativeWebDriverTimeout(1);

		try {
			return context.driver.findElement(matching);
		} catch (NoSuchElementException e) {
			return null;
		} finally {
			setNativeWebDriverTimeout(NATIVE_WEB_DRIVER_TIMEOUT);
		}
	}

	public void clickIfExists(By matching) {
		WebElement logoutLink = getElementIfExists(matching);

		if (logoutLink != null) {
			logoutLink.click();
		}
	}

	public WebElement click(final By findingBy) {
		WebElement element = findElement(findingBy);
		element.click();
		return element;
	}

	public WebElement clear(final By findingBy) {
		WebElement element = findElement(findingBy);
		element.clear();
		return element;
	}

	public void click(final String id) {
		findElement(By.id(id)).click();
	}

	public boolean checkDisabled(final By find) {
		WebElement element = findElement(find);
		boolean status = true;
		if (element.isEnabled() != true) {
			status = false;
			logger.info("You are here within the if block of the ");
		}
		return status;
	}

	public void clickXpath(final String xpath) {
		findElement(By.xpath(xpath)).click();
	}

	public void select(final By findingBy) {
		findElement(findingBy).click();
	}

	public void fillInTextField(final String id, final String text) {
		findElement(By.id(id)).sendKeys(text);
	}

	public void fillInXpathField(final String xpath, final String text) {
		findElement(By.xpath(xpath)).sendKeys(text);
	}
	public void clearAndFillInIdField(final String id, final String text) {
		WebElement webElement = findElement(By.id(id));
		webElement.clear();
		webElement.sendKeys(text);
	}
	public void clearAndFillInXpathField(final String xpath, final String text) {
		WebElement webElement = findElement(By.xpath(xpath));
		webElement.clear();
		webElement.sendKeys(text);
	}

	public void selectDropdown(final String id, final int index) {
		selectFirstByIndex(getSelect(By.id(id)), index);
	}

	public void selectDropdown(final By findingBy, final int index) {
		WebDriverWait wait = new WebDriverWait(context.driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(findingBy));
		selectFirstByIndex(getSelect(findingBy), index);
	}

	
	/**
	 * The implementation of Select.selectByIndex continues to iterate through it's options after a match has been found. Normally this is OK but if a JS
	 * onchange() event fires which changes the URL the dropdown disappears and it then complains about a bad cache.
	 * 
	 * @param select
	 * @param index
	 */
	private void selectFirstByIndex(Select select, int index) {
		String match = String.valueOf(index);

		boolean matched = false;
		for (WebElement option : select.getOptions()) {
			if (match.equals(option.getAttribute("index"))) {
				option.click();
				if (!select.isMultiple()) {
					return;
				}
				matched = true;
				break; // !!
			}
		}
		if (!matched) {
			throw new NoSuchElementException("Cannot locate option with index: " + index);
		}
	}

	public void clickDropdown(By matching, int index) {
		WebElement option = findElement(matching).findElement(By.xpath("option[" + index + "]"));
		option.click();
		option.click();
	}

	/*
	 * Generate a Random Alphanumeric string of any size required by user
	 */

	@SuppressWarnings("static-access")
	public static String getRandomString(int length) {
		RandomStringUtils generateString = new RandomStringUtils();
		String randomString = generateString.randomAlphanumeric(length);
		System.out.println("Random String generated :" + randomString);
		return randomString;
	}

	@SuppressWarnings("static-access")
	public static String getRandomAlphabeticString(int length) {
		RandomStringUtils generateString = new RandomStringUtils();
		String randomString = generateString.randomAlphabetic(length);
		System.out.println("Random String generated :" + randomString);
		return randomString;
	}

	/*
	 * Generate a random number
	 */
	public static int getRandomNumber(int somenumber) {
		Random randomno = new Random();
		int randomNumber = randomno.nextInt(somenumber) + 1;
		logger.info("Random Number generated : " + randomNumber);
		return randomNumber;
	}

	/*
	 * Generate a random 6 digit phone number
	 */
	public static int getRandom6digitNumber() {
		Random randomGenerator = new Random();
		//int randomInt = randomGenerator.nextInt(1000000);
		int randomInt = randomGenerator.nextInt(999999 - 100000) + 100000;
		logger.info("Random 6 digit number generated : " + randomInt);
		return randomInt;

	}

	public static int getRandomNumberGreaterThanfifty(int someNumber) {
		Random randomno = new Random();
		int randomNumber = randomno.nextInt(someNumber) + 1 - 49;
		logger.info("Random Number generated : " + randomNumber);
		return randomNumber;
	}

	/**
	 * Accepts a confirm dialogue, retrying according to bespoke retry strategy if dialogue is not available
	 */
	public void confirmWithRetry() {
		DialogueAccepter dialogueAccepter = new DialogueAccepter(context.driver);
		retryingRunner.run(new RetryableRunnable(dialogueAccepter, clock, DEFAULT_TIMEOUT));
	}

	public void setRetryModeOn(boolean retryModeOn) {
		this.retryModeOn = retryModeOn;
	}

	public void clickandwait(final By matching) {
		WebElementFinder webElementFinder = new WebElementFinder(context.driver, matching);
		retryingRunner.run(new RetryableRunnable(webElementFinder, clock, DEFAULT_TIMEOUT));
	}

	public void sleep(long interval) {
		try {
			Thread.sleep(MASTER_SLEEP_BASE + interval);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public WebElement findElement(final By matching) {
		if (retryModeOn) {
			WebElementFinder webElementFinder = new WebElementFinder(context.driver, matching);
			retryingRunner.run(new RetryableRunnable(webElementFinder, clock, DEFAULT_TIMEOUT));

			return webElementFinder.value;
		} else {
			return context.driver.findElement(matching);
		}
	}

	private Select getSelect(By matching) {
		return new Select(findElement(matching));
	}

	public void getLocalPage(String testUrl) throws InterruptedException {
		goTo(testUrl + "/local/");

	}

	public void getJobDetailsPage(String testUrl) throws InterruptedException {
		goTo(testUrl + "/local/job/164970");
	}

	public void getQuotes(String testUrl, WebDriver driver, String jobTypeId, String tradeCode) throws InterruptedException {
		this.getQuotes(TRADE_SELECT_ELEMENT_ID, JOBTYPE_ELEMENT_ID, "btn-next-step", testUrl, driver, jobTypeId, tradeCode);
	}

	// this method is used for the jobform on the result local pages
	public void getQuotesForLocal(String testUrl, WebDriver driver, String jobTypeId, String tradeCode) throws InterruptedException {
		this.getQuotes("jobFormTrade", "jobFormJobType", "_btn_next_step", testUrl, driver, jobTypeId, tradeCode);	}
	
	private void getQuotes(String htmlElementIdForTrade, String htmlElementIdForJobType, String htmlElementIdForSubmitButton, String testUrl, WebDriver driver, String jobTypeId, String tradeCode) throws InterruptedException {
		goTo(testUrl);
		WebDriverWait waitfortrade = new WebDriverWait(driver, 10);
		By byvaluetrade = By.cssSelector("#" + htmlElementIdForTrade + " > option[value='" + tradeCode + "']");
		waitfortrade.until(ExpectedConditions.presenceOfElementLocated(byvaluetrade));

		Thread.sleep(2000);

		Select jobTypeSelect = new Select(driver.findElement(By.id(htmlElementIdForTrade)));
		jobTypeSelect.selectByValue(tradeCode);

		// wait a bit to give a chance for the AJAX call to populate the skill drop-down
		// and for us to select option 58 - Plumbing Repair & Maintenance
		WebDriverWait wait = new WebDriverWait(driver, 10);
		By byValue = By.cssSelector("#" + htmlElementIdForJobType + " > option[value='" + jobTypeId + "']");
		wait.until(ExpectedConditions.presenceOfElementLocated(byValue));

		Select tradeCodeSelect = new Select(driver.findElement(By.id(htmlElementIdForJobType)));
		tradeCodeSelect.selectByValue(jobTypeId);

		click(htmlElementIdForSubmitButton);
	}

	public void clickPlusIcon(String path, String value, int times) {

		List<WebElement> getoptionsOwner = context.driver.findElements(By.xpath(path));
		String completePath;
		int countOfLiOwner = getoptionsOwner.size();
		logger.info("Count of links are: " + countOfLiOwner);
		// Iterator<WebElement> it = getoptionsOwner.iterator();
		for (int position = 1; position <= countOfLiOwner; position++) {
			completePath = path + "[" + (position) + "]/label";
			String text = (context.driver.findElement(By.xpath(completePath))).getAttribute("innerHTML");
			logger.info("Here is the text : " + text);
			if (value.equalsIgnoreCase(text)) {
				completePath = path + "[" + (position) + "]/a[2]";
				logger.info("Complete path : " + completePath);
				for (int i = 0; i < times; i++) {
					logger.info("Complete path 2 : " + completePath);
					click(By.xpath(completePath));
				}
			}
		}
	}

	public void clickPlusIcon(String path, int times) {
		for (int i = 0; i < times; i++) {
			click(By.xpath(path));
		}

	}

	public void clickMinusIcon(String path, String value, int times) {

		List<WebElement> getoptionsOwner = context.driver.findElements(By.xpath(path));
		String completePath;
		int getcountofliOwner = getoptionsOwner.size();
		logger.info("Count of links are: " + getcountofliOwner);
		int position = 1;
		Iterator<WebElement> it = getoptionsOwner.iterator();
		while (it.hasNext()) {
			completePath = path + "[" + position + "]/label";
			String text = (context.driver.findElement(By.xpath(completePath))).getAttribute("innerHTML");
			if (value.equalsIgnoreCase(text)) {
				completePath = path + "[" + position + "]/a[1]";
				for (int i = 0; i < times; i++) {
					click(By.xpath(path));
				}
			}

			position++;
		}
	}

	public void checkAndSelectRadioByOption(String path, String optionValue) {
		List<WebElement> getoptionsOwner = context.driver.findElements(By.xpath(path));
		String completePath;
		int getcountofliOwner = getoptionsOwner.size();
		logger.info("Count of links are: " + getcountofliOwner);
		int position = 1;
		for (WebElement option : getoptionsOwner) {

			if (optionValue.equals(option.getText())) {
				completePath = path + "[" + position + "]/input";
				context.driver.findElement(By.xpath(completePath)).click();
				if (optionValue.equalsIgnoreCase("Other")) {
					position++;
					completePath = path + "[" + position + "]/textarea";
					fillInXpathField(completePath, "new option");
					break;
				}
			}
			position++;
		}
	}

	public void checkAndSelectRadioForOptionOfTypeOther(String path, boolean fillTextIfOptionIsOther) {
		List<WebElement> getoptionsOwner = context.driver.findElements(By.xpath(path));
		String completePath;
		int getcountofliOwner = getoptionsOwner.size();
		logger.info("Count of links are: " + getcountofliOwner);
		int position = 1;
		for (WebElement option : getoptionsOwner) {
			if ("Other".equalsIgnoreCase(option.getText())) {
				completePath = path + "[" + position + "]/input";
				context.driver.findElement(By.xpath(completePath)).click();
				completePath = path + "[" + position + "]/textarea";
				if (fillTextIfOptionIsOther) {
					fillInXpathField(completePath, "new option");
				}
				break;
			}
			position++;
		}
	}

	public void checkAndSelectRadioByIndex(String path, int index) {
		List<WebElement> getoptionsOwner = context.driver.findElements(By.xpath(path));

		int getcountofliOwner = getoptionsOwner.size();
		logger.info("Count of links are : " + getcountofliOwner);
		int position = 0;
		for (WebElement option : getoptionsOwner) {
			if (position == index) {
				option.click();
			}
			position++;
		}
	}

	public void checkAndSelectDropDownByOption(String path, String optionValue) {
		WebElement webelement = context.driver.findElement(By.xpath(path));

		Select droplist = new Select(webelement);
		logger.info("Count of links are : " + droplist.getOptions().size());
		droplist.selectByVisibleText(optionValue);

	}
	
	public void checkAndSelectDropDownById(String path, String optionValue) {
		WebElement webelement = context.driver.findElement(By.id(path));

		Select droplist = new Select(webelement);
		logger.info("Count of links are : " + droplist.getOptions().size());
		droplist.selectByVisibleText(optionValue);

	}
	

	public void checkAndSelectDropDownByIndex(String path, int index) {
		List<WebElement> getoptionsOwner = context.driver.findElements(By.xpath(path));
		int getcountofliOwner = getoptionsOwner.size();
		logger.info("Count of links are : " + getcountofliOwner);

		for (WebElement option : getoptionsOwner) {
			Select droplist = new Select(option);
			droplist.selectByIndex(index);
		}
	}

	public void checkAndSelectDropDownByValue(String path, String value) {
		WebElement webelement = context.driver.findElement(By.xpath(path));

		Select droplist = new Select(webelement);
		logger.info("Count of links are : " + droplist.getOptions().size());
		droplist.selectByValue(value);

	}

	public String getValue(String xpath) {
		WebDriverWait waitForButton = new WebDriverWait(context.driver, 10);
		waitForButton.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		WebElement webelement = context.driver.findElement(By.xpath(xpath));
		String getBuyContent1 = webelement.getText();
		return getBuyContent1;
	}
	
	public String getTitle(){
		String title = context.driver.getTitle();
		return title;
	}

	public void getParentWindow() {
		String pWindow = context.driver.getWindowHandle();
		logger.info("Here is the CurrentWindow  :" + pWindow);
		String getTitle = context.driver.getTitle();
		logger.info(" Window Title : " + getTitle);
	}

	public String getCurrentWindow() {
		Set<String> allWindows = context.driver.getWindowHandles();
		for (String curWindow : allWindows) {
			context.driver.switchTo().window(curWindow);
			logger.info("Here is the CurrentWindow  :" + curWindow);
		}
		String getTitle = context.driver.getTitle();
		logger.info("Current Window Title : " + getTitle);
		return getTitle;
	}

}