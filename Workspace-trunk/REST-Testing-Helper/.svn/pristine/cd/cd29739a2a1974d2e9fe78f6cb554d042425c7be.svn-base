/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.ratedpeople;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpResponse;

import uk.co.ratedpeople.Collection;
import uk.co.ratedpeople.ReferenceData;


/**
 * Helper class for retrieving reference data from HttpResponse
 * @author swethamorthala
 */
public class ReferenceDataRetriever {

	/**
	 * This method is responsible for loading data from HttpResponse to a collection
	 * of ReferenceData objects
	 * @param response HttpResponse to load data from
	 * @return Collection<ReferenceData> returns a collection of ReferenceData objects
	 * @see ReferenceData
	 */
	@SuppressWarnings("unchecked")
    public Collection<ReferenceData> getReferenceData(HttpResponse response) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Collection.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Collection<ReferenceData> collection = (Collection<ReferenceData>) unmarshaller.unmarshal(response.getEntity().getContent());
		return collection;
    }

	/**
	 * This method is responsible for extracting code name information from the collection of
	 * ReferenceData and adding it to a List.
	 * @param collection Collection of ReferenceData objects to extract code names from
	 * @return List<String> returns a list of code names
	 */
    public List<String> getCodeNames(Collection<ReferenceData> collection){
		List<String> codes = new ArrayList<String>();
		List<ReferenceData> refDataColl = collection.getEntries();
		for(ReferenceData refData : refDataColl){
		    codes.add(refData.getCode());
		}
		return codes;
    }
}
