package main;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    List<Enclosure> animalEnclosures;

    public Zoo() {
        this.animalEnclosures = new ArrayList<Enclosure>();
    }

    public void addEnclosure(String background, int numberAnimals) {
        this.animalEnclosures.add(new Enclosure(background));
    }

    public void deleteEnclosure(int index) {
        this.animalEnclosures.remove(index);
    }
}
