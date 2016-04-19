package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money;

import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests the VAT Rater ( {@link ValueAddedTaxRater} ) .
 */
public class ValueAddedTaxRaterTest {
	private static final int CURRENCY_SCALE = 2;

	private static final BigDecimal TEN_QUID = new BigDecimal("10.00").setScale(CURRENCY_SCALE);
	private static final BigDecimal TWELVE_QUID = new BigDecimal("12.00").setScale(CURRENCY_SCALE);

	private ValueAddedTaxRater rater;

	@BeforeMethod
	public void beforeMethod() {
		this.rater = new ValueAddedTaxRater();
	}

	@Test
	public void testRating() {
		final BigDecimal input = TEN_QUID;
		final BigDecimal output = this.rater.rate(input);

		Assert.assertNotNull(output, "Output was null!");
		Assert.assertEquals(output, TWELVE_QUID, "Wasn't as expected!");
	}

	@Test
	public void testUnrating() {
		final BigDecimal input = TWELVE_QUID;
		final BigDecimal output = this.rater.unrate(input);

		Assert.assertNotNull(output, "Output was null!");
		Assert.assertEquals(output, TEN_QUID, "Wasn't as expected!");
	}

	@Test
	public void testRatingFractionalInput() {
		final BigDecimal input = new BigDecimal("12.45").setScale(CURRENCY_SCALE);
		final BigDecimal output = this.rater.rate(input);

		Assert.assertNotNull(output, "Output was null!");
		final BigDecimal expected = new BigDecimal("14.94").setScale(CURRENCY_SCALE);
		Assert.assertEquals(output, expected, "Not as thought!");
	}
}
