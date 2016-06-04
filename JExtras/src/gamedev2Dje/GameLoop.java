package gamedev2Dje;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GameLoop extends JPanel implements Runnable {
	private static final long serialVersionUID = -5034487081279828050L;
	
	
	Thread thread;
	boolean running;
	
	int fps, tps, width, height;
	
	public Graphics2D graphics;
	public BufferedImage img; 
	
	static double currFps = 120D;
	
	
	public GameLoop(int w, int h) {
		width = w;
		height = h;
		
		setPreferredSize(new Dimension(width, height));
		setFocusable(false);
		requestFocus();
	}
	
	
	
	@Override
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	
	@Override
	public void run() {
		
		initialize();
		
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / currFps;
		int frames = 0;
		int ticks = 0;
		long lastTimer = System.currentTimeMillis();
		double deltaTime = 0;
		
		while(running == true) {
			long now = System.nanoTime();
			deltaTime += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = false;
			
			while(deltaTime >= 1) {
				ticks++;
				update();
				deltaTime -= 1;
				shouldRender = true;
			}
			if(shouldRender == true) {
				draw();
				frames++;
			}
			
			try {
				Thread.sleep(2);
			} catch(Exception err) {
				err.printStackTrace();
			}
			
			if(System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				tps = frames;
				fps = ticks;
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	
	public void initialize() {
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		graphics = (Graphics2D)img.getGraphics();
		running = true;
	}
	
	public void update() {
		
	}
	
	public void draw() {
		graphics.clearRect(0, 0, width, height);
	}
	
	public void clear() {
		Graphics2D g2 = (Graphics2D)getGraphics();
		if(img != null) {
			g2.drawImage(img, 0, 0, null);
		}
		g2.dispose();
	}
	
	
	
	
	

}
