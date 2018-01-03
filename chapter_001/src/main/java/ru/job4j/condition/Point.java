package ru.job4j.condition;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $IId$
 * @since 03/01/2018
 */
 
public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double distanceTo(Point that) {
		return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
	}
	
	public static void main(String[] args) {
		Point a = new Point(0, 1);
		Point b = new Point(1, 0);
		System.out.println(a.distanceTo(b));
	}
}