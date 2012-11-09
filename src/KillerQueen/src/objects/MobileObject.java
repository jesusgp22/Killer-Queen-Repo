package objects;

import java.awt.Graphics2D;
import java.awt.Image;

public class MobileObject extends BaseObject {

	protected int dx;
	protected int dy;
	protected Image objectImage;

	public MobileObject() {
		super();
		objectImage = null;
	}

	public MobileObject(int x, int y, int height, int width,
			Image objectImage) {
		super(x, y, height, width);
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


	public void setObjectImage(Image objectImage) {
		this.objectImage = objectImage;
	}

	public void draw(Graphics2D g2d){
		g2d.drawRect(x, y, width, height);
	}

	public Image getObjectImage() {
		return objectImage;
	}
}
