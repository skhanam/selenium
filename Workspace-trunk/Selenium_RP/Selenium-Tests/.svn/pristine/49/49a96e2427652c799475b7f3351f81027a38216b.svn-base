package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.datetime;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * A range of Dates
 */
public class DateRange implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date startDate;
	private Date endDate;

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(final Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(final Date endDate) {
		this.endDate = endDate;
	}

	public boolean isOngoing() {
		final boolean ongoing = this.getEndDate() == null;
		return ongoing;
	}

	public boolean covers(final Date date) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		final boolean inStartRange = isCoveredByStartDate(cal);
		final boolean inEndRange = isCoveredByEndDate(cal);
		final boolean in = (inStartRange && inEndRange);
		return in;
	}

	private boolean isCoveredByStartDate(final Calendar cal) {
		final Calendar startCal = getStartCal();
		final boolean inStartRange = (startCal == null) || startCal.before(cal);
		return inStartRange;
	}

	private boolean isCoveredByEndDate(final Calendar cal) {
		final Calendar endCal = getEndCal();
		final boolean inEndRange = (endCal == null) || endCal.after(cal);
		return inEndRange;
	}

	private Calendar getStartCal() {
		final Date date = this.getStartDate();
		final Calendar startCal = calendarOrNullFrom(date);
		return startCal;
	}

	private Calendar calendarOrNullFrom(final Date date) {
		if (date == null) {
			return null;
		}
		final Calendar startCal = Calendar.getInstance();
		startCal.setTime(date);
		return startCal;
	}

	private Calendar getEndCal() {
		final Date date = this.getEndDate();
		final Calendar endCal = calendarOrNullFrom(date);
		return endCal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.endDate == null) ? 0 : this.endDate.hashCode());
		result = prime * result + ((this.startDate == null) ? 0 : this.startDate.hashCode());
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
		DateRange other = (DateRange) obj;
		if (this.endDate == null) {
			if (other.endDate != null) {
				return false;
			}
		} else if (!this.endDate.equals(other.endDate)) {
			return false;
		}
		if (this.startDate == null) {
			if (other.startDate != null) {
				return false;
			}
		} else if (!this.startDate.equals(other.startDate)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
