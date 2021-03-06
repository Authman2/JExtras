package je.files;

import java.util.ArrayList;

import je.collections.Tuple;

/****************************************************************************
 *																			*
 *	Author: Adeola Uthman													*
 * 	File: JSONParser.java													*
 * 	Date: January 18, 2017													*
 *  																		*
 *  Description: An algorithm that parses JSON data.						*
 *  																		*
 *  License: 																*
 *  Copyright (C) 2016  Adeola Uthman										*
 *  This program is free software: you can redistribute it and/or modify	*
 *  it under the terms of the GNU General Public License as published by	*
 *  the Free Software Foundation, either version 3 of the License, or		*
 *  (at your option) any later version.										*
 *  This program is distributed in the hope that it will be useful,			*
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of			*
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the			*
 *  GNU General Public License for more details.							*
 *  																		*
 ****************************************************************************/

public class JSONParser {

	/***********************
	*
	*		METHODS
	*
	************************/
	
	/** Parses a json tree from a string, json.
	 * @param json -- The json that you want to read in the form of a String.
	 * @return An arraylist of Tuple objects that contain the values of each item in your json. */
	public static ArrayList<Tuple> parse(String json) {
		// A list that will store the parsed data.
		ArrayList<Tuple> list = new ArrayList<Tuple>();
		
		// The trimmed version of the json string (also without the outside brackets).
		String trimmedJSON = json.replaceAll("\n|\t|", "").replaceAll(" : ", ":");
		trimmedJSON = trimmedJSON.substring(1, trimmedJSON.length() - 1);
		trimmedJSON += ",";
		
		// Get each key value pair.
		while(!trimmedJSON.equals("") && !trimmedJSON.equals(",") && !trimmedJSON.equals(" ")) {
			// If it starts with a comma by accident.
			if (trimmedJSON.startsWith(",")) {
				trimmedJSON = trimmedJSON.substring(1);
			}
			
			// Add the value to the array.
			Tuple t = getKeyValue(trimmedJSON);
			list.add(t);
			
			// Change the trimmedJSON.
			String stopAt = ",";
			String firstChar = trimmedJSON.substring(trimmedJSON.indexOf(":")+1, trimmedJSON.indexOf(":")+2);
			
			if (firstChar.equals("[")) {
				stopAt = "]";
			} else if (firstChar.equals("{")) {
				stopAt = "}";
			} else if (firstChar.equals("(")) {
				stopAt = ")";
			} else {
				stopAt = ",";
			}
			trimmedJSON = trimmedJSON.substring(trimmedJSON.indexOf(stopAt)+1);
		}
		
		return list;
	}

	/** Parses a json tree from a file. That file should only contain one json tree.
	 * @param path -- The path to the text file containing your json tree. 
	 * @return An arraylist of Tuple objects that contain the values of each item in your json. */
	public static ArrayList<Tuple> parseFrom(String path) {
		ReadFile reader = new ReadFile(path);
		
		// Get the entire contents of the file.
		String value = "";
		try {
			value = reader.read();
		} catch(Exception err) { err.printStackTrace(); }
		
		return parse(value);
	}


	
	/** Returns the first value in a JSON tree. 
	 * @param innerJSON -- the json string that you want to parse. 
	 * @return A tuple of the first key,value pair in the json tree. */
	private static Tuple getKeyValue(String innerJSON) {
		innerJSON += ",";
		Object key = innerJSON.substring(0, innerJSON.indexOf(":"));
		Object value = null;
		
		// Has quotes
		if( ((String)key).startsWith("\"") || ((String)key).startsWith("'") ) {
			key = ((String)key).substring(1, ((String)key).length() - 1);
		}
		
		// Find the value by its specific type.
		String val = "";
		String stopAt = ",";
		if (innerJSON.substring(innerJSON.indexOf(":")+1, innerJSON.indexOf(":")+2).equals("[")) {
			stopAt = "]";
		} else if (innerJSON.substring(innerJSON.indexOf(":")+1, innerJSON.indexOf(":")+2).equals("{")) {
			stopAt = "}";
		} else if (innerJSON.substring(innerJSON.indexOf(":")+1, innerJSON.indexOf(":")+2).equals("(")) {
			stopAt = ")";
		} else {
			stopAt = ",";
		}
		val = innerJSON.substring(innerJSON.indexOf(":")+1, innerJSON.indexOf(stopAt));
		
		// Dictionary
		if (val.contains("{")) {
			val += "}";
			ArrayList<Tuple> a = parse(val);
			value = a;
			return new Tuple(key, value);
		}
		
		// Tuples
		if(val.contains("(")) {
			val = val.substring(1).trim();
			ReadFile reader = new ReadFile();
			Object[] array = reader.createArrayOBJECT(val, ",");
			
			if(array.length == 1 && array[0] == null) {
				return new Tuple();
			}			
			return new Tuple(array);
		}
		
		// Booleans
		if ( val.equalsIgnoreCase("true") || val.equalsIgnoreCase("false") ) {
			val = val.toLowerCase();
			value = new Boolean(val);
			
			return new Tuple(key, value);
		}
		
		// String
		if( val.contains("'") || val.contains("\"") ) {
			val = val.replaceAll("\'", "").replaceAll("\"", "");
			value = val;
			return new Tuple(key, value);
		}
		
		// Number
		if ( !val.contains("'") && !val.contains("\"") && !val.contains("[") && !val.contains("{")) {
			if ( val.contains(".") ) { value = Double.parseDouble(val); }
			else { value = Integer.parseInt(val); }
			return new Tuple(key, value);
		}
		
		// Array
		if ( val.contains("[") ) {
			val = val.replace("[", "").replaceAll("]", "");
			ReadFile reader = new ReadFile();
			Object[] array = reader.createArrayOBJECT(val, ",");
			
			value = array;
			return new Tuple(key, value);
		}
		
		return null;	
	}
	
} // End of class.






