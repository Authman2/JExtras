package collectionsje;

/** 
A generic class used for plotting coordinate points. X and Y are the x and y coordinates to be plotted. K is the 
key that can be used to keep track of which coordinate is being looked at.
Copyright (C) 2016  Adeola Uthman

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.


@author Adeola Uthman
@version 1.0 
*/

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
	
	/** Checks if the X and Y coordinates of this tuple are within range.
	 * @param t -- The other tuple to compare to.
	 * @param range -- The range that the numbers can be within.
	 * @return true if they are within range. False otherwise.*/
	public boolean isInRange(Tuple<Integer, Integer, Integer> t, int range) {
		Tuple<Integer, Integer, Integer> thisTup = new Tuple<Integer, Integer, Integer>((Integer)x,(Integer)y,(Integer)key);
		
		if(t.getX() >= thisTup.getX() - range && t.getX() <= thisTup.getX() + range) {
			return true;
		} else {
			return false;
		}
	}
	
}
