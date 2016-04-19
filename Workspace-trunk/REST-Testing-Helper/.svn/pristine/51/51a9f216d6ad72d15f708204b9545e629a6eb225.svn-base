package uk.co.ratedpeople;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Represents a user.
 *
 * @author zsolt
 */
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.NONE)
public class RestDomainXMLBeanUser {

	@XmlID()
	private String id = null;

	@XmlElement(required = true)
	private String salutationId = null;

	@XmlElement(required = true)
	private String firstName = null;

	@XmlElement(required = true)
	private String lastName = null;

	@XmlElement(required = true)
	private String email = null;

	@XmlElement(required = true)
	private String mobilePhone = null;

	@Deprecated
	@XmlElement(required = false)
	private String userAvailabilityId = null;

	@XmlElement()
	private boolean subscribedToNewsletter = false;

	@XmlElement()
	private String password = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getSalutationId() {
		return salutationId;
	}

	public void setSalutationId(String salutationId) {
		this.salutationId = salutationId;
	}

	public boolean isSubscribedToNewsletter() {
		return subscribedToNewsletter;
	}

	public void setSubscribedToNewsletter(boolean subscribedToNewsletter) {
		this.subscribedToNewsletter = subscribedToNewsletter;
	}

	@Deprecated
	public String getUserAvailabilityId() {
		return userAvailabilityId;
	}

	@Deprecated
	public void setUserAvailabilityId(String userAvailabilityId) {
		this.userAvailabilityId = userAvailabilityId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
