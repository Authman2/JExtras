package contents;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//Not an actually drawn state, just used for saving data.
public class Save {

	public Save() {}

	/** Saves a file to the specified path. */
	public void SaveFile(Object t, String savename) {
		try {
			FileOutputStream fileOut = new FileOutputStream(savename);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(t);
			out.close();
			fileOut.close();
			System.out.println("Saved!");
		} catch(IOException i) {
			i.printStackTrace();
		}
	}
	
}
