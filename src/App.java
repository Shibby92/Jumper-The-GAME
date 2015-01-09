import javax.swing.JFrame;


public class App {
	public App(){
		JFrame window = new JFrame("JUMPER!!");
		window.setSize(1024, 768);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameGraphics panel = new GameGraphics(1024, 768);
		window.setContentPane(panel);
		window.setVisible(true);
		panel.requestFocus(false);
	}
}
