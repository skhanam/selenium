package uk.co.ratedpeople;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public class PasswordSigner {

	private static Logger LOGGER = Logger.getLogger(PasswordSigner.class.getName());

	/**
	 * Convert the hashed password into UTF-8 (which shouldn't have any effect).
	 * Sign it with the HMACSHA1 algorithm and convert that into a base64 UTF-8
	 * encoded string.
	 * 
	 * @param hashedPassword
	 *            - md5 hash of the password to be signed
	 * @parm accessKey The private key to sign with
	 * @return A signed, hashed base64 UTF-8 password
	 * @throws InvalidKeyException
	 *             If the key provided could not be used to sign
	 */
	public String sign(String hashedPassword, String accessKey) throws InvalidKeyException {
		try {
			String utf8EncodedPassword = URLEncoder.encode(hashedPassword, "UTF-8");
			LOGGER.fine("UTF-8 encoded password: " + utf8EncodedPassword);
			SignatureGenerator signer = new SignatureGenerator();
			String userSignedPassword = signer.getHMACSHA1SignedBase64Utf8String(hashedPassword, accessKey);
			LOGGER.fine("Signed password: " + userSignedPassword);
			return userSignedPassword;
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("UTF-8 is not a supported encoding");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("HmacSHA1 is not a supported algorithm");
		}
	}

}
