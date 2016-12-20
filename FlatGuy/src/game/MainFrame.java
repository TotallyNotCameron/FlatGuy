package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JPanel {
	
	private static int width = 600;
	private static int height = 400;

	/**
	 * Create the applet.
	 */
	public MainFrame() {

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(width / 2, height / 2, 200, 400);
	}
	
	public static void main(String[] args) {
		MainFrame example = new MainFrame();
		
		JFrame jf = new JFrame();
		jf.setTitle("FlatGuy");
		jf.setSize(width, height);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(example);
		
	}

}
