package game;

public class Player {

	// positions on the different axises
	private int x;
	private int y;
	private int z;
	
	//width and height of the hitbox
	private final int width;
	private final int height;
	
	//velocities automagically initialized to 0
	double xVel;
	double yVel;
	double zVel;
	
	//controls
	boolean isRightButtonPressed;
	boolean isLeftButtonPressed;
	boolean isForwardButtonPressed;
	boolean isBackwardButtonPressed;

	
	public Player() {
		x = 0;
		y = 0;
		z = 0;
		width = 100;
		height = 100;
	}	
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
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

	public Player(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		width = 100;
		height = 100;
	}	
	
	public void moveRight(){
		x++;
	}
	
	public void moveLeft(){
		x--;
	}
	
	public void setRightButton(boolean k){
		isRightButtonPressed = k;
	}
	
	public void setLeftButton(boolean k){
		isLeftButtonPressed = k;
	}
	
	public void setForwardButton(boolean k){
		isForwardButtonPressed = k;
	}
	
	public void setBackwardButton(boolean k){
		isBackwardButtonPressed = k;
	}
	
}
