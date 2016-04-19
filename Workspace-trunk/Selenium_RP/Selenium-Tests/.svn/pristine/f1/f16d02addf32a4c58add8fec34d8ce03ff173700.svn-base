package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @deprecated I think. Try to use amounts without VAT that can have it added instead. You could also always init those with inclusive amount too, and have them
 *             work it back on init.
 */
@Deprecated
class MonetaryAmount implements Comparable<MonetaryAmount>, Serializable {
	private BigDecimal decimal;

	MonetaryAmount(final String amount) {
		this.decimal = CurrencyHelp.currencyAmountOf(amount);
	}

	MonetaryAmount(final BigDecimal amount) {
		this.decimal = CurrencyHelp.currencyAmountOf(amount);
	}

	void changeAmountTo(final String amount) {
		this.decimal = CurrencyHelp.currencyAmountOf(amount);
	}

	void add(final BigDecimal add) {
		this.decimal = this.decimal.add(add).setScale(CurrencyHelp.CURRENCY_SCALE);
	}

	BigDecimal toBigDecimal() {
		return this.decimal;
	}

	String toCashString() {
		final String str = CurrencyHelp.asCashString(this.decimal);
		return str;
	}

	@Override
	public int compareTo(final MonetaryAmount other) {
		final int comp = this.toBigDecimal().compareTo(other.toBigDecimal());
		return comp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.decimal == null) ? 0 : this.decimal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		MonetaryAmount other = (MonetaryAmount) obj;
		if (this.decimal == null) {
			if (other.decimal != null) {
				return false;
			}
		} else if (!this.decimal.equals(other.decimal)) {
			return false;
		}
		return true;
	}
}