package uk.co.ratedpeople.test.functional.selenium.ho.searchjobs;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.NoSuchElementException;

import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author danthalapalli.aravind
 * 
 */

public class SearchJobs {

	private static final String SEARCHJOB_FIELD = "_keyword";

	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.ho.searchjobs.SearchJobs");
	private String testUrl;
	private TestScriptUtilities scriptUtils;

	public SearchJobs(String testUrl, TestScriptUtilities scriptUtils) {
		this.testUrl = testUrl;
		this.scriptUtils = scriptUtils;
	}

	public void fillinSearchjobfield(String searchjobtext) throws Exception, NoSuchElementException {

		Thread.sleep(2000);

		if (StringUtils.isNotBlank(searchjobtext)) {
			scriptUtils.fillInTextField(SEARCHJOB_FIELD, searchjobtext);
		}
	}

	public void gotohomepage() throws Exception, NoSuchElementException {
		scriptUtils.goTo(testUrl);
	}
}
