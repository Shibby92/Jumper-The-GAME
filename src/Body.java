import java.awt.Color;
import java.awt.Graphics;

public class Body {
	private Point start, centre;
	private int width, height, speedX, speedY;
	private Color color;
	private int minX, maxX, minY, maxY;
	private int accelleration;

	public Body(int x, int y, int width, int height, Color color, int speedX,
			int speedY, int minX, int minY, int maxX, int maxY) {
		this.start = new Point(x, y);
		this.width = width;
		this.height = height;
		this.color = color;
		this.centre = new Point(x + (width / 2), y + (height / 2));
		this.speedX = speedX;
		this.speedY = speedY;
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
		this.accelleration=0;
	}

	public void draw(Graphics g) {
		move();
		g.setColor(this.color);
		return;
	}
	public void jump(){
		if(this.start.getY()==this.maxY-this.height){
		this.speedY=-20;
		this.accelleration=1;
		}
	}

	@Override
	public String toString() {
		return "Body [start=" + start.toString() + ", centre=" + centre + ", width="
				+ width + ", height=" + height + ", speedX=" + speedX
				+ ", speedY=" + speedY + ", color=" + color + ", minX=" + minX
				+ ", maxX=" + maxX + ", minY=" + minY + ", maxY=" + maxY
				+ ", accelleration=" + accelleration + "]";
	}

	private void move() {
		this.speedY+=this.accelleration;
		if (this.getX() + this.width + this.speedX >= this.maxX
				&& this.speedX > 0) {
			this.speedX = 0;
			this.start.setX(maxX - this.width);
			this.centre.setX(maxX - this.width / 2);
		}
		if (this.getX() + this.speedX <= this.minX && this.speedX < 0) {
			this.speedX = 0;
		}
		if (this.getY() + this.height + this.speedY >= this.maxY 
				&& this.speedY > 0) {
			this.speedY = 0;
			this.start.setY(this.maxY - this.height);
			this.centre.setY(maxY - this.height / 2);
		}
		if (this.getY()<= this.minY && this.speedY < 0) {
			this.speedY = 0;
		}
		this.start.move(this.speedX, this.speedY);
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

	public int getX() {
		return this.start.getX();
	}

	public int getY() {
		return this.start.getY();
	}
}
