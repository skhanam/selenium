package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression;

import java.util.logging.Level;
import java.util.logging.Logger;

import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.audit.ActivityLog;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.audit.ActivityRecord;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.audit.ActivityRecordFactory;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money.TaxableAmount;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.tradesman.TestTradesmen;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.tradesman.Tradesman;

/** was ActivityScript */
class ActivitySession {
	private static final String POSTCODE_USED_BY_SELENIUM_JOBPOSTER = "sw1e 6dr";

	private static final Logger LOGGER = Logger.getLogger(ActivitySession.class.getName());

	/** whether to actually call the servers for real */
	private boolean useServers;
	/** the server-controllers (to access servers). set when creating Script, in your beforeClass() */
	private TmWebControllers tmWebControllers;
	/** the test tradesmen - set in your beforeMethod() */
	private TestTradesmen testTradesmen;
	/** everything is logged here */
	private ActivityLog activityLog;

	// TODO more here...

	ActivitySession(final TmWebControllers webControllers, final TestTradesmen tradesmen) {
		this.useServers = false; // let's not do anything by default...
		this.tmWebControllers = webControllers;
		this.testTradesmen = tradesmen;
		this.activityLog = new ActivityLog();
	}

	Tradesman agentSignupTm(final String tmIdCode) {
		final ActivityRecord activity = ActivityRecordFactory.agentSignupOfTm(tmIdCode);
		markOfflineModeAndLog(activity);

		// actuate remotely, if online
		if (this.useServers) {
			final Tradesman tm = this.testTradesmen.createAndSignupTradesmanUsingDefaults(tmIdCode);
			return tm;
		}
		return null; // TODO doesn't work when offline, at least currently
	}

	Tradesman getTradesmanWithIdCode(final String tmIdCode) {
		final Tradesman tm = this.testTradesmen.getTmWithIdCode(tmIdCode);
		return tm;
	}
	
//	void postAJobAndBuyWithTmWithIdCodeInPostcodeWithExpectedCost(final String tmIdCode, final String postcode, final TaxableAmount priceBeforeTax) {
//		final ActivityRecord activity = ActivityRecordFactory.tmToBuyNewJobForTmWithIdCode(tmIdCode);
//		markOfflineModeAndLog(activity);
//		
//		final Tradesman tm = this.testTradesmen.getTmWithIdCode(tmIdCode);
//		// actuate remotely, if online
//		if (this.useServers) {
//			final String tmPassword = "password"; // TODO Move this out!
//			try {
//				this.tmWebControllers.getJbController().postMetalWorkerJobInPostcodeAndBuyWithTmCredentials(postcode, tm.getTmState().getUserName(), tmPassword);
//			} catch (final Exception exception) {
//				throw new RuntimeException(exception);
//			}
//		}
//		// actuate on local model...
//		/*
//		 * TODO estimate job price (expected) subtract from balance - ensuring free balance stops at zero - seeing debt for remainder
//		 */
//		// TODO job should have some descriptor, and the cost to the TM.
////		final JobPriceDetail job = makeMetalworkerJobInPostcode();
//		tm.buyJob(job);
//	}
	
	void postAJobAndBuyWithTmWithIdCode(final String tmIdCode, final JobPriceDetail job) {
		final ActivityRecord activity = ActivityRecordFactory.tmToBuyNewJobForTmWithIdCode(tmIdCode);
		markOfflineModeAndLog(activity);

		final Tradesman tm = this.testTradesmen.getTmWithIdCode(tmIdCode);
		// actuate remotely, if online
		if (this.useServers) {
			final String tmPassword = "password"; // TODO Move this out!
			try {
				this.tmWebControllers.getJbController().postMetalWorkerJobInPostcodeAndBuyWithTmCredentials(job.getPostcode(), tm.getTmState().getUserName(), tmPassword);
			} catch (final Exception exception) {
				throw new RuntimeException(exception);
			}
		}
		// actuate on local model...
		/*
		 * estimate job price (expected) subtract from balance - ensuring free balance stops at zero - seeing debt for remainder
		 */
		// job should have some descriptor, and the cost to the TM.
		tm.buyJob(job);
	}

	void postAJobAndBuyWithTmWithIdCode(final String tmIdCode) {
		final ActivityRecord activity = ActivityRecordFactory.tmToBuyNewJobForTmWithIdCode(tmIdCode);
		markOfflineModeAndLog(activity);

		final Tradesman tm = this.testTradesmen.getTmWithIdCode(tmIdCode);
		// actuate remotely, if online
		if (this.useServers) {
			final String tmPassword = "password"; // TODO Move this out!
			try {
				this.tmWebControllers.getJbController().postAndBuyJob(tm.getTmState().getUserName(), tmPassword);
			} catch (final Exception exception) {
				throw new RuntimeException(exception);
			}
		}
		// actuate on local model...
		/*
		 * TODO estimate job price (expected) subtract from balance - ensuring free balance stops at zero - seeing debt for remainder
		 */
		// TODO job should have some descriptor, and the cost to the TM.
		final JobPriceDetail job = makeSomeJob(); // TODO move out and break up
		tm.buyJob(job);
	}

	private JobPriceDetail makeSomeJob() {
		return new JobPriceDetail("mah job", POSTCODE_USED_BY_SELENIUM_JOBPOSTER, TaxableAmount.newWithIncludedVatValue("23.76")); // 19.80+VAT
	}

	/**
	 * @deprecated doesn't work - not implemented in jBilling Controller (JBillingRegression) yet.
	 * 
	 * @param tmIdCode
	 */
	@Deprecated
	void grantLeadCreditToTmWithIdCode(final String tmIdCode) {
		final ActivityRecord activity = ActivityRecordFactory.agentToGrantLeadCreditToTmWithIdCode(tmIdCode);
		markOfflineModeAndLog(activity);

		// TODO
		final Tradesman tm = this.testTradesmen.getTmWithIdCode(tmIdCode);
		// actuate remotely, if online
		if (this.useServers) {
			try {
				// give goodwill in mk3
				this.tmWebControllers.getJbController().goToMK3();
				this.tmWebControllers.getJbController().goodwill(tm.getTmState().getUserName());

				// raise credit request
				// this.tmWebControllers.getJbController().creditRequest(tmIdCode);
			} catch (final Exception exception) {
				throw new RuntimeException(exception);
			}
		}
		final JobPriceDetail job = makeSomeJob(); // TODO make parameter
		// actuate on local model...
		tm.grantCreditFor(job);
	}

	void grantGoodwillOfPredefinedAmountToTmWithIdCode(final String tmIdCode) {
		final ActivityRecord activityRecord = ActivityRecordFactory.agentToGrantPredefinedGoodwillToTmWithIdCode(tmIdCode);
		markOfflineModeAndLog(activityRecord);

		final Tradesman tm = this.testTradesmen.getTmWithIdCode(tmIdCode);
		LOGGER.log(Level.INFO, "tm: " + tm.getIdCode() + " before granting pre-defined goodwill, balance is: " + tm.getTmState().getBalance());
		// actuate remotely, if online
		if (this.useServers) {
			try {
				// give goodwill in mk3
				this.tmWebControllers.getJbController().goToMK3();
				this.tmWebControllers.getJbController().goodwill(tm.getTmState().getUserName());
			} catch (final Exception exception) {
				throw new RuntimeException(exception);
			}
		}
		tm.grantGoodwillOfPredefinedAmount();
		LOGGER.log(Level.INFO, "tm: " + tm.getIdCode() + " after granting pre-defined goodwill, balance is: " + tm.getTmState().getBalance());
	}

	private void markOfflineModeAndLog(final ActivityRecord activity) {
		activity.setOnServers(this.useServers);
		this.activityLog.add(activity);
	}

	void assertBalancesAsExpected() {
		if (!this.useServers) {
			System.err.println("Currently not set to talk to servers (in offline mode), so not asserting balances.");
			return;
		}
		// ok, so let's do it...
		this.testTradesmen.assertBalancesAsExpected();
	}

	void goOnline() {
		System.out.println(" === going online ====");
		this.useServers = true;
	}

	void goOffline() {
		System.out.println(" === going offline ====");
		this.useServers = false;
	}
}