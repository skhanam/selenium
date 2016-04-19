package uk.co.ratedpeople.test.functional.selenium.newho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TopMenu {
	
	private WebDriver driver;

	@FindBy(linkText="Post a job")
	private WebElement postJobLink;
	
	@FindBy(linkText="My jobs")
	private WebElement myJobsLink;
	
	@FindBy(linkText="My details")
	private WebElement myDetailsLink;
	
	public TopMenu(WebDriver dr){
		driver = dr;
	}
	
	public MainPage postAjob(){
		postJobLink.click();
		return PageFactory.initElements(driver, MainPage.class);
	}
	
	public HomePage clickMyJobs(){
		myJobsLink.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public MyDetailsPage clickMyDetails(){
		myDetailsLink.click();
		return PageFactory.initElements(driver, MyDetailsPage.class);
	}
}
