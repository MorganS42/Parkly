package com.parkly.main;

public class NationalPark {
    private Plant[] plants;
    private Animal[] animals;
    private String location;

    public NationalPark(Plant[] plants, Animal[] animals, String location) {
        this.plants = plants;
        this.animals = animals;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
