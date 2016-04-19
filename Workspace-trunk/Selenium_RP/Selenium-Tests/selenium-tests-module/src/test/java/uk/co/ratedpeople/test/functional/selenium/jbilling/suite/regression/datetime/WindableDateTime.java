package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.datetime;

import java.util.Calendar;
import java.util.Date;

/**
 * A Date/Time that can be wound forward.
 */
public class WindableDateTime {

	public static class EasyDate {
		private final int dayOfMonth;
		private final int month;
		private final int year;

		public static class Builder {
			public static Builder with() {
				return new Builder();
			}

			private int dayOfMonth;
			private int month;
			private int year;

			private Builder() {
			}

			public Builder dayOfMonth(final int dayOfMonth) {
				this.dayOfMonth = dayOfMonth;
				return this;
			}

			public Builder month(final int month) {
				this.month = month;
				return this;
			}

			public Builder year(final int year) {
				this.year = year;
				return this;
			}

			public EasyDate build() {
				final EasyDate date = new EasyDate(this.dayOfMonth, this.month, this.year);
				return date;
			}
		}

		public EasyDate(final int dayOfMonth, final int month, final int year) {
			super();
			this.dayOfMonth = dayOfMonth;
			this.month = month;
			this.year = year;
		}

		public int getDayOfMonth() {
			return this.dayOfMonth;
		}

		public int getMonth() {
			return this.month;
		}

		public int getYear() {
			return this.year;
		}

		public void applyTo(final Calendar calendar) {
			calendar.set(Calendar.YEAR, getYear());
			calendar.set(Calendar.MONTH, getMonth());
			calendar.set(Calendar.DAY_OF_MONTH, getDayOfMonth());
			// adjust time too.
			calendar.set(Calendar.HOUR, 1);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
		}

		public Date toDate() {
			final Calendar cal = Calendar.getInstance();
			this.applyTo(cal);
			final Date date = cal.getTime();
			return date;
		}
	}
	// we will do this \/ in another class, specific to that - this is purely about winding dates on.
	// private final JBillingRegression timeController;
	private final Calendar calendar;

	private WindableDateTime() {
		super();
		this.calendar = Calendar.getInstance();
	}

	public WindableDateTime(/* final JBillingRegression timeController, */final EasyDate easyDate) {
		this();
		// this.timeController = timeController;
		this.setDate(easyDate);
	}

	public WindableDateTime(final Date date) {
		this();
		this.setDate(date);
	}

	public void windForwardDaysBy(final int numOfDays) {
		this.calendar.add(Calendar.DAY_OF_MONTH, numOfDays);
	}

	public void windForwardOneDay() {
		this.windForwardDaysBy(1);
	}

	public void windForwardMonthsBy(final int numOfMonths) {
		this.calendar.add(Calendar.MONTH, numOfMonths);
	}

	public void windForwardOneMonth() {
		this.windForwardMonthsBy(1);
	}

	public void windForwardYearsBy(final int numOfYears) {
		this.calendar.add(Calendar.YEAR, numOfYears);
	}

	public void windForwardOneYear() {
		this.windForwardYearsBy(1);
	}

	public void setDate(final Date newDate) {
		this.calendar.setTime(newDate);
	}

	public void setDate(final EasyDate easyDate) {
		easyDate.applyTo(this.calendar);
	}

	public Date getDate() {
		final Date date = this.calendar.getTime();
		return date;
	}

}
