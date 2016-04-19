package uk.co.ratedpeople;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Date;

/**
 * 
 * Provides utility methods to provide HTTP headers with pre-configured key data.
 * 
 */
public class HeaderHelper {

	private static final String ACCESS_KEY_ID = "campaignId=359&affiliateId=234988&hashed=true";
	private static final String ACCESS_KEY = "P3IeS7FlREi1a7FhnhXW9AY11NX3lMPv";
	
	public static final String APPLICATION_XML_CONTENT_TYPE = "application/xml";
	public static final String MULTIPART_CONTENT_TYPE = "multipart/form-data";

	
	public String provideAccessKeyId() {
		try {
			TestContext context = TestContext.getDefault();
			String accessKeyId = context.getAccessKeyId();
			if (accessKeyId == null) {
				return ACCESS_KEY_ID;
			} else {
				return accessKeyId;
			}			
		} catch (IOException ie) {
			throw new RuntimeException(ie);
		}
		
	}
	
	public String provideAccessKey() {
		try {
			TestContext context = TestContext.getDefault();
			String accessKey = context.getAccessKey();
			if (accessKey == null) {
				return ACCESS_KEY;
			} else {
				return accessKey;
			}
		} catch (IOException ie) {
			throw new RuntimeException(ie);
		}
	}
	
	public String createAuthnHeader(String username, String password) throws InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException {
		AuthenticationHeaderGenerator generator = new AuthenticationHeaderGenerator();
		String authnHeader = generator.getAuthenticationHeaderWithPlainPassword(username, password, provideAccessKeyId(), provideAccessKey());
		return authnHeader;
	}

	public String createAuthnHeaderUsingHashedPassword(String username, String hashedPassword) throws InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException {
		AuthenticationHeaderGenerator generator = new AuthenticationHeaderGenerator();
		String authnHeader = generator.getAuthenticationHeader(username, hashedPassword, provideAccessKeyId(), provideAccessKey());
		return authnHeader;
	}
	
	public String createPostAuthzHeader(String uri, String contentType, Date date) throws InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException {
		AuthorizationHeaderGenerator generator = new AuthorizationHeaderGenerator();
		String authzHeader = generator.generate("POST", contentType, uri, provideAccessKeyId(), provideAccessKey(), date);
		return authzHeader;
	}

	public String createGetAuthzHeader(String uri, Date date) throws InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException {
		AuthorizationHeaderGenerator generator = new AuthorizationHeaderGenerator();
		String authzHeader = generator.generate("GET", null, uri, provideAccessKeyId(), provideAccessKey(), date);
		return authzHeader;
	}

	public String createGetAuthzHeader(String uri, Date date, String accessKey, String accessKeyId) throws InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException {
		AuthorizationHeaderGenerator generator = new AuthorizationHeaderGenerator();
		String authzHeader = generator.generate("GET", null, uri, accessKeyId, accessKey, date);
		return authzHeader;
	}

	public String createPutAuthzHeader(String uri, Date date) throws InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException {
		AuthorizationHeaderGenerator generator = new AuthorizationHeaderGenerator();
		String authzHeader = generator.generate("PUT", APPLICATION_XML_CONTENT_TYPE, uri, provideAccessKeyId(), provideAccessKey(), date);
		return authzHeader;
	}

	public String createDeleteAuthzHeader(String uri, Date date) throws InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException {
		AuthorizationHeaderGenerator generator = new AuthorizationHeaderGenerator();
		String authzHeader = generator.generate("DELETE", null, uri, provideAccessKeyId(), provideAccessKey(), date);
		return authzHeader;
	}
}
