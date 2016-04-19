package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.audit;

public enum ActivityType {
	/** Agent signs up TM */
	AGENT_SIGNUP_TM,
	/** TM buys an New Job */
	TM_BUY_JOB_NEW,
	/** TM buys an existing Job */
	TM_BUY_JOB_EXISTING,
	/** Agent grants a TM Lead Credit */
	AGENT_GRANT_LEAD_CREDIT, 
	/** Agent grants TM Goodwill Credit  */
	AGENT_GOODWILL_CREDIT;
}