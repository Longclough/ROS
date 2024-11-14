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
 * Adds the FeatureMetadata, which is common to all AIXM features
 * 
 * <p>Java class for AbstractAIXMFeatureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractAIXMFeatureType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMFeatureBaseType">
 *       &lt;sequence>
 *         &lt;element name="featureMetadata" type="{http://www.aixm.aero/schema/5.1}FeatureMetadataPropertyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractAIXMFeatureType", propOrder = {
    "featureMetadata"
})
@XmlSeeAlso({
    ObstacleAreaType.class,
    RunwayCentrelinePointType.class,
    AirspaceBorderCrossingType.class,
    AirportHeliportCollocationType.class,
    NavaidType.class,
    ArrestingGearType.class,
    PilotControlledLightingType.class,
    AeronauticalGroundLightType.class,
    ApronType.class,
    NonMovementAreaType.class,
    SafeAltitudeAreaType.class,
    TaxiHoldingPositionType.class,
    AirportHotSpotType.class,
    PassengerLoadingBridgeType.class,
    AirspaceType.class,
    RadioFrequencyAreaType.class,
    MarkingBuoyType.class,
    ProcedureDMEType.class,
    WorkAreaType.class,
    SeaplaneRampSiteType.class,
    UnplannedHoldingType.class,
    DistanceIndicationType.class,
    DeicingAreaType.class,
    SpecialDateType.class,
    FlightRestrictionType.class,
    ApronElementType.class,
    TaxiwayType.class,
    RunwayBlastPadType.class,
    SpecialNavigationStationType.class,
    RunwayType.class,
    RouteSegmentType.class,
    AirportHeliportType.class,
    GuidanceLineType.class,
    ChangeOverPointType.class,
    RunwayElementType.class,
    RadarSystemType.class,
    AuthorityForAirspaceType.class,
    StandardLevelColumnType.class,
    AerialRefuellingType.class,
    AltimeterSourceType.class,
    AbstractAirportHeliportProtectionAreaType.class,
    TerminalArrivalAreaType.class,
    AircraftStandType.class,
    StandardLevelTableType.class,
    RulesProceduresType.class,
    NavigationAreaType.class,
    TouchDownLiftOffType.class,
    RouteType.class,
    SignificantPointInAirspaceType.class,
    FloatingDockSiteType.class,
    HoldingAssessmentType.class,
    RadioCommunicationChannelType.class,
    HoldingPatternType.class,
    RunwayVisualRangeType.class,
    CirclingAreaType.class,
    GeoBorderType.class,
    SeaplaneLandingAreaType.class,
    AbstractNavaidEquipmentType.class,
    UnitType.class,
    StandardLevelSectorType.class,
    SurveyControlPointType.class,
    SpecialNavigationSystemType.class,
    OrganisationAuthorityType.class,
    AbstractRadarEquipmentType.class,
    NavigationAreaRestrictionType.class,
    AbstractSegmentLegType.class,
    DesignatedPointType.class,
    AbstractNavigationSystemCheckpointType.class,
    RouteDMEType.class,
    TaxiwayElementType.class,
    RoadType.class,
    VerticalStructureType.class,
    AngleIndicationType.class,
    AbstractGroundLightSystemType.class,
    RunwayDirectionType.class,
    AbstractProcedureType.class,
    AbstractServiceType.class,
    AbstractMarkingType.class
})
public abstract class AbstractAIXMFeatureType
    extends AbstractAIXMFeatureBaseType
{

    protected FeatureMetadataPropertyType featureMetadata;

    /**
     * Gets the value of the featureMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link FeatureMetadataPropertyType }
     *     
     */
    public FeatureMetadataPropertyType getFeatureMetadata() {
        return featureMetadata;
    }

    /**
     * Sets the value of the featureMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeatureMetadataPropertyType }
     *     
     */
    public void setFeatureMetadata(FeatureMetadataPropertyType value) {
        this.featureMetadata = value;
    }

}