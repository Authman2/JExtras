package contents;

import java.io.BufferedReader;
import java.io.FileReader;

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

/**
 * This class is responsible for reading data from a text file. The method "Read" will read the contents of
 * the text file and return them as a string. The string can then be utilized elsewhere within your code. 
 * There are also methods for creating one dimensional arrays of string and int from a string -- Similar to String's 
 * "split" method.
 * 
 * */
public class ReadFile {

	public ReadFile() {}

	/** 
	 * Reads a file from a given path.
	 * 
	 * @param path -- The location of the file to be read on your computer.
	 * @throws java.lang.Exception -- If the file path did not find a file.
	 * @return text -- A string containing the contents of the file.
	 */
	public String Read(String path) throws Exception {
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
	public String[] CreateArraySTRING(String text, String separator) {
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
	public int[] CreateArrayINT(String text, String separator) {
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
	public float[] CreateArrayFLOAT(String text, String separator) {
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
	public double[] CreateArrayDOUBLE(String text, String separator) {
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
