package gamedev2Dje;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class GameLoop2 extends Canvas implements Runnable {
	private static final long serialVersionUID = -2418033011155805445L;

	public int WIDTH, HEIGHT;
	
	int pos = 1;
	
	private boolean running = false;
	private Thread thread; 
	
	
	public GameLoop2(int w, int h) {
		WIDTH = w;
		HEIGHT = h;
	}
	
	
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				update();
				updates++;
				delta--;
			}
			draw();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				//System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}

	
	public void initialize() {
		
	}
	
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void draw() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g  = bs.getDrawGraphics();
	
		//Drawing
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		g.setColor(Color.white);
		g.fillRect(pos, 5, 10, 10);
		
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		GameWindow w = new GameWindow(500, 400, "Working", new GameLoop2(500, 400));
	}
}
