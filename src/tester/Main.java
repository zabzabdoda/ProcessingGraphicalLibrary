package tester;

import javax.swing.JFrame;

import com.zabzabdoda.pgl.component.Button;
import com.zabzabdoda.pgl.component.ButtonListener;

import processing.core.PApplet;

import com.zabzabdoda.pgl.component.Frame;
import com.zabzabdoda.pgl.component.Label;
import com.zabzabdoda.pgl.component.Panel;
import com.zabzabdoda.pgl.component.RadioButton;
import com.zabzabdoda.pgl.component.RadioController;

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
		Frame frame = new Frame("Main Window", 600, 600, JFrame.DISPOSE_ON_CLOSE);
		Panel pan = new Panel(100,100,400,250);
		Label l2 = new Label("Favorite Movie:",0,0,pan.getWidth(),50);
		l2.setAlignment(PApplet.CENTER, PApplet.CENTER);
		l2.setTextSize(20);
		Label submitLabel = new Label("Favorite Movie:",180,50,pan.getWidth()/2,50);
		submitLabel.setAlignment(PApplet.CENTER, PApplet.CENTER);
		RadioButton rb1 = new RadioButton("Star Wars", 10, 50, 100, 25);
		RadioButton rb2 = new RadioButton("Batman", 10, 100, 100, 25);
		RadioButton rb3 = new RadioButton("Star Trek", 10, 150, 100, 25);
		RadioButton rb4 = new RadioButton("Avengers", 10, 200, 100, 25);
		RadioController rc = new RadioController();
		Button b1 = new Button(230,180,100,50,"Submit");
		b1.setListener(new ButtonListener() {
			@Override
			public void onClicked() {
				submitLabel.setText(rc.getSelected().getText()+ " is a good choice :)");
			}
		});
		pan.add(rb1);
		pan.add(rb2);
		pan.add(rb3);
		pan.add(rb4);
		pan.add(l2);
		pan.add(b1);
		pan.add(submitLabel);
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
