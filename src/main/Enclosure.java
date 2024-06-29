package main;
import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    public static final int MAX_ANIMALS = 7;

    String background;
    List<Animal> animalsInEnclosure;
    
    public Enclosure(String background) {
        this.background = background;
        this.animalsInEnclosure = new ArrayList<Animal>();
    }

    void displayBackground() {
        // Display image of background
    }

    void addAnimal(Animal newAnimal) {
        this.animalsInEnclosure.add(newAnimal);
    }

    void spawnAnimals() {
        // Display image of animal at the x and y coords of the animal
    }
}
