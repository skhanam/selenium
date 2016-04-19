package uk.co.ratedpeople.test.functional.selenium.pjf;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * Class to hold common actions for submitting job via portable job form
 * @author swetha.morthala
 */
public class PortableJobFormActions extends TestScriptUtilities {

	public PortableJobFormActions(SeleniumTestContext context) {
		super(context);
	}
	
	public void goToMainPage() {
		goTo(context.getTestPJFURL()+"/test-cases/index.html");
	}
	
	
}
