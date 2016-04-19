package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyHelp {
	/** The symbol for currency. */
	public static final String CURRENCY_SYMBOL = "£";

	/** The scale (number of decimal-places) for currency. */
	public static final int CURRENCY_SCALE = 2;

	/** Zero, in a currency-style - so to two decimal places. */
	public static final BigDecimal ZERO_CASH_STYLE = BigDecimal.ZERO.setScale(CURRENCY_SCALE);

	public static BigDecimal currencyAmountOf(final String amountAsString) {
		final BigDecimal amount = new BigDecimal(amountAsString).setScale(CURRENCY_SCALE);
		return amount;
	}

	public static BigDecimal currencyAmountOf(final BigDecimal amount) {
		final BigDecimal bd = amount.setScale(CURRENCY_SCALE, RoundingMode.HALF_UP);
		return bd;
	}

	public static String asCashString(final BigDecimal mon) {
		final String monStr = mon.toPlainString();
		final String done = CURRENCY_SYMBOL + monStr;
		return done;
	}
}