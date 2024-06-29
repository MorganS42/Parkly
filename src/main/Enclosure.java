package main;
import java.util.ArrayList;
import java.util.List;

import graphics.DisplayObject;
import graphics.Window;

public class Enclosure extends Displayable {
    public static final int MAX_ANIMALS = 7;

    public static final String background = "enclosure.png";
    List<Animal> animals;
    AnimalSpecies species;
    
    public Enclosure(AnimalSpecies species) {
        super(new DisplayObject(background, 0, 0, Window.WIDTH, Window.HEIGHT));
        this.animals = new ArrayList<Animal>();
        this.species = species;
    }

    void addAnimal(Animal newAnimal) {
        if(animals.size() < MAX_ANIMALS) this.animals.add(newAnimal);
    }

    @Override
    public void update() {
        for(Animal animal : animals) animal.update();
    }

    public boolean removeAnimal(Animal animal) {
        return animals.remove(animal);
    }
}
