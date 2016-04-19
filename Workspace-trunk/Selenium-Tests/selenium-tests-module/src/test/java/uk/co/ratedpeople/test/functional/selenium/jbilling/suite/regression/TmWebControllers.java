package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.CreateTradesman;
import uk.co.ratedpeople.test.functional.selenium.functions.JBillingRegression;

/**
 * The controllers for Web Resources (WebApps, REST APIs, etc) for Tradesman Testing.
 */
public class TmWebControllers {
	private SeleniumTestContext context;

	private CreateTradesman tmTools;
	private JBillingRegression jbController;

	public TmWebControllers(final SeleniumTestContext context, final TestScriptUtilities scriptUtilities) {
		this.context = context;

		this.jbController = new JBillingRegression(this.context, scriptUtilities);
		this.tmTools = new CreateTradesman(this.context, scriptUtilities);
	}

	public CreateTradesman getTmTools() {
		return tmTools;
	}

	public JBillingRegression getJbController() {
		return jbController;
	}
}