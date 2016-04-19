package uk.co.ratedpeople;


public class TradesmanScreeningDetails {
	
	private String documentType;
	private String ipAddress;
	private Integer screeningRetryCount;
	private Integer salutationTypeId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dateOfBirth;
	private Passport passport;
	private UKDrivingLicence ukDrivingLicence;
	private DetailedAddress personalAddress;
	
	public String getDocumentType() {
		return documentType;
	}
	
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	
	public String getIpAddress() {
		return ipAddress;
	}
	
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public Integer getScreeningRetryCount() {
		return screeningRetryCount;
	}
	
	public void setScreeningRetryCount(Integer screeningRetryCount) {
		this.screeningRetryCount = screeningRetryCount;
	}
	
	public Integer getSalutationTypeId() {
		return salutationTypeId;
	}
	
	public void setSalutationTypeId(Integer salutationTypeId) {
		this.salutationTypeId = salutationTypeId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public Passport getPassport() {
		return passport;
	}
	
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	public UKDrivingLicence getUkDrivingLicence() {
		return ukDrivingLicence;
	}
	
	public void setUkDrivingLicence(UKDrivingLicence ukDrivingLicence) {
		this.ukDrivingLicence = ukDrivingLicence;
	}
	
	public DetailedAddress getPersonalAddress() {
		return personalAddress;
	}
	
	public void setPersonalAddress(DetailedAddress personalAddress) {
		this.personalAddress = personalAddress;
	}
}
