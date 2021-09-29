package com.dlex.OOC.Week3.OldMacDonaldSong;

public abstract class Animal {

    private final String name;
    private final String sound;

    Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    String getName() {
        return this.name;
    }

    String getSound() {
        return this.sound;
    }

    @Override
    public String toString() {
        return getName().toLowerCase() + ": " + getSound().toLowerCase();
    }
}
