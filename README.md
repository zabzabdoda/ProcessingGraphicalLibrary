# ProcessingGraphicalLibrary

## Description
This project serves to create an easier GUI for developers making a Java program using the [Processing](https://processing.org/) library. 
Specifically this library adds GUI components such as Buttons, Frames, panels, Radio Buttons, and more to come. I originally started this
project to create a clear easy to use library so I could focus on making other elements of my programs instead of coding a Button class
for the hundredth time.

## Installation
```xml
<dependency>
  <groupId>com.zabzabdoda.pgl</groupId>
  <artifactId>ProcessingGraphicalLibrary</artifactId>
  <version>1.0</version>
</dependency>
<dependency>
  <groupId>org.processing</groupId>
  <artifactId>core</artifactId>
  <version>3.3.6</version>
 </dependency>	
 </dependencies>
```
## Usage

### Frame
A frame is the main window of this library
example:
```java
Frame frame = new Frame("Main Window", 600, 600, JFrame.DISPOSE_ON_CLOSE);
Label label = new Label("Label!!!",0,0,200,50);
frame.add(label);
frame.startDraw(true);
```
when using a frame make sure to add all of your components to that frame similar to how swing graphics work.
After adding all of your components call the ```startDraw()``` method to display the screen.


## License
Licensed under the [MIT License](LICENSE)
