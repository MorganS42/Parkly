package main;

import graphics.DisplayObject;

public abstract class Displayable implements Updatable {
    DisplayObject object;

    Displayable(DisplayObject displayObject) {
        this.object = displayObject;
    }
    
    void show() {
        Parkly.DISPLAY.addObject(object);
    }

    void hide() {
        Parkly.DISPLAY.removeObject(object);
    }
}
