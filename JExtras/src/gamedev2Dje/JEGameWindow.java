package gamedev2Dje;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class JEGameWindow extends JFrame {
	private static final long serialVersionUID = 7056823709652215472L;
	
	
	boolean fse = false;
	int fsm = 0;
	GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

	public JEGameWindow(String title, int w, int h, GameLoop2 gl2) {
		super(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		gl2.start();
	}
//	
//	private void setfullscreen(int fsm) {
//		switch(fsm) {
//		case 0:
//			setUndecorated(false);
//			break;
//		case 1:
//			setUndecorated(true); 
//			break;
//		case 2:
//			setUndecorated(true);
//			device.setFullScreenWindow(this);
//			break;
//		}
//	}

	public void setFullScreen(int fsnm) {
		fse = true;
		if(fsm <= 2) {
			this.fsm = fsnm;
		} else {
			System.err.println("Error: " + fsnm + " is not supported.");
		}
	}
	
	
	
	
	
	
	
	
	
	
}
