package uk.co.ratedpeople;


public class UKDrivingLicenceDetailsBuilder {

	public static UKDrivingLicence build(String number1, String number2, String number3, String number4) {
		UKDrivingLicence obj = new UKDrivingLicence();
		obj.setNumber1(number1);
		obj.setNumber2(number2);
		obj.setNumber3(number3);
		obj.setNumber4(number4);
		return obj;
	}
}

