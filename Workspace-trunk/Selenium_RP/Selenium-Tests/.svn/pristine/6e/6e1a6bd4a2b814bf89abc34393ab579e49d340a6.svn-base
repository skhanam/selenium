package uk.co.ratedpeople.test.functional.selenium.ho.mobile;

import org.openqa.selenium.By;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
/**
 * This is selenium test for mobile job form success scenario.
 * @author abhiuday.tomar
 *
 */
public class MobileJobForm extends TestScriptUtilities{

	public MobileJobForm(SeleniumTestContext context) {
		super(context);
	}
	
	public void submitJob(String path) throws InterruptedException{
		goTo(context.getTestHttpsHOURL()+path);
		clickIfExists(By.linkText("Aerial / Network Specialist"));
		this.sleep(2000);
		clickDropdown(By.id("jobtype"), 4);
		this.click("btn-next-step");
		
		this.click("statusREADY_TO_HIRE");
		this.click("ownerOWN_AND_LIVE");
		this.selectDropdown("timing", 1);
		this.fillInTextField("postcode", "ha99ar");
		
		this.clearAndFillInXpathField(".//*[@id='additionalDetailsContainer']/textarea", "This is a mobile job form selenium test.It will be used for selenium testing.");
		this.clickIfExists(By.xpath(".//*[@id='stage2']/div[6]/div/button[1]"));
		
		this.selectDropdown("jobBudgetCode", 1);
		this.clickIfExists(By.xpath(".//*[@id='stage3']/div[2]/div/button[1]"));
		
		this.fillInTextField("firstName", "sangeetha");
		this.fillInTextField("lastName", "kumar");
		this.fillInTextField("mobilePhone", "07788990099");
		this.fillInTextField("email", "ho.selenium.test126@ratedtrades.com");
		this.click("btnPostJob");
		this.sleep(2000);
		
		assertEquals(context.driver.findElement(By.id("header-h1")).getText(),"Thank you");
		System.out.println("Home owner Email : seleniumho@ratedpeople.com");
		
		}
	
	private void assertEquals(String text, String string) {
		// TODO Auto-generated method stub
		
	}

	public void submitJobWithErrors(String path) throws InterruptedException{
		goTo(context.getTestHttpsHOURL()+path);
		clickIfExists(By.linkText("Aerial / Network Specialist"));
		this.sleep(2000);
		clickDropdown(By.id("jobtype"), 4);
		this.click("btn-next-step");
		
		this.click("statusREADY_TO_HIRE");
		this.click("ownerOWN_AND_LIVE");
		this.selectDropdown("timing", 1);
		
		fillInTextField("postcode", "wembley");
		this.clearAndFillInXpathField(".//*[@id='additionalDetailsContainer']/textarea", "This is a mobile job form selenium test.It will be used for selenium testing.");
		this.clickIfExists(By.xpath(".//*[@id='stage2']/div[6]/div/button[1]"));
		
		this.click("statusREADY_TO_HIRE");
		this.click("ownerOWN_AND_LIVE");
		this.selectDropdown("timing", 1);
		this.clear(By.xpath(".//*[@id='postcode']"));
		this.fillInTextField("postcode", "ha99ar");
				
		this.clearAndFillInXpathField(".//*[@id='additionalDetailsContainer']/textarea", "This is a mobile job form selenium test.It will be used for selenium testing.");
		this.clickIfExists(By.xpath(".//*[@id='stage2']/div[6]/div/button[1]"));
		
		this.selectDropdown("jobBudgetCode", 1);
		this.clickIfExists(By.xpath(".//*[@id='stage3']/div[2]/div/button[1]"));
		
		this.fillInTextField("firstName", "sangeetha");
		this.fillInTextField("lastName", "kumar");
		this.fillInTextField("mobilePhone", "07788990099");
		this.fillInTextField("email", "ho.selenium.test126@ratedtrades.com");
		this.click("btnPostJob");
		this.sleep(2000);
		
		assertEquals(context.driver.findElement(By.id("header-h1")).getText(),"Thank you");
		System.out.println("Home owner Email : seleniumho@ratedpeople.com");
				}
}
