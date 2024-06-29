package main;

import java.awt.*;

public class Utils {
    public static Image toImage(String image) {
        return Toolkit.getDefaultToolkit().getImage("res/" + image);
    }
}
