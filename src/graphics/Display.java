package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import main.Parkly;

public class Display extends JPanel {
	double density = 20;
	double squareSize = Window.WIDTH / density;
	
	public Display() {
		Parkly.WINDOW.frame.getContentPane().add(this);
		this.setBounds(0, 0, Window.WIDTH, Window.HEIGHT);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
	}
}
