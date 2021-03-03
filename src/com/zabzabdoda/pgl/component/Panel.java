package com.zabzabdoda.pgl.component;

import java.util.HashSet;

import processing.core.PApplet;

public class Panel extends Component{
	
	private HashSet<Component> components;
	
	public Panel(int x, int y, int width, int height) {
		super(x,y,width,height);
		components = new HashSet<Component>();
	}
	
	public void add(Component comp) {
		components.add(comp);
		comp.setFrameOffset(x, y);
	}
	
	public void remove(Component comp) {
		components.remove(comp);
		comp.setFrameOffset(0, 0);
	}
	
	@Override
	public void setPApplet(PApplet p) {
		this.p = p;
		for(Component c : components) {
			c.setPApplet(p);
		}
	}
	
	@Override
	public void draw() {
		p.pushStyle();
		p.fill(220);
		p.rect(x, y, width, height);
		p.popStyle();
		for(Component c : components) {
			c.draw();
		}
	}

	@Override
	public void mouseMoved() {
		for(Component c : components) {
			c.mouseMoved();
		}
	}

	@Override
	public void mousePressed() {
		for(Component c : components) {
			c.mousePressed();
		}		
	}

	@Override
	public void mouseReleased() {
		for(Component c : components) {
			c.mouseReleased();
		}
	}
	
}
