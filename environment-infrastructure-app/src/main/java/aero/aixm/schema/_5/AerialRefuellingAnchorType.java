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
 * <p>Java class for AerialRefuellingAnchorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialRefuellingAnchorType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMObjectType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.aixm.aero/schema/5.1}AerialRefuellingAnchorPropertyGroup"/>
 *         &lt;element name="extension" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractAerialRefuellingAnchorExtension"/>
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
@XmlType(name = "AerialRefuellingAnchorType", propOrder = {
    "outboundCourse",
    "outboundCourseType",
    "inboundCourse",
    "turnDirection",
    "speedLimit",
    "legSeparation",
    "legLength",
    "refuellingBaseLevel",
    "refuellingBaseLevelReference",
    "extent",
    "verticalExtent",
    "point",
    "annotation",
    "extension"
})
public class AerialRefuellingAnchorType
    extends AbstractAIXMObjectType
{

    @XmlElementRef(name = "outboundCourse", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValBearingType> outboundCourse;
    @XmlElementRef(name = "outboundCourseType", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodeCourseType> outboundCourseType;
    @XmlElementRef(name = "inboundCourse", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValBearingType> inboundCourse;
    @XmlElementRef(name = "turnDirection", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodeDirectionTurnType> turnDirection;
    @XmlElementRef(name = "speedLimit", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValSpeedType> speedLimit;
    @XmlElementRef(name = "legSeparation", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValDistanceType> legSeparation;
    @XmlElementRef(name = "legLength", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValDistanceType> legLength;
    @XmlElementRef(name = "refuellingBaseLevel", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValDistanceVerticalType> refuellingBaseLevel;
    @XmlElementRef(name = "refuellingBaseLevelReference", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodeVerticalReferenceType> refuellingBaseLevelReference;
    @XmlElementRef(name = "extent", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<SurfacePropertyType> extent;
    @XmlElement(nillable = true)
    protected List<AirspaceLayerPropertyType> verticalExtent;
    @XmlElement(nillable = true)
    protected List<AerialRefuellingPointPropertyType> point;
    @XmlElement(nillable = true)
    protected List<NotePropertyType> annotation;
    protected List<AerialRefuellingAnchorType.Extension> extension;

    /**
     * Gets the value of the outboundCourse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValBearingType }{@code >}
     *     
     */
    public JAXBElement<ValBearingType> getOutboundCourse() {
        return outboundCourse;
    }

    /**
     * Sets the value of the outboundCourse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValBearingType }{@code >}
     *     
     */
    public void setOutboundCourse(JAXBElement<ValBearingType> value) {
        this.outboundCourse = value;
    }

    /**
     * Gets the value of the outboundCourseType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodeCourseType }{@code >}
     *     
     */
    public JAXBElement<CodeCourseType> getOutboundCourseType() {
        return outboundCourseType;
    }

    /**
     * Sets the value of the outboundCourseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodeCourseType }{@code >}
     *     
     */
    public void setOutboundCourseType(JAXBElement<CodeCourseType> value) {
        this.outboundCourseType = value;
    }

    /**
     * Gets the value of the inboundCourse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValBearingType }{@code >}
     *     
     */
    public JAXBElement<ValBearingType> getInboundCourse() {
        return inboundCourse;
    }

    /**
     * Sets the value of the inboundCourse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValBearingType }{@code >}
     *     
     */
    public void setInboundCourse(JAXBElement<ValBearingType> value) {
        this.inboundCourse = value;
    }

    /**
     * Gets the value of the turnDirection property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodeDirectionTurnType }{@code >}
     *     
     */
    public JAXBElement<CodeDirectionTurnType> getTurnDirection() {
        return turnDirection;
    }

    /**
     * Sets the value of the turnDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodeDirectionTurnType }{@code >}
     *     
     */
    public void setTurnDirection(JAXBElement<CodeDirectionTurnType> value) {
        this.turnDirection = value;
    }

    /**
     * Gets the value of the speedLimit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValSpeedType }{@code >}
     *     
     */
    public JAXBElement<ValSpeedType> getSpeedLimit() {
        return speedLimit;
    }

    /**
     * Sets the value of the speedLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValSpeedType }{@code >}
     *     
     */
    public void setSpeedLimit(JAXBElement<ValSpeedType> value) {
        this.speedLimit = value;
    }

    /**
     * Gets the value of the legSeparation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValDistanceType }{@code >}
     *     
     */
    public JAXBElement<ValDistanceType> getLegSeparation() {
        return legSeparation;
    }

    /**
     * Sets the value of the legSeparation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValDistanceType }{@code >}
     *     
     */
    public void setLegSeparation(JAXBElement<ValDistanceType> value) {
        this.legSeparation = value;
    }

    /**
     * Gets the value of the legLength property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValDistanceType }{@code >}
     *     
     */
    public JAXBElement<ValDistanceType> getLegLength() {
        return legLength;
    }

    /**
     * Sets the value of the legLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValDistanceType }{@code >}
     *     
     */
    public void setLegLength(JAXBElement<ValDistanceType> value) {
        this.legLength = value;
    }

    /**
     * Gets the value of the refuellingBaseLevel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValDistanceVerticalType }{@code >}
     *     
     */
    public JAXBElement<ValDistanceVerticalType> getRefuellingBaseLevel() {
        return refuellingBaseLevel;
    }

    /**
     * Sets the value of the refuellingBaseLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValDistanceVerticalType }{@code >}
     *     
     */
    public void setRefuellingBaseLevel(JAXBElement<ValDistanceVerticalType> value) {
        this.refuellingBaseLevel = value;
    }

    /**
     * Gets the value of the refuellingBaseLevelReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodeVerticalReferenceType }{@code >}
     *     
     */
    public JAXBElement<CodeVerticalReferenceType> getRefuellingBaseLevelReference() {
        return refuellingBaseLevelReference;
    }

    /**
     * Sets the value of the refuellingBaseLevelReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodeVerticalReferenceType }{@code >}
     *     
     */
    public void setRefuellingBaseLevelReference(JAXBElement<CodeVerticalReferenceType> value) {
        this.refuellingBaseLevelReference = value;
    }

    /**
     * Gets the value of the extent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SurfacePropertyType }{@code >}
     *     
     */
    public JAXBElement<SurfacePropertyType> getExtent() {
        return extent;
    }

    /**
     * Sets the value of the extent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SurfacePropertyType }{@code >}
     *     
     */
    public void setExtent(JAXBElement<SurfacePropertyType> value) {
        this.extent = value;
    }

    /**
     * Gets the value of the verticalExtent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the verticalExtent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVerticalExtent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AirspaceLayerPropertyType }
     * 
     * 
     */
    public List<AirspaceLayerPropertyType> getVerticalExtent() {
        if (verticalExtent == null) {
            verticalExtent = new ArrayList<AirspaceLayerPropertyType>();
        }
        return this.verticalExtent;
    }

    /**
     * Gets the value of the point property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the point property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AerialRefuellingPointPropertyType }
     * 
     * 
     */
    public List<AerialRefuellingPointPropertyType> getPoint() {
        if (point == null) {
            point = new ArrayList<AerialRefuellingPointPropertyType>();
        }
        return this.point;
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
     * {@link AerialRefuellingAnchorType.Extension }
     * 
     * 
     */
    public List<AerialRefuellingAnchorType.Extension> getExtension() {
        if (extension == null) {
            extension = new ArrayList<AerialRefuellingAnchorType.Extension>();
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
     *         &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractAerialRefuellingAnchorExtension"/>
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
        "abstractAerialRefuellingAnchorExtension"
    })
    public static class Extension {

        @XmlElement(name = "AbstractAerialRefuellingAnchorExtension", required = true)
        protected AbstractExtensionType abstractAerialRefuellingAnchorExtension;
        @XmlAttribute(name = "owns")
        protected Boolean owns;

        /**
         * Gets the value of the abstractAerialRefuellingAnchorExtension property.
         * 
         * @return
         *     possible object is
         *     {@link AbstractExtensionType }
         *     
         */
        public AbstractExtensionType getAbstractAerialRefuellingAnchorExtension() {
            return abstractAerialRefuellingAnchorExtension;
        }

        /**
         * Sets the value of the abstractAerialRefuellingAnchorExtension property.
         * 
         * @param value
         *     allowed object is
         *     {@link AbstractExtensionType }
         *     
         */
        public void setAbstractAerialRefuellingAnchorExtension(AbstractExtensionType value) {
            this.abstractAerialRefuellingAnchorExtension = value;
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
