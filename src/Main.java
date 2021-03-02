import java.awt.Dimension;

import javax.swing.JFrame;

import com.zabzabdoda.pgl.component.Button;
import com.zabzabdoda.pgl.component.Button.ButtonListener;
import com.zabzabdoda.pgl.component.Frame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Main extends PApplet{
	
	private Button button;
	private Frame frame;
	
	public Main() {
		frame = new Frame(100,100,400,400,this);
		button = new Button(10, 10, 100, 50, "Button",this);
		button.setListener(new ButtonListener() {
			@Override
			public void onClicked() {
				System.out.println("Button: " + button.getX()+ ", " + button.getY());
				System.out.println("Frame: " + frame.getX()+ ", " + frame.getY());
			}
		});
		frame.add(button);
	}
	
	public void draw() {
		background(200);
		frame.draw();
	}
	
	@Override
	public void mouseMoved() {
		button.mouseMoved();
	}
	
	@Override
	public void mousePressed() {
		button.mousePressed();
	}
	
	@Override
	public void mouseReleased() {
		button.mouseReleased();
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Main gui = new Main();
		PApplet.runSketch(new String[] { "" }, gui);
		PSurfaceAWT surf = (PSurfaceAWT) gui.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame) canvas.getFrame();
		window.setSize(720, 480);
		window.setTitle("Menu");
		window.setMinimumSize(new Dimension(100, 100));
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		window.setResizable(true);
		//window.setExtendedState(window.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		window.setVisible(true);
	}
	
	
}
