package uk.co.ratedpeople;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import uk.co.ratedpeople.ReferenceData;
/**
 * Container to wrap list of objects, it's used when returning a list a of things.
 *
 * @author zsolt
 */
@XmlRootElement(name = "collection")
@XmlAccessorType(XmlAccessType.NONE)
public class Collection<T> {

    @XmlElements(
        {@XmlElement(name="referenceData", type = ReferenceData.class)}
    )   
    private List<T> entries = null;

    public List<T> getEntries() {
        return entries;
    }

    public void setEntries(List<T> entries) {
        this.entries = entries;
    }
    
}