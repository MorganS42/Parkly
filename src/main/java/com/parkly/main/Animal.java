package com.parkly.main;

import com.parkly.graphics.DisplayObject;
import com.parkly.graphics.Window;

public class Animal extends Displayable {
    private enum State {
        IDLE,
        MOVE
    }

    public static final int MAX_HP = 100;
    public static final double X_MOVE_INCREMENT = 2;
    public static final double Y_MOVE_INCREMENT = 5;

    private double hunger, x, y;
    
    private String name;
    private AnimalSpecies species;
    private Profile profile;
    private String photo;

    private State state;
    private double xdistance;
    private double ydistance;
    private int xdirection;
    private int ydirection;
    private int targetX;
    private double idleTime;

    public Animal(String name, AnimalSpecies species, String photo) {
        super(new DisplayObject(species.getTexture(), 0, 0, (int) (Window.HEIGHT * 0.1), (int) (Window.HEIGHT * 0.1)));
        this.name = name;
        this.species = species;

        x = (int)(Math.random() * Window.WIDTH);
        y = species.canFly() ? Window.HEIGHT * 0.15 : Window.HEIGHT - Window.HEIGHT * 0.15;
        hunger = 0;
        state = State.MOVE;
        idleTime = (int)(Math.random() * 50) + 100;
        this.photo = photo;
        profile = new Profile(this);
    }

    public Animal(String name, String species, String photo) {
        this(name, AnimalSpecies.findAnimalSpecies(species), photo);
    }

    // Make animal move but not like a spastic dingo under the influence of marijuana
    public void update() {
        // Manages movement
        switch (state) {
            case IDLE:
                if (idleTime <= 0) {
                    state = State.MOVE;
                    xdirection = (Math.random() > 0.5) ? 1 : -1;
                    xdistance = (int)(Math.random() * (Math.abs(x - (xdirection == 1 ? Window.WIDTH * 0.9 : 0))));
                    if (species.canFly()) {
                        ydirection = (Math.random() > 0.5) ? 1 : -1;
                        ydistance = (int)(Math.random() * (Math.abs(x - (xdirection == 1 ? Window.HEIGHT * 0.4 : 0))));
                    }
                    else {
                        ydirection = 1;
                        ydistance = 0;
                    }
                }
                else {
                    idleTime -= X_MOVE_INCREMENT;
                }
                break;
            case MOVE:
                if (Parkly.ZOO.getPlantSize() == 0 || this.species.canFly()) {
                    if (xdistance > 0 || ydistance > 0) {
                        if (xdistance > 0) {
                            x += xdirection * X_MOVE_INCREMENT;
                            xdistance -= X_MOVE_INCREMENT;
                        }
                        if (ydistance > 0 && species.canFly()) {
                            y += ydirection * Y_MOVE_INCREMENT;
                            ydistance -= Y_MOVE_INCREMENT;
                        }
                    }
                    else {
                        state = State.IDLE;
                        idleTime = (int)(Math.random() * 100);
                    }
                }
                else {
                    targetX = Parkly.ZOO.getTargetX();
                    if(Math.abs(x - targetX) < X_MOVE_INCREMENT && Parkly.ZOO.canEat()) {
                        Parkly.ZOO.removePlant();
                        this.hunger -= 5;
                        if(this.hunger < 0) this.hunger = 0;
                    }
                    if (targetX > x) {
                        x += X_MOVE_INCREMENT;
                    }
                    else if (targetX < x) {
                        x -= X_MOVE_INCREMENT;
                    }
                }
                break;
        }
        
        //Increase hunger
        hunger += 0.005;

        //Move image
        object.move((int)x, (int)y);

        //Check for death
        if (MAX_HP - hunger <= 0) {
            die();
        }
    }

    //Shows some info like photos you have taken, hunger, plants it can eat, etc
    public void showProfile() {
        profile.show();

        //TODO add statistics, plants, etc as text boxes basically
        
    }

    public void feed(Plant plant) {
        hunger -= plant.getSpecies().getValue();
        Parkly.INVENTORY.removePlant(plant);
    }

    public void die() {
        Parkly.ZOO.removeAnimal(this);
    }

    public AnimalSpecies getSpecies() {
        return species;
    }

    public double getHunger() {
        return hunger;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() {
        super.hide();
        profile.hide();
    }
}
