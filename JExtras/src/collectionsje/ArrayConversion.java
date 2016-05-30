package collectionsje;

 
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



/** This class contains a method which can convert a one-dimensional array to a two-dimensional array. */
public class ArrayConversion {

	/** Converts a one-dimensional array of integers into a two-dimensional array of integers. Returns the newly converted
	 * array.
	 * 
	 * @param array -- The one-dimensional array to be converted.
	 * @param breakPoint -- The point at which to break up the array. For example, if you input {1,2,3,4,5,6,7,8,9,10} and you
	 * set the breakPoint to 5, it will cut the array at the fifth item, returning the array:
	 * {{1,2,3,4,5}, {6,7,8,9,10}}.
	 * @return array2D -- The array above as a two-dimensional array.
	 */
	public static int[][] OneToTwo(int[] array, int breakPoint) {
		int[][] newArray = null;
		//If they divide evenly, just make that many rows. Otherwise add an extra row.
		if((array.length%breakPoint) == 0) {
			newArray = new int[(int)(array.length/breakPoint)][breakPoint];
		} else {
			newArray = new int[(int)(array.length/breakPoint)+1][breakPoint];
		}
		
		final int BREAK = breakPoint;
		int i = 0, k = 0;
		int height = 0;
		//Check again if they divide evenly, and set the height accordingly.
		if((array.length%breakPoint) == 0) {
			height = (int)(array.length/breakPoint);
		} else {
			height = (int)(array.length/breakPoint)+1;
		}
		
		//As long as k is less than the height.
		while(k < height) {
			//Create a temporary array for each line.
			int[] temp = new int[BREAK];
			//Fill the temporary array with the 1D array up until the breakpoint.
			for(int newi = 0; newi < BREAK; newi++) {
				if(i < array.length) {
					temp[newi] = array[i];
					i++;
				} else {
					temp[newi] = 0;
					i++;
				}
			}
			//Add to the breakpoint
			breakPoint += BREAK;
			//Set the 2D array's "x-array" to the temporary array.
			newArray[k] = temp;
			//Increment "k" so that you go to the next line.
			k++;
		}
		
		return newArray;
	}
	
	/** Converts a one-dimensional array of floats into a two-dimensional array of floats. Returns the newly converted
	 * array.
	 * 
	 * @param array -- The one-dimensional array to be converted.
	 * @param breakPoint -- The point at which to break up the array. For example, if you input {1,2,3,4,5,6,7,8,9,10} and you
	 * set the breakPoint to 5, it will cut the array at the fifth item, returning the array:
	 * {{1,2,3,4,5}, {6,7,8,9,10}}.
	 * @return array2D -- The array above as a two-dimensional array.
	 */
	public static float[][] OneToTwo(float[] array, int breakPoint) {
		float[][] newArray = null;
		//If they divide evenly, just make that many rows. Otherwise add an extra row.
		if((array.length%breakPoint) == 0) {
			newArray = new float[(int)(array.length/breakPoint)][breakPoint];
		} else {
			newArray = new float[(int)(array.length/breakPoint)+1][breakPoint];
		}
		
		final int BREAK = breakPoint;
		int i = 0, k = 0;
		int height = 0;
		//Check again if they divide evenly, and set the height accordingly.
		if((array.length%breakPoint) == 0) {
			height = (int)(array.length/breakPoint);
		} else {
			height = (int)(array.length/breakPoint)+1;
		}
		
		//As long as k is less than the height.
		while(k < height) {
			//Create a temporary array for each line.
			float[] temp = new float[BREAK];
			//Fill the temporary array with the 1D array up until the breakpoint.
			for(int newi = 0; newi < BREAK; newi++) {
				if(i < array.length) {
					temp[newi] = array[i];
					i++;
				} else {
					temp[newi] = 0;
					i++;
				}
			}
			//Add to the breakpoint
			breakPoint += BREAK;
			//Set the 2D array's "x-array" to the temporary array.
			newArray[k] = temp;
			//Increment "k" so that you go to the next line.
			k++;
		}
		
		return newArray;
	}
	
	
	/** Converts a one-dimensional array of doubles into a two-dimensional array of doubles. Returns the newly converted
	 * array.
	 * 
	 * @param array -- The one-dimensional array to be converted.
	 * @param breakPoint -- The point at which to break up the array. For example, if you input {1,2,3,4,5,6,7,8,9,10} and you
	 * set the breakPoint to 5, it will cut the array at the fifth item, returning the array:
	 * {{1,2,3,4,5}, {6,7,8,9,10}}.
	 * @return array2D -- The array above as a two-dimensional array.
	 */
	public static double[][] OneToTwo(double[] array, int breakPoint) {
		double[][] newArray = null;
		//If they divide evenly, just make that many rows. Otherwise add an extra row.
		if((array.length%breakPoint) == 0) {
			newArray = new double[(int)(array.length/breakPoint)][breakPoint];
		} else {
			newArray = new double[(int)(array.length/breakPoint)+1][breakPoint];
		}
		
		final int BREAK = breakPoint;
		int i = 0, k = 0;
		int height = 0;
		//Check again if they divide evenly, and set the height accordingly.
		if((array.length%breakPoint) == 0) {
			height = (int)(array.length/breakPoint);
		} else {
			height = (int)(array.length/breakPoint)+1;
		}
		
		//As long as k is less than the height.
		while(k < height) {
			//Create a temporary array for each line.
			double[] temp = new double[BREAK];
			//Fill the temporary array with the 1D array up until the breakpoint.
			for(int newi = 0; newi < BREAK; newi++) {
				if(i < array.length) {
					temp[newi] = array[i];
					i++;
				} else {
					temp[newi] = 0;
					i++;
				}
			}
			//Add to the breakpoint
			breakPoint += BREAK;
			//Set the 2D array's "x-array" to the temporary array.
			newArray[k] = temp;
			//Increment "k" so that you go to the next line.
			k++;
		}
		
		return newArray;
	}
	
	
	/** Converts a one-dimensional array of longs into a two-dimensional array of longs. Returns the newly converted
	 * array.
	 * 
	 * @param array -- The one-dimensional array to be converted.
	 * @param breakPoint -- The point at which to break up the array. For example, if you input {1,2,3,4,5,6,7,8,9,10} and you
	 * set the breakPoint to 5, it will cut the array at the fifth item, returning the array:
	 * {{1,2,3,4,5}, {6,7,8,9,10}}.
	 * @return array2D -- The array above as a two-dimensional array.
	 */
	public static long[][] OneToTwo(long[] array, int breakPoint) {
		long[][] newArray = null;
		//If they divide evenly, just make that many rows. Otherwise add an extra row.
		if((array.length%breakPoint) == 0) {
			newArray = new long[(int)(array.length/breakPoint)][breakPoint];
		} else {
			newArray = new long[(int)(array.length/breakPoint)+1][breakPoint];
		}
		
		final int BREAK = breakPoint;
		int i = 0, k = 0;
		int height = 0;
		//Check again if they divide evenly, and set the height accordingly.
		if((array.length%breakPoint) == 0) {
			height = (int)(array.length/breakPoint);
		} else {
			height = (int)(array.length/breakPoint)+1;
		}
		
		//As long as k is less than the height.
		while(k < height) {
			//Create a temporary array for each line.
			long[] temp = new long[BREAK];
			//Fill the temporary array with the 1D array up until the breakpoint.
			for(int newi = 0; newi < BREAK; newi++) {
				if(i < array.length) {
					temp[newi] = array[i];
					i++;
				} else {
					temp[newi] = 0;
					i++;
				}
			}
			//Add to the breakpoint
			breakPoint += BREAK;
			//Set the 2D array's "x-array" to the temporary array.
			newArray[k] = temp;
			//Increment "k" so that you go to the next line.
			k++;
		}
		
		return newArray;
	}
	
	
	/** Converts a one-dimensional array of shorts into a two-dimensional array of shorts. Returns the newly converted
	 * array.
	 * 
	 * @param array -- The one-dimensional array to be converted.
	 * @param breakPoint -- The point at which to break up the array. For example, if you input {1,2,3,4,5,6,7,8,9,10} and you
	 * set the breakPoint to 5, it will cut the array at the fifth item, returning the array:
	 * {{1,2,3,4,5}, {6,7,8,9,10}}.
	 * @return array2D -- The array above as a two-dimensional array.
	 */
	public static short[][] OneToTwo(short[] array, int breakPoint) {
		short[][] newArray = null;
		//If they divide evenly, just make that many rows. Otherwise add an extra row.
		if((array.length%breakPoint) == 0) {
			newArray = new short[(int)(array.length/breakPoint)][breakPoint];
		} else {
			newArray = new short[(int)(array.length/breakPoint)+1][breakPoint];
		}
		
		final int BREAK = breakPoint;
		int i = 0, k = 0;
		int height = 0;
		//Check again if they divide evenly, and set the height accordingly.
		if((array.length%breakPoint) == 0) {
			height = (int)(array.length/breakPoint);
		} else {
			height = (int)(array.length/breakPoint)+1;
		}
		
		//As long as k is less than the height.
		while(k < height) {
			//Create a temporary array for each line.
			short[] temp = new short[BREAK];
			//Fill the temporary array with the 1D array up until the breakpoint.
			for(int newi = 0; newi < BREAK; newi++) {
				if(i < array.length) {
					temp[newi] = array[i];
					i++;
				} else {
					temp[newi] = 0;
					i++;
				}
			}
			//Add to the breakpoint
			breakPoint += BREAK;
			//Set the 2D array's "x-array" to the temporary array.
			newArray[k] = temp;
			//Increment "k" so that you go to the next line.
			k++;
		}
		
		return newArray;
	}
	
	
	/** Converts a one-dimensional array of objects into a two-dimensional array of objects. Returns the newly converted
	 * array.
	 * 
	 * @param array -- The one-dimensional array to be converted.
	 * @param breakPoint -- The point at which to break up the array.
	 * @return array2D -- The array above as a two-dimensional array.
	 */
	public static Object[][] OneToTwo(Object[] array, int breakPoint) {
		Object[][] newArray = null;
		//If they divide evenly, just make that many rows. Otherwise add an extra row.
		if((array.length%breakPoint) == 0) {
			newArray = new Object[(int)(array.length/breakPoint)][breakPoint];
		} else {
			newArray = new Object[(int)(array.length/breakPoint)+1][breakPoint];
		}
		
		final int BREAK = breakPoint;
		int i = 0, k = 0;
		int height = 0;
		//Check again if they divide evenly, and set the height accordingly.
		if((array.length%breakPoint) == 0) {
			height = (int)(array.length/breakPoint);
		} else {
			height = (int)(array.length/breakPoint)+1;
		}
		
		//As long as k is less than the height.
		while(k < height) {
			//Create a temporary array for each line.
			Object[] temp = new Object[BREAK];
			//Fill the temporary array with the 1D array up until the breakpoint.
			for(int newi = 0; newi < BREAK; newi++) {
				if(i < array.length) {
					temp[newi] = array[i];
					i++;
				} else {
					temp[newi] = null;
					i++;
				}
			}
			//Add to the breakpoint
			breakPoint += BREAK;
			//Set the 2D array's "x-array" to the temporary array.
			newArray[k] = temp;
			//Increment "k" so that you go to the next line.
			k++;
		}
		
		return newArray;
	}
}
