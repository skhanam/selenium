package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test {@link VatRate}
 */
public class VatRateTest {
	private static final int SCALE = 3;
	private static final BigDecimal TWENTY = new BigDecimal("20").setScale(SCALE);
	private static final BigDecimal ONE_POINT_TWO = new BigDecimal("1.2").setScale(SCALE);
	private static final BigDecimal SEVENTEEN_AND_A_HALF = new BigDecimal("17.5").setScale(SCALE);
	private static final BigDecimal ONE_POINT_SEVEN_FIVE = new BigDecimal("1.175").setScale(SCALE);

	private static final Logger LOGGER = Logger.getLogger(VatRateTest.class.getName());

	@Test
	public void testTwentyPercentRate() {
		final VatRate rate = new VatRate(TWENTY);
		LOGGER.log(Level.INFO, "Got VatRate of: " + rate);

		Assert.assertEquals(rate.getPercentage(), TWENTY);
		Assert.assertEquals(rate.getMultiplicand(), ONE_POINT_TWO);
	}

	@Test
	public void testOldRate() {
		final VatRate rate = new VatRate(SEVENTEEN_AND_A_HALF);
		LOGGER.log(Level.INFO, "Got VatRate of: " + rate);

		Assert.assertEquals(rate.getPercentage(), SEVENTEEN_AND_A_HALF);
		Assert.assertEquals(rate.getMultiplicand(), ONE_POINT_SEVEN_FIVE);
	}
}
