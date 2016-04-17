package contents;


import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

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


/** Used for adding different styles to a JTextPane. Available styles are Bold, Italic, Underline, and Strikethrough. */
public class TextStyle implements Serializable {
	private static final long serialVersionUID = 5226747964476281976L;

	
	
	//The index to start the style and the length for how long it should go on until.
	int startPosition, length;
	
	//The particular key for which style to add
	String key;
	
	//The JTextComponent to add style to
	transient JTextPane textspace;

	//The color to set the text to
	Color textcolor = Color.black;
	
	//The font
	Font font;
	
	
	/** Default Constructor */
	public TextStyle() {}
	
	
	
	/** Creates a new Text Style.
	 * 
	 * @param t -- The JTextPane to have the style added to.
	 * @param start -- The index of the text in the text pane to start adding the style at.
	 * @param length -- The length of text to add the style on.
	 * @param key -- The specific key used for adding particular styles. "BOLD" is used for bold styling, "ITALIC" is used
	 * for italics, "UNDERLINE" is used for underlining, and "STRIKETHROUGH" is used for adding a strike through.
	 */
	public TextStyle(JTextPane t, int start, int length, String styleKey) {
		this.textspace = t;
		this.startPosition = start;
		this.length = length;
		key = styleKey;
	}
	
	
	
	/** Creates a new Text Style.
	 * 
	 * @param t -- The JTextPane to have the style added to.
	 * @param start -- The index of the text in the text pane to start adding the style at.
	 * @param length -- The length of text to add the style on.
	 */
	public TextStyle(JTextPane t, int start, int length) {
		this.textspace = t;
		this.startPosition = start;
		this.length = length;
	}

	
	
	
	/** Sets the text pane to have the styles set on. 
	 * @param jtp -- The JTextPane to have the style added to.*/
	public void setTextPane(JTextPane jtp) { 
		textspace = jtp; 
	}
	
	
	
	/** Set teh color of the text. 
	 * @param c -- The color you want the text to appear. */
	public void setTextColor(Color c) { 
		textcolor = c; 
	}
	
	
	/** Sets the font of the text.
	 * @param f - The font to set. */
	public void setFont(Font f) {
		font = f;
	}
	
	
	/** Returns the text font.
	 * @return the text font. */
	public Font getFont() {
		return font;
	}
	
	
	/** Returns the color of the text.
	 * @return the color of the text. */
	public Color getTextColor() {
		return textcolor;
	}
	
	
	/** Returns the starting index of where the style should be added. 
	 * @return the starting position of the particular style. */
	public int getStartPosition() {
		return startPosition;
	}
	
	
	/** Returns the length of the text styling. 
	 * @return the length of text to have the styl added to. */
	public int getLength() { 
		return length; 
	}
	
	
	/** Returns the special key used for setting the style. 
	 * @return the special key used for adding particular styles. */
	public String getKey() { 
		return key;
	}
	
	
	/** Adds the text color to the text pane. */
	public TextStyle addColorStyle() {
		 //Style for coloring
		 Style style = textspace.addStyle("Coloring", null);
	     StyleConstants.setForeground(style, textcolor);
		 textspace.getStyledDocument().setCharacterAttributes(startPosition, length, style, false);
		 
		return this;
	}
	
	
	/** Adds a specific font to the text pane. */
	public void addFontStyle() {
		SimpleAttributeSet sas = new SimpleAttributeSet();
		StyleConstants.setFontFamily(sas, font.getFamily());
		StyleConstants.setFontSize(sas, font.getSize());
		textspace.getStyledDocument().setCharacterAttributes(startPosition, length, sas, false);
	}
	
	
	/** Adds the style to the text pane. 
	 * @return this TextStyle object. */
	public TextStyle addStyle() {
		//Bold
		if(key.equals("BOLD")) {
			SimpleAttributeSet sas = new SimpleAttributeSet();
			StyleConstants.setBold(sas, !StyleConstants.isBold(sas));
			textspace.getStyledDocument().setCharacterAttributes(startPosition, length, sas, false);
			return this;
		}
		
		//Italic
		if(key.equals("ITALIC")) {
			SimpleAttributeSet sas = new SimpleAttributeSet();
			StyleConstants.setItalic(sas, !StyleConstants.isItalic(sas));
			textspace.getStyledDocument().setCharacterAttributes(startPosition, length, sas, false);
			return this;
		}
		
		//Underline
		if(key.equals("UNDERLINE")) {
			SimpleAttributeSet sas = new SimpleAttributeSet();
			StyleConstants.setUnderline(sas, !StyleConstants.isUnderline(sas));
			textspace.getStyledDocument().setCharacterAttributes(startPosition, length, sas, false);
			return this;
		}
		
		//Strikethrough
		if(key.equals("STRIKETHROUGH")) {
			SimpleAttributeSet sas = new SimpleAttributeSet();
			StyleConstants.setStrikeThrough(sas, !StyleConstants.isStrikeThrough(sas));
			textspace.getStyledDocument().setCharacterAttributes(startPosition, length, sas, false);
			return this;
		}
		
		
		
		return null;
	}
	
	/** Adds the style to the text pane. 
	 * @param t -- The JTextPane to have the style added to.
	 * @param start -- The index of the text in the text pane to start adding the style at.
	 * @param length -- The length of text to add the style on.
	 * @param key -- The specific key used for adding particular styles. "BOLD" is used for bold styling, "ITALIC" is used
	 * for italics, "UNDERLINE" is used for underlining, and "STRIKETHROUGH" is used for adding a strike through.
	 * @return this TextStyle object. */
	public TextStyle addStyle(JTextPane t, int start, int length, String styleKey) {
		//Bold
		if(styleKey.equals("BOLD")) {
			SimpleAttributeSet sas = new SimpleAttributeSet();
			StyleConstants.setBold(sas, !StyleConstants.isBold(sas));
			t.getStyledDocument().setCharacterAttributes(start, length, sas, false);
			return this;
		}
		
		//Italic
		if(styleKey.equals("ITALIC")) {
			SimpleAttributeSet sas = new SimpleAttributeSet();
			StyleConstants.setItalic(sas, !StyleConstants.isItalic(sas));
			t.getStyledDocument().setCharacterAttributes(start, length, sas, false);
			return this;
		}
		
		//Underline
		if(styleKey.equals("UNDERLINE")) {
			SimpleAttributeSet sas = new SimpleAttributeSet();
			StyleConstants.setUnderline(sas, !StyleConstants.isUnderline(sas));
			t.getStyledDocument().setCharacterAttributes(start, length, sas, false);
			return this;
		}
		
		//Strikethrough
		if(styleKey.equals("STRIKETHROUGH")) {
			SimpleAttributeSet sas = new SimpleAttributeSet();
			StyleConstants.setStrikeThrough(sas, !StyleConstants.isStrikeThrough(sas));
			t.getStyledDocument().setCharacterAttributes(start, length, sas, false);
			return this;
		}
		
		
		return null;
	}
	
}
