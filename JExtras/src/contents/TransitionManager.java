package contents;
import java.awt.Color;
import java.awt.Graphics2D;

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
 * This class is responsible for handling transitions easily. All you must do is create a new TransitionManager object,
 * then, before doing any actual actions with it, you must define the type of transition using the "SetTransition" 
 * method. After that, you must update and draw the TransitionManager.
 * */
public class TransitionManager {

	private Transition transition;
	private boolean startFading;
	private float alpha;
	private double rateOfChange;
	
	public TransitionManager() {}
	
	/** Sets the type of transition to perform as well as the amount to transition by. 
	 * @param t -- The type of transition to perform.
	 * @param rateOfChange -- The amount by which to change the drawings on the screen.
	 */
	public void SetTransition(Transition t, double rateOfChange) { this.transition = t; this.rateOfChange = rateOfChange; initialize(); }
	
	/** Returns the current type of transition that this TransitionManager is set to perform. 
	 * @return transition -- the transition that is currently set to be performed. */
	public Transition getTransition() { return transition; }
	
	/** Boolean for whether or not this TransitionManager's transition type has been set. Mostly for error checking purposes.
	 * @return returns whether or not the transition has already been set. */
	public boolean transitionSet() { return transition != null; }
	
	/** Tells the TransitionManager to start performing the transition.. */
	public void BeginTransition() { startFading = true; }
	
	/** Returns whether or not the TransitionManager is done with the current transition. 
	 * @return returns whether or not the transition has finished playing. */
	public boolean Finished() { 
		if(transition == Transition.Fade_In) return alpha <= 0;
		else return alpha >= 1;
	}
	
	
	
	public void initialize() {
		if(transition == Transition.Fade_In) { alpha = 1; }
		if(transition == Transition.Fade_Out) { alpha = 0; }
	}
	
	public void update(double time) {
		if(startFading && Finished() == false) {
			//FADING IN
			if(transition == Transition.Fade_In) {
				//Lower the alpha value.
				alpha -= rateOfChange;
			}
			//FADING OUT
			if(transition == Transition.Fade_Out) {
				//Raise the alpha value.
				alpha += rateOfChange; 
			}
		}
	}
	
	public void draw(Graphics2D g) {
		if(startFading && Finished() == false) {
			g.setColor(new Color(0,0,0,alpha));
			g.fillRect(0, 0, 640, 470);
		}
	}

	
	
	
	
	/** The type of transition to perform. With this, you can quickly and easily add new transition types,
	 * and then you can define what they should look like above in the draw and update methods. */
	public enum Transition {
		Fade_Out, Fade_In, ScreenWipe_Up, ScreenWipe_Down, ScreenWipe_Left, ScreenWipe_Right;
	}

}
