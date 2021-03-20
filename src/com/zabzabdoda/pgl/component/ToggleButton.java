package com.zabzabdoda.pgl.component;

import java.awt.Color;

import processing.core.PApplet;

public class ToggleButton extends Button{

	protected boolean isOn;
	
	public ToggleButton(int x, int y, int width, int height, String text) {
		super(x, y, width, height, text);
		isOn = false;
	}
	
	@Override
	protected void draw() {
		if(p != null) {
			p.pushStyle();
			p.noStroke();
			p.textAlign(PApplet.CENTER,PApplet.CENTER);
			if(isOn) {
				p.fill(122, 138, 153);
				p.rect(x,y,width,height);
				p.fill(181, 206, 228);
				p.rect(x+2,y+2,width-4,height-4);
				p.fill(Color.BLACK.getRGB());
				p.text(text, x, y,width,height);
			}else {
				if(isHovered) {
					p.fill(122, 138, 153);
					p.rect(x, y, width, height);
					setGradient(x+2,y+2,width-5,height-5,new Color(255,255,255),new Color(190, 211, 231));
					p.fill(Color.BLACK.getRGB());
					p.text(text, x, y,width,height);
				}else {
					p.fill(122, 138, 153);
					p.rect(x, y, width, height);
					setGradient(x+1,y+1,width-3,height-3,new Color(255,255,255),new Color(190, 211, 231));
					p.fill(Color.BLACK.getRGB());
					p.text(text, x, y,width,height);
				}
			}
			p.popStyle();
		}
	}
	
	public boolean getState() {
		return isOn;
	}
	
	public void mousePressed() {
		if(detectCollision(p.mouseX,p.mouseY)) {
			isOn = !isOn;
			click();
		}
	}
	
}
