package com.parkly.main;
import java.util.ArrayList;
import java.util.List;

public class Zoo implements Updatable {
    private List<Enclosure> enclosures;

    public Zoo() {
        this.enclosures = new ArrayList<Enclosure>();
    }

    public void addEnclosure(Enclosure enclosure) {
        this.enclosures.add(enclosure);
    }

    @Override
    public void update() {
        for(Enclosure enclosure : enclosures) enclosure.update();
    }

    public void addAnimal(Animal animal) {
        for(Enclosure enclosure : enclosures) {
            if(enclosure.species == animal.getSpecies()) {
                enclosure.addAnimal(animal);
                break;
            }
        }
        Enclosure newEnclosure = new Enclosure(animal.getSpecies());
        newEnclosure.addAnimal(animal);
        enclosures.add(newEnclosure);
    }

    public void removeAnimal(Animal animal) {
        for(Enclosure enclosure : enclosures) {
            if(enclosure.removeAnimal(animal)) break;
        }
    }
}
