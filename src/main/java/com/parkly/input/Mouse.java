package com.parkly.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Mouse {
	public static int X;
	public static int Y;
	
	public static boolean LEFT_CLICK;

	public static class ClickListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1) LEFT_CLICK = true;
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				LEFT_CLICK = false;
			}
		}
		
	}
	
	public static class MotionListener implements MouseMotionListener {
		@Override
		public void mouseMoved(MouseEvent e) {
			X = e.getX();
			Y = e.getY();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			X = e.getX();
			Y = e.getY();
		}
	}
}