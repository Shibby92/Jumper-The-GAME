import javax.swing.JFrame;

public class Play {
	public static void main(String[] args) {

		JFrame window = new JFrame("JUMPER!!");
		window.setSize(1024, 768);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameGraphics panel = new GameGraphics();
		window.setContentPane(panel);
		window.setVisible(true);
	}
}
