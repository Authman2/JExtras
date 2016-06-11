package collectionsje;

import java.util.ArrayList;


/** 
A list of Tuples that are used for keeping track of coordinate points. This is really just an ArrayList, so it should be used
as such. 
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
public class TupleList<T> extends ArrayList<Tuple<T, T, T>> {
	private static final long serialVersionUID = 821688233023392724L;

	
	public TupleList() {}
	
	
	@Override
	public boolean add(Tuple<T, T, T> e) {
		return super.add(e);
	}
	
}
