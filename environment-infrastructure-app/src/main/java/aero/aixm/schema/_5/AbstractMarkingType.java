//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.10 at 09:50:27 AM BST 
//


package aero.aixm.schema._5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AbstractMarkingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractMarkingType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMFeatureType">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractMarkingType")
@XmlSeeAlso({
    AirportProtectionAreaMarkingType.class,
    TouchDownLiftOffMarkingType.class,
    RunwayMarkingType.class,
    DeicingAreaMarkingType.class,
    ApronMarkingType.class,
    TaxiwayMarkingType.class,
    StandMarkingType.class,
    GuidanceLineMarkingType.class,
    TaxiHoldingPositionMarkingType.class
})
public abstract class AbstractMarkingType
    extends AbstractAIXMFeatureType
{


}
