package main;

public class AnimalSpecies {
    private String name, texture;
    private Plant[] plants;

    public AnimalSpecies(String name, String texture, Plant[] plants) {
        this.name = name;
        this.plants = plants;
        this.texture = texture;
    }
}
