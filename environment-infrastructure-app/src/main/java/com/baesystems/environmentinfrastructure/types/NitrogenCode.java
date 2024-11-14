package com.baesystems.environmentinfrastructure.types;

public class NitrogenCode {
	// A code describing the type of nitrogen supplies for aviation usage.
	public static final NitrogenCode LPNG = new NitrogenCode("LPNG"); // Low pressure nitrogen serving.
	public static final NitrogenCode HPNG = new NitrogenCode("HPNG"); // High pressure nitrogen servicing.
	public static final NitrogenCode LHNG = new NitrogenCode("LHNG"); // Low and high pressure nitrogen servicing.
	public static final NitrogenCode LNG = new NitrogenCode("LNG"); // Liquid nitrogen servicing.
	public static final NitrogenCode NGRB = new NitrogenCode("NGRB"); // Nitrogen replacement bottles.
	public static final NitrogenCode HNGRB = new NitrogenCode("HNGRB"); // High pressure nitrogen replacement bottles.
	public static final NitrogenCode LNGRB = new NitrogenCode("LNGRB"); // Low pressure nitrogen replacement bottles.
	public static final NitrogenCode NG = new NitrogenCode("NG"); // Indicates nitrogen servicing when type of servicing is unspecified.
	
	private String value;
	
	public NitrogenCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof NitrogenCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
