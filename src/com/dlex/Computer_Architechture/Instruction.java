package com.dlex.Computer_Architechture;

public class Instruction {
	private final int step;
	private final String opcode;
	private final Register register;
	private final String operand2;
	private int value;
	private final int clockCycle;

	public Instruction(int step, String opcode, Register register, int clockCycle) {
		this.step = step;
		this.opcode = opcode;
		this.register = register;
		this.operand2 = "";
		this.value = register.getValue();
		this.clockCycle = clockCycle;
	}

	public Instruction(int step, String opcode, Register register, String operand2, int clockCycle) {
		this.step = step;
		this.opcode = opcode;
		this.register = register;
		this.operand2 = operand2;
		this.value = register.getValue();
		this.clockCycle = clockCycle;
	}

	public String opcode5bit() {
		return switch (this.opcode) {
			case "mov" -> "00001";
			case "add" -> "00010";
			case "mul" -> "00100";
			case "sub" -> "00011";
			case "div" -> "00101";
			default -> "";
		};
	}

	public String valueTo16bit() {
		if (value >= 0) {
			return String.format("%016d", Integer.valueOf(Integer.toBinaryString(value)));
		} else {
			String sixteenBitVal = Integer.toBinaryString(value);
			return sixteenBitVal.substring(sixteenBitVal.length()-16, sixteenBitVal.length());
		}
	}

	public Register getRegister() {
		return register;
	}

	public int getClockCycle() {
		return clockCycle;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		if (this.operand2.equals("")) {
			return String.format("%s%d%-10s%-5s%-4s,  %-5d%-7s%-5s%-22s%d", "[", this.step, "]", this.opcode,
					this.register.getRegisterAddress(), this.value, opcode5bit(), this.register.addressTo3Bit(),
					valueTo16bit(), this.clockCycle);
		} else {
			return String.format("%s%d%-10s%-5s%-4s,  %-5s%-7s%-5s%-22s%d", "[", this.step, "]", this.opcode,
					this.register.getRegisterAddress(), this.operand2, opcode5bit(), this.register.addressTo3Bit(),
					valueTo16bit(), this.clockCycle);
		}

	}
}
