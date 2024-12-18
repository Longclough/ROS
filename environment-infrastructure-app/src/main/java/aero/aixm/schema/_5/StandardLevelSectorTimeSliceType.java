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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StandardLevelSectorTimeSliceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StandardLevelSectorTimeSliceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMTimeSliceType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.aixm.aero/schema/5.1}StandardLevelSectorPropertyGroup"/>
 *         &lt;element name="extension" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractStandardLevelSectorExtension"/>
 *                 &lt;/sequence>
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
@XmlType(name = "StandardLevelSectorTimeSliceType", propOrder = {
    "flightRule",
    "fromTrack",
    "toTrack",
    "angleType",
    "applicableAirspace",
    "applicableLevelColumn",
    "annotation",
    "extension"
})
public class StandardLevelSectorTimeSliceType
    extends AbstractAIXMTimeSliceType
{

    @XmlElementRef(name = "flightRule", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodeFlightRuleType> flightRule;
    @XmlElementRef(name = "fromTrack", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValBearingType> fromTrack;
    @XmlElementRef(name = "toTrack", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValBearingType> toTrack;
    @XmlElementRef(name = "angleType", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodeNorthReferenceType> angleType;
    @XmlElement(nillable = true)
    protected List<AirspacePropertyType> applicableAirspace;
    @XmlElementRef(name = "applicableLevelColumn", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<StandardLevelColumnPropertyType> applicableLevelColumn;
    @XmlElement(nillable = true)
    protected List<NotePropertyType> annotation;
    protected List<StandardLevelSectorTimeSliceType.Extension> extension;

    /**
     * Gets the value of the flightRule property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodeFlightRuleType }{@code >}
     *     
     */
    public JAXBElement<CodeFlightRuleType> getFlightRule() {
        return flightRule;
    }

    /**
     * Sets the value of the flightRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodeFlightRuleType }{@code >}
     *     
     */
    public void setFlightRule(JAXBElement<CodeFlightRuleType> value) {
        this.flightRule = value;
    }

    /**
     * Gets the value of the fromTrack property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValBearingType }{@code >}
     *     
     */
    public JAXBElement<ValBearingType> getFromTrack() {
        return fromTrack;
    }

    /**
     * Sets the value of the fromTrack property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValBearingType }{@code >}
     *     
     */
    public void setFromTrack(JAXBElement<ValBearingType> value) {
        this.fromTrack = value;
    }

    /**
     * Gets the value of the toTrack property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValBearingType }{@code >}
     *     
     */
    public JAXBElement<ValBearingType> getToTrack() {
        return toTrack;
    }

    /**
     * Sets the value of the toTrack property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValBearingType }{@code >}
     *     
     */
    public void setToTrack(JAXBElement<ValBearingType> value) {
        this.toTrack = value;
    }

    /**
     * Gets the value of the angleType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodeNorthReferenceType }{@code >}
     *     
     */
    public JAXBElement<CodeNorthReferenceType> getAngleType() {
        return angleType;
    }

    /**
     * Sets the value of the angleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodeNorthReferenceType }{@code >}
     *     
     */
    public void setAngleType(JAXBElement<CodeNorthReferenceType> value) {
        this.angleType = value;
    }

    /**
     * Gets the value of the applicableAirspace property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicableAirspace property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicableAirspace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AirspacePropertyType }
     * 
     * 
     */
    public List<AirspacePropertyType> getApplicableAirspace() {
        if (applicableAirspace == null) {
            applicableAirspace = new ArrayList<AirspacePropertyType>();
        }
        return this.applicableAirspace;
    }

    /**
     * Gets the value of the applicableLevelColumn property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StandardLevelColumnPropertyType }{@code >}
     *     
     */
    public JAXBElement<StandardLevelColumnPropertyType> getApplicableLevelColumn() {
        return applicableLevelColumn;
    }

    /**
     * Sets the value of the applicableLevelColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StandardLevelColumnPropertyType }{@code >}
     *     
     */
    public void setApplicableLevelColumn(JAXBElement<StandardLevelColumnPropertyType> value) {
        this.applicableLevelColumn = value;
    }

    /**
     * Gets the value of the annotation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the annotation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnnotation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NotePropertyType }
     * 
     * 
     */
    public List<NotePropertyType> getAnnotation() {
        if (annotation == null) {
            annotation = new ArrayList<NotePropertyType>();
        }
        return this.annotation;
    }

    /**
     * Gets the value of the extension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StandardLevelSectorTimeSliceType.Extension }
     * 
     * 
     */
    public List<StandardLevelSectorTimeSliceType.Extension> getExtension() {
        if (extension == null) {
            extension = new ArrayList<StandardLevelSectorTimeSliceType.Extension>();
        }
        return this.extension;
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
     *       &lt;sequence>
     *         &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractStandardLevelSectorExtension"/>
     *       &lt;/sequence>
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
        "abstractStandardLevelSectorExtension"
    })
    public static class Extension {

        @XmlElement(name = "AbstractStandardLevelSectorExtension", required = true)
        protected AbstractExtensionType abstractStandardLevelSectorExtension;
        @XmlAttribute(name = "owns")
        protected Boolean owns;

        /**
         * Gets the value of the abstractStandardLevelSectorExtension property.
         * 
         * @return
         *     possible object is
         *     {@link AbstractExtensionType }
         *     
         */
        public AbstractExtensionType getAbstractStandardLevelSectorExtension() {
            return abstractStandardLevelSectorExtension;
        }

        /**
         * Sets the value of the abstractStandardLevelSectorExtension property.
         * 
         * @param value
         *     allowed object is
         *     {@link AbstractExtensionType }
         *     
         */
        public void setAbstractStandardLevelSectorExtension(AbstractExtensionType value) {
            this.abstractStandardLevelSectorExtension = value;
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
