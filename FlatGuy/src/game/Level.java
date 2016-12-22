package game;

import java.awt.Polygon;
import java.awt.Rectangle;

public class Level {

	private static int level;

	// note to self: when adding a third dimension, make the arrays three
	// dimensional, with one dimension being level, another being
	// the rectangles, and the last one being the z coordinate

	// what each value means: Rectangle[current level][z coordinate][# of walls
	// in that z coordinate]

	 public static Rectangle[][] twoDimensionRecs = {
	 { new Rectangle(0, 400, 700, 50), new Rectangle(200, 300, 50, 50) }, //	 2d walls in level 1
	 { new Rectangle(50, 50, 50, 50) } // 2d walls in level 2, and so on
	 };

	// Wall[level][walls in group]
	public static Wall[][] wallarrs = { 
			{ new Wall(0, 400, 0, 700, 50, 500), new Wall(200, 300, 50, 50, 50, 350) }, // walls in level 1																									/																																												// 1
			{ new Wall(0, 400, 0, 700, 50, 500) } 										// walls in level 2

	};

	// Wall[all possible 500 z coordinates][# walls that correspond to each z coordinate]
	public static Rectangle[][] threeDWalls;

	public Level() {

	}
	
	//ALL OF OUR LEVELS HAVE A Z LENGTH OF 500
	
	// generates the three dimensional walls, after calling this method, you get get the x, y, width, and height 
	// from any wall with any given z coordinate
	public static void generateWalls(int level) {
		
		//runs through each wall in a given level
		for (int k = 0; k < wallarrs[level].length; k++) {
			
			// assigns all values up to the z coordinate with no wall (just offscreen)
			for (int i = 0; i < wallarrs[level][k].getZ(); i++) {
				threeDWalls[i][k] = new Rectangle(10000, 1, 1, 1);
			}
			
			//assigns values along the z length with the proper wall
			for (int i = wallarrs[level][k].getZ(); i < wallarrs[level][k].getLength(); i++){
				threeDWalls[i][k] = new Rectangle(wallarrs[level][k].getX(), wallarrs[level][k].getY(), 
						wallarrs[level][k].getWidth(), wallarrs[level][k].getHeight());
			}
			// assigns the rest of the z coordinates with no wall (just offscreen)
			for (int i = wallarrs[level][k].getZ() + wallarrs[level][k].getLength(); i < 500; i++){
				threeDWalls[i][k] = new Rectangle(10000, 1, 1, 1);
			}
			
		}

	}

	// set the level to something else
	public static void setLevel(int level) {
		Level.level = level;
	}

	// returns the current level
	public static int getLevel() {
		return Level.level;
	}

}
