package ru.job4j.shapes;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 01/03/2018
 */
 
public class Paint {
	public void draw(Shape shape) {
		System.out.print(shape.draw());
	}
}