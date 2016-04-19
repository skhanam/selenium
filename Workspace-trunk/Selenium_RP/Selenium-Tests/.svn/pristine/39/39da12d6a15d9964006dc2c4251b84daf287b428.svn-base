package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.jbillingmodel;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.datetime.DateRange;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money.TaxableAmount;

/**
 * An instance of a Plan
 */
public class PlanInstance implements Serializable {
	public static class Comparators {
		public static final int LESS_THAN = -1;
		public static final int EQUAL = 0;
		public static final int MORE_THAN = 1;

		/**
		 * Compares two {@link PlanInstance} objects, by comparing their <code>startDate</code> values. Can be used to sort them ascending
		 */
		public static class StartDateComparator implements Comparator<PlanInstance> {
			@Override
			public int compare(final PlanInstance o1, final PlanInstance o2) {
				if (o1 == null && o2 != null) {
					return LESS_THAN;
				}
				if (o1 != null && o2 == null) {
					return MORE_THAN;
				}
				if (o1 == o2 || o1.equals(o2)) {
					return EQUAL;
				}
				final Calendar startCal = asCalendar(o1.getActiveRange().getStartDate());
				final Calendar endCal = asCalendar(o2.getActiveRange().getEndDate());
				final int comparison = startCal.compareTo(endCal);
				return comparison;
			}

			private Calendar asCalendar(final Date date) {
				final Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				return cal;
			}
		}
	}

	private static final long serialVersionUID = 1L;

	private final PlanSpec planSpec;
	private final DateRange activeRange;

	public PlanInstance(final PlanSpec planSpec) {
		this.planSpec = planSpec;
		this.activeRange = new DateRange();
	}

	public PlanSpec getPlanSpec() {
		return this.planSpec;
	}

	public DateRange getActiveRange() {
		return this.activeRange;
	}

	public void begin() {
		this.setStartDate(getCurrentTestDate());
	}

	public void setStartDate(final Date startDate) {
		this.getActiveRange().setStartDate(startDate);
	}

	public void setEndDate(final Date endDate) {
		this.getActiveRange().setEndDate(endDate);
	}

	public boolean isActiveOn(final Date date) {
		final boolean is = this.getActiveRange().covers(date);
		return is;
	}

	@Deprecated
	private Date getCurrentTestDate() {
		// TODO needs changing to get Date from pretend (windable) date
		return new Date();
	}

	public TaxableAmount getInclusiveCredit() {
		return this.getPlanSpec().getInclusiveCredit();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.activeRange == null) ? 0 : this.activeRange.hashCode());
		result = prime * result + ((this.planSpec == null) ? 0 : this.planSpec.hashCode());
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
		PlanInstance other = (PlanInstance) obj;
		if (this.activeRange == null) {
			if (other.activeRange != null) {
				return false;
			}
		} else if (!this.activeRange.equals(other.activeRange)) {
			return false;
		}
		if (this.planSpec == null) {
			if (other.planSpec != null) {
				return false;
			}
		} else if (!this.planSpec.equals(other.planSpec)) {
			return false;
		}
		return true;
	}

}
