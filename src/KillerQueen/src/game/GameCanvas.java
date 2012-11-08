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
		character = new Character(150, 150, 100, 50, 0, null);
		timer = new Timer(25, this);
		addKeyListener(new CustomKeyAdapter());
		setPreferredSize(new Dimension(900,550));
		setFocusable(true);
		addMap();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		character.draw(g2d);
		world.drawWorld(g2d);
	}
	
	//this method is here for future map making meanwhile you can manually insert objects here.
	private void addMap() {
		StaticObject aux = new StaticObject(500, 400, 50, 50, null);
		world.insertObject(aux);
		StaticObject aux2 = new StaticObject(40, 40, 40, 40, null);
		StaticObject aux3 = new StaticObject(800,200,135,30,null);
		world.insertObject(aux2);
		world.insertObject(aux3);
		
	}
	
	private class CustomKeyAdapter extends KeyAdapter{
		public void keyReleased(KeyEvent e) {
			handleKeyRelease();
		}

		public void keyPressed(KeyEvent e) {
			handleKeyPress();
		}
		
	}

	public void handleKeyRelease() {
		
		
	}

	public void handleKeyPress() {
		
		
	}
}
