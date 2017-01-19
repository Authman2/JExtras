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
	*		VARIABLES
	*
	************************/





	/***********************
	*
	*		METHODS
	*
	************************/

	public static ArrayList<Tuple> parse(String json) {
		// A dictionary that will store the parsed data.
		ArrayList<Tuple> list = new ArrayList<Tuple>();
		
		// The trimmed version of the json string (also without the outside brackets).
		String trimmedJSON = json.replaceAll("\\s", "");
		trimmedJSON = trimmedJSON.substring(1, trimmedJSON.length() - 1);
		
		// Get each key value pair.
		while(!trimmedJSON.equals("")) {
			// Add the value to the array.
			Tuple t = getKeyValue(trimmedJSON);
			list.add( new Tuple(t.get(0), t.get(1)) );
			
			// Change the trimmedJSON.
			String stopAt = ",";
			if (trimmedJSON.substring(trimmedJSON.indexOf(":")+1, trimmedJSON.indexOf(":")+2).equals("[")) {
				stopAt = "]";
			} else {
				stopAt = ",";
			}
			trimmedJSON = trimmedJSON.substring(trimmedJSON.indexOf(stopAt)+1);
		}
		
		return list;
	}

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
		
		// Find the value by its specific type.
		String val = "";
		String stopAt = ",";
		if (innerJSON.substring(innerJSON.indexOf(":")+1, innerJSON.indexOf(":")+2).equals("[")) {
			stopAt = "]";
		} else {
			stopAt = ",";
		}
		val = innerJSON.substring(innerJSON.indexOf(":")+1, innerJSON.indexOf(stopAt));
		
		
		// String
		if( val.contains("'") || val.contains("\"") ) {
			val = val.replaceAll("\'", "").replaceAll("\"", "");
			value = val;
			return new Tuple(key, value);
		}
		
		// Number
		if ( val.matches("\\d+") ) {
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






