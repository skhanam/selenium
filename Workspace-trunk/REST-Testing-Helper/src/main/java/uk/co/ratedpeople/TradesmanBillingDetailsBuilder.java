package uk.co.ratedpeople;

import uk.co.ratedpeople.TradesmanBillingDetails.MonthYear;

public class TradesmanBillingDetailsBuilder {

	public static TradesmanBillingDetails build(String name, String cardNumber, MonthYear expiryDate, Integer cv2Number, 
			DetailedAddress billingAddress,String planType, String purchaseOrderId, ThreeDResponse threeDResponse) {
		TradesmanBillingDetails obj = new TradesmanBillingDetails();
		obj.setBillingAddress(billingAddress);
		obj.setCardNumber(cardNumber);
		obj.setCv2Number(cv2Number);
		obj.setExpiryDate(expiryDate);
		obj.setName(name);
		obj.setPlanType(planType);
		obj.setPurchaseOrderId(purchaseOrderId);
		obj.setThreeDResponse(threeDResponse);
		return obj;
	}
}

