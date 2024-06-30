package com.parkly.main;

import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.util.ImageUtils;
import com.parkly.graphics.Display;
import com.parkly.graphics.DisplayObject;
import com.parkly.graphics.Window;

public class Webcamera extends Displayable {
    static Webcam webcam = Webcam.getDefault();
    {
        webcam.open();
    }

    Webcamera() {
        super(new DisplayObject((Graphics2D g2, Display display) -> {
            BufferedImage image = webcam.getImage();
            g2.drawImage(image, 0, 0, Window.WIDTH, Window.HEIGHT, display);
        }));
    }

    @Override
    public void update() {
        
    }
    
    public void run() {
        BufferedImage image = webcam.getImage();
        try {
            ImageIO.write(image, ImageUtils.FORMAT_JPG, new java.io.File("res/selfie.jpg"));
            Parkly.detectLabels(Parkly.vision, "res/selfie.jpg");
        } 
        catch (IOException e) {
        }
    }
}
