package main;

public class Plant {
    private PlantSpecies species;

    public Plant(PlantSpecies species) {
        this.species = species;
    }

    public PlantSpecies getSpecies() {
        return species;
    }
}
