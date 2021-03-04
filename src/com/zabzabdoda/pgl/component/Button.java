package com.zabzabdoda.pgl.component;

import java.awt.Color;

import processing.core.PApplet;

public class Button extends Component implements ButtonListener{
	
	protected String text;
	protected boolean isHovered;
	private boolean isPressed;
	private ButtonListener buttonListener;

	public Button(int x, int y, int width, int height, String text) {
		super(x,y,width,height);
		this.text = text;
		this.isHovered = false;
		this.isPressed = false;
		this.buttonListener = null;
	}
	
	
	
	public void setListener(ButtonListener buttonListener) {
		this.buttonListener = buttonListener;
	}
	
	@Override
	public void draw() {
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
	
	public void mouseMoved() {
		if(detectCollision(this.p.mouseX,this.p.mouseY)) {
			this.isHovered = true;
		}else {
			this.isHovered = false;
		}
	}
	
	public void mouseReleased() {
		this.isPressed = false;
	}
	
	public void mousePressed() {
		if(detectCollision(this.p.mouseX,this.p.mouseY)) {
			this.isPressed = true;
			click();
		}
	}
	
	public boolean detectCollision(int x, int y) {
		if(this.x <= x && this.y <= y && this.x + width >= x && this.y + height >= y) {
			return true;
		}
		return false;
	}
	
	public void click() {
		if(this.buttonListener != null) {
			this.buttonListener.onClicked();
		}
	}
	
	public void hover(boolean hover) {
		this.isHovered = hover;
	}
	
	public String getText() {
		return this.text;
	}
	
	void setGradient(int x, int y, float w, float h, Color c1, Color c2) {
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



	@Override
	public void onClicked() {
		// TODO Auto-generated method stub
		
	}
}
