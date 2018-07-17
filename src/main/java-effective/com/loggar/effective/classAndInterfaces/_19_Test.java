package com.loggar.effective.classAndInterfaces;

import static com.loggar.effective.classAndInterfaces._19_PhysicalConstants.AVOGADROS_NUMBER;

//Use of static import to avoid qualifying constants
public class _19_Test {
	double atoms(double mols) {
		return AVOGADROS_NUMBER * mols;
	}
	// Many more uses of PhysicalConstants justify static import
}
/*
 * Normally a utility class requires clients to qualify constant names with a
 * class name, you can avoid the need for qualifying the constants with the
 * class name by making use of the static import facility, introduced in release
 * 1.5:
 */
