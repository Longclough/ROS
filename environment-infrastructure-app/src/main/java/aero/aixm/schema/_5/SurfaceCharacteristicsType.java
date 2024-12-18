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
 * <p>Java class for SurfaceCharacteristicsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SurfaceCharacteristicsType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMObjectType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.aixm.aero/schema/5.1}SurfaceCharacteristicsPropertyGroup"/>
 *         &lt;element name="extension" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractSurfaceCharacteristicsExtension"/>
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
@XmlType(name = "SurfaceCharacteristicsType", propOrder = {
    "composition",
    "preparation",
    "surfaceCondition",
    "classPCN",
    "pavementTypePCN",
    "pavementSubgradePCN",
    "maxTyrePressurePCN",
    "evaluationMethodPCN",
    "classLCN",
    "weightSIWL",
    "tyrePressureSIWL",
    "weightAUW",
    "annotation",
    "extension"
})
public class SurfaceCharacteristicsType
    extends AbstractAIXMObjectType
{

    @XmlElementRef(name = "composition", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodeSurfaceCompositionType> composition;
    @XmlElementRef(name = "preparation", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodeSurfacePreparationType> preparation;
    @XmlElementRef(name = "surfaceCondition", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodeSurfaceConditionType> surfaceCondition;
    @XmlElementRef(name = "classPCN", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValPCNType> classPCN;
    @XmlElementRef(name = "pavementTypePCN", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodePCNPavementType> pavementTypePCN;
    @XmlElementRef(name = "pavementSubgradePCN", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodePCNSubgradeType> pavementSubgradePCN;
    @XmlElementRef(name = "maxTyrePressurePCN", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodePCNTyrePressureType> maxTyrePressurePCN;
    @XmlElementRef(name = "evaluationMethodPCN", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<CodePCNMethodType> evaluationMethodPCN;
    @XmlElementRef(name = "classLCN", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValLCNType> classLCN;
    @XmlElementRef(name = "weightSIWL", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValWeightType> weightSIWL;
    @XmlElementRef(name = "tyrePressureSIWL", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValPressureType> tyrePressureSIWL;
    @XmlElementRef(name = "weightAUW", namespace = "http://www.aixm.aero/schema/5.1", type = JAXBElement.class)
    protected JAXBElement<ValWeightType> weightAUW;
    @XmlElement(nillable = true)
    protected List<NotePropertyType> annotation;
    protected List<SurfaceCharacteristicsType.Extension> extension;

    /**
     * Gets the value of the composition property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodeSurfaceCompositionType }{@code >}
     *     
     */
    public JAXBElement<CodeSurfaceCompositionType> getComposition() {
        return composition;
    }

    /**
     * Sets the value of the composition property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodeSurfaceCompositionType }{@code >}
     *     
     */
    public void setComposition(JAXBElement<CodeSurfaceCompositionType> value) {
        this.composition = value;
    }

    /**
     * Gets the value of the preparation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodeSurfacePreparationType }{@code >}
     *     
     */
    public JAXBElement<CodeSurfacePreparationType> getPreparation() {
        return preparation;
    }

    /**
     * Sets the value of the preparation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodeSurfacePreparationType }{@code >}
     *     
     */
    public void setPreparation(JAXBElement<CodeSurfacePreparationType> value) {
        this.preparation = value;
    }

    /**
     * Gets the value of the surfaceCondition property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodeSurfaceConditionType }{@code >}
     *     
     */
    public JAXBElement<CodeSurfaceConditionType> getSurfaceCondition() {
        return surfaceCondition;
    }

    /**
     * Sets the value of the surfaceCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodeSurfaceConditionType }{@code >}
     *     
     */
    public void setSurfaceCondition(JAXBElement<CodeSurfaceConditionType> value) {
        this.surfaceCondition = value;
    }

    /**
     * Gets the value of the classPCN property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValPCNType }{@code >}
     *     
     */
    public JAXBElement<ValPCNType> getClassPCN() {
        return classPCN;
    }

    /**
     * Sets the value of the classPCN property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValPCNType }{@code >}
     *     
     */
    public void setClassPCN(JAXBElement<ValPCNType> value) {
        this.classPCN = value;
    }

    /**
     * Gets the value of the pavementTypePCN property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodePCNPavementType }{@code >}
     *     
     */
    public JAXBElement<CodePCNPavementType> getPavementTypePCN() {
        return pavementTypePCN;
    }

    /**
     * Sets the value of the pavementTypePCN property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodePCNPavementType }{@code >}
     *     
     */
    public void setPavementTypePCN(JAXBElement<CodePCNPavementType> value) {
        this.pavementTypePCN = value;
    }

    /**
     * Gets the value of the pavementSubgradePCN property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodePCNSubgradeType }{@code >}
     *     
     */
    public JAXBElement<CodePCNSubgradeType> getPavementSubgradePCN() {
        return pavementSubgradePCN;
    }

    /**
     * Sets the value of the pavementSubgradePCN property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodePCNSubgradeType }{@code >}
     *     
     */
    public void setPavementSubgradePCN(JAXBElement<CodePCNSubgradeType> value) {
        this.pavementSubgradePCN = value;
    }

    /**
     * Gets the value of the maxTyrePressurePCN property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodePCNTyrePressureType }{@code >}
     *     
     */
    public JAXBElement<CodePCNTyrePressureType> getMaxTyrePressurePCN() {
        return maxTyrePressurePCN;
    }

    /**
     * Sets the value of the maxTyrePressurePCN property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodePCNTyrePressureType }{@code >}
     *     
     */
    public void setMaxTyrePressurePCN(JAXBElement<CodePCNTyrePressureType> value) {
        this.maxTyrePressurePCN = value;
    }

    /**
     * Gets the value of the evaluationMethodPCN property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CodePCNMethodType }{@code >}
     *     
     */
    public JAXBElement<CodePCNMethodType> getEvaluationMethodPCN() {
        return evaluationMethodPCN;
    }

    /**
     * Sets the value of the evaluationMethodPCN property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CodePCNMethodType }{@code >}
     *     
     */
    public void setEvaluationMethodPCN(JAXBElement<CodePCNMethodType> value) {
        this.evaluationMethodPCN = value;
    }

    /**
     * Gets the value of the classLCN property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValLCNType }{@code >}
     *     
     */
    public JAXBElement<ValLCNType> getClassLCN() {
        return classLCN;
    }

    /**
     * Sets the value of the classLCN property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValLCNType }{@code >}
     *     
     */
    public void setClassLCN(JAXBElement<ValLCNType> value) {
        this.classLCN = value;
    }

    /**
     * Gets the value of the weightSIWL property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValWeightType }{@code >}
     *     
     */
    public JAXBElement<ValWeightType> getWeightSIWL() {
        return weightSIWL;
    }

    /**
     * Sets the value of the weightSIWL property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValWeightType }{@code >}
     *     
     */
    public void setWeightSIWL(JAXBElement<ValWeightType> value) {
        this.weightSIWL = value;
    }

    /**
     * Gets the value of the tyrePressureSIWL property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValPressureType }{@code >}
     *     
     */
    public JAXBElement<ValPressureType> getTyrePressureSIWL() {
        return tyrePressureSIWL;
    }

    /**
     * Sets the value of the tyrePressureSIWL property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValPressureType }{@code >}
     *     
     */
    public void setTyrePressureSIWL(JAXBElement<ValPressureType> value) {
        this.tyrePressureSIWL = value;
    }

    /**
     * Gets the value of the weightAUW property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValWeightType }{@code >}
     *     
     */
    public JAXBElement<ValWeightType> getWeightAUW() {
        return weightAUW;
    }

    /**
     * Sets the value of the weightAUW property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValWeightType }{@code >}
     *     
     */
    public void setWeightAUW(JAXBElement<ValWeightType> value) {
        this.weightAUW = value;
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
     * {@link SurfaceCharacteristicsType.Extension }
     * 
     * 
     */
    public List<SurfaceCharacteristicsType.Extension> getExtension() {
        if (extension == null) {
            extension = new ArrayList<SurfaceCharacteristicsType.Extension>();
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
     *         &lt;element ref="{http://www.aixm.aero/schema/5.1}AbstractSurfaceCharacteristicsExtension"/>
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
        "abstractSurfaceCharacteristicsExtension"
    })
    public static class Extension {

        @XmlElement(name = "AbstractSurfaceCharacteristicsExtension", required = true)
        protected AbstractExtensionType abstractSurfaceCharacteristicsExtension;
        @XmlAttribute(name = "owns")
        protected Boolean owns;

        /**
         * Gets the value of the abstractSurfaceCharacteristicsExtension property.
         * 
         * @return
         *     possible object is
         *     {@link AbstractExtensionType }
         *     
         */
        public AbstractExtensionType getAbstractSurfaceCharacteristicsExtension() {
            return abstractSurfaceCharacteristicsExtension;
        }

        /**
         * Sets the value of the abstractSurfaceCharacteristicsExtension property.
         * 
         * @param value
         *     allowed object is
         *     {@link AbstractExtensionType }
         *     
         */
        public void setAbstractSurfaceCharacteristicsExtension(AbstractExtensionType value) {
            this.abstractSurfaceCharacteristicsExtension = value;
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
