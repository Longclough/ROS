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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TimeCoordinateSystemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeCoordinateSystemType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}TimeReferenceSystemType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="originPosition" type="{http://www.opengis.net/gml/3.2}TimePositionType"/>
 *           &lt;element name="origin" type="{http://www.opengis.net/gml/3.2}TimeInstantPropertyType"/>
 *         &lt;/choice>
 *         &lt;element name="interval" type="{http://www.opengis.net/gml/3.2}TimeIntervalLengthType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeCoordinateSystemType", propOrder = {
    "originPosition",
    "origin",
    "interval"
})
public class TimeCoordinateSystemType
    extends TimeReferenceSystemType
{

    protected TimePositionType originPosition;
    protected TimeInstantPropertyType origin;
    @XmlElement(required = true)
    protected TimeIntervalLengthType interval;

    /**
     * Gets the value of the originPosition property.
     * 
     * @return
     *     possible object is
     *     {@link TimePositionType }
     *     
     */
    public TimePositionType getOriginPosition() {
        return originPosition;
    }

    /**
     * Sets the value of the originPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePositionType }
     *     
     */
    public void setOriginPosition(TimePositionType value) {
        this.originPosition = value;
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link TimeInstantPropertyType }
     *     
     */
    public TimeInstantPropertyType getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeInstantPropertyType }
     *     
     */
    public void setOrigin(TimeInstantPropertyType value) {
        this.origin = value;
    }

    /**
     * Gets the value of the interval property.
     * 
     * @return
     *     possible object is
     *     {@link TimeIntervalLengthType }
     *     
     */
    public TimeIntervalLengthType getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeIntervalLengthType }
     *     
     */
    public void setInterval(TimeIntervalLengthType value) {
        this.interval = value;
    }

}
