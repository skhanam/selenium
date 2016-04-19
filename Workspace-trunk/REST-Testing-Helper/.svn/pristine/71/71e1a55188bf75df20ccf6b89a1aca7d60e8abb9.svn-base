package uk.co.ratedpeople;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;


/**
 * Container for a set of errors.
 * 
 * @author zsolt
 */
@XmlRootElement(name = "errors")
@XmlType(namespace = "http://ratedpeople.com/1.0", name = "errors")
@XmlAccessorType(XmlAccessType.NONE)
public class Errors {

	@XmlElement(required = true)
	private String resource = null;

	@XmlElement(required = false)
	private String requestId = null;

	@XmlElements({ @XmlElement(name = "error", type = ResponseError.class) })
	Set<ResponseError> errors = null;

	public Errors() {
		this.errors = new HashSet<ResponseError>();
	}

	public Errors(Set<ResponseError> errors) {
		this.errors = errors;
	}

	public void add(final ResponseError error) {
		this.errors.add(error);
	}

	public void addAll(final List<ResponseError> errorList) {
		this.errors.addAll(errorList);
	}

	public Set<ResponseError> getErrors() {
		return errors;
	}

	public List<ResponseError> getErrorList() {
		List<ResponseError> errorList = new ArrayList<ResponseError>();
		Iterator<ResponseError> iterator = errors.iterator();
		while (iterator.hasNext()) {
			ResponseError responseError = iterator.next();
			errorList.add(responseError);
		}
		return errorList;
	}

	public void setErrors(Set<ResponseError> errors) {
		this.errors = errors;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public boolean isEmpty() {
		if (this.errors == null)
			return true;
		return this.errors.isEmpty();
	}

	public Iterator<ResponseError> iterator() {
		return this.errors.iterator();
	}

	public ResponseError getFirst() {
		return iterator().next();
	}

	public boolean contains(final ErrorCode errorCode) {
		if (errorCode == null) {
			return false;
		}
		for (final ResponseError error : this.errors) {
			if (error == null) {
				continue;
			}
			final ErrorCode codeOfCurrentError = new ErrorCode(error.getCode());
			if (errorCode.equals(codeOfCurrentError)) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(final ErrorCode errorCode, final String message) {
		if (errorCode == null) {
			return false;
		}
		for (final ResponseError error : this.errors) {
			if (error == null) {
				continue;
			}
			final ErrorCode codeOfCurrentError = new ErrorCode(error.getCode());
			if (errorCode.equals(codeOfCurrentError) && message.equals(error.getMessage())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.errors == null) ? 0 : this.errors.hashCode());
		result = prime * result + ((this.requestId == null) ? 0 : this.requestId.hashCode());
		result = prime * result + ((this.resource == null) ? 0 : this.resource.hashCode());
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
		Errors other = (Errors) obj;
		if (this.errors == null) {
			if (other.errors != null)
				return false;
		} else if (!this.errors.equals(other.errors))
			return false;
		if (this.requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!this.requestId.equals(other.requestId))
			return false;
		if (this.resource == null) {
			if (other.resource != null)
				return false;
		} else if (!this.resource.equals(other.resource))
			return false;
		return true;
	}

}
