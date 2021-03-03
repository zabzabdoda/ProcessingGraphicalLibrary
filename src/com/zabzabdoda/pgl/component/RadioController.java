package com.zabzabdoda.pgl.component;

import java.util.ArrayList;

import processing.core.PApplet;

public class RadioController extends Component{
	
	private ArrayList<RadioButton> radioButtons;
	private RadioButton selected;
	
	public RadioController() {
		super(0,0,0,0);
		radioButtons = new ArrayList<RadioButton>();
	}
	
	public void add(RadioButton radioButton) {
		radioButtons.add(radioButton);
	}
	
	public void remove(RadioButton radioButton) {
		radioButtons.remove(radioButton);
	}
	
	public void setDefault(RadioButton def) {
		setSelected(def);
	}
	
	public RadioButton getSelected() {
		return selected;
	}
	
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

	@Override
	public void mousePressed() {
		for(RadioButton rb : radioButtons) {
			//System.out.println(rb.getX()+", "+rb.getY());
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
