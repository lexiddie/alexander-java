package com.dlex.Computer_Architechture;

public class Register {
	private final String registerAddress;
	private int value;

	public Register(int value, String registerAddress) {
		this.registerAddress = registerAddress;

		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String valueTo16Bit() {
		if (value >= 0) {
			return String.format("%016d", Integer.valueOf(Integer.toBinaryString(value)));
		} else {
			String sixteenBitVal = Integer.toBinaryString(value);
			return sixteenBitVal.substring(sixteenBitVal.length()-16, sixteenBitVal.length());
		}
	}

	public String addressTo3Bit() {

		return switch (this.registerAddress) {
			case "r0" -> "000";
			case "r1" -> "001";
			case "r2" -> "010";
			case "r3" -> "011";
			case "r4" -> "100";
			case "r5" -> "101";
			case "r6" -> "110";
			case "r7" -> "111";
			default -> "";
		};
	}

	public String getRegisterAddress() {
		return registerAddress;
	}
}
