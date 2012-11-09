package objects;

import java.awt.Graphics2D;
import java.awt.Image;

public class StaticObject extends BaseObject {

	Image objectImage;
	
	public StaticObject() {
		super();
		objectImage = null;
	}

	public StaticObject(int x, int y, int height, int width,Image image) {
		super(x, y, height, width);
		this.objectImage = image;
	}
	
	public void draw(Graphics2D g2d){
		g2d.fillRect(x, y, width, height);
	}

}
