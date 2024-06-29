package graphics;

import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.function.IntSupplier;

public class DisplayObject {
    private DisplayScript script;
    private IntSupplier getX;
    private IntSupplier getY;

    public DisplayObject(String image, int x, int y, int width, int height) {
        this.getX = () -> x;
        this.getY = () -> y;
        this.script = (Graphics2D g2, Display display) -> {
            g2.drawImage(Toolkit.getDefaultToolkit().getImage("res/" + image), getX.getAsInt(), getY.getAsInt(), width, height, display);  
        };
    }

    public DisplayObject(DisplayScript script) {
        this.script = script;
    }

    public void display(Graphics2D g2, Display display) {
        script.display(g2, display);
    }

    public void move(int newX, int newY) {
        this.getX = () -> newX;
        this.getY = () -> newY;
    }
}
