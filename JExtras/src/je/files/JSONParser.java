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
		String trimmedJSON = json.replace(" ", "");
		trimmedJSON = trimmedJSON.substring(1, trimmedJSON.length() - 1);
		trimmedJSON = trimmedJSON.replace("'", "");
		trimmedJSON = trimmedJSON.replace("\"", "");
		
		
		// Get each key value pair.
		while(!trimmedJSON.equals("")) {
			Tuple t = getKeyValue(trimmedJSON);
			list.add( new Tuple(t.get(0), t.get(1)) );
			
			int firstPart = ((String)t.get(0)).length() + ((String)t.get(1)).length() + 2;
			if (firstPart <= trimmedJSON.length()) {
				trimmedJSON = trimmedJSON.substring(firstPart);
			} else {
				trimmedJSON = "";
			}			
		}
		
		return list;
	}

	public static void parseFrom(String path) {
		ReadFile reader = new ReadFile(path);
		
		// Get the entire contents of the file.
		String value = "";
		try {
			reader.read();
		} catch(Exception err) { err.printStackTrace(); }
		
		System.out.println(value);
	}


	
	/** Returns the first value in a JSON tree. 
	 * @param innerJSON -- the json string that you want to parse. 
	 * @return A tuple of the first key,value pair in the json tree. */
	private static Tuple getKeyValue(String innerJSON) {
		Object key = innerJSON.substring(0, innerJSON.indexOf(":"));
		Object value = null;
		
		if(innerJSON.indexOf(",") > -1) {
			String temp = innerJSON.substring(innerJSON.indexOf(":") + 1, innerJSON.indexOf(","));
			
			if (temp.contains("[")) {
				temp = innerJSON.substring(innerJSON.indexOf(":") + 1, innerJSON.indexOf("]")+1);
			}
			value = temp;
		} else {
			value = innerJSON.substring(innerJSON.indexOf(":") + 1, innerJSON.indexOf("}"));
		}
		
		
		return new Tuple(key, value);
	}
	
	
	
	
	
} // End of class.






