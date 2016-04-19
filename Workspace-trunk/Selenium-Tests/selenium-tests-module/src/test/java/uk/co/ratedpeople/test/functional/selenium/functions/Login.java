package uk.co.ratedpeople.test.functional.selenium.functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.httpclient.support.WebSiteCredentials;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class Login {
	private TestScriptUtilities scriptUtils;
	private String testUrl;
	private String supportUrl;
	private WebDriver driver;
	
	public Login(TestScriptUtilities scriptUtils, SeleniumTestContext context) {
		this.scriptUtils = scriptUtils;
		this.testUrl = context.getTestUrl();
		this.supportUrl = context.getSupportUrl();
		this.driver = context.driver;
	}

	public void login(WebSiteCredentials credentials) throws Exception {
		loginAdmin(credentials.getUserName(), credentials.getPassword());
	}
	
	public void loginJbilling(String usernamexpath,String username,String passwordxpath ,String password,String loginxpath) throws Exception{
		scriptUtils.fillInTextField(usernamexpath, username);
		scriptUtils.fillInTextField(passwordxpath, password);
		scriptUtils.clickandwait(By.xpath(loginxpath));
	}

	public void loginSupport(WebSiteCredentials credentials) throws Exception {
		loginSupport(credentials.getUserName(), credentials.getPassword());
	}

	public void login(String username, String password) throws Exception {
		logoutAdmin();

		scriptUtils.goTo(testUrl + "/log-in");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 50);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hoUserName")));		
		scriptUtils.fillInTextField("hoUserName", username);
		scriptUtils.fillInTextField("hoPassword", password);
		scriptUtils.click("login-as-ho-button");
	}

	public void loginTP(String TPusername, String TPpassword) {
//		logoutAdmin();
		scriptUtils.goTo(testUrl);
		scriptUtils.goTo(testUrl + "/log-in");
		scriptUtils.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 50);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tpUserName")));
		scriptUtils.fillInTextField("tpUserName", TPusername);
		scriptUtils.fillInTextField("tpPassword", TPpassword);
		scriptUtils.click("login-as-tp-button");
	
	}

	public void loginAdmin(String username, String password) throws Exception {

		this.loginSupport(username, password);

		//goTo(context.getTestUrl() + "/admin/showProperties");
	}

	public void loginSupport(String username, String password) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 50);
//		logoutAdmin();

		scriptUtils.goTo(supportUrl + "/support");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
		scriptUtils.clear(By.id("userName"));
		scriptUtils.fillInTextField("userName", username);
		scriptUtils.clear(By.id("password"));
		scriptUtils.fillInTextField("password", password);
		Thread.sleep(2000);
		scriptUtils.click("btn-log-in");
	}

	
	public void loginTM(String usernameXpath,String username,String pwdXpath,String password,String loginxpath){
		scriptUtils.fillInTextField(usernameXpath, username);
		scriptUtils.fillInTextField(pwdXpath, password);
		scriptUtils.click(By.xpath(loginxpath));
	}
	
	public void logoutAdmin() {
		scriptUtils.goTo(supportUrl + "/logout");
	}

}
