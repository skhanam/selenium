package uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression;

import uk.co.ratedpeople.test.functional.selenium.jbilling.suite.regression.money.TaxableAmount;

/**
 * Until we read prices from the API for specific TMs, then we'll just assume we know all the prices in the Tests.
 */
public class JobPriceDetail {
	private final String descInTestOnly;
	private final String postcode;
	private final TaxableAmount basePrice;

	public JobPriceDetail(final String descInTestOnly, final String postcode, final TaxableAmount priceWithoutVat) {
		this.descInTestOnly = descInTestOnly;
		this.postcode = postcode;
		this.basePrice = priceWithoutVat;
	}

	public String getDescInTestOnly() {
		return this.descInTestOnly;
	}
	
	public String getPostcode() {
		return this.postcode;
	}

	public TaxableAmount getBasePrice() {
		return this.basePrice;
	}
}