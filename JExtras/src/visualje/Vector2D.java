package visualje;


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
 * This is a Vector class for two-dimensional positions. An object's "Vector2D" is going to represent
 * It's position. The 'D' in this class does not stand for "Double". It is just a way to say that this class is 
 * used for two-dimensional entities.
 * 
 */
public class Vector2D{

	/** The x and y coordinates of the vector. */
	public float X, Y;
	
	
	/** Default constructor. Creates a new vector at the point (0,0). */
	public Vector2D() { X = 0; Y = 0; }
	
	
	/** Constructor. Creates a new vector with the specified coordinates. 
	 * 
	 * @param x -- The X-coordinate of the vector.
	 * @param y -- The Y-coordinate of the vector.
	 */
	public Vector2D(float x, float y) { this.X = x; this.Y = y; }
	
	
	/** Adds the points of "vec" to this vector. The 'x' values will add together and the
	 * 'y' values will add together. Returns the updated vector. 
	 * @param vec -- The vector that is to be added to this one. 
	 * @return Returns the updated vector. */
	public Vector2D add(Vector2D vec) {
		this.X += vec.X;
		this.Y += vec.Y;
		return this;
	}
	
	
	/** Subtracts the points of "vec" from this vector. The 'x' values will subtract from one another and the
	 * 'y' values will do the same. Since you do not directly subtract two vectors, it just adds the negative
	 * vector of 'vec.' 
	 * @param vec -- The vector that is to be subtracted from this one.
	 * @return Returns the updated vector. */
	public Vector2D subtract(Vector2D vec) {
		this.X += vec.negative().X;
		this.Y += vec.negative().Y;
		return this;
	}
	
	
	/** Multiplies the points of "vec" to this vector. The 'x' values will multiply together and the
	 * 'y' values will multiply together. Returns the updated vector. 
	 * @param vec -- The vector that this vector is to be multiplied by. 
	 *  @return Returns the updated vector. */
	public Vector2D multipy(Vector2D vec) {
		this.X *= vec.X;
		this.Y *= vec.Y;
		return this;
	}
	
	
	/** Divides the points of "vec" to this vector. The 'x' values will divide and the
	 * 'y' values will divide. Returns the updated vector. 
	 * @param vec -- The vector that this vector is to be divided by.
	 *  @return Returns the updated vector.  */
	public Vector2D divide(Vector2D vec) {
		this.X /= vec.X;
		this.Y /= vec.Y;
		return this;
	}
	
	
	/** Calculates the magnitude of the vector.
	 *  @return Returns the magnitude of this vector. */
	public double Magnitude() {
		return Math.sqrt((X*X) + (Y*Y));
	}
	
	
	/** Calculates the length of the vector. 
	 *  @return Returns the length of this vector.*/
	public double Length() {
		double xComp = Magnitude()*Math.cos(DirAngle());
		double yComp = Magnitude()*Math.sin(DirAngle());
		
		return Math.sqrt((xComp*xComp) + (yComp*yComp));
	}
	
	
	/** Calculates the direction angle of the vector starting from the angle 0 degrees. Angle is in
	 * degrees, not radians. If you need the angle in radians, use the method DirAngleRAD().
	 * @return Returns the direction angle of this vector in degrees. */
	public double DirAngle() {
		return (Math.atan(Y/X)*180)/Math.PI;
	}
	
	
	/** Calculates the direction angle of the vector starting from 0 radians. This method returns the
	 * angle in radians, not degrees. If you need the angle in radians, use the method DirAngle(). 
	 * @return Returns the direction angle of this vector in radians. */
	public double DirAngleRAD() {
		return Math.atan(Y/X);
	}
	
	
	/** Calculates the angle between this vector and another in degrees.
	 * @param vec -- The other vector to check the angle with.
	 * @return Returns the angle between this vector and "vec." */
	public double AngleBetweenVectors(Vector2D vec) {
		double angle = (this.Magnitude() * vec.Magnitude())/(this.Length() * vec.Length());
		
		return (Math.acos(angle)*180)/Math.PI;
	}
	
	/** Calculates the angle between this vector and another in radians. 
	 *  @param vec -- The other vector to check the angle with.
	 * @return Returns the angle between this vector and "vec" in radians. */
	public double AngleBetweenVectorsRAD(Vector2D vec) {
		double angle = (this.Magnitude() * vec.Magnitude())/(this.Length() * vec.Length());
		
		return Math.acos(angle);
	}
	
	/** Calculates the dot product of two vectors. Calculates using the angle in degrees.
	 * @param vec -- The other vector to calculate the dot product with.
	 * @return the dot product.
	 *  */
	public double dotProduct(Vector2D vec) {
		return this.Magnitude() * vec.Magnitude() * this.AngleBetweenVectors(vec);
	}
	
	/** Returns the dot product of two vectors. Calculates using the angle in radians.
	 * @param vec -- The other vector to calculate the dot product with.
	 * @return the dot product.
	 *  */
	public double dotProductRAD(Vector2D vec) {
		return this.Magnitude() * vec.Magnitude() * this.AngleBetweenVectorsRAD(vec);
	}
	
	
	/** Calculates the distance between this vector and "vec."
	 * @param vec -- The second vector after this current one.
	 * @return the distance between this and vec.
	 *  */
	public double Distance(Vector2D vec) {
		double dx = (vec.X - X)*(vec.X - X);
		double dy = (vec.Y - Y)*(vec.Y - Y);
		
		return Math.sqrt(dx + dy);
	}
	
	
	/** Calculates the distance between two vectors.
	 * @param vec1 -- The first vector
	 * @param vec2 -- The second vector
	 * @return the distance between vec1 and vec2.
	 * */
	public double Distance(Vector2D vec1, Vector2D vec2) {
		double dx = (vec2.X - vec1.X)*(vec2.X - vec1.X);
		double dy = (vec2.Y - vec1.Y)*(vec2.Y - vec1.Y);
		
		return Math.sqrt(dx + dy);
	}
	
	
	/** Returns a new vector that has the coordinates (0,0). 
	 * @return a vector with the coordinates (0,0). */
	public static Vector2D zero() {
		return new Vector2D(0,0);
	}
	
	
	/** Returns a normalized vector, which is just a vector with a magnitude of 1, that
	 * points in the direction of the original vector. 
	 * @return A normalized vector. */
	public Vector2D normalize() {
		double length = Math.sqrt(X*X + Y*Y);
		
		if(length != 0.0) {
			float s = 1.0F / (float)length;
			X *= s;
			Y *= s;
		}
		
		return this;
	}
	
	
	/** Returns this vector as a negative vector. For example...
	 * 
	 * Vector2D vec1 = new Vector2D(3,5);
	 * System.out.println(vec1.toString());
	 * 
	 * ^ That will print out, "Vector2D: (3,5)"
	 * 
	 * However, if you do this...
	 * 
	 * System.out.println(vec1.negative().toString());
	 *   
	 * You will get the negative of the vector, and it will print
	 * out, "Vector2D: (-3,-5)"
	 *   
	 * @return This vector, but as a negative.
	 */
	public Vector2D negative() {
		return new Vector2D(-X,-Y);
	}
	
	
	/** Returns the unit vector "i," which is just a vector with a magnitude of 1. This is the
	 * unit vector on the x-axis. 
	 * 
	 * @return A vector of magnitude "1" in the X direction. */
	public Vector2D UnitX() {
		return new Vector2D(1,0);
	}
	
	
	/** Returns the unit vector "j," which is just a vector with a magnitude of 1. This is the
	 * unit vector on the y-axis. 
	 * 
	 * @return A vector of magnitude "1" in the Y direction. */
	public Vector2D UnitY() {
		return new Vector2D(0,1);
	}
	
	
	/** Checks if this vector is mathematically equal to another vector. 
	 * 
	 * @param vec -- The vector to be compared to.
	 * @return True, if the vectors are mathematically equal to each other, and False if they are not. */
	public boolean equals(Vector2D vec) {
		return (this.X == vec.X && this.Y == vec.Y);
	}
	
	/** Checks if this vector is mathematically equal to another vector by each component. 
	 * 
	 * @param x -- The x coordinate of the vector.
	 * @param y -- The y coordinate of the vector.
	 * @return True, if the vectors are mathematically equal to each other, and False if they are not. */
	public boolean equals(float x, float y) {
		return (this.X == x && this.Y == y);
	}
	
	
	/**  Returns a string of the vector that displays...
	 * "Vector2D: (x,y)"
	 * @return The coordinates of the vector as a string.
	 */
	public String toString() {
		return "Vector2D: (" + this.X + "," + this.Y + ")";
	}
}
