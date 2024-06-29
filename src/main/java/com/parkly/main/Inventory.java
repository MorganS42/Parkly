package com.parkly.main;

import java.util.List;

public class Inventory {
    private List<Plant> plants;

    public Inventory() {}

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void removePlant(Plant plant) {
        plants.remove(plant);
    }
}

