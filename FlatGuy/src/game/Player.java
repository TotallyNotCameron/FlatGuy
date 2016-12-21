package game;

import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Player {

	// positions on the different axises
	private int x;
	private int y;
	private int z;
    private int jumpPower;
	
	// width and height of the hitbox
	private final int width;
	private final int height;

	// velocities automagically initialized to 0
	private double xVel;
	private double yVel;
	private double zVel;

	// controls
	private boolean isRightButtonPressed;
	private boolean isLeftButtonPressed;
	private boolean isForwardButtonPressed;
	private boolean isBackwardButtonPressed;
	private boolean isJumpButtonPressed;
	private boolean hasJumped;
	
	
	
	public void timePassed(){
		//alters velocities
		if (isRightButtonPressed){
			xVel++;
		}
		
		if (isLeftButtonPressed){
			xVel--;
		}
		
		if(isJumpButtonPressed){
			yVel -= jumpPower;
		}
		
		
		
		//gravity
		yVel++;
		
		
		
		//move stuff
		x += xVel;
		y += yVel;
		
	}
	
	public Player() {
		width = 50;
		height = 50;
		x = 100;
		y = 200;
		jumpPower = 20;
	}

	public void setRightButton(boolean k) {
		isRightButtonPressed = k;
	}

	public void setLeftButton(boolean k) {
		isLeftButtonPressed = k;
	}

	public void setForwardButton(boolean k) {
		isForwardButtonPressed = k;
	}

	public void setBackwardButton(boolean k) {
		isBackwardButtonPressed = k;
	}

	public void jump() {
		isJumpButtonPressed = true;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

}
