package com.zabzabdoda.pgl.component;

import java.awt.Color;

import processing.core.PApplet;

public class Label extends Component {

	private String text;
	private int textSize,alignment,alignment2;
	private Color color;
	
	public Label(String text, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.text = text;
		textSize = 12;
		color = Color.BLACK;
		alignment = PApplet.LEFT;
		alignment2 = PApplet.CENTER;
	}

	@Override
	public void draw() {
		p.pushStyle();
		p.textSize(textSize);
		p.textAlign(alignment,alignment2);
		p.fill(color.getRGB());
		p.text(text, x, y,width,height);
		p.popStyle();
	}
	
	public void setAlignment(int alignment,int alignment2) {
		this.alignment = alignment;
		this.alignment2 = alignment2;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setTextSize(int size) {
		textSize = size;
	}

	@Override
	public void mouseMoved() {
		
	}

	@Override
	public void mousePressed() {
		
	}

	@Override
	public void mouseReleased() {
		
	}
	
}
