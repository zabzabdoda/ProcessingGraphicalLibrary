package com.zabzabdoda.pgl.component;

import java.awt.Point;

import processing.core.PApplet;

/**
 * Represents a graphical widget that can be
 * drawn on the screen. Classes such as button
 * and label extend this class
 * 
 * @author zabzabdoda
 *
 */
public abstract class Component {
	
	protected int x,y,width,height;
	protected int xOffset,yOffset;
	protected PApplet p;

	
	/**
	 * Creates an instance of a Component which has elements that
	 * are necessary to be drawn on the screen
	 * 
	 * @param x The x position of the component
	 * @param y The y position of the component
	 * @param width The width of the component
	 * @param height The height of the component
	 */
	public Component(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Draws the component to the screen
	 */
	protected abstract void draw();
	
	/**
	 * Sets the drawing surface that the 
	 * component gets drawn on
	 * 
	 * @param p The PApplet object that the frame you are drawing on gets initialized to
	 */
	protected void setPApplet(PApplet p) {
		this.p = p;
	}
	
	/**
	 * Sets the offset needed to position the component to fit within a sub-frame
	 * 
	 * @param x The x amount to offset by
	 * @param y The y amount to offset by
	 */
	protected void addFrameOffset(int x, int y) {
		this.xOffset += x;
		this.yOffset += y;
		this.x += xOffset;
		this.y += yOffset;
	}
	
	/**
	 * Gets the amount that the component is offset by
	 * 
	 * @return A point object that holds the x and y values for the offset of the current frame that this component is a part of
	 */
	protected Point getFrameOffset() {
		return new Point(xOffset,yOffset);
	}
	
	/**
	 * Gets the x value of this component
	 * 
	 * @return the x value of the component
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x value of this component
	 * 
	 * @param x The new x value that the component will be at
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y value of this component
	 * 
	 * @return The x value of the component
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y value of this component
	 * 
	 * @param y The new y value that the component will be at
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the current width of the component
	 * 
	 * @return The width of the component
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width of the component
	 * 
	 * @param width The new width the component will be 
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets the current height of the component
	 * 
	 * @return the height of the component
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height of the component
	 * 
	 * @param height The new height the component will be 
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
}
