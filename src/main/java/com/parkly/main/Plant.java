package com.parkly.main;

public class Plant extends Displayable {
    private PlantSpecies species;
    private String photo;
    private int x, y;

    public Plant(PlantSpecies species, String photo) {
        this.species = species;
        this.photo = photo;

        x = (int)(Math.random() * Window.WIDTH);
        y = Window.HEIGHT - Window.HEIGHT * 0.15;
        super(new DisplayObject(species.getTexture(), x, y, (int) (Window.HEIGHT * 0.1), (int) (Window.HEIGHT * 0.1)));
    }

    public Plant(String species, String photo) {
        this(PlantSpecies.findPlantSpecies(species), photo);
    }

    public PlantSpecies getSpecies() {
        return species;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
