package uk.co.ratedpeople;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;


/**
 * Model holding the error information to be sent back to the partner.
 * 
 * @author zsolt
 */
@XmlRootElement(name = "error")
@XmlAccessorType(XmlAccessType.NONE)
public class ResponseError {

	@XmlElement(required = true)
	private String code = null;

	@XmlElement(required = false)
	private String message = null;

	@XmlElement(required = false)
	private String fieldName = null;

	@XmlElement(required = false)
	private String fieldValue = null;

	@XmlElement(required = false)
	private String displayMessage = null;

	public ResponseError() {
	}

	public ResponseError(final String code) {
		this.code = code;
		this.message = code;
	}

	public ResponseError(final String code, final String message) {
		this.code = code;
		this.message = message;
	}

	public ResponseError(final ErrorCode errorCode, final String message) {
		this.validate(errorCode);
		this.code = errorCode.getName();
		this.message = message;
	}

	private void validate(final ErrorCode errorCode) {
		if (errorCode == null) {
			throw new IllegalArgumentException("Cannot create Error with null ErrorCodes object");
		}
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(final String code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getDisplayMessage() {
		return displayMessage;
	}

	public void setDisplayMessage(String displayMessage) {
		this.displayMessage = displayMessage;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
		result = prime * result + ((this.message == null) ? 0 : this.message.hashCode());
		result = prime * result + ((this.fieldName == null) ? 0 : this.fieldName.hashCode());
		result = prime * result + ((this.fieldValue == null) ? 0 : this.fieldValue.hashCode());
		result = prime * result + ((this.displayMessage == null) ? 0 : this.displayMessage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseError other = (ResponseError) obj;
		if (this.code == null) {
			if (other.code != null)
				return false;
		} else if (!this.code.equals(other.code))
			return false;
		if (this.message == null) {
			if (other.message != null)
				return false;
		} else if (!this.message.equals(other.message))
			return false;
		if (this.fieldName == null) {
			if (other.fieldName != null)
				return false;
		} else if (!this.fieldName.equals(other.fieldName))
			return false;
		if (this.fieldValue == null) {
			if (other.fieldValue != null)
				return false;
		} else if (!this.fieldValue.equals(other.fieldValue))
			return false;
		if (this.displayMessage == null) {
			if (other.displayMessage != null)
				return false;
		} else if (!this.displayMessage.equals(other.displayMessage))
			return false;
		return true;
	}

}
