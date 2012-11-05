package colition.detection;

public class World {

	TestStaticObject[] boxArray;
	boolean[][] gridArray;

	public World() {
		boxArray = new TestStaticObject[81];
		gridArray = new boolean[140][140];
		int offsetX, offsetY;
		int pos = 0;
		for (int i = 0; i < 20; i++) {
			boxArray[pos] = new TestStaticObject(0, i * 35, 35, 35);
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
			boxArray[pos] = new TestStaticObject(i * 35, 0, 35, 35);
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
			boxArray[pos] = new TestStaticObject(19 * 35, i * 35, 35, 35);
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
			boxArray[pos] = new TestStaticObject(i * 35, 19 * 35, 35, 35);
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

}
