package uk.co.ratedpeople.test.functional.selenium.ho.diy;

/**
 * @author danthalapalli.aravind
 * 
 */
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class AskAnExpertQuestionQnANegativeTest extends TestScript {
	
	private AskAnExpertQuestionQnA underTest;
	private static final String BUTTON_ID ="btn_submit_q";
	
	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new AskAnExpertQuestionQnA(context.driver,
				context.getTestUrl(), scriptUtilities);
	}
	
	
	@Test(enabled = true)
	public void AskAnExpertQuestionQnANegativeTest1() throws Exception {
		
		underTest.getdiypage();
		
		WebDriverWait waitForPageToLoad = new WebDriverWait(context.driver, 10);
		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKON_ASKTHISQUESTIONBUTTON"))));
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKON_ASKTHISQUESTIONBUTTON"))).click();
		
		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("ERRORMSG_FORNOQUESTION"))));
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FORNOQUESTION"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FORNOQUESTIONTEXT"));
		
		
		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("NEWQUESTION_LANDING"))));

		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("NEWQUESTION_LANDING"))).sendKeys(AskanexpertXpathLocators.datalocators
								.get("LESSTHAN_FIVECHAR"));

		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKON_ASKTHISQUESTIONBUTTON"))));

		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKON_ASKTHISQUESTIONBUTTON"))).click();

		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("ERRORMSG_LESSTHANFIVECHAR"))));

		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_LESSTHANFIVECHAR"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_LESSTHANFIVECHARTEXT"));
		
		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("NEWQUESTION_LANDING"))));

		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("NEWQUESTION_LANDING"))).sendKeys(AskanexpertXpathLocators.datalocators
								.get("ENTERING_TEXTMORETHAN70"));

		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKON_ASKTHISQUESTIONBUTTON"))));

		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKON_ASKTHISQUESTIONBUTTON"))).click();
		
		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("ERRORMSG_MORETHAN70CHAR"))));

		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_MORETHAN70CHAR"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_MORETHAN70CHARTEXT"));
		
	}
	
	
	@Test(enabled = true)
	public void AskAnExpertQuestionQnANegativeTest2() throws Exception {
		
		
		underTest.getdiypage();

		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("NEWQUESTION_LANDING"))).sendKeys(AskanexpertXpathLocators.datalocators
								.get("ENTERING_TEXT"));
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKON_ASKTHISQUESTIONBUTTON"))).click();
		
				
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKONASK_BUTTON"))).click();
					
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FORQUESTION"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FORQUESTIONTEXT"));
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FORCATEGORY"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FORCATEGORYTEXT"));
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FORFIRSTNAME"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FORFIRSTNAMETEXT"));
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FOREMAIL"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FOREMAILTEXT"));
		
		
	}
	
	
	@Test(enabled = true)
	public void AskAnExpertQuestionQnANegativeTest3() throws Exception {
		
		underTest.getdiypage();
		
		WebDriverWait waitForPageToLoad = new WebDriverWait(context.driver, 10);
		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("NEWQUESTION_LANDING"))));

		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("NEWQUESTION_LANDING"))).sendKeys(AskanexpertXpathLocators.datalocators
								.get("ENTERING_TEXT"));
		
		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKON_ASKTHISQUESTIONBUTTON"))));
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKON_ASKTHISQUESTIONBUTTON"))).click();
				
		Select bycategory = new Select(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("category"))));
		bycategory.selectByValue("network");
		
		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKONASK_BUTTON"))));
				
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKONASK_BUTTON"))).click();
		
		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("ERRORMSG_FORFIRSTNAME"))));
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FORFIRSTNAME"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FORFIRSTNAMETEXT"));
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FOREMAIL"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FOREMAILTEXT"));
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FORQUESTION"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FORQUESTIONTEXT"));
	}
	
	
	@Test(enabled = true)
	public void AskAnExpertQuestionQnANegativeTest4() throws Exception {
		
		underTest.getdiypage();

		WebDriverWait waitForPageToLoad = new WebDriverWait(context.driver, 10);
		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("NEWQUESTION_LANDING"))));

		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("NEWQUESTION_LANDING"))).sendKeys(AskanexpertXpathLocators.datalocators
								.get("ENTERING_TEXT"));
		
		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKON_ASKTHISQUESTIONBUTTON"))));
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKON_ASKTHISQUESTIONBUTTON"))).click();
		
		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("DESCRIPTION_XPATH"))));
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("DESCRIPTION_XPATH"))).sendKeys(AskanexpertXpathLocators.datalocators
								.get("DESCRIPTION_XPATHTEXT"));
		
		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("CLICKONASK_BUTTON"))));
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKONASK_BUTTON"))).click();
		
		waitForPageToLoad.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(AskanexpertXpathLocators.xpathlocators.get("ERRORMSG_FORFIRSTNAME"))));
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FORFIRSTNAME"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FORFIRSTNAMETEXT"));
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FOREMAIL"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FOREMAILTEXT"));
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FORCATEGORY"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FORCATEGORYTEXT"));
	}
	
	@Test(enabled = true)
	public void AskAnExpertQuestionQnANegativeTest5() throws Exception {
		
		underTest.getdiypage();

		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("NEWQUESTION_LANDING"))).sendKeys(AskanexpertXpathLocators.datalocators
								.get("ENTERING_TEXT"));
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKON_ASKTHISQUESTIONBUTTON"))).click();
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("DESCRIPTION_XPATH"))).sendKeys(AskanexpertXpathLocators.datalocators
								.get("DESCRIPTION_XPATHTEXT"));
		
		Select bycategory = new Select(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("category"))));
		bycategory.selectByValue("network");
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKONASK_BUTTON"))).click();
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FORFIRSTNAME"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FORFIRSTNAMETEXT"));
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FOREMAIL"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FOREMAILTEXT"));
		
		
	}
	
	@Test(enabled = true)
	public void AskAnExpertQuestionQnANegativeTest6() throws Exception {
		
		
		underTest.getdiypage();

		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("NEWQUESTION_LANDING"))).sendKeys(AskanexpertXpathLocators.datalocators
								.get("ENTERING_TEXT"));
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKON_ASKTHISQUESTIONBUTTON"))).click();
		
		String headerText = context.driver.findElement(By.xpath(".//*[@id='Question_title']")).getAttribute("value");
		System.out.println(headerText);
		
		assertEquals(
				headerText,
				AskanexpertXpathLocators.datalocators
						.get("ENTERING_TEXT"));
		
		
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("DESCRIPTION_XPATH"))).sendKeys("less than 30");
		
		Select bycategory = new Select(context.driver.findElement(By.xpath(AskanexpertXpathLocators.xpathlocators.get("category"))));
		bycategory.selectByValue("network");
		
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("FIRST_NAME"))).sendKeys(AskanexpertXpathLocators.datalocators
								.get("FIRST_NAMETEXT"));
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("EMAIL_ID"))).sendKeys(AskanexpertXpathLocators.datalocators
								.get("EMAIL_IDTEXT"));
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("KEEPME_UPDATECHECKBOX"))).click();	
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKONASK_BUTTON"))).click();	
				
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("LESSTHAN_THIRTYWORDSERRORMSG"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("LESSTHAN_THIRTYWORDSERRORMSGTEXT"));
		
		
	}
	
	@Test(enabled = true)
	public void AskAnExpertQuestionQnANegativeTest7() throws Exception {
		
		underTest.getdiypage();

		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("NEWQUESTION_LANDING"))).sendKeys(AskanexpertXpathLocators.datalocators
								.get("ENTERING_TEXT"));
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKON_ASKTHISQUESTIONBUTTON"))).click();
		
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("LAST_NAMEXPATH"))).sendKeys(AskanexpertXpathLocators.datalocators
								.get("LAST_NAMEXPATHTEXT"));
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKONASK_BUTTON"))).click();	
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FORFIRSTNAME"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FORFIRSTNAMETEXT"));
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FOREMAIL"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FOREMAILTEXT"));
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FORQUESTION"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FORQUESTIONTEXT"));
		
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("ERRORMSG_FORCATEGORY"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("ERRORMSG_FORCATEGORYTEXT"));
		
				
	}
	
	
	@Test(enabled = true)
	public void AskAnExpertQuestionQnANegativeTest8() throws Exception {
		
		
		underTest.getdiypage();

		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("NEWQUESTION_LANDING"))).sendKeys(AskanexpertXpathLocators.datalocators
								.get("ENTERING_TEXT"));
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKON_ASKTHISQUESTIONBUTTON"))).click();
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("DESCRIPTION_XPATH"))).sendKeys("budget");
		
		Thread.sleep(1000);
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("XPATHFOR_WRITINGBUDGET"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("XPATHFOR_WRITINGBUDGETEXT"));
		
		
		WebElement button= context.driver.findElement(By.id(BUTTON_ID));
        if(button.isEnabled())
        {
        context.driver.findElement(By.id(BUTTON_ID)).click();
        System.out.println("THE BUTTON IS ENABELED");
        }
        else
        {
            System.out.println("THE BUTTON IS DISABELED");
        }
        
        context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("COSTGUIDESLINK_XPATH"))).click();
        
        String AskAnExpert = context.driver.getWindowHandle();

        for(String winHandle : context.driver.getWindowHandles()){
    	  context.driver.switchTo().window(winHandle);
      }
        
        Thread.sleep(2000);
        
        context.driver.close();
        
        context.driver.switchTo().window(AskAnExpert);
		
		
	}
	
	@Test(enabled = true)
	public void AskAnExpertQuestionQnANegativeTest9() throws Exception {	
		
		
		underTest.getdiypage();

		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("NEWQUESTION_LANDING"))).sendKeys("budget budget");
		
		context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("CLICKON_ASKTHISQUESTIONBUTTON"))).click();
		
		
		Thread.sleep(2000);
		
		assertEquals(
				context.driver.findElement(
						By.xpath(AskanexpertXpathLocators.xpathlocators
								.get("XPATHFOR_WRITINGBUDGET"))).getText(),
				AskanexpertXpathLocators.datalocators
						.get("XPATHFOR_WRITINGBUDGETEXT"));
		
		
		WebElement button= context.driver.findElement(By.id(BUTTON_ID));
        if(button.isEnabled())
        {
        context.driver.findElement(By.id(BUTTON_ID)).click();
        System.out.println("THE BUTTON IS ENABELED");
        }
        else
        {
            System.out.println("THE BUTTON IS DISABELED");
        }
        
        context.driver.findElement(
				By.xpath(AskanexpertXpathLocators.xpathlocators
						.get("COSTGUIDESLINK_XPATH"))).click();
        
        String AskAnExpert = context.driver.getWindowHandle();

        for(String winHandle : context.driver.getWindowHandles()){
    	  context.driver.switchTo().window(winHandle);
      }
        
        Thread.sleep(2000);
        
        context.driver.close();
        
        context.driver.switchTo().window(AskAnExpert);
		
		
	}
	
	
	
}
