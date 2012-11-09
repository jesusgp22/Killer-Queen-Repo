package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import world.ImageLoader;
import objects.Character;
import objects.StaticObject;

@SuppressWarnings("serial")
public class GameCanvas extends JPanel implements ActionListener {

	World world;
	Character character;
	Timer timer;
	ImageLoader imageLoader;

	public GameCanvas() {
		imageLoader = new ImageLoader();
		world = new World();
		character = new Character(150, 150, 100, 50, null);
		timer = new Timer(10, this);
		addKeyListener(new CustomKeyAdapter());
		setPreferredSize(new Dimension(900,550));
		setFocusable(true);
		addMap();
		timer.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		character.move(); 
		handleColitions();
		repaint();
	}
	

	private void handleColitions() {
		boolean solveColitionNeeded = false;
		if( world.grid[character.getUpper().x/5][character.getUpper().y/5] == true){
			character.up = true;
			solveColitionNeeded = true;
		}
		if( world.grid[character.getRightUpper().x/5][character.getRightUpper().y/5] == true){
			character.rup = true;
			solveColitionNeeded = true;
		}
		if( world.grid[character.getLeftUpper().x/5][character.getLeftUpper().y/5] == true){
			character.lup = true;
			solveColitionNeeded = true;
		}
		if( world.grid[character.getRightLower().x/5][character.getRightLower().y/5] == true){
			character.rlow = true;
			solveColitionNeeded = true;
		}
		if( world.grid[character.getLeftLower().x/5][character.getLeftLower().y/5] == true){
			character.llow = true;
			solveColitionNeeded = true;
		}
		if( world.grid[character.getRightFoot().x/5][character.getRightFoot().y/5] == true){
			character.rfoot = true;
			solveColitionNeeded = true;
		}
		if( world.grid[character.getLeftFoot().x/5][character.getLeftFoot().y/5] == true){
			character.lfoot = true;
			solveColitionNeeded = true;
		}
		if(solveColitionNeeded)
			solveColition();
		
	}

	private void solveColition() {
		int x=character.getX();
		int y=character.getY();
		if(character.lfoot || character.rfoot)
			y-=2;
		if(character.llow || character.lup)
			x+=2;
		if(character.rlow || character.rup)
			x-=2;
		if(character.up)
			y+=2;
		character.setLocation(x, y);
		character.lfoot = false;
		character.rfoot = false;
		character.up = false;
		character.rup =false;
		character.rlow = false;
		character.lup = false;
		character.llow = false;
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		world.drawWorld(g2d);
		character.draw(g2d);
	}
	
	//this method is here for future map making meanwhile you can manually insert objects here.
	private void addMap() {
		StaticObject aux = new StaticObject(500, 400, 50, 50, null);
		world.insertObject(aux);
		StaticObject aux2 = new StaticObject(40, 40, 40, 40, null);
		StaticObject aux3 = new StaticObject(800,200,135,30,null);
		world.insertObject(aux2);
		world.insertObject(aux3);
		
		StaticObject aux4 = new StaticObject(100,100,300,50,null);
		StaticObject aux5 = new StaticObject(150,400,50,300,null);
		world.insertObject(aux4);
		world.insertObject(aux5);
		
	}
	
	private class CustomKeyAdapter extends KeyAdapter{
		public void keyReleased(KeyEvent e) {
			handleKeyRelease(e);
		}

		public void keyPressed(KeyEvent e) {
			handleKeyPress(e);
		}
		
	}

	public void handleKeyRelease(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_DOWN){
			character.setDy(0);
		}
		if(key == KeyEvent.VK_UP){
			character.setDy(0);
		}
		if(key == KeyEvent.VK_LEFT){
			character.setDx(0);
		}
		if(key == KeyEvent.VK_RIGHT){
			character.setDx(0);
		}
	}

	public void handleKeyPress(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_DOWN){
			character.setDy(1);
		}
		if(key == KeyEvent.VK_UP){
			character.setDy(-1);
		}
		if(key == KeyEvent.VK_LEFT){
			character.setDx(-1);
		}
		if(key == KeyEvent.VK_RIGHT){
			character.setDx(1);
		}
	}
}
