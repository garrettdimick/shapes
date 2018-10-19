import javax.swing.*;
import java.awt.*;

class DrawingCanvas extends JPanel {

    Point p1 = new Point(100, 100);
    Point p2 = new Point(500, 100);
    Point p3 = new Point(500, 400);
    Point p4 = new Point(100, 400);
    Rectangle r = new Rectangle(p1, p2, p3, p4);

    Point p11 = new Point(200, 200);
    Point p21 = new Point(600, 200);
    Point p31 = new Point(600, 500);
    Point p41 = new Point(200, 500);
    Rectangle r1 = new Rectangle(p11, p21, p31, p41);

    Circle c = new Circle(p1, 20);
    Circle c1 = new Circle(p21, 100);

    Point p5 = new Point(500, 275);
    Point p6 = new Point(300, 550);
    Point p7 = new Point(700, 550);
    Triangle t = new Triangle(p5, p6, p7);

    Circle c4 = new Circle(p6, 80);
    Circle c5 = new Circle(p5, 80);
    Circle c6 = new Circle(p7, 80);

    CompositeShape bigBoy = new CompositeShape();
    CompositeShape hugeOne = new CompositeShape();
    public DrawingCanvas() throws ShapeException {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }

    public Dimension getPreferredSize() {
        return new Dimension(900,900);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.setColor(Color.BLUE);
//        r.renderShape(g);
//        g.setColor(Color.LIGHT_GRAY);
//        c.renderShape(g);
        g.setColor(Color.MAGENTA);
        bigBoy.add(r1);
        bigBoy.add(c1);
//        g.drawString(c1.toString(), 50, 50);

        hugeOne.add(bigBoy);
        hugeOne.add(c4);
//        hugeOne.add(c5);
//        hugeOne.add(t);
//        hugeOne.add(c6);
//        bigBoy.renderShape(g);
        hugeOne.renderShape(g);
//        g.drawString(bigBoy.toString(), 50, 100);
    }
}