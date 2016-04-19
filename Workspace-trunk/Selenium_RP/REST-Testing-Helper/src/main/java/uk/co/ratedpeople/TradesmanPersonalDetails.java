package uk.co.ratedpeople;

public class TradesmanPersonalDetails {

	private Integer salutationTypeId;
	private String firstName;
	private String lastName;
	private String password;
	private String confirmPassword;
	private Integer businessRoleTypeId;
	
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
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public Integer getBusinessRoleTypeId() {
		return businessRoleTypeId;
	}
	
	public void setBusinessRoleTypeId(Integer businessRoleTypeId) {
		this.businessRoleTypeId = businessRoleTypeId;
	}
}
