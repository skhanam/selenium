package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.jbillingmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.GoodwillGrant;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money.CurrencyHelp;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money.MonetaryAmountTransaction;
import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money.MonetaryAmountTransaction.TransType;

/**
 * Represents an Account Balance in jBilling, with the RP-logic additions (e.g. "Special Credit")
 */
public class Balance implements Serializable {
	private static final long serialVersionUID = 1L;

	public static class BalanceException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		BalanceException() {
			super();
		}

		BalanceException(String message, Throwable cause) {
			super(message, cause);
		}

		BalanceException(String message) {
			super(message);
		}

		BalanceException(Throwable cause) {
			super(cause);
		}
	}

	public static class CannotChargeCardForOverspendException extends BalanceException {
		private static final long serialVersionUID = 1L;
		private BigDecimal overspend;

		CannotChargeCardForOverspendException(final String message, final BigDecimal overspend) {
			super(message);
			this.overspend = overspend;
		}

		BigDecimal getOverspend() {
			return this.overspend;
		}

		@Override
		public String toString() {
			return super.toString() + " { overspend: " + this.getOverspend() + " }";
		}
	}
	
	private static final Logger LOGGER = Logger.getLogger(Balance.class.getName());
	
	/*
	 * TODO Refactor to use MonetaryAmount instead of BigDecimal for the parts. 
	 */
	

	/** The amount of balance you get "free" each cycle (Plan Renewal Period) */
	private BigDecimal freeBalance;
	// /** The amount overspilled - overspent from free balance and special-credit */
	// private BigDecimal debt;
	/** Any credit given goes here, so it doesn't get used for paying subscriptions */
	private BigDecimal specialCredit;
	/**
	 * This balance implementation will keep a balance here, starting at zero, which will up/down depending on spend. The debt will be dynamically calcualted
	 * from the ((freeBalance + specialCredit) - spent)
	 */
	private BigDecimal spent;

	/** Whether or not the card can be charged for overspill. */
	private boolean cardChargingPermitted;
	/** How much overspill should've been charged onto their payment card (overspend) */
	private BigDecimal chargedCard;

	/** a list of what happened, in order */
	private final List<MonetaryAmountTransaction> transactions;

	/**
	 * Constructs a new Zeroed Balance.
	 */
	public Balance() {
		this.freeBalance = CurrencyHelp.ZERO_CASH_STYLE;
		this.specialCredit = CurrencyHelp.ZERO_CASH_STYLE;
		this.spent = CurrencyHelp.ZERO_CASH_STYLE;
		this.chargedCard = CurrencyHelp.ZERO_CASH_STYLE;
		this.transactions = new ArrayList<MonetaryAmountTransaction>();
		this.permitCardCharging();
	}

	/**
	 * Spend the specified amount, using any credit balances.
	 * 
	 * @param amountRaw
	 *            the amount to spend.
	 */
	public void spendThroughCredit(final BigDecimal amountRaw) {
		LOGGER.log(Level.INFO, "balance before spend: " + this);
//		final BigDecimal amount = amountRaw.setScale(CurrencyHelp.CURRENCY_SCALE); // get in currency terms
		final BigDecimal amount = CurrencyHelp.currencyAmountOf(amountRaw); // get in currency terms
		final MonetaryAmountTransaction trans = new MonetaryAmountTransaction(TransType.SPEND_CREDIT_USE_PERMITTED, amount);
		this.transactions.add(trans);

		// update spent...
		/*
		 * if free balance > 0, then get deduct amount from it, then see if went below zero - if it did, then add the positive-version of that negative amount
		 * to: chargedCard. add the whole amount to spent.
		 */
//		this.spent = this.spent.setScale(CurrencyHelp.CURRENCY_SCALE); // make sure is scale of 2 before doing anything, don't forget returns updated or new obj
		this.spent = CurrencyHelp.currencyAmountOf(this.spent); // make sure is scale of 2 before doing anything, don't forget returns updated or new obj
		this.spent = this.spent.add(amount);

		// try specialCredit first...
		final BigDecimal amountLeftAfterSpecialCredit;

		if (hasSpecialCredit()) {
			// has some special credit, so let's spend that first...
			final BigDecimal specialCreditStage = this.specialCredit.subtract(amount);

			// if it's zero, then we spent exact amount, so that is that...
			if (specialCreditStage.compareTo(BigDecimal.ZERO) == 0) {
				// so we spend exact amount, let's double-check that's correct...
				if (this.specialCredit.compareTo(amount) != 0) {
					throw new IllegalStateException("The specialCreditStage was zero after deducting amount: " + amount
							+ ", but the specialCredit before the transaction (" + this.specialCredit + ") didn't equal the amount being spent!");
				}
				// if here, then we spent it exactly, so let's assign it, and clear the amountLeftAfterSpecialCredit.
				this.setSpecialCredit(specialCreditStage);
				amountLeftAfterSpecialCredit = CurrencyHelp.ZERO_CASH_STYLE;
				return;
			}

			// if it's negative, then we should set the amountLeftAfterSpecialCredit to be as positive version of that
			if (specialCreditStage.compareTo(BigDecimal.ZERO) < 0) {
				// less than zero, so set specialCredit to zero, and take negative amount and set amountLeftAfterSpecialCredit to that.
				this.setSpecialCredit(CurrencyHelp.ZERO_CASH_STYLE);
				amountLeftAfterSpecialCredit = specialCreditStage.negate();
			} else {
				// otherwise, must have not spent all specialCredit.
				// therefore: set specialCredit to stage
				this.setSpecialCredit(specialCreditStage);
				amountLeftAfterSpecialCredit = BigDecimal.ZERO;
				return;
			}
		} else {
			// has no special credit...
			amountLeftAfterSpecialCredit = amount;
		}

		// figure out how it affects freeBalance, if any charging is required...
		final BigDecimal freeBalanceStage = this.freeBalance.subtract(amountLeftAfterSpecialCredit);
		if (freeBalanceStage.compareTo(BigDecimal.ZERO) < 0) {
			// for Atomic behaviour, we need to see if can charge card, and by the amount we want, before we deduct anything from the balance.
			// less than zero, so set freeBalance to zero, and take negative amount and add that to charged.
			this.freeBalance = CurrencyHelp.ZERO_CASH_STYLE;
			final BigDecimal overspend = freeBalanceStage.negate();

			chargeCardIfPermitted(overspend);
		} else {
			// otherwise, the freeBalance was zero or above, so let's just use the staged value...
			this.freeBalance = freeBalanceStage;
		}
	}

	/**
	 * Charges the card if card-charging is permitted ({@link #isCardChargingPermitted()}).
	 * 
	 * @see #isCardChargingPermitted()
	 * @see #forbidCardCharging()
	 * @see #permitCardCharging()
	 * 
	 * @param overspend
	 *            the amount to charge for.
	 * @throws #{@link CannotChargeCardForOverspendException} if card cannot be charged.
	 */
	private void chargeCardIfPermitted(final BigDecimal overspend) {
		// TODO we also need to be able to check if the CreditCard has expired, or is even present (perhaps deleted in some test cases)!
		if (!isCardChargingPermitted()) {
			// TODO at some point, we might change this to be switchable - so permit debt or not when charging not permitted.
			throw new CannotChargeCardForOverspendException("Cannot charge card for: " + overspend + " : Card charging not permitted.", overspend);
		}
//		this.chargedCard = this.chargedCard.setScale(CurrencyHelp.CURRENCY_SCALE);
		this.chargedCard = CurrencyHelp.currencyAmountOf(this.chargedCard);
		this.chargedCard = this.chargedCard.add(overspend);
	}

	/**
	 * Indicates if charging a card is permitted.
	 * 
	 * @see #forbidCardCharging()
	 * @see #permitCardCharging()
	 * 
	 * @return true if so, false otherwise.
	 */
	public boolean isCardChargingPermitted() {
		return this.cardChargingPermitted;
	}

	/**
	 * Indicates if special-credit is present.
	 * 
	 * @see #getSpecialCredit()
	 * @see #grantSpecialCredit(BigDecimal)
	 * 
	 * @return true if so, false otherwise.
	 */
	public boolean hasSpecialCredit() {
		return this.getSpecialCredit().compareTo(BigDecimal.ZERO) > 0;
	}

	/**
	 * Grant the additional "special-credit" to the User. Used for Lead Credits, etc.
	 * 
	 * Beware the VAT issue with this! Maybe use {@link #grantGoodwill(GoodwillGrant)} instead, as that makes it clear whether you have added VAT already to the
	 * amount or not.
	 * 
	 * @see #grantGoodwill(GoodwillGrant)
	 * 
	 * @param amount
	 *            the amount of "special-credit" to add.
	 */
	public void grantSpecialCredit(final BigDecimal amount) {
//		this.specialCredit = this.specialCredit.setScale(CurrencyHelp.CURRENCY_SCALE);
		this.specialCredit = CurrencyHelp.currencyAmountOf(this.specialCredit);
		this.specialCredit = this.specialCredit.add(amount);
	}
	
	public void grantGoodwill(final GoodwillGrant grant) {
//		this.specialCredit = this.specialCredit.setScale(CurrencyHelp.CURRENCY_SCALE);
		this.specialCredit = CurrencyHelp.currencyAmountOf(this.specialCredit);
		this.specialCredit = this.specialCredit.add(grant.getAmountWithVat());
	}

	public BigDecimal getFreeBalance() {
		return this.freeBalance;
	}

	public BigDecimal getSpecialCredit() {
		return this.specialCredit;
	}
	
	public BigDecimal getOverallBalance() {
		final BigDecimal accountBalance = this.getSpecialCredit().add(this.getFreeBalance()); // TODO .subtract(this.debt)
		return accountBalance;
	}

	/**
	 * Running total of amount spent.
	 * 
	 * @return running total of amount spent.
	 */
	public BigDecimal getSpent() {
		return this.spent;
	}

	/**
	 * Returns the amount the card was charged.
	 * 
	 * @return amount card has been charged.
	 */
	public BigDecimal getChargedCard() {
		return this.chargedCard;
	}

	/**
	 * @deprecated encapsulate/protect more from outsiders
	 * @param freeBalance
	 */
	@Deprecated
	public void setFreeBalance(final BigDecimal freeBalance) {
		this.freeBalance = freeBalance;
	}

	private void setSpecialCredit(final BigDecimal specialCredit) {
		this.specialCredit = specialCredit;
	}

	public List<MonetaryAmountTransaction> getTransactions() {
		return this.transactions;
	}

	/**
	 * Builds a new {@link Balance} with the specified freeBalance in place.
	 * 
	 * @param freeBalanceToGive
	 *            the amount of "free-balance" to grant.
	 * @return the new {@link Balance} object.
	 */
	public static Balance withFreeBalance(final BigDecimal freeBalanceToGive) {
		final Balance balance = new Balance();
//		final TaxableAmount amount = new TaxableAmount(freeBalanceToGive);
//		balance.setFreeBalance(amount.getAmountWithVat());
		// TODO come back to this - we want an amount object which has VAT or not clear.
		balance.setFreeBalance(freeBalanceToGive);
		return balance;
	}

	/**
	 * Builds a new {@link Balance} with the specified "special-credit" in place.
	 * 
	 * @param specialCredit
	 *            the amount of "special-credit" to grant.
	 * @return the new {@link Balance} object.
	 */
	public static Balance withSpecialCredit(final BigDecimal specialCredit) {
		final Balance balance = new Balance();
		balance.setSpecialCredit(specialCredit);
		return balance;
	}

	/**
	 * Forbids charging the card.
	 * 
	 * @see #permitCardCharging()
	 * @see #isCardChargingPermitted()
	 */
	public void forbidCardCharging() {
		this.cardChargingPermitted = false;
	}

	/**
	 * Permits charging the card.
	 * 
	 * @see #forbidCardCharging()
	 * @see #isCardChargingPermitted()
	 */
	public void permitCardCharging() {
		this.cardChargingPermitted = true;
	}

	public String getFreeBalanceCurrencyString() {
//		final String cost = getFreeBalance().toPlainString();
//		final String currencyLedCost = CurrencyHelp.CURRENCY_SYMBOL + cost;
		final String currencyLedCost = CurrencyHelp.asCashString(getFreeBalance());
		return currencyLedCost;
	}
	
	public String getOverallBalanceCurrencyString() {
//		final String amount = getOverallBalance().toPlainString();
//		final String currencyLedAmount = CurrencyHelp.CURRENCY_SYMBOL + amount;
		final String currencyLedAmount = CurrencyHelp.asCashString(getOverallBalance());
		return currencyLedAmount;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


}