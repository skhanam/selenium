package uk.co.ratedpeople.test.functional.selenium.tp.functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class SplitLogin extends TestScriptUtilities {
	
	public SplitLogin(SeleniumTestContext context) {
		super(context);
	}
	
	public void login(String userName, String password) {
		clickIfExists(By.linkText("Logout"));
		goTo(context.getTestUrl()+"/log-in");
		fillInTextField("tpUserName", userName);
		fillInTextField("tpPassword", password);
		WebElement element = getElementIfExists(By.xpath("//button[@type='submit']"));
		element.click();
	}
}