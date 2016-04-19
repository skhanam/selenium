package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression;

import java.math.BigDecimal;
import java.util.Date;

import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money.AmountVatType;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money.CurrencyHelp;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money.ValueAddedTaxRater;

public class GoodwillGrant {
	private final BigDecimal amount;
	private final GoodwillType type;
	private final AmountVatType amountVatType;
	private final Date goodwillDate;
	private final ValueAddedTaxRater vatRater;

	public GoodwillGrant(final String amount, final GoodwillType type, final AmountVatType amountVatType, final Date goodwillDate) {
		this(new BigDecimal(amount).setScale(CurrencyHelp.CURRENCY_SCALE), type, amountVatType, goodwillDate);
	}

	public GoodwillGrant(final BigDecimal amount, final GoodwillType type, final AmountVatType amountVatType, final Date goodwillDate) {
		super();
		this.vatRater = new ValueAddedTaxRater();
		this.amount = amount;
		this.type = type;
		this.amountVatType = amountVatType;
		this.goodwillDate = goodwillDate;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public AmountVatType getAmountVatType() {
		return this.amountVatType;
	}

	public GoodwillType getType() {
		return this.type;
	}

	public BigDecimal getAmountWithVat() {
		if (AmountVatType.INCLUDES_VAT.equals(this.getAmountVatType())) {
			return this.getAmount();
		}
		// calc with vat
		// final BigDecimal withVat = this.getAmount().multiply(getCurrentVatAmount()).setScale(CurrencyHelp.CURRENCY_SCALE);
		final BigDecimal withVat = this.vatRater.rate(this.getAmount());
		return withVat;
	}

	// private BigDecimal getCurrentVatAmount() {
	// final BigDecimal vat = this.vatRater.getVatRateAtDate(this.goodwillDate);
	// return vat;
	// }
}