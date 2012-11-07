package world;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import objects.MobileObject;
import objects.Character;

public class World extends JPanel implements ActionListener {

	public Image fondo;
	int camx, camy, dx, dy, sizeX, sizeY, posChX, posChY;
	Timer time;
	Character p;
	MobileObject object;
	ImageLoader imageLoader;

	public World() {
		
		imageLoader = new ImageLoader();
		String root = new String("src/resources/images/");
		p = new Character();
		object = new MobileObject(0, 0, 0, 0, 0, imageLoader.cuadrado.getImage());
		

		camx = 0;
		camy = 0;
		dx = 0;
		dy = 0;
		posChX=300;
		posChY=300;
		addKeyListener(new AL());
		setFocusable(true);
		fondo = imageLoader.i.getImage();
		sizeX = imageLoader.i.getIconWidth();
		sizeY = imageLoader.i.getIconHeight();
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
		g2d.drawImage(p.getObjectImage(), posChX, posChY, null);
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
			handleKeyReleased(e);
		
			
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
			handleKeyPressed(e);
			
		}

	}
	
	public void handleKeyPressed(KeyEvent e){
		int key = e.getKeyCode();
			if(key == KeyEvent.VK_LEFT ){
			dx = -5;
			int np =p.getNp();
			
			if(np >=0 && np <3){
				p.setObjectImage( imageLoader.l.getImage());
				np = np +1;
				System.out.println("1");
			}		
			if(np >=3 && np <6){
				p.setObjectImage( imageLoader.ll.getImage());
				np = np +1;
				System.out.println("2");
			}
			if(np >=6 && np <9){
				p.setObjectImage( imageLoader.lll.getImage());
				np = np +1;
				System.out.println("3");
			}
			if(np >=9){
				p.setObjectImage( imageLoader.llll.getImage());
				np = np +1;
				System.out.println("4");
				if(np==12)
					np = 0;
			}
			}
			
			
			if(key == KeyEvent.VK_RIGHT){
			dx = 5;
			
			int np =p.getNp();
				if(np >=0 && np <3){
					p.setObjectImage(  imageLoader.r.getImage());
					np = np +1;
					System.out.println("1");
				}		
				if(np >=3 && np <6){
					p.setObjectImage( imageLoader.rr.getImage());
					np = np +1;
					System.out.println("2");
				}
				if(np >=6 && np <9){
					p.setObjectImage( imageLoader.rrr.getImage());
					np = np +1;
					System.out.println("3");
				}
				if(np >=9){
					p.setObjectImage( imageLoader.rrrr.getImage());
					np = np +1;
					System.out.println("4");
					if(np==12)
						np = 0;
				}
			}
			
			if(key == KeyEvent.VK_DOWN){
				p.setObjectImage( imageLoader.lll.getImage());
				dy = -5;
			}
			
			if(key == KeyEvent.VK_UP){
				p.setObjectImage(imageLoader.rrr.getImage());
				dy = 5;
			}

	}
	
	public void handleKeyReleased(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT)
		dx = 0;
		//still= lll.getImage();
		
		if(key == KeyEvent.VK_RIGHT)
		dx = 0;
		//still= rrr.getImage();
		
		if(key == KeyEvent.VK_DOWN)
		dy = 0;
		
		if(key == KeyEvent.VK_UP)
		dy = 0;
		
	}

}
