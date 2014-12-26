import java.awt.Color;
import java.awt.Graphics;

public class Body {
	private Point start, centre;
	private int width, height,speedX,speedY;
	private Color color;

	public Body(int x, int y, int width, int height, Color color,int speedX,int speedY) {
		this.start = new Point(x, y);
		this.width = width;
		this.height = height;
		this.color = color;
		this.centre = new Point(x + (width / 2), y + (height / 2));
		this.speedX=speedX;
		this.speedY=speedY;
	}

	public void draw(Graphics g) {
		move();
		g.setColor(this.color);
		return;
	}
	private void move(){
		this.start.move(this.speedX,this.speedY);
		this.centre.move(this.speedX, this.speedY);
	}

	public boolean checkCollision(Body other) {
		if (this.centre.getDistance(other.centre) < (this.height / 2 + other.height / 2)
				&& this.centre.getDistance(other.centre) < (this.width / 2 + other.width / 2))
			return true;
		return false;
	}

	public Point getStart() {
		return start;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	public int getX(){
		return this.start.getX();
	}
	public int getY(){
		return this.start.getY();
	}
}
