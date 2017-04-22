package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GameWindow extends JPanel implements ActionListener, KeyListener {

	// so i may have goofed a tad and everything is coupled very heavily, but i
	// mean it works, so that's cool.

	int code;

	Timer timer = new Timer(30, this);
	private static int windowWidth;
	private static int windowHeight;
	Player dude = new Player();

	public static boolean hasWon = false;
	public static boolean isPaused = true;
	private static BufferedImage playerImage; 
	private static BufferedImage menuImage;
	
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

		code = e.getKeyCode();
		if (!isPaused) {
			if (code == KeyEvent.VK_RIGHT)
				dude.setRightButton(true);

			if (code == KeyEvent.VK_LEFT) {
				dude.setLeftButton(true);
			}

			if (code == KeyEvent.VK_UP)
				dude.setForwardButton(true);

			if (code == KeyEvent.VK_DOWN)
				dude.setBackwardButton(true);

			if (code == KeyEvent.VK_M)
				isPaused = true;

			if (code == KeyEvent.VK_SPACE)
				dude.setJumpButton(true);

			if (code == KeyEvent.VK_0) {
				Level.setLevel(Level.getLevel() + 1);
				dude.setX(Level.startingPos[Level.getLevel()].getX());
				dude.setY(Level.startingPos[Level.getLevel()].getY());
				dude.setZ(Level.startingPos[Level.getLevel()].getZ());
			}

		}
		// if in menu while player hits space, then it restarts their
		// current level
		if (code == KeyEvent.VK_SPACE && isPaused) {
			isPaused = false;
			Level.setLevel(Level.getLevel());
			dude.setX(Level.startingPos[Level.getLevel()].getX());
			dude.setY(Level.startingPos[Level.getLevel()].getY());
			dude.setZ(Level.startingPos[Level.getLevel()].getZ());

		}

	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {

		if (!isPaused) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				dude.setRightButton(false);

			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				dude.setLeftButton(false);

			if (e.getKeyCode() == KeyEvent.VK_UP)
				dude.setForwardButton(false);

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				dude.setBackwardButton(false);
			}

			if (e.getKeyCode() == KeyEvent.VK_SPACE)
				dude.setJumpButton(false);

		}
	}

	/*
	 * Paint Method
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		try {
			playerImage = ImageIO.read(new File("Turtle.png"));
			menuImage = ImageIO.read(new File("FlatGuyMenu.jpg"));
		} catch(IOException e){
			e.printStackTrace();
		}

		if (!isPaused) {
			
			//sets backgroud colour
			Color back = new Color(150, dude.getZ() / 3, 250 - dude.getZ() / 2);
			g.setColor(back);
			g.fillRect(0, 0, 900, 600);

			// draws the walls to the screen
			g.setColor(Color.BLACK);
			for (int i = 0; i < Level.twoDimensionRects[dude.getZ()].length; i++) {
				g.fillRect((int) Level.twoDimensionRects[dude.getZ()][i].getX(),
						(int) Level.twoDimensionRects[dude.getZ()][i].getY(),
						(int) Level.twoDimensionRects[dude.getZ()][i].getWidth(),
						(int) Level.twoDimensionRects[dude.getZ()][i].getHeight());
			}
			g.setColor(Color.BLUE);

			g.fillRect(Level.goalRects[dude.getZ()].x, Level.goalRects[dude.getZ()].y,
					Level.goalRects[dude.getZ()].width, Level.goalRects[dude.getZ()].height);
			
			g.drawImage(playerImage, dude.getX(), dude.getY(), dude.getWidth(), dude.getHeight(), this);
		
			
			
			g.setColor(Color.BLACK);
			g.drawString("char x: " + dude.getX(), 700, 50);
			g.drawString("char y: " + dude.getY(), 700, 70);
			g.drawString("char z: " + dude.getZ(), 700, 90);

			if (Level.getLevel() == 0) {
				g.drawString("Hey there, this dude on the screen that looks like a square is you! Try using the left",
						50, 50);
				g.drawString("and right arrow keys to move. Use the spacebar to jump.", 50, 70);
				g.drawString("By the way, this may look like a Two Dimensional World, ", 50, 90);
				g.drawString("but it is actually Three Dimensional. More on that later... ", 50, 110);
			} else if (Level.getLevel() == 1) {
				g.drawString("Good job, now to do it again, but... where has the goal gone?", 50, 50);
				g.drawString("Oh goodie! Now it must be time for the third dimension! You can use the ", 50, 70);
				g.drawString("up and down arrow keys to navigate through the third dimension!", 50, 90);
				g.drawString("Your character can only see two dimensions at a time though, so you only get ", 50, 110);
				g.drawString("to see a cross-section of the three dimensional world.", 50, 130);
			} else if (Level.getLevel() == 2) {
				g.drawString("Oh no! There seems to be a wall blocking your way!", 50, 50);
				g.drawString("There's no way you can get to the goal :(", 50, 70);
			} else if (Level.getLevel() == 3) {
				g.drawString("Aha you saw right past that... ", 50, 50);
				g.drawString("Let's see if you have tunnel vision.", 50, 70);
			}
		} else if (isPaused) {
			g.drawImage(menuImage, 0, 0, this.getWidth(), this.getHeight(), this);
			if (hasWon) {
				g.drawString("You won, muh dood!, want to play again?", 50, 50);
			}
		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		// change this when making a leveling system
		Level.setLevel(0);

		GameWindow test = new GameWindow();

		JFrame jf = new JFrame();

		jf.setSize(windowWidth, windowHeight);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setTitle("FlatGuy");
		jf.add(test);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				jf.setVisible(true);
			}
		});

	}

}
