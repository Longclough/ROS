//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.10 at 09:50:27 AM BST 
//


package aero.aixm.schema._5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EnRouteSegmentPointPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnRouteSegmentPointPropertyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMPropertyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.aixm.aero/schema/5.1}EnRouteSegmentPoint"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnRouteSegmentPointPropertyType", propOrder = {
    "enRouteSegmentPoint"
})
public class EnRouteSegmentPointPropertyType
    extends AbstractAIXMPropertyType
{

    @XmlElement(name = "EnRouteSegmentPoint", required = true)
    protected EnRouteSegmentPointType enRouteSegmentPoint;

    /**
     * Gets the value of the enRouteSegmentPoint property.
     * 
     * @return
     *     possible object is
     *     {@link EnRouteSegmentPointType }
     *     
     */
    public EnRouteSegmentPointType getEnRouteSegmentPoint() {
        return enRouteSegmentPoint;
    }

    /**
     * Sets the value of the enRouteSegmentPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnRouteSegmentPointType }
     *     
     */
    public void setEnRouteSegmentPoint(EnRouteSegmentPointType value) {
        this.enRouteSegmentPoint = value;
    }

}