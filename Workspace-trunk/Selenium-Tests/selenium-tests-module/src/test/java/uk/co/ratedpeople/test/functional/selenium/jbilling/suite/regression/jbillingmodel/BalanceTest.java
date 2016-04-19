package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.jbillingmodel;

import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.jbillingmodel.Balance.CannotChargeCardForOverspendException;

/**
 * Tests {@link Balance} works correctly.
 */
public class BalanceTest {
	/** The scale (number of decimal-places) for currency. */
	private static final int CURRENCY_SCALE = 2;
	/** Zero, to two decimal places, for currency/cash. */
	private static final BigDecimal ZERO_CASH_STYLE = BigDecimal.ZERO.setScale(CURRENCY_SCALE);

	private BigDecimal smallAmount;
	private BigDecimal midAmount;

	private Balance balance;

	@BeforeMethod
	public void beforeMethod() {
		this.smallAmount = new BigDecimal("12.08").setScale(CURRENCY_SCALE);
		this.midAmount = new BigDecimal("22.24").setScale(CURRENCY_SCALE);

		this.balance = new Balance();
	}

	@Test
	public void testAllZerosWithSpendIsOk() {
		final BigDecimal spend = this.midAmount;

		balance.spendThroughCredit(spend);

		Assert.assertEquals(balance.getFreeBalance(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getChargedCard(), spend);
		Assert.assertEquals(balance.getSpecialCredit(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpent(), spend);
		Assert.assertEquals(balance.getOverallBalance(), ZERO_CASH_STYLE);

		System.out.println("spent: " + balance.getSpent());
	}

	@Test
	public void testAllZerosWithCreditIsOk() {
		final BigDecimal credit = this.midAmount;

		balance.grantSpecialCredit(credit);

		Assert.assertEquals(balance.getFreeBalance(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getChargedCard(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpecialCredit(), credit);
		Assert.assertEquals(balance.getSpent(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getOverallBalance(), credit);
	}

	@Test
	public void testAllZerosWithSpendAndCreditOfSameAmountIsOk() {
		balance.spendThroughCredit(midAmount);
		balance.grantSpecialCredit(midAmount);

		Assert.assertEquals(balance.getFreeBalance(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpecialCredit(), midAmount); // credit goes here
		Assert.assertEquals(balance.getChargedCard(), midAmount); // freeBalance was zero, so spent it
		Assert.assertEquals(balance.getSpent(), midAmount); // TODO should this be spend, ignoring credits? do we want another balance with that floating
															// balance?
		Assert.assertEquals(balance.getOverallBalance(), midAmount);

		// TODO should also check computed debt
	}

	@Test
	public void testAllZerosWithSpendAndCreditOfLesserAmountOk() {
		balance.spendThroughCredit(midAmount);
		balance.spendThroughCredit(midAmount);
		balance.grantSpecialCredit(midAmount);

		Assert.assertEquals(balance.getFreeBalance(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpecialCredit(), midAmount);
		final BigDecimal twice = midAmount.multiply(BigDecimal.valueOf(2));
		Assert.assertEquals(balance.getChargedCard(), twice);
		Assert.assertEquals(balance.getSpent(), twice);
		Assert.assertEquals(balance.getOverallBalance(), midAmount);
	}

	@Test
	public void testAllZerosWithSpendAndCreditAfterOfLargerAmountOk() {
		balance.spendThroughCredit(midAmount);
		balance.grantSpecialCredit(midAmount);
		balance.grantSpecialCredit(midAmount);

		final BigDecimal twice = midAmount.multiply(BigDecimal.valueOf(2));
		Assert.assertEquals(balance.getFreeBalance(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpecialCredit(), twice);
		Assert.assertEquals(balance.getChargedCard(), midAmount);
		Assert.assertEquals(balance.getSpent(), midAmount);
		Assert.assertEquals(balance.getOverallBalance(), twice);
	}

	@Test
	public void testFreeBalanceWithSpendIsOk() {
		balance = Balance.withFreeBalance(midAmount);
		balance.spendThroughCredit(midAmount);

		Assert.assertEquals(balance.getFreeBalance(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpecialCredit(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getChargedCard(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpent(), midAmount);
		Assert.assertEquals(balance.getOverallBalance(), ZERO_CASH_STYLE);
	}

	@Test
	public void testFreeBalanceWithCreditAndIsOk() {
		balance = Balance.withSpecialCredit(midAmount);

		Assert.assertEquals(balance.getFreeBalance(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpecialCredit(), midAmount);
		Assert.assertEquals(balance.getChargedCard(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpent(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getOverallBalance(), midAmount);
	}

	@Test
	public void testNoFreeBalanceWithSpendAndCreditOfSameAmountIsOk() {
		balance = Balance.withSpecialCredit(midAmount);
		Assert.assertEquals(balance.getSpecialCredit(), midAmount);
		balance.spendThroughCredit(midAmount);

		Assert.assertEquals(balance.getFreeBalance(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpecialCredit(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getChargedCard(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpent(), midAmount);
		Assert.assertEquals(balance.getOverallBalance(), ZERO_CASH_STYLE);
	}

	@Test
	public void testNoFreeBalanceWithSpendAndCreditOfLesserAmountIsOk() {
		balance = Balance.withSpecialCredit(smallAmount);
		Assert.assertEquals(balance.getSpecialCredit(), smallAmount);

		balance.spendThroughCredit(midAmount);

		final BigDecimal difference = midAmount.subtract(smallAmount);

		Assert.assertEquals(balance.getFreeBalance(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpecialCredit(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getChargedCard(), difference);
		Assert.assertEquals(balance.getSpent(), midAmount);
		Assert.assertEquals(balance.getOverallBalance(), ZERO_CASH_STYLE);
	}

	@Test
	public void testNoFreeBalanceWithSpendAndCreditOfLargerAmountIsOk() {
		balance = Balance.withSpecialCredit(midAmount);
		Assert.assertEquals(balance.getSpecialCredit(), midAmount);

		balance.spendThroughCredit(smallAmount);

		final BigDecimal difference = midAmount.subtract(smallAmount);

		Assert.assertEquals(balance.getFreeBalance(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpecialCredit(), difference);
		Assert.assertEquals(balance.getChargedCard(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpent(), smallAmount);
		Assert.assertEquals(balance.getOverallBalance(), difference);
	}

	@Test
	public void testFreeBalanceWithSpendAndCreditOfSameAmountIsOk() {
		balance = Balance.withSpecialCredit(midAmount);
		balance.setFreeBalance(midAmount);

		Assert.assertEquals(balance.getSpecialCredit(), midAmount);
		balance.spendThroughCredit(midAmount);

		Assert.assertEquals(balance.getFreeBalance(), midAmount);
		Assert.assertEquals(balance.getSpecialCredit(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getChargedCard(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpent(), midAmount);
		Assert.assertEquals(balance.getOverallBalance(), midAmount);
	}

	@Test
	public void testFreeBalanceWithSpendAndCreditOfLesserAmountIsOk() {
		balance = Balance.withSpecialCredit(smallAmount);
		balance.setFreeBalance(midAmount);
		Assert.assertEquals(balance.getSpecialCredit(), smallAmount);

		balance.spendThroughCredit(midAmount);

		final BigDecimal overspill = midAmount.subtract(smallAmount);
		final BigDecimal newFreeBalance = midAmount.subtract(overspill).setScale(CURRENCY_SCALE);

		Assert.assertEquals(balance.getFreeBalance(), newFreeBalance);
		Assert.assertEquals(balance.getSpecialCredit(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getChargedCard(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpent(), midAmount);
		Assert.assertEquals(balance.getOverallBalance(), newFreeBalance);
	}

	@Test
	public void testFreeBalanceWithSpendAndCreditOfLargerAmountIsOk() {
		balance = Balance.withSpecialCredit(midAmount);
		balance.setFreeBalance(midAmount);
		Assert.assertEquals(balance.getSpecialCredit(), midAmount);

		balance.spendThroughCredit(smallAmount);

		final BigDecimal difference = midAmount.subtract(smallAmount);

		Assert.assertEquals(balance.getFreeBalance(), midAmount);
		Assert.assertEquals(balance.getSpecialCredit(), difference);
		Assert.assertEquals(balance.getChargedCard(), ZERO_CASH_STYLE);
		Assert.assertEquals(balance.getSpent(), smallAmount);
		Assert.assertEquals(balance.getOverallBalance(), midAmount.add(difference));
	}

	/**
	 * TODO change Exception to be more specific CannotChargeCardForOverspendException
	 */
	@Test(expectedExceptions = CannotChargeCardForOverspendException.class)
	public void testThrowsFailedPaymentIfAttemptOverspendAndChargingNotPermitted() {
		balance.forbidCardCharging();
		Assert.assertFalse(balance.isCardChargingPermitted(), "Card charging should've been forbidden!");
		// this next call should trigger a CannotChargeCardForOverspendException...
		balance.spendThroughCredit(midAmount);
	}
}
