package com.parkly.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.parkly.main.Parkly;

public class Keyboard {
	public static class KeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			char c = e.getKeyChar();	
			switch(c) {
				case 'h':
					Parkly.ZOO.hide();
					Parkly.WEBCAM.show();
					break;

				case 't':
					if(Parkly.WEBCAM.run().contains("Plant")) {
						System.out.println("Added Plant!!");
						Parkly.ZOO.addPlant();
					}
				case 's':
					Parkly.ZOO.show();
					Parkly.WEBCAM.hide();
					break;

				case 'm':
					Parkly.ZOO.moveRight();
					break;

				case 'n':
					Parkly.ZOO.moveLeft();
					break;

				case 'p':
					Parkly.PHOTO_LIBRARY.show();
					Parkly.ZOO.hide();
					break;

				case 'l':
					Parkly.PHOTO_LIBRARY.hide();
					Parkly.ZOO.show();
					break;

				case 'f':
					Parkly.ZOO.addPlant();
					break;
			}
		}
	}
}
