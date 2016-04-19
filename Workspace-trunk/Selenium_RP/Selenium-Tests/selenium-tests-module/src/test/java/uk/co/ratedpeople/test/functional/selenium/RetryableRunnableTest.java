package uk.co.ratedpeople.test.functional.selenium;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.FixableClock;
import uk.co.ratedpeople.test.functional.SimpleHolder;

public class RetryableRunnableTest {
	private static final long TIME_AT_FIRST_RUN = 1000l;
	private static final Long TIMEOUT = 100l;

	private FixableClock clock;
	SimpleHolder<Boolean> executed;

	@BeforeMethod
	public void beforeMethod() {
		clock = new FixableClock(TIME_AT_FIRST_RUN);
		executed = new SimpleHolder<Boolean>();
	}

	@Test
	public void successfulOperationWhenRunIsRunAndReportsSuccess() {
		RetryableRunnable underTest = new RetryableRunnable(getSuccessfulOperation(), clock, TIMEOUT);
		underTest.run();

		Assert.assertTrue(executed.value);
		Assert.assertTrue(underTest.succeeded());
	}

	@Test
	public void failingOperationWhenRunForFirstTimeIsRunAndCausesNoExceptionAndDoesNotReportSuccess() {
		RetryableRunnable underTest = givenFirstRunOfFailingOperation();
		
		Assert.assertTrue(executed.value);
		Assert.assertFalse(underTest.succeeded());
	}

	@Test
	public void failingOperationWhenRunAgainWithinTimeoutIsRunAndCausesNoExceptionAndDoesNotReportSuccess() {
		RetryableRunnable underTest = givenFirstRunOfFailingOperation();

		clock.time = TIME_AT_FIRST_RUN + 50l;
		Assert.assertFalse(timeoutReached());

		executed.value = false;
		underTest.run();
		
		Assert.assertTrue(executed.value);
		Assert.assertFalse(underTest.succeeded());
	}

	@Test(expectedExceptions = OperationFailedException.class)
	public void failingOperationWhenRunAgainAfterTimeoutCausesExceptionAndDoesNotReportSuccess() {
		RetryableRunnable underTest = givenFirstRunOfFailingOperation();

		clock.time = TIME_AT_FIRST_RUN + TIMEOUT;
		Assert.assertTrue(timeoutReached());

		executed.value = false;
		underTest.run();
		
		Assert.assertTrue(executed.value);
		Assert.assertFalse(underTest.succeeded());
	}

	private boolean timeoutReached() {
		return clock.time - TIME_AT_FIRST_RUN >= TIMEOUT;
	}

	private RetryableRunnable givenFirstRunOfFailingOperation() {
		RetryableRunnable underTest = new RetryableRunnable(getFailingRunnable(new OperationFailedException()), clock, TIMEOUT);
		underTest.run();

		return underTest;
	}

	private Runnable getSuccessfulOperation() {
		return new Runnable() {
			@Override
			public void run() {
				executed.value = true;
			}
		};
	}

	private Runnable getFailingRunnable(final RuntimeException e) {
		return new Runnable() {
			@Override
			public void run() {
				executed.value = true;
				throw e;
			}
		};
	}

	@SuppressWarnings("serial")
	class OperationFailedException extends RuntimeException {
		public OperationFailedException() {
			super("I come from an always-failing operation");
		}
	}
}
