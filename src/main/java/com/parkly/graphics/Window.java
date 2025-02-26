package com.parkly.graphics;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

import com.parkly.input.Keyboard;
import com.parkly.input.Mouse;

public class Window {
	public JFrame frame;
	
    public static final double RATIO = 9.0 / 16.0;

	public static final int MONITOR = 0;
	
	public static final GraphicsDevice[] gs = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
	
	public static final double SCALE_X = gs[MONITOR].getDefaultConfiguration().getDefaultTransform().getScaleX();
	public static final double SCALE_Y = gs[MONITOR].getDefaultConfiguration().getDefaultTransform().getScaleY();
	
	
	public static final int HEIGHT = (int) Math.ceil(gs[MONITOR].getDisplayMode().getHeight() / SCALE_Y * 0.5);
    public static final int WIDTH = (int) (HEIGHT * RATIO);
	
	public Window() {
		frame = new JFrame("Parkly");
        
		frame.setBounds(WIDTH, 0, WIDTH, HEIGHT);
		
		//frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    frame.setLayout(null);

		frame.addMouseListener(new Mouse.ClickListener());
	    frame.addMouseMotionListener(new Mouse.MotionListener());
	    frame.addKeyListener(new Keyboard.KeyListener());
	}
}