package com.parkly.main;

import java.awt.Graphics2D;

import com.parkly.graphics.Display;
import com.parkly.graphics.DisplayObject;

public class Webcam extends Displayable {
    Webcam() {
        super(new DisplayObject((Graphics2D g2, Display display) -> {
            
        }));
    }

    @Override
    public void update() {
        
    }
    
}
