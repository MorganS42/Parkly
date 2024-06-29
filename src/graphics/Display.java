package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import main.Parkly;

public class Display extends JPanel {
	private List<DisplayObject> objects;

	public Display() {
		Parkly.WINDOW.frame.getContentPane().add(this);
		this.setBounds(0, 0, Window.WIDTH, Window.HEIGHT);
		objects = new ArrayList<DisplayObject>();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);

		for(DisplayObject object : objects) {
			g2.drawImage(object.getImage(), object.getX(), object.getY(), object.getWidth(), object.getHeight(), this);
		}
	}

	public void addObject(DisplayObject object) {
		this.objects.add(object);
	}

	public void removeObject(DisplayObject object) {
		this.objects.remove(object);
	}
}
