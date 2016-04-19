package uk.co.ratedpeople.test.functional.selenium.tp.firstsecondthirdbuyandtimeintent;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class FirstSecondThirdBuyAndTimeIntent {
	private Login login;
	private TestScriptUtilities scriptUtils;
	private WebDriver driver;
		
	public FirstSecondThirdBuyAndTimeIntent(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		this.driver = context.driver;
		login = new Login(scriptUtils, context);
		}
	
	public void submitJobForFirstSecondThirdBuy() throws Exception {
			
		//driver.get("http://paris.uk.ratedpeople/");
         driver.get("http://preprod.preprod/");
		 Thread.sleep(3000);
		 WebDriverWait wait = new WebDriverWait(driver, 50);
		 new Select(driver.findElement(By.xpath("//*[@id='trade']"))).selectByVisibleText("Metalworker");
		 new Select(driver.findElement(By.xpath("//*[@id='jobtype']"))).selectByVisibleText("Security Grill");
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("method:submitSkillSpecificJob"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("statusREADY_TO_HIRE"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ownerOWN_AND_LIVE"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ownerOWN_AND_LIVE"))).click();
		 new Select(driver.findElement(By.xpath("//*[@id='timing']"))).selectByVisibleText("Urgently");
		 driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("NR13 3AA");
		 driver.findElement(By.xpath("//html/body/div/div[2]/div/div/div/div/div/div/form/section/div[5]/textarea")).sendKeys("Submit a job via selenium tests to test first buy, second buy and third buy. Submit a job via selenium tests to test first buy, second buy and third buy.");
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div/div[2]/div/div/div/div/div/div/form/section/div/p/label")));
		 new Select(driver.findElement(By.xpath("//*[@id='jobBudgetCode']"))).selectByVisibleText("Under £100");
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next"))).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("ruhulla");
		 driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("ho");
		 driver.findElement(By.xpath("//input[@id='mobilePhone']")).sendKeys("07412463662");
		 driver.findElement(By.xpath("//input[@id='confirmPhone']")).sendKeys("07412463662");
		 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ruhhomeowner@ratedtrades.com");
		 driver.findElement(By.xpath("//input[@id='confirmEmail']")).sendKeys("ruhhomeowner@ratedtrades.com");
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPostJob"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnConfirmJob"))).click();
		 Thread.sleep(8000);
		 assertEquals(driver.findElement(By.xpath(".//*[@id='header-h1']")).getText(),"Thank you");
				
	}

	public void firstBuy() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 30);
		login.loginTP("TMFirstBuy@ratedtrades.com", "password");
		/*scriptUtils.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='login_username']")).sendKeys("TMFirstBuy@ratedtrades.com");
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("password");
		scriptUtils.click(By.id("login__login"));*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS"))));
		assertEquals(driver.findElement(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("1st_2nd_3rd_TO_BUY"))).getText(),"Be 1st to buy!");
		scriptUtils.click(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FirstSecondThirdBuyXpathlocators.xpathLookup.get("BUY_BUTTON"))));
		scriptUtils.click(By.id(FirstSecondThirdBuyXpathlocators.xpathLookup.get("BUY_BUTTON")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("CONFIRM_BUTTON"))));
		scriptUtils.click(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("CONFIRM_BUTTON"))); // Confirm button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO"))));
		driver.findElement(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO")));
		scriptUtils.sleep(5000);
		driver.findElement(By.linkText("Purchased Jobs")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("VIEW_DETAILS_PURCHASED_JOB"))));
		scriptUtils.click(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("VIEW_DETAILS_PURCHASED_JOB")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("PURCHASE_COUNT"))));
		driver.findElement(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("PURCHASE_COUNT"))).equals(1);
		
	}
	public void SecondBuy() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		login.loginTP("TMSecondBuy@ratedtrades.com", "password");
		scriptUtils.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS"))));
		assertEquals(driver.findElement(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("1st_2nd_3rd_TO_BUY"))).getText(),"Be 2nd to buy.");
		scriptUtils.click(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FirstSecondThirdBuyXpathlocators.xpathLookup.get("BUY_BUTTON"))));
		scriptUtils.click(By.id(FirstSecondThirdBuyXpathlocators.xpathLookup.get("BUY_BUTTON")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("CONFIRM_BUTTON"))));
		scriptUtils.click(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("CONFIRM_BUTTON"))); // Confirm button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO"))));
		driver.findElement(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO")));
		Thread.sleep(5000);
		driver.findElement(By.linkText("Purchased Jobs")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("VIEW_DETAILS_PURCHASED_JOB"))));
		scriptUtils.click(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("VIEW_DETAILS_PURCHASED_JOB")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("PURCHASE_COUNT"))));
		driver.findElement(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("PURCHASE_COUNT"))).equals(2);
		}
	
	public void ThirdBuy() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		login.loginTP("TMThirdBuy@ratedtrades.com", "password");
		scriptUtils.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS"))));
		assertEquals(driver.findElement(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("1st_2nd_3rd_TO_BUY"))).getText(),"Be 3rd to buy.");
		scriptUtils.click(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FirstSecondThirdBuyXpathlocators.xpathLookup.get("BUY_BUTTON"))));
		scriptUtils.click(By.id(FirstSecondThirdBuyXpathlocators.xpathLookup.get("BUY_BUTTON")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("CONFIRM_BUTTON"))));
		scriptUtils.click(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("CONFIRM_BUTTON"))); // Confirm button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO"))));
		driver.findElement(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO")));
		Thread.sleep(5000);
		driver.findElement(By.linkText("Purchased Jobs")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("VIEW_DETAILS_PURCHASED_JOB"))));
		scriptUtils.click(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("VIEW_DETAILS_PURCHASED_JOB")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("PURCHASE_COUNT"))));
		driver.findElement(By.xpath(FirstSecondThirdBuyXpathlocators.xpathLookup.get("PURCHASE_COUNT"))).equals(3);
		}
			
	}
