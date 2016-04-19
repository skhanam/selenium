package uk.co.ratedpeople;

import java.security.InvalidKeyException;
import java.security.SignatureException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.codec.digest.DigestUtils;

public class AuthenticationHeaderGenerator {

	private static Logger LOGGER = Logger.getLogger(AuthenticationHeaderGenerator.class.getName());

	/**
	 * Creates a header for authentication consisting of: RPWS
	 * accesskey:username=username&password=signedhashedpassword Both the
	 * accesskey and the username and password string are base 64 encoded.
	 * 
	 * @param userName
	 *            Email address of user trying to access the API
	 * @param plainPassword
	 *            Password before hashing
	 * @param accessKeyId
	 *            Access Id consisting of campaignId, affiliateId and whether
	 *            these are hashed: e.g.
	 *            campaignId=391&affiliateId=88218&hashed=true
	 * @param accessKey
	 *            Private access key provided to this partner
	 * @return The header
	 * @throws SignatureException
	 * @throws InvalidKeyException
	 */
	public String getAuthenticationHeaderWithPlainPassword(String userName, String plainPassword, String accessKeyId, String accessKey)
					throws SignatureException, InvalidKeyException {
		return getAuthenticationHeader(userName, DigestUtils.md5Hex(plainPassword), accessKeyId, accessKey);
	}

	/**
	 * Creates a header for authentication consisting of: RPWS
	 * accesskey:username=username&password=signedhashedpassword Both the
	 * accesskey and the username and password string are base 64 encoded.
	 * 
	 * @param userName
	 *            Email address of user trying to access the API
	 * @param hashedPassword
	 *            MD5 hashed password
	 * @param accessKeyId
	 *            Access Id consisting of campaignId, affiliateId and whether
	 *            these are hashed: e.g.
	 *            campaignId=391&affiliateId=88218&hashed=true
	 * @param privateAccessKey
	 *            Private access key provided to this partner
	 * @return The header
	 * @throws SignatureException
	 * @throws InvalidKeyException
	 */
	public String getAuthenticationHeader(String userName, String hashedPassword, String accessKeyId, String privateAccessKey)
					throws SignatureException, InvalidKeyException {
		LOGGER.log(Level.FINE, "User name : {0}", userName);
		LOGGER.log(Level.FINE, "Hashed Password : {0}", hashedPassword);
		LOGGER.log(Level.FINE, "Access key id {0}: ", accessKeyId);
		LOGGER.log(Level.FINE, "Access key : {0}", privateAccessKey);

		String encodedAccessKeyId = Base64Converter.encode(accessKeyId);
		LOGGER.log(Level.FINE, "Encoded access key : {0}", encodedAccessKeyId);

		PasswordSigner signer = new PasswordSigner();
		String signedEncodedPassword = signer.sign(hashedPassword, privateAccessKey);

		String authSign = "username=" + userName + "&password=" + signedEncodedPassword;
		LOGGER.log(Level.FINE, "Un encoded authentication sign : {0}", authSign);

		String base64EncodedAuthSign = Base64Converter.encode(authSign);
		LOGGER.log(Level.FINE, "Base 64 encoded auth sign : {0}", base64EncodedAuthSign);

		StringBuilder authHeader = new StringBuilder();
		authHeader.append("RPWS ");
		authHeader.append(encodedAccessKeyId);
		authHeader.append(":");
		authHeader.append(base64EncodedAuthSign);

		LOGGER.log(Level.FINE, "Authentication header : {0}", authHeader.toString());

		return authHeader.toString();
	}
}
