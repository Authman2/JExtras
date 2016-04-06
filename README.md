# JExtras
A Java library that contains resources that can be used to easily implement extra features into one's Java program. 

- Year: 2016
- Language: Java
- Programmer: Adeola Uthman


# ArrayConversion
- A class with methods that are responsible for turning one dimensional arrays into two dimensional arrays. One must indicate which one dimensional array he/she wants to convert, and at which index to break it up by.

# Load
- Used for loading serialized objects. It returns the loaded object, so one must simply state which object the newly loaded object should be stored in and must cast it to the appropriate type of object.

# ReadFile
- Reads a file and returns the contents of that file as a string. That string can then be used and manipulated elsewhere in one's program. This class also contains methods for turning a string into an array of different types from a separator (similar to String's "split" method).

# Save
- Used for saving objects. A Non-Serializable error will be thrown if the object you are trying to save does not implement Serializable.

# TransitionManager
- A class that is capable of handling transitions for one's Java program. Simply create a new TransitionManager object, set the type of transition, and then use the BeginTransition method.

# Vector2D
- A class that represents an object's position on the screen using vector mathematics. Also, it is important to note that the "D" does not stand for double; the class uses floating point values. It simply means that this class is used for two dimensional entities, as opposed to 3D.
