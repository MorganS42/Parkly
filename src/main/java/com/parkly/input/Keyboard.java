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
					break;

				case 's':
					Parkly.ZOO.show();
					break;

				case 'm':
					Parkly.ZOO.moveRight();
					break;

				case 'n':
					Parkly.ZOO.moveLeft();
					break;
			}
		}
	}
}
