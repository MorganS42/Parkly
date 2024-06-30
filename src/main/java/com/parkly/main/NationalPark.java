package com.parkly.main;

import java.awt.Font;
import java.awt.Graphics2D;

import com.parkly.graphics.Display;
import com.parkly.graphics.DisplayObject;
import com.parkly.graphics.Window;

public class NationalPark extends Displayable {
    private Plant[] plants;
    private Animal[] animals;
    private String location;

    public NationalPark(Plant[] plants, Animal[] animals, String location) {
        super(new DisplayObject((Graphics2D g2, Display display) -> {
            g2.drawImage(Utils.toImage("square.png"), (int)(Window.WIDTH * 0.05), (int)(Window.HEIGHT * 0.3), (int)(Window.WIDTH * 0.9), (int)(Window.WIDTH * 0.9), display);
            g2.drawImage(Utils.toImage("redcross.png"), (int)(Window.WIDTH * 0.85), (int)(Window.HEIGHT * 0.31), (int)(Window.WIDTH * 0.1), (int)(Window.WIDTH * 0.1), display);

            g2.setFont(new Font("TimesRoman", Font.BOLD, (int) (Window.HEIGHT * 0.07)));
            g2.drawString("Ku-Ring-Gai Chase National Park", (int)(Window.WIDTH * 0.25), (int)(Window.HEIGHT * 0.32));
            g2.setFont(new Font("TimesRoman", Font.BOLD, (int) (Window.HEIGHT * 0.05)));
            g2.drawString("Animals found here: ", (int)(Window.WIDTH * 0.25), (int)(Window.HEIGHT * 0.4));
            g2.setFont(new Font("TimesRoman", Font.PLAIN, (int) (Window.HEIGHT * 0.05)));
            g2.drawString("Sulpher Crested Cockatoo, Brushtail Possum", (int)(Window.WIDTH * 0.25), (int)(Window.HEIGHT * 0.4));
        }));

        this.plants = plants;
        this.animals = animals;
        this.location = location;        
    }

    public String getLocation() {
        return location;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
