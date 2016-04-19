package uk.co.ratedpeople;

import static uk.co.ratedpeople.FunctionalTestConstants.FUNCTIONAL_TEST_ACCESS_KEY;
import static uk.co.ratedpeople.FunctionalTestConstants.FUNCTIONAL_TEST_ACCESS_KEY_ID;
import static uk.co.ratedpeople.FunctionalTestConstants.FUNCTIONAL_TEST_APP1_SUPPORT_PROPERTY;
import static uk.co.ratedpeople.FunctionalTestConstants.FUNCTIONAL_TEST_APP2_SUPPORT_PROPERTY;
import static uk.co.ratedpeople.FunctionalTestConstants.FUNCTIONAL_TEST_HOST_PROPERTY;
import static uk.co.ratedpeople.FunctionalTestConstants.FUNCTIONAL_TEST_PORT_PROPERTY;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;

/**
 * Contextual data for running tests.
 */
public class TestContext {

	/**
	 * Environment Properties - provides access to Environment of tests - including the System Environment, configuration-via-Properties files, etc.
	 * 
	 * Has state, but *should* be thread-safe (provided you don't try and change values - that will be ok when backed by a Java Properties object which is
	 * Thread-safe, but implementations could vary).
	 */
	protected final Environment environment;

	/**
	 * Constructs and returns a test context which derives properties from a default Environment
	 * 
	 * @see uk.co.ratedpeople.functionaltest.environment.Environment#getSystemEnvironmentWithDefault()
	 */
	public static TestContext getDefault() throws IOException {
		final Environment environment = Environment.getSystemEnvironmentWithDefault();

		return new TestContext(environment);
	}

	public TestContext(final Environment environment) {
		this.environment = environment;
	}

	public String getContextProperty(String propertyName) {
		return this.environment.getProperty(propertyName);
	}

	public String getTestHostName() {
		return this.environment.getProperty(FUNCTIONAL_TEST_HOST_PROPERTY);
	}

	public String getTestUrl() {
		return constructUrl("http://");
	}

	public final String getTestHttpsUrl() {
		return constructUrl("https://");
	}

	protected String constructUrl(final String protocol) {
		String URL = protocol + this.environment.getProperty(FUNCTIONAL_TEST_HOST_PROPERTY);
		
		Integer portNumber = Integer.valueOf(this.environment.getProperty(FUNCTIONAL_TEST_PORT_PROPERTY).trim());
		
		if (portNumber != 80) {
			URL = URL + ":" + portNumber;
		}
		
		return URL;
	}

	protected String constructUrl(final String protocol, final String hostProperty, final String portProperty) {
		String URL = protocol + this.environment.getProperty(hostProperty);

		Integer portNumber = Integer.valueOf(this.environment.getProperty(portProperty).trim());

		if (portNumber != 80) {
			URL = URL + ":" + portNumber;
		}

		return URL;
	}
	
	public String getAccessKeyId() {
		return this.environment.getProperty(FUNCTIONAL_TEST_ACCESS_KEY_ID);
	}
	
	public String getAccessKey() {
		return this.environment.getProperty(FUNCTIONAL_TEST_ACCESS_KEY);
	}

	/**
	 * Returns the Tradesman User who takes the place of integration.test3@ratedtrades.com - or that user, depending upon environment.
	 * 
	 * <b>NOTE: this is a hack until we get the data-issues resolved</b>.
	 * 
	 * @return the username of the TM to use as or instead of integration.test3@ratedtrades.com
	 */
	public String getTmUserWasIntegrationTestThree() {
		final String name = this.getContextProperty(FunctionalTestConstants.DATA_PATCH_INTEGRATION_TEST_THREE_OR_SUBSTITUTE);
		if (StringUtils.isBlank(name)) {
			return "integration.test3@ratedtrades.com";
		}
		return name;
	}
	
	public String getTestapp1Url() {
		return constructUrl("http://",FUNCTIONAL_TEST_APP1_SUPPORT_PROPERTY, FUNCTIONAL_TEST_PORT_PROPERTY);
	}

	public String getTestapp2Url() {
		return constructUrl("http://",FUNCTIONAL_TEST_APP2_SUPPORT_PROPERTY, FUNCTIONAL_TEST_PORT_PROPERTY);
	}

	public String getSupportUrl() {
		return constructUrl("https://",FUNCTIONAL_TEST_HOST_PROPERTY, FUNCTIONAL_TEST_PORT_PROPERTY);
	}
}
