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
 * <p>Java class for HoldingAssessmentTimeSlicePropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HoldingAssessmentTimeSlicePropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.aixm.aero/schema/5.1}HoldingAssessmentTimeSlice"/>
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
@XmlType(name = "HoldingAssessmentTimeSlicePropertyType", propOrder = {
    "holdingAssessmentTimeSlice"
})
public class HoldingAssessmentTimeSlicePropertyType {

    @XmlElement(name = "HoldingAssessmentTimeSlice", required = true)
    protected HoldingAssessmentTimeSliceType holdingAssessmentTimeSlice;
    @XmlAttribute(name = "owns")
    protected Boolean owns;

    /**
     * Gets the value of the holdingAssessmentTimeSlice property.
     * 
     * @return
     *     possible object is
     *     {@link HoldingAssessmentTimeSliceType }
     *     
     */
    public HoldingAssessmentTimeSliceType getHoldingAssessmentTimeSlice() {
        return holdingAssessmentTimeSlice;
    }

    /**
     * Sets the value of the holdingAssessmentTimeSlice property.
     * 
     * @param value
     *     allowed object is
     *     {@link HoldingAssessmentTimeSliceType }
     *     
     */
    public void setHoldingAssessmentTimeSlice(HoldingAssessmentTimeSliceType value) {
        this.holdingAssessmentTimeSlice = value;
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