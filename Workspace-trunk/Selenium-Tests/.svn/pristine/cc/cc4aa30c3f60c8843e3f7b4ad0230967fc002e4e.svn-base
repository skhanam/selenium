package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.datetime;

import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit Tests for {@link WindableDateTime}.
 */
public class WindableDateTimeTest {

	@Test
	public void testBasicInit() {
		final Date date = buildADate();

		final WindableDateTime windable = new WindableDateTime(date);

		Assert.assertEquals(windable.getDate(), date, "Output Date should match input Date!");
	}

	@Test
	public void testSettingDate() {
		final Date date = buildADate();

		final WindableDateTime windable = new WindableDateTime(date);

		Assert.assertEquals(windable.getDate(), date, "Output Date should match input Date!");

		final Calendar calTwo = buildACalendar();
		calTwo.set(Calendar.DAY_OF_MONTH, 2);
		calTwo.set(Calendar.MONTH, 3);
		calTwo.set(Calendar.YEAR, 2014);
		final Date dateTwo = calTwo.getTime();

		windable.setDate(dateTwo);

		Assert.assertEquals(windable.getDate(), dateTwo, "Output Date should match input Date after setDate() call!");
	}

	@Test
	public void testWindingOnDateOneDayViaHelper() {
		final Calendar cal = buildACalendar();
		final Date date = cal.getTime();

		final WindableDateTime windable = new WindableDateTime(date);
		windable.windForwardOneDay();

		cal.add(Calendar.DAY_OF_YEAR, 1);

		Assert.assertEquals(windable.getDate(), cal.getTime(), "Output Date not what it should be");
	}

	@Test
	public void testWindingOnDateOneDayViaXDaysCall() {
		final int numOfDays = 1;
		testWindingForwardDaysBy(numOfDays);
	}

	@Test
	public void testWindingOnDateThreeDaysViaXDaysCall() {
		final int numOfDays = 3;
		testWindingForwardDaysBy(numOfDays);
	}

	@Test
	public void testWindingOnDateTwentyFourDaysViaXDaysCall() {
		final int numOfDays = 24;
		testWindingForwardDaysBy(numOfDays);
	}

	@Test
	public void testWindingOnDateThirtyTwoDaysViaXDaysCall() {
		final int numOfDays = 32;
		testWindingForwardDaysBy(numOfDays);
	}

	private void testWindingForwardDaysBy(final int numOfDays) {
		final Calendar cal = buildACalendar();
		final Date date = cal.getTime();

		final WindableDateTime windable = new WindableDateTime(date);
		windable.windForwardDaysBy(numOfDays);

		cal.add(Calendar.DAY_OF_YEAR, numOfDays);

		Assert.assertEquals(windable.getDate(), cal.getTime(), "Output Date not what it should be");
	}

	@Test
	public void testWindingOnDateOneMonthViaHelper() {
		final Calendar cal = buildACalendar();
		final Date date = cal.getTime();

		final WindableDateTime windable = new WindableDateTime(date);
		windable.windForwardOneMonth();

		cal.add(Calendar.MONTH, 1);

		Assert.assertEquals(windable.getDate(), cal.getTime(), "Output Date not what it should be");
	}

	@Test
	public void testWindingOnDateOneMonthsViaXMonthsCall() {
		final int numOfMonths = 1;
		testWindingForwardMonthsBy(numOfMonths);
	}

	@Test
	public void testWindingOnDateThreeMonthsViaXMonthsCall() {
		final int numOfMonths = 3;
		testWindingForwardMonthsBy(numOfMonths);
	}

	@Test
	public void testWindingOnDateTwelveMonthsViaXMonthsCall() {
		final int numOfMonths = 12;
		testWindingForwardMonthsBy(numOfMonths);
	}

	@Test
	public void testWindingOnDateThirteenMonthsViaXMonthsCall() {
		final int numOfMonths = 13;
		testWindingForwardMonthsBy(numOfMonths);
	}

	@Test
	public void testWindingOnDateSixteenMonthsViaXMonthsCall() {
		final int numOfMonths = 16;
		testWindingForwardMonthsBy(numOfMonths);
	}

	private void testWindingForwardMonthsBy(final int numOfMonths) {
		final Calendar cal = buildACalendar();
		final Date date = cal.getTime();

		final WindableDateTime windable = new WindableDateTime(date);
		windable.windForwardMonthsBy(numOfMonths);

		cal.add(Calendar.MONTH, numOfMonths);

		Assert.assertEquals(windable.getDate(), cal.getTime(), "Output Date not what it should be");
	}

	@Test
	public void testWindingOnDateOneYearViaHelper() {
		final Calendar cal = buildACalendar();
		final Date date = cal.getTime();

		final WindableDateTime windable = new WindableDateTime(date);
		windable.windForwardOneYear();

		cal.add(Calendar.YEAR, 1);

		Assert.assertEquals(windable.getDate(), cal.getTime(), "Output Date not what it should be");
	}

	@Test
	public void testWindingOnDateOneYearsViaXMonthsCall() {
		final int numOfMonths = 1;
		testWindingForwardYearsBy(numOfMonths);
	}

	@Test
	public void testWindingOnDateThreeYearsViaXMonthsCall() {
		final int numOfYears = 3;
		testWindingForwardYearsBy(numOfYears);
	}

	private void testWindingForwardYearsBy(final int numOfYears) {
		final Calendar cal = buildACalendar();
		final Date date = cal.getTime();

		final WindableDateTime windable = new WindableDateTime(date);
		windable.windForwardYearsBy(numOfYears);

		cal.add(Calendar.YEAR, numOfYears);

		Assert.assertEquals(windable.getDate(), cal.getTime(), "Output Date not what it should be");
	}

	private Date buildADate() {
		final Calendar cal = buildACalendar();
		final Date date = cal.getTime();
		return date;
	}

	private Calendar buildACalendar() {
		final Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2002);
		cal.set(Calendar.MONTH, 5);
		cal.set(Calendar.DAY_OF_MONTH, 3);
		return cal;
	}
}
