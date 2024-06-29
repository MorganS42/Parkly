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

	public static final List<Updatable> updatables = new ArrayList<Updatable>();

	public static void main(String[] args) {
		System.out.println("Hello world!");

		GAME_ENGINE.schedule(new GameEngine(), 0, GameEngine.PERIOD);
	}
	
	static class GameEngine extends TimerTask {
		public final static double FPS = 30;
		public final static int PERIOD = (int) (1000.0 / FPS);
		
		@Override
	    public void run() {
			for(Updatable updatable : updatables) {
				updatable.update();
			}

			DISPLAY.repaint();
		}
	}
}
