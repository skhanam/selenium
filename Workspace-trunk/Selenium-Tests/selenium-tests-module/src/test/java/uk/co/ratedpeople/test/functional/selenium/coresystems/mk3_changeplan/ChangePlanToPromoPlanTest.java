/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_changeplan;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_refreshjbilling.RefreshJBillinginMK3;

/**
 * @author shobha.rani
 *Changing Plans to Promo plans
 */
public class ChangePlanToPromoPlanTest extends TestScript{
	private RefreshJBillinginMK3 underTest;
	public String uniqueEmailAccountName;
	private ChangePlanToPromoPlan underPromoTest;
	private UniqueEmailAddressGenerator uniqueEmailAddressGenerator;
	
	@BeforeClass
	public void beforeClass() throws Exception 
	{
		underTest = new RefreshJBillinginMK3(this.context,scriptUtilities);
		underPromoTest = new ChangePlanToPromoPlan(this.context, scriptUtilities);
		uniqueEmailAddressGenerator = new UniqueEmailAddressGenerator();
	}
	
	@Test (enabled=false)
	public void createNewTMandtakingQuarterlyPromoplanTest() throws Exception 
	{
		uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		underTest.testCreateNewTradesmanMK3support(uniqueEmailAccountName);
		underTest.testUpdateLuceneSearch(uniqueEmailAccountName);
		underPromoTest.tesChangeQuarterlyPromoplan(uniqueEmailAccountName);
	}
	@Test (enabled=false)
	public void createNewTMandtakingMonthlyPromoplanTest() throws Exception 
	{
		uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		underTest.testCreateNewTradesmanMK3support(uniqueEmailAccountName);
		underPromoTest.tesChangeMonthlyPromoplan(uniqueEmailAccountName);
	}	
	
	}
  

