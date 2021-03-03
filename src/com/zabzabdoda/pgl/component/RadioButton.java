package com.zabzabdoda.pgl.component;

import processing.core.PApplet;

public class RadioButton extends ToggleButton{

	
	
	public RadioButton(String name, int x, int y, int width, int height) {
		super(x, y, width, height, name);
	}

	@Override
	public void draw() {
		p.pushStyle();
		p.noFill();
		p.ellipseMode(PApplet.CENTER);
		p.circle(x, y+height/2, 10);
		if(isOn) {
			p.fill(0);
			p.circle(x, y+height/2, 10);
		}
		p.fill(0);
		p.textSize(height-6);
		p.textAlign(PApplet.LEFT,PApplet.UP);
		p.text(text, x+height, y,width,height);
		p.noFill();
		//p.rect(x+height, y, width, height);
		p.popStyle();
	}

	public void setToggle(boolean tog) {
		isOn = tog;
	}
	
	@Override
	public void mouseMoved() {
		
	}

	@Override
	public void mousePressed() {
	}

	@Override
	public void mouseReleased() {
		
	}

	
	
}
