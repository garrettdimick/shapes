import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ShapeDemo{
    public static void main(String[] args) throws ShapeException {
        JFrame display = new JFrame("SHAPES!");
        display.setSize(1000, 1000);
        display.setLocation(100, 100);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.add(new DrawingCanvas());
        display.pack();
        display.setVisible(true);
    }
}


