package com.parkly.graphics;

import java.awt.Graphics2D;

@FunctionalInterface
public interface DisplayScript {
    void display(Graphics2D g2, Display display);
}
