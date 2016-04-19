/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.core.regression;

import java.util.Hashtable;

/**
 * @author shabana.khanam
 *
 */
public class CreditBundleLocators {
	

	@SuppressWarnings("serial")
	public static Hashtable<String, String> xpathLookup = new Hashtable<String, String>(){
		{
			//Credit bundles 
			put("CREDIT",".//*[@id='creditAmount']");
			put("COST",".//*[@id='paymentAmount']");
			put("COSTVAT",".//*[@id='paymentAmountIncVat']");
//			put("CREDITBUNDLE",".//*[@id='container']/nav[@id='subnav']/ul/li[19]");
			put("CREDITBUNDLE","html/body/div[2]/nav/ul/li[19]/a");
			
			put("PAYBTN",".//*[@id='submitBuyCredit']");
			put("CREDITHEADER","html/body/div[1]/div/div[3]/div/div[2]/h1");
		}
		};

}
