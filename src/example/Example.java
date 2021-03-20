package example;

import javax.swing.JFrame;

import com.zabzabdoda.pgl.component.Button;
import com.zabzabdoda.pgl.component.Button.ButtonListener;

import processing.core.PApplet;

import com.zabzabdoda.pgl.component.Frame;
import com.zabzabdoda.pgl.component.Label;
import com.zabzabdoda.pgl.component.Panel;
import com.zabzabdoda.pgl.component.RadioButton;
import com.zabzabdoda.pgl.component.RadioController;

/*
 * Example program that demonstrates
 * how to use different components together
 *
 */
public class Example {
	
	public static void main(String[] args) {
		// Creates a new processing window 
		Frame frame = new Frame("Main Window", 600, 600, JFrame.DISPOSE_ON_CLOSE);
		// Creates a new panel
		Panel pan = new Panel(100,100,400,250);
		// Creates a new label
		Label l2 = new Label("Favorite Movie:",0,0,pan.getWidth(),50);
		// Sets the alignment to be the center of the label box
		l2.setAlignment(PApplet.CENTER, PApplet.CENTER);
		// Sets the text size to 20 points
		l2.setTextSize(20);
		// Creates a new label 
		Label submitLabel = new Label("",180,50,pan.getWidth()/2,50);
		// Changes the alignment of the text in the label to be the center of the label box
		submitLabel.setAlignment(PApplet.CENTER, PApplet.CENTER);
		// Creates 4 new Radio Buttons stacked on top of each other
		RadioButton rb1 = new RadioButton("Star Wars", 10, 50, 100, 25);
		RadioButton rb2 = new RadioButton("Batman", 10, 100, 100, 25);
		RadioButton rb3 = new RadioButton("Star Trek", 10, 150, 100, 25);
		RadioButton rb4 = new RadioButton("Avengers", 10, 200, 100, 25);
		// Makes a new Controller for the radio buttons 
		RadioController rc = new RadioController();
		// Creates a new submit button 
		Button b1 = new Button(230,180,100,50,"Submit");
		// Adds a button listener to listen when the button is clicked
		b1.setListener(new ButtonListener() {
			@Override
			public void onClicked() {
				// Changes the label
				submitLabel.setText(rc.getSelected().getText()+ " is a good choice :)");
			}
		});
		// Adds all the radio buttons, button and labels to the panel
		pan.add(rb1);
		pan.add(rb2);
		pan.add(rb3);
		pan.add(rb4);
		pan.add(b1);
		pan.add(l2);
		pan.add(submitLabel);
		// Adds the radio buttons to the controller
		rc.add(rb1);
		rc.add(rb2);
		rc.add(rb3);
		rc.add(rb4);
		// sets the default radio option
		rc.setDefault(rb1);
		// adds the radio controller to the panel
		pan.add(rc);
		// adds the panel to the main frame
		frame.add(pan);
		// starts drawing AFTER everything is assigned
		frame.startDraw(true);
	}
}
