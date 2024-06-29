package graphics;

import java.awt.Image;
import java.awt.Toolkit;

public class DisplayObject {
    private Image image;
    private int x, y;
    private int width, height;

    public DisplayObject(String image, int x, int y, int width, int height) {
        this.image = Toolkit.getDefaultToolkit().getImage("res/" + image);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }
}
