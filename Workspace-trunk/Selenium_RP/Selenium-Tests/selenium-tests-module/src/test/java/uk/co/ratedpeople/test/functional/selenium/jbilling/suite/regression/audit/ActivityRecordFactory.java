package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.audit;

public class ActivityRecordFactory {

	public static ActivityRecord agentSignupOfTm(final String tmIdCode) {
		final ActivityRecord activity = new ActivityRecord(Actor.AGENT, ActivityType.AGENT_SIGNUP_TM);
		activity.setInvolvedTmIdCode(tmIdCode);
		activity.addUserInfoKey("signedupTmIdCode", tmIdCode);
		return activity;
	}

	public static ActivityRecord tmToBuyNewJobForTmWithIdCode(final String tmIdCode) {
		final ActivityRecord record = new ActivityRecord(Actor.TRADESMAN, ActivityType.TM_BUY_JOB_NEW);
		record.setInvolvedTmIdCode(tmIdCode);
		return record;
	}

	public static ActivityRecord agentToGrantLeadCreditToTmWithIdCode(final String tmIdCode) {
		final ActivityRecord record = new ActivityRecord(Actor.AGENT, ActivityType.AGENT_GRANT_LEAD_CREDIT);
		record.setInvolvedTmIdCode(tmIdCode);
		return record;
	}

	public static ActivityRecord agentToGrantPredefinedGoodwillToTmWithIdCode(final String tmIdCode) {
		final ActivityRecord record = new ActivityRecord(Actor.AGENT, ActivityType.AGENT_GOODWILL_CREDIT);
		record.setInvolvedTmIdCode(tmIdCode);
		return record;
	}

}