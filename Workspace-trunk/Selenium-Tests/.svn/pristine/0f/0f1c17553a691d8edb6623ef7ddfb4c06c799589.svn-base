package uk.co.ratedpeople.test.functional.selenium.functions;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class BuyJob<IWebElement> {
	private Login login;
	private TestScriptUtilities scriptUtils;
	private WebDriver driver;
	private static String JOB_LEAD= "html/body/div[2]/header/div/div[2]/nav/ul/li[1]/a";
	private static String CONFIRM_BTN="//html/body/div/div/div[4]/aside/div[3]/form/p/a";

	public static Logger logger = Logger
			.getLogger("uk.co.ratedpeople.test.functional.selenium.coresystems");

	public BuyJob(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		this.driver = context.driver;
		login = new Login(scriptUtils, context);

	}

	public void buyLeadExistingCardNoBalance(String username) throws Exception {
		
        WebDriverWait wait = new WebDriverWait(driver, 30);
		System.out.println("Tradesman Email : sangitmtestuser@ratedtrades.com");
		login.loginTP(username, "password");
		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("html/body/div[2]/div/div[3]/div[3]/div[1]/div[2]/ol/li[2]/div/p[2]/a")));
		scriptUtils
				.click(By
						.xpath("html/body/div[2]/div/div[3]/div[3]/div[1]/div[2]/ol/li[2]/div/p[2]/a"));

		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("buy-btn")));
		driver.findElement(By.id("buy-btn")).click();
		scriptUtils.sleep(5000);
		scriptUtils.click(By
				.xpath("//html/body/div/div/div[4]/aside/div[3]/form/p/a"));// Confirm button
		
		scriptUtils.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[text()='Contact Info']")));
		driver.findElement(By.xpath("//*[text()='Contact Info']"));

}
	
	public void buyLead(String username) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		login.loginTP(username, "password");
		Thread.sleep(5000);
		scriptUtils.click(By.xpath(JOB_LEAD));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("html/body/div[2]/div/div[3]/div[3]/div[1]/div[2]/ol/li[2]/div/p[2]/a")));
		scriptUtils
				.click(By
						.xpath("html/body/div[2]/div/div[3]/div[3]/div[1]/div[2]/ol/li[2]/div/p[2]/a"));

		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("buy-btn")));
		driver.findElement(By.id("buy-btn")).click();
		scriptUtils.sleep(5000);
		scriptUtils.click(By
				.xpath(CONFIRM_BTN));// Confirm button
		
		scriptUtils.sleep(5000);
	}

	public void buyLeadNewCard(String username) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		login.loginTP(username, "password");
		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("html/body/div[2]/div/div[3]/div[3]/div[1]/div[2]/ol/li[2]/div/p[2]/a")));
		scriptUtils
				.click(By
						.xpath("html/body/div[2]/div/div[3]/div[3]/div[1]/div[2]/ol/li[2]/div/p[2]/a"));

		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("buy-btn")));
		driver.findElement(By.id("buy-btn")).click();
		scriptUtils.sleep(5000);
		scriptUtils
				.click(By
						.xpath("//html/body/div/div/div[4]/aside/div[3]/form/span/p[4]/a"));
		scriptUtils.sleep(4000);
		driver.findElement(By.name("name")).sendKeys("Test Tradesman");
		driver.findElement(By.name("cardNumber")).sendKeys("4929 0000 0000 6");
		scriptUtils.selectDropdown("purchase-enddate-month", 1);
		scriptUtils.selectDropdown("purchase-enddate-year", 3);
		driver.findElement(By.name("cv2")).sendKeys("123");

		scriptUtils.click(By
				.xpath("//html/body/div/div/div[4]/aside/div[3]/form/p/a"));
		scriptUtils.sleep(10000);
		driver.findElement(By.name("password")).sendKeys("password");
		scriptUtils.click(By.xpath("//input[@type='submit']"));
		scriptUtils.sleep(11000);
		driver.findElement(By.xpath("//*[text()='Contact Info']"));
	}

}
