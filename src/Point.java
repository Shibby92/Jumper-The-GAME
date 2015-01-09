public class Point {
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDistance(Point other) {
		int result, dx, dy;
		dx = (this.x - other.x) * (this.x - other.x);
		dy = (this.y - other.y) * (this.y - other.y);
		result = (int) (Math.sqrt(dx + dy));
		return result;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	public void move(int speedX, int speedY) {
		this.x += speedX;
		this.y += speedY;
	}
}
