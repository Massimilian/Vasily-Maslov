package ru.job4j.condition;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 03/01/2018
 */

public class Triangle {
	private Point first;
	private Point second;
	private Point third;
	
	public Triangle(Point first, Point second, Point third) {
	this.first = first;
	this.second = second;
	this.third = third;
	}
	
	/**
	* Метод вычисления полупериметра по длинам сторон:
	*
	* result = (ab + ac + bc) / 2;
	*
	*@param ab расстояние между точками a и b
	*@param ac расстояние между точками a и c
	*@param bc расстояние между точками b и c
	*@return Полупериметр
	*/
	public double period(double ab, double ac, double bc) {
    return ab / 2 + ac / 2 + bc / 2;
	}
	
	/**
	* Метод должен вычислить площадь треугольника.
	*
	* @return Вернуть прощадь, если треугольник существует или -1, если треугольника нет.
	*/
	public double area() {
		double result = -1;
		double ab = this.first.distanceTo(this.second);
		double ac = this.first.distanceTo(this.third);
		double bc = this.second.distanceTo(this.third);
		double period = this.period(ab, ac, bc);
//		if (this.exist(ab, ac, bc)) {
			// написать формулу для расчета площади треугольника.
			//result = ...;
		result = Math.sqrt(period * (period - ab) * (period - ac) * (period - bc));
//		}
		return result;
	}

	/**
	* Метод проверяет можно ли построить треугольник с такими длинами сторон.
	* 
	* Подумайте какое надо написать условие, чтобы определить можно ли построить треугольник.
	* 
	* @param ab Длина от точки a b. 
	* @param ac Длина от точки a c.
	* @param bc Длина от точки b c.
	* @return
	*/
//	private boolean exist(double ab, double ac, double bc) {
//	if (ab == 0D || ac == 0D || bc == 0D) {
//		return false;
//		} else {
//		return true;
//		}
//	}
}