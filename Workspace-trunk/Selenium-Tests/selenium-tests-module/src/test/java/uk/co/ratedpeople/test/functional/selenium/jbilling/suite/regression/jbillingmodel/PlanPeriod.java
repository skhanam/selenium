package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.jbillingmodel;

public enum PlanPeriod {
	MONTHLY(1), QUARTERLY(4), ANNUAL(12), PAYG(0);

	private final int months;

	private PlanPeriod(final int monthsPerIteration) {
		this.months = monthsPerIteration;
	}

	public int getMonths() {
		return months;
	}

	public boolean isPayAsYouGo() {
		return PAYG.equals(this);
	}
}