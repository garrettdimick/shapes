import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;


public class ShapeDemo{
    private static final String OUTPUT_FILE_2 = "/Users/garrettdimick/tmp/composite.txt";
    private static final String INPUT_FILE_4 = "/Users/garrettdimick/tmp/listofshapes.txt";
    public static void main(String[] args) throws ShapeException, IOException {
        JFrame display = new JFrame("SHAPES!");
        display.setSize(1000, 1000);
        display.setLocation(100, 100);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.add(new DrawingCanvas());
        display.pack();
        display.setVisible(true);

        //Uncomment the following block of code to demo that a composite shape can be created from several shapes, including another
        // composite shape and that that shape can be saved to a file and rendered as a Graphics object (the code
        // for that is in the DrawingCanvas class
        // SAVE A SHAPE TO A SCRIPT
        // ADD A SHAPE TO A COMPOSITE SHAPE
        Point p6 = new Point(300, 550);
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
        try (OutputStream out = new FileOutputStream(OUTPUT_FILE_2)){
            out.write(hugeOne.saveToOutputStream());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // REMOVE A SHAPE FROM A COMPOSITE SHAPE
        CompositeShape theBigOne = hugeOne;
        theBigOne.remove(r1);
        System.out.println("Removed: " + r1.toString());
        theBigOne.toString();
        //REMOVE ALL SHAPES FROM COMPOSITE SHAPE
        theBigOne.removeAll();
        System.out.println("Removed the rest of the shapes.");
        if(theBigOne.shapeList.isEmpty()){
            System.out.println("Truth.");
        }


        // Uncomment the following block of code to demo that the ShapeFactory will create a simple shape from
        // a script which contains a single shape
//        InputStream in = new FileInputStream(INPUT_FILE_1);
//        byte[] bytes = ShapeFactory.loadInputStream(in);
//        String inputString = new String(bytes);
//        Shape newShape = ShapeFactory.generateShape(inputString);
//        Shape newShape = ShapeFactory.loadShapeFromFile(INPUT_FILE_1);
//        System.out.println("THE NEW SHAPE IS: ");
//        System.out.println(newShape.toString());

        // Uncomment the following block of code to demo that the ShapeFactory class is working
        // INPUT_FILE_4 is a file that has several shapes in it as a script, two of which are identical
        // Also demos the use of the flyweight pattern
        // LOAD A SHAPE FROM A SCRIPT
        ShapeFactory sf = new ShapeFactory();
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        File file = new File(INPUT_FILE_4);
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            Shape ns = sf.generateShape(sc.nextLine());
            shapes.add(ns);
        }
        sc.close();
        System.out.println("The created shapes are: ");
        System.out.println(shapes);


    }
}


