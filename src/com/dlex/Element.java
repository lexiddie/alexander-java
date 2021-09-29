package com.dlex;

public class Element {
    private String name;
    private String symbol;
    private int number;
    private int period;
    private int group;
    private double mass;

    public Element(String elementName, String elementSymbol, int elementNumber, int elementPeriod, int elementGroup, double elementMass ) {
        this.name = elementName;
        this.symbol = elementSymbol;
        this.number = elementNumber;
        this.period = elementPeriod;
        this.group = elementGroup;
        this.mass = elementMass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %f", name, symbol, number, period, group, mass);
    }
}
