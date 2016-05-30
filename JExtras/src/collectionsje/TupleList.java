package collectionsje;

import java.util.ArrayList;


/** A list of Tuples that are used for keeping track of coordinate points. This is really just an ArrayList, so it should be used
 * as such. */
public class TupleList extends ArrayList<Tuple<Integer, Integer, Integer>> {
	private static final long serialVersionUID = 821688233023392724L;

	
	public TupleList() {}
	
	
	@Override
	public boolean add(Tuple<Integer, Integer, Integer> e) {
		return super.add(e);
	}
	
}
