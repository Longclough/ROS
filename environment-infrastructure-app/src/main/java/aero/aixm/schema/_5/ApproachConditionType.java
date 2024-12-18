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
 * <p>Java class for ApproachConditionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApproachConditionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMObjectType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.aixm.aero/schema/5.1}ApproachConditionPropertyGroup"/>
 *         &lt;element name="extension" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractApproachConditionExtension"/>
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
@XmlType(name = "ApproachConditionType", propOrder = {
    "finalApproachPath",
    "requiredNavigationPerformance",
    "climbGradient",
    "minimumSet",
    "circlingRestriction",
    "aircraftCategory",
    "landingArea",
    "altimeter",
    "designSurface",
    "annotation",
    "extension"
})
public class ApproachConditionType
    extends AbstractAIXMObjectType
{

    @XmlElementRef(name = "finalApproachPath", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodeMinimaFinalApproachPathType> finalApproachPath;
    @XmlElementRef(name = "requiredNavigationPerformance", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodeRNPType> requiredNavigationPerformance;
    @XmlElementRef(name = "climbGradient", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValSlopeType> climbGradient;
    @XmlElementRef(name = "minimumSet", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<MinimaPropertyType> minimumSet;
    @XmlElement(nillable = true)
    protected List<CirclingRestrictionPropertyType> circlingRestriction;
    @XmlElement(nillable = true)
    protected List<AircraftCharacteristicPropertyType> aircraftCategory;
    @XmlElement(nillable = true)
    protected List<LandingTakeoffAreaCollectionPropertyType> landingArea;
    @XmlElementRef(name = "altimeter", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<AltimeterSourcePropertyType> altimeter;
    @XmlElement(nillable = true)
    protected List<ObstacleAssessmentAreaPropertyType> designSurface;
    @XmlElement(nillable = true)
    protected List<NotePropertyType> annotation;
    protected List<ApproachConditionType.Extension> extension;

    /**
     * Gets the value of the finalApproachPath property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodeMinimaFinalApproachPathType }{@code >}
     *     
     */
    public JAXBElement<CodeMinimaFinalApproachPathType> getFinalApproachPath() {
        return finalApproachPath;
    }

    /**
     * Sets the value of the finalApproachPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodeMinimaFinalApproachPathType }{@code >}
     *     
     */
    public void setFinalApproachPath(JAXBElement<CodeMinimaFinalApproachPathType> value) {
        this.finalApproachPath = value;
    }

    /**
     * Gets the value of the requiredNavigationPerformance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodeRNPType }{@code >}
     *     
     */
    public JAXBElement<CodeRNPType> getRequiredNavigationPerformance() {
        return requiredNavigationPerformance;
    }

    /**
     * Sets the value of the requiredNavigationPerformance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodeRNPType }{@code >}
     *     
     */
    public void setRequiredNavigationPerformance(JAXBElement<CodeRNPType> value) {
        this.requiredNavigationPerformance = value;
    }

    /**
     * Gets the value of the climbGradient property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValSlopeType }{@code >}
     *     
     */
    public JAXBElement<ValSlopeType> getClimbGradient() {
        return climbGradient;
    }

    /**
     * Sets the value of the climbGradient property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValSlopeType }{@code >}
     *     
     */
    public void setClimbGradient(JAXBElement<ValSlopeType> value) {
        this.climbGradient = value;
    }

    /**
     * Gets the value of the minimumSet property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MinimaPropertyType }{@code >}
     *     
     */
    public JAXBElement<MinimaPropertyType> getMinimumSet() {
        return minimumSet;
    }

    /**
     * Sets the value of the minimumSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MinimaPropertyType }{@code >}
     *     
     */
    public void setMinimumSet(JAXBElement<MinimaPropertyType> value) {
        this.minimumSet = value;
    }

    /**
     * Gets the value of the circlingRestriction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the circlingRestriction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCirclingRestriction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CirclingRestrictionPropertyType }
     * 
     * 
     */
    public List<CirclingRestrictionPropertyType> getCirclingRestriction() {
        if (circlingRestriction == null) {
            circlingRestriction = new ArrayList<CirclingRestrictionPropertyType>();
        }
        return this.circlingRestriction;
    }

    /**
     * Gets the value of the aircraftCategory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aircraftCategory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAircraftCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AircraftCharacteristicPropertyType }
     * 
     * 
     */
    public List<AircraftCharacteristicPropertyType> getAircraftCategory() {
        if (aircraftCategory == null) {
            aircraftCategory = new ArrayList<AircraftCharacteristicPropertyType>();
        }
        return this.aircraftCategory;
    }

    /**
     * Gets the value of the landingArea property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the landingArea property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLandingArea().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LandingTakeoffAreaCollectionPropertyType }
     * 
     * 
     */
    public List<LandingTakeoffAreaCollectionPropertyType> getLandingArea() {
        if (landingArea == null) {
            landingArea = new ArrayList<LandingTakeoffAreaCollectionPropertyType>();
        }
        return this.landingArea;
    }

    /**
     * Gets the value of the altimeter property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AltimeterSourcePropertyType }{@code >}
     *     
     */
    public JAXBElement<AltimeterSourcePropertyType> getAltimeter() {
        return altimeter;
    }

    /**
     * Sets the value of the altimeter property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AltimeterSourcePropertyType }{@code >}
     *     
     */
    public void setAltimeter(JAXBElement<AltimeterSourcePropertyType> value) {
        this.altimeter = value;
    }

    /**
     * Gets the value of the designSurface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the designSurface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDesignSurface().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObstacleAssessmentAreaPropertyType }
     * 
     * 
     */
    public List<ObstacleAssessmentAreaPropertyType> getDesignSurface() {
        if (designSurface == null) {
            designSurface = new ArrayList<ObstacleAssessmentAreaPropertyType>();
        }
        return this.designSurface;
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
     * {@link ApproachConditionType.Extension }
     * 
     * 
     */
    public List<ApproachConditionType.Extension> getExtension() {
        if (extension == null) {
            extension = new ArrayList<ApproachConditionType.Extension>();
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
     *         &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractApproachConditionExtension"/>
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
        "abstractApproachConditionExtension"
    })
    public static class Extension {

        @XmlElement(name = "AbstractApproachConditionExtension", required = true)
        protected AbstractExtensionType abstractApproachConditionExtension;
        @XmlAttribute(name = "owns")
        protected Boolean owns;

        /**
         * Gets the value of the abstractApproachConditionExtension property.
         * 
         * @return
         *     possible object is
         *     {@link AbstractExtensionType }
         *     
         */
        public AbstractExtensionType getAbstractApproachConditionExtension() {
            return abstractApproachConditionExtension;
        }

        /**
         * Sets the value of the abstractApproachConditionExtension property.
         * 
         * @param value
         *     allowed object is
         *     {@link AbstractExtensionType }
         *     
         */
        public void setAbstractApproachConditionExtension(AbstractExtensionType value) {
            this.abstractApproachConditionExtension = value;
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
