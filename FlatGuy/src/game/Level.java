package game;

import java.awt.Polygon;
import java.awt.Rectangle;

public class Level {

	private static int level; 
	
	// note to self: when adding a third dimension, make the arrays three dimensional, with one dimension being level, another being
	// the rectangles, and the last one being the z coordinate
	
	// what each value means:   Rectangle[current level][Rectangles]
	public static Rectangle[][] twoDimensionRecs = {
			{ new Rectangle(0, 400, 700, 50), new Rectangle(200, 300, 50, 50) },   //  2d walls in level 1
			{ new Rectangle(50,50,50,50) }   									   //  2d walls in level 2, and so on
	};
	
	public Level() {
		
	}
	
	//set the level to something else
	public static void setLevel(int level){
		Level.level = level;
	}
	
	//returns the current level
	public static int getLevel(){
		return Level.level;
	}
	
}
