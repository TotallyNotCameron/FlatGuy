package game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class MainClass extends JApplet  {

	private  Player player = new Player();
	public void init() {
		
		Component c = getContentPane();
		c.setSize(1000, 1000);
		JPanel panel = new JPanel();
        setKeyBindings(panel);
        c.addKeyListener(this);;
         
         
	}
	
	
	//paints junk
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.blue);
		g.fillRect(player.getX(), player.getY(), player.getHeight(), player.getWidth());
	}
	


	private void setKeyBindings(final JPanel panel) {
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0), "Move Left");
        panel.getActionMap().put("Move Left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                player.moveLeft();
            }
        });
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0), "Move Right");
        panel.getActionMap().put("Move Right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	player.moveRight();
            }
        });
    }
	
}
