package uk.co.ratedpeople;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Place holder for all kind of reference data.
 *
 * @author zsolt
 */
@XmlRootElement(name = "referenceData")
@XmlAccessorType(XmlAccessType.NONE)
public class ReferenceData {

    /** The unique identifier of the reference data. */
	@XmlID
	private String id = null;

    /** The display name of the reference data. */
	@XmlElement(required = true)
	private String name = null;

    /** The order of the data in the list. */
    @XmlElement(required = true)
    private int order;

    /** Set of possible tips. */
    @XmlElementWrapper(name = "tips")
	@XmlElement(name = "tip")
	Set<String> tips = null;

	public ReferenceData() {
	}

	public ReferenceData(String id, String name, int order, Set<String> tips) {
		this.id = id;
		this.name = name;
        this.order = order;
		this.tips = tips;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setTips(Set<String> tips) {
		this.tips = tips;
	}

	public Set<String> getTips() {
		return tips;
	}

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + order;
		result = prime * result + ((tips == null) ? 0 : tips.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReferenceData other = (ReferenceData) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (order != other.order)
			return false;
		if (tips == null) {
			if (other.tips != null)
				return false;
		} else if (!tips.equals(other.tips))
			return false;
		return true;
	}

}