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
 * <p>Java class for HoldingPatternDurationPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HoldingPatternDurationPropertyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMPropertyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.aixm.aero/schema/5.1}HoldingPatternDuration"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HoldingPatternDurationPropertyType", propOrder = {
    "holdingPatternDuration"
})
public class HoldingPatternDurationPropertyType
    extends AbstractAIXMPropertyType
{

    @XmlElement(name = "HoldingPatternDuration", required = true)
    protected HoldingPatternDurationType holdingPatternDuration;

    /**
     * Gets the value of the holdingPatternDuration property.
     * 
     * @return
     *     possible object is
     *     {@link HoldingPatternDurationType }
     *     
     */
    public HoldingPatternDurationType getHoldingPatternDuration() {
        return holdingPatternDuration;
    }

    /**
     * Sets the value of the holdingPatternDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link HoldingPatternDurationType }
     *     
     */
    public void setHoldingPatternDuration(HoldingPatternDurationType value) {
        this.holdingPatternDuration = value;
    }

}
