package com.zabzabdoda.pgl.component;
import java.awt.Dimension;
import java.util.HashSet;
import java.util.LinkedList;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

/*
 * TODO:
 * 	- Add toggle button
 * 	- Add textbox
 *  - Add combobox
 *  - Add listbox
 *  - Add progressbar
 *  - Add spinner
 *  - Add slider
 */

/**
 * Main window for the library creates a new 
 * JFrame with a Processing window embedded in it
 * 
 * @author zabzabdoda
 *
 */
public class Frame extends PApplet{
	
	private LinkedList<Component> components;
	private LinkedList<MouseListener> mouseListeners;
	private JFrame swingFrame;
	private boolean startDraw;
	
	/**
	 * Creates a new Frame that will display when the start
	 * draw is called
	 * 
	 * Close Operation takes in a JFrame constant
	 * 	- DISPOSE_ON_CLOSE
	 * 	- DO_NOTHING_ON_CLOSE
	 * 	- EXIT_ON_CLOSE
	 * 	- HIDE_ON_CLOSE
	 * 
	 * @param title The name of the window
	 * @param width the width of the window
	 * @param height the height of the window
	 * @param closeOperation Determines what operation to perform when the user clicks the x button on the window
	 */
	public Frame(String title, int width, int height, int closeOperation) {
		PApplet.runSketch(new String[] { "" }, this);
		PSurfaceAWT surf = (PSurfaceAWT) this.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		swingFrame = (JFrame) canvas.getFrame();
		swingFrame.setSize(width, height);
		swingFrame.setTitle(title);
		swingFrame.setMinimumSize(new Dimension(100, 100));
		swingFrame.setDefaultCloseOperation(closeOperation);
		swingFrame.setResizable(true);
		components = new LinkedList<Component>();
		mouseListeners = new LinkedList<MouseListener>();
	}
	
	/**
	 * Adds a component to the frame to draw 
	 * 
	 * @param comp the component to add to the frame
	 */
	public void add(Component comp) {
		components.add(comp);
		comp.setPApplet(this);
	}
	
	/**
	 * removes the component from the frame
	 * 
	 * @param comp the component to remove
	 */
	public void remove(Component comp) {
		components.remove(comp);
		comp.setPApplet(null);
	}
	
	/**
	 * lets the window draw all of the components
	 * 
	 * @param draw Whether the window should draw or not
	 */
	public void startDraw(boolean draw) {
		startDraw = draw;
	}
	
	
	/**
	 * draws all the components if startDraw is true
	 * 
	 */
	public void draw() {
		if(startDraw) {
			background(200);
			for(Component c : components) {
				c.draw();
			}
		}
	}
	
	/**
	 * gets called when the mouse is moved, passes it
	 * on to each of the components
	 */
	@Override
	public void mouseMoved() {
		for(Component c : components) {
			((MouseListener)c).mouseMoved();

		}
	}
	
	/**
	 * gets when the mouse is pressed and passes it
	 * to each of the components
	 */
	@Override
	public void mousePressed() {
		for(Component c : components) {
			((MouseListener)c).mousePressed();

		}
	}
	
	/**
	 * gets when the mouse is released and is passed
	 * to the components
	 */
	@Override
	public void mouseReleased() {
		for(Component c : components) {
			if(c instanceof MouseListener) {
				((MouseListener)c).mouseReleased();
			}
		}
	}

	/**
	 * Closes the window and exits the processing process
	 */
	public void dispose() {
		swingFrame.dispose();
		this.exit();
	}
	
	
}
