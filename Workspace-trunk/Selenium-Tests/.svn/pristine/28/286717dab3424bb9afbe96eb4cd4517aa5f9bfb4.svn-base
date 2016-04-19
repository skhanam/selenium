package uk.co.ratedpeople.test.functional.selenium.newho;

import org.openqa.selenium.support.PageFactory;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newho.pages.TopMenu;

public class LoginContext extends TestScript {

	private static TopMenu topMenu = null;

	public LoginContext() {
	}

	public TopMenu getTopMenu() {
		if (topMenu == null) {
			topMenu = PageFactory.initElements(context.driver, TopMenu.class);
		}
		return topMenu;
	}

}
