package objects;

import java.awt.*;


import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Character extends MobileObject{
	
	private int numeroPaso;
	
	public Character(){
		super();
		numeroPaso=0;
		
	}
	
	public Character(int x,int y,int height,int width,int objectSpeed, Image image){

		super(x,y,height,width,objectSpeed,image);
		numeroPaso=0;
		
	}

	public void setNp(int np) {
		this.numeroPaso = np;
	}

	public int getNp() {
		return numeroPaso;
	}

}
