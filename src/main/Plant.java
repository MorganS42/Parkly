package main;

public class Plant {
    private PlantSpecies species;
    private String photo;

    public Plant(PlantSpecies species, String photo) {
        this.species = species;
        this.photo = photo;
    }

    public PlantSpecies getSpecies() {
        return species;
    }
}
