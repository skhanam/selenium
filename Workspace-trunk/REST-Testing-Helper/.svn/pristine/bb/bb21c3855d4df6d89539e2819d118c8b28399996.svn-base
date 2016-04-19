package uk.co.ratedpeople;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class MD5CheckSumCalculator {
	private static final Logger LOGGER = Logger.getLogger(MD5CheckSumCalculator.class.getName());

	public String createMD5SumStringFromFileOverHttps(String filePath) throws ClientProtocolException, IOException {
		System.out.println("file path over https::"+filePath);
		HttpGet getImageRequest = new HttpGet(filePath);
		final DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpResponse response = httpClient.execute(getImageRequest);
		InputStream is = response.getEntity().getContent();
		return createMD5SumString(is);

	}

	public String createMD5SumStringFromFile(String filePath) throws FileNotFoundException {
		System.out.println("FilePath::"+filePath);
		InputStream is = new FileInputStream(filePath);
		return createMD5SumString(is);
	}

	public String createMD5SumString(InputStream is) {
		 byte[] b = createMD5Sum(is);
	       String result = "";
	       for (int i=0; i < b.length; i++) {
	           result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
	       }
	       return result;
	}

	private byte[] createMD5Sum(InputStream is) {
		try {
			try{byte[] buffer = new byte[1024];
		       MessageDigest complete = MessageDigest.getInstance("MD5");
		       int numRead;

		       do {
		           numRead = is.read(buffer);
		           if (numRead > 0) {
		               complete.update(buffer, 0, numRead);
		           }
		       } while (numRead != -1);
		       return complete.digest();
			}finally{
		       is.close();
			}
		} catch (NoSuchAlgorithmException nsae) {
			LOGGER.log(Level.SEVERE, "No such algorithm exception", nsae);
			return null;
		} catch (IOException ioe) {
			LOGGER.log(Level.SEVERE, "IO Exception", ioe);
			return null;
		}
	}
}
