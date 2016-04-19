package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.audit;

import java.util.ArrayList;
import java.util.List;

public class ActivityLog {
	/*
	 * # By Actor (TM, AGENT, SYSTEM, TESTER) - Timing changes are TESTER?
	 * 
	 * # ActivityType
	 * 
	 * # date/time stamp performed
	 * 
	 * # whether performed on server
	 * 
	 * # whether performed at all
	 * 
	 * # userInfo dict of misc data for this (?)
	 */
	private PerCodeActivityRecordMap activityPerTmUserIdCode;
	private List<ActivityRecord> masterLog;

	public ActivityLog() {
		this.masterLog = new ArrayList<ActivityRecord>();
		this.activityPerTmUserIdCode = new PerCodeActivityRecordMap();
	}

	public void add(final ActivityRecord activity) {
		final List<ActivityRecord> list = getPerTmActivityLog(activity);
		list.add(activity);
		this.masterLog.add(activity);
	}

	private List<ActivityRecord> getPerTmActivityLog(final ActivityRecord activity) {
		final List<ActivityRecord> list = this.activityPerTmUserIdCode.getListForCode(activity.getInvolvedTmIdCode());
		return list;
	}
}