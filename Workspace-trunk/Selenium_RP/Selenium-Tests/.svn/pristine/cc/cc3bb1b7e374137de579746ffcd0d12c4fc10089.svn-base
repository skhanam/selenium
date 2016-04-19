package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression;

import java.util.Date;

import uk.co.ratedpeople.test.functional.selenium.functions.JBillingRegression;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.datetime.WindableDateTime;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.datetime.WindableDateTime.EasyDate;

/**
 * Controls Time.
 */
public class TimeController {
	private JBillingRegression webController;
	private WindableDateTime currentDateTime;
	// TODO PlanRoller or whatnot
	
	TimeController(final JBillingRegression webController, final EasyDate startDateForTests) {
		super();
		this.webController = webController;
		this.currentDateTime = new WindableDateTime(startDateForTests);
	}
	
	TimeController(final JBillingRegression webController, final Date startDateForTests) {
		super();
		this.webController = webController;
		this.currentDateTime = new WindableDateTime(startDateForTests);
	}
	
	public Date getCurrentDate() {
		final Date date = this.currentDateTime.getDate();
		return date;
	}
	
	public void windForwardTimeByDays(final int days) {
		this.currentDateTime.windForwardDaysBy(days);
		// TODO use planRoller
	}
	
	public void windForwardTimeByOneDay() {
		this.currentDateTime.windForwardOneDay();
		// TODO use planRoller
	}
	
	public void windForwardTimeByMonths(final int months) {
		this.currentDateTime.windForwardMonthsBy(months);
		// TODO use planRoller
	}
	
	public void windForwardTimeByOneMonth() {
		this.currentDateTime.windForwardOneMonth();
		// TODO use planRoller
	}
	
	public void windForwardTimeByYears(final int years) {
		this.currentDateTime.windForwardYearsBy(years);
		// TODO use planRoller
	}
	
	public void windForwardTimeByOneYear() {
		this.currentDateTime.windForwardOneYear();
		// TODO use planRoller
	}
}
