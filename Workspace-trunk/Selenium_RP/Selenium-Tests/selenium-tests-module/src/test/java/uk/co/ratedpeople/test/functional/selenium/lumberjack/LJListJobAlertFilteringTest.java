package uk.co.ratedpeople.test.functional.selenium.lumberjack;

import org.openqa.selenium.TimeoutException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.APIJob;
import uk.co.ratedpeople.JobSubmitter;
import uk.co.ratedpeople.JobSubmitter.Trade;
import uk.co.ratedpeople.RestDomainXMLBeanUser;
import uk.co.ratedpeople.TradesmanSignupFactory;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class LJListJobAlertFilteringTest extends TestScript {

	private LumberJack underTest;
	private JobSubmitter jobSubmitter;
	private APIJob urgentReadyToHireChimneyJob;
	private APIJob twoDaysPlanningBudgetingBathroomJob;
	private final String POSTCODE = "SW1E 6AU";
	private TradesmanSignupFactory tradesmanSignupFactory;
	private RestDomainXMLBeanUser newTM;
	
	private final Integer BATHROOM_SPECIALIST = 1;
	private final Integer BUILDER = 3;
	private final Integer CCTV = 123;

	private enum TimingFilteringCriteria {
		URGENTLY, LT_2_DAYS, FLEXIBLE_S_D;
	}

	private enum IntentFilteringCriteria {
		READY_TO_HIRE, PLANNING_BUDGETING, INSURANCE_CLAIM;
	}

	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new LumberJack(this.context, scriptUtilities);
		jobSubmitter = new JobSubmitter();
		tradesmanSignupFactory = new TradesmanSignupFactory();

		Integer[] specialisationTypes = {BATHROOM_SPECIALIST, BUILDER, CCTV};
		newTM = tradesmanSignupFactory.doTradesmanSignupSpecificSpecialisationsAndPostcode(POSTCODE, specialisationTypes);

		urgentReadyToHireChimneyJob = jobSubmitter.submitJobTimingIntent(POSTCODE, Trade.BUILDER, JobSubmitter.SkillTypeIds.CHIMNEY_BUILDING_TYPE, "RANGE_500_1000", TimingFilteringCriteria.URGENTLY.name(),IntentFilteringCriteria.READY_TO_HIRE.name());
		twoDaysPlanningBudgetingBathroomJob = jobSubmitter.submitJobTimingIntent(POSTCODE, Trade.BATHROOM, JobSubmitter.SkillTypeIds.PLUMBER_BATHINSTALL_JOB_TYPE, "RANGE_500_1000", TimingFilteringCriteria.LT_2_DAYS.name(), IntentFilteringCriteria.PLANNING_BUDGETING.name());
	}

	@Test(enabled = true)
	public void testListJobAlertFilterByTiming() throws InterruptedException{
		APIJob[] urgentJobs = new APIJob[]{urgentReadyToHireChimneyJob};
		APIJob[] twoDaysjobs = new APIJob[]{twoDaysPlanningBudgetingBathroomJob};
		underTest.testListJobAlertFilter(newTM.getEmail(), "TIMING_FILTER_TAB", TimingFilteringCriteria.URGENTLY.name(), TimingFilteringCriteria.LT_2_DAYS.name(), TimingFilteringCriteria.FLEXIBLE_S_D.name(), urgentJobs, twoDaysjobs);
	}

	@Test(enabled = true)
	public void testListJobAlertFilterByIntent() throws InterruptedException{
		APIJob[] readyToHireJobs = new APIJob[]{urgentReadyToHireChimneyJob};
		APIJob[] planningBudgetingJobs = new APIJob[]{twoDaysPlanningBudgetingBathroomJob};
		underTest.testListJobAlertFilter(newTM.getEmail(), "STATUS_FILTER_TAB", IntentFilteringCriteria.READY_TO_HIRE.name(), IntentFilteringCriteria.PLANNING_BUDGETING.name(), IntentFilteringCriteria.INSURANCE_CLAIM.name(), readyToHireJobs, planningBudgetingJobs);
	}

	@Test(enabled = true, expectedExceptions = TimeoutException.class)
	public void testListJobAlertFilterBySkillsTMBathroomTradeOnly() throws Exception{
		//create user with just one specialisation
		Integer[] specialisationTypes = {BATHROOM_SPECIALIST};
		RestDomainXMLBeanUser newTM = tradesmanSignupFactory.doTradesmanSignupSpecificSpecialisationsAndPostcode(POSTCODE, specialisationTypes);

		underTest.testListJobAlertFilterSkillsView(newTM.getEmail(), "SHOW_ALL_SKILLS_LINK");
	}

	@Test(enabled = true)
	public void testListJobAlertFilterBySkills() throws Exception{
		APIJob[] chimneyJob = new APIJob[]{urgentReadyToHireChimneyJob};
		APIJob[] bathroomjob = new APIJob[]{twoDaysPlanningBudgetingBathroomJob};

		Integer[] skills = new Integer[]{Integer.valueOf(JobSubmitter.SkillTypeIds.CHIMNEY_BUILDING_TYPE), Integer.valueOf(JobSubmitter.SkillTypeIds.PLUMBER_BATHINSTALL_JOB_TYPE)};

		//test view for user with multiple specialisations
		underTest.testListJobAlertFilterSkillsView(newTM.getEmail(), "SHOW_ALL_SKILLS_LINK", skills);

		//test filtering by specific skills
		underTest.testListJobAlertFilter(newTM.getEmail(), "SHOW_ALL_SKILLS_LINK","CHIMNEY_SKILL", "BATHROOM_INSTALLATION_SKILL", "CCTV_SKILL", chimneyJob, bathroomjob);
	}

}
