package com.zabzabdoda.pgl.component;

import java.util.HashSet;

import processing.core.PApplet;

public class Frame extends Component{
	
	private PApplet p;
	private HashSet<Component> components;
	
	public Frame(int x, int y, int width, int height, PApplet p) {
		super(x,y,width,height);
		this.p = p;
		components = new HashSet<Component>();
	}
	
	public void add(Component comp) {
		components.add(comp);
	}
	
	public void remove(Component comp) {
		components.remove(comp);
	}
	
	@Override
	public void draw() {
		p.pushMatrix();
		p.pushStyle();
		p.fill(220);
		p.translate(x, y);
		p.rect(0, 0, width, height);
		p.popStyle();
		for(Component c : components) {
			c.draw();
		}

		p.popMatrix();
	}
	
}
