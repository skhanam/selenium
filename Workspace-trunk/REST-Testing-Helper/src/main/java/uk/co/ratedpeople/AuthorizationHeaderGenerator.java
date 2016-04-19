package uk.co.ratedpeople;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AuthorizationHeaderGenerator {
	
	private static Logger LOGGER = Logger.getLogger(AuthorizationHeaderGenerator.class.getName());
	
    /**
     * Generates an authorization header to be used with the REST api requests
     * @param method HTTP method - e.g. GET or POST
     * @param contentType content type - e.g. application/xml
     * @param uri uri to which the request is being sent Ex: "/api/v1/jobBudgets
     * @param accessKeyId Combination string of campaign and affiliate id Ex: "campaignId=359&affiliateId=234988&hashed=true"
     * @param accessKey This is the private access key assigned to that particular Partner/Affiliate
     * @Date date This date should be the same as the one in header
     */
    public String generate(String method, String contentType, String uri, String accessKeyId, String accessKey, Date date) throws SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException{
    	final String encodedAccessKeyId = Base64Converter.encode(accessKeyId);
		LOGGER.fine("Encoded access key : " + encodedAccessKeyId);
	
		final StringBuilder unSignedString = new StringBuilder();
		unSignedString.append(method + "\n");
		unSignedString.append((contentType == null ? "": contentType) +"\n");
		unSignedString.append("\n");
		unSignedString.append("x-rp-date:" + date.toString() + "\n");
		unSignedString.append(uri);
		
		LOGGER.log(Level.FINE, "Unsigned authorisation string : {0}", unSignedString.toString());
	
		SignatureGenerator signer = new SignatureGenerator();
		final String signedString = signer.generateSignature(unSignedString.toString(), accessKey);
	
		LOGGER.log(Level.FINE, "Signed string : {0}", signedString);
	
		final StringBuilder authHeader = new StringBuilder();
		authHeader.append("RPWS ");
		authHeader.append(encodedAccessKeyId);
		authHeader.append(":");
		authHeader.append(signedString);
	
		LOGGER.log(Level.FINE, "Authorization header : {0}", authHeader.toString());
	
		return authHeader.toString();
    }
}
