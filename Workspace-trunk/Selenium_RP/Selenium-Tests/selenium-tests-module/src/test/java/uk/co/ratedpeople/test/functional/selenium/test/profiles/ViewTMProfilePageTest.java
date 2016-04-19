package uk.co.ratedpeople.test.functional.selenium.test.profiles;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.test.profiles.ViewTMProfileRatingsAndPhotos;

public class ViewTMProfilePageTest extends TestScript{
	
private ViewTMProfileRatingsAndPhotos viewTM;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		viewTM = new ViewTMProfileRatingsAndPhotos(this.context);
	}

	@Test(enabled=true) 
	public void viewiewTMProfileTest() throws Exception {
		viewTM.viewTMProfileAndGetQuote();
		viewTM.clickOnAllTabsInProfilePageAndAssert();
		
	}
}
