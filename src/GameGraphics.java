import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class GameGraphics extends JPanel implements ActionListener{
	private Timer animation;
	private Body[] elements;
	int eleCount;
	int width;
	int height;

	public GameGraphics(int width,int height){
		super();
		animation=new Timer(200,this);
		elements=new Body[3];
		eleCount=0;
		this.width=width;
		this.height=height;
		//ovo smo stavili samo radi debugginga
		eleCount=1;
		elements[0]=new Oval(0,0,20,30,Color.RED,3,1);
		this.setBackground(new Color(184,242,245));
		animation.start();
	}
	@Override public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i =0;i<eleCount;i++){
			elements[i].draw(g);
		}
		g.setColor(new Color(54,140,22));
		g.fill3DRect(0, this.height-100, this.width, 100, true);//resizable window scaling ZADACA
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	

}
