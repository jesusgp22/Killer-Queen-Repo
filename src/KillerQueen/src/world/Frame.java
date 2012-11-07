package world;
	
	import javax.swing.JFrame;

	public class Frame{

		public Frame() {
			JFrame frame = new JFrame("Mundo Muestra");
			frame.add(new World());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(900, 550);
			frame.setVisible(true);
			frame.setResizable(false);

		}

		public static void main(String[] args) {
			new Frame();
		}

	}