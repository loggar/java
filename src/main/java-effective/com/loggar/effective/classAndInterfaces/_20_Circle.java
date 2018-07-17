package com.loggar.effective.classAndInterfaces;

/**
 * Prefer class hierarchies to tagged classes
 *
 */
class _20_Circle extends _20_Figure {
	final double radius;

	_20_Circle(double radius) {
		this.radius = radius;
	}

	double area() {
		return Math.PI * (radius * radius);
	}
}
