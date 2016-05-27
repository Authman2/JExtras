package contents;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import javax.imageio.ImageIO;

public class JEImage implements Serializable {
	private static final long serialVersionUID = -2541788792627589269L;
	
	//The buffered image.
	private BufferedImage image;
	
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
	}
	
	/** @param bi -- A buffered image. */
	public JEImage(BufferedImage bi) {
		this.image = bi;
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
	
	
	/** Returns the image as a buffered image.
	 * @return image */
	public BufferedImage getImage() {
		return image;
	}
	
	
	/** Returns the width of the image. 
	 * @return width. */
	public int getWidth() {
		return getImage().getWidth();
	}
	
	
	/** Returns the width of the image. 
	 * @return height. */
	public int getHeight() {
		return getImage().getHeight();
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