package je.visual.coolbuttons;
/****************************************************************************
 *																			*
 *	Author: Adeola Uthman													*
 * 	File: PillButton.java													*
 * 	Date: November 14, 2016													*
 *  																		*
 *  Description: A pill shaped JButton that extends the abstract class		*
 *	"CoolButton." It functions just like any other JButton, but just has a 	*
 * 	pill shape.																*
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
import java.awt.Graphics;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.Font;

import javax.swing.*;

public class PillButton extends CoolButton {
    

	//////// Constructors /////////

	/** Creates a pill button with default attributes. */
	public PillButton() {
		super();
		shape = ButtonShape.PILL;
	}


	/** Creates a pill button with the string, message, as the button
	text.
	@param message -- The text on the button. */
	public PillButton(String message) {
		super(message);
		shape = ButtonShape.PILL;
	}


	/** Creates a pill button with the string, message, as the button
	text, and with the background color, c.
	@param message -- The text on the button.
	@param c -- The background color of the button. */
	public PillButton(String message, Color c) {
		super(message, c);
		shape = ButtonShape.PILL;
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
			shape_shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), pill_arc, pill_arc);
		}
		return shape_shape.contains(x,y);
	}

}
