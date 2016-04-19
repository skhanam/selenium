package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.jbillingmodel.PlanSpec;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.tradesman.TestTradesmen;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.tradesman.Tradesman;

/**
 * New jBilling Regression Pack
 * 
 */
public class JbillingNewRegressionTest extends TestScript {
	private static class TmSpec {
		static class Monthly {
			static class NeverSpends {
				static final String ID_CODE = "tmMonthlyNeverSpends";
				static final PlanSpec PLAN = PlanSpecDefinitions.DEFAULT;
			}

			static class BuysAFewLeads {
				static final String ID_CODE = "tmBuysAFewLeads";
				static final PlanSpec PLAN = PlanSpecDefinitions.DEFAULT;
			}
		}
	}

	/**
	 * Whether the Tests should create the Tradesman when starting, or load their details from a file, i.e. using previously created ones. Not currently
	 * supported.
	 */
	static enum TradesmanDataSetMode {
		CREATE_TRADESMEN, USE_SAVED_TRADESMEN;
	}

	/**
	 * Whether the Tests should really talk to the Servers or not, or just do everything locally.
	 */
	static enum ServerCommsPolicy {
		ONLINE, OFFLINE;
	}

	/**
	 * Whether or not the Test-Cases are enabled (Master Switch).
	 */
	private static final boolean TESTS_ENABLED = true;

	private TradesmanDataSetMode mode = TradesmanDataSetMode.CREATE_TRADESMEN;
	private ServerCommsPolicy serverCommsPolicy = ServerCommsPolicy.ONLINE;
	private boolean usePersistanceOfTmState;

	private TmWebControllers tmWebControllers;
	private TestTradesmen testTradesmen;

	private ActivitySession activitySession;

	/**
	 * One time preparations for all Test-Cases in this Class.
	 * 
	 * Prepares all of the necessary objects that are used, including starting a new {@link ActivitySession}.
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public void beforeClass() throws Exception {
		this.tmWebControllers = new TmWebControllers(this.context, this.scriptUtilities);
		this.testTradesmen = new TestTradesmen(this.tmWebControllers);

		this.activitySession = new ActivitySession(this.tmWebControllers, this.testTradesmen);

		if (ServerCommsPolicy.OFFLINE.equals(this.serverCommsPolicy)) {
			this.activitySession.goOffline();
		} else if (ServerCommsPolicy.ONLINE.equals(this.serverCommsPolicy)) {
			this.activitySession.goOnline();
		}

		if (TradesmanDataSetMode.CREATE_TRADESMEN.equals(this.mode)) {
			createTradesmen();
			if (this.usePersistanceOfTmState) {
				this.testTradesmen.saveToFile();
			}
		} // otherwise, the beforeMethod() will just load the existing ones
	}

	public void createTradesmen() {
		final Tradesman tmMonthlyNeverSpends = this.activitySession.agentSignupTm(TmSpec.Monthly.NeverSpends.ID_CODE);
		System.out.println("Signed up TM: " + tmMonthlyNeverSpends);
		final Tradesman tmBuysSomeLeads = this.activitySession.agentSignupTm(TmSpec.Monthly.BuysAFewLeads.ID_CODE);
		System.out.println("Signed up TM: " + tmBuysSomeLeads);

		// TODO signup other TMs here...

		// assert balances ok...
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		if (this.usePersistanceOfTmState) {
			// load TMs
			this.testTradesmen.loadFromFile();
		}
		// this.activitySession.tmWebControllers.getJbController().loginOut();
	}

	// =====================================================================
	//
	// Setup & Preparations Above /\
	//
	// Test Cases Follow \/
	//
	// =====================================================================

	@Test(enabled = TESTS_ENABLED)
	public void testMonthOneDayTwo() {
		/*
		 * TODO
		 * 
		 * 1. tell Tradesman to be present (can do this in beforeMethod() ?) - so either already loaded, or load if first test (so if Tradesman is empty).
		 * 
		 * 2. this test knows state it wants, so fast-forward **our** state (in Tradesmen) to the month/day combo we are.
		 * 
		 * 3. perform any actions
		 * 
		 * 4. perform any assertions
		 * 
		 * 5. anything else you wanna do in this test case.
		 * 
		 * TODO
		 */
		// final Tradesman tmMonthlyNeverSpends = this.activitySession.getTradesmanWithIdCode(TmSpec.Monthly.NeverSpends.ID_CODE);
		// System.out.println("Found TM for tmMonthlyNeverSpends: " + tmMonthlyNeverSpends);

		// do we really need it here? we talk exclusively through ActivitySession really...
		this.activitySession.postAJobAndBuyWithTmWithIdCode(TmSpec.Monthly.BuysAFewLeads.ID_CODE);

		// final Tradesman buysAFewLeadsTm = this.activitySession.getTradesmanWithIdCode(TmSpec.Monthly.BuysAFewLeads.ID_CODE);

		// check all TMs balances...
		this.activitySession.assertBalancesAsExpected();
	}

	@Test(enabled = TESTS_ENABLED, dependsOnMethods = { "testMonthOneDayTwo" })
	public void testMonthOneDayThree() {
		// "buys a few leads" user buys two leads, gets one credit
		this.activitySession.postAJobAndBuyWithTmWithIdCode(TmSpec.Monthly.BuysAFewLeads.ID_CODE);
		this.activitySession.assertBalancesAsExpected();
		this.activitySession.postAJobAndBuyWithTmWithIdCode(TmSpec.Monthly.BuysAFewLeads.ID_CODE);
		this.activitySession.assertBalancesAsExpected();

		// this.activitySession.grantLeadCreditToTmWithIdCode(TmSpec.Monthly.BuysAFewLeads.ID_CODE);
		this.activitySession.grantGoodwillOfPredefinedAmountToTmWithIdCode(TmSpec.Monthly.BuysAFewLeads.ID_CODE);

		this.activitySession.assertBalancesAsExpected();
	}

	// public void submitJobBlah() {
	// this.activitySession.postAJobAndBuyWithTmWithIdCode("tm3");
	// this.activitySession.postAJobAndBuyWithTmWithIdCode("tm6");
	// this.activitySession.postAJobAndBuyWithTmWithIdCode("tm11");
	// this.activitySession.postAJobAndBuyWithTmWithIdCode("tm12");
	//
	// this.activitySession.assertBalancesAsExpected();
	//
	// this.activitySession.windOnXDays(1);
	// }

}
