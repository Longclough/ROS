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
 * <p>Java class for DirectionFinderTimeSliceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DirectionFinderTimeSliceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMTimeSliceType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.aixm.aero/schema/5.1}DirectionFinderPropertyGroup"/>
 *         &lt;element name="extension" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractDirectionFinderExtension"/>
 *                   &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractNavaidEquipmentExtension"/>
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
@XmlType(name = "DirectionFinderTimeSliceType", propOrder = {
    "rest"
})
public class DirectionFinderTimeSliceType
    extends AbstractAIXMTimeSliceType
{

    @XmlElementRefs({
        @XmlElementRef(name = "annotation", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "doppler", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "dateMagneticVariation", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "flightChecked", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "extension", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "magneticVariation", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "location", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "monitoring", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "magneticVariationAccuracy", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "informationProvision", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "availability", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "emissionClass", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "authority", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "designator", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "mobile", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class),
        @XmlElementRef(name = "name", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    })
    protected List<JAXBElement<?>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Name" is used by two different parts of a schema. See: 
     * line 13396 of file:/C:/AIXM/AIXM_Features.xsd
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
     * {@link JAXBElement }{@code <}{@link NotePropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link CodeYesNoType }{@code >}
     * {@link JAXBElement }{@code <}{@link DateYearType }{@code >}
     * {@link JAXBElement }{@code <}{@link CodeYesNoType }{@code >}
     * {@link JAXBElement }{@code <}{@link DirectionFinderTimeSliceType.Extension }{@code >}
     * {@link JAXBElement }{@code <}{@link ValMagneticVariationType }{@code >}
     * {@link JAXBElement }{@code <}{@link ElevatedPointPropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link NavaidEquipmentMonitoringPropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link ValAngleType }{@code >}
     * {@link JAXBElement }{@code <}{@link InformationServicePropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link NavaidOperationalStatusPropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link CodeRadioEmissionType }{@code >}
     * {@link JAXBElement }{@code <}{@link AuthorityForNavaidEquipmentPropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link CodeYesNoType }{@code >}
     * {@link JAXBElement }{@code <}{@link CodeNavaidDesignatorType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextNameType }{@code >}
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
     *         &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractDirectionFinderExtension"/>
     *         &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractNavaidEquipmentExtension"/>
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
        "abstractDirectionFinderExtension",
        "abstractNavaidEquipmentExtension"
    })
    public static class Extension {

        @XmlElement(name = "AbstractDirectionFinderExtension")
        protected AbstractExtensionType abstractDirectionFinderExtension;
        @XmlElement(name = "AbstractNavaidEquipmentExtension")
        protected AbstractExtensionType abstractNavaidEquipmentExtension;
        @XmlAttribute(name = "owns")
        protected Boolean owns;

        /**
         * Gets the value of the abstractDirectionFinderExtension property.
         * 
         * @return
         *     possible object is
         *     {@link AbstractExtensionType }
         *     
         */
        public AbstractExtensionType getAbstractDirectionFinderExtension() {
            return abstractDirectionFinderExtension;
        }

        /**
         * Sets the value of the abstractDirectionFinderExtension property.
         * 
         * @param value
         *     allowed object is
         *     {@link AbstractExtensionType }
         *     
         */
        public void setAbstractDirectionFinderExtension(AbstractExtensionType value) {
            this.abstractDirectionFinderExtension = value;
        }

        /**
         * Gets the value of the abstractNavaidEquipmentExtension property.
         * 
         * @return
         *     possible object is
         *     {@link AbstractExtensionType }
         *     
         */
        public AbstractExtensionType getAbstractNavaidEquipmentExtension() {
            return abstractNavaidEquipmentExtension;
        }

        /**
         * Sets the value of the abstractNavaidEquipmentExtension property.
         * 
         * @param value
         *     allowed object is
         *     {@link AbstractExtensionType }
         *     
         */
        public void setAbstractNavaidEquipmentExtension(AbstractExtensionType value) {
            this.abstractNavaidEquipmentExtension = value;
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
