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
 * <p>Java class for TerminalArrivalAreaTimeSliceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TerminalArrivalAreaTimeSliceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMTimeSliceType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.aixm.aero/schema/5.1}TerminalArrivalAreaPropertyGroup"/>
 *         &lt;element name="extension" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractTerminalArrivalAreaExtension"/>
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
@XmlType(name = "TerminalArrivalAreaTimeSliceType", propOrder = {
    "arrivalAreaType",
    "outerBufferWidth",
    "lateralBufferWidth",
    "ifFixDesignatedPoint",
    "ifNavaidSystem",
    "ifAimingPoint",
    "ifRunwayPoint",
    "ifAirportReferencePoint",
    "ifPosition",
    "iafFixDesignatedPoint",
    "iafNavaidSystem",
    "iafAimingPoint",
    "iafRunwayPoint",
    "iafAirportReferencePoint",
    "iafPosition",
    "buffer",
    "sector",
    "approachRNAV",
    "annotation",
    "extension"
})
public class TerminalArrivalAreaTimeSliceType
    extends AbstractAIXMTimeSliceType
{

    @XmlElementRef(name = "arrivalAreaType", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodeTAAType> arrivalAreaType;
    @XmlElementRef(name = "outerBufferWidth", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValDistanceType> outerBufferWidth;
    @XmlElementRef(name = "lateralBufferWidth", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValDistanceType> lateralBufferWidth;
    @XmlElementRef(name = "IF_fixDesignatedPoint", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<DesignatedPointPropertyType> ifFixDesignatedPoint;
    @XmlElementRef(name = "IF_navaidSystem", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<NavaidPropertyType> ifNavaidSystem;
    @XmlElementRef(name = "IF_aimingPoint", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<TouchDownLiftOffPropertyType> ifAimingPoint;
    @XmlElementRef(name = "IF_runwayPoint", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<RunwayCentrelinePointPropertyType> ifRunwayPoint;
    @XmlElementRef(name = "IF_airportReferencePoint", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<AirportHeliportPropertyType> ifAirportReferencePoint;
    @XmlElementRef(name = "IF_position", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<PointPropertyType> ifPosition;
    @XmlElementRef(name = "IAF_fixDesignatedPoint", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<DesignatedPointPropertyType> iafFixDesignatedPoint;
    @XmlElementRef(name = "IAF_navaidSystem", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<NavaidPropertyType> iafNavaidSystem;
    @XmlElementRef(name = "IAF_aimingPoint", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<TouchDownLiftOffPropertyType> iafAimingPoint;
    @XmlElementRef(name = "IAF_runwayPoint", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<RunwayCentrelinePointPropertyType> iafRunwayPoint;
    @XmlElementRef(name = "IAF_airportReferencePoint", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<AirportHeliportPropertyType> iafAirportReferencePoint;
    @XmlElementRef(name = "IAF_position", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<PointPropertyType> iafPosition;
    @XmlElementRef(name = "buffer", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<SurfacePropertyType> buffer;
    @XmlElement(nillable = true)
    protected List<TerminalArrivalAreaSectorPropertyType> sector;
    @XmlElementRef(name = "approachRNAV", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<InstrumentApproachProcedurePropertyType> approachRNAV;
    @XmlElement(nillable = true)
    protected List<NotePropertyType> annotation;
    protected List<TerminalArrivalAreaTimeSliceType.Extension> extension;

    /**
     * Gets the value of the arrivalAreaType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodeTAAType }{@code >}
     *     
     */
    public JAXBElement<CodeTAAType> getArrivalAreaType() {
        return arrivalAreaType;
    }

    /**
     * Sets the value of the arrivalAreaType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodeTAAType }{@code >}
     *     
     */
    public void setArrivalAreaType(JAXBElement<CodeTAAType> value) {
        this.arrivalAreaType = value;
    }

    /**
     * Gets the value of the outerBufferWidth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValDistanceType }{@code >}
     *     
     */
    public JAXBElement<ValDistanceType> getOuterBufferWidth() {
        return outerBufferWidth;
    }

    /**
     * Sets the value of the outerBufferWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValDistanceType }{@code >}
     *     
     */
    public void setOuterBufferWidth(JAXBElement<ValDistanceType> value) {
        this.outerBufferWidth = value;
    }

    /**
     * Gets the value of the lateralBufferWidth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValDistanceType }{@code >}
     *     
     */
    public JAXBElement<ValDistanceType> getLateralBufferWidth() {
        return lateralBufferWidth;
    }

    /**
     * Sets the value of the lateralBufferWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValDistanceType }{@code >}
     *     
     */
    public void setLateralBufferWidth(JAXBElement<ValDistanceType> value) {
        this.lateralBufferWidth = value;
    }

    /**
     * Gets the value of the ifFixDesignatedPoint property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DesignatedPointPropertyType }{@code >}
     *     
     */
    public JAXBElement<DesignatedPointPropertyType> getIFFixDesignatedPoint() {
        return ifFixDesignatedPoint;
    }

    /**
     * Sets the value of the ifFixDesignatedPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DesignatedPointPropertyType }{@code >}
     *     
     */
    public void setIFFixDesignatedPoint(JAXBElement<DesignatedPointPropertyType> value) {
        this.ifFixDesignatedPoint = value;
    }

    /**
     * Gets the value of the ifNavaidSystem property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link NavaidPropertyType }{@code >}
     *     
     */
    public JAXBElement<NavaidPropertyType> getIFNavaidSystem() {
        return ifNavaidSystem;
    }

    /**
     * Sets the value of the ifNavaidSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link NavaidPropertyType }{@code >}
     *     
     */
    public void setIFNavaidSystem(JAXBElement<NavaidPropertyType> value) {
        this.ifNavaidSystem = value;
    }

    /**
     * Gets the value of the ifAimingPoint property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TouchDownLiftOffPropertyType }{@code >}
     *     
     */
    public JAXBElement<TouchDownLiftOffPropertyType> getIFAimingPoint() {
        return ifAimingPoint;
    }

    /**
     * Sets the value of the ifAimingPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TouchDownLiftOffPropertyType }{@code >}
     *     
     */
    public void setIFAimingPoint(JAXBElement<TouchDownLiftOffPropertyType> value) {
        this.ifAimingPoint = value;
    }

    /**
     * Gets the value of the ifRunwayPoint property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RunwayCentrelinePointPropertyType }{@code >}
     *     
     */
    public JAXBElement<RunwayCentrelinePointPropertyType> getIFRunwayPoint() {
        return ifRunwayPoint;
    }

    /**
     * Sets the value of the ifRunwayPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RunwayCentrelinePointPropertyType }{@code >}
     *     
     */
    public void setIFRunwayPoint(JAXBElement<RunwayCentrelinePointPropertyType> value) {
        this.ifRunwayPoint = value;
    }

    /**
     * Gets the value of the ifAirportReferencePoint property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AirportHeliportPropertyType }{@code >}
     *     
     */
    public JAXBElement<AirportHeliportPropertyType> getIFAirportReferencePoint() {
        return ifAirportReferencePoint;
    }

    /**
     * Sets the value of the ifAirportReferencePoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AirportHeliportPropertyType }{@code >}
     *     
     */
    public void setIFAirportReferencePoint(JAXBElement<AirportHeliportPropertyType> value) {
        this.ifAirportReferencePoint = value;
    }

    /**
     * Gets the value of the ifPosition property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}
     *     
     */
    public JAXBElement<PointPropertyType> getIFPosition() {
        return ifPosition;
    }

    /**
     * Sets the value of the ifPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}
     *     
     */
    public void setIFPosition(JAXBElement<PointPropertyType> value) {
        this.ifPosition = value;
    }

    /**
     * Gets the value of the iafFixDesignatedPoint property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DesignatedPointPropertyType }{@code >}
     *     
     */
    public JAXBElement<DesignatedPointPropertyType> getIAFFixDesignatedPoint() {
        return iafFixDesignatedPoint;
    }

    /**
     * Sets the value of the iafFixDesignatedPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DesignatedPointPropertyType }{@code >}
     *     
     */
    public void setIAFFixDesignatedPoint(JAXBElement<DesignatedPointPropertyType> value) {
        this.iafFixDesignatedPoint = value;
    }

    /**
     * Gets the value of the iafNavaidSystem property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link NavaidPropertyType }{@code >}
     *     
     */
    public JAXBElement<NavaidPropertyType> getIAFNavaidSystem() {
        return iafNavaidSystem;
    }

    /**
     * Sets the value of the iafNavaidSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link NavaidPropertyType }{@code >}
     *     
     */
    public void setIAFNavaidSystem(JAXBElement<NavaidPropertyType> value) {
        this.iafNavaidSystem = value;
    }

    /**
     * Gets the value of the iafAimingPoint property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TouchDownLiftOffPropertyType }{@code >}
     *     
     */
    public JAXBElement<TouchDownLiftOffPropertyType> getIAFAimingPoint() {
        return iafAimingPoint;
    }

    /**
     * Sets the value of the iafAimingPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TouchDownLiftOffPropertyType }{@code >}
     *     
     */
    public void setIAFAimingPoint(JAXBElement<TouchDownLiftOffPropertyType> value) {
        this.iafAimingPoint = value;
    }

    /**
     * Gets the value of the iafRunwayPoint property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RunwayCentrelinePointPropertyType }{@code >}
     *     
     */
    public JAXBElement<RunwayCentrelinePointPropertyType> getIAFRunwayPoint() {
        return iafRunwayPoint;
    }

    /**
     * Sets the value of the iafRunwayPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RunwayCentrelinePointPropertyType }{@code >}
     *     
     */
    public void setIAFRunwayPoint(JAXBElement<RunwayCentrelinePointPropertyType> value) {
        this.iafRunwayPoint = value;
    }

    /**
     * Gets the value of the iafAirportReferencePoint property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AirportHeliportPropertyType }{@code >}
     *     
     */
    public JAXBElement<AirportHeliportPropertyType> getIAFAirportReferencePoint() {
        return iafAirportReferencePoint;
    }

    /**
     * Sets the value of the iafAirportReferencePoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AirportHeliportPropertyType }{@code >}
     *     
     */
    public void setIAFAirportReferencePoint(JAXBElement<AirportHeliportPropertyType> value) {
        this.iafAirportReferencePoint = value;
    }

    /**
     * Gets the value of the iafPosition property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}
     *     
     */
    public JAXBElement<PointPropertyType> getIAFPosition() {
        return iafPosition;
    }

    /**
     * Sets the value of the iafPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}
     *     
     */
    public void setIAFPosition(JAXBElement<PointPropertyType> value) {
        this.iafPosition = value;
    }

    /**
     * Gets the value of the buffer property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SurfacePropertyType }{@code >}
     *     
     */
    public JAXBElement<SurfacePropertyType> getBuffer() {
        return buffer;
    }

    /**
     * Sets the value of the buffer property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SurfacePropertyType }{@code >}
     *     
     */
    public void setBuffer(JAXBElement<SurfacePropertyType> value) {
        this.buffer = value;
    }

    /**
     * Gets the value of the sector property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sector property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSector().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TerminalArrivalAreaSectorPropertyType }
     * 
     * 
     */
    public List<TerminalArrivalAreaSectorPropertyType> getSector() {
        if (sector == null) {
            sector = new ArrayList<TerminalArrivalAreaSectorPropertyType>();
        }
        return this.sector;
    }

    /**
     * Gets the value of the approachRNAV property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link InstrumentApproachProcedurePropertyType }{@code >}
     *     
     */
    public JAXBElement<InstrumentApproachProcedurePropertyType> getApproachRNAV() {
        return approachRNAV;
    }

    /**
     * Sets the value of the approachRNAV property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link InstrumentApproachProcedurePropertyType }{@code >}
     *     
     */
    public void setApproachRNAV(JAXBElement<InstrumentApproachProcedurePropertyType> value) {
        this.approachRNAV = value;
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
     * {@link TerminalArrivalAreaTimeSliceType.Extension }
     * 
     * 
     */
    public List<TerminalArrivalAreaTimeSliceType.Extension> getExtension() {
        if (extension == null) {
            extension = new ArrayList<TerminalArrivalAreaTimeSliceType.Extension>();
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
     *         &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractTerminalArrivalAreaExtension"/>
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
        "abstractTerminalArrivalAreaExtension"
    })
    public static class Extension {

        @XmlElement(name = "AbstractTerminalArrivalAreaExtension", required = true)
        protected AbstractExtensionType abstractTerminalArrivalAreaExtension;
        @XmlAttribute(name = "owns")
        protected Boolean owns;

        /**
         * Gets the value of the abstractTerminalArrivalAreaExtension property.
         * 
         * @return
         *     possible object is
         *     {@link AbstractExtensionType }
         *     
         */
        public AbstractExtensionType getAbstractTerminalArrivalAreaExtension() {
            return abstractTerminalArrivalAreaExtension;
        }

        /**
         * Sets the value of the abstractTerminalArrivalAreaExtension property.
         * 
         * @param value
         *     allowed object is
         *     {@link AbstractExtensionType }
         *     
         */
        public void setAbstractTerminalArrivalAreaExtension(AbstractExtensionType value) {
            this.abstractTerminalArrivalAreaExtension = value;
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
