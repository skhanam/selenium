package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.jbillingmodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A group of {@link PlanInstance} objects.
 */
public class PlanGroup implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(PlanGroup.class.getName());
	private final PlanInstance.Comparators.StartDateComparator startDateComparator;
	private final List<PlanInstance> plans;

	public PlanGroup() {
		this.plans = new ArrayList<PlanInstance>();
		this.startDateComparator = new PlanInstance.Comparators.StartDateComparator();
	}

	public void add(final PlanInstance plan) {
		this.plans.add(plan);
		sortPlansByStartDateAscending();
	}

	private void sortPlansByStartDateAscending() {
		Collections.sort(this.plans, this.startDateComparator);
	}

	public List<PlanInstance> getPlansActiveAtDate(final Date date) {
		/* ok, so we could do something clever here with custom objects and DateRanges... but let's just do something simple for now... */
		// using earliest date strategy... assumes all in startDate order
		final List<PlanInstance> activePlans = new ArrayList<PlanInstance>();
		for (final PlanInstance plan : this.plans) {
			final boolean activeOnDate = plan.isActiveOn(date);
			if (activeOnDate) {
				LOGGER.log(Level.INFO, "Plan : " + plan + " is active on date: " + date + " so adding to list.");
				activePlans.add(plan);
			}
		}
		// when here, should have all (hopefully just one!) active plan in a list.
		return activePlans;
	}

	public List<PlanInstance> getAllPlans() {
		final List<PlanInstance> fixed = Collections.unmodifiableList(this.plans);
		return fixed;
	}

	public boolean hasAnyActivePlansAtDate(final Date date) {
		final boolean does = !this.getPlansActiveAtDate(date).isEmpty();
		return does;
	}

	public PlanInstance getFirstPlan() {
		final PlanInstance first = this.plans.get(0);
		return first;
	}
}
