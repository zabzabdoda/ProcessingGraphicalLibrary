package com.zabzabdoda.pgl.component;

import java.awt.Color;

import processing.core.PApplet;

/**
 * Represents a rectangular button that can
 * accept a listener to run code when the button
 * is pressed.
 * 
 * @author zabzabdoda
 *
 */
public class Button extends Component implements MouseListener{
	
	protected String text;
	protected boolean isHovered;
	private boolean isPressed;
	private ButtonListener buttonListener;

	/**
	 * Constructs a new rectangular button 
	 * 
	 * @param x the x position on the window
	 * @param y the y position on the window
	 * @param width the width of the button
	 * @param height the height of the button
	 * @param text the text displayed on the button
	 */
	public Button(int x, int y, int width, int height, String text) {
		super(x,y,width,height);
		this.text = text;
		this.isHovered = false;
		this.isPressed = false;
		this.buttonListener = null;
	}
	
	
	/**
	 * Sets the listener that will run when the button
	 * is clicked
	 * 
	 * @param buttonListener The listener that will run when the button is pressed
	 */
	public void setListener(ButtonListener buttonListener) {
		this.buttonListener = buttonListener;
	}
	
	/**
	 * 
	 * Draws the button when the button is 
	 * assigned to a panel or frame
	 * 
	 */
	@Override
	protected void draw() {
		if(p != null) {
			p.pushStyle();
			p.noStroke();
			p.textAlign(PApplet.CENTER,PApplet.CENTER);
			p.textSize(12);
			if(this.isPressed) {
				p.fill(122, 138, 153);
				p.rect(x,y,width,height);
				p.fill(181, 206, 228);
				p.rect(x+2,y+2,width-4,height-4);
				p.fill(Color.BLACK.getRGB());
				p.text(text, x, y,width,height);
			}else {
				if(this.isHovered) {
					this.p.fill(122, 138, 153);
					this.p.rect(x, y, width, height);
					setGradient(x+2,y+2,width-5,height-5,new Color(255,255,255),new Color(190, 211, 231));
					this.p.fill(Color.BLACK.getRGB());
					this.p.text(text, x, y,width,height);
				}else {
					this.p.fill(122, 138, 153);
					this.p.rect(x, y, width, height);
					setGradient(x+1,y+1,width-3,height-3,new Color(255,255,255),new Color(190, 211, 231));
					this.p.fill(Color.BLACK.getRGB());
					this.p.text(text, x, y,width,height);
				}
			}
			p.popStyle();
		}
	}
	
	/**
	 * Gets called when the user moves the mouse
	 */
	public void mouseMoved() {
		if(detectCollision(this.p.mouseX,this.p.mouseY)) {
			this.isHovered = true;
		}else {
			this.isHovered = false;
		}
	}
	
	/**
	 * Gets called when the user releases the mouse 1 button
	 */
	public void mouseReleased() {
		this.isPressed = false;
	}
	
	/**
	 * Gets called when the user presses down the mouse 1 button
	 */
	public void mousePressed() {
		if(detectCollision(this.p.mouseX,this.p.mouseY)) {
			this.isPressed = true;
			click();
		}
	}
	
	/**
	 * 
	 * Gets whether the x and y positions collide
	 * with the button
	 * 
	 * @param x The x value of the point being checked against the button
	 * @param y The y value of the point being checked against the button
	 * @return Whether the x y point collides with the button
	 */
	public boolean detectCollision(int x, int y) {
		if(this.x <= x && this.y <= y && this.x + width >= x && this.y + height >= y) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * Runs when the button is clicked
	 * 
	 */
	public void click() {
		if(this.buttonListener != null) {
			this.buttonListener.onClicked();
		}
	}
	
	/**
	 * Sets the hover state
	 * 
	 * @param hover whether the user is hovering or not
	 * 
	 */
	public void hover(boolean hover) {
		this.isHovered = hover;
	}
	
	/**
	 * 
	 * Returns the text displayed on the button
	 * 
	 * @return the text on the button
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * 
	 * Sets the gradient of the button
	 * Button colors and pattern are currently 
	 * static
	 * 
	 * @param x The x position of the button
	 * @param y The y position of the button
	 * @param w The width of the button
	 * @param h The height of the button
	 * @param c1 The lower/upper color of the button
	 * @param c2 The middle color of the button
	 */
	protected void setGradient(int x, int y, float w, float h, Color c1, Color c2) {
		p.pushStyle();
		p.noFill();
	    for (int i = y; i <= y+h/4; i++) {
	    	float inter = PApplet.map(i, y, (y+h/4), 1, 0);
		    p.stroke(p.lerpColor(p.color(c1.getRGB()), p.color(c2.getRGB()), inter));
		    p.line(x, i, x+w, i);
	    }
	    for (int i = (int) (y+h/4)+1; i <= y+h; i++) {
	    	float inter = PApplet.map(i, y+h/4, y+h, 0, 1);
		    p.stroke(p.lerpColor(p.color(c1.getRGB()), p.color(c2.getRGB()), inter));
		    p.line(x, i, x+w, i);
	    }
	    p.popStyle();
	}
	
	
	
	public interface ButtonListener{
		/**
		 * Method to run when the button is clicked
		 */
		public void onClicked();
	}
}
