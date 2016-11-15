package je.otherje.pointconnector;
/****************************************************************************
 *																			*
 *	Author: Adeola Uthman													*
 * 	File: PointConnector.java												*
 * 	Date: September 4, 2016													*
 *  																		*
 *  Description: An algorithm that finds the shortest						*
 *  distance between any two in a list of points and 						*
 *  subsequently connects them together.									*
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

public class PointConnector {
	
	// An arraylist that contains all of the points that need to be connected.
	private ArrayList<Point> points;
	
	
	
	///////// Constructors //////////

	/** Creates an empty object with no points to connect. */
	public PointConnector() { points = new ArrayList<Point>(); }
	
	
	/** Creates a new PointConnecter object and initializes it with a list of points to connect to each other.
	 * @param points -- The list of coordinate points that need to be connected. */
	public PointConnector(ArrayList<Point> points) { this.points = points; }
	
	
	////// Enum //////
	
	/** This enum represents the different ways that the points should be connected by. */
	public enum ConnectionType {
		
		/** Connects the points by X value, meaning that if any two points have the same X coordinate and are within a
		 * certain proximity of each other, they will be connected. */
		SAME_X,
		
		
		/** Connects the points by Y value, meaning that if any two points have the same Y coordinate and are within a
		 * certain proximity of each other, they will be connected. */
		SAME_Y,
		
		
		/** Connects a point to one or more points based on proximity alone. If there are any points within the specified
		 * distance from the point in question, then those two points will be connected. */
		PROXIMITY,
	}
	
	
	///////// Getters //////////
	
	/** Returns all of the points that are supposed to be connected. */
	public ArrayList<Point> getPoints() { return points; }
	
	
	///////// Setters //////////
	
	/** Sets the list of points to have connected to each other. 
	 * @param points -- The list of coordinate points that need to be connected. */
	public void setPoints(ArrayList<Point> points) { this.points = points; }
	
	
	/** Adds a point to the list of points that must be connected. 
	 * @param p -- The point to add to the list of points. */
	public void addPoint(Point p) { this.points.add(p); }
	
	
	/** Adds a point to the list of points with the specified x and y coordinate points.
	 * @param x -- The x coordinate. 
	 * @param y -- The y coordinate. */
	public void addPoint(int x, int y) { this.points.add(new Point(x, y)); }
	
	
	/** Starts the point connection process. 
	 * @param type -- The way that the algorithm should connect the dots by.
	 * @param proximity -- The farthest radial distance that any two points can be from each other and still connect. */
	public void connectBy(ConnectionType type, int proximity) {
		
		if(type == ConnectionType.SAME_X)
			ConnectBySameX(proximity);
		if(type == ConnectionType.SAME_Y)
			ConnectBySameY(proximity);
		if(type == ConnectionType.PROXIMITY)
			ConnectByProximity(proximity);
	}
	
	
	/** Connects the points based on the which ones are both near each other and have the same X values. Will return a list
	 * of Point objects that the user can then use to see which points are connected to other points. 
	 * @return points -- The same list that was inserted at the beginning of the algorithm, now with connected points. */
	private void ConnectBySameX(int proximity) {
		// Loop through every single point.
		for(Point initialPoint : points) {

			// Loop through all of the points again.
			for(Point otherPoint : points) {
				
				// Check if the points are close enough to each other.
				if(initialPoint.x == otherPoint.x && initialPoint.distanceTo(otherPoint) < proximity) {
					
					// Add points to the temporary list to be checked later.
					initialPoint.addPotentialPoint(otherPoint);
					
				}
			} // End of inside for-loop			
			
			// Connect initialPoint to the one with the shortest distance.
			Point nearest = getNearestPoint(initialPoint, initialPoint.getPotentialPoints());
			initialPoint.connectPoint(nearest);
			
			// Print out the point that this point is connected to.
			//System.out.println(initialPoint + " is connected to " + initialPoint.getConnectedPoint());
			
		} // End of outside for-loop
	}
	
	
	/** Connects the points based on the which ones are both near each other and have the same Y values. */
	private void ConnectBySameY(int proximity) {
		// Loop through every single point.
		for(Point initialPoint : points) {

			// Loop through all of the points again.
			for(Point otherPoint : points) {
				
				// Check if the points are close enough to each other.
				if(initialPoint.y == otherPoint.y && initialPoint.distanceTo(otherPoint) < proximity) {
					
					// Add points to the temporary list to be checked later.
					initialPoint.addPotentialPoint(otherPoint);
					
				}
			} // End of inside for-loop			
			
			// Connect initialPoint to the one with the shortest distance.
			Point nearest = getNearestPoint(initialPoint, initialPoint.getPotentialPoints());
			initialPoint.connectPoint(nearest);
			
			// Print out the point that this point is connected to.
			//System.out.println(initialPoint + " is connected to " + initialPoint.getConnectedPoint());
			
		} // End of outside for-loop
	}
	
	
	/** Connects the points based on how close they are to each other. */
	private void ConnectByProximity(int proximity) {
		
		// Loop through every single point.
		for(Point initialPoint : points) {

			// Loop through all of the points again.
			for(Point otherPoint : points) {
				
				// Check if the points are close enough to each other.
				if(initialPoint.distanceTo(otherPoint) < proximity) {
					
					// Add points to the temporary list to be checked later.
					initialPoint.addPotentialPoint(otherPoint);
					
				}
			} // End of inside for-loop			
			
			// Connect initialPoint to the one with the shortest distance.
			Point nearest = getNearestPoint(initialPoint, initialPoint.getPotentialPoints());
			initialPoint.connectPoint(nearest);
			
			// Print out the point that this point is connected to.
			//System.out.println(initialPoint + " is connected to " + initialPoint.getConnectedPoint());
			
		} // End of outside for-loop
	}
	
	
	/** Returns the point with the shortest distance to "p".
	 * @param p -- The point to connect.
	 * @param points -- The list of points to check for closeness.
	 * @return The point with the shortest distance to "p". */
	private Point getNearestPoint(Point p, ArrayList<Point> points) {
		// This can be a double, assumming no two points are separated by a distance of Integer.MAX_VALUE.
		double dist = Integer.MAX_VALUE;
		int nearestIndex = -1;
		
		// Remove "p" if it is in the list of potential points, but save it for later.
		int sameIndex = -1;
		if(points.contains(p)) {
			sameIndex = points.indexOf(p);
			points.remove(p);
		}
		
		// Try to find the point with the shortest distance to "p."
		try {
			
			for(Point somepoint : points) {
				if(somepoint.distance(p) <= dist) {
					dist = somepoint.distance(p);
					nearestIndex = points.indexOf(somepoint);
				}
			}
			
		} catch(IndexOutOfBoundsException err) {
			err.printStackTrace();
		}
		
		/* 	
		  	If, by the time you get here, the nearestIndex is still -1 (i.e. a point within the specified distance has
		  	not been found), just return the point that is the same as "p" so it can connect to itself.
		*/
		if(nearestIndex == -1) {
			nearestIndex = sameIndex;
		}
		
		/* Handle the possibility of an empty point list. */
		if(points.size() < 1) {
			return p;							// If the size of the array list is less than 1, just return "p."
		} else {
			return points.get(nearestIndex);	// Otherwise, return the one from the nearest index.
		}
	}
	
	
	
	
	
} // End of PointConnector class
