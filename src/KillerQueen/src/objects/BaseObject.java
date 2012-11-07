package objects;

public abstract class BaseObject {

	protected int x;
	protected int y;
	protected int height;
	protected int width;

	public BaseObject() {
		x = 0;
		y = 0;
		height = 0;
		width = 0;
	}

	public BaseObject(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

}
