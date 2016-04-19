package uk.co.ratedpeople.test.functional.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class CanReachLoginPageWithoutVisibleSessionIdsTest extends TestScript {
	
	@Test
	public void canGetLogInPageWithoutRewrittenUrls() {
		// Initial visit to non-log-in page sets cookie, and so removes future server URL/id(!) rewriting to introduce jsessionid:
		String baseURL = context.getTestUrl();
		context.driver.get(baseURL);
		
		// Our test call itself:
		context.driver.get(baseURL + "/log-in");
		
		Assert.assertFalse(context.driver.getPageSource().contains("jsessionid"));
	}
}
