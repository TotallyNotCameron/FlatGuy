package game;

public class Player {

	// positions on the different axises
	private int x;
	private int y;
	private int z;
	private int jumpPower;

	// width and height of the hitbox
	private final int width;
	private final int height;
	private final int accelRate;
	private final int speedLimit;
	private final int gravity; 

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

	public void timePassed() {
		// alters velocities
		if (isRightButtonPressed && xVel <= speedLimit) {
			xVel += accelRate;
		}

		if (isLeftButtonPressed && xVel >= -speedLimit) {
			xVel -= accelRate;
		}

		if (isJumpButtonPressed && !hasJumped) {
			yVel -= jumpPower;
			hasJumped = true;
			isJumpButtonPressed = false;
		}

		// gravity
		yVel += gravity;
		
		//REMOVE THIS WHEN MAKING WALLS
		if (y >= 450 && yVel > 0){
			yVel = 0;
			hasJumped = false;
		}
		
		// move stuff
		x += xVel;
		y += yVel;
		
		//remove this after making collision detection with walls and things
		

	}

	public Player() {
		width = 50;
		height = 50;
		x = 100;
		y = 200;
		jumpPower = 20;
		accelRate = 3;
		speedLimit = 40;
		gravity = 1;
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

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
