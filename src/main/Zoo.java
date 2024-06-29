package main;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    List<Enclosure> animalEnclosure;

    public Zoo() {
        animalEnclosure = new ArrayList<Enclosure>();
    }

    public void addEnclosure(String background, int numberAnimals) {
        animalEnclosure.add(new Enclosure(background, numberAnimals));
    }

    public void deleteEnclosure(int index) {
        animalEnclosure.remove(index);
    }
}
