//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.10 at 09:50:27 AM BST 
//


package net.opengis.gml._3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="inverseFlattening" type="{http://www.opengis.net/gml/3.2}MeasureType"/>
 *         &lt;element name="semiMinorAxis" type="{http://www.opengis.net/gml/3.2}LengthType"/>
 *         &lt;element name="isSphere" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "inverseFlattening",
    "semiMinorAxis",
    "isSphere"
})
@XmlRootElement(name = "SecondDefiningParameter_GL")
public class SecondDefiningParameterGL {

    protected MeasureType inverseFlattening;
    protected LengthType semiMinorAxis;
    @XmlElement(defaultValue = "true")
    protected java.lang.Boolean isSphere;

    /**
     * Gets the value of the inverseFlattening property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getInverseFlattening() {
        return inverseFlattening;
    }

    /**
     * Sets the value of the inverseFlattening property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setInverseFlattening(MeasureType value) {
        this.inverseFlattening = value;
    }

    /**
     * Gets the value of the semiMinorAxis property.
     * 
     * @return
     *     possible object is
     *     {@link LengthType }
     *     
     */
    public LengthType getSemiMinorAxis() {
        return semiMinorAxis;
    }

    /**
     * Sets the value of the semiMinorAxis property.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthType }
     *     
     */
    public void setSemiMinorAxis(LengthType value) {
        this.semiMinorAxis = value;
    }

    /**
     * Gets the value of the isSphere property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.Boolean }
     *     
     */
    public java.lang.Boolean isIsSphere() {
        return isSphere;
    }

    /**
     * Sets the value of the isSphere property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.Boolean }
     *     
     */
    public void setIsSphere(java.lang.Boolean value) {
        this.isSphere = value;
    }

}
