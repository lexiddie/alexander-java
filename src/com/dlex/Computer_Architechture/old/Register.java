package com.dlex.Computer_Architechture.old;

import java.util.Objects;

public class Register {
    private String address;
    private int data;

    public Register(int data, String address) {
        this.address = address;
        this.data = data;
    }

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public String getAddress() {
        return this.getAddress();
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String convertTo16bits() {
        if (data>=0) {
            return String.format("%016d", Integer.valueOf(Integer.toBinaryString(data)));
        } else {
            String sixteenBits = Integer.toBinaryString(data);
            return sixteenBits.substring(sixteenBits.length()-16, sixteenBits.length());
        }
    }

    public String convertAddressTo3Bit() {
        if (Objects.equals(address, "r0")) {
            return "000";
        } else if (Objects.equals(address, "r1")) {
            return "001";
        } else if (Objects.equals(address, "r2")) {
            return "010";
        } else if (Objects.equals(address, "r3")) {
            return "011";
        } else if (Objects.equals(address, "r4")) {
            return "100";
        } else if (Objects.equals(address, "r5")) {
            return "101";
        } else if (Objects.equals(address, "r6")) {
            return "110";
        } else if (Objects.equals(address, "r7")) {
            return "111";
        } else {
            return " ";
        }
    }


}
