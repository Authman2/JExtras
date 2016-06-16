# JExtras
A Java library that contains resources that can be used to easily implement extra features into one's Java program. 

- Year: 2016
- Language: Java
- Programmer: Adeola Uthman

# History
- JExtras was a project I started to solve problems that I often came across while programming. Each "Extra" was created because the task that it performs is something that I thought I could used for many different projects, without having to rewrite the code multiple times. It was much more efficient to write them once and reuse them later on with this sort of "Everything Library". The reason it is called "JExtras" is because the problems that it solves do not necessarily have anything to do with one another; they are just "extra" things that one can implement into his/her java program. The "J" simply stands for Java, the language the library was written in and for. The contents of the library are mostly independent of one another, but contain solutions to problems that any one person may come across while programming, such as loading and saving objects, converting 1-dimensional arrays to 2-dimensional arrays, drawing objects on a JFrame using vectors, and many others.
- I plan on adding more and more "Extras" in the future. Anytime I come across a problem that I feel can be solved in a simpler way, I will typically create a class that performs that task and add it to JExtras.

# Collectionsje
- **ArrayConversion**: A class with methods that are responsible for turning one dimensional arrays into two dimensional arrays. One must indicate which one dimensional array he/she wants to convert, and at which index to break it up by.
- **Tuple**: A generic class that keeps track of a value, X, another value, Y, and a key, K, that can be used to find a particular tuple object later on. When first created, this object was used for storing x and y coordinate points. However, the X and Y values could really be used for anything.
- **TupleList**: A list of Tuple objects (see above). It functions the same way an ArrayList does, so it should be used as such. A method like get(index), for example, will return a Tuple object, which one can then use as a regular tuple.

# Filesje
- **Load**: Used for loading serialized objects. It returns the loaded object, so one must simply state which object the newly loaded object should be stored in and must cast it to the appropriate type of object.
- **ReadFile**: Reads a file and returns the contents of that file as a string. That string can then be used and manipulated elsewhere in one's program. This class also contains methods for turning a string into an array of different types from a separator (similar to String's "split" method).
- **Save**: Used for saving objects. A Non-Serializable error will be thrown if the object you are trying to save does not implement Serializable.

# Otherje
- **EdgeDetector**: A standard edge detector that can be used for any type of program that requires edge detection. To use it, one must first specify the image that he/she would like to find edges in. Then, the "detect" or "Detect" methods can be used by specifying through parameters whether or not it should create a JFrame to display the image and the amount of difference to look for in the image. The lower-case detect method returns a TupleList (see above) containing all of the coordinate points of where the edges were found. The capital detect method returns a BufferedImage with a white background and black dots on all of the edges.

# Visualje
- **JEImage**: A class used for image processing. I felt that creating a BufferedImage this way was very simple, and allowed me to use it in more ways than I could with just the BufferedImage class alone.
- **TextStyle**: Used for adding different styles to JTextPanes. Using either a specified font, color, or key, the user can add different styles to the text pane. When using a key, the text MUST be written exactly as it is in the source code ("BOLD" for bold, "ITALIC" for italics, "UNDERLINE" for underlining, and "STRIKETHROUGH" for a strike through). TextStyle is also serializable, so one can save a particular font style and load it later on.
- **TransitionManager**: A class that is capable of handling transitions for one's Java program. Simply create a new TransitionManager object, set the type of transition, and then use the BeginTransition method.
- **Vector2D**: A class that represents an object's position on the screen using vector mathematics. Also, it is important to note that the "D" does not stand for double; the class uses floating point values. It simply means that this class is used for two dimensional entities, as opposed to 3D.
