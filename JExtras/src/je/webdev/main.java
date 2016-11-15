package je.webdev;

import java.awt.*;

import java.io.File;

import javax.swing.JFrame;

import je.visual.coolbuttons.*;


public class main {

	public static void main(String[] args) {
		WebPane webPane = new WebPane();
		webPane.setHtml(new File("src/je/webdev/file.html"));
		webPane.setCSS(new File("src/je/webdev/styles.css"));
		webPane.setJavascript(new File("src/je/webdev/actions.js"));
		webPane.display();

		JFrame f = new JFrame("Test HTML");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.getContentPane().add(webPane);
		f.setSize(300, 300);
		f.getContentPane().setLayout(null);
		CoolButton c = new CircleButton("Circle_Btn");
		CoolButton c2 = new PillButton("Pill_Btn");
		CoolButton c3 = new RectangleButton("Rectangle_Btn");
		c.setBounds(40, 40, 70, 70);
		c2.setBounds(10,10,100,30);
		c3.setBounds(100,100,80,40);
		c.setBackground(Color.green);
		c2.setBackground(Color.blue);
		c3.setBackground(Color.red);
		f.add(c);
		f.add(c2);
		f.add(c3);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
