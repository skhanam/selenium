package uk.co.ratedpeople.test.functional.selenium.tests;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.SubmitJobAsNewCustomer;
import uk.co.ratedpeople.test.functional.selenium.questions.AskAnExpert;

public class AskAnExpertAndSubmitJobTest extends TestScript {
	
	private AskAnExpert question;
	private SubmitJobAsNewCustomer underTest;
	private String testUrl;
	private UniqueEmailAddressGenerator uniqueEmailAddressGenerator;
	
	@BeforeClass
	public void beforeClass() {
	  question =   new AskAnExpert(context, scriptUtilities);	
	  underTest = new SubmitJobAsNewCustomer(this.context, scriptUtilities);	
	  testUrl = context.getTestUrl();
	  uniqueEmailAddressGenerator = new UniqueEmailAddressGenerator();
	}
  
	
	
	@Test(enabled = false)
	public void askAnExpertSubmitJobTest() throws Exception{
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		question.askAnExpertLanding(uniqueEmailAccountName,2);
		underTest.submitJobAsNewCustomerWithEmail(testUrl,uniqueEmailAccountName);
	}
	
	@Test(enabled = false)
	public void SubmitJobAskAnExpertTest() throws Exception{
		String uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		underTest.submitJobAsNewCustomerWithEmail(testUrl,uniqueEmailAccountName);
		question.askAnExpertLanding(uniqueEmailAccountName,2);
	}

}