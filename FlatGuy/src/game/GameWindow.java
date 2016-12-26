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

@SuppressWarnings("serial")
public class GameWindow extends JPanel implements ActionListener, KeyListener {

	Timer timer = new Timer(30, this);
	private static int windowWidth;
	private static int windowHeight;
	Player dude = new Player();

	public GameWindow() {

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

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			dude.setRightButton(true);

		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			dude.setLeftButton(true);

		if (e.getKeyCode() == KeyEvent.VK_E)
			dude.setForwardButton(true);

		if (e.getKeyCode() == KeyEvent.VK_D)
			dude.setBackwardButton(true);

		if (e.getKeyCode() == KeyEvent.VK_UP)
			dude.setJumpButton(true);

	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			dude.setRightButton(false);

		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			dude.setLeftButton(false);

		if (e.getKeyCode() == KeyEvent.VK_W)
			dude.setForwardButton(false);

		if (e.getKeyCode() == KeyEvent.VK_D)
			dude.setBackwardButton(false);

		if (e.getKeyCode() == KeyEvent.VK_UP)
			dude.setJumpButton(false);

	}

	/*
	 * Paint Method
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLACK);

		// draws the walls to the screen
		for (int i = 0; i < Level.twoDimensionRects[dude.getZ()].length; i++) {
			g.fillRect((int) Level.twoDimensionRects[dude.getZ()][i].getX(),
					(int) Level.twoDimensionRects[dude.getZ()][i].getY(),
					(int) Level.twoDimensionRects[dude.getZ()][i].getWidth(),
					(int) Level.twoDimensionRects[dude.getZ()][i].getHeight());
		}

		g.setColor(Color.GREEN);

		g.fillRect(dude.getX(), dude.getY(), dude.getWidth(), dude.getHeight());

		g.setColor(Color.black);
		g.drawString("char z: " + dude.getZ(), 100, 100);
		g.drawString("jumpbutton: " + dude.getJumpButton(), 100, 200);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		GameWindow test = new GameWindow();

		JFrame jf = new JFrame();
		jf.setVisible(true);
		jf.setSize(windowWidth, windowHeight);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setTitle("FlatGuy");
		jf.add(test);

		// change this when making a leveling system
		Level.setLevel(0);
	}

}
