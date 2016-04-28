# JExtras
A Java library that contains resources that can be used to easily implement extra features into one's Java program. 

- Year: 2016
- Language: Java
- Programmer: Adeola Uthman

# History
- JExtras was a project I started to solve problems that I often came across while programming. Each "Extra" was created because the task that it performs is something that I can use for many different project, without having to rewrite the code multiple times. It was much more efficient to write them once and reuse them. The reason it is called "JExtras" is because the problems that it solves do not necessarily have anything to do with one another. They are sort of random, but contain solutions to problems that any one person may come across while programming such as loading and saving objects, converting 1-dimensional arrays to 2-dimensional arrays, or drawing objects on screen using vectors, etc.
- I plan on adding more and more "Extras" in the future. Anytime I come across a problem that I feel can be solved in a simpler way, I will typically create a class that performs that task and add it to JExtras.

# ArrayConversion
- A class with methods that are responsible for turning one dimensional arrays into two dimensional arrays. One must indicate which one dimensional array he/she wants to convert, and at which index to break it up by.

# Load
- Used for loading serialized objects. It returns the loaded object, so one must simply state which object the newly loaded object should be stored in and must cast it to the appropriate type of object.

# ReadFile
- Reads a file and returns the contents of that file as a string. That string can then be used and manipulated elsewhere in one's program. This class also contains methods for turning a string into an array of different types from a separator (similar to String's "split" method).

# Save
- Used for saving objects. A Non-Serializable error will be thrown if the object you are trying to save does not implement Serializable.

# TextStyle
- Used for adding different styles to JTextPanes. Using either a specified font, color, or key, the user can add different styles to the text pane. When using a key, the text MUST be written exactly as it is in the source code ("BOLD" for bold, "ITALIC" for italics, "UNDERLINE" for underlining, and "STRIKETHROUGH" for a strike through). TextStyle is also serializable, so one can save a particular font style and load it later on.

# TransitionManager
- A class that is capable of handling transitions for one's Java program. Simply create a new TransitionManager object, set the type of transition, and then use the BeginTransition method.

# Vector2D
- A class that represents an object's position on the screen using vector mathematics. Also, it is important to note that the "D" does not stand for double; the class uses floating point values. It simply means that this class is used for two dimensional entities, as opposed to 3D.
