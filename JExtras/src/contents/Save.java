package contents;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
/**
 * @author Adeola Uthman
 * @version 1.0
 * Copyright: 2016 Adeola Uthman
 * 
The MIT License (MIT)

Copyright (c) 2016 Adeola Uthman

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/


public class Save {

	private FileOutputStream fileOut;
	private ObjectOutputStream out;
	private OutputStream defout;
	
	public Save() {}

	/** Saves an object to the specified path. */
	public void SaveFile(Object t, String savename) {
		try {
			fileOut = new FileOutputStream(savename);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(t);
			out.close();
			fileOut.close();
			System.out.println("Saved!");
		} catch(IOException i) {
			i.printStackTrace();
		}
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
