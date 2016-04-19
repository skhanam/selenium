package uk.co.ratedpeople.test.functional.selenium.ho.searchjobs;

import java.util.Hashtable;
/**
 * @author danthalapalli.aravind
 *
 */

public class SearchJobsXpathLocators {
	
	@SuppressWarnings("serial")
	public static Hashtable<String, String>  datalocators = new Hashtable<String, String>(){{
		
			put("SEARCH_BUTTON","searchButton");
			put("HEADERTEXT_TEXT","The latest job leads across the UK");
			put("FIRSTLINKTEXT_TEXT","Needed: Gardener / Garden Designer in Westminster, SW1E");
			put("ALSOBEINTRESTED_TEXT","You might also be interested in...");
			put("arealnetworklinkText_TEXT","Needed: Aerial / Network Specialist in Kensington and Chelsea, SW5");
			put("bathroomlinkText_TEXT","Needed: Bathroom Specialist in Wembley, HA9");
			put("bricklayinglinkText_TEXT","Needed: Bricklayer in Westminster, SW1E");
			put("buildinglinkText_TEXT","Needed: Builder in Westminster, SW1E");
			put("carpentry&joinerylinkText_TEXT","Needed: Carpenter / Joiner in Westminster, SW1E");
			put("locksmithlinkText_TEXT","Needed: Locksmith in Hounslow, TW4");
			put("connectwithText_TEXT","Connect with new customers today");
			
			
	}	
	};
	
	@SuppressWarnings("serial")
	public static Hashtable<String, String>  xpathlocators = new Hashtable<String, String>(){{
		
		put("HEADERTEXT_XPATH",".//*[@id='searchJobs']/h1");
		
		put("KEYWORD_XPATH",".//*[@id='_keyword']");
		put("POSTCODE_XPATH",".//*[@id='postcode']");
		put("SEARCHBUTTON_XPATH",".//*[@id='search']");
		put("FIRSTLINKTEXT_XPATH",".//*[@id='job-card']/h1");
		put("FIRSTLINK_XPATH",".//*[@id='RPjoblistHolder']/div[1]/h3/a");
        put("ALSOBEINTRESTED_XPATH",".//*[@id='alsoInterestedHeader']");
        put("CLICKONLINKONE_XPATH",".//*[@id='jobsInterestedIn']/li[1]/a");
        put("CLICKONLINKTWO_XPATH",".//*[@id='jobsInterestedIn']/li[2]/a");
        put("CLICKONLINKTHREE_XPATH",".//*[@id='jobsInterestedIn']/li[3]/a");
        put("CLICKONLINKFOUR_XPATH",".//*[@id='jobsInterestedIn']/li[4]/a");
        put("CLICKONLINKFIVE_XPATH",".//*[@id='jobsInterestedIn']/li[5]/a");
        put("LISTOFTRADES_XPATH",".//*[@id='trade-dropdown']");
        put("registernow_xpath",".//*[@id='register-link-job-search']");
        put("connectwith_XPATH",".//*[@id='neutral-main-column']/section[1]/h1");
        put("FINDWORKNOWLINK_XPATH",".//*[@id='find-work']/a");
       
	}
	};
	
}
