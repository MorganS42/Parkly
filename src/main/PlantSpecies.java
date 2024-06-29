package main;

public class PlantSpecies {
    private String name, texture;
    private int value;
    private Animal[] animals;

    public PlantSpecies(String name, String texture, Animal[] animals, int value) {
        this.name = name;
        this.texture = texture;
        this.animals = animals;
    }
}
