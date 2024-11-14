package com.baesystems.environmentinfrastructure.loader.aixm.parse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;

import com.baesystems.environmentinfrastructure.airspace.OperationsType;
import com.baesystems.environmentinfrastructure.application.Logger;
import com.baesystems.environmentinfrastructure.loader.aixm.AIXMParseException;
import com.baesystems.environmentinfrastructure.types.AuthorityRoleCode;
import com.baesystems.environmentinfrastructure.types.FacilityRankingCode;
import com.baesystems.environmentinfrastructure.types.ValueInterpretationCode;

import aero.aixm.schema._5.AbstractAIXMFeatureType;
import aero.aixm.schema._5.CodeAuthorityRoleType;
import aero.aixm.schema._5.CodeFacilityRankingType;
import aero.aixm.schema._5.CodeMilitaryOperationsType;
import aero.aixm.schema._5.CodeStandbyPowerType;
import aero.aixm.schema._5.CodeValueInterpretationType;
import aero.aixm.schema._5.LinguisticNotePropertyType;
import aero.aixm.schema._5.NoNumberType;
import aero.aixm.schema._5.NoSequenceType;
import aero.aixm.schema._5.NotePropertyType;
import aero.aixm.schema._5.TextDesignatorType;
import aero.aixm.schema._5.TextInstructionType;
import aero.aixm.schema._5.TextNameType;

public class ParseGeneral {

	public static String getDesignator(JAXBElement<TextDesignatorType> designator) {
		if(designator != null && designator.getValue() != null) {
			return getDesignator(designator.getValue());
		}
		return null;
	}
	
	public static String getDesignator(TextDesignatorType designator) {
		if(designator != null) {
			return designator.getValue();
		}
		return null;
	}

	public static List<String> getNote(List<NotePropertyType> value) {		
		if(value != null) {
			List<String> notes = new ArrayList<>();
			for(NotePropertyType noteProperty : value) {
				notes.addAll(getNotes(noteProperty));
			}
			return notes;
		}
		return null;
	}

	public static List<String> getNote(NotePropertyType value) {	
		if(value != null && value.getNote() != null) {
			List<String> notes = new ArrayList<>();
			notes.addAll(getNotes(value));
			return notes;
		}
		return null;
	}

	private static List<String> getNotes(NotePropertyType noteProperty) {
		List<String> notes = new ArrayList<String>();
		if(noteProperty != null && noteProperty.getNote() != null) {	
			if(noteProperty.getNote().getTranslatedNote() != null) {
				for(LinguisticNotePropertyType linguisticNoteProperty : noteProperty.getNote().getTranslatedNote()) {
					notes.add(linguisticNoteProperty.getLinguisticNote().getNote().getValue().getValue());
				}
			} else {
				Logger.log("Note format not supported");
			}
		} else {

		}
		return notes;
	}
	
	public static String getInstruction(JAXBElement<TextInstructionType> instruction) {
		if(instruction != null && instruction.getValue() != null) {
			return getInstruction(instruction.getValue());
		} 
		return null;
	}
	
	public static String getInstruction(TextInstructionType instruction) {
		if(instruction != null) {
			return instruction.getValue();
		} 
		return null;
	}

	public static OperationsType getOperationsType(CodeMilitaryOperationsType value) {
		if(value != null && value.getValue() != null) {
			if(value.getValue().equals("MIL")) {
				return OperationsType.MIL;
			} else if(value.getValue().equals("CIVIL")) {
				return OperationsType.CIVIL;
			} else {
				return OperationsType.UNKNOWN;
			}
		}
		return null;
	}

	public static String getUuid(AbstractAIXMFeatureType feature) {		
		try {
			return tryGetUuid(feature);
		} catch (AIXMParseException e) {
			return UUID.randomUUID().toString();
		}	
	}

	public static String tryGetUuid(AbstractAIXMFeatureType feature) throws AIXMParseException {
		if(feature.getIdentifier() != null) {
			return feature.getIdentifier().getValue().toLowerCase();
		} else if (feature.getId() != null) {
			return feature.getId().toLowerCase();
		} else {
			throw new AIXMParseException("No unique identifier");
		}
	}

	public static String getName(JAXBElement<TextNameType> name) {
		if(name != null && name.getValue() != null) {
			getName(name.getValue());
		}
		return null;
	}

	public static String getName(TextNameType name) {
		if(name != null) {
			return name.getValue();
		}
		return null;
	}

	public static Long getNumber(JAXBElement<NoNumberType> number) {
		if(number != null && number.getValue() != null) {
			return getNumber(number.getValue());
		}
		return null;
	}

	public static Long getNumber(NoNumberType number) {
		if(number != null) {
			return number.getValue();
		}
		return null;
	}

	public static Long getSequenceNumber(JAXBElement<NoSequenceType> number) {
		if(number != null && number.getValue() != null) {
			return getSequenceNumber(number.getValue());
		}
		return null;
	}
	
	public static Long getSequenceNumber(NoSequenceType number) {
		if(number != null) {
			return number.getValue();
		}
		return null;
	}

	public static String getStandbyPowerType(CodeStandbyPowerType type) {
		if(type != null) {
			return type.getValue();
		}
		return null;
	}
	
	public static ValueInterpretationCode getInterpretation(JAXBElement<CodeValueInterpretationType> interpretation) {
		if(interpretation != null && interpretation.getValue() != null) {
			return new ValueInterpretationCode(interpretation.getValue().getValue());
		}
		return null;
	}
	
	public static AuthorityRoleCode getRole(JAXBElement<CodeAuthorityRoleType> role) {
		if(role != null && role.getValue() != null) {
			return new AuthorityRoleCode(role.getValue().getValue());
		}
		return null;
	}
	
	public static FacilityRankingCode getRank(CodeFacilityRankingType rank) {
		if(rank != null && rank.getValue() != null) {
			return new FacilityRankingCode(rank.getValue());
		}
		return null;
	}
	
	public static FacilityRankingCode getRank(JAXBElement<CodeFacilityRankingType> rank) {
		if(rank != null && rank.getValue() != null) {
			return getRank(rank.getValue());
		}
		return null;
	}
}
