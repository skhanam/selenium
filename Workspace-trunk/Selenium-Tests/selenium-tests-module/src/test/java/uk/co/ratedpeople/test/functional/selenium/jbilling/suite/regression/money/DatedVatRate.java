package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money;

import java.util.Date;

import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.datetime.DateRange;

/**
 * A VAT Rate, with the active Date-Range.
 */
public class DatedVatRate {
	private final VatRate vatRate;
	private final DateRange activeDates;

	public DatedVatRate(final VatRate vatRate, final DateRange activeDates) {
		assert (vatRate != null);
		assert (activeDates != null);
		this.vatRate = vatRate;
		this.activeDates = activeDates;
	}

	public VatRate getVatRate() {
		return this.vatRate;
	}

	public DateRange getActiveDates() {
		return this.activeDates;
	}

	public boolean isActiveOn(final Date date) {
		final boolean is = this.getActiveDates().covers(date);
		return is;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.activeDates == null) ? 0 : this.activeDates.hashCode());
		result = prime * result + ((this.vatRate == null) ? 0 : this.vatRate.hashCode());
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
		DatedVatRate other = (DatedVatRate) obj;
		if (this.activeDates == null) {
			if (other.activeDates != null) {
				return false;
			}
		} else if (!this.activeDates.equals(other.activeDates)) {
			return false;
		}
		if (this.vatRate == null) {
			if (other.vatRate != null) {
				return false;
			}
		} else if (!this.vatRate.equals(other.vatRate)) {
			return false;
		}
		return true;
	}

}
