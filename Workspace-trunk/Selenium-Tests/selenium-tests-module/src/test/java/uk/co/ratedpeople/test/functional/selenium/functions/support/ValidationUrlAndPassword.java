package uk.co.ratedpeople.test.functional.selenium.functions.support;
public class ValidationUrlAndPassword {
	private String validationUrl;
	private String password;

	public ValidationUrlAndPassword(String validationUrl, String password) {
		this.validationUrl = validationUrl;
		this.password = password;
	}

	public String getValidationUrl() {
		return validationUrl;
	}

	public String getPassword() {
		return password;
	}
}
