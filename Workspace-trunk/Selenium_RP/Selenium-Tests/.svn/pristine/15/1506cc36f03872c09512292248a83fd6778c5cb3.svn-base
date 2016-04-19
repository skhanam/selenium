package uk.co.ratedpeople.test.functional.selenium;

/**
 * Runs a Runnable at intervals, and stops doing so only if it throws a Throwable.
 */
public class RetryingRunner {
	private long retryInterval;

	public RetryingRunner(long retryInterval) {
		this.retryInterval = retryInterval;
	}

	public void run(RetryableRunnable runnable) {
		while (true) {
			runnable.run();
			if (runnable.succeeded()) {
				return;
			}
			
			sleep(retryInterval);
		}
	}

	private void sleep(long interval) {
		try {
			Thread.sleep(interval);
		}
		catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
