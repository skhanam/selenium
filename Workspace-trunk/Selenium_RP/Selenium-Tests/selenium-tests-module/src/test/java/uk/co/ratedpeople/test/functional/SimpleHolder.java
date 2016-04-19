package uk.co.ratedpeople.test.functional;

/**
 * A Holder which directly exposes the field containing its held value.
 */
public class SimpleHolder<T> implements Holder<T> {
	public T value;

	public SimpleHolder() {
	}

	public SimpleHolder(T value) {
		this.value = value;
	}
	
	@Override
	public T getValue() {
		return value;
	}
}
