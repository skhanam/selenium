package uk.co.ratedpeople;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;

/**
 * Class providing functionality to generate email addresses which are universally unique.
 * 
 * @author nigel.rawlins
 */
public class UniqueEmailAddressGenerator {
	
	/**
	 * Generate a universally unique email address which starts with the string "test.user".
	 * 
	 * @return The generated email address.
	 */
	public String generateUniqueEmailAddress() {
		return generateUniqueEmailAddress("test.user");
	}

	/**
	 * Generate a universally unique email address which starts with the provided start text.
	 * 
	 * @param startText The start text.
	 * @return The generated email address.
	 */
	public String generateUniqueEmailAddress(String startText) {
		return generateUniqueEmailAddress(startText, "@ratedtrades.com");
	}

	private String generateUniqueEmailAddress(String startText, String endText){
		return startText + StringUtils.replace(UUID.randomUUID().toString(), "-", "") + endText;
	}

	/**
	 * Generate a universally unique email address for Jbilling accounts.
	 * 
	 * @return The generated email address.
	 */
	public String getUniqueEmailAccountNameJBilling() {
		return generateUniqueEmailAddress(StringUtils.EMPTY, "jbilling@ratedtrades.com");
	}
}