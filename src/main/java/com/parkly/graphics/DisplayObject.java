package com.parkly.graphics;

import java.awt.Graphics2D;

import com.parkly.main.Utils;

public class DisplayObject {
    private DisplayScript script;
    private String image;
    private int width, height;

    public DisplayObject(String image, int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        this.image = image;
        this.script = (Graphics2D g2, Display display) -> {
            g2.drawImage(Utils.toImage(image), x, y, width, height, display);  
        };
    }

    public DisplayObject(DisplayScript script) {
        this.script = script;
    }

    public void display(Graphics2D g2, Display display) {
        script.display(g2, display);
    }

    public void move(int newX, int newY) {
        this.script = (Graphics2D g2, Display display) -> {
            g2.drawImage(Utils.toImage(image), newX, newY, width, height, display);  
        };
    }
}
