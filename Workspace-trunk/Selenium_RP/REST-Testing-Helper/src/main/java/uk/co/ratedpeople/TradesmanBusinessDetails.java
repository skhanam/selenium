package uk.co.ratedpeople;

public class TradesmanBusinessDetails {

	private Integer businessTypeId;
	private String contactName;
	private String companyName;
	private Integer employeeCountTypeId;
	private String companyNumber;
	private String vatNumber;
	private String mobileNumber;
	private String landlineNumber;
	private Integer maxDistance;
	private DetailedAddress businessAddress;
	private Boolean marketingOptIn;
	private Integer leadSourceId;
	
	public Integer getBusinessTypeId() {
		return businessTypeId;
	}
	
	public void setBusinessTypeId(Integer businessTypeId) {
		this.businessTypeId = businessTypeId;
	}
	
	public String getContactName() {
		return contactName;
	}
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public Integer getEmployeeCountTypeId() {
		return employeeCountTypeId;
	}
	
	public void setEmployeeCountTypeId(Integer employeeCountTypeId) {
		this.employeeCountTypeId = employeeCountTypeId;
	}
	
	public String getCompanyNumber() {
		return companyNumber;
	}
	
	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}
	
	public String getVatNumber() {
		return vatNumber;
	}
	
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getLandlineNumber() {
		return landlineNumber;
	}
	
	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}
	
	public Integer getMaxDistance() {
		return maxDistance;
	}
	
	public void setMaxDistance(Integer maxDistance) {
		this.maxDistance = maxDistance;
	}
	
	public DetailedAddress getBusinessAddress() {
		return businessAddress;
	}
	
	public void setBusinessAddress(DetailedAddress businessAddress) {
		this.businessAddress = businessAddress;
	}
	
	public Boolean getMarketingOptIn() {
		return marketingOptIn;
	}
	
	public void setMarketingOptIn(Boolean marketingOptIn) {
		this.marketingOptIn = marketingOptIn;
	}

	public Integer getLeadSourceId() {
		return leadSourceId;
	}

	public void setLeadSourceId(Integer leadSourceId) {
		this.leadSourceId = leadSourceId;
	}
}
