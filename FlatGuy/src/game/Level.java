package game;

import java.awt.Polygon;
import java.awt.Rectangle;

public class Level {

	private static int level;

	// what each value means: Rectangle[current level][z coordinate][# of walls
	// in that z coordinate]

	// delete this after making things chill with the 3d walls
//	 public static Rectangle[][] twoDimensionRecs = {
//	 { new Rectangle(0, 400, 700, 50), new Rectangle(200, 300, 50, 50) }, //	 2d walls in level 1
//	 { new Rectangle(50, 50, 50, 50) } 										// 2d walls in level 2, and so on
//	 };

	// Wall[level][walls in group]
	private static Wall[][] wallarrs = { 
			{ new Wall(0, 500, 0, 800, 100, 500), new Wall(300, 400, 200, 250, 100, 50), 
				new Wall(350, 300, 200, 150, 100, 50),new Wall(400, 200, 200, 50, 100, 50) }, // walls in level 0																						/																																												// 1
			{ new Wall(0, 400, 0, 700, 50, 500) } 										// walls in level 1

	};

	// Wall[all possible 500 z coordinates][# walls that correspond to each z coordinate]
	public static Rectangle[][] twoDimensionRects; 

	public Level() {

	}
	
	//ALL OF OUR LEVELS HAVE A Z LENGTH OF 500
	
	// generates the three dimensional walls, after calling this method, you get get the x, y, width, and height 
	// from any wall with any given z coordinate
	public static void generateWalls(int level) {
		
		twoDimensionRects = new Rectangle[500][wallarrs[level].length];
		//runs through each wall in a given level
		for (int k = 0; k < wallarrs[level].length; k++) {
			int i = 0;
			// assigns all values up to the z coordinate with no wall (just offscreen)
			while (i < wallarrs[level][k].getZ()){
				twoDimensionRects[i][k] = new Rectangle(10000, 1, 1, 1);
				i++;
			}

			// assigns values where the wall is with 1 rectangle per unit
			while (i < wallarrs[level][k].getLength() + wallarrs[level][k].getZ()){
				twoDimensionRects[i][k] = new Rectangle(wallarrs[level][k].getX(), wallarrs[level][k].getY(), 
						wallarrs[level][k].getWidth(), wallarrs[level][k].getHeight());
				i++;
			}
			// assigns the rest of the z coordinates with no wall (just offscreen)
			while (i < 500){
				twoDimensionRects[i][k] = new Rectangle(10000, 1, 1, 1);
				i++;
			}
		}

	}

	// set the level to something else
	public static void setLevel(int level) {
		Level.level = level;
		Level.generateWalls(level);
	}

	// returns the current level
	public static int getLevel() {
		return Level.level;
	}

}
