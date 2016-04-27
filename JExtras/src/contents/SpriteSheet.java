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

	
	public SpriteSheet() {}

	/** Sets the BufferedImage for the sprite sheet directly from a file in the project folder. 
	 *
	 * @param classfile -- The class that contains the main method.
	 * @param path -- The location in project folder that contains the image you need.
	 */
	public void setSpriteSheet(Class<?> classfile, String path) {
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