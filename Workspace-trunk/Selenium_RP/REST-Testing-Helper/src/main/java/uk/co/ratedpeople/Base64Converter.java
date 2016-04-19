package uk.co.ratedpeople;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

/**
 * Converts between byte arrays, UTF-8 Strings and base64 encoded UTF-8 Strings.
 * 
 * @author christina.fisher
 * 
 */
public class Base64Converter {

	public static final String UTF8_ENCODING = "UTF-8";

	/**
	 * Encode a string to a base 64 hash, returns as UTF-8 encoded String
	 * 
	 * @param stringToEncode
	 *            UTF-8 encoded String
	 * @return base 64 hash of the String
	 */
	public static String encode(String stringToEncode) {
		try {
			byte[] stringToEncodeBytes = stringToEncode.getBytes(UTF8_ENCODING);
			return encode(stringToEncodeBytes);
		} catch (UnsupportedEncodingException ex) {
			throw new IllegalStateException("An error occurred while decoding string", ex);
		}
	}

	/**
	 * Encodes the bytes in base64 and converts to a UTF-8 String.
	 * 
	 * @param bytesToEncode
	 * @return
	 */
	public static String encode(byte[] bytesToEncode) {
		try {
			byte[] encodedStringBytes = Base64.encodeBase64(bytesToEncode);
			return new String(encodedStringBytes, UTF8_ENCODING);
		} catch (UnsupportedEncodingException ex) {
			throw new IllegalStateException("An error occurred while decoding string", ex);
		}
	}

	/**
	 * Decode a String from a base64 hash UTF-8 encoded String
	 * 
	 * @param encodedString
	 *            base 64 encoded string
	 * @return decoded String
	 */
	public static String decode(String encodedString) {
		try {
			byte[] encodedStringBytes = encodedString.getBytes(UTF8_ENCODING);
			byte[] decodedStringBytes = Base64.decodeBase64(encodedStringBytes);
			return new String(decodedStringBytes, UTF8_ENCODING);
		} catch (UnsupportedEncodingException ex) {
			throw new IllegalStateException("An error occurred while decoding string", ex);
		}
	}

}
