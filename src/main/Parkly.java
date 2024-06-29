//Programmed by Tom VB

package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import graphics.Display;
import graphics.Window;

public class Parkly {
	public static final Inventory INVENTORY = new Inventory();

	public static final Window WINDOW = new Window();
	public static final Display DISPLAY = new Display();

	public static final Timer GAME_ENGINE = new Timer();

	public static final Zoo ZOO = new Zoo();

	public static void main(String[] args) {
		GAME_ENGINE.schedule(new GameEngine(), 0, GameEngine.PERIOD);

		ZOO.addAnimal(new Animal("Bob", "Frog", ""));

		
	}
	
	static class GameEngine extends TimerTask {
		public final static double FPS = 30;
		public final static int PERIOD = (int) (1000.0 / FPS);
		
		@Override
	    public void run() {
			ZOO.update();

			DISPLAY.repaint();
		}
	}
}
