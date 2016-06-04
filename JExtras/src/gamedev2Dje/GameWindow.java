package gamedev2Dje;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

	
	public GameWindow(int w, int h, String title, GameLoop2 gl2) {
		
		gl2.setPreferredSize(new Dimension(w, h));
		gl2.setMaximumSize(new Dimension(w, h));
		gl2.setMinimumSize(new Dimension(w, h));
		
		
		setTitle(title);
		add(gl2);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		gl2.start();
	}
	
	
}
