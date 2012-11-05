package colition.detection;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.*;
import java.security.acl.LastOwnerException;

import javax.swing.*;

public class Board extends JPanel implements ActionListener {

	TestCharacter avatar;
	Timer time;
	TestStaticObject[] boxArray;
	boolean[][] gridArray;
	
	public Board() {
		avatar = new TestCharacter(100, 100, 30, 20);
		initWorld();
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// Don't do anything
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				keyWasReleased(e);
				//System.out.println("released");
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				keyWasPressed(e);
				//System.out.println("pressed, oh nyeah");				
			}
		});
		setFocusable(true);
		time = new Timer(25, this);
		time.start();
	}

	private void initWorld() {
		boxArray = new TestStaticObject[81];
		gridArray = new boolean[140][140];
		int offsetX, offsetY;
		int pos = 0;
		for (int i = 0; i < 20; i++) {
			boxArray[pos] = new TestStaticObject(0, i * 35, 35, 35);
			offsetX = boxArray[pos].getX() / 5;
			offsetY = boxArray[pos].getY() / 5;
			for (int j = 0; j < 7; j++) {
				for (int j2 = 0; j2 < 7; j2++) {
						gridArray[j+offsetX][j2+offsetY] = true;
				}
			}
			pos++;
		}
		for (int i = 0; i < 19; i++) {
			boxArray[pos] = new TestStaticObject(i * 35, 0, 35, 35);
			offsetX = boxArray[pos].getX() / 5;
			offsetY = boxArray[pos].getY() / 5;
			for (int j = 0; j < 7; j++) {
				for (int j2 = 0; j2 < 7; j2++) {
						gridArray[j+offsetX][j2+offsetY] = true;
				}
			}
			pos++;
		}
		for (int i = 0; i < 20; i++) {
			boxArray[pos] = new TestStaticObject(19 * 35, i * 35, 35, 35);
			offsetX = boxArray[pos].getX() / 5;
			offsetY = boxArray[pos].getY() / 5;
			for (int j = 0; j < 7; j++) {
				for (int j2 = 0; j2 < 7; j2++) {
						gridArray[j+offsetX][j2+offsetY] = true;
				}
			}
			pos++;
		}
		for (int i = 1; i < 19; i++) {
			boxArray[pos] = new TestStaticObject(i * 35, 19 * 35, 35, 35);
			offsetX = boxArray[pos].getX() / 5;
			offsetY = boxArray[pos].getY() / 5;
			for (int j = 0; j < 7; j++) {
				for (int j2 = 0; j2 < 7; j2++) {
						gridArray[j+offsetX][j2+offsetY] = true;
				}
			}
			pos++;
		}
	}

	public void actionPerformed(ActionEvent e) {
		
		if(!isColiding())
			avatar.move();
		repaint();
	}

	private boolean isColiding() {
		
		TestCharacter auxChar = new TestCharacter(avatar.getX(),avatar.getY(),avatar.getHeight(),avatar.getWidth());
		auxChar.move();
		if(gridArray[auxChar.upper.x/5][auxChar.upper.y/5] == true )
			return true;
		if(gridArray[auxChar.rightUpper.x/5][auxChar.rightUpper.y/5] == true )
			return true;
		if(gridArray[auxChar.rightLower.x/5][auxChar.rightLower.y/5] == true )
			return true;
		if(gridArray[auxChar.rightFoot.x/5][auxChar.rightFoot.y/5] == true )
			return true;
		if(gridArray[auxChar.leftFoot.x/5][auxChar.leftFoot.y/5] == true )
			return true;
		if(gridArray[auxChar.leftLower.x/5][auxChar.leftLower.y/5] == true )
			return true;
		if(gridArray[auxChar.leftUpper.x/5][auxChar.leftUpper.y/5] == true )
			return true;
		return false;		
	}

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
		for (int i = 0; i < 77; i++) {
			g2d.drawRect(boxArray[i].getX(), boxArray[i].getY(),
					boxArray[i].getWidth(), boxArray[i].getHeight());
		}
	}
	
	
	public void keyWasPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT)
			avatar.dx = -3;
		if (key == KeyEvent.VK_RIGHT)
			avatar.dx = 3;
		if (key == KeyEvent.VK_UP)
			avatar.dy = -3;
		if (key == KeyEvent.VK_DOWN)
			avatar.dy = 3;
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
