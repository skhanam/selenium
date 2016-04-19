package uk.co.ratedpeople.test.functional.selenium;

import org.openqa.selenium.WebDriver;

public class DialogueAccepter implements Runnable {
	private WebDriver driver;
	
	public DialogueAccepter(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void run() {
		accept();
	}

	public void accept() {
		driver.switchTo().alert().accept();
	}
}
