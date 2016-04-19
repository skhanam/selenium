package uk.co.ratedpeople.test.functional.selenium.tp;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class MemberBenefitTest extends TestScript {
 private TPMemberBenefits TPMB;
	
	
@BeforeClass
public void beforeClass() {
	TPMB = new TPMemberBenefits(this.context);
}

@Test(enabled=true) 
public void memberBenefitTest() throws Exception{
	TPMB.gettingMemberBenefitFromLandingPage();
	TPMB.gettingMemberBenefitFromSeeTermsPopup();
}
	
}