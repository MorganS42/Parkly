package main;

public class PlantSpecies {
    public static final PlantSpecies[] PLANT_SPECIES = {
		new PlantSpecies("Eucalyptus", "plant.png", 1)
	};

    private String name, texture;
    private int value;
    private AnimalSpecies[] animals;

    public PlantSpecies(String name, String texture, int value) {
        this.name = name;
        this.texture = texture;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PlantSpecies findPlantSpecies(String name) {
        for(PlantSpecies plantSpecies : PLANT_SPECIES) {
            if(plantSpecies.name.equals(name)) return plantSpecies;
        }
        return null;
    }
}
