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
 * <p>Java class for AirportHeliportUsagePropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AirportHeliportUsagePropertyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMPropertyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.aixm.aero/schema/5.1}AirportHeliportUsage"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AirportHeliportUsagePropertyType", propOrder = {
    "airportHeliportUsage"
})
public class AirportHeliportUsagePropertyType
    extends AbstractAIXMPropertyType
{

    @XmlElement(name = "AirportHeliportUsage", required = true)
    protected AirportHeliportUsageType airportHeliportUsage;

    /**
     * Gets the value of the airportHeliportUsage property.
     * 
     * @return
     *     possible object is
     *     {@link AirportHeliportUsageType }
     *     
     */
    public AirportHeliportUsageType getAirportHeliportUsage() {
        return airportHeliportUsage;
    }

    /**
     * Sets the value of the airportHeliportUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link AirportHeliportUsageType }
     *     
     */
    public void setAirportHeliportUsage(AirportHeliportUsageType value) {
        this.airportHeliportUsage = value;
    }

}