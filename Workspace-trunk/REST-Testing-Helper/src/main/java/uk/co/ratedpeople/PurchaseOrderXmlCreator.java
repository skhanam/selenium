package uk.co.ratedpeople;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import uk.co.ratedpeople.CreditCardTestData.CreditCard;

/**
 * 
 * Creates XML representation for Purchase Order, including the credit card
 * 
 */
public class PurchaseOrderXmlCreator {

	public String makePurchaseOrderXml() {
		return makePurchaseOrderXml(null);
	}
	
	public String makePurchaseOrderXml(CreditCard cc) {
		StringBuilder builder = new StringBuilder();
		builder.append("<purchaseorder>");
		if (cc != null) {
			appendCreditCardXml(builder, cc);
		}
		builder.append("</purchaseorder>");
		return builder.toString();
	}
	
	public String makePurchaseOrderXmlWithThreeDResponse(Map<String, String> threeDResponse) {
		StringBuilder builder = new StringBuilder();
		builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		builder.append("<purchaseorder>");
		if (threeDResponse != null) {
			builder.append("<threedresponse>");
			builder.append("<md>");
			builder.append(threeDResponse.get("MD"));
			builder.append("</md>");
			builder.append("<mdx>");
			builder.append(threeDResponse.get("MDX"));			
			builder.append("</mdx>");
			builder.append("<pares>");
			builder.append(threeDResponse.get("PaRes"));			
			builder.append("</pares>");
			builder.append("</threedresponse>");
		}
		builder.append("</purchaseorder>");
		return builder.toString();
	}

	public String makeCreditCardXml(CreditCard cc) {
		StringBuilder builder = new StringBuilder();
		appendCreditCardXml(builder, cc);
		return builder.toString();
	}

	/**
	 * append xml for cc to the given string builder
	 * 
	 * @param builder
	 * @param cc
	 */
	public void appendCreditCardXml(StringBuilder builder, CreditCard cc) {
		builder.append("<creditcard>");

		builder.append("<cardnumber>");
		builder.append(cc.getCardNumber());
		builder.append("</cardnumber>");

		builder.append("<type>");
		builder.append(cc.getCode());
		builder.append("</type>");

		builder.append("<startdate><month>");
		builder.append(cc.getStartMonth());
		builder.append("</month><year>");
		builder.append(cc.getStartYear());
		builder.append("</year></startdate>");

		builder.append("<expirydate><month>");
		builder.append(cc.getEndMonth());
		builder.append("</month><year>");
		builder.append(cc.getEndYear());
		builder.append("</year></expirydate>");

		if (!StringUtils.isEmpty(cc.getIssueNumber())) {
			builder.append("<issuenumber>");
			builder.append(cc.getIssueNumber());
			builder.append("</issuenumber>");
		}

		builder.append("<cv2>");
		builder.append(cc.getCV2());
		builder.append("</cv2>");

		builder.append("<name>");
		builder.append(cc.getName());
		builder.append("</name>");

		builder.append("<address>");
		builder.append(cc.getBillingAddress());
		builder.append("</address>");

		builder.append("<postcode>");
		builder.append(cc.getBillingPostcode());
		builder.append("</postcode>");

		builder.append("</creditcard>");
	}
}
