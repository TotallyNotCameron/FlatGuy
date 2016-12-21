package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TestWindow extends JPanel {
	
	static Timer timer;
	
	/*
	 * Paint Method
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(350, 250, 50, 50);
	}
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		TestWindow test = new TestWindow();
		
		JFrame jf = new JFrame();
		jf.setVisible(true);
		jf.setSize(800, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBackground(Color.GRAY);
		jf.setTitle("FlatGuy");
		jf.add(test);
	}

}
