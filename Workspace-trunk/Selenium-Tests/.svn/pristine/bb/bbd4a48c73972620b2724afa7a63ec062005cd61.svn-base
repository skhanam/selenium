package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression;

import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.jbillingmodel.PlanPeriod;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.jbillingmodel.PlanSpec;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money.TaxableAmount;

/**
 * Defined {@link PlanSpec} objects used for Test-Data.
 */
public class PlanSpecDefinitions {

	/**
	 * Needs the correct Plan code at some point - when it actually chooses the plan via the code on the server.
	 */
	public static final PlanSpec COST_FIVE_WITH_CREDIT_FIFTY = PlanSpec.Builder.with().planSelectorId("50FREE").planPeriodOf(PlanPeriod.MONTHLY)
			.includingCredit(TaxableAmount.newWithIncludedVatValue("50.00")).costing(TaxableAmount.newWithSansVatValue("5.00")).build();

	/**
	 * Needs the correct Plan code at some point - when it actually chooses the plan via the code on the server.
	 */
	public static final PlanSpec COST_TWENTY_WITH_CREDIT_TEN = PlanSpec.Builder.with().planSelectorId("10FREE").planPeriodOf(PlanPeriod.MONTHLY)
			.includingCredit(TaxableAmount.newWithSansVatValue("10.00")).costing(TaxableAmount.newWithSansVatValue("20.00")).build();

	/**
	 * The Plan to use by default.
	 */
	public static final PlanSpec DEFAULT = COST_FIVE_WITH_CREDIT_FIFTY;

}