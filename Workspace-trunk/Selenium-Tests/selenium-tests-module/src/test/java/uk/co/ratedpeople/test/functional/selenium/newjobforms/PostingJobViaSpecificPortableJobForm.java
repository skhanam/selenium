package uk.co.ratedpeople.test.functional.selenium.newjobforms;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

	public class PostingJobViaSpecificPortableJobForm extends TestScriptUtilities{
	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.PostingJobViaSpecificJobForm");
	private WebDriver driver;
	WebDriverWait waitforcontinue = new WebDriverWait(context.driver,10);
	 DetailsToUse pDDetails = new DetailsToUse(context);
		public PostingJobViaSpecificPortableJobForm(SeleniumTestContext context) {
			super(context);
			driver = context.driver;
			
		}
			public void postingJobViaSpecificJobForm()throws Exception{
				WebDriverWait wait = new WebDriverWait(context.driver, 40);
				pDDetails.enterDetails();
				//enter room and condition
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rooms']/div[1]/ul/li[1]/div/a[2]"))).click();
				driver.findElement(By.id("Job_services_decPaint")).click();
				driver.findElement(By.xpath("//*[@id='Job_conditions_repairGood']")).click();
				sleep(3000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='stage-1']/div[4]/div/button[2]")));
				//select other
				driver.findElement(By.xpath("//*[@id='rooms']/div[2]/ul/li[4]/div[1]/a[2]")).click();
				driver.findElement(By.xpath("//*[@id='Job_room_other']")).sendKeys("porch");
				//click next to job desc page
				driver.findElement(By.xpath("//*[@id='stage-1']/div[4]/div/button[2]")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Job_materials_allMaterials']"))).click();
				//driver.findElement(By.xpath("//*[@id='Job_materials_allMaterials']")).click(); 
				driver.findElement(By.xpath("//*[@id='Job_additional']")).sendKeys("I need some work done in my house. Please can you carry one out.");
				//need to click twice to work at the moment
				driver.findElement(By.xpath("//*[@id='stage-2']/div[4]/button[2]")).click();
				assertEquals(findElement(By.xpath("//*[@id='timeframe']/em")).getText(), "Select the closest option for when you need the work done");
				new Select(driver.findElement(By.xpath("//*[@id='Job_jobStartDate']"))).selectByVisibleText("Within 2 days"); 
				driver.findElement(By.xpath("//*[@id='stage-2']/div[4]/button[2]")).click();
			    new Select(driver.findElement(By.xpath("//*[@id='Job_jobBudgetId']"))).selectByVisibleText("Under £750"); 
			    driver.findElement(By.xpath("//*[@id='stage-3']/div[2]/button[2]")).click();
			    driver.findElement(By.xpath("//*[@id='form-submit']")).click(); 
			    assertEquals(driver.findElement(By.xpath("//*[@id='contact']/div[1]/em[1]")).getText(), "Enter your first name.");
			    assertEquals(findElement(By.xpath("//*[@id='contact']/div[1]/em[2]")). getText(), "Enter your surname.");
			    assertEquals(findElement(By.xpath("//*[@id='contact']/div[1]/em[3]")). getText(),"Enter your phone number.");
			    assertEquals(findElement(By.xpath("//*[@id='contact']/div[1]/em[4]")).getText(),"Enter your email address.");
			    driver.findElement(By.xpath("//*[@id='Job_user_firstName']")).sendKeys("Mark");
				driver.findElement(By.xpath("//*[@id='Job_user_lastName']")).sendKeys("Coleman");
				driver.findElement(By.xpath("//*[@id='Job_user_phoneNumber']")).sendKeys("07777777777");
				driver.findElement(By.xpath("//*[@id='Job_user_email']")).sendKeys("sarah.pain@ratedtrades.com");
				sleep(3000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='form-submit']"))).click();
				sleep(5000);
			    assertEquals(driver.findElement(By.xpath("//*[@id='header-h1']")).getText(),"Thank you");
			    System.out.println("Thank you");
			    			
}
			
	
	
	
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	
