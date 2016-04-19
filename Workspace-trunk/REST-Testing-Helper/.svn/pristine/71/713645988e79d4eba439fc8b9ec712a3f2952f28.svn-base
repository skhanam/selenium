package uk.co.ratedpeople;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Enumeration;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
/**
 * Generates HMAC-SHA1 signatures.
 *
 * @author zsolt
 */
public final class SignatureGenerator {

	private static final Logger LOGGER = Logger.getLogger(SignatureGenerator.class.getName());

	/** Prefix for customer Rated People headers. Value = {@value } */
	public static final String RATEDPEOPLE_HEADER_PREFIX = "x-rp-";

	/** Rated People date header name. Value = {@value } */
	public static final String RATEDPEOPLE_DATE_HEADER = "x-rp-date";

    public static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    public static final String UTF_8_ENCODING = "UTF-8";


    /**
     * Generate a Base64 encoded HMAC-SHA1 signature. First encrypts the given text then it encodes the
	 * resulting byte array with Base64 encoding.
     *
     * @param data The data to be signed
     * @param key The signing key
     * @return The Base64 encoded HMAC-SHA1 signature
     * @throws java.security.SignatureException In case the signature generation fails
     */
    public String generateSignature(final String data, final String key) throws SignatureException {
        String signature = null;
        try {
            //get the key
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(UTF_8_ENCODING), HMAC_SHA1_ALGORITHM);
            //get an instance of the MAC algorithm with SHA1 hash algorithm
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            //initialize with the key
            mac.init(secretKey);
            //compute the HMAC bytes
            byte[] signatureBytes = mac.doFinal(data.getBytes(UTF_8_ENCODING));
            //base64 encode the HMAC            
            Base64 base64 = new Base64();
            signature = new String(base64.encode(signatureBytes), UTF_8_ENCODING);
			if (LOGGER.isLoggable(Level.FINE)) {
				LOGGER.fine("Signature: " + signature);
			}
        } catch (Exception ex) {
            throw new SignatureException( key, ex);
        }
        return signature;
    }

	/**
	 * Generates a signature for a given HTTP request. For the details how the signature is generated please
	 * check the API spec. <br />
	 * Please note that this method doesn't validate the data, for example it doesn't check whether there's any
	 * date header, the validation must be done prior to calling this method.
	 * 
	 * @param request The request to sign
	 * @param key The private access key to sign with
	 * @return The signature
	 * @throws java.security.SignatureException If a problem occures while signing
	 */
	public String generateSignature(final HttpServletRequest request, final String key) throws SignatureException {
		StringBuilder stringToSign = new StringBuilder();
		//add the HTTP verb
		stringToSign.append(request.getMethod()).append("\n");
		//add the Content type
		if (request.getContentType() != null) {
			stringToSign.append(request.getContentType()).append("\n");
		} else {
			stringToSign.append("\n");
		}
		
		//get all the RatedPeople headers, convert the header names to lowercase
		//and put them in a map with the values,
		SortedMap<String, String> rpHeaders = new TreeMap<String, String>();
		@SuppressWarnings("unchecked")
		Enumeration<String> headerNames = request.getHeaderNames();
		String headerName = null;
		String lcHeaderName = null;
		while (headerNames.hasMoreElements()) {
			headerName = (String) headerNames.nextElement();
			lcHeaderName = headerName.toLowerCase();
			if (lcHeaderName.contains(RATEDPEOPLE_HEADER_PREFIX)) {
				rpHeaders.put(lcHeaderName, request.getHeader(headerName));
			}
		}

		//add the date
		if (!rpHeaders.containsKey(RATEDPEOPLE_DATE_HEADER)) {
			if (request.getHeader("Date") != null) {
				stringToSign.append(request.getHeader("Date")).append("\n");
			} else {
				stringToSign.append("\n");
			}
		} else {
			stringToSign.append("\n");
		}
		
		//add headers
		for (Map.Entry<String, String> entry : rpHeaders.entrySet()) {
			stringToSign.append(entry.getKey()).append(":").append(entry.getValue()).append("\n");
		}

		//add resource
		String uri = request.getRequestURI();
		uri = convertPercentage20ToSpace(uri);
		stringToSign.append(uri);

		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.fine("StringToSign: " + stringToSign.toString());
		}		
		return generateSignature(stringToSign.toString(), key);
	}

	/**
	 * Concerts the url escape for space " " which is %20 to spaces.
	 * 
	 * @param uri
	 *            The uri who's %20's we want to chance to spaces.
	 * @return updated uri
	 */
	private String convertPercentage20ToSpace(String uri) {
		if (uri.contains("%20")) {
			uri = uri.replace("%20", " ");
		}
		return uri;
	}

	/**
	 * This method HAMAC-SHA1 signs given string with the given key, and encodes
	 * the result in base64 before returning a UTF8 String.
	 * 
	 * @param stringToSign
	 *            string that needs to be hashed
	 * @param key
	 *            key used for hashing
	 */
    public String getHMACSHA1SignedBase64Utf8String(final String stringToSign, final String key) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
	
    	if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.fine("StringToSign: " + stringToSign);
		}
		//get the key
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(UTF_8_ENCODING), HMAC_SHA1_ALGORITHM);
		//get an instance of the MAC algorithm with SHA1 hash algorithm
		Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
		//initialize with the key
		mac.init(secretKey);
		//compute the HMAC bytes
		byte[] signedStringBytes = mac.doFinal(stringToSign.getBytes(UTF_8_ENCODING));
		byte[] base64encoded = Base64.encodeBase64(signedStringBytes);
		String signedString = new String(base64encoded, UTF_8_ENCODING);
		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.fine("SignedString: " + signedString);
		}
		return signedString;
    }

}