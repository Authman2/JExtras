package je.other.pointconnector;

import java.util.ArrayList;

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

public class PointConnector {
	
	private ArrayList<Point> input;
	private ArrayList<Point> output;
	
	
	
	/** Initializes the point connector with a list of input points. */
	public PointConnector(ArrayList<Point> p) {
		this.input = p;
		this.output = new ArrayList<Point>();
	}
	
	
	
	
	
	/** Connects all of the input points based on shortest distance. */
	public void connect() {
		if(input == null) { return; }
		if(input.size() == 0) { return; }
		
		// The reference point.
		Point p1 = input.get(0);
		
		// The shortest distance from the reference point.
		double dist = Integer.MAX_VALUE;
		Point ref = null;
		
		// Go through each point.
		if(input.size() > 1) {
			for(int i = 1; i < input.size(); i++) {
				Point p2 = input.get(i);
				if(p1.distance(p2.x, p2.y) < dist) {
					dist = p1.distance(p2.x, p2.y);
					ref = p2;
				}
			}
		
			// Connect the points together.
			p1.connectPoint(ref);
			ref.connectPoint(p1);
			
			// Remove the points that have already been connected.
			output.add(p1);
			output.add(ref);
			input.remove(p1);
			input.remove(ref);
			
			// Recursively, connect other points.
			connect();
		} else {
			// Connect to itself.
			p1.connectPoint(p1);
			output.add(p1);
		} // End of point connecting.
	}
	
	
	
	public ArrayList<Point> getOutput() { return output; }
	public ArrayList<Point> getInput() { return input; }
	
}