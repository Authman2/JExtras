package je.visual;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * This class is responsible for handling transitions easily. All you must do is create a new TransitionManager object,
 * then, before doing any actual actions with it, you must define the type of transition using the "SetTransition" 
 * method. After that, you must update and draw the TransitionManager.
 
Copyright (C) 2016  Adeola Uthman

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.


@author Adeola Uthman
@version 1.0
*/
public class TransitionManager {
	
	///////////////////////
	//
	//	Variables
	//
	///////////////////////
	
	private Transition transition;
	private boolean started;
	private float alpha;
	private float rateOfChange;
	private int width, height, startx, starty, endx, endy;
	private Completion complete;
	
	
	///////////////////////
	//
	//	Constructor
	//
	///////////////////////
	
	public TransitionManager(int w, int h) { width = w; height = h; }
	
	
	
	
	///////////////////////
	//
	//	Setters
	//
	///////////////////////
	
	/** Sets the type of transition to perform as well as the amount to transition by. 
	 * @param t -- The type of transition to perform.
	 * @param rateOfChange -- The amount by which to change the drawings on the screen.
	 */
	public void setTransition(Transition t, float rateOfChange) { this.transition = t; this.rateOfChange = rateOfChange; initialize(); }
	
	
	/** Initializes certain variables after the the transition has been set. */
	private void initialize() {
		started = false;
		
		switch(transition) {
			case Fade_In:
				alpha = 1; // Starts dark, becomes lighter over time.
				break;
			case Fade_Out:
				alpha = 0; // Starts light, becomes darker over time.
				break;
			case ScreenWipe_Up:
				alpha = 1; // For all swipes, it remains dark the whole way through.
				startx = 0;
				endx = width;
				starty = height;
				endy = height;
				break;
			case ScreenWipe_Down:
				alpha = 1;
				startx = 0;
				endx = width;
				starty = -height;
				endy = height;
				break;
			case ScreenWipe_Left:
				alpha = 1;
				startx = -width;
				endx = width;
				starty = 0;
				endy = height;
				break;
			case ScreenWipe_Right:
				alpha = 1;
				startx = width;
				endx = width*2;
				starty = 0;
				endy = height;
				break;
			default:
				alpha = 1;
				break;
		}
		
	}
	
	
	/** Starts the transition. 
	 * @param completion -- An interface containing a method that gets called when the transition is finished. */
	public void beginTransition(Completion completion) {
		started = true;
		complete = completion;
	}
	
	
	/** Updates all of the transitions. */
	public void updateTransitions() {
		if( started == true ) {
			if(isFinished()) { if(complete != null) {complete.completion();} started = false; }
			
			switch(transition) {
				case Fade_In:
					fadeIn();
					break;
				case Fade_Out:
					fadeOut();
					break;
				case ScreenWipe_Up:
					swipeUp();
					break;
				case ScreenWipe_Down:
					swipeDown();
					break;
				case ScreenWipe_Left:
					swipeLeft();
					break;
				case ScreenWipe_Right:
					swipeRight();
					break;
				default:
					break;
			}
		}
	}
	
	
	/** Draw the transitions using a graphics object. */
	public void drawTransitions(Graphics2D g) {
		if( started == true ) {
			
			switch(transition) {
				case Fade_In:
					g.setColor(new Color(0,0,0,alpha));
					g.fillRect(0, 0, width, height);
					break;
				case Fade_Out:
					g.setColor(new Color(0,0,0,alpha));
					g.fillRect(0, 0, width, height);
					break;
				case ScreenWipe_Up:
					g.setColor(new Color(0,0,0,alpha));
					g.fillRect(startx, starty, endx, endy);
					break;
				case ScreenWipe_Down:
					g.setColor(new Color(0,0,0,alpha));
					g.fillRect(startx, starty, endx, endy);
					break;
				case ScreenWipe_Left:
					g.setColor(new Color(0,0,0,alpha));
					g.fillRect(startx, starty, endx, endy);
					break;
				case ScreenWipe_Right:
					g.setColor(new Color(0,0,0,alpha));
					g.fillRect(startx, starty, endx, endy);
					break;
				default:
					break;
			}
		}
	}
	
	
	
	/** Performs the fade in animation. */
	private void fadeIn() {
		if(alpha > 0) {
			alpha -= rateOfChange;
			if(alpha < 0) { alpha = 0; }
		}
	}
	
	/** Performs the fade out animation. */
	private void fadeOut() {
		if(alpha < 1) {
			alpha += rateOfChange;
			if(alpha > 1) { alpha = 1; }
		}
	}
	
	/** Performs the swipe up animation. */
	private void swipeUp() {
		starty -= rateOfChange;
	}
	
	/** Performs the swipe down animation. */
	private void swipeDown() {
		starty += rateOfChange;
	}
	
	/** Performs the swipe left animation. */
	private void swipeLeft() {
		startx += rateOfChange;
	}
	
	/** Performs the swipe right animation. */
	private void swipeRight() {
		startx -= rateOfChange;
	}
	
	
	
	public boolean isFinished() {
		boolean finished = false;
		if( started == true ) {
			
			switch(transition) {
				case Fade_In:
					if(alpha <= 0) finished = true;
					break;
				case Fade_Out:
					if(alpha >= 1) finished = true;
					break;
				case ScreenWipe_Up:
					if(starty <= 0) finished = true;
					break;
				case ScreenWipe_Down:
					if(starty >= 0) finished = true;
					break;
				case ScreenWipe_Left:
					if(startx >= 0) finished = true;
					break;
				case ScreenWipe_Right:
					if(startx <= 0) finished = true;
					break;
				default:
					finished = true;
					break;
			}
		}
		return finished;
	}
	
	
	
	
	
	
	/** The type of transition to perform. With this, you can quickly and easily add new transition types,
	 * and then you can define what they should look like above in the draw and update methods. */
	public enum Transition {
		Fade_Out, Fade_In, ScreenWipe_Up, ScreenWipe_Down, ScreenWipe_Left, ScreenWipe_Right;
	}

	/** A completion block interface. */
	public interface Completion {
		public void completion();
	}
}
