package demo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Mundo extends JPanel implements ActionListener {

	public Image fondo;
	int camx, camy, dx, dy, sizeX, sizeY, posChX, posChY;
	Timer time;
	Personaje p;
	Object object;

	public Mundo() {

		String root = new String("/home/alberto/Dropbox/Killer Queen/Pictures/");
		p = new Personaje();
		object = new Object(0, 0, 0, (root + "cuadrado.png"));

		camx = 0;
		camy = 0;
		dx = 0;
		dy = 0;
		posChX=300;
		posChY=300;
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon(root + "BG.jpg");
		fondo = i.getImage();
		sizeX = i.getIconWidth();
		sizeY = i.getIconHeight();
		time = new Timer(10, this);
		time.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mover();
		repaint();
	}

	private void mover() {

//		System.out.println("Char: "+ posChX+" "+posChY);
//		System.out.println("cam: "+ camx+" "+camy);
//		System.out.println( p.np);
		
		if (camx <= sizeX-900 && camx >= 0) {
			camx = camx + dx;
			object.setX(-camx);
		}	

		if (camy >= -sizeY+550 && camy <= 0) {
			camy = camy + dy;
			object.setY(camy);
		}

		if (camx > sizeX-900){
			camx = sizeX-900;
			if(posChX<sizeX-300)
				posChX = posChX + dx;
		}
		
		if (camy < -sizeY+550){
			camy = -sizeY+550;
			if(posChY<sizeY-400)
				posChY = posChY - dy;
		}
		
		if (camx < 0){
			camx = 0;
			if(posChX>0)
				posChX = posChX + dx;
		}
		
		if (camy > 0){
			camy = 0;
			if(posChY>0)
				posChY = posChY - dy;
		}
		
	}

	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(fondo, -camx, camy, null);
		g2d.drawImage(p.still, posChX, posChY, null);
		g2d.drawImage(object.getObjectImage(), object.getX(), object.getY(), null);

	}

	private class AL extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				dx = 0;
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				dx = 0;
			if (e.getKeyCode() == KeyEvent.VK_UP)
				dy = 0;
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
				dy = 0;
			p.keyReleased(e);
		
			
		}

		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				dx = 5;
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				dx = -5;
			if (e.getKeyCode() == KeyEvent.VK_UP)
				dy = 5;
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
				dy = -5;
			p.keyPressed(e);
			
		}

	}

}
