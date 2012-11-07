package objects;

import java.awt.*;


import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Character extends MobileObject{
	int np;
	public Image still;
	
	String root = new String("src/resources/images/");
	
	ImageIcon r = new ImageIcon(root + "nosamus2.png");
	ImageIcon l = new ImageIcon(root + "nosamus3.png");
	ImageIcon rr= new ImageIcon(root + "nosamus22.png");
	ImageIcon ll= new ImageIcon(root + "nosamus33.png");
	ImageIcon rrr= new ImageIcon(root + "nosamus222.png");
	ImageIcon lll= new ImageIcon(root + "nosamus333.png");
	ImageIcon rrrr= new ImageIcon(root + "nosamus2222.png");
	ImageIcon llll= new ImageIcon(root + "nosamus3333.png");
	
	
	public Character(){

		super();
		still = r.getImage();
		np=0;
		
	}
	
	public Image getImage(){
		return still;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
			if(key == KeyEvent.VK_LEFT ){
			dx = -5;
			
			if(np >=0 && np <3){
				still = l.getImage();
				np = np +1;
				System.out.println("1");
			}		
			if(np >=3 && np <6){
				still = ll.getImage();
				np = np +1;
				System.out.println("2");
			}
			if(np >=6 && np <9){
				still = lll.getImage();
				np = np +1;
				System.out.println("3");
			}
			if(np >=9){
				still = llll.getImage();
				np = np +1;
				System.out.println("4");
				if(np==12)
					np = 0;
			}
			}
			
			
			if(key == KeyEvent.VK_RIGHT){
			dx = 5;
			
				if(np >=0 && np <3){
					still = r.getImage();
					np = np +1;
					System.out.println("1");
				}		
				if(np >=3 && np <6){
					still = rr.getImage();
					np = np +1;
					System.out.println("2");
				}
				if(np >=6 && np <9){
					still = rrr.getImage();
					np = np +1;
					System.out.println("3");
				}
				if(np >=9){
					still = rrrr.getImage();
					np = np +1;
					System.out.println("4");
					if(np==12)
						np = 0;
				}
			}
			
			if(key == KeyEvent.VK_DOWN){
				still = lll.getImage();
				dy = -5;
			}
			
			if(key == KeyEvent.VK_UP){
				still = rrr.getImage();
				dy = 5;
			}

	}
	
	public void keyReleased(KeyEvent e){
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
