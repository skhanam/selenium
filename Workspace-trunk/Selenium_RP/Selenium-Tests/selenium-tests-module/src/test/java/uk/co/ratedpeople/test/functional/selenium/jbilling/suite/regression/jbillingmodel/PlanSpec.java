package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.jbillingmodel;

import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money.TaxableAmount;

public class PlanSpec implements Serializable {

	public static class Builder {
		private String planSelectorId;
		private PlanPeriod planPeriod;
		private TaxableAmount cost;
		private TaxableAmount inclusiveCredit;

		public static Builder with() {
			return new Builder();
		}

		private Builder() {
		}

		public Builder planSelectorId(final String planSelectorId) {
			this.planSelectorId = planSelectorId;
			return this;
		}

		public Builder planPeriodOf(final PlanPeriod planPeriod) {
			this.planPeriod = planPeriod;
			return this;
		}

		public Builder costing(final TaxableAmount cost) {
			this.cost = cost;
			return this;
		}

		public Builder includingCredit(final TaxableAmount inclusiveCredit) {
			this.inclusiveCredit = inclusiveCredit;
			return this;
		}

		public PlanSpec build() {
			return new PlanSpec(planSelectorId, planPeriod, cost, inclusiveCredit);
		}
	}

	private static final long serialVersionUID = 1L;

	/** What is this, and how does it work? */
	private final String planSelectorId;
	private final PlanPeriod planPeriod;
	private final TaxableAmount cost;
	private final TaxableAmount inclusiveCredit;

	PlanSpec(final String planSelectorId, final PlanPeriod planPeriod, final TaxableAmount cost, final TaxableAmount inclusiveCredit) {
		super();
		this.planSelectorId = planSelectorId;
		this.planPeriod = planPeriod;
		this.cost = cost;
		this.inclusiveCredit = inclusiveCredit;
	}

	public String getPlanSelectorId() {
		return planSelectorId;
	}

	public PlanPeriod getPlanPeriod() {
		return planPeriod;
	}

	public TaxableAmount getCost() {
		return this.cost;
	}

	// BigDecimal getInclusiveCreditAmount() {
	// return this.inclusiveCredit;
	// }

	public TaxableAmount getInclusiveCredit() {
		return this.inclusiveCredit;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.cost == null) ? 0 : this.cost.hashCode());
		result = prime * result + ((this.inclusiveCredit == null) ? 0 : this.inclusiveCredit.hashCode());
		result = prime * result + ((this.planPeriod == null) ? 0 : this.planPeriod.hashCode());
		result = prime * result + ((this.planSelectorId == null) ? 0 : this.planSelectorId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PlanSpec other = (PlanSpec) obj;
		if (this.cost == null) {
			if (other.cost != null) {
				return false;
			}
		} else if (!this.cost.equals(other.cost)) {
			return false;
		}
		if (this.inclusiveCredit == null) {
			if (other.inclusiveCredit != null) {
				return false;
			}
		} else if (!this.inclusiveCredit.equals(other.inclusiveCredit)) {
			return false;
		}
		if (this.planPeriod != other.planPeriod) {
			return false;
		}
		if (this.planSelectorId == null) {
			if (other.planSelectorId != null) {
				return false;
			}
		} else if (!this.planSelectorId.equals(other.planSelectorId)) {
			return false;
		}
		return true;
	}
}