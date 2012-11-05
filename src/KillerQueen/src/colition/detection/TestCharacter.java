package colition.detection;

import java.awt.Point;
import java.awt.event.KeyEvent;

import objects.GenericObject;

public class TestCharacter extends GenericObject {

	int dx, dy;
	Point upper,leftUpper,leftLower,rightUpper,rightLower,leftFoot,rightFoot;

	public TestCharacter() {
		super();
		dx = 0;
		dy = 0;
	}

	public TestCharacter(int x, int y, int height, int width) {
		super(x, y, height, width);
		dx = 0;
		dy = 0;
		upper = new Point(getX()+(getWidth()/2),getY());
		leftUpper = new Point(getX(), (int)(getY()+0.2*getHeight()));
		leftLower = new Point(getX(),(int)(getY()+0.8*getHeight()));
		rightUpper = new Point(getX()+getWidth(),(int)(getY()+0.2*getHeight()));
		rightLower = new Point(getX()+getWidth(),(int)(getY()+0.8*getHeight()));
		leftFoot = new Point((int)(getX()+0.3*getWidth()),getY()+getHeight());
		rightFoot = new Point((int)(getX()+0.7*getWidth()),getY()+getHeight());
	}

	public void move() {
		setX(getX() + dx);
		setY(getY() + dy);
		upper.setLocation(getX()+(getWidth()/2),getY());
		leftUpper.setLocation(getX(), (int)(getY()+0.2*getHeight()));
		leftLower.setLocation(getX(),(int)(getY()+0.8*getHeight()));
		rightUpper.setLocation(getX()+getWidth(),(int)(getY()+0.2*getHeight()));
		rightLower.setLocation(getX()+getWidth(),(int)(getY()+0.8*getHeight()));
		leftFoot.setLocation((int)(getX()+0.3*getWidth()),getY()+getHeight());
		rightFoot.setLocation((int)(getX()+0.7*getWidth()),getY()+getHeight());
//		checkColitions();

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT)
			dx = -1;
		if (key == KeyEvent.VK_RIGHT)
			dx = 1;
		if (key == KeyEvent.VK_UP)
			dy = -1;
		if (key == KeyEvent.VK_DOWN)
			dy = 1;
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT)
			dx = 0;
		if (key == KeyEvent.VK_RIGHT)
			dx = 0;
		if (key == KeyEvent.VK_UP)
			dy = 0;
		if (key == KeyEvent.VK_DOWN)
			dy = 0;
	}

}
