package colition.detection;

import java.awt.Point;

import objects.BaseObject;

public class TestCharacter extends BaseObject {

	int dx, dy;
	Point upper, leftUpper, leftLower, rightUpper, rightLower, leftFoot,
			rightFoot;
	private boolean canMoveUp = true;
	private boolean canMoveDown = true;
	private boolean canMoveLeft = true;
	private boolean canMoveRight = true;

	public TestCharacter() {
		super();
		dx = 0;
		dy = 0;
	}

	public TestCharacter(int x, int y, int height, int width) {
		super(x, y, height, width);
		dx = 0;
		dy = 0;
		upper = new Point(getX() + (getWidth() / 2), getY());
		leftUpper = new Point(getX(), (int) (getY() + 0.2 * getHeight()));
		leftLower = new Point(getX(), (int) (getY() + 0.8 * getHeight()));
		rightUpper = new Point(getX() + getWidth(),
				(int) (getY() + 0.2 * getHeight()));
		rightLower = new Point(getX() + getWidth(),
				(int) (getY() + 0.8 * getHeight()));
		leftFoot = new Point((int) (getX() + 0.3 * getWidth()), getY()
				+ getHeight());
		rightFoot = new Point((int) (getX() + 0.7 * getWidth()), getY()
				+ getHeight());
	}

	public void move() {
		x = (getX() + dx);
		y = (getY() + dy);
		upper.setLocation(getX() + (getWidth() / 2), getY());
		leftUpper.setLocation(getX(), (int) (getY() + 0.2 * getHeight()));
		leftLower.setLocation(getX(), (int) (getY() + 0.8 * getHeight()));
		rightUpper.setLocation(getX() + getWidth(),
				(int) (getY() + 0.2 * getHeight()));
		rightLower.setLocation(getX() + getWidth(),
				(int) (getY() + 0.8 * getHeight()));
		leftFoot.setLocation((int) (getX() + 0.3 * getWidth()), getY()
				+ getHeight());
		rightFoot.setLocation((int) (getX() + 0.7 * getWidth()), getY()
				+ getHeight());
	}

	public boolean isCanMoveUp() {
		return canMoveUp;
	}

	public void setCanMoveUp(boolean canMoveUp) {
		this.canMoveUp = canMoveUp;
	}

	public boolean isCanMoveDown() {
		return canMoveDown;
	}

	public void setCanMoveDown(boolean canMoveDown) {
		this.canMoveDown = canMoveDown;
	}

	public boolean isCanMoveLeft() {
		return canMoveLeft;
	}

	public void setCanMoveLeft(boolean canMoveLeft) {
		this.canMoveLeft = canMoveLeft;
	}

	public boolean isCanMoveRight() {
		return canMoveRight;
	}

	public void setCanMoveRight(boolean canMoveRight) {
		this.canMoveRight = canMoveRight;
	}

	// public void forceMove(int forcedDx,int forcedDy){
	// setX(getX() + forcedDx);
	// setY(getY() + forcedDy);
	// upper.setLocation(getX()+(getWidth()/2),getY());
	// leftUpper.setLocation(getX(), (int)(getY()+0.2*getHeight()));
	// leftLower.setLocation(getX(),(int)(getY()+0.8*getHeight()));
	// rightUpper.setLocation(getX()+getWidth(),(int)(getY()+0.2*getHeight()));
	// rightLower.setLocation(getX()+getWidth(),(int)(getY()+0.8*getHeight()));
	// leftFoot.setLocation((int)(getX()+0.3*getWidth()),getY()+getHeight());
	// rightFoot.setLocation((int)(getX()+0.7*getWidth()),getY()+getHeight());
	//
	// }
}
