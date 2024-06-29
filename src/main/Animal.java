package main;

import graphics.DisplayObject;

public class Animal extends Displayable {
    private enum State {
        IDLE,
        MOVE
    }

    public static final int MAX_HP = 100;
    public static final double MOVE_INCREMENT = 0.5;

    private double hunger, x, y;
    
    private String name;
    private AnimalSpecies species;
    private Profile profile;
    private String photo;

    private State state;
    private double distance;
    private int direction;
    private double idleTime;

    public Animal(String name, AnimalSpecies species, String photo) {
        super(new DisplayObject(species.getTexture(), 0, 0, 100, 100));
        this.name = name;
        this.species = species;

        x = (int)(Math.random() * 100);
        y = (int)(Math.random() * 100);
        hunger = 0;
        state = State.IDLE;
        idleTime = (int)(Math.random() * 600);
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
                if (idleTime == 0) {
                    state = State.MOVE;
                    direction = (Math.random() > 0.5) ? 1 : -1;
                    distance = (int)(Math.random() * 100 * direction);
                }
                else {
                    idleTime -= MOVE_INCREMENT;
                }
                break;
            case MOVE:
                if (distance != 0) {
                    x += direction * MOVE_INCREMENT;
                    distance -= MOVE_INCREMENT;
                }
                else {
                    state = State.IDLE;
                    idleTime = (int)(Math.random() * 600);
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
}
