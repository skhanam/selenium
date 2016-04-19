package uk.co.ratedpeople.test.functional.selenium.newjobforms;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

	public class PostingJobViaGasBoilerJobForm extends TestScriptUtilities{
	private WebDriver driver;
	private static final DateFormat df = new SimpleDateFormat("EEE, dd MMM HH mm");
	private static final Date date = new Date();
    private DetailsToUse fillDetails = new DetailsToUse(context);
	WebDriverWait wait = new WebDriverWait(context.driver, 50);
		public PostingJobViaGasBoilerJobForm(SeleniumTestContext context) {
			super(context);
			driver = context.driver;
		}
			private String getTagLine() {
				return "Hello all! I am a good Tradesman, before I publish my RSS on the our RSS aggregators. " +
					"In Ninja RSS Syndicator is possible to limit description by words, but I need description with 252 characters. " +  df.format(date);
			}
			
			private String getTagLine1() {
				return "Hell"; 
			}
	  
			private String getTagLine2() {
				return "Hello my boiler is made of a local brand called BRIXTON "  +   df.format(date);
			}
			
	public void postingJobViaGasBoilerFormflow1() throws Exception {
		fillDetails.gasBDetails();
 		driver.findElement(By.xpath("//*[@id='Job_describes_job_descInstall']")).click();
 		driver.findElement(By.xpath("//*[@id='stage-1']/div[2]/div/button[2]")).click();
 		sleep(3000);
 		//select what type of boiler you have & type you want installed & what make
 		new Select(driver.findElement(By.xpath("//*[@id='Job_boilerType']"))).selectByVisibleText("Combi boiler");
 		new Select(driver.findElement(By.xpath("//*[@id='Job_boilerTypeInstall']"))).selectByVisibleText("Combi boiler");
		new Select(driver.findElement(By.xpath("//*[@id='Job_boilerMakeInstall']"))).selectByVisibleText("Ariston");
		//how many radiators
		sleep(3000);
		new Select(driver.findElement(By.xpath("//*[@id='Job_radiators']"))).selectByVisibleText("None");
		//click next
		sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gas-boiler-form']/section[2]/div[5]/button[2]"))).click();
		sleep(3000);
	    //additional info form click next and assert errors
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='stage-2']/div[3]/button[2]"))).click();
		//driver.findElement(By.xpath("//*[@id='stage-2']/div[3]/button[2]")).click();
	  	sleep(3000);
	  	assertEquals(driver.findElement(By.xpath("//*[@id='timeframe']/em")).getText(), "Select the closest option for when you need the work done");
	  	assertEquals(driver.findElement(By.xpath("//*[@id='description']/em")).getText(), "Please provide some additional details");
		//enter less chars and asssert for error
		driver.findElement(By.xpath("//*[@id='Job_additional']")).sendKeys(getTagLine1());
		//select start date
		new Select(driver.findElement(By.xpath("//*[@id='Job_jobStartDate']"))).selectByVisibleText("2 months+");
		driver.findElement(By.xpath("//*[@id='stage-2']/div[3]/button[2]")).click();
		assertEquals(driver.findElement(By.xpath("//*[@id='description']/em")).getText(), "Please enter at least 5 characters.");
		driver.findElement(By.xpath("//*[@id='Job_additional']")).sendKeys(getTagLine());
		driver.findElement(By.xpath("//*[@id='stage-2']/div[3]/button[2]")).click();
	    //select a budget
		//click next without entering a budget and assert for error
		driver.findElement(By.xpath("//*[@id='stage-3']/div[2]/button[2]")).click();
		sleep(3000);
		System.out.println("Based on your job details, we suggest you set your budget between:£1300 and £2300");
		assertEquals(driver.findElement(By.xpath("//*[@id='budget']/div/div[2]/em")).getText(),  "Select an approximate budget");
		new Select(driver.findElement(By.xpath("//*[@id='Job_jobBudgetId']"))).selectByVisibleText("Under £2,000");
        driver.findElement(By.xpath("//*[@id='stage-3']/div[2]/button[2]")).click();
        sleep(3000);
        //enter details
        driver.findElement(By.id("Job_user_firstName")).sendKeys("");
        driver.findElement(By.id("Job_user_lastName")).sendKeys("");
        //enter email and fon no
        driver.findElement(By.xpath("//*[@id='Job_user_phoneNumber']")).sendKeys("07988673201");
        driver.findElement(By.xpath("//*[@id='Job_user_email']")).sendKeys("kk@ratedtrades.com");
        // click next and assert error messages
        driver.findElement(By.xpath("//*[@id='form-submit']")).click();
        sleep(3000);
        assertEquals(findElement(By.xpath("//*[@id='contact']/div[1]/em[1]")).getText(), "Enter your first name.");
        assertEquals(findElement(By.xpath("//*[@id='contact']/div[1]/em[2]")).getText(), "Enter your surname.");
        //enter names now
        driver.findElement(By.id("Job_user_firstName")).sendKeys("kwame");
        driver.findElement(By.id("Job_user_lastName")).sendKeys("Nkrumah");
        //submit
        driver.findElement(By.xpath("//*[@id='form-submit']")).click();
        sleep(3000);
        assertEquals(driver.findElement(By.xpath("//*[@id='header-h1']")).getText(),"Thank you");
	    System.out.println("Thank you");
	}

	public void postingJobViaGasBoilerFormFlow2() {
		fillDetails.gasBDetails();
	    //Hot water/heating
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Job_describes_job_descNotWorking']"))).click();
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    //click next and assert for errors
	    driver.findElement(By.xpath("//*[@id='gas-boiler-form']/section[3]/div[4]/button[2]")).click();
	    sleep(3000);
	    assertEquals(driver.findElement(By.xpath("//*[@id='water-taps']/em")).getText(), "Select whether your taps have hot water");
	    assertEquals(driver.findElement(By.xpath("//*[@id='radiators-heating']/em")).getText(), "Select whether your radiators heat up");
	    //enter additional info and click next
	    driver.findElement(By.xpath("//*[@id='Job_tap_water_waterNo']")).click();
	    driver.findElement(By.xpath("//*[@id='Job_radiator_heat_radiatorNo']")).click();
	    //what make is your boiler
	    sleep(2000);
	    new Select(driver.findElement(By.xpath("//*[@id='Job_boilerMake']"))).selectByVisibleText("Don't know");
	    sleep(2000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gas-boiler-form']/section[3]/div[4]/button[2]"))).click();
	    sleep(3000);
        System.out.println("Based on your job details, we suggest you set your budget between:£150 and £350");
	  //click without entering desc and assert for error
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='stage-2']/div[3]/button[2]"))).click();
	  	//driver.findElement(By.xpath("//*[@id='stage-2']/div[3]/button[2]")).click();
	  	sleep(3000);
	  	assertEquals(driver.findElement(By.xpath("//*[@id='timeframe']/em")).getText(), "Select the closest option for when you need the work done");
	  	assertEquals(driver.findElement(By.xpath("//*[@id='description']/em")).getText(), "Please provide some additional details");
	  //select timing, desc and click next
	    new Select(driver.findElement(By.xpath("//*[@id='Job_jobStartDate']"))).selectByVisibleText("2 months+");
	    driver.findElement(By.xpath("//*[@id='Job_additional']")).sendKeys(getTagLine2());
	    driver.findElement(By.xpath("//*[@id='stage-2']/div[3]/button[2]")).click();
	  	sleep(3000);
	  	//select a budget
	  	new Select(driver.findElement(By.xpath("//*[@id='Job_jobBudgetId']"))).selectByVisibleText("Under £2,000");
	    driver.findElement(By.xpath("//*[@id='stage-3']/div[2]/button[2]")).click();       
	    //enter details
	    sleep(3000);
	    driver.findElement(By.id("Job_user_firstName")).sendKeys("kwame");
	    driver.findElement(By.id("Job_user_lastName")).sendKeys("Nkrumah");
	    //no fon number and wrong email
	    driver.findElement(By.xpath("//*[@id='Job_user_phoneNumber']")).sendKeys("078000000001");
	    driver.findElement(By.xpath("//*[@id='Job_user_email']")).sendKeys("kkhotmail.com");
	    sleep(3000);
	    driver.findElement(By.xpath("//*[@id='form-submit']")).click();
	    sleep(3000);
	    //assert error message
	    assertEquals(findElement(By.xpath("//*[@id='contact']/div[1]/em[4]")).getText(), "Enter a valid email address.");
	    assertEquals(findElement(By.xpath("//*[@id='contact']/div[1]/em[3]")).getText(), "Enter a valid phone number");
	    //assertEquals(findElement(By.xpath("//*[@id='contact']/div[3]/em")).getText(), "Enter your phone number.");
	    //enter fon no again
	    driver.findElement(By.xpath("//*[@id='Job_user_phoneNumber']")).clear();
	    driver.findElement(By.xpath("//*[@id='Job_user_phoneNumber']")).sendKeys("07988568425");
	    driver.findElement(By.xpath("//*[@id='Job_user_email']")).clear();
	    //enter email again
	    driver.findElement(By.xpath("//*[@id='Job_user_email']")).sendKeys("kk@ratedtrades.com");
	    //submit
	    driver.findElement(By.xpath("//*[@id='form-submit']")).click();
	    sleep(3000);
	    assertEquals(driver.findElement(By.xpath("//*[@id='header-h1']")).getText(),"Thank you");
	    System.out.println("Thank you");
	    
	}
	
	public void postingJobViaGasBoilerFormFlow3() {
		fillDetails.gasBDetails();
	    //click next and assert for all errors
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Job_describes_job_descCertificate']"))).click();
	    sleep(3000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
 		sleep(3000);
        //select how many appliances required
		driver.findElement(By.xpath("//*[@id='appliances']/div/ul/li[1]/div/a[2]")).click();//boiler
		sleep(3000);
		driver.findElement(By.xpath("//*[@id='appliances']/div/ul/li[2]/div/a[2]")).click();//Gas
		driver.findElement(By.xpath("//*[@id='appliances']/div/ul/li[2]/div/a[2]")).click();
		//de-select 1 Gas
		driver.findElement(By.xpath("//*[@id='appliances']/div/ul/li[2]/div/a[1]")).click();
		// what make is your boiler
		new Select(driver.findElement(By.xpath("//*[@id='Job_boilerInstall']"))).selectByVisibleText("Worcester Bosch");
		sleep(3000);
		driver.findElement(By.xpath("//*[@id='gas-boiler-form']/section[4]/div[3]/button[2]")).click();
		//select timing, add desc and click next
	    new Select(driver.findElement(By.xpath("//*[@id='Job_jobStartDate']"))).selectByVisibleText("2 months+");
	    driver.findElement(By.xpath("//*[@id='Job_additional']")).sendKeys(getTagLine2());
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='stage-2']/div[3]/button[2]"))).click();
	    //driver.findElement(By.xpath("//*[@id='stage-2']/div[3]/button[2]")).click();
	  	sleep(3000);
	  	//select a budget
	  	new Select(driver.findElement(By.xpath("//*[@id='Job_jobBudgetId']"))).selectByVisibleText("Under £2,000");
	    driver.findElement(By.xpath("//*[@id='stage-3']/div[2]/button[2]")).click();
	    //enter details
	    sleep(3000);
	    driver.findElement(By.id("Job_user_firstName")).sendKeys("kwame");
	    driver.findElement(By.id("Job_user_lastName")).sendKeys("Nkrumah");
	    //enter wrong fon number and email
	    driver.findElement(By.xpath("//*[@id='Job_user_phoneNumber']")).sendKeys("020844241.");
	    sleep(3000);
	    driver.findElement(By.xpath("//*[@id='Job_user_email']")).sendKeys("kkhotmail.com");
	    driver.findElement(By.xpath("//*[@id='form-submit']")).click();
	    assertEquals(findElement(By.xpath("//*[@id='contact']/div[1]/em[3]")).getText(), "Enter a valid phone number");
	    assertEquals(findElement(By.xpath("//*[@id='contact']/div[1]/em[4]")).getText(), "Enter a valid email address.");
	    driver.findElement(By.xpath("//*[@id='Job_user_phoneNumber']")).clear();
	    //enter fon no again
	    driver.findElement(By.xpath("//*[@id='Job_user_phoneNumber']")).sendKeys("07988568425");
	    driver.findElement(By.xpath("//*[@id='Job_user_email']")).clear();
	    //enter email again
	    driver.findElement(By.xpath("//*[@id='Job_user_email']")).sendKeys("kk@ratedtrades.com");
	    //submit
	    driver.findElement(By.xpath("//*[@id='form-submit']")).click();
	    sleep(3000);
	    assertEquals(driver.findElement(By.xpath("//*[@id='header-h1']")).getText(),"Thank you");
	    System.out.println("Thank you");
	}
	public void postJobViaGasBoilerFormFlow4() {
		fillDetails.gasBDetails();
	    //service gas appliances
	    driver.findElement(By.xpath("//*[@id='Job_describes_job_descService']")).click();
	    sleep(2000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
	    sleep(3000);
        //select how many appliances required
		driver.findElement(By.xpath("//*[@id='gas-appliances_serviced']/div/ul/li[1]/div/a[2]")).click();
		driver.findElement(By.xpath("//*[@id='gas-appliances_serviced']/div/ul/li[2]/div/a[2]")).click();
		//what make is your boiler
		new Select(driver.findElement(By.xpath(".//*[@id='Job_boilerAppliancesInstall']"))).selectByVisibleText("Alpha");
		//do u require a gas cert and click next
		driver.findElement(By.xpath("//*[@id='Job_require_gas_certificates_radiatorYes']")).click();
		driver.findElement(By.xpath("//*[@id='gas-boiler-form']/section[5]/div[4]/button[2]")).click();
		sleep(5000);
		//select timing, desc and click next
	    new Select(driver.findElement(By.xpath("//*[@id='Job_jobStartDate']"))).selectByVisibleText("2 months+");
	    driver.findElement(By.xpath("//*[@id='Job_additional']")).sendKeys(getTagLine2());
	    //need to click twice to work sometimes
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='stage-2']/div[3]/button[2]"))).click();
	   //driver.findElement(By.xpath("//*[@id='stage-2']/div[3]/button[2]")).click();
	  	sleep(3000);
	  	//select a budget
	  	new Select(driver.findElement(By.xpath("//*[@id='Job_jobBudgetId']"))).selectByVisibleText("Under £2,000");
	    driver.findElement(By.xpath("//*[@id='stage-3']/div[2]/button[2]")).click();
	    //enter details
	    sleep(3000);
	    driver.findElement(By.id("Job_user_firstName")).sendKeys("kwame");
	    driver.findElement(By.id("Job_user_lastName")).sendKeys("Nkrumah");
	    //enter wrong fon number and email
	    driver.findElement(By.xpath("//*[@id='Job_user_phoneNumber']")).sendKeys("020844241.");
	    driver.findElement(By.xpath("//*[@id='Job_user_email']")).sendKeys("kkhotmail.com");
	    driver.findElement(By.xpath("//*[@id='form-submit']")).click();
	    sleep(3000);
	    //assert error messages
	    assertEquals(findElement(By.xpath("//*[@id='contact']/div[1]/em[3]")).getText(), "Enter a valid phone number");
	    assertEquals(findElement(By.xpath("//*[@id='contact']/div[1]/em[4]")).getText(), "Enter a valid email address.");
	    driver.findElement(By.xpath("//*[@id='Job_user_phoneNumber']")).clear();
	    //enter fon no again
	    driver.findElement(By.xpath("//*[@id='Job_user_phoneNumber']")).sendKeys("07988568425");
	    driver.findElement(By.xpath("//*[@id='Job_user_email']")).clear();
	    //enter email again
	    driver.findElement(By.xpath("//*[@id='Job_user_email']")).sendKeys("kk@ratedtrades.com");
	    //submit
	    driver.findElement(By.xpath("//*[@id='form-submit']")).click();
	    sleep(4000);
	    assertEquals(driver.findElement(By.xpath("//*[@id='header-h1']")).getText(),"Thank you");
	    System.out.println("Thank you");
	}
	public void postingJobViaBoilerFormFlow5() {
		fillDetails.gasBDetails();
	        //select something else 
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Job_describes_job_descElse']"))).click();
	 		driver.findElement(By.xpath("//button[@type='submit']")).click();
	 		//click next and asset for errors
	 		sleep(2000);
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='stage-2']/div[3]/button[2]"))).click();
	 		assertEquals(driver.findElement(By.xpath("//*[@id='description']/em")).getText(), "Please provide some additional details");
	 		assertEquals(driver.findElement(By.xpath("//*[@id='timeframe']/em")).getText(), "Select the closest option for when you need the work done");
			sleep(3000);
			//select start date and desc
			new Select(driver.findElement(By.xpath("//*[@id='Job_jobStartDate']"))).selectByVisibleText("I am flexible on start date");
			
			//enter less chars and assert for error
			driver.findElement(By.xpath("//*[@id='Job_additional']")).sendKeys(getTagLine1());
			driver.findElement(By.xpath("//*[@id='stage-2']/div[3]/button[2]")).click();
			assertEquals(driver.findElement(By.xpath("//*[@id='description']/em")).getText(), "Please enter at least 30 characters.");
			driver.findElement(By.xpath("//*[@id='Job_additional']")).sendKeys(getTagLine2());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='stage-2']/div[3]/button[2]"))).click();
		    //select a budget
			sleep(2000);
			new Select(driver.findElement(By.xpath("//*[@id='Job_jobBudgetId']"))).selectByVisibleText("Under £2,000");
			sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='stage-3']/div[2]/button[2]"))).click();
	        //enter details
	        sleep(3000);
	        driver.findElement(By.id("Job_user_firstName")).sendKeys("kwame");
	        //enter no 2nd name, wrong fon number and email
	        driver.findElement(By.id("Job_user_lastName")).sendKeys("");
	        driver.findElement(By.xpath("//*[@id='Job_user_phoneNumber']")).sendKeys("+7988673201");
	        driver.findElement(By.xpath("//*[@id='Job_user_email']")).sendKeys("kk@hotmailcom");
	        driver.findElement(By.xpath("//*[@id='form-submit']")).click();
	        clickIfExists(By.xpath("//*[@id='form-submit']"));
	        sleep(3000);
	        //assert error messages
	        assertEquals(findElement(By.xpath("//*[@id='contact']/div[1]/em[2]")).getText(), "Enter your surname.");
	        assertEquals(findElement(By.xpath("//*[@id='contact']/div[1]/em[4]")).getText(), "Enter a valid email address.");
	        assertEquals(findElement(By.xpath("//*[@id='contact']/div[1]/em[3]")).getText(), "Enter a valid phone number");
	        //enter surname
	        driver.findElement(By.id("Job_user_lastName")).sendKeys("Nkrumah");
           //enter fon no and email again
	        driver.findElement(By.xpath("//*[@id='Job_user_phoneNumber']")).clear();
	        driver.findElement(By.xpath("//*[@id='Job_user_phoneNumber']")).sendKeys("07988568425");
	        driver.findElement(By.xpath("//*[@id='Job_user_email']")).clear();
	        driver.findElement(By.xpath("//*[@id='Job_user_email']")).sendKeys("kk@ratedtrades.com");
	        //submit
	        driver.findElement(By.xpath("//*[@id='form-submit']")).click();
	        sleep(3000);
	        assertEquals(driver.findElement(By.xpath("//*[@id='header-h1']")).getText(),"Thank you");
		    System.out.println("Thank you");
}
	
}