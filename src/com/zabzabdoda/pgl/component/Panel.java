package com.zabzabdoda.pgl.component;

import java.util.HashSet;

import processing.core.PApplet;

/**
 * Represents an area where components can be
 * stored and drawn with its own relative coordinate
 * system
 * 
 * @author zabzabdoda
 *
 */
public class Panel extends Component implements MouseListener{
	
	private HashSet<Component> components;
	
	/**
	 * Constructs a new panel at a certain position
	 * 
	 * @param x The x value of the panel
	 * @param y The y value of the panel
	 * @param width The width of the panel
	 * @param height The height of the panel
	 */
	public Panel(int x, int y, int width, int height) {
		super(x,y,width,height);
		components = new HashSet<Component>();
	}
	
	/**
	 * Adds a component to the panel and
	 * sets its relative positioning to the
	 * x,y values of the panel
	 * 
	 * @param comp The component to add
	 */
	public void add(Component comp) {
		components.add(comp);
		comp.addFrameOffset(x, y);
	}
	
	/**
	 * Removes the component from the panel
	 * and resets its offset to the main frame
	 * 
	 * @param comp The component to remove
	 */
	public void remove(Component comp) {
		components.remove(comp);
		comp.addFrameOffset(0, 0);
	}
	
	/**
	 * Sets the surface that all the components
	 * are drawn on
	 * 
	 * @param p PApplet object of main window
	 */
	@Override
	public void setPApplet(PApplet p) {
		this.p = p;
		for(Component c : components) {
			c.setPApplet(p);
		}
	}
	
	/**
	 * draws the panel and all of its components
	 * to the main window
	 * 
	 */
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

	/**
	 * calls all component mousemoved methods
	 */
	@Override
	public void mouseMoved() {
		for(Component c : components) {
			if(c instanceof MouseListener) {
				((MouseListener)c).mouseMoved();
			}
		}
	}

	/**
	 * calls all component mousemoved methods
	 */
	@Override
	public void mousePressed() {
		for(Component c : components) {
			if(c instanceof MouseListener) {
				((MouseListener)c).mousePressed();
			}			
		}
	}

	/**
	 * calls all component mousemoved methods
	 */
	@Override
	public void mouseReleased() {
		for(Component c : components) {
			if(c instanceof MouseListener) {
				((MouseListener)c).mouseReleased();
			}
		}
	}
	
}
