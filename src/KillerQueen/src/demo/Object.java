package demo;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Object {

	private int x;
	private int dx;
	private int y;
	private int dy;
	private Image objectImage;
	private int objectSpeed;

	public Object() {
		setX(0);
		setY(0);
		setObjectSpeed(0);
		ImageIcon image = new ImageIcon();
		setObjectImage(image.getImage());
	}

	public Object(int x, int y, int objectSpeed, String objectImage) {
		setX(x);
		setY(y);
		setObjectSpeed(objectSpeed);
		ImageIcon image = new ImageIcon(objectImage);
		setObjectImage(image.getImage());
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
		setX(getX() + getDx());
		setY(getY() + getDy());
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			setDx(-getObjectSpeed());
		}

		if (key == KeyEvent.VK_RIGHT) {
			setDx(getObjectSpeed());
		}

		if (key == KeyEvent.VK_UP) {
			setDy(-getObjectSpeed());
		}

		if (key == KeyEvent.VK_DOWN) {
			setDy(getObjectSpeed());
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			setDx(0);
		}

		if (key == KeyEvent.VK_RIGHT) {
			setDx(0);
		}

		if (key == KeyEvent.VK_UP) {
			setDy(0);
		}

		if (key == KeyEvent.VK_DOWN) {
			setDy(0);
		}
	}

}
