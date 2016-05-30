package collectionsje;

/** A generic class used for plotting coordinate points. X and Y are the x and y coordinates to be plotted. K is the 
 * key that can be used to keep track of which coordinate is being looked at. */
public class Tuple<X, Y, K> {

	public X x;
	public Y y;
	public K key;
	
	
	public Tuple(X x, Y y, K key) {
		this.x = x;
		this.y = y;
		this.key = key;
	}
	
	/** Returns the x coordinate. 
	 * @return x; */
	public X getX() { return x; }
	
	/** Returns the y coordinate. 
	 * @return y; */
	public Y getY() { return y; }
	
	/** Returns the key used for this tuple.
	 * @return key; */
	public K getKey() { return key; }
}
