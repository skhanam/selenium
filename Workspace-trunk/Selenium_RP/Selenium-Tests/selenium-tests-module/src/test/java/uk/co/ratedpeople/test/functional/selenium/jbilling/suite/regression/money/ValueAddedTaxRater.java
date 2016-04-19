package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ValueAddedTaxRater {
	static final VatRate TWENTY_PERCENT_RATE = new VatRate("20");
	private static final Logger LOGGER = Logger.getLogger(ValueAddedTaxRater.class.getName());

	public VatRate getVatRateAtDate(final Date date) {
		return TWENTY_PERCENT_RATE;
	}

	public BigDecimal rate(final BigDecimal bigDecimal) {
		final Date date = getCurrentPretendDate();
		final BigDecimal vatRateAtDate = getVatRateAtDate(date).getMultiplicand();
		final BigDecimal scaled = CurrencyHelp.currencyAmountOf(bigDecimal); // .setScale(CurrencyHelp.CURRENCY_SCALE);
		LOGGER.log(Level.INFO, "About to multiply: " + scaled + " by: " + vatRateAtDate);
		final BigDecimal multiplied = scaled.multiply(vatRateAtDate); // , MathContext.UNLIMITED);
		final BigDecimal bd = CurrencyHelp.currencyAmountOf(multiplied); // multiplied.setScale(CurrencyHelp.CURRENCY_SCALE, RoundingMode.HALF_UP);
		return bd;
	}

	private Date getCurrentPretendDate() {
		return new Date(); // TODO for now, just return now
	}

	public BigDecimal unrate(final BigDecimal withVat) {
		final Date date = getCurrentPretendDate();
		final BigDecimal scaled = CurrencyHelp.currencyAmountOf(withVat); // withVat.setScale(CurrencyHelp.CURRENCY_SCALE);
		final BigDecimal vatRateAtDate = getVatRateAtDate(date).getMultiplicand();
		LOGGER.log(Level.INFO, "About to divide: " + scaled + " by: " + vatRateAtDate);
		final BigDecimal divided = scaled.divide(vatRateAtDate, RoundingMode.HALF_UP);
		final BigDecimal sansVat = CurrencyHelp.currencyAmountOf(divided); // divided.setScale(CurrencyHelp.CURRENCY_SCALE);
		return sansVat;
	}
}