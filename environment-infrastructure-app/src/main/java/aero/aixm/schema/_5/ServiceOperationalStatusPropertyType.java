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
 * <p>Java class for ServiceOperationalStatusPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceOperationalStatusPropertyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMPropertyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.aixm.aero/schema/5.1}ServiceOperationalStatus"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceOperationalStatusPropertyType", propOrder = {
    "serviceOperationalStatus"
})
public class ServiceOperationalStatusPropertyType
    extends AbstractAIXMPropertyType
{

    @XmlElement(name = "ServiceOperationalStatus", required = true)
    protected ServiceOperationalStatusType serviceOperationalStatus;

    /**
     * Gets the value of the serviceOperationalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceOperationalStatusType }
     *     
     */
    public ServiceOperationalStatusType getServiceOperationalStatus() {
        return serviceOperationalStatus;
    }

    /**
     * Sets the value of the serviceOperationalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceOperationalStatusType }
     *     
     */
    public void setServiceOperationalStatus(ServiceOperationalStatusType value) {
        this.serviceOperationalStatus = value;
    }

}
