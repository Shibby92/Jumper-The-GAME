import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameGraphics extends JPanel implements ActionListener {
	private Date start;
	private Timer animation;
	private Body elements;
	private Body[] obstacles;
	private Body player;
	int eleCount = 0;
	int width;
	int height;

	public GameGraphics(int width, int height) {
		super();
		obstacles = new Body[25];
		player=new Oval(width/2,height-100-40,40,40,Color.BLUE,0,0,0,0,width,height-100);
		start=new Date();
		int rangeMin=1030;
		int rangeMax=1330;
		for (int i = 0; i < obstacles.length; i++) {
			int radius = random(10, 30);
			obstacles[i] = new Oval(random(rangeMin, rangeMax), height - 100 - radius,
					radius, radius, Color.ORANGE, random(8, 15) * -1, 0, 0, 0,
					1330, height);
			rangeMin+=100;
			rangeMax+=100;
			eleCount++;
		}
		animation = new Timer(17, this);
		this.width = width;
		this.height = height;
		elements = new Oval(0, 638, 30, 30, Color.RED, 50, 50, 0, 0, width,
				height - 100);
		this.setBackground(new Color(184, 242, 245));
		addKeyListener(new KeyHandler());
		animation.start();
	}

	private int random(int min, int max) {
		return min + (int) (Math.random() * (max - min));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Date end= new Date();
		long points=end.getTime()-start.getTime();
		g.drawString(Long.toString(points), 500, 100);
		player.draw(g);
		for (int i = 0; i < eleCount; i++) {
			obstacles[i].draw(g);
			if(player.checkCollision(obstacles[i])){
				animation.stop();
				JOptionPane.showMessageDialog(null, "OGRAJISALI STE!");
				break;
			}
		}
		g.setColor(new Color(54, 140, 22));
		g.fill3DRect(0, this.height - 100, this.width, 100, true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	private class KeyHandler extends KeyAdapter{
		public void keyTyped(KeyEvent e){
			player.jump();
		}
	}

}
