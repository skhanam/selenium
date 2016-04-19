package uk.co.ratedpeople.test.functional.selenium.newjobforms.cacheclear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class HelpClearCache extends TestScript {
	private String testUrl;
	private WebDriver driver;
	private Login login;

	@BeforeMethod
	public void setUp() {
		this.driver = this.context.driver;
		this.testUrl = this.context.getSupportUrl();
		this.login = new Login(scriptUtilities, this.context);
		this.scriptUtilities = new TestScriptUtilities(context);
	}

	/**
	 * Test access to /support as an admin user. Should be fine and go straight
	 * through to MK3.
	 */

	@Test(enabled = false)
	public void clearCacheOnLive() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String liveUrls[] = new String[5];
		liveUrls[0] = "https://backend1app.uk.ratedpeople";
		liveUrls[1] = "https://app1support.uk.ratedpeople";
		liveUrls[2] = "https://app2support.uk.ratedpeople";
		liveUrls[3] = "https://app1www.uk.ratedpeople";
		liveUrls[4] = "https://app2www.uk.ratedpeople";
		String username = "";
		String password = "";
		// username = "support.selenium@ratedpeople.com";
		// password = "password";
		for (String url : liveUrls) {
			scriptUtilities.goTo(url + "/logout");

			System.out.println("log in -> "+url);
			scriptUtilities.goTo(url + "/support");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.id("userName")));
			scriptUtilities.fillInTextField("userName", username);
			scriptUtilities.fillInTextField("password", password);
			scriptUtilities.click("btn-log-in");
			scriptUtilities.goTo(url + "/admin/showProperties/cache");

			String flushRPProperties = "html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[4]/td/table/tbody/tr[2]/td[8]/input[2]";
							
			scriptUtilities.click(By.xpath(flushRPProperties));
			for (int i = 100; i < 260; i++) {
				WebElement element = scriptUtilities.findElement(By.xpath("html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[4]/td/table/tbody/tr["+ i + "]/td[1]"));
				
				if (element.getText().startsWith("SkillSpecific")){
					System.out.println("flush "+element.getText());
					String flush = "html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[4]/td/table/tbody/tr["+ i + "]/td[8]/input[2]";
					scriptUtilities.click(By.xpath(flush));
				}
			}
			scriptUtilities.goTo(url + "/logout");
			System.out.println("log out ->  "+url);
		}
		

	}

	

}
