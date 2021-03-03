package tester;

import java.awt.Color;

import javax.swing.JFrame;

import com.zabzabdoda.pgl.component.Button;
import com.zabzabdoda.pgl.component.Button.ButtonListener;

import processing.core.PApplet;

import com.zabzabdoda.pgl.component.Frame;
import com.zabzabdoda.pgl.component.Label;
import com.zabzabdoda.pgl.component.Panel;
import com.zabzabdoda.pgl.component.RadioButton;
import com.zabzabdoda.pgl.component.RadioController;
import com.zabzabdoda.pgl.component.ToggleButton;

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
public class Main {
	
	public static void main(String[] args) {
		Frame frame = new Frame("Main Window", 600, 600, JFrame.EXIT_ON_CLOSE);
		Button b1 = new Button(10,30,100,50,"Button 1");
		frame.add(b1);
		b1.setListener(new ButtonListener() {
			@Override
			public void onClicked() {
				System.out.println("Button 1");
			}
		});
		Label l1 = new Label("Label!!!",100,20,200,60);
		l1.setColor(Color.RED);
		l1.setTextSize(30);
		l1.setAlignment(PApplet.CENTER, PApplet.CENTER);
		frame.add(l1);
		ToggleButton tb1 = new ToggleButton(400,30,100,50,"Toggle Button");
		tb1.setListener(new ButtonListener() {
			@Override
			public void onClicked() {
				System.out.println("Toggle Button is "+tb1.getState());
			}
		});
		frame.add(tb1);
		
		Panel pan = new Panel(100,100,200,250);
		Label l2 = new Label("Favorite Movie:",0,0,pan.getWidth(),50);
		l2.setAlignment(PApplet.CENTER, PApplet.CENTER);
		l2.setTextSize(20);
		RadioButton rb1 = new RadioButton("Star Wars", 10, 50, 100, 25);
		RadioButton rb2 = new RadioButton("Lord Of The Rings", 10, 100, 100, 25);
		RadioButton rb3 = new RadioButton("Star Trek", 10, 150, 100, 25);
		RadioButton rb4 = new RadioButton("Marvel", 10, 200, 100, 25);
		RadioController rc = new RadioController();
		pan.add(rb1);
		pan.add(rb2);
		pan.add(rb3);
		pan.add(rb4);
		pan.add(l2);
		rc.add(rb1);
		rc.add(rb2);
		rc.add(rb3);
		rc.add(rb4);
		rc.setDefault(rb1);
		pan.add(rc);
		frame.add(pan);
		frame.startDraw(true);
	}
	
}
