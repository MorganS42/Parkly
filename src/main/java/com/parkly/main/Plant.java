package com.parkly.main;

import com.parkly.graphics.DisplayObject;
import com.parkly.graphics.Window;

public class Plant extends Displayable {
    private PlantSpecies species;
    private String photo;
    private int x, y;

    private int plantTime;

    public Plant(PlantSpecies species, String photo) {
        super(new DisplayObject(species.getTexture(), 0, 0, (int) (Window.HEIGHT * 0.2), (int) (Window.HEIGHT * 0.2)));

        this.species = species;
        this.photo = photo;
        this.plantTime = 300;

        x = (int)(Math.random() * Window.WIDTH);
        y = (int)(Window.HEIGHT - Window.HEIGHT * 0.2);
        this.object.move(x, y);
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

    @Override
    public void update() {
        plantTime--;
    }

    public boolean canEat() {
        return plantTime < 0;
    }
}
