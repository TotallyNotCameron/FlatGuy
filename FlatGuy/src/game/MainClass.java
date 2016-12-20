package game;

import java.awt.*;
import javax.swing.*;

public class MainClass extends JApplet {

	public void init() {
		Container c = getContentPane();
		c.setBackground(Color.red);

	}

	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.blue);
		g.drawString("hi there, waddup", 60, 65);
	}

}
