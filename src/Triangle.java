import java.awt.*;

public class Triangle extends Shape{

    private Point vertex1;
    private Point vertex2;
    private Point vertex3;

    /**
     * Constructor to create a triangle from points, uses the validator to check for valid points
     * @param v1
     * @param v2
     * @param v3
     * @throws ShapeException
     */
    public Triangle(Point v1, Point v2, Point v3) throws ShapeException{
        super();
        Validator.validatePoint(v1, "Invalid Point");
        Validator.validatePoint(v2, "Invalid Point");
        Validator.validatePoint(v3, "Invalid Point");
        Point c = triangleCalcCenter(v1, v2, v3);
        this.setCenter(c);
        this.vertex1 = v1;
        this.vertex2 = v2;
        this.vertex3 = v3;

        Validator.validateTriangle(this, "Invalid Triangle Construction");
    }

    public Point triangleCalcCenter(Point p1, Point p2, Point p3) throws ShapeException {
        Validator.validatePoint(p1, "Invalid Point");
        Validator.validatePoint(p2, "Invalid Point");
        Validator.validatePoint(p3, "Invalid Point");
        Point midP = new Point((p1.getX() + p2.getX() + p3.getX()) / 3,
                (p1.getY() + p2.getY() + p3.getY()) / 3);
        return midP;
    }

    /**
     * Getters and setters for each of the data members
     */
    public double computeArea(){
        double p = ((lineLength(vertex1, vertex2) + lineLength(vertex2,  vertex3) + lineLength(vertex3, vertex1)) / 2);
        double a = Math.sqrt(p*(p-lineLength(vertex1, vertex2))*(lineLength(vertex2,  vertex3))*
                (p-lineLength(vertex3, vertex1)));
        return a;
    }

    @Override
    public void renderShape(Graphics g) {
        int x[]={(int)vertex1.getX(), (int)vertex2.getX(), (int)vertex3.getX()};
        int y[] = {(int)vertex1.getY(), (int)vertex2.getY(), (int)vertex3.getY()};
        g.drawPolygon(x, y, 3);
    }

    public Point getVertex1() {
        return vertex1;
    }

    public Point getVertex2() {
        return vertex2;
    }

    public Point getVertex3() {
        return vertex3;
    }

}