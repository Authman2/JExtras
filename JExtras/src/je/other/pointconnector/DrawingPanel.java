package je.other.pointconnector;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	// All of the points to draw
	private ArrayList<Point> pointsToDraw;
	
	// Whether or not the ovals should be drawn on the panel.
	private boolean shouldDrawOvals;
	
	
	public DrawingPanel(ArrayList<Point> p, boolean drawOvals) {
		pointsToDraw = p;
		shouldDrawOvals = drawOvals;
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		

		if(shouldDrawOvals) {
			// Draw each point on the JFrame
			for(Point p : pointsToDraw) {
				g.fillOval(p.x, p.y, 5, 5);
			}
		}
		
		// Draw a line for each point connection
		for(Point point : pointsToDraw) {
			
			if(point.getConnectedPoint() != null) {
				
				g.drawLine(point.x, point.y, point.getConnectedPoint().x, point.getConnectedPoint().y);
				
			}
		}
	}
	
	
} // End of class
