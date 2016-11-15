package je.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
/**
 * Used for saving objects that implement Serializable. 
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


public class Save {

	private FileOutputStream fileOut;
	private ObjectOutputStream out;
	private OutputStream defout;
	
	public Save() {}

	/** Saves an object to the specified path.
	 * @return the file of the object you just saved. */
	public File SaveFile(Object t, String savename) {
		try {
			fileOut = new FileOutputStream(savename);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(t);
			out.close();
			fileOut.close();
			return new File(savename);
		} catch(IOException i) {
			i.printStackTrace();
		}
		return null;
	}
	
	
	
	/** Returns the file output stream used for saving objects */
	public FileOutputStream getFileOutputStream() {
		return fileOut;
	}
	
	/** Returns the output stream for different data types. Not for objects. */
	public OutputStream getOutputStream() {
		return defout;
	}
	
	/** Returns the object output stream used to save the file. */
	public ObjectOutputStream getObjectOutputStream() {
		return out;
	}
}
