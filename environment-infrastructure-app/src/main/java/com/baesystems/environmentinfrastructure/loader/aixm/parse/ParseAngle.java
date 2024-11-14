package com.baesystems.environmentinfrastructure.loader.aixm.parse;

import javax.xml.bind.JAXBElement;

import com.baesystems.environmentinfrastructure.basictypes.AngleWithAccuracy;
import com.baesystems.environmentinfrastructure.basictypes.MagneticVariation;
import com.baesystems.environmentinfrastructure.loader.aixm.AIXMParseException;
import com.baesystems.environmentinfrastructure.types.NorthReferenceCode;

import net.opengis.gml._3.AngleType;
import aero.aixm.schema._5.CodeBearingType;
import aero.aixm.schema._5.CodeCourseType;
import aero.aixm.schema._5.CodeNorthReferenceType;
import aero.aixm.schema._5.ValAngleType;
import aero.aixm.schema._5.ValBearingType;
import aero.aixm.schema._5.ValMagneticVariationChangeType;
import aero.aixm.schema._5.ValMagneticVariationType;
import aero.aixm.schema._5.ValSlopeType;
import com.baesystems.environmentinfrastructure.basictypes.angle.Angle;
import com.baesystems.environmentinfrastructure.basictypes.angle.AngleUnit;
import com.baesystems.environmentinfrastructure.basictypes.angle.Bearing;
import com.baesystems.environmentinfrastructure.basictypes.angle.BearingType;
import com.baesystems.environmentinfrastructure.basictypes.angle.Course;
import com.baesystems.environmentinfrastructure.basictypes.angle.MagCourse;
import com.baesystems.environmentinfrastructure.basictypes.angle.TrueTrack;

public class ParseAngle {
	public static Angle angleTypeToAngle(AngleType angle) {
		if(angle != null) {
			if(angle.getUom().equals("rad")) {
				return new Angle(angle.getValue(), AngleUnit.RADIANS);
			} else {
				return new Angle(angle.getValue(), AngleUnit.DEGREES);
			}
		} else {
			return null;
		}
	}

	public static BearingType codeBearingTypeToBearingType(JAXBElement<CodeBearingType> bearingType) {
		if(bearingType != null && bearingType.getValue() != null) {
			String bearingTypeString = bearingType.getValue().getValue();
			for(BearingType bearingTypeEnum : BearingType.values()) {
				if(bearingTypeEnum.toString().equals(bearingTypeString)) {
					return bearingTypeEnum;
				}
			}
		}
		return null;
	}
	
	public static Course courseToCourse(JAXBElement<ValBearingType> course, JAXBElement<CodeCourseType> courseType, Angle magneticVariation) {
		if(course != null && course.getValue() != null && courseType != null && courseType.getValue() != null) {
			if(courseType.getValue().getValue().equals("TRUE_TRACK")) {
				return new TrueTrack(valBearingTypeToAngle(course));
			} else if(courseType.getValue().getValue().equals("MAG_BRG")) {
				return new MagCourse(valBearingTypeToAngle(course), magneticVariation);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public static Angle valAngleTypeToAngle(JAXBElement<ValAngleType> angle) {
		if(angle != null && angle.getValue() != null) {
			return valAngleTypeToAngle(angle.getValue());
		} else return null;
	}
	
	public static Angle valAngleTypeToAngle(ValAngleType angle) {
		if(angle != null && angle.getValue() != null) {
			return Angle.fromDegrees(angle.getValue().doubleValue());
		} else return null;
	}
	
	public static Angle valBearingTypeToAngle(JAXBElement<ValBearingType> bearing) {
		if(bearing != null && bearing.getValue() != null) {
			return valBearingTypeToAngle(bearing.getValue());
		} else {
			return null;
		}
	}
	
	public static Angle valBearingTypeToAngle(ValBearingType bearing) {
		if(bearing != null && bearing.getValue() != null) {
			return Angle.fromDegrees(bearing.getValue().doubleValue());
		} else {
			return null;
		}
	}
	
	public static AngleWithAccuracy valBearingTypeToAngleWithAccuracy(JAXBElement<ValBearingType> trueBearing, JAXBElement<ValAngleType> trueBearingAccuracy) {
		Angle angle = valBearingTypeToAngle(trueBearing);
		Angle accuracy= valAngleTypeToAngle(trueBearingAccuracy);
		if(angle != null) {
			return new AngleWithAccuracy(angle, accuracy);
		}
		return null;
	}
	
	public static Bearing valBearingTypeToBearing(JAXBElement<ValBearingType> angle, BearingType bearingType, Angle magneticVariation) throws AIXMParseException {
		try {
			return new Bearing(valBearingTypeToAngle(angle), bearingType, magneticVariation);
		} catch (Exception e) {
			throw new AIXMParseException(e.getMessage());
		}
	}
	
	public static Bearing valBearingTypeToBearing(JAXBElement<ValBearingType> angle, JAXBElement<CodeBearingType> bearingType, MagneticVariation magneticVariation) throws AIXMParseException {
		try {
			if(magneticVariation == null) {
				throw new AIXMParseException("Magnetic variation is null");
			}
			if(magneticVariation.getAngle() == null) {
				throw new AIXMParseException("Magnetic variation angle is null");
			}
			return new Bearing(valBearingTypeToAngle(angle), codeBearingTypeToBearingType(bearingType), magneticVariation.getAngle().getAngle());
		} catch (Exception e) {
			throw new AIXMParseException(e.getMessage());
		}
	}

	public static Double valMagneticVariationToAngle(ValMagneticVariationChangeType value) {
		if(value != null && value.getValue() != null) {
			return value.getValue().doubleValue();
		} else {
			return null;
		}
	}

	public static Angle valMagneticVariationTypeToAngle(ValMagneticVariationType magVar) {
		if(magVar != null && magVar.getValue() != null) {
			return Angle.fromDegrees(magVar.getValue().doubleValue());
		} else {
			return null;
		}
	}
	
	public static Angle valSlopeToAngle(JAXBElement<ValSlopeType> slope) {
		if(slope != null && slope.getValue() != null) {
			return Angle.fromDegrees(slope.getValue().getValue().doubleValue());
		}
		return null;
	}

	public static NorthReferenceCode getAngleReferenceType(CodeNorthReferenceType northReference) {
		if(northReference != null && northReference.getValue() != null) {
			return new NorthReferenceCode(northReference.getValue());
		}
		return null;
	}

	public static NorthReferenceCode getAngleReferenceType(JAXBElement<CodeNorthReferenceType> northReference) {
		if(northReference != null && northReference.getValue() != null) {
			return getAngleReferenceType(northReference.getValue());
		}
		return null;
	}
}
