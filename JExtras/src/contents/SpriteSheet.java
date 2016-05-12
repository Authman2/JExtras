package contents;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import javax.imageio.ImageIO;

public class SpriteSheet implements Serializable {
	private static final long serialVersionUID = -2541788792627589269L;
	
	//The spritesheet buffered image.
	private BufferedImage spritesheet;
	
	//The path to the file
	private String path;

	
	public SpriteSheet() {}
	
	/** @param classfile -- The class that contains a main method.
	 * @param path -- The project path to the image. */
	public SpriteSheet(Class<?> classfile, String path) {
		this.path = path;
		URL url = classfile.getResource(path);
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		this.spritesheet = img;
	}
	
	/** @param bi -- A buffered image. */
	public SpriteSheet(BufferedImage bi) {
		this.spritesheet = bi;
	}
	
	

	/** Sets the BufferedImage for the sprite sheet directly from a file in the project folder. 
	 *
	 * @param classfile -- The class that contains the main method.
	 * @param path -- The location in project folder that contains the image you need.
	 */
	public void setSpriteSheet(Class<?> classfile, String path) {
		this.path = path;
		URL url = classfile.getResource(path);
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		this.spritesheet = img;
	}
	
	
	/** Sets the spritesheet to a specified BufferedImage.
	 * @param bi -- The BufferedImage you want to set the spritesheet to. */
	public void setSpriteSheet(BufferedImage bi) {
		this.spritesheet = bi;
	}
	
	
	/** Returns the sprite sheet as a buffered image.
	 * @return spritesheet */
	public BufferedImage getSpriteSheet() {
		return spritesheet;
	}
	
	
	/** Returns the path to the file of the spritesheet's image. */
	public String getPath() {
		return path;
	}
	
	
	/** Returns information about the sprite sheet image.
	 * @return The path to the spritesheet, and the width and height of the spritesheet. */
	public String toString() {
		return "[Image: " + path + ", Width: " + spritesheet.getWidth() + ", Height: " + spritesheet.getHeight() + "]";
	}
	
	
	/** Returns a "part," or "sprite", of the spritesheet. The part is just the particular square area you would like to take 
	 * from the spritesheet.
	 *
	 * @param x -- The x position on the spritesheet to start from.
	 * @param y -- The y position on the spritesheet to start from.
	 * @param width -- The width of the sprite.
	 * @param height -- The height of the sprite.
	 */
	public BufferedImage getPart(int x, int y, int width, int height) {
		BufferedImage sprite = spritesheet.getSubimage(x,y,width,height);
		return sprite;
	}

}