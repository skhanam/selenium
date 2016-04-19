package uk.co.ratedpeople;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * User information valid for any type of user. This bean is designed to pass
 * information about the user between the facade layer and callers of the facade
 * layer.
 * 
 * User objects must be {@link Serializable} as they are stored in session by
 * TP-APP.
 * 
 * @author christina.fisher
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
@XmlType(namespace = "http://ratedpeople.com/1.0/user", name = "user")
public class User implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -7007437073050180153L;

	@XmlElement(required = true)
	private int id;

	@XmlElement(name = "accessType")
	private Set<AccessType> accessTypes = new HashSet<AccessType>();

	@XmlElement
	private Status status;

	private SalutationType title;

	@XmlElement(name = "firstName")
	private String firstName;

	@XmlElement(name = "lastName")
	private String lastName;

	@XmlElement(name = "contactName", required = false)
	private String contactName;

	@XmlElement(name = "accountBalance", required = false)
	private BigDecimal accountBalance;

	@XmlElement(name = "isJbillingUser", required = true)
	private boolean isJbillingUser;

	@XmlElement(name = "lastLogin", required = false)
	private Date lastLogin;

	@XmlElement(name = "redirectUrl", required = false)
	private String redirectUrl;

	@XmlElement(name = "isDiyExpert", required = true)
	private boolean diyExpert;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<AccessType> getAccessTypes() {
		return accessTypes;
	}

	public void setAccessTypes(Set<AccessType> accessType) {
		this.accessTypes = accessType;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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

	public SalutationType getTitle() {
		return title;
	}

	public void setTitle(SalutationType title) {
		this.title = title;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public boolean isJbillingUser() {
		return isJbillingUser;
	}

	public void setJbillingUser(boolean isJbillingUser) {
		this.isJbillingUser = isJbillingUser;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public boolean isDiyExpert() {
		return this.diyExpert;
	}

	public void setDiyExpert(final boolean isDiyExpert) {
		this.diyExpert = isDiyExpert;
	}

	@XmlEnum
	@XmlType(namespace = "http://ratedpeople.com/1.0/user")
	public enum AccessType {
		@XmlEnumValue("HOMEOWNER")
		HOMEOWNER, @XmlEnumValue("TRADESMAN")
		TRADESMAN, @XmlEnumValue("AGENT")
		AGENT
	}

	@XmlEnum
	@XmlType(namespace = "http://ratedpeople.com/1.0/user")
	public enum Status {
		@XmlEnumValue("PENDING_ACTIVATION")
		PENDING_ACTIVATION, @XmlEnumValue("ACTIVE")
		ACTIVE, @XmlEnumValue("NOT_ACTIVE")
		NOT_ACTIVE
	}

	@XmlEnum
	@XmlType(namespace = "http://ratedpeople.com/1.0/user")
	public enum SalutationType {
		@XmlEnumValue(" ")
		NONE(" "), @XmlEnumValue("Mr")
		MR("Mr"), @XmlEnumValue("Miss")
		MISS("Miss"), @XmlEnumValue("Mrs")
		MRS("Mrs"), @XmlEnumValue("Ms")
		MS("Ms"), @XmlEnumValue("Dr")
		DR("Dr"), @XmlEnumValue("Prof")
		PROF("Prof");

		private String value;

		SalutationType(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
}
