package je.other.pointconnector;
/****************************************************************************
 *																			*
 *	Author: Adeola Uthman													*
 * 	File: Point.java														*
 * 	Date: September 4, 2016													*
 *  																		*
 *  Description: An extension to the java.awt.Point class. This Point 		*
 *  class allows for two points to be connected, and contains a list of 	*
 *  potential points, which are points that this point could connect to.	*
 *  																		*
 *  License: 																*
 *  Copyright (C) 2016  Adeola Uthman										*
 *  This program is free software: you can redistribute it and/or modify	*
 *  it under the terms of the GNU General Public License as published by	*
 *  the Free Software Foundation, either version 3 of the License, or		*
 *  (at your option) any later version.										*
 *  This program is distributed in the hope that it will be useful,			*
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of			*
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the			*
 *  GNU General Public License for more details.							*
 *  																		*
 ****************************************************************************/

import java.util.ArrayList;

public class Point extends java.awt.Point {
	private static final long serialVersionUID = 1L;

	// The point that this one is connected to
	private Point connectedPoint;
	
	// A list of potential points that this point could connect to
	private ArrayList<Point> potentialPoints;
	
	
	
	/** New point object. */
	public Point() { potentialPoints = new ArrayList<Point>(); }
	
	
	/** New point object with coordinates x and y. 
	 * @param x -- The x coordinate.
	 * @param y -- The y coordinate. */
	public Point(int x, int y) { super(x,y); potentialPoints = new ArrayList<Point>(); }

	
	
	////////// Methods ///////////
	
	/** Connects another point, p, to this point.
	 * @param p -- The point to connect to this one. */
	public void connectPoint(Point p) { connectedPoint = p; }
	
	
	/** Adds a new point to the list of potential points.
	 * @param p -- The point to add. */
	public void addPotentialPoint(Point p) { potentialPoints.add(p); }
	
	
	////////// Getters ///////////
	
	/** Returns the point that this one is connected to.
	 * @return The point connected to this one. */
	public Point getConnectedPoint() { return connectedPoint; }
	
	
	/** Returns a list of the potential points that this point could connect to.
	 * @return A list of potential points. */
	public ArrayList<Point> getPotentialPoints() { return potentialPoints; }
	
	
	/** Returns the distance from this point to another.
	 * @return the distance between points. */
	public double distanceTo(Point p) {
		return super.distance(p.x, p.y);
	}
	

	@Override
	public String toString() {
		return String.format("Point: (%d, %d)", x, y);
	}
}
