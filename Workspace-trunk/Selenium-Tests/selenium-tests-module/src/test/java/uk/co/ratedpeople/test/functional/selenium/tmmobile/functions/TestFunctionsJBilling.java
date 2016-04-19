package uk.co.ratedpeople.test.functional.selenium.tmmobile.functions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.LoginToJBilling;

public class TestFunctionsJBilling {

	private WebDriver driver;

	public TestFunctionsJBilling(WebDriver webDriver) {
		driver = webDriver;
	}

	// required for initial release testing
	public void setAccountBalance(final SeleniumTestContext testContext, final Integer jBillingUserId, final BigDecimal specialCredit, final BigDecimal freeBalance,
			final BigDecimal creditLimit) throws Exception {

		this.loginToJBillingAndEditUser(testContext, jBillingUserId);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement freeBalanceField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contactField.10")));
			
		assertNotNull(freeBalanceField);
				
		freeBalanceField.clear();
		freeBalanceField.sendKeys(freeBalance.toString());

		WebElement specialCreditField = driver.findElement(By.id("contactField.101"));
		specialCreditField.clear();
		specialCreditField.sendKeys(specialCredit.toString());

		WebElement creditLimitField = driver.findElement(By.id("user.creditLimitAsDecimal"));
		creditLimitField.clear();
		creditLimitField.sendKeys(creditLimit.toString());

		saveUserEditChanges(testContext,jBillingUserId);
	}

	// required for initial release testing
	public void removeAllCardsForTradesman(final SeleniumTestContext testContext, final Integer jBillingUserId) throws Exception {
		// there is no rest call to do this
		this.loginToJBillingAndEditUser(testContext, jBillingUserId);

		// this ensure that the credit card section is visible and that we do not get a Selenium's element is not visible exception
		((JavascriptExecutor) driver)
				.executeScript("var divs = document.getElementsByClassName('box-card-hold'); for(var i=0; i<divs.length; i++) { divs[i].style.display='block' }");

		// the delete button will not be displayed if there is no card - if there is no card, we have nothing to do
		List<WebElement> webElements = driver.findElements(By.cssSelector("a.submit.delete > span"));

		if (webElements.size() != 1) {
			WebElement creditCardField = driver.findElement(By.id("creditCard.number"));

			String trimmedCreditCardNumber = creditCardField.getText().trim();

			if (!"".equals(trimmedCreditCardNumber)) {
				fail("Unable to delete credit card");
			}
		} else {
			WebElement deleteCardButton = webElements.get(0);

			deleteCardButton.click();

			Thread.sleep(2000);

			saveUserEditChanges(testContext,jBillingUserId);
		}
	}

	// required for initial release testing
	public void addCardForTradesman(final SeleniumTestContext testContext, final Integer jBillingUserId, final String nameOnCard, final String cardNumber,
			final String expiryMonth, final Integer expiryYear, final Integer securityCode) throws Exception {
		// there is no rest call to do this unless one buys a job with a new card
		this.loginToJBillingAndEditUser(testContext, jBillingUserId);

		// this ensure that the credit card section is visible and that we do not get a Selenium's element is not visible exception
		((JavascriptExecutor) driver)
				.executeScript("var divs = document.getElementsByClassName('box-card-hold'); for(var i=0; i<divs.length; i++) { divs[i].style.display='block' }");

		WebElement creditCardNameField = driver.findElement(By.id("creditCard.name"));
		creditCardNameField.clear();
		creditCardNameField.sendKeys(nameOnCard);

		WebElement creditCardNumberField = driver.findElement(By.id("creditCard.number"));
		creditCardNumberField.clear();
		creditCardNumberField.sendKeys(cardNumber);

		WebElement creditCardExpiryMonthField = driver.findElement(By.id("expiryMonth"));
		creditCardExpiryMonthField.clear();
		creditCardExpiryMonthField.sendKeys(expiryMonth);

		WebElement creditCardExpiryYearField = driver.findElement(By.id("expiryYear"));
		creditCardExpiryYearField.clear();
		creditCardExpiryYearField.sendKeys(expiryYear.toString());

		WebElement creditCardSecurityCodeField = driver.findElement(By.id("creditCard.securityCode"));
		creditCardSecurityCodeField.clear();
		creditCardSecurityCodeField.sendKeys(securityCode.toString());

		saveUserEditChanges(testContext,jBillingUserId);
	}

	

	/**
	 * @param jBillingUserId
	 */
	private void saveUserEditChanges(final SeleniumTestContext testContext,final Integer jBillingUserId) throws Exception {
		
		String jbUrl = testContext.getJBillingUrl();
		
		System.out.println("JBilling Url is  ...  : " + jbUrl);		
		driver.findElement(By.partialLinkText("Save Changes")).click();

		Thread.sleep(5000);
        assertEquals(driver.getCurrentUrl(),jbUrl + "/jbilling/customer/list/" + jBillingUserId);
//		assertEquals(driver.getCurrentUrl(), LoginToJBilling.JBILLING_PREPROD_URL + "customer/list/" + jBillingUserId);
	}

	private void loginToJBillingAndEditUser(final SeleniumTestContext testContext, final Integer jBillingUserId) throws Exception {
		/*
		 * Set Account Balance £100 Set Account Balance to £1 Set Account Balance to £0 We cannot set an account balance directly. We can purchase jobs or give
		 * credit requests so as to affect the account balance though.
		 */
		LoginToJBilling loginToJBilling = new LoginToJBilling(testContext);
		loginToJBilling.login();

		loginToJBilling.goToEditUserPage(jBillingUserId);
		Thread.sleep(3000);
		// 23.01.2013 - Added clicking by "Edit Customer". Hopefully it will fix for Jenkins. Aleksandr
/*//		WebDriverWait wait = new WebDriverWait(driver, 50);
//		WebElement jBillingUserIdEditLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href^='/jbilling/customer/edit/" + jBillingUserId + "']")));
		WebElement jBillingUserIdEditLink = driver.findElement(By.cssSelector("a[href^='/jbilling/customer/edit/" + jBillingUserId + "']"));
		assertNotNull(jBillingUserIdEditLink);
	//	jBillingUserIdEditLink.click();
*/		driver.findElement(By.linkText("Edit Customer")).click();
		Thread.sleep(3000);
		
	}
	
	public void loginToJBillingAndEditUserStatus(final SeleniumTestContext testContext, final Integer jBillingUserId) throws Exception {
		
		LoginToJBilling loginToJBilling = new LoginToJBilling(testContext);
		loginToJBilling.login();

		loginToJBilling.goToEditUserPage(jBillingUserId);
		Thread.sleep(3000);		
		driver.findElement(By.linkText("Edit Customer")).click();
		Thread.sleep(2000);	
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user.statusId")));
		driver.findElement(By.id("user.statusId")).sendKeys("Overdue");
		Thread.sleep(1000);
		saveUserEditChanges(testContext,jBillingUserId);
	}
}
