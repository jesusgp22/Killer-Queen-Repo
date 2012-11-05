package colition.detection;

import javax.swing.*;

public class Frame {

	public Frame() {
		JFrame frame = new JFrame();
		frame.add(new Board());
		frame.setTitle("Colision Test Board");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new Frame();
	}
}
