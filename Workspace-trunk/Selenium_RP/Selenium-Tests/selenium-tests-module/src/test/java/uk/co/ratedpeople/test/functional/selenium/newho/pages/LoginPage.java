package uk.co.ratedpeople.test.functional.selenium.newho.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage{

	public WebDriver driver;
	
		
    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "btn_login")
    WebElement loginBtn;

    public void navigateTo(WebDriver driver) {
    	  driver.get("http://homeowners.ratedpeople.com");
    }

	public LoginPage(WebDriver dr) {
		driver = dr;
	}
	
    public HomePage doLogin(String uname, String psswd) {
    	//driver.manage().deleteAllCookies();
    	username.sendKeys(uname);
    	password.sendKeys(psswd);
    	loginBtn.click();
        return PageFactory.initElements(driver, HomePage.class);
    }
  }