package objects;

public abstract class GenericObject {

	private int x;
	private int y;
	private int height;
	private int width;
	
	public GenericObject() {
		x=0;
		y=0;
		height=0;
		width=0;
	}
	
	public GenericObject(int x,int y,int height, int width){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
