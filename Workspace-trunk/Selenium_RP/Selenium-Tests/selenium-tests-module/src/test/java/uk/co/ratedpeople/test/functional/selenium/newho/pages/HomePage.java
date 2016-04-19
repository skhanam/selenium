package uk.co.ratedpeople.test.functional.selenium.newho.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

WebDriver driver;
	
	
	@FindBy(xpath="//div[@class='page-header']/header/nav/ul/li[2]/a")
	public WebElement myJobsLink;
	
	@FindBy(id="job-list")
	public WebElement jobList;
	
	
	
	public HomePage(WebDriver dr){
		driver = dr;
	}
	
	public JobsPage gotoJob(){
		myJobsLink.click();
		return PageFactory.initElements(driver, JobsPage.class);
	}


    	
    }

