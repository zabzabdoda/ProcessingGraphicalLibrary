package com.zabzabdoda.pgl.component;

import java.awt.Point;

import processing.core.PApplet;

public abstract class Component {
	
	protected int x,y,width,height;
	protected int xOffset,yOffset;
	protected PApplet p;

	public Component(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void draw();
	public abstract void mouseMoved();
	public abstract void mousePressed();
	public abstract void mouseReleased();
	
	public void setPApplet(PApplet p) {
		this.p = p;
	}
	
	public void setFrameOffset(int x, int y) {
		this.xOffset = x;
		this.yOffset = y;
		this.x += xOffset;
		this.y += yOffset;
	}
	
	public Point getFrameOffset() {
		return new Point(xOffset,yOffset);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
