package objects;

import java.awt.*;


import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Character extends MobileObject{
	
	private int np;
	
	public Character(){
		super();
		np=0;
		
	}
	
	public Character(int x,int y,int height,int width,int objectSpeed, Image image){

		super(x,y,height,width,objectSpeed,image);
		np=0;
		
	}

	public void setNp(int np) {
		this.np = np;
	}

	public int getNp() {
		return np;
	}

}
