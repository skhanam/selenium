package uk.co.ratedpeople.test.functional.selenium.questions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class AskAnExpert {
	private Login login;
	private TestScriptUtilities scriptUtils;
	private String testUrl;
	private WebDriver driver;
	
	
	public AskAnExpert(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		this.testUrl = context.getTestUrl();
		this.driver = context.driver;
				
		login = new Login(scriptUtils, context);
	}


	public void askAnExpertLanding(String email,int category) {
		scriptUtils.clickIfExists(By.linkText("Logout"));
		scriptUtils.goTo(testUrl + "/diy-advice");
		scriptUtils.fillInTextField("new-question-landing","Testing the question landing page ");
		scriptUtils.click(By.xpath(".//*[@id='ask-question']/button[1]"));
		scriptUtils.fillInTextField("Question_title", "Title Question : Selenium Test Ask An Expert");
		scriptUtils.fillInTextField("Question_description","Question : How can I edit");
		scriptUtils.sleep(2000);
		scriptUtils.clickDropdown(By.id("Question_category"),category);
		scriptUtils.fillInTextField("Question_firstName" ,"Sangeetha");
		scriptUtils.fillInTextField("Question_lastName","Kumar");
		scriptUtils.fillInTextField("Question_email",email);
		scriptUtils.click("btn_submit_q");
		scriptUtils.sleep(2000);
		assertEquals("Thank you for your submission. You will receive an email when one of our experts has answered your question.", driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/h2")).getText());

	}

	public void submitAnswer(String TPlogin, String password) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		login.loginTP(TPlogin, password);
		scriptUtils.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Ask an expert"))).click();
		scriptUtils.click(By.xpath("//html/body/div[2]/div/div[3]/section[2]/div[2]/ol/li[2]/p[2]/a"));
		/*scriptUtils.click(By.xpath("//*[@id=\"header-wrapper\"]/nav/ul/li[3]/a"));
		scriptUtils.click(By.xpath("//*[@id=\"jobAlertsTable\"]/ol/li[2]/p[2]/a"));*/
		scriptUtils.fillInXpathField("//*[@id=\"tag_line\"]","This is my answer posted by Selenium script");
		scriptUtils.click("submitQuestionResponse_0");
		assertEquals("Thank you for your response.", driver.findElement(By.xpath("//*[@id=\"content\"]/section[2]/div[1]/div/div/p/strong")).getText());
	}
}


