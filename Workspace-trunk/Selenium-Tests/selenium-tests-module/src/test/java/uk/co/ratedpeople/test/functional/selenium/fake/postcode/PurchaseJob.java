package uk.co.ratedpeople.test.functional.selenium.fake.postcode;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class PurchaseJob {
	private ViewJobPageObect viewJob;
	private TestScriptUtilities scriptUtils;

	public PurchaseJob(SeleniumTestContext context, TestScriptUtilities scriptUtils) throws IOException {
		this.scriptUtils = scriptUtils;
		viewJob = new ViewJobPageObect(context, scriptUtils);
	}

	public String purchaseJobWithinAFakePostCode() throws IOException {
		
         //Viewed job
		viewJob.viewJob();
		//click to buy
		WebElement element = scriptUtils.findElement(By.linkText("Buy"));
		element.click();
		//Now buy
		scriptUtils.click(By.linkText("Confirm"));
		//element = viewJob.findElement(By.xpath("//*[@id='default-card']/p[4]/a"));
		//element.click();
		//fillInTextField("purchase-cardholder", "mark kofi");
			/*	//use a new card
		element = viewJob.findElement(By.xpath("//*[@id='default-card']/p[4]/a"));
		element.click();
		element=viewJob.findElement(By.xpath("//*[@id='purchase-cardholder']/span/input"));
		element.sendKeys("mark kofi");
		element=viewJob.findElement(By.xpath("//*[@id='purchase-cardtype']/span/select"));
		element.sendKeys("MASTERCARD");
		element=viewJob.findElement(By.xpath("//*[@id='purchase-cardnumber']/span/input"));
		element.sendKeys("5404 0000 0000 0001");
		element=viewJob.findElement(By.xpath("//*[@id='purchase-enddate-year']"));
		element.sendKeys("2018");
		element=viewJob.findElement(By.xpath("//*[@id='purchase-securitynumber']/span/input"));
		element.sendKeys("123");
		element=viewJob.findElement(By.xpath("//*[@id='buy-job']/p/a[1]"));
		element.click();
		element=viewJob.findElement(By.xpath("//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[5]/td[2]/input"));
		element.sendKeys("password");
		element=viewJob.findElement(By.xpath("//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[6]/td[2]/input"));
		element.click();
		*/
		// Request for a Rating from a customer
		scriptUtils.click(By.xpath("//*[@id='container-rating']/p/a"));

		scriptUtils.click(By.xpath("//*[@id='container-rating']/div[2]/a[1]"));
	
		scriptUtils.click(By.linkText("Job Alerts"));
		//click on account
		element = scriptUtils.findElement(By.linkText("Jobs On Map"));
		element.click();
		element = scriptUtils.findElement(By.linkText("Edit job alert settings"));
		element.click();
		element = scriptUtils.findElement(By.id("postcode"));
		element.sendKeys("rp99pt");
		scriptUtils.click(By.xpath("//*[@id='settingsTab_area']/div/fieldset/p/button"));
		scriptUtils.sleep(100);
		element = scriptUtils.findElement(By.id("invalidPostcode"));
	     assertEquals(scriptUtils.findElement(By.xpath("//*[@id='invalidPostcode']")).getText(),"Invalid Postcode");
	
		// element = viewJob.findElement(By.xpath("//*[@id='header-wrapper']/nav/ul/li[3]/a"));
		
		//element = viewJob.findElement(By.xpath("//*[@id='header-wrapper']/nav/ul/li[3]/a"));
		//element = viewJob.findElement(By.xpath("//*[@id='header-wrapper']/nav/ul/li[3]/ul/li[3]/a"));
		//element.click();
		//element = viewJob.findElement(By.linkText("Job Alerts"));
		//element.click();
		
		return "";
	}
}


