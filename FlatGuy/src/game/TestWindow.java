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
	
	
	
	Timer timer = new Timer(30, this);
	private static int windowWidth;
	private static int windowHeight;
	Player dude = new Player();
	
	public TestWindow() {
		
		windowWidth = 800;
		windowHeight = 600;
		
		timer.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		dude.timePassed();
		repaint();
	}
	
	
	/* 
	 * Creating the controls
	 */
	public void keyPressed(KeyEvent e) {
		
		
		if ( e.getKeyCode() == KeyEvent.VK_RIGHT){
			dude.setRightButton(true);
		}
		
		if ( e.getKeyCode() == KeyEvent.VK_LEFT){
			dude.setLeftButton(true);
		}
		
		if ( e.getKeyCode() == KeyEvent.VK_UP){
			dude.jump();
		}
	}
	
	public void keyTyped(KeyEvent e){
		
	}
	
	public void keyReleased(KeyEvent e){
		if ( e.getKeyCode() == KeyEvent.VK_RIGHT){
			dude.setRightButton(false);
		}
		if ( e.getKeyCode() == KeyEvent.VK_LEFT){
			dude.setLeftButton(false);
		}
	}
	
	
	
	
	
	
	
	/*
	 * Paint Method
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.GREEN);
		g.fillRect(dude.getX(), dude.getY(), dude.getWidth(), dude.getHeight());

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
