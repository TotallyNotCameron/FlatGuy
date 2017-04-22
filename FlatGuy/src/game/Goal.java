package game;

public class Goal {

	int x;
	int y;
	int z;
	int width;
	int height;
	int length;
	
	public Goal(int x, int y, int z, int width, int height, int length) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.width = width;
		this.height = height;
		this.length = length;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getLength(){
		return length;
	}
	
	public int getX(){
		 return x;
	}
	
	public int getY(){
		 return y;
	}
	
	public int getZ(){
		 return z;
	}

	
}
