//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.10 at 09:50:27 AM BST 
//


package aero.aixm.schema._5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchRescueServiceTimeSlicePropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchRescueServiceTimeSlicePropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.aixm.aero/schema/5.1}SearchRescueServiceTimeSlice"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opengis.net/gml/3.2}OwnershipAttributeGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchRescueServiceTimeSlicePropertyType", propOrder = {
    "searchRescueServiceTimeSlice"
})
public class SearchRescueServiceTimeSlicePropertyType {

    @XmlElement(name = "SearchRescueServiceTimeSlice", required = true)
    protected SearchRescueServiceTimeSliceType searchRescueServiceTimeSlice;
    @XmlAttribute(name = "owns")
    protected Boolean owns;

    /**
     * Gets the value of the searchRescueServiceTimeSlice property.
     * 
     * @return
     *     possible object is
     *     {@link SearchRescueServiceTimeSliceType }
     *     
     */
    public SearchRescueServiceTimeSliceType getSearchRescueServiceTimeSlice() {
        return searchRescueServiceTimeSlice;
    }

    /**
     * Sets the value of the searchRescueServiceTimeSlice property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchRescueServiceTimeSliceType }
     *     
     */
    public void setSearchRescueServiceTimeSlice(SearchRescueServiceTimeSliceType value) {
        this.searchRescueServiceTimeSlice = value;
    }

    /**
     * Gets the value of the owns property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isOwns() {
        if (owns == null) {
            return false;
        } else {
            return owns;
        }
    }

    /**
     * Sets the value of the owns property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOwns(Boolean value) {
        this.owns = value;
    }

}
