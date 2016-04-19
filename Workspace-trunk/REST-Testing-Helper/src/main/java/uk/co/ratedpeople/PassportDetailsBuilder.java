package uk.co.ratedpeople;


public class PassportDetailsBuilder {

	public static Passport build(String countryOfOrigin, String expiryDate, String number1, String number2, String number3,
			String number4, String number5, String number6, String number7, String number8, String number9) {
		Passport obj = new Passport();
		obj.setCountryOfOrigin(countryOfOrigin);		
		obj.setExpiryDate(expiryDate);
		obj.setNumber1(number1);
		obj.setNumber2(number2);
		obj.setNumber3(number3);
		obj.setNumber4(number4);
		obj.setNumber5(number5);
		obj.setNumber6(number6);
		obj.setNumber7(number7);
		obj.setNumber8(number8);
		obj.setNumber9(number9);
		return obj;
	}
}

