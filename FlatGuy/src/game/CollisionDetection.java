package game;

import java.awt.Rectangle;


public class CollisionDetection {

	public CollisionDetection() {

	}

	/* 
	 * below is collision detection for the walls and the shape
	 */
	public static Boolean isAbleMoveX(int x, int y, int width, int height, int speedX, int speedY) {

		Rectangle right1 = new Rectangle(x + speedX, y, width, height);

//		for (int i = 0; i < Level.twoDimensionRecs[Level.getLevel()].length; i++){
//			if (right1.intersects(Level.twoDimensionRecs[Level.getLevel()][i])){
//				return false;
//			}
//		}
		
		
		return true;
	}

	public static Boolean isAbleMoveY(int x1, int y1, int width1, int height1, int speedX, int speedY) {

		Rectangle down1 = new Rectangle(x1, y1 + speedY, width1, height1);
		
//		for (int i = 0; i < Level.twoDimensionRecs[Level.getLevel()].length; i++){
//			if (down1.intersects(Level.twoDimensionRecs[Level.getLevel()][i])){
//				return false;
//			}
//		}
		
		return true;
	}
	
	
	
}



