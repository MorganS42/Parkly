package com.parkly.main;
import java.util.ArrayList;
import java.util.List;

import com.parkly.graphics.DisplayObject;
import com.parkly.graphics.Window;

public class Enclosure extends Displayable {
    public static final int MAX_ANIMALS = 7;

    public static final String background = "background.png";
    List<Animal> animals;
    List<Plant> plants;
    AnimalSpecies species;
    
    public Enclosure(AnimalSpecies species) {
        super(new DisplayObject(background, 0, 0, Window.WIDTH, Window.HEIGHT));
        this.animals = new ArrayList<Animal>();
        this.plants = new ArrayList<Plant>();
        this.species = species;
    }

    public void addAnimal(Animal newAnimal) {
        if(animals.size() < MAX_ANIMALS) this.animals.add(newAnimal);
    }

    public void addPlant(Plant plant) {
        this.plants.add(plant);
        plant.show();
    }

    public void removePlant() {
        for(Plant plant : plants) plant.hide();
        plants.clear();
    }

    public int getPlantSize() {
        return plants.size();
    }

    public int getTargetX() {
        return plants.get(0).getX();
    }

    public void showProfile() {
        animals.get(0).showProfile();
    }

    public void hideProfile() {
        animals.get(0).hideProfile();
    }

    @Override
    public void update() {
        for(Animal animal : animals) animal.update();
        for(Plant plant : plants) plant.update();
    }

    public boolean removeAnimal(Animal animal) {
        return animals.remove(animal);
    }

    @Override
    public void show() {
        super.show();
        for(Animal animal : animals) animal.show();
        for(Plant plant : plants) plant.show();
    }

    @Override
    public void hide() {
        super.hide();
        for(Animal animal : animals) animal.hide();
        for(Plant plant : plants) plant.show();
    }
}
