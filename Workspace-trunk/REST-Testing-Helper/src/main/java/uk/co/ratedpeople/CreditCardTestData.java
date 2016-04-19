package uk.co.ratedpeople;

public class CreditCardTestData {

	public static CreditCard VISA = new CreditCard("VISA", "4929 0000 0000 6"), 
					         MASTER_CARD = new CreditCard("MC", "5404 0000 0000 0001"), 
					        // DELTA = new CreditCard("DELTA", "4462 0000 0000 0003"), 
					        // SOLO = new CreditCard("SOLO", "6334 9000 0000 0005"), // Ouch! SOLO cards don't work on sage test system 
					         MAESTRO_UK = new CreditCard("SWITCH", "5641 8200 0000 0005", "01"), 
					         MAESTRO_INTL = new CreditCard("SWITCH","3000 0000 0000 000004"), 
					       //  AMEX = new CreditCard("AMEX","3742 0000 0000 004"), 					          
					       //  JAPAN_CREDIT_BUREAU = new CreditCard("JCB","3569 9900 0000 0009"), 
					       //  DINERS_CLUB = new CreditCard("DC","3600 0000 0000 08"), 
					       //  LASER_CARDS = new CreditCard("LASER","6304 9900 0000 0000 044"),
					         VISA_ELECTRON = new CreditCard("UKE","4917 3000 0000 0008"),
					         DODGY_VISA = new CreditCard("VISA", "4929 0000 9999 9");
	
	// At present we accept only these card types
	private static CreditCard[] allValidCards = {VISA, MASTER_CARD, MAESTRO_UK, MAESTRO_INTL, VISA_ELECTRON };
	
	// At present agents can only make non-3D payments with following cards
	private static CreditCard[] allNon3DCards = {VISA, MASTER_CARD, VISA_ELECTRON};
	
	public static CreditCard[] getAllValidCards(){
		return allValidCards;
	}
	
	public static CreditCard[] getAllNon3DCards(){
		return allNon3DCards;
	}
	
	public static class CreditCard {
	
		private String code;
		private String cardNumber;
		private String issueNumber;
		private String CV2 = "123";
		private String billingAddress = "88 the Willows";
		private String billingPostcode = "ab41 2de";
		private String startMonth = "1";
		private String startYear = "2010";
		private String endMonth = "12";
		private String endYear = "2030";
		private String name = "Test user";
		
		CreditCard(String code, String cardNumber) {
			this(code, cardNumber, null);
		}
		
		CreditCard(String code, String cardNumber, String issueNumber) {
			this.code = code;
			this.cardNumber = cardNumber;
			this.issueNumber = issueNumber;			
		}

		public String getCode() {
			return this.code;
		}

		public String getCardNumber() {
			return this.cardNumber;
		}

		public String getIssueNumber() {
			return this.issueNumber;
		}

		public String getCV2() {
			return this.CV2;
		}

		public String getBillingAddress() {
			return this.billingAddress;
		}

		public String getBillingPostcode() {
			return this.billingPostcode;
		}

		public String getStartMonth() {
			return this.startMonth;
		}

		public String getStartYear() {
			return this.startYear;
		}

		public String getEndMonth() {
			return this.endMonth;
		}

		public String getEndYear() {
			return this.endYear;
		}			
		
		public String getName() {
			return this.name;
		}
	}
	
	
}
