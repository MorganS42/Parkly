package com.parkly.main;
import java.util.ArrayList;
import java.util.List;

public class Zoo implements Updatable {
    private List<Enclosure> enclosures;
    public int current = 0;

    public Zoo() {
        this.enclosures = new ArrayList<Enclosure>();
    }

    public void addEnclosure(Enclosure enclosure) {
        this.enclosures.add(enclosure);
    }

    @Override
    public void update() {
        // for(Enclosure enclosure : enclosures) enclosure.update();
        enclosures.get(current).update();
    }

    public void addAnimal(Animal animal) {
        for(Enclosure enclosure : enclosures) {
            if(enclosure.species.equals(animal.getSpecies())) {
                enclosure.addAnimal(animal);
                return;
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

    public void show() {
        enclosures.get(current).show();
    }

    public void hide() {
        enclosures.get(current).hide();
    }

    public void moveLeft() {
        enclosures.get(current).hide();
        if(current < enclosures.size() - 1) current++;
        enclosures.get(current).show();
    }

    public void moveRight() {
        enclosures.get(current).hide();
        if(current > 0) current--;
        enclosures.get(current).show();
    }
}
