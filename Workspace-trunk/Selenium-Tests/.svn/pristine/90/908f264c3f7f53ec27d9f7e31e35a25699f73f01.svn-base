package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.tradesman;

import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import uk.co.ratedpeople.test.functional.selenium.functions.CreateTradesman;
import uk.co.ratedpeople.test.functional.selenium.functions.CreateTradesman.TPDetails;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.GoodwillGrant;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.GoodwillType;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.JobPriceDetail;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.PlanSpecDefinitions;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.jbillingmodel.PlanSpec;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money.AmountVatType;

/**
 * A controllable Tradesman.
 */
public class Tradesman {
	private static final Logger LOGGER = Logger.getLogger(Tradesman.class.getName());
	private final CreateTradesman tmTools;
	private final TradesmanState tmState;

	public Tradesman(final CreateTradesman tmTools, final String idCode) {
		this.tmTools = tmTools;
		this.tmState = new TradesmanState();
		this.tmState.setIdCode(idCode);
		this.tmState.setStartPlan(PlanSpecDefinitions.DEFAULT);
	}

	public Tradesman(final CreateTradesman tmTools, final TradesmanState tmState) {
		this.tmTools = tmTools;
		this.tmState = tmState;
	}

	public String getIdCode() {
		return this.tmState.getIdCode();
	}

	public void setStartPlan(final PlanSpec startPlan) {
		this.tmState.setStartPlan(startPlan);
	}

	/**
	 * Signs up TM with all defaults - NOT using the plans you set with {@link #setStartPlan(PlanSpec)}
	 */
	public void signupUsingDefaults() {
		try {
			final TPDetails tpDetails = this.tmTools.createNewTradesmanMK3JBilling();
			this.tmState.setId(tpDetails.getId());
			this.tmState.setUserName(tpDetails.getUsername());
			this.tmState.startPlanBegins();
		} catch (Exception e) {
			throw new RuntimeException("Exception when creating user in MK3!!", e);
		}
	}

	public TradesmanState getTmState() {
		return this.tmState;
	}

	public void buyJob(final JobPriceDetail job) {
		final BigDecimal priceForTm = myPriceFor(job);
		this.tmState.spendThroughCredit(priceForTm);
		LOGGER.log(Level.INFO, "balance of tm: " + this.tmState.getIdCode() + " after spend of: " + priceForTm + " is: " + this.tmState.getBalance());
	}

	private BigDecimal myPriceFor(final JobPriceDetail job) {
		// TODO in future, need to alter this as appropriate (e.g. PAYG scaling factor, etc).
		return job.getBasePrice().getAmountWithVat();
		// return BigDecimal.TEN.setScale(2); // at min, goodwill is always £10.00
	}

	@Deprecated
	public void grantCreditFor(final JobPriceDetail job) {
		if (true)
			throw new UnsupportedOperationException("Can't give Lead-Credits at minute.");
		final BigDecimal priceForTm = myPriceFor(job);
		this.tmState.giveLeadCredit(priceForTm);
	}

	public void grantGoodwillOfPredefinedAmount() {
		final Date currentDate = new Date(); // TODO get current "pretend" date from DateController
		final GoodwillGrant grant = new GoodwillGrant("12.00", GoodwillType.PREDEFINED, AmountVatType.INCLUDES_VAT, currentDate);
		this.tmState.giveGoodwillOf(grant);
	}

	// void assertBalanceAsExpected() {
	// this.
	// }

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}