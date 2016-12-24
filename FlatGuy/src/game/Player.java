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
	private final double accelRate;
	private final int speedLimit;
	private final int gravity;
	private double fricRate;

	// velocities automagically initialized to 0
	private double xVel;
	private double yVel;
	private double zVel;

	// controls
	private boolean isRightButtonPressed = false;
	private boolean isLeftButtonPressed = false;
	private boolean isForwardButtonPressed = false;
	private boolean isBackwardButtonPressed = false;
	private boolean isJumpButtonPressed = false;
	private boolean hasJumped = false;

	public void timePassed() {
		// alters velocities
		if (isRightButtonPressed && xVel <= speedLimit) {
			xVel += accelRate;
		}

		if (isLeftButtonPressed && xVel >= -speedLimit) {
			xVel -= accelRate;
		}

		if (isForwardButtonPressed) {
			zVel += accelRate / 10.0;
		}

		if (isBackwardButtonPressed) {
			zVel -= accelRate / 10.0;
		}

		if (isJumpButtonPressed && !hasJumped) {
			yVel = jumpPower;
			hasJumped = true;
		}

		// gravity
		yVel += gravity;

		// apply friction
		xVel = xVel * fricRate;

		// if can move right, move right
		if (CollisionDetection.isAbleMoveX(x, y, width, height, (int) xVel, (int) yVel)) {
			x += xVel;
		} else {
			xVel = 0;
		}
		// when it's in the air
		if (CollisionDetection.isAbleMoveY(x, y, width, height, (int) xVel, (int) yVel) && y < 500) {
			y += yVel;
			fricRate = .99;
			// when it's touhing the ground
		} else {
			yVel = 0;
			hasJumped = false;
			if (!isRightButtonPressed && !isLeftButtonPressed)
				fricRate = .7;
			else
				fricRate = .9;
		}
		z += zVel;

	}

	public Player() {
		width = 30;
		height = 30;
		x = 100;
		y = 200;
		z = 150;
		jumpPower = 20;
		accelRate = 2;
		speedLimit = 10;
		gravity = 1;
		fricRate = .9;
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

	public void setJumpButton(boolean k) {
		isJumpButtonPressed = k;
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

	public boolean getBackwardButton() {
		return isBackwardButtonPressed;
	}

}
