package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.datetime;

import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests for {@link DateRange}
 */
public class DateRangeTest {
	static class TestData {
		private Date earlierDate;
		private Date midDate;
		private Date laterDate;

		TestData() {
			buildDates();
		}

		private void buildDates() {
			buildEarlyDate();
			buildMidDate();
			buildLaterDate();
		}

		private void buildEarlyDate() {
			final Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 1982);
			cal.set(Calendar.MONTH, 8);
			cal.set(Calendar.DAY_OF_MONTH, 23);
			cal.set(Calendar.HOUR_OF_DAY, 11);
			cal.set(Calendar.MINUTE, 0);
			final Date date = cal.getTime();
			this.earlierDate = date;
		}

		private void buildMidDate() {
			final Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2012);
			cal.set(Calendar.MONTH, 6);
			cal.set(Calendar.DAY_OF_MONTH, 17);
			cal.set(Calendar.HOUR_OF_DAY, 9);
			cal.set(Calendar.MINUTE, 0);
			final Date date = cal.getTime();
			this.midDate = date;
		}

		private void buildLaterDate() {
			final Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2015);
			cal.set(Calendar.MONTH, 3);
			cal.set(Calendar.DAY_OF_MONTH, 8);
			cal.set(Calendar.HOUR_OF_DAY, 2);
			cal.set(Calendar.MINUTE, 0);
			final Date date = cal.getTime();
			this.laterDate = date;
		}

		Date getEarlierDate() {
			return this.earlierDate;
		}

		Date getMidDate() {
			return this.midDate;
		}

		Date getLaterDate() {
			return this.laterDate;
		}
	}

	private static enum ExpectedResult {
		WITHIN, OUTSIDE;
	}

	private TestData testData;

	@BeforeMethod
	public void beforeMethod() {
		this.testData = new TestData();
	}

	@Test
	public void testWithinBoundedRange() {
		final Date testDate = this.testData.getMidDate();
		final ExpectedResult expected = ExpectedResult.WITHIN;

		final DateRange range = new DateRange();
		range.setStartDate(this.testData.getEarlierDate());
		range.setEndDate(this.testData.getLaterDate());

		final boolean expectedCovers = ExpectedResult.WITHIN.equals(expected);
		Assert.assertEquals(range.covers(testDate), expectedCovers, "Wrong: Expected Date to be: " + expected + " range.");
	}

	@Test
	public void testWithinOngoingRange() {
		final Date testDate = this.testData.getMidDate();
		final ExpectedResult expected = ExpectedResult.WITHIN;

		final DateRange range = new DateRange();
		range.setStartDate(this.testData.getEarlierDate());
		range.setEndDate(null); // just emphasise null

		final boolean expectedCovers = ExpectedResult.WITHIN.equals(expected);
		Assert.assertEquals(range.covers(testDate), expectedCovers, "Wrong: Expected Date to be: " + expected + " range.");
	}

	@Test
	public void testNotInBoundedRange() {
		final Date testDate = this.testData.getLaterDate();
		final ExpectedResult expected = ExpectedResult.OUTSIDE;

		final DateRange range = new DateRange();
		range.setStartDate(this.testData.getEarlierDate());
		range.setEndDate(this.testData.getMidDate());

		final boolean expectedCovers = ExpectedResult.WITHIN.equals(expected);
		Assert.assertEquals(range.covers(testDate), expectedCovers, "Wrong: Expected Date to be: " + expected + " range.");
	}

	@Test
	public void testNotInBoundedRangeLessThan() {
		final Date testDate = this.testData.getEarlierDate();
		final ExpectedResult expected = ExpectedResult.OUTSIDE;

		final DateRange range = new DateRange();
		range.setStartDate(this.testData.getMidDate());
		range.setEndDate(this.testData.getLaterDate());

		final boolean expectedCovers = ExpectedResult.WITHIN.equals(expected);
		Assert.assertEquals(range.covers(testDate), expectedCovers, "Wrong: Expected Date to be: " + expected + " range.");
	}

	@Test
	public void testNotInOngoingRange() {
		final Date testDate = this.testData.getEarlierDate();
		final ExpectedResult expected = ExpectedResult.OUTSIDE;

		final DateRange range = new DateRange();
		range.setStartDate(this.testData.getMidDate());
		range.setEndDate(null); // emphasise null

		final boolean expectedCovers = ExpectedResult.WITHIN.equals(expected);
		Assert.assertEquals(range.covers(testDate), expectedCovers, "Wrong: Expected Date to be: " + expected + " range.");
	}

}
