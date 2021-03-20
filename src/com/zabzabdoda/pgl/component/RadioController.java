package com.zabzabdoda.pgl.component;

import java.util.ArrayList;

import processing.core.PApplet;

/**
 * Controls the radiobuttons assigned to an object
 * of this class. 
 * 
 * @author zabzabdoda
 *
 */
public class RadioController extends Component implements MouseListener{
	
	private ArrayList<RadioButton> radioButtons;
	private RadioButton selected;
	
	/**
	 * Makes a new radio controller
	 */
	public RadioController() {
		super(0,0,0,0);
		radioButtons = new ArrayList<RadioButton>();
	}
	
	/**
	 * Adds the radio button to this controller
	 * @param radioButton The radio button to add
	 */
	public void add(RadioButton radioButton) {
		radioButtons.add(radioButton);
	}
	
	/**
	 * Removes the specified radio button from this controller
	 * @param radioButton The radio button to remove
	 */
	public void remove(RadioButton radioButton) {
		radioButtons.remove(radioButton);
	}
	
	/**
	 * Sets the radio button that is on by default
	 * @param def The radio button that is on by default
	 */
	public void setDefault(RadioButton def) {
		setSelected(def);
	}
	
	/**
	 * Gets the currently selected radio button
	 * 
	 * @return The radio button that is selected
	 */
	public RadioButton getSelected() {
		return selected;
	}
	
	/**
	 * Sets the radio button that is selected
	 * @param radioButton The radio button that is selected
	 */
	public void setSelected(RadioButton radioButton) {
		selected = radioButton;
		radioButton.setToggle(true);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Gets called when one of the radio buttons are pressed
	 */
	@Override
	public void mousePressed() {
		for(RadioButton rb : radioButtons) {
			if(rb.detectCollision(p.mouseX, p.mouseY)) {
				for(RadioButton b : radioButtons) {
					b.setToggle(false);
				}
				setSelected(rb);
			}
		}
	}

	@Override
	public void mouseReleased() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
