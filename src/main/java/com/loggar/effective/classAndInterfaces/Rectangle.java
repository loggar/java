package com.loggar.effective.classAndInterfaces;

/**
 * Prefer class hierarchies to tagged classes
 *
 */
class Rectangle extends Figure {
	final double length;
	final double width;

	Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	double area() {
		return length * width;
	}
}
