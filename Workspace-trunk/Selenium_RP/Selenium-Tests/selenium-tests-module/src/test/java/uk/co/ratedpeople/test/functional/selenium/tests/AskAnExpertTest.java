package uk.co.ratedpeople.test.functional.selenium.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.questions.AskAnExpert;

public class AskAnExpertTest extends TestScript {

	private AskAnExpert question;

	@BeforeClass
	public void beforeClass() {
		question = new AskAnExpert(context, scriptUtilities);
	}

	@Test(enabled=false)
	public void askanExpertTest() {
		question.askAnExpertLanding("sangiho@ratedpeople.com", 2);
		question.askAnExpertLanding("sangiho@ratedpeople.com", 3);
		question.askAnExpertLanding("sangiho@ratedpeople.com", 4);
	}

	@Test(enabled=false)
	public void submitAnswerTest() {
//		question.submitAnswer("aleksandr01jbilling@ratedtrades.com", "password");
		question.submitAnswer("diyuserqa@ratedtrades.com", "password");
	}
}