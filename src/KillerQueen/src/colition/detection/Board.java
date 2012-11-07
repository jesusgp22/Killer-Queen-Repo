package colition.detection;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {

	World world;
	TestCharacter avatar;
	Timer time;

	public Board() {
		avatar = new TestCharacter(100, 100, 30, 20);
		world = new World();
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// Don't do anything

			}

			@Override
			public void keyReleased(KeyEvent e) {
				keyWasReleased(e);
				// System.out.println("released");

			}

			@Override
			public void keyPressed(KeyEvent e) {
				keyWasPressed(e);
				// System.out.println("pressed, oh nyeah");
			}
		});
		setFocusable(true);
		time = new Timer(25, this);
		time.start();
	}

	public void actionPerformed(ActionEvent e) {
		avatar.move();
		repaint();
	}

	void checkColition() {
		TestCharacter auxChar = new TestCharacter(avatar.getX(), avatar.getY(),
				avatar.getHeight(), avatar.getWidth());
		auxChar.move();

		if (world.gridArray[auxChar.upper.x / 5][auxChar.upper.y / 5] == true)
			avatar.setCanMoveUp(false);
		else
			avatar.setCanMoveUp(true);

		if (world.gridArray[auxChar.rightUpper.x / 5][auxChar.rightUpper.y / 5] == true)
			avatar.setCanMoveRight(false);
		else
			avatar.setCanMoveRight(true);
		if (world.gridArray[auxChar.rightLower.x / 5][auxChar.rightLower.y / 5] == true)
			avatar.setCanMoveRight(false);
		else
			avatar.setCanMoveRight(true);

		if (world.gridArray[auxChar.rightFoot.x / 5][auxChar.rightFoot.y / 5] == true)
			avatar.setCanMoveDown(false);
		else
			avatar.setCanMoveDown(true);
		if (world.gridArray[auxChar.leftFoot.x / 5][auxChar.leftFoot.y / 5] == true)
			avatar.setCanMoveDown(false);
		else
			avatar.setCanMoveDown(true);

		if (world.gridArray[auxChar.leftLower.x / 5][auxChar.leftLower.y / 5] == true)
			avatar.setCanMoveLeft(false);
		else
			avatar.setCanMoveLeft(true);
		if (world.gridArray[auxChar.leftUpper.x / 5][auxChar.leftUpper.y / 5] == true)
			avatar.setCanMoveLeft(false);
		else
			avatar.setCanMoveLeft(true);

	}

	// private boolean isColiding() {
	//
	// TestCharacter auxChar = new TestCharacter(avatar.getX(), avatar.getY(),
	// avatar.getHeight(), avatar.getWidth());
	// auxChar.move();
	// if (world.gridArray[auxChar.upper.x / 5][auxChar.upper.y / 5] == true)
	// return true;
	// if (world.gridArray[auxChar.rightUpper.x / 5][auxChar.rightUpper.y / 5]
	// == true)
	// return true;
	// if (world.gridArray[auxChar.rightLower.x / 5][auxChar.rightLower.y / 5]
	// == true)
	// return true;
	// if (world.gridArray[auxChar.rightFoot.x / 5][auxChar.rightFoot.y / 5] ==
	// true)
	// return true;
	// if (world.gridArray[auxChar.leftFoot.x / 5][auxChar.leftFoot.y / 5] ==
	// true)
	// return true;
	// if (world.gridArray[auxChar.leftLower.x / 5][auxChar.leftLower.y / 5] ==
	// true)
	// return true;
	// if (world.gridArray[auxChar.leftUpper.x / 5][auxChar.leftUpper.y / 5] ==
	// true)
	// return true;
	// return false;
	// }

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawRect(avatar.getX(), avatar.getY(), avatar.getWidth(),
				avatar.getHeight());
		g2d.setColor(Color.RED);
		int xCoords[] = new int[] { avatar.upper.x, avatar.rightUpper.x,
				avatar.rightLower.x, avatar.rightFoot.x, avatar.leftFoot.x,
				avatar.leftLower.x, avatar.leftUpper.x };
		int yCoords[] = new int[] { avatar.upper.y, avatar.rightUpper.y,
				avatar.rightLower.y, avatar.rightFoot.y, avatar.leftFoot.y,
				avatar.leftLower.y, avatar.leftUpper.y };
		g2d.drawPolygon(xCoords, yCoords, 7);
		for (int i = 0; i < 80; i++) {
			g2d.drawRect(world.boxArray[i].getX(), world.boxArray[i].getY(),
					world.boxArray[i].getWidth(), world.boxArray[i].getHeight());
		}
	}

	public void keyWasPressed(KeyEvent e) {
		int key = e.getKeyCode();
		checkColition();
		if (key == KeyEvent.VK_LEFT) {
			if (avatar.isCanMoveLeft())
				avatar.dx = -1;
			else
				avatar.dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			if (avatar.isCanMoveRight())
				avatar.dx = 1;
			else
				avatar.dx = 0;
		}

		if (key == KeyEvent.VK_UP) {
			if (avatar.isCanMoveUp())
				avatar.dy = -1;
			else
				avatar.dy = 0;
		}

		if (key == KeyEvent.VK_DOWN) {
			if (avatar.isCanMoveDown())
				avatar.dy = 1;
			else
				avatar.dy = 0;
		}
	}

	public void keyWasReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT)
			avatar.dx = 0;
		if (key == KeyEvent.VK_RIGHT)
			avatar.dx = 0;
		if (key == KeyEvent.VK_UP)
			avatar.dy = 0;
		if (key == KeyEvent.VK_DOWN)
			avatar.dy = 0;
	}

}
