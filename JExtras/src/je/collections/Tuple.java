package je.collections;

public class Tuple {

	private Object[] objects;
	
	
	/** Creates a new Tuple object with as many parameters as the user wants. 
	 * @param objects -- Any parameters that the user may need. They can also be different types. */
	public Tuple(Object...objects) {
		this.objects = objects;
	}
	
	
	
	/** Returns the object at the "i"th index of the tuple.
	 * Example.) Tuple t = new Tuple("name", "Joe Schmoe");
	 * 			 t.get(0) ----> "name"
	 * 			 t.get(1) ----> "Joe Schmoe"
	 * @param i -- The index.
	 * @return the object at i. */
	public Object get(int i) {
		return this.objects[i];
	}
	
	
	
	public String toString() {
		int i = 0;
		String r = "(";
		while(i < objects.length) {
			if(i == objects.length - 1) {
				r += objects[i].toString();
			} else {
				r += objects[i].toString() + ",";
			}
			i++;
		}
		r += ")";
		return r;
	}
	
	
}
