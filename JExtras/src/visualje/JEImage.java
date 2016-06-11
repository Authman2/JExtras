package visualje;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 
An image class. JEImage is just an easier way to load BufferedImages into one's project. It has access to all of
the same methods that BufferedImages do through the "getImage()" method, and also extra methods for doing things
specific to JEImages.
Copyright (C) 2016  Adeola Uthman

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.


@author Adeola Uthman
@version 1.0
*/
public class JEImage implements Serializable {
	private static final long serialVersionUID = -2541788792627589269L;
	
	//The buffered image.
	private BufferedImage image;
	
	//The width and height
	private int width, height;
	
	//The path to the file
	private String path;

	
	public JEImage() {}
	
	/** @param classfile -- The class that contains a main method.
	 * @param path -- The project path to the image. */
	public JEImage(Class<?> classfile, String path) {
		this.path = path;
		URL url = classfile.getResource(path);
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		this.image = img;
		width = img.getWidth();
		height = img.getHeight();
	}
	
	/** @param bi -- A buffered image. */
	public JEImage(BufferedImage bi) {
		this.image = bi;
		width = bi.getWidth();
		height = bi.getHeight();
	}
	
	

	/** Sets the BufferedImage directly from a file in the project folder. 
	 *
	 * @param classfile -- The class that contains the main method.
	 * @param path -- The location in project folder that contains the image you need.
	 */
	public void setImage(Class<?> classfile, String path) {
		this.path = path;
		URL url = classfile.getResource(path);
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		this.image = img;
	}
	
	
	/** Sets the image to a specified BufferedImage.
	 * @param bi -- The BufferedImage you want to set image to. */
	public void setImage(BufferedImage bi) {
		this.image = bi;
	}
	
	
	/** Adds the other image onto this image starting at the specified coordinates.
	 * @param other -- The other BufferedImage that you want to combine with this one's.
	 * @param startX -- The x coordinate to start adding the other image onto this one at.
	 * @param startY -- The y coordinate to start adding the other image onto this one at.
	 * @return A new JEImage that is a combination of the original image and the image from other. */
	public JEImage combine(BufferedImage other, int startX, int startY) {
		
		//Create a new BufferedImage that is bigger than it really needs to be. It will be resized later.
		BufferedImage newImg = new BufferedImage(this.width+other.getWidth(), this.height+other.getHeight(), this.getImage().getType());
		
		//Set all the pixels to a specific background color
		for(int i = 0; i < newImg.getWidth(); i++) {
			for(int j = 0; j < newImg.getHeight(); j++) {
				newImg.setRGB(i, j, -1);
			}
		}
		
		//First, recreate the original image starting at (0,0).
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				newImg.setRGB(i, j, getImage().getRGB(i, j));
			}
		}
		
		//Loop through and tack on the other image to the new one starting from the specified coordinates.
		//Loops over the size of the other image.
		for(int i = 0; i < other.getWidth(); i++) {
			for(int j = 0; j < other.getHeight(); j++) {
				newImg.setRGB(i+startX, j+startY, other.getRGB(i, j));
			}
		}
		
		//These are the real heights and widths of the image; the ones that remove the extra space from newImg.
		int realWidth = 0;
		int realHeight = 0;
		
		//Loop through the image that was just made. Determine the height and width based on where the RGB values are not -1.
		for(int i = 0; i < newImg.getWidth(); i++) { if(newImg.getRGB(i, 0) != -1) realWidth++; }
		for(int i = 0; i < newImg.getHeight(); i++) { if(newImg.getRGB(0, i) != -1) realHeight++; }
		
		//Create another BufferedImage with the correct size
		BufferedImage finalImg = new BufferedImage(realWidth, realHeight, newImg.getType());
		
		//Fill each pixel with the correct RGB value from newImg
		for(int i = 0; i < realWidth; i++)
			for(int j = 0; j < realHeight; j++) 
				finalImg.setRGB(i, j, newImg.getRGB(i, j));
		
		
		return new JEImage(finalImg);
	}
	
	
	
	/** Adds the other image onto this image starting at the specified coordinates.
	 * @param other -- The other JEImage that you want to combine with this one.
	 * @param startX -- The x coordinate to start adding the other image onto this one at.
	 * @param startY -- The y coordinate to start adding the other image onto this one at.
	 * @return A new JEImage that is a combination of the original image and the image from other. */
	public JEImage combine(JEImage other, int startX, int startY) {
		
		//Create a new BufferedImage that is bigger than it really needs to be. It will be resized later.
		BufferedImage newImg = new BufferedImage(this.width+other.getWidth(), this.height+other.getHeight(), this.getImage().getType());
		
		//Set all the pixels to a specific background color
		for(int i = 0; i < newImg.getWidth(); i++) {
			for(int j = 0; j < newImg.getHeight(); j++) {
				newImg.setRGB(i, j, -1);
			}
		}
		
		//First, recreate the original image starting at (0,0).
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				newImg.setRGB(i, j, getImage().getRGB(i, j));
			}
		}
		
		//Loop through and tack on the other image to the new one starting from the specified coordinates.
		//Loops over the size of the other image.
		for(int i = 0; i < other.getWidth(); i++) {
			for(int j = 0; j < other.getHeight(); j++) {
				newImg.setRGB(i+startX, j+startY, other.getRGB(i, j));
			}
		}
		
		//These are the real heights and widths of the image; the ones that remove the extra space from newImg.
		int realWidth = 0;
		int realHeight = 0;
		
		//Loop through the image that was just made. Determine the height and width based on where the RGB values are not -1.
		for(int i = 0; i < newImg.getWidth(); i++) { if(newImg.getRGB(i, 0) != -1) realWidth++; }
		for(int i = 0; i < newImg.getHeight(); i++) { if(newImg.getRGB(0, i) != -1) realHeight++; }
		
		//Create another BufferedImage with the correct size
		BufferedImage finalImg = new BufferedImage(realWidth, realHeight, newImg.getType());
		
		//Fill each pixel with the correct RGB value from newImg
		for(int i = 0; i < realWidth; i++)
			for(int j = 0; j < realHeight; j++) 
				finalImg.setRGB(i, j, newImg.getRGB(i, j));
		
		
		return new JEImage(finalImg);
	}
	
	
	
	/** Sets the size that the image should be.
	 * @param w -- The width
	 * @param h -- The height */
	public void setSize(int w, int h) {
		width = w;
		height = h;
	}
	
	
	
	/** Returns the image as a buffered image.
	 * @return image */
	public BufferedImage getImage() {
		if(image != null) {
			return image;
		} else {
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			
			for(int i = 0; i < width; i++) {
				for(int j = 0; j < height; j++) {
					Color c = Color.white;
					image.setRGB(i, j, c.getRGB());
				}
			}
			
			return image;
		}
	}
	
	
	
	/** Returns the width of the image. 
	 * @return width. */
	public int getWidth() {
		if(image != null)
			return getImage().getWidth();
		else
			return width;
	}
	
	
	
	/** Returns the width of the image. 
	 * @return height. */
	public int getHeight() {
		if(image != null)
			return getImage().getHeight();
		else 
			return height;
	}
	
	
	
	/** Returns the RGB color value at a specified point.
	 * @param x - The x coordinate
	 * @param y - The y coordinate
	 * @return rgb value. */
	public int getRGB(int x, int y) {
		return getImage().getRGB(x, y);
	}
	
	
	
	/** Sets the RGB color value at a particular point. 
	 * @param x - The x coordinate
	 * @param y - The y coordinate
	 * @param value - The RGB value. */
	public void setRGB(int x, int y, int value) {
		getImage().setRGB(x, y, value);
	}
	
	
	
	/** Returns the path to the file of the image. 
	 * @return path. */
	public String getPath() {
		return path;
	}
	
	
	
	/** Returns information about the sprite sheet image.
	 * @return The path to the image, and the width and height of the image. */
	public String toString() {
		return "[Image: " + path + ", Width: " + image.getWidth() + ", Height: " + image.getHeight() + "]";
	}
	
	
	
	/** Returns a "part," or "sprite", of the image. The part is just the particular square area you would like to take 
	 * from the image.
	 *
	 * @param x -- The x position on the image to start from.
	 * @param y -- The y position on the image to start from.
	 * @param width -- The width of the sprite.
	 * @param height -- The height of the sprite.
	 */
	public BufferedImage getPart(int x, int y, int width, int height) {
		BufferedImage sprite = image.getSubimage(x,y,width,height);
		return sprite;
	}
	
	
	
	/** Returns a new JEImage that is the same as this one. It is a clone of this image. */
	public JEImage clone() {
		JEImage copy = new JEImage(this.image);
		
		return copy;
	}
}