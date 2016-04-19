package uk.co.ratedpeople;


public class TradesmanBusinessDetailsBuilder {

	public static TradesmanBusinessDetails build(Integer businessTypeId, String contactName, String companyName, Integer employeeCountTypeId,
			String companyNumber, String vatNumber, String mobileNumber, String landlineNumber, Integer maxDistance, DetailedAddress businessAddress,
			Boolean marketingOptIn, Integer leadSourceId) {
		TradesmanBusinessDetails obj = new TradesmanBusinessDetails();
		obj.setBusinessAddress(businessAddress);
		obj.setBusinessTypeId(businessTypeId);
		obj.setCompanyName(companyName);
		obj.setContactName(contactName);
		obj.setCompanyNumber(companyNumber);
		obj.setEmployeeCountTypeId(employeeCountTypeId);
		obj.setLandlineNumber(landlineNumber);
		obj.setMarketingOptIn(marketingOptIn);
		obj.setMaxDistance(maxDistance);
		obj.setMobileNumber(mobileNumber);
		obj.setVatNumber(vatNumber);
		obj.setLeadSourceId(leadSourceId);
		return obj;
	}
}
