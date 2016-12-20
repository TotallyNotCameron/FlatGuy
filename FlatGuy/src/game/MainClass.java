package game;

import java.awt.*;
import javax.swing.*;

public class MainClass extends JApplet {

	public void init() {
		Container c = getContentPane();
		c.setBackground(Color.white);
		c.setSize(1000, 1000);

	}
	
	
	//paints junk
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.BLACK);
		g.fillRect(60, 70, 50, 50);
	}

}
