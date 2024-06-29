package main;

import graphics.DisplayObject;
import graphics.Window;

public class Profile extends Displayable {
    private DisplayObject photo;

    public Profile(String photo) {
        super(new DisplayObject("image.png", (int)(Window.WIDTH * 0.05), (int)(Window.HEIGHT * 0.3), (int)(Window.WIDTH * 0.9), (int)(Window.WIDTH * 0.9)));

        this.photo = new DisplayObject(photo, (int)(Window.WIDTH * 0.1), (int)(Window.HEIGHT * 0.6), (int)(Window.WIDTH * 0.4), (int)(Window.WIDTH * 0.4));
    }

    @Override
    public void update() {
        
    }
}
