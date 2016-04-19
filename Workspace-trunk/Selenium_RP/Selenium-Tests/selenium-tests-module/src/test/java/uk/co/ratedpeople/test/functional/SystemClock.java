package uk.co.ratedpeople.test.functional;

public class SystemClock implements Clock {
	@Override
	public long getTime() {
		return System.currentTimeMillis();
	}
}
