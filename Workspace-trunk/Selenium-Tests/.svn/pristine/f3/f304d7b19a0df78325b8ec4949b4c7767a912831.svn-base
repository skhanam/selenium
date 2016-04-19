package uk.co.ratedpeople.test.functional.selenium.functions;

import org.openqa.selenium.By;
import org.testng.Assert;

import uk.co.ratedpeople.APIJob;
import uk.co.ratedpeople.CreditRequestSubmitter;
import uk.co.ratedpeople.JobPurchaseOrderSubmitter;
import uk.co.ratedpeople.JobSubmitter;
import uk.co.ratedpeople.UserRetriever;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class CreditRequest {
	private static final String TRADESPERSON_USERNAME = "aleksandr11@ratedtrades.com";
	private static final String TRADESPERSON_PASSWORD = "password";
	private static final String CREDIT_REQUEST_XML = "<creditrequest>" + "<reasoncode>UNABLE_TO_CONTACT</reasoncode>"
	+ "<comment>this is a credit request as unable to contact the customer</comment>" + "</creditrequest>";

	private String testUrl;
	private Login login;
	public String uniqueEmailAccountName;
	private JobSubmitter jobSubmitter;
	private UserRetriever userRetriever;
	private JobPurchaseOrderSubmitter poSubmitter;
	private CreditRequestSubmitter creditRequestSubmitter;
	private TestScriptUtilities scriptUtils;
	private SeleniumTestContext context;
	
	public CreditRequest(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		testUrl = context.getTestUrl();
		this.scriptUtils = scriptUtils;
		this.context = context;
		
		login = new Login(scriptUtils, context);
		
		jobSubmitter = new JobSubmitter();
		userRetriever = new UserRetriever();
		poSubmitter = new JobPurchaseOrderSubmitter();
		creditRequestSubmitter = new CreditRequestSubmitter();
	}
	
	private void creditRequestForAPurchasedJob() throws Exception {
		APIJob jobSubmitted = jobSubmitter.submitMetalWorkerJobForExistingUser("SE21 8JH");
		String jobReference = jobSubmitted.getId();
		int userId = userRetriever.getUserId(TRADESPERSON_USERNAME, TRADESPERSON_PASSWORD);
		poSubmitter.postPurchaseOrderWithoutCard(TRADESPERSON_USERNAME, TRADESPERSON_PASSWORD, userId, jobReference);
		creditRequestSubmitter.postCreditRequestForJob(TRADESPERSON_USERNAME, TRADESPERSON_PASSWORD, userId, jobReference, CREDIT_REQUEST_XML);
	}
	
	public String creditRequest() throws Exception {

		creditRequestForAPurchasedJob();
		
		scriptUtils.goTo(testUrl);
		login.login(context.getAdminCredentials());
		scriptUtils.goTo(testUrl + "/supportN/member/search");
		scriptUtils.sleep(3000);
		scriptUtils.fillInTextField("search_search", TRADESPERSON_USERNAME);
		scriptUtils.sleep(2000);
		scriptUtils.click("search_0");
		scriptUtils.sleep(3000);
		scriptUtils.click(By.xpath("//html/body/div/nav/ul/li[3]/a"));
		scriptUtils.sleep(3000);
		
		scriptUtils.click("quote_0");
		scriptUtils.sleep(3000);
		scriptUtils.click("quote__approveCreditRequest");
		scriptUtils.sleep(3000);
		if (context.driver.findElement(By.xpath("//html/body/div/div/div[3]/div/div/form/div[2]/div/b")).getText().contains("APPROVED")) {
																 
			System.out.println(context.driver.findElement(By.xpath("//html/body/div/div/div[3]/div/div/form/div[2]/div/b")).getText()); 
			
			scriptUtils.sleep(5000);	
			}
		else
	
		{Assert.fail("Credit request is not approved");
		}
		
		scriptUtils.click(By.linkText("LOG OUT"));
		
		creditRequestForAPurchasedJob();
		
		scriptUtils.goTo(testUrl);
		login.login(context.getAdminCredentials());
		scriptUtils.goTo(testUrl + "/supportN/member/search");
		scriptUtils.fillInTextField("search_search", TRADESPERSON_USERNAME);
		scriptUtils.click("search_0");	
		scriptUtils.sleep(3000);
		scriptUtils.click(By.xpath("//html/body/div/nav/ul/li[3]/a"));
		scriptUtils.sleep(3000);
		scriptUtils.click("quote_0");
		scriptUtils.sleep(3000);
		scriptUtils.click("quote__declineCreditRequest");
		if (context.driver.findElement(By.xpath("//html/body/div/div/div[3]/div/div/form/div[2]/div/b")).getText().contains("DECLINED")) {
			System.out.println(context.driver.findElement(By.xpath("//html/body/div/div/div[3]/div/div/form/div[2]/div/b")).getText());  
			}
		else
	
		{Assert.fail("Credit request is not declined");
		}

		return "";
	}
}
