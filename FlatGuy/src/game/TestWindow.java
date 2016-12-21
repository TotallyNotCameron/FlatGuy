package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TestWindow extends JPanel implements ActionListener, KeyListener {
	
	
	
	Timer timer = new Timer(5, this);
	private int x;
	private int y;
	private int xVel;
	private int yVel;
	private int xStartingPoint;
	private int yStartingPoint;
	private static int windowWidth;
	private static int windowHeight;
	
	public TestWindow() {
		x = 0;
		y = 0;
		windowWidth = 800;
		windowHeight = 600;
		xVel = 0;
		yVel = 0;
		xStartingPoint = (windowWidth / 2);
		yStartingPoint = (windowHeight / 2);
		
		timer.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(x < 0) {
			xVel = 0;
			x = xStartingPoint;
			y = yStartingPoint;
		} 
		
		if(x > 800) {
			xVel = 0;
			x = xStartingPoint;
			y = yStartingPoint;
		}
		
		if(y < 0) {
			yVel = 0;
			x = xStartingPoint;
			y = yStartingPoint;
		}
		
		if(y > 600) {
			yVel = 0;
			x = xStartingPoint;
			y = yStartingPoint;
		}
		
		x = x + xVel;
		y = y + yVel;
		repaint();
	}
	
	
	/* 
	 * Creating the controls
	 */
	public void keyPressed(KeyEvent e) {
		
		
		if ( e.getKeyCode() == KeyEvent.VK_RIGHT){
			xVel = 1;
			yVel = 0;
		}
		
		if ( e.getKeyCode() == KeyEvent.VK_LEFT){
			xVel = -1;
			yVel = 0;
		}
		
		if ( e.getKeyCode() == KeyEvent.VK_UP){
			xVel = 0;
			yVel = -1;
		}

		if ( e.getKeyCode() == KeyEvent.VK_DOWN){
			xVel = 0;
			yVel = 1;
		}
	}
	
	public void keyTyped(KeyEvent e){
		
	}
	
	public void keyReleased(KeyEvent e){
		xVel = 0;
		yVel = 0;
	}
	
	
	
	
	
	
	
	/*
	 * Paint Method
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLACK);
		g.fillRect(x, y, 50, 50);

	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		TestWindow test = new TestWindow();

		JFrame jf = new JFrame();
		jf.setVisible(true);
		jf.setSize(windowWidth, windowHeight);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setBackground(Color.GRAY);
		jf.setTitle("FlatGuy");
		jf.add(test);
	}



}
