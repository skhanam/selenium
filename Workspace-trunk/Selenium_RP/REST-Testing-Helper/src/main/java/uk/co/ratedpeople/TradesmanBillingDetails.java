package uk.co.ratedpeople;

public class TradesmanBillingDetails {

	private String name;
	private String cardNumber;
	private MonthYear expiryDate;
	private Integer cv2Number;
	private DetailedAddress billingAddress;
	private String planType;
	private String purchaseOrderId;
	private ThreeDResponse threeDResponse;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public Integer getCv2Number() {
		return cv2Number;
	}

	public void setCv2Number(Integer cv2Number) {
		this.cv2Number = cv2Number;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public MonthYear getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(MonthYear expiryDate) {
		this.expiryDate = expiryDate;
	}

	public DetailedAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(DetailedAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(String purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public ThreeDResponse getThreeDResponse() {
		return threeDResponse;
	}

	public void setThreeDResponse(ThreeDResponse threeDResponse) {
		this.threeDResponse = threeDResponse;
	}

	public static class MonthYear {
		private int month;
		private int year;
		
		public MonthYear(final int month, final int year) {
			this.setMonth(month);
			this.setYear(year);				
		}
		
		public int getMonth() {
			return month;
		}
		public void setMonth(final int month) {
			this.month = month;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
	}
}
