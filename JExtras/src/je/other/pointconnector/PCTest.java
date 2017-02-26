package je.other.pointconnector;

import java.util.ArrayList;
import java.util.Random;

public class PCTest {

	public static void main(String[] args) {
		
		// Create a random list of points.
		ArrayList<Point> a = new ArrayList<Point>();
		Random rand = new Random();
		int size = new Integer("15000");
		for(int i = 0; i < size; i++) a.add(new Point( rand.nextInt(100), rand.nextInt(100) ));
		
		// Initialize and use the point connector.
		PointConnector pc = new PointConnector(a);
		pc.connect();
		
		// Print out the results.
		for(Point p : pc.getOutput()) {
			System.out.println(p.toString() + " is connected to " + p.getConnectedPoint().toString());
		}
	}
	
	
	
}
