package uk.co.ratedpeople.test.functional.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uk.co.ratedpeople.test.functional.SimpleHolder;

/**
 * A Runnable which captures a WebDriver page element when run.
 */
public class WebElementFinder extends SimpleHolder<WebElement> implements Runnable {
	private WebDriver driver;
	private By matching;

	public WebElementFinder(WebDriver driver, By matching) {
		this.driver = driver;
		this.matching = matching;
	}

	@Override
	public void run() {
		value = driver.findElement(matching);
	}
}
