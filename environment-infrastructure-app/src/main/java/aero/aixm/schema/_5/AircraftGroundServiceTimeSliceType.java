//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.10 at 09:50:27 AM BST 
//


package aero.aixm.schema._5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AircraftGroundServiceTimeSliceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AircraftGroundServiceTimeSliceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMTimeSliceType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.aixm.aero/schema/5.1}AircraftGroundServicePropertyGroup"/>
 *         &lt;element name="extension" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractAircraftGroundServiceExtension"/>
 *                   &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractAirportGroundServiceExtension"/>
 *                   &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractServiceExtension"/>
 *                 &lt;/choice>
 *                 &lt;attGroup ref="{http://www.opengis.net/gml/3.2}OwnershipAttributeGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AircraftGroundServiceTimeSliceType", propOrder = {
    "rest"
})
public class AircraftGroundServiceTimeSliceType
    extends AbstractAIXMTimeSliceType
{

    @XmlElementRefs({
        @XmlElementRef(name = "name", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "call-sign", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "extension", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "serviceProvider", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "annotation", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "flightOperations", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "compliantICAO", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "type", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "groundCommunication", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "availability", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "location", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "airportHeliport", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "radioCommunication", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "rank", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    })
    protected List<JAXBElement<?>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Name" is used by two different parts of a schema. See: 
     * line 10138 of file:/C:/AIXM/AIXM_Features.xsd
     * line 37 of file:/C:/AIXM/ISO_19136_Schemas/gmlBase.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the rest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TextNameType }{@code >}
     * {@link JAXBElement }{@code <}{@link CallsignDetailPropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link AircraftGroundServiceTimeSliceType.Extension }{@code >}
     * {@link JAXBElement }{@code <}{@link UnitPropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link NotePropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link CodeFlightDestinationType }{@code >}
     * {@link JAXBElement }{@code <}{@link CodeYesNoType }{@code >}
     * {@link JAXBElement }{@code <}{@link CodeAircraftGroundServiceType }{@code >}
     * {@link JAXBElement }{@code <}{@link ContactInformationPropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link ServiceOperationalStatusPropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link ElevatedPointPropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link AirportHeliportPropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link RadioCommunicationChannelPropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link CodeFacilityRankingType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<?>>();
        }
        return this.rest;
    }


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
     *         &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractAircraftGroundServiceExtension"/>
     *         &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractAirportGroundServiceExtension"/>
     *         &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractServiceExtension"/>
     *       &lt;/choice>
     *       &lt;attGroup ref="{http://www.opengis.net/gml/3.2}OwnershipAttributeGroup"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "abstractAircraftGroundServiceExtension",
        "abstractAirportGroundServiceExtension",
        "abstractServiceExtension"
    })
    public static class Extension {

        @XmlElement(name = "AbstractAircraftGroundServiceExtension")
        protected AbstractExtensionType abstractAircraftGroundServiceExtension;
        @XmlElement(name = "AbstractAirportGroundServiceExtension")
        protected AbstractExtensionType abstractAirportGroundServiceExtension;
        @XmlElement(name = "AbstractServiceExtension")
        protected AbstractExtensionType abstractServiceExtension;
        @XmlAttribute(name = "owns")
        protected Boolean owns;

        /**
         * Gets the value of the abstractAircraftGroundServiceExtension property.
         * 
         * @return
         *     possible object is
         *     {@link AbstractExtensionType }
         *     
         */
        public AbstractExtensionType getAbstractAircraftGroundServiceExtension() {
            return abstractAircraftGroundServiceExtension;
        }

        /**
         * Sets the value of the abstractAircraftGroundServiceExtension property.
         * 
         * @param value
         *     allowed object is
         *     {@link AbstractExtensionType }
         *     
         */
        public void setAbstractAircraftGroundServiceExtension(AbstractExtensionType value) {
            this.abstractAircraftGroundServiceExtension = value;
        }

        /**
         * Gets the value of the abstractAirportGroundServiceExtension property.
         * 
         * @return
         *     possible object is
         *     {@link AbstractExtensionType }
         *     
         */
        public AbstractExtensionType getAbstractAirportGroundServiceExtension() {
            return abstractAirportGroundServiceExtension;
        }

        /**
         * Sets the value of the abstractAirportGroundServiceExtension property.
         * 
         * @param value
         *     allowed object is
         *     {@link AbstractExtensionType }
         *     
         */
        public void setAbstractAirportGroundServiceExtension(AbstractExtensionType value) {
            this.abstractAirportGroundServiceExtension = value;
        }

        /**
         * Gets the value of the abstractServiceExtension property.
         * 
         * @return
         *     possible object is
         *     {@link AbstractExtensionType }
         *     
         */
        public AbstractExtensionType getAbstractServiceExtension() {
            return abstractServiceExtension;
        }

        /**
         * Sets the value of the abstractServiceExtension property.
         * 
         * @param value
         *     allowed object is
         *     {@link AbstractExtensionType }
         *     
         */
        public void setAbstractServiceExtension(AbstractExtensionType value) {
            this.abstractServiceExtension = value;
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

}
