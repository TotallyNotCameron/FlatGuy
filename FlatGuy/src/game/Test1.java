package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

public class Test1 extends JApplet {

	/**
	 * Create the applet.
	 */
	public Test1() {

	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponents(g);
		g.setColor(Color.BLUE);
		g.fillRect(50, 50, 100, 100);
	}

}
