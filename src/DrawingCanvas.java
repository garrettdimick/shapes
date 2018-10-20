import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


class DrawingCanvas extends JPanel {
    private static final String INPUT_FILE_4 = "/Users/garrettdimick/tmp/listofshapes.txt";

    Shape newShape = new CompositeShape();
    public DrawingCanvas() throws ShapeException {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public Dimension getPreferredSize() {
        return new Dimension(900,900);
    }

    public void paintComponent(Graphics g) {

        // RENDER A SHAPE TO AN IMAGE
        g.setColor(Color.MAGENTA);
        try {
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
            hugeOne.renderShape(g);
        } catch (ShapeException e) {
            e.printStackTrace();
        }

        // Demos loading an embedded picture from a file and rendering it to the screen
        File input = new File("/Users/garrettdimick/tmp/cool.png");
        InputStream is = null;
        try {
            is = new FileInputStream(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        EmbeddedPicture ep = null;
        try {
            ep = new EmbeddedPicture(is);
        } catch (ShapeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ep.renderShape(g);
        ep.toString();


        //REMOVE A SHAPE FROM A COMPOSITE SHAPE


//        g.setColor(Color.CYAN);
//        try{
//            ShapeFactory sf = new ShapeFactory();
//            ArrayList<Shape> shapes = new ArrayList<Shape>();
//            File file = new File(INPUT_FILE_4);
//            Scanner sc = new Scanner(file);
//            while(sc.hasNextLine()){
//                Shape ns = sf.generateShape(sc.nextLine());
//                shapes.add(ns);
//            }
//            sc.close();
//            for(Shape s : shapes){
//                g.drawString(s.toString(), (int)s.getCenter().getX(), (int)s.getCenter().getY());
//                s.renderShape(g);
//            }
//            System.out.println("The created shapes are: ");
//            System.out.println(shapes);
//        }catch(ShapeException | FileNotFoundException e){
//            e.printStackTrace();
//        }
    }
}