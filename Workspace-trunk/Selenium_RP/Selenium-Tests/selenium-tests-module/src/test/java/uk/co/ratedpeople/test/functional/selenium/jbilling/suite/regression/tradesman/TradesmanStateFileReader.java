package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.tradesman;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collection;

class TradesmanStateFileReader {
	TradesmanStateFileReader() {
	}

	Collection<TradesmanState> readFromFile(final String fileName) {
		try {
//			final FileReader file = new FileReader(fileName);
//			final BufferedReader buffer = new BufferedReader(file);
//			final Gson gson = new Gson();
//
//			final Type listType = new TypeToken<Collection<TradesmanState>>() {
//			}.getType();
//			final Collection<TradesmanState> tmStates = gson.fromJson(buffer, listType);
			
			final FileInputStream file = new FileInputStream(fileName);
			final BufferedInputStream buffer = new BufferedInputStream(file);
			final ObjectInputStream stream = new ObjectInputStream(buffer);
			@SuppressWarnings("unchecked")
			final Collection<TradesmanState> tmStates = (Collection<TradesmanState>) stream.readObject();
			stream.close();
			System.out.println("Loaded: " + tmStates);
			return tmStates;
		} catch (final FileNotFoundException fnfE) {
			throw new RuntimeException(fnfE);
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		} catch (ClassNotFoundException exception) {
			throw new RuntimeException(exception);
		}
	}
}