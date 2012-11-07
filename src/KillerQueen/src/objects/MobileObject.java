package objects;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class MobileObject extends BaseObject {

	protected int dx;
	protected int dy;
	private Image objectImage;
	private int objectSpeed;

	public MobileObject() {
		super();
		setObjectSpeed(0);
		ImageIcon image = new ImageIcon();
		setObjectImage(image.getImage());
	}

	public MobileObject(int x, int y, int height, int width, int objectSpeed,
			String objectImage) {
		super(x, y, height, width);
		this.objectSpeed = objectSpeed;
		ImageIcon image = new ImageIcon(objectImage);
		setObjectImage(image.getImage());
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

	public void moveObject() {
		x = (getX() + getDx());
		y = (getY() + getDy());
	}

}
