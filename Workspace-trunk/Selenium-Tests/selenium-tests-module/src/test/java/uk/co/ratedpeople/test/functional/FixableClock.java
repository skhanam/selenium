package uk.co.ratedpeople.test.functional;

public class FixableClock implements Clock {
	public long time;

	public FixableClock() {
	}

	public FixableClock(long time) {
		this.time = time;
	}

	@Override
	public long getTime() {
		return time;
	}
}
