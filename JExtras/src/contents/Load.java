package contents;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
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
			System.out.println("Loaded!");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return j;
	}
	
	/** Returns the file input stream used to load the file.
	 * @return fileIn -- the file input stream */
	public FileInputStream getFileInputStream() {
		return fileIn;
	}

	/** Returns the path of the file.
	 * @return path -- the file path */
	public String getFilePath() {
		return this.path;
	}
}
