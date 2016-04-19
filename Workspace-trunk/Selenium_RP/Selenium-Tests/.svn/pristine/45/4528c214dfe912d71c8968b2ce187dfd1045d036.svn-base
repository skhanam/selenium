package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varB;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author sangeetha.kumar
 * 
 *         This test is for signing up the new TM with variant B on monthly plan [15/30]using driving license as his screening details
 */

public class SignUpVariant_B_AndLogInTest extends TestScript {

	private SignUpVariantB signUpVariantB;
	private SignUpVariant_B_AndLogin signUpVariant_B_AndLogin;

	@BeforeClass
	public void beforeClass() throws Exception {
		signUpVariantB = new SignUpVariantB(this.context, scriptUtilities);
		signUpVariant_B_AndLogin = new SignUpVariant_B_AndLogin(this.context, scriptUtilities);
	}

	@DataProvider(name = "data")
	public static Object[][] postCode() {
		return new Object[][] {
			// 15/30 -> 7f5940396c13
			// 15/50 -> 0f05541d86b4
			// 0/50 -> 418486a9e548
				
			{ "MONTHLY", "7f5940396c13", "DL", "Introductory £15 monthly with £30 free leads", "£30.00" },
			{ "MONTHLY", "418486a9e548", "DL", "£0 monthly with £50 free leads", "£50.00" },
			{ "MONTHLY", "0f05541d86b4", "DL", "Introductory £15 monthly with £50 free leads", "£50.00" },
			{ "ANNUAL", "7f5940396c13", "DL", "Introductory £15 monthly with £30 free leads", "£30.00" },
			{ "ANNUAL", "418486a9e548", "DL", "£0 monthly with £50 free leads", "£50.00" },
			{ "ANNUAL", "0f05541d86b4", "DL", "Introductory £15 monthly with £50 free leads", "£50.00" },
		};

	}

	@Test(dataProvider = "data")
	public void signupVarBTest(final String rollOnType, final String tariff, final String screeningType, String tarriffText, String credit) throws Exception {
		String uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		
		signUpVariantB.signUpVarB(uniqueEmailAccountName, rollOnType, tariff, screeningType);
		signUpVariant_B_AndLogin.login(uniqueEmailAccountName, "password");
		signUpVariant_B_AndLogin.checkPostcode(SignupVarBXpathlocators.dataLookup.get("postcode"));
		signUpVariant_B_AndLogin.checkBilling(tarriffText, credit);
		List<String> skillList = createListSkills();

		signUpVariant_B_AndLogin.checkTrade(skillList);

	}

	private List<String> createListSkills() {
		List<String> skillList = new ArrayList<String>();
		skillList.add("CCTV");
		skillList.add("Digital Home Network");
		skillList.add("Fire Alarm System");
		skillList.add("Sound & Audio Visual Installation");
		skillList.add("Aerial & Satellite Dish");
		skillList.add("Burglar, Security & Intruder Alarm");
		return skillList;
	}

}
