package uk.co.ratedpeople.test.functional.selenium.newho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyDetailsPage {
	WebDriver driver;
	
	@FindBy(linkText="Update contact details")
	public WebElement updateContactButton;

	@FindBy(linkText="Change password")
	public WebElement changePasswordButton;
	
	@FindBy(id="Password_currentPassword")
	public WebElement currentPassword;
	
	@FindBy(id="Password_password_Enter_new_password")
	public WebElement newPassword;
	
	@FindBy(id="Password_password_Confirm_new_password")
	public WebElement confirmPassword;
	
	@FindBy(linkText="Submit")
	public WebElement submitButton;
	
	@FindBy(linkText="Cancel")
	public WebElement cancelButton;
	
	public MyDetailsPage(WebDriver dr){
		driver = dr;
	}
	
	public void updateContactDetails(){
		updateContactButton.click();
		//to-do fill and update details
			}
	
	public void updatePassword(String currentPass, String newPass, String confirmPass){
		
		changePasswordButton.click();
		currentPassword.sendKeys(currentPass);
		newPassword.sendKeys(newPass);
		confirmPassword.sendKeys(confirmPass);
		cancelButton.click();
		
	}
}
