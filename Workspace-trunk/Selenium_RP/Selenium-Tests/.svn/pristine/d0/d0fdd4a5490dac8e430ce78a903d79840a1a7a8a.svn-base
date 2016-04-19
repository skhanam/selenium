package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.tradesman;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;

class TradesmanStateFileWriter {
	TradesmanStateFileWriter() {
		super();
	}

	void writeToFile(final Collection<Tradesman> tradesmanCollection, final String fileName) {
		try {
			final FileOutputStream out = new FileOutputStream(fileName);
			final BufferedOutputStream buffer = new BufferedOutputStream(out);
			final ObjectOutputStream stream = new ObjectOutputStream(buffer);
			stream.writeObject(tradesmanCollection);
			stream.close();
			
//			final FileWriter file = new FileWriter(fileName);
//			final BufferedWriter buffer = new BufferedWriter(file);
//			final Gson gson = new Gson();
//			final Type listType = new TypeToken<Collection<TradesmanState>>() {
//			}.getType();
//			final String json = gson.toJson(tradesmanCollection, listType);
//			System.out.println("generated json: " + json);
//			buffer.write(json);
//			for (final Tradesman tm : tradesmanCollection) {
//				final String json = gson.toJson(tm.getTmState());
//				buffer.write(json);
//			}
//			buffer.close();
		} catch (final FileNotFoundException fnfE) {
			throw new RuntimeException(fnfE);
		} catch (final IOException ioE) {
			throw new RuntimeException(ioE);
		}
	}
}