package filesje;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
This class is responsible for reading data from a text file. The method "Read" will read the contents of
the text file and return them as a string. The string can then be utilized elsewhere within your code. 
There are also methods for creating one dimensional arrays of string and int from a string -- Similar to String's 
"split" method.

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

public class ReadFile {
	
	//The path to the file
	String path;
	
	//The line of text
	String line = "";
	
	//The contents of the file
	String contents = "";
	
	
	
	////////////// Constructors //////////////

	public ReadFile() {}
	
	public ReadFile(String path) { this.path = path; }
	
	
	///////////// Methods /////////////
	
	/** 
	 * Reads a file from a given path.
	 * 
	 * @param path -- The location of the file to be read on your computer.
	 * @throws java.lang.Exception -- If the file path did not find a file.
	 * @return text -- A string containing the contents of the file.
	 */
	public String read(String path) throws Exception {
		this.path = path;
		FileReader file = new FileReader(path);
		BufferedReader reader = new BufferedReader(file);
		
		String text = "";
		String line = reader.readLine();
		
		while(line != null) {
			text += line;
			line = reader.readLine();
			text += "\n";
		}
		
		reader.close();
		
		return text;
	}
	
	
	/** 
	 * Reads a file from a given path.
	 * 
	 * @throws java.lang.Exception -- If the file path did not find a file.
	 * @return text -- A string containing the contents of the file.
	 */
	public String read() throws Exception {
		FileReader file = new FileReader(path);
		BufferedReader reader = new BufferedReader(file);
		
		String text = "";
		String line = reader.readLine();
		
		while(line != null) {
			text += line;
			line = reader.readLine();
			text += "\n";
		}
		
		reader.close();
		
		return text;
	}
	
	
	/** Reads a file from the starting position up until the end position.
	 * @param start -- The starting position of the text.
	 * @param finish -- The end position of the text.
	 * @return the text from start to finish. */
	public String readThrough(int start, int finish) throws Exception {
		FileReader file = new FileReader(path);
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(file);
		
		String text = "";	//The text that the user wants
		String contents = "";	//The entire file's contents
		
		//Fill the contents
		String line = reader.readLine();
		while(line != null) {
			contents += line;
			line = reader.readLine();
			contents += "\n";
		}
		
		//Set the text from start to finish.
		text = contents.substring(start, finish);
		
		
		return text;
	}
	
	
	/** Reads a file from the starting position up until the end position.
	 * @param c -- The particular character to read up until.
	 * @return the text from start to finish. */
	public String readThrough(String c) throws Exception {
		FileReader file = new FileReader(path);
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(file);
		
		String text = "";	//The text that the user wants
		
		//Fill the contents
		String line = reader.readLine();
		while(line != null) {
			contents += line;
			line = reader.readLine();
			contents += "\n";
		}
		
		//Set the text from start to finish.
		text = contents.substring(0, contents.indexOf(c) + 1);
		contents = contents.substring(contents.indexOf(c) + 1);
		
		return text;
	}
	
	
	/** Sets the path of the file. */
	public void setPath(String path) { this.path = path; line = ""; contents = ""; }
	
	
	/** Returns the BufferedReader used for reading files. */
	public BufferedReader getReader() {
		FileReader file = null;
		try { file = new FileReader(path); } catch (FileNotFoundException e) { e.printStackTrace(); }
		BufferedReader reader = new BufferedReader(file);
		
		return reader;
	}
	
	
	/** Returns the number of lines in the file. */
	public int numLines() {
		int j = 0;
		try {
			
			String content = read();
			
			for(int i = 0; i < content.length(); i++) {
				if(content.substring(i, i+1).equals("\n")) {
					j++;
				}
			}
			
		} catch(Exception err) { err.printStackTrace(); }
		
		return j;
	}
	
	
	
	/** Takes the contents of a String, text, and splits it up by every instance of "separator."
	 *  Creates a new array of Strings with each elements.
	 * 
	 *  Example.)
	 *  String s = "apple,orange,tree,house,bird";		//Creates a new String object.
	 *  String[] sArray = CreateArraySTRING(s,","); //Creates an array of Strings from "s" with each element denoted by a ","
	 * 
	 *  The newly created array looks like this: ["apple", "orange", "tree", "house", "bird"];
	 * 
	 *  @param text -- The string to be chopped up into an array.
	 *  @param separator -- What the program will look for to split the array up by. Every time it finds "separator," it will 
	 *  					make a new element in the array.
	 *  @return array -- A 1-dimensional array containing the elements of "text", separated by "separator."
	 *  */
	public String[] createArraySTRING(String text, String separator) {
		//The number of times "separator" shows up in the given string.
		int numSeparator = 0;
		
		//Find all of the separators.
		for(int i = 0; i < text.length(); i++) {
			if(text.substring(i,i+1).equals(separator))
				numSeparator++;
		}
		
		//Create the array
		String[] array = new String[numSeparator];
		
		int i = 0;
		while(text.indexOf(separator) > -1) {
			//Add to the array
			array[i] = text.substring(0, text.indexOf(separator));
			//Remove from the text string.
			text = text.substring(text.indexOf(separator)+1);
			i++;
		}
		
		return array;
	}
	
	/** Takes the contents of a String, text, and splits it up by every instance of "separator."
	 *  Creates a new array of ints with each element parsed to an integer.
	 * 
	 *  Example.)
	 *  String s = "1,2,3,4,5";		//Creates a new String object.
	 *  int[] sArray = CreateArrayINT(s,","); //Creates an array of ints from "s" with each element denoted by a ","
	 * 
	 *  The newly created array looks like this: [1, 2, 3, 4, 5];
	 * 
	 *  @param text -- The string to be chopped up into an array.
	 *  @param separator -- What the program will look for to split the array up by. Every time it finds "separator," it will 
	 *  					make a new element in the array.
	 *  @return array -- A 1-dimensional array containing the elements of "text", separated by "separator."
	 *  */
	public int[] createArrayINT(String text, String separator) {
		//The number of times "separator" shows up in the given string.
		int numSeparator = 0;
		
		//Find all of the separators.
		for(int i = 0; i < text.length(); i++) {
			if(text.substring(i,i+1).equals(separator))
				numSeparator++;
		}
		
		//Create the array
		int[] array = new int[numSeparator];
		
		int i = 0;
		while(text.indexOf(separator) > -1) {
			//Add to the array
			array[i] = Integer.parseInt(text.substring(0, text.indexOf(separator)) );
			//Remove from the text string.
			text = text.substring(text.indexOf(separator)+1);
			i++;
		}
		
		return array;
	}
	
	/** Takes the contents of a String, text, and splits it up by every instance of "separator."
	 *  Creates a new array of floats with each element parsed to an integer.
	 * 
	 *  Example.)
	 *  String s = "1,2,3,4,5";		//Creates a new String object.
	 *  int[] sArray = CreateArrayINT(s,","); //Creates an array of floats from "s" with each element denoted by a ","
	 * 
	 *  The newly created array looks like this: [1, 2, 3, 4, 5];
	 * 
	 *  @param text -- The string to be chopped up into an array.
	 *  @param separator -- What the program will look for to split the array up by. Every time it finds "separator," it will 
	 *  					make a new element in the array.
	 *  @return array -- A 1-dimensional array containing the elements of "text", separated by "separator."
	 *  */
	public float[] createArrayFLOAT(String text, String separator) {
		//The number of times "separator" shows up in the given string.
		int numSeparator = 0;
		
		//Find all of the separators.
		for(int i = 0; i < text.length(); i++) {
			if(text.substring(i,i+1).equals(separator))
				numSeparator++;
		}
		
		//Create the array
		float[] array = new float[numSeparator];
		
		int i = 0;
		while(text.indexOf(separator) > -1) {
			//Add to the array
			array[i] = Float.parseFloat(text.substring(0, text.indexOf(separator)) );
			//Remove from the text string.
			text = text.substring(text.indexOf(separator)+1);
			i++;
		}
		
		return array;
	}
	
	/** Takes the contents of a String, text, and splits it up by every instance of "separator."
	 *  Creates a new array of double with each element parsed to an integer.
	 * 
	 *  Example.)
	 *  String s = "1,2,3,4,5";		//Creates a new String object.
	 *  int[] sArray = CreateArrayINT(s,","); //Creates an array of double from "s" with each element denoted by a ","
	 * 
	 *  The newly created array looks like this: [1, 2, 3, 4, 5];
	 * 
	 *  @param text -- The string to be chopped up into an array.
	 *  @param separator -- What the program will look for to split the array up by. Every time it finds "separator," it will 
	 *  					make a new element in the array.
	 *  @return array -- A 1-dimensional array containing the elements of "text", separated by "separator."
	 *  */
	public double[] createArrayDOUBLE(String text, String separator) {
		//The number of times "separator" shows up in the given string.
		int numSeparator = 0;
		
		//Find all of the separators.
		for(int i = 0; i < text.length(); i++) {
			if(text.substring(i,i+1).equals(separator))
				numSeparator++;
		}
		
		//Create the array
		double[] array = new double[numSeparator];
		
		int i = 0;
		while(text.indexOf(separator) > -1) {
			//Add to the array
			array[i] = Double.parseDouble(text.substring(0, text.indexOf(separator)) );
			//Remove from the text string.
			text = text.substring(text.indexOf(separator)+1);
			i++;
		}
		
		return array;
	}
	
}
