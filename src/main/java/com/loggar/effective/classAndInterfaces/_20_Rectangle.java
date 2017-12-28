package com.loggar.effective.classAndInterfaces;

/**
 * Prefer class hierarchies to tagged classes
 *
 */
class _20_Rectangle extends _20_Figure {
	final double length;
	final double width;

	_20_Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	double area() {
		return length * width;
	}
}
