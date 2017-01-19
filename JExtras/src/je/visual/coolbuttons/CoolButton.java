package je.visual.coolbuttons;
/****************************************************************************
 *																			*
 *	Author: Adeola Uthman													*
 * 	File: CoolButton.java													*
 * 	Date: November 14, 2016													*
 *  																		*
 *  Description: An abstract representation of a "cool" button. This is		*
 * 	really just a button that can shaped to make cooler looking JButtons.	*
 * 	It can be shaped into a circle, a pill, a rectangle, and a button with 	*
 *	no shape (Just the text).												*
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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;

import javax.swing.JButton;

public abstract class CoolButton extends JButton {
private static final long serialVersionUID = -7817494993672404327L;

	protected static final int pill_arc = 30;


	// The enum for the button shape
	public enum ButtonShape { CIRCLE, PILL, RECTANGLE }

	// The size of the button
	protected Dimension size;

	// The text on the button
	protected String message;

	// The enum for what shape this button should take
	protected ButtonShape shape;

	// The actual Shape object
	protected Shape shape_shape;






	////////// Constructors ///////////

	/** Default constructor for a cool button. */
	public CoolButton() {
		this("");
	}



	/** Creates a new CoolButton with the specified button text, message.
	@param message -- The text on the button. */
	public CoolButton(String message) {
		this(message, Color.gray);
	}



	/** Creates a new CoolButton with the specified text, message, and with the 
	color, c. 
	@param message -- The text on the button.
	@param c -- The background color of the button. */
	public CoolButton(String message, Color c) {
		this.message = message;
		setBackground(c);
		setFocusable(false);

		Dimension sz = getPreferredSize();
		sz.width = sz.height = Math.max(sz.width, sz.height);
		setPreferredSize(sz);

		setContentAreaFilled(false);
		setBorderPainted(false);
	}




	////////// Other //////////

	public void paintComponent(Graphics g) {
		if(getModel().isArmed()) {
			g.setColor( noErrorColor(getBackground(), 40, "-") );
		} else {
			g.setColor(getBackground());
		}


		// Draw a shape based on the type of shape specified.
		if(shape == ButtonShape.CIRCLE) {
			g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
		
		} else if(shape == ButtonShape.PILL) {
			g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, pill_arc, pill_arc);

		} else if(shape == ButtonShape.RECTANGLE) {
			g.fillRect(0, 0, getSize().width - 1, getSize().height - 1);

		}


		super.paintComponent(g);
	}





	////////// Setters //////////

	@Override
	public void setSize(int w, int h) {
		setPreferredSize(new Dimension(w,h));
	}



	/** Sets the shape of the button.
	@param s -- The shape enum type. */
	public void setShape(ButtonShape s) {
		this.shape = s;
	}







	////////// Getters //////////

	/** @return the text on the button. */
	public String getText() { return message; }



	/** @return the shape of the button. */
	public ButtonShape getButtonShape() { return shape; }



	/** Returns whether or not the point (x,y) is contained within this
	button. Must be implemented in subclasses.
	@param x -- The x position.
	@param y -- The y position.
	@return whether or not (x,y) is inside of this button.
	*/
	public abstract boolean contains(int x, int y);






	/** THIS IS THE NO ERROR COLOR METHOD FROM MY CustomWindows PROJECT. */
	protected static Color noErrorColor(Color color, int changeAmount, String operation) {
		Color newColor = null;
		int newRed = 0, newGreen = 0, newBlue = 0;
		
		if(operation.equals("-")) {
			if(color.getRed() - changeAmount < 0) {
				int temp = (color.getRed() - changeAmount);
				newRed = (color.getRed() - changeAmount) + (int)Math.abs(temp);
			} else {
				newRed = (color.getRed() - changeAmount);
			}
			if(color.getGreen() - changeAmount < 0) {
				int temp = (color.getGreen() - changeAmount);
				newGreen = (color.getGreen() - changeAmount) + (int)Math.abs(temp);
			} else {
				newGreen = (color.getGreen() - changeAmount);
			}
			if(color.getBlue() - changeAmount < 0) {
				int temp = (color.getBlue() - changeAmount);
				newBlue = (color.getBlue() - changeAmount) + (int)Math.abs(temp);
			} else {
				newBlue = (color.getBlue() - changeAmount);
			}
		} else if(operation.equals("+")) {
			if(color.getRed() + changeAmount > 255) {
				int temp = (color.getRed() + changeAmount);
				newRed = (color.getRed() + changeAmount) + (int)Math.abs(temp);
			} else {
				newRed = (color.getRed() + changeAmount);
			}
			if(color.getGreen() + changeAmount > 255) {
				int temp = (color.getGreen() + changeAmount);
				newGreen = (color.getGreen() + changeAmount) + (int)Math.abs(temp);
			} else {
				newGreen = (color.getGreen() + changeAmount);
			}
			if(color.getBlue() + changeAmount > 255) {
				int temp = (color.getBlue() + changeAmount);
				newBlue = (color.getBlue() + changeAmount) + (int)Math.abs(temp);
			} else {
				newBlue = (color.getBlue() + changeAmount);
			}
		}
		
		newColor = new Color(newRed, newGreen, newBlue);
		return newColor;
	}
}
