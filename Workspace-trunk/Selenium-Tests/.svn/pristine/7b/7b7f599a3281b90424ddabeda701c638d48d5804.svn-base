package uk.co.ratedpeople.test.functional.selenium.newjobforms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.assertEquals;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

    public class PostingJobViaGenericPortableJobForm extends TestScriptUtilities{
    private WebDriver driver;
    private String testUrl; 
    	public PostingJobViaGenericPortableJobForm(SeleniumTestContext context) {
    		super(context);
    		driver = context.driver;
    		testUrl = context.getTestUrl ();
    	}
    	
    	public void postingJobViaGenericJobForm() throws Exception{
    	goTo(testUrl + "/get-quotes-b/painters-decorators/london");
    	new Select(driver.findElement(By.xpath("//*[@id='jobFormJobType']"))).selectByVisibleText("Paint Effects / Mural");
    	driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("");
    	driver.findElement(By.xpath("//*[@id='btn-next-step']")).click();
    	assertEquals(findElement(By.xpath("//*[@id='postcodeError']")).getText(), "Sorry we do not recognise that postcode. Please call us on 0870 220 8811");
    	driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("SW426BA");
    	driver.findElement(By.xpath("//*[@id='btn-next-step']")).click();
    	assertEquals(findElement(By.xpath("//*[@id='postcodeError']")).getText(), "Sorry we do not recognise that postcode. Please call us on 0870 220 8811");
    	driver.findElement(By.xpath("//*[@id='postcode']")).clear();
   
    	driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("SW46BA"); 
    	driver.findElement(By.xpath("//*[@id='btn-next-step']")).click(); 
    	clickIfExists(By.xpath("//*[@id='btn-next-step']"));
    	sleep(3000);
    	driver.switchTo().frame(0);
    	//enter 24 chars, min is 25
    	//sleep(3000);
    	driver.findElement(By.xpath("//*[@id='Job_description']")).sendKeys("i need a good tradesmans");
    	new Select(driver.findElement(By.xpath("//*[@id='Job_jobBudgetId']"))).selectByVisibleText("Under £2,000");
    	new Select(driver.findElement(By.xpath("//*[@id='Job_jobStartDate']"))).selectByVisibleText("Urgently");
    	driver.findElement(By.xpath("//*[@id='btn-next-step']")).click();
    	assertEquals(findElement(By.xpath("//*[@id='stage-1']/section[2]/div[1]/div[1]/em[1]")).getText(),"Please enter at least 25 characters.");
    	driver.findElement(By.xpath("//*[@id='Job_description']")).clear();
    	driver.findElement(By.xpath("//*[@id='Job_description']")).sendKeys("i need a good tradesman to come and do this job");
    	//assertEquals(findElement(By.xpath("//*[@id='stage-1']/section[2]/div[1]/div[2]/em[1]")).getText(),"Select an approximate budget");
    	//assertEquals(findElement(By.xpath("//*[@id='stage-1']/section[2]/div[1]/div[3]/em[1]")).getText(),"Select the closest option for when you need the work done");
    	driver.findElement(By.xpath("//*[@id='btn-next-step']")).click();
    	driver.findElement(By.xpath("//*[@id='Job_user_firstName']")).sendKeys("Mark");
		driver.findElement(By.xpath("//*[@id='Job_user_lastName']")).sendKeys("Coleman");
		driver.findElement(By.xpath("//*[@id='Job_user_phoneNumber']")).sendKeys("07777777777");
		driver.findElement(By.xpath("//*[@id='Job_user_email']")).sendKeys("sarah.painrataedpeople.com");
		driver.findElement(By.xpath("//*[@id='form-submit']")).click(); 
		assertEquals(findElement(By.xpath("//*[@id='stage-2']/section[2]/div[4]/em")).getText(),"Enter a valid email address.");
		driver.findElement(By.xpath("//*[@id='Job_user_email']")).clear();
		driver.findElement(By.xpath("//*[@id='Job_user_email']")).sendKeys("sarah.pain@ratedtrades.com");
		sleep(3000);
		driver.findElement(By.xpath("//*[@id='form-submit']")).click(); 
		sleep(3000);
		assertEquals(driver.findElement(By.xpath("//*[@id='header-h1']")).getText(),"Thank you");
		System.out.println("Thank you");
    	
   }
}