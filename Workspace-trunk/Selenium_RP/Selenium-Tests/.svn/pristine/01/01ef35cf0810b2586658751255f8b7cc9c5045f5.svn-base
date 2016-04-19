package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class LoginToJBilling extends TestScriptUtilities {

//	public static final String JBILLING_PREPROD_URL = "http://jbillingapi.preprod/jbilling/";
//	public static final String JBILLING_DEV3_URL = "http://devjbilling3.uk.ratedpeople:8084/jbilling/";
	private WebDriver driver;
	
	@SuppressWarnings("serial")
	public static Hashtable<String, String> xpathLookUp = new Hashtable<String, String>(){
		{
			put("usernameUi","j_username");
			put("passwordUi","j_password");
			put("remembermeUi","_spring_security_remember_me");
			put("submitUi","a.submit");
			
		}
	};
	
	
	@SuppressWarnings("serial")
	public static Hashtable<String , String> dataLookUp = new Hashtable<String, String>(){
		{
			put("username","admin");
			put("password","password");
		}
	};
	
	

	public LoginToJBilling(SeleniumTestContext context) {
		super(context);
		driver = context.driver;
	}

	public void login() throws Exception {
		driver.manage().deleteAllCookies();
		String getJB = context.getJBillingUrl();
		System.out.println("Here is the Jbilling URL formed :  " + getJB);
		goTo(getJB+"/jbilling");
		Thread.sleep(5000);
		// check if we are already logged in
		List<WebElement> logOutLinkList = driver.findElements(By.cssSelector("a[href^='/jbilling/logout/index']"));
		if (logOutLinkList != null && logOutLinkList.size() > 0) {
			return;
		}

		WebElement userNameField = driver.findElement(By.id(xpathLookUp.get("usernameUi")));
		userNameField.clear();
		userNameField.sendKeys(dataLookUp.get("username"));

		WebElement passwordField = driver.findElement(By.id(xpathLookUp.get("passwordUi")));
		passwordField.clear();
		passwordField.sendKeys(dataLookUp.get("password"));

		WebElement rememberMeCheckBox = driver.findElement(By.id(xpathLookUp.get("remembermeUi")));
		rememberMeCheckBox.click();

		WebElement loginButton = driver.findElement(By.cssSelector(xpathLookUp.get("submitUi")));
		loginButton.click();

		Thread.sleep(2000);
	}

	public void goToEditUserPage(final Integer jBillingUserId) {
		String getJBurl = context.getJBillingUrl();
//		goTo(JBILLING_PREPROD_URL + "customerInspector/inspect/" + jBillingUserId);
		System.out.println(getJBurl);
		
		goTo(getJBurl+"/jbilling/customerInspector/inspect/"+jBillingUserId);
		
	}
}
