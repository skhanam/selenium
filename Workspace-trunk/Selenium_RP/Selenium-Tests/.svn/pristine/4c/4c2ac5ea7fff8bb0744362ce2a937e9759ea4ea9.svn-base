package uk.co.ratedpeople.test.functional.selenium.newjobforms.plumbing;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.newbuilds.BuildXpathLocators;

public class PostingJobViaPlumbingJobForms {
	private static final String JOBTYPE = "jobtype";
	private static final String BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID = "56";
	private static final String PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID = "58";
	private static final String PLUMBER_TRADE_CODE = "plumber";
	private static final String NEXT_DESC_BLOCKED = "nextDescBlocked";
	private static final String NEXT_DESC_INSTALL = "nextDescInstall";
	private static final String NEXT_DESC_REPAIR = "nextDescRepair";
	private static final String NEXT_DESC_LEAK = "nextDescLeak";
	private static final String NEXT_DESC_REPLACE = "nextDescReplace";
	private static final String THANK_YOU_HEADER_TEXT_ID = "header-h1";
	private static final String THANK_YOU = "Thank you";
	
	private static final String ErewardIMAGE_XPATH  = ".//*[@id='skill-specifc-portable-jobform']/a/img";	
	private static final String SRC_CONTAINS  ="2/post-your-job/bundles/rpglobalassets/img/research-now-banner.jpg";

	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.PostingJobViaPlumbingJobForms");
	private WebDriver driver;
	private String testUrl;
	private SeleniumTestContext context;
	private TestScriptUtilities testScriptUtilities;
	public static final String NEXT = "next";

	public PostingJobViaPlumbingJobForms(final TestScriptUtilities testScriptUtilities, final SeleniumTestContext context, final String testUrl) {
		this.context = context;
		this.driver = context.driver;
		this.testScriptUtilities = testScriptUtilities;
		this.testUrl = testUrl;
	}

	public void PostingJobViaPlumbingJobFormLeaknotsure() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsleak(Xpathlocators.xpathLookup.get("leak"), Xpathlocators.xpathLookup.get("notsure"));
		additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		budget(9);
		location();
	}

	public void PostingJobViaPlumbingJobFormLeaknotsureBathroomroute() throws Exception {
		getQuotes(BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID);
		jobDetailsleak(Xpathlocators.xpathLookup.get("leak"), Xpathlocators.xpathLookup.get("notsure"));
		additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		budget(9);
		location();
	}

	public void PostingJobViaPlumbingJobFormLeaknotsureOtherBudgetBathroomroute() throws Exception {
		getQuotes(BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID);
		jobDetailsleak(Xpathlocators.xpathLookup.get("leak"), Xpathlocators.xpathLookup.get("notsure"));
		additionalInfo(Xpathlocators.xpathLookup.get("visiblefalse"), Xpathlocators.xpathLookup.get("accessiblefalse"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		budgetOther();
		location();
	}

	public void PostingJobViaPlumbingJobFormLeaknotsureOtherBudget() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsleak(Xpathlocators.xpathLookup.get("leak"), Xpathlocators.xpathLookup.get("notsure"));
		additionalInfo(Xpathlocators.xpathLookup.get("visiblefalse"), Xpathlocators.xpathLookup.get("accessiblefalse"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		budgetOther();
		location();
	}

	public void PostingJobViaPlumbingJobFormLeakMultiplepathtwo() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsleak(Xpathlocators.xpathLookup.get("leak"), Xpathlocators.xpathLookup.get("ltap"), Xpathlocators.xpathLookup.get("ltoilet"),
				Xpathlocators.xpathLookup.get("lwashbin"), Xpathlocators.xpathLookup.get("lbath"), Xpathlocators.xpathLookup.get("ltank"),
				Xpathlocators.xpathLookup.get("lsink"), Xpathlocators.xpathLookup.get("lshower"), Xpathlocators.xpathLookup.get("lboiler"));
		additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessiblefalse"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		budget(9);
		location();
	}

	public void PostingJobViaPlumbingJobFormLeakMultiplepathtwoBathroomroute() throws Exception {
		getQuotes(BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID);
		jobDetailsleak(Xpathlocators.xpathLookup.get("leak"), Xpathlocators.xpathLookup.get("ltap"), Xpathlocators.xpathLookup.get("ltoilet"),
				Xpathlocators.xpathLookup.get("lwashbin"), Xpathlocators.xpathLookup.get("lbath"), Xpathlocators.xpathLookup.get("ltank"),
				Xpathlocators.xpathLookup.get("lsink"), Xpathlocators.xpathLookup.get("lshower"), Xpathlocators.xpathLookup.get("lboiler"));
		additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessiblefalse"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		budget(9);
		location();
	}

	public void PostingJobViaPlumbingJobFormLeakMultiplepathtwoOtherBudget() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsleak(Xpathlocators.xpathLookup.get("leak"), Xpathlocators.xpathLookup.get("ltap"), Xpathlocators.xpathLookup.get("ltoilet"),
				Xpathlocators.xpathLookup.get("lwashbin"), Xpathlocators.xpathLookup.get("lbath"), Xpathlocators.xpathLookup.get("ltank"),
				Xpathlocators.xpathLookup.get("lsink"), Xpathlocators.xpathLookup.get("lshower"), Xpathlocators.xpathLookup.get("lboiler"));
		additionalInfo(Xpathlocators.xpathLookup.get("visiblefalse"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		budgetOther();
		location();
	}

	public void PostingJobViaPlumbingJobFormLeakMultiplepathtwoBathroomrouteOtherBudget() throws Exception {
		getQuotes(BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID);
		jobDetailsleak(Xpathlocators.xpathLookup.get("leak"), Xpathlocators.xpathLookup.get("ltap"), Xpathlocators.xpathLookup.get("ltoilet"),
				Xpathlocators.xpathLookup.get("lwashbin"), Xpathlocators.xpathLookup.get("lbath"), Xpathlocators.xpathLookup.get("ltank"),
				Xpathlocators.xpathLookup.get("lsink"), Xpathlocators.xpathLookup.get("lshower"), Xpathlocators.xpathLookup.get("lboiler"));
		additionalInfo(Xpathlocators.xpathLookup.get("visiblefalse"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		budgetOther();
		location();
	}

	public void PostingJobViaPlumbingJobFormLeakpathtwoOther() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsleak(Xpathlocators.xpathLookup.get("leak"), Xpathlocators.xpathLookup.get("lwashbin"), Xpathlocators.xpathLookup.get("lother"),
				Xpathlocators.xpathLookup.get("lotext"));
		additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormLeakpathtwoBathroomrouteOther() throws Exception {
		getQuotes(BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID);
		jobDetailsleak(Xpathlocators.xpathLookup.get("leak"), Xpathlocators.xpathLookup.get("lwashbin"), Xpathlocators.xpathLookup.get("lother"),
				Xpathlocators.xpathLookup.get("lotext"));
		additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormLeakpathtwoOthertextNbudget() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsleak(Xpathlocators.xpathLookup.get("leak"), Xpathlocators.xpathLookup.get("lwashbin"), Xpathlocators.xpathLookup.get("lother"),
				Xpathlocators.xpathLookup.get("lotext"));
		additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		budgetOther();
		location();

	}

	public void PostingJobViaPlumbingJobFormLeakpathtwoBathroomrouteOthertextNbudget() throws Exception {
		getQuotes(BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID);
		jobDetailsleak(Xpathlocators.xpathLookup.get("leak"), Xpathlocators.xpathLookup.get("lwashbin"), Xpathlocators.xpathLookup.get("lother"),
				Xpathlocators.xpathLookup.get("lotext"));
		additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		budgetOther();
		location();

	}

	public void PostingJobViaPlumbingJobFormLeakpathoneeach() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsleak(Xpathlocators.xpathLookup.get("leak"), Xpathlocators.xpathLookup.get("lwashbin"));
		additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormLeakpathoneBathroomrouteeach() throws Exception {
		getQuotes(BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID);
		jobDetailsleak(Xpathlocators.xpathLookup.get("leak"), Xpathlocators.xpathLookup.get("lwashbin"));
		additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormLeakpathoneeachOtherbudget() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsleak(Xpathlocators.xpathLookup.get("leak"), Xpathlocators.xpathLookup.get("lwashbin"));
		additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
		budgetOther();
		location();

	}

	/*
	 * Job details path repair with one option checked in path two
	 */

	public void PostingJobViaPlumbingJobFormRepair() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsRepair(Xpathlocators.xpathLookup.get("repair"), Xpathlocators.xpathLookup.get("repairtap"));
		additionalInfowithoutVisibility(Xpathlocators.xpathLookup.get("accessibletrue"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("repintent"), Xpathlocators.xpathLookup.get("repownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormRepairBathroomroute() throws Exception {
		getQuotes(BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID);
		jobDetailsRepair(Xpathlocators.xpathLookup.get("repair"), Xpathlocators.xpathLookup.get("repairtap"));
		additionalInfowithoutVisibility(Xpathlocators.xpathLookup.get("accessibletrue"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("repintent"), Xpathlocators.xpathLookup.get("repownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormRepairMultiplepathtwoOtherbudget() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsRepair(Xpathlocators.xpathLookup.get("repair"), Xpathlocators.xpathLookup.get("repairtap"));
		additionalInfowithoutVisibility(Xpathlocators.xpathLookup.get("accessibletrue"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("repintent"), Xpathlocators.xpathLookup.get("repownership"));
		budgetOther();
		location();

	}

	public void PostingJobViaPlumbingJobFormRepairMultiplepathtwoBathroomrouteOtherbudget() throws Exception {
		getQuotes(BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID);
		jobDetailsRepair(Xpathlocators.xpathLookup.get("repair"), Xpathlocators.xpathLookup.get("repairtap"));
		additionalInfowithoutVisibility(Xpathlocators.xpathLookup.get("accessibletrue"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("repintent"), Xpathlocators.xpathLookup.get("repownership"));
		budgetOther();
		location();

	}

	/*
	 * Job details path repair with multiple option checked in path two
	 */

	public void PostingJobViaPlumbingJobFormRepairMultiplepathtwo() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsRepair(Xpathlocators.xpathLookup.get("repair"), Xpathlocators.xpathLookup.get("repairtap"), Xpathlocators.xpathLookup.get("repbath"),
				Xpathlocators.xpathLookup.get("repwtank"), Xpathlocators.xpathLookup.get("reptoilet"), Xpathlocators.xpathLookup.get("repshower"),
				Xpathlocators.xpathLookup.get("repboiler"), Xpathlocators.xpathLookup.get("repwashbasin"), Xpathlocators.xpathLookup.get("repsink"));
		additionalInfowithoutVisibility(Xpathlocators.xpathLookup.get("accessibletrue"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("repintent"), Xpathlocators.xpathLookup.get("repownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormRepairMultiplepathtwoBathroomroute() throws Exception {
		getQuotes(BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID);
		jobDetailsRepair(Xpathlocators.xpathLookup.get("repair"), Xpathlocators.xpathLookup.get("repairtap"), Xpathlocators.xpathLookup.get("repbath"),
				Xpathlocators.xpathLookup.get("repwtank"), Xpathlocators.xpathLookup.get("reptoilet"), Xpathlocators.xpathLookup.get("repshower"),
				Xpathlocators.xpathLookup.get("repboiler"), Xpathlocators.xpathLookup.get("repwashbasin"), Xpathlocators.xpathLookup.get("repsink"));
		additionalInfowithoutVisibility(Xpathlocators.xpathLookup.get("accessibletrue"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("repintent"), Xpathlocators.xpathLookup.get("repownership"));
		budget(9);
		location();

	}

	/*
	 * Job details path repair with multiple option checked in path two
	 */

	public void PostingJobViaPlumbingJobFormRepairOther() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsRepair(Xpathlocators.xpathLookup.get("repair"), Xpathlocators.xpathLookup.get("repairtap"), Xpathlocators.xpathLookup.get("repbath"),
				Xpathlocators.xpathLookup.get("repwtank"), Xpathlocators.xpathLookup.get("reptoilet"), Xpathlocators.xpathLookup.get("repshower"),
				Xpathlocators.xpathLookup.get("repboiler"), Xpathlocators.xpathLookup.get("repwashbasin"), Xpathlocators.xpathLookup.get("repsink"),
				Xpathlocators.xpathLookup.get("repother"), Xpathlocators.xpathLookup.get("repothertxt"));
		additionalInfowithoutVisibility(Xpathlocators.xpathLookup.get("accessibletrue"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("repintent"), Xpathlocators.xpathLookup.get("repownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormRepairOtherBathroomroute() throws Exception {
		getQuotes(BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID);
		jobDetailsRepair(Xpathlocators.xpathLookup.get("repair"), Xpathlocators.xpathLookup.get("repairtap"), Xpathlocators.xpathLookup.get("repbath"),
				Xpathlocators.xpathLookup.get("repwtank"), Xpathlocators.xpathLookup.get("reptoilet"), Xpathlocators.xpathLookup.get("repshower"),
				Xpathlocators.xpathLookup.get("repboiler"), Xpathlocators.xpathLookup.get("repwashbasin"), Xpathlocators.xpathLookup.get("repsink"),
				Xpathlocators.xpathLookup.get("repother"), Xpathlocators.xpathLookup.get("repothertxt"));
		additionalInfowithoutVisibility(Xpathlocators.xpathLookup.get("accessibletrue"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("repintent"), Xpathlocators.xpathLookup.get("repownership"));
		budget(9);
		location();

	}

	/*
	 * Job Details path install with single option checked in path two
	 */

	public void PostingJobViaPlumbingJobFormInstall() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsInstall(Xpathlocators.xpathLookup.get("install"), Xpathlocators.xpathLookup.get("instap"));
		additionalInfoInstall(Xpathlocators.xpathLookup.get("insplacenotsure"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("insintent"), Xpathlocators.xpathLookup.get("insownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormInstallBathroomroute() throws Exception {
		getQuotes(BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID);
		jobDetailsInstall(Xpathlocators.xpathLookup.get("install"), Xpathlocators.xpathLookup.get("instap"));
		additionalInfoInstall(Xpathlocators.xpathLookup.get("insplacenotsure"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("repintent"), Xpathlocators.xpathLookup.get("repownership"));
		budget(9);
		location();

	}

	/*
	 * Job Details path install with multiple option checked in path two
	 */

	public void PostingJobViaPlumbingJobFormInstallMultiplepathtwo() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsInstall(Xpathlocators.xpathLookup.get("install"), Xpathlocators.xpathLookup.get("instap"), Xpathlocators.xpathLookup.get("instoilet"),
				Xpathlocators.xpathLookup.get("inswtank"), Xpathlocators.xpathLookup.get("inswbasin"), Xpathlocators.xpathLookup.get("inssink"),
				Xpathlocators.xpathLookup.get("insradiator"), Xpathlocators.xpathLookup.get("insbath"), Xpathlocators.xpathLookup.get("insshower"));
		additionalInfoInstall(Xpathlocators.xpathLookup.get("insplaceno"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("insintent"), Xpathlocators.xpathLookup.get("insownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormInstallMultiplepathtwoBathroomroute() throws Exception {
		getQuotes(BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID);
		jobDetailsInstall(Xpathlocators.xpathLookup.get("install"), Xpathlocators.xpathLookup.get("instap"), Xpathlocators.xpathLookup.get("instoilet"),
				Xpathlocators.xpathLookup.get("inswtank"), Xpathlocators.xpathLookup.get("inswbasin"), Xpathlocators.xpathLookup.get("inssink"),
				Xpathlocators.xpathLookup.get("insradiator"), Xpathlocators.xpathLookup.get("insbath"), Xpathlocators.xpathLookup.get("insshower"));
		additionalInfoInstall(Xpathlocators.xpathLookup.get("insplaceno"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("insintent"), Xpathlocators.xpathLookup.get("insownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormInstallOther() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsInstall(Xpathlocators.xpathLookup.get("install"), Xpathlocators.xpathLookup.get("instap"), Xpathlocators.xpathLookup.get("instoilet"),
				Xpathlocators.xpathLookup.get("inswtank"), Xpathlocators.xpathLookup.get("inswbasin"), Xpathlocators.xpathLookup.get("inssink"),
				Xpathlocators.xpathLookup.get("insradiator"), Xpathlocators.xpathLookup.get("insbath"), Xpathlocators.xpathLookup.get("insshower"),
				Xpathlocators.xpathLookup.get("insother"), Xpathlocators.xpathLookup.get("insothertxt"));
		additionalInfowithoutVisibility(Xpathlocators.xpathLookup.get("insplaceyes"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("insintent"), Xpathlocators.xpathLookup.get("insownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormReplace() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsReplace(Xpathlocators.xpathLookup.get("replace"), Xpathlocators.xpathLookup.get("repltap"));
		additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("replintent"),
				Xpathlocators.xpathLookup.get("replownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormInstallOtherBathroomroute() throws Exception {
		getQuotes(BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID);
		jobDetailsInstall(Xpathlocators.xpathLookup.get("install"), Xpathlocators.xpathLookup.get("instap"), Xpathlocators.xpathLookup.get("instoilet"),
				Xpathlocators.xpathLookup.get("inswtank"), Xpathlocators.xpathLookup.get("inswbasin"), Xpathlocators.xpathLookup.get("inssink"),
				Xpathlocators.xpathLookup.get("insradiator"), Xpathlocators.xpathLookup.get("insbath"), Xpathlocators.xpathLookup.get("insshower"),
				Xpathlocators.xpathLookup.get("insother"), Xpathlocators.xpathLookup.get("insothertxt"));
		additionalInfowithoutVisibility(Xpathlocators.xpathLookup.get("insplaceyes"), 6, Xpathlocators.dataLookup.get("postcode"),
				Xpathlocators.xpathLookup.get("insintent"), Xpathlocators.xpathLookup.get("insownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormReplaceBathroomroute() throws Exception {
		getQuotes(BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID);
		jobDetailsReplace(Xpathlocators.xpathLookup.get("replace"), Xpathlocators.xpathLookup.get("repltap"));
		additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("replintent"),
				Xpathlocators.xpathLookup.get("replownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormReplaceMultiplepathtwo() throws Exception {
		jobDetailsReplace(Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("replace"), Xpathlocators.xpathLookup.get("repltap"),
				Xpathlocators.xpathLookup.get("repltoilet"), Xpathlocators.xpathLookup.get("replwtank"), Xpathlocators.xpathLookup.get("replwbasin"),
				Xpathlocators.xpathLookup.get("replsink"), Xpathlocators.xpathLookup.get("replradiator"), Xpathlocators.xpathLookup.get("replshower"),
				Xpathlocators.xpathLookup.get("replappliance"));
		additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("replintent"),
				Xpathlocators.xpathLookup.get("replownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormReplaceOther() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsReplace(Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("replace"), Xpathlocators.xpathLookup.get("repltap"),
				Xpathlocators.xpathLookup.get("repltoilet"), Xpathlocators.xpathLookup.get("replwtank"), Xpathlocators.xpathLookup.get("replwbasin"),
				Xpathlocators.xpathLookup.get("replsink"), Xpathlocators.xpathLookup.get("replradiator"), Xpathlocators.xpathLookup.get("replshower"),
				Xpathlocators.xpathLookup.get("replappliance"), Xpathlocators.xpathLookup.get("replother"), Xpathlocators.xpathLookup.get("replothertxt"));
		additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("replintent"),
				Xpathlocators.xpathLookup.get("replownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormBlockageMultiplepathtwo() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsBlockedMultiplepathtwo(Xpathlocators.xpathLookup.get("blockage"), Xpathlocators.xpathLookup.get("btoilet"),
				Xpathlocators.xpathLookup.get("bbasin"), Xpathlocators.xpathLookup.get("bshower"), Xpathlocators.xpathLookup.get("bsink"),
				Xpathlocators.xpathLookup.get("bbath"), Xpathlocators.xpathLookup.get("bappliance"));
		additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("bintent"),
				Xpathlocators.xpathLookup.get("bownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormBlockage() throws Exception {
		jobDetailsBlocked(Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("blockage"), Xpathlocators.xpathLookup.get("btoilet"));
		additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("bintent"),
				Xpathlocators.xpathLookup.get("bownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormTrackingAffiliate() throws Exception {
		jobDetailsBlockedaffiliate(Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("blockage"),
				Xpathlocators.xpathLookup.get("btoilet"));
		additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("bintent"),
				Xpathlocators.xpathLookup.get("bownership"));
		budget(9);
		location();
	}

	/*
	 * public void PostingJobViaPlumbingJobFormValidatepathTwo() throws Exception{
	 * jobDetails(Xpathlocators.dataLookup.get("postcode"),Xpathlocators.xpathLookup.get("blockage"), Xpathlocators.xpathLookup.get("btoilet"));
	 * additionalInfoReplace(6); budget(9); location(); }
	 */

	public void PostingJobViaPlumbingJobFormBlockageOther() throws Exception {
		jobDetailsBlockedOther(Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("blockage"), Xpathlocators.xpathLookup.get("btoilet"),
				Xpathlocators.xpathLookup.get("bother"), Xpathlocators.xpathLookup.get("bothertxt"));
		additionalInfoReplace(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("bintent"),
				Xpathlocators.xpathLookup.get("bownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormSomethingElse() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsSomethingelse(Xpathlocators.xpathLookup.get("somethingelse"));
		additionalInfoSomethingElse(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("somethingelsintent"),
				Xpathlocators.xpathLookup.get("somethingelsownership"));
		budget(9);
		location();

	}

	public void PostingJobViaPlumbingJobFormSomethingElseEditJob() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsSomethingelse(Xpathlocators.xpathLookup.get("somethingelse"));
		additionalInfoSomethingElse(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("somethingelsintent"),
				Xpathlocators.xpathLookup.get("somethingelsownership"));
		budget(9);
		
		String email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
		String confirmEmail = email;
		String firstName = Xpathlocators.dataLookup.get("fname");
		String lastName = Xpathlocators.dataLookup.get("lname");
		String phoneNumber = Xpathlocators.dataLookup.get("mobile");
		String confirmPhoneNumber = Xpathlocators.dataLookup.get("confirmphonenumber");		
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(testScriptUtilities, context, firstName, lastName, phoneNumber, confirmPhoneNumber, email, confirmEmail);
		

	}

	public void PostingJobViaPlumbingJobFormSomethingElseCancelAndReturn() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		jobDetailsSomethingelse(Xpathlocators.xpathLookup.get("somethingelse"));
		additionalInfoSomethingElse(6, Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("somethingelsintent"),
				Xpathlocators.xpathLookup.get("somethingelsownership"));
		budget(9);
		String email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
		String confirmEmail = email;
		String firstName = Xpathlocators.dataLookup.get("fname");
		String lastName = Xpathlocators.dataLookup.get("lname");
		String phoneNumber = Xpathlocators.dataLookup.get("mobile");
		String confirmPhoneNumber = Xpathlocators.dataLookup.get("confirmphonenumber");
		
		JobFormSeleniumHelper.fillInContactPageDetailsAndCancelAndReturn(testScriptUtilities, context, firstName, lastName, phoneNumber, confirmPhoneNumber, email, confirmEmail);
	}

	public void PostingJobViaPlumbingJobFormGAtracking() throws Exception {
		jobdetailsGAtracking();
		additionalInfoGAtracking();
		budgetGAtracking();
		locationGAtracking();
		confirmationGAtracking();
	}

	/*
	 * JOb details page with one option each in pathone & pathtwo
	 */

	public void jobDetailsleak(String pathone, String pathtwo) throws Exception {
		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(pathtwo));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_LEAK)));

	}

	/*
	 * jobdetails flow leak path two with all nine options selected
	 */

	public void jobDetailsleak(String pathone, String pathtwo, String pathtwooftwo, String pathtwoofthree, String pathtwooffour, String pathtwooffive,
			String pathtwoofsix, String pathtwoofseven, String pathtwoofeight) throws Exception {

		// goTo(testUrl +"/post-your-job/plumbing/job-details?jobTypeId=58&postcode=rp99rp");
		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(pathtwo));
		testScriptUtilities.click(By.xpath(pathtwooftwo));
		testScriptUtilities.click(By.xpath(pathtwoofthree));
		testScriptUtilities.click(By.xpath(pathtwooffour));
		testScriptUtilities.click(By.xpath(pathtwooffive));
		testScriptUtilities.click(By.xpath(pathtwoofsix));
		testScriptUtilities.click(By.xpath(pathtwoofseven));
		testScriptUtilities.click(By.xpath(pathtwoofeight));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_LEAK)));

	}

	/*
	 * Job details page other option checked
	 */
	public void jobDetailsleak(String pathone, String pathtwo, String pathtwooftwo, String othertxt) throws Exception {

		// goTo(testUrl +"/post-your-job/plumbing/job-details?jobTypeId=58&postcode=rp99rp");
		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(pathtwo));
		testScriptUtilities.click(By.xpath(pathtwooftwo));
		testScriptUtilities.fillInXpathField(othertxt, "Selenium" + TestScriptUtilities.getRandomString(3));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_LEAK)));

	}

	/*
	 * Job details path repair with one option checked in path two
	 */
	public void jobDetailsRepair(String pathone, String pathtwo) throws Exception {

		// goTo(testUrl +"/post-your-job/plumbing/job-details?jobTypeId=58&postcode=rp99rp");
		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(pathtwo));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_REPAIR)));

	}

	public void jobDetailsRepair(String pathone, String pathtwo, String pathtwooftwo, String pathtwoofthree, String pathtwooffour, String pathtwooffive,
			String pathtwoofsix, String pathtwoofseven, String pathtwoofeight) throws Exception {

		// goTo(testUrl +"/post-your-job/plumbing/job-details?jobTypeId=58&postcode=rp99rp");
		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(pathtwo));
		testScriptUtilities.click(By.xpath(pathtwooftwo));
		testScriptUtilities.click(By.xpath(pathtwoofthree));
		testScriptUtilities.click(By.xpath(pathtwooffour));
		testScriptUtilities.click(By.xpath(pathtwooffive));
		testScriptUtilities.click(By.xpath(pathtwoofsix));
		testScriptUtilities.click(By.xpath(pathtwoofseven));
		testScriptUtilities.click(By.xpath(pathtwoofeight));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_REPAIR)));

	}

	public void jobDetailsRepair(String pathone, String pathtwo, String pathtwooftwo, String pathtwoofthree, String pathtwooffour, String pathtwooffive,
			String pathtwoofsix, String pathtwoofseven, String pathtwoofeight, String other, String othertxt) throws Exception {

		// goTo(testUrl +"/post-your-job/plumbing/job-details?jobTypeId=58&postcode=rp99rp");
		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(pathtwo));
		testScriptUtilities.click(By.xpath(pathtwooftwo));
		testScriptUtilities.click(By.xpath(pathtwoofthree));
		testScriptUtilities.click(By.xpath(pathtwooffour));
		testScriptUtilities.click(By.xpath(pathtwooffive));
		testScriptUtilities.click(By.xpath(pathtwoofsix));
		testScriptUtilities.click(By.xpath(pathtwoofseven));
		testScriptUtilities.click(By.xpath(pathtwoofeight));
		testScriptUtilities.click(By.xpath(other));
		testScriptUtilities.fillInXpathField(othertxt, "Selenium" + TestScriptUtilities.getRandomString(3));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_REPAIR)));

	}

	public void jobDetailsInstall(String pathone, String pathtwo, String pathtwooftwo, String pathtwoofthree, String pathtwooffour, String pathtwooffive,
			String pathtwoofsix, String pathtwoofseven, String pathtwoofeight) throws Exception {

		// goTo(testUrl +"/post-your-job/plumbing/job-details?jobTypeId=58&postcode=rp99rp");
		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(pathtwo));
		testScriptUtilities.click(By.xpath(pathtwooftwo));
		testScriptUtilities.click(By.xpath(pathtwoofthree));
		testScriptUtilities.click(By.xpath(pathtwooffour));
		testScriptUtilities.click(By.xpath(pathtwooffive));
		testScriptUtilities.click(By.xpath(pathtwoofsix));
		testScriptUtilities.click(By.xpath(pathtwoofseven));
		testScriptUtilities.click(By.xpath(pathtwoofeight));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_INSTALL)));

	}

	public void jobDetailsInstall(String pathone, String pathtwo) throws Exception {

		// goTo(testUrl +"/post-your-job/plumbing/job-details?jobTypeId=58&postcode=rp99rp");
		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(pathtwo));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_INSTALL)));

	}

	public void jobDetailsInstall(String pathone, String pathtwo, String pathtwooftwo, String pathtwoofthree, String pathtwooffour, String pathtwooffive,
			String pathtwoofsix, String pathtwoofseven, String pathtwoofeight, String other, String othertxt) throws Exception {

		// goTo(testUrl +"/post-your-job/plumbing/job-details?jobTypeId=58&postcode=rp99rp");
		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(pathtwo));
		testScriptUtilities.click(By.xpath(pathtwooftwo));
		testScriptUtilities.click(By.xpath(pathtwoofthree));
		testScriptUtilities.click(By.xpath(pathtwooffour));
		testScriptUtilities.click(By.xpath(pathtwooffive));
		testScriptUtilities.click(By.xpath(pathtwoofsix));
		testScriptUtilities.click(By.xpath(pathtwoofseven));
		testScriptUtilities.click(By.xpath(pathtwoofeight));
		testScriptUtilities.click(By.xpath(other));
		testScriptUtilities.fillInXpathField(othertxt, "Selenium" + TestScriptUtilities.getRandomString(3));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_INSTALL)));

	}

	public void jobDetailsReplace(String postcode, String pathone, String pathtwo, String pathtwooftwo, String pathtwoofthree, String pathtwooffour,
			String pathtwooffive, String pathtwoofsix, String pathtwoofseven, String pathtwoofeight, String other, String othertxt) throws Exception {

		// goTo(testUrl +"/post-your-job/plumbing/job-details?jobTypeId=58&postcode=rp99rp");
		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(pathtwo));
		testScriptUtilities.click(By.xpath(pathtwooftwo));
		testScriptUtilities.click(By.xpath(pathtwoofthree));
		testScriptUtilities.click(By.xpath(pathtwooffour));
		testScriptUtilities.click(By.xpath(pathtwooffive));
		testScriptUtilities.click(By.xpath(pathtwoofsix));
		testScriptUtilities.click(By.xpath(pathtwoofseven));
		testScriptUtilities.click(By.xpath(pathtwoofeight));
		testScriptUtilities.click(By.xpath(other));
		testScriptUtilities.fillInXpathField(othertxt, "Selenium" + TestScriptUtilities.getRandomString(3));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_REPLACE)));
	}

	public void jobDetailsReplace(String pathone, String pathtwo) throws Exception {

		// goTo(testUrl +"/post-your-job/plumbing/job-details?jobTypeId=58&postcode=rp99rp");
		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(pathtwo));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_REPLACE)));
	}

	public void jobDetailsReplace(String postcode, String pathone, String pathtwo, String pathtwooftwo, String pathtwoofthree, String pathtwooffour,
			String pathtwooffive, String pathtwoofsix, String pathtwoofseven, String pathtwoofeight) throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		// goTo(testUrl +"/post-your-job/plumbing/job-details?jobTypeId=58&postcode=rp99rp");
		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(pathtwo));
		testScriptUtilities.click(By.xpath(pathtwooftwo));
		testScriptUtilities.click(By.xpath(pathtwoofthree));
		testScriptUtilities.click(By.xpath(pathtwooffour));
		testScriptUtilities.click(By.xpath(pathtwooffive));
		testScriptUtilities.click(By.xpath(pathtwoofsix));
		testScriptUtilities.click(By.xpath(pathtwoofseven));
		testScriptUtilities.click(By.xpath(pathtwoofeight));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_REPLACE)));
	}

	public void jobDetailsBlocked(String postcode, String pathone, String pathtwo) throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		// goTo(testUrl +"/post-your-job/plumbing/job-details?jobTypeId=58&postcode=rp99rp");
		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(pathtwo));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_BLOCKED)));
	}

	public void jobDetailsBlockedaffiliate(String postcode, String pathone, String pathtwo) throws Exception {
		getQuotesAffiliate(postcode);

		// goTo(testUrl +"/post-your-job/plumbing/job-details?jobTypeId=58&postcode=rp99rp");
		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(pathtwo));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_BLOCKED)));
	}

	public void jobDetailsBlockedOther(String postcode, String pathone, String pathtwo, String other, String othertxt) throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		// goTo(testUrl +"/post-your-job/plumbing/job-details?jobTypeId=58&postcode=rp99rp");
		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(pathtwo));
		testScriptUtilities.click(By.xpath(other));
		testScriptUtilities.fillInXpathField(othertxt, "Selenium" + TestScriptUtilities.getRandomString(3));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_BLOCKED)));
	}

	public void jobDetailsBlockedMultiplepathtwo(String pathone, String pathtwo, String pathtwooftwo, String pathtwoofthree, String pathtwooffour,
			String pathtwooffive, String pathtwoofsix) throws Exception {

		// goTo(testUrl +"/post-your-job/plumbing/job-details?jobTypeId=58&postcode=rp99rp");
		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("continue")));
		WebDriverWait waitfornext = new WebDriverWait(driver, 10);
		waitfornext.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("continue"))));
		testScriptUtilities.click(By.xpath(pathtwo));
		testScriptUtilities.click(By.xpath(pathtwooftwo));
		testScriptUtilities.click(By.xpath(pathtwoofthree));
		testScriptUtilities.click(By.xpath(pathtwooffour));
		testScriptUtilities.click(By.xpath(pathtwooffive));
		testScriptUtilities.click(By.xpath(pathtwoofsix));

		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT_DESC_BLOCKED)));
	}

	private void getQuotes(String skillTypeId) throws InterruptedException {
		testScriptUtilities.getQuotes(testUrl + "/get-quotes/", driver, skillTypeId, PLUMBER_TRADE_CODE);
	}

	public void getQuotesPlumbingRepairMaintenance() throws InterruptedException {
		this.getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
	}

	public void getQuotesBathroomKitchen() throws InterruptedException {
		this.getQuotes(BATHROOM_KITCHEN_WC_PLUMBING_SKILL_TYPE_ID);
	}

	public void getQuotesAffiliate(String postcode) throws InterruptedException {
		int campaignId = 0;
		int affiliateId = 0;
		int tokyoCampaignId = 411;
		int tokyoAffiliateId = 428569;
		int preprodCampaignId = 425;
		int preprodAffiliateId = 428570;
		if (testUrl.contains("tokyo")) {
			campaignId = tokyoCampaignId;
			affiliateId = tokyoAffiliateId;
		} else {
			// valid campaign id for preprod
			campaignId = preprodCampaignId;
			affiliateId = preprodAffiliateId;
		}
		String fullUrl = testUrl + "/afct?affiliateId=" + affiliateId + "&campaignId=" + campaignId
				+ "&utm_source=rightmove&utm_medium=banners&utm_campaign=addvaluempu&page=get-quotes/plumbers";
		testScriptUtilities.goTo(fullUrl);
		logger.info("TestURl  : " + fullUrl);
		getGoogleTrackingID();
		Select select = new Select(driver.findElement(By.id(JOBTYPE)));
		select.selectByValue(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		testScriptUtilities.click(Xpathlocators.xpathLookup.get("nextquotes"));
	}

	public void getQuotesGAtracking(String postcode) throws Exception {
		testScriptUtilities.goTo(testUrl + "/get-quotes/");
		if (getGoogleTrackingID() == true) {
			Assert.assertTrue(getGoogleTrackingID() == true);

		} else {
			logger.info("Google Tracking code UA-845338-13 not Found ");
		}
		Select select = new Select(driver.findElement(By.id(JOBTYPE)));
		select.selectByValue(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		// testScriptUtilities.fillInTextField("postcode",postcode);
		testScriptUtilities.click(Xpathlocators.xpathLookup.get("nextquotes"));
	}

	public void jobdetailsGAtracking() throws Exception {
		getQuotes(PLUMBING_REPAIR_MAINTENANCE_SKILL_TYPE_ID);
		if (getGoogleTrackingID() == true) {
			Assert.assertTrue(getGoogleTrackingID() == true);
		} else {
			logger.info("Google Tracking code UA-845538-13 not Found ");
			Assert.fail();
		}

		jobDetailsleak(Xpathlocators.xpathLookup.get("leak"), Xpathlocators.xpathLookup.get("lwashbin"));
	}

	public void additionalInfoGAtracking() throws Exception {
		if (getGoogleTrackingID() == true) {
			Assert.assertTrue(getGoogleTrackingID() == true);

		} else {
			logger.info("Google Tracking code UA-845338-13 not Found ");
			Assert.fail();
		}

		additionalInfo(Xpathlocators.xpathLookup.get("visibletrue"), Xpathlocators.xpathLookup.get("accessibletrue"), 6,
				Xpathlocators.dataLookup.get("postcode"), Xpathlocators.xpathLookup.get("lintent"), Xpathlocators.xpathLookup.get("lownership"));
	}

	public void budgetGAtracking() throws Exception {
		if (getGoogleTrackingID() == true) {
			Assert.assertTrue(getGoogleTrackingID() == true);

		} else {
			logger.info("Google Tracking code UA-845338-13 not Found ");
			Assert.fail();
		}
		budget(9);

	}

	public void locationGAtracking() throws Exception {
		if (getGoogleTrackingID() == true) {
			Assert.assertTrue(getGoogleTrackingID() == true);

		} else {
			logger.info("Google Tracking code UA-845338-13 not Found ");
			Assert.fail();
		}
		String email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
		String confirmEmail = email;
		String firstName = Xpathlocators.dataLookup.get("fname") + TestScriptUtilities.getRandomAlphabeticString(3);
		String lastName = Xpathlocators.dataLookup.get("lname") + TestScriptUtilities.getRandomAlphabeticString(3);
		String phoneNumber = Xpathlocators.dataLookup.get("mobile");
		String confirmPhoneNumber = Xpathlocators.dataLookup.get("confirmphonenumber");
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(testScriptUtilities, context, firstName, lastName, phoneNumber, confirmPhoneNumber, email,
				confirmEmail);
	}

	public void confirmationGAtracking() {
		if (getGoogleTrackingID() == true) {
			Assert.assertTrue(getGoogleTrackingID() == true);

		} else {
			logger.info("Google Tracking code UA-845338-13 not Found ");
			Assert.fail();
		}

		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);
	}

	public void budgetOther() {
		testScriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("budget")), 10);
		String convrtrandNumber = Integer.toString(TestScriptUtilities.getRandomNumberGreaterThanfifty(100000));
		logger.info("Here is the converted integer  : " + convrtrandNumber);
		testScriptUtilities.fillInXpathField(Xpathlocators.xpathLookup.get("otherbudget"), convrtrandNumber);
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("nextstage3")));
	}

	public boolean getGoogleTrackingID() {
		boolean getgoogleanalyticsId = driver.getPageSource().contains("UA-845538-13");
		logger.info("Status googleId : " + getgoogleanalyticsId);
		// boolean getgaId = driver.getPageSource().contentEquals("UA-845538-13");
		// logger.info("Status googleId2 : "+getgaId);
		return getgoogleanalyticsId;

	}

	public boolean getgoogleConversionID() {
		boolean getConversionID = driver.getPageSource().contains("1024272544");
		logger.info("Conversion Id  : " + getConversionID);
		return getConversionID;

	}

	public void additionalInfo(String visibility, String accessibility, int timing, String postcode, String xpathintent, String xpathOwnership)
			throws Exception {
		// Wait for page to navigate to Additional Details
		WebDriverWait waitforAddInfo = new WebDriverWait(driver, 10);
		waitforAddInfo.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("additionalInfo"))));
		testScriptUtilities.fillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "selenium" + TestScriptUtilities.getRandomString(3));
		// intent & ownership added
		List<WebElement> getoptionsIntent = driver.findElements(By.xpath(xpathintent));
		int getcountofli = getoptionsIntent.size();
		int getRandomintent = TestScriptUtilities.getRandomNumber(getcountofli);
		logger.info("Random of Intent links are : " + getRandomintent);
		if (getRandomintent == 1) {
			getRandomintent += 1;
		}
		logger.info("Count of links are : " + getcountofli);
		// for (int i = 1; i < getcountofli; i++) {
		String formxpath = xpathintent + "[" + getRandomintent + "]/input";
		logger.info("Xpath formed is  : " + formxpath);
		testScriptUtilities.click(By.xpath(formxpath));
		// }
		List<WebElement> getoptionsOwner = driver.findElements(By.xpath(xpathOwnership));
		int getcountofliOwner = getoptionsOwner.size();
		logger.info("Count of links are : " + getcountofliOwner);
		int getRandomofliOwner = TestScriptUtilities.getRandomNumber(getcountofliOwner);
		logger.info("Random of Ownership links are : " + getRandomofliOwner);
		// for (int j = 1; j <= getcountofli; j++) {
		String formxpathOwner = xpathOwnership + "[" + getRandomofliOwner + "]/input";
		logger.info("Xpath formed is  : " + formxpathOwner);
		testScriptUtilities.click(By.xpath(formxpathOwner));
		// }
		testScriptUtilities.click(By.xpath(visibility));
		testScriptUtilities.click(By.xpath(accessibility));
		testScriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(timing));
		testScriptUtilities.fillInTextField("postcode", postcode);
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
	}

	public void additionalInfowithoutVisibility(String accessibility, int timing, String postcode, String xpathintent, String xpathOwnership) throws Exception {
		// Wait for page to navigate to Additional Details
		WebDriverWait waitforAddInfo = new WebDriverWait(driver, 10);
		waitforAddInfo.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("additionalInfo"))));
		testScriptUtilities.fillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "selenium" + TestScriptUtilities.getRandomString(3));
		testScriptUtilities.click(By.xpath(accessibility));
		// intent & ownership added
		List<WebElement> getoptionsIntent = driver.findElements(By.xpath(xpathintent));
		int getcountofli = getoptionsIntent.size();
		int getRandomintent = TestScriptUtilities.getRandomNumber(getcountofli);
		logger.info("Random of Intent links are : " + getRandomintent);
		if (getRandomintent == 1) {
			getRandomintent += 1;
		}
		logger.info("Count of links are : " + getcountofli);
		// for (int i = 1; i < getcountofli; i++) {
		String formxpath = xpathintent + "[" + getRandomintent + "]/input";
		logger.info("Xpath formed is  : " + formxpath);
		testScriptUtilities.click(By.xpath(formxpath));
		// }
		List<WebElement> getoptionsOwner = driver.findElements(By.xpath(xpathOwnership));
		int getcountofliOwner = getoptionsOwner.size();
		logger.info("Count of links are : " + getcountofliOwner);
		int getRandomofliOwner = TestScriptUtilities.getRandomNumber(getcountofliOwner);
		logger.info("Random of Ownership links are : " + getRandomofliOwner);
		// for (int j = 1; j <= getcountofli; j++) {
		String formxpathOwner = xpathOwnership + "[" + getRandomofliOwner + "]/input";
		logger.info("Xpath formed is  : " + formxpathOwner);
		testScriptUtilities.click(By.xpath(formxpathOwner));
		// }
		testScriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(timing));
		testScriptUtilities.fillInTextField("postcode", postcode);
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));

	}

	public void additionalInfoInstall(String accessibility, int timing, String postcode, String xpathintent, String xpathOwnership) throws Exception {
		// Wait for page to navigate to Additional Details
		WebDriverWait waitforAddInfo = new WebDriverWait(driver, 10);
		waitforAddInfo.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("additionalInfo"))));
		testScriptUtilities.fillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "selenium" + TestScriptUtilities.getRandomString(3));
		testScriptUtilities.click(By.xpath(accessibility));
		// intent & ownership added
		List<WebElement> getoptionsIntent = driver.findElements(By.xpath(xpathintent));
		int getcountofli = getoptionsIntent.size();
		int getRandomintent = TestScriptUtilities.getRandomNumber(getcountofli);
		logger.info("Random of Intent links are : " + getRandomintent);
		if (getRandomintent == 1) {
			getRandomintent += 1;
		}
		logger.info("Count of links are : " + getcountofli);

		String formxpath = xpathintent + "[" + getRandomintent + "]/input";
		logger.info("Xpath formed is  : " + formxpath);
		testScriptUtilities.click(By.xpath(formxpath));

		List<WebElement> getoptionsOwner = driver.findElements(By.xpath(xpathOwnership));
		int getcountofliOwner = getoptionsOwner.size();
		logger.info("Count of links are : " + getcountofliOwner);
		int getRandomofliOwner = TestScriptUtilities.getRandomNumber(getcountofliOwner);
		logger.info("Random of Ownership links are : " + getRandomofliOwner);

		String formxpathOwner = xpathOwnership + "[" + getRandomofliOwner + "]/input";
		logger.info("Xpath formed is  : " + formxpathOwner);
		testScriptUtilities.click(By.xpath(formxpathOwner));

		testScriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(timing));
		testScriptUtilities.fillInTextField("postcode", postcode);
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));

	}

	/*
	 * additional info for replace flow
	 */

	public void additionalInfoReplace(int timing, String postcode, String xpathintent, String xpathOwnership) throws Exception {
		// Wait for page to navigate to Additional Details
		WebDriverWait waitforAddInfo = new WebDriverWait(driver, 10);
		waitforAddInfo.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("additionalInfo"))));
		testScriptUtilities.fillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "selenium" + TestScriptUtilities.getRandomString(25));
		testScriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(timing));
		testScriptUtilities.fillInTextField("postcode", postcode);
		// intent & ownership added
		List<WebElement> getoptionsIntent = driver.findElements(By.xpath(xpathintent));
		int getcountofli = getoptionsIntent.size();
		int getRandomintent = TestScriptUtilities.getRandomNumber(getcountofli);
		logger.info("Random of Intent links are : " + getRandomintent);
		if (getRandomintent == 1) {
			getRandomintent += 1;
		}
		logger.info("Count of links are : " + getcountofli);
		// for (int i = 1; i < getcountofli; i++) {
		String formxpath = xpathintent + "[" + getRandomintent + "]/input";
		logger.info("Xpath formed is  : " + formxpath);
		testScriptUtilities.click(By.xpath(formxpath));
		// }
		List<WebElement> getoptionsOwner = driver.findElements(By.xpath(xpathOwnership));
		int getcountofliOwner = getoptionsOwner.size();
		logger.info("Count of links are : " + getcountofliOwner);
		int getRandomofliOwner = TestScriptUtilities.getRandomNumber(getcountofliOwner);
		logger.info("Random of Ownership links are : " + getRandomofliOwner);
		// for (int j = 1; j <= getcountofli; j++) {
		String formxpathOwner = xpathOwnership + "[" + getRandomofliOwner + "]/input";
		logger.info("Xpath formed is  : " + formxpathOwner);
		testScriptUtilities.click(By.xpath(formxpathOwner));
		// }
		testScriptUtilities.sleep(3000);
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
	}

	public void budget(int budget) throws Exception {
		testScriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("budget")), TestScriptUtilities.getRandomNumber(budget));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));
	}

	public void location() throws Exception {
		Thread.sleep(2000);
		String email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
		String confirmEmail = email;
		String firstName = Xpathlocators.dataLookup.get("fname");
		String lastName = Xpathlocators.dataLookup.get("lname");
		String phoneNumber = Xpathlocators.dataLookup.get("mobile");
		String confirmPhoneNumber = Xpathlocators.dataLookup.get("confirmphonenumber");

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(testScriptUtilities, context, firstName, lastName, phoneNumber, confirmPhoneNumber, email,
				confirmEmail);

		WebDriverWait wait = new WebDriverWait(context.driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(THANK_YOU_HEADER_TEXT_ID)));
		assertEquals(context.driver.findElement(By.id(THANK_YOU_HEADER_TEXT_ID)).getText(), THANK_YOU);

		
		assertEquals(driver.findElement(By.xpath(Xpathlocators.xpathLookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(), Xpathlocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
		assertEquals(driver.findElement(By.xpath(Xpathlocators.xpathLookup.get("WHATHAPPENSNEXTONE_XPATH"))).getText(), Xpathlocators.dataLookup.get("WHATHAPPENSNEXTONE_TEXT"));
		assertEquals(driver.findElement(By.xpath(Xpathlocators.xpathLookup.get("WHATHAPPENSNEXTTWO_XPATH"))).getText(), Xpathlocators.dataLookup.get("WHATHAPPENSNEXTTWO_TEXT"));
		assertEquals(driver.findElement(By.xpath(Xpathlocators.xpathLookup.get("WHATHAPPENSNEXTTHREE_XPATH"))).getText(), Xpathlocators.dataLookup.get("WHATHAPPENSNEXTTHREE_TEXT"));
		
		// this is to test E-rewards link
				context.driver.findElement(By.xpath(ErewardIMAGE_XPATH)).isDisplayed();
				context.driver.findElement(By.xpath(ErewardIMAGE_XPATH)).getAttribute("src").contains(SRC_CONTAINS);
				
					
				String Mainwindow = context.driver.getWindowHandle(); 
				context.driver.findElement(By.xpath(ErewardIMAGE_XPATH)).click();

				for (String Erewardwindow : context.driver.getWindowHandles()) {
					context.driver.switchTo().window(Erewardwindow); 
				}

				context.driver.close(); 
				context.driver.switchTo().window(Mainwindow);

		
		
	}

	public int getCountDiv() throws Exception {
		int countdiv = driver.findElements(By.xpath(".//*[@id='descLeak']/div[1]/div")).size();
		System.out.println("Count of div   :" + countdiv);
		if (countdiv <= 0) {
			logger.info("When count is zero : No Job Type Found  : " + countdiv);
		} else {
			logger.info("Job Type Found  : " + countdiv);
		}
		return countdiv;
	}

	public int getCountlink() throws Exception {
		getCountDiv();
		logger.info("Within the getCountLink() :" + getCountDiv());
		String xpathis = ".//*[@id='descLeak']/div[1]/div[" + getCountDiv() + "]/ul/li";
		logger.info("formed xpath is  :" + xpathis);
		int countlink = driver.findElements(By.xpath(xpathis)).size();
		logger.info("Count of links : " + countlink);
		return countlink;
	}

	public void jobDetailsSomethingelse(String pathone) throws Exception {

		testScriptUtilities.click(By.xpath(pathone));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpathlocators.xpathLookup.get("somethingelsecontinue"))));
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get("somethingelsecontinue")));
	}

	public void additionalInfoSomethingElse(int timing, String postcode, String xpathintent, String xpathOwnership) throws Exception {
		// Wait for page to navigate to Additional Details
		WebDriverWait waitforAddInfo = new WebDriverWait(driver, 10);
		waitforAddInfo.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("additionalInfo"))));
		// intent & ownership added
		List<WebElement> getoptionsIntent = driver.findElements(By.xpath(xpathintent));
		int getcountofli = getoptionsIntent.size();
		int getRandomintent = TestScriptUtilities.getRandomNumber(getcountofli);
		logger.info("Random of Intent links are : " + getRandomintent);
		if (getRandomintent == 1) {
			getRandomintent += 1;
		}
		logger.info("Count of links are : " + getcountofli);
		// for (int i = 1; i < getcountofli; i++) {
		String formxpath = xpathintent + "[" + getRandomintent + "]/input";
		logger.info("Xpath formed is  : " + formxpath);
		testScriptUtilities.click(By.xpath(formxpath));
		// }
		List<WebElement> getoptionsOwner = driver.findElements(By.xpath(xpathOwnership));
		int getcountofliOwner = getoptionsOwner.size();
		logger.info("Count of links are : " + getcountofliOwner);
		int getRandomofliOwner = TestScriptUtilities.getRandomNumber(getcountofliOwner);
		logger.info("Random of Ownership links are : " + getRandomofliOwner);
		// for (int j = 1; j <= getcountofli; j++) {
		String formxpathOwner = xpathOwnership + "[" + getRandomofliOwner + "]/input";
		logger.info("Xpath formed is  : " + formxpathOwner);
		testScriptUtilities.click(By.xpath(formxpathOwner));
		// }
		testScriptUtilities.fillInXpathField(Xpathlocators.xpathLookup.get("additionalInfo"), "selenium" + TestScriptUtilities.getRandomString(25));
		testScriptUtilities.selectDropdown(By.xpath(Xpathlocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(timing));
		testScriptUtilities.fillInTextField("postcode", postcode);
		testScriptUtilities.click(By.xpath(Xpathlocators.xpathLookup.get(NEXT)));

	}

	public void intentownership(String xpathintent, String xpathOwnership) {
		// intent & ownership added
		List<WebElement> getoptionsIntent = driver.findElements(By.xpath(xpathintent));
		int getcountofli = getoptionsIntent.size();
		int getRandomintent = TestScriptUtilities.getRandomNumber(getcountofli);
		logger.info("Random of Intent links are : " + getRandomintent);
		if (getRandomintent == 1) {
			getRandomintent += 1;
		}
		logger.info("Count of links are : " + getcountofli);
		String formxpath = xpathintent + "[" + getRandomintent + "]/input";
		logger.info("Xpath formed is  : " + formxpath);
		testScriptUtilities.click(By.xpath(formxpath));

		List<WebElement> getoptionsOwner = driver.findElements(By.xpath(xpathOwnership));
		int getcountofliOwner = getoptionsOwner.size();
		logger.info("Count of links are : " + getcountofliOwner);
		int getRandomofliOwner = TestScriptUtilities.getRandomNumber(getcountofliOwner);
		logger.info("Random of Ownership links are : " + getRandomofliOwner);

		String formxpathOwner = xpathOwnership + "[" + getRandomofliOwner + "]/input";
		logger.info("Xpath formed is  : " + formxpathOwner);
		testScriptUtilities.click(By.xpath(formxpathOwner));

	}
	
	public void RecommendedServices(){
		
		String getheaderText = context.driver.findElement(By.xpath(Xpathlocators.xpathLookup.get("RECOMMEND_SERVICES"))).getText();
		assertEquals(getheaderText, BuildXpathLocators.assertLookup.get("RECOMMEND_SERVICESTEXT"));
		WebDriverWait waitForPageToLoad = new WebDriverWait(context.driver, 10);
		waitForPageToLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpathlocators.xpathLookup.get("CLICKON_FACEBOOKICON"))));
		context.driver.findElement(By.xpath(Xpathlocators.xpathLookup.get("CLICKON_FACEBOOKICON"))).click();

		String opensfacebook = context.driver.getWindowHandle();

		for (String winHandle : context.driver.getWindowHandles()) {
			context.driver.switchTo().window(winHandle);
		}

		testScriptUtilities.sleep(3000);

		context.driver.close();

		context.driver.switchTo().window(opensfacebook);
		
	}
	
	
}
