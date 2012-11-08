package game;

import java.awt.Color;
import java.awt.Graphics2D;

import objects.StaticObject;


public class World {

	public static int MAX_OBJECTS = 200;
	StaticObject[] worldObjets; 
	int numObjects;
	boolean[][] grid;
	
	public World(){
		numObjects = 0;
		worldObjets = new StaticObject[MAX_OBJECTS];
		grid = new boolean[180][110];
	}
	
	public void drawWorld(Graphics2D g2d){

		g2d.setColor(Color.BLUE);
		for (int i = 0; i < numObjects; i++) {
			worldObjets[i].draw(g2d);
		}
		
	}
	
	public void insertObject(StaticObject staticObject){
		worldObjets[numObjects] = staticObject;
		numObjects++;
		updateGrid(staticObject.getX(),staticObject.getY(),staticObject.getHeight(),staticObject.getWidth());
	}
	
	private void updateGrid(int x,int y,int height,int width){
		int offsetX = x/5;
		int offsetY = y/5;
		for (int i = 0; i < width/5; i++) {
			for (int j = 0; j < height/5; j++) {
				grid[offsetX + i][offsetY + j] = true;
			}
		}
	}
	
}
