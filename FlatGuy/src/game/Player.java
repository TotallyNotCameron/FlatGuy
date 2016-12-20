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
		width = 100;
		height = 100;
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
	
	public int getZ(){
		return z;
	}
	
}
