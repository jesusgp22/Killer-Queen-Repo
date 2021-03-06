package objects;

import java.awt.Image;

public class MobileObject extends BaseObject {

	protected int dx;
	protected int dy;
	protected Image objectImage;
	protected int objectSpeed;

	public MobileObject() {
		super();
		setObjectSpeed(0);
		objectImage = null;
	}

	public MobileObject(int x, int y, int height, int width, int objectSpeed,
			Image objectImage) {
		super(x, y, height, width);
		this.objectSpeed = objectSpeed;
		this.objectImage = objectImage;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public int getObjectSpeed() {
		return objectSpeed;
	}

	public void setObjectSpeed(int objectSpeed) {
		this.objectSpeed = objectSpeed;
	}

	public Image getObjectImage() {
		return objectImage;
	}

	public void setObjectImage(Image objectImage) {
		this.objectImage = objectImage;
	}

}
