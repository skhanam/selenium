package uk.co.ratedpeople.test.functional.httpclient.support;

import uk.co.ratedpeople.Environment;
import uk.co.ratedpeople.test.functional.SeleniumFunctionalTestConstants;

/**
 * Implements 'givens' - test pre-conditions - on which tests rely. Currently, this reliance is implemented by ensuring similar state in each system under test,
 * rather than by setting up that state ourselves.
 */
public class TestFixtures {
	private static class PropertyNames {
		static class User {
			static class Agent {
				static class Active {
					static final String USER_NAME_PROP = "functional.test.user.agent.active.username";
					static final String PASSWORD_PROP = "functional.test.user.agent.active.password";
				}
			}
			static class Tradesman {
				static class Active {
					static class WAQSBilled {
						static final String USER_NAME_PROP = "functional.test.user.tm.active.waqs.username";
						static final String PASSWORD_PROP = "functional.test.user.tm.active.waqs.password";
					}
					static class JBillingBilled {
						static final String USER_NAME_PROP = "functional.test.user.tm.active.jbilling.username";
						static final String PASSWORD_PROP = "functional.test.user.tm.active.jbilling.password";
					}
				}
			}
		}
	}
	
	// Static constants private to encourage use of outer API

	private static final String PREPROD_ADMIN_USER_NAME = "aaron.barwell@ratedpeople.com";
	private static final String PREPROD_ADMIN_PASSWORD = "password";

	private static final String DEV3_ADMIN_USER_NAME = "aaron.barwell@ratedpeople.com";
	private static final String DEV3_ADMIN_PASSWORD = "password";

	static final WebSiteCredentials PREPROD_ADMIN_CREDENTIALS = new WebSiteCredentials("preprod_admin", PREPROD_ADMIN_USER_NAME, PREPROD_ADMIN_PASSWORD);
	static final WebSiteCredentials DEV3_ADMIN_CREDENTIALS = new WebSiteCredentials("dev3_admin", DEV3_ADMIN_USER_NAME, DEV3_ADMIN_PASSWORD);

	public WebSiteCredentials getAdminCredentials(final Environment environment) {
		final String testHost = environment.getProperty(SeleniumFunctionalTestConstants.FUNCTIONAL_TEST_HOST_PROPERTY);
		final String hostName = (testHost != null) ? getHostName(testHost) : null;

		final WebSiteCredentials credentials = "dev3".equals(hostName) ? DEV3_ADMIN_CREDENTIALS : PREPROD_ADMIN_CREDENTIALS;
		return credentials;
	}

	/**
	 * @return host name from fully qualified host name, e.g. 'preprod' from 'preprod.uk.ratedpeople'; or null if cannot be determined
	 */
	protected String getHostName(final String fullyQualifiedHostName) {
		final int dot = fullyQualifiedHostName.indexOf(".");
		final String hostName = dot > 0 ? fullyQualifiedHostName.substring(0, dot) : null;
		return hostName;
	}

	public WebSiteCredentials getActiveAgentCredentials(final Environment environment) {
		final String username = environment.getProperty(PropertyNames.User.Agent.Active.USER_NAME_PROP);
		final String password = environment.getProperty(PropertyNames.User.Agent.Active.PASSWORD_PROP);
		final WebSiteCredentials credentials = new WebSiteCredentials("Active Agent", username, password);
		return credentials;
	}

	public WebSiteCredentials getActiveTradesmanWaqsBilledCredentials(final Environment environment) {
		final String username = environment.getProperty(PropertyNames.User.Tradesman.Active.WAQSBilled.USER_NAME_PROP);
		final String password = environment.getProperty(PropertyNames.User.Tradesman.Active.WAQSBilled.PASSWORD_PROP);
		final WebSiteCredentials credentials = new WebSiteCredentials("Active TM (WAQS)", username, password);
		return credentials;
	}

	public WebSiteCredentials getActiveTradesmanJbillingBilledCredentials(final Environment environment) {
		final String username = environment.getProperty(PropertyNames.User.Tradesman.Active.JBillingBilled.USER_NAME_PROP);
		final String password = environment.getProperty(PropertyNames.User.Tradesman.Active.JBillingBilled.PASSWORD_PROP);
		final WebSiteCredentials credentials = new WebSiteCredentials("Active TM (jBilling)", username, password);
		return credentials;
	}
}
