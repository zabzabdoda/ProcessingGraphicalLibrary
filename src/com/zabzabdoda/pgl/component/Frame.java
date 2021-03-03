package com.zabzabdoda.pgl.component;
import java.awt.Dimension;
import java.util.HashSet;
import java.util.LinkedList;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Frame extends PApplet{
	
	private LinkedList<Component> components;
	private JFrame swingFrame;
	private boolean startDraw;
	
	public Frame(String title, int x, int y, int closeOperation) {
		PApplet.runSketch(new String[] { "" }, this);
		PSurfaceAWT surf = (PSurfaceAWT) this.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		swingFrame = (JFrame) canvas.getFrame();
		swingFrame.setSize(x, y);
		swingFrame.setTitle(title);
		swingFrame.setMinimumSize(new Dimension(100, 100));
		swingFrame.setDefaultCloseOperation(closeOperation);
		swingFrame.setResizable(true);
		components = new LinkedList<Component>();
	}
	
	public void add(Component comp) {
		if(comp instanceof Panel) {
			components.add(0,comp);
		}else {
			components.add(comp);
		}
		comp.setPApplet(this);
	}
	
	public void remove(Component comp) {
		components.remove(comp);
		comp.setPApplet(null);
	}
	
	public void startDraw(boolean draw) {
		startDraw = draw;
	}
	
	public void draw() {
		if(startDraw) {
			background(200);
			for(Component c : components) {
				c.draw();
			}
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

	public void dispose() {
		swingFrame.dispose();
		this.exit();
	}
	
	
}
