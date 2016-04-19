package uk.co.ratedpeople.test.functional.selenium.jbilling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.CreateTradesman;
import uk.co.ratedpeople.test.functional.selenium.functions.JBillingRegression;


public class JBillingRegressionTest extends TestScript {
	private static final String OLD_TM_PW = "123456";

	private static final String TM_PASSWORD = "password";
	
	private JBillingRegression jbTest;
	private CreateTradesman underTest;
	
	
	@BeforeClass
	public void beforeClass() throws Exception {
		jbTest = new JBillingRegression(this.context, scriptUtilities);	
		underTest = new CreateTradesman(this.context, scriptUtilities);	
	}
	
	public static String tm1;
	public static String tm1_ID;
	public static String tm2 ;
	public static String tm2_ID;
	public static String tm3 ;
	public static String tm3_ID;
	public static String tm4 ;
	public static String tm4_ID ;
	public static String tm5 ;
	public static String tm5_ID;
	public static String tm6 ;
	public static String tm6_ID;
	public static String tm7;
	public static String tm7_ID;
	public static String tm8;
	public static String tm8_ID ;
	public static String tm9;
	public static String tm9_ID;
	public static String tm10;
	public static String tm10_ID;
	public static String tm11;
	public static String tm11_ID;
	public static String tm12;
	public static String tm12_ID;
	
	@Override
	protected boolean shouldCloseSeleniumAfterTestsCompleteOrFail() {
		return false;
//		return super.shouldCloseSeleniumAfterTestsCompleteOrFail();
	}

	@Test (enabled=false) 
	public void testJBilling() throws Exception {
		
		jbTest.postAndBuyJob(tm1,TM_PASSWORD);
		jbTest.postAndBuyJob(tm2,TM_PASSWORD);
		jbTest.postAndBuyJob(tm3,TM_PASSWORD);
		
		jbTest.postAndBuyJob(tm4,TM_PASSWORD);
		jbTest.postAndBuyJob(tm5,TM_PASSWORD);
		jbTest.postAndBuyJob(tm6,TM_PASSWORD);
		
	}
	
	@Test (enabled=false) 
	public void assertLastJBPayment() throws Exception {
		jbTest.loginJB();
		jbTest.assertLastPayment("961", "£24.00");
		jbTest.assertLastPayment("969", "£24.00");
	}
	

	/**
	 * Whether to create the TMs on this run.
	 * 
	 * If false, the IDs are expected to be found in the file that should've been generated on a previous run that had this set to true.
	 */
	private static final boolean CREATE_TMS_NOW = true;
	
	private static final boolean SKIP_ASSERTIONS = false;
	

	// Month 1 - Day 1. Create 10 TM 
	
	@Test (enabled=true, priority = 0 ) 
	public void create10TM() throws Exception {
		System.out.println("Test 1");
		
		if (CREATE_TMS_NOW) {
			CreateTradesman.TPDetails t1 = underTest.createNewTradesmanMK3JBilling();
			tm1 = t1.getUsername();
			tm1_ID = t1.getId();
			CreateTradesman.TPDetails t2 = underTest.createNewTradesmanMK3JBilling();
			tm2 = t2.getUsername();
			tm2_ID = t2.getId();
			CreateTradesman.TPDetails t3 = underTest.createNewTradesmanMK3JBilling();
			tm3 = t3.getUsername();
			tm3_ID = t3.getId();
			CreateTradesman.TPDetails t4 = underTest.createNewTradesmanMK3JBilling();
			tm4 = t4.getUsername();
			tm4_ID = t4.getId();
			CreateTradesman.TPDetails t5 = underTest.createNewTradesmanMK3JBilling();
			tm5 = t5.getUsername();
			tm5_ID = t5.getId();
			CreateTradesman.TPDetails t6 = underTest.createNewTradesmanMK3JBilling();
			tm6 = t6.getUsername();
			tm6_ID = t6.getId();
			CreateTradesman.TPDetails t7 = underTest.createNewTradesmanMK3JBilling();
			tm7 = t7.getUsername();
			tm7_ID = t7.getId();
			CreateTradesman.TPDetails t8 = underTest.createNewTradesmanMK3JBilling();
			tm8 = t8.getUsername();
			tm8_ID = t8.getId();
			CreateTradesman.TPDetails t9 = underTest.createNewTradesmanMK3JBilling();
			tm9 = t9.getUsername();
			tm9_ID = t9.getId();
			CreateTradesman.TPDetails t10 = underTest.createNewTradesmanMK3JBilling();
			tm10 = t10.getUsername();
			tm10_ID = t10.getId();
			CreateTradesman.TPDetails t11 = underTest.createNewTradesmanMK3JBilling();
			tm11 = t11.getUsername();
			tm11_ID = t11.getId();
			CreateTradesman.TPDetails t12 = underTest.createNewTradesmanMK3JBilling();
			tm12 = t12.getUsername();
			tm12_ID = t12.getId();

			System.out.println("public static String tm1 = \"" + tm1 + "\";");
			System.out.println("public static String tm1_ID = \"" + tm1_ID + "\";");
			System.out.println("public static String tm2 = \"" + tm2 + "\";");
			System.out.println("public static String tm2_ID = \"" + tm2_ID + "\";");
			System.out.println("public static String tm3 = \"" + tm3 + "\";");
			System.out.println("public static String tm3_ID = \"" + tm3_ID + "\";");
			System.out.println("public static String tm4 = \"" + tm4 + "\";");
			System.out.println("public static String tm4_ID = \"" + tm4_ID + "\";");
			System.out.println("public static String tm5 = \"" + tm5 + "\";");
			System.out.println("public static String tm5_ID = \"" + tm5_ID + "\";");
			System.out.println("public static String tm6 = \"" + tm6 + "\";");
			System.out.println("public static String tm6_ID = \"" + tm6_ID + "\";");
			System.out.println("public static String tm7 = \"" + tm7 + "\";");
			System.out.println("public static String tm7_ID = \"" + tm7_ID + "\";");
			System.out.println("public static String tm8 = \"" + tm8 + "\";");
			System.out.println("public static String tm8_ID = \"" + tm8_ID + "\";");
			System.out.println("public static String tm9 = \"" + tm9 + "\";");
			System.out.println("public static String tm9_ID = \"" + tm9_ID + "\";");
			System.out.println("public static String tm10 = \"" + tm10 + "\";");
			System.out.println("public static String tm10_ID = \"" + tm10_ID + "\";");
			System.out.println("public static String tm11 = \"" + tm11 + "\";");
			System.out.println("public static String tm11_ID = \"" + tm11_ID + "\";");
			System.out.println("public static String tm12 = \"" + tm12 + "\";");
			System.out.println("public static String tm12_ID = \"" + tm12_ID + "\";");

			saveTradesmenToFile();
		}

		loadTPDetailsFromFile();
		
	    	  
		
		// Make sure that Free Balance is 24 GBP for all tradesman
		jbTest.goToMK3();
		if (!SKIP_ASSERTIONS) {
			jbTest.assertFreeBalance(tm1, "£24.00");
			jbTest.assertFreeBalance(tm2, "£24.00");
			jbTest.assertFreeBalance(tm3, "£24.00");
			jbTest.assertFreeBalance(tm4, "£24.00");
			jbTest.assertFreeBalance(tm5, "£24.00");
			jbTest.assertFreeBalance(tm6, "£24.00");
			jbTest.assertFreeBalance(tm7, "£24.00");
			jbTest.assertFreeBalance(tm8, "£24.00");
			jbTest.assertFreeBalance(tm9, "£24.00");
			jbTest.assertFreeBalance(tm10, "£24.00");
		}

		jbTest.changeDate("1","60");
		jbTest.loginOut();
		// Copy tradesman data
	}

	
	
	// Month 1 - Day 2. 	
	@Test (enabled=true, priority = 1, dependsOnMethods = { "create10TM"})
	public void submitJob() throws Exception {
		System.out.println("Test 2");
		loadTPDetailsFromFile();
		
		if (!SKIP_ASSERTIONS) {
			jbTest.postAndBuyJob(tm6,TM_PASSWORD);
			jbTest.postAndBuyJob(tm7,TM_PASSWORD);
			jbTest.postAndBuyJob(tm8,TM_PASSWORD);
			jbTest.postAndBuyJob(tm9,TM_PASSWORD);
			
			jbTest.postAndBuyJob(tm11,TM_PASSWORD);
			jbTest.postAndBuyJob(tm12,TM_PASSWORD);
			
			// Check Free Balance for all users
			jbTest.goToMK3();
			jbTest.assertFreeBalance(tm1, "£24.00");
			jbTest.assertFreeBalance(tm2, "£24.00");
			jbTest.assertFreeBalance(tm3, "£24.00");
			jbTest.assertFreeBalance(tm4, "£24.00");
			jbTest.assertFreeBalance(tm5, "£24.00");
			jbTest.assertFreeBalance(tm6, "£9.60");
			jbTest.assertFreeBalance(tm7, "£9.60");
			jbTest.assertFreeBalance(tm8, "£9.60");
			jbTest.assertFreeBalance(tm9, "£9.60");
			jbTest.assertFreeBalance(tm10, "£24.00");
			
			jbTest.assertFreeBalance(tm11, "£9.60");
			jbTest.assertFreeBalance(tm12, "£9.60");
		}
		
		jbTest.goodwill(tm10);
		
		jbTest.changeDate("1","60");
		jbTest.loginOut();
	}
	
	// Month 1 - Day 3. 	
	@Test (enabled=true, priority = 2, dependsOnMethods = { "submitJob"})
	public void submitJobM1_D3() throws Exception {
		System.out.println("Test 3");
		loadTPDetailsFromFile();
		
		jbTest.postAndBuyJob(tm2,TM_PASSWORD);
		jbTest.postAndBuyJob(tm3,TM_PASSWORD);
		jbTest.postAndBuyJob(tm4,TM_PASSWORD);
		jbTest.postAndBuyJob(tm5,TM_PASSWORD);
		jbTest.postAndBuyJob(tm6,TM_PASSWORD);
		jbTest.postAndBuyJob(tm7,TM_PASSWORD);
		jbTest.postAndBuyJob(tm8,TM_PASSWORD);
		jbTest.postAndBuyJob(tm9,TM_PASSWORD);
		jbTest.postAndBuyJob(tm10,TM_PASSWORD);
		
		// Check Free Balance for all users
		jbTest.goToMK3();
		jbTest.assertFreeBalance(tm1, "£24.00");
		jbTest.assertFreeBalance(tm2, "£9.60");
		jbTest.assertFreeBalance(tm3, "£9.60");
		jbTest.assertFreeBalance(tm4, "£9.60");
		jbTest.assertFreeBalance(tm5, "£9.60");
		jbTest.assertFreeBalance(tm6, "£0.00");
		jbTest.assertFreeBalance(tm7, "£0.00");
		jbTest.assertFreeBalance(tm8, "£0.00");
		jbTest.assertFreeBalance(tm9, "£0.00");
		jbTest.assertFreeBalance(tm10, "£21.60");
		jbTest.assertFreeBalance(tm11, "£9.60");
		jbTest.assertFreeBalance(tm12, "£9.60");
		// Check lastPayment
		
		
		jbTest.changeDate("1","60");
		jbTest.loginOut();
	}
	
	// Month 1 - Day 4. 	
	@Test (enabled=true, priority = 3, dependsOnMethods = { "submitJobM1_D3"})
	public void submitJobM1_D4() throws Exception {
		System.out.println("Test 4");
		loadTPDetailsFromFile();
		
		jbTest.postAndBuyJob(tm3,TM_PASSWORD);
		jbTest.postAndBuyJob(tm6,TM_PASSWORD);
		jbTest.postAndBuyJob(tm11,TM_PASSWORD);
		jbTest.postAndBuyJob(tm12,TM_PASSWORD);
		
		jbTest.goToMK3();
		jbTest.assertFreeBalance(tm1, "£24.00");
		jbTest.assertFreeBalance(tm2, "£9.60");
		jbTest.assertFreeBalance(tm3, "£0.00");
		jbTest.assertFreeBalance(tm4, "£9.60");
		jbTest.assertFreeBalance(tm5, "£9.60");
		jbTest.assertFreeBalance(tm6, "£0.00");
		jbTest.assertFreeBalance(tm7, "£0.00");
		jbTest.assertFreeBalance(tm8, "£0.00");
		jbTest.assertFreeBalance(tm9, "£0.00");
		jbTest.assertFreeBalance(tm10, "£21.60");
		jbTest.assertFreeBalance(tm11, "£0.00");
		jbTest.assertFreeBalance(tm12, "£0.00");
		
		jbTest.loginJB();
		jbTest.assertLastPayment(tm3_ID, "£4.80");
		jbTest.assertLastPayment(tm6_ID, "£14.40");
		jbTest.assertLastPayment(tm11_ID, "£4.80");
		jbTest.assertLastPayment(tm12_ID, "£4.80");
		
		jbTest.changeDate("1","60");
		jbTest.loginOut();
	}
	
	// Month 1 - Day 5. 	
	@Test (enabled=true, priority = 4, dependsOnMethods = { "submitJobM1_D4"})
	public void submitJobM1_D5() throws Exception {
		System.out.println("Test 5");
		loadTPDetailsFromFile();
		
		jbTest.postAndBuyJob(tm2,TM_PASSWORD);
		jbTest.postAndBuyJob(tm3,TM_PASSWORD);
		jbTest.postAndBuyJob(tm5,TM_PASSWORD);
		
		jbTest.goToMK3();
		jbTest.goodwill(tm10);
		
		jbTest.assertFreeBalance(tm1, "£24.00");
		jbTest.assertFreeBalance(tm2, "£0.00");
		jbTest.assertFreeBalance(tm3, "£0.00");
		jbTest.assertFreeBalance(tm4, "£9.60");
		jbTest.assertFreeBalance(tm5, "£0.00");
		jbTest.assertFreeBalance(tm6, "£0.00");
		jbTest.assertFreeBalance(tm7, "£0.00");
		jbTest.assertFreeBalance(tm8, "£0.00");
		jbTest.assertFreeBalance(tm9, "£0.00");
		jbTest.assertFreeBalance(tm10, "£33.60");
		jbTest.assertFreeBalance(tm11, "£0.00");
		jbTest.assertFreeBalance(tm12, "£0.00");
		
		
		jbTest.loginJB();
		jbTest.assertLastPayment(tm2_ID, "£4.80");
		jbTest.assertLastPayment(tm3_ID, "£14.40");
		jbTest.assertLastPayment(tm5_ID, "£4.80");
				
		jbTest.changeDate("1","60");
		jbTest.loginOut();
	}
	
	// Month 1 - Day 6. 	
	@Test (enabled=true, priority = 5, dependsOnMethods = { "submitJobM1_D5"})
	public void submitJobM1_D6() throws Exception {
		System.out.println("Test 6");
		loadTPDetailsFromFile();
		
		jbTest.postAndBuyJob(tm3,TM_PASSWORD);
		
		jbTest.goToMK3();
		jbTest.creditRequest(tm5);
		
		jbTest.assertFreeBalance(tm1, "£24.00");
		jbTest.assertFreeBalance(tm2, "£0.00");
		jbTest.assertFreeBalance(tm3, "£0.00");
		jbTest.assertFreeBalance(tm4, "£9.60");
		jbTest.assertFreeBalance(tm5, "£14.40");
		jbTest.assertFreeBalance(tm6, "£0.00");
		jbTest.assertFreeBalance(tm7, "£0.00");
		jbTest.assertFreeBalance(tm8, "£0.00");
		jbTest.assertFreeBalance(tm9, "£0.00");
		jbTest.assertFreeBalance(tm10, "£33.60");
		jbTest.assertFreeBalance(tm11, "£0.00");
		jbTest.assertFreeBalance(tm12, "£0.00");
		
		jbTest.loginJB();
		jbTest.assertLastPayment(tm3_ID, "£14.40");
		
		jbTest.changeDate("1","60");
		jbTest.loginOut();
	}
	
	// Month 1 - Day 7. 	
	@Test (enabled=true, priority = 6, dependsOnMethods = { "submitJobM1_D6"})
	public void submitJobM1_D7() throws Exception {
		System.out.println("Test 7");
		loadTPDetailsFromFile();
		
		jbTest.postAndBuyJob(tm3,TM_PASSWORD);
		
		jbTest.goToMK3();
		jbTest.assertFreeBalance(tm1, "£24.00");
		jbTest.assertFreeBalance(tm2, "£0.00");
		jbTest.assertFreeBalance(tm3, "£0.00");
		jbTest.assertFreeBalance(tm4, "£9.60");
		jbTest.assertFreeBalance(tm5, "£14.40");
		jbTest.assertFreeBalance(tm6, "£0.00");
		jbTest.assertFreeBalance(tm7, "£0.00");
		jbTest.assertFreeBalance(tm8, "£0.00");
		jbTest.assertFreeBalance(tm9, "£0.00");
		jbTest.assertFreeBalance(tm10, "£33.60");
		jbTest.assertFreeBalance(tm11, "£0.00");
		jbTest.assertFreeBalance(tm12, "£0.00");
		
		jbTest.loginJB();
		jbTest.assertLastPayment(tm3_ID, "£14.40");
		
		
		
		jbTest.changeDate("8","60");
		jbTest.loginOut();
		// wait a lot
	}
	
	// Month 1 - Day 15. 	
	@Test (enabled=true, priority = 7, dependsOnMethods = { "submitJobM1_D7"})
	public void submitJobM1_D15() throws Exception {
		System.out.println("Test 8");
		loadTPDetailsFromFile();
		
		jbTest.goToMK3();
		jbTest.cancelAccount(tm8);
		
		jbTest.changeDate("5","60");
		jbTest.loginOut();
		// wait
	}
	
	// Month 1 - Day 20.  	
	@Test (enabled=true, priority = 8, dependsOnMethods = { "submitJobM1_D15"})
	public void submitJobM1_D20() throws Exception {
		System.out.println("Test 9");
		loadTPDetailsFromFile();
		
		jbTest.postAndBuyJob(tm8,TM_PASSWORD);
		
		jbTest.goToMK3();
		jbTest.assertFreeBalance(tm1, "£24.00");
		jbTest.assertFreeBalance(tm2, "£0.00");
		jbTest.assertFreeBalance(tm3, "£0.00");
		jbTest.assertFreeBalance(tm4, "£9.60");
		jbTest.assertFreeBalance(tm5, "£14.40");
		jbTest.assertFreeBalance(tm6, "£0.00");
		jbTest.assertFreeBalance(tm7, "£0.00");
		jbTest.assertFreeBalance(tm8, "£0.00");
		jbTest.assertFreeBalance(tm9, "£0.00");
		jbTest.assertFreeBalance(tm10, "£33.60");
		jbTest.assertFreeBalance(tm11, "£0.00");
		jbTest.assertFreeBalance(tm12, "£0.00");
		
		jbTest.loginJB();
		jbTest.assertLastPayment(tm8_ID, "£14.40");
		
	
		jbTest.changeDate("5","60");
		jbTest.loginOut();
		// wait
	}
	
	// Month 1 - Day 25. 	
	@Test (enabled=true, priority = 9, dependsOnMethods = { "submitJobM1_D20"})
	public void submitJobM1_D25() throws Exception {
		System.out.println("Test 10");
		loadTPDetailsFromFile();
		
		// tm6 changes to annual plan.
		jbTest.goToMK3();
		jbTest.switchToPlan(tm6, "601");
		jbTest.changeDate("6","60");
		//wait
		jbTest.goToMK3();
		jbTest.changeDate("1","60");

		
		jbTest.goToMK3();
		jbTest.changeDate("1","60"); 
		
		jbTest.flushUserInfo();
		jbTest.loginOut();
		// clear cache

		
		
		loadTPDetailsFromFile();
		jbTest.goToMK3();
		jbTest.assertFreeBalance(tm1, "£24.00");
		jbTest.assertFreeBalance(tm2, "£24.00");
		jbTest.assertFreeBalance(tm3, "£24.00");
		jbTest.assertFreeBalance(tm4, "£24.00");
		jbTest.assertFreeBalance(tm5, "£38.40");
		jbTest.assertFreeBalance(tm6, "£0.00");
		jbTest.assertFreeBalance(tm7, "£24.00");
		jbTest.assertFreeBalance(tm8, "£0.00");
		jbTest.assertFreeBalance(tm9, "£24.00");
		jbTest.assertFreeBalance(tm10, "£36.00");
		jbTest.assertFreeBalance(tm11, "£24.00");
		jbTest.assertFreeBalance(tm12, "£24.00");
		
		
		// assert 8 is suspended
		// assert all billing data (invoices)
		jbTest.loginOut();

	}
	
	// Month 2 - Day 2.
	@Test(enabled = true, priority = 10, dependsOnMethods = { "submitJobM1_D25"})
	public void submitJobM2_D2() throws Exception {
		System.out.println("Test 11");
		loadTPDetailsFromFile();
		
		jbTest.postAndBuyJob(tm5,TM_PASSWORD);
		jbTest.postAndBuyJob(tm7,TM_PASSWORD);
		jbTest.postAndBuyJob(tm9,TM_PASSWORD);
		
		jbTest.goToMK3();
		jbTest.assertFreeBalance(tm1, "£24.00");
		jbTest.assertFreeBalance(tm2, "£24.00");
		jbTest.assertFreeBalance(tm3, "£24.00");
		jbTest.assertFreeBalance(tm4, "£24.00");
		jbTest.assertFreeBalance(tm5, "£24.00");
		jbTest.assertFreeBalance(tm6, "£0.00");
		jbTest.assertFreeBalance(tm7, "£9.60");
		jbTest.assertFreeBalance(tm8, "£0.00");
		jbTest.assertFreeBalance(tm9, "£9.60");
		jbTest.assertFreeBalance(tm10, "£36.00");
		jbTest.assertFreeBalance(tm11, "£24.00");
		jbTest.assertFreeBalance(tm12, "£24.00");
		
		jbTest.changeDate("1","60"); 
		
		jbTest.loginOut();
	}
	
	// Month 2 - Day 3.
	@Test(enabled = true, priority = 11, dependsOnMethods = { "submitJobM2_D2"})
	public void submitJobM2_D3() throws Exception {
		System.out.println("Test 12");
		loadTPDetailsFromFile();
		
		jbTest.postAndBuyJob(tm5,TM_PASSWORD);
		jbTest.postAndBuyJob(tm7,TM_PASSWORD);
		jbTest.postAndBuyJob(tm9,TM_PASSWORD);
		
		jbTest.goToMK3();
		jbTest.assertFreeBalance(tm1, "£24.00");
		jbTest.assertFreeBalance(tm2, "£24.00");
		jbTest.assertFreeBalance(tm3, "£24.00");
		jbTest.assertFreeBalance(tm4, "£24.00");
		jbTest.assertFreeBalance(tm5, "£9.60");
		jbTest.assertFreeBalance(tm6, "£0.00");
		jbTest.assertFreeBalance(tm7, "£0.00");
		jbTest.assertFreeBalance(tm8, "£0.00");
		jbTest.assertFreeBalance(tm9, "£0.00");
		jbTest.assertFreeBalance(tm10, "£36.00");
		jbTest.assertFreeBalance(tm11, "£24.00");
		jbTest.assertFreeBalance(tm12, "£24.00");
		
		jbTest.loginJB();
		jbTest.assertLastPayment(tm7_ID, "£4.80");
		jbTest.assertLastPayment(tm9_ID, "£4.80");
		
		jbTest.changeDate("2","60"); 
		
		jbTest.loginOut();
	}
	
	// Month 2 - Day 5.
	@Test(enabled = true, priority = 12, dependsOnMethods = { "submitJobM2_D3"})
	public void submitJobM2_D5() throws Exception {
		System.out.println("Test 13");
		loadTPDetailsFromFile();
		
		//tm7 changes to annual
		
		jbTest.goToMK3();
		jbTest.switchToPlan(tm7, "601");
		jbTest.cancelAccount(tm9);
		

		jbTest.changeDate("5","60"); 
		jbTest.loginOut();
	}
	
	// Month 2 - Day 10.
	@Test(enabled = true, priority = 13, dependsOnMethods = { "submitJobM2_D5"})
	public void submitJobM2_D10() throws Exception {
		System.out.println("Test 14");
		loadTPDetailsFromFile();
		
		jbTest.postAndBuyJob(tm7, TM_PASSWORD);
		
		jbTest.goToMK3();
		jbTest.assertFreeBalance(tm1, "£24.00");
		jbTest.assertFreeBalance(tm2, "£24.00");
		jbTest.assertFreeBalance(tm3, "£24.00");
		jbTest.assertFreeBalance(tm4, "£24.00");
		jbTest.assertFreeBalance(tm5, "£9.60");
		jbTest.assertFreeBalance(tm6, "£0.00");
		jbTest.assertFreeBalance(tm7, "£0.00");
		jbTest.assertFreeBalance(tm8, "£0.00");
		jbTest.assertFreeBalance(tm9, "£0.00");
		jbTest.assertFreeBalance(tm10, "£36.00");
		jbTest.assertFreeBalance(tm11, "£24.00");
		jbTest.assertFreeBalance(tm12, "£24.00");
		
		jbTest.loginJB();
		jbTest.assertLastPayment(tm7_ID, "£14.40");

		
		jbTest.changeDate("20","60"); 
		
		jbTest.loginOut();
	}
	
	// Month 2 - DBBR.
	@Test(enabled = true, priority = 14, dependsOnMethods = { "submitJobM2_D10"})
	public void submitJobM2_DBB() throws Exception {
		System.out.println("Test 15");
		loadTPDetailsFromFile();
		
		jbTest.postAndBuyJob(tm9, TM_PASSWORD);
		
		jbTest.goToMK3();
		jbTest.assertFreeBalance(tm1, "£24.00");
		jbTest.assertFreeBalance(tm2, "£24.00");
		jbTest.assertFreeBalance(tm3, "£24.00");
		jbTest.assertFreeBalance(tm4, "£24.00");
		jbTest.assertFreeBalance(tm5, "£9.60");
		jbTest.assertFreeBalance(tm6, "£0.00");
		jbTest.assertFreeBalance(tm7, "£0.00");
		jbTest.assertFreeBalance(tm8, "£0.00");
		jbTest.assertFreeBalance(tm9, "£0.00");
		jbTest.assertFreeBalance(tm10, "£36.00");
		jbTest.assertFreeBalance(tm11, "£24.00");
		jbTest.assertFreeBalance(tm12, "£24.00");
		
		jbTest.loginJB();
		jbTest.assertLastPayment(tm9_ID, "£14.40");
		
		jbTest.changeDate("1","60"); 
		// clear chache
		jbTest.flushUserInfo();
		// assert balances
		// assert invoices 
		jbTest.loginOut();
	
	}
	
	// Month 3 - Day 1.
	@Test(enabled = true, priority = 15, dependsOnMethods = { "submitJobM2_DBB"})
	public void submitJobM3_D1() throws Exception {		
		System.out.println("Test 16");
		loadTPDetailsFromFile();
		
		jbTest.goToMK3();
		jbTest.assertFreeBalance(tm1, "£24.00");
		jbTest.assertFreeBalance(tm2, "£24.00");
		jbTest.assertFreeBalance(tm3, "£24.00");
		jbTest.assertFreeBalance(tm4, "£24.00");
		jbTest.assertFreeBalance(tm5, "£24.00");
		jbTest.assertFreeBalance(tm6, "£0.00");
		jbTest.assertFreeBalance(tm7, "£0.00");
		jbTest.assertFreeBalance(tm8, "£0.00");
		jbTest.assertFreeBalance(tm9, "£0.00");
		jbTest.assertFreeBalance(tm10, "£36.00");
		jbTest.assertFreeBalance(tm11, "£24.00");
		jbTest.assertFreeBalance(tm12, "£24.00");
		 
		jbTest.changeDate("1","60"); 
		jbTest.loginOut();
	}
	
	// Month 3 - Day 2.
	@Test(enabled = true, priority = 16, dependsOnMethods = { "submitJobM3_D1"})
	public void submitJobM3_D2() throws Exception {
		System.out.println("Test 17");
		loadTPDetailsFromFile();
		
		jbTest.postAndBuyJob(tm6, TM_PASSWORD);
		
		jbTest.goToMK3();
		jbTest.assertFreeBalance(tm1, "£24.00");
		jbTest.assertFreeBalance(tm2, "£24.00");
		jbTest.assertFreeBalance(tm3, "£24.00");
		jbTest.assertFreeBalance(tm4, "£24.00");
		jbTest.assertFreeBalance(tm5, "£24.00");
		jbTest.assertFreeBalance(tm6, "£0.00");
		jbTest.assertFreeBalance(tm7, "£0.00");
		jbTest.assertFreeBalance(tm8, "£0.00");
		jbTest.assertFreeBalance(tm9, "£0.00");
		jbTest.assertFreeBalance(tm10, "£36.00");
		jbTest.assertFreeBalance(tm11, "£24.00");
		jbTest.assertFreeBalance(tm12, "£24.00");
		
		jbTest.loginJB();
		jbTest.assertLastPayment(tm6_ID, "£14.40");
		
		jbTest.changeDate("1","60"); 
		jbTest.loginOut();
	}
	
	// Month 3 - Day 3.
	@Test(enabled = true, priority = 17, dependsOnMethods = { "submitJobM3_D2"})
	public void submitJobM3_D3() throws Exception {
		System.out.println("Test 18");
		loadTPDetailsFromFile();
		
		jbTest.postAndBuyJob(tm4, TM_PASSWORD);
		
		jbTest.goToMK3();
		jbTest.creditRequest(tm6);
		
		jbTest.goToMK3();
		jbTest.assertFreeBalance(tm1, "£24.00");
		jbTest.assertFreeBalance(tm2, "£24.00");
		jbTest.assertFreeBalance(tm3, "£24.00");
		jbTest.assertFreeBalance(tm4, "£9.60");
		jbTest.assertFreeBalance(tm5, "£24.00");
		jbTest.assertFreeBalance(tm6, "£14.40");
		jbTest.assertFreeBalance(tm7, "£0.00");
		jbTest.assertFreeBalance(tm8, "£0.00");
		jbTest.assertFreeBalance(tm9, "£0.00");
		jbTest.assertFreeBalance(tm10, "£36.00");
		jbTest.assertFreeBalance(tm11, "£24.00");
		jbTest.assertFreeBalance(tm12, "£24.00");
		 
		jbTest.changeDate("28","60"); 

		jbTest.changeDate("1","60"); 
		
		// clear cache
		jbTest.flushUserInfo();
		// check invoices
		jbTest.loginOut();
	}
	
	
	// Month 4 - Day 1.
	@Test(enabled = true, priority = 18, dependsOnMethods = { "submitJobM3_D3"})
	public void submitJobM4_D1() throws Exception {
		System.out.println("Test 19");
		loadTPDetailsFromFile();

		jbTest.goToMK3();
		jbTest.assertFreeBalance(tm1, "£12.00");
		jbTest.assertFreeBalance(tm2, "£12.00");
		jbTest.assertFreeBalance(tm3, "£12.00");
		jbTest.assertFreeBalance(tm4, "£12.00");
		jbTest.assertFreeBalance(tm5, "£12.00");
		jbTest.assertFreeBalance(tm6, "£14.40");
		jbTest.assertFreeBalance(tm7, "£0.00");
		jbTest.assertFreeBalance(tm8, "£0.00");
		jbTest.assertFreeBalance(tm9, "£0.00");
		jbTest.assertFreeBalance(tm10, "£24.00");
		jbTest.assertFreeBalance(tm11, "£12.00");
		jbTest.assertFreeBalance(tm12, "£12.00");
		 
		jbTest.changeDate("2","60"); 
		jbTest.loginOut();
	}
	
	// Month 4 - Day 3.
	@Test(enabled = true, priority = 19, dependsOnMethods = { "submitJobM4_D1"})
	public void submitJobM4_D3() throws Exception {
		System.out.println("Test 20");
		loadTPDetailsFromFile();
		
		jbTest.postAndBuyJob(tm4, TM_PASSWORD);
		

		jbTest.goToMK3();
		jbTest.assertFreeBalance(tm1, "£12.00");
		jbTest.assertFreeBalance(tm2, "£12.00");
		jbTest.assertFreeBalance(tm3, "£12.00");
		jbTest.assertFreeBalance(tm4, "£0.00");
		jbTest.assertFreeBalance(tm5, "£12.00");
		jbTest.assertFreeBalance(tm6, "£14.40");
		jbTest.assertFreeBalance(tm7, "£0.00");
		jbTest.assertFreeBalance(tm8, "£0.00");
		jbTest.assertFreeBalance(tm9, "£0.00");
		jbTest.assertFreeBalance(tm10, "£24.00");
		jbTest.assertFreeBalance(tm11, "£12.00");
		jbTest.assertFreeBalance(tm12, "£12.00");
		 
		jbTest.loginJB();
		jbTest.assertLastPayment(tm4_ID, "£2.40");
		
		jbTest.changeDate("27","60"); 
		
		jbTest.changeDate("1","60"); 
		jbTest.flushUserInfo();
		jbTest.loginOut();
	}
	// run billing process
	// assert all stuff
	// :)
	
	
	
	/**
	 * 
	 */
	private void loadTPDetailsFromFile() {
		tm1 = getStringAtLine(0);
		tm1_ID = getStringAtLine(1);
		tm2 = getStringAtLine(2);
		tm2_ID = getStringAtLine(3);
		tm3 = getStringAtLine(4);
		tm3_ID = getStringAtLine(5);
		tm4 = getStringAtLine(6);
		tm4_ID = getStringAtLine(7);
		tm5 = getStringAtLine(8);
		tm5_ID = getStringAtLine(9);
		tm6 = getStringAtLine(10);
		tm6_ID = getStringAtLine(11);
		tm7 = getStringAtLine(12);
		tm7_ID = getStringAtLine(13);
		tm8 = getStringAtLine(14);
		tm8_ID = getStringAtLine(15);
		tm9 = getStringAtLine(16);
		tm9_ID = getStringAtLine(17);
		tm10 = getStringAtLine(18);
		tm10_ID = getStringAtLine(19);
		tm11 = getStringAtLine(20);
		tm11_ID = getStringAtLine(21);
		tm12 = getStringAtLine(22);
		tm12_ID = getStringAtLine(23);
	}

	/**
	 * @param lineNumber
	 */
	private String getStringAtLine(int lineNumber) {
		String strLine = null;
		try {

			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream("userId.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			// Read File Line By Line
			int i = 0;
			while ((strLine = br.readLine()) != null || i <= lineNumber) {
				// Print the content on the console
				
				if (i == lineNumber)
					break;
				i++;
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		//System.out.println("Reading line from file pos " + lineNumber + " result: " + strLine);
		return strLine;
	}

	/**
	 * @throws IOException
	 */
	private void saveTradesmenToFile() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter("userId.txt"));
		try {
			addLineToFile(out, tm1);
			addLineToFile(out, tm1_ID);
			addLineToFile(out, tm2);
			addLineToFile(out, tm2_ID);
			addLineToFile(out, tm3);
			addLineToFile(out, tm3_ID);
			addLineToFile(out, tm4);
			addLineToFile(out, tm4_ID);
			addLineToFile(out, tm5);
			addLineToFile(out, tm5_ID);
			addLineToFile(out, tm6);
			addLineToFile(out, tm6_ID);
			addLineToFile(out, tm7);
			addLineToFile(out, tm7_ID);
			addLineToFile(out, tm8);
			addLineToFile(out, tm8_ID);
			addLineToFile(out, tm9);
			addLineToFile(out, tm9_ID);
			addLineToFile(out, tm10);
			addLineToFile(out, tm10_ID);
			addLineToFile(out, tm11);
			addLineToFile(out, tm11_ID);
			addLineToFile(out, tm12);
			addLineToFile(out, tm12_ID);
		} finally {
			out.close();
		}
	}

	/**
	 * @param out
	 * @param tm13
	 * @throws IOException
	 */
	private void addLineToFile(BufferedWriter out, String line) throws IOException {
		out.write(line);
		out.newLine();
		//System.out.println(line + " Loaded into file userId.txt");
	}
	
	public static class TPDetails {
		private String username;
		private String id;
		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}
		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
		}
		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}
		
		
	}

}

