//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.10 at 09:50:27 AM BST 
//


package org.isotc211._2005.gmd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.isotc211._2005.gco.AbstractObjectType;
import org.isotc211._2005.gco.CharacterStringPropertyType;
import org.isotc211._2005.gco.DatePropertyType;


/**
 * Standardized resource reference
 * 
 * <p>Java class for CI_Citation_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CI_Citation_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.isotc211.org/2005/gco}AbstractObject_Type">
 *       &lt;sequence>
 *         &lt;element name="title" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType"/>
 *         &lt;element name="alternateTitle" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.isotc211.org/2005/gmd}CI_Date_PropertyType" maxOccurs="unbounded"/>
 *         &lt;element name="edition" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *         &lt;element name="editionDate" type="{http://www.isotc211.org/2005/gco}Date_PropertyType" minOccurs="0"/>
 *         &lt;element name="identifier" type="{http://www.isotc211.org/2005/gmd}MD_Identifier_PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="citedResponsibleParty" type="{http://www.isotc211.org/2005/gmd}CI_ResponsibleParty_PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="presentationForm" type="{http://www.isotc211.org/2005/gmd}CI_PresentationFormCode_PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="series" type="{http://www.isotc211.org/2005/gmd}CI_Series_PropertyType" minOccurs="0"/>
 *         &lt;element name="otherCitationDetails" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *         &lt;element name="collectiveTitle" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *         &lt;element name="ISBN" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *         &lt;element name="ISSN" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CI_Citation_Type", propOrder = {
    "title",
    "alternateTitle",
    "date",
    "edition",
    "editionDate",
    "identifier",
    "citedResponsibleParty",
    "presentationForm",
    "series",
    "otherCitationDetails",
    "collectiveTitle",
    "isbn",
    "issn"
})
public class CICitationType
    extends AbstractObjectType
{

    @XmlElement(required = true)
    protected CharacterStringPropertyType title;
    protected List<CharacterStringPropertyType> alternateTitle;
    @XmlElement(required = true)
    protected List<CIDatePropertyType> date;
    protected CharacterStringPropertyType edition;
    protected DatePropertyType editionDate;
    protected List<MDIdentifierPropertyType> identifier;
    protected List<CIResponsiblePartyPropertyType> citedResponsibleParty;
    protected List<CIPresentationFormCodePropertyType> presentationForm;
    protected CISeriesPropertyType series;
    protected CharacterStringPropertyType otherCitationDetails;
    protected CharacterStringPropertyType collectiveTitle;
    @XmlElement(name = "ISBN")
    protected CharacterStringPropertyType isbn;
    @XmlElement(name = "ISSN")
    protected CharacterStringPropertyType issn;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setTitle(CharacterStringPropertyType value) {
        this.title = value;
    }

    /**
     * Gets the value of the alternateTitle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alternateTitle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlternateTitle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CharacterStringPropertyType }
     * 
     * 
     */
    public List<CharacterStringPropertyType> getAlternateTitle() {
        if (alternateTitle == null) {
            alternateTitle = new ArrayList<CharacterStringPropertyType>();
        }
        return this.alternateTitle;
    }

    /**
     * Gets the value of the date property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the date property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CIDatePropertyType }
     * 
     * 
     */
    public List<CIDatePropertyType> getDate() {
        if (date == null) {
            date = new ArrayList<CIDatePropertyType>();
        }
        return this.date;
    }

    /**
     * Gets the value of the edition property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getEdition() {
        return edition;
    }

    /**
     * Sets the value of the edition property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setEdition(CharacterStringPropertyType value) {
        this.edition = value;
    }

    /**
     * Gets the value of the editionDate property.
     * 
     * @return
     *     possible object is
     *     {@link DatePropertyType }
     *     
     */
    public DatePropertyType getEditionDate() {
        return editionDate;
    }

    /**
     * Sets the value of the editionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatePropertyType }
     *     
     */
    public void setEditionDate(DatePropertyType value) {
        this.editionDate = value;
    }

    /**
     * Gets the value of the identifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the identifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MDIdentifierPropertyType }
     * 
     * 
     */
    public List<MDIdentifierPropertyType> getIdentifier() {
        if (identifier == null) {
            identifier = new ArrayList<MDIdentifierPropertyType>();
        }
        return this.identifier;
    }

    /**
     * Gets the value of the citedResponsibleParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the citedResponsibleParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCitedResponsibleParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CIResponsiblePartyPropertyType }
     * 
     * 
     */
    public List<CIResponsiblePartyPropertyType> getCitedResponsibleParty() {
        if (citedResponsibleParty == null) {
            citedResponsibleParty = new ArrayList<CIResponsiblePartyPropertyType>();
        }
        return this.citedResponsibleParty;
    }

    /**
     * Gets the value of the presentationForm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the presentationForm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPresentationForm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CIPresentationFormCodePropertyType }
     * 
     * 
     */
    public List<CIPresentationFormCodePropertyType> getPresentationForm() {
        if (presentationForm == null) {
            presentationForm = new ArrayList<CIPresentationFormCodePropertyType>();
        }
        return this.presentationForm;
    }

    /**
     * Gets the value of the series property.
     * 
     * @return
     *     possible object is
     *     {@link CISeriesPropertyType }
     *     
     */
    public CISeriesPropertyType getSeries() {
        return series;
    }

    /**
     * Sets the value of the series property.
     * 
     * @param value
     *     allowed object is
     *     {@link CISeriesPropertyType }
     *     
     */
    public void setSeries(CISeriesPropertyType value) {
        this.series = value;
    }

    /**
     * Gets the value of the otherCitationDetails property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getOtherCitationDetails() {
        return otherCitationDetails;
    }

    /**
     * Sets the value of the otherCitationDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setOtherCitationDetails(CharacterStringPropertyType value) {
        this.otherCitationDetails = value;
    }

    /**
     * Gets the value of the collectiveTitle property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getCollectiveTitle() {
        return collectiveTitle;
    }

    /**
     * Sets the value of the collectiveTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setCollectiveTitle(CharacterStringPropertyType value) {
        this.collectiveTitle = value;
    }

    /**
     * Gets the value of the isbn property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getISBN() {
        return isbn;
    }

    /**
     * Sets the value of the isbn property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setISBN(CharacterStringPropertyType value) {
        this.isbn = value;
    }

    /**
     * Gets the value of the issn property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getISSN() {
        return issn;
    }

    /**
     * Sets the value of the issn property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setISSN(CharacterStringPropertyType value) {
        this.issn = value;
    }

}
