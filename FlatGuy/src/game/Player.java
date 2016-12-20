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
	boolean isUpButtonPressed;
	boolean isForwardButtonPressed;
	boolean isBackwardButtonPressed;

	
	public Player() {
		width = 100;
		height = 100;
	}

	
	
}
