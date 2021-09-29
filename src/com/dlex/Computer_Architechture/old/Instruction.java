package com.dlex.Computer_Architechture.old;

public class Instruction {
    private int step;
    private String opcode;
    private String Operand2;
    private int data;
    private int clockCycle;
    private Register register;

    public Instruction(int step, String opcode, Register register, int clockCycle) {
        this.setStep(step);
        this.opcode = opcode;
        this.setRegister(register);
        this.setOperand2(null);
        this.setData(register.getData());
        this.setClockCycle(clockCycle);
    }

    public Instruction(int step, String opcode, Register register, int clockCycle, String Operand2) {
        this.setStep(step);
        this.opcode = opcode;
        this.setRegister(register);
        this.setOperand2(Operand2);
        this.setData(register.getData());
        this.setClockCycle(clockCycle);
    }

    public String opcode5bit() {
        if (opcode=="mov") {
            return "00001";
        } else if (opcode=="add") {
            return "00011";
        } else if (opcode=="sub") {
            return "00101";
        } else if (opcode=="mul") {
            return "00111";
        } else if (opcode=="div") {
            return "01001";
        } else {
            return "";
        }
    }
    public String convertTo16bit() {
        if (data>=0) {
            return String.format("%016d",Integer.valueOf(Integer.toBinaryString(data)));
        } else {
            String sixteenBit = Integer.toBinaryString(data);
            return sixteenBit.substring(sixteenBit.length()-16, sixteenBit.length());
        }
    }
    public String getOpcode() {
        return this.opcode;
    }
    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getOperand2() {
        return Operand2;
    }

    public void setOperand2(String operand2) {
        Operand2 = operand2;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getClockCycle() {
        return clockCycle;
    }

    public void setClockCycle(int clockCycle) {
        this.clockCycle = clockCycle;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
    public String toString() {
        if (this.Operand2.equals("")) {
            return String.format("%s%d%-10s%-5s%-4s,  %-5d%-7s%-5s%-22s%d", "[", this.step, "]", this.opcode,
                    this.register.getAddress(), this.data, opcode5bit(), this.register.convertAddressTo3Bit(),
                    convertTo16bit(), this.clockCycle);
        } else {
            return String.format("%s%d%-10s%-5s%-4s,  %-5s%-7s%-5s%-22s%d", "[", this.step, "]", this.opcode,
                    this.register.getAddress(), this.Operand2, opcode5bit(), this.register.convertAddressTo3Bit(),
                    convertTo16bit(), this.clockCycle);
        }
    }
}
