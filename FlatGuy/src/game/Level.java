package game;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

public class Level {

	private static int level;

	// Wall[level][walls in level]

	public static Point3D[] startingPos = { new Point3D(100, 400, 200), // 0
			new Point3D(100, 400, 200), // 1
			new Point3D(100, 400, 200), // 2
			new Point3D(100, 400, 200), // 3
			new Point3D(100, 400, 250) // 4
	};
	
	static int totLevels = startingPos.length;

	private static Wall[][] wallarrs = { {
			// level 0
			new Wall(0, 500, 0, 800, 100, 500), new Wall(300, 400, 0, 250, 100, 500),
			new Wall(350, 300, 0, 150, 100, 500), new Wall(400, 200, 0, 50, 100, 500),

			new Wall(-1, -200, 0, 1, 1000, 500), new Wall(800, -200, 0, 1, 1000, 500) // left,
																						// right
																						// boundaries

			},
			{
					// level 1
					new Wall(0, 500, 0, 800, 100, 500), new Wall(300, 400, 200, 250, 100, 50),
					new Wall(350, 300, 200, 150, 100, 50), new Wall(400, 200, 200, 50, 100, 50),

					new Wall(-1, -200, 0, 1, 1000, 500), new Wall(800, -200, 0, 1, 1000, 500) // left,
																								// right
																								// boundaries
			}, // level 2
			{ new Wall(0, 500, 0, 800, 100, 500), new Wall(350, 100, 150, 300, 600, 200),

					new Wall(-1, -200, 0, 1, 1000, 500), new Wall(800, -200, 0, 1, 1000, 500) // left,
																								// right
																								// boundaries
			}, // level 3
			{ new Wall(150, 100, 0, 350, 250, 500), new Wall(150, 500, 0, 350, 250, 500),
					new Wall(150, 100, 0, 350, 400, 150), new Wall(350, 100, 200, 150, 400, 300),
					new Wall(150, 200, 0, 150, 400, 300), new Wall(150, 100, 350, 300, 600, 150),

					new Wall(-1, -200, 0, 1, 1000, 500), new Wall(800, -200, 0, 1, 1000, 500), // left,
																								// right
																								// boundaries
					new Wall(0, 500, 0, 800, 100, 500)

			}, // level 4
			{ new Wall(100, 350, 250, 50, 50, 100), new Wall(300, 250, 250, 50, 50, 100),
					new Wall(350, 200, 200, 100, 50, 50), new Wall(400, 200, 50, 100, 50, 100),
					new Wall(650, 200, 50, 50, 50, 50), new Wall(750, 200, 50, 50, 50, 450),
					new Wall(-1, -200, 0, 1, 1000, 500), new Wall(800, -200, 0, 1, 1000, 500), // left,
																								// right
																								// boundaries
					new Wall(0, 500, 0, 800, 100, 500) }

	};

	private static Goal[] goals = { new Goal(700, 400, 0, 50, 50, 500), // 0
			new Goal(700, 400, 100, 50, 50, 50), // 1
			new Goal(700, 400, 200, 50, 50, 50), // 2
			new Goal(700, 400, 200, 50, 50, 50), // 3
			new Goal(600, 100, 450, 50, 50, 50) // 4
	};
	public static Rectangle[] goalRects;

	// Wall[all possible 500 z coordinates][# walls that correspond to each z
	// coordinate]
	public static Rectangle[][] twoDimensionRects;

	public Level() {

	}

	// ALL OF OUR LEVELS HAVE A Z LENGTH OF 500

	// generates the three dimensional walls, after calling this method, you get
	// get the x, y, width, and height
	// from any wall with any given z coordinate
	// now it also generates the goals needed for each level too
	public static void generateWalls(int level) {
		twoDimensionRects = new Rectangle[500][wallarrs[level].length];
		// runs through each wall in a given level
		for (int k = 0; k < wallarrs[level].length; k++) {
			int i = 0;
			// assigns all values up to the z coordinate with no wall (just
			// offscreen)
			while (i < wallarrs[level][k].getZ()) {
				twoDimensionRects[i][k] = new Rectangle(10000, 1, 1, 1);
				i++;
			}

			// assigns values where the wall is with 1 rectangle per unit
			while (i < wallarrs[level][k].getLength() + wallarrs[level][k].getZ()) {
				twoDimensionRects[i][k] = new Rectangle(wallarrs[level][k].getX(), wallarrs[level][k].getY(),
						wallarrs[level][k].getWidth(), wallarrs[level][k].getHeight());
				i++;
			}
			// assigns the rest of the z coordinates with no wall (just
			// offscreen)
			while (i < 500) {
				twoDimensionRects[i][k] = new Rectangle(10000, 1, 1, 1);
				i++;
			}
		}
		goalRects = new Rectangle[500];
		int i = 0;
		while (i < goals[level].getZ()) {
			goalRects[i] = new Rectangle(10000, 1, 1, 1);
			i++;
		}
		while (i < goals[level].getLength() + goals[level].getZ()) {
			goalRects[i] = new Rectangle(goals[level].getX(), goals[level].getY(), goals[level].getWidth(),
					goals[level].getHeight());
			i++;
		}
		while (i < 500) {
			goalRects[i] = new Rectangle(10000, 1, 1, 1);
			i++;
		}
	}

	// set the level to something else
	public static void setLevel(int level) {

		if (level <= totLevels) {
			Level.level = level;
			Level.generateWalls(level);
		} else {
			GameWindow.hasWon = true;
			GameWindow.isPaused = true;
		}

	}

	// returns the current level
	public static int getLevel() {
		return Level.level;
	}

}
