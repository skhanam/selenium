package uk.co.ratedpeople;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.http.HttpResponse;

public class ResponseContentUnwrapper {
	
	/**
	 * Converts the content of the response into a string	
	 * @param response Response containing some content
	 * @return A string containing the content of the response
	 */
	public String unwrapContentAsString(HttpResponse response) {
    	try {
    		InputStream input = response.getEntity().getContent();
    		OutputStream output = new ByteArrayOutputStream();
    		IOUtils.copy(input, output);
    		return output.toString();
    	} catch (IOException io) {
    		throw new IllegalStateException(io);
    	}
    }
}
