package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class MonetaryAmountTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	public static enum TransType {
		/** This is a credit into a TMs account (so a payment from RP to them) */
		CREDIT,
		/** This is a payment made by the TM, which is permitted to use any credit they may have. */
		SPEND_CREDIT_USE_PERMITTED,
		/** This is a payment made by the TM, which must be charged immediately, and cannot use credit. */
		SPEND_CHARGE_IMMEDIATE;
	}

	private final MonetaryAmountTransaction.TransType type;
	private final BigDecimal amount;

	public MonetaryAmountTransaction(final MonetaryAmountTransaction.TransType type, final BigDecimal amount) {
		super();
		this.type = type;
		this.amount = amount;
	}

	public MonetaryAmountTransaction.TransType getType() {
		return this.type;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}