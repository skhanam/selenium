package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author sangeetha.kumar
 * 
 *         This test is for signing up the new TM with variant E on monthly plan [15/30]using driving license as his screening details
 */

public class SignUpVariant_E_AndCheckTariffAndSkillsTest extends TestScript {

	private SignUpVariantE signUpVariantE;
	private SignUpVariant_E_AndCheckTariffAndSkill signUpVariant_E_AndCheckTariffAndSkill;

	@BeforeClass
	public void beforeClass() throws Exception {

		signUpVariantE = new SignUpVariantE(this.context, scriptUtilities);
		signUpVariant_E_AndCheckTariffAndSkill = new SignUpVariant_E_AndCheckTariffAndSkill(this.context, scriptUtilities);
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
	public void signupVarETest(final String rollOnType, final String tariff, final String screeningType, String tarriffText,String credit) throws Exception {
		String uniqueEmailAccountName = TestScriptUtilities.getRandomString(3) + new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		signUpVariantE.signUpVarE(uniqueEmailAccountName, rollOnType, tariff, screeningType);
		// String uniqueEmailAccountName = "mtM113741-03-Jun-2014-@ratedtrades.com";
		signUpVariant_E_AndCheckTariffAndSkill.login(uniqueEmailAccountName, "password");
		signUpVariant_E_AndCheckTariffAndSkill.checkPostcode(SignupVarEXpathlocators.dataLookup.get("postcode"));
		signUpVariant_E_AndCheckTariffAndSkill.checkBilling(tarriffText, credit);
		List<String> skillList = createListSkills();

		signUpVariant_E_AndCheckTariffAndSkill.checkTrade(skillList);

	}

	private List<String> createListSkills() {
		List<String> skillList = new ArrayList<String>();
		skillList.add("Thatched Roof");
		skillList.add("Velux / Skylight Window");
		skillList.add("Chimney Building / Repair");
		skillList.add("Slate & Tiled Roof");
		skillList.add("Thatched Roof");
		skillList.add("Zinc / Metal Roof");
		skillList.add("Flat Roof");
		skillList.add("Fascias / Soffits / Cladding - Wooden");
		skillList.add("Leadwork");
		skillList.add("Guttering and Rainwater Pipe");
		skillList.add("Fascias / Soffits / Cladding - uPVC");
		skillList.add("Flat Pack Furniture Assembly");
		skillList.add("General Maintenance");
		skillList.add("Carpet Cleaning");
		skillList.add("Commercial Cleaning");
		skillList.add("Domestic House Cleaning");
		return skillList;
	}

}
