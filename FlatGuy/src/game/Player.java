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

	// some other stuff that affects movement
	private final double accelRate;
	private final int speedLimit;
	private final int gravity;
	public double fricRate;

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


	public Player() {
		width = 30;
		height = 30;
		x = 100;
		y = 200;
		z = 200;
		jumpPower = 19;
		accelRate = 2;
		speedLimit = 10;
		gravity = 1;
		fricRate = .9;
	}

	
	public void timePassed() {

		// alters velocities
		if (isRightButtonPressed && xVel <= speedLimit) {
			xVel += accelRate;
		}

		if (isLeftButtonPressed && xVel >= -speedLimit) {
			xVel -= accelRate;
		}

		if (isForwardButtonPressed) {
			zVel = 2;
		} else if (isBackwardButtonPressed) {
			zVel = -2;
		} else {
			zVel = 0;
		}

		if (isJumpButtonPressed && !hasJumped) {
			Audio.doAudioJunk("jump");
			yVel = -jumpPower;
			hasJumped = true;
		}

		// gravity
		yVel += gravity;

		// apply friction
		xVel = xVel * fricRate;

		if (xVel < 1 && xVel > -1) {
			xVel = 0;
		}

		
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
		}
		// when it's touching the ground
		else{
			yVel = 0;
			if (!isRightButtonPressed && !isLeftButtonPressed)
				fricRate = .7;
			else
				fricRate = .9;
		}
		
		if (!CollisionDetection.isAbleMoveDown(x, y, z, width, height, (int)xVel, (int)yVel))
			hasJumped = false;
		
		
		
		if (CollisionDetection.isAbleMoveZ(x, y, z, width, height, (int) xVel, (int) yVel, (int) zVel) && z + zVel > 10
				&& z + zVel < Level.twoDimensionRects.length - 10) {
			z += zVel;
		}
		
		if (CollisionDetection.isTouchingExit(this)){
			Level.setLevel(Level.getLevel() + 1);
			this.x = Level.startingPos[Level.getLevel()].getX();
			this.y = Level.startingPos[Level.getLevel()].getY();
			this.z = Level.startingPos[Level.getLevel()].getZ();
		}
		
		checkAudio();

	}

	private void checkAudio() {
		if (!CollisionDetection.isAbleMoveX(x, y, z, width, height, (int) xVel, (int) yVel) && xSoundValid) {
			Audio.doAudioJunk("thud");
			xSoundValid = false;
		} else if (!CollisionDetection.isAbleMoveY(x, y, z, width, height, (int) xVel, (int) yVel) && ySoundValid) {
			Audio.doAudioJunk("thud");
			ySoundValid = false;
		} else if (!CollisionDetection.isAbleMoveZ(x, y, z, width, height, (int) xVel, (int) yVel, (int) zVel)
				&& zSoundValid) {
			Audio.doAudioJunk("thud");
			zSoundValid = false;
		}

		if (CollisionDetection.isAbleMoveX(x, y, z, width, height, (int) xVel, (int) yVel)) {
			xSoundValid = true;
		}
		if (CollisionDetection.isAbleMoveY(x, y, z, width, height, (int) xVel, (int) yVel)) {
			ySoundValid = true;
		}
		if (CollisionDetection.isAbleMoveZ(x, y, z, width, height, (int) xVel, (int) yVel, (int) zVel)) {
			zSoundValid = true;
		}
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

	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setZ(int z){
		this.z = z;
	}
	
}
