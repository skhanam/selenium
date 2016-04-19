package uk.co.ratedpeople.test.functional.selenium.coresystems.pricing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author sangeetha.kumar
 * 
 * This test is used to check pricing for same job posted under different trades
 * Posting Aerial & Satellite Dish jobs from different trades like network, electrician and specialist
 * so that pricing can be checked to be the same
 */

public class PriceJobBySkillTest extends TestScript {
	private PriceJobBySkill underTest;
	
	// this method is set to false during debug mode
	@Override
	protected boolean shouldCloseSeleniumAfterTestsCompleteOrFail() {
		return true;
	}	
	
	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new PriceJobBySkill(this.context, scriptUtilities);		
	}
	
	@Test(enabled=true)
    public void testNetworkJobWithAerialSatelliteDish() throws Exception {
	underTest.submitJob1WithAerialSatelliteDish();
	}

	@Test(enabled=true,dependsOnMethods="testNetworkJobWithAerialSatelliteDish")
    public void testElectricianJobWithAerialSatelliteDish() throws Exception {
	underTest.submitJob2WithAerialSatelliteDish();
	}

	@Test(enabled=true,dependsOnMethods="testElectricianJobWithAerialSatelliteDish")
    public void testSpecialistJobWithAerialSatelliteDish() throws Exception {
	underTest.submitJob3WithAerialSatelliteDish();
	}
	
	@Test(enabled=true,dependsOnMethods="testSpecialistJobWithAerialSatelliteDish")
    public void testCompareJobPriceStandardTMBySkill() throws Exception {
	underTest.compareBuyLeadPriceStdTM();       
	}
	
	@Test(enabled=true,dependsOnMethods="testSpecialistJobWithAerialSatelliteDish")
    public void testCompareJobPricePAYGTMBySkill() throws Exception {
	underTest.compareBuyLeadPricePaygoTM();
	}
	
}