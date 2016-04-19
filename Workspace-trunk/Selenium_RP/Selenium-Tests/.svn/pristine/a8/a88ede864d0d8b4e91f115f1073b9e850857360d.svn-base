package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_uploadpricingcsv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class UploadPricingCsv {
	private Login login;
	private SeleniumTestContext context;
	private TestScriptUtilities scriptUtils;

     public UploadPricingCsv(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
    	this.context = context;
    	this.scriptUtils = scriptUtils;
		login = new Login(scriptUtils, context);
	}			
     public void fileUpload() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		login.loginSupport("sangeetha.kumar@ratedpeople.com", "password");
		Thread.sleep(5000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='nav']/li[1]/a")));
	    scriptUtils.click(By.xpath(".//*[@id='nav']/li[1]/a"));
	    Thread.sleep(5000);
	       
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/table/tbody/tr[2]/td[1]/center/table/tbody/tr/td/table/tbody/tr[17]/td[2]/div/a")));
	    scriptUtils.click(By.xpath("html/body/table/tbody/tr[2]/td[1]/center/table/tbody/tr/td/table/tbody/tr[17]/td[2]/div/a"));
	    Thread.sleep(5000);
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("upload")));
	    WebElement fileInput = scriptUtils.findElement(By.id("upload"));
	    fileInput.sendKeys("C:\\Users\\sangeetha.kumar\\pricing\\Pricing_timing.csv");
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadSubmit")));
        scriptUtils.click(By.id("uploadSubmit"));
               
    	Thread.sleep(20000);
	    
	    }	
}
