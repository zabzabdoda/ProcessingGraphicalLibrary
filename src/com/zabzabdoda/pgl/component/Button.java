package com.zabzabdoda.pgl.component;

import java.awt.Color;

import processing.core.PApplet;

public class Button extends Component{
	
	private String text;
	private boolean isHovered,isPressed;
	private ButtonListener buttonListener;
	private PApplet papplet;
	
	public Button(int x, int y, int width, int height, String text, PApplet p) {
		super(x,y,width,height);
		this.text = text;
		this.isHovered = false;
		this.isPressed = false;
		buttonListener = null;
		this.papplet = p;
		
	}
	
	public void setListener(ButtonListener buttonListener) {
		this.buttonListener = buttonListener;
	}
	
	@Override
	public void draw() {
		papplet.pushStyle();
		papplet.noStroke();
		papplet.textAlign(PApplet.CENTER,PApplet.CENTER);
		if(isPressed) {
			papplet.fill(122, 138, 153);
			papplet.rect(x,y,width,height);
			papplet.fill(181, 206, 228);
			papplet.rect(x+2,y+2,width-4,height-4);
			papplet.fill(Color.BLACK.getRGB());
			papplet.text(text, x, y,width,height);
		}else {
			if(isHovered) {
				papplet.fill(122, 138, 153);
				papplet.rect(x, y, width, height);
				setGradient(x+2,y+2,width-5,height-5,new Color(255,255,255),new Color(190, 211, 231));
				papplet.fill(Color.BLACK.getRGB());
				papplet.text(text, x, y,width,height);
			}else {
				papplet.fill(122, 138, 153);
				papplet.rect(x, y, width, height);
				setGradient(x+1,y+1,width-3,height-3,new Color(255,255,255),new Color(190, 211, 231));
				papplet.fill(Color.BLACK.getRGB());
				papplet.text(text, x, y,width,height);
			}
		}
		papplet.popStyle();
	}
	
	public void mouseMoved() {
		if(detectCollision(papplet.mouseX,papplet.mouseY)) {
			isHovered = true;
		}else {
			isHovered = false;
		}
	}
	
	public void mouseReleased() {
		isPressed = false;
	}
	
	public void mousePressed() {
		if(detectCollision(papplet.mouseX,papplet.mouseY)) {
			isPressed = true;
			click();
		}
	}
	
	public boolean detectCollision(int x, int y) {
		System.out.println(x+", "+y);
		System.out.println(this.x+", "+this.y);
		if(this.x <= x && this.y <= y && this.x + width >= x && this.y + height >= y) {
			return true;
		}
		return false;
	}
	
	public void click() {
		if(buttonListener != null) {
			buttonListener.onClicked();
		}
	}
	
	public void hover(boolean hover) {
		isHovered = hover;
	}
	
	public String getText() {
		return text;
	}

	public interface ButtonListener {
		
		public void onClicked();
		
	}
	
	void setGradient(int x, int y, float w, float h, Color c1, Color c2) {
		papplet.pushStyle();
		papplet.noFill();
	    for (int i = y; i <= y+h/4; i++) {
	    	float inter = PApplet.map(i, y, (y+h/4), 1, 0);
		    papplet.stroke(papplet.lerpColor(papplet.color(c1.getRGB()), papplet.color(c2.getRGB()), inter));
		    papplet.line(x, i, x+w, i);
	    }
	    for (int i = (int) (y+h/4)+1; i <= y+h; i++) {
	    	float inter = PApplet.map(i, y+h/4, y+h, 0, 1);
		    papplet.stroke(papplet.lerpColor(papplet.color(c1.getRGB()), papplet.color(c2.getRGB()), inter));
		    papplet.line(x, i, x+w, i);
	    }
	    papplet.popStyle();
	}
}
