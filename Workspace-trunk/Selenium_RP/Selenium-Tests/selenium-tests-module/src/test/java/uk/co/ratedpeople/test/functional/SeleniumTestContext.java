package uk.co.ratedpeople.test.functional;

import static uk.co.ratedpeople.FunctionalTestConstants.FUNCTIONAL_TEST_HOST_PROPERTY;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;

import uk.co.ratedpeople.Environment;
import uk.co.ratedpeople.FunctionalTestConstants;
import uk.co.ratedpeople.TestContext;
import uk.co.ratedpeople.test.functional.httpclient.support.TestFixtures;
import uk.co.ratedpeople.test.functional.httpclient.support.WebSiteCredentials;

/**
 * Contextual data for running tests.
 * 
 * Is not-thread-safe currently as hosts a {@link WebDriver} - this should be moved into Selenium/Browser specific test-context object.
 */
public class SeleniumTestContext extends TestContext {

	/**
	 * Instantiated by clients (of this class) if/when they need it, and shared
	 * simply here.
	 * 
	 * <b>This is bad - publicly accessible, not initialised by default - for starters. Also muddies REST vs Web Browser based tests.</b>
	 * 
	 * Stateful - as maintains a link to the Web Browser it is controlling. This means is it also potentially not-thread-safe, hence causing it's hosting Class not to be.
	 */
	public WebDriver driver;

	private final TestFixtures testFixtures;

	/**
	 * Constructs and returns a test context which derives properties from a
	 * default Environment
	 * 
	 * @see uk.co.ratedpeople.utils.environment.Environment#getSystemEnvironmentWithDefault()
	 */
	public static SeleniumTestContext getDefault() throws IOException {
		final Environment environment = Environment.getSystemEnvironmentWithDefault();
		return new SeleniumTestContext(environment);
	}

	public SeleniumTestContext(final Environment environment) {
		super(environment);
		testFixtures = new TestFixtures();
	}
	
	public String getTestHostName(){
		return this.environment.getProperty(FUNCTIONAL_TEST_HOST_PROPERTY);
	}
	
//	public String getSeleniumServerPort() {
//		return this.environment.getProperty(FUNCTIONAL_TEST_SELENIUM_SERVER_PORT);		
//	}

	public String getSauceUrl(){
		return this.environment.getProperty(SeleniumFunctionalTestConstants.SAUCE_URL_PROPERTY);
	}
	
//	public String getSauceBrowser(){
//		return this.environment.getProperty(FunctionalTestConstants.SAUCE_BROWSER_PROPERTY);
//	}
	
	public String getSeleniumLocalServerHub(){
		return this.environment.getProperty(SeleniumFunctionalTestConstants.SELENIUM_LOCAL_SERVER_HUB);
	}
	
	public String getSeleniumSauceLabsServerHub(){
		return this.environment.getProperty(SeleniumFunctionalTestConstants.SELENIUM_SAUCE_LABS_SERVER_HUB);
	}
	
//	public String getSupportUrl() {
//		return getTestHostName();
//	}

	private String getStringProperty(String propertyKey) {
		return environment.getProperty(propertyKey);
	}

	private int getIntProperty(String propertyKey) {
		String property = getStringProperty(propertyKey);
		return Integer.valueOf(property.trim());
	}

//	public String getTestapp1Url() {
//		return getURL("http://", getStringProperty(FUNCTIONAL_TEST_APP1_SUPPORT_PROPERTY), getIntProperty(FUNCTIONAL_TEST_PORT_PROPERTY));
//	}
//
//	public String getTestapp2Url() {
//		return getURL("http://", getStringProperty(FUNCTIONAL_TEST_APP2_SUPPORT_PROPERTY), getIntProperty(FUNCTIONAL_TEST_PORT_PROPERTY));
//	}

	private String getURL(final String prefix, final String hostName, final int portNumber) {
		String URL = prefix + hostName;
		if(portNumber != 80) {
			URL = URL + ":"+portNumber;
		}
		return URL;
	}
	
	
	
	/**
	 * Gives URL for the tradesmen web site
	 * @return 
	 */
	public final String getTestTPURL() {
		return getURL("http://", getStringProperty(SeleniumFunctionalTestConstants.FUNCTIONAL_TEST_TP_HOST_PROPERTY), getIntProperty(SeleniumFunctionalTestConstants.FUNCTIONAL_TEST_TP_PORT_PROPERTY));
	}
	
//	public String getTestTmMobileURL() {
//		return getURL("https://", getStringProperty(FunctionalTestConstants1.FUNCTIONAL_TEST_TMMOBILE_HOST), getIntProperty(FunctionalTestConstants1.FUNCTIONAL_TEST_TMMOBILE_PORT));
//	}

	/**
	 * Gives HTTP protocol URL for the portable job form site
	 * @return 
	 */
	public final String getTestPJFURL() {
		return getURL("http://", getStringProperty(SeleniumFunctionalTestConstants.FUNCTIONAL_TEST_PJF_HOST_PROPERTY), getIntProperty(SeleniumFunctionalTestConstants.FUNCTIONAL_TEST_PJF_PORT_PROPERTY));
	}

	/**
	 * Gives HTTPS protocol URL for the new home owner web site
	 * @return 
	 */
	public final String getTestHttpsNewHOURL() {
		return getURL("https://", getStringProperty(SeleniumFunctionalTestConstants.FUNCTIONAL_TEST_NEW_HO_HOST_PROPERTY), getIntProperty(SeleniumFunctionalTestConstants.FUNCTIONAL_TEST_NEW_HO_PORT_PROPERTY));
	}
	
	/**
	 * Gives HTTPS protocol URL for the home owner web site
	 * @return 
	 */
	public final String getTestHttpsHOURL() {
		return getURL("https://", getStringProperty(SeleniumFunctionalTestConstants.FUNCTIONAL_TEST_HO_HOST_PROPERTY), getIntProperty(SeleniumFunctionalTestConstants.FUNCTIONAL_TEST_HO_PORT_PROPERTY));
	}

	/**
	 * Gives HTTPS protocol URL for TM Mobile App
	 * @return 
	 */
	public final String getTestHttpsTMMobileURL() {
		return getURL("https://", getStringProperty(SeleniumFunctionalTestConstants.FUNCTIONAL_TEST_TMMOBILE_HOST), getIntProperty(SeleniumFunctionalTestConstants.FUNCTIONAL_TEST_TMMOBILE_PORT));
	}

	public WebSiteCredentials getAdminCredentials() {
		return testFixtures.getAdminCredentials(environment);
	}
	
	public WebSiteCredentials getActiveAgentCredentials() {
		return this.testFixtures.getActiveAgentCredentials(this.environment);
	}
	
	public WebSiteCredentials getActiveTradesmanWaqsBilledCredentials() {
		return this.testFixtures.getActiveTradesmanWaqsBilledCredentials(this.environment);
	}

	public WebSiteCredentials getActiveTradesmanJbillingBilledCredentials() {
		return this.testFixtures.getActiveTradesmanJbillingBilledCredentials(this.environment);
	}

	public String getTestImageFolderPath() {
		URL location = SeleniumTestContext.class.getProtectionDomain().getCodeSource().getLocation();	
		System.out.println(location);
		String sourcePath = location.getFile();
		System.out.println(sourcePath);
		String sourceProjectPath = sourcePath.substring(0, sourcePath.indexOf("/target/"));
		System.out.println(sourceProjectPath);
		if(File.separator.equals("\\")) {
			// special treatment for windows path which turns out to be like /c:/dir/subdir			
			sourceProjectPath = sourceProjectPath.replaceFirst("/", "");
			sourceProjectPath = sourceProjectPath.replace("/", "\\");
		}
		String imageFolderPath = sourceProjectPath + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "testdata" + File.separator + "images"; 
		System.out.println(imageFolderPath);
		return imageFolderPath;
	}
	
//	public String getEnvironment(){
//		return System.getProperty(FunctionalTestConstants.ENVIRONMENT);
//	}
	
	
//	public String getEnvironmentProperties(){
//		return System.getProperty(FunctionalTestConstants.ENVIRONMENT_PROPERTY);
//	}

	public String getSeleniumBrowser(){
		String value = System.getProperty(SeleniumFunctionalTestConstants.SELENIUM_SERVER_BROWSER);
		if (StringUtils.isEmpty(value)) {
			value = environment.getProperty(SeleniumFunctionalTestConstants.SELENIUM_SERVER_BROWSER);
		}
		return value;
	}
	
	public String getSeleniumBrowserVersion(){
		String value = System.getProperty(SeleniumFunctionalTestConstants.SELENIUM_SERVER_BROWSER_VERSION);
		if (StringUtils.isEmpty(value)) {
			value = environment.getProperty(SeleniumFunctionalTestConstants.SELENIUM_SERVER_BROWSER_VERSION);
		}
		return value;
	}
	
	public String getSeleniumPlatform(){
		String value = System.getProperty(SeleniumFunctionalTestConstants.SELENIUM_SERVER_PLATFORM);
		if (StringUtils.isEmpty(value)) {
			value = environment.getProperty(SeleniumFunctionalTestConstants.SELENIUM_SERVER_PLATFORM);
		}
		return value;
	}
	
	public String getSeleniumDesktopDeviceEndPoint(){
//		return System.getProperty(FunctionalTestConstants.SELENIUM_DESKTOP_DEVICE_END_POINT);
		return System.getProperty(FunctionalTestConstants.FUNCTIONAL_TEST_HOST_PROPERTY);
	}
	
	public String getSeleniumTabletDeviceEndPoint(){
		return System.getProperty(SeleniumFunctionalTestConstants.SELENIUM_TABLET_DEVICE_END_POINT);
	}
	
	public String getSeleniumMobileDeviceEndPoint(){
		return System.getProperty(SeleniumFunctionalTestConstants.SELENIUM_MOBILE_DEVICE_END_POINT);
	}
	
	public String getSeleniumTabletDeviceModel(){
		String value = System.getProperty(SeleniumFunctionalTestConstants.SELENIUM_TABLET_DEVICE_MODEL);
		if (StringUtils.isEmpty(value)) {
			value = environment.getProperty(SeleniumFunctionalTestConstants.SELENIUM_TABLET_DEVICE_MODEL);
		}
		return value;
	}
	
	public String getSeleniumMobileDeviceModel(){
		String value = System.getProperty(SeleniumFunctionalTestConstants.SELENIUM_MOBILE_DEVICE_MODEL);
		if (StringUtils.isEmpty(value)) {
			value = environment.getProperty(SeleniumFunctionalTestConstants.SELENIUM_MOBILE_DEVICE_MODEL);
		}
		return value;
	}
	
	public String getSeleniumDefaultBrowser(){
		return environment.getProperty(SeleniumFunctionalTestConstants.DEFAULT_SELENIUM_SERVER_BROWSER);
	}
	
	public String getSeleniumDefaultBrowserVersion(){
		return environment.getProperty(SeleniumFunctionalTestConstants.DEFAULT_SELENIUM_SERVER_BROWSER_VERSION);
	}
	
	public String getSeleniumDefaultPlatform(){
		return environment.getProperty(SeleniumFunctionalTestConstants.DEFAULT_SELENIUM_SERVER_PLATFORM);
	}
	
	public String getSeleniumDefaultDesktopDeviceEndPoint(){
		return environment.getProperty(SeleniumFunctionalTestConstants.DEFAULT_SELENIUM_DESKTOP_DEVICE_END_POINT);
	}

	public String getJBillingUrl() {
		return getURL("http://", getStringProperty(SeleniumFunctionalTestConstants.FUNCTIONAL_TEST_JB_PROPERTY), getIntProperty(SeleniumFunctionalTestConstants.FUNCTIONAL_TEST_JB_PORT_PROPERTY));
	}
}
