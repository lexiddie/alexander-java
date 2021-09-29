package com.dlex.Computer_Architechture.old;

import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public static void main(String[] args) {
        String instruction = "";
        String Opcode = "";
        String Operand1 = "";
        String Operand2 = "";
        Register[] register = new Register[8];

        for (int i = 0; i < 8; i++) {
            register[i] = new Register(0, "r" + i);
        }
        ArrayList<Instruction> step = new ArrayList<Instruction>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Instruction");
        System.out.println("OpCode: mov,add,sub,mul,div");
        System.out.println("Operand 1: r0 - r7");
        System.out.println("Operand 2: r0 - r7 or a decimal");
        System.out.println("Type end 0 0 to exist");
        System.out.println("Input your data: ");
        instruction = sc.nextLine();
        int steps = 0;

        label:
        while (!(Opcode.equals("end")) && !(Operand1.equals("0")) && !(Operand2.equals("0"))) {
            if (instruction.equals("end 0 0")) {
                break;
            } else {
                String[] input = instruction.split(" ");
                Opcode = input[0];
                Operand1 = input[1];
                Operand2 = input[2];
                Register Reg = null;

                for (int i = 0; i <= register.length; i++) {
                    if (register[i].getAddress().equals(Operand1)) {
                        Reg = register[i];
                        break;
                    }
                }
                try {

                    int data = Integer.parseInt(Operand2);
                    if (Opcode.equals("mov")) {
                        assert Reg != null;
                        Reg.setData(data);
                        step.add(new Instruction(steps, Opcode, Reg, 1));
                        break;
                    } else if (Opcode.equals("add") ) {
                        assert Reg != null;
                        Reg.setData(Reg.getData() + data);
                        step.add(new Instruction(steps, Opcode, Reg, 2));
                        break;
                    }
                    if (Opcode.equals("sub") ) {
                        assert Reg != null;
                        Reg.setData(Reg.getData() - data);
                        step.add(new Instruction(steps, Opcode, Reg, 3));
                        break;
                    }
                    if (Opcode.equals("mul") ) {
                        assert Reg != null;
                        Reg.setData(Reg.getData() * data);
                        step.add(new Instruction(steps, Opcode, Reg, 34));
                        break;
                    }
                    if (Opcode.equals("div") ) {
                        assert Reg != null;
                        Reg.setData(Reg.getData() / data);
                        step.add(new Instruction(steps, Opcode, Reg, 1));
                        break;
                    }
                } catch (NumberFormatException e) {
                    Register sourceReg = null;
                    for (int j = 0; j <= register.length; j++) {
                        if (register[j].getAddress().equals(Operand2)) {
                            sourceReg = register[j];
                            break;
                        }
                    }
                    switch (Opcode) {
                        case "mov":
                            assert Reg != null;
                            assert sourceReg != null;
                            Reg.setData(sourceReg.getData());
                            step.add(new Instruction(steps, Opcode, Reg, 1, Operand2));
                            break label;
                        case "add":
                            assert Reg != null;
                            assert sourceReg != null;
                            Reg.setData(sourceReg.getData() + Reg.getData());
                            step.add(new Instruction(steps, Opcode, Reg, 2, Operand2));
                            break label;
                        case "sub":
                            assert Reg != null;
                            assert sourceReg != null;
                            Reg.setData(sourceReg.getData() - Reg.getData());
                            step.add(new Instruction(steps, Opcode, Reg, 3, Operand2));
                            break label;
                        case "mul":
                            assert Reg != null;
                            assert sourceReg != null;
                            Reg.setData(sourceReg.getData() / Reg.getData());
                            step.add(new Instruction(steps, Opcode, Reg, 4, Operand2));
                            break label;
                    }
                }
            }
            steps++;
            System.out.println();
            System.out.format("%-15s%-12s%-35s%s\n", "Steps", "Decoded:", "Encoded Instructions(24-bits):", "Clock cycles");
            for (Instruction s : step) {
                System.out.println(s.toString());
            }
            System.out.println(" ");
            System.out.println("Steps of Register");
            for (Instruction s : step) {
                System.out.format("%s  =   %d [%s]\n", s.getRegister().getAddress(), s.getData(), s.convertTo16bit());
            }
            System.out.println("Final Register Result");
            for (Register value : register) {
                System.out.format("%s  %d   [%s]\n", value.getAddress(), value.getData(),
                value.convertTo16bits());
            }
            System.out.println(" ");
            int totalClockCycle = 0;
            for (Instruction s : step) {
                totalClockCycle += s.getClockCycle();
            }
            double cpi = totalClockCycle / steps;
            System.out.println("Total CPI is: " + cpi);

        }
    }
}
