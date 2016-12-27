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
	
	private boolean xSoundValid;
	private boolean ySoundValid;
	private boolean zSoundValid;

	public void timePassed() {
		// alters velocities
		if (isRightButtonPressed && xVel <= speedLimit) {
			xVel += accelRate;
		}

		if (isLeftButtonPressed && xVel >= -speedLimit) {
			xVel -= accelRate;
		}

		if (isForwardButtonPressed) {
			zVel += accelRate;
		}

		if (isBackwardButtonPressed) {
			zVel -= accelRate;
		}

		if (isJumpButtonPressed && !hasJumped) {
			Audio.doAudioJunk("jump");
			yVel -= jumpPower;
			hasJumped = true;
		}

		// gravity
		yVel += gravity;

		// apply friction
		xVel = xVel * fricRate;
		zVel = zVel * fricRate;

		// if can move right, move right
		if (CollisionDetection.isAbleMoveX(x, y, z, width, height, (int) xVel, (int) yVel)) {
			x += xVel;
		} else {
			xVel = 0;
		}
		// when it's in the air
		if (CollisionDetection.isAbleMoveY(x, y, z, width, height, (int) xVel, (int) yVel)) {
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
		if (CollisionDetection.isAbleMoveZ(x, y, z, width, height, (int) xVel, (int) yVel, (int) zVel)
				&& z + zVel > 10 && z + zVel < Level.twoDimensionRects.length - 10) {
			z += zVel;
		} else {
			zVel = 0;
		}

		checkAudio();
		
	}
	
	private void checkAudio(){
		if (!CollisionDetection.isAbleMoveX(x, y, z, width, height, (int) xVel, (int) yVel) && xSoundValid){
			Audio.doAudioJunk("thud");
			xSoundValid = false;
		}
		else if (!CollisionDetection.isAbleMoveY(x, y, z, width, height, (int) xVel, (int) yVel) && ySoundValid){
			Audio.doAudioJunk("thud");
			ySoundValid = false;
		}
		else if (!CollisionDetection.isAbleMoveZ(x, y, z, width, height, (int) xVel, (int) yVel, (int) zVel) && zSoundValid){
			Audio.doAudioJunk("thud");
			zSoundValid = false;
		}
		
		
		
		if (CollisionDetection.isAbleMoveX(x, y, z, width, height, (int) xVel, (int) yVel)){
			xSoundValid = true;
		}
		if (CollisionDetection.isAbleMoveY(x, y, z, width, height, (int) xVel, (int) yVel)){
			ySoundValid = true;
		}
		if (CollisionDetection.isAbleMoveZ(x, y, z, width, height, (int) xVel, (int) yVel, (int) zVel)){
			zSoundValid = true;
		}
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

	public boolean getJumpButton() {
		return isJumpButtonPressed;
	}

	public boolean getBackwardButton() {
		return isBackwardButtonPressed;
	}

	public boolean getForwardButton() {
		return isForwardButtonPressed;
	}

}
