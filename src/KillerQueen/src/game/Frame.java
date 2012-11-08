package game;

import javax.swing.*;

public class Frame {

	public Frame() {
		JFrame frame = new JFrame();
		frame.add(new GameCanvas());
		frame.setTitle("Game Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new Frame();
	}
}