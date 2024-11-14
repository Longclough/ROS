//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.10 at 09:50:27 AM BST 
//


package aero.aixm.schema._5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml._3.TimePrimitivePropertyType;


/**
 * Adds in the AIXM specific properties, such as 'interpretation'.
 * 
 * <p>Java class for AbstractAIXMTimeSliceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractAIXMTimeSliceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.aixm.aero/schema/5.1}AbstractAIXMTimeSliceBaseType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.aixm.aero/schema/5.1}interpretation"/>
 *         &lt;element ref="{http://www.aixm.aero/schema/5.1}sequenceNumber" minOccurs="0"/>
 *         &lt;element ref="{http://www.aixm.aero/schema/5.1}correctionNumber" minOccurs="0"/>
 *         &lt;element name="timeSliceMetadata" type="{http://www.aixm.aero/schema/5.1}FeatureTimeSliceMetadataPropertyType" minOccurs="0"/>
 *         &lt;element ref="{http://www.aixm.aero/schema/5.1}featureLifetime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractAIXMTimeSliceType", propOrder = {
    "interpretation",
    "sequenceNumber",
    "correctionNumber",
    "timeSliceMetadata",
    "featureLifetime"
})
@XmlSeeAlso({
    SpecialDateTimeSliceType.class,
    PassengerServiceTimeSliceType.class,
    ArrivalLegTimeSliceType.class,
    TaxiwayTimeSliceType.class,
    RunwayVisualRangeTimeSliceType.class,
    StandardLevelSectorTimeSliceType.class,
    InformationServiceTimeSliceType.class,
    OrganisationAuthorityTimeSliceType.class,
    CheckpointVORTimeSliceType.class,
    AirportClearanceServiceTimeSliceType.class,
    AirspaceBorderCrossingTimeSliceType.class,
    AngleIndicationTimeSliceType.class,
    GuidanceLineTimeSliceType.class,
    SeaplaneRampSiteTimeSliceType.class,
    GroundTrafficControlServiceTimeSliceType.class,
    AircraftGroundServiceTimeSliceType.class,
    UnplannedHoldingTimeSliceType.class,
    VisualGlideSlopeIndicatorTimeSliceType.class,
    AeronauticalGroundLightTimeSliceType.class,
    RunwayTimeSliceType.class,
    DMETimeSliceType.class,
    TaxiwayMarkingTimeSliceType.class,
    SecondarySurveillanceRadarTimeSliceType.class,
    RouteDMETimeSliceType.class,
    FireFightingServiceTimeSliceType.class,
    AirportHeliportTimeSliceType.class,
    ApronTimeSliceType.class,
    TACANTimeSliceType.class,
    MissedApproachLegTimeSliceType.class,
    ArrivalFeederLegTimeSliceType.class,
    RadarSystemTimeSliceType.class,
    SDFTimeSliceType.class,
    TaxiHoldingPositionTimeSliceType.class,
    NavaidTimeSliceType.class,
    UnitTimeSliceType.class,
    DistanceIndicationTimeSliceType.class,
    TaxiHoldingPositionMarkingTimeSliceType.class,
    AircraftStandTimeSliceType.class,
    PassengerLoadingBridgeTimeSliceType.class,
    CirclingAreaTimeSliceType.class,
    RunwayProtectAreaLightSystemTimeSliceType.class,
    MarkerBeaconTimeSliceType.class,
    NavigationAreaTimeSliceType.class,
    TaxiHoldingPositionLightSystemTimeSliceType.class,
    TaxiwayElementTimeSliceType.class,
    PilotControlledLightingTimeSliceType.class,
    RunwayBlastPadTimeSliceType.class,
    RoadTimeSliceType.class,
    ApproachLightingSystemTimeSliceType.class,
    VerticalStructureTimeSliceType.class,
    ElevationTimeSliceType.class,
    PrimarySurveillanceRadarTimeSliceType.class,
    StandardInstrumentDepartureTimeSliceType.class,
    RulesProceduresTimeSliceType.class,
    ApronElementTimeSliceType.class,
    AirportHeliportCollocationTimeSliceType.class,
    DeicingAreaMarkingTimeSliceType.class,
    WorkAreaTimeSliceType.class,
    DeicingAreaTimeSliceType.class,
    IntermediateLegTimeSliceType.class,
    HoldingPatternTimeSliceType.class,
    AerialRefuellingTimeSliceType.class,
    AuthorityForAirspaceTimeSliceType.class,
    FinalLegTimeSliceType.class,
    NavigationAreaRestrictionTimeSliceType.class,
    RouteSegmentTimeSliceType.class,
    SpecialNavigationStationTimeSliceType.class,
    AltimeterSourceTimeSliceType.class,
    InitialLegTimeSliceType.class,
    LocalizerTimeSliceType.class,
    CheckpointINSTimeSliceType.class,
    StandardLevelTableTimeSliceType.class,
    RadioFrequencyAreaTimeSliceType.class,
    RunwayDirectionTimeSliceType.class,
    InstrumentApproachProcedureTimeSliceType.class,
    AirportHotSpotTimeSliceType.class,
    GeoBorderTimeSliceType.class,
    RunwayElementTimeSliceType.class,
    VORTimeSliceType.class,
    RouteTimeSliceType.class,
    TouchDownLiftOffTimeSliceType.class,
    GuidanceLineMarkingTimeSliceType.class,
    GlidepathTimeSliceType.class,
    AzimuthTimeSliceType.class,
    TouchDownLiftOffLightSystemTimeSliceType.class,
    TouchDownLiftOffSafeAreaTimeSliceType.class,
    DirectionFinderTimeSliceType.class,
    RadioCommunicationChannelTimeSliceType.class,
    AirspaceTimeSliceType.class,
    NDBTimeSliceType.class,
    ApronLightSystemTimeSliceType.class,
    SurveyControlPointTimeSliceType.class,
    ApronMarkingTimeSliceType.class,
    ObstacleAreaTimeSliceType.class,
    DepartureLegTimeSliceType.class,
    RunwayCentrelinePointTimeSliceType.class,
    RunwayMarkingTimeSliceType.class,
    SpecialNavigationSystemTimeSliceType.class,
    NonMovementAreaTimeSliceType.class,
    SignificantPointInAirspaceTimeSliceType.class,
    TerminalArrivalAreaTimeSliceType.class,
    AirTrafficControlServiceTimeSliceType.class,
    AirportSuppliesServiceTimeSliceType.class,
    FloatingDockSiteTimeSliceType.class,
    AirportProtectionAreaMarkingTimeSliceType.class,
    AirTrafficManagementServiceTimeSliceType.class,
    GuidanceLineLightSystemTimeSliceType.class,
    RunwayDirectionLightSystemTimeSliceType.class,
    SearchRescueServiceTimeSliceType.class,
    SeaplaneLandingAreaTimeSliceType.class,
    ProcedureDMETimeSliceType.class,
    StandardInstrumentArrivalTimeSliceType.class,
    FlightRestrictionTimeSliceType.class,
    TouchDownLiftOffMarkingTimeSliceType.class,
    DesignatedPointTimeSliceType.class,
    MarkingBuoyTimeSliceType.class,
    HoldingAssessmentTimeSliceType.class,
    SafeAltitudeAreaTimeSliceType.class,
    RunwayProtectAreaTimeSliceType.class,
    ArrestingGearTimeSliceType.class,
    ChangeOverPointTimeSliceType.class,
    TaxiwayLightSystemTimeSliceType.class,
    PrecisionApproachRadarTimeSliceType.class,
    StandardLevelColumnTimeSliceType.class,
    StandMarkingTimeSliceType.class
})
public abstract class AbstractAIXMTimeSliceType
    extends AbstractAIXMTimeSliceBaseType
{

    @XmlElement(required = true)
    protected String interpretation;
    protected Long sequenceNumber;
    protected Long correctionNumber;
    protected FeatureTimeSliceMetadataPropertyType timeSliceMetadata;
    protected TimePrimitivePropertyType featureLifetime;

    /**
     * Gets the value of the interpretation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterpretation() {
        return interpretation;
    }

    /**
     * Sets the value of the interpretation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterpretation(String value) {
        this.interpretation = value;
    }

    /**
     * Gets the value of the sequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Sets the value of the sequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSequenceNumber(Long value) {
        this.sequenceNumber = value;
    }

    /**
     * Gets the value of the correctionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCorrectionNumber() {
        return correctionNumber;
    }

    /**
     * Sets the value of the correctionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCorrectionNumber(Long value) {
        this.correctionNumber = value;
    }

    /**
     * Gets the value of the timeSliceMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link FeatureTimeSliceMetadataPropertyType }
     *     
     */
    public FeatureTimeSliceMetadataPropertyType getTimeSliceMetadata() {
        return timeSliceMetadata;
    }

    /**
     * Sets the value of the timeSliceMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeatureTimeSliceMetadataPropertyType }
     *     
     */
    public void setTimeSliceMetadata(FeatureTimeSliceMetadataPropertyType value) {
        this.timeSliceMetadata = value;
    }

    /**
     * Gets the value of the featureLifetime property.
     * 
     * @return
     *     possible object is
     *     {@link TimePrimitivePropertyType }
     *     
     */
    public TimePrimitivePropertyType getFeatureLifetime() {
        return featureLifetime;
    }

    /**
     * Sets the value of the featureLifetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePrimitivePropertyType }
     *     
     */
    public void setFeatureLifetime(TimePrimitivePropertyType value) {
        this.featureLifetime = value;
    }

}
