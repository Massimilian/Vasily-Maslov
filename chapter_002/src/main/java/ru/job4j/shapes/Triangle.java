package ru.job4j.shapes;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 01/03/2018
 */
 
public class Triangle implements Shape {
	@Override
	public String draw() {
		StringBuilder str = new StringBuilder();
		str.append("  *  ");
		str.append(" *** ");
		str.append("*****");
		return str.toString();
	}
}