package je.visual.coolbuttons;
/****************************************************************************
 *																			*
 *	Author: Adeola Uthman													*
 * 	File: CircleButton.java													*
 * 	Date: November 14, 2016													*
 *  																		*
 *  Description: A circular shaped JButton that extends the abstract class	*
 *	"CoolButton." It functions just like any other JButton, but just has a 	*
 * 	cirucular shape.														*
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

import java.awt.Color;
import java.awt.geom.Ellipse2D;

public class CircleButton extends CoolButton {
	private static final long serialVersionUID = -6448396798895428483L;

	
	//////// Constructors /////////

	/** Creates a circle button with default attributes. */
	public CircleButton() {
		super();
		shape = ButtonShape.CIRCLE;
	}


	/** Creates a circle button with the string, message, as the button
	text.
	@param message -- The text on the button. */
	public CircleButton(String message) {
		super(message);
		shape = ButtonShape.CIRCLE;
	}


	/** Creates a circle button with the string, message, as the button
	text, and with the background color, c.
	@param message -- The text on the button.
	@param c -- The background color of the button. */
	public CircleButton(String message, Color c) {
		super(message, c);
		shape = ButtonShape.CIRCLE;
	}






	//////// Getters ////////

	/** Returns whether or not the point (x,y) is contained within this
	button. Must be implemented in subclasses.
	@param x -- The x position.
	@param y -- The y position.
	@return whether or not (x,y) is inside of this button.
	*/
	public boolean contains(int x, int y) {
		if(shape_shape == null || !shape_shape.getBounds().equals(getBounds())) {
			shape_shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		return shape_shape.contains(x,y);
	}

}
