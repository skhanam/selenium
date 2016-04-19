package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money;

import java.math.BigDecimal;

/**
 * Perhaps to take over from {@link MonetaryAmount}
 */
public class TaxableAmount {

	public static TaxableAmount newWithSansVatValue(final String sansVatString) {
		final TaxableAmount amount = new TaxableAmount(sansVatString);
		return amount;
	}

	public static TaxableAmount newWithSansVatValue(final BigDecimal sansVat) {
		final TaxableAmount amount = new TaxableAmount(sansVat);
		return amount;
	}

	public static TaxableAmount newWithIncludedVatValue(final BigDecimal withVat) {
		final ValueAddedTaxRater vatRater = new ValueAddedTaxRater();
		final BigDecimal sansVat = vatRater.unrate(withVat);
		final TaxableAmount amount = new TaxableAmount(sansVat);
		return amount;
	}

	public static TaxableAmount newWithIncludedVatValue(final String withVatString) {
		final BigDecimal withVat = new BigDecimal(withVatString); // Currency scale will be applied for us, so don't worry
		final TaxableAmount amount = newWithIncludedVatValue(withVat);
		return amount;
	}

	private MonetaryAmount amountSansVat;
	private ValueAddedTaxRater vatRater;

	private TaxableAmount(final String amountSansVatAsString) {
		this.amountSansVat = new MonetaryAmount(amountSansVatAsString);
		this.vatRater = new ValueAddedTaxRater();
	}

	private TaxableAmount(final BigDecimal amountSansVat) {
		this.amountSansVat = new MonetaryAmount(amountSansVat);
		this.vatRater = new ValueAddedTaxRater();
	}

	public MonetaryAmount getMonetaryAmountSansVat() {
		return this.amountSansVat;
	}

	public BigDecimal getAmountSansVat() {
		return this.amountSansVat.toBigDecimal();
	}

	public BigDecimal getAmountWithVat() {
		final BigDecimal withVat = this.vatRater.rate(this.amountSansVat.toBigDecimal());
		return withVat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.amountSansVat == null) ? 0 : this.amountSansVat.hashCode());
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
		TaxableAmount other = (TaxableAmount) obj;
		if (this.amountSansVat == null) {
			if (other.amountSansVat != null) {
				return false;
			}
		} else if (!this.amountSansVat.equals(other.amountSansVat)) {
			return false;
		}
		return true;
	}
}