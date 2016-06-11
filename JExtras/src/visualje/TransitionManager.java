package visualje;
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
