package objects;

import java.awt.*;

public class Character extends MobileObject {

	private Point upper;
	private Point leftUpper;
	private Point leftLower;
	private Point rightUpper;
	private Point rightLower;
	private Point leftFoot;
	private Point rightFoot;
	private int stepNumber;
	public boolean up,llow,lup,rup,rlow,rfoot,lfoot;
	
	public Character() {
		super();
		stepNumber = 0;
		initControlPoints();

	}

	public Character(int x, int y, int height, int width, Image image) {

		super(x, y, height, width, image);
		stepNumber = 0;
		initControlPoints();

	}

	private void initControlPoints() {
		upper = new Point(x + (width / 2), y);
		leftUpper = new Point(x, (int) (y + 0.2 * height));
		leftLower = new Point(x, (int) (y + 0.8 * height));
		rightUpper = new Point(x + width, (int) (y + 0.2 * height));
		rightLower = new Point(x + width, (int) (y + 0.8 * height));
		leftFoot = new Point((int) (x + 0.3 * width), y + height);
		rightFoot = new Point((int) (x + 0.7 * width), y + height);

	}

	public void updateControlPoints() {
		upper.setLocation(x + (width / 2), y);
		leftUpper.setLocation(x, (int) (y + 0.2 * height));
		leftLower.setLocation(x, (int) (y + 0.8 * height));
		rightUpper.setLocation(x + width, (int) (y + 0.2 * height));
		rightLower.setLocation(x + width, (int) (y + 0.8 * height));
		leftFoot.setLocation((int) (x + 0.3 * width), y + height);
		rightFoot.setLocation((int) (x + 0.7 * width), y + height);
	}

	public void setStepNumber(int np) {
		this.stepNumber = np;
	}

	public int getStepNumber() {
		return stepNumber;
	}

	@Override
	public void draw(Graphics2D g2d) {
		super.draw(g2d);
		int xCoords[] = new int[] { upper.x, rightUpper.x, rightLower.x,
				rightFoot.x, leftFoot.x, leftLower.x, leftUpper.x };
		int yCoords[] = new int[] { upper.y, rightUpper.y, rightLower.y,
				rightFoot.y, leftFoot.y, leftLower.y, leftUpper.y };
		g2d.setColor(Color.RED);
		g2d.drawPolygon(xCoords, yCoords, 7);
	}

	public void move() {
		x += dx;
		y += dy;
		updateControlPoints();
	}

	public Point getLeftUpper() {
		return leftUpper;
	}

	public Point getLeftLower() {
		return leftLower;
	}

	public Point getRightUpper() {
		return rightUpper;
	}

	public Point getRightLower() {
		return rightLower;
	}

	public Point getLeftFoot() {
		return leftFoot;
	}

	public Point getRightFoot() {
		return rightFoot;
	}

	public Point getUpper() {
		return upper;
	}
	
	public void setLocation(int x,int y){
		this.x=x;
		this.y=y;
		updateControlPoints();
		
	}

}
