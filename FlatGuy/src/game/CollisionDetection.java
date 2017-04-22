package game;

import java.awt.Rectangle;

public class CollisionDetection {

	public CollisionDetection() {

	}

	/*
	 * below is collision detection for the walls and the shape
	 */
	public static Boolean isAbleMoveX(int x, int y, int z, int width, int height, int speedX, int speedY) {

		Rectangle right1;

		if (speedX >= 0)
			right1 = new Rectangle(x + speedX, y, width, height);
		else
			right1 = new Rectangle(x + speedX - 1, y, width, height);

		// runs through all rectangles in a given plane, checking to see if dude
		// will collide with em
		for (int i = 0; i < Level.twoDimensionRects[z].length; i++) {
			if (right1.intersects(Level.twoDimensionRects[z][i])) {
				return false;
			}
		}

		return true;
	}

	public static Boolean isAbleMoveY(int x, int y, int z, int width, int height, int speedX, int speedY) {

		Rectangle down1 = new Rectangle(x, y + speedY, width, height);

		// runs through all rectangles in a given plane, checking to see if dude
		// will collide with em
		for (int i = 0; i < Level.twoDimensionRects[z].length; i++) {
			if (down1.intersects(Level.twoDimensionRects[z][i])) {
				return false;
			}
		}

		return true;
	}

	public static Boolean isAbleMoveDown(int x, int y, int z, int width, int height, int speedX, int speedY) {
		if (speedY > 0) {
			Rectangle down1 = new Rectangle(x, y + speedY, width, height);

			// runs through all rectangles in a given plane, checking to see if
			// dude
			// will collide with em
			for (int i = 0; i < Level.twoDimensionRects[z].length; i++) {
				if (down1.intersects(Level.twoDimensionRects[z][i])) {
					return false;
				}
			}
		}
		return true;
	}

	// this method is slightly different because we don't want bugs and because
	// the z plane is an array
	public static Boolean isAbleMoveZ(int x, int y, int z, int width, int height, int speedX, int speedY, int speedZ) {

		Rectangle forward1 = new Rectangle(x + speedX, y + speedY, width, height);

		// runs through all rectangles in a given plane, checking to see if dude
		// will collide with em
		for (int i = 0; i < Level.twoDimensionRects[z + speedZ].length; i++) {
			if (forward1.intersects(Level.twoDimensionRects[z + speedZ][i])) {
				return false;
			}
		}

		return true;
	}

	public static Boolean isTouchingExit(Player p) {

		Rectangle hitBox = new Rectangle(p.getX(), p.getY(), p.getWidth(), p.getHeight());

		if (hitBox.intersects(Level.goalRects[p.getZ()]))
			return true;
		else
			return false;

	}

}
