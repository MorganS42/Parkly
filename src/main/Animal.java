package main;

import java.awt.*;

import graphics.DisplayObject;

public class Animal extends Displayable {
    public static final String TEXTURE = "";
    public static final int MAX_HP = 100;

    private int hunger, x, y;
    private String name;
    private AnimalSpecies species;

    public Animal(String name, AnimalSpecies species) {
        this.name = name;
        this.species = species;
        x = (int)(Math.random() * 100);
        y = (int)(Math.random() * 100);
        this.hunger = 0;
    }

    // Make animal move but not like a spastic dingo under the influence of marijuana
    public void update() {

    }

    // Shows photo
    public void display() {

    }

    //Shows some info like photos you have taken, hunger, plants it can eat, etc
    public void profile() {

    }
}
