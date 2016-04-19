package uk.co.ratedpeople;

import java.util.Calendar;

/**
 * A generator of phone numbers based on the current system time.
 * 
 * @author nigel.rawlins
 */
public class TelephoneNumberCurrentTimeStampBasedGenerator {
	
	/**
	 * Generate a land line telephone number (one starting with 01).
	 * 
	 * @return
	 */
	public String generateLandLineTelephoneNumber() {
		return generatePhoneNumber("01");
	}
	
	/**
	 * Generate a mobile telephone number (one starting with 07).
	 * 
	 * @return
	 */
	public String generateMobileTelephoneNumber() {
		return generatePhoneNumber("07");
	}
	
	/**
	 * This method is synchronized to ensure uniqueness of the telephone number generated as far as possible.
	 * The eleven digits of the number are made up of:
	 * 
	 * - 01 or 07 depending on the incoming prefix (01 will be passed in for land lines and 07 will be passed in for mobiles).
	 * - The current day of the month as a two digit number.
	 * - The current hour of the day as a two digit number.
	 * - The current minute of the hour as a two digit number.
	 * - The current second of the minute as a two digit number.
	 * - The first digit of the current millisecond of the second.
	 * 
	 * In addition to synchronizing, to ensure uniqueness we also do not want the current timestamp to be requested more than
	 * once in the same tenth of a second, since this is the level to which we use, so the method pauses for at least this
	 * length of time to make absolutely sure.
	 * 
	 * @param prefix The prefix (01 for land lines or 07 for mobiles).
	 * @return The generated telephone number.
	 */
	private synchronized String generatePhoneNumber(final String prefix) {
		
		ensurePausedForAtLeastOneHundredMilliseconds();
		
		final Calendar calendar = Calendar.getInstance();
		
		final int day = calendar.get(Calendar.DAY_OF_MONTH);
		final int hour = calendar.get(Calendar.HOUR_OF_DAY);
		final int minute = calendar.get(Calendar.MINUTE);
		final int second = calendar.get(Calendar.SECOND);
		final int millisecond = calendar.get(Calendar.MILLISECOND);
		
		return prefix + ensureTwoCharacters(day) + ensureTwoCharacters(hour) + ensureTwoCharacters(minute) + ensureTwoCharacters(second) + (millisecond / 100);
	}
	
	/**
	 * Pause the current thread for at least 100 milliseconds.
	 */
	private void ensurePausedForAtLeastOneHundredMilliseconds() {
		
		final long timeAtStartOfMethod = System.currentTimeMillis();
		
		while (System.currentTimeMillis() < timeAtStartOfMethod + 100L) {
			try {
				Thread.sleep(100L);
			}
			catch(InterruptedException interruptedException) {
				continue;
			}
		}
	}
	
	/**
	 * For the given integer, pad it with an extra zero at the front if it is less than 10, returning exactly two characters as a string.
	 * 
	 * @param integer The integer.
	 * @return The integer as a string, padded with a zero at the front if necessary.
	 */
	private String ensureTwoCharacters(final int integer) {
		return integer < 10 ? "0" + integer : String.valueOf(integer);
	}
}