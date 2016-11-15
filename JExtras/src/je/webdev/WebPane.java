package je.webdev;

import java.io.File;

import javax.swing.JEditorPane;

import je.files.ReadFile;

public class WebPane extends JEditorPane {
private static final long serialVersionUID = 6776224215885167191L;


	// The part that is the html.
	private String html = "";
	
	// The part that is the css styling.
	private String css = "";
	
	// The part that is the javascript.
	private String javascript = "";



	
	
	/////////// Constructor ///////////

	/** Creates a new WebPane where html, css, and javascript can be dispalyed. The files for each part must be
	 * specified elsewhere. */
	public WebPane() { setEditable(false); }


	
	
	
	
	/////////// Setters ///////////
	
	/** Sets the file that contains the html that should be displayed.
	 * @param htmlFile -- The html file. */
	public void setHtml(File htmlFile) {
		ReadFile reader = new ReadFile(htmlFile.getAbsolutePath());
		
		// Read from the html file
		String contents = "";
		try {
			contents = reader.read();
		} catch(Exception err) {
			err.printStackTrace();
		}
		
		// Set the instance variable
		this.html = contents;
	}
	
	
	
	/** Sets the file that contains the css styles for the html page.
	 * @param cssFile -- The css file. */
	public void setCSS(File cssFile) {
		ReadFile reader = new ReadFile(cssFile.getAbsolutePath());
		
		// Read from the html file
		String contents = "";
		try {
			contents = reader.read();
		} catch(Exception err) {
			err.printStackTrace();
		}
		
		// Set the instance variable
		this.css = contents;
	}
	
	
	
	/** Sets the file that contains the javascript.
	 * @param jsFile -- The javascript file. */
	public void setJavascript(File jsFile) {
		ReadFile reader = new ReadFile(jsFile.getAbsolutePath());
		
		// Read from the html file
		String contents = "";
		try {
			contents = reader.read();
		} catch(Exception err) {
			err.printStackTrace();
		}
		
		// Set the instance variable
		this.javascript = contents;
	}



	public void display() {
		// The text of the html, css, and js.
		String totalText = css + javascript + html;
		
		// Set the content type to html, and set the text to the text of everything.
		setContentType("text/html");
		setText(totalText);
	}
}
