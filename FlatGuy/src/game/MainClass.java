package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MainClass extends JApplet implements ActionListener {

	Player mainDude = new Player();
	Timer t;

	public void init() {

		Container c = getContentPane();
		c.setBackground(Color.white);
		c.setSize(700, 500);
		t = new Timer(1000, this);
		t.start();
	}

	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();

		switch (k) {
		case KeyEvent.VK_RIGHT:
			mainDude.setRightButton(true);
			break;
		case KeyEvent.VK_LEFT:
			mainDude.setLeftButton(true);
			break;
		case KeyEvent.VK_UP:
			mainDude.jump();
			break;
		}

	}

	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();
		switch (k) {
		case KeyEvent.VK_LEFT:
			mainDude.setLeftButton(false);
			break;
		case KeyEvent.VK_RIGHT:
			mainDude.setRightButton(false);
			break;

		}

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.fillRect(60, 70, 50, 50);
		g.fillRect(mainDude.getX(), mainDude.getY(), mainDude.getWidth(), mainDude.getHeight());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mainDude.timePassed();
		repaint();
	}

}
