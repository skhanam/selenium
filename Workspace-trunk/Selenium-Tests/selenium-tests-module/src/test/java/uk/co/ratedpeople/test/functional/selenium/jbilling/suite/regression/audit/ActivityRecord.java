package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.audit;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class ActivityRecord {
	private Actor actor;
	private ActivityType activityType;
	private Map<String, Object> userInfo;
	private final Date happenedAt;
	private String involvedTmIdCode;
	private boolean onServers;

	ActivityRecord(final Actor actor, final ActivityType activityType) {
		this.actor = actor;
		this.activityType = activityType;
		this.userInfo = new HashMap<String, Object>();
		this.happenedAt = new Date();
	}

	public Actor getActor() {
		return this.actor;
	}

	public ActivityType getActivityType() {
		return this.activityType;
	}

	public boolean isOnServers() {
		return this.onServers;
	}

	public void setOnServers(final boolean useServers) {
		this.onServers = useServers;
	}

	public void setInvolvedTmIdCode(final String idCode) {
		this.involvedTmIdCode = idCode;
	}

	public String getInvolvedTmIdCode() {
		return this.involvedTmIdCode;
	}

	public void addUserInfoKey(final String key, final Object data) {
		this.userInfo.put(key, data);
	}

	public Date getHappenedAt() {
		return this.happenedAt;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.activityType == null) ? 0 : this.activityType.hashCode());
		result = prime * result + ((this.actor == null) ? 0 : this.actor.hashCode());
		result = prime * result + ((this.happenedAt == null) ? 0 : this.happenedAt.hashCode());
		result = prime * result + ((this.involvedTmIdCode == null) ? 0 : this.involvedTmIdCode.hashCode());
		result = prime * result + (this.onServers ? 1231 : 1237);
		result = prime * result + ((this.userInfo == null) ? 0 : this.userInfo.hashCode());
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
		ActivityRecord other = (ActivityRecord) obj;
		if (this.activityType != other.activityType) {
			return false;
		}
		if (this.actor != other.actor) {
			return false;
		}
		if (this.happenedAt == null) {
			if (other.happenedAt != null) {
				return false;
			}
		} else if (!this.happenedAt.equals(other.happenedAt)) {
			return false;
		}
		if (this.involvedTmIdCode == null) {
			if (other.involvedTmIdCode != null) {
				return false;
			}
		} else if (!this.involvedTmIdCode.equals(other.involvedTmIdCode)) {
			return false;
		}
		if (this.onServers != other.onServers) {
			return false;
		}
		if (this.userInfo == null) {
			if (other.userInfo != null) {
				return false;
			}
		} else if (!this.userInfo.equals(other.userInfo)) {
			return false;
		}
		return true;
	}
}