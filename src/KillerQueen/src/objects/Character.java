package objects;

import java.awt.*;

public class Character extends MobileObject{
	
	private int stepNumber;
	
	public Character(){
		super();
		stepNumber=0;
		
	}
	
	public Character(int x,int y,int height,int width,int objectSpeed, Image image){

		super(x,y,height,width,objectSpeed,image);
		stepNumber=0;
		
	}

	public void setStepNumber(int np) {
		this.stepNumber = np;
	}

	public int getStepNumber() {
		return stepNumber;
	}

}
