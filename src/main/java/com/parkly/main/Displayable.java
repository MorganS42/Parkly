package com.parkly.main;

import com.parkly.graphics.DisplayObject;

public abstract class Displayable implements Updatable {
    DisplayObject object;

    Displayable(DisplayObject displayObject) {
        this.object = displayObject;
    }
    
    public void show() {
        Parkly.DISPLAY.addObject(object);
    }

    public void hide() {
        Parkly.DISPLAY.removeObject(object);
    }
}
