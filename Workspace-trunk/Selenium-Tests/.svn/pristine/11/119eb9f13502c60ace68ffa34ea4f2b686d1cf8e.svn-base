package uk.co.ratedpeople.test.functional.selenium.pjf;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * Selenium test class for posting job via portable job form
 * @author swetha.morthala
 */
public class PostJobViaPortableJobFormTest extends TestScript {
	
	private PortableJobFormActions pjfActions;
	
	@BeforeClass
	public void beforeClass(){
		pjfActions = new PortableJobFormActions(this.context);
	}
	
	@Test
	public void postJobToConcertina(){
		pjfActions.goToMainPage();
	}
	
}
