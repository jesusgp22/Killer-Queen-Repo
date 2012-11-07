package colition.detection;

import objects.StaticObject;

public class World {

	StaticObject[] boxArray;
	boolean[][] gridArray;

	public World() {
		boxArray = new StaticObject[81];
		gridArray = new boolean[140][140];
		int offsetX, offsetY;
		int pos = 0;
		for (int i = 0; i < 20; i++) {
			boxArray[pos] = new StaticObject(0, i * 35, 35, 35);
			offsetX = boxArray[pos].getX() / 5;
			offsetY = boxArray[pos].getY() / 5;
			for (int j = 0; j < 7; j++) {
				for (int j2 = 0; j2 < 7; j2++) {
					gridArray[j + offsetX][j2 + offsetY] = true;
				}
			}
			pos++;
		}
		for (int i = 0; i < 19; i++) {
			boxArray[pos] = new StaticObject(i * 35, 0, 35, 35);
			offsetX = boxArray[pos].getX() / 5;
			offsetY = boxArray[pos].getY() / 5;
			for (int j = 0; j < 7; j++) {
				for (int j2 = 0; j2 < 7; j2++) {
					gridArray[j + offsetX][j2 + offsetY] = true;
				}
			}
			pos++;
		}
		for (int i = 0; i < 20; i++) {
			boxArray[pos] = new StaticObject(19 * 35, i * 35, 35, 35);
			offsetX = boxArray[pos].getX() / 5;
			offsetY = boxArray[pos].getY() / 5;
			for (int j = 0; j < 7; j++) {
				for (int j2 = 0; j2 < 7; j2++) {
					gridArray[j + offsetX][j2 + offsetY] = true;
				}
			}
			pos++;
		}
		for (int i = 1; i < 19; i++) {
			boxArray[pos] = new StaticObject(i * 35, 19 * 35, 35, 35);
			offsetX = boxArray[pos].getX() / 5;
			offsetY = boxArray[pos].getY() / 5;
			for (int j = 0; j < 7; j++) {
				for (int j2 = 0; j2 < 7; j2++) {
					gridArray[j + offsetX][j2 + offsetY] = true;
				}
			}
			pos++;
		}

		boxArray[pos] = new StaticObject(140, 232, 35, 35);
		offsetX = boxArray[pos].getX() / 5;
		offsetY = boxArray[pos].getY() / 5;
		for (int j = 0; j < 7; j++) {
			for (int j2 = 0; j2 < 7; j2++) {
				gridArray[j + offsetX][j2 + offsetY] = true;
			}
		}
		pos++;

		boxArray[pos] = new StaticObject(450, 397, 35, 35);
		offsetX = boxArray[pos].getX() / 5;
		offsetY = boxArray[pos].getY() / 5;
		for (int j = 0; j < 7; j++) {
			for (int j2 = 0; j2 < 7; j2++) {
				gridArray[j + offsetX][j2 + offsetY] = true;
			}
		}
		pos++;

		boxArray[pos] = new StaticObject(450, 432, 35, 35);
		offsetX = boxArray[pos].getX() / 5;
		offsetY = boxArray[pos].getY() / 5;
		for (int j = 0; j < 7; j++) {
			for (int j2 = 0; j2 < 7; j2++) {
				gridArray[j + offsetX][j2 + offsetY] = true;
			}
		}
		pos++;
	}

}
