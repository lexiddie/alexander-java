package com.dlex.Computer_Architechture;

import java.util.ArrayList;

public class InitializeData {

    private String opcode = "";
    private String operand = "";
    private String operand2 = "";
    private Register desReg = null;
    private final Register[] registers = new Register[8];
    private final ArrayList<Instruction> steps = new ArrayList<>();
    private int step = 0;

    public InitializeData() {
        fillRegister();
    }

    public boolean verification(String readline) {
        if (readline.equals("end 0 0")) {
            resultPrint();
            return true;
        } else {
            String[] Input = readline.split(" ");
            opcode = Input[0];
            operand = Input[1];
            operand2 = Input[2];
            registerAssignment();
            computeResult();
            step ++;
            return false;
        }
    }

    private void fillRegister() {
        for (int i = 0; i <= 7; i++) {
            registers[i] = new Register(0, "r" + i);
        }
    }

    private void registerAssignment() {
        for (int k = 0; k <= registers.length; k++) {
            if ((registers[k].getRegisterAddress().equals(operand))) {
                desReg = registers[k];
                break;
            }
        }
    }

    private void resultPrint() {
        System.out.println();
        System.out.format("%-15s%-12s%-35s%s\n", "Steps", "Decoded:", "Encoded Instructions(24-bits):", "Clock cycles");
        for (Instruction s : steps) {
            System.out.println(s.toString());
        }
        System.out.println("\n");
        System.out.println("Steps of Register");
        for (Instruction s : steps) {
            System.out.format("%s  =   %d [%s]\n", s.getRegister().getRegisterAddress(), s.getValue(),
                    s.valueTo16bit());
        }
        System.out.println("\n\n\n");
        System.out.println("Final Register Result");
        for (Register register : registers) {
            System.out.format("%s  %d   [%s]\n", register.getRegisterAddress(), register.getValue(), register.valueTo16Bit());
        }
        System.out.println("\n");
        int totalClockCycle = 0;
        for (Instruction s : steps) {
            totalClockCycle += s.getClockCycle();
        }
        double cpi = totalClockCycle / step;
        System.out.println("CPI of the program : " + cpi);
        System.out.println("-------------------------------------------------------------------------");
    }

    private void computeResult() {
        try {
            int value = Integer.parseInt(operand2);
            switch (opcode) {
                case "mov" -> {
                    desReg.setValue(value);
                    steps.add(new Instruction(step, opcode, desReg, 1));
                }
                case "add" -> {
                    desReg.setValue(desReg.getValue() + value);
                    steps.add(new Instruction(step, opcode, desReg, 2));
                }
                case "sub" -> {
                    desReg.setValue(desReg.getValue() - value);
                    steps.add(new Instruction(step, opcode, desReg, 3));
                }
                case "mul" -> {
                    desReg.setValue(desReg.getValue() * value);
                    steps.add(new Instruction(step, opcode, desReg, 4));
                }
                case "div" -> {
                    desReg.setValue(desReg.getValue() / value);
                    steps.add(new Instruction(step, opcode, desReg, 4));
                }
            }
        } catch (NumberFormatException e) {
            Register sourceReg = null;
            for (int j = 0; j <= registers.length; j++) {
                if (registers[j].getRegisterAddress().equals(operand2)) {
                    sourceReg = registers[j];
                    break;
                }
            }
            switch (opcode) {
                case "mov" -> {
                    assert sourceReg != null;
                    desReg.setValue(sourceReg.getValue());
                    steps.add(new Instruction(step, opcode, desReg, operand2, 1));
                }
                case "add" -> {
                    assert sourceReg != null;
                    desReg.setValue(desReg.getValue() + sourceReg.getValue());
                    steps.add(new Instruction(step, opcode, desReg, operand2, 2));
                }
                case "sub" -> {
                    assert sourceReg != null;
                    desReg.setValue(desReg.getValue() - sourceReg.getValue());
                    steps.add(new Instruction(step, opcode, desReg, operand2, 3));
                }
                case "mul" -> {
                    assert sourceReg != null;
                    desReg.setValue(desReg.getValue() * sourceReg.getValue());
                    steps.add(new Instruction(step, opcode, desReg, operand2, 4));
                }
                case "div" -> {
                    assert sourceReg != null;
                    desReg.setValue(desReg.getValue() / sourceReg.getValue());
                    steps.add(new Instruction(step, opcode, desReg, operand2, 4));
                }
            }
        }
    }

}
