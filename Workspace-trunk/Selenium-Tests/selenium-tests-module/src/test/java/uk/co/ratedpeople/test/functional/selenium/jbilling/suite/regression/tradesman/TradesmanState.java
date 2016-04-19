package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.tradesman;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.GoodwillGrant;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.jbillingmodel.Balance;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.jbillingmodel.PlanGroup;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.jbillingmodel.PlanInstance;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.jbillingmodel.PlanSpec;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money.TaxableAmount;

public class TradesmanState implements Serializable {
	private static final long serialVersionUID = 1L;

	private String idCode;
	private String userName;
	private String id;

	private Balance balance;
	private PlanInstance startPlan;
	private PlanGroup plans;

	private boolean shouldHaveCard;

	TradesmanState() {
		this.balance = new Balance();
		this.plans = new PlanGroup();
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Balance getBalance() {
		return this.balance;
	}

	public void setBalance(final Balance balance) {
		this.balance = balance;
	}

	public PlanInstance getStartPlan() {
		return this.startPlan;
	}
	
	/**
	 * Should provide a {@link PlanInstance} really instead - see {@link #setStartPlan(PlanInstance)}.
	 * 
	 * @param planSpec
	 */
	@Deprecated
	public void setStartPlan(final PlanSpec planSpec) {
		final PlanInstance newPlan = new PlanInstance(planSpec);
		this.setStartPlan(newPlan);
	}
	
	public void startPlanBegins() {
		this.startPlan.begin();
		this.initBalanceFromStartPlan();
	}

	public void setStartPlan(final PlanInstance currentPlan) {
		this.startPlan = currentPlan;
		this.plans.add(this.startPlan);
//		this.initBalanceFromStartPlan(); // no, do on begins().
	}

	private void initBalanceFromStartPlan() {
		// this.getBalance().setFreeBalance(this.getStartPlan().getInclusiveCredit());
		final TaxableAmount inclusiveCredit = this.getStartPlan().getInclusiveCredit();
		final Balance bal = Balance.withFreeBalance(inclusiveCredit.getAmountWithVat());
		this.setBalance(bal);
	}

	public boolean isShouldHaveCard() {
		return this.shouldHaveCard;
	}

	public void setShouldHaveCard(final boolean shouldHaveCard) {
		this.shouldHaveCard = shouldHaveCard;
	}

	public String getIdCode() {
		return this.idCode;
	}

	public void setIdCode(final String idCode) {
		this.idCode = idCode;
	}

	public void spendThroughCredit(final BigDecimal priceForTm) {
		this.getBalance().spendThroughCredit(priceForTm);
		/* TODO Balance object needs to know about creditCard - maybe wrap Balance in
		 *  a Spender or something (MoneyAccount?) that can credit/spend, uses balance, on-file Card if present when required, etc. */
	}

	public String getFreeBalanceCurrencyString() {
		final String cost = getBalance().getFreeBalanceCurrencyString();
		return cost;
	}

	public String getOverallBalanceCurrencyString() {
		final String amount = getBalance().getOverallBalanceCurrencyString();
		return amount;
	}

	public void giveLeadCredit(final BigDecimal priceForTm) {
		this.getBalance().grantSpecialCredit(priceForTm);
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public void giveGoodwillOf(final GoodwillGrant grant) {
		this.getBalance().grantGoodwill(grant);
	}


}