package uk.co.ratedpeople;

import java.util.HashMap;

@SuppressWarnings("serial")
public class LiteralMap<T, U> extends HashMap<T, U> {
	@SuppressWarnings("unchecked")
	public LiteralMap(Object... values) {
		if (values.length % 2 != 0) {
			throw new IllegalArgumentException("values must be a List with an even number of elements");
		}
		
		for (int a = 0; a < values.length / 2; a++) {
			put((T) values[a * 2], (U) values[a * 2 + 1]);
		}
	}
}
