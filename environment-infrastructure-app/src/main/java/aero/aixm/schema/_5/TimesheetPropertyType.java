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
 * <p>Java class for TimesheetPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimesheetPropertyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMPropertyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.aixm.aero/schema/5.1}Timesheet"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimesheetPropertyType", propOrder = {
    "timesheet"
})
public class TimesheetPropertyType
    extends AbstractAIXMPropertyType
{

    @XmlElement(name = "Timesheet", required = true)
    protected TimesheetType timesheet;

    /**
     * Gets the value of the timesheet property.
     * 
     * @return
     *     possible object is
     *     {@link TimesheetType }
     *     
     */
    public TimesheetType getTimesheet() {
        return timesheet;
    }

    /**
     * Sets the value of the timesheet property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimesheetType }
     *     
     */
    public void setTimesheet(TimesheetType value) {
        this.timesheet = value;
    }

}