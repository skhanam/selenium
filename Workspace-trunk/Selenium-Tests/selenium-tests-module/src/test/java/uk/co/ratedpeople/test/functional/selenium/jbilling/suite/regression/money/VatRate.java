package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money;

import java.math.BigDecimal;

/**
 * Represents a VAT (Value Added Tax Rate)
 * 
 * @see {@link DatedVatRate} for a VAT Rate that can tell you what dates it applies on.
 * 
 */
public class VatRate {
	/** So can cope with the half-scales, like the old 17.5% (which becomes 1.175) */
	private static final int SCALE = 3;

	/** the VAT percentage. */
	private final BigDecimal percentage;

	VatRate(final BigDecimal percentage) {
		super();
		this.percentage = percentage;
	}

	VatRate(final String percentage) {
		this(new BigDecimal(percentage));
	}

	BigDecimal getPercentage() {
		return this.percentage;
	}

	BigDecimal getMultiplicand() {
		final BigDecimal dividedDown = this.getPercentage().divide(BigDecimal.valueOf(100).setScale(SCALE)); // , RoundingMode.HALF_UP).setScale(SCALE);
		final BigDecimal multiplicant = BigDecimal.ONE.add(dividedDown).setScale(SCALE);
		return multiplicant;
	}

	@Override
	public String toString() {
		final String str = super.toString() + " { percentage: '" + this.getPercentage() + "', multiplicand: '" + this.getMultiplicand() + "' }";
		return str;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.percentage == null) ? 0 : this.percentage.hashCode());
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
		VatRate other = (VatRate) obj;
		if (this.percentage == null) {
			if (other.percentage != null) {
				return false;
			}
		} else if (!this.percentage.equals(other.percentage)) {
			return false;
		}
		return true;
	}
}