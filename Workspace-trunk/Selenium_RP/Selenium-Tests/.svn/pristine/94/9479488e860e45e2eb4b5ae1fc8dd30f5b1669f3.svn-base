package uk.co.ratedpeople.test.functional.selenium.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.BuyGasJobByAddingCertificate;;

public class BuyGasJobByAddingCertificateTest extends TestScript {
	private BuyGasJobByAddingCertificate underTest;

	@BeforeClass
	public void beforeClass() {
		underTest = new BuyGasJobByAddingCertificate(context, scriptUtilities);		
	}

	@Test(enabled=true)
	public void buyGasJobLeadByAddingGasCertificate() throws Exception {
		underTest.submitGasJob();
		underTest.buyGasJobLeadByAddingGasCertificateAndDeletingCertificate();

	}
}
