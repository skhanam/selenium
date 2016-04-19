package uk.co.ratedpeople.test.functional.selenium;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;

import com.mysql.jdbc.Statement;

public class TestScript {
	private static class SeleniumControlOptions {
		static final boolean LEAVE_SELENIUM_OPEN_AFTER_TESTS = false;
	}
	
	public static Logger LOGGER = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.TestScript");
	
	private static final String USER_NAME = "user.name";
	private static final String WEBDRIVER_FIREFOX_PROFILE = "webdriver.firefox.profile";
	private static final String SAUCELABS = "saucelabs";
	private static final String DESKTOP = "desktop";
	private static final String TABLET = "tablet";
	private static final String MOBILE = "mobile";
	private static final String IOS = "ios";
	private static final String VISTA = "Vista";
	private static final String XP = "xp";
	private static final String ANDROID = "android";
	private static final String IPHONE = "iphone";
	private static final String IPAD = "ipad";
	private static final String FIREFOX = "firefox";
	private static final String IE = "ie";
	private static final String ALL = "all";
	private static final String CHROME = "chrome";
	private static final String LINUX = "LINUX";
//	private static final String ENVIRONMENT ="functional.test.host";
//	private static final String PREPROD ="preprod.preprod";
	
	protected TestScriptUtilities scriptUtilities;
	private StringBuffer verificationErrors = new StringBuffer();
	protected final SeleniumTestContext context;
	public static final String JDBC_DRIVER_URL = "jdbc:mysql://db.preprod:3306/rated_people" ;
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_USER_NAME = "ratedpeople";  
	public static final String DB_PWD = "ratedpeople";
	public static final  String USER_QUERY = "select * from user order by id desc";
	public static final  String CAMPAIGN_QUERY = "select * from membership_campaign_url where user_id='";
	
	public TestScript() {
		try {
			this.context = SeleniumTestContext.getDefault();
			this.scriptUtilities = new TestScriptUtilities(context);
		} catch (IOException e) {
			throw new IllegalStateException(
					"Failed to initialized default context", e);
		}
	}

	public TestScript(SeleniumTestContext context) {
		this.context = context;
		this.scriptUtilities = new TestScriptUtilities(context);
	}

	public SeleniumTestContext getTestContext() {
		return context;
	}

	public TestScriptUtilities getTestScriptUtilities() {
		return scriptUtilities;
	}

	@Parameters({"platform", "browser", "version", "device", "deviceModel" })
	@BeforeClass(alwaysRun = true)
	public void setup(@Optional("") String platform, @Optional("Firefox") String browser,
			@Optional("all") String version, @Optional("None") String device,
			@Optional("None") String deviceModel) {
		System.out.println("platform ="+platform);
		if (StringUtils.isBlank(platform)) {
			runSeleniumFromLocalBox(); 
		} else {
			
			runSeleniumFromJenkins(platform, browser, version, device,
					deviceModel);
		}
	}
	
	public String cleanUpUserRoles() {
	String membershipCampaignURL = null;
	try {
			System.out.println("You are in  cleanUpUserRoles() ");
			Class.forName(JDBC_DRIVER).newInstance();
		   	Connection con = DriverManager.getConnection(JDBC_DRIVER_URL, DB_USER_NAME, DB_PWD);
		   	Statement stmt = (Statement) con.createStatement();
		   	ResultSet result = (ResultSet) stmt.executeQuery(USER_QUERY);	
		   	if(result.next()){
			   	System.out.println("result  being fetched   : " + result);
			   	String userID = result.getString("id");
			   	System.out.println("User ID being fetched   : "+userID);
			   	String combinedQuery = CAMPAIGN_QUERY + userID + "'";
			    ResultSet resultTwo = (ResultSet) stmt.executeQuery(combinedQuery);	
			    if(resultTwo.next()){
				   	System.out.println("resultSetTwo being fetched   : " + resultTwo);
				   	membershipCampaignURL = resultTwo.getString("url");
				   	System.out.println("resultSetTwo being fetched   : " + membershipCampaignURL);
			    }
		   	}
		   con.close();
		} catch (Exception e) {
			System.err.println("e.getMessage()" + e);
		}
	 return membershipCampaignURL;
	}
	

	private void runSeleniumFromLocalBox() {
		
		if (context.getSauceUrl() != null) {
			String gridHubUrl = context
					.getSeleniumDefaultDesktopDeviceEndPoint();
			String browser = context.getSeleniumDefaultBrowser();
			getRemoteDriver(gridHubUrl, browser);
			System.out.println("Starting selenium grid on " + gridHubUrl);
		} else if (context.getSeleniumLocalServerHub() != null) {
			String gridHubUrl = context.getSeleniumLocalServerHub();
			String browser = context.getSeleniumBrowser();
			getRemoteDriver(gridHubUrl, browser);
			System.out.println("Starting selenium grid on " + gridHubUrl);
		} else {
			System.out.println("Starting selenium on local box");
			getLocalFirefoxDriver();
		}
	}

	public void getRemoteDriver(String gridHubUrl, String browser) {
		setBrowser(browser);

		DesiredCapabilities capability = this.setBrowser(browser);

		try {
			context.driver = new RemoteWebDriver(new URL(gridHubUrl),
					capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	
	private void runSeleniumFromJenkins(String platform, String browser,
			String version, String device, String deviceModel) {
		platform = initialisePlatform(platform);
		browser = initialiseBrowser(browser);
		version = initialiseVersion(version);
		deviceModel = initialiseDeviceModel(deviceModel);
		device = initialiseDevice(device);

		if (doSkipTest(browser, platform, version, device, deviceModel)) {
			throw new SkipException("Skipped test for: BROWSER: " + browser
					+ "; " + "BROWSER VERSION: " + version + "; PLATFORM: "
					+ platform + "; DEVICE: " + device + "; DEVICE MODEL: "
					+ deviceModel);
		}

		System.out.println("Running test for: BROWSER: " + browser + "; "
				+ "BROWSER VERSION: " + version + "; PLATFORM: " + platform
				+ "; DEVICE: " + device);

		DesiredCapabilities caps = setBrowser(browser);
		setPlatform(platform, caps);

		caps.setVersion(version);

		try {
			String seleniumServerHub = getSeleniumServerHub(device);

			System.out.println("Connecting to Selenium Server Hub end point: "
					+ seleniumServerHub);

			context.driver = new RemoteWebDriver(new URL(seleniumServerHub),
					caps);
		} catch (Exception e) {
			throw new SkipException(
					"Skipped test for: BROWSER: "
							+ browser
							+ "; "
							+ "BROWSER VERSION: "
							+ version
							+ "; PLATFORM: "
							+ platform
							+ "; DEVICE: "
							+ device
							+ "; DEVICE MODEL: "
							+ deviceModel
							+ "; because there was an issue setting up the remote web driver.");
		}

		if (context.getSauceUrl() != null) {
			String gridHubUrl = context.getSauceUrl();
			context.driver.get(gridHubUrl);
		}
	}

	
	public WebDriver getLocalFirefoxDriver() {
		// implementation looks for your custom firefox profile. Make sure you
		// have firefox profile with your username and not default user.
		String userName = System.getProperty(USER_NAME);
		LOGGER.info("User name: " + userName);
		String environmentHost = System.getenv("ENVIRONMENT");
		LOGGER.info("Tests are running on Environment  : "+environmentHost );
		ProfilesIni allProfiles = new ProfilesIni();
		System.setProperty(WEBDRIVER_FIREFOX_PROFILE, userName);
		String browserProfile = System.getProperty(WEBDRIVER_FIREFOX_PROFILE);
		FirefoxProfile profile = allProfiles.getProfile(browserProfile);
		profile.setAcceptUntrustedCertificates(true);
		
		profile.setPreference("dom.forms.number", false);
		WebDriver firefoxDriver = new FirefoxDriver(profile);
		// the core team needs the firefox window to be maximum for most of the tests 
		firefoxDriver.manage().window().maximize();
//		System.out.println("Driver object is created at once every ");

		return context.driver = firefoxDriver;
	}

	private String getSeleniumServerHub(String device) {
		String endPoint = null;

		if (device.equalsIgnoreCase(TABLET)) {
			endPoint = context.getSeleniumTabletDeviceEndPoint();
		} else if (device.equals(MOBILE)) {
			endPoint = context.getSeleniumMobileDeviceEndPoint();
		} else {
			endPoint = context.getSeleniumDesktopDeviceEndPoint();
		}

		if (endPoint.equalsIgnoreCase(SAUCELABS)) {
			return context.getSeleniumSauceLabsServerHub();
		}

		return context.getSeleniumLocalServerHub();
	}

	@AfterMethod(alwaysRun = true)
	public void takeScreenshot(ITestResult result) {
		File screenshot = ((TakesScreenshot) context.driver)
				.getScreenshotAs(OutputType.FILE);
		String userHome = System.getProperty("user.home");
		String seleniumScreenshotDirName = userHome + File.separator
				+ "seleniumScreenshots";
		File seleniumScreenshotDir = new File(seleniumScreenshotDirName);
		if (!seleniumScreenshotDir.exists()) {
			seleniumScreenshotDir.mkdir();

		}
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMMdd-HHmmss");
		String nowStr = format.format(now);
		File permLocation = new File(seleniumScreenshotDirName + File.separator
				+ this.getClass().getSimpleName() + "_"
				+ result.getMethod().getMethodName() + "_" + nowStr + ".png");
		try {
			FileUtils.copyFile(screenshot, permLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Saved at " + permLocation.getAbsolutePath());
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		context.driver.manage().deleteAllCookies();
//		context.driver.close();
	}

	@AfterClass(alwaysRun = true)
	public void closeSession(){
		if (shouldCloseSeleniumAfterTestsCompleteOrFail()) {
				context.driver.quit();
			
		}
	}

	/**
	 * Whether or not Selenium should be shut-down (and the browser quit) after Selenium either completes or encounters problems (e,g. tests fail). Default is true.
	 * 
	 * @return true if so, false otherwise. Default is true.
	 */
	protected boolean shouldCloseSeleniumAfterTestsCompleteOrFail() {
		return !SeleniumControlOptions.LEAVE_SELENIUM_OPEN_AFTER_TESTS;
	}
	
	
	private boolean doSkipTest(String browser, String platform, String version,
			String device, String deviceModel) {
		String browserToTest = context.getSeleniumBrowser();
		String browserVersionToTest = context.getSeleniumBrowserVersion();
		String platformToTest = context.getSeleniumPlatform();
		if (StringUtils.isNotBlank(device)) 
		{
				if (device.equalsIgnoreCase(DESKTOP)) 
				{
					if (!isValid(browserToTest, browser)
						|| !isValid(platformToTest, platform)
						|| !isValid(browserVersionToTest, version)) 
					{
							System.out.println("Skipping Desktop test");
							return true;
					}
				} else {
						String deviceModelToTest = null;

						if (device.equalsIgnoreCase(TABLET)) 
						{   deviceModelToTest = context.getSeleniumTabletDeviceModel();
						} else if (device.equalsIgnoreCase(MOBILE)) {
							deviceModelToTest = context.getSeleniumMobileDeviceModel();
						}

						if (StringUtils.isNotBlank(deviceModel)
						&& !isValid(deviceModelToTest, deviceModel)) {
							System.out.println("Skipping Device test, DeviceModelToTest: "
									+ deviceModelToTest
									+ " deviceModel: "
									+ deviceModel);
							return true;
						}
						}
				return true;
		} 
//			}else {
		return false;	
}
		
//	}

	private boolean isValid(String versionToRun, String testVersion) {
		if (versionToRun.equalsIgnoreCase(testVersion)
				|| versionToRun.equalsIgnoreCase(ALL)) {
			return true;
		}

		return false;
	}

	private DesiredCapabilities setBrowser(String browser) {
		DesiredCapabilities caps = null;

		if (browser.equalsIgnoreCase(IE)) {
			caps = DesiredCapabilities.internetExplorer();
			caps.setBrowserName(DesiredCapabilities.internetExplorer()
					.getBrowserName());
			caps.setCapability(
					InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true);
		}

		if (browser.equalsIgnoreCase(FIREFOX)) {
			caps = DesiredCapabilities.firefox();
			caps.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
		}

		if (browser.equalsIgnoreCase(IPAD)) {
			caps = DesiredCapabilities.ipad();
			caps.setBrowserName(DesiredCapabilities.ipad().getBrowserName());
		}

		if (browser.equalsIgnoreCase(IPHONE)) {
			caps = DesiredCapabilities.iphone();
			caps.setBrowserName(DesiredCapabilities.iphone().getBrowserName());
		}

		if (browser.equalsIgnoreCase(ANDROID)) {
			caps = DesiredCapabilities.android();
			caps.setBrowserName(DesiredCapabilities.android().getBrowserName());
		}

		if (browser.equalsIgnoreCase(CHROME)) {
			caps = DesiredCapabilities.chrome();
			caps.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
		}

		return caps;
	}

	private void setPlatform(String platform, DesiredCapabilities caps) {

		if (platform.equalsIgnoreCase(XP)) {
			caps.setPlatform(Platform.XP);
		}

		if (platform.equalsIgnoreCase(VISTA)) {
			caps.setPlatform(Platform.VISTA);
		}

		if (platform.equalsIgnoreCase(LINUX)) {
			caps.setPlatform(Platform.LINUX);
		}

		if (platform.equalsIgnoreCase(ANDROID)) {
			caps.setPlatform(Platform.ANDROID);
		}

		if (platform.equalsIgnoreCase(IOS)) {
			caps.setPlatform(Platform.MAC);
		}
	}

	private String initialiseDeviceModel(String deviceModel) {
		if (StringUtils.isBlank(deviceModel)) {
			System.out.println("deviceModel " + deviceModel);
			return "";
		}

		return deviceModel;
	}

	private String initialiseDevice(String device) {
		if (StringUtils.isBlank(device)) {
			System.out.println("device " + device);
			return DESKTOP;
		}

		return device;
	}

	private String initialiseBrowser(String browser) {
		if (StringUtils.isBlank(browser)) {
			System.out.println("browser " + browser);
			return context.getSeleniumDefaultBrowser();
		}

		return browser;
	}

	private String initialiseVersion(String version) {
		if (StringUtils.isBlank(version)) {
			System.out.println("version " + version);
			return context.getSeleniumDefaultBrowserVersion();
		}

		return version;
	}

	private String initialisePlatform(String platform) {
		if (StringUtils.isBlank(platform)) {
			System.out.println("platform " + platform);
			return context.getSeleniumDefaultPlatform();
		} else
			return platform;

	}
	
//	private String initialiseEnvironment(String environment) {
//		if (StringUtils.isBlank(environment)) {
//			System.out.println("environment " + environment);
//			return context.getEnvironment();
//		} else
//			return environment;
//
//	}
//	
//	private String initialiseEnvironmentProperty(String property) {
//		if (StringUtils.isBlank(property)) {
//			System.out.println("environment  property" + property);
//			return context.getEnvironmentProperties();
//		} else
//			return property;
//
//	}
}