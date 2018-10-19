import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;


public class ShapeDemo{
    private static final String OUTPUT_FILE_1 = "/Users/garrettdimick/tmp/triangle.txt";
    private static final String OUTPUT_FILE_2 = "/Users/garrettdimick/tmp/composite.txt";
    public static void main(String[] args) throws ShapeException, IOException {
        JFrame display = new JFrame("SHAPES!");
        display.setSize(1000, 1000);
        display.setLocation(100, 100);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.add(new DrawingCanvas());
        display.pack();
        display.setVisible(true);

        Point p5 = new Point(500, 275);
        Point p6 = new Point(300, 550);
        Point p7 = new Point(700, 550);
        Triangle t = new Triangle(p5, p6, p7);

        try (OutputStream out = new FileOutputStream(OUTPUT_FILE_1)){
            out.write(t.saveToOutputStream());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        Point p11 = new Point(200, 200);
        Point p21 = new Point(600, 200);
        Point p31 = new Point(600, 500);
        Point p41 = new Point(200, 500);
        Rectangle r1 = new Rectangle(p11, p21, p31, p41);

        Circle c1 = new Circle(p21, 100);

        Circle c4 = new Circle(p6, 80);

        CompositeShape bigBoy = new CompositeShape();
        CompositeShape hugeOne = new CompositeShape();
        bigBoy.add(r1);
        bigBoy.add(c1);
        hugeOne.add(bigBoy);
        hugeOne.add(c4);
        hugeOne.add(c1);

        hugeOne.saveToScriptFile(OUTPUT_FILE_2);
//        try (OutputStream out = new FileOutputStream(OUTPUT_FILE_2)){
//            out.write(hugeOne.saveToOutputStream());
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
    }
}


