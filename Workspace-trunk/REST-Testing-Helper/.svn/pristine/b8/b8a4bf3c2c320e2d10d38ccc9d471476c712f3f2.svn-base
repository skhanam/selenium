/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.ratedpeople;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpResponse;

/**
 * Helper class for retrieving errors from HttpResponse
 * @author swethamorthala
 */
public class ErrorsRetriever {

	/**
	 * This method is responsible for parsing the content in the response to Errors object
	 * @param response HttpResponse object whose content needs to be parsed
	 * @return Errors returns parsed Errors object
	 * @see Errors
	 */
    public Errors getErrors(HttpResponse response) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Errors.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Errors errors = (Errors) unmarshaller.unmarshal(response.getEntity().getContent());
		return errors;
    }

}
