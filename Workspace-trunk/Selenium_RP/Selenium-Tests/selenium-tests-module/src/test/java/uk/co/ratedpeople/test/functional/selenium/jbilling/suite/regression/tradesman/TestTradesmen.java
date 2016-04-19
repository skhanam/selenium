package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.tradesman;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.TmWebControllers;

/**
 * Tradesmen used in the tests.
 */
public class TestTradesmen {
	private static final String TM_USER_DATA_FILE_NAME = "tm-user-data.dat";
	private static final Logger LOGGER = Logger.getLogger(TestTradesmen.class.getName());

	private final Map<String, Tradesman> tmMap = new HashMap<String, Tradesman>();
	private final TmWebControllers tmWebControllers;

	public TestTradesmen(final TmWebControllers tmWebControllers) {
		this.tmWebControllers = tmWebControllers;
	}

	public Tradesman createTradesmanWithDefaults(final String idCode) {
		final Tradesman tm = new Tradesman(this.tmWebControllers.getTmTools(), idCode);
		this.add(tm);
		return tm;
	}

	public Tradesman createAndSignupTradesmanUsingDefaults(final String idCode) {
		final Tradesman tm = this.createTradesmanWithDefaults(idCode);
		tm.signupUsingDefaults();
		try {
			this.tmWebControllers.getJbController().loginOut();
		} catch (final Exception exception) {
			throw new RuntimeException(exception);
		}
		return tm;
	}

	public void add(final Tradesman tm) {
		this.tmMap.put(tm.getIdCode(), tm);
	}

	public Tradesman getTmWithIdCode(final String idCode) {
		final Tradesman tm = this.tmMap.get(idCode);
		return tm;
	}

	public void saveToFile() {
		final TradesmanStateFileWriter writer = new TradesmanStateFileWriter();
		writer.writeToFile(this.tmMap.values(), TM_USER_DATA_FILE_NAME);
	}

	public void loadFromFile() {
		final TradesmanStateFileReader reader = new TradesmanStateFileReader();
		final Collection<TradesmanState> tmStates = reader.readFromFile(TM_USER_DATA_FILE_NAME);
		for (final TradesmanState tmState : tmStates) {
			final Tradesman tm = new Tradesman(this.tmWebControllers.getTmTools(), tmState);
			this.add(tm);
		}
	}

	public void assertBalancesAsExpected() {
		try {
			// just log into MK3 once here...
			// this.tmWebControllers.getJbController().loginOut();
			this.tmWebControllers.getJbController().goToMK3();
		} catch (final Exception exception) {
			LOGGER.log(Level.SEVERE, "Exception asserting balances!", exception);
			throw new RuntimeException(exception);
		}
		for (final Tradesman tm : this.tmMap.values()) {
			// tm.assertBalanceAsExpected(); // TODO maybe move it in there in future
			try {
				// TODO should ensure logged into MK3 here, and then use getJbController().gotoMK3()
				// final String currencyLedCost = tm.getTmState().getFreeBalanceCurrencyString();
				System.out.println("About to assert balance of: { " + tm + " }...");
				final String currencyLedCost = tm.getTmState().getOverallBalanceCurrencyString();
				this.tmWebControllers.getJbController().assertFreeBalance(tm.getTmState().getUserName(), currencyLedCost);
				System.out.println("Done assertFreeBalance of tm: { " + tm + " } ");
			} catch (final Exception exception) {
				throw new RuntimeException("Exception asserting balance for TM: " + tm, exception);
			}
		}
		// System.out.println("About to logout of MK3...");
		// try {
		// this.tmWebControllers.getJbController().loginOut();
		// } catch (final Exception exception) {
		// throw new RuntimeException(exception);
		// }
	}
}