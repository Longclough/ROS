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
 * <p>Java class for NitrogenPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NitrogenPropertyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMPropertyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.aixm.aero/schema/5.1}Nitrogen"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NitrogenPropertyType", propOrder = {
    "nitrogen"
})
public class NitrogenPropertyType
    extends AbstractAIXMPropertyType
{

    @XmlElement(name = "Nitrogen", required = true)
    protected NitrogenType nitrogen;

    /**
     * Gets the value of the nitrogen property.
     * 
     * @return
     *     possible object is
     *     {@link NitrogenType }
     *     
     */
    public NitrogenType getNitrogen() {
        return nitrogen;
    }

    /**
     * Sets the value of the nitrogen property.
     * 
     * @param value
     *     allowed object is
     *     {@link NitrogenType }
     *     
     */
    public void setNitrogen(NitrogenType value) {
        this.nitrogen = value;
    }

}
