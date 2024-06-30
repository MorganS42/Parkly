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
        for(Enclosure enclosure : enclosures) enclosure.update();
        //enclosures.get(current).update();
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

    public void removePlant() {
        enclosures.get(current).removePlant();
    }

    public int getPlantSize() {
        return enclosures.get(current).getPlantSize();
    }

    public int getTargetX() {
        return enclosures.get(current).getTargetX();
    }

    public void addPlant() {
        enclosures.get(current).addPlant(new Plant("Eucalyptus", "plant.png"));
    }

    public boolean canEat() {
        for(Plant plant : enclosures.get(current).plants) if(!plant.canEat()) return false;
        return true;
    }

    public void show() {
        enclosures.get(current).show();
    }

    public void hide() {
        enclosures.get(current).hide();
    }

    public void showProfile() {
        enclosures.get(current).showProfile();
    }

    public void hideProfile() {
        enclosures.get(current).hideProfile();
    }

    public void moveLeft() {
        if(current >= enclosures.size() - 1) return;

        enclosures.get(current).hide();
        current++;
        enclosures.get(current).show();
    }

    public void moveRight() {
        if(current <= 0) return;

        enclosures.get(current).hide();
        current--;
        enclosures.get(current).show();
    }
}
