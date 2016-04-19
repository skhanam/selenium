package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.audit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PerCodeActivityRecordMap {
	private Map<String, List<ActivityRecord>> activityByCode;

	PerCodeActivityRecordMap() {
		this.activityByCode = new HashMap<String, List<ActivityRecord>>();
	}

	List<ActivityRecord> getListForCode(final String code) {
		final List<ActivityRecord> list = this.activityByCode.get(code);
		if (list != null) {
			return list;
		}
		final List<ActivityRecord> newList = addNewListFor(code);
		return newList;
	}

	private List<ActivityRecord> addNewListFor(final String code) {
		final List<ActivityRecord> list = this.activityByCode.get(code);
		if (list != null) {
			// another thread beat us to it, so don't add again, just return the one that was added
			return list;
		}
		final List<ActivityRecord> newList = new ArrayList<ActivityRecord>();
		this.activityByCode.put(code, newList);
		return newList;
	}
}