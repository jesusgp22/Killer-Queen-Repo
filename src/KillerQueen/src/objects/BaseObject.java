package objects;

public abstract class BaseObject {

	private int x;
	private int y;
	protected int height;
	protected int width;
	
	public BaseObject() {
		x=0;
		y=0;
		height=0;
		width=0;
	}
	
	public BaseObject(int x,int y,int height, int width){
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
