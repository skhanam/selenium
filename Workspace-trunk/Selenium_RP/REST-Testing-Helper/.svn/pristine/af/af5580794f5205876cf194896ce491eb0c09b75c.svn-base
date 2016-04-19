package uk.co.ratedpeople;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * This is a utility class to encrypt the data using AES Algorithm.
 * 
 * @author abhiuday.tomar
 * 
 */

public class AESEncryption {

	private static final String ALGO = "AES";

	public static String encrypt(String Data, String encryptionKey) throws Exception {
		Key key = generateKey(encryptionKey);
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		byte[] encryptedValue = Base64.encodeBase64(encVal);
		return new String(encryptedValue);
	}

	public static String decrypt(String encryptedData, String encryptionKey) throws Exception {
		Key key = generateKey(encryptionKey);
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = new Base64().decode(encryptedData.getBytes());
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	/**
	 * This method encrypts a text using AES/CBC/PKCS5Padding algorithm
	 * 
	 * @param data
	 *            the data to encrypt
	 * @param salt
	 *            the salt to concatenate
	 * @param encryptionKey
	 *            secret key
	 * @return A string encrypted
	 * @throws Exception
	 */
	public static String encryptCBC(String data, String salt, String encryptionKey) throws Exception {

		byte[] initializationVector = salt.getBytes();
		IvParameterSpec ips = new IvParameterSpec(initializationVector);
		SecretKey aesKey = new SecretKeySpec(encryptionKey.getBytes(), ALGO);

		Cipher encryptCipher;
		encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		// Initialize the Cipher with key and parameters
		encryptCipher.init(Cipher.ENCRYPT_MODE, aesKey, ips);

		byte[] cleartext = (data).getBytes();
		byte[] ciphertext = encryptCipher.doFinal(cleartext);
		byte[] encryptedValue = Base64.encodeBase64(ciphertext);
		String result = new String(encryptedValue);

		return result;

	}

	/**
	 * This method decrypts a text using AES/CBC/PKCS5Padding algorithm
	 * 
	 * @param encryptedData
	 *            the data to decrypt
	 * @param salt
	 *            the salt to concatenate
	 * @param encryptionKey
	 *            secret key
	 * @return A string in clear format
	 * @throws Exception
	 */
	public static String decryptCBC(String encryptedData, String salt, String encryptionKey) throws Exception {

		Cipher decryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] initializationVector = salt.getBytes();
		IvParameterSpec ips = new IvParameterSpec(initializationVector);
		SecretKey aesKey = new SecretKeySpec(encryptionKey.getBytes(), ALGO);

		// Initialize PBE Cipher with key and parameters
		decryptCipher.init(Cipher.DECRYPT_MODE, aesKey, ips);
		byte[] decordedValue = new Base64().decode(encryptedData.getBytes());
		// Decrypt the cleartext
		byte[] deciphertext = decryptCipher.doFinal(decordedValue);

		String decryptedValue = new String(deciphertext);

		return decryptedValue;
	}

	private static Key generateKey(String encryptionKey) throws Exception {
		Key key = new SecretKeySpec(encryptionKey.getBytes(), ALGO);
		return key;
	}

}
