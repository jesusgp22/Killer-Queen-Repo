package world;

import javax.swing.ImageIcon;

public class ImageLoader {

	String root = new String("src/resources/images/");

	ImageIcon r;
	ImageIcon l;
	ImageIcon rr;
	ImageIcon ll;
	ImageIcon rrr;
	ImageIcon lll;
	ImageIcon rrrr;
	ImageIcon llll;
	ImageIcon cuadrado;
	ImageIcon i;
	
	public ImageLoader() {

		r = new ImageIcon(root + "nosamus2.png");
		l = new ImageIcon(root + "nosamus3.png");
		rr = new ImageIcon(root + "nosamus22.png");
		ll = new ImageIcon(root + "nosamus33.png");
		rrr = new ImageIcon(root + "nosamus222.png");
		lll = new ImageIcon(root + "nosamus333.png");
		rrrr = new ImageIcon(root + "nosamus2222.png");
		llll = new ImageIcon(root + "nosamus3333.png");
		cuadrado = new ImageIcon(root + "cuadrado.png");
		i = new ImageIcon(root + "BG.jpg");	
	}

}
