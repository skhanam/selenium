package uk.co.ratedpeople.test.functional.selenium;

import uk.co.ratedpeople.test.functional.Clock;

/**
 * Runs a Runnable whenever asked to do so, re-throwing no exception thrown by the
 * Runnable unless a we've reached timeout such that <code>(time now - time first run) >= timeout</code>.
 */
public class RetryableRunnable implements Runnable {
	private Runnable runnable;
	private Clock clock;
	private long timeout;
	private boolean succeeded;

	private long firstRunTime;

	public RetryableRunnable(Runnable runnable, Clock clock, long timeout) {
		this.runnable = runnable;
		this.clock = clock;
		this.timeout = timeout;
	}

	public void run() {
		long runTime = clock.getTime();
		
		if (firstRunTime == 0l) {
			firstRunTime = runTime;
		}

		RuntimeException operationException = null;

		try {
			runnable.run();
			succeeded = true;
		}
		catch (RuntimeException e) {
			operationException = e;
		}

		if (runTime - firstRunTime >= timeout) {
			throw operationException;
		}
	}

	public boolean succeeded() {
		return succeeded;
	}
}
