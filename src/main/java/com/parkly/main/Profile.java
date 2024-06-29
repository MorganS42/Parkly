package com.parkly.main;

import com.parkly.graphics.*;
import com.parkly.graphics.Window;

import java.awt.*;

public class Profile extends Displayable {
    public Profile(Animal animal) {
        super(new DisplayObject((Graphics2D g2, Display display) -> {
            double hunger = animal.getHunger();
            String name = animal.getName();
            g2.drawImage(Utils.toImage("square.png"), (int)(Window.WIDTH * 0.05), (int)(Window.HEIGHT * 0.3), (int)(Window.WIDTH * 0.9), (int)(Window.WIDTH * 0.9), display);
            g2.drawImage(Utils.toImage("redcross.png"), (int)(Window.WIDTH * 0.8), (int)(Window.HEIGHT * 0.35), (int)(Window.WIDTH * 0.1), (int)(Window.WIDTH * 0.1), display);
            g2.drawImage(Utils.toImage(animal.getPhoto()), (int)(Window.WIDTH * 0.1), (int)(Window.HEIGHT * 0.35), (int)(Window.WIDTH * 0.4), (int)(Window.WIDTH * 0.4), display);

            g2.setFont(new Font("TimesRoman", Font.PLAIN, (int) (Window.HEIGHT * 0.07)));
            g2.drawString(name, (int)(Window.WIDTH * 0.15), (int)(Window.HEIGHT * 0.65));
            g2.drawString(animal.getSpecies().getName(), (int)(Window.WIDTH * 0.15), (int)(Window.HEIGHT * 0.725));
            g2.drawString("Health: " + (int)(100-hunger) + "/100", (int)(Window.WIDTH * 0.15), (int)(Window.HEIGHT * 0.8));
        }));
    }

    @Override
    public void update() {
        
    }
}
