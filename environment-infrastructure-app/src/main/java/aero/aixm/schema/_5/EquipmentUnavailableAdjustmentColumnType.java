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
 * <p>Java class for EquipmentUnavailableAdjustmentColumnType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EquipmentUnavailableAdjustmentColumnType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMObjectType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.aixm.aero/schema/5.1}EquipmentUnavailableAdjustmentColumnPropertyGroup"/>
 *         &lt;element name="extension" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractEquipmentUnavailableAdjustmentColumnExtension"/>
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
@XmlType(name = "EquipmentUnavailableAdjustmentColumnType", propOrder = {
    "guidanceEquipment",
    "landingSystemLights",
    "equipmentRVR",
    "visibilityAdjustment",
    "approachLightingInoperative",
    "annotation",
    "extension"
})
public class EquipmentUnavailableAdjustmentColumnType
    extends AbstractAIXMObjectType
{

    @XmlElementRef(name = "guidanceEquipment", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodeApproachType> guidanceEquipment;
    @XmlElementRef(name = "landingSystemLights", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodeYesNoType> landingSystemLights;
    @XmlElementRef(name = "equipmentRVR", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodeYesNoType> equipmentRVR;
    @XmlElementRef(name = "visibilityAdjustment", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValDistanceVerticalType> visibilityAdjustment;
    @XmlElementRef(name = "approachLightingInoperative", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodeYesNoType> approachLightingInoperative;
    @XmlElement(nillable = true)
    protected List<NotePropertyType> annotation;
    protected List<EquipmentUnavailableAdjustmentColumnType.Extension> extension;

    /**
     * Gets the value of the guidanceEquipment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodeApproachType }{@code >}
     *     
     */
    public JAXBElement<CodeApproachType> getGuidanceEquipment() {
        return guidanceEquipment;
    }

    /**
     * Sets the value of the guidanceEquipment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodeApproachType }{@code >}
     *     
     */
    public void setGuidanceEquipment(JAXBElement<CodeApproachType> value) {
        this.guidanceEquipment = value;
    }

    /**
     * Gets the value of the landingSystemLights property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodeYesNoType }{@code >}
     *     
     */
    public JAXBElement<CodeYesNoType> getLandingSystemLights() {
        return landingSystemLights;
    }

    /**
     * Sets the value of the landingSystemLights property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodeYesNoType }{@code >}
     *     
     */
    public void setLandingSystemLights(JAXBElement<CodeYesNoType> value) {
        this.landingSystemLights = value;
    }

    /**
     * Gets the value of the equipmentRVR property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodeYesNoType }{@code >}
     *     
     */
    public JAXBElement<CodeYesNoType> getEquipmentRVR() {
        return equipmentRVR;
    }

    /**
     * Sets the value of the equipmentRVR property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodeYesNoType }{@code >}
     *     
     */
    public void setEquipmentRVR(JAXBElement<CodeYesNoType> value) {
        this.equipmentRVR = value;
    }

    /**
     * Gets the value of the visibilityAdjustment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValDistanceVerticalType }{@code >}
     *     
     */
    public JAXBElement<ValDistanceVerticalType> getVisibilityAdjustment() {
        return visibilityAdjustment;
    }

    /**
     * Sets the value of the visibilityAdjustment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValDistanceVerticalType }{@code >}
     *     
     */
    public void setVisibilityAdjustment(JAXBElement<ValDistanceVerticalType> value) {
        this.visibilityAdjustment = value;
    }

    /**
     * Gets the value of the approachLightingInoperative property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodeYesNoType }{@code >}
     *     
     */
    public JAXBElement<CodeYesNoType> getApproachLightingInoperative() {
        return approachLightingInoperative;
    }

    /**
     * Sets the value of the approachLightingInoperative property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodeYesNoType }{@code >}
     *     
     */
    public void setApproachLightingInoperative(JAXBElement<CodeYesNoType> value) {
        this.approachLightingInoperative = value;
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
     * {@link EquipmentUnavailableAdjustmentColumnType.Extension }
     * 
     * 
     */
    public List<EquipmentUnavailableAdjustmentColumnType.Extension> getExtension() {
        if (extension == null) {
            extension = new ArrayList<EquipmentUnavailableAdjustmentColumnType.Extension>();
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
     *         &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractEquipmentUnavailableAdjustmentColumnExtension"/>
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
        "abstractEquipmentUnavailableAdjustmentColumnExtension"
    })
    public static class Extension {

        @XmlElement(name = "AbstractEquipmentUnavailableAdjustmentColumnExtension", required = true)
        protected AbstractExtensionType abstractEquipmentUnavailableAdjustmentColumnExtension;
        @XmlAttribute(name = "owns")
        protected Boolean owns;

        /**
         * Gets the value of the abstractEquipmentUnavailableAdjustmentColumnExtension property.
         * 
         * @return
         *     possible object is
         *     {@link AbstractExtensionType }
         *     
         */
        public AbstractExtensionType getAbstractEquipmentUnavailableAdjustmentColumnExtension() {
            return abstractEquipmentUnavailableAdjustmentColumnExtension;
        }

        /**
         * Sets the value of the abstractEquipmentUnavailableAdjustmentColumnExtension property.
         * 
         * @param value
         *     allowed object is
         *     {@link AbstractExtensionType }
         *     
         */
        public void setAbstractEquipmentUnavailableAdjustmentColumnExtension(AbstractExtensionType value) {
            this.abstractEquipmentUnavailableAdjustmentColumnExtension = value;
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
