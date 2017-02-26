package je.collections;

import java.util.Iterator;

public class Tuple implements java.lang.Iterable<Object> {

	private Object[] objects;
	private int index = 0;
	
	
	/** Creates a new Tuple object with as many parameters as the user wants. 
	 * @param objects -- Any parameters that the user may need. They can also be different types. */
	public Tuple(Object...objects) {
		this.objects = objects;
	}
	
	
	
	/** Appends a new object onto the end of the tuple.
	 * @param itm -- The item to add.*/
	public void append(Object itm) { 
		Object[] temp = new Object[this.objects.length+1];
		for(int i = 0; i < objects.length; i++) {
			temp[i] = objects[i];
		}
		temp[objects.length] = itm;
		objects = temp;
	}
	
	
	/** Removes the item at index i.
	 * @param i -- The index of the item to remove.
	 * @return The object that was just removed. */
	public Object remove(int i) {
		Object[] temp = new Object[this.objects.length-1];
		Object remover = objects[i];
		
		for(int j = 0; j < i; j++) {
			temp[j] = objects[j];
		}
		for(int j = i+1; j <= temp.length; j++) {
			temp[j-1] = objects[j];
		}
		
		objects = temp;
		
		return remover;
	}
	
	
	/** Removes the object, obj.
	 * @param obj -- The object to remove.
	 * @return The object that was just removed. */
	public Object remove(Object obj) {
		for(int i = 0; i < objects.length; i++) {
			if(objects[i] == obj) {
				remove(i);
				break;
			}
		}
		return obj;
	}
	
	
	/** Removes every instance of the object, obj.
	 * @param obj -- The object to remove.
	 * @return The object that was just removed. */
	public Object removeAll(Object obj) {
		for(int i = 0; i < objects.length; i++) {
			if(objects[i] == obj) {
				remove(i);
			}
		}
		return obj;
	}
	
	
	
	/** Removes every object from the tuple. */
	public void clear() {
		for(int i = 0; i < objects.length; i++) {
			remove(i);
		}
	}
	
	
	
	/** Returns the object at the "i"th index of the tuple.
	 * Example.) Tuple t = new Tuple("name", "Joe Schmoe");
	 * 			 t.get(0) ----> "name"
	 * 			 t.get(1) ----> "Joe Schmoe"
	 * @param i -- The index.
	 * @return the object at i. */
	public Object atIndex(int i) {
		return this.objects[i];
	}
	
	
	/**@return whether or not the tuple contains any elements. */
	public boolean isEmpty() {
		if(objects.length == 0) {
			return true;
		}
		return false;
	}
	
	
	/**@return the number of objects in this tuple. */
	public int getCount() {
		return objects.length;
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





	@Override
	public Iterator<Object> iterator() {
		return new Iterator<Object>() {

			@Override
			public boolean hasNext() {
				if(index == objects.length - 1) {
					return true;
				} else {
					return false;
				}
			}

			@Override
			public Object next() {
				if(objects.length > 0) {
					return objects[index++];
				}
				return null;
			}
			
		};
	}
	
}
