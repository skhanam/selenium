package uk.co.ratedpeople.test.functional.selenium.functions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import uk.co.ratedpeople.APIJob;
import uk.co.ratedpeople.JobPurchaseOrderSubmitter;
import uk.co.ratedpeople.JobSubmitter;
import uk.co.ratedpeople.UserRetriever;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class JBillingRegression {
	private Login login;
	public String uniqueEmailAccountName;
	private static JobSubmitter jobSubmitter;
	private UserRetriever userRetriever;
	private JobPurchaseOrderSubmitter poSubmitter;
	private TestScriptUtilities scriptUtils;
	private SeleniumTestContext context;

	public JBillingRegression(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		this.context = context;

		login = new Login(scriptUtils, context);

		jobSubmitter = new JobSubmitter();
		userRetriever = new UserRetriever();
		poSubmitter = new JobPurchaseOrderSubmitter();
	}

	/**
	 * Post a Job via the API, and Buy it via the API.
	 * 
	 * @param tradesman
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public String postAndBuyJob(String tradesman, String password) throws Exception {
		final String postcode = "sw1e 6dr";
		return postMetalWorkerJobInPostcodeAndBuyWithTmCredentials(postcode, tradesman, password);
	}

	/**
	 * Post a Metalworker Job via the API, in the given Postcode, then buy using the given TM credentials via the API.
	 * 
	 * @param postcode postcode to post the job in.
	 * @param tradesman the tradesman's username.
	 * @param password the tradesman's password
	 * @return
	 * @throws Exception
	 */
	public String postMetalWorkerJobInPostcodeAndBuyWithTmCredentials(final String postcode, String tradesman, String password) throws Exception {
		final APIJob jobSubmitted = jobSubmitter.submitMetalWorkerJobForExistingUser(postcode);
		final String jobReference = jobSubmitted.getId();
		final int userId = userRetriever.getUserId(tradesman, password);
		poSubmitter.postPurchaseOrderWithoutCard(tradesman, password, userId, jobReference);
		return "";
	}
	
	private String getRpAppUrlFor(final String urlPath) {
		final String hostUrl = this.context.getTestUrl();
		return buildUrlForHostUrlAndPath(hostUrl, urlPath);
	}

	private String buildUrlForHostUrlAndPath(final String hostUrl, final String urlPath) {
		final StringBuilder builder = new StringBuilder();
		builder.append(hostUrl);
		builder.append("/");
		builder.append(urlPath);
		final String url = builder.toString();
		return url;
	}

	/**
	 * Logs into jBilling.
	 * 
	 * @return
	 * @throws Exception
	 */
	public String loginJB() throws Exception {
//		scriptUtils.goTo("http://jbilltestingstack2.ratedpeople.com:8082/jbilling");
		System.err.println("\n\n\n=======================\n\n OMG about to go to: " + getJbillingUrlFor("jbilling"));
		scriptUtils.goTo(getJbillingUrlFor("jbilling"));

		scriptUtils.sleep(1000);
		
		scriptUtils.fillInTextField("j_username", "admin");
		scriptUtils.fillInTextField("j_password", "123qwe");
		scriptUtils.click(By.linkText("Login"));
		
		scriptUtils.sleep(2000);

		return "";
	}

//	private String getJbillingSslUrlFor(final String urlPath) {
//		final String jbUrl = this.context.getJBillingSslUrl();
//		return buildUrlForHostUrlAndPath(jbUrl, urlPath);
//	}
	

	private String getJbillingUrlFor(final String urlPath) {
		final String jbUrl = this.context.getJBillingUrl();
		return buildUrlForHostUrlAndPath(jbUrl, urlPath);
	}

	/**
	 * Logs out of the current WebApp.
	 * 
	 * @return
	 * @throws Exception
	 */
	public String loginOut() throws Exception {
		login.logoutAdmin();
		return "";
	}

	/**
	 * Logs into MK3, and requests the Member Search.
	 * 
	 * @return
	 * @throws Exception
	 */
	public String goToMK3() throws Exception {
		login.login(context.getAdminCredentials());
		//scriptUtils.goTo("https://jbilltestingstack2.ratedpeople.com/supportN/member/search");
		scriptUtils.goTo(this.getRpAppUrlFor("supportN/member/search"));
		return "";
	}

	/**
	 * Already logged in Admin Flushes specific jBilling Cached data from the RP-App using the Admin Show-Cache page.
	 * 
	 * @return
	 * @throws Exception
	 */
	public String flushUserInfo() throws Exception {
//		scriptUtils.goTo("https://jbilltestingstack.ratedpeople.com/admin/showProperties/cache");
		scriptUtils.goTo(getRpAppUrlFor("admin/showProperties/cache"));
		/*
		 * sleep(5000); scriptUtils.click(By.xpath("(//input[@id='flush'])[241]")); sleep(5000); scriptUtils.click(By.xpath("(//input[@id='flush'])[242]"));
		 * sleep(2000);
		 */

		scriptUtils.sleep(5000);
		scriptUtils.click(By.xpath("(//input[@id='flush'])[197]"));
		scriptUtils.sleep(5000);
		scriptUtils.click(By.xpath("(//input[@id='flush'])[198]"));
		scriptUtils.sleep(5000);
		scriptUtils.click(By.xpath("(//input[@id='flush'])[199]"));
		scriptUtils.sleep(5000);
		scriptUtils.click(By.xpath("(//input[@id='flush'])[200]"));
		scriptUtils.sleep(2000);

		return "";
	}

	/**
	 * An already logged in Agent in MK3 switches the TM's plan.
	 * 
	 * @param tradesman
	 * @param planSelectorId
	 * @return
	 * @throws Exception
	 */
	public String switchToPlan(String tradesman, String planSelectorId) throws Exception {
		context.driver.findElement(By.id("search_search")).clear();
		scriptUtils.fillInTextField("search_search", tradesman);
		scriptUtils.click("search_0");
		waitForAccountPageToLoad(planSelectorId);
		scriptUtils.sleep(5000);
		while (!context.driver.findElement(By.id("input-button-SHOW_SWITCH_PLANS")).isDisplayed()) {
			scriptUtils.sleep(1000);
		}
		scriptUtils.click("input-button-SHOW_SWITCH_PLANS");
		// while (!context.driver.findElement(By.xpath("(//input[@id='" + planSelectorId + "'])[3]")).isDisplayed()) {
		// sleep(100);
		// }
		scriptUtils.sleep(3000);
		// scriptUtils.click(By.xpath("//input[@id='" + planSelectorId + "']"));

		Select select = new Select(context.driver.findElement(By.id("tariffDropdown")));
		// select.deselectAll();
		select.selectByValue("PA-03");

		// scriptUtils.click("switchTariffDropdown");
		// sleep(2000);
		// scriptUtils.click(planSelectorId);
		scriptUtils.click("input-button-NEXT");
		scriptUtils.sleep(3000);
		scriptUtils.click("input-button-CONFIRM-switch");
		waitForStatusMessage();

		return "";
	}

	/**
	 * Already logged in Agent finds TM in MK3 and gets their jBilling ID.
	 * 
	 * @param tradesman
	 * @return
	 * @throws Exception
	 */
	public String getTMJBillingID(String tradesman) throws Exception {
		context.driver.findElement(By.id("search_search")).clear();
		scriptUtils.fillInTextField("search_search", tradesman);
		scriptUtils.click("search_0");

		return context.driver.findElement(By.id("userInfo-jbillingId")).getText();
	}

	/**
	 * Already logged in Agent looks at the TMs last payment in jBilling.
	 * 
	 * @param id
	 * @param balance
	 * @return
	 * @throws Exception
	 */
	public String assertLastPayment(String id, String balance) throws Exception {
//		scriptUtils.goTo("http://jbilltestingstack.ratedpeople.com:8082/jbilling/payment/user/" + id);
		scriptUtils.goTo(getJbillingUrlFor("jbilling/payment/user/" + id));
		assertEquals(context.driver.findElement(By.xpath("//html/body/div/div[2]/div[3]/div[3]/div/div/div/div/table/tbody/tr/td[4]/a/span")).getText(),
				balance);
		scriptUtils.sleep(3000);
		return "";
	}

	/**
	 * Already logged in Agent Finds the TM in MK3 and checks their Balance.
	 * 
	 * @param tradesman
	 * @param balance
	 * @return
	 * @throws Exception
	 */
	public String assertFreeBalance(String tradesman, String balance) throws Exception {
		scriptUtils.sleep(2000);
		context.driver.findElement(By.id("search_search")).clear();
		scriptUtils.fillInTextField("search_search", tradesman);
		scriptUtils.click("search_0");

		String userBalanceInfo = null;
		boolean waitingForInfo = true;
		while (waitingForInfo) {
			userBalanceInfo = context.driver.findElement(By.id("userInfo-balance")).getText();
			if (userBalanceInfo != null && !userBalanceInfo.equals("")) {
				waitingForInfo = false;
			}
		}
		scriptUtils.sleep(2000);
		assertEquals(userBalanceInfo, balance);

		return "";
	}

	/**
	 * Already Logged-In Admin Uses the RP-App Admin Web UI to fast-forward time.
	 * 
	 * @param day
	 * @param wait_time
	 * @return
	 * @throws Exception
	 */
	public String changeDate(String day, String wait_time) throws Exception {
//		scriptUtils.goTo("https://jbilltestingstack.ratedpeople.com/admin/regression/timejump");
		scriptUtils.goTo(getRpAppUrlFor("admin/regression/timejump"));
		scriptUtils.sleep(1000);
		context.driver.findElement(By.name("daysToTimeJump")).clear();
		context.driver.findElement(By.name("lengthOfBillingRun")).clear();
		context.driver.findElement(By.name("daysToTimeJump")).sendKeys(day);
		context.driver.findElement(By.name("lengthOfBillingRun")).sendKeys(wait_time);
		scriptUtils.click("button-START_TIMEJUMP");

		waitForTimeJumpToComplete();
		scriptUtils.sleep(2000);

		/*
		 * for (int attempt = 0; attempt < 10; attempt++) { try { context.driver.findElement(By.id("complete")); break; // Success! } catch
		 * (NoSuchElementException ignored) {
		 * 
		 * } //context.driver.navigate().refresh(); }
		 */

		return "";
	}

	private void waitForTimeJumpToComplete() {
		boolean waitingForTimeJumpToComplete = true;
		while (waitingForTimeJumpToComplete) {

			try {
				scriptUtils.sleep(1000);
				boolean test = context.driver.findElement(By.id("complete")).isDisplayed();
				waitingForTimeJumpToComplete = !test;
			} catch (Exception e) {
			}
		}
	}

	private void waitForStatusMessage() {
		boolean waitingForStatusMessage = true;
		while (waitingForStatusMessage) {
			try {
				scriptUtils.sleep(1000);
				boolean test = context.driver.findElement(By.id("statusMessage")).isDisplayed();
				waitingForStatusMessage = !test;
			} catch (Exception e) {
			}
		}
	}

	/**
	 * Already logged in Agent in MK3 finds the TM and grants them goodwill credit.
	 * The amount is fixed.
	 * 
	 * @param tradesman
	 * @return
	 * @throws Exception
	 */
	public String goodwill(String tradesman) throws Exception {
		context.driver.findElement(By.id("search_search")).clear();
		scriptUtils.fillInTextField("search_search", tradesman);
		scriptUtils.click("search_0");

		scriptUtils.click(By.linkText("Payment Details"));
		scriptUtils.sleep(3000);
		// scriptUtils.fillInTextField("TEXT-agentUser", "tom.brightwell@ratedpeople.com");
		// scriptUtils.fillInTextField("TEXT-agentPass", "password");
		// selectDropdown("creditReasonCode", 1);
		scriptUtils.fillInTextField("note", "Some notes");
		scriptUtils.selectDropdown("code", 3);

		scriptUtils.click("BUTTON-give_credit");
		scriptUtils.sleep(4000);

		return "";
	}

	/**
	 * Already logged-in Agent in MK3 finds the TM and submits a Credit Request on their behalf.
	 * 
	 * @param tradesman
	 * @return
	 * @throws Exception
	 */
	public String creditRequest(String tradesman) throws Exception {
		context.driver.findElement(By.id("search_search")).clear();
		scriptUtils.fillInTextField("search_search", tradesman);
		scriptUtils.click("search_0");

		scriptUtils.click(By.linkText("Purchased Jobs"));
		scriptUtils.click("quote_0");
		scriptUtils.selectDropdown("quote_selectedReasonId", 4);
		scriptUtils.fillInTextField("quote_recreditComment", "Please give my money back");
		scriptUtils.click("quote__recredit");
		scriptUtils.sleep(8000);
		return "";
	}

	/**
	 * Already logged in Agent searches in MK3 for TM and Suspends them.
	 * 
	 * @param tradesman
	 * @return
	 * @throws Exception
	 */
	public String cancelAccount(String tradesman) throws Exception {
		context.driver.findElement(By.id("search_search")).clear();
		scriptUtils.fillInTextField("search_search", tradesman);
		scriptUtils.click("search_0");
		scriptUtils.sleep(5000);
		scriptUtils.click("input-button-SUSPEND");
		scriptUtils.sleep(3000);
		return "";
	}

	private void waitForAccountPageToLoad(String planSelectorId) {
		for (int tries = 0;; tries++) {
			if (tries >= 4)
				break;
			try {
				scriptUtils.sleep(100);
				String test = context.driver.findElement(By.id(planSelectorId)).getAttribute("id");
				if (planSelectorId.equals(test))
					break;
			} catch (Exception e) {
			}
		}
	}
}
