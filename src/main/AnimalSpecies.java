package main;

public class AnimalSpecies {
    public static final AnimalSpecies[] ANIMAL_SPECIES = {
		new AnimalSpecies("Frog", "animal.png", new PlantSpecies[]{
            
		})
	};

    private String name, texture;
    private PlantSpecies[] edible;

    public AnimalSpecies(String name, String texture, PlantSpecies[] edible) {
        this.name = name;
        this.edible = edible;
        this.texture = texture;
    }

    public String getTexture() {
        return texture;
    }

    public static AnimalSpecies findAnimalSpecies(String name) {
        for(AnimalSpecies animalSpecies : ANIMAL_SPECIES) {
            if(animalSpecies.name.equals(name)) return animalSpecies;
        }
        return null;
    }

    public boolean canEat(Plant plant) {
        for(PlantSpecies plantSpecies : edible) {
            if(plantSpecies == plant.getSpecies()) return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
