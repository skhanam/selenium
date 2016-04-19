package uk.co.ratedpeople.test.functional.selenium.newho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobsPage {

WebDriver driver;
	
	
	@FindBy(xpath="//div[@class='page-header']/header/nav/ul/li[2]/a")
	public WebElement myJobsLink;
	
	
	public JobsPage(WebDriver dr){
		driver = dr;
	}
	
	public SomethingElse doSomething(){
		myJobsLink.click();
		return PageFactory.initElements(driver, SomethingElse.class);
	}

	public String getTopResultTitle() {
	
		return null;
	}
	
}
