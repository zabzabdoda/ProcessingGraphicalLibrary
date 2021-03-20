package com.zabzabdoda.pgl.component;

import java.awt.Color;

import processing.core.PApplet;

/**
 * Represents a text string that can
 * be drawn to the main window
 * 
 * @author zabzabdoda
 *
 */
public class Label extends Component{

	private String text;
	private int textSize,alignment,alignment2;
	private Color color;
	
	/**
	 * Creates a new label at the specified location
	 * and text
	 * 
	 * @param text The text to display on the label
	 * @param x The x position of the label
	 * @param y The y position of the label
	 * @param width The width of the label
	 * @param height The height of the label
	 */
	public Label(String text, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.text = text;
		textSize = 12;
		color = Color.BLACK;
		alignment = PApplet.LEFT;
		alignment2 = PApplet.CENTER;
	}

	/**
	 * Draws the label to the main window
	 */
	@Override
	public void draw() {
		p.pushStyle();
		p.textSize(textSize);
		p.textAlign(alignment,alignment2);
		p.fill(color.getRGB());
		p.text(text, x, y,width,height);
		p.popStyle();
	}
	
	/**
	 * Changes the label text
	 * @param text The new text to set the label to
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * The Text Alignment, Use PApplet
	 * constants such as LEFT, RIGHT, CENTER
	 * 
	 * @param alignment The horizontal alignment
	 * @param alignment2 The vertical alignment
	 */
	public void setAlignment(int alignment,int alignment2) {
		this.alignment = alignment;
		this.alignment2 = alignment2;
	}
	
	/**
	 * The color to make the text
	 * @param color The Color the text will be
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * The font size of the label text
	 * 
	 * @param size The font point size of the text
	 */
	public void setTextSize(int size) {
		textSize = size;
	}
	
}
