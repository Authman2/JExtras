package je.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
/**
A class used for loading Serialized objects that have already been saved.
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

public class Load {

	
	private FileInputStream fileIn;
	private String path;
	
	public Load() {}
	
	/** Loads a file from the specified path. */
	public Object LoadFile(Object j, String path) {
		this.path = path;
		fileIn = null;
		ObjectInputStream in = null;
		
		try {
			fileIn = new FileInputStream(path);
			in = new ObjectInputStream(fileIn);
			j = in.readObject();
			in.close();
			fileIn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return j;
	}
	
	/** Returns the file input stream used to load the file.
	 * @return fileIn -- the file input stream. Will return null if there is an issue loading the file at the
	 * specified path. */
	public FileInputStream getFileInputStream(String path) {
		try {
			fileIn = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fileIn;
	}

	/** Returns the path of the file.
	 * @return path -- the file path */
	public String getFilePath() {
		return this.path;
	}
}
